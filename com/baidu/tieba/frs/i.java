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
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.adp.framework.message.Message;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.d.a.a;
import com.baidu.tbadk.KuangFloatingViewController;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.atomData.MangaBrowserActivityConfig;
import com.baidu.tbadk.core.atomData.MessageCenterActivityConfig;
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
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.ay;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.core.view.NoPressedRelativeLayout;
import com.baidu.tbadk.core.view.UserIconBox;
import com.baidu.tbadk.core.voice.VoiceManager;
import com.baidu.tbadk.coreExtra.message.UpdateAttentionMessage;
import com.baidu.tbadk.coreExtra.messageCenter.NewsRemindMessage;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.c.a;
import com.baidu.tieba.d;
import com.baidu.tieba.frs.g.i;
import com.baidu.tieba.frs.mc.FrsModelController;
import com.baidu.tieba.frs.view.FrsHeaderViewContainer;
import com.baidu.tieba.pb.data.ContriInfo;
import com.baidu.tieba.pb.data.PbFloorAgreeResponseMessage;
import com.baidu.tieba.share.AddExperiencedModel;
import com.baidu.tieba.tbadkCore.d;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
import java.util.ArrayList;
import java.util.List;
import tbclient.FrsPage.RecmForumInfo;
/* loaded from: classes2.dex */
public class i extends BaseFragment implements BdListView.e, a.InterfaceC0056a, UserIconBox.b<com.baidu.adp.widget.ListView.h>, VoiceManager.c, com.baidu.tieba.InjectPlugin.a.b, aj, am, ao, com.baidu.tieba.frs.loadmore.a, com.baidu.tieba.frs.mc.j, com.baidu.tieba.recapp.n {
    public static boolean dEf = false;
    public static volatile long dEp = 0;
    public static volatile long dEq = 0;
    public static volatile int dEr = 0;
    private com.baidu.tbadk.util.r bDm;
    private com.baidu.adp.lib.e.b<TbImageView> beQ;
    private com.baidu.tieba.frs.gametab.b cjX;
    private com.baidu.tieba.frs.smartsort.b dEA;
    private com.baidu.tieba.frs.mc.b dEB;
    private ap dEC;
    private com.baidu.tieba.frs.entelechy.b.b dEE;
    private com.baidu.tbadk.h.a dEF;
    private com.baidu.tieba.frs.g.a dEG;
    private com.baidu.tieba.frs.mc.d dEH;
    private com.baidu.tieba.frs.mc.c dEI;
    private com.baidu.tieba.frs.g.h dEJ;
    private com.baidu.tieba.frs.mc.a dEK;
    private com.baidu.tieba.frs.live.a dEL;
    private j dEM;
    public com.baidu.tieba.frs.g.c dEN;
    private com.baidu.tieba.frs.mc.e dEO;
    private int dEP;
    private View.OnTouchListener dEQ;
    private com.baidu.tieba.frs.view.b dER;
    private com.baidu.tieba.frs.g.e dES;
    private boolean dET;
    private com.baidu.tieba.NEGFeedBack.a dEV;
    private com.baidu.tieba.ala.a dEW;
    private com.baidu.tbadk.core.dialog.i dEX;
    private AddExperiencedModel dEY;
    private com.baidu.tieba.frs.entelechy.b dEb;
    public bd dEg;
    private com.baidu.tieba.tbadkCore.data.e dEk;
    private VoiceManager dEn;
    private FrsModelController dEw;
    private com.baidu.tieba.frs.g.f dEx;
    private com.baidu.tieba.frs.g.i dEy;
    private com.baidu.tieba.frs.mc.f dEz;
    public View mRootView;
    public boolean dEc = false;
    private boolean dEd = false;
    private boolean dEe = false;
    public String dEh = null;
    public String mFrom = null;
    public int mFlag = 0;
    private boolean dEi = false;
    private String mThreadId = null;
    public String forumId = null;
    private int dDV = 0;
    private boolean dEj = false;
    private boolean dEl = false;
    private boolean dEm = false;
    private k dEo = null;
    public final bd bZU = null;
    private com.baidu.tieba.tbadkCore.m dDS = new com.baidu.tieba.tbadkCore.m();
    public long dpA = -1;
    public long bAz = 0;
    public long bAr = 0;
    public long createTime = 0;
    public long beginTime = -1;
    private boolean dEs = false;
    private boolean dEt = false;
    public com.baidu.tbadk.k.d dEu = null;
    private boolean dEv = true;
    private SparseArray<com.baidu.tieba.InjectPlugin.a.a> dED = new SparseArray<>();
    private boolean clg = true;
    private boolean dEU = false;
    private AddExperiencedModel.a dEZ = new AddExperiencedModel.a() { // from class: com.baidu.tieba.frs.i.1
        @Override // com.baidu.tieba.share.AddExperiencedModel.a
        public void b(ContriInfo contriInfo) {
            if (contriInfo != null && contriInfo.isShowToast()) {
                i.this.a(contriInfo);
            }
        }
    };
    private HttpMessageListener dFa = new HttpMessageListener(CmdConfigHttp.CMD_PB_FLOOR_AGREE, true) { // from class: com.baidu.tieba.frs.i.12
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && (httpResponsedMessage instanceof PbFloorAgreeResponseMessage)) {
                PbFloorAgreeResponseMessage pbFloorAgreeResponseMessage = (PbFloorAgreeResponseMessage) httpResponsedMessage;
                if (pbFloorAgreeResponseMessage.getContriInfo() != null && pbFloorAgreeResponseMessage.getContriInfo().isShowToast()) {
                    i.this.a(pbFloorAgreeResponseMessage.getContriInfo());
                }
            }
        }
    };
    private final CustomMessageListener dFb = new CustomMessageListener(2016495) { // from class: com.baidu.tieba.frs.i.23
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getCmd() == 2016495) {
                Object data = customResponsedMessage.getData();
                if (data instanceof bd) {
                    com.baidu.tieba.frs.f.g.a(i.this.dEo, i.this.dDS, i.this.getForumId(), true, (bd) data);
                }
            }
        }
    };
    private CustomMessageListener dFc = new CustomMessageListener(2921005) { // from class: com.baidu.tieba.frs.i.31
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (i.this.dDS != null) {
                i.this.dDS.bwc();
                if (i.this.dEo != null) {
                    i.this.dEo.amD();
                }
            }
        }
    };
    private CustomMessageListener dFd = new CustomMessageListener(2001624) { // from class: com.baidu.tieba.frs.i.32
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                Object data = customResponsedMessage.getData();
                if ((data instanceof Integer) && Integer.parseInt(data.toString()) == 1) {
                    i.this.avd();
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2003020, true));
                }
            }
        }
    };
    private final an dFe = new an() { // from class: com.baidu.tieba.frs.i.33
        @Override // com.baidu.tieba.frs.an
        public void a(int i, int i2, at atVar, ArrayList<com.baidu.adp.widget.ListView.i> arrayList) {
            i.this.auW();
            if (i.this.dEE != null) {
                i.this.dEx.gu(i.this.dEE.nh(i));
            }
            d.a aVar = new d.a();
            if (atVar != null) {
                aVar.isSuccess = atVar.errCode == 0;
                aVar.errorCode = atVar.errCode;
                aVar.errorMsg = atVar.errMsg;
                if (aVar.isSuccess) {
                    if (com.baidu.tbadk.core.util.v.E(arrayList)) {
                        i.this.dEo.XQ();
                    } else if (atVar.hasMore) {
                        if (com.baidu.tbadk.core.util.v.D(i.this.dDS.getThreadList()) > 3) {
                            i.this.dEo.XO();
                        } else {
                            i.this.dEo.awa();
                        }
                    } else if (atVar.dHC) {
                        i.this.dEo.XP();
                    } else {
                        i.this.dEo.XQ();
                    }
                }
            } else {
                atVar = new at();
                atVar.pn = 1;
                atVar.hasMore = false;
                atVar.dHC = false;
            }
            if (i == 1) {
                i.this.dEv = true;
                i.this.dFp.a(i.this.dEw.getType(), false, aVar);
            } else {
                i.this.a(aVar);
                if (i.this.dEw.ayW() != null) {
                    i.this.dDS = i.this.dEw.ayW();
                }
                i.this.avf();
            }
            if (i.this.dFx != null) {
                i.this.dFx.a(i, i2, atVar, arrayList);
            }
        }
    };
    private i.b dFf = new i.b() { // from class: com.baidu.tieba.frs.i.34
        @Override // com.baidu.tieba.frs.g.i.b
        public void hT(int i) {
            if (i != 1) {
                com.baidu.tieba.card.r.alt().eO(false);
            }
            if (!i.this.dEo.avD()) {
                i.this.avi();
            }
            com.baidu.tieba.frs.e.c.dUj.dUa = i;
            com.baidu.tieba.frs.e.c.dUj.dUb = -1;
        }
    };
    private CustomMessageListener dFg = new CustomMessageListener(2001606) { // from class: com.baidu.tieba.frs.i.35
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof Integer)) {
                i.this.dEy.nV(((Integer) customResponsedMessage.getData()).intValue());
            }
        }
    };
    private CustomMessageListener dFh = new CustomMessageListener(2001607) { // from class: com.baidu.tieba.frs.i.36
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getData() != null && ((Integer) customResponsedMessage.getData()).intValue() == 51 && i.this.dDS != null) {
                com.baidu.tieba.frs.f.i.a(i.this.dDS, i.this.getPageContext());
            }
        }
    };
    private final CustomMessageListener dFi = new CustomMessageListener(2003019) { // from class: com.baidu.tieba.frs.i.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                i.this.dEy.nT(49);
            }
        }
    };
    private final CustomMessageListener dFj = new CustomMessageListener(2001222) { // from class: com.baidu.tieba.frs.i.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            int i;
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof SignData) && i.this.dDS != null && i.this.dDS.bas() != null) {
                SignData signData = (SignData) customResponsedMessage.getData();
                int user_level = i.this.dDS.bas().getUser_level();
                if (signData.forumId != null && signData.forumId.equals(i.this.dDS.bas().getId())) {
                    i.this.dDS.d(signData);
                    i.this.dEx.g(i.this.dDS);
                    if (i.this.dEx.aAr()) {
                        i = i.this.dDS.bas().getUser_level();
                        if (user_level >= i) {
                            i++;
                        }
                    } else {
                        i = user_level;
                    }
                    TbadkCoreApplication.getInst().addSignedForum(i.this.dDS.bas().getName(), signData.sign_bonus_point, i);
                }
            }
        }
    };
    private final CustomMessageListener dFk = new CustomMessageListener(2001352) { // from class: com.baidu.tieba.frs.i.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.tbadkCore.s) && i.this.dDS != null) {
                i.this.dDS.c((com.baidu.tieba.tbadkCore.s) customResponsedMessage.getData());
                i.this.dEx.f(i.this.dDS);
                i.this.dEy.a(i.this.dDS, i.this.dEw.azy());
            }
        }
    };
    private final AntiHelper.a dFl = new AntiHelper.a() { // from class: com.baidu.tieba.frs.i.5
        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
        public void onPositiveButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
            TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c12536").s("obj_locate", aq.a.aXA));
        }

        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
        public void onNavigationButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
            TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c12535").s("obj_locate", aq.a.aXA));
        }
    };
    private CustomMessageListener chk = new CustomMessageListener(2001115) { // from class: com.baidu.tieba.frs.i.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Message<?> message;
            if (customResponsedMessage instanceof UpdateAttentionMessage) {
                UpdateAttentionMessage updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage;
                if (updateAttentionMessage.getData() != null && updateAttentionMessage.getData().toUid != null && (message = updateAttentionMessage.getmOrginalMessage()) != null && message.getTag() != null && message.getTag().equals(i.this.getPageContext().getUniqueId())) {
                    if (updateAttentionMessage.getData().biK != null) {
                        if (AntiHelper.a(i.this.getActivity(), updateAttentionMessage.getData().biK, i.this.dFl) != null) {
                            TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c12534").s("obj_locate", aq.a.aXA));
                        }
                    } else if (updateAttentionMessage.getData().apH && updateAttentionMessage.getData().isAttention) {
                        com.baidu.adp.lib.util.l.showToast(i.this.getPageContext().getPageActivity(), d.j.attention_success);
                    }
                }
            }
        }
    };
    private CustomMessageListener dFm = new CustomMessageListener(2001374) { // from class: com.baidu.tieba.frs.i.7
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof PostWriteCallBackData)) {
                i.this.dEo.c((PostWriteCallBackData) customResponsedMessage.getData());
            }
        }
    };
    private CustomMessageListener dFn = new CustomMessageListener(2001626) { // from class: com.baidu.tieba.frs.i.8
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            NewsRemindMessage newsRemindMessage;
            if (customResponsedMessage != null && (customResponsedMessage instanceof NewsRemindMessage) && customResponsedMessage.getCmd() == 2001626 && (newsRemindMessage = (NewsRemindMessage) customResponsedMessage) != null) {
                int notificationCount = newsRemindMessage.getNotificationCount() + newsRemindMessage.getMsgCount() + newsRemindMessage.getChatCount();
                boolean z = newsRemindMessage.hasMsgRemind() || newsRemindMessage.hasChatRemind() || newsRemindMessage.hasNotificationRemind();
                if (i.this.dEo != null) {
                    i.this.dEo.E(notificationCount, z);
                }
            }
        }
    };
    private CustomMessageListener dFo = new CustomMessageListener(2921334) { // from class: com.baidu.tieba.frs.i.9
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            com.baidu.tieba.tbadkCore.e bvI;
            if (i.this.dDS != null && (bvI = i.this.dDS.bvI()) != null && bvI.buJ() != 0) {
                String str = "frs_activity_switch_" + bvI.buJ();
                boolean z = com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean(str, false);
                TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c13038").ab("obj_type", z ? "2" : "1"));
                com.baidu.tbadk.core.sharedPref.b.getInstance().remove(str);
                com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("frs_activity_switch_" + bvI.buJ(), !z);
                i.this.getActivity().finish();
                MessageManager.getInstance().sendMessage(new CustomMessage(2003000, new FrsActivityConfig(i.this.getContext()).createNormalCfg(i.this.getForumName(), "")));
            }
        }
    };
    public final com.baidu.tieba.tbadkCore.o dFp = new com.baidu.tieba.tbadkCore.o() { // from class: com.baidu.tieba.frs.i.10
        private long startTime = 0;

        @Override // com.baidu.tieba.tbadkCore.o
        public void mQ(int i) {
            this.startTime = System.nanoTime();
            if (i.this.dEo != null) {
                switch (i) {
                    case 1:
                    case 2:
                        i.this.dEo.avO();
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

        @Override // com.baidu.tieba.tbadkCore.o
        public void a(int i, boolean z, d.a aVar) {
            if (i.this.clg) {
                i.this.clg = false;
                com.baidu.tieba.frs.f.g.a(i.this.dEo, i.this.dDS, i.this.getForumId(), false, null);
            }
            i.this.auW();
            i.this.dEs = true;
            if (aVar != null && aVar.isSuccess) {
                i.this.dEo.avX().gd(com.baidu.tbadk.core.util.ao.De().Dg());
                i.dEp = 0L;
                i.dEq = 0L;
                i.dEr = 0;
            } else {
                i.dEr = 1;
            }
            if (!i.this.dEw.azC() && (i == 3 || i == 6)) {
                i.this.dEI.resetData();
            }
            long currentTimeMillis = System.currentTimeMillis();
            if (i.this.dEw.ayW() != null) {
                i.this.dDS = i.this.dEw.ayW();
            }
            if (i == 7) {
                i.this.mO(i.this.dDS.bvp());
                return;
            }
            if (i.this.dDS.yA() != null) {
                i.this.setHasMore(i.this.dDS.yA().yw());
            }
            i.this.auX();
            if (i == 4) {
                if (!i.this.dEw.azC() && TbadkCoreApplication.getInst().isRecAppExist() && i.this.dEw.azs() == 1) {
                    i.this.dDS.a(i.this);
                }
                ArrayList<com.baidu.adp.widget.ListView.i> a2 = i.this.dEI.a(false, false, i.this.dDS.getThreadList(), i.this.dEk);
                if (a2 != null) {
                    i.this.dDS.au(a2);
                    i.this.dDS.bvR();
                    i.this.dEo.a(a2, i.this.dDS);
                }
                if (i.this.dEw != null) {
                    com.baidu.tieba.frs.e.b.a(i.this.dDS, i.this.dEw.azy(), 2);
                    return;
                }
                return;
            }
            switch (i) {
                case 1:
                    i.this.dEo.avO();
                    break;
                case 2:
                    i.this.dEo.avO();
                    break;
                case 3:
                case 6:
                    if (i.this.dDS != null) {
                        i.this.dDS.bvP();
                    }
                    if (i.this.dEN != null) {
                        i.this.dEN.refresh();
                        break;
                    }
                    break;
            }
            i.this.auY();
            if (aVar == null || aVar.errorCode == 0) {
                if (i.this.dDS != null) {
                    i.this.x(false, i == 5);
                    i.this.dEo.mU(i);
                    i.dEp = (System.nanoTime() - this.startTime) / 1000000;
                    if (aVar != null) {
                        i.dEq = aVar.gXK;
                    }
                } else {
                    return;
                }
            } else if (i.this.dDS == null || com.baidu.tbadk.core.util.v.E(i.this.dDS.getThreadList())) {
                i.this.a(aVar);
            } else if (aVar.gXJ) {
                i.this.showToast(i.this.getPageContext().getResources().getString(d.j.net_error_text, aVar.errorMsg, Integer.valueOf(aVar.errorCode)));
            }
            if (i.this.dDS.buU() == 1) {
                TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c11384"));
            }
            if (i.this.dpA > -1 && !i.this.dEU) {
                com.baidu.tieba.frs.f.g.a(i.this.dEw, i.this.dpA);
                i.this.dpA = -1L;
                i.this.dEU = true;
            }
            if (i.this.dEl && i.this.dEy.nT(49)) {
                i.this.dEl = false;
            }
            i.this.bAz = System.currentTimeMillis() - currentTimeMillis;
            System.gc();
        }

        @Override // com.baidu.tieba.tbadkCore.o
        public void b(com.baidu.tieba.tbadkCore.j jVar) {
            if (jVar != null) {
                if ("normal_page".equals(i.this.dEw.azo()) || "frs_page".equals(i.this.dEw.azo()) || "book_page".equals(i.this.dEw.azo())) {
                    i.this.a(jVar);
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001615, jVar));
                }
            }
        }
    };
    private final CustomMessageListener dFq = new CustomMessageListener(2016485) { // from class: com.baidu.tieba.frs.i.13
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tbadk.data.h) && !StringUtils.isNull(TbadkCoreApplication.getCurrentAccount())) {
                i.this.dDS.a((com.baidu.tbadk.data.h) customResponsedMessage.getData());
                i.this.dEo.avX().notifyDataSetChanged();
            }
        }
    };
    private final CustomMessageListener mMemListener = new CustomMessageListener(2001194) { // from class: com.baidu.tieba.frs.i.14
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Integer num;
            UserData userData;
            if (customResponsedMessage != null && (num = (Integer) customResponsedMessage.getData()) != null && i.this.dDS != null && (userData = i.this.dDS.getUserData()) != null) {
                userData.setIsMem(num.intValue());
                if (num.intValue() != 0) {
                    i.this.dEx.f(num);
                }
            }
        }
    };
    private final com.baidu.tieba.frs.mc.i dFr = new com.baidu.tieba.frs.mc.i() { // from class: com.baidu.tieba.frs.i.16
        @Override // com.baidu.tieba.frs.mc.i
        public void a(int i, boolean z, int i2, boolean z2, ArrayList<com.baidu.adp.widget.ListView.i> arrayList, boolean z3) {
            if (i.this.dEA != null && i.this.dEw != null && i.this.dEw.azC() && z && !z2 && !z3) {
                i.this.dEA.nJ(i2);
            }
        }
    };
    public final View.OnTouchListener bDn = new View.OnTouchListener() { // from class: com.baidu.tieba.frs.i.17
        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (i.this.dEQ != null) {
                i.this.dEQ.onTouch(view, motionEvent);
            }
            if (i.this.dEC != null && i.this.dEC.awr() != null) {
                i.this.dEC.awr().onTouchEvent(motionEvent);
            }
            if (i.this.cjX != null) {
                i.this.cjX.f(view, motionEvent);
            }
            if (i.this.dEx != null) {
                i.this.dEx.onTouchEvent(motionEvent);
                return false;
            }
            return false;
        }
    };
    private final CustomMessageListener dFs = new CustomMessageListener(2004507) { // from class: com.baidu.tieba.frs.i.18
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && com.baidu.tbadk.core.sharedPref.b.getInstance().getInt(TbadkCoreApplication.getCurrentAccount() + "photolive_hostLevel", -1) != -1 && i.this.dDS.bas() != null) {
                i.this.dDS.bas().setCanAddPhotoLivePost(true);
            }
        }
    };
    private final CustomMessageListener dFt = new CustomMessageListener(2016493) { // from class: com.baidu.tieba.frs.i.19
        /* JADX DEBUG: Method merged with bridge method */
        /* JADX DEBUG: Multi-variable search result rejected for r2v2, resolved type: com.baidu.tieba.frs.i */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                String str = (String) customResponsedMessage.getData();
                if (!TextUtils.isEmpty(str)) {
                    TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c11455").ab("obj_locate", "frs"));
                    com.baidu.tbadk.core.util.aw.Du().c(i.this.getPageContext(), new String[]{str});
                }
            }
        }
    };
    public final View.OnClickListener dFu = new View.OnClickListener() { // from class: com.baidu.tieba.frs.i.24
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (i.this.dEo == null || view != i.this.dEo.avL() || i.this.getActivity() == null) {
                if (i.this.dDS != null && i.this.dDS.bas() != null && i.this.dEo != null && view == i.this.dEo.avS()) {
                    TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c12402").ab(ImageViewerConfig.FORUM_ID, i.this.dDS.bas().getId()).ab("uid", TbadkCoreApplication.getCurrentAccount()).ab(ImageViewerConfig.FORUM_NAME, i.this.dDS.bas().getName()));
                    if (!StringUtils.isNull(i.this.dDS.bas().getName())) {
                        i.this.sendMessage(new CustomMessage(2002001, new PostSearchActivityConfig(i.this.getPageContext().getPageActivity(), i.this.dDS.bas().getName(), i.this.dDS.bas().getId())));
                        return;
                    }
                    return;
                }
                if (view.getId() == d.g.game_activity_egg_layout && com.baidu.adp.lib.util.l.pa()) {
                    TiebaStatic.log("c10853");
                    if (i.this.dEo.avU()) {
                        i.this.dEo.avV();
                    } else {
                        String activityUrl = i.this.dDS.bas().getYuleData().AO().getActivityUrl();
                        if (!StringUtils.isNull(activityUrl)) {
                            com.baidu.tbadk.browser.b.S(i.this.getPageContext().getPageActivity(), activityUrl);
                        }
                    }
                }
                if (view == i.this.dEo.awb() && i.this.dEw != null && i.this.dEw.hasMore()) {
                    i.this.dEo.XO();
                    i.this.WO();
                }
                if (view != null && view == i.this.dEo.avT() && ay.ba(i.this.getContext())) {
                    TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c12924").s("obj_locate", 2));
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new MessageCenterActivityConfig(i.this.getContext())));
                    return;
                }
                return;
            }
            i.this.getActivity().finish();
        }
    };
    private final RecyclerView.OnScrollListener Sb = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.frs.i.25
        private int dFA = 0;
        private int bZz = 0;

        @Override // android.support.v7.widget.RecyclerView.OnScrollListener
        public void onScrolled(RecyclerView recyclerView, int i, int i2) {
            if (i.this.dEG != null) {
                i.this.dEG.azY();
            }
            this.dFA = 0;
            this.bZz = 0;
            if (recyclerView != null && (recyclerView instanceof com.baidu.adp.widget.ListView.h)) {
                this.dFA = ((com.baidu.adp.widget.ListView.h) recyclerView).getFirstVisiblePosition();
                this.bZz = ((com.baidu.adp.widget.ListView.h) recyclerView).getLastVisiblePosition();
            }
            if (i.this.dES != null) {
                i.this.dES.b(recyclerView, this.dFA, this.bZz);
            }
            if (i.this.dDS != null && i.this.dEo != null && i.this.dEo.avX() != null) {
                i.this.dEo.bv(this.dFA, this.bZz);
            }
        }

        @Override // android.support.v7.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i) {
            if (i.this.dEx != null) {
                i.this.dEx.setScrollState(i);
            }
            if ((i == 2 || i == 1) && !i.this.dEt) {
                i.this.dEt = true;
                i.this.dEo.avZ();
            }
            if (i.this.dEu == null && !i.this.avn()) {
                i.this.dEu = new com.baidu.tbadk.k.d();
                i.this.dEu.ij(1000);
            }
            if (i == 0) {
                com.baidu.tieba.card.r.alt().eO(true);
                i.this.dEo.bu(this.dFA, this.bZz);
            }
            if (i.this.dES != null) {
                i.this.dES.onScrollStateChanged(recyclerView, i);
            }
            if (i.this.dEu != null) {
                i.this.dEu.Od();
            }
            if (i == 0) {
                com.baidu.tieba.frs.f.g.a(i.this.dEo, i.this.dDS, i.this.getForumId(), false, null);
            }
            if (i.this.dEy != null && i == 1) {
                i.this.dEy.aAz();
            }
        }
    };
    private final b dFv = new b() { // from class: com.baidu.tieba.frs.i.26
        @Override // com.baidu.tieba.frs.b
        public void a(int i, int i2, View view, View view2, bd bdVar) {
            if (i != i.this.dEo.avX().axq()) {
                if (i != i.this.dEo.avX().axr()) {
                    if (i != i.this.dEo.avX().axt()) {
                        if (i != i.this.dEo.avX().awi()) {
                            if (i == i.this.dEo.avX().axs() && i.this.dDS != null && i.this.dDS.getUserData() != null && i.this.dDS.getUserData().isBawu()) {
                                final String bvn = i.this.dDS.bvn();
                                if (!com.baidu.tbadk.core.util.am.isEmpty(bvn) && i.this.dDS.bas() != null) {
                                    com.baidu.tieba.c.a.a(i.this.getPageContext(), i.this.dDS.bas().getId(), i.this.dDS.bas().getName(), new a.InterfaceC0136a() { // from class: com.baidu.tieba.frs.i.26.1
                                        @Override // com.baidu.tieba.c.a.InterfaceC0136a
                                        public void akN() {
                                            com.baidu.tbadk.browser.b.R(i.this.getPageContext().getPageActivity(), bvn);
                                            TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c10502").ab(ImageViewerConfig.FORUM_ID, i.this.dDS.bas().getId()).ab("uid", i.this.dDS.getUserData().getUserId()));
                                        }
                                    });
                                    return;
                                }
                                return;
                            }
                            return;
                        }
                        i.this.dEg = bdVar;
                        com.baidu.tieba.frs.f.h.a(i.this, i.this.dEg);
                        TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c10179").ab(ImageViewerConfig.FORUM_ID, i.this.getForumId()));
                        return;
                    }
                    com.baidu.tieba.frs.f.h.z(i.this);
                    TiebaStatic.log(new com.baidu.tbadk.core.util.ak(i == i.this.dEo.avX().axt() ? "c10177" : "c10244").ab(ImageViewerConfig.FORUM_ID, i.this.getForumId()));
                } else if (ay.ba(i.this.getPageContext().getPageActivity())) {
                    TiebaStatic.log("my_service_ck");
                    if (i.this.dDS != null && i.this.dDS.bas() != null) {
                        ForumData bas = i.this.dDS.bas();
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002006, new OfficalBarChatActivityConfig(i.this.getPageContext().getPageActivity(), com.baidu.adp.lib.g.b.c(bas.getId(), 0L), bas.getName(), bas.getImage_url(), 0)));
                    }
                }
            } else if (ay.ba(i.this.getActivity())) {
                TiebaStatic.log("forum_fortune_click");
                com.baidu.tieba.frs.f.h.a(i.this.getPageContext(), i.this.dDS);
            }
        }
    };
    private final NoNetworkView.a dCv = new NoNetworkView.a() { // from class: com.baidu.tieba.frs.i.27
        @Override // com.baidu.tbadk.core.view.NoNetworkView.a
        public void bu(boolean z) {
            if (i.this.dEw.azs() == 1 && z && !i.this.dEo.avm()) {
                if (i.this.dDS == null || com.baidu.tbadk.core.util.v.E(i.this.dDS.getThreadList())) {
                    i.this.hideNetRefreshView(i.this.dEo.afu());
                    i.this.showLoadingView(i.this.dEo.afu(), true);
                    i.this.dEo.fQ(false);
                    i.this.refresh();
                    return;
                }
                i.this.dEo.avO();
            }
        }
    };
    private final CustomMessageListener bjn = new CustomMessageListener(0) { // from class: com.baidu.tieba.frs.i.28
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.baidu.adp.framework.message.ResponsedMessage] */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public /* bridge */ /* synthetic */ void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            onMessage2((CustomResponsedMessage) customResponsedMessage);
        }

        /* renamed from: onMessage  reason: avoid collision after fix types in other method */
        public void onMessage2(CustomResponsedMessage customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2001118) {
                com.baidu.tieba.frs.f.c.a(customResponsedMessage, i.this.dEo, i.this.dDS);
            }
        }
    };
    private com.baidu.adp.widget.ListView.o dFw = new a();
    private an dFx = new an() { // from class: com.baidu.tieba.frs.i.29
        @Override // com.baidu.tieba.frs.an
        public void a(int i, int i2, at atVar, ArrayList<com.baidu.adp.widget.ListView.i> arrayList) {
            com.baidu.adp.lib.g.e.ns().post(new Runnable() { // from class: com.baidu.tieba.frs.i.29.1
                @Override // java.lang.Runnable
                public void run() {
                    if (i.this.dEo != null && i.this.dEo.amu()) {
                        i.this.WO();
                    }
                }
            });
        }
    };
    private CustomMessageListener dFy = new CustomMessageListener(2921033) { // from class: com.baidu.tieba.frs.i.30
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getData() != null) {
                Object data = customResponsedMessage.getData();
                if ((data instanceof String) && !TextUtils.isEmpty((String) data)) {
                    i.this.dET = true;
                }
            }
        }
    };

    @Override // com.baidu.tbadk.core.BaseFragment, com.baidu.tieba.frs.loadmore.a
    public /* bridge */ /* synthetic */ com.baidu.adp.base.e getPageContext() {
        return super.getPageContext();
    }

    public com.baidu.tieba.frs.entelechy.b.b auK() {
        return this.dEE;
    }

    public com.baidu.adp.widget.ListView.o auL() {
        return this.dFw;
    }

    public com.baidu.tieba.frs.mc.d auM() {
        return this.dEH;
    }

    public com.baidu.tieba.frs.smartsort.b auN() {
        return this.dEA;
    }

    @Override // com.baidu.tieba.frs.mc.j
    public FrsModelController auO() {
        return this.dEw;
    }

    @Override // com.baidu.tieba.frs.mc.j
    public com.baidu.tieba.frs.mc.c auP() {
        return this.dEI;
    }

    @Override // com.baidu.tieba.frs.mc.j
    public com.baidu.tieba.frs.g.f auQ() {
        return this.dEx;
    }

    public com.baidu.tieba.frs.g.k auR() {
        return this.dEy;
    }

    public ap auS() {
        return this.dEC;
    }

    @Override // com.baidu.tieba.frs.mc.j
    public k auT() {
        return this.dEo;
    }

    @Override // com.baidu.tieba.frs.ao
    public String getForumId() {
        return this.forumId;
    }

    @Override // com.baidu.tieba.frs.ao, com.baidu.tieba.frs.loadmore.a
    public String getForumName() {
        return this.dEh;
    }

    public void setForumName(String str) {
        this.dEh = str;
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

    @Override // com.baidu.tieba.recapp.n
    public String getFid() {
        return this.forumId;
    }

    @Override // com.baidu.tieba.recapp.n
    public int getPageNum() {
        if (this.dEI == null) {
            return 1;
        }
        return this.dEI.getPn();
    }

    public int getPn() {
        if (this.dEI == null) {
            return 1;
        }
        return this.dEI.getPn();
    }

    public void setPn(int i) {
        if (this.dEI != null) {
            this.dEI.setPn(i);
        }
    }

    public void setHasMore(int i) {
        if (this.dEI != null) {
            this.dEI.setHasMore(i);
        }
    }

    public int auU() {
        if (this.dEI == null) {
            return -1;
        }
        return this.dEI.auU();
    }

    public boolean auV() {
        return this.dEm;
    }

    public String getThreadId() {
        return this.mThreadId;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(d.a aVar) {
        if (aVar == null) {
            String string = TbadkCoreApplication.getInst().getString(d.j.error_unkown_try_again);
            this.dEo.avI();
            showNetRefreshView(this.dEo.afu(), string, true);
        } else if (340001 == aVar.errorCode) {
            a(aVar, this.dDS.buR());
        } else {
            if (com.baidu.tbadk.core.util.v.E(this.dDS.getThreadList())) {
                b(aVar);
            }
            if (avn()) {
                setNetRefreshViewEmotionMarginTop(com.baidu.adp.lib.util.l.t(TbadkCoreApplication.getInst(), d.e.ds280));
            } else {
                setNetRefreshViewEmotionDefMarginTop();
            }
        }
    }

    public void a(View view, String str, boolean z, List<RecmForumInfo> list) {
        this.dEo.avI();
        this.dEo.mS(8);
        if (this.dER == null) {
            this.dER = new com.baidu.tieba.frs.view.b(getPageContext(), getNetRefreshListener());
        }
        this.dER.gW(str);
        this.dER.by(list);
        this.dER.j(view, z);
    }

    private void a(d.a aVar, List<RecmForumInfo> list) {
        if (this.dEo != null) {
            this.dEo.avI();
            this.dEo.setTitle(this.dEh);
            a(this.dEo.afu(), aVar.errorMsg, true, list);
        }
    }

    private void b(d.a aVar) {
        this.dEo.avI();
        if (aVar.gXJ) {
            showNetRefreshView(this.dEo.afu(), TbadkCoreApplication.getInst().getString(d.j.net_error_text, new Object[]{aVar.errorMsg, Integer.valueOf(aVar.errorCode)}), true);
        } else {
            showNetRefreshView(this.dEo.afu(), aVar.errorMsg, true);
        }
    }

    public void auW() {
        hideLoadingView(this.dEo.afu());
        if (!this.dEo.avm()) {
            this.dEo.fR(false);
        } else {
            this.dEo.fR(true);
        }
        if (this.dEo.avG() instanceof com.baidu.tieba.frs.tab.a) {
            ((com.baidu.tieba.frs.tab.a) this.dEo.avG()).azU();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void auX() {
        if (auU() == 0 && com.baidu.tbadk.core.util.v.E(this.dDS.bvb())) {
            if (com.baidu.tbadk.core.util.v.E(this.dDS.getThreadList())) {
                this.dEo.XQ();
            } else {
                this.dEo.XP();
            }
        } else if (com.baidu.tbadk.core.util.v.D(this.dDS.getThreadList()) > 3) {
            this.dEo.XO();
        } else {
            this.dEo.awa();
        }
    }

    public void a(ErrorData errorData) {
        auW();
        this.dEo.avO();
        d.a azp = this.dEw.azp();
        boolean E = com.baidu.tbadk.core.util.v.E(this.dDS.getThreadList());
        if (azp != null && E) {
            if (E) {
                if (this.dEw.azq() != 0) {
                    this.dEw.azw();
                    this.dEo.avO();
                } else {
                    a(azp);
                }
                this.dEo.y(this.dDS.bwj(), false);
                return;
            } else if (azp.gXJ) {
                this.dEo.y(true, false);
                showToast(getPageContext().getResources().getString(d.j.net_error_text, azp.errorMsg, Integer.valueOf(azp.errorCode)));
                return;
            } else {
                return;
            }
        }
        a(azp);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void auY() {
        if (this.dDS == null || this.dDS.bas() != null) {
            this.dEo.avW();
        } else if (this.dDS.bas().getYuleData() != null && this.dDS.bas().getYuleData().AN()) {
            TiebaStatic.log("c10852");
            this.dEo.a(this.dDS.bas().getYuleData().AO());
        } else {
            this.dEo.avW();
        }
    }

    private void w(boolean z, boolean z2) {
        if (this.dEw != null && this.dDS != null && this.dEo != null && z) {
            if (!this.dEw.azC() && this.dEw.azs() == 1) {
                if (!this.dEw.azA()) {
                    if (TbadkCoreApplication.getInst().appResponseToIntentClass(PhotoLiveActivityConfig.class)) {
                        this.dDS.bwa();
                        this.dDS.bvT();
                    }
                    this.dDS.bvY();
                    this.dDS.bvZ();
                }
                boolean z3 = false;
                if (this.dEo.avX().k(com.baidu.tieba.card.data.o.dar)) {
                    z3 = this.dDS.bwd();
                }
                if (!z3) {
                    this.dDS.bwb();
                }
                if (TbadkCoreApplication.getInst().isRecAppExist()) {
                    this.dDS.a(this);
                }
                if (!this.dEo.avX().k(bd.aOo)) {
                    this.dDS.bvQ();
                }
                this.dDS.bwe();
            }
            if (!this.dEo.avX().k(bd.aOo)) {
                this.dDS.bvX();
                this.dDS.bvV();
            } else {
                this.dDS.bvW();
                this.dDS.bvU();
            }
            this.dDS.bvR();
            this.dDS.bvO();
            if (this.dEo.avX().k(com.baidu.tieba.g.b.eaq)) {
                this.dDS.mK(z2);
            }
            if (TbadkCoreApplication.isLogin() && (!this.dEw.azC() || this.dEw.isNetFirstLoad)) {
                this.dDS.bwf();
            }
            this.dDS.bwh();
        }
    }

    public boolean auZ() {
        if (this.dEx != null && this.dEw != null) {
            this.dEx.a(this.dEw.azo(), this.dDS);
        }
        boolean z = false;
        if (this.dDS != null) {
            z = this.dDS.bwk();
        }
        avb();
        return z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mO(int i) {
        aq aqVar = null;
        auZ();
        avi();
        try {
            if (this.dDS != null) {
                this.dEo.a((ArrayList<com.baidu.adp.widget.ListView.i>) null, this.dDS);
                this.dEx.nO(1);
                this.dEo.avR();
                this.dEy.a(this.dDS, this.dEw.azy());
                com.baidu.tieba.frs.tab.b nU = this.dEy.nU(this.dDS.bvp());
                if (nU != null && !TextUtils.isEmpty(nU.url)) {
                    aqVar = new aq();
                    aqVar.dHz = nU.url;
                    aqVar.stType = nU.name;
                }
                this.dEw.a(this.dDS.bvp(), 0, aqVar);
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void x(boolean z, boolean z2) {
        try {
            if (this.dDS != null && this.dEy != null && this.dEw != null) {
                if (!this.dEo.avX().k(bd.aOo)) {
                    this.dDS.bvQ();
                }
                boolean E = com.baidu.tbadk.core.util.v.E(this.dDS.bvC());
                this.dEo.fO(E);
                if (!E) {
                    if (this.dES == null) {
                        this.dES = new com.baidu.tieba.frs.g.e(this, (NoPressedRelativeLayout) this.mRootView);
                    }
                    if (this.cjX == null) {
                        this.cjX = new com.baidu.tieba.frs.gametab.b(getActivity(), getBaseFragmentActivity().getUniqueId(), true);
                    }
                } else {
                    this.dES = null;
                    this.cjX = null;
                }
                if (this.dDS.bas() != null) {
                    this.dEh = this.dDS.bas().getName();
                    this.forumId = this.dDS.bas().getId();
                }
                if (this.dDS.bwk()) {
                    this.dEy.a(this.dDS, this.dEw.azy());
                }
                if (z) {
                    w(true, z);
                } else {
                    w(this.dEv, z);
                }
                auZ();
                if (this.dEE != null) {
                    this.dEE.a(this.dEx, this.dDS);
                }
                if (this.dDS.yA() != null) {
                    setHasMore(this.dDS.yA().yw());
                }
                ArrayList<com.baidu.adp.widget.ListView.i> a2 = this.dEI.a(z2, true, this.dDS.getThreadList(), null, z);
                if (a2 != null) {
                    this.dDS.au(a2);
                }
                this.dDS.bwg();
                if (this.dEw.azs() == 1) {
                    avf();
                    if (!z && this.dEw.getPn() == 1) {
                        ava();
                    }
                }
                this.dDV = this.dDS.azu();
                if (this.dEk != null) {
                    this.dEj = true;
                    this.dEk.vI(this.dDV);
                    com.baidu.tieba.frs.f.a.a(this, this.dDS.bas(), this.dDS.getThreadList(), this.dEj, getPn());
                }
                if (this.dEG != null) {
                    this.dEG.bS(this.dEy.aAw());
                }
                auW();
                this.dEo.avJ();
                this.dEo.y(true, false);
                if (this.dDS.bas() != null) {
                    this.dEo.lI(this.dDS.bas().getWarningMsg());
                }
                if (this.dDS != null && this.dDS.bvF() != null && com.baidu.tbadk.core.sharedPref.b.getInstance().getLong("frs_video_activity_guide", 0L) == 0) {
                    com.baidu.adp.lib.g.e.ns().postDelayed(new Runnable() { // from class: com.baidu.tieba.frs.i.11
                        @Override // java.lang.Runnable
                        public void run() {
                            i.this.dEo.awf();
                        }
                    }, 1000L);
                }
                MessageManager.getInstance().sendMessage(new CustomMessage(2921326, this));
                this.dEo.avB();
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    public void ava() {
        if (this.dEL == null) {
            this.dEL = new com.baidu.tieba.frs.live.a(this, com.baidu.adp.lib.g.b.h(this.forumId, 0));
        }
        this.dEL.azb();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.tieba.tbadkCore.j jVar) {
        try {
            if (!this.dEs && jVar != null && this.dDS != null) {
                this.dDS.e(jVar);
                x(true, false);
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    private void avb() {
        if (this.dEw != null) {
            lG(this.dEw.azo());
        } else {
            lG("normal_page");
        }
    }

    private void lG(String str) {
        fJ("frs_page".equals(str));
        if (this.dEE != null) {
            this.dEE.a(this.dEx, this.dEo, this.dDS);
        }
    }

    public void fJ(boolean z) {
        if (this.dEJ != null) {
            this.dEJ.c(this.dEo, z);
        }
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        if (this.mRootView == null) {
            this.mRootView = layoutInflater.inflate(d.h.frs_activity, viewGroup, false);
            this.dEb = new com.baidu.tieba.frs.entelechy.b();
            this.dEE = this.dEb.awW();
            this.dEx = new com.baidu.tieba.frs.g.f(this, this.dEb, (FrsHeaderViewContainer) this.mRootView.findViewById(d.g.header_view_container));
            this.dEy = new com.baidu.tieba.frs.g.i(this, this.mRootView);
            this.dEy.a(this.dFf);
            Intent intent = getActivity().getIntent();
            if (intent != null && "main_tab".equals(intent.getStringExtra("from"))) {
                this.dEd = true;
            }
            this.dEo = new k(this, this.dFu, this.dEb, this.dEd, this.dEx);
            this.dEo.setHeaderViewHeight(this.dEP);
        } else {
            if (this.mRootView.getParent() instanceof ViewGroup) {
                ((ViewGroup) this.mRootView.getParent()).removeView(this.mRootView);
            }
            this.dEy.resetData();
            this.dEo.awe();
        }
        return this.mRootView;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        Intent intent = getActivity().getIntent();
        this.dpA = System.currentTimeMillis();
        if (intent != null) {
            this.dEl = intent.getBooleanExtra(FrsActivityConfig.ALA_IS_ONLIVING, false);
            this.dpA = intent.getLongExtra("TibaStatic.StartTime", System.currentTimeMillis());
            K(intent);
        }
        this.beginTime = System.currentTimeMillis();
        this.bAr = this.beginTime - this.dpA;
        this.dEk = new com.baidu.tieba.tbadkCore.data.e("frs", com.baidu.tieba.tbadkCore.data.e.hax);
        this.dEw = new FrsModelController(this, this.dFp);
        this.dEw.a(this.dFe);
        this.dEw.init();
        if (intent != null) {
            this.dEw.l(intent.getExtras());
        } else if (bundle != null) {
            this.dEw.l(bundle);
        } else {
            this.dEw.l(null);
        }
        if (intent != null) {
            this.dEx.o(intent.getExtras());
        } else if (bundle != null) {
            this.dEx.o(bundle);
        } else {
            this.dEx.o((Bundle) null);
        }
        this.dEn = getVoiceManager();
        this.dEM = new j(getPageContext(), this);
        initUI();
        initData(bundle);
        if (this.mFrom != null && this.mFrom.equals("from_tieba_kuang")) {
            TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c12264").s("obj_type", 1).ab(ImageViewerConfig.FORUM_NAME, this.dEw.getForumName()));
            KuangFloatingViewController.getInstance().setNeedShowFloatingView(true);
            if (KuangFloatingViewController.getInstance().init()) {
                ((BaseFragmentActivity) getPageContext().getOrignalPage()).grantWindowPermission(new com.baidu.tbadk.core.e() { // from class: com.baidu.tieba.frs.i.15
                    @Override // com.baidu.tbadk.core.e
                    public void aS(boolean z) {
                        if (z) {
                            KuangFloatingViewController.getInstance().showFloatingView();
                        }
                    }
                });
            }
        }
        if (!avn()) {
            this.dEC = new ap(getActivity(), this.dEo, this.dEx);
            this.dEC.fX(true);
        }
        this.dEn = getVoiceManager();
        if (this.dEn != null) {
            this.dEn.onCreate(getPageContext());
        }
        new com.baidu.tieba.frs.mc.g();
        this.dEI = new com.baidu.tieba.frs.mc.c(this, this.dFr);
        this.dEA = new com.baidu.tieba.frs.smartsort.b(this);
        this.dEJ = new com.baidu.tieba.frs.g.h(this);
        this.createTime = System.currentTimeMillis() - this.beginTime;
        this.dEG = new com.baidu.tieba.frs.g.a(getPageContext(), this.dEw.azz());
        this.dEB = new com.baidu.tieba.frs.mc.b(this);
        this.dEH = new com.baidu.tieba.frs.mc.d(this);
        this.dEz = new com.baidu.tieba.frs.mc.f(this);
        this.dEK = new com.baidu.tieba.frs.mc.a(this);
        this.dEN = new com.baidu.tieba.frs.g.c(this);
        this.dEO = new com.baidu.tieba.frs.mc.e(this, getUniqueId());
        this.dEV = new com.baidu.tieba.NEGFeedBack.a(getPageContext(), "frs");
        this.dEW = new com.baidu.tieba.ala.a(getPageContext());
        registerListener(this.chk);
        registerListener(this.mMemListener);
        registerListener(this.dFk);
        registerListener(this.dFs);
        registerListener(this.dFj);
        registerListener(this.dFq);
        registerListener(this.dFg);
        registerListener(this.dFh);
        registerListener(this.dFi);
        registerListener(this.dFb);
        registerListener(this.dFc);
        registerListener(this.dFy);
        registerListener(this.dFm);
        registerListener(this.dFd);
        registerListener(this.dFn);
        this.dFo.setSelfListener(true);
        registerListener(this.dFo);
        this.dFa.setTag(getPageContext().getUniqueId());
        registerListener(this.dFa);
        this.dEo.fQ(false);
        if (!avn()) {
            showLoadingView(this.dEo.afu(), true);
            this.dEw.G(3, true);
        }
        super.onActivityCreated(bundle);
    }

    @Override // com.baidu.tieba.frs.aj
    public void Xq() {
        if (isAdded() && this.clg && !isLoadingViewAttached()) {
            showLoadingView(this.dEo.afu(), true);
        }
    }

    @Override // com.baidu.tieba.frs.aj
    public void Xr() {
        if (isAdded() && this.clg && isLoadingViewAttached()) {
            hideLoadingView(this.dEo.afu());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onLazyLoad() {
        if (avn()) {
            showLoadingView(this.dEo.afu(), true);
            this.dEo.mT(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
            this.dEw.G(3, true);
            Ez().scrollToPosition(0);
        }
    }

    @Override // com.baidu.tieba.frs.aj
    public void setHeaderViewHeight(int i) {
        this.dEP = i;
        if (this.dEo != null) {
            this.dEo.setHeaderViewHeight(this.dEP);
        }
    }

    @Override // com.baidu.tieba.frs.aj
    public void setRecommendFrsNavigationAnimDispatcher(com.baidu.tbadk.util.s sVar) {
        if (sVar != null) {
            this.bDm = sVar.Pl();
            this.dEQ = sVar.Pm();
        }
    }

    @Override // com.baidu.tieba.frs.aj
    public void showFloatingView() {
        if (this.bDm != null) {
            this.bDm.cG(true);
        }
    }

    private void K(Intent intent) {
        if (intent != null) {
            if (!com.baidu.tieba.frs.f.e.a(this, getForumName(), "from", intent.getBooleanExtra(FrsActivityConfig.FROM_SHORT_CUT, false)) && getActivity() != null) {
                getActivity().finish();
                return;
            }
        }
        if (intent != null && intent.getData() != null) {
            Uri data = intent.getData();
            this.dEh = data.getQueryParameter("name");
            this.mFrom = data.getQueryParameter("from");
            if (!StringUtils.isNull(this.dEh)) {
                intent.putExtra("name", this.dEh);
            }
            if (!StringUtils.isNull(this.mFrom)) {
                intent.putExtra("from", this.mFrom);
            }
            TiebaStatic.log("c10105");
        }
        if (StringUtils.isNull(this.dEh)) {
            this.dEh = com.baidu.tieba.frs.f.h.M(intent);
            if (!StringUtils.isNull(this.dEh)) {
                intent.putExtra("name", this.dEh);
            }
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onStart() {
        super.onStart();
        this.dEn = getVoiceManager();
        if (this.dEn != null) {
            this.dEn.onStart(getPageContext());
        }
    }

    private void initData(Bundle bundle) {
        Intent intent;
        registerListener(2001118, this.bjn);
        if (bundle != null) {
            this.dEh = bundle.getString("name");
            this.mFrom = bundle.getString("from");
            this.mFlag = bundle.getInt(FrsActivityConfig.FLAG, 0);
        } else if (getActivity() != null && (intent = getActivity().getIntent()) != null) {
            this.dEh = intent.getStringExtra("name");
            this.mFrom = intent.getStringExtra("from");
            this.mFlag = intent.getIntExtra(FrsActivityConfig.FLAG, 0);
        }
        if (TextUtils.isEmpty(this.mFrom) || FrsActivityConfig.FRS_FROM_WRITESHARE.equals(this.mFrom)) {
        }
        if (this.mIsLogin) {
            registerListener(2001120, this.bjn);
        }
        this.dEx.o(bundle);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.dFy);
        if (this.dEn != null) {
            this.dEn.onDestory(getPageContext());
        }
        this.dEn = null;
        com.baidu.tieba.card.r.alt().eO(false);
        if (this.dDS != null && this.dDS.bas() != null) {
            ae.awo().bF(com.baidu.adp.lib.g.b.c(this.dDS.bas().getId(), 0L));
        }
        if (this.dEL != null) {
            this.dEL.onDestory();
        }
        if (this.dEo != null) {
            com.baidu.tieba.frs.f.g.a(this.dEo, this.dDS, getForumId(), false, null);
            this.dEo.onDestroy();
        }
        super.onDestroy();
        try {
            if (this.dEu != null) {
                this.dEu.onDestroy();
            }
            this.dEo.release();
            System.gc();
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
        this.dEw.onActivityDestroy();
        this.dEx.onActivityDestroy();
        if (this.dEw != null) {
            this.dEw.Za();
        }
        if (this.dEC != null) {
            this.dEC.Pk();
        }
        if (this.dEF != null) {
            this.dEF.destory();
        }
        if (this.dEG != null) {
            this.dEG.destory();
        }
        if (this.dEA != null) {
            this.dEA.onDestroy();
        }
        if (this.dES != null) {
            this.dES.onDestory();
        }
        if (this.dEK != null) {
            this.dEK.onDestroy();
        }
        if (this.dEV != null) {
            this.dEV.onDestroy();
        }
        if (this.dEW != null) {
            this.dEW.onDestroy();
        }
        com.baidu.tieba.recapp.d.a.boS().boU();
        com.baidu.tieba.frs.f.i.azV();
        if (this.dEy != null) {
            this.dEy.a((i.b) null);
            this.dEy.aAz();
        }
        if (this.dEX != null) {
            this.dEX.onDestroy();
        }
        if (this.dEY != null) {
            this.dEY.onDestroy();
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putString("name", this.dEh);
        bundle.putString("from", this.mFrom);
        this.dEw.onSaveInstanceState(bundle);
        if (this.dEn != null && getPageContext() != null && getPageContext().getPageActivity() != null) {
            this.dEn.onSaveInstanceState(getPageContext().getPageActivity());
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (this.dEK != null) {
            this.dEK.onActivityResult(i, i2, intent);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        if (this.dEo != null) {
            this.dEo.avO();
            this.dEo.onResume();
        }
        this.dEz.gr(true);
        this.dEv = true;
        if (dEf) {
            dEf = false;
            this.dEo.startPullRefresh();
            return;
        }
        if (this.dEn != null) {
            this.dEn.onResume(getPageContext());
        }
        this.dEo.fS(false);
        registerListener(this.dFt);
        if (this.dET) {
            refresh(6);
            this.dET = false;
        }
        if (KuangFloatingViewController.getInstance().init()) {
            ((BaseFragmentActivity) getPageContext().getOrignalPage()).grantWindowPermission(new com.baidu.tbadk.core.e() { // from class: com.baidu.tieba.frs.i.20
                @Override // com.baidu.tbadk.core.e
                public void aS(boolean z) {
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

    public boolean avc() {
        Intent intent;
        if (getActivity() == null || (intent = getActivity().getIntent()) == null) {
            return false;
        }
        return intent.getBooleanExtra(FrsActivityConfig.ALA_IS_ONLIVING, false);
    }

    public void onNewIntent(Intent intent) {
        if (intent != null) {
            if (!TextUtils.isEmpty(intent.getStringExtra("name"))) {
                this.dEh = intent.getStringExtra("name");
            }
            if (!TextUtils.isEmpty(intent.getStringExtra("from"))) {
                this.mFrom = intent.getStringExtra("from");
            }
            this.dEi = intent.getBooleanExtra(FrsActivityConfig.KEY_REFRESH, false);
            if (this.dEi) {
                avd();
            }
            if (this.mFrom != null && this.mFrom.equals("from_tieba_kuang")) {
                KuangFloatingViewController.getInstance().setNeedShowFloatingView(true);
                if (KuangFloatingViewController.getInstance().init()) {
                    ((BaseFragmentActivity) getPageContext().getOrignalPage()).grantWindowPermission(new com.baidu.tbadk.core.e() { // from class: com.baidu.tieba.frs.i.21
                        @Override // com.baidu.tbadk.core.e
                        public void aS(boolean z) {
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
    public void avd() {
        this.dEo.startPullRefresh();
    }

    public void closeActivity() {
        com.baidu.tieba.frs.f.h.a(getPageContext(), getActivity() == null ? null : getActivity().getIntent(), this.mFrom);
    }

    private void initUI() {
        if (this.mFlag == 0) {
            this.dEo.setTitle(this.dEh);
        } else {
            this.dEo.setTitle("");
            this.mFlag = 1;
        }
        this.dEo.setOnAdapterItemClickListener(this.dFw);
        this.dEo.addOnScrollListener(this.Sb);
        this.dEo.h(this.dCv);
        this.dEo.avX().a(this.dFv);
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.dEo.onChangeSkinType(i);
        this.dEx.nN(i);
        this.dEy.onChangeSkinType(i);
        if (this.dER != null) {
            this.dER.onChangeSkinType();
        }
        if (this.dEX != null) {
            this.dEX.onChangeSkinType(i);
        }
    }

    public void mP(int i) {
        if (!this.mIsLogin) {
            if (this.dDS != null && this.dDS.yn() != null) {
                this.dDS.yn().setIfpost(1);
            }
            if (i == 0) {
                ay.aZ(getActivity());
            }
        } else if (this.dDS != null) {
            if (i == 0) {
                com.baidu.tieba.frs.f.i.b(this, 0);
            } else {
                this.dEo.avQ();
            }
        }
    }

    public void refresh() {
        this.dEo.avM();
        refresh(3);
    }

    public void refresh(int i) {
        this.dEs = false;
        if (!this.dEo.avD()) {
            avi();
        }
        if (this.dEo.avF() != null) {
            this.dEo.avF().aEa();
        }
        this.dEw.G(i, true);
    }

    private void ave() {
        switch (this.mFlag) {
            case 1:
                com.baidu.adp.lib.g.h.nt().e(new Runnable() { // from class: com.baidu.tieba.frs.i.22
                    @Override // java.lang.Runnable
                    public void run() {
                        com.baidu.tieba.tbadkCore.util.a.sQ(i.this.dEh);
                    }
                });
                break;
        }
        this.mFlag = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void avf() {
        if (!this.dEo.avD()) {
            avi();
        }
        try {
            if (this.dDS != null) {
                this.dEo.aik();
                this.dEo.fN(this.dEw.azt());
                if (!com.baidu.tieba.frs.g.f.i(this.dDS) || !com.baidu.tieba.frs.g.f.h(this.dDS)) {
                }
                if (this.dDS.bas() != null) {
                    this.dEh = this.dDS.bas().getName();
                    this.forumId = this.dDS.bas().getId();
                }
                if (this.dDS.yA() != null) {
                    setHasMore(this.dDS.yA().yw());
                }
                this.dEo.setTitle(this.dEh);
                this.dEo.setForumName(this.dEh);
                TbadkCoreApplication.getInst().setDefaultBubble(this.dDS.getUserData().getBimg_url());
                TbadkCoreApplication.getInst().setDefaultBubbleEndTime(this.dDS.getUserData().getBimg_end_time());
                ave();
                avg();
                ArrayList<com.baidu.adp.widget.ListView.i> threadList = this.dDS.getThreadList();
                if (threadList != null) {
                    this.dEo.a(threadList, this.dDS);
                    com.baidu.tieba.frs.f.c.u(this.dEo);
                    this.dEx.nO(getPageNum());
                    this.dEx.f(this.dDS);
                    this.dEy.a(this.dDS, this.dEw.azy());
                    this.dEo.avR();
                }
                this.dEo.a(this.dDS.buW());
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    private void avg() {
        if (this.dDS != null) {
            if (this.dDS.baH() == 1) {
                this.dEo.avX().setFromCDN(true);
            } else {
                this.dEo.avX().setFromCDN(false);
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onPause() {
        super.onPause();
        this.dEz.gr(false);
        this.dEv = false;
        if (this.dEn != null) {
            this.dEn.onPause(getPageContext());
        }
        this.dEo.onPause();
        this.dEo.fS(true);
        if (this.dEG != null) {
            this.dEG.azY();
        }
        MessageManager.getInstance().unRegisterListener(this.dFt);
    }

    @Override // android.support.v4.app.Fragment
    public void onStop() {
        super.onStop();
        com.baidu.tieba.card.r.alt().eO(false);
        if (this.dDS != null && this.dDS.bas() != null && getPageContext() != null && getPageContext().getPageActivity() != null) {
            com.baidu.tbadk.distribute.a.KM().a(getPageContext().getPageActivity(), "frs", this.dDS.bas().getId(), 0L);
        }
        if (this.dEn != null) {
            this.dEn.onStop(getPageContext());
        }
        if (Ez() != null) {
            Ez().getRecycledViewPool().clear();
        }
        this.dEx.onActivityStop();
        com.baidu.tbadk.util.t.Po();
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        super.onPrimary();
        if (isAdded() && this.dEx != null) {
            this.dEx.gt(isPrimary());
        }
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i != 4 || this.dEo == null) {
            return false;
        }
        return this.dEo.avN();
    }

    @Override // com.baidu.tieba.recapp.n
    public TbPageContext<?> akO() {
        return getPageContext();
    }

    @Override // com.baidu.tieba.recapp.n
    public void a(AdvertAppInfo advertAppInfo, String str) {
        com.baidu.tbadk.distribute.a.KM().a(advertAppInfo, this.forumId, 0L, "FRS", str, getPn());
    }

    @Override // com.baidu.tieba.recapp.n
    public void avh() {
        auO().avh();
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager getVoiceManager() {
        if (this.dEn == null) {
            this.dEn = VoiceManager.instance();
        }
        return this.dEn;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.core.view.UserIconBox.b
    /* renamed from: getListView */
    public com.baidu.adp.widget.ListView.h Ez() {
        if (this.dEo == null) {
            return null;
        }
        return this.dEo.getListView();
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager.b c(VoiceData.VoiceModel voiceModel) {
        return null;
    }

    public void avi() {
        if (this.dEn != null) {
            this.dEn.stopPlay();
        }
    }

    @Override // com.baidu.tbadk.core.view.UserIconBox.b
    public com.baidu.adp.lib.e.b<TbImageView> EA() {
        if (this.beQ == null) {
            this.beQ = UserIconBox.w(getPageContext().getPageActivity(), 8);
        }
        return this.beQ;
    }

    public void avj() {
        if (getFragmentActivity() != null && getFragmentActivity().getCurrentFocus() != null) {
            com.baidu.adp.lib.util.l.a(getFragmentActivity(), getFragmentActivity().getCurrentFocus());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public com.baidu.adp.widget.ListView.l onGetPreLoadListView() {
        return Ez().getPreLoadHandle();
    }

    @Override // com.baidu.tieba.frs.am
    public NavigationBar avk() {
        if (this.dEo == null) {
            return null;
        }
        return this.dEo.avk();
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
                if (bdUniqueId == r.dGM) {
                    if (i.this.dEo != null) {
                        TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c11752").ab(ImageViewerConfig.FORUM_ID, i.this.forumId).ab("obj_locate", "1"));
                        i.this.dEo.startPullRefresh();
                    }
                } else if (iVar != null && (iVar instanceof bd)) {
                    bd bdVar = (bd) iVar;
                    if (bdVar.zY() == null || bdVar.zY().getGroup_id() == 0 || ay.ba(i.this.getActivity())) {
                        if (bdVar.zR() != 1 || ay.ba(i.this.getActivity())) {
                            if (bdVar.zB() != null) {
                                if (ay.ba(i.this.getActivity())) {
                                    String postUrl = bdVar.zB().getPostUrl();
                                    if (!StringUtils.isNull(postUrl) && com.baidu.adp.lib.util.l.pa()) {
                                        com.baidu.tbadk.browser.b.S(i.this.getActivity(), postUrl);
                                    }
                                }
                            } else if (bdVar.Ag() != null) {
                                if (StringUtils.isNull(TbadkCoreApplication.getCurrentAccount())) {
                                    ay.aZ(i.this.getPageContext().getPageActivity());
                                    return;
                                }
                                com.baidu.tbadk.core.data.m Ag = bdVar.Ag();
                                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new MangaBrowserActivityConfig(i.this.getPageContext().getPageActivity(), Ag.getCartoonId(), Ag.getChapterId(), 2)));
                            } else {
                                com.baidu.tieba.tbadkCore.util.e readThreadHistory = TbadkCoreApplication.getInst().getReadThreadHistory();
                                if (readThreadHistory != null && !readThreadHistory.sW(bdVar.getId())) {
                                    readThreadHistory.sV(bdVar.getId());
                                }
                                final String zv = bdVar.zv();
                                if (zv == null || zv.equals("")) {
                                    z = false;
                                } else {
                                    new Thread(new Runnable() { // from class: com.baidu.tieba.frs.i.a.1
                                        @Override // java.lang.Runnable
                                        public void run() {
                                            com.baidu.tbadk.core.util.x xVar = new com.baidu.tbadk.core.util.x(zv);
                                            xVar.Cz().Dw().mIsNeedAddCommenParam = false;
                                            xVar.Cz().Dw().mIsUseCurrentBDUSS = false;
                                            xVar.Cc();
                                        }
                                    }).start();
                                    z = true;
                                }
                                String tid = bdVar.getTid();
                                if (tid == null) {
                                    tid = "";
                                }
                                if (bdVar.zi() == 2 && !tid.startsWith("pb:")) {
                                    com.baidu.tbadk.core.util.aw.Du().c(i.this.getPageContext(), new String[]{tid, "", null});
                                } else if (bdVar.getThreadType() == 33 || (bdVar instanceof com.baidu.tbadk.core.data.as)) {
                                    String str = bdVar.getThreadType() == 33 ? "c10245" : "c10180";
                                    if (i.this.dEw.azs() == 5) {
                                        str = "c10387";
                                    }
                                    TiebaStatic.log(new com.baidu.tbadk.core.util.ak(str).ab(ImageViewerConfig.FORUM_ID, i.this.forumId));
                                    com.baidu.tieba.frs.f.h.b(i.this, bdVar);
                                    if (i.this.dDS != null && i.this.dDS.bas() != null) {
                                        com.baidu.tieba.frs.e.a aVar = new com.baidu.tieba.frs.e.a();
                                        aVar.dTX = i.this.dDS.gYv == 1;
                                        aVar.dTZ = i.this.dDS.bas().getId();
                                        aVar.dTY = i.this.auO().azy();
                                        if (com.baidu.tieba.frs.e.c.dUj != null) {
                                            aVar.dUa = com.baidu.tieba.frs.e.c.dUj.dUa;
                                            aVar.dUb = com.baidu.tieba.frs.e.c.dUj.dUb;
                                        }
                                        com.baidu.tieba.frs.e.b.azS().a(aVar, bdVar, 1);
                                    }
                                } else {
                                    if (tid.startsWith("pb:")) {
                                        bdVar.setId(tid.substring(3));
                                    }
                                    if (bdUniqueId.getId() == bd.aPy.getId()) {
                                        com.baidu.tieba.frs.f.g.a(bdVar.yV());
                                    } else if (bdUniqueId.getId() == bd.aOr.getId()) {
                                        com.baidu.tbadk.core.util.ak akVar = new com.baidu.tbadk.core.util.ak("c12940");
                                        akVar.ab("obj_type", "2");
                                        akVar.ab("tid", bdVar.getTid());
                                        TiebaStatic.log(akVar);
                                    }
                                    com.baidu.tieba.frs.f.h.a(i.this, bdVar, i, z);
                                    com.baidu.tieba.frs.f.g.a(i.this, i.this.dDS, bdVar);
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
            hideNetRefreshView(this.dEo.afu());
            showLoadingView(this.dEo.afu(), true);
            this.dEo.fQ(false);
            this.dEw.G(3, true);
        }
    }

    @Override // com.baidu.tieba.frs.loadmore.a
    public com.baidu.tieba.tbadkCore.m avl() {
        return this.dDS;
    }

    public boolean avm() {
        return this.dEo.avm();
    }

    public void aW(Object obj) {
        if (this.dEB != null && this.dEB.dSL != null) {
            this.dEB.dSL.ak(obj);
        }
    }

    public void aX(Object obj) {
        if (this.dEB != null && this.dEB.dSM != null) {
            this.dEB.dSM.ak(obj);
        }
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.e
    public void onScrollToBottom() {
        if (!com.baidu.adp.lib.util.l.pa()) {
            this.dEo.XQ();
        } else if (this.dEw.azs() == 1) {
            Xc();
            WO();
        } else if (this.dEw.hasMore()) {
            WO();
        }
    }

    @Override // com.baidu.tieba.frs.loadmore.FrsLoadMoreModel.a
    public void lu(String str) {
        Xc();
        showToast(str);
    }

    @Override // com.baidu.tieba.frs.loadmore.FrsLoadMoreModel.a
    public void J(ArrayList<com.baidu.adp.widget.ListView.i> arrayList) {
        Xc();
        if (!com.baidu.tbadk.core.util.v.E(arrayList)) {
            if (!this.dEw.azC() && TbadkCoreApplication.getInst().isRecAppExist() && this.dEw.azs() == 1) {
                this.dDS.a(this, arrayList);
            }
            ArrayList<com.baidu.adp.widget.ListView.i> a2 = this.dEI.a(false, false, arrayList, this.dEk);
            if (a2 != null) {
                this.dDS.au(a2);
                this.dEo.a(a2, this.dDS);
            }
            if (this.dEw != null) {
                com.baidu.tieba.frs.e.b.a(this.dDS, this.dEw.azy(), 2);
            }
        }
    }

    private void Xc() {
        if (auU() == 1 || this.dEI.bv(this.dDS.bvb())) {
            if (com.baidu.tbadk.core.util.v.D(this.dDS.getThreadList()) > 3) {
                this.dEo.XO();
            } else {
                this.dEo.awa();
            }
        } else if (com.baidu.tbadk.core.util.v.E(this.dDS.getThreadList())) {
            this.dEo.XQ();
        } else {
            this.dEo.XP();
        }
    }

    @Override // com.baidu.tieba.frs.mc.j
    public void WO() {
        if (this.dEI != null) {
            this.dEI.a(this.dEh, this.forumId, this.dDS);
        }
    }

    public void takePhoto() {
        if (!com.baidu.tbadk.core.util.ab.e(getPageContext().getPageActivity(), 1)) {
            com.baidu.tbadk.core.util.ai.b(getPageContext());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, com.baidu.tbadk.pageStayDuration.a
    public String getCurrentPageKey() {
        return avn() ? "a034" : "a006";
    }

    @Override // com.baidu.tbadk.core.BaseFragment, com.baidu.tbadk.pageStayDuration.a
    public List<String> getCurrentPageSourceKeyList() {
        ArrayList arrayList;
        if (!avn()) {
            return super.getCurrentPageSourceKeyList();
        }
        if (super.getCurrentPageSourceKeyList() != null) {
            arrayList = new ArrayList(super.getCurrentPageSourceKeyList());
        } else {
            arrayList = new ArrayList();
        }
        if (!"a001".equals(com.baidu.tbadk.core.util.v.f(arrayList, arrayList.size() - 1))) {
            arrayList.add("a001");
            return arrayList;
        }
        return arrayList;
    }

    @Override // android.support.v4.app.Fragment
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

    public void fK(boolean z) {
        if (this.dEC != null) {
            this.dEC.fX(z);
        }
    }

    @Override // com.baidu.tieba.InjectPlugin.a.b
    public void a(int i, com.baidu.tieba.InjectPlugin.a.a aVar) {
        this.dED.put(i, aVar);
    }

    @Override // com.baidu.tieba.InjectPlugin.a.b
    public com.baidu.tieba.InjectPlugin.a.a jc(int i) {
        return this.dED.get(i);
    }

    @Override // com.baidu.tieba.InjectPlugin.a.b
    public void a(com.baidu.tieba.InjectPlugin.b bVar) {
        this.dEM.b(bVar);
    }

    public boolean avn() {
        return this.dEd;
    }

    @Override // com.baidu.tieba.frs.aj
    public void Xp() {
        if (this.dEo != null) {
            showFloatingView();
            this.dEo.getListView().scrollToPosition(0);
            this.dEo.startPullRefresh();
        }
    }

    public ForumWriteData avo() {
        if (this.dDS == null || this.dDS.bas() == null) {
            return null;
        }
        ForumData bas = this.dDS.bas();
        ForumWriteData forumWriteData = new ForumWriteData(bas.getId(), bas.getName(), bas.getPrefixData(), this.dDS.yn());
        forumWriteData.setForumLevel(bas.getUser_level());
        forumWriteData.setAvatar(this.dDS.bas().getImage_url());
        forumWriteData.specialForumType = bas.special_forum_type;
        UserData userData = this.dDS.getUserData();
        if (userData != null) {
            forumWriteData.setPrivateThread(userData.getPrivateThread());
            return forumWriteData;
        }
        return forumWriteData;
    }

    @Override // com.baidu.tieba.frs.aj
    public void En() {
        changeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // com.baidu.tieba.frs.aj
    public void setVideoThreadId(String str) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragment
    public void showLoadingView(View view, boolean z) {
        super.showLoadingView(view, z);
        this.dEo.mS(8);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragment
    public void hideLoadingView(View view) {
        super.hideLoadingView(view);
        this.dEo.mS(0);
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void showNetRefreshView(View view, String str, boolean z) {
        super.showNetRefreshView(view, str, z);
        this.dEo.mS(8);
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void showNetRefreshViewNoClick(View view, String str, boolean z) {
        super.showNetRefreshViewNoClick(view, str, z);
        this.dEo.mS(8);
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void hideNetRefreshView(View view) {
        super.hideNetRefreshView(view);
        this.dEo.mS(0);
    }

    public void avp() {
        i.c aAx;
        if (this.dEy != null && (aAx = this.dEy.aAx()) != null && aAx.fragment != null && (aAx.fragment instanceof al)) {
            ((al) aAx.fragment).auF();
        }
    }

    public void a(ContriInfo contriInfo) {
        if (this.dEX == null) {
            this.dEX = new com.baidu.tbadk.core.dialog.i(akO());
        }
        this.dEX.a(contriInfo, -1L);
    }

    public void fL(boolean z) {
        this.dEe = z;
    }

    public boolean avq() {
        return this.dEe;
    }

    public void lH(String str) {
        if (!com.baidu.tbadk.core.util.am.isEmpty(str)) {
            if (this.dEY == null) {
                this.dEY = new AddExperiencedModel(akO());
                this.dEY.a(this.dEZ);
            }
            this.dEY.bW(this.forumId, str);
        }
    }
}
