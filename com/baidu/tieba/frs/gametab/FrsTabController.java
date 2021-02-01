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
    public static final String jCd = FrsFragment.class.getSimpleName();
    public static final String jCe = FrsTabHostFragment.class.getSimpleName();
    private FrsActivity jCf;
    private FrsTabHostFragment jCg;
    private ShareSuccessReplyToServerModel jCj;
    private FrsBaseViewPager jCl;
    private FragmentAdapter jCm;
    private OvalActionButton jCn;
    private boolean jCo;
    private boolean jCp;
    private NavigationBarCoverTip jCq;
    private com.baidu.tieba.c.e jCt;
    private com.baidu.tieba.frs.d.e jCu;
    private Runnable jCv;
    private boolean jCw;
    private LinearLayout jgk;
    private FRSRefreshButton jkB;
    private ai jkv;
    private FrsFragment jkw;
    private m jkx;
    private int jkz;
    private String mForumName;
    private String mFrom;
    private boolean jCh = false;
    private final Handler mHandler = new Handler();
    private int jky = 0;
    private boolean jCk = false;
    private boolean jCr = false;
    private boolean jCs = false;
    private boolean jCx = false;
    private boolean jCy = false;
    private HttpMessageListener jCz = new HttpMessageListener(CmdConfigHttp.CMD_FRS_RECOMMEND) { // from class: com.baidu.tieba.frs.gametab.FrsTabController.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage instanceof FrsRecommendResMsg) {
                if (httpResponsedMessage.getError() != 0) {
                    new BdTopToast(FrsTabController.this.jCf).zn(false).UN(httpResponsedMessage.getErrorString()).aR((ViewGroup) FrsTabController.this.jCf.findViewById(R.id.frs));
                    return;
                }
                int pushStatus = ((FrsRecommendResMsg) httpResponsedMessage).getPushStatus();
                String pushMsg = ((FrsRecommendResMsg) httpResponsedMessage).getPushMsg();
                if (pushStatus == 1) {
                    new ScreenTopToast(FrsTabController.this.jCf).US(FrsTabController.this.jCf.getString(R.string.frs_recommend_suc_tip_title)).UT(FrsTabController.this.jCf.getString(R.string.frs_recommend_suc_tip_content)).UU(FrsTabController.this.jCf.getString(R.string.dialog_confirm_see)).an(new View.OnClickListener() { // from class: com.baidu.tieba.frs.gametab.FrsTabController.1.1
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view) {
                            HashMap hashMap = new HashMap();
                            hashMap.put("_forumId", FrsTabController.this.jkx.getForum().getId());
                            MessageManager.getInstance().sendMessage(new CustomMessage(2002015, new com.baidu.tieba.tbadkCore.data.m(FrsTabController.this.jCf, "RecommendHistoryPage", hashMap)));
                        }
                    }).aR((ViewGroup) FrsTabController.this.jCf.findViewById(R.id.frs));
                } else {
                    new BdTopToast(FrsTabController.this.jCf).zn(false).UN(pushMsg).aR((ViewGroup) FrsTabController.this.jCf.findViewById(R.id.frs));
                }
            }
        }
    };
    private CustomMessageListener jCA = new CustomMessageListener(2921465) { // from class: com.baidu.tieba.frs.gametab.FrsTabController.12
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            new ScreenTopToast(FrsTabController.this.jCf).US(FrsTabController.this.jCf.getString(R.string.frs_recommend_fail_month_tip)).UU(FrsTabController.this.jCf.getString(R.string.frs_recommend_fail_tip_btn)).an(new View.OnClickListener() { // from class: com.baidu.tieba.frs.gametab.FrsTabController.12.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    HashMap hashMap = new HashMap();
                    hashMap.put("_forumId", FrsTabController.this.jkx.getForum().getId());
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002015, new com.baidu.tieba.tbadkCore.data.m(FrsTabController.this.jCf, "ForumGradePage", hashMap)));
                }
            }).aR((ViewGroup) FrsTabController.this.jCf.findViewById(R.id.frs));
        }
    };
    private com.baidu.adp.framework.listener.a jCB = new com.baidu.adp.framework.listener.a(1001703, CmdConfigSocket.CMD_FRS_PAGE) { // from class: com.baidu.tieba.frs.gametab.FrsTabController.21
        @Override // com.baidu.adp.framework.listener.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            m mVar = null;
            int i = -1;
            if (!FrsTabController.this.jCh && !responsedMessage.hasError() && responsedMessage.getError() == 0) {
                if (responsedMessage instanceof FrsPageHttpResponseMessage) {
                    mVar = ((FrsPageHttpResponseMessage) responsedMessage).getResponseData();
                    i = ((FrsPageHttpResponseMessage) responsedMessage).getUpdateType();
                } else if (responsedMessage instanceof FRSPageSocketResponsedMessage) {
                    mVar = ((FRSPageSocketResponsedMessage) responsedMessage).getResponseData();
                    i = ((FRSPageSocketResponsedMessage) responsedMessage).getUpdateType();
                }
                if (mVar != null) {
                    FrsTabController.this.jCh = true;
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
    private CustomMessageListener jCC = new CustomMessageListener(CmdConfigCustom.CMD_GET_FRS_PAGE_CACHE) { // from class: com.baidu.tieba.frs.gametab.FrsTabController.22
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (!FrsTabController.this.jCh && FrsTabController.this.jkx == null && customResponsedMessage != null && (customResponsedMessage.getData() instanceof m)) {
                m mVar = (m) customResponsedMessage.getData();
                if (mVar.getForum() != null && FrsTabController.this.mForumName != null && FrsTabController.this.mForumName.equals(mVar.getForum().getName())) {
                    FrsTabController.this.a(mVar, false, -1);
                }
            }
        }
    };
    private CustomMessageListener jCD = new CustomMessageListener(CmdConfigCustom.CMD_CLICK_CLOSE_GAME_FRS_CONFIRM) { // from class: com.baidu.tieba.frs.gametab.FrsTabController.23
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            FrsTabController.this.cIL();
        }
    };
    private CustomMessageListener jCE = new CustomMessageListener(CmdConfigCustom.CMD_GAME_FRS_TAB_CHANGE) { // from class: com.baidu.tieba.frs.gametab.FrsTabController.24
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
                if (yS != -1 && FrsTabController.this.cIM() && FrsTabController.this.jCg != null) {
                    FrsTabController.this.jCg.setCurrentTab(yS);
                    if (FrsTabController.this.yU(yS) != 1) {
                        FrsTabController.this.jkw.qz(false);
                    }
                }
            }
        }
    };
    private HttpMessageListener jCF = new HttpMessageListener(0) { // from class: com.baidu.tieba.frs.gametab.FrsTabController.25
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && 1021074 == httpResponsedMessage.getCmd() && (httpResponsedMessage instanceof AlaGameTabGetNewNotifyResponsedMessage)) {
                List<a> newNotifyData = ((AlaGameTabGetNewNotifyResponsedMessage) httpResponsedMessage).getNewNotifyData();
                if (!y.isEmpty(newNotifyData) && FrsTabController.this.jCg != null) {
                    for (a aVar : newNotifyData) {
                        if (aVar != null) {
                            for (int i = 0; i < FrsTabController.this.jkv.bAS().size(); i++) {
                                FragmentTabHost.b ot = FrsTabController.this.jCg.ot(i);
                                if (ot != null && ot.mType != 1 && ot.mType != FrsTabController.this.jCg.getCurrentTabType() && ot.mType == aVar.getTabId() && aVar.cIA() && ot.eZk.Dn(String.valueOf(ot.mType)) != null) {
                                    ot.eZk.Dn(String.valueOf(ot.mType)).view.setVisibility(0);
                                }
                            }
                        }
                    }
                }
            }
        }
    };
    private CustomMessageListener jCG = new CustomMessageListener(2921518) { // from class: com.baidu.tieba.frs.gametab.FrsTabController.26
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            new BdTopToast(FrsTabController.this.jCf, 2000).zn(false).UN(FrsTabController.this.jCf.getString(R.string.frs_top_forum_rules_click_toast)).aR((ViewGroup) FrsTabController.this.jCf.findViewById(R.id.frs));
        }
    };
    private Runnable jCH = new Runnable() { // from class: com.baidu.tieba.frs.gametab.FrsTabController.27
        @Override // java.lang.Runnable
        public void run() {
            com.baidu.adp.lib.f.e.mA().removeCallbacks(this);
            FrsTabController.this.cIK();
            com.baidu.adp.lib.f.e.mA().postDelayed(this, 30000L);
        }
    };
    private CustomMessageListener mAccountChangedListener = new CustomMessageListener(CmdConfigCustom.METHOD_ACCOUNT_CHANGE) { // from class: com.baidu.tieba.frs.gametab.FrsTabController.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2005016) {
                FrsTabController.this.jCk = true;
            }
        }
    };
    private CustomMessageListener jCI = new CustomMessageListener(2921369) { // from class: com.baidu.tieba.frs.gametab.FrsTabController.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && FrsTabController.this.jCl != null && FrsTabController.this.jCm != null && (customResponsedMessage.getData() instanceof FrsTabViewPager.a)) {
                FrsTabViewPager.a aVar = (FrsTabViewPager.a) customResponsedMessage.getData();
                FrsTabController.this.jCo = aVar.cEC();
                FrsTabController.this.jCp = aVar.cED();
            }
        }
    };
    private CustomMessageListener jCJ = new CustomMessageListener(2921370) { // from class: com.baidu.tieba.frs.gametab.FrsTabController.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && FrsTabController.this.jCl != null && FrsTabController.this.jCm != null && (customResponsedMessage.getData() instanceof Boolean)) {
                FrsTabController.this.jCl.setForceIntercept(((Boolean) customResponsedMessage.getData()).booleanValue());
            }
        }
    };
    private CustomMessageListener jCK = new CustomMessageListener(CmdConfigCustom.CMD_NEW_WRITE_POST_SUCCESS) { // from class: com.baidu.tieba.frs.gametab.FrsTabController.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (((Boolean) customResponsedMessage.getData()).booleanValue()) {
                FrsTabController.this.e((ForumData) null);
            }
        }
    };
    private CustomMessageListener jCL = new CustomMessageListener(2921498) { // from class: com.baidu.tieba.frs.gametab.FrsTabController.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (FrsTabController.this.jCu != null && customResponsedMessage != null && customResponsedMessage.getData() != null) {
                if (customResponsedMessage.getData() instanceof ForumData) {
                    FrsTabController.this.e((ForumData) customResponsedMessage.getData());
                } else if (customResponsedMessage.getData() instanceof Long) {
                    long longValue = ((Long) customResponsedMessage.getData()).longValue();
                    if (FrsTabController.this.gv(longValue) && FrsTabController.this.jCu.gw(longValue) >= 3) {
                        FrsTabController.this.jCu.gx(longValue);
                        FrsTabController.this.jCx = true;
                    }
                }
            }
        }
    };
    private CustomMessageListener jCM = new CustomMessageListener(CmdConfigCustom.CMD_PERSON_LIKE_FORUM) { // from class: com.baidu.tieba.frs.gametab.FrsTabController.7
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.tbadkCore.writeModel.e)) {
                com.baidu.tieba.tbadkCore.writeModel.e eVar = (com.baidu.tieba.tbadkCore.writeModel.e) customResponsedMessage.getData();
                if (FrsTabController.this.jCu != null && eVar != null && TbadkCoreApplication.isLogin()) {
                    FrsTabController.this.jCu.fe(TbadkCoreApplication.getCurrentAccount(), String.valueOf(eVar.forumId));
                }
            }
        }
    };
    private ViewPager.OnPageChangeListener jCN = new ViewPager.OnPageChangeListener() { // from class: com.baidu.tieba.frs.gametab.FrsTabController.8
        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrolled(int i, float f, int i2) {
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            if (i != 1) {
                FrsTabController.this.jCn.setVisibility(0);
                if (FrsTabController.this.cBE() != null) {
                    FrsTabController.this.cBE().qt(false);
                }
                FrsTabController.this.jkw.cCY();
            }
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i) {
            switch (i) {
                case 0:
                    FrsTabController.this.jCp = false;
                    FrsTabController.this.jCl.setForceIntercept(false);
                    return;
                default:
                    return;
            }
        }
    };
    private FrsBaseViewPager.a jCO = new FrsBaseViewPager.a() { // from class: com.baidu.tieba.frs.gametab.FrsTabController.9
        @Override // com.baidu.tieba.frs.FrsBaseViewPager.a
        public void cCa() {
            if (FrsTabController.this.jCl != null) {
                if (FrsTabController.this.jCl.getCurrentItem() == 0) {
                    FrsTabController.this.jCl.setmDisallowSlip(true);
                } else {
                    FrsTabController.this.jCl.setmDisallowSlip(false);
                }
            }
        }

        @Override // com.baidu.tieba.frs.FrsBaseViewPager.a
        public boolean cCb() {
            if (FrsTabController.this.jCl.getCurrentItem() == 0) {
                if (FrsTabController.this.jCo && FrsTabController.this.jCp) {
                    FrsTabController.this.jCl.setmDisallowSlip(false);
                }
                if (!FrsTabController.this.jCp) {
                    FrsTabController.this.jCl.setmDisallowSlip(true);
                }
                FrsTabController.this.jCl.setmDisallowSlip(true);
            } else {
                FrsTabController.this.jCl.setmDisallowSlip(true);
            }
            return true;
        }
    };
    private String jCi = com.baidu.tbadk.core.sharedPref.b.getSharedPrefKeyWithAccount(SharedPrefConfig.SHOW_GAME_FOREM_TAB_HOT_POINT);

    public FrsTabController(FrsActivity frsActivity) {
        this.jCf = frsActivity;
    }

    public void init(Bundle bundle) {
        if (this.jCf != null) {
            this.jCf.setContentView(R.layout.frs_base_layout);
            this.jCl = (FrsBaseViewPager) this.jCf.findViewById(R.id.frs_base_viewpager);
            this.jCm = new FragmentAdapter(this.jCf.getSupportFragmentManager());
            this.jCl.setAdapter(this.jCm);
            this.jCl.setPageTransformer(true, new CubeOutViewPagerTransformer());
            this.jCl.addOnPageChangeListener(this.jCN);
            this.jCl.setmDisallowSlip(true);
            this.jCl.setOnTouchEventListener(this.jCO);
            this.jCn = (OvalActionButton) this.jCf.findViewById(R.id.frs_post_forum_button);
            this.jCn.setIsCircle(true);
            this.jCn.setHasShadow(false);
            this.jkB = (FRSRefreshButton) this.jCf.findViewById(R.id.frs_refresh_forum_button);
            this.jgk = (LinearLayout) this.jCf.findViewById(R.id.frs_ll_redpack);
            this.jCf.registerListener(this.jCI);
            this.jCf.registerListener(this.jCJ);
            this.jCB.getHttpMessageListener().setPriority(-1);
            this.jCB.getSocketMessageListener().setPriority(-1);
            this.jCf.registerListener(this.jCC);
            this.jCE.setSelfListener(true);
            this.jCf.registerListener(this.jCE);
            this.jCD.setSelfListener(true);
            this.jCf.registerListener(this.jCD);
            this.jCf.registerListener(this.mAccountChangedListener);
            if (bundle == null) {
                this.mForumName = this.jCf.getIntent().getStringExtra("name");
                this.mFrom = this.jCf.getIntent().getStringExtra("from");
                this.jky = this.jCf.getIntent().getIntExtra(FrsActivityConfig.FRS_GAME_DEFAULT_TAB_ID, 0);
            } else {
                this.mForumName = bundle.getString("name");
                this.mFrom = bundle.getString("from");
                this.jky = bundle.getInt("default_tab_id", 0);
            }
            ap(bundle);
            this.jCm.notifyDataSetChanged();
            this.jCj = new ShareSuccessReplyToServerModel();
            this.jCf.registerListener(this.jCB);
            this.jCf.registerListener(this.jCz);
            this.jCf.registerListener(this.jCA);
            this.jCf.registerListener(this.jCG);
        }
    }

    public void onSaveInstanceState(Bundle bundle) {
        bundle.putString("name", this.mForumName);
        bundle.putInt("default_tab_id", this.jky);
        bundle.putString("from", this.mFrom);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ap(Bundle bundle) {
        FragmentManager fragmentManager = getFragmentManager();
        if (fragmentManager != null && !fragmentManager.isDestroyed() && this.jCm != null) {
            try {
                FrsFragment frsFragment = (FrsFragment) this.jCm.KO(jCd);
                if (frsFragment == null) {
                    frsFragment = aq(bundle);
                }
                frsFragment.b(this.jCn);
                frsFragment.a(this.jkB);
                frsFragment.c(this.jgk);
                if (!jCd.equals(this.jCm.zU(0))) {
                    if (jCe.equals(this.jCm.zU(0))) {
                        this.jCm.zT(0);
                    }
                    this.jCm.a(0, frsFragment);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cIF() {
        FragmentManager fragmentManager = getFragmentManager();
        if (fragmentManager != null && !fragmentManager.isDestroyed() && this.jCm != null) {
            try {
                FrsTabHostFragment frsTabHostFragment = (FrsTabHostFragment) this.jCm.KO(jCe);
                if (frsTabHostFragment == null) {
                    frsTabHostFragment = cIG();
                }
                frsTabHostFragment.b(this.jCn);
                frsTabHostFragment.b(this.jkB);
                if (!jCe.equals(this.jCm.zU(0))) {
                    if (jCd.equals(this.jCm.zU(0))) {
                        this.jCm.zT(0);
                    }
                    this.jCm.a(0, frsTabHostFragment);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private FrsFragment aq(Bundle bundle) {
        if (this.jkw == null) {
            this.jkw = new FrsFragment();
            this.jkw.setArguments(bundle);
            this.jkw.setBaseTag(jCd);
        }
        this.jkw.jgr = false;
        return this.jkw;
    }

    private FrsTabHostFragment cIG() {
        if (this.jCg == null) {
            this.jCg = new FrsTabHostFragment(this);
            this.jCg.setBaseTag(jCe);
            this.jCg.yW(this.jky);
        }
        return this.jCg;
    }

    private FragmentManager getFragmentManager() {
        if (this.jCf != null) {
            return this.jCf.getSupportFragmentManager();
        }
        return null;
    }

    private void cIH() {
        ThemeColorInfo themeColorInfo;
        ThemeElement themeElement;
        if (this.jkx != null && (themeColorInfo = this.jkx.getForum().getThemeColorInfo()) != null && themeColorInfo.day != null && themeColorInfo.night != null && themeColorInfo.dark != null) {
            int skinType = TbadkCoreApplication.getInst().getSkinType();
            if (skinType == 4) {
                themeElement = themeColorInfo.dark;
            } else if (skinType == 1) {
                themeElement = themeColorInfo.night;
            } else {
                themeElement = themeColorInfo.day;
            }
            this.jCn.setStartAndEndColor(themeElement.light_color, themeElement.dark_color);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(m mVar, boolean z, int i) {
        if (mVar != null && mVar.getForum() != null) {
            this.jkx = mVar;
            ForumData forum = mVar.getForum();
            if (!e(mVar)) {
                if (z) {
                    a(forum, mVar.getAnti());
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921476));
            }
            if (forum.getIsShowBawuTask() && com.baidu.tbadk.core.sharedPref.b.brQ().getInt("key_bawu_task_toast", 0) == 0 && !this.jCr) {
                this.jCr = true;
                com.baidu.adp.lib.f.e.mA().postDelayed(new Runnable() { // from class: com.baidu.tieba.frs.gametab.FrsTabController.10
                    @Override // java.lang.Runnable
                    public void run() {
                        FrsTabController.this.cIN();
                    }
                }, 30000L);
            }
            if (mVar.bazhuExam != null && !this.jCs && z) {
                com.baidu.tieba.frs.m.a(this.jCf.getPageContext(), mVar.bazhuExam, forum.getId(), forum.getName());
                this.jCs = true;
            }
            if (y.getCount(mVar.getGameTabInfo()) > 0) {
                this.mHandler.post(new Runnable() { // from class: com.baidu.tieba.frs.gametab.FrsTabController.11
                    @Override // java.lang.Runnable
                    public void run() {
                        boolean dx = FrsTabController.this.dx(FrsTabController.this.jkx.getGameTabInfo());
                        if (dx) {
                            FrsTabController.this.jCm.notifyDataSetChanged();
                            if (dx && FrsTabController.this.jCg != null) {
                                FrsTabController.this.jCg.Y(FrsTabController.this.jkw);
                                FrsTabController.this.jCg.a(FrsTabController.this.jkx, FrsTabController.this.jkv);
                            }
                        }
                        if (FrsTabController.this.jCf.isLoadingViewAttached()) {
                            FrsTabController.this.jCf.hideLoadingView(FrsTabController.this.jCf.findViewById(16908290));
                        }
                    }
                });
            } else if (cIM()) {
                this.mHandler.post(new Runnable() { // from class: com.baidu.tieba.frs.gametab.FrsTabController.13
                    @Override // java.lang.Runnable
                    public void run() {
                        Bundle bundle;
                        FrsTabController.this.jkw.jgr = true;
                        if (FrsTabController.this.jkw != null) {
                            bundle = FrsTabController.this.jkw.getArguments();
                        } else {
                            bundle = null;
                        }
                        FrsTabController.this.ap(bundle);
                        FrsTabController.this.jCm.notifyDataSetChanged();
                        if (FrsTabController.this.jCf.isLoadingViewAttached()) {
                            FrsTabController.this.jCf.hideLoadingView(FrsTabController.this.jCf.findViewById(16908290));
                        }
                    }
                });
            }
            cIH();
            cIO();
            if (z) {
                if ((!this.jCw || i == 4) && forum.isLike() == 0 && com.baidu.tbadk.a.d.bjc() && TbadkCoreApplication.isLogin()) {
                    this.jCu = new com.baidu.tieba.frs.d.e();
                    this.jCf.registerListener(this.jCL);
                    this.jCf.registerListener(this.jCK);
                    this.jCf.registerListener(this.jCM);
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
            f(1, this.jCf.getString(R.string.forum_tool_first_bazhu_content), String.valueOf(R.drawable.pic_mask_update), "");
            com.baidu.tbadk.core.sharedPref.b.brQ().putBoolean("key_forum_tool_find_dialog_show", true);
            return true;
        } else if (!z && is_manager == 2) {
            f(2, this.jCf.getString(R.string.forum_tool_first_bawu_content), String.valueOf(R.drawable.pic_mask_update), "");
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
        final com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.jCf);
        aVar.nA(2);
        aVar.jG(false);
        FrsForumToolDialogView frsForumToolDialogView = new FrsForumToolDialogView(this.jCf);
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
                    bf.bsV().b(FrsTabController.this.jCf.getPageContext(), new String[]{"http://tieba.baidu.com/mo/q/bawuteam?fn=" + FrsTabController.this.cBE().getForumName() + "&fid=" + FrsTabController.this.cBE().getForumId()});
                } else if (i == 2) {
                    HashMap hashMap = new HashMap();
                    hashMap.put("forum_id", FrsTabController.this.cBE().getForumId());
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002015, new com.baidu.tieba.tbadkCore.data.m(FrsTabController.this.jCf, OpenFlutter.ACTIVITY_FORUM_DETAIL, hashMap)));
                } else if (i == 3 && !TextUtils.isEmpty(str3)) {
                    bf.bsV().b(FrsTabController.this.jCf.getPageContext(), new String[]{str3});
                }
            }
        });
        aVar.bn(frsForumToolDialogView);
        aVar.b(this.jCf.getPageContext()).bqx();
    }

    private void a(ForumData forumData, AntiData antiData) {
        if (forumData != null && !com.baidu.tbadk.youngster.b.a.a(this.jCf.getPageContext(), antiData, R.id.frs) && !c(forumData)) {
            List<TipInfo> tipInfos = forumData.getTipInfos();
            if (!y.isEmpty(tipInfos)) {
                com.baidu.tbadk.youngster.b.a.a(this.jCf.getPageContext(), tipInfos.get(0), TbadkCoreApplication.getCurrentAccount(), forumData.getId(), this.jCf.getString(R.string.frs_risk_dialog_button_text));
            }
        }
    }

    private boolean c(ForumData forumData) {
        if (au.isEmpty(forumData.getRiskTipPop()) || au.isEmpty(forumData.getRiskTipPopTitle())) {
            return false;
        }
        final com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.jCf);
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
        aVar.b(this.jCf.getPageContext()).bqx();
        return true;
    }

    public m cII() {
        return this.jkx;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean dx(List<FrsTabInfo> list) {
        if (this.jCf.isLoadingViewAttached()) {
            this.jCf.hideLoadingView(this.jCf.findViewById(16908290));
        }
        if (cIM()) {
            return false;
        }
        this.jkw.jgr = true;
        cIJ();
        if (com.baidu.tbadk.core.sharedPref.b.brQ().getBoolean("frs_game_login_tip", true)) {
            com.baidu.tbadk.core.sharedPref.b.brQ().putBoolean(SharedPrefConfig.FRS_LOGIN_TIP, true);
            com.baidu.tbadk.core.sharedPref.b.brQ().putBoolean("frs_game_login_tip", false);
        }
        dy(list);
        return true;
    }

    private void cIJ() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1021074, TbConfig.SERVER_ADDRESS + "game/forum/getNewNotify");
        tbHttpMessageTask.setResponsedClass(AlaGameTabGetNewNotifyResponsedMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
        this.jCf.registerListener(1021074, this.jCF);
    }

    private void dy(List<FrsTabInfo> list) {
        boolean z;
        if (!y.isEmpty(list)) {
            CustomMessageListener customMessageListener = new CustomMessageListener(CmdConfigCustom.CMD_GAME_FRS_ADD_TAB) { // from class: com.baidu.tieba.frs.gametab.FrsTabController.17
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.framework.listener.MessageListener
                public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                    if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof ai)) {
                        if (!com.baidu.tbadk.core.sharedPref.b.brQ().getBoolean(FrsTabController.this.jCi, true)) {
                            com.baidu.adp.lib.f.e.mA().post(FrsTabController.this.jCH);
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
                                bundle.putString("name", FrsTabController.this.jkw.getForumName());
                                bundle.putString("from", FrsTabController.this.jkw.getFrom());
                                bundle.putString("forum_id", FrsTabController.this.jkw.getForumId());
                                bundle.putInt("tab_id", 503);
                                bundle.putBoolean("can_auto_play_video", FrsTabController.this.jkx.isFrsVideoAutoPlay);
                                bundle.putBoolean("need_log", FrsTabController.this.jkx.needLog == 1);
                                bundle.putBoolean("is_brand_forum", FrsTabController.this.jkx.isBrandForum);
                                FrsViewData frsViewData = new FrsViewData();
                                frsViewData.receiveData(FrsTabController.this.jkx);
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
                        FrsTabController.this.cIF();
                    }
                }
            };
            customMessageListener.setPriority(Integer.MAX_VALUE);
            customMessageListener.setSelfListener(true);
            this.jCf.registerListener(customMessageListener);
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
            this.jkv = new ai(this.jCf.getActivity(), arrayList);
            if (cBE() != null) {
                this.jkv.setForumId(cBE().getForumId());
                this.jkv.setForumName(cBE().getForumName());
                if (cBE().cCZ() != null && cBE().cCZ().getForum() != null) {
                    ForumData forum = cBE().cCZ().getForum();
                    this.jkv.setForumGameLabel(forum.getForumGameLabel());
                    this.jkv.Im(forum.getSpecialForumType());
                }
            }
            this.jkw.jgr = false;
            new e(this.jkw).a(this.jkv);
            CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(CmdConfigCustom.CMD_GAME_FRS_ADD_TAB, this.jkv);
            CustomMessage customMessage = new CustomMessage(CmdConfigCustom.CMD_GAME_FRS_ADD_TAB);
            customMessage.setTag(this.jCf.getUniqueId());
            customResponsedMessage.setOrginalMessage(customMessage);
            MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cIK() {
        if (this.jkv != null && !TextUtils.isEmpty(this.jkv.getForumId())) {
            HttpMessage httpMessage = new HttpMessage(1021074);
            httpMessage.addParam("forum_id", this.jkx.getForum().getId());
            MessageManager.getInstance().sendMessage(httpMessage);
        }
    }

    private void a(Fragment fragment, int i) {
        NavigationBar bVd;
        if ((fragment instanceof ap) && this.jkx != null && this.jkx.getForum() != null && (bVd = ((ap) fragment).bVd()) != null) {
            StringBuilder sb = new StringBuilder();
            sb.append(UtilHelper.getFixedBarText(this.jkx.getForum().getName(), 5, true, true) + this.jCf.getActivity().getString(R.string.forum));
            bVd.setCenterTextTitle(sb.toString());
        }
    }

    @Override // com.baidu.tieba.InjectPlugin.a.b
    public void a(int i, com.baidu.tieba.InjectPlugin.a.a aVar) {
        if (this.jkw instanceof com.baidu.tieba.InjectPlugin.a.b) {
            this.jkw.a(i, aVar);
        }
    }

    @Override // com.baidu.tieba.InjectPlugin.a.b
    public com.baidu.tieba.InjectPlugin.a.a sM(int i) {
        if (this.jkw instanceof com.baidu.tieba.InjectPlugin.a.b) {
            return this.jkw.sM(i);
        }
        return null;
    }

    @Override // com.baidu.tieba.InjectPlugin.a.b
    public void a(com.baidu.tieba.InjectPlugin.b bVar) {
        if (this.jkw instanceof com.baidu.tieba.InjectPlugin.a.b) {
            this.jkw.a(bVar);
        }
    }

    public void onNewIntent(Intent intent) {
        if (this.jkw != null) {
            this.jkw.onNewIntent(intent);
        }
    }

    public void onResume() {
        if (!cIM()) {
            this.jkw.setPrimary(true);
        } else if (this.jCg != null) {
            Fragment currentFragment = this.jCg.getCurrentFragment();
            if (currentFragment instanceof BaseFragment) {
                ((BaseFragment) currentFragment).setPrimary(true);
            }
        }
        if (this.jCk) {
            this.jCk = false;
            if (this.jkw != null) {
                this.jkw.refresh();
            }
        }
        if (this.jkx != null && this.jkx.getUserData() != null && this.jkx.getUserData().getNewGodData() != null) {
            if (this.jkx.getForum() != null) {
                x.bFC().setFid(this.jkx.getForum().getId());
            }
            x.bFC().b(2, this.jkx.getUserData().getNewGodData());
        }
        this.jCy = true;
        if (this.jCx) {
            e((ForumData) null);
        }
    }

    public void onPause() {
        this.jCy = false;
        if (this.jCu != null) {
            this.jCu.cKB();
        }
        if (!cIM()) {
            this.jkw.setPrimary(false);
        } else if (this.jCg != null) {
            Fragment currentFragment = this.jCg.getCurrentFragment();
            if (currentFragment instanceof BaseFragment) {
                ((BaseFragment) currentFragment).setPrimary(false);
            }
        }
        x.bFC().removeCallbacks();
    }

    public void onChangeSkinType(int i) {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (skinType == 1 || skinType == 4) {
            UtilHelper.changeStatusBarIconAndTextColor(true, this.jCf);
        } else {
            UtilHelper.changeStatusBarIconAndTextColor(false, this.jCf);
        }
        if (this.jkw != null) {
            this.jkw.onChangeSkinType(i);
        }
        if (this.jCg != null) {
            this.jCg.onChangeSkinType(i);
        }
        cIH();
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            if (cIM() && this.jCg != null && this.jCg.cEf()) {
                this.jCg.cEx();
                UtilHelper.setNavigationBarBackground(this.jCf, this.jCg.cEs());
            } else if (this.jkw != null && this.jkw.isAdded()) {
                if (this.jkw.onKeyDown(i, keyEvent)) {
                    return true;
                }
                cIL();
            } else {
                return this.jCf.b(i, keyEvent);
            }
        } else if (i == 24) {
            if (this.jkw != null && this.jkw.isAdded()) {
                return this.jkw.onKeyDown(i, keyEvent);
            }
        } else {
            return this.jCf.b(i, keyEvent);
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cIL() {
        if (this.jkz != this.jky && cIM()) {
            this.jCg.setCurrentTab(this.jky);
            if (yU(this.jky) != 1) {
                this.jkw.qz(false);
            }
            this.jkz = this.jky;
            a(this.jCg.getCurrentFragment(), this.jky);
            return;
        }
        this.jkw.closeActivity();
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: com.baidu.tieba.frs.FrsActivity */
    /* JADX DEBUG: Multi-variable search result rejected for r2v1, resolved type: com.baidu.tieba.frs.FrsActivity */
    /* JADX WARN: Multi-variable type inference failed */
    public void onActivityResult(int i, int i2, Intent intent) {
        if (!cIM()) {
            this.jkw.onActivityResult(i, i2, intent);
        } else if (this.jCg != null) {
            if (1 == this.jCg.getCurrentTabType()) {
                this.jkw.onActivityResult(i, i2, intent);
            } else {
                this.jCg.getCurrentFragment().onActivityResult(i, i2, intent);
            }
        }
        if (i2 == -1) {
            if (i == 24007) {
                int intExtra = intent.getIntExtra("extra_share_status", 2);
                int intExtra2 = intent.getIntExtra("extra_show_channel", 1);
                if (intExtra == 1) {
                    com.baidu.tieba.o.a.dCR().I(this.jCf.getPageContext());
                    ShareItem shareItem = TbadkCoreApplication.getInst().getShareItem();
                    if (shareItem != null && shareItem.linkUrl != null && this.jCj != null) {
                        this.jCj.a(shareItem.linkUrl, intExtra2, new ShareSuccessReplyToServerModel.a() { // from class: com.baidu.tieba.frs.gametab.FrsTabController.18
                            @Override // com.baidu.tbadk.coreExtra.model.ShareSuccessReplyToServerModel.a
                            public void byF() {
                            }

                            @Override // com.baidu.tbadk.coreExtra.model.ShareSuccessReplyToServerModel.a
                            public void a(final CustomDialogData customDialogData) {
                                com.baidu.adp.lib.f.e.mA().postDelayed(new Runnable() { // from class: com.baidu.tieba.frs.gametab.FrsTabController.18.1
                                    @Override // java.lang.Runnable
                                    public void run() {
                                        if (FrsTabController.this.jCf != null) {
                                            com.baidu.tieba.pb.interactionpopupwindow.c.a(FrsTabController.this.jCf.getPageContext(), customDialogData).show();
                                        }
                                    }
                                }, 1000L);
                            }
                        });
                    }
                }
            } else if (i == 13011) {
                com.baidu.tieba.o.a.dCR().I(this.jCf.getPageContext());
            }
        }
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager getVoiceManager() {
        if (!cIM()) {
            return this.jkw.getVoiceManager();
        }
        if (this.jCg == null) {
            return null;
        }
        Fragment currentFragment = this.jCg.getCurrentFragment();
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
        if (this.jkv == null) {
            return -1;
        }
        int count = y.getCount(this.jkv.bAS());
        for (int i2 = 0; i2 < count; i2++) {
            if (this.jkv.bAS().get(i2).tab_id.intValue() == i) {
                return i2;
            }
        }
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int yU(int i) {
        if (this.jkv != null && i < y.getCount(this.jkv.bAS())) {
            return this.jkv.bAS().get(i).tab_id.intValue();
        }
        return -1;
    }

    public FrsFragment cBE() {
        return this.jkw;
    }

    @Override // com.baidu.tieba.tbadkCore.FrsCommonImageLayout.c
    public com.baidu.adp.lib.d.b<TbImageView> cBF() {
        if (!cIM()) {
            if (this.jkw instanceof FrsCommonImageLayout.c) {
                return ((FrsCommonImageLayout.c) this.jkw).cBF();
            }
        } else if (this.jCg == null) {
            return null;
        } else {
            Fragment currentFragment = this.jCg.getCurrentFragment();
            if (currentFragment instanceof FrsCommonImageLayout.c) {
                return ((FrsCommonImageLayout.c) currentFragment).cBF();
            }
        }
        return null;
    }

    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(FrsNoListItemViewHolder.jjH);
        this.mHandler.removeCallbacksAndMessages(null);
        if (this.jCf.isLoadingViewAttached()) {
            this.jCf.hideLoadingView(this.jCf.findViewById(16908290));
        }
        if (this.jCH != null) {
            com.baidu.adp.lib.f.e.mA().removeCallbacks(this.jCH);
        }
        com.baidu.tbadk.core.sharedPref.b.brQ().putBoolean(this.jCi, false);
        if (this.jCj != null) {
            this.jCj.cancelLoadData();
        }
        if (this.jkw != null && this.jkw.cCp() != null) {
            this.jkw.cCp().cIZ();
        }
        if (this.jCq != null) {
            this.jCq.onDestroy();
        }
        if (FrsActivityConfig.FRS_FROM_FLUTTER_BCASTEDIT.equals(this.mFrom)) {
            new p(TbadkCoreApplication.getInst()).bsh();
        }
        if (FrsActivityConfig.FRS_FROM_FORUM_RULE_EDIT.equals(this.mFrom)) {
            com.baidu.tbadk.k.d.bCB().ld(false);
        }
        if (this.jCv != null) {
            com.baidu.adp.lib.f.e.mA().removeCallbacks(this.jCv);
        }
        if (this.jkx != null && this.jkx.getForum() != null && this.jCu != null) {
            this.jCu.gx(com.baidu.adp.lib.f.b.toLong(this.jkx.getForum().getId(), 0L));
        }
    }

    public FragmentTabHost cEv() {
        if (this.jCg == null) {
            return null;
        }
        return this.jCg.cEv();
    }

    public boolean cIM() {
        if (this.jCm == null) {
            return false;
        }
        return this.jCm.getItem(0) instanceof FrsTabHostFragment;
    }

    public void yW(int i) {
        this.jky = i;
    }

    public void zR(int i) {
        this.jkz = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cIN() {
        if (this.jCf != null) {
            if (this.jCq == null) {
                this.jCq = (NavigationBarCoverTip) this.jCf.findViewById(R.id.navigation_cover_tip);
            }
            if (this.jCq != null) {
                View inflate = View.inflate(this.jCf, R.layout.write_thread_share_guide, null);
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
                com.baidu.tbadk.core.util.ap.setBackgroundColor(this.jCq, R.color.cp_link_tip_a_alpha95);
                tBSpecificationBtn.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.gametab.FrsTabController.19
                    /* JADX DEBUG: Multi-variable search result rejected for r4v9, resolved type: com.baidu.tieba.frs.FrsActivity */
                    /* JADX WARN: Multi-variable type inference failed */
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        new ar("c13439").bsO();
                        if (FrsTabController.this.cBE() != null && !TextUtils.isEmpty(FrsTabController.this.cBE().getForumId()) && !TextUtils.isEmpty(FrsTabController.this.mForumName) && FrsTabController.this.jCf != null) {
                            if (FrsTabController.this.jCq != null) {
                                FrsTabController.this.jCq.hideTip();
                            }
                            bf.bsV().b(FrsTabController.this.jCf.getPageContext(), new String[]{"https://tieba.baidu.com/mo/q/bawutask?fid=" + FrsTabController.this.cBE().getForumId() + "&fn=" + FrsTabController.this.mForumName + "&noread=" + (com.baidu.tbadk.core.sharedPref.b.brQ().getInt("key_bawu_task_toast", 0) == -1 ? 1 : 0)});
                        }
                    }
                });
                this.jCq.a(this.jCf, inflate, 30000);
                new ar("c13438").bsO();
                int i = com.baidu.tbadk.core.sharedPref.b.brQ().getInt("key_bawu_task_toast", 0);
                if (i >= 0) {
                    com.baidu.tbadk.core.sharedPref.b.brQ().putInt("key_bawu_task_toast", i + 1);
                }
            }
        }
    }

    private void cIO() {
        boolean z;
        if (this.jkx != null && this.jkx.getEntelechyTabInfo() != null && this.jkx.getEntelechyTabInfo().tab != null) {
            Iterator<FrsTabInfo> it = this.jkx.getEntelechyTabInfo().tab.iterator();
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
                if (this.jCt == null) {
                    this.jCt = new com.baidu.tieba.c.e(this.jCf.getPageContext(), this.jCn);
                    this.jCt.en(R.drawable.pic_sign_tip_down);
                    this.jCt.xh(2);
                    this.jCt.setUseDirectOffset(true);
                    this.jCt.xl(-l.getDimens(this.jCf, R.dimen.tbds20));
                    this.jCt.setYOffset(-l.getDimens(this.jCf, R.dimen.tbds20));
                    this.jCt.setTextColor(R.color.CAM_X0101);
                    this.jCt.setHeight(R.dimen.tbds54);
                    this.jCt.xj(l.getDimens(this.jCf, R.dimen.tbds44));
                }
                this.jCt.aJ(this.jCf.getString(R.string.frs_evaluate_tip), "first_into_frs_with_evaluate_tab");
            }
        }
    }

    private void d(final ForumData forumData) {
        boolean z = false;
        if (i(forumData.getName(), forumData.getId(), forumData.getImage_url(), false)) {
            if (this.jCv != null) {
                com.baidu.adp.lib.f.e.mA().removeCallbacks(this.jCv);
            }
            z = true;
        }
        if (!this.jCw) {
            this.jCu.cKA().k(TbadkCoreApplication.getCurrentAccount(), forumData.getId(), System.currentTimeMillis());
            this.jCw = true;
        }
        if (!z) {
            this.jCv = this.jCv != null ? this.jCv : new Runnable() { // from class: com.baidu.tieba.frs.gametab.FrsTabController.20
                @Override // java.lang.Runnable
                public void run() {
                    if (FrsTabController.this.jCu != null) {
                        if (FrsTabController.this.jCy) {
                            FrsTabController.this.i(forumData.getName(), forumData.getId(), forumData.getImage_url(), true);
                        } else {
                            FrsTabController.this.jCx = true;
                        }
                    }
                }
            };
            com.baidu.adp.lib.f.e.mA().postDelayed(this.jCv, AppStatusRules.DEFAULT_GRANULARITY);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(ForumData forumData) {
        if (this.jkw.cCr() != null && this.jCu != null) {
            if (forumData == null) {
                forumData = this.jkx.getForum();
            }
            if (forumData != null && forumData.isLike() != 1) {
                if (!this.jCy) {
                    this.jCx = true;
                } else if (i(forumData.getName(), forumData.getId(), forumData.getImage_url(), false) && this.jCv != null) {
                    com.baidu.adp.lib.f.e.mA().removeCallbacks(this.jCv);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean i(String str, String str2, String str3, boolean z) {
        if (!this.jCu.ff(TbadkCoreApplication.getCurrentAccount(), str2) || this.jkw == null || this.jkw.cCr() == null) {
            return false;
        }
        this.jCx = false;
        this.jCu.a(this.jCf, str, str2, str3, this.jkw.cCr().cLu());
        this.jCu.cKA().e(TbadkCoreApplication.getCurrentAccount(), str2, System.currentTimeMillis(), z);
        return true;
    }

    public boolean gv(long j) {
        ForumData forum;
        return (this.jkx == null || j == 0 || (forum = this.jkx.getForum()) == null || com.baidu.adp.lib.f.b.toLong(forum.getId(), 0L) != j) ? false : true;
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

        public BaseFragment KO(String str) {
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
        if (!cIM()) {
            return this.jkw.getTbPageTag();
        }
        if (this.jCg != null) {
            if (1 == this.jCg.getCurrentTabType()) {
                return this.jkw.getTbPageTag();
            }
            Fragment currentFragment = this.jCg.getCurrentFragment();
            if (currentFragment instanceof BaseFragment) {
                return ((BaseFragment) currentFragment).getTbPageTag();
            }
        }
        return null;
    }

    public void onScreenShot(String str) {
        if (this.jkx != null && this.jkx.getForum() != null) {
            TiebaStatic.log(new ar("c13848").dR("uid", TbadkCoreApplication.getCurrentAccount()).dR("fid", this.jkx.getForum().getId()).ap("obj_type", 2));
        }
    }
}
