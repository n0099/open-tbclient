package com.baidu.tieba.frs;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.util.SparseArray;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.widget.TextView;
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
import com.baidu.adp.widget.ListView.BdRecyclerView;
import com.baidu.card.a.a;
import com.baidu.e.a.a;
import com.baidu.live.tbadk.core.data.ConstantData;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.core.sharedpref.SharedPrefConfig;
import com.baidu.live.tbadk.core.util.CommonStatisticKey;
import com.baidu.live.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.live.tbadk.core.util.UrlSchemaHelper;
import com.baidu.tbadk.BdToken.f;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.CreateBarGuideActivityConfig;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.core.atomData.MangaBrowserActivityConfig;
import com.baidu.tbadk.core.atomData.MessageCenterActivityConfig;
import com.baidu.tbadk.core.atomData.OfficalBarChatActivityConfig;
import com.baidu.tbadk.core.atomData.TbWebViewActivityConfig;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tbadk.core.data.ErrorData;
import com.baidu.tbadk.core.data.ForumData;
import com.baidu.tbadk.core.data.PrivateForumPopInfoData;
import com.baidu.tbadk.core.data.SignData;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tbadk.core.data.VoiceData;
import com.baidu.tbadk.core.data.bg;
import com.baidu.tbadk.core.data.bh;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.util.ba;
import com.baidu.tbadk.core.util.bc;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.core.view.NoPressedRelativeLayout;
import com.baidu.tbadk.core.view.UserIconBox;
import com.baidu.tbadk.core.voice.VoiceManager;
import com.baidu.tbadk.coreExtra.message.UpdateAttentionMessage;
import com.baidu.tbadk.coreExtra.messageCenter.NewsRemindMessage;
import com.baidu.tbadk.data.VisitedForumData;
import com.baidu.tbadk.widget.FRSRefreshButton;
import com.baidu.tbadk.widget.OvalActionButton;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.NEGFeedBack.d;
import com.baidu.tieba.R;
import com.baidu.tieba.deletethread.DeleteThreadHttpResponseMessage;
import com.baidu.tieba.frs.a;
import com.baidu.tieba.frs.commontab.FrsCommonTabFragment;
import com.baidu.tieba.frs.mc.FrsModelController;
import com.baidu.tieba.frs.mc.FrsNewAreaFragment;
import com.baidu.tieba.frs.vc.FrsTabViewController;
import com.baidu.tieba.frs.view.FrsHeaderViewContainer;
import com.baidu.tieba.pb.data.ContriInfo;
import com.baidu.tieba.pb.data.PbFloorAgreeResponseMessage;
import com.baidu.tieba.share.AddExperiencedModel;
import com.baidu.tieba.tbadkCore.FrsViewData;
import com.baidu.tieba.tbadkCore.e;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import tbclient.FrsPage.RecmForumInfo;
import tbclient.FrsTabInfo;
import tbclient.WindowToast;
/* loaded from: classes4.dex */
public class FrsFragment extends BaseFragment implements BdListView.e, a.InterfaceC0055a, UserIconBox.b<BdRecyclerView>, VoiceManager.c, com.baidu.tieba.InjectPlugin.a.b, ae, ah, aj, com.baidu.tieba.frs.loadmore.a, com.baidu.tieba.frs.mc.l, com.baidu.tieba.recapp.n {
    public static com.baidu.tieba.tbadkCore.l fuB;
    private com.baidu.tbadk.util.v cOx;
    private com.baidu.adp.lib.e.b<TbImageView> crq;
    private com.baidu.tieba.frs.gametab.b dIw;
    private com.baidu.tbadk.core.dialog.a eOs;
    private com.baidu.card.z fuN;
    private FrsModelController fuO;
    private com.baidu.tieba.frs.vc.f fuP;
    private FrsTabViewController fuQ;
    private com.baidu.tieba.frs.mc.h fuR;
    private com.baidu.tieba.frs.smartsort.a fuS;
    private com.baidu.tieba.frs.mc.b fuT;
    private ak fuU;
    private com.baidu.tieba.frs.entelechy.b.b fuW;
    private com.baidu.tbadk.k.a fuX;
    private com.baidu.tieba.frs.vc.a fuY;
    private com.baidu.tieba.frs.mc.d fuZ;
    private com.baidu.tieba.frs.entelechy.a fuj;
    private com.baidu.tieba.tbadkCore.data.f fut;
    private VoiceManager fuw;
    private OvalActionButton fuy;
    private FRSRefreshButton fuz;
    private int fvE;
    private com.baidu.tieba.frs.mc.c fva;
    private com.baidu.tieba.frs.vc.h fvb;
    private com.baidu.tieba.frs.mc.a fvc;
    private com.baidu.tieba.frs.live.a fvd;
    private j fve;
    public com.baidu.tieba.frs.vc.c fvf;
    private com.baidu.tieba.frs.mc.e fvg;
    private View.OnTouchListener fvh;
    private com.baidu.tieba.frs.view.a fvi;
    private com.baidu.tieba.frs.view.c fvj;
    private com.baidu.tieba.frs.vc.e fvk;
    private boolean fvl;
    private com.baidu.tieba.NEGFeedBack.a fvn;
    private com.baidu.tieba.ala.a fvo;
    private com.baidu.tieba.frs.brand.buttommenu.a fvp;
    private com.baidu.tieba.frs.sportspage.notification.a fvq;
    private AddExperiencedModel fvr;
    private boolean fvt;
    private View mRootView;
    public static boolean fuo = false;
    public static volatile long fuD = 0;
    public static volatile long fuE = 0;
    public static volatile int fuF = 0;
    public boolean fuk = false;
    private boolean ful = false;
    private boolean fum = false;
    private boolean fun = true;
    public String fup = null;
    public String mFrom = null;
    public int mFlag = 0;
    public boolean fuq = false;
    private boolean fur = false;
    private String mThreadId = null;
    public String forumId = null;
    private int fuc = 0;
    private boolean fus = false;
    private boolean fuu = false;
    private boolean fuv = false;
    private k fux = null;
    private boolean fuA = false;
    public final bh cqG = null;
    private FrsViewData fua = new FrsViewData();
    public long faW = -1;
    public long cLq = 0;
    public long cLi = 0;
    public long createTime = 0;
    public long beginTime = -1;
    public long fuC = 0;
    public boolean fuG = false;
    private boolean fuH = false;
    private boolean fuI = false;
    public com.baidu.tbadk.p.b fuJ = null;
    private boolean fuK = true;
    private boolean fuL = true;
    private a.C0044a fuM = new a.C0044a(2);
    private SparseArray<com.baidu.tieba.InjectPlugin.a.a> fuV = new SparseArray<>();
    private boolean dxT = true;
    private boolean fvm = false;
    private boolean hasInit = false;
    private boolean fvs = false;
    private boolean fvu = false;
    private AlphaAnimation fvv = null;
    private AlphaAnimation fvw = null;
    private AddExperiencedModel.a fvx = new AddExperiencedModel.a() { // from class: com.baidu.tieba.frs.FrsFragment.1
        @Override // com.baidu.tieba.share.AddExperiencedModel.a
        public void a(ContriInfo contriInfo) {
        }
    };
    public int mHeadLineDefaultNavTabId = -1;
    private HttpMessageListener fvy = new HttpMessageListener(1001601, true) { // from class: com.baidu.tieba.frs.FrsFragment.12
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && (httpResponsedMessage instanceof PbFloorAgreeResponseMessage)) {
                PbFloorAgreeResponseMessage pbFloorAgreeResponseMessage = (PbFloorAgreeResponseMessage) httpResponsedMessage;
            }
        }
    };
    private final CustomMessageListener fvz = new CustomMessageListener(CmdConfigCustom.CMD_AD_FRS_THREAD_CLICKED) { // from class: com.baidu.tieba.frs.FrsFragment.23
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getCmd() == 2016495) {
                Object data = customResponsedMessage.getData();
                if (data instanceof bh) {
                    com.baidu.tieba.frs.f.h.a(FrsFragment.this.fux, FrsFragment.this.fua, FrsFragment.this.getForumId(), true, (bh) data);
                }
            }
        }
    };
    private CustomMessageListener fvA = new CustomMessageListener(CmdConfigCustom.CMD_CLOSE_GAME_RANK_CARD) { // from class: com.baidu.tieba.frs.FrsFragment.34
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (FrsFragment.this.fua != null) {
                FrsFragment.this.fua.removeGameRankListFromThreadList();
                if (FrsFragment.this.fux != null) {
                    FrsFragment.this.fux.aaO();
                }
            }
        }
    };
    private CustomMessageListener Fw = new CustomMessageListener(2921401) { // from class: com.baidu.tieba.frs.FrsFragment.41
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getData() != null && FrsFragment.this.fuz != null && (customResponsedMessage.getData() instanceof Integer)) {
                if (((Integer) customResponsedMessage.getData()).intValue() <= 0 || FrsFragment.this.fuQ.bqV() == 0 || FrsFragment.this.fuQ.bqS() == null || !(FrsFragment.this.fuQ.bqS().fragment instanceof BaseFragment) || !((BaseFragment) FrsFragment.this.fuQ.bqS().fragment).isPrimary()) {
                    if (FrsFragment.this.fuQ.bqV() != 0) {
                        FrsFragment.this.bkl();
                        return;
                    }
                    return;
                }
                FrsFragment.this.bkm();
            }
        }
    };
    private CustomMessageListener fvB = new CustomMessageListener(CmdConfigCustom.CMD_FRS_TAB_CLICK) { // from class: com.baidu.tieba.frs.FrsFragment.42
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                Object data = customResponsedMessage.getData();
                if ((data instanceof Integer) && Integer.parseInt(data.toString()) == 1) {
                    FrsFragment.this.bkd();
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_EXPAND_BAR_HEADER, true));
                }
            }
        }
    };
    private final ai fvC = new ai() { // from class: com.baidu.tieba.frs.FrsFragment.43
        @Override // com.baidu.tieba.frs.ai
        public void a(int i, int i2, ap apVar, ArrayList<com.baidu.adp.widget.ListView.m> arrayList) {
            FrsFragment.this.bjQ();
            if (FrsFragment.this.fuW != null) {
                FrsFragment.this.fuP.kF(FrsFragment.this.fuW.qT(i));
            }
            e.b bVar = new e.b();
            if (apVar != null) {
                bVar.isSuccess = apVar.errCode == 0;
                bVar.errorCode = apVar.errCode;
                bVar.errorMsg = apVar.errMsg;
                if (bVar.isSuccess) {
                    if (com.baidu.tbadk.core.util.v.isEmpty(arrayList)) {
                        FrsFragment.this.fux.aKi();
                    } else if (apVar.hasMore) {
                        if (com.baidu.tbadk.core.util.v.getCount(FrsFragment.this.fua.getThreadList()) > 3) {
                            FrsFragment.this.fux.aKg();
                        } else {
                            FrsFragment.this.fux.blf();
                        }
                    } else if (apVar.fyK) {
                        FrsFragment.this.fux.aKh();
                    } else {
                        FrsFragment.this.fux.aKi();
                    }
                }
            } else {
                apVar = new ap();
                apVar.pn = 1;
                apVar.hasMore = false;
                apVar.fyK = false;
            }
            if (i == 1) {
                FrsFragment.this.fuK = true;
                FrsFragment.this.fvR.a(FrsFragment.this.fuO.getType(), false, bVar);
            } else {
                FrsFragment.this.a(bVar);
                if (FrsFragment.this.fuO.boK() != null) {
                    FrsFragment.this.fua = FrsFragment.this.fuO.boK();
                }
                FrsFragment.this.bkf();
            }
            if (FrsFragment.this.fvY != null) {
                FrsFragment.this.fvY.a(i, i2, apVar, arrayList);
            }
        }
    };
    private FrsTabViewController.a fvD = new FrsTabViewController.a() { // from class: com.baidu.tieba.frs.FrsFragment.44
        @Override // com.baidu.tieba.frs.vc.FrsTabViewController.a
        public void jV(int i) {
            boolean z = false;
            if (i != 1) {
                com.baidu.tieba.card.t.bau().iK(false);
                FrsFragment.this.jD(false);
            }
            if (i == 303 && i != FrsFragment.this.fvE) {
                TiebaStatic.log(new com.baidu.tbadk.core.util.an("c13121").bS("fid", FrsFragment.this.forumId).bS("uid", TbadkCoreApplication.getCurrentAccount()));
            }
            if (i == 502) {
                FrsFragment.this.fuy.setIconFade(R.drawable.btn_frs_professional_edit_n);
            } else {
                FrsFragment.this.fuy.setIconFade(0);
            }
            FrsFragment.this.fvE = i;
            FrsFragment.this.bki();
            com.baidu.tieba.frs.d.d.fDi.fPN = i;
            com.baidu.tieba.frs.d.d.fDi.fPO = -1;
            com.baidu.tieba.frs.a biU = com.baidu.tieba.frs.a.biU();
            if (i == 1 && FrsFragment.this.fvs) {
                z = true;
            }
            biU.G(z, true);
        }
    };
    private CustomMessageListener fvF = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_FRS_LIVE_COUNT) { // from class: com.baidu.tieba.frs.FrsFragment.45
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof Integer)) {
                FrsFragment.this.fuQ.rZ(((Integer) customResponsedMessage.getData()).intValue());
            }
        }
    };
    private CustomMessageListener fvG = new CustomMessageListener(CmdConfigCustom.CMD_FRS_TAB_LIVE_START) { // from class: com.baidu.tieba.frs.FrsFragment.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getData() != null && ((Integer) customResponsedMessage.getData()).intValue() == 51 && FrsFragment.this.fua != null) {
                com.baidu.tieba.frs.f.j.a(FrsFragment.this.fua, FrsFragment.this.getPageContext());
            }
        }
    };
    private final CustomMessageListener fvH = new CustomMessageListener(CmdConfigCustom.CMD_FRS_SELECT_ALA_LIVE_TAB) { // from class: com.baidu.tieba.frs.FrsFragment.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                FrsFragment.this.fuQ.rX(49);
            }
        }
    };
    private final CustomMessageListener fvI = new CustomMessageListener(CmdConfigCustom.CMD_SIGN_REFRESH_SIGN_STATE) { // from class: com.baidu.tieba.frs.FrsFragment.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            int i;
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof SignData) && FrsFragment.this.fua != null && FrsFragment.this.fua.getForum() != null) {
                SignData signData = (SignData) customResponsedMessage.getData();
                int user_level = FrsFragment.this.fua.getForum().getUser_level();
                if (signData.forumId != null && signData.forumId.equals(FrsFragment.this.fua.getForum().getId())) {
                    FrsFragment.this.fua.updateSignData(signData);
                    FrsFragment.this.fuP.j(FrsFragment.this.fua);
                    if (FrsFragment.this.fuP.bqF()) {
                        i = FrsFragment.this.fua.getForum().getUser_level();
                        if (user_level >= i) {
                            i++;
                        }
                    } else {
                        i = user_level;
                    }
                    TbadkCoreApplication.getInst().addSignedForum(FrsFragment.this.fua.getForum().getName(), signData.sign_bonus_point, i);
                }
            }
        }
    };
    private final CustomMessageListener fvJ = new CustomMessageListener(CmdConfigCustom.CMD_FRS_EXPERIENCE_TIP) { // from class: com.baidu.tieba.frs.FrsFragment.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.tbadkCore.t) && FrsFragment.this.fua != null) {
                FrsFragment.this.fua.updateLikeData((com.baidu.tieba.tbadkCore.t) customResponsedMessage.getData());
                FrsFragment.this.fuP.i(FrsFragment.this.fua);
                FrsFragment.this.fuQ.a(FrsFragment.this.fua, FrsFragment.this.fuO.bpn());
            }
        }
    };
    private final AntiHelper.a fvK = new AntiHelper.a() { // from class: com.baidu.tieba.frs.FrsFragment.6
        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
        public void onPositiveButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
            TiebaStatic.log(new com.baidu.tbadk.core.util.an(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_POS_CLICK).O("obj_locate", at.a.LOCATE_LIKE_PERSON));
        }

        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
        public void onNavigationButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
            TiebaStatic.log(new com.baidu.tbadk.core.util.an(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_NEG_CLICK).O("obj_locate", at.a.LOCATE_LIKE_PERSON));
        }
    };
    private CustomMessageListener fvL = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_ATTENTION) { // from class: com.baidu.tieba.frs.FrsFragment.7
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Message<?> message;
            if (customResponsedMessage instanceof UpdateAttentionMessage) {
                UpdateAttentionMessage updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage;
                if (updateAttentionMessage.getData() != null && updateAttentionMessage.getData().toUid != null && (message = updateAttentionMessage.getmOrginalMessage()) != null && message.getTag() != null && message.getTag().equals(FrsFragment.this.getPageContext().getUniqueId())) {
                    if (updateAttentionMessage.getData().cvM != null) {
                        if (AntiHelper.a(FrsFragment.this.getActivity(), updateAttentionMessage.getData().cvM, FrsFragment.this.fvK) != null) {
                            TiebaStatic.log(new com.baidu.tbadk.core.util.an(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_SHOW).O("obj_locate", at.a.LOCATE_LIKE_PERSON));
                        }
                    } else if (updateAttentionMessage.getData().isSucc && updateAttentionMessage.getData().isAttention) {
                        com.baidu.adp.lib.util.l.showToast(FrsFragment.this.getPageContext().getPageActivity(), (int) R.string.attention_success);
                    }
                }
            }
        }
    };
    private CustomMessageListener fvM = new CustomMessageListener(2921346) { // from class: com.baidu.tieba.frs.FrsFragment.8
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            FrsFragment.this.refresh();
        }
    };
    private CustomMessageListener fvN = new CustomMessageListener(CmdConfigCustom.CMD_VIDEO_WRITE_POST_SUCCESS) { // from class: com.baidu.tieba.frs.FrsFragment.9
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof PostWriteCallBackData)) {
                FrsFragment.this.fux.c((PostWriteCallBackData) customResponsedMessage.getData());
            }
        }
    };
    private CustomMessageListener fvO = new CustomMessageListener(CmdConfigCustom.CMD_MESSAGE_REMIND) { // from class: com.baidu.tieba.frs.FrsFragment.10
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            NewsRemindMessage newsRemindMessage;
            if (customResponsedMessage != null && (customResponsedMessage instanceof NewsRemindMessage) && customResponsedMessage.getCmd() == 2001626 && (newsRemindMessage = (NewsRemindMessage) customResponsedMessage) != null) {
                int notificationCount = newsRemindMessage.getNotificationCount() + newsRemindMessage.getMsgCount() + newsRemindMessage.getChatCount();
                boolean z = newsRemindMessage.hasMsgRemind() || newsRemindMessage.hasChatRemind() || newsRemindMessage.hasNotificationRemind();
                if (FrsFragment.this.fux != null) {
                    FrsFragment.this.fux.C(notificationCount, z);
                }
            }
        }
    };
    private final CustomMessageListener fvP = new CustomMessageListener(2921391) { // from class: com.baidu.tieba.frs.FrsFragment.11
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (FrsFragment.this.isResumed()) {
                FrsFragment.this.bkv();
            }
        }
    };
    private CustomMessageListener fvQ = new CustomMessageListener(CmdConfigCustom.CMD_FRS_EXPAND_BAR_HEADER) { // from class: com.baidu.tieba.frs.FrsFragment.13
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Boolean)) {
                boolean booleanValue = ((Boolean) customResponsedMessage.getData()).booleanValue();
                if (FrsFragment.this.fux != null) {
                    FrsFragment.this.fux.setExpanded(booleanValue);
                }
            }
        }
    };
    public final com.baidu.tieba.tbadkCore.p fvR = new com.baidu.tieba.tbadkCore.p() { // from class: com.baidu.tieba.frs.FrsFragment.14
        private long startTime = 0;

        @Override // com.baidu.tieba.tbadkCore.p
        public void qp(int i) {
            this.startTime = System.nanoTime();
            if (FrsFragment.this.fux != null) {
                switch (i) {
                    case 1:
                    case 2:
                        FrsFragment.this.fux.bkQ();
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

        @Override // com.baidu.tieba.tbadkCore.p
        public void a(int i, boolean z, e.b bVar) {
            if (FrsFragment.this.dxT) {
                FrsFragment.this.dxT = false;
                com.baidu.tieba.frs.f.h.a(FrsFragment.this.fux, FrsFragment.this.fua, FrsFragment.this.getForumId(), false, null);
            }
            FrsFragment.this.bjQ();
            FrsFragment.this.fuH = true;
            if (bVar != null && bVar.isSuccess) {
                FrsFragment.this.fux.blc().ko(com.baidu.tbadk.core.util.ar.amM().isFrsShowBigImage());
                FrsFragment.fuD = 0L;
                FrsFragment.fuE = 0L;
                FrsFragment.fuF = 0;
            } else {
                FrsFragment.fuF = 1;
            }
            if (!FrsFragment.this.fuO.bpr() && (i == 3 || i == 6)) {
                FrsFragment.this.fva.resetData();
            }
            long currentTimeMillis = System.currentTimeMillis();
            if (FrsFragment.this.fuO.boK() != null) {
                FrsFragment.this.fua = FrsFragment.this.fuO.boK();
            }
            FrsFragment.this.fux.b(FrsFragment.this.fua.getRedpacketRainData());
            FrsFragment.this.ql(1);
            if (i == 7) {
                FrsFragment.this.qm(FrsFragment.this.fua.getFrsDefaultTabId());
                return;
            }
            if (FrsFragment.this.fua.getPage() != null) {
                FrsFragment.this.setHasMore(FrsFragment.this.fua.getPage().ahy());
            }
            if (i == 4) {
                if (!FrsFragment.this.fuO.bpr() && TbadkCoreApplication.getInst().isRecAppExist() && FrsFragment.this.fuO.bpi() == 1) {
                    FrsFragment.this.fua.addRecommendAppToThreadList(FrsFragment.this);
                }
                ArrayList<com.baidu.adp.widget.ListView.m> a2 = FrsFragment.this.fva.a(false, false, FrsFragment.this.fua.getThreadList(), FrsFragment.this.fut, false);
                if (a2 != null) {
                    FrsFragment.this.fua.setThreadList(a2);
                    FrsFragment.this.fua.checkLiveStageInThreadList();
                }
                if (FrsFragment.this.fuO != null) {
                    com.baidu.tieba.frs.d.c.a(FrsFragment.this.fua, FrsFragment.this.fuO.bpn(), 2);
                }
                com.baidu.tieba.frs.f.a.a(FrsFragment.this, FrsFragment.this.fua.getForum(), FrsFragment.this.fua.getThreadList(), false, FrsFragment.this.getPn());
                FrsFragment.this.cLq = System.currentTimeMillis() - currentTimeMillis;
                FrsFragment.this.fux.a(a2, FrsFragment.this.fua);
                FrsFragment.this.bjR();
                return;
            }
            FrsFragment.this.bjR();
            switch (i) {
                case 1:
                    FrsFragment.this.fux.bkQ();
                    break;
                case 2:
                    FrsFragment.this.fux.bkQ();
                    break;
                case 3:
                case 6:
                    if (FrsFragment.this.fua != null) {
                        FrsFragment.this.fua.clearPostThreadCount();
                    }
                    if (FrsFragment.this.fvf != null) {
                        FrsFragment.this.fvf.refresh();
                        break;
                    }
                    break;
            }
            FrsFragment.this.bjY();
            if (bVar == null || bVar.errorCode == 0) {
                if (FrsFragment.this.fua != null) {
                    FrsFragment.this.a(FrsFragment.this.fua);
                    FrsFragment.this.J(false, i == 5);
                    if (FrsFragment.this.fuO != null) {
                        if (FrsFragment.this.fua.getActivityHeadData() != null && FrsFragment.this.fua.getActivityHeadData().agU() != null && FrsFragment.this.fua.getActivityHeadData().agU().size() > 0) {
                            com.baidu.tieba.frs.d.a.a(FrsFragment.this.getUniqueId(), 1, FrsFragment.this.fua.getForum(), FrsFragment.this.fuO.getSortType(), 1);
                        }
                        if (FrsFragment.this.fua.getThreadList() != null && FrsFragment.this.fua.getThreadList().size() > 0) {
                            Iterator<com.baidu.adp.widget.ListView.m> it = FrsFragment.this.fua.getThreadList().iterator();
                            while (true) {
                                if (it.hasNext()) {
                                    com.baidu.adp.widget.ListView.m next = it.next();
                                    if ((next instanceof bh) && ((bh) next).getType() == bh.ccp) {
                                        com.baidu.tieba.frs.d.a.a(FrsFragment.this.getUniqueId(), 1, FrsFragment.this.fua.getForum(), FrsFragment.this.fuO.getSortType(), 2);
                                    }
                                }
                            }
                        }
                        com.baidu.tieba.frs.d.a.a(FrsFragment.this.getUniqueId(), FrsFragment.this.fua.getThreadList(), FrsFragment.this.fua.getForum(), FrsFragment.this.fuO.getSortType());
                    }
                    FrsFragment.this.fux.qy(i);
                    FrsFragment.fuD = (System.nanoTime() - this.startTime) / 1000000;
                    if (bVar != null) {
                        FrsFragment.fuE = bVar.jfm;
                    }
                } else {
                    return;
                }
            } else if (FrsFragment.this.fua == null || com.baidu.tbadk.core.util.v.isEmpty(FrsFragment.this.fua.getThreadList())) {
                FrsFragment.this.a(bVar);
            } else if (bVar.ffA) {
                FrsFragment.this.showToast(FrsFragment.this.getPageContext().getResources().getString(R.string.net_error_text, bVar.errorMsg, Integer.valueOf(bVar.errorCode)));
            }
            FrsFragment.this.bjV();
            FrsFragment.this.bjW();
            if (FrsFragment.this.fua.getAccessFlag() == 1) {
                TiebaStatic.log(new com.baidu.tbadk.core.util.an("c11384"));
            }
            if (FrsFragment.this.faW > -1 && !FrsFragment.this.fvm) {
                com.baidu.tieba.frs.f.h.a(FrsFragment.this.fuO, FrsFragment.this.faW);
                FrsFragment.this.faW = -1L;
                FrsFragment.this.fvm = true;
            }
            if (FrsFragment.this.fuu && FrsFragment.this.fuQ.rX(49)) {
                FrsFragment.this.fuu = false;
            }
            FrsFragment.this.cLq = System.currentTimeMillis() - currentTimeMillis;
            System.gc();
        }

        @Override // com.baidu.tieba.tbadkCore.p
        public void c(com.baidu.tieba.tbadkCore.l lVar) {
            if ((lVar != null && ("normal_page".equals(FrsFragment.this.fuO.getPageType()) || "frs_page".equals(FrsFragment.this.fuO.getPageType()) || "book_page".equals(FrsFragment.this.fuO.getPageType()))) || "brand_page".equals(FrsFragment.this.fuO.getPageType())) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_GET_FRS_PAGE_CACHE, lVar));
                FrsFragment.this.b(lVar);
                FrsFragment.fuB = lVar;
            }
        }
    };
    private final CustomMessageListener fvS = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_PENDANT) { // from class: com.baidu.tieba.frs.FrsFragment.20
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tbadk.data.l) && !StringUtils.isNull(TbadkCoreApplication.getCurrentAccount())) {
                FrsFragment.this.fua.updateCurrentUserPendant((com.baidu.tbadk.data.l) customResponsedMessage.getData());
                FrsFragment.this.fux.blc().notifyDataSetChanged();
            }
        }
    };
    private final CustomMessageListener mMemListener = new CustomMessageListener(CmdConfigCustom.CMD_RESPONSE_MEM) { // from class: com.baidu.tieba.frs.FrsFragment.21
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Integer num;
            UserData userData;
            if (customResponsedMessage != null && (num = (Integer) customResponsedMessage.getData()) != null && FrsFragment.this.fua != null && (userData = FrsFragment.this.fua.getUserData()) != null) {
                userData.setIsMem(num.intValue());
                if (num.intValue() != 0) {
                    FrsFragment.this.fuP.e(num);
                }
            }
        }
    };
    private final com.baidu.tieba.frs.mc.k fvT = new com.baidu.tieba.frs.mc.k() { // from class: com.baidu.tieba.frs.FrsFragment.26
        @Override // com.baidu.tieba.frs.mc.k
        public void a(int i, boolean z, int i2, boolean z2, ArrayList<com.baidu.adp.widget.ListView.m> arrayList, boolean z3) {
            if (FrsFragment.this.fuS != null && FrsFragment.this.fuO != null && FrsFragment.this.fuO.bpr() && z && !z2 && !z3) {
                FrsFragment.this.fuS.rz(i2);
            }
        }
    };
    public final View.OnTouchListener czy = new View.OnTouchListener() { // from class: com.baidu.tieba.frs.FrsFragment.27
        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (FrsFragment.this.fvh != null) {
                FrsFragment.this.fvh.onTouch(view, motionEvent);
            }
            if (FrsFragment.this.fuU != null && FrsFragment.this.fuU.blJ() != null) {
                FrsFragment.this.fuU.blJ().onTouchEvent(motionEvent);
            }
            if (FrsFragment.this.dIw != null) {
                FrsFragment.this.dIw.c(view, motionEvent);
            }
            if (FrsFragment.this.fuP != null) {
                FrsFragment.this.fuP.C(motionEvent);
                return false;
            }
            return false;
        }
    };
    private final CustomMessageListener fvU = new CustomMessageListener(CmdConfigCustom.CMD_GOTOLIVE_HOST_UPGRADE) { // from class: com.baidu.tieba.frs.FrsFragment.28
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && com.baidu.tbadk.core.sharedPref.b.alP().getInt(TbadkCoreApplication.getCurrentAccount() + SharedPrefConfig.PHOTOLIVE_HOSTLEVEL, -1) != -1 && FrsFragment.this.fua.getForum() != null) {
                FrsFragment.this.fua.getForum().setCanAddPhotoLivePost(true);
            }
        }
    };
    public final View.OnClickListener fvV = new View.OnClickListener() { // from class: com.baidu.tieba.frs.FrsFragment.30
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (FrsFragment.this.fux == null || view != FrsFragment.this.fux.bkO() || FrsFragment.this.getActivity() == null) {
                if (FrsFragment.this.fua != null && FrsFragment.this.fua.getForum() != null && FrsFragment.this.fux != null && view == FrsFragment.this.fux.bkU()) {
                    if (FrsFragment.this.fvj == null) {
                        FrsFragment.this.fvj = new com.baidu.tieba.frs.view.c(FrsFragment.this.getPageContext());
                    }
                    FrsFragment.this.fvj.m(FrsFragment.this.fua);
                    FrsFragment.this.fvj.showDialog();
                    return;
                }
                if (view.getId() == R.id.game_activity_egg_layout && com.baidu.adp.lib.util.l.isNetOk()) {
                    TiebaStatic.log(TbadkCoreStatisticKey.YULE_GAME_EAST_EGG_CLICK);
                    if (FrsFragment.this.fux.bkZ()) {
                        FrsFragment.this.fux.bla();
                    } else {
                        String activityUrl = FrsFragment.this.fua.getForum().getYuleData().akI().getActivityUrl();
                        if (!StringUtils.isNull(activityUrl)) {
                            com.baidu.tbadk.browser.a.startInternalWebActivity(FrsFragment.this.getPageContext().getPageActivity(), activityUrl);
                        }
                    }
                }
                if (view == FrsFragment.this.fux.blg() && FrsFragment.this.fuO != null && FrsFragment.this.fuO.hasMore()) {
                    FrsFragment.this.fux.aKg();
                    FrsFragment.this.aIU();
                }
                if (view != null && view == FrsFragment.this.fux.bkW() && bc.checkUpIsLogin(FrsFragment.this.getContext())) {
                    TiebaStatic.log(new com.baidu.tbadk.core.util.an(CommonStatisticKey.MESSAGE_ENTER_ICON_CLICK).O("obj_locate", 2));
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new MessageCenterActivityConfig(FrsFragment.this.getContext())));
                    return;
                }
                return;
            }
            CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(CmdConfigCustom.CMD_CLICK_CLOSE_GAME_FRS_CONFIRM);
            customResponsedMessage.setmOrginalMessage(new CustomMessage((int) CmdConfigCustom.CMD_GAME_FRS_TAB_CHANGE, FrsFragment.this.getPageContext().getUniqueId()));
            MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
        }
    };
    private final RecyclerView.OnScrollListener mScrollListener = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.frs.FrsFragment.31
        private int fwh = 0;
        private int duA = 0;

        @Override // android.support.v7.widget.RecyclerView.OnScrollListener
        public void onScrolled(RecyclerView recyclerView, int i, int i2) {
            if (FrsFragment.this.fuY != null) {
                FrsFragment.this.fuY.bqf();
            }
            this.fwh = 0;
            this.duA = 0;
            if (recyclerView != null && (recyclerView instanceof BdRecyclerView)) {
                this.fwh = ((BdRecyclerView) recyclerView).getFirstVisiblePosition();
                this.duA = ((BdRecyclerView) recyclerView).getLastVisiblePosition();
            }
            if (FrsFragment.this.fvk != null) {
                FrsFragment.this.fvk.a(recyclerView, this.fwh, this.duA);
            }
            if (FrsFragment.this.fua != null && FrsFragment.this.fux != null && FrsFragment.this.fux.blc() != null) {
                FrsFragment.this.fux.bm(this.fwh, this.duA);
                if (FrsFragment.this.fuN != null && FrsFragment.this.fuN.lV() != null) {
                    FrsFragment.this.fuN.lV().b(FrsFragment.this.fuM);
                }
            }
        }

        @Override // android.support.v7.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i) {
            if (FrsFragment.this.fuP != null) {
                FrsFragment.this.fuP.setScrollState(i);
            }
            if (i == 0) {
                FrsFragment.this.fux.blk();
            }
            if ((i == 2 || i == 1) && !FrsFragment.this.fuI) {
                FrsFragment.this.fuI = true;
                FrsFragment.this.fux.ble();
            }
            if (FrsFragment.this.fuJ == null && !FrsFragment.this.bkp()) {
                FrsFragment.this.fuJ = new com.baidu.tbadk.p.b();
                FrsFragment.this.fuJ.setSubType(1000);
            }
            if (i == 0) {
                if (FrsFragment.this.fuJ != null) {
                    FrsFragment.this.fuJ.awC();
                }
                com.baidu.tieba.card.t.bau().iK(true);
                FrsFragment.this.jD(true);
                FrsFragment.this.fux.bl(this.fwh, this.duA);
            } else if (FrsFragment.this.fuJ != null) {
                FrsFragment.this.fuJ.awB();
            }
            if (FrsFragment.this.fvk != null) {
                FrsFragment.this.fvk.onScrollStateChanged(recyclerView, i);
            }
            if (i == 0) {
                com.baidu.tieba.frs.f.h.a(FrsFragment.this.fux, FrsFragment.this.fua, FrsFragment.this.getForumId(), false, null);
            }
            if (FrsFragment.this.fuQ != null && i == 1) {
                FrsFragment.this.fuQ.bqU();
            }
            if (FrsFragment.this.fuN == null) {
                if (FrsFragment.this.fux.bkH() != null && !FrsFragment.this.fux.bko() && FrsFragment.this.fux.bkH().cck() != null && (FrsFragment.this.fux.bkH().cck().getTag() instanceof com.baidu.card.z)) {
                    FrsFragment.this.fuN = (com.baidu.card.z) FrsFragment.this.fux.bkH().cck().getTag();
                }
            } else if (i == 0 && FrsFragment.this.fux.bkH() != null && !FrsFragment.this.fux.bko() && FrsFragment.this.fux.bkH().cck() != null && (FrsFragment.this.fux.bkH().cck().getTag() instanceof com.baidu.card.z)) {
                FrsFragment.this.fuN = (com.baidu.card.z) FrsFragment.this.fux.bkH().cck().getTag();
            }
            if (i == 1) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921418));
            }
        }
    };
    private final d fvW = new d() { // from class: com.baidu.tieba.frs.FrsFragment.32
        @Override // com.baidu.tieba.frs.d
        public void a(int i, int i2, View view, View view2, bh bhVar) {
            if (i != FrsFragment.this.fux.blc().bmZ()) {
                if (i != FrsFragment.this.fux.blc().bna()) {
                    if (i == FrsFragment.this.fux.blc().bmX() && FrsFragment.this.fua != null && FrsFragment.this.fua.getUserData() != null && FrsFragment.this.fua.getUserData().isBawu()) {
                        String bawuCenterUrl = FrsFragment.this.fua.getBawuCenterUrl();
                        if (!com.baidu.tbadk.core.util.aq.isEmpty(bawuCenterUrl) && FrsFragment.this.fua.getForum() != null) {
                            com.baidu.tbadk.browser.a.startWebActivity(FrsFragment.this.getPageContext().getPageActivity(), bawuCenterUrl);
                            TiebaStatic.log(new com.baidu.tbadk.core.util.an("c10502").bS("fid", FrsFragment.this.fua.getForum().getId()).bS("uid", FrsFragment.this.fua.getUserData().getUserId()));
                        }
                    }
                } else if (bc.checkUpIsLogin(FrsFragment.this.getPageContext().getPageActivity())) {
                    TiebaStatic.log(CommonStatisticKey.MY_SERVICE_CK);
                    if (FrsFragment.this.fua != null && FrsFragment.this.fua.getForum() != null) {
                        ForumData forum = FrsFragment.this.fua.getForum();
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_OFFICIAL_BAR_CHAT, new OfficalBarChatActivityConfig(FrsFragment.this.getPageContext().getPageActivity(), com.baidu.adp.lib.g.b.toLong(forum.getId(), 0L), forum.getName(), forum.getImage_url(), 0)));
                    }
                }
            } else if (bc.checkUpIsLogin(FrsFragment.this.getActivity())) {
                TiebaStatic.log("forum_fortune_click");
                com.baidu.tieba.frs.f.i.b(FrsFragment.this.getPageContext(), FrsFragment.this.fua);
            }
        }
    };
    private final NoNetworkView.a fsc = new NoNetworkView.a() { // from class: com.baidu.tieba.frs.FrsFragment.33
        @Override // com.baidu.tbadk.core.view.NoNetworkView.a
        public void onNetworkChange(boolean z) {
            if (FrsFragment.this.fuO.bpi() == 1 && z && !FrsFragment.this.fux.bko()) {
                if (FrsFragment.this.fua == null || com.baidu.tbadk.core.util.v.isEmpty(FrsFragment.this.fua.getThreadList())) {
                    FrsFragment.this.hideNetRefreshView(FrsFragment.this.fux.aYb());
                    FrsFragment.this.showLoadingView(FrsFragment.this.fux.aYb(), true);
                    FrsFragment.this.fux.jO(false);
                    FrsFragment.this.refresh();
                    return;
                }
                FrsFragment.this.fux.bkQ();
            }
        }
    };
    private final CustomMessageListener cwi = new CustomMessageListener(0) { // from class: com.baidu.tieba.frs.FrsFragment.35
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.baidu.adp.framework.message.ResponsedMessage] */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public /* bridge */ /* synthetic */ void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            onMessage2((CustomResponsedMessage) customResponsedMessage);
        }

        /* renamed from: onMessage  reason: avoid collision after fix types in other method */
        public void onMessage2(CustomResponsedMessage customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2001118) {
                com.baidu.tieba.frs.f.c.a(customResponsedMessage, FrsFragment.this.fux, FrsFragment.this.fua);
            }
        }
    };
    private com.baidu.adp.widget.ListView.s fvX = new a();
    private ai fvY = new ai() { // from class: com.baidu.tieba.frs.FrsFragment.37
        @Override // com.baidu.tieba.frs.ai
        public void a(int i, int i2, ap apVar, ArrayList<com.baidu.adp.widget.ListView.m> arrayList) {
            com.baidu.adp.lib.g.e.fZ().post(new Runnable() { // from class: com.baidu.tieba.frs.FrsFragment.37.1
                @Override // java.lang.Runnable
                public void run() {
                    if (FrsFragment.this.fux != null && FrsFragment.this.fux.bbu()) {
                        FrsFragment.this.aIU();
                    }
                }
            });
        }
    };
    private CustomMessageListener fvZ = new CustomMessageListener(CmdConfigCustom.CMD_MODIFY_NICKNAME_SUCCEED) { // from class: com.baidu.tieba.frs.FrsFragment.38
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getData() != null) {
                Object data = customResponsedMessage.getData();
                if ((data instanceof String) && !TextUtils.isEmpty((String) data)) {
                    FrsFragment.this.fvl = true;
                }
            }
        }
    };
    private CustomMessageListener fwa = new CustomMessageListener(2921381) { // from class: com.baidu.tieba.frs.FrsFragment.39
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof KeyEvent)) {
                KeyEvent keyEvent = (KeyEvent) customResponsedMessage.getData();
                if (keyEvent.getAction() == 0 && keyEvent.getKeyCode() == 24) {
                    if (FrsFragment.this.fuN == null && FrsFragment.this.fux.bkH() != null && !FrsFragment.this.fux.bko() && FrsFragment.this.fux.bkH().cck() != null && (FrsFragment.this.fux.bkH().cck().getTag() instanceof com.baidu.card.z)) {
                        FrsFragment.this.fuN = (com.baidu.card.z) FrsFragment.this.fux.bkH().cck().getTag();
                    }
                    if (FrsFragment.this.fuN != null && FrsFragment.this.fuN.lV() != null) {
                        FrsFragment.this.fuN.lV().b(new a.C0044a(3));
                    }
                }
            }
        }
    };
    private CustomMessageListener fwb = new CustomMessageListener(2921414) { // from class: com.baidu.tieba.frs.FrsFragment.40
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (FrsFragment.this.fux != null) {
                FrsFragment.this.fux.pC();
            }
        }
    };

    @Override // com.baidu.tbadk.core.BaseFragment, com.baidu.tieba.frs.loadmore.a
    public /* bridge */ /* synthetic */ com.baidu.adp.base.e getPageContext() {
        return super.getPageContext();
    }

    public com.baidu.tieba.frs.entelechy.b.b bjE() {
        return this.fuW;
    }

    public com.baidu.adp.widget.ListView.s bjF() {
        return this.fvX;
    }

    public com.baidu.tieba.frs.mc.d bjG() {
        return this.fuZ;
    }

    public com.baidu.tieba.frs.smartsort.a bjH() {
        return this.fuS;
    }

    @Override // com.baidu.tieba.frs.mc.l
    public FrsModelController bjI() {
        return this.fuO;
    }

    @Override // com.baidu.tieba.frs.mc.l
    public com.baidu.tieba.frs.mc.c bjJ() {
        return this.fva;
    }

    @Override // com.baidu.tieba.frs.mc.l
    public com.baidu.tieba.frs.vc.f bjK() {
        return this.fuP;
    }

    public FrsTabViewController bjL() {
        return this.fuQ;
    }

    public ak bjM() {
        return this.fuU;
    }

    public void jC(boolean z) {
        this.fvu = z;
    }

    @Override // com.baidu.tieba.frs.mc.l
    public k bjN() {
        return this.fux;
    }

    @Override // com.baidu.tieba.frs.aj
    public String getForumId() {
        return this.forumId;
    }

    @Override // com.baidu.tieba.frs.aj, com.baidu.tieba.frs.loadmore.a
    public String getForumName() {
        return this.fup;
    }

    public void setForumName(String str) {
        this.fup = str;
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
        if (this.fva == null) {
            return 1;
        }
        return this.fva.getPn();
    }

    public int getPn() {
        if (this.fva == null) {
            return 1;
        }
        return this.fva.getPn();
    }

    public void setPn(int i) {
        if (this.fva != null) {
            this.fva.setPn(i);
        }
    }

    public void setHasMore(int i) {
        if (this.fva != null) {
            this.fva.setHasMore(i);
        }
    }

    public int bjO() {
        if (this.fva == null) {
            return -1;
        }
        return this.fva.bjO();
    }

    public boolean bjP() {
        return this.fuv;
    }

    public String getThreadId() {
        return this.mThreadId;
    }

    public View getRootView() {
        return this.mRootView;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(e.b bVar) {
        if (bVar == null) {
            String string = TbadkCoreApplication.getInst().getString(R.string.error_unkown_try_again);
            this.fux.bkK();
            showNetRefreshView(this.fux.aYb(), string, true);
        } else if (340001 == bVar.errorCode) {
            a(bVar, this.fua.getRecm_forum_list());
        } else {
            if (com.baidu.tbadk.core.util.v.isEmpty(this.fua.getThreadList())) {
                b(bVar);
            }
            if (bkp()) {
                setNetRefreshViewEmotionMarginTop(com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.ds280));
            } else {
                setNetRefreshViewEmotionDefMarginTop();
            }
        }
    }

    public void a(View view, String str, boolean z, List<RecmForumInfo> list) {
        this.fux.bkK();
        this.fux.qu(8);
        if (this.fvi == null) {
            this.fvi = new com.baidu.tieba.frs.view.a(getPageContext(), getNetRefreshListener());
        }
        this.fvi.setSubText(str);
        this.fvi.cB(list);
        this.fvi.attachView(view, z);
    }

    private void a(e.b bVar, List<RecmForumInfo> list) {
        if (this.fux != null) {
            this.fux.bkK();
            this.fux.setTitle(this.fup);
            a(this.fux.aYb(), bVar.errorMsg, true, list);
        }
    }

    private void b(e.b bVar) {
        this.fux.bkK();
        if (bVar.ffA) {
            showNetRefreshView(this.fux.aYb(), TbadkCoreApplication.getInst().getString(R.string.net_error_text, new Object[]{bVar.errorMsg, Integer.valueOf(bVar.errorCode)}), true);
        } else {
            showNetRefreshView(this.fux.aYb(), bVar.errorMsg, true);
        }
    }

    public void bjQ() {
        hideLoadingView(this.fux.aYb());
        this.fux.jQ(false);
        if (this.fux.bkI() instanceof com.baidu.tieba.frs.tab.c) {
            ((com.baidu.tieba.frs.tab.c) this.fux.bkI()).bpL();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bjR() {
        if (bjO() == 0 && com.baidu.tbadk.core.util.v.isEmpty(this.fua.getThreadListIds())) {
            if (com.baidu.tbadk.core.util.v.isEmpty(this.fua.getThreadList())) {
                this.fux.aKi();
            } else {
                this.fux.aKh();
            }
        } else if (com.baidu.tbadk.core.util.v.getCount(this.fua.getThreadList()) > 3) {
            this.fux.aKg();
        } else {
            this.fux.blf();
        }
    }

    public void a(ErrorData errorData) {
        String stringExtra = getActivity().getIntent().getStringExtra("name");
        if (getActivity().getIntent().getIntExtra(FrsActivityConfig.FRS_CALL_FROM, -1) == 12 && errorData != null && errorData.error_code == 3 && !StringUtils.isNull(stringExtra) && TbadkCoreApplication.isLogin()) {
            sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new CreateBarGuideActivityConfig(getContext(), stringExtra)));
            getActivity().finish();
            return;
        }
        bjQ();
        this.fux.bkQ();
        e.b bpf = this.fuO.bpf();
        boolean isEmpty = com.baidu.tbadk.core.util.v.isEmpty(this.fua.getThreadList());
        if (bpf != null && isEmpty) {
            if (this.fuO.bpg() != 0) {
                this.fuO.bpl();
                this.fux.bkQ();
            } else {
                a(bpf);
            }
            this.fux.K(this.fua.isStarForum(), false);
            return;
        }
        a(bpf);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.tieba.tbadkCore.l lVar) {
        if (lVar != null && lVar.getEntelechyTabInfo() != null && lVar.getEntelechyTabInfo().tab != null) {
            for (FrsTabInfo frsTabInfo : lVar.getEntelechyTabInfo().tab) {
                if (frsTabInfo.tab_id.intValue() == 502 && com.baidu.tbadk.core.sharedPref.b.alP().getBoolean("first_into_tab_profession", true)) {
                    return;
                }
            }
        }
        new com.baidu.tieba.frs.ad.f(getTbPageContext()).a(lVar);
    }

    public boolean bjS() {
        return bjT() && !bjU();
    }

    private boolean bjT() {
        if (bkn() == null) {
            return false;
        }
        FrsViewData bkn = bkn();
        com.baidu.tbadk.core.data.s sVar = null;
        if (bkn.getStar() != null && !StringUtils.isNull(bkn.getStar().cnx())) {
            sVar = new com.baidu.tbadk.core.data.s();
        } else if (bkn.getActivityHeadData() != null && com.baidu.tbadk.core.util.v.getCount(bkn.getActivityHeadData().agU()) >= 1) {
            sVar = bkn.getActivityHeadData().agU().get(0);
        }
        return sVar != null;
    }

    public boolean bjU() {
        if (bkn() == null) {
            return false;
        }
        FrsViewData bkn = bkn();
        return (com.baidu.tbadk.core.util.v.isEmpty(bkn.getShowTopThreadList()) && bkn.getBusinessPromot() == null) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bjV() {
        boolean b;
        if (!bjX()) {
            final PrivateForumPopInfoData privateForumPopInfoData = new PrivateForumPopInfoData();
            privateForumPopInfoData.a(this.fua.getPrivateForumTotalInfo().getPrivatePopInfo());
            FrsPrivateCommonDialogView frsPrivateCommonDialogView = new FrsPrivateCommonDialogView(getActivity());
            if (this.fua.getPrivateForumTotalInfo().ahF().private_forum_status.intValue() == 1 && (com.baidu.tbadk.core.util.aq.isEmpty(privateForumPopInfoData.ahH()) || privateForumPopInfoData.ahK() != Integer.valueOf(this.forumId))) {
                privateForumPopInfoData.mQ("create_success");
                privateForumPopInfoData.mR(TbadkCoreApplication.getInst().getString(R.string.frs_private_create_hint));
                privateForumPopInfoData.mS("https://tieba.baidu.com/mo/q/forumtarget?fid=" + this.forumId + "&fn=" + this.fup + "&nomenu=1");
                privateForumPopInfoData.b(Integer.valueOf(this.forumId));
                b = frsPrivateCommonDialogView.b(privateForumPopInfoData);
            } else {
                b = privateForumPopInfoData.ahK() == Integer.valueOf(this.forumId) ? frsPrivateCommonDialogView.b(privateForumPopInfoData) : false;
            }
            if (b) {
                final com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getActivity());
                aVar.hW(2);
                aVar.aM(frsPrivateCommonDialogView);
                aVar.eh(false);
                frsPrivateCommonDialogView.setConfirmButton(new View.OnClickListener() { // from class: com.baidu.tieba.frs.FrsFragment.15
                    /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: com.baidu.tieba.frs.FrsFragment */
                    /* JADX WARN: Multi-variable type inference failed */
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        ba.amO().b(FrsFragment.this.getPageContext(), new String[]{privateForumPopInfoData.ahJ()});
                        aVar.dismiss();
                    }
                });
                aVar.a(new a.b() { // from class: com.baidu.tieba.frs.FrsFragment.16
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                        aVar2.dismiss();
                    }
                });
                aVar.b(getPageContext()).akM();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bjW() {
        if (bjX() || this.fua.getPrivateForumTotalInfo().ahF().private_forum_status.intValue() != 1) {
            a((Integer) null, (Integer) null, true);
        } else {
            a(this.fua.getPrivateForumTotalInfo().ahF().private_forum_audit_status, this.fua.getPrivateForumTotalInfo().ahG(), false);
        }
    }

    public void a(Integer num, Integer num2, boolean z) {
        final String str;
        final int i = 2;
        if (this.fux.bkV() != null) {
            TextView bkV = this.fux.bkV();
            if (z) {
                bkV.setVisibility(8);
                return;
            }
            if (num.intValue() == 2) {
                bkV.setText("修改实名认证信息");
                bkV.setVisibility(0);
                str = "https://tieba.baidu.com/mo/q/priforum/editinfo?fid=" + this.forumId + "&nomenu=1";
            } else if (num2.intValue() >= 0 && num2.intValue() <= 100) {
                bkV.setText("目标已完成" + String.valueOf(num2) + "%");
                bkV.setVisibility(0);
                str = "https://tieba.baidu.com/mo/q/forumtarget?fid=" + this.forumId + "&fn=" + this.fup + "&nomenu=1";
                i = 1;
            } else {
                bkV.setVisibility(8);
                i = 0;
                str = "";
            }
            bkV.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.FrsFragment.17
                /* JADX DEBUG: Multi-variable search result rejected for r1v4, resolved type: com.baidu.tieba.frs.FrsFragment */
                /* JADX WARN: Multi-variable type inference failed */
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    TiebaStatic.log(new com.baidu.tbadk.core.util.an("c13387").bS("fid", FrsFragment.this.forumId).bS("uid", TbadkCoreApplication.getCurrentAccount()).O("obj_type", i));
                    ba.amO().b(FrsFragment.this.getPageContext(), new String[]{str});
                }
            });
        }
    }

    private boolean bjX() {
        return this.fua == null || !this.fua.isPrivateForum() || this.fua.getPrivateForumTotalInfo() == null || this.fua.getPrivateForumTotalInfo().ahF() == null || this.fua.getUserData().getIs_manager() != 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ql(int i) {
        List<WindowToast> list;
        if (TbadkCoreApplication.isLogin() && this.fua != null && (list = this.fua.mWindowToast) != null && list.size() > 0) {
            int i2 = 0;
            while (true) {
                int i3 = i2;
                if (i3 < list.size()) {
                    WindowToast windowToast = list.get(i3);
                    if (windowToast == null || windowToast.toast_type.intValue() != i) {
                        i2 = i3 + 1;
                    } else if (!com.baidu.tbadk.core.util.aq.isEmpty(windowToast.toast_link)) {
                        sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new TbWebViewActivityConfig(getPageContext().getPageActivity(), "", com.baidu.tbadk.util.ad.addParamsForPageTranslucent(windowToast.toast_link), true)));
                        return;
                    } else {
                        return;
                    }
                } else {
                    return;
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bjY() {
        if (this.fua == null || this.fua.getForum() != null) {
            this.fux.blb();
        } else if (this.fua.getForum().getYuleData() != null && this.fua.getForum().getYuleData().akH()) {
            TiebaStatic.log(TbadkCoreStatisticKey.YULE_GAME_EAST_EGG_VIEW);
            this.fux.a(this.fua.getForum().getYuleData().akI());
        } else {
            this.fux.blb();
        }
    }

    private void I(boolean z, boolean z2) {
        if (this.fuO != null && this.fua != null && this.fux != null && z) {
            if (!this.fuO.bpr() && this.fuO.bpi() == 1) {
                if (!this.fuO.bpp()) {
                    this.fua.addCardVideoInfoToThreadList();
                    this.fua.addVideoInfoToThreadListInTenAndFifteenFloor();
                }
                boolean z3 = false;
                if (this.fux.blc().o(com.baidu.tieba.card.data.n.ePT)) {
                    z3 = this.fua.addHotTopicDataToThreadList();
                }
                if (!z3) {
                    this.fua.addFeedForumDataToThreadList();
                }
                if (TbadkCoreApplication.getInst().isRecAppExist()) {
                    this.fua.addRecommendAppToThreadList(this);
                }
                if (!this.fux.blc().o(bh.caS)) {
                    this.fua.removeAlaLiveThreadData();
                }
                this.fua.addSchoolRecommendToThreadList();
            }
            if (!this.fux.blc().o(bh.caS)) {
                this.fua.removeAlaInsertLiveData();
                this.fua.removeAlaStageLiveDat();
            } else {
                this.fua.addInsertLiveDataToThreadList();
                this.fua.addStageLiveDataToThreadList();
            }
            this.fua.checkLiveStageInThreadList();
            this.fua.addNoticeThreadToThreadList();
            if (this.fux.blc().o(com.baidu.tieba.h.b.fXE)) {
                this.fua.addGameRankListToThreadList(z2);
            }
            if (TbadkCoreApplication.isLogin() && (!this.fuO.bpr() || this.fuO.isNetFirstLoad)) {
                this.fua.addUserRecommendToThreadList();
            }
            this.fua.addVideoActivityToTop();
        }
    }

    public boolean bjZ() {
        if (this.fuP != null && this.fuO != null) {
            this.fuP.a(this.fuO.getPageType(), this.fua);
        }
        boolean z = false;
        if (this.fua != null) {
            z = this.fua.hasTab();
        }
        bkb();
        return z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void qm(int i) {
        am amVar = null;
        bjZ();
        bki();
        try {
            if (this.fua != null) {
                this.fux.a((ArrayList<com.baidu.adp.widget.ListView.m>) null, this.fua);
                this.fuP.rR(1);
                this.fux.bkT();
                this.fuQ.a(this.fua, this.fuO.bpn());
                com.baidu.tieba.frs.tab.d rY = this.fuQ.rY(this.fua.getFrsDefaultTabId());
                if (rY != null && !TextUtils.isEmpty(rY.url)) {
                    amVar = new am();
                    amVar.ext = rY.url;
                    amVar.stType = rY.name;
                }
                this.fuO.a(this.fua.getFrsDefaultTabId(), 0, amVar);
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void J(boolean z, boolean z2) {
        try {
            if (this.fua != null && this.fuQ != null && this.fuO != null) {
                if (!this.fux.blc().o(bh.caS)) {
                    this.fua.removeAlaLiveThreadData();
                }
                boolean isEmpty = com.baidu.tbadk.core.util.v.isEmpty(this.fua.getGameTabInfo());
                this.fux.jM(isEmpty);
                if (!isEmpty) {
                    if (this.fvk == null) {
                        this.fvk = new com.baidu.tieba.frs.vc.e(this, (NoPressedRelativeLayout) this.mRootView);
                    }
                    if (this.dIw == null) {
                        this.dIw = new com.baidu.tieba.frs.gametab.b(getActivity(), getBaseFragmentActivity().getUniqueId(), true);
                    }
                } else {
                    this.fvk = null;
                    this.dIw = null;
                }
                if (this.fua.getForum() != null) {
                    this.fup = this.fua.getForum().getName();
                    this.forumId = this.fua.getForum().getId();
                }
                if (this.fua.hasTab()) {
                    this.fuQ.a(this.fua, this.fuO.bpn());
                }
                if (z) {
                    I(true, z);
                } else {
                    I(this.fuK, z);
                }
                bjZ();
                if (this.fuW != null) {
                    this.fuW.a(this.fuP, this.fua);
                }
                if (this.fua.getPage() != null) {
                    setHasMore(this.fua.getPage().ahy());
                }
                ArrayList<com.baidu.adp.widget.ListView.m> a2 = this.fva.a(z2, true, this.fua.getThreadList(), null, z, false);
                if (a2 != null) {
                    this.fua.setThreadList(a2);
                }
                this.fua.removeRedundantUserRecommendData();
                this.fuc = this.fua.getTopThreadSize();
                if (this.fut != null) {
                    this.fus = true;
                    this.fut.zM(this.fuc);
                    com.baidu.tieba.frs.f.a.a(this, this.fua.getForum(), this.fua.getThreadList(), this.fus, getPn());
                }
                if (this.fuO.bpi() == 1) {
                    bkf();
                    if (!z && this.fuO.getPn() == 1) {
                        bka();
                    }
                }
                if (this.fuY != null) {
                    this.fuY.bV(this.fuQ.bqR());
                }
                bjQ();
                this.fux.bkL();
                this.fux.K(true, false);
                if (z && this.fua.isFirstTabEqualAllThread()) {
                    com.baidu.adp.lib.g.e.fZ().post(new Runnable() { // from class: com.baidu.tieba.frs.FrsFragment.18
                        @Override // java.lang.Runnable
                        public void run() {
                            if (!FrsFragment.this.fuH) {
                                FrsFragment.this.fux.bll();
                            }
                        }
                    });
                }
                if (this.fua.getForum() != null) {
                    this.fux.vN(this.fua.getForum().getWarningMsg());
                }
                if (this.fua != null && this.fua.getFrsVideoActivityData() != null && com.baidu.tbadk.core.sharedPref.b.alP().getLong(SharedPrefConfig.FRS_VIDEO_ACTIVITY_GUIDE, 0L) == 0) {
                    com.baidu.adp.lib.g.e.fZ().postDelayed(new Runnable() { // from class: com.baidu.tieba.frs.FrsFragment.19
                        @Override // java.lang.Runnable
                        public void run() {
                            FrsFragment.this.fux.bli();
                        }
                    }, 1000L);
                }
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_FRS_SHOW_AR_ENTRY, this));
                this.fux.bkF();
                if (this.fua != null && this.fua.getForum() != null) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_ENTER_FORUM, new VisitedForumData(this.fua.getForum().getId(), this.fua.getForum().getName(), this.fua.getForum().getImage_url(), String.valueOf(System.currentTimeMillis() / 1000), ConstantData.Forum.SPECAIL_FORUM_TYPE_LIVE.equals(this.fua.getForum().special_forum_type), this.fua.getForum().getThemeColorInfo(), this.fua.getForum().getMember_num())));
                }
                this.fvp.a(this.fua.bottomMenuList, this.fua.getForum());
                bkv();
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    public void jD(boolean z) {
        com.baidu.tieba.q.c.cni().b(getUniqueId(), z);
    }

    public void bka() {
        if (this.fvd == null) {
            this.fvd = new com.baidu.tieba.frs.live.a(this, com.baidu.adp.lib.g.b.toInt(this.forumId, 0));
        }
        this.fvd.boQ();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(com.baidu.tieba.tbadkCore.l lVar) {
        try {
            if (!this.fuH && lVar != null && this.fua != null) {
                this.fua.receiveData(lVar);
                J(true, false);
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    private void bkb() {
        if (this.fuO != null) {
            vL(this.fuO.getPageType());
        } else {
            vL("normal_page");
        }
    }

    private void vL(String str) {
        jE("frs_page".equals(str));
        if (this.fuW != null) {
            this.fuW.a(this.fuP, this.fux, this.fua);
        }
    }

    public void jE(boolean z) {
        if (this.fvb != null) {
            this.fvb.bqK();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        com.baidu.tieba.q.c.cni().v(getUniqueId());
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        if (this.mRootView == null) {
            this.mRootView = layoutInflater.inflate(R.layout.frs_activity, viewGroup, false);
            this.fuj = new com.baidu.tieba.frs.entelechy.a();
            this.fuW = this.fuj.bmE();
            this.fuP = new com.baidu.tieba.frs.vc.f(this, this.fuj, (FrsHeaderViewContainer) this.mRootView.findViewById(R.id.header_view_container));
            this.fuQ = new FrsTabViewController(this, this.mRootView);
            this.fuQ.registerListener();
            this.fuP.a(this.fuQ);
            this.fuQ.a(this.fvD);
            Intent intent = getActivity().getIntent();
            if (intent != null && "main_tab".equals(intent.getStringExtra("from"))) {
                this.ful = true;
            }
            this.fux = new k(this, this.fvV, this.fuj, this.ful, this.fuP);
            this.fvp = new com.baidu.tieba.frs.brand.buttommenu.a(getPageContext(), this.mRootView);
        } else {
            if (this.mRootView.getParent() instanceof ViewGroup) {
                ((ViewGroup) this.mRootView.getParent()).removeView(this.mRootView);
            }
            if (this.fuQ != null) {
                this.fuQ.registerListener();
            }
            this.fux.blh();
            this.mRootView.setLeft(0);
            this.mRootView.setRight(com.baidu.adp.lib.util.l.getEquipmentWidth(TbadkCoreApplication.getInst().getContext()));
        }
        this.fvt = true;
        return this.mRootView;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        ArrayList<com.baidu.adp.widget.ListView.m> arrayList = null;
        this.faW = System.currentTimeMillis();
        this.beginTime = this.faW;
        Intent intent = getActivity().getIntent();
        if (intent != null) {
            this.fuu = intent.getBooleanExtra(FrsActivityConfig.ALA_IS_ONLIVING, false);
            this.faW = intent.getLongExtra("TibaStatic.StartTime", System.currentTimeMillis());
            ap(intent);
        }
        this.cLi = this.beginTime - this.faW;
        this.fut = new com.baidu.tieba.tbadkCore.data.f("frs", com.baidu.tieba.tbadkCore.data.f.jgV);
        if (this.fuO == null) {
            this.fuO = new FrsModelController(this, this.fvR);
            this.fuO.a(this.fvC);
            this.fuO.init();
        }
        if (intent != null) {
            this.fuO.K(intent.getExtras());
        } else if (bundle != null) {
            this.fuO.K(bundle);
        } else {
            this.fuO.K(null);
        }
        if (intent != null) {
            this.fuP.Q(intent.getExtras());
        } else if (bundle != null) {
            this.fuP.Q(bundle);
        } else {
            this.fuP.Q(null);
        }
        this.fuw = getVoiceManager();
        this.fve = new j(getPageContext(), this);
        initUI();
        initData(bundle);
        if (!bkp()) {
            this.fuU = new ak(getActivity(), this.fux, this.fuP);
            this.fuU.kd(true);
        }
        this.fuw = getVoiceManager();
        if (this.fuw != null) {
            this.fuw.onCreate(getPageContext());
        }
        new com.baidu.tieba.frs.mc.i();
        int i = -1;
        if (this.fva != null && this.fva.bpb() != null) {
            i = this.fva.bpb().bjO();
            arrayList = this.fva.bpb().getDataList();
        }
        this.fva = new com.baidu.tieba.frs.mc.c(this, this.fvT);
        this.fva.bpb().setHasMore(i);
        if (arrayList != null && arrayList.size() > 0) {
            this.fva.bpb().ai(arrayList);
        }
        this.fuS = new com.baidu.tieba.frs.smartsort.a(this);
        this.fvb = new com.baidu.tieba.frs.vc.h(this);
        this.fuY = new com.baidu.tieba.frs.vc.a(getPageContext(), this.fuO.bpo());
        this.fuT = new com.baidu.tieba.frs.mc.b(this);
        this.fuZ = new com.baidu.tieba.frs.mc.d(this);
        this.fuR = new com.baidu.tieba.frs.mc.h(this);
        this.fvc = new com.baidu.tieba.frs.mc.a(this);
        this.fvf = new com.baidu.tieba.frs.vc.c(this);
        this.fvg = new com.baidu.tieba.frs.mc.e(this, getUniqueId());
        this.fvn = new com.baidu.tieba.NEGFeedBack.a(getPageContext(), "frs");
        this.fvo = new com.baidu.tieba.ala.a(getPageContext());
        this.fvq = new com.baidu.tieba.frs.sportspage.notification.a(getPageContext());
        registerListener(this.fvL);
        registerListener(this.mMemListener);
        registerListener(this.fvJ);
        registerListener(this.fvU);
        registerListener(this.fvI);
        registerListener(this.fvS);
        registerListener(this.fvF);
        registerListener(this.fvG);
        registerListener(this.fvH);
        registerListener(this.fvz);
        registerListener(this.fvA);
        registerListener(this.Fw);
        registerListener(this.fvZ);
        registerListener(this.fvN);
        registerListener(this.fvB);
        registerListener(this.fvO);
        registerListener(this.fvM);
        this.fvy.setTag(getPageContext().getUniqueId());
        registerListener(this.fvy);
        registerListener(this.fvP);
        registerListener(this.fvQ);
        this.fwa.setTag(getPageContext().getUniqueId());
        MessageManager.getInstance().registerListener(this.fwa);
        registerListener(this.fwb);
        this.fux.jO(false);
        if (!bkp() && !this.hasInit) {
            showLoadingView(this.fux.aYb(), true);
            this.fuO.E(3, false);
        }
        com.baidu.tieba.frs.a.biU().a(new a.b() { // from class: com.baidu.tieba.frs.FrsFragment.22
            @Override // com.baidu.tieba.frs.a.b
            public void H(boolean z, boolean z2) {
                if (FrsFragment.this.fux != null) {
                    FrsFragment.this.fux.qv(z ? 0 : 8);
                    if (!z2) {
                        FrsFragment.this.fvs = z;
                    }
                    if (FrsFragment.this.fux.blc() != null && FrsFragment.this.fuO != null && FrsFragment.this.fuO.bpj()) {
                        FrsFragment.this.fux.blc().notifyDataSetChanged();
                    }
                    if (FrsFragment.this.bjL() != null) {
                        FrsTabViewController.b bqS = FrsFragment.this.bjL().bqS();
                        if (bqS != null && bqS.tabId == 502 && (bqS.fragment instanceof FrsCommonTabFragment)) {
                            ((FrsCommonTabFragment) bqS.fragment).bmA();
                        } else if (bqS != null && bqS.tabId == 503 && (bqS.fragment instanceof FrsNewAreaFragment)) {
                            FrsNewAreaFragment frsNewAreaFragment = (FrsNewAreaFragment) bqS.fragment;
                            frsNewAreaFragment.bmA();
                            if (frsNewAreaFragment.bpv() != null) {
                                com.baidu.tieba.frs.mc.g bpv = frsNewAreaFragment.bpv();
                                bpv.jR(!z);
                                bpv.jS(!z);
                            }
                        }
                        if (FrsFragment.this.bjL().bqL() != null) {
                            FrsFragment.this.bjL().bqL().setmDisallowSlip(z);
                            FrsFragment.this.bjL().kH(z);
                        }
                    }
                    if (FrsFragment.this.fux.bkJ() != null) {
                        FrsFragment.this.fux.jL(!z);
                    }
                    if (FrsFragment.this.getActivity() instanceof FrsActivity) {
                        ((FrsActivity) FrsFragment.this.getActivity()).jB(!z);
                    }
                    if (FrsFragment.this.fvp != null) {
                        FrsFragment.this.fvp.kk(!z);
                    }
                    FrsFragment.this.fux.jR(!z);
                    FrsFragment.this.fux.jS(z ? false : true);
                }
            }

            @Override // com.baidu.tieba.frs.a.b
            public void qi(int i2) {
                if (FrsFragment.this.fux != null) {
                    FrsFragment.this.fux.qw(i2);
                }
            }

            @Override // com.baidu.tieba.frs.a.b
            public void bjb() {
                com.baidu.adp.lib.util.l.showToast(FrsFragment.this.getContext(), (int) R.string.frs_multi_delete_max_num);
            }
        });
        this.fux.b(new d.a() { // from class: com.baidu.tieba.frs.FrsFragment.24
            @Override // com.baidu.tieba.NEGFeedBack.d.a
            public void a(DeleteThreadHttpResponseMessage deleteThreadHttpResponseMessage) {
                boolean z;
                int i2 = 0;
                if (deleteThreadHttpResponseMessage != null) {
                    FrsFragment.this.fux.aBM();
                    FrsFragment.this.fux.blj();
                    FrsNewAreaFragment frsNewAreaFragment = null;
                    if (FrsFragment.this.fuQ == null || FrsFragment.this.fuQ.bqS() == null || !(FrsFragment.this.fuQ.bqS().fragment instanceof FrsNewAreaFragment)) {
                        z = false;
                    } else {
                        frsNewAreaFragment = (FrsNewAreaFragment) FrsFragment.this.fuQ.bqS().fragment;
                        z = true;
                    }
                    if (deleteThreadHttpResponseMessage.getError() == 0) {
                        String text = !TextUtils.isEmpty(deleteThreadHttpResponseMessage.getText()) ? deleteThreadHttpResponseMessage.getText() : FrsFragment.this.getString(R.string.delete_fail);
                        if (deleteThreadHttpResponseMessage.getRetType() == 1211066) {
                            if (FrsFragment.this.eOs == null) {
                                FrsFragment.this.eOs = new com.baidu.tbadk.core.dialog.a(FrsFragment.this.getActivity());
                            }
                            FrsFragment.this.eOs.nn(text);
                            FrsFragment.this.eOs.a(R.string.dialog_known, new a.b() { // from class: com.baidu.tieba.frs.FrsFragment.24.1
                                @Override // com.baidu.tbadk.core.dialog.a.b
                                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                                    if (aVar != null) {
                                        aVar.dismiss();
                                    }
                                }
                            });
                            FrsFragment.this.eOs.eh(false);
                            FrsFragment.this.eOs.b(FrsFragment.this.getPageContext());
                            FrsFragment.this.eOs.akM();
                        } else if (deleteThreadHttpResponseMessage.getRetType() == 1211067) {
                            if (FrsFragment.this.eOs == null) {
                                FrsFragment.this.eOs = new com.baidu.tbadk.core.dialog.a(FrsFragment.this.getActivity());
                            }
                            FrsFragment.this.eOs.nn(text);
                            FrsFragment.this.eOs.a(R.string.know, new a.b() { // from class: com.baidu.tieba.frs.FrsFragment.24.2
                                @Override // com.baidu.tbadk.core.dialog.a.b
                                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                                    if (aVar != null) {
                                        aVar.dismiss();
                                    }
                                }
                            });
                            FrsFragment.this.eOs.eh(false);
                            FrsFragment.this.eOs.b(FrsFragment.this.getPageContext());
                            FrsFragment.this.eOs.akM();
                        } else {
                            FrsFragment.this.fux.ar(deleteThreadHttpResponseMessage.getText(), ContextCompat.getColor(FrsFragment.this.getContext(), deleteThreadHttpResponseMessage.getRetType() == 1 ? R.color.nav_bar_tip_error : R.color.cp_link_tip_a_alpha95));
                        }
                        if (z && frsNewAreaFragment != null) {
                            frsNewAreaFragment.cw(deleteThreadHttpResponseMessage.getSuccessItems());
                        }
                        FrsFragment.this.cl(deleteThreadHttpResponseMessage.getSuccessItems());
                        com.baidu.tieba.frs.a.biU().ck(deleteThreadHttpResponseMessage.getSuccessItems());
                        for (com.baidu.adp.widget.ListView.m mVar : FrsFragment.this.fua.getThreadList()) {
                            if (mVar instanceof bg) {
                                i2++;
                                continue;
                            }
                            if (i2 >= 6) {
                                break;
                            }
                        }
                        if (i2 < 6) {
                            FrsFragment.this.aIU();
                            return;
                        }
                        return;
                    }
                    com.baidu.adp.lib.util.l.showToast(FrsFragment.this.getActivity(), deleteThreadHttpResponseMessage.getErrorString());
                }
            }
        });
        this.hasInit = true;
        qn(1);
        super.onActivityCreated(bundle);
        this.createTime = System.currentTimeMillis() - this.beginTime;
    }

    public void jF(boolean z) {
        if (this.fuQ != null) {
            this.fuQ.fTe = z;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cl(List<String> list) {
        if (!com.baidu.tbadk.core.util.v.isEmpty(list)) {
            ArrayList<com.baidu.adp.widget.ListView.m> threadList = this.fua.getThreadList();
            if (!com.baidu.tbadk.core.util.v.isEmpty(threadList) && this.fux.getListView() != null && this.fux.getListView().getData() != null) {
                Iterator<com.baidu.adp.widget.ListView.m> it = threadList.iterator();
                List<com.baidu.adp.widget.ListView.m> data = this.fux.getListView().getData();
                int i = 0;
                while (it.hasNext()) {
                    com.baidu.adp.widget.ListView.m next = it.next();
                    if (next instanceof bg) {
                        bh bhVar = ((bg) next).caz;
                        int i2 = 0;
                        while (true) {
                            if (i2 >= list.size()) {
                                break;
                            } else if (!com.baidu.tbadk.core.util.aq.equals(list.get(i2), bhVar.getId())) {
                                i2++;
                            } else {
                                it.remove();
                                data.remove(next);
                                this.fva.d(next);
                                this.fux.getListView().getAdapter().notifyItemRemoved(i);
                                break;
                            }
                        }
                    }
                    i++;
                }
            }
        }
    }

    @Override // com.baidu.tieba.frs.ae
    public void aJn() {
        if (isAdded() && this.dxT && !isLoadingViewAttached()) {
            showLoadingView(this.fux.aYb(), true);
        }
    }

    @Override // com.baidu.tieba.frs.ae
    public void aJo() {
        if (isAdded() && this.dxT && isLoadingViewAttached()) {
            hideLoadingView(this.fux.aYb());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onLazyLoad() {
        if (bkp()) {
            showLoadingView(this.fux.aYb(), true);
            this.fux.qx(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
            this.fuO.E(3, true);
            aod().scrollToPosition(0);
        }
    }

    private void qn(int i) {
        String str = "";
        if (this.fua != null && this.fua.getForum() != null) {
            str = this.fua.getForum().getId();
        }
        if (!StringUtils.isNull(str)) {
            TiebaStatic.log(new com.baidu.tbadk.core.util.an("c13008").bS("fid", str).bS("obj_type", "4").O("obj_locate", i).bS("uid", TbadkCoreApplication.getCurrentAccount()));
        }
    }

    @Override // com.baidu.tieba.frs.ae
    public void setRecommendFrsNavigationAnimDispatcher(com.baidu.tbadk.util.w wVar) {
        if (wVar != null) {
            this.cOx = wVar.axL();
            this.fvh = wVar.axM();
        }
    }

    @Override // com.baidu.tieba.frs.ae
    public void showFloatingView() {
        if (this.cOx != null) {
            this.cOx.fE(true);
        }
    }

    private void ap(Intent intent) {
        if (intent != null) {
            if (intent != null) {
                if (!com.baidu.tieba.frs.f.f.a(this, getForumName(), "from", intent.getBooleanExtra(FrsActivityConfig.FROM_SHORT_CUT, false)) && getActivity() != null) {
                    getActivity().finish();
                    return;
                }
            }
            if (intent != null && intent.getData() != null) {
                Uri data = intent.getData();
                this.fup = data.getQueryParameter("name");
                this.mFrom = data.getQueryParameter("from");
                if (!StringUtils.isNull(this.fup)) {
                    intent.putExtra("name", this.fup);
                }
                if (!StringUtils.isNull(this.mFrom)) {
                    intent.putExtra("from", this.mFrom);
                }
                TiebaStatic.log(TbadkCoreStatisticKey.AS_INVOKE_TIEBA);
            }
            if (StringUtils.isNull(this.fup) && intent != null && intent.getData() != null) {
                Uri data2 = intent.getData();
                if (com.baidu.tbadk.BdToken.f.k(data2)) {
                    com.baidu.tbadk.BdToken.f.aen().b(data2, new f.a() { // from class: com.baidu.tieba.frs.FrsFragment.25
                        @Override // com.baidu.tbadk.BdToken.f.a
                        public void o(HashMap<String, Object> hashMap) {
                            if (hashMap != null && (hashMap.get(com.baidu.tbadk.BdToken.f.bRy) instanceof String)) {
                                FrsFragment.this.fup = (String) hashMap.get(com.baidu.tbadk.BdToken.f.bRy);
                            }
                        }
                    });
                } else {
                    com.baidu.tieba.frs.f.d as = com.baidu.tieba.frs.f.i.as(intent);
                    if (as != null) {
                        this.fup = as.forumName;
                        if (as.fRB == null || as.fRB.equals("aidou")) {
                        }
                    }
                }
                if (!StringUtils.isNull(this.fup)) {
                    intent.putExtra("name", this.fup);
                }
                intent.putExtra(FrsActivityConfig.FRS_CALL_FROM, 12);
            }
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onStart() {
        super.onStart();
        this.fuw = getVoiceManager();
        if (this.fuw != null) {
            this.fuw.onStart(getPageContext());
        }
    }

    private void initData(Bundle bundle) {
        Intent intent;
        registerListener(CmdConfigCustom.CMD_FILE_DOWNLOAD, this.cwi);
        if (bundle != null) {
            this.fup = bundle.getString("name");
            this.mFrom = bundle.getString("from");
            this.mFlag = bundle.getInt(FrsActivityConfig.FLAG, 0);
        } else if (getActivity() != null && (intent = getActivity().getIntent()) != null) {
            this.fup = intent.getStringExtra("name");
            this.mFrom = intent.getStringExtra("from");
            this.mFlag = intent.getIntExtra(FrsActivityConfig.FLAG, 0);
        }
        if (getArguments() != null) {
            this.fuq = getArguments().getBoolean(FrsActivityConfig.FRS_CREATE_WITH_GAME, false);
        }
        if (TextUtils.isEmpty(this.mFrom) || FrsActivityConfig.FRS_FROM_WRITESHARE.equals(this.mFrom)) {
        }
        if (this.mIsLogin) {
            registerListener(CmdConfigCustom.CMD_MESSAGE_NOTIFY_LOCAL, this.cwi);
        }
        this.fuP.Q(bundle);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        com.baidu.tieba.q.c.cni().w(getUniqueId());
        MessageManager.getInstance().unRegisterListener(this.fvZ);
        fuB = null;
        if (this.fuw != null) {
            this.fuw.onDestory(getPageContext());
        }
        com.baidu.tieba.recapp.report.a.remove("FRS");
        this.fuw = null;
        com.baidu.tieba.card.t.bau().iK(false);
        if (this.fua != null && this.fua.getForum() != null) {
            aa.blG().cK(com.baidu.adp.lib.g.b.toLong(this.fua.getForum().getId(), 0L));
        }
        if (this.fvd != null) {
            this.fvd.onDestory();
        }
        if (this.fux != null) {
            com.baidu.tieba.frs.f.h.a(this.fux, this.fua, getForumId(), false, null);
            this.fux.onDestroy();
        }
        super.onDestroy();
        try {
            if (this.fuJ != null) {
                this.fuJ.awD();
            }
            this.fux.release();
            System.gc();
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
        this.fuP.aGF();
        if (this.fuO != null) {
            this.fuO.aMK();
        }
        if (this.fuU != null) {
            this.fuU.axK();
        }
        if (this.fuX != null) {
            this.fuX.destory();
        }
        if (this.fuY != null) {
            this.fuY.destory();
        }
        if (this.fuS != null) {
            this.fuS.onDestroy();
        }
        if (this.fvk != null) {
            this.fvk.onDestory();
        }
        if (this.fvc != null) {
            this.fvc.onDestroy();
        }
        if (this.fvn != null) {
            this.fvn.onDestroy();
        }
        if (this.fvo != null) {
            this.fvo.onDestroy();
        }
        com.baidu.tieba.recapp.d.a.cgB().cgD();
        com.baidu.tieba.frs.f.j.bqc();
        if (this.fuQ != null) {
            this.fuQ.a((FrsTabViewController.a) null);
            this.fuQ.bqU();
        }
        if (this.fvr != null) {
            this.fvr.onDestroy();
        }
        com.baidu.tieba.frs.a.biU().a(null);
    }

    @Override // android.support.v4.app.Fragment
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putString("name", this.fup);
        bundle.putString("from", this.mFrom);
        this.fuO.onSaveInstanceState(bundle);
        if (this.fuw != null && getPageContext() != null && getPageContext().getPageActivity() != null) {
            this.fuw.onSaveInstanceState(getPageContext().getPageActivity());
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (this.fvc != null) {
            this.fvc.onActivityResult(i, i2, intent);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        if (this.fux != null) {
            this.fux.bkQ();
            this.fux.onResume();
        }
        this.fuR.kA(true);
        this.fuK = true;
        if (fuo) {
            fuo = false;
            this.fux.startPullRefresh();
            return;
        }
        if (this.fuw != null) {
            this.fuw.onResume(getPageContext());
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_RESUME));
        this.fux.jT(false);
        if (this.fvl) {
            refresh(6);
            this.fvl = false;
        }
        bkv();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragment
    public void onUserChanged(boolean z) {
        super.onUserChanged(z);
    }

    public boolean bkc() {
        Intent intent;
        if (getActivity() == null || (intent = getActivity().getIntent()) == null) {
            return false;
        }
        return intent.getBooleanExtra(FrsActivityConfig.ALA_IS_ONLIVING, false);
    }

    public void onNewIntent(Intent intent) {
        if (intent != null) {
            if (!TextUtils.isEmpty(intent.getStringExtra("name"))) {
                this.fup = intent.getStringExtra("name");
            }
            if (!TextUtils.isEmpty(intent.getStringExtra("from"))) {
                this.mFrom = intent.getStringExtra("from");
            }
            this.fur = intent.getBooleanExtra(FrsActivityConfig.KEY_REFRESH, false);
            if (this.fur) {
                bkd();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bkd() {
        this.fux.startPullRefresh();
    }

    public void closeActivity() {
        com.baidu.tieba.frs.f.i.a(getPageContext(), getActivity() == null ? null : getActivity().getIntent(), this.mFrom);
    }

    private void initUI() {
        if (this.mFlag == 0) {
            this.fux.setTitle(this.fup);
        } else {
            this.fux.setTitle("");
            this.mFlag = 1;
        }
        this.fux.a(this.fvX);
        this.fux.addOnScrollListener(this.mScrollListener);
        this.fux.h(this.fsc);
        this.fux.blc().a(this.fvW);
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.fvt) {
            this.fux.onChangeSkinType(i);
            this.fuP.rQ(i);
            this.fuQ.onChangeSkinType(i);
            if (this.fuz != null) {
                this.fuz.onChangeSkinType(i);
            }
            if (this.fvi != null) {
                this.fvi.onChangeSkinType();
            }
            if (this.fvp != null) {
                this.fvp.onChangeSkinType(getPageContext(), i);
            }
            if (this.eOs != null) {
                com.baidu.tbadk.s.a.a(getPageContext(), this.eOs.getRealView());
            }
            if (this.fvj != null) {
                this.fvj.onChangeSkinType();
            }
        }
    }

    public void qo(int i) {
        if (!this.mIsLogin) {
            if (this.fua != null && this.fua.getAnti() != null) {
                this.fua.getAnti().setIfpost(1);
            }
            if (i == 0) {
                bc.skipToLoginActivity(getActivity());
            }
        } else if (this.fua != null) {
            if (i == 0) {
                com.baidu.tieba.frs.f.j.d(this, 0);
            } else {
                this.fux.bkS();
            }
        }
    }

    public void refresh() {
        com.baidu.tieba.a.d.aDc().rg("page_frs");
        refresh(3);
    }

    public void refresh(int i) {
        this.fuH = false;
        bki();
        if (this.fux != null && this.fux.bkH() != null) {
            this.fux.bkH().bup();
        }
        if (this.fuO != null) {
            this.fuO.E(i, true);
        }
    }

    private void bke() {
        switch (this.mFlag) {
            case 1:
                com.baidu.adp.lib.g.h.ga().submitTask(new Runnable() { // from class: com.baidu.tieba.frs.FrsFragment.29
                    @Override // java.lang.Runnable
                    public void run() {
                        com.baidu.tieba.tbadkCore.util.a.DW(FrsFragment.this.fup);
                    }
                });
                break;
        }
        this.mFlag = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bkf() {
        bki();
        try {
            if (this.fua != null) {
                this.fux.aMo();
                this.fux.jL(bku());
                if (!com.baidu.tieba.frs.vc.f.l(this.fua) || !com.baidu.tieba.frs.vc.f.k(this.fua)) {
                }
                if (this.fua.getForum() != null) {
                    this.fup = this.fua.getForum().getName();
                    this.forumId = this.fua.getForum().getId();
                }
                if (this.fua.getPage() != null) {
                    setHasMore(this.fua.getPage().ahy());
                }
                this.fux.setTitle(this.fup);
                this.fux.setForumName(this.fup);
                TbadkCoreApplication.getInst().setDefaultBubble(this.fua.getUserData().getBimg_url());
                TbadkCoreApplication.getInst().setDefaultBubbleEndTime(this.fua.getUserData().getBimg_end_time());
                bke();
                bkg();
                ArrayList<com.baidu.adp.widget.ListView.m> threadList = this.fua.getThreadList();
                if (threadList != null) {
                    this.fux.a(threadList, this.fua);
                    com.baidu.tieba.frs.f.c.y(this.fux);
                    this.fuP.rR(getPageNum());
                    this.fuP.i(this.fua);
                    this.fuQ.a(this.fua, this.fuO.bpn());
                    this.fux.bkT();
                }
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    private void bkg() {
        if (this.fua != null) {
            if (this.fua.getIsNewUrl() == 1) {
                this.fux.blc().setFromCDN(true);
            } else {
                this.fux.blc().setFromCDN(false);
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onPause() {
        super.onPause();
        this.fuR.kA(false);
        this.fuK = false;
        this.fux.onPause();
        if (this.fuw != null) {
            this.fuw.onPause(getPageContext());
        }
        this.fux.jT(true);
        if (this.fuY != null) {
            this.fuY.bqf();
        }
        com.baidu.tbadk.BdToken.c.adX().aec();
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void setPrimary(boolean z) {
        super.setPrimary(z);
        if (this.fuQ != null && this.fuQ.bqS() != null && (this.fuQ.bqS().fragment instanceof BaseFragment)) {
            ((BaseFragment) this.fuQ.bqS().fragment).setPrimary(z);
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onStop() {
        super.onStop();
        com.baidu.tieba.card.t.bau().iK(false);
        jD(false);
        if (this.fua != null && this.fua.getForum() != null && getPageContext() != null && getPageContext().getPageActivity() != null) {
            com.baidu.tbadk.distribute.a.atL().a(getPageContext().getPageActivity(), "frs", this.fua.getForum().getId(), 0L);
        }
        if (this.fuw != null) {
            this.fuw.onStop(getPageContext());
        }
        if (aod() != null) {
            aod().getRecycledViewPool().clear();
        }
        this.fuP.anE();
        com.baidu.tbadk.util.x.axO();
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        super.onPrimary();
        if (isAdded()) {
            if (this.fuP != null) {
                this.fuP.jJ(isPrimary());
            }
            if (this.fux != null) {
                this.fux.jJ(isPrimary());
                this.fux.jT(!isPrimary());
            }
        }
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            if (com.baidu.tieba.frs.a.biU().biV()) {
                com.baidu.tieba.frs.a.biU().reset();
                return true;
            } else if (this.fux != null) {
                return this.fux.bkP();
            }
        } else if (i == 24) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921381, keyEvent));
        }
        return false;
    }

    @Override // com.baidu.tieba.recapp.n
    public TbPageContext<?> getTbPageContext() {
        return getPageContext();
    }

    @Override // com.baidu.tieba.recapp.n
    public void a(AdvertAppInfo advertAppInfo, String str) {
        com.baidu.tbadk.distribute.a.atL().a(advertAppInfo, this.forumId, 0L, "FRS", str, getPn());
    }

    @Override // com.baidu.tieba.recapp.n
    public void bkh() {
        bjI().bkh();
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager getVoiceManager() {
        if (this.fuw == null) {
            this.fuw = VoiceManager.instance();
        }
        return this.fuw;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.core.view.UserIconBox.b
    /* renamed from: getListView */
    public BdRecyclerView aod() {
        if (this.fux == null) {
            return null;
        }
        return this.fux.getListView();
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager.b c(VoiceData.VoiceModel voiceModel) {
        return null;
    }

    public void bki() {
        if (this.fuw != null) {
            this.fuw.stopPlay();
        }
    }

    @Override // com.baidu.tbadk.core.view.UserIconBox.b
    public com.baidu.adp.lib.e.b<TbImageView> aoe() {
        if (this.crq == null) {
            this.crq = UserIconBox.o(getPageContext().getPageActivity(), 8);
        }
        return this.crq;
    }

    public void bkj() {
        if (getFragmentActivity() != null && getFragmentActivity().getCurrentFocus() != null) {
            com.baidu.adp.lib.util.l.hideSoftKeyPad(getFragmentActivity(), getFragmentActivity().getCurrentFocus());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public com.baidu.adp.widget.ListView.p onGetPreLoadListView() {
        return aod().getPreLoadHandle();
    }

    @Override // com.baidu.tieba.frs.ah
    public NavigationBar aKP() {
        if (this.fux == null) {
            return null;
        }
        return this.fux.aKP();
    }

    public FRSRefreshButton bkk() {
        return this.fuz;
    }

    public void a(FRSRefreshButton fRSRefreshButton) {
        if (fRSRefreshButton != null) {
            this.fuz = fRSRefreshButton;
            this.fuz.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.FrsFragment.36
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (FrsFragment.this.fuQ != null) {
                        FrsTabViewController.b bqS = FrsFragment.this.fuQ.bqS();
                        if (bqS != null && bqS.fragment != null && (bqS.fragment instanceof ag)) {
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_EXPAND_BAR_HEADER, true));
                            ((ag) bqS.fragment).bjw();
                            ((ag) bqS.fragment).aKf();
                            return;
                        }
                        FrsFragment.this.bjN().startPullRefresh();
                    }
                }
            });
        }
    }

    public void bkl() {
        if (this.fuz != null && this.fuA) {
            if (this.fvv != null) {
                this.fvv.cancel();
            }
            this.fvv = new AlphaAnimation(1.0f, 0.0f);
            this.fvv.setDuration(300L);
            this.fvv.setFillAfter(true);
            this.fuz.startAnimation(this.fvv);
            this.fuz.setClickable(false);
            this.fuA = false;
        }
    }

    public void bkm() {
        if (this.fuz != null && !this.fuA && this.fuQ.bqV() != 0) {
            this.fuz.setVisibility(0);
            if (this.fvw != null) {
                this.fvw.cancel();
            }
            this.fvw = new AlphaAnimation(0.0f, 1.0f);
            this.fvw.setDuration(300L);
            this.fvw.setFillAfter(true);
            this.fuz.startAnimation(this.fvw);
            this.fuz.setClickable(true);
            this.fuA = true;
        }
    }

    /* loaded from: classes4.dex */
    private final class a implements com.baidu.adp.widget.ListView.s {
        private a() {
        }

        /* JADX DEBUG: Multi-variable search result rejected for r2v1, resolved type: com.baidu.tieba.frs.FrsFragment */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.baidu.adp.widget.ListView.s
        public void a(View view, com.baidu.adp.widget.ListView.m mVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i, long j) {
            if (bdUniqueId != null) {
                if (bdUniqueId == p.fxG) {
                    if (FrsFragment.this.fux != null) {
                        TiebaStatic.log(new com.baidu.tbadk.core.util.an("c11752").bS("fid", FrsFragment.this.forumId).bS("obj_locate", "1"));
                        FrsFragment.this.fux.startPullRefresh();
                    }
                } else if (mVar != null && (mVar instanceof bg)) {
                    bh bhVar = ((bg) mVar).caz;
                    if (bhVar.ajw() == null || bhVar.ajw().getGroup_id() == 0 || bc.checkUpIsLogin(FrsFragment.this.getActivity())) {
                        if (bhVar.ajo() != 1 || bc.checkUpIsLogin(FrsFragment.this.getActivity())) {
                            if (bhVar.aiR() != null) {
                                if (bc.checkUpIsLogin(FrsFragment.this.getActivity())) {
                                    String postUrl = bhVar.aiR().getPostUrl();
                                    if (!StringUtils.isNull(postUrl) && com.baidu.adp.lib.util.l.isNetOk()) {
                                        com.baidu.tbadk.browser.a.startInternalWebActivity(FrsFragment.this.getActivity(), postUrl);
                                    }
                                }
                            } else if (bhVar.ajH() != null) {
                                if (StringUtils.isNull(TbadkCoreApplication.getCurrentAccount())) {
                                    bc.skipToLoginActivity(FrsFragment.this.getPageContext().getPageActivity());
                                    return;
                                }
                                com.baidu.tbadk.core.data.o ajH = bhVar.ajH();
                                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new MangaBrowserActivityConfig(FrsFragment.this.getPageContext().getPageActivity(), ajH.getCartoonId(), ajH.getChapterId(), 2)));
                            } else {
                                com.baidu.tieba.tbadkCore.util.d readThreadHistory = TbadkCoreApplication.getInst().getReadThreadHistory();
                                if (readThreadHistory != null && !readThreadHistory.Ec(bhVar.getId())) {
                                    readThreadHistory.Eb(bhVar.getId());
                                }
                                boolean z = false;
                                final String aiL = bhVar.aiL();
                                if (aiL != null && !aiL.equals("")) {
                                    z = true;
                                    new Thread(new Runnable() { // from class: com.baidu.tieba.frs.FrsFragment.a.1
                                        @Override // java.lang.Runnable
                                        public void run() {
                                            com.baidu.tbadk.core.util.x xVar = new com.baidu.tbadk.core.util.x(aiL);
                                            xVar.amp().amP().mIsNeedAddCommenParam = false;
                                            xVar.amp().amP().mIsUseCurrentBDUSS = false;
                                            xVar.getNetData();
                                        }
                                    }).start();
                                }
                                String tid = bhVar.getTid();
                                if (tid == null) {
                                    tid = "";
                                }
                                if (bhVar.aiz() == 2 && !tid.startsWith(UrlSchemaHelper.SCHEMA_TYPE_PB)) {
                                    ba.amO().b(FrsFragment.this.getPageContext(), new String[]{tid, "", null});
                                    return;
                                }
                                if (tid.startsWith(UrlSchemaHelper.SCHEMA_TYPE_PB)) {
                                    bhVar.setId(tid.substring(3));
                                }
                                if (bdUniqueId.getId() == bh.ccp.getId()) {
                                    com.baidu.tieba.frs.f.h.a(bhVar.aik());
                                } else if (bdUniqueId.getId() == bh.caV.getId()) {
                                    com.baidu.tbadk.core.util.an anVar = new com.baidu.tbadk.core.util.an(CommonStatisticKey.KEY_FRS_TRANSMIT_THREAD);
                                    anVar.bS("obj_type", "2");
                                    anVar.bS("tid", bhVar.getTid());
                                    TiebaStatic.log(anVar);
                                }
                                com.baidu.tieba.frs.f.i.a(FrsFragment.this, bhVar, i, z);
                                com.baidu.tieba.frs.f.h.a(FrsFragment.this, FrsFragment.this.fua, bhVar);
                            }
                        }
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragment
    public void onNetRefreshButtonClicked() {
        if (com.baidu.adp.lib.util.l.isNetOk()) {
            hideNetRefreshView(this.fux.aYb());
            showLoadingView(this.fux.aYb(), true);
            this.fux.jO(false);
            this.fuO.E(3, true);
        }
    }

    @Override // com.baidu.tieba.frs.loadmore.a
    public FrsViewData bkn() {
        return this.fua;
    }

    public boolean bko() {
        return this.fux.bko();
    }

    public void am(Object obj) {
        if (this.fuT != null && this.fuT.fNe != null) {
            this.fuT.fNe.callback(obj);
        }
    }

    public void an(Object obj) {
        if (this.fuT != null && this.fuT.fNf != null) {
            this.fuT.fNf.callback(obj);
        }
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.e
    public void onScrollToBottom() {
        this.fux.getListView().stopScroll();
        if (!this.fux.bkY()) {
            if (!com.baidu.adp.lib.util.l.isNetOk()) {
                this.fux.aKi();
            } else if (this.fuO.bpi() == 1) {
                aJj();
                aIU();
            } else if (this.fuO.hasMore()) {
                aIU();
            }
        }
    }

    @Override // com.baidu.tieba.frs.loadmore.FrsLoadMoreModel.a
    public void onFailed(String str) {
        aJj();
        showToast(str);
    }

    @Override // com.baidu.tieba.frs.loadmore.FrsLoadMoreModel.a
    public void aa(ArrayList<com.baidu.adp.widget.ListView.m> arrayList) {
        boolean isEmpty = com.baidu.tbadk.core.util.v.isEmpty(arrayList);
        setHasMore(isEmpty ? 0 : 1);
        aJj();
        if (!isEmpty) {
            if (!this.fuO.bpr() && TbadkCoreApplication.getInst().isRecAppExist() && this.fuO.bpi() == 1) {
                this.fua.addRecommendAppToThreadList(this, arrayList);
            }
            if (this.fuO != null) {
                com.baidu.tieba.frs.d.a.a(getUniqueId(), arrayList, this.fua.getForum(), this.fuO.getSortType());
            }
            ArrayList<com.baidu.adp.widget.ListView.m> a2 = this.fva.a(false, false, arrayList, this.fut, false);
            if (a2 != null) {
                this.fua.setThreadList(a2);
                this.fux.a(a2, this.fua);
            }
            if (this.fuO != null) {
                com.baidu.tieba.frs.d.c.a(this.fua, this.fuO.bpn(), 2);
            }
        }
    }

    private void aJj() {
        if (bjO() == 1 || this.fva.cv(this.fua.getThreadListIds())) {
            if (com.baidu.tbadk.core.util.v.getCount(this.fua.getThreadList()) > 3) {
                this.fux.aKg();
            } else {
                this.fux.blf();
            }
        } else if (com.baidu.tbadk.core.util.v.isEmpty(this.fua.getThreadList())) {
            this.fux.aKi();
        } else {
            this.fux.aKh();
        }
    }

    @Override // com.baidu.tieba.frs.mc.l
    public void aIU() {
        if (this.fva != null) {
            this.fva.a(this.fup, this.forumId, this.fua);
        }
    }

    public void takePhoto() {
        if (!com.baidu.tbadk.core.util.ab.requestWriteExternalStorgeAndCameraPermission(getPageContext().getPageActivity(), 1)) {
            com.baidu.tbadk.core.util.al.c(getPageContext());
        }
    }

    @Override // android.support.v4.app.Fragment, com.baidu.e.a.a.InterfaceC0055a
    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        com.baidu.tieba.frs.f.i.a(this, i, strArr, iArr);
    }

    public void jG(boolean z) {
        if (this.fuU != null) {
            this.fuU.kd(z);
        }
    }

    @Override // com.baidu.tieba.InjectPlugin.a.b
    public void a(int i, com.baidu.tieba.InjectPlugin.a.a aVar) {
        this.fuV.put(i, aVar);
    }

    @Override // com.baidu.tieba.InjectPlugin.a.b
    public com.baidu.tieba.InjectPlugin.a.a ln(int i) {
        return this.fuV.get(i);
    }

    @Override // com.baidu.tieba.InjectPlugin.a.b
    public void a(com.baidu.tieba.InjectPlugin.b bVar) {
        this.fve.b(bVar);
    }

    public boolean bkp() {
        return this.ful;
    }

    @Override // com.baidu.tieba.frs.ae
    public void vV() {
        if (this.fux != null) {
            showFloatingView();
            this.fux.getListView().scrollToPosition(0);
            this.fux.startPullRefresh();
        }
    }

    public ForumWriteData bkq() {
        if (this.fua == null || this.fua.getForum() == null) {
            return null;
        }
        ForumData forum = this.fua.getForum();
        ForumWriteData forumWriteData = new ForumWriteData(forum.getId(), forum.getName(), forum.getPrefixData(), this.fua.getAnti());
        forumWriteData.avatar = forum.getImage_url();
        forumWriteData.forumLevel = forum.getUser_level();
        forumWriteData.specialForumType = forum.special_forum_type;
        forumWriteData.firstDir = forum.getFirst_class();
        forumWriteData.secondDir = forum.getSecond_class();
        UserData userData = this.fua.getUserData();
        forumWriteData.privateThread = userData != null ? userData.getPrivateThread() : 0;
        return forumWriteData;
    }

    @Override // com.baidu.tieba.frs.ae
    public void anM() {
        changeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // com.baidu.tieba.frs.ae
    public void setVideoThreadId(String str) {
    }

    public void jH(boolean z) {
        this.fuL = z;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragment
    public void showLoadingView(View view, boolean z) {
        super.showLoadingView(view, z);
        this.fux.qu(8);
        ((FrsActivity) getActivity()).g(view, true);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragment
    public void hideLoadingView(View view) {
        super.hideLoadingView(view);
        this.fux.qu(0);
        ((FrsActivity) getActivity()).g(view, false);
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void showNetRefreshView(View view, String str, boolean z) {
        super.showNetRefreshView(view, str, z);
        this.fux.qu(8);
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void showNetRefreshViewNoClick(View view, String str, boolean z) {
        super.showNetRefreshViewNoClick(view, str, z);
        this.fux.qu(8);
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void hideNetRefreshView(View view) {
        super.hideNetRefreshView(view);
        this.fux.qu(0);
    }

    public void bkr() {
        FrsTabViewController.b bqS;
        if (this.fuQ != null && (bqS = this.fuQ.bqS()) != null && bqS.fragment != null && (bqS.fragment instanceof ag)) {
            ((ag) bqS.fragment).bjw();
        }
    }

    public void jI(boolean z) {
        this.fun = z;
    }

    public void b(OvalActionButton ovalActionButton) {
        this.fuy = ovalActionButton;
    }

    public OvalActionButton bks() {
        return this.fuy;
    }

    public boolean bkt() {
        return this.fun;
    }

    public void vM(String str) {
        if (TbadkCoreApplication.isLogin() && !com.baidu.tbadk.core.util.aq.isEmpty(str)) {
            if (this.fvr == null) {
                this.fvr = new AddExperiencedModel(getTbPageContext());
                this.fvr.a(this.fvx);
            }
            this.fvr.dR(this.forumId, str);
        }
    }

    public boolean bku() {
        if (this.fuL && !this.fvu) {
            return (this.fuO != null && this.fuO.bpj() && com.baidu.tieba.frs.a.biU().biV()) ? false : true;
        }
        return false;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, com.baidu.tbadk.core.util.g.c
    public boolean videoNeedPreload() {
        if (this.fua != null) {
            return com.baidu.tbadk.util.ac.axT() && (this.fua.isFrsVideoAutoPlay || com.baidu.tbadk.core.sharedPref.b.alP().getInt(SharedPrefConfig.AUTO_PLAY_VIDEO_FRS, 0) == 1);
        }
        return super.videoNeedPreload();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, com.baidu.tbadk.core.util.g.c
    public boolean isCyberVideoUsedThisPage() {
        return com.baidu.tbadk.a.b.mb("cyber_player_test");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bkv() {
        if (!com.baidu.tbadk.core.util.aq.isEmpty(this.forumId)) {
            com.baidu.tbadk.BdToken.c.adX().j(com.baidu.tbadk.BdToken.b.bQb, com.baidu.adp.lib.g.b.toLong(this.forumId, 0L));
        }
    }
}
