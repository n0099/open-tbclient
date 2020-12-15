package com.baidu.tieba.frs.gametab;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.ActivityChooserView;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.l;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigSocket;
import com.baidu.live.tbadk.core.sharedpref.SharedPrefConfig;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.data.ForumData;
import com.baidu.tbadk.core.data.VoiceData;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.tabHost.FragmentTabHost;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.util.au;
import com.baidu.tbadk.core.util.bf;
import com.baidu.tbadk.core.util.o;
import com.baidu.tbadk.core.util.y;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.commonBtn.TBSpecificationBtn;
import com.baidu.tbadk.core.voice.VoiceManager;
import com.baidu.tbadk.coreExtra.model.ShareSuccessReplyToServerModel;
import com.baidu.tbadk.coreExtra.share.ShareItem;
import com.baidu.tbadk.mainTab.FragmentTabIndicator;
import com.baidu.tbadk.mainTab.TbFragmentTabIndicator;
import com.baidu.tbadk.pageInfo.TbPageTag;
import com.baidu.tbadk.task.TbHttpMessageTask;
import com.baidu.tbadk.util.w;
import com.baidu.tbadk.widget.FRSRefreshButton;
import com.baidu.tbadk.widget.OvalActionButton;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.frs.CubeOutViewPagerTransformer;
import com.baidu.tieba.frs.FrsActivity;
import com.baidu.tieba.frs.FrsBaseViewPager;
import com.baidu.tieba.frs.FrsFragment;
import com.baidu.tieba.frs.FrsRecommendResMsg;
import com.baidu.tieba.frs.FrsTabHostFragment;
import com.baidu.tieba.frs.FrsTabViewPager;
import com.baidu.tieba.frs.al;
import com.baidu.tieba.frs.as;
import com.baidu.tieba.frs.sportspage.FrsSportsRecommendFragment;
import com.baidu.tieba.frs.t;
import com.baidu.tieba.pb.interactionpopupwindow.CustomDialogData;
import com.baidu.tieba.tbadkCore.FRSPageSocketResponsedMessage;
import com.baidu.tieba.tbadkCore.FrsCommonImageLayout;
import com.baidu.tieba.tbadkCore.FrsPageHttpResponseMessage;
import com.baidu.tieba.tbadkCore.FrsViewData;
import com.baidu.tieba.tbadkCore.m;
import com.baidu.tieba.view.BdTopToast;
import com.baidu.tieba.view.NavigationBarCoverTip;
import com.baidu.tieba.view.ScreenTopToast;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import tbclient.FrsPage.TipInfo;
import tbclient.FrsTabInfo;
import tbclient.ThemeColorInfo;
import tbclient.ThemeElement;
/* loaded from: classes22.dex */
public class FrsTabController implements VoiceManager.c, com.baidu.tieba.InjectPlugin.a.b, FrsCommonImageLayout.c {
    public static final String joG = FrsFragment.class.getSimpleName();
    public static final String joH = FrsTabHostFragment.class.getSimpleName();
    private LinearLayout iTa;
    private al iXj;
    private FrsFragment iXk;
    private m iXl;
    private int iXn;
    private FRSRefreshButton iXp;
    private FrsActivity joI;
    private FrsTabHostFragment joJ;
    private ShareSuccessReplyToServerModel joM;
    private FrsBaseViewPager joO;
    private FragmentAdapter joP;
    private OvalActionButton joQ;
    private boolean joR;
    private boolean joS;
    private NavigationBarCoverTip joT;
    private com.baidu.tieba.d.e joW;
    private com.baidu.tieba.frs.f.e joX;
    private Runnable joY;
    private boolean joZ;
    private String mForumName;
    private String mFrom;
    private boolean joK = false;
    private final Handler mHandler = new Handler();
    private int iXm = 0;
    private boolean joN = false;
    private boolean joU = false;
    private boolean joV = false;
    private boolean jpa = false;
    private boolean jpb = false;
    private HttpMessageListener jpc = new HttpMessageListener(CmdConfigHttp.CMD_FRS_RECOMMEND) { // from class: com.baidu.tieba.frs.gametab.FrsTabController.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage instanceof FrsRecommendResMsg) {
                if (httpResponsedMessage.getError() != 0) {
                    new BdTopToast(FrsTabController.this.joI).yW(false).Vt(httpResponsedMessage.getErrorString()).aF((ViewGroup) FrsTabController.this.joI.findViewById(R.id.frs));
                    return;
                }
                int pushStatus = ((FrsRecommendResMsg) httpResponsedMessage).getPushStatus();
                String pushMsg = ((FrsRecommendResMsg) httpResponsedMessage).getPushMsg();
                if (pushStatus == 1) {
                    new ScreenTopToast(FrsTabController.this.joI).Vx(FrsTabController.this.joI.getString(R.string.frs_recommend_suc_tip_title)).Vy(FrsTabController.this.joI.getString(R.string.frs_recommend_suc_tip_content)).Vz(FrsTabController.this.joI.getString(R.string.dialog_confirm_see)).al(new View.OnClickListener() { // from class: com.baidu.tieba.frs.gametab.FrsTabController.1.1
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view) {
                            HashMap hashMap = new HashMap();
                            hashMap.put("_forumId", FrsTabController.this.iXl.getForum().getId());
                            MessageManager.getInstance().sendMessage(new CustomMessage(2002015, new com.baidu.tieba.tbadkCore.data.m(FrsTabController.this.joI, "RecommendHistoryPage", hashMap)));
                        }
                    }).aF((ViewGroup) FrsTabController.this.joI.findViewById(R.id.frs));
                } else {
                    new BdTopToast(FrsTabController.this.joI).yW(false).Vt(pushMsg).aF((ViewGroup) FrsTabController.this.joI.findViewById(R.id.frs));
                }
            }
        }
    };
    private CustomMessageListener jpd = new CustomMessageListener(2921465) { // from class: com.baidu.tieba.frs.gametab.FrsTabController.12
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            new ScreenTopToast(FrsTabController.this.joI).Vx(FrsTabController.this.joI.getString(R.string.frs_recommend_fail_month_tip)).Vz(FrsTabController.this.joI.getString(R.string.frs_recommend_fail_tip_btn)).al(new View.OnClickListener() { // from class: com.baidu.tieba.frs.gametab.FrsTabController.12.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    HashMap hashMap = new HashMap();
                    hashMap.put("_forumId", FrsTabController.this.iXl.getForum().getId());
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002015, new com.baidu.tieba.tbadkCore.data.m(FrsTabController.this.joI, "ForumGradePage", hashMap)));
                }
            }).aF((ViewGroup) FrsTabController.this.joI.findViewById(R.id.frs));
        }
    };
    private com.baidu.adp.framework.listener.a jpe = new com.baidu.adp.framework.listener.a(1001703, CmdConfigSocket.CMD_FRS_PAGE) { // from class: com.baidu.tieba.frs.gametab.FrsTabController.19
        @Override // com.baidu.adp.framework.listener.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            m mVar = null;
            int i = -1;
            if (!FrsTabController.this.joK && !responsedMessage.hasError() && responsedMessage.getError() == 0) {
                if (responsedMessage instanceof FrsPageHttpResponseMessage) {
                    mVar = ((FrsPageHttpResponseMessage) responsedMessage).getResponseData();
                    i = ((FrsPageHttpResponseMessage) responsedMessage).getUpdateType();
                } else if (responsedMessage instanceof FRSPageSocketResponsedMessage) {
                    mVar = ((FRSPageSocketResponsedMessage) responsedMessage).getResponseData();
                    i = ((FRSPageSocketResponsedMessage) responsedMessage).getUpdateType();
                }
                if (mVar != null) {
                    FrsTabController.this.joK = true;
                    FrsTabController.this.a(mVar, true, i);
                    if (mVar != null && mVar.getForum() != null && !StringUtils.isNull(mVar.getForum().getId())) {
                        com.baidu.tbadk.core.business.a.bmh().dK("2", mVar.getForum().getId());
                    }
                }
                if (mVar != null && mVar.getUserData() != null && mVar.getUserData().getNewGodData() != null) {
                    if (mVar.getForum() != null) {
                        w.bGH().setFid(mVar.getForum().getId());
                    }
                    w.bGH().b(2, mVar.getUserData().getNewGodData());
                }
            }
        }
    };
    private CustomMessageListener jpf = new CustomMessageListener(CmdConfigCustom.CMD_GET_FRS_PAGE_CACHE) { // from class: com.baidu.tieba.frs.gametab.FrsTabController.20
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (!FrsTabController.this.joK && FrsTabController.this.iXl == null && customResponsedMessage != null && (customResponsedMessage.getData() instanceof m)) {
                m mVar = (m) customResponsedMessage.getData();
                if (mVar.getForum() != null && FrsTabController.this.mForumName != null && FrsTabController.this.mForumName.equals(mVar.getForum().getName())) {
                    FrsTabController.this.a(mVar, false, -1);
                }
            }
        }
    };
    private CustomMessageListener jpg = new CustomMessageListener(CmdConfigCustom.CMD_CLICK_CLOSE_GAME_FRS_CONFIRM) { // from class: com.baidu.tieba.frs.gametab.FrsTabController.21
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            FrsTabController.this.cIp();
        }
    };
    private CustomMessageListener jph = new CustomMessageListener(CmdConfigCustom.CMD_GAME_FRS_TAB_CHANGE) { // from class: com.baidu.tieba.frs.gametab.FrsTabController.22
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            int Ac;
            if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof Integer)) {
                int intValue = ((Integer) customResponsedMessage.getData()).intValue();
                if (10001 == intValue) {
                    Ac = FrsTabController.this.Ac(9);
                    if (Ac == -1) {
                        Ac = FrsTabController.this.Ac(2);
                    }
                } else {
                    Ac = FrsTabController.this.Ac(intValue);
                }
                if (Ac != -1 && FrsTabController.this.cIq() && FrsTabController.this.joJ != null) {
                    FrsTabController.this.joJ.setCurrentTab(Ac);
                    if (FrsTabController.this.Ae(Ac) != 1) {
                        FrsTabController.this.iXk.pW(false);
                    }
                }
            }
        }
    };
    private HttpMessageListener jpi = new HttpMessageListener(0) { // from class: com.baidu.tieba.frs.gametab.FrsTabController.23
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && 1021074 == httpResponsedMessage.getCmd() && (httpResponsedMessage instanceof AlaGameTabGetNewNotifyResponsedMessage)) {
                List<a> newNotifyData = ((AlaGameTabGetNewNotifyResponsedMessage) httpResponsedMessage).getNewNotifyData();
                if (!y.isEmpty(newNotifyData) && FrsTabController.this.joJ != null) {
                    for (a aVar : newNotifyData) {
                        if (aVar != null) {
                            for (int i = 0; i < FrsTabController.this.iXj.bBY().size(); i++) {
                                FragmentTabHost.b pL = FrsTabController.this.joJ.pL(i);
                                if (pL != null && pL.mType != 1 && pL.mType != FrsTabController.this.joJ.getCurrentTabType() && pL.mType == aVar.getTabId() && aVar.cIe() && pL.eRD.El(String.valueOf(pL.mType)) != null) {
                                    pL.eRD.El(String.valueOf(pL.mType)).view.setVisibility(0);
                                }
                            }
                        }
                    }
                }
            }
        }
    };
    private CustomMessageListener jpj = new CustomMessageListener(2921518) { // from class: com.baidu.tieba.frs.gametab.FrsTabController.24
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            new BdTopToast(FrsTabController.this.joI, 2000).yW(false).Vt(FrsTabController.this.joI.getString(R.string.frs_top_forum_rules_click_toast)).aF((ViewGroup) FrsTabController.this.joI.findViewById(R.id.frs));
        }
    };
    private Runnable jpk = new Runnable() { // from class: com.baidu.tieba.frs.gametab.FrsTabController.25
        @Override // java.lang.Runnable
        public void run() {
            com.baidu.adp.lib.f.e.mY().removeCallbacks(this);
            FrsTabController.this.cIo();
            com.baidu.adp.lib.f.e.mY().postDelayed(this, 30000L);
        }
    };
    private CustomMessageListener mAccountChangedListener = new CustomMessageListener(CmdConfigCustom.METHOD_ACCOUNT_CHANGE) { // from class: com.baidu.tieba.frs.gametab.FrsTabController.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2005016) {
                FrsTabController.this.joN = true;
            }
        }
    };
    private CustomMessageListener jpl = new CustomMessageListener(2921369) { // from class: com.baidu.tieba.frs.gametab.FrsTabController.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && FrsTabController.this.joO != null && FrsTabController.this.joP != null && (customResponsedMessage.getData() instanceof FrsTabViewPager.a)) {
                FrsTabViewPager.a aVar = (FrsTabViewPager.a) customResponsedMessage.getData();
                FrsTabController.this.joR = aVar.cEm();
                FrsTabController.this.joS = aVar.cEn();
            }
        }
    };
    private CustomMessageListener jpm = new CustomMessageListener(2921370) { // from class: com.baidu.tieba.frs.gametab.FrsTabController.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && FrsTabController.this.joO != null && FrsTabController.this.joP != null && (customResponsedMessage.getData() instanceof Boolean)) {
                FrsTabController.this.joO.setForceIntercept(((Boolean) customResponsedMessage.getData()).booleanValue());
            }
        }
    };
    private CustomMessageListener jpn = new CustomMessageListener(CmdConfigCustom.CMD_NEW_WRITE_POST_SUCCESS) { // from class: com.baidu.tieba.frs.gametab.FrsTabController.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (((Boolean) customResponsedMessage.getData()).booleanValue()) {
                FrsTabController.this.e((ForumData) null);
            }
        }
    };
    private CustomMessageListener jpo = new CustomMessageListener(2921498) { // from class: com.baidu.tieba.frs.gametab.FrsTabController.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (FrsTabController.this.joX != null && customResponsedMessage != null && customResponsedMessage.getData() != null) {
                if (customResponsedMessage.getData() instanceof ForumData) {
                    FrsTabController.this.e((ForumData) customResponsedMessage.getData());
                } else if (customResponsedMessage.getData() instanceof Long) {
                    long longValue = ((Long) customResponsedMessage.getData()).longValue();
                    if (FrsTabController.this.gq(longValue) && FrsTabController.this.joX.gr(longValue) >= 3) {
                        FrsTabController.this.joX.gs(longValue);
                        FrsTabController.this.jpa = true;
                    }
                }
            }
        }
    };
    private CustomMessageListener jpp = new CustomMessageListener(CmdConfigCustom.CMD_PERSON_LIKE_FORUM) { // from class: com.baidu.tieba.frs.gametab.FrsTabController.7
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.tbadkCore.writeModel.a)) {
                com.baidu.tieba.tbadkCore.writeModel.a aVar = (com.baidu.tieba.tbadkCore.writeModel.a) customResponsedMessage.getData();
                if (FrsTabController.this.joX != null && aVar != null && TbadkCoreApplication.isLogin()) {
                    FrsTabController.this.joX.fe(TbadkCoreApplication.getCurrentAccount(), String.valueOf(aVar.forumId));
                }
            }
        }
    };
    private ViewPager.OnPageChangeListener jpq = new ViewPager.OnPageChangeListener() { // from class: com.baidu.tieba.frs.gametab.FrsTabController.8
        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrolled(int i, float f, int i2) {
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            if (i != 1) {
                FrsTabController.this.joQ.setVisibility(0);
                if (FrsTabController.this.cBr() != null) {
                    FrsTabController.this.cBr().pQ(false);
                }
                FrsTabController.this.iXk.cCJ();
            }
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i) {
            switch (i) {
                case 0:
                    FrsTabController.this.joS = false;
                    FrsTabController.this.joO.setForceIntercept(false);
                    return;
                default:
                    return;
            }
        }
    };
    private FrsBaseViewPager.a jpr = new FrsBaseViewPager.a() { // from class: com.baidu.tieba.frs.gametab.FrsTabController.9
        @Override // com.baidu.tieba.frs.FrsBaseViewPager.a
        public void cBN() {
            if (FrsTabController.this.joO != null) {
                if (FrsTabController.this.joO.getCurrentItem() == 0) {
                    FrsTabController.this.joO.setmDisallowSlip(true);
                } else {
                    FrsTabController.this.joO.setmDisallowSlip(false);
                }
            }
        }

        @Override // com.baidu.tieba.frs.FrsBaseViewPager.a
        public boolean cBO() {
            if (FrsTabController.this.joO.getCurrentItem() == 0) {
                if (FrsTabController.this.joR && FrsTabController.this.joS) {
                    FrsTabController.this.joO.setmDisallowSlip(false);
                }
                if (!FrsTabController.this.joS) {
                    FrsTabController.this.joO.setmDisallowSlip(true);
                }
                FrsTabController.this.joO.setmDisallowSlip(true);
            } else {
                FrsTabController.this.joO.setmDisallowSlip(true);
            }
            return true;
        }
    };
    private String joL = com.baidu.tbadk.core.sharedPref.b.getSharedPrefKeyWithAccount(SharedPrefConfig.SHOW_GAME_FOREM_TAB_HOT_POINT);

    public FrsTabController(FrsActivity frsActivity) {
        this.joI = frsActivity;
    }

    public void init(Bundle bundle) {
        if (this.joI != null) {
            this.joI.setContentView(R.layout.frs_base_layout);
            this.joO = (FrsBaseViewPager) this.joI.findViewById(R.id.frs_base_viewpager);
            this.joP = new FragmentAdapter(this.joI.getSupportFragmentManager());
            this.joO.setAdapter(this.joP);
            this.joO.setPageTransformer(true, new CubeOutViewPagerTransformer());
            this.joO.addOnPageChangeListener(this.jpq);
            this.joO.setmDisallowSlip(true);
            this.joO.setOnTouchEventListener(this.jpr);
            this.joQ = (OvalActionButton) this.joI.findViewById(R.id.frs_post_forum_button);
            this.joQ.setIsCircle(true);
            this.joQ.setHasShadow(false);
            this.iXp = (FRSRefreshButton) this.joI.findViewById(R.id.frs_refresh_forum_button);
            this.iTa = (LinearLayout) this.joI.findViewById(R.id.frs_ll_redpack);
            this.joI.registerListener(this.jpl);
            this.joI.registerListener(this.jpm);
            this.jpe.getHttpMessageListener().setPriority(-1);
            this.jpe.getSocketMessageListener().setPriority(-1);
            this.joI.registerListener(this.jpf);
            this.jph.setSelfListener(true);
            this.joI.registerListener(this.jph);
            this.jpg.setSelfListener(true);
            this.joI.registerListener(this.jpg);
            this.joI.registerListener(this.mAccountChangedListener);
            if (bundle == null) {
                this.mForumName = this.joI.getIntent().getStringExtra("name");
                this.mFrom = this.joI.getIntent().getStringExtra("from");
                this.iXm = this.joI.getIntent().getIntExtra(FrsActivityConfig.FRS_GAME_DEFAULT_TAB_ID, 0);
            } else {
                this.mForumName = bundle.getString("name");
                this.mFrom = bundle.getString("from");
                this.iXm = bundle.getInt("default_tab_id", 0);
            }
            ap(bundle);
            this.joP.notifyDataSetChanged();
            this.joM = new ShareSuccessReplyToServerModel();
            this.joI.registerListener(this.jpe);
            this.joI.registerListener(this.jpc);
            this.joI.registerListener(this.jpd);
            this.joI.registerListener(this.jpj);
        }
    }

    public void onSaveInstanceState(Bundle bundle) {
        bundle.putString("name", this.mForumName);
        bundle.putInt("default_tab_id", this.iXm);
        bundle.putString("from", this.mFrom);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ap(Bundle bundle) {
        FragmentManager fragmentManager = getFragmentManager();
        if (fragmentManager != null && !fragmentManager.isDestroyed() && this.joP != null) {
            try {
                FrsFragment frsFragment = (FrsFragment) this.joP.Lo(joG);
                if (frsFragment == null) {
                    frsFragment = aq(bundle);
                }
                frsFragment.b(this.joQ);
                frsFragment.a(this.iXp);
                frsFragment.c(this.iTa);
                if (!joG.equals(this.joP.Be(0))) {
                    if (joH.equals(this.joP.Be(0))) {
                        this.joP.Bd(0);
                    }
                    this.joP.a(0, frsFragment);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cIj() {
        FragmentManager fragmentManager = getFragmentManager();
        if (fragmentManager != null && !fragmentManager.isDestroyed() && this.joP != null) {
            try {
                FrsTabHostFragment frsTabHostFragment = (FrsTabHostFragment) this.joP.Lo(joH);
                if (frsTabHostFragment == null) {
                    frsTabHostFragment = cIk();
                }
                frsTabHostFragment.b(this.joQ);
                frsTabHostFragment.b(this.iXp);
                if (!joH.equals(this.joP.Be(0))) {
                    if (joG.equals(this.joP.Be(0))) {
                        this.joP.Bd(0);
                    }
                    this.joP.a(0, frsTabHostFragment);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private FrsFragment aq(Bundle bundle) {
        if (this.iXk == null) {
            this.iXk = new FrsFragment();
            this.iXk.setArguments(bundle);
            this.iXk.setBaseTag(joG);
        }
        this.iXk.iTh = false;
        return this.iXk;
    }

    private FrsTabHostFragment cIk() {
        if (this.joJ == null) {
            this.joJ = new FrsTabHostFragment(this);
            this.joJ.setBaseTag(joH);
            this.joJ.Ag(this.iXm);
        }
        return this.joJ;
    }

    private FragmentManager getFragmentManager() {
        if (this.joI != null) {
            return this.joI.getSupportFragmentManager();
        }
        return null;
    }

    private void cIl() {
        ThemeColorInfo themeColorInfo;
        ThemeElement themeElement;
        if (this.iXl != null && (themeColorInfo = this.iXl.getForum().getThemeColorInfo()) != null && themeColorInfo.day != null && themeColorInfo.night != null && themeColorInfo.dark != null) {
            int skinType = TbadkCoreApplication.getInst().getSkinType();
            if (skinType == 4) {
                themeElement = themeColorInfo.dark;
            } else if (skinType == 1) {
                themeElement = themeColorInfo.night;
            } else {
                themeElement = themeColorInfo.day;
            }
            this.joQ.setStartAndEndColor(themeElement.light_color, themeElement.dark_color);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(m mVar, boolean z, int i) {
        if (mVar != null && mVar.getForum() != null) {
            ForumData forum = mVar.getForum();
            if (z) {
                a(forum, mVar.getAnti());
            }
            if (forum.getIsShowBawuTask() && com.baidu.tbadk.core.sharedPref.b.bsO().getInt("key_bawu_task_toast", 0) == 0 && !this.joU) {
                this.joU = true;
                com.baidu.adp.lib.f.e.mY().postDelayed(new Runnable() { // from class: com.baidu.tieba.frs.gametab.FrsTabController.10
                    @Override // java.lang.Runnable
                    public void run() {
                        FrsTabController.this.cIr();
                    }
                }, 30000L);
            }
            if (mVar.bazhuExam != null && !this.joV && z) {
                com.baidu.tieba.frs.m.a(this.joI.getPageContext(), mVar.bazhuExam, forum.getId(), forum.getName());
                this.joV = true;
            }
            this.iXl = mVar;
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921476));
            if (y.getCount(mVar.getGameTabInfo()) > 0) {
                this.mHandler.post(new Runnable() { // from class: com.baidu.tieba.frs.gametab.FrsTabController.11
                    @Override // java.lang.Runnable
                    public void run() {
                        boolean du = FrsTabController.this.du(FrsTabController.this.iXl.getGameTabInfo());
                        if (du) {
                            FrsTabController.this.joP.notifyDataSetChanged();
                            if (du && FrsTabController.this.joJ != null) {
                                FrsTabController.this.joJ.Y(FrsTabController.this.iXk);
                                FrsTabController.this.joJ.a(FrsTabController.this.iXl, FrsTabController.this.iXj);
                            }
                        }
                        if (FrsTabController.this.joI.isLoadingViewAttached()) {
                            FrsTabController.this.joI.hideLoadingView(FrsTabController.this.joI.findViewById(16908290));
                        }
                    }
                });
            } else if (cIq()) {
                this.mHandler.post(new Runnable() { // from class: com.baidu.tieba.frs.gametab.FrsTabController.13
                    @Override // java.lang.Runnable
                    public void run() {
                        Bundle bundle;
                        FrsTabController.this.iXk.iTh = true;
                        if (FrsTabController.this.iXk != null) {
                            bundle = FrsTabController.this.iXk.getArguments();
                        } else {
                            bundle = null;
                        }
                        FrsTabController.this.ap(bundle);
                        FrsTabController.this.joP.notifyDataSetChanged();
                        if (FrsTabController.this.joI.isLoadingViewAttached()) {
                            FrsTabController.this.joI.hideLoadingView(FrsTabController.this.joI.findViewById(16908290));
                        }
                    }
                });
            }
            cIl();
            cIs();
            if (z) {
                if ((!this.joZ || i == 4) && forum.isLike() == 0 && com.baidu.tbadk.a.d.bkv() && TbadkCoreApplication.isLogin()) {
                    this.joX = new com.baidu.tieba.frs.f.e();
                    this.joI.registerListener(this.jpo);
                    this.joI.registerListener(this.jpn);
                    this.joI.registerListener(this.jpp);
                    d(forum);
                }
            }
        }
    }

    private void a(ForumData forumData, AntiData antiData) {
        if (forumData != null && !com.baidu.tbadk.youngster.b.a.a(this.joI.getPageContext(), antiData, R.id.frs) && !c(forumData)) {
            List<TipInfo> tipInfos = forumData.getTipInfos();
            if (!y.isEmpty(tipInfos)) {
                com.baidu.tbadk.youngster.b.a.a(this.joI.getPageContext(), tipInfos.get(0), TbadkCoreApplication.getCurrentAccount(), forumData.getId(), this.joI.getString(R.string.frs_risk_dialog_button_text));
            }
        }
    }

    private boolean c(ForumData forumData) {
        if (au.isEmpty(forumData.getRiskTipPop()) || au.isEmpty(forumData.getRiskTipPopTitle())) {
            return false;
        }
        final com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.joI);
        aVar.Bp(forumData.getRiskTipPopTitle());
        aVar.setTitleShowCenter(true);
        aVar.setMessageShowCenter(true);
        aVar.Bq(forumData.getRiskTipPop());
        aVar.a(R.string.frs_risk_dialog_button_text, new a.b() { // from class: com.baidu.tieba.frs.gametab.FrsTabController.14
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                aVar.dismiss();
            }
        });
        aVar.b(this.joI.getPageContext()).brv();
        return true;
    }

    public m cIm() {
        return this.iXl;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean du(List<FrsTabInfo> list) {
        if (this.joI.isLoadingViewAttached()) {
            this.joI.hideLoadingView(this.joI.findViewById(16908290));
        }
        if (cIq()) {
            return false;
        }
        this.iXk.iTh = true;
        cIn();
        if (com.baidu.tbadk.core.sharedPref.b.bsO().getBoolean("frs_game_login_tip", true)) {
            com.baidu.tbadk.core.sharedPref.b.bsO().putBoolean(SharedPrefConfig.FRS_LOGIN_TIP, true);
            com.baidu.tbadk.core.sharedPref.b.bsO().putBoolean("frs_game_login_tip", false);
        }
        dv(list);
        return true;
    }

    private void cIn() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1021074, TbConfig.SERVER_ADDRESS + "game/forum/getNewNotify");
        tbHttpMessageTask.setResponsedClass(AlaGameTabGetNewNotifyResponsedMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
        this.joI.registerListener(1021074, this.jpi);
    }

    private void dv(List<FrsTabInfo> list) {
        boolean z;
        if (!y.isEmpty(list)) {
            CustomMessageListener customMessageListener = new CustomMessageListener(CmdConfigCustom.CMD_GAME_FRS_ADD_TAB) { // from class: com.baidu.tieba.frs.gametab.FrsTabController.15
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.framework.listener.MessageListener
                public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                    if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof al)) {
                        if (!com.baidu.tbadk.core.sharedPref.b.bsO().getBoolean(FrsTabController.this.joL, true)) {
                            com.baidu.adp.lib.f.e.mY().post(FrsTabController.this.jpk);
                        }
                        ((al) customResponsedMessage.getData()).b(new com.baidu.tbadk.mainTab.b() { // from class: com.baidu.tieba.frs.gametab.FrsTabController.15.1
                            @Override // com.baidu.tbadk.mainTab.b
                            public boolean isAvailable() {
                                return true;
                            }

                            @Override // com.baidu.tbadk.mainTab.b
                            public com.baidu.tbadk.mainTab.c createFragmentTabStructure() {
                                FrsSportsRecommendFragment frsSportsRecommendFragment = new FrsSportsRecommendFragment();
                                Bundle bundle = new Bundle();
                                bundle.putString("name", FrsTabController.this.iXk.getForumName());
                                bundle.putString("from", FrsTabController.this.iXk.getFrom());
                                bundle.putString("forum_id", FrsTabController.this.iXk.getForumId());
                                bundle.putInt("tab_id", 503);
                                bundle.putBoolean("can_auto_play_video", FrsTabController.this.iXl.isFrsVideoAutoPlay);
                                bundle.putBoolean("need_log", FrsTabController.this.iXl.needLog == 1);
                                bundle.putBoolean("is_brand_forum", FrsTabController.this.iXl.isBrandForum);
                                FrsViewData frsViewData = new FrsViewData();
                                frsViewData.receiveData(FrsTabController.this.iXl);
                                bundle.putSerializable("view_data", frsViewData);
                                frsSportsRecommendFragment.setArguments(bundle);
                                com.baidu.tbadk.mainTab.c cVar = new com.baidu.tbadk.mainTab.c();
                                cVar.frag = frsSportsRecommendFragment;
                                cVar.type = 25;
                                cVar.showIconType = com.baidu.tbadk.mainTab.c.SHOWTEXT;
                                return cVar;
                            }

                            @Override // com.baidu.tbadk.mainTab.b
                            public TbFragmentTabIndicator getTabIndicator(Context context) {
                                this.mIndicator = (FragmentTabIndicator) LayoutInflater.from(context).inflate(R.layout.fragmenttabindicator, (ViewGroup) null);
                                this.mIndicator.setTextSize(2.0f);
                                return this.mIndicator;
                            }
                        });
                        FrsTabController.this.cIj();
                    }
                }
            };
            customMessageListener.setPriority(ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED);
            customMessageListener.setSelfListener(true);
            this.joI.registerListener(customMessageListener);
            ArrayList arrayList = new ArrayList();
            for (FrsTabInfo frsTabInfo : list) {
                if (frsTabInfo != null) {
                    Iterator it = arrayList.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            z = false;
                            break;
                        }
                        FrsTabInfo frsTabInfo2 = (FrsTabInfo) it.next();
                        if (frsTabInfo2 != null && frsTabInfo2.tab_id == frsTabInfo.tab_id) {
                            z = true;
                            break;
                        }
                    }
                    if (!z) {
                        arrayList.add(frsTabInfo);
                    }
                }
            }
            this.iXj = new al(this.joI.getActivity(), arrayList);
            if (cBr() != null) {
                this.iXj.setForumId(cBr().getForumId());
                this.iXj.setForumName(cBr().getForumName());
                if (cBr().cCK() != null && cBr().cCK().getForum() != null) {
                    ForumData forum = cBr().cCK().getForum();
                    this.iXj.setForumGameLabel(forum.getForumGameLabel());
                    this.iXj.IW(forum.getSpecialForumType());
                }
            }
            this.iXk.iTh = false;
            new e(this.iXk).a(this.iXj);
            CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(CmdConfigCustom.CMD_GAME_FRS_ADD_TAB, this.iXj);
            CustomMessage customMessage = new CustomMessage(CmdConfigCustom.CMD_GAME_FRS_ADD_TAB);
            customMessage.setTag(this.joI.getUniqueId());
            customResponsedMessage.setOrginalMessage(customMessage);
            MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cIo() {
        if (this.iXj != null && !TextUtils.isEmpty(this.iXj.getForumId())) {
            HttpMessage httpMessage = new HttpMessage(1021074);
            httpMessage.addParam("forum_id", this.iXl.getForum().getId());
            MessageManager.getInstance().sendMessage(httpMessage);
        }
    }

    private void a(Fragment fragment, int i) {
        NavigationBar bVL;
        if ((fragment instanceof as) && this.iXl != null && this.iXl.getForum() != null && (bVL = ((as) fragment).bVL()) != null) {
            StringBuilder sb = new StringBuilder();
            sb.append(UtilHelper.getFixedBarText(this.iXl.getForum().getName(), 5, true, true) + this.joI.getActivity().getString(R.string.forum));
            bVL.setCenterTextTitle(sb.toString());
        }
    }

    @Override // com.baidu.tieba.InjectPlugin.a.b
    public void a(int i, com.baidu.tieba.InjectPlugin.a.a aVar) {
        if (this.iXk instanceof com.baidu.tieba.InjectPlugin.a.b) {
            this.iXk.a(i, aVar);
        }
    }

    @Override // com.baidu.tieba.InjectPlugin.a.b
    public com.baidu.tieba.InjectPlugin.a.a ub(int i) {
        if (this.iXk instanceof com.baidu.tieba.InjectPlugin.a.b) {
            return this.iXk.ub(i);
        }
        return null;
    }

    @Override // com.baidu.tieba.InjectPlugin.a.b
    public void a(com.baidu.tieba.InjectPlugin.b bVar) {
        if (this.iXk instanceof com.baidu.tieba.InjectPlugin.a.b) {
            this.iXk.a(bVar);
        }
    }

    public void onNewIntent(Intent intent) {
        if (this.iXk != null) {
            this.iXk.onNewIntent(intent);
        }
    }

    public void onResume() {
        if (!cIq()) {
            this.iXk.setPrimary(true);
        } else if (this.joJ != null) {
            Fragment currentFragment = this.joJ.getCurrentFragment();
            if (currentFragment instanceof BaseFragment) {
                ((BaseFragment) currentFragment).setPrimary(true);
            }
        }
        if (this.joN) {
            this.joN = false;
            if (this.iXk != null) {
                this.iXk.refresh();
            }
        }
        if (this.iXl != null && this.iXl.getUserData() != null && this.iXl.getUserData().getNewGodData() != null) {
            if (this.iXl.getForum() != null) {
                w.bGH().setFid(this.iXl.getForum().getId());
            }
            w.bGH().b(2, this.iXl.getUserData().getNewGodData());
        }
        this.jpb = true;
        if (this.jpa) {
            e((ForumData) null);
        }
    }

    public void onPause() {
        this.jpb = false;
        if (this.joX != null) {
            this.joX.cKe();
        }
        if (!cIq()) {
            this.iXk.setPrimary(false);
        } else if (this.joJ != null) {
            Fragment currentFragment = this.joJ.getCurrentFragment();
            if (currentFragment instanceof BaseFragment) {
                ((BaseFragment) currentFragment).setPrimary(false);
            }
        }
        w.bGH().removeCallbacks();
    }

    public void onChangeSkinType(int i) {
        UtilHelper.changeStatusBarIconAndTextColor(true, this.joI);
        if (this.iXk != null) {
            this.iXk.onChangeSkinType(i);
        }
        if (this.joJ != null) {
            this.joJ.onChangeSkinType(i);
        }
        cIl();
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            if (cIq() && this.joJ != null && this.joJ.cDQ()) {
                this.joJ.cEh();
                UtilHelper.setNavigationBarBackground(this.joI, this.joJ.cEc());
            } else if (this.iXk != null && this.iXk.isAdded()) {
                if (this.iXk.onKeyDown(i, keyEvent)) {
                    return true;
                }
                cIp();
            } else {
                return this.joI.b(i, keyEvent);
            }
        } else if (i == 24) {
            if (this.iXk != null && this.iXk.isAdded()) {
                return this.iXk.onKeyDown(i, keyEvent);
            }
        } else {
            return this.joI.b(i, keyEvent);
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cIp() {
        if (this.iXn != this.iXm && cIq()) {
            this.joJ.setCurrentTab(this.iXm);
            if (Ae(this.iXm) != 1) {
                this.iXk.pW(false);
            }
            this.iXn = this.iXm;
            a(this.joJ.getCurrentFragment(), this.iXm);
            return;
        }
        this.iXk.closeActivity();
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: com.baidu.tieba.frs.FrsActivity */
    /* JADX DEBUG: Multi-variable search result rejected for r2v1, resolved type: com.baidu.tieba.frs.FrsActivity */
    /* JADX WARN: Multi-variable type inference failed */
    public void onActivityResult(int i, int i2, Intent intent) {
        if (!cIq()) {
            this.iXk.onActivityResult(i, i2, intent);
        } else if (this.joJ != null) {
            if (1 == this.joJ.getCurrentTabType()) {
                this.iXk.onActivityResult(i, i2, intent);
            } else {
                this.joJ.getCurrentFragment().onActivityResult(i, i2, intent);
            }
        }
        if (i2 == -1) {
            if (i == 24007) {
                int intExtra = intent.getIntExtra("extra_share_status", 2);
                int intExtra2 = intent.getIntExtra("extra_show_channel", 1);
                if (intExtra == 1) {
                    com.baidu.tieba.p.a.dEL().F(this.joI.getPageContext());
                    ShareItem shareItem = TbadkCoreApplication.getInst().getShareItem();
                    if (shareItem != null && shareItem.linkUrl != null && this.joM != null) {
                        this.joM.a(shareItem.linkUrl, intExtra2, new ShareSuccessReplyToServerModel.a() { // from class: com.baidu.tieba.frs.gametab.FrsTabController.16
                            @Override // com.baidu.tbadk.coreExtra.model.ShareSuccessReplyToServerModel.a
                            public void bzM() {
                            }

                            @Override // com.baidu.tbadk.coreExtra.model.ShareSuccessReplyToServerModel.a
                            public void a(final CustomDialogData customDialogData) {
                                com.baidu.adp.lib.f.e.mY().postDelayed(new Runnable() { // from class: com.baidu.tieba.frs.gametab.FrsTabController.16.1
                                    @Override // java.lang.Runnable
                                    public void run() {
                                        if (FrsTabController.this.joI != null) {
                                            com.baidu.tieba.pb.interactionpopupwindow.c.a(FrsTabController.this.joI.getPageContext(), customDialogData).show();
                                        }
                                    }
                                }, 1000L);
                            }
                        });
                    }
                }
            } else if (i == 13011) {
                com.baidu.tieba.p.a.dEL().F(this.joI.getPageContext());
            }
        }
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager getVoiceManager() {
        if (!cIq()) {
            return this.iXk.getVoiceManager();
        }
        if (this.joJ == null) {
            return null;
        }
        Fragment currentFragment = this.joJ.getCurrentFragment();
        if (currentFragment instanceof VoiceManager.c) {
            return ((VoiceManager.c) currentFragment).getVoiceManager();
        }
        return null;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager.b d(VoiceData.VoiceModel voiceModel) {
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int Ac(int i) {
        if (this.iXj == null) {
            return -1;
        }
        int count = y.getCount(this.iXj.bBY());
        for (int i2 = 0; i2 < count; i2++) {
            if (this.iXj.bBY().get(i2).tab_id.intValue() == i) {
                return i2;
            }
        }
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int Ae(int i) {
        if (this.iXj != null && i < y.getCount(this.iXj.bBY())) {
            return this.iXj.bBY().get(i).tab_id.intValue();
        }
        return -1;
    }

    public FrsFragment cBr() {
        return this.iXk;
    }

    @Override // com.baidu.tieba.tbadkCore.FrsCommonImageLayout.c
    public com.baidu.adp.lib.d.b<TbImageView> cBs() {
        if (!cIq()) {
            if (this.iXk instanceof FrsCommonImageLayout.c) {
                return ((FrsCommonImageLayout.c) this.iXk).cBs();
            }
        } else if (this.joJ == null) {
            return null;
        } else {
            Fragment currentFragment = this.joJ.getCurrentFragment();
            if (currentFragment instanceof FrsCommonImageLayout.c) {
                return ((FrsCommonImageLayout.c) currentFragment).cBs();
            }
        }
        return null;
    }

    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(t.iWv);
        this.mHandler.removeCallbacksAndMessages(null);
        if (this.joI.isLoadingViewAttached()) {
            this.joI.hideLoadingView(this.joI.findViewById(16908290));
        }
        if (this.jpk != null) {
            com.baidu.adp.lib.f.e.mY().removeCallbacks(this.jpk);
        }
        com.baidu.tbadk.core.sharedPref.b.bsO().putBoolean(this.joL, false);
        if (this.joM != null) {
            this.joM.cancelLoadData();
        }
        if (this.iXk != null && this.iXk.cCa() != null) {
            this.iXk.cCa().cID();
        }
        if (this.joT != null) {
            this.joT.onDestroy();
        }
        if (FrsActivityConfig.FRS_FROM_FLUTTER_BCASTEDIT.equals(this.mFrom)) {
            new o(TbadkCoreApplication.getInst()).bte();
        }
        if (FrsActivityConfig.FRS_FROM_FORUM_RULE_EDIT.equals(this.mFrom)) {
            com.baidu.tbadk.k.d.bDH().kI(false);
        }
        if (this.joY != null) {
            com.baidu.adp.lib.f.e.mY().removeCallbacks(this.joY);
        }
        if (this.iXl != null && this.iXl.getForum() != null && this.joX != null) {
            this.joX.gs(com.baidu.adp.lib.f.b.toLong(this.iXl.getForum().getId(), 0L));
        }
    }

    public FragmentTabHost cEf() {
        if (this.joJ == null) {
            return null;
        }
        return this.joJ.cEf();
    }

    public boolean cIq() {
        if (this.joP == null) {
            return false;
        }
        return this.joP.getItem(0) instanceof FrsTabHostFragment;
    }

    public void Ag(int i) {
        this.iXm = i;
    }

    public void Bb(int i) {
        this.iXn = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cIr() {
        if (this.joI != null) {
            if (this.joT == null) {
                this.joT = (NavigationBarCoverTip) this.joI.findViewById(R.id.navigation_cover_tip);
            }
            if (this.joT != null) {
                View inflate = View.inflate(this.joI, R.layout.write_thread_share_guide, null);
                TextView textView = (TextView) inflate.findViewById(R.id.write_thread_success_tips);
                TBSpecificationBtn tBSpecificationBtn = (TBSpecificationBtn) inflate.findViewById(R.id.share_icon);
                if (TextUtils.isEmpty(this.mForumName)) {
                    textView.setText("吧主您好，本吧考核新制度上线啦");
                } else {
                    textView.setText(this.mForumName + "吧吧主您好，本吧考核新制度上线啦");
                }
                tBSpecificationBtn.setTextSize(R.dimen.tbds34);
                tBSpecificationBtn.setText(TbadkCoreApplication.getInst().getResources().getString(R.string.check_immediately));
                com.baidu.tbadk.core.view.commonBtn.c cVar = new com.baidu.tbadk.core.view.commonBtn.c();
                cVar.bwd();
                tBSpecificationBtn.setConfig(cVar);
                tBSpecificationBtn.bvt();
                ap.setViewTextColor(textView, R.color.CAM_X0101);
                ap.setBackgroundColor(this.joT, R.color.cp_link_tip_a_alpha95);
                tBSpecificationBtn.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.gametab.FrsTabController.17
                    /* JADX DEBUG: Multi-variable search result rejected for r4v9, resolved type: com.baidu.tieba.frs.FrsActivity */
                    /* JADX WARN: Multi-variable type inference failed */
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        new ar("c13439").btT();
                        if (FrsTabController.this.cBr() != null && !TextUtils.isEmpty(FrsTabController.this.cBr().getForumId()) && !TextUtils.isEmpty(FrsTabController.this.mForumName) && FrsTabController.this.joI != null) {
                            if (FrsTabController.this.joT != null) {
                                FrsTabController.this.joT.hideTip();
                            }
                            bf.bua().b(FrsTabController.this.joI.getPageContext(), new String[]{"https://tieba.baidu.com/mo/q/bawutask?fid=" + FrsTabController.this.cBr().getForumId() + "&fn=" + FrsTabController.this.mForumName + "&noread=" + (com.baidu.tbadk.core.sharedPref.b.bsO().getInt("key_bawu_task_toast", 0) == -1 ? 1 : 0)});
                        }
                    }
                });
                this.joT.a(this.joI, inflate, 30000);
                new ar("c13438").btT();
                int i = com.baidu.tbadk.core.sharedPref.b.bsO().getInt("key_bawu_task_toast", 0);
                if (i >= 0) {
                    com.baidu.tbadk.core.sharedPref.b.bsO().putInt("key_bawu_task_toast", i + 1);
                }
            }
        }
    }

    private void cIs() {
        boolean z;
        if (this.iXl != null && this.iXl.getEntelechyTabInfo() != null && this.iXl.getEntelechyTabInfo().tab != null) {
            Iterator<FrsTabInfo> it = this.iXl.getEntelechyTabInfo().tab.iterator();
            while (true) {
                if (!it.hasNext()) {
                    z = false;
                    break;
                } else if (it.next().tab_type.intValue() == 16) {
                    z = true;
                    break;
                }
            }
            if (z) {
                if (this.joW == null) {
                    this.joW = new com.baidu.tieba.d.e(this.joI.getPageContext(), this.joQ);
                    this.joW.fO(R.drawable.pic_sign_tip_down);
                    this.joW.setAnchor(2);
                    this.joW.setUseDirectOffset(true);
                    this.joW.yt(-l.getDimens(this.joI, R.dimen.tbds20));
                    this.joW.setYOffset(-l.getDimens(this.joI, R.dimen.tbds20));
                    this.joW.setTextColor(R.color.CAM_X0101);
                    this.joW.setHeight(R.dimen.tbds54);
                    this.joW.yr(l.getDimens(this.joI, R.dimen.tbds44));
                }
                this.joW.aP(this.joI.getString(R.string.frs_evaluate_tip), "first_into_frs_with_evaluate_tab");
            }
        }
    }

    private void d(final ForumData forumData) {
        boolean z = false;
        if (g(forumData.getName(), forumData.getId(), forumData.getImage_url(), false)) {
            if (this.joY != null) {
                com.baidu.adp.lib.f.e.mY().removeCallbacks(this.joY);
            }
            z = true;
        }
        if (!this.joZ) {
            this.joX.cKd().i(TbadkCoreApplication.getCurrentAccount(), forumData.getId(), System.currentTimeMillis());
            this.joZ = true;
        }
        if (!z) {
            this.joY = this.joY != null ? this.joY : new Runnable() { // from class: com.baidu.tieba.frs.gametab.FrsTabController.18
                @Override // java.lang.Runnable
                public void run() {
                    if (FrsTabController.this.joX != null) {
                        if (FrsTabController.this.jpb) {
                            FrsTabController.this.g(forumData.getName(), forumData.getId(), forumData.getImage_url(), true);
                        } else {
                            FrsTabController.this.jpa = true;
                        }
                    }
                }
            };
            com.baidu.adp.lib.f.e.mY().postDelayed(this.joY, 60000L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(ForumData forumData) {
        if (this.iXk.cCc() != null && this.joX != null) {
            if (forumData == null) {
                forumData = this.iXl.getForum();
            }
            if (forumData != null && forumData.isLike() != 1) {
                if (!this.jpb) {
                    this.jpa = true;
                } else if (g(forumData.getName(), forumData.getId(), forumData.getImage_url(), false) && this.joY != null) {
                    com.baidu.adp.lib.f.e.mY().removeCallbacks(this.joY);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean g(String str, String str2, String str3, boolean z) {
        if (!this.joX.ff(TbadkCoreApplication.getCurrentAccount(), str2) || this.iXk == null || this.iXk.cCc() == null) {
            return false;
        }
        this.jpa = false;
        this.joX.a(this.joI, str, str2, str3, this.iXk.cCc().cKW());
        this.joX.cKd().a(TbadkCoreApplication.getCurrentAccount(), str2, System.currentTimeMillis(), z);
        return true;
    }

    public boolean gq(long j) {
        ForumData forum;
        return (this.iXl == null || j == 0 || (forum = this.iXl.getForum()) == null || com.baidu.adp.lib.f.b.toLong(forum.getId(), 0L) != j) ? false : true;
    }

    /* loaded from: classes22.dex */
    public class FragmentAdapter extends FragmentStatePagerAdapter {
        private List<BaseFragment> mFragments;

        public FragmentAdapter(FragmentManager fragmentManager) {
            super(fragmentManager);
            this.mFragments = new ArrayList(2);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.support.v4.app.FragmentStatePagerAdapter
        /* renamed from: Bc */
        public BaseFragment getItem(int i) {
            return (BaseFragment) y.getItem(this.mFragments, i);
        }

        @Override // android.support.v4.view.PagerAdapter
        public int getCount() {
            return this.mFragments.size();
        }

        @Override // android.support.v4.view.PagerAdapter
        public int getItemPosition(Object obj) {
            return -2;
        }

        public boolean a(int i, BaseFragment baseFragment) {
            return y.add(this.mFragments, i, baseFragment);
        }

        public BaseFragment Lo(String str) {
            if (au.isEmpty(str)) {
                return null;
            }
            for (BaseFragment baseFragment : this.mFragments) {
                if (baseFragment != null && str.equals(baseFragment.getBaseTag())) {
                    return baseFragment;
                }
            }
            return null;
        }

        public BaseFragment Bd(int i) {
            return (BaseFragment) y.remove(this.mFragments, i);
        }

        public String Be(int i) {
            if (getItem(i) != null) {
                return getItem(i).getBaseTag();
            }
            return null;
        }
    }

    public TbPageTag getTbPageTag() {
        if (!cIq()) {
            return this.iXk.getTbPageTag();
        }
        if (this.joJ != null) {
            if (1 == this.joJ.getCurrentTabType()) {
                return this.iXk.getTbPageTag();
            }
            Fragment currentFragment = this.joJ.getCurrentFragment();
            if (currentFragment instanceof BaseFragment) {
                return ((BaseFragment) currentFragment).getTbPageTag();
            }
        }
        return null;
    }

    public void onScreenShot(String str) {
        if (this.iXl != null && this.iXl.getForum() != null) {
            TiebaStatic.log(new ar("c13848").dY("uid", TbadkCoreApplication.getCurrentAccount()).dY("fid", this.iXl.getForum().getId()).al("obj_type", 2));
        }
    }
}
