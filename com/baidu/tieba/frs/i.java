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
    public static boolean dEc = false;
    public static volatile long dEm = 0;
    public static volatile long dEn = 0;
    public static volatile int dEo = 0;
    private com.baidu.tbadk.util.r bDj;
    private com.baidu.adp.lib.e.b<TbImageView> beN;
    private com.baidu.tieba.frs.gametab.b cjU;
    private com.baidu.tieba.frs.entelechy.b dDY;
    private com.baidu.tieba.frs.entelechy.b.b dEB;
    private com.baidu.tbadk.h.a dEC;
    private com.baidu.tieba.frs.g.a dED;
    private com.baidu.tieba.frs.mc.d dEE;
    private com.baidu.tieba.frs.mc.c dEF;
    private com.baidu.tieba.frs.g.h dEG;
    private com.baidu.tieba.frs.mc.a dEH;
    private com.baidu.tieba.frs.live.a dEI;
    private j dEJ;
    public com.baidu.tieba.frs.g.c dEK;
    private com.baidu.tieba.frs.mc.e dEL;
    private int dEM;
    private View.OnTouchListener dEN;
    private com.baidu.tieba.frs.view.b dEO;
    private com.baidu.tieba.frs.g.e dEP;
    private boolean dEQ;
    private com.baidu.tieba.NEGFeedBack.a dES;
    private com.baidu.tieba.ala.a dET;
    private com.baidu.tbadk.core.dialog.i dEU;
    private AddExperiencedModel dEV;
    public bd dEd;
    private com.baidu.tieba.tbadkCore.data.e dEh;
    private VoiceManager dEk;
    private FrsModelController dEt;
    private com.baidu.tieba.frs.g.f dEu;
    private com.baidu.tieba.frs.g.i dEv;
    private com.baidu.tieba.frs.mc.f dEw;
    private com.baidu.tieba.frs.smartsort.b dEx;
    private com.baidu.tieba.frs.mc.b dEy;
    private ap dEz;
    public View mRootView;
    public boolean dDZ = false;
    private boolean dEa = false;
    private boolean dEb = false;
    public String dEe = null;
    public String mFrom = null;
    public int mFlag = 0;
    private boolean dEf = false;
    private String mThreadId = null;
    public String forumId = null;
    private int dDS = 0;
    private boolean dEg = false;
    private boolean dEi = false;
    private boolean dEj = false;
    private k dEl = null;
    public final bd bZR = null;
    private com.baidu.tieba.tbadkCore.l dDP = new com.baidu.tieba.tbadkCore.l();
    public long dpx = -1;
    public long bAw = 0;
    public long bAo = 0;
    public long createTime = 0;
    public long beginTime = -1;
    private boolean dEp = false;
    private boolean dEq = false;
    public com.baidu.tbadk.k.d dEr = null;
    private boolean dEs = true;
    private SparseArray<com.baidu.tieba.InjectPlugin.a.a> dEA = new SparseArray<>();
    private boolean cld = true;
    private boolean dER = false;
    private AddExperiencedModel.a dEW = new AddExperiencedModel.a() { // from class: com.baidu.tieba.frs.i.1
        @Override // com.baidu.tieba.share.AddExperiencedModel.a
        public void b(ContriInfo contriInfo) {
            if (contriInfo != null && contriInfo.isShowToast()) {
                i.this.a(contriInfo);
            }
        }
    };
    private HttpMessageListener dEX = new HttpMessageListener(CmdConfigHttp.CMD_PB_FLOOR_AGREE, true) { // from class: com.baidu.tieba.frs.i.12
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
    private final CustomMessageListener dEY = new CustomMessageListener(2016495) { // from class: com.baidu.tieba.frs.i.23
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getCmd() == 2016495) {
                Object data = customResponsedMessage.getData();
                if (data instanceof bd) {
                    com.baidu.tieba.frs.f.g.a(i.this.dEl, i.this.dDP, i.this.getForumId(), true, (bd) data);
                }
            }
        }
    };
    private CustomMessageListener dEZ = new CustomMessageListener(2921005) { // from class: com.baidu.tieba.frs.i.30
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (i.this.dDP != null) {
                i.this.dDP.bvX();
                if (i.this.dEl != null) {
                    i.this.dEl.amC();
                }
            }
        }
    };
    private CustomMessageListener dFa = new CustomMessageListener(2001624) { // from class: com.baidu.tieba.frs.i.31
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                Object data = customResponsedMessage.getData();
                if ((data instanceof Integer) && Integer.parseInt(data.toString()) == 1) {
                    i.this.avc();
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2003020, true));
                }
            }
        }
    };
    private final an dFb = new an() { // from class: com.baidu.tieba.frs.i.32
        @Override // com.baidu.tieba.frs.an
        public void a(int i, int i2, at atVar, ArrayList<com.baidu.adp.widget.ListView.i> arrayList) {
            i.this.auV();
            if (i.this.dEB != null) {
                i.this.dEu.gs(i.this.dEB.nh(i));
            }
            d.a aVar = new d.a();
            if (atVar != null) {
                aVar.isSuccess = atVar.errCode == 0;
                aVar.errorCode = atVar.errCode;
                aVar.errorMsg = atVar.errMsg;
                if (aVar.isSuccess) {
                    if (com.baidu.tbadk.core.util.v.E(arrayList)) {
                        i.this.dEl.XP();
                    } else if (atVar.hasMore) {
                        if (com.baidu.tbadk.core.util.v.D(i.this.dDP.getThreadList()) > 3) {
                            i.this.dEl.XN();
                        } else {
                            i.this.dEl.avY();
                        }
                    } else if (atVar.dHx) {
                        i.this.dEl.XO();
                    } else {
                        i.this.dEl.XP();
                    }
                }
            } else {
                atVar = new at();
                atVar.pn = 1;
                atVar.hasMore = false;
                atVar.dHx = false;
            }
            if (i == 1) {
                i.this.dEs = true;
                i.this.dFl.a(i.this.dEt.getType(), false, aVar);
            } else {
                i.this.a(aVar);
                if (i.this.dEt.ayU() != null) {
                    i.this.dDP = i.this.dEt.ayU();
                }
                i.this.ave();
            }
            if (i.this.dFt != null) {
                i.this.dFt.a(i, i2, atVar, arrayList);
            }
        }
    };
    private i.b dFc = new i.b() { // from class: com.baidu.tieba.frs.i.33
        @Override // com.baidu.tieba.frs.g.i.b
        public void hT(int i) {
            if (i != 1) {
                com.baidu.tieba.card.r.als().eO(false);
            }
            i.this.avh();
            com.baidu.tieba.frs.e.c.dUe.dTV = i;
            com.baidu.tieba.frs.e.c.dUe.dTW = -1;
        }
    };
    private CustomMessageListener dFd = new CustomMessageListener(2001606) { // from class: com.baidu.tieba.frs.i.34
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof Integer)) {
                i.this.dEv.nV(((Integer) customResponsedMessage.getData()).intValue());
            }
        }
    };
    private CustomMessageListener dFe = new CustomMessageListener(2001607) { // from class: com.baidu.tieba.frs.i.35
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getData() != null && ((Integer) customResponsedMessage.getData()).intValue() == 51 && i.this.dDP != null) {
                com.baidu.tieba.frs.f.i.a(i.this.dDP, i.this.getPageContext());
            }
        }
    };
    private final CustomMessageListener dFf = new CustomMessageListener(2003019) { // from class: com.baidu.tieba.frs.i.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                i.this.dEv.nT(49);
            }
        }
    };
    private final CustomMessageListener dFg = new CustomMessageListener(2001222) { // from class: com.baidu.tieba.frs.i.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            int i;
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof SignData) && i.this.dDP != null && i.this.dDP.bar() != null) {
                SignData signData = (SignData) customResponsedMessage.getData();
                int user_level = i.this.dDP.bar().getUser_level();
                if (signData.forumId != null && signData.forumId.equals(i.this.dDP.bar().getId())) {
                    i.this.dDP.d(signData);
                    i.this.dEu.g(i.this.dDP);
                    if (i.this.dEu.aAp()) {
                        i = i.this.dDP.bar().getUser_level();
                        if (user_level >= i) {
                            i++;
                        }
                    } else {
                        i = user_level;
                    }
                    TbadkCoreApplication.getInst().addSignedForum(i.this.dDP.bar().getName(), signData.sign_bonus_point, i);
                }
            }
        }
    };
    private final CustomMessageListener dFh = new CustomMessageListener(2001352) { // from class: com.baidu.tieba.frs.i.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.tbadkCore.r) && i.this.dDP != null) {
                i.this.dDP.c((com.baidu.tieba.tbadkCore.r) customResponsedMessage.getData());
                i.this.dEu.f(i.this.dDP);
                i.this.dEv.a(i.this.dDP, i.this.dEt.azw());
            }
        }
    };
    private final AntiHelper.a dFi = new AntiHelper.a() { // from class: com.baidu.tieba.frs.i.5
        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
        public void onPositiveButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
            TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c12536").s("obj_locate", aq.a.aXy));
        }

        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
        public void onNavigationButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
            TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c12535").s("obj_locate", aq.a.aXy));
        }
    };
    private CustomMessageListener chh = new CustomMessageListener(2001115) { // from class: com.baidu.tieba.frs.i.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Message<?> message;
            if (customResponsedMessage instanceof UpdateAttentionMessage) {
                UpdateAttentionMessage updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage;
                if (updateAttentionMessage.getData() != null && updateAttentionMessage.getData().toUid != null && (message = updateAttentionMessage.getmOrginalMessage()) != null && message.getTag() != null && message.getTag().equals(i.this.getPageContext().getUniqueId())) {
                    if (updateAttentionMessage.getData().biH != null) {
                        if (AntiHelper.a(i.this.getActivity(), updateAttentionMessage.getData().biH, i.this.dFi) != null) {
                            TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c12534").s("obj_locate", aq.a.aXy));
                        }
                    } else if (updateAttentionMessage.getData().apG && updateAttentionMessage.getData().isAttention) {
                        com.baidu.adp.lib.util.l.showToast(i.this.getPageContext().getPageActivity(), d.j.attention_success);
                    }
                }
            }
        }
    };
    private CustomMessageListener dFj = new CustomMessageListener(2001374) { // from class: com.baidu.tieba.frs.i.7
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof PostWriteCallBackData)) {
                i.this.dEl.c((PostWriteCallBackData) customResponsedMessage.getData());
            }
        }
    };
    private CustomMessageListener dFk = new CustomMessageListener(2001626) { // from class: com.baidu.tieba.frs.i.8
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            NewsRemindMessage newsRemindMessage;
            if (customResponsedMessage != null && (customResponsedMessage instanceof NewsRemindMessage) && customResponsedMessage.getCmd() == 2001626 && (newsRemindMessage = (NewsRemindMessage) customResponsedMessage) != null) {
                int notificationCount = newsRemindMessage.getNotificationCount() + newsRemindMessage.getMsgCount() + newsRemindMessage.getChatCount();
                boolean z = newsRemindMessage.hasMsgRemind() || newsRemindMessage.hasChatRemind() || newsRemindMessage.hasNotificationRemind();
                if (i.this.dEl != null) {
                    i.this.dEl.E(notificationCount, z);
                }
            }
        }
    };
    public final com.baidu.tieba.tbadkCore.n dFl = new com.baidu.tieba.tbadkCore.n() { // from class: com.baidu.tieba.frs.i.9
        private long startTime = 0;

        @Override // com.baidu.tieba.tbadkCore.n
        public void mQ(int i) {
            this.startTime = System.nanoTime();
            if (i.this.dEl != null) {
                switch (i) {
                    case 1:
                    case 2:
                        i.this.dEl.avM();
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
            if (i.this.cld) {
                i.this.cld = false;
                com.baidu.tieba.frs.f.g.a(i.this.dEl, i.this.dDP, i.this.getForumId(), false, null);
            }
            i.this.auV();
            i.this.dEp = true;
            if (aVar != null && aVar.isSuccess) {
                i.this.dEl.avV().gd(com.baidu.tbadk.core.util.ao.Dd().Df());
                i.dEm = 0L;
                i.dEn = 0L;
                i.dEo = 0;
            } else {
                i.dEo = 1;
            }
            if (!i.this.dEt.azA() && (i == 3 || i == 6)) {
                i.this.dEF.resetData();
            }
            long currentTimeMillis = System.currentTimeMillis();
            if (i.this.dEt.ayU() != null) {
                i.this.dDP = i.this.dEt.ayU();
            }
            if (i == 7) {
                i.this.mO(i.this.dDP.bvm());
                return;
            }
            if (i.this.dDP.yA() != null) {
                i.this.setHasMore(i.this.dDP.yA().yw());
            }
            i.this.auW();
            if (i == 4) {
                if (!i.this.dEt.azA() && TbadkCoreApplication.getInst().isRecAppExist() && i.this.dEt.azq() == 1) {
                    i.this.dDP.a(i.this);
                }
                ArrayList<com.baidu.adp.widget.ListView.i> a2 = i.this.dEF.a(false, false, i.this.dDP.getThreadList(), i.this.dEh);
                if (a2 != null) {
                    i.this.dDP.au(a2);
                    i.this.dDP.bvM();
                    i.this.dEl.a(a2, i.this.dDP);
                }
                if (i.this.dEt != null) {
                    com.baidu.tieba.frs.e.b.a(i.this.dDP, i.this.dEt.azw(), 2);
                    return;
                }
                return;
            }
            switch (i) {
                case 1:
                    i.this.dEl.avM();
                    break;
                case 2:
                    i.this.dEl.avM();
                    break;
                case 3:
                case 6:
                    if (i.this.dDP != null) {
                        i.this.dDP.bvK();
                    }
                    if (i.this.dEK != null) {
                        i.this.dEK.refresh();
                        break;
                    }
                    break;
            }
            i.this.auX();
            if (aVar == null || aVar.errorCode == 0) {
                if (i.this.dDP != null) {
                    i.this.x(false, i == 5);
                    i.this.dEl.mU(i);
                    i.dEm = (System.nanoTime() - this.startTime) / 1000000;
                    if (aVar != null) {
                        i.dEn = aVar.gXu;
                    }
                } else {
                    return;
                }
            } else if (i.this.dDP == null || com.baidu.tbadk.core.util.v.E(i.this.dDP.getThreadList())) {
                i.this.a(aVar);
            } else if (aVar.gXt) {
                i.this.showToast(i.this.getPageContext().getResources().getString(d.j.net_error_text, aVar.errorMsg, Integer.valueOf(aVar.errorCode)));
            }
            if (i.this.dDP.buS() == 1) {
                TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c11384"));
            }
            if (i.this.dpx > -1 && !i.this.dER) {
                com.baidu.tieba.frs.f.g.a(i.this.dEt, i.this.dpx);
                i.this.dpx = -1L;
                i.this.dER = true;
            }
            if (i.this.dEi && i.this.dEv.nT(49)) {
                i.this.dEi = false;
            }
            i.this.bAw = System.currentTimeMillis() - currentTimeMillis;
            System.gc();
        }

        @Override // com.baidu.tieba.tbadkCore.n
        public void b(com.baidu.tieba.tbadkCore.i iVar) {
            if (iVar != null) {
                if ("normal_page".equals(i.this.dEt.azm()) || "frs_page".equals(i.this.dEt.azm()) || "book_page".equals(i.this.dEt.azm())) {
                    i.this.a(iVar);
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001615, iVar));
                }
            }
        }
    };
    private final CustomMessageListener dFm = new CustomMessageListener(2016485) { // from class: com.baidu.tieba.frs.i.11
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tbadk.data.h) && !StringUtils.isNull(TbadkCoreApplication.getCurrentAccount())) {
                i.this.dDP.a((com.baidu.tbadk.data.h) customResponsedMessage.getData());
                i.this.dEl.avV().notifyDataSetChanged();
            }
        }
    };
    private final CustomMessageListener mMemListener = new CustomMessageListener(2001194) { // from class: com.baidu.tieba.frs.i.13
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Integer num;
            UserData userData;
            if (customResponsedMessage != null && (num = (Integer) customResponsedMessage.getData()) != null && i.this.dDP != null && (userData = i.this.dDP.getUserData()) != null) {
                userData.setIsMem(num.intValue());
                if (num.intValue() != 0) {
                    i.this.dEu.f(num);
                }
            }
        }
    };
    private final com.baidu.tieba.frs.mc.i dFn = new com.baidu.tieba.frs.mc.i() { // from class: com.baidu.tieba.frs.i.15
        @Override // com.baidu.tieba.frs.mc.i
        public void a(int i, boolean z, int i2, boolean z2, ArrayList<com.baidu.adp.widget.ListView.i> arrayList, boolean z3) {
            if (i.this.dEx != null && i.this.dEt != null && i.this.dEt.azA() && z && !z2 && !z3) {
                i.this.dEx.nJ(i2);
            }
        }
    };
    public final View.OnTouchListener bDk = new View.OnTouchListener() { // from class: com.baidu.tieba.frs.i.16
        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (i.this.dEN != null) {
                i.this.dEN.onTouch(view, motionEvent);
            }
            if (i.this.dEz != null && i.this.dEz.awp() != null) {
                i.this.dEz.awp().onTouchEvent(motionEvent);
            }
            if (i.this.cjU != null) {
                i.this.cjU.f(view, motionEvent);
            }
            if (i.this.dEu != null) {
                i.this.dEu.onTouchEvent(motionEvent);
                return false;
            }
            return false;
        }
    };
    private final CustomMessageListener dFo = new CustomMessageListener(2004507) { // from class: com.baidu.tieba.frs.i.17
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && com.baidu.tbadk.core.sharedPref.b.getInstance().getInt(TbadkCoreApplication.getCurrentAccount() + "photolive_hostLevel", -1) != -1 && i.this.dDP.bar() != null) {
                i.this.dDP.bar().setCanAddPhotoLivePost(true);
            }
        }
    };
    private final CustomMessageListener dFp = new CustomMessageListener(2016493) { // from class: com.baidu.tieba.frs.i.18
        /* JADX DEBUG: Method merged with bridge method */
        /* JADX DEBUG: Multi-variable search result rejected for r2v2, resolved type: com.baidu.tieba.frs.i */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                String str = (String) customResponsedMessage.getData();
                if (!TextUtils.isEmpty(str)) {
                    TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c11455").ab("obj_locate", "frs"));
                    com.baidu.tbadk.core.util.aw.Dt().c(i.this.getPageContext(), new String[]{str});
                }
            }
        }
    };
    public final View.OnClickListener dFq = new View.OnClickListener() { // from class: com.baidu.tieba.frs.i.22
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (i.this.dEl == null || view != i.this.dEl.avJ() || i.this.getActivity() == null) {
                if (i.this.dDP != null && i.this.dDP.bar() != null && i.this.dEl != null && view == i.this.dEl.avQ()) {
                    TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c12402").ab(ImageViewerConfig.FORUM_ID, i.this.dDP.bar().getId()).ab("uid", TbadkCoreApplication.getCurrentAccount()).ab(ImageViewerConfig.FORUM_NAME, i.this.dDP.bar().getName()));
                    if (!StringUtils.isNull(i.this.dDP.bar().getName())) {
                        i.this.sendMessage(new CustomMessage(2002001, new PostSearchActivityConfig(i.this.getPageContext().getPageActivity(), i.this.dDP.bar().getName(), i.this.dDP.bar().getId())));
                        return;
                    }
                    return;
                }
                if (view.getId() == d.g.game_activity_egg_layout && com.baidu.adp.lib.util.l.pa()) {
                    TiebaStatic.log("c10853");
                    if (i.this.dEl.avS()) {
                        i.this.dEl.avT();
                    } else {
                        String activityUrl = i.this.dDP.bar().getYuleData().AN().getActivityUrl();
                        if (!StringUtils.isNull(activityUrl)) {
                            com.baidu.tbadk.browser.b.S(i.this.getPageContext().getPageActivity(), activityUrl);
                        }
                    }
                }
                if (view == i.this.dEl.avZ() && i.this.dEt != null && i.this.dEt.hasMore()) {
                    i.this.dEl.XN();
                    i.this.WN();
                }
                if (view != null && view == i.this.dEl.avR() && ay.ba(i.this.getContext())) {
                    TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c12924").s("obj_locate", 2));
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new MessageCenterActivityConfig(i.this.getContext())));
                    return;
                }
                return;
            }
            i.this.getActivity().finish();
        }
    };
    private final RecyclerView.OnScrollListener Sb = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.frs.i.24
        private int dFw = 0;
        private int bZw = 0;

        @Override // android.support.v7.widget.RecyclerView.OnScrollListener
        public void onScrolled(RecyclerView recyclerView, int i, int i2) {
            if (i.this.dED != null) {
                i.this.dED.azW();
            }
            this.dFw = 0;
            this.bZw = 0;
            if (recyclerView != null && (recyclerView instanceof com.baidu.adp.widget.ListView.h)) {
                this.dFw = ((com.baidu.adp.widget.ListView.h) recyclerView).getFirstVisiblePosition();
                this.bZw = ((com.baidu.adp.widget.ListView.h) recyclerView).getLastVisiblePosition();
            }
            if (i.this.dEP != null) {
                i.this.dEP.b(recyclerView, this.dFw, this.bZw);
            }
            if (i.this.dDP != null && i.this.dEl != null && i.this.dEl.avV() != null) {
                i.this.dEl.bv(this.dFw, this.bZw);
            }
        }

        @Override // android.support.v7.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i) {
            if (i.this.dEu != null) {
                i.this.dEu.setScrollState(i);
            }
            if ((i == 2 || i == 1) && !i.this.dEq) {
                i.this.dEq = true;
                i.this.dEl.avX();
            }
            if (i.this.dEr == null && !i.this.avm()) {
                i.this.dEr = new com.baidu.tbadk.k.d();
                i.this.dEr.ij(1000);
            }
            if (i == 0) {
                com.baidu.tieba.card.r.als().eO(true);
                i.this.dEl.bu(this.dFw, this.bZw);
            }
            if (i.this.dEP != null) {
                i.this.dEP.onScrollStateChanged(recyclerView, i);
            }
            if (i.this.dEr != null) {
                i.this.dEr.Oc();
            }
            if (i == 0) {
                com.baidu.tieba.frs.f.g.a(i.this.dEl, i.this.dDP, i.this.getForumId(), false, null);
            }
            if (i.this.dEv != null && i == 1) {
                i.this.dEv.aAx();
            }
        }
    };
    private final b dFr = new b() { // from class: com.baidu.tieba.frs.i.25
        @Override // com.baidu.tieba.frs.b
        public void a(int i, int i2, View view, View view2, bd bdVar) {
            if (i != i.this.dEl.avV().axo()) {
                if (i != i.this.dEl.avV().axp()) {
                    if (i != i.this.dEl.avV().axr()) {
                        if (i != i.this.dEl.avV().awg()) {
                            if (i == i.this.dEl.avV().axq() && i.this.dDP != null && i.this.dDP.getUserData() != null && i.this.dDP.getUserData().isBawu()) {
                                final String bvk = i.this.dDP.bvk();
                                if (!com.baidu.tbadk.core.util.am.isEmpty(bvk) && i.this.dDP.bar() != null) {
                                    com.baidu.tieba.c.a.a(i.this.getPageContext(), i.this.dDP.bar().getId(), i.this.dDP.bar().getName(), new a.InterfaceC0136a() { // from class: com.baidu.tieba.frs.i.25.1
                                        @Override // com.baidu.tieba.c.a.InterfaceC0136a
                                        public void akM() {
                                            com.baidu.tbadk.browser.b.R(i.this.getPageContext().getPageActivity(), bvk);
                                            TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c10502").ab(ImageViewerConfig.FORUM_ID, i.this.dDP.bar().getId()).ab("uid", i.this.dDP.getUserData().getUserId()));
                                        }
                                    });
                                    return;
                                }
                                return;
                            }
                            return;
                        }
                        i.this.dEd = bdVar;
                        com.baidu.tieba.frs.f.h.a(i.this, i.this.dEd);
                        TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c10179").ab(ImageViewerConfig.FORUM_ID, i.this.getForumId()));
                        return;
                    }
                    com.baidu.tieba.frs.f.h.z(i.this);
                    TiebaStatic.log(new com.baidu.tbadk.core.util.ak(i == i.this.dEl.avV().axr() ? "c10177" : "c10244").ab(ImageViewerConfig.FORUM_ID, i.this.getForumId()));
                } else if (ay.ba(i.this.getPageContext().getPageActivity())) {
                    TiebaStatic.log("my_service_ck");
                    if (i.this.dDP != null && i.this.dDP.bar() != null) {
                        ForumData bar = i.this.dDP.bar();
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002006, new OfficalBarChatActivityConfig(i.this.getPageContext().getPageActivity(), com.baidu.adp.lib.g.b.c(bar.getId(), 0L), bar.getName(), bar.getImage_url(), 0)));
                    }
                }
            } else if (ay.ba(i.this.getActivity())) {
                TiebaStatic.log("forum_fortune_click");
                com.baidu.tieba.frs.f.h.a(i.this.getPageContext(), i.this.dDP);
            }
        }
    };
    private final NoNetworkView.a dCs = new NoNetworkView.a() { // from class: com.baidu.tieba.frs.i.26
        @Override // com.baidu.tbadk.core.view.NoNetworkView.a
        public void bu(boolean z) {
            if (i.this.dEt.azq() == 1 && z && !i.this.dEl.avl()) {
                if (i.this.dDP == null || com.baidu.tbadk.core.util.v.E(i.this.dDP.getThreadList())) {
                    i.this.hideNetRefreshView(i.this.dEl.aft());
                    i.this.showLoadingView(i.this.dEl.aft(), true);
                    i.this.dEl.fQ(false);
                    i.this.refresh();
                    return;
                }
                i.this.dEl.avM();
            }
        }
    };
    private final CustomMessageListener bjk = new CustomMessageListener(0) { // from class: com.baidu.tieba.frs.i.27
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.baidu.adp.framework.message.ResponsedMessage] */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public /* bridge */ /* synthetic */ void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            onMessage2((CustomResponsedMessage) customResponsedMessage);
        }

        /* renamed from: onMessage  reason: avoid collision after fix types in other method */
        public void onMessage2(CustomResponsedMessage customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2001118) {
                com.baidu.tieba.frs.f.c.a(customResponsedMessage, i.this.dEl, i.this.dDP);
            }
        }
    };
    private com.baidu.adp.widget.ListView.o dFs = new a();
    private an dFt = new an() { // from class: com.baidu.tieba.frs.i.28
        @Override // com.baidu.tieba.frs.an
        public void a(int i, int i2, at atVar, ArrayList<com.baidu.adp.widget.ListView.i> arrayList) {
            com.baidu.adp.lib.g.e.ns().post(new Runnable() { // from class: com.baidu.tieba.frs.i.28.1
                @Override // java.lang.Runnable
                public void run() {
                    if (i.this.dEl != null && i.this.dEl.amt()) {
                        i.this.WN();
                    }
                }
            });
        }
    };
    private CustomMessageListener dFu = new CustomMessageListener(2921033) { // from class: com.baidu.tieba.frs.i.29
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getData() != null) {
                Object data = customResponsedMessage.getData();
                if ((data instanceof String) && !TextUtils.isEmpty((String) data)) {
                    i.this.dEQ = true;
                }
            }
        }
    };

    @Override // com.baidu.tbadk.core.BaseFragment, com.baidu.tieba.frs.loadmore.a
    public /* bridge */ /* synthetic */ com.baidu.adp.base.e getPageContext() {
        return super.getPageContext();
    }

    public com.baidu.tieba.frs.entelechy.b.b auJ() {
        return this.dEB;
    }

    public com.baidu.adp.widget.ListView.o auK() {
        return this.dFs;
    }

    public com.baidu.tieba.frs.mc.d auL() {
        return this.dEE;
    }

    public com.baidu.tieba.frs.smartsort.b auM() {
        return this.dEx;
    }

    @Override // com.baidu.tieba.frs.mc.j
    public FrsModelController auN() {
        return this.dEt;
    }

    @Override // com.baidu.tieba.frs.mc.j
    public com.baidu.tieba.frs.mc.c auO() {
        return this.dEF;
    }

    @Override // com.baidu.tieba.frs.mc.j
    public com.baidu.tieba.frs.g.f auP() {
        return this.dEu;
    }

    public com.baidu.tieba.frs.g.k auQ() {
        return this.dEv;
    }

    public ap auR() {
        return this.dEz;
    }

    @Override // com.baidu.tieba.frs.mc.j
    public k auS() {
        return this.dEl;
    }

    @Override // com.baidu.tieba.frs.ao
    public String getForumId() {
        return this.forumId;
    }

    @Override // com.baidu.tieba.frs.ao, com.baidu.tieba.frs.loadmore.a
    public String getForumName() {
        return this.dEe;
    }

    public void setForumName(String str) {
        this.dEe = str;
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
        if (this.dEF == null) {
            return 1;
        }
        return this.dEF.getPn();
    }

    public int getPn() {
        if (this.dEF == null) {
            return 1;
        }
        return this.dEF.getPn();
    }

    public void setPn(int i) {
        if (this.dEF != null) {
            this.dEF.setPn(i);
        }
    }

    public void setHasMore(int i) {
        if (this.dEF != null) {
            this.dEF.setHasMore(i);
        }
    }

    public int auT() {
        if (this.dEF == null) {
            return -1;
        }
        return this.dEF.auT();
    }

    public boolean auU() {
        return this.dEj;
    }

    public String getThreadId() {
        return this.mThreadId;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(d.a aVar) {
        if (aVar == null) {
            String string = TbadkCoreApplication.getInst().getString(d.j.error_unkown_try_again);
            this.dEl.avG();
            showNetRefreshView(this.dEl.aft(), string, true);
        } else if (340001 == aVar.errorCode) {
            a(aVar, this.dDP.buP());
        } else {
            if (com.baidu.tbadk.core.util.v.E(this.dDP.getThreadList())) {
                b(aVar);
            }
            if (avm()) {
                setNetRefreshViewEmotionMarginTop(com.baidu.adp.lib.util.l.t(TbadkCoreApplication.getInst(), d.e.ds280));
            } else {
                setNetRefreshViewEmotionDefMarginTop();
            }
        }
    }

    public void a(View view, String str, boolean z, List<RecmForumInfo> list) {
        this.dEl.avG();
        this.dEl.mS(8);
        if (this.dEO == null) {
            this.dEO = new com.baidu.tieba.frs.view.b(getPageContext(), getNetRefreshListener());
        }
        this.dEO.gW(str);
        this.dEO.by(list);
        this.dEO.j(view, z);
    }

    private void a(d.a aVar, List<RecmForumInfo> list) {
        if (this.dEl != null) {
            this.dEl.avG();
            this.dEl.setTitle(this.dEe);
            a(this.dEl.aft(), aVar.errorMsg, true, list);
        }
    }

    private void b(d.a aVar) {
        this.dEl.avG();
        if (aVar.gXt) {
            showNetRefreshView(this.dEl.aft(), TbadkCoreApplication.getInst().getString(d.j.net_error_text, new Object[]{aVar.errorMsg, Integer.valueOf(aVar.errorCode)}), true);
        } else {
            showNetRefreshView(this.dEl.aft(), aVar.errorMsg, true);
        }
    }

    public void auV() {
        hideLoadingView(this.dEl.aft());
        if (!this.dEl.avl()) {
            this.dEl.fR(false);
        } else {
            this.dEl.fR(true);
        }
        if (this.dEl.avE() instanceof com.baidu.tieba.frs.tab.a) {
            ((com.baidu.tieba.frs.tab.a) this.dEl.avE()).azS();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void auW() {
        if (auT() == 0 && com.baidu.tbadk.core.util.v.E(this.dDP.buY())) {
            if (com.baidu.tbadk.core.util.v.E(this.dDP.getThreadList())) {
                this.dEl.XP();
            } else {
                this.dEl.XO();
            }
        } else if (com.baidu.tbadk.core.util.v.D(this.dDP.getThreadList()) > 3) {
            this.dEl.XN();
        } else {
            this.dEl.avY();
        }
    }

    public void a(ErrorData errorData) {
        auV();
        this.dEl.avM();
        d.a azn = this.dEt.azn();
        boolean E = com.baidu.tbadk.core.util.v.E(this.dDP.getThreadList());
        if (azn != null && E) {
            if (E) {
                if (this.dEt.azo() != 0) {
                    this.dEt.azu();
                    this.dEl.avM();
                } else {
                    a(azn);
                }
                this.dEl.y(this.dDP.bwe(), false);
                return;
            } else if (azn.gXt) {
                this.dEl.y(true, false);
                showToast(getPageContext().getResources().getString(d.j.net_error_text, azn.errorMsg, Integer.valueOf(azn.errorCode)));
                return;
            } else {
                return;
            }
        }
        a(azn);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void auX() {
        if (this.dDP == null || this.dDP.bar() != null) {
            this.dEl.avU();
        } else if (this.dDP.bar().getYuleData() != null && this.dDP.bar().getYuleData().AM()) {
            TiebaStatic.log("c10852");
            this.dEl.a(this.dDP.bar().getYuleData().AN());
        } else {
            this.dEl.avU();
        }
    }

    private void w(boolean z, boolean z2) {
        if (this.dEt != null && this.dDP != null && this.dEl != null && z) {
            if (!this.dEt.azA() && this.dEt.azq() == 1) {
                if (!this.dEt.azy()) {
                    if (TbadkCoreApplication.getInst().appResponseToIntentClass(PhotoLiveActivityConfig.class)) {
                        this.dDP.bvV();
                        this.dDP.bvO();
                    }
                    this.dDP.bvT();
                    this.dDP.bvU();
                }
                boolean z3 = false;
                if (this.dEl.avV().k(com.baidu.tieba.card.data.o.dao)) {
                    z3 = this.dDP.bvY();
                }
                if (!z3) {
                    this.dDP.bvW();
                }
                if (TbadkCoreApplication.getInst().isRecAppExist()) {
                    this.dDP.a(this);
                }
                if (!this.dEl.avV().k(bd.aOn)) {
                    this.dDP.bvL();
                }
                this.dDP.bvZ();
            }
            if (!this.dEl.avV().k(bd.aOn)) {
                this.dDP.bvS();
                this.dDP.bvQ();
            } else {
                this.dDP.bvR();
                this.dDP.bvP();
            }
            this.dDP.bvM();
            this.dDP.bvJ();
            if (this.dEl.avV().k(com.baidu.tieba.g.b.eaa)) {
                this.dDP.mF(z2);
            }
            if (TbadkCoreApplication.isLogin() && (!this.dEt.azA() || this.dEt.isNetFirstLoad)) {
                this.dDP.bwa();
            }
            this.dDP.bwc();
        }
    }

    public boolean auY() {
        if (this.dEu != null && this.dEt != null) {
            this.dEu.a(this.dEt.azm(), this.dDP);
        }
        boolean z = false;
        if (this.dDP != null) {
            z = this.dDP.bwf();
        }
        ava();
        return z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mO(int i) {
        aq aqVar = null;
        auY();
        avh();
        try {
            if (this.dDP != null) {
                this.dEl.a((ArrayList<com.baidu.adp.widget.ListView.i>) null, this.dDP);
                this.dEu.nO(1);
                this.dEl.avP();
                this.dEv.a(this.dDP, this.dEt.azw());
                com.baidu.tieba.frs.tab.b nU = this.dEv.nU(this.dDP.bvm());
                if (nU != null && !TextUtils.isEmpty(nU.url)) {
                    aqVar = new aq();
                    aqVar.dHu = nU.url;
                    aqVar.stType = nU.name;
                }
                this.dEt.a(this.dDP.bvm(), 0, aqVar);
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void x(boolean z, boolean z2) {
        try {
            if (this.dDP != null && this.dEv != null && this.dEt != null) {
                if (!this.dEl.avV().k(bd.aOn)) {
                    this.dDP.bvL();
                }
                boolean E = com.baidu.tbadk.core.util.v.E(this.dDP.bvz());
                this.dEl.fO(E);
                if (!E) {
                    if (this.dEP == null) {
                        this.dEP = new com.baidu.tieba.frs.g.e(this, (NoPressedRelativeLayout) this.mRootView);
                    }
                    if (this.cjU == null) {
                        this.cjU = new com.baidu.tieba.frs.gametab.b(getActivity(), getBaseFragmentActivity().getUniqueId(), true);
                    }
                } else {
                    this.dEP = null;
                    this.cjU = null;
                }
                if (this.dDP.bar() != null) {
                    this.dEe = this.dDP.bar().getName();
                    this.forumId = this.dDP.bar().getId();
                }
                if (this.dDP.bwf()) {
                    this.dEv.a(this.dDP, this.dEt.azw());
                }
                if (z) {
                    w(true, z);
                } else {
                    w(this.dEs, z);
                }
                auY();
                if (this.dEB != null) {
                    this.dEB.a(this.dEu, this.dDP);
                }
                if (this.dDP.yA() != null) {
                    setHasMore(this.dDP.yA().yw());
                }
                ArrayList<com.baidu.adp.widget.ListView.i> a2 = this.dEF.a(z2, true, this.dDP.getThreadList(), null, z);
                if (a2 != null) {
                    this.dDP.au(a2);
                }
                this.dDP.bwb();
                if (this.dEt.azq() == 1) {
                    ave();
                    if (!z && this.dEt.getPn() == 1) {
                        auZ();
                    }
                }
                this.dDS = this.dDP.azs();
                if (this.dEh != null) {
                    this.dEg = true;
                    this.dEh.vI(this.dDS);
                    com.baidu.tieba.frs.f.a.a(this, this.dDP.bar(), this.dDP.getThreadList(), this.dEg, getPn());
                }
                if (this.dED != null) {
                    this.dED.bS(this.dEv.aAu());
                }
                auV();
                this.dEl.avH();
                this.dEl.y(true, false);
                if (this.dDP.bar() != null) {
                    this.dEl.lI(this.dDP.bar().getWarningMsg());
                }
                if (this.dDP != null && this.dDP.bvC() != null && com.baidu.tbadk.core.sharedPref.b.getInstance().getLong("frs_video_activity_guide", 0L) == 0) {
                    com.baidu.adp.lib.g.e.ns().postDelayed(new Runnable() { // from class: com.baidu.tieba.frs.i.10
                        @Override // java.lang.Runnable
                        public void run() {
                            i.this.dEl.awd();
                        }
                    }, 1000L);
                }
                MessageManager.getInstance().sendMessage(new CustomMessage(2921326, this));
                this.dEl.avA();
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    public void auZ() {
        if (this.dEI == null) {
            this.dEI = new com.baidu.tieba.frs.live.a(this, com.baidu.adp.lib.g.b.h(this.forumId, 0));
        }
        this.dEI.ayZ();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.tieba.tbadkCore.i iVar) {
        try {
            if (!this.dEp && iVar != null && this.dDP != null) {
                this.dDP.e(iVar);
                x(true, false);
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    private void ava() {
        if (this.dEt != null) {
            lG(this.dEt.azm());
        } else {
            lG("normal_page");
        }
    }

    private void lG(String str) {
        fJ("frs_page".equals(str));
        if (this.dEB != null) {
            this.dEB.a(this.dEu, this.dEl, this.dDP);
        }
    }

    public void fJ(boolean z) {
        if (this.dEG != null) {
            this.dEG.c(this.dEl, z);
        }
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        if (this.mRootView == null) {
            this.mRootView = layoutInflater.inflate(d.h.frs_activity, viewGroup, false);
            this.dDY = new com.baidu.tieba.frs.entelechy.b();
            this.dEB = this.dDY.awU();
            this.dEu = new com.baidu.tieba.frs.g.f(this, this.dDY, (FrsHeaderViewContainer) this.mRootView.findViewById(d.g.header_view_container));
            this.dEv = new com.baidu.tieba.frs.g.i(this, this.mRootView);
            this.dEv.a(this.dFc);
            Intent intent = getActivity().getIntent();
            if (intent != null && "main_tab".equals(intent.getStringExtra("from"))) {
                this.dEa = true;
            }
            this.dEl = new k(this, this.dFq, this.dDY, this.dEa, this.dEu);
            this.dEl.setHeaderViewHeight(this.dEM);
        } else {
            if (this.mRootView.getParent() instanceof ViewGroup) {
                ((ViewGroup) this.mRootView.getParent()).removeView(this.mRootView);
            }
            this.dEv.resetData();
            this.dEl.awc();
        }
        return this.mRootView;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        Intent intent = getActivity().getIntent();
        this.dpx = System.currentTimeMillis();
        if (intent != null) {
            this.dEi = intent.getBooleanExtra(FrsActivityConfig.ALA_IS_ONLIVING, false);
            this.dpx = intent.getLongExtra("TibaStatic.StartTime", System.currentTimeMillis());
            K(intent);
        }
        this.beginTime = System.currentTimeMillis();
        this.bAo = this.beginTime - this.dpx;
        this.dEh = new com.baidu.tieba.tbadkCore.data.e("frs", com.baidu.tieba.tbadkCore.data.e.haa);
        this.dEt = new FrsModelController(this, this.dFl);
        this.dEt.a(this.dFb);
        this.dEt.init();
        if (intent != null) {
            this.dEt.l(intent.getExtras());
        } else if (bundle != null) {
            this.dEt.l(bundle);
        } else {
            this.dEt.l(null);
        }
        if (intent != null) {
            this.dEu.o(intent.getExtras());
        } else if (bundle != null) {
            this.dEu.o(bundle);
        } else {
            this.dEu.o((Bundle) null);
        }
        this.dEk = getVoiceManager();
        this.dEJ = new j(getPageContext(), this);
        initUI();
        initData(bundle);
        if (this.mFrom != null && this.mFrom.equals("from_tieba_kuang")) {
            TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c12264").s("obj_type", 1).ab(ImageViewerConfig.FORUM_NAME, this.dEt.getForumName()));
            KuangFloatingViewController.getInstance().setNeedShowFloatingView(true);
            if (KuangFloatingViewController.getInstance().init()) {
                ((BaseFragmentActivity) getPageContext().getOrignalPage()).grantWindowPermission(new com.baidu.tbadk.core.e() { // from class: com.baidu.tieba.frs.i.14
                    @Override // com.baidu.tbadk.core.e
                    public void aS(boolean z) {
                        if (z) {
                            KuangFloatingViewController.getInstance().showFloatingView();
                        }
                    }
                });
            }
        }
        if (!avm()) {
            this.dEz = new ap(getActivity(), this.dEl, this.dEu);
            this.dEz.fX(true);
        }
        this.dEk = getVoiceManager();
        if (this.dEk != null) {
            this.dEk.onCreate(getPageContext());
        }
        new com.baidu.tieba.frs.mc.g();
        this.dEF = new com.baidu.tieba.frs.mc.c(this, this.dFn);
        this.dEx = new com.baidu.tieba.frs.smartsort.b(this);
        this.dEG = new com.baidu.tieba.frs.g.h(this);
        this.createTime = System.currentTimeMillis() - this.beginTime;
        this.dED = new com.baidu.tieba.frs.g.a(getPageContext(), this.dEt.azx());
        this.dEy = new com.baidu.tieba.frs.mc.b(this);
        this.dEE = new com.baidu.tieba.frs.mc.d(this);
        this.dEw = new com.baidu.tieba.frs.mc.f(this);
        this.dEH = new com.baidu.tieba.frs.mc.a(this);
        this.dEK = new com.baidu.tieba.frs.g.c(this);
        this.dEL = new com.baidu.tieba.frs.mc.e(this, getUniqueId());
        this.dES = new com.baidu.tieba.NEGFeedBack.a(getPageContext(), "frs");
        this.dET = new com.baidu.tieba.ala.a(getPageContext());
        registerListener(this.chh);
        registerListener(this.mMemListener);
        registerListener(this.dFh);
        registerListener(this.dFo);
        registerListener(this.dFg);
        registerListener(this.dFm);
        registerListener(this.dFd);
        registerListener(this.dFe);
        registerListener(this.dFf);
        registerListener(this.dEY);
        registerListener(this.dEZ);
        registerListener(this.dFu);
        registerListener(this.dFj);
        registerListener(this.dFa);
        registerListener(this.dFk);
        this.dEX.setTag(getPageContext().getUniqueId());
        registerListener(this.dEX);
        this.dEl.fQ(false);
        if (!avm()) {
            showLoadingView(this.dEl.aft(), true);
            this.dEt.G(3, true);
        }
        super.onActivityCreated(bundle);
    }

    @Override // com.baidu.tieba.frs.aj
    public void Xp() {
        if (isAdded() && this.cld && !isLoadingViewAttached()) {
            showLoadingView(this.dEl.aft(), true);
        }
    }

    @Override // com.baidu.tieba.frs.aj
    public void Xq() {
        if (isAdded() && this.cld && isLoadingViewAttached()) {
            hideLoadingView(this.dEl.aft());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onLazyLoad() {
        if (avm()) {
            showLoadingView(this.dEl.aft(), true);
            this.dEl.mT(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
            this.dEt.G(3, true);
            Ey().scrollToPosition(0);
        }
    }

    @Override // com.baidu.tieba.frs.aj
    public void setHeaderViewHeight(int i) {
        this.dEM = i;
        if (this.dEl != null) {
            this.dEl.setHeaderViewHeight(this.dEM);
        }
    }

    @Override // com.baidu.tieba.frs.aj
    public void setRecommendFrsNavigationAnimDispatcher(com.baidu.tbadk.util.s sVar) {
        if (sVar != null) {
            this.bDj = sVar.Pk();
            this.dEN = sVar.Pl();
        }
    }

    @Override // com.baidu.tieba.frs.aj
    public void showFloatingView() {
        if (this.bDj != null) {
            this.bDj.cG(true);
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
            this.dEe = data.getQueryParameter("name");
            this.mFrom = data.getQueryParameter("from");
            if (!StringUtils.isNull(this.dEe)) {
                intent.putExtra("name", this.dEe);
            }
            if (!StringUtils.isNull(this.mFrom)) {
                intent.putExtra("from", this.mFrom);
            }
            TiebaStatic.log("c10105");
        }
        if (StringUtils.isNull(this.dEe)) {
            this.dEe = com.baidu.tieba.frs.f.h.M(intent);
            if (!StringUtils.isNull(this.dEe)) {
                intent.putExtra("name", this.dEe);
            }
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onStart() {
        super.onStart();
        this.dEk = getVoiceManager();
        if (this.dEk != null) {
            this.dEk.onStart(getPageContext());
        }
    }

    private void initData(Bundle bundle) {
        Intent intent;
        registerListener(2001118, this.bjk);
        if (bundle != null) {
            this.dEe = bundle.getString("name");
            this.mFrom = bundle.getString("from");
            this.mFlag = bundle.getInt(FrsActivityConfig.FLAG, 0);
        } else if (getActivity() != null && (intent = getActivity().getIntent()) != null) {
            this.dEe = intent.getStringExtra("name");
            this.mFrom = intent.getStringExtra("from");
            this.mFlag = intent.getIntExtra(FrsActivityConfig.FLAG, 0);
        }
        if (TextUtils.isEmpty(this.mFrom) || FrsActivityConfig.FRS_FROM_WRITESHARE.equals(this.mFrom)) {
        }
        if (this.mIsLogin) {
            registerListener(2001120, this.bjk);
        }
        this.dEu.o(bundle);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.dFu);
        if (this.dEk != null) {
            this.dEk.onDestory(getPageContext());
        }
        this.dEk = null;
        com.baidu.tieba.card.r.als().eO(false);
        if (this.dDP != null && this.dDP.bar() != null) {
            ae.awm().bF(com.baidu.adp.lib.g.b.c(this.dDP.bar().getId(), 0L));
        }
        if (this.dEI != null) {
            this.dEI.onDestory();
        }
        if (this.dEl != null) {
            com.baidu.tieba.frs.f.g.a(this.dEl, this.dDP, getForumId(), false, null);
            this.dEl.onDestroy();
        }
        super.onDestroy();
        try {
            if (this.dEr != null) {
                this.dEr.onDestroy();
            }
            this.dEl.release();
            System.gc();
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
        this.dEt.onActivityDestroy();
        this.dEu.onActivityDestroy();
        if (this.dEt != null) {
            this.dEt.YZ();
        }
        if (this.dEz != null) {
            this.dEz.Pj();
        }
        if (this.dEC != null) {
            this.dEC.destory();
        }
        if (this.dED != null) {
            this.dED.destory();
        }
        if (this.dEx != null) {
            this.dEx.onDestroy();
        }
        if (this.dEP != null) {
            this.dEP.onDestory();
        }
        if (this.dEH != null) {
            this.dEH.onDestroy();
        }
        if (this.dES != null) {
            this.dES.onDestroy();
        }
        if (this.dET != null) {
            this.dET.onDestroy();
        }
        com.baidu.tieba.recapp.d.a.boR().boT();
        com.baidu.tieba.frs.f.i.azT();
        if (this.dEv != null) {
            this.dEv.a((i.b) null);
            this.dEv.aAx();
        }
        if (this.dEU != null) {
            this.dEU.onDestroy();
        }
        if (this.dEV != null) {
            this.dEV.onDestroy();
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putString("name", this.dEe);
        bundle.putString("from", this.mFrom);
        this.dEt.onSaveInstanceState(bundle);
        if (this.dEk != null && getPageContext() != null && getPageContext().getPageActivity() != null) {
            this.dEk.onSaveInstanceState(getPageContext().getPageActivity());
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (this.dEH != null) {
            this.dEH.onActivityResult(i, i2, intent);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        if (this.dEl != null) {
            this.dEl.avM();
            this.dEl.onResume();
        }
        this.dEw.gp(true);
        this.dEs = true;
        if (dEc) {
            dEc = false;
            this.dEl.startPullRefresh();
            return;
        }
        if (this.dEk != null) {
            this.dEk.onResume(getPageContext());
        }
        this.dEl.fS(false);
        registerListener(this.dFp);
        if (this.dEQ) {
            refresh(6);
            this.dEQ = false;
        }
        if (KuangFloatingViewController.getInstance().init()) {
            ((BaseFragmentActivity) getPageContext().getOrignalPage()).grantWindowPermission(new com.baidu.tbadk.core.e() { // from class: com.baidu.tieba.frs.i.19
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

    public boolean avb() {
        Intent intent;
        if (getActivity() == null || (intent = getActivity().getIntent()) == null) {
            return false;
        }
        return intent.getBooleanExtra(FrsActivityConfig.ALA_IS_ONLIVING, false);
    }

    public void onNewIntent(Intent intent) {
        if (intent != null) {
            if (!TextUtils.isEmpty(intent.getStringExtra("name"))) {
                this.dEe = intent.getStringExtra("name");
            }
            if (!TextUtils.isEmpty(intent.getStringExtra("from"))) {
                this.mFrom = intent.getStringExtra("from");
            }
            this.dEf = intent.getBooleanExtra(FrsActivityConfig.KEY_REFRESH, false);
            if (this.dEf) {
                avc();
            }
            if (this.mFrom != null && this.mFrom.equals("from_tieba_kuang")) {
                KuangFloatingViewController.getInstance().setNeedShowFloatingView(true);
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
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void avc() {
        this.dEl.startPullRefresh();
    }

    public void closeActivity() {
        com.baidu.tieba.frs.f.h.a(getPageContext(), getActivity() == null ? null : getActivity().getIntent(), this.mFrom);
    }

    private void initUI() {
        if (this.mFlag == 0) {
            this.dEl.setTitle(this.dEe);
        } else {
            this.dEl.setTitle("");
            this.mFlag = 1;
        }
        this.dEl.setOnAdapterItemClickListener(this.dFs);
        this.dEl.addOnScrollListener(this.Sb);
        this.dEl.h(this.dCs);
        this.dEl.avV().a(this.dFr);
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.dEl.onChangeSkinType(i);
        this.dEu.nN(i);
        this.dEv.onChangeSkinType(i);
        if (this.dEO != null) {
            this.dEO.onChangeSkinType();
        }
        if (this.dEU != null) {
            this.dEU.onChangeSkinType(i);
        }
    }

    public void mP(int i) {
        if (!this.mIsLogin) {
            if (this.dDP != null && this.dDP.yn() != null) {
                this.dDP.yn().setIfpost(1);
            }
            if (i == 0) {
                ay.aZ(getActivity());
            }
        } else if (this.dDP != null) {
            if (i == 0) {
                com.baidu.tieba.frs.f.i.b(this, 0);
            } else {
                this.dEl.avO();
            }
        }
    }

    public void refresh() {
        this.dEl.avK();
        refresh(3);
    }

    public void refresh(int i) {
        this.dEp = false;
        avh();
        if (this.dEl.avD() != null) {
            this.dEl.avD().aDZ();
        }
        this.dEt.G(i, true);
    }

    private void avd() {
        switch (this.mFlag) {
            case 1:
                com.baidu.adp.lib.g.h.nt().e(new Runnable() { // from class: com.baidu.tieba.frs.i.21
                    @Override // java.lang.Runnable
                    public void run() {
                        com.baidu.tieba.tbadkCore.util.a.sQ(i.this.dEe);
                    }
                });
                break;
        }
        this.mFlag = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ave() {
        avh();
        try {
            if (this.dDP != null) {
                this.dEl.aij();
                this.dEl.fN(this.dEt.azr());
                if (!com.baidu.tieba.frs.g.f.i(this.dDP) || !com.baidu.tieba.frs.g.f.h(this.dDP)) {
                }
                if (this.dDP.bar() != null) {
                    this.dEe = this.dDP.bar().getName();
                    this.forumId = this.dDP.bar().getId();
                }
                if (this.dDP.yA() != null) {
                    setHasMore(this.dDP.yA().yw());
                }
                this.dEl.setTitle(this.dEe);
                this.dEl.setForumName(this.dEe);
                TbadkCoreApplication.getInst().setDefaultBubble(this.dDP.getUserData().getBimg_url());
                TbadkCoreApplication.getInst().setDefaultBubbleEndTime(this.dDP.getUserData().getBimg_end_time());
                avd();
                avf();
                ArrayList<com.baidu.adp.widget.ListView.i> threadList = this.dDP.getThreadList();
                if (threadList != null) {
                    this.dEl.a(threadList, this.dDP);
                    com.baidu.tieba.frs.f.c.u(this.dEl);
                    this.dEu.nO(getPageNum());
                    this.dEu.f(this.dDP);
                    this.dEv.a(this.dDP, this.dEt.azw());
                    this.dEl.avP();
                }
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    private void avf() {
        if (this.dDP != null) {
            if (this.dDP.baG() == 1) {
                this.dEl.avV().setFromCDN(true);
            } else {
                this.dEl.avV().setFromCDN(false);
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onPause() {
        super.onPause();
        this.dEw.gp(false);
        this.dEs = false;
        this.dEl.onPause();
        if (this.dEk != null) {
            this.dEk.onPause(getPageContext());
        }
        this.dEl.fS(true);
        if (this.dED != null) {
            this.dED.azW();
        }
        MessageManager.getInstance().unRegisterListener(this.dFp);
    }

    @Override // android.support.v4.app.Fragment
    public void onStop() {
        super.onStop();
        com.baidu.tieba.card.r.als().eO(false);
        if (this.dDP != null && this.dDP.bar() != null && getPageContext() != null && getPageContext().getPageActivity() != null) {
            com.baidu.tbadk.distribute.a.KL().a(getPageContext().getPageActivity(), "frs", this.dDP.bar().getId(), 0L);
        }
        if (this.dEk != null) {
            this.dEk.onStop(getPageContext());
        }
        if (Ey() != null) {
            Ey().getRecycledViewPool().clear();
        }
        this.dEu.onActivityStop();
        com.baidu.tbadk.util.t.Pn();
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        super.onPrimary();
        if (isAdded() && this.dEu != null) {
            this.dEu.gr(isPrimary());
        }
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i != 4 || this.dEl == null) {
            return false;
        }
        return this.dEl.avL();
    }

    @Override // com.baidu.tieba.recapp.n
    public TbPageContext<?> akN() {
        return getPageContext();
    }

    @Override // com.baidu.tieba.recapp.n
    public void a(AdvertAppInfo advertAppInfo, String str) {
        com.baidu.tbadk.distribute.a.KL().a(advertAppInfo, this.forumId, 0L, "FRS", str, getPn());
    }

    @Override // com.baidu.tieba.recapp.n
    public void avg() {
        auN().avg();
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager getVoiceManager() {
        if (this.dEk == null) {
            this.dEk = VoiceManager.instance();
        }
        return this.dEk;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.core.view.UserIconBox.b
    /* renamed from: getListView */
    public com.baidu.adp.widget.ListView.h Ey() {
        if (this.dEl == null) {
            return null;
        }
        return this.dEl.getListView();
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager.b c(VoiceData.VoiceModel voiceModel) {
        return null;
    }

    public void avh() {
        if (this.dEk != null) {
            this.dEk.stopPlay();
        }
    }

    @Override // com.baidu.tbadk.core.view.UserIconBox.b
    public com.baidu.adp.lib.e.b<TbImageView> Ez() {
        if (this.beN == null) {
            this.beN = UserIconBox.w(getPageContext().getPageActivity(), 8);
        }
        return this.beN;
    }

    public void avi() {
        if (getFragmentActivity() != null && getFragmentActivity().getCurrentFocus() != null) {
            com.baidu.adp.lib.util.l.a(getFragmentActivity(), getFragmentActivity().getCurrentFocus());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public com.baidu.adp.widget.ListView.l onGetPreLoadListView() {
        return Ey().getPreLoadHandle();
    }

    @Override // com.baidu.tieba.frs.am
    public NavigationBar avj() {
        if (this.dEl == null) {
            return null;
        }
        return this.dEl.avj();
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
                if (bdUniqueId == r.dGH) {
                    if (i.this.dEl != null) {
                        TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c11752").ab(ImageViewerConfig.FORUM_ID, i.this.forumId).ab("obj_locate", "1"));
                        i.this.dEl.startPullRefresh();
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
                                            xVar.Cy().Dv().mIsNeedAddCommenParam = false;
                                            xVar.Cy().Dv().mIsUseCurrentBDUSS = false;
                                            xVar.Cb();
                                        }
                                    }).start();
                                    z = true;
                                }
                                String tid = bdVar.getTid();
                                if (tid == null) {
                                    tid = "";
                                }
                                if (bdVar.zi() == 2 && !tid.startsWith("pb:")) {
                                    com.baidu.tbadk.core.util.aw.Dt().c(i.this.getPageContext(), new String[]{tid, "", null});
                                } else if (bdVar.getThreadType() == 33 || (bdVar instanceof com.baidu.tbadk.core.data.as)) {
                                    String str = bdVar.getThreadType() == 33 ? "c10245" : "c10180";
                                    if (i.this.dEt.azq() == 5) {
                                        str = "c10387";
                                    }
                                    TiebaStatic.log(new com.baidu.tbadk.core.util.ak(str).ab(ImageViewerConfig.FORUM_ID, i.this.forumId));
                                    com.baidu.tieba.frs.f.h.b(i.this, bdVar);
                                    if (i.this.dDP != null && i.this.dDP.bar() != null) {
                                        com.baidu.tieba.frs.e.a aVar = new com.baidu.tieba.frs.e.a();
                                        aVar.dTS = i.this.dDP.gYa == 1;
                                        aVar.dTU = i.this.dDP.bar().getId();
                                        aVar.dTT = i.this.auN().azw();
                                        if (com.baidu.tieba.frs.e.c.dUe != null) {
                                            aVar.dTV = com.baidu.tieba.frs.e.c.dUe.dTV;
                                            aVar.dTW = com.baidu.tieba.frs.e.c.dUe.dTW;
                                        }
                                        com.baidu.tieba.frs.e.b.azQ().a(aVar, bdVar, 1);
                                    }
                                } else {
                                    if (tid.startsWith("pb:")) {
                                        bdVar.setId(tid.substring(3));
                                    }
                                    if (bdUniqueId.getId() == bd.aPx.getId()) {
                                        com.baidu.tieba.frs.f.g.a(bdVar.yV());
                                    } else if (bdUniqueId.getId() == bd.aOq.getId()) {
                                        com.baidu.tbadk.core.util.ak akVar = new com.baidu.tbadk.core.util.ak("c12940");
                                        akVar.ab("obj_type", "2");
                                        akVar.ab("tid", bdVar.getTid());
                                        TiebaStatic.log(akVar);
                                    }
                                    com.baidu.tieba.frs.f.h.a(i.this, bdVar, i, z);
                                    com.baidu.tieba.frs.f.g.a(i.this, i.this.dDP, bdVar);
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
            hideNetRefreshView(this.dEl.aft());
            showLoadingView(this.dEl.aft(), true);
            this.dEl.fQ(false);
            this.dEt.G(3, true);
        }
    }

    @Override // com.baidu.tieba.frs.loadmore.a
    public com.baidu.tieba.tbadkCore.l avk() {
        return this.dDP;
    }

    public boolean avl() {
        return this.dEl.avl();
    }

    public void aW(Object obj) {
        if (this.dEy != null && this.dEy.dSG != null) {
            this.dEy.dSG.ak(obj);
        }
    }

    public void aX(Object obj) {
        if (this.dEy != null && this.dEy.dSH != null) {
            this.dEy.dSH.ak(obj);
        }
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.e
    public void onScrollToBottom() {
        if (!com.baidu.adp.lib.util.l.pa()) {
            this.dEl.XP();
        } else if (this.dEt.azq() == 1) {
            Xb();
            WN();
        } else if (this.dEt.hasMore()) {
            WN();
        }
    }

    @Override // com.baidu.tieba.frs.loadmore.FrsLoadMoreModel.a
    public void lu(String str) {
        Xb();
        showToast(str);
    }

    @Override // com.baidu.tieba.frs.loadmore.FrsLoadMoreModel.a
    public void J(ArrayList<com.baidu.adp.widget.ListView.i> arrayList) {
        Xb();
        if (!com.baidu.tbadk.core.util.v.E(arrayList)) {
            if (!this.dEt.azA() && TbadkCoreApplication.getInst().isRecAppExist() && this.dEt.azq() == 1) {
                this.dDP.a(this, arrayList);
            }
            ArrayList<com.baidu.adp.widget.ListView.i> a2 = this.dEF.a(false, false, arrayList, this.dEh);
            if (a2 != null) {
                this.dDP.au(a2);
                this.dEl.a(a2, this.dDP);
            }
            if (this.dEt != null) {
                com.baidu.tieba.frs.e.b.a(this.dDP, this.dEt.azw(), 2);
            }
        }
    }

    private void Xb() {
        if (auT() == 1 || this.dEF.bv(this.dDP.buY())) {
            if (com.baidu.tbadk.core.util.v.D(this.dDP.getThreadList()) > 3) {
                this.dEl.XN();
            } else {
                this.dEl.avY();
            }
        } else if (com.baidu.tbadk.core.util.v.E(this.dDP.getThreadList())) {
            this.dEl.XP();
        } else {
            this.dEl.XO();
        }
    }

    @Override // com.baidu.tieba.frs.mc.j
    public void WN() {
        if (this.dEF != null) {
            this.dEF.a(this.dEe, this.forumId, this.dDP);
        }
    }

    public void takePhoto() {
        if (!com.baidu.tbadk.core.util.ab.e(getPageContext().getPageActivity(), 1)) {
            com.baidu.tbadk.core.util.ai.b(getPageContext());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, com.baidu.tbadk.pageStayDuration.a
    public String getCurrentPageKey() {
        return avm() ? "a034" : "a006";
    }

    @Override // com.baidu.tbadk.core.BaseFragment, com.baidu.tbadk.pageStayDuration.a
    public List<String> getCurrentPageSourceKeyList() {
        ArrayList arrayList;
        if (!avm()) {
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
        if (this.dEz != null) {
            this.dEz.fX(z);
        }
    }

    @Override // com.baidu.tieba.InjectPlugin.a.b
    public void a(int i, com.baidu.tieba.InjectPlugin.a.a aVar) {
        this.dEA.put(i, aVar);
    }

    @Override // com.baidu.tieba.InjectPlugin.a.b
    public com.baidu.tieba.InjectPlugin.a.a jc(int i) {
        return this.dEA.get(i);
    }

    @Override // com.baidu.tieba.InjectPlugin.a.b
    public void a(com.baidu.tieba.InjectPlugin.b bVar) {
        this.dEJ.b(bVar);
    }

    public boolean avm() {
        return this.dEa;
    }

    @Override // com.baidu.tieba.frs.aj
    public void Xo() {
        if (this.dEl != null) {
            showFloatingView();
            this.dEl.getListView().scrollToPosition(0);
            this.dEl.startPullRefresh();
        }
    }

    public ForumWriteData avn() {
        if (this.dDP == null || this.dDP.bar() == null) {
            return null;
        }
        ForumData bar = this.dDP.bar();
        ForumWriteData forumWriteData = new ForumWriteData(bar.getId(), bar.getName(), bar.getPrefixData(), this.dDP.yn());
        forumWriteData.setForumLevel(bar.getUser_level());
        forumWriteData.setAvatar(this.dDP.bar().getImage_url());
        forumWriteData.specialForumType = bar.special_forum_type;
        UserData userData = this.dDP.getUserData();
        if (userData != null) {
            forumWriteData.setPrivateThread(userData.getPrivateThread());
            return forumWriteData;
        }
        return forumWriteData;
    }

    @Override // com.baidu.tieba.frs.aj
    public void Em() {
        changeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // com.baidu.tieba.frs.aj
    public void setVideoThreadId(String str) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragment
    public void showLoadingView(View view, boolean z) {
        super.showLoadingView(view, z);
        this.dEl.mS(8);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragment
    public void hideLoadingView(View view) {
        super.hideLoadingView(view);
        this.dEl.mS(0);
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void showNetRefreshView(View view, String str, boolean z) {
        super.showNetRefreshView(view, str, z);
        this.dEl.mS(8);
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void showNetRefreshViewNoClick(View view, String str, boolean z) {
        super.showNetRefreshViewNoClick(view, str, z);
        this.dEl.mS(8);
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void hideNetRefreshView(View view) {
        super.hideNetRefreshView(view);
        this.dEl.mS(0);
    }

    public void avo() {
        i.c aAv;
        if (this.dEv != null && (aAv = this.dEv.aAv()) != null && aAv.fragment != null && (aAv.fragment instanceof al)) {
            ((al) aAv.fragment).auE();
        }
    }

    public void a(ContriInfo contriInfo) {
        if (this.dEU == null) {
            this.dEU = new com.baidu.tbadk.core.dialog.i(akN());
        }
        this.dEU.a(contriInfo, -1L);
    }

    public void fL(boolean z) {
        this.dEb = z;
    }

    public boolean avp() {
        return this.dEb;
    }

    public void lH(String str) {
        if (!com.baidu.tbadk.core.util.am.isEmpty(str)) {
            if (this.dEV == null) {
                this.dEV = new AddExperiencedModel(akN());
                this.dEV.a(this.dEW);
            }
            this.dEV.bW(this.forumId, str);
        }
    }
}
