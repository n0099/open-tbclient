package com.baidu.tieba.ala;

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
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.ala.AlaCmdConfigCustom;
import com.baidu.live.adp.base.BdBaseApplication;
import com.baidu.live.adp.framework.listener.CustomMessageListener;
import com.baidu.live.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.adp.lib.util.BdUtilHelper;
import com.baidu.live.adp.lib.util.StringUtils;
import com.baidu.live.tbadk.ActivityPendingTransitionFactory;
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
import com.baidu.live.u.a;
import com.baidu.live.utils.h;
import com.baidu.live.utils.r;
import com.baidu.tieba.ala.adapter.AlaRankListFragmentAdapter;
import com.baidu.tieba.ala.fragment.AlaRankListFragment;
/* loaded from: classes3.dex */
public class AlaRankListActivity extends BaseFragmentActivity implements View.OnTouchListener {
    private ImageView Wq;
    private int YH;
    private String alR;
    private FragmentTabHost eim;
    private TextView ein;
    private long eio;
    private String eip;
    private String eiq;
    private boolean eir;
    private ImageView eis;
    private AlaRankListFragmentAdapter eit;
    private int eiu;
    private TextView eiv;
    private String mPortrait;
    private View mRootView;
    private int mScreenWidth;
    private long mUserId;
    private String mUserName;
    private String otherParams;
    private final int eil = BdUtilHelper.getDimens(TbadkCoreApplication.getInst(), a.e.sdk_ds208);
    private Handler mHandler = new Handler();
    private boolean agN = false;
    private boolean ajI = false;
    private boolean ajJ = false;
    private CustomMessageListener ahd = new CustomMessageListener(2913054) { // from class: com.baidu.tieba.ala.AlaRankListActivity.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            AlaRankListActivity.this.closeActivity();
        }
    };
    CustomMessageListener ahe = new CustomMessageListener(AlaCmdConfigCustom.CMD_ALA_IMAGE_FRAME_PLAYER_CONTROLLER) { // from class: com.baidu.tieba.ala.AlaRankListActivity.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            AlaRankListActivity.this.closeActivity();
        }
    };
    private ViewTreeObserver.OnGlobalLayoutListener ajE = new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.tieba.ala.AlaRankListActivity.7
        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            int[] screenDimensions = BdUtilHelper.getScreenDimensions(AlaRankListActivity.this.getPageContext().getPageActivity());
            if (screenDimensions[0] > screenDimensions[1] && screenDimensions[0] != AlaRankListActivity.this.mScreenWidth) {
                AlaRankListActivity.this.mScreenWidth = screenDimensions[0];
                if (UtilHelper.canUseStyleImmersiveSticky()) {
                    AlaRankListActivity.this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.AlaRankListActivity.7.1
                        @Override // java.lang.Runnable
                        public void run() {
                            if (AlaRankListActivity.this.mRootView != null) {
                                h.S(AlaRankListActivity.this.mRootView);
                                r.d(AlaRankListActivity.this.getActivity(), false);
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
        if (BdBaseApplication.getInst() == null) {
            if (TbConfig.sdkInitCallback == null) {
                super.finish();
                return;
            }
            TbConfig.sdkInitCallback.initSdk();
        }
        if (bundle != null) {
            this.YH = bundle.getInt("live_type", 1);
            this.mUserId = bundle.getLong(TbEnum.SystemMessage.KEY_USER_ID, 0L);
            this.mUserName = bundle.getString(TbEnum.SystemMessage.KEY_USER_NAME, "");
            this.eiq = bundle.getString("rank_list_type", "");
            this.eir = bundle.getBoolean("rank_list_from");
            this.mPortrait = bundle.getString("portrait", "");
            this.otherParams = bundle.getString(IntentConfig.OTHER_PARAMS, "");
            this.alR = bundle.getString("feed_id", "");
            this.eio = bundle.getLong("cur_live_id", -1L);
            this.eip = bundle.getString("cur_hour", "");
        } else {
            this.YH = getIntent().getIntExtra("live_type", 1);
            this.mUserId = getIntent().getLongExtra(TbEnum.SystemMessage.KEY_USER_ID, 0L);
            this.mUserName = getIntent().getStringExtra(TbEnum.SystemMessage.KEY_USER_NAME);
            this.eiq = getIntent().getStringExtra("rank_list_type");
            this.eir = getIntent().getBooleanExtra("rank_list_from", false);
            this.mPortrait = getIntent().getStringExtra("portrait");
            this.alR = getIntent().getStringExtra("feed_id");
            this.eio = getIntent().getLongExtra("cur_live_id", -1L);
            this.eip = getIntent().getStringExtra("cur_hour");
            this.otherParams = getIntent().getStringExtra(IntentConfig.OTHER_PARAMS);
        }
        registerListener(this.ahe);
        registerListener(this.ahd);
        initView();
        ActivityPendingTransitionFactory.enterExitAnimation(getPageContext(), 0);
        this.ajI = false;
        this.mRootView.setVisibility(4);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        if (!this.agN) {
            this.mRootView.setVisibility(0);
            tt();
            this.agN = true;
        }
    }

    private void tt() {
        Animation loadAnimation;
        this.ajI = true;
        if (UtilHelper.getRealScreenOrientation(getActivity()) == 2) {
            loadAnimation = AnimationUtils.loadAnimation(getActivity(), a.C0102a.sdk_in_from_right);
        } else {
            loadAnimation = AnimationUtils.loadAnimation(getActivity(), a.C0102a.sdk_in_from_bottom);
        }
        loadAnimation.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.ala.AlaRankListActivity.1
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                AlaRankListActivity.this.ajI = false;
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        });
        this.mRootView.startAnimation(loadAnimation);
    }

    private void tu() {
        Animation loadAnimation;
        if (!this.ajJ && !this.ajI) {
            if (UtilHelper.getRealScreenOrientation(getActivity()) == 2) {
                loadAnimation = AnimationUtils.loadAnimation(getActivity(), a.C0102a.sdk_out_to_right);
            } else {
                loadAnimation = AnimationUtils.loadAnimation(getActivity(), a.C0102a.sdk_out_to_bottom);
            }
            loadAnimation.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.ala.AlaRankListActivity.2
                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationStart(Animation animation) {
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationEnd(Animation animation) {
                    AlaRankListActivity.super.finish();
                    ActivityPendingTransitionFactory.enterExitAnimation(AlaRankListActivity.this.getPageContext(), 0);
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationRepeat(Animation animation) {
                }
            });
            this.ajJ = true;
            this.mRootView.startAnimation(loadAnimation);
        }
    }

    @Override // com.baidu.live.tbadk.core.BaseFragmentActivity, android.app.Activity
    public void finish() {
        tu();
    }

    @Override // android.support.v4.app.FragmentActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        if (this.mRootView != null) {
            if (UtilHelper.getRealScreenOrientation(getActivity()) == 2) {
                h.S(this.mRootView);
                r.d(getActivity(), false);
            } else {
                h.T(this.mRootView);
                r.d(getActivity(), true);
            }
            if (UtilHelper.getRealScreenOrientation(getPageContext().getPageActivity()) == 2) {
                this.mRootView.setBackgroundResource(a.f.ala_rank_list_landscape_corner_bg);
            } else {
                this.mRootView.setBackgroundResource(a.f.ala_rank_list_top_corner_bg);
            }
            bbz();
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
        this.Wq = (ImageView) this.mRootView.findViewById(a.g.ala_rank_list_back);
        this.eiv = (TextView) this.mRootView.findViewById(a.g.ala_rank_list_title);
        this.ein = (TextView) this.mRootView.findViewById(a.g.ala_rank_list_full_entrance);
        this.eiv.setText(a.i.hkqm_rank_list_sub_panel_title);
        this.ein.setVisibility(4);
        this.Wq.setVisibility(8);
        this.ein.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.AlaRankListActivity.3
            /* JADX DEBUG: Multi-variable search result rejected for r1v1, resolved type: com.baidu.tieba.ala.AlaRankListActivity */
            /* JADX WARN: Multi-variable type inference failed */
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!StringUtils.isNull(com.baidu.live.v.a.zs().awM.ZT)) {
                    TiebaInitialize.log(new StatisticItem("c12964"));
                    UrlManager.getInstance().dealOneLink(AlaRankListActivity.this.getPageContext(), new String[]{com.baidu.live.v.a.zs().awM.ZT}, true);
                }
            }
        });
        this.eis = (ImageView) this.mRootView.findViewById(a.g.rule_icon);
        this.eis.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.AlaRankListActivity.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                String string;
                LogManager.getCommonLogger().doClickHourRankRuleIconLog(AlaRankListActivity.this.alR, AlaRankListActivity.this.otherParams);
                if (TbadkCoreApplication.getInst().isHaokan()) {
                    string = com.baidu.live.c.pw().getString("hour_rank_rule_hk_190808", "");
                } else if (TbadkCoreApplication.getInst().isQuanmin()) {
                    string = com.baidu.live.c.pw().getString("hour_rank_rule_qm_190808", "");
                } else {
                    string = com.baidu.live.c.pw().getString("hour_rank_rule_default", "");
                }
                BrowserHelper.startInternalWebActivity(AlaRankListActivity.this.getPageContext().getPageActivity(), string);
            }
        });
        bbH();
        initTabSpec();
        if (UtilHelper.getRealScreenOrientation(getActivity()) == 2) {
            h.S(this.mRootView);
            r.d(getActivity(), false);
        }
    }

    private void bbH() {
        this.eim = (FragmentTabHost) findViewById(a.g.ala_rank_list_tabhost);
        this.eim.setup(getSupportFragmentManager());
        this.eim.setTabWidgetViewHeight((int) getResources().getDimension(a.e.sdk_ds110));
        this.eim.needShowTopDiver(false);
        this.eim.setShouldDrawIndicatorLine(false);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.support.v4.app.FragmentActivity, android.support.v4.app.SupportActivity, android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putLong(TbEnum.SystemMessage.KEY_USER_ID, this.mUserId);
        bundle.putInt("live_type", this.YH);
        bundle.putString("rank_list_type", this.eiq);
        bundle.putBoolean("rank_list_from", this.eir);
        bundle.putString("portrait", this.mPortrait);
        bundle.putString("feed_id", this.alR);
        bundle.putLong("cur_live_id", this.eio);
        bundle.putString("cur_hour", this.eip);
        bundle.putString(IntentConfig.OTHER_PARAMS, this.otherParams);
    }

    @Override // android.app.Activity
    protected void onRestoreInstanceState(Bundle bundle) {
        bundle.putLong(TbEnum.SystemMessage.KEY_USER_ID, this.mUserId);
        bundle.putInt("live_type", this.YH);
        bundle.putString("rank_list_type", this.eiq);
        bundle.putBoolean("rank_list_from", this.eir);
        bundle.putString("portrait", this.mPortrait);
        bundle.putString(IntentConfig.OTHER_PARAMS, this.otherParams);
        bundle.putString("feed_id", this.alR);
        bundle.putLong("cur_live_id", this.eio);
        bundle.putString("cur_hour", this.eip);
        super.onRestoreInstanceState(bundle);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void closeActivity() {
        finish();
    }

    @Override // com.baidu.live.tbadk.core.BaseFragmentActivity, android.app.Activity, android.view.Window.Callback
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        bbz();
    }

    private void bbz() {
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
            window.getDecorView().getViewTreeObserver().addOnGlobalLayoutListener(this.ajE);
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

    private void initTabSpec() {
        this.eit = new AlaRankListFragmentAdapter(this, this.YH, this.mUserId, this.mUserName, this.eir, this.mPortrait, this.otherParams, this.alR, this.eio, this.eip);
        this.eiu = this.eit.xH(this.eiq);
        int count = this.eit.getCount();
        for (int i = 0; i < count; i++) {
            AlaRankListFragment alaRankListFragment = (AlaRankListFragment) this.eit.getItem(i);
            if (alaRankListFragment != null) {
                a(alaRankListFragment, this.eit.oB(i));
            }
        }
        FragmentTabWidget fragmentTabWidget = this.eim.getFragmentTabWidget();
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) fragmentTabWidget.getLayoutParams();
        layoutParams.gravity = 1;
        if (TbadkCoreApplication.getInst().isHaokan() || TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isTieba() || TbadkCoreApplication.getInst().isMobileBaidu()) {
            int dimens = BdUtilHelper.getDimens(TbadkCoreApplication.getInst(), a.e.sdk_ds38);
            layoutParams.width = -1;
            fragmentTabWidget.setPadding(dimens, fragmentTabWidget.getPaddingTop(), dimens, fragmentTabWidget.getPaddingBottom());
        } else {
            layoutParams.width = this.eil * this.eit.getCount();
        }
        fragmentTabWidget.setLayoutParams(layoutParams);
        this.eim.initViewPagerWithNoType();
        this.eim.setCurrentTab(this.eiu);
        this.eit.oC(this.eiu);
        this.eim.setOnPageChangeListener(new ViewPager.OnPageChangeListener() { // from class: com.baidu.tieba.ala.AlaRankListActivity.8
            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrolled(int i2, float f, int i3) {
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageSelected(int i2) {
                AlaRankListActivity.this.eit.oC(i2);
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
            this.eim.addTabSpec(tabSpec);
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
        getWindow().getDecorView().getViewTreeObserver().removeGlobalOnLayoutListener(this.ajE);
        this.ajE = null;
    }
}
