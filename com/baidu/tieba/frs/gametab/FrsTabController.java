package com.baidu.tieba.frs.gametab;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.viewpager.widget.ViewPager;
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
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.util.au;
import com.baidu.tbadk.core.util.bf;
import com.baidu.tbadk.core.util.p;
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
import com.baidu.tbadk.util.x;
import com.baidu.tbadk.widget.FRSRefreshButton;
import com.baidu.tbadk.widget.OvalActionButton;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.flutter.util.OpenFlutter;
import com.baidu.tieba.frs.CubeOutViewPagerTransformer;
import com.baidu.tieba.frs.FrsActivity;
import com.baidu.tieba.frs.FrsBaseViewPager;
import com.baidu.tieba.frs.FrsFragment;
import com.baidu.tieba.frs.FrsNoListItemViewHolder;
import com.baidu.tieba.frs.FrsRecommendResMsg;
import com.baidu.tieba.frs.FrsTabHostFragment;
import com.baidu.tieba.frs.FrsTabViewPager;
import com.baidu.tieba.frs.ai;
import com.baidu.tieba.frs.ap;
import com.baidu.tieba.frs.sportspage.FrsSportsRecommendFragment;
import com.baidu.tieba.frs.view.FrsForumToolDialogView;
import com.baidu.tieba.pb.interactionpopupwindow.CustomDialogData;
import com.baidu.tieba.tbadkCore.FRSPageSocketResponsedMessage;
import com.baidu.tieba.tbadkCore.FrsCommonImageLayout;
import com.baidu.tieba.tbadkCore.FrsPageHttpResponseMessage;
import com.baidu.tieba.tbadkCore.FrsViewData;
import com.baidu.tieba.tbadkCore.m;
import com.baidu.tieba.view.BdTopToast;
import com.baidu.tieba.view.NavigationBarCoverTip;
import com.baidu.tieba.view.ScreenTopToast;
import com.kwad.sdk.collector.AppStatusRules;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import tbclient.FrsPage.TipInfo;
import tbclient.FrsTabInfo;
import tbclient.ThemeColorInfo;
import tbclient.ThemeElement;
/* loaded from: classes2.dex */
public class FrsTabController implements VoiceManager.c, com.baidu.tieba.InjectPlugin.a.b, FrsCommonImageLayout.c {
    public static final String jCr = FrsFragment.class.getSimpleName();
    public static final String jCs = FrsTabHostFragment.class.getSimpleName();
    private FragmentAdapter jCA;
    private OvalActionButton jCB;
    private boolean jCC;
    private boolean jCD;
    private NavigationBarCoverTip jCE;
    private com.baidu.tieba.c.e jCH;
    private com.baidu.tieba.frs.d.e jCI;
    private Runnable jCJ;
    private boolean jCK;
    private FrsActivity jCt;
    private FrsTabHostFragment jCu;
    private ShareSuccessReplyToServerModel jCx;
    private FrsBaseViewPager jCz;
    private LinearLayout jgy;
    private ai jkJ;
    private FrsFragment jkK;
    private m jkL;
    private int jkN;
    private FRSRefreshButton jkP;
    private String mForumName;
    private String mFrom;
    private boolean jCv = false;
    private final Handler mHandler = new Handler();
    private int jkM = 0;
    private boolean jCy = false;
    private boolean jCF = false;
    private boolean jCG = false;
    private boolean jCL = false;
    private boolean jCM = false;
    private HttpMessageListener jCN = new HttpMessageListener(CmdConfigHttp.CMD_FRS_RECOMMEND) { // from class: com.baidu.tieba.frs.gametab.FrsTabController.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage instanceof FrsRecommendResMsg) {
                if (httpResponsedMessage.getError() != 0) {
                    new BdTopToast(FrsTabController.this.jCt).zn(false).UZ(httpResponsedMessage.getErrorString()).aR((ViewGroup) FrsTabController.this.jCt.findViewById(R.id.frs));
                    return;
                }
                int pushStatus = ((FrsRecommendResMsg) httpResponsedMessage).getPushStatus();
                String pushMsg = ((FrsRecommendResMsg) httpResponsedMessage).getPushMsg();
                if (pushStatus == 1) {
                    new ScreenTopToast(FrsTabController.this.jCt).Ve(FrsTabController.this.jCt.getString(R.string.frs_recommend_suc_tip_title)).Vf(FrsTabController.this.jCt.getString(R.string.frs_recommend_suc_tip_content)).Vg(FrsTabController.this.jCt.getString(R.string.dialog_confirm_see)).an(new View.OnClickListener() { // from class: com.baidu.tieba.frs.gametab.FrsTabController.1.1
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view) {
                            HashMap hashMap = new HashMap();
                            hashMap.put("_forumId", FrsTabController.this.jkL.getForum().getId());
                            MessageManager.getInstance().sendMessage(new CustomMessage(2002015, new com.baidu.tieba.tbadkCore.data.m(FrsTabController.this.jCt, "RecommendHistoryPage", hashMap)));
                        }
                    }).aR((ViewGroup) FrsTabController.this.jCt.findViewById(R.id.frs));
                } else {
                    new BdTopToast(FrsTabController.this.jCt).zn(false).UZ(pushMsg).aR((ViewGroup) FrsTabController.this.jCt.findViewById(R.id.frs));
                }
            }
        }
    };
    private CustomMessageListener jCO = new CustomMessageListener(2921465) { // from class: com.baidu.tieba.frs.gametab.FrsTabController.12
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            new ScreenTopToast(FrsTabController.this.jCt).Ve(FrsTabController.this.jCt.getString(R.string.frs_recommend_fail_month_tip)).Vg(FrsTabController.this.jCt.getString(R.string.frs_recommend_fail_tip_btn)).an(new View.OnClickListener() { // from class: com.baidu.tieba.frs.gametab.FrsTabController.12.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    HashMap hashMap = new HashMap();
                    hashMap.put("_forumId", FrsTabController.this.jkL.getForum().getId());
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002015, new com.baidu.tieba.tbadkCore.data.m(FrsTabController.this.jCt, "ForumGradePage", hashMap)));
                }
            }).aR((ViewGroup) FrsTabController.this.jCt.findViewById(R.id.frs));
        }
    };
    private com.baidu.adp.framework.listener.a jCP = new com.baidu.adp.framework.listener.a(1001703, CmdConfigSocket.CMD_FRS_PAGE) { // from class: com.baidu.tieba.frs.gametab.FrsTabController.21
        @Override // com.baidu.adp.framework.listener.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            m mVar = null;
            int i = -1;
            if (!FrsTabController.this.jCv && !responsedMessage.hasError() && responsedMessage.getError() == 0) {
                if (responsedMessage instanceof FrsPageHttpResponseMessage) {
                    mVar = ((FrsPageHttpResponseMessage) responsedMessage).getResponseData();
                    i = ((FrsPageHttpResponseMessage) responsedMessage).getUpdateType();
                } else if (responsedMessage instanceof FRSPageSocketResponsedMessage) {
                    mVar = ((FRSPageSocketResponsedMessage) responsedMessage).getResponseData();
                    i = ((FRSPageSocketResponsedMessage) responsedMessage).getUpdateType();
                }
                if (mVar != null) {
                    FrsTabController.this.jCv = true;
                    FrsTabController.this.a(mVar, true, i);
                    if (mVar != null && mVar.getForum() != null && !StringUtils.isNull(mVar.getForum().getId())) {
                        com.baidu.tbadk.core.business.b.blh().dC("2", mVar.getForum().getId());
                    }
                }
                if (mVar != null && mVar.getUserData() != null && mVar.getUserData().getNewGodData() != null) {
                    if (mVar.getForum() != null) {
                        x.bFC().setFid(mVar.getForum().getId());
                    }
                    x.bFC().b(2, mVar.getUserData().getNewGodData());
                }
            }
        }
    };
    private CustomMessageListener jCQ = new CustomMessageListener(CmdConfigCustom.CMD_GET_FRS_PAGE_CACHE) { // from class: com.baidu.tieba.frs.gametab.FrsTabController.22
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (!FrsTabController.this.jCv && FrsTabController.this.jkL == null && customResponsedMessage != null && (customResponsedMessage.getData() instanceof m)) {
                m mVar = (m) customResponsedMessage.getData();
                if (mVar.getForum() != null && FrsTabController.this.mForumName != null && FrsTabController.this.mForumName.equals(mVar.getForum().getName())) {
                    FrsTabController.this.a(mVar, false, -1);
                }
            }
        }
    };
    private CustomMessageListener jCR = new CustomMessageListener(CmdConfigCustom.CMD_CLICK_CLOSE_GAME_FRS_CONFIRM) { // from class: com.baidu.tieba.frs.gametab.FrsTabController.23
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            FrsTabController.this.cIS();
        }
    };
    private CustomMessageListener jCS = new CustomMessageListener(CmdConfigCustom.CMD_GAME_FRS_TAB_CHANGE) { // from class: com.baidu.tieba.frs.gametab.FrsTabController.24
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            int yS;
            if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof Integer)) {
                int intValue = ((Integer) customResponsedMessage.getData()).intValue();
                if (10001 == intValue) {
                    yS = FrsTabController.this.yS(9);
                    if (yS == -1) {
                        yS = FrsTabController.this.yS(2);
                    }
                } else {
                    yS = FrsTabController.this.yS(intValue);
                }
                if (yS != -1 && FrsTabController.this.cIT() && FrsTabController.this.jCu != null) {
                    FrsTabController.this.jCu.setCurrentTab(yS);
                    if (FrsTabController.this.yU(yS) != 1) {
                        FrsTabController.this.jkK.qz(false);
                    }
                }
            }
        }
    };
    private HttpMessageListener jCT = new HttpMessageListener(0) { // from class: com.baidu.tieba.frs.gametab.FrsTabController.25
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && 1021074 == httpResponsedMessage.getCmd() && (httpResponsedMessage instanceof AlaGameTabGetNewNotifyResponsedMessage)) {
                List<a> newNotifyData = ((AlaGameTabGetNewNotifyResponsedMessage) httpResponsedMessage).getNewNotifyData();
                if (!y.isEmpty(newNotifyData) && FrsTabController.this.jCu != null) {
                    for (a aVar : newNotifyData) {
                        if (aVar != null) {
                            for (int i = 0; i < FrsTabController.this.jkJ.bAS().size(); i++) {
                                FragmentTabHost.b ot = FrsTabController.this.jCu.ot(i);
                                if (ot != null && ot.mType != 1 && ot.mType != FrsTabController.this.jCu.getCurrentTabType() && ot.mType == aVar.getTabId() && aVar.cIH() && ot.eZk.Dl(String.valueOf(ot.mType)) != null) {
                                    ot.eZk.Dl(String.valueOf(ot.mType)).view.setVisibility(0);
                                }
                            }
                        }
                    }
                }
            }
        }
    };
    private CustomMessageListener jCU = new CustomMessageListener(2921518) { // from class: com.baidu.tieba.frs.gametab.FrsTabController.26
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            new BdTopToast(FrsTabController.this.jCt, 2000).zn(false).UZ(FrsTabController.this.jCt.getString(R.string.frs_top_forum_rules_click_toast)).aR((ViewGroup) FrsTabController.this.jCt.findViewById(R.id.frs));
        }
    };
    private Runnable jCV = new Runnable() { // from class: com.baidu.tieba.frs.gametab.FrsTabController.27
        @Override // java.lang.Runnable
        public void run() {
            com.baidu.adp.lib.f.e.mA().removeCallbacks(this);
            FrsTabController.this.cIR();
            com.baidu.adp.lib.f.e.mA().postDelayed(this, 30000L);
        }
    };
    private CustomMessageListener mAccountChangedListener = new CustomMessageListener(CmdConfigCustom.METHOD_ACCOUNT_CHANGE) { // from class: com.baidu.tieba.frs.gametab.FrsTabController.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2005016) {
                FrsTabController.this.jCy = true;
            }
        }
    };
    private CustomMessageListener jCW = new CustomMessageListener(2921369) { // from class: com.baidu.tieba.frs.gametab.FrsTabController.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && FrsTabController.this.jCz != null && FrsTabController.this.jCA != null && (customResponsedMessage.getData() instanceof FrsTabViewPager.a)) {
                FrsTabViewPager.a aVar = (FrsTabViewPager.a) customResponsedMessage.getData();
                FrsTabController.this.jCC = aVar.cEJ();
                FrsTabController.this.jCD = aVar.cEK();
            }
        }
    };
    private CustomMessageListener jCX = new CustomMessageListener(2921370) { // from class: com.baidu.tieba.frs.gametab.FrsTabController.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && FrsTabController.this.jCz != null && FrsTabController.this.jCA != null && (customResponsedMessage.getData() instanceof Boolean)) {
                FrsTabController.this.jCz.setForceIntercept(((Boolean) customResponsedMessage.getData()).booleanValue());
            }
        }
    };
    private CustomMessageListener jCY = new CustomMessageListener(CmdConfigCustom.CMD_NEW_WRITE_POST_SUCCESS) { // from class: com.baidu.tieba.frs.gametab.FrsTabController.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (((Boolean) customResponsedMessage.getData()).booleanValue()) {
                FrsTabController.this.e((ForumData) null);
            }
        }
    };
    private CustomMessageListener jCZ = new CustomMessageListener(2921498) { // from class: com.baidu.tieba.frs.gametab.FrsTabController.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (FrsTabController.this.jCI != null && customResponsedMessage != null && customResponsedMessage.getData() != null) {
                if (customResponsedMessage.getData() instanceof ForumData) {
                    FrsTabController.this.e((ForumData) customResponsedMessage.getData());
                } else if (customResponsedMessage.getData() instanceof Long) {
                    long longValue = ((Long) customResponsedMessage.getData()).longValue();
                    if (FrsTabController.this.gv(longValue) && FrsTabController.this.jCI.gw(longValue) >= 3) {
                        FrsTabController.this.jCI.gx(longValue);
                        FrsTabController.this.jCL = true;
                    }
                }
            }
        }
    };
    private CustomMessageListener jDa = new CustomMessageListener(CmdConfigCustom.CMD_PERSON_LIKE_FORUM) { // from class: com.baidu.tieba.frs.gametab.FrsTabController.7
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.tbadkCore.writeModel.e)) {
                com.baidu.tieba.tbadkCore.writeModel.e eVar = (com.baidu.tieba.tbadkCore.writeModel.e) customResponsedMessage.getData();
                if (FrsTabController.this.jCI != null && eVar != null && TbadkCoreApplication.isLogin()) {
                    FrsTabController.this.jCI.fe(TbadkCoreApplication.getCurrentAccount(), String.valueOf(eVar.forumId));
                }
            }
        }
    };
    private ViewPager.OnPageChangeListener jDb = new ViewPager.OnPageChangeListener() { // from class: com.baidu.tieba.frs.gametab.FrsTabController.8
        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrolled(int i, float f, int i2) {
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            if (i != 1) {
                FrsTabController.this.jCB.setVisibility(0);
                if (FrsTabController.this.cBL() != null) {
                    FrsTabController.this.cBL().qt(false);
                }
                FrsTabController.this.jkK.cDf();
            }
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i) {
            switch (i) {
                case 0:
                    FrsTabController.this.jCD = false;
                    FrsTabController.this.jCz.setForceIntercept(false);
                    return;
                default:
                    return;
            }
        }
    };
    private FrsBaseViewPager.a jDc = new FrsBaseViewPager.a() { // from class: com.baidu.tieba.frs.gametab.FrsTabController.9
        @Override // com.baidu.tieba.frs.FrsBaseViewPager.a
        public void cCh() {
            if (FrsTabController.this.jCz != null) {
                if (FrsTabController.this.jCz.getCurrentItem() == 0) {
                    FrsTabController.this.jCz.setmDisallowSlip(true);
                } else {
                    FrsTabController.this.jCz.setmDisallowSlip(false);
                }
            }
        }

        @Override // com.baidu.tieba.frs.FrsBaseViewPager.a
        public boolean cCi() {
            if (FrsTabController.this.jCz.getCurrentItem() == 0) {
                if (FrsTabController.this.jCC && FrsTabController.this.jCD) {
                    FrsTabController.this.jCz.setmDisallowSlip(false);
                }
                if (!FrsTabController.this.jCD) {
                    FrsTabController.this.jCz.setmDisallowSlip(true);
                }
                FrsTabController.this.jCz.setmDisallowSlip(true);
            } else {
                FrsTabController.this.jCz.setmDisallowSlip(true);
            }
            return true;
        }
    };
    private String jCw = com.baidu.tbadk.core.sharedPref.b.getSharedPrefKeyWithAccount(SharedPrefConfig.SHOW_GAME_FOREM_TAB_HOT_POINT);

    public FrsTabController(FrsActivity frsActivity) {
        this.jCt = frsActivity;
    }

    public void init(Bundle bundle) {
        if (this.jCt != null) {
            this.jCt.setContentView(R.layout.frs_base_layout);
            this.jCz = (FrsBaseViewPager) this.jCt.findViewById(R.id.frs_base_viewpager);
            this.jCA = new FragmentAdapter(this.jCt.getSupportFragmentManager());
            this.jCz.setAdapter(this.jCA);
            this.jCz.setPageTransformer(true, new CubeOutViewPagerTransformer());
            this.jCz.addOnPageChangeListener(this.jDb);
            this.jCz.setmDisallowSlip(true);
            this.jCz.setOnTouchEventListener(this.jDc);
            this.jCB = (OvalActionButton) this.jCt.findViewById(R.id.frs_post_forum_button);
            this.jCB.setIsCircle(true);
            this.jCB.setHasShadow(false);
            this.jkP = (FRSRefreshButton) this.jCt.findViewById(R.id.frs_refresh_forum_button);
            this.jgy = (LinearLayout) this.jCt.findViewById(R.id.frs_ll_redpack);
            this.jCt.registerListener(this.jCW);
            this.jCt.registerListener(this.jCX);
            this.jCP.getHttpMessageListener().setPriority(-1);
            this.jCP.getSocketMessageListener().setPriority(-1);
            this.jCt.registerListener(this.jCQ);
            this.jCS.setSelfListener(true);
            this.jCt.registerListener(this.jCS);
            this.jCR.setSelfListener(true);
            this.jCt.registerListener(this.jCR);
            this.jCt.registerListener(this.mAccountChangedListener);
            if (bundle == null) {
                this.mForumName = this.jCt.getIntent().getStringExtra("name");
                this.mFrom = this.jCt.getIntent().getStringExtra("from");
                this.jkM = this.jCt.getIntent().getIntExtra(FrsActivityConfig.FRS_GAME_DEFAULT_TAB_ID, 0);
            } else {
                this.mForumName = bundle.getString("name");
                this.mFrom = bundle.getString("from");
                this.jkM = bundle.getInt("default_tab_id", 0);
            }
            ap(bundle);
            this.jCA.notifyDataSetChanged();
            this.jCx = new ShareSuccessReplyToServerModel();
            this.jCt.registerListener(this.jCP);
            this.jCt.registerListener(this.jCN);
            this.jCt.registerListener(this.jCO);
            this.jCt.registerListener(this.jCU);
        }
    }

    public void onSaveInstanceState(Bundle bundle) {
        bundle.putString("name", this.mForumName);
        bundle.putInt("default_tab_id", this.jkM);
        bundle.putString("from", this.mFrom);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ap(Bundle bundle) {
        FragmentManager fragmentManager = getFragmentManager();
        if (fragmentManager != null && !fragmentManager.isDestroyed() && this.jCA != null) {
            try {
                FrsFragment frsFragment = (FrsFragment) this.jCA.KP(jCr);
                if (frsFragment == null) {
                    frsFragment = aq(bundle);
                }
                frsFragment.b(this.jCB);
                frsFragment.a(this.jkP);
                frsFragment.c(this.jgy);
                if (!jCr.equals(this.jCA.zU(0))) {
                    if (jCs.equals(this.jCA.zU(0))) {
                        this.jCA.zT(0);
                    }
                    this.jCA.a(0, frsFragment);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cIM() {
        FragmentManager fragmentManager = getFragmentManager();
        if (fragmentManager != null && !fragmentManager.isDestroyed() && this.jCA != null) {
            try {
                FrsTabHostFragment frsTabHostFragment = (FrsTabHostFragment) this.jCA.KP(jCs);
                if (frsTabHostFragment == null) {
                    frsTabHostFragment = cIN();
                }
                frsTabHostFragment.b(this.jCB);
                frsTabHostFragment.b(this.jkP);
                if (!jCs.equals(this.jCA.zU(0))) {
                    if (jCr.equals(this.jCA.zU(0))) {
                        this.jCA.zT(0);
                    }
                    this.jCA.a(0, frsTabHostFragment);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private FrsFragment aq(Bundle bundle) {
        if (this.jkK == null) {
            this.jkK = new FrsFragment();
            this.jkK.setArguments(bundle);
            this.jkK.setBaseTag(jCr);
        }
        this.jkK.jgF = false;
        return this.jkK;
    }

    private FrsTabHostFragment cIN() {
        if (this.jCu == null) {
            this.jCu = new FrsTabHostFragment(this);
            this.jCu.setBaseTag(jCs);
            this.jCu.yW(this.jkM);
        }
        return this.jCu;
    }

    private FragmentManager getFragmentManager() {
        if (this.jCt != null) {
            return this.jCt.getSupportFragmentManager();
        }
        return null;
    }

    private void cIO() {
        ThemeColorInfo themeColorInfo;
        ThemeElement themeElement;
        if (this.jkL != null && (themeColorInfo = this.jkL.getForum().getThemeColorInfo()) != null && themeColorInfo.day != null && themeColorInfo.night != null && themeColorInfo.dark != null) {
            int skinType = TbadkCoreApplication.getInst().getSkinType();
            if (skinType == 4) {
                themeElement = themeColorInfo.dark;
            } else if (skinType == 1) {
                themeElement = themeColorInfo.night;
            } else {
                themeElement = themeColorInfo.day;
            }
            this.jCB.setStartAndEndColor(themeElement.light_color, themeElement.dark_color);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(m mVar, boolean z, int i) {
        if (mVar != null && mVar.getForum() != null) {
            this.jkL = mVar;
            ForumData forum = mVar.getForum();
            if (!e(mVar)) {
                if (z) {
                    a(forum, mVar.getAnti());
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921476));
            }
            if (forum.getIsShowBawuTask() && com.baidu.tbadk.core.sharedPref.b.brQ().getInt("key_bawu_task_toast", 0) == 0 && !this.jCF) {
                this.jCF = true;
                com.baidu.adp.lib.f.e.mA().postDelayed(new Runnable() { // from class: com.baidu.tieba.frs.gametab.FrsTabController.10
                    @Override // java.lang.Runnable
                    public void run() {
                        FrsTabController.this.cIU();
                    }
                }, 30000L);
            }
            if (mVar.bazhuExam != null && !this.jCG && z) {
                com.baidu.tieba.frs.m.a(this.jCt.getPageContext(), mVar.bazhuExam, forum.getId(), forum.getName());
                this.jCG = true;
            }
            if (y.getCount(mVar.getGameTabInfo()) > 0) {
                this.mHandler.post(new Runnable() { // from class: com.baidu.tieba.frs.gametab.FrsTabController.11
                    @Override // java.lang.Runnable
                    public void run() {
                        boolean dx = FrsTabController.this.dx(FrsTabController.this.jkL.getGameTabInfo());
                        if (dx) {
                            FrsTabController.this.jCA.notifyDataSetChanged();
                            if (dx && FrsTabController.this.jCu != null) {
                                FrsTabController.this.jCu.Y(FrsTabController.this.jkK);
                                FrsTabController.this.jCu.a(FrsTabController.this.jkL, FrsTabController.this.jkJ);
                            }
                        }
                        if (FrsTabController.this.jCt.isLoadingViewAttached()) {
                            FrsTabController.this.jCt.hideLoadingView(FrsTabController.this.jCt.findViewById(16908290));
                        }
                    }
                });
            } else if (cIT()) {
                this.mHandler.post(new Runnable() { // from class: com.baidu.tieba.frs.gametab.FrsTabController.13
                    @Override // java.lang.Runnable
                    public void run() {
                        Bundle bundle;
                        FrsTabController.this.jkK.jgF = true;
                        if (FrsTabController.this.jkK != null) {
                            bundle = FrsTabController.this.jkK.getArguments();
                        } else {
                            bundle = null;
                        }
                        FrsTabController.this.ap(bundle);
                        FrsTabController.this.jCA.notifyDataSetChanged();
                        if (FrsTabController.this.jCt.isLoadingViewAttached()) {
                            FrsTabController.this.jCt.hideLoadingView(FrsTabController.this.jCt.findViewById(16908290));
                        }
                    }
                });
            }
            cIO();
            cIV();
            if (z) {
                if ((!this.jCK || i == 4) && forum.isLike() == 0 && com.baidu.tbadk.a.d.bjc() && TbadkCoreApplication.isLogin()) {
                    this.jCI = new com.baidu.tieba.frs.d.e();
                    this.jCt.registerListener(this.jCZ);
                    this.jCt.registerListener(this.jCY);
                    this.jCt.registerListener(this.jDa);
                    d(forum);
                }
            }
        }
    }

    private boolean e(m mVar) {
        if (mVar == null || mVar.getUserData() == null) {
            return false;
        }
        int is_manager = mVar.getUserData().getIs_manager();
        boolean z = com.baidu.tbadk.core.sharedPref.b.brQ().getBoolean("key_forum_tool_find_dialog_show", false);
        if (is_manager == 1 && !z) {
            f(1, this.jCt.getString(R.string.forum_tool_first_bazhu_content), String.valueOf(R.drawable.pic_mask_update), "");
            com.baidu.tbadk.core.sharedPref.b.brQ().putBoolean("key_forum_tool_find_dialog_show", true);
            return true;
        } else if (!z && is_manager == 2) {
            f(2, this.jCt.getString(R.string.forum_tool_first_bawu_content), String.valueOf(R.drawable.pic_mask_update), "");
            com.baidu.tbadk.core.sharedPref.b.brQ().putBoolean("key_forum_tool_find_dialog_show", true);
            return true;
        } else if (mVar.bawuPopInfo != null) {
            f(3, mVar.bawuPopInfo.content, mVar.bawuPopInfo.img_url, mVar.bawuPopInfo.jump_url);
            return true;
        } else {
            return false;
        }
    }

    private void f(final int i, String str, String str2, final String str3) {
        final com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.jCt);
        aVar.nA(2);
        aVar.jG(false);
        FrsForumToolDialogView frsForumToolDialogView = new FrsForumToolDialogView(this.jCt);
        frsForumToolDialogView.setStartLoadUrl(i, str2);
        frsForumToolDialogView.setContent(str);
        frsForumToolDialogView.setCancleButtonListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.gametab.FrsTabController.14
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (aVar != null) {
                    aVar.dismiss();
                }
            }
        });
        frsForumToolDialogView.setConfirmButtonListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.gametab.FrsTabController.15
            /* JADX DEBUG: Multi-variable search result rejected for r1v3, resolved type: com.baidu.tieba.frs.FrsActivity */
            /* JADX DEBUG: Multi-variable search result rejected for r2v6, resolved type: com.baidu.tieba.frs.FrsActivity */
            /* JADX WARN: Multi-variable type inference failed */
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (aVar != null) {
                    aVar.dismiss();
                }
                if (i == 1) {
                    bf.bsV().b(FrsTabController.this.jCt.getPageContext(), new String[]{"http://tieba.baidu.com/mo/q/bawuteam?fn=" + FrsTabController.this.cBL().getForumName() + "&fid=" + FrsTabController.this.cBL().getForumId()});
                } else if (i == 2) {
                    HashMap hashMap = new HashMap();
                    hashMap.put("forum_id", FrsTabController.this.cBL().getForumId());
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002015, new com.baidu.tieba.tbadkCore.data.m(FrsTabController.this.jCt, OpenFlutter.ACTIVITY_FORUM_DETAIL, hashMap)));
                } else if (i == 3 && !TextUtils.isEmpty(str3)) {
                    bf.bsV().b(FrsTabController.this.jCt.getPageContext(), new String[]{str3});
                }
            }
        });
        aVar.bn(frsForumToolDialogView);
        aVar.b(this.jCt.getPageContext()).bqx();
    }

    private void a(ForumData forumData, AntiData antiData) {
        if (forumData != null && !com.baidu.tbadk.youngster.b.a.a(this.jCt.getPageContext(), antiData, R.id.frs) && !c(forumData)) {
            List<TipInfo> tipInfos = forumData.getTipInfos();
            if (!y.isEmpty(tipInfos)) {
                com.baidu.tbadk.youngster.b.a.a(this.jCt.getPageContext(), tipInfos.get(0), TbadkCoreApplication.getCurrentAccount(), forumData.getId(), this.jCt.getString(R.string.frs_risk_dialog_button_text));
            }
        }
    }

    private boolean c(ForumData forumData) {
        if (au.isEmpty(forumData.getRiskTipPop()) || au.isEmpty(forumData.getRiskTipPopTitle())) {
            return false;
        }
        final com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.jCt);
        aVar.At(forumData.getRiskTipPopTitle());
        aVar.setTitleShowCenter(true);
        aVar.setMessageShowCenter(true);
        aVar.Au(forumData.getRiskTipPop());
        aVar.a(R.string.frs_risk_dialog_button_text, new a.b() { // from class: com.baidu.tieba.frs.gametab.FrsTabController.16
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                aVar.dismiss();
            }
        });
        aVar.b(this.jCt.getPageContext()).bqx();
        return true;
    }

    public m cIP() {
        return this.jkL;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean dx(List<FrsTabInfo> list) {
        if (this.jCt.isLoadingViewAttached()) {
            this.jCt.hideLoadingView(this.jCt.findViewById(16908290));
        }
        if (cIT()) {
            return false;
        }
        this.jkK.jgF = true;
        cIQ();
        if (com.baidu.tbadk.core.sharedPref.b.brQ().getBoolean("frs_game_login_tip", true)) {
            com.baidu.tbadk.core.sharedPref.b.brQ().putBoolean(SharedPrefConfig.FRS_LOGIN_TIP, true);
            com.baidu.tbadk.core.sharedPref.b.brQ().putBoolean("frs_game_login_tip", false);
        }
        dy(list);
        return true;
    }

    private void cIQ() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1021074, TbConfig.SERVER_ADDRESS + "game/forum/getNewNotify");
        tbHttpMessageTask.setResponsedClass(AlaGameTabGetNewNotifyResponsedMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
        this.jCt.registerListener(1021074, this.jCT);
    }

    private void dy(List<FrsTabInfo> list) {
        boolean z;
        if (!y.isEmpty(list)) {
            CustomMessageListener customMessageListener = new CustomMessageListener(CmdConfigCustom.CMD_GAME_FRS_ADD_TAB) { // from class: com.baidu.tieba.frs.gametab.FrsTabController.17
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.framework.listener.MessageListener
                public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                    if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof ai)) {
                        if (!com.baidu.tbadk.core.sharedPref.b.brQ().getBoolean(FrsTabController.this.jCw, true)) {
                            com.baidu.adp.lib.f.e.mA().post(FrsTabController.this.jCV);
                        }
                        ((ai) customResponsedMessage.getData()).b(new com.baidu.tbadk.mainTab.b() { // from class: com.baidu.tieba.frs.gametab.FrsTabController.17.1
                            @Override // com.baidu.tbadk.mainTab.b
                            public boolean isAvailable() {
                                return true;
                            }

                            @Override // com.baidu.tbadk.mainTab.b
                            public com.baidu.tbadk.mainTab.c createFragmentTabStructure() {
                                FrsSportsRecommendFragment frsSportsRecommendFragment = new FrsSportsRecommendFragment();
                                Bundle bundle = new Bundle();
                                bundle.putString("name", FrsTabController.this.jkK.getForumName());
                                bundle.putString("from", FrsTabController.this.jkK.getFrom());
                                bundle.putString("forum_id", FrsTabController.this.jkK.getForumId());
                                bundle.putInt("tab_id", 503);
                                bundle.putBoolean("can_auto_play_video", FrsTabController.this.jkL.isFrsVideoAutoPlay);
                                bundle.putBoolean("need_log", FrsTabController.this.jkL.needLog == 1);
                                bundle.putBoolean("is_brand_forum", FrsTabController.this.jkL.isBrandForum);
                                FrsViewData frsViewData = new FrsViewData();
                                frsViewData.receiveData(FrsTabController.this.jkL);
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
                        FrsTabController.this.cIM();
                    }
                }
            };
            customMessageListener.setPriority(Integer.MAX_VALUE);
            customMessageListener.setSelfListener(true);
            this.jCt.registerListener(customMessageListener);
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
            this.jkJ = new ai(this.jCt.getActivity(), arrayList);
            if (cBL() != null) {
                this.jkJ.setForumId(cBL().getForumId());
                this.jkJ.setForumName(cBL().getForumName());
                if (cBL().cDg() != null && cBL().cDg().getForum() != null) {
                    ForumData forum = cBL().cDg().getForum();
                    this.jkJ.setForumGameLabel(forum.getForumGameLabel());
                    this.jkJ.In(forum.getSpecialForumType());
                }
            }
            this.jkK.jgF = false;
            new e(this.jkK).a(this.jkJ);
            CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(CmdConfigCustom.CMD_GAME_FRS_ADD_TAB, this.jkJ);
            CustomMessage customMessage = new CustomMessage(CmdConfigCustom.CMD_GAME_FRS_ADD_TAB);
            customMessage.setTag(this.jCt.getUniqueId());
            customResponsedMessage.setOrginalMessage(customMessage);
            MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cIR() {
        if (this.jkJ != null && !TextUtils.isEmpty(this.jkJ.getForumId())) {
            HttpMessage httpMessage = new HttpMessage(1021074);
            httpMessage.addParam("forum_id", this.jkL.getForum().getId());
            MessageManager.getInstance().sendMessage(httpMessage);
        }
    }

    private void a(Fragment fragment, int i) {
        NavigationBar bVk;
        if ((fragment instanceof ap) && this.jkL != null && this.jkL.getForum() != null && (bVk = ((ap) fragment).bVk()) != null) {
            StringBuilder sb = new StringBuilder();
            sb.append(UtilHelper.getFixedBarText(this.jkL.getForum().getName(), 5, true, true) + this.jCt.getActivity().getString(R.string.forum));
            bVk.setCenterTextTitle(sb.toString());
        }
    }

    @Override // com.baidu.tieba.InjectPlugin.a.b
    public void a(int i, com.baidu.tieba.InjectPlugin.a.a aVar) {
        if (this.jkK instanceof com.baidu.tieba.InjectPlugin.a.b) {
            this.jkK.a(i, aVar);
        }
    }

    @Override // com.baidu.tieba.InjectPlugin.a.b
    public com.baidu.tieba.InjectPlugin.a.a sM(int i) {
        if (this.jkK instanceof com.baidu.tieba.InjectPlugin.a.b) {
            return this.jkK.sM(i);
        }
        return null;
    }

    @Override // com.baidu.tieba.InjectPlugin.a.b
    public void a(com.baidu.tieba.InjectPlugin.b bVar) {
        if (this.jkK instanceof com.baidu.tieba.InjectPlugin.a.b) {
            this.jkK.a(bVar);
        }
    }

    public void onNewIntent(Intent intent) {
        if (this.jkK != null) {
            this.jkK.onNewIntent(intent);
        }
    }

    public void onResume() {
        if (!cIT()) {
            this.jkK.setPrimary(true);
        } else if (this.jCu != null) {
            Fragment currentFragment = this.jCu.getCurrentFragment();
            if (currentFragment instanceof BaseFragment) {
                ((BaseFragment) currentFragment).setPrimary(true);
            }
        }
        if (this.jCy) {
            this.jCy = false;
            if (this.jkK != null) {
                this.jkK.refresh();
            }
        }
        if (this.jkL != null && this.jkL.getUserData() != null && this.jkL.getUserData().getNewGodData() != null) {
            if (this.jkL.getForum() != null) {
                x.bFC().setFid(this.jkL.getForum().getId());
            }
            x.bFC().b(2, this.jkL.getUserData().getNewGodData());
        }
        this.jCM = true;
        if (this.jCL) {
            e((ForumData) null);
        }
    }

    public void onPause() {
        this.jCM = false;
        if (this.jCI != null) {
            this.jCI.cKI();
        }
        if (!cIT()) {
            this.jkK.setPrimary(false);
        } else if (this.jCu != null) {
            Fragment currentFragment = this.jCu.getCurrentFragment();
            if (currentFragment instanceof BaseFragment) {
                ((BaseFragment) currentFragment).setPrimary(false);
            }
        }
        x.bFC().removeCallbacks();
    }

    public void onChangeSkinType(int i) {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (skinType == 1 || skinType == 4) {
            UtilHelper.changeStatusBarIconAndTextColor(true, this.jCt);
        } else {
            UtilHelper.changeStatusBarIconAndTextColor(false, this.jCt);
        }
        if (this.jkK != null) {
            this.jkK.onChangeSkinType(i);
        }
        if (this.jCu != null) {
            this.jCu.onChangeSkinType(i);
        }
        cIO();
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            if (cIT() && this.jCu != null && this.jCu.cEm()) {
                this.jCu.cEE();
                UtilHelper.setNavigationBarBackground(this.jCt, this.jCu.cEz());
            } else if (this.jkK != null && this.jkK.isAdded()) {
                if (this.jkK.onKeyDown(i, keyEvent)) {
                    return true;
                }
                cIS();
            } else {
                return this.jCt.b(i, keyEvent);
            }
        } else if (i == 24) {
            if (this.jkK != null && this.jkK.isAdded()) {
                return this.jkK.onKeyDown(i, keyEvent);
            }
        } else {
            return this.jCt.b(i, keyEvent);
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cIS() {
        if (this.jkN != this.jkM && cIT()) {
            this.jCu.setCurrentTab(this.jkM);
            if (yU(this.jkM) != 1) {
                this.jkK.qz(false);
            }
            this.jkN = this.jkM;
            a(this.jCu.getCurrentFragment(), this.jkM);
            return;
        }
        this.jkK.closeActivity();
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: com.baidu.tieba.frs.FrsActivity */
    /* JADX DEBUG: Multi-variable search result rejected for r2v1, resolved type: com.baidu.tieba.frs.FrsActivity */
    /* JADX WARN: Multi-variable type inference failed */
    public void onActivityResult(int i, int i2, Intent intent) {
        if (!cIT()) {
            this.jkK.onActivityResult(i, i2, intent);
        } else if (this.jCu != null) {
            if (1 == this.jCu.getCurrentTabType()) {
                this.jkK.onActivityResult(i, i2, intent);
            } else {
                this.jCu.getCurrentFragment().onActivityResult(i, i2, intent);
            }
        }
        if (i2 == -1) {
            if (i == 24007) {
                int intExtra = intent.getIntExtra("extra_share_status", 2);
                int intExtra2 = intent.getIntExtra("extra_show_channel", 1);
                if (intExtra == 1) {
                    com.baidu.tieba.o.a.dCY().I(this.jCt.getPageContext());
                    ShareItem shareItem = TbadkCoreApplication.getInst().getShareItem();
                    if (shareItem != null && shareItem.linkUrl != null && this.jCx != null) {
                        this.jCx.a(shareItem.linkUrl, intExtra2, new ShareSuccessReplyToServerModel.a() { // from class: com.baidu.tieba.frs.gametab.FrsTabController.18
                            @Override // com.baidu.tbadk.coreExtra.model.ShareSuccessReplyToServerModel.a
                            public void byF() {
                            }

                            @Override // com.baidu.tbadk.coreExtra.model.ShareSuccessReplyToServerModel.a
                            public void a(final CustomDialogData customDialogData) {
                                com.baidu.adp.lib.f.e.mA().postDelayed(new Runnable() { // from class: com.baidu.tieba.frs.gametab.FrsTabController.18.1
                                    @Override // java.lang.Runnable
                                    public void run() {
                                        if (FrsTabController.this.jCt != null) {
                                            com.baidu.tieba.pb.interactionpopupwindow.c.a(FrsTabController.this.jCt.getPageContext(), customDialogData).show();
                                        }
                                    }
                                }, 1000L);
                            }
                        });
                    }
                }
            } else if (i == 13011) {
                com.baidu.tieba.o.a.dCY().I(this.jCt.getPageContext());
            }
        }
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager getVoiceManager() {
        if (!cIT()) {
            return this.jkK.getVoiceManager();
        }
        if (this.jCu == null) {
            return null;
        }
        Fragment currentFragment = this.jCu.getCurrentFragment();
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
    public int yS(int i) {
        if (this.jkJ == null) {
            return -1;
        }
        int count = y.getCount(this.jkJ.bAS());
        for (int i2 = 0; i2 < count; i2++) {
            if (this.jkJ.bAS().get(i2).tab_id.intValue() == i) {
                return i2;
            }
        }
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int yU(int i) {
        if (this.jkJ != null && i < y.getCount(this.jkJ.bAS())) {
            return this.jkJ.bAS().get(i).tab_id.intValue();
        }
        return -1;
    }

    public FrsFragment cBL() {
        return this.jkK;
    }

    @Override // com.baidu.tieba.tbadkCore.FrsCommonImageLayout.c
    public com.baidu.adp.lib.d.b<TbImageView> cBM() {
        if (!cIT()) {
            if (this.jkK instanceof FrsCommonImageLayout.c) {
                return ((FrsCommonImageLayout.c) this.jkK).cBM();
            }
        } else if (this.jCu == null) {
            return null;
        } else {
            Fragment currentFragment = this.jCu.getCurrentFragment();
            if (currentFragment instanceof FrsCommonImageLayout.c) {
                return ((FrsCommonImageLayout.c) currentFragment).cBM();
            }
        }
        return null;
    }

    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(FrsNoListItemViewHolder.jjV);
        this.mHandler.removeCallbacksAndMessages(null);
        if (this.jCt.isLoadingViewAttached()) {
            this.jCt.hideLoadingView(this.jCt.findViewById(16908290));
        }
        if (this.jCV != null) {
            com.baidu.adp.lib.f.e.mA().removeCallbacks(this.jCV);
        }
        com.baidu.tbadk.core.sharedPref.b.brQ().putBoolean(this.jCw, false);
        if (this.jCx != null) {
            this.jCx.cancelLoadData();
        }
        if (this.jkK != null && this.jkK.cCw() != null) {
            this.jkK.cCw().cJg();
        }
        if (this.jCE != null) {
            this.jCE.onDestroy();
        }
        if (FrsActivityConfig.FRS_FROM_FLUTTER_BCASTEDIT.equals(this.mFrom)) {
            new p(TbadkCoreApplication.getInst()).bsh();
        }
        if (FrsActivityConfig.FRS_FROM_FORUM_RULE_EDIT.equals(this.mFrom)) {
            com.baidu.tbadk.k.d.bCB().ld(false);
        }
        if (this.jCJ != null) {
            com.baidu.adp.lib.f.e.mA().removeCallbacks(this.jCJ);
        }
        if (this.jkL != null && this.jkL.getForum() != null && this.jCI != null) {
            this.jCI.gx(com.baidu.adp.lib.f.b.toLong(this.jkL.getForum().getId(), 0L));
        }
    }

    public FragmentTabHost cEC() {
        if (this.jCu == null) {
            return null;
        }
        return this.jCu.cEC();
    }

    public boolean cIT() {
        if (this.jCA == null) {
            return false;
        }
        return this.jCA.getItem(0) instanceof FrsTabHostFragment;
    }

    public void yW(int i) {
        this.jkM = i;
    }

    public void zR(int i) {
        this.jkN = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cIU() {
        if (this.jCt != null) {
            if (this.jCE == null) {
                this.jCE = (NavigationBarCoverTip) this.jCt.findViewById(R.id.navigation_cover_tip);
            }
            if (this.jCE != null) {
                View inflate = View.inflate(this.jCt, R.layout.write_thread_share_guide, null);
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
                cVar.buY();
                tBSpecificationBtn.setConfig(cVar);
                tBSpecificationBtn.bup();
                com.baidu.tbadk.core.util.ap.setViewTextColor(textView, R.color.CAM_X0101);
                com.baidu.tbadk.core.util.ap.setBackgroundColor(this.jCE, R.color.cp_link_tip_a_alpha95);
                tBSpecificationBtn.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.gametab.FrsTabController.19
                    /* JADX DEBUG: Multi-variable search result rejected for r4v9, resolved type: com.baidu.tieba.frs.FrsActivity */
                    /* JADX WARN: Multi-variable type inference failed */
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        new ar("c13439").bsO();
                        if (FrsTabController.this.cBL() != null && !TextUtils.isEmpty(FrsTabController.this.cBL().getForumId()) && !TextUtils.isEmpty(FrsTabController.this.mForumName) && FrsTabController.this.jCt != null) {
                            if (FrsTabController.this.jCE != null) {
                                FrsTabController.this.jCE.hideTip();
                            }
                            bf.bsV().b(FrsTabController.this.jCt.getPageContext(), new String[]{"https://tieba.baidu.com/mo/q/bawutask?fid=" + FrsTabController.this.cBL().getForumId() + "&fn=" + FrsTabController.this.mForumName + "&noread=" + (com.baidu.tbadk.core.sharedPref.b.brQ().getInt("key_bawu_task_toast", 0) == -1 ? 1 : 0)});
                        }
                    }
                });
                this.jCE.a(this.jCt, inflate, 30000);
                new ar("c13438").bsO();
                int i = com.baidu.tbadk.core.sharedPref.b.brQ().getInt("key_bawu_task_toast", 0);
                if (i >= 0) {
                    com.baidu.tbadk.core.sharedPref.b.brQ().putInt("key_bawu_task_toast", i + 1);
                }
            }
        }
    }

    private void cIV() {
        boolean z;
        if (this.jkL != null && this.jkL.getEntelechyTabInfo() != null && this.jkL.getEntelechyTabInfo().tab != null) {
            Iterator<FrsTabInfo> it = this.jkL.getEntelechyTabInfo().tab.iterator();
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
                if (this.jCH == null) {
                    this.jCH = new com.baidu.tieba.c.e(this.jCt.getPageContext(), this.jCB);
                    this.jCH.en(R.drawable.pic_sign_tip_down);
                    this.jCH.xh(2);
                    this.jCH.setUseDirectOffset(true);
                    this.jCH.xl(-l.getDimens(this.jCt, R.dimen.tbds20));
                    this.jCH.setYOffset(-l.getDimens(this.jCt, R.dimen.tbds20));
                    this.jCH.setTextColor(R.color.CAM_X0101);
                    this.jCH.setHeight(R.dimen.tbds54);
                    this.jCH.xj(l.getDimens(this.jCt, R.dimen.tbds44));
                }
                this.jCH.aJ(this.jCt.getString(R.string.frs_evaluate_tip), "first_into_frs_with_evaluate_tab");
            }
        }
    }

    private void d(final ForumData forumData) {
        boolean z = false;
        if (i(forumData.getName(), forumData.getId(), forumData.getImage_url(), false)) {
            if (this.jCJ != null) {
                com.baidu.adp.lib.f.e.mA().removeCallbacks(this.jCJ);
            }
            z = true;
        }
        if (!this.jCK) {
            this.jCI.cKH().k(TbadkCoreApplication.getCurrentAccount(), forumData.getId(), System.currentTimeMillis());
            this.jCK = true;
        }
        if (!z) {
            this.jCJ = this.jCJ != null ? this.jCJ : new Runnable() { // from class: com.baidu.tieba.frs.gametab.FrsTabController.20
                @Override // java.lang.Runnable
                public void run() {
                    if (FrsTabController.this.jCI != null) {
                        if (FrsTabController.this.jCM) {
                            FrsTabController.this.i(forumData.getName(), forumData.getId(), forumData.getImage_url(), true);
                        } else {
                            FrsTabController.this.jCL = true;
                        }
                    }
                }
            };
            com.baidu.adp.lib.f.e.mA().postDelayed(this.jCJ, AppStatusRules.DEFAULT_GRANULARITY);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(ForumData forumData) {
        if (this.jkK.cCy() != null && this.jCI != null) {
            if (forumData == null) {
                forumData = this.jkL.getForum();
            }
            if (forumData != null && forumData.isLike() != 1) {
                if (!this.jCM) {
                    this.jCL = true;
                } else if (i(forumData.getName(), forumData.getId(), forumData.getImage_url(), false) && this.jCJ != null) {
                    com.baidu.adp.lib.f.e.mA().removeCallbacks(this.jCJ);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean i(String str, String str2, String str3, boolean z) {
        if (!this.jCI.ff(TbadkCoreApplication.getCurrentAccount(), str2) || this.jkK == null || this.jkK.cCy() == null) {
            return false;
        }
        this.jCL = false;
        this.jCI.a(this.jCt, str, str2, str3, this.jkK.cCy().cLB());
        this.jCI.cKH().e(TbadkCoreApplication.getCurrentAccount(), str2, System.currentTimeMillis(), z);
        return true;
    }

    public boolean gv(long j) {
        ForumData forum;
        return (this.jkL == null || j == 0 || (forum = this.jkL.getForum()) == null || com.baidu.adp.lib.f.b.toLong(forum.getId(), 0L) != j) ? false : true;
    }

    /* loaded from: classes2.dex */
    public class FragmentAdapter extends FragmentStatePagerAdapter {
        private List<BaseFragment> mFragments;

        public FragmentAdapter(FragmentManager fragmentManager) {
            super(fragmentManager);
            this.mFragments = new ArrayList(2);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // androidx.fragment.app.FragmentStatePagerAdapter
        /* renamed from: zS */
        public BaseFragment getItem(int i) {
            return (BaseFragment) y.getItem(this.mFragments, i);
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public int getCount() {
            return this.mFragments.size();
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public int getItemPosition(Object obj) {
            return -2;
        }

        public boolean a(int i, BaseFragment baseFragment) {
            return y.add(this.mFragments, i, baseFragment);
        }

        public BaseFragment KP(String str) {
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

        public BaseFragment zT(int i) {
            return (BaseFragment) y.remove(this.mFragments, i);
        }

        public String zU(int i) {
            if (getItem(i) != null) {
                return getItem(i).getBaseTag();
            }
            return null;
        }
    }

    public TbPageTag getTbPageTag() {
        if (!cIT()) {
            return this.jkK.getTbPageTag();
        }
        if (this.jCu != null) {
            if (1 == this.jCu.getCurrentTabType()) {
                return this.jkK.getTbPageTag();
            }
            Fragment currentFragment = this.jCu.getCurrentFragment();
            if (currentFragment instanceof BaseFragment) {
                return ((BaseFragment) currentFragment).getTbPageTag();
            }
        }
        return null;
    }

    public void onScreenShot(String str) {
        if (this.jkL != null && this.jkL.getForum() != null) {
            TiebaStatic.log(new ar("c13848").dR("uid", TbadkCoreApplication.getCurrentAccount()).dR("fid", this.jkL.getForum().getId()).ap("obj_type", 2));
        }
    }
}
