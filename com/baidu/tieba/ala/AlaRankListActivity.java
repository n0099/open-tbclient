package com.baidu.tieba.ala;

import android.app.Activity;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.Window;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.ala.AlaCmdConfigCustom;
import com.baidu.live.adp.framework.listener.CustomMessageListener;
import com.baidu.live.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.adp.lib.util.BdUtilHelper;
import com.baidu.live.adp.lib.util.StringUtils;
import com.baidu.live.k.a;
import com.baidu.live.tbadk.TbConfig;
import com.baidu.live.tbadk.browser.BrowserHelper;
import com.baidu.live.tbadk.core.BaseFragmentActivity;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.frameworkdata.IntentConfig;
import com.baidu.live.tbadk.core.tabhost.FragmentTabHost;
import com.baidu.live.tbadk.core.tabhost.FragmentTabWidget;
import com.baidu.live.tbadk.core.util.StatisticItem;
import com.baidu.live.tbadk.core.util.TbEnum;
import com.baidu.live.tbadk.core.util.TiebaInitialize;
import com.baidu.live.tbadk.core.util.UrlManager;
import com.baidu.live.tbadk.core.util.UtilHelper;
import com.baidu.live.tbadk.log.LogManager;
import com.baidu.live.tbadk.maintab.FragmentTabIndicator;
import com.baidu.live.utils.g;
import com.baidu.live.utils.q;
import com.baidu.megapp.ma.Util;
import com.baidu.tieba.ala.adapter.AlaRankListFragmentAdapter;
import com.baidu.tieba.ala.fragment.AlaRankListFragment;
/* loaded from: classes6.dex */
public class AlaRankListActivity extends BaseFragmentActivity implements View.OnTouchListener {
    private static final int dtJ = BdUtilHelper.getDimens(TbadkCoreApplication.getInst(), a.e.sdk_ds208);
    private ImageView Nj;
    private int Pw;
    private String aaL;
    private FragmentTabHost dtK;
    private TextView dtL;
    private long dtM;
    private String dtN;
    private String dtO;
    private boolean dtP;
    private ImageView dtQ;
    private AlaRankListFragmentAdapter dtR;
    private int dtS;
    private TextView dtT;
    private String mPortrait;
    private View mRootView;
    private int mScreenWidth;
    private long mUserId;
    private String mUserName;
    private String otherParams;
    private Handler mHandler = new Handler();
    private CustomMessageListener dtU = new CustomMessageListener(2913054) { // from class: com.baidu.tieba.ala.AlaRankListActivity.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            AlaRankListActivity.this.closeActivity();
        }
    };
    CustomMessageListener afT = new CustomMessageListener(AlaCmdConfigCustom.CMD_ALA_IMAGE_FRAME_PLAYER_CONTROLLER) { // from class: com.baidu.tieba.ala.AlaRankListActivity.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            AlaRankListActivity.this.closeActivity();
        }
    };
    private ViewTreeObserver.OnGlobalLayoutListener YD = new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.tieba.ala.AlaRankListActivity.5
        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            int[] screenDimensions = BdUtilHelper.getScreenDimensions(AlaRankListActivity.this.getPageContext().getPageActivity());
            if (screenDimensions[0] > screenDimensions[1] && screenDimensions[0] != AlaRankListActivity.this.mScreenWidth) {
                AlaRankListActivity.this.mScreenWidth = screenDimensions[0];
                if (UtilHelper.canUseStyleImmersiveSticky()) {
                    AlaRankListActivity.this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.AlaRankListActivity.5.1
                        @Override // java.lang.Runnable
                        public void run() {
                            if (AlaRankListActivity.this.mRootView != null) {
                                g.P(AlaRankListActivity.this.mRootView);
                                q.d(AlaRankListActivity.this.getActivity(), false);
                            }
                        }
                    }, 300L);
                }
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.live.tbadk.core.BaseFragmentActivity, com.baidu.live.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.support.v4.app.SupportActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        setIsAddSwipeBackLayout(false);
        setUseStyleImmersiveSticky(true);
        super.onCreate(bundle);
        if (bundle != null) {
            this.Pw = bundle.getInt("live_type", 1);
            this.mUserId = bundle.getLong(TbEnum.SystemMessage.KEY_USER_ID, 0L);
            this.mUserName = bundle.getString(TbEnum.SystemMessage.KEY_USER_NAME, "");
            this.dtO = bundle.getString("rank_list_type", "");
            this.dtP = bundle.getBoolean("rank_list_from");
            this.mPortrait = bundle.getString("portrait", "");
            this.otherParams = bundle.getString(IntentConfig.OTHER_PARAMS, "");
            this.aaL = bundle.getString("feed_id", "");
            this.dtM = bundle.getLong("cur_live_id", -1L);
            this.dtN = bundle.getString("cur_hour", "");
        } else {
            this.Pw = getIntent().getIntExtra("live_type", 1);
            this.mUserId = getIntent().getLongExtra(TbEnum.SystemMessage.KEY_USER_ID, 0L);
            this.mUserName = getIntent().getStringExtra(TbEnum.SystemMessage.KEY_USER_NAME);
            this.dtO = getIntent().getStringExtra("rank_list_type");
            this.dtP = getIntent().getBooleanExtra("rank_list_from", false);
            this.mPortrait = getIntent().getStringExtra("portrait");
            this.aaL = getIntent().getStringExtra("feed_id");
            this.dtM = getIntent().getLongExtra("cur_live_id", -1L);
            this.dtN = getIntent().getStringExtra("cur_hour");
            this.otherParams = getIntent().getStringExtra(IntentConfig.OTHER_PARAMS);
        }
        registerListener(this.afT);
        registerListener(this.dtU);
        initView();
    }

    @Override // android.support.v4.app.FragmentActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        if (this.mRootView != null) {
            if (UtilHelper.getRealScreenOrientation(getActivity()) == 2) {
                g.P(this.mRootView);
                q.d(getActivity(), false);
            } else {
                g.Q(this.mRootView);
                q.d(getActivity(), true);
            }
            if (UtilHelper.getRealScreenOrientation(getPageContext().getPageActivity()) == 2) {
                this.mRootView.setBackgroundResource(a.f.ala_rank_list_landscape_corner_bg);
            } else {
                this.mRootView.setBackgroundResource(a.f.ala_rank_list_top_corner_bg);
            }
            aIF();
            aIE();
        }
    }

    private void initView() {
        this.mRootView = LayoutInflater.from(getPageContext().getPageActivity()).inflate(a.h.ala_rank_list_layout, (ViewGroup) null);
        if (UtilHelper.getRealScreenOrientation(getPageContext().getPageActivity()) == 2) {
            this.mRootView.setBackgroundResource(a.f.ala_rank_list_landscape_corner_bg);
        } else {
            this.mRootView.setBackgroundResource(a.f.ala_rank_list_top_corner_bg);
        }
        setContentView(this.mRootView);
        this.Nj = (ImageView) this.mRootView.findViewById(a.g.ala_rank_list_back);
        this.dtT = (TextView) this.mRootView.findViewById(a.g.ala_rank_list_title);
        this.dtL = (TextView) this.mRootView.findViewById(a.g.ala_rank_list_full_entrance);
        this.dtT.setText(a.i.hkqm_rank_list_sub_panel_title);
        this.dtL.setVisibility(4);
        this.Nj.setVisibility(8);
        this.dtL.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.AlaRankListActivity.1
            /* JADX DEBUG: Multi-variable search result rejected for r1v1, resolved type: com.baidu.tieba.ala.AlaRankListActivity */
            /* JADX WARN: Multi-variable type inference failed */
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!StringUtils.isNull(com.baidu.live.l.a.uB().ajF.QK)) {
                    TiebaInitialize.log(new StatisticItem("c12964"));
                    UrlManager.getInstance().dealOneLink(AlaRankListActivity.this.getPageContext(), new String[]{com.baidu.live.l.a.uB().ajF.QK}, true);
                }
            }
        });
        this.dtQ = (ImageView) this.mRootView.findViewById(a.g.rule_icon);
        this.dtQ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.AlaRankListActivity.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                String string;
                LogManager.getCommonLogger().doClickHourRankRuleIconLog(AlaRankListActivity.this.aaL, AlaRankListActivity.this.otherParams);
                if (TbadkCoreApplication.getInst().isHaokan()) {
                    string = com.baidu.live.c.np().getString("hour_rank_rule_hk_190808", "");
                } else if (TbadkCoreApplication.getInst().isQuanmin()) {
                    string = com.baidu.live.c.np().getString("hour_rank_rule_qm_190808", "");
                } else {
                    string = com.baidu.live.c.np().getString("hour_rank_rule_default", "");
                }
                BrowserHelper.startInternalWebActivity(AlaRankListActivity.this.getPageContext().getPageActivity(), string);
            }
        });
        aID();
        initTabSpec();
        if (UtilHelper.getRealScreenOrientation(getActivity()) == 2) {
            g.P(this.mRootView);
            q.d(getActivity(), false);
        }
    }

    private void aID() {
        this.dtK = (FragmentTabHost) findViewById(a.g.ala_rank_list_tabhost);
        this.dtK.setup(getSupportFragmentManager());
        this.dtK.setTabWidgetViewHeight((int) getResources().getDimension(a.e.sdk_ds110));
        this.dtK.needShowTopDiver(false);
        this.dtK.setShouldDrawIndicatorLine(false);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.support.v4.app.FragmentActivity, android.support.v4.app.SupportActivity, android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putLong(TbEnum.SystemMessage.KEY_USER_ID, this.mUserId);
        bundle.putInt("live_type", this.Pw);
        bundle.putString("rank_list_type", this.dtO);
        bundle.putBoolean("rank_list_from", this.dtP);
        bundle.putString("portrait", this.mPortrait);
        bundle.putString("feed_id", this.aaL);
        bundle.putLong("cur_live_id", this.dtM);
        bundle.putString("cur_hour", this.dtN);
        bundle.putString(IntentConfig.OTHER_PARAMS, this.otherParams);
    }

    @Override // android.app.Activity
    protected void onRestoreInstanceState(Bundle bundle) {
        bundle.putLong(TbEnum.SystemMessage.KEY_USER_ID, this.mUserId);
        bundle.putInt("live_type", this.Pw);
        bundle.putString("rank_list_type", this.dtO);
        bundle.putBoolean("rank_list_from", this.dtP);
        bundle.putString("portrait", this.mPortrait);
        bundle.putString(IntentConfig.OTHER_PARAMS, this.otherParams);
        bundle.putString("feed_id", this.aaL);
        bundle.putLong("cur_live_id", this.dtM);
        bundle.putString("cur_hour", this.dtN);
        super.onRestoreInstanceState(bundle);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void closeActivity() {
        finish();
    }

    @Override // com.baidu.live.tbadk.core.BaseFragmentActivity, android.app.Activity, android.view.Window.Callback
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        aIE();
    }

    private void aIE() {
        Window window = getWindow();
        if (window != null) {
            int[] screenDimensions = BdUtilHelper.getScreenDimensions(getPageContext().getPageActivity());
            View decorView = window.getDecorView();
            decorView.setOnTouchListener(this);
            if (!UtilHelper.canUseStyleImmersiveSticky()) {
                WindowManager.LayoutParams attributes = window.getAttributes();
                if (screenDimensions[1] > screenDimensions[0]) {
                    attributes.height = screenDimensions[1] - BdUtilHelper.getStatusBarHeight(getPageContext().getPageActivity());
                    attributes.gravity = 80;
                } else {
                    attributes.height = screenDimensions[1];
                    attributes.gravity = 48;
                }
                getWindowManager().updateViewLayout(decorView, attributes);
            }
            this.mScreenWidth = screenDimensions[0];
            window.setBackgroundDrawableResource(17170445);
            window.getDecorView().getViewTreeObserver().addOnGlobalLayoutListener(this.YD);
            if (this.mRootView.getLayoutParams() instanceof FrameLayout.LayoutParams) {
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.mRootView.getLayoutParams();
                if (screenDimensions[1] > screenDimensions[0]) {
                    layoutParams.width = screenDimensions[0];
                    layoutParams.height = (int) (screenDimensions[1] * 0.618d);
                    layoutParams.gravity = 80;
                } else {
                    layoutParams.width = screenDimensions[1];
                    layoutParams.height = screenDimensions[1];
                    layoutParams.gravity = 53;
                }
                this.mRootView.setLayoutParams(layoutParams);
            }
        }
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            if (view == this.mRootView) {
                return true;
            }
            setResult(0);
            finish();
            return true;
        }
        return false;
    }

    private void aIF() {
        if (this instanceof Activity) {
            if (UtilHelper.getRealScreenOrientation(getPageContext().getPageActivity()) == 2) {
                overridePendingTransition(a.C0068a.sdk_activity_open_translate_from_right, a.C0068a.sdk_activity_close_translate_to_right);
            } else {
                overridePendingTransition(a.C0068a.sdk_activity_open_translate_from_bottom, a.C0068a.sdk_activity_close_translate_from_top);
            }
        } else if (UtilHelper.getRealScreenOrientation(getPageContext().getPageActivity()) == 2) {
            overridePendingTransition(Util.getHostResourcesId(getActivity(), TbConfig.PACKAGE_NAME, "slide_in_from_right", "anim"), Util.getHostResourcesId(getActivity(), TbConfig.PACKAGE_NAME, "slide_out_to_right", "anim"));
        } else {
            overridePendingTransition(Util.getHostResourcesId(getActivity(), TbConfig.PACKAGE_NAME, "slide_in_from_bottom", "anim"), Util.getHostResourcesId(getActivity(), TbConfig.PACKAGE_NAME, "slide_out_to_bottom", "anim"));
        }
    }

    @Override // com.baidu.live.tbadk.core.BaseFragmentActivity
    public void enterExitAnimation() {
        aIF();
    }

    @Override // com.baidu.live.tbadk.core.BaseFragmentActivity
    public void closeAnimation() {
        aIF();
    }

    private void initTabSpec() {
        this.dtR = new AlaRankListFragmentAdapter(this, this.Pw, this.mUserId, this.mUserName, this.dtP, this.mPortrait, this.otherParams, this.aaL, this.dtM, this.dtN);
        this.dtS = this.dtR.sB(this.dtO);
        int count = this.dtR.getCount();
        for (int i = 0; i < count; i++) {
            AlaRankListFragment alaRankListFragment = (AlaRankListFragment) this.dtR.getItem(i);
            if (alaRankListFragment != null) {
                a(alaRankListFragment, this.dtR.lZ(i));
            }
        }
        FragmentTabWidget fragmentTabWidget = this.dtK.getFragmentTabWidget();
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) fragmentTabWidget.getLayoutParams();
        layoutParams.gravity = 1;
        if (TbadkCoreApplication.getInst().isHaokan() || TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isTieba()) {
            int dimens = BdUtilHelper.getDimens(TbadkCoreApplication.getInst(), a.e.sdk_ds38);
            layoutParams.width = -1;
            fragmentTabWidget.setPadding(dimens, fragmentTabWidget.getPaddingTop(), dimens, fragmentTabWidget.getPaddingBottom());
        } else {
            layoutParams.width = dtJ * this.dtR.getCount();
        }
        fragmentTabWidget.setLayoutParams(layoutParams);
        this.dtK.initViewPagerWithNoType();
        this.dtK.setCurrentTab(this.dtS);
        this.dtR.ma(this.dtS);
        this.dtK.setOnPageChangeListener(new ViewPager.OnPageChangeListener() { // from class: com.baidu.tieba.ala.AlaRankListActivity.6
            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrolled(int i2, float f, int i3) {
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageSelected(int i2) {
                AlaRankListActivity.this.dtR.ma(i2);
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrollStateChanged(int i2) {
            }
        });
    }

    private void a(Fragment fragment, String str) {
        if (fragment != null) {
            FragmentTabHost.TabSpec tabSpec = new FragmentTabHost.TabSpec();
            FragmentTabIndicator fragmentTabIndicator = new FragmentTabIndicator(getPageContext().getContext());
            tabSpec.mContentFragment = fragment;
            fragmentTabIndicator.setGradientAttrs(getPageContext().getResources().getColor(a.d.sdk_color_ff1e66), getPageContext().getResources().getColor(a.d.sdk_color_ff6619), getResources().getDimension(a.e.sdk_fontsize32), getResources().getDimension(a.e.sdk_fontsize40), true);
            fragmentTabIndicator.setText(str);
            fragmentTabIndicator.setTextColorResId(a.d.sdk_color_e6e6e6);
            fragmentTabIndicator.setTextSize(0, getResources().getDimension(a.e.sdk_fontsize32));
            tabSpec.mIndicatorView = fragmentTabIndicator;
            this.dtK.addTabSpec(tabSpec);
        }
    }

    @Override // com.baidu.live.tbadk.core.BaseFragmentActivity
    protected void onChangeSkinType(int i) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.live.tbadk.core.BaseFragmentActivity, com.baidu.live.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.mHandler.removeCallbacksAndMessages(null);
        getWindow().getDecorView().getViewTreeObserver().removeGlobalOnLayoutListener(this.YD);
        this.YD = null;
    }
}
