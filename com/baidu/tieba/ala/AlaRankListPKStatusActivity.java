package com.baidu.tieba.ala;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
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
import com.baidu.fsg.base.utils.ResUtils;
import com.baidu.live.adp.framework.listener.CustomMessageListener;
import com.baidu.live.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.adp.lib.util.BdUtilHelper;
import com.baidu.live.tbadk.TbConfig;
import com.baidu.live.tbadk.core.BaseFragmentActivity;
import com.baidu.live.tbadk.core.tabhost.FragmentTabHost;
import com.baidu.live.tbadk.core.tabhost.FragmentTabWidget;
import com.baidu.live.tbadk.core.util.TbEnum;
import com.baidu.live.tbadk.core.util.UtilHelper;
import com.baidu.live.tbadk.maintab.FragmentTabIndicator;
import com.baidu.live.u.a;
import com.baidu.live.utils.h;
import com.baidu.megapp.ma.Util;
import com.baidu.tieba.ala.adapter.AlaRankListPKStatusFragmentAdapter;
/* loaded from: classes3.dex */
public class AlaRankListPKStatusActivity extends BaseFragmentActivity implements View.OnTouchListener {
    private int avX;
    private String eUJ;
    private boolean eUK;
    private FragmentTabHost eUR;
    private AlaRankListPKStatusFragmentAdapter eUS;
    private String mPortrait;
    private View mRootView;
    private int mScreenWidth;
    private long mUserId;
    private Handler mHandler = new Handler();
    CustomMessageListener aES = new CustomMessageListener(AlaCmdConfigCustom.CMD_ALA_IMAGE_FRAME_PLAYER_CONTROLLER) { // from class: com.baidu.tieba.ala.AlaRankListPKStatusActivity.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            AlaRankListPKStatusActivity.this.closeActivity();
        }
    };
    private ViewTreeObserver.OnGlobalLayoutListener aHH = new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.tieba.ala.AlaRankListPKStatusActivity.3
        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            int[] screenDimensions = BdUtilHelper.getScreenDimensions(AlaRankListPKStatusActivity.this.getPageContext().getPageActivity());
            if (screenDimensions[0] > screenDimensions[1] && screenDimensions[0] != AlaRankListPKStatusActivity.this.mScreenWidth) {
                AlaRankListPKStatusActivity.this.mScreenWidth = screenDimensions[0];
                if (UtilHelper.canUseStyleImmersiveSticky()) {
                    AlaRankListPKStatusActivity.this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.AlaRankListPKStatusActivity.3.1
                        @Override // java.lang.Runnable
                        public void run() {
                            if (AlaRankListPKStatusActivity.this.mRootView != null) {
                                h.T(AlaRankListPKStatusActivity.this.mRootView);
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
        if (!isFinishing()) {
            if (bundle != null) {
                this.avX = bundle.getInt("live_type", 1);
                this.mUserId = bundle.getLong(TbEnum.SystemMessage.KEY_USER_ID, 0L);
                this.eUJ = bundle.getString("rank_list_type", "");
                this.eUK = bundle.getBoolean("rank_list_from");
                this.mPortrait = bundle.getString("portrait");
            } else {
                this.avX = getIntent().getIntExtra("live_type", 1);
                this.mUserId = getIntent().getLongExtra(TbEnum.SystemMessage.KEY_USER_ID, 0L);
                this.eUJ = getIntent().getStringExtra("rank_list_type");
                this.eUK = getIntent().getBooleanExtra("rank_list_from", false);
                this.mPortrait = getIntent().getStringExtra("portrait");
            }
            registerListener(this.aES);
            initView();
        }
    }

    private void initView() {
        this.mRootView = LayoutInflater.from(getPageContext().getPageActivity()).inflate(a.h.ala_pk_status_layout, (ViewGroup) null);
        setContentView(this.mRootView);
        ImageView imageView = (ImageView) this.mRootView.findViewById(a.g.ala_rank_list_back);
        imageView.setVisibility(0);
        imageView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.AlaRankListPKStatusActivity.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                AlaRankListPKStatusActivity.this.finish();
            }
        });
        ((TextView) this.mRootView.findViewById(a.g.ala_rank_list_title)).setText(a.i.ala_rank_list_pk_status_panel_title);
        bpe();
        initTabSpec();
        if (UtilHelper.canUseStyleImmersiveSticky() && UtilHelper.getRealScreenOrientation(getActivity()) == 2) {
            h.T(this.mRootView);
        }
    }

    private void bpe() {
        this.eUR = (FragmentTabHost) findViewById(a.g.ala_rank_list_tabhost);
        this.eUR.setup(getSupportFragmentManager());
        this.eUR.setTabWidgetViewHeight((int) getResources().getDimension(a.e.sdk_ds80));
        this.eUR.getFragmentTabWidget().setAbsoluteWeight(true);
        this.eUR.getFragmentTabWidget().setDiverColor(getResources().getColor(a.d.sdk_cp_cont_b));
        this.eUR.getFragmentTabWidget().setDviderRectWidth(-2);
        this.eUR.getFragmentTabWidget().setDviderRectHeight(BdUtilHelper.getDimens(getPageContext().getPageActivity(), a.e.sdk_ds4));
    }

    private void initTabSpec() {
        this.eUS = new AlaRankListPKStatusFragmentAdapter(this, this.avX, this.mUserId, this.eUK, this.mPortrait);
        int AD = this.eUS.AD(this.eUJ);
        int count = this.eUS.getCount();
        for (int i = 0; i < count; i++) {
            Fragment item = this.eUS.getItem(i);
            if (item != null) {
                a(item, this.eUS.pq(i));
            }
        }
        FragmentTabWidget fragmentTabWidget = this.eUR.getFragmentTabWidget();
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) fragmentTabWidget.getLayoutParams();
        layoutParams.gravity = 1;
        layoutParams.width = -1;
        layoutParams.leftMargin = (int) getResources().getDimension(a.e.sdk_ds34);
        layoutParams.rightMargin = (int) getResources().getDimension(a.e.sdk_ds34);
        fragmentTabWidget.setLayoutParams(layoutParams);
        this.eUR.initViewPagerWithNoType();
        this.eUR.setCurrentTab(AD);
    }

    private void a(Fragment fragment, String str) {
        if (fragment != null) {
            FragmentTabHost.TabSpec tabSpec = new FragmentTabHost.TabSpec();
            FragmentTabIndicator fragmentTabIndicator = new FragmentTabIndicator(getPageContext().getContext());
            tabSpec.mContentFragment = fragment;
            fragmentTabIndicator.setText(str);
            fragmentTabIndicator.setTextColorResId(a.d.ala_rank_list_tab_text_color);
            fragmentTabIndicator.setTextSize(0, getResources().getDimension(a.e.sdk_fontsize32));
            tabSpec.mIndicatorView = fragmentTabIndicator;
            this.eUR.addTabSpec(tabSpec);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.support.v4.app.FragmentActivity, android.support.v4.app.SupportActivity, android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putLong(TbEnum.SystemMessage.KEY_USER_ID, this.mUserId);
        bundle.putInt("live_type", this.avX);
        bundle.putString("rank_list_type", this.eUJ);
        bundle.putBoolean("rank_list_from", this.eUK);
        bundle.putString("portrait", this.mPortrait);
    }

    @Override // android.app.Activity
    protected void onRestoreInstanceState(Bundle bundle) {
        bundle.putLong(TbEnum.SystemMessage.KEY_USER_ID, this.mUserId);
        bundle.putInt("live_type", this.avX);
        bundle.putString("rank_list_type", this.eUJ);
        bundle.putBoolean("rank_list_from", this.eUK);
        bundle.putString("portrait", this.mPortrait);
        super.onRestoreInstanceState(bundle);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void closeActivity() {
        finish();
    }

    @Override // com.baidu.live.tbadk.core.BaseFragmentActivity, android.app.Activity, android.view.Window.Callback
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        Window window = getWindow();
        if (window != null) {
            int[] screenDimensions = BdUtilHelper.getScreenDimensions(getPageContext().getPageActivity());
            View decorView = window.getDecorView();
            decorView.setOnTouchListener(this);
            if (!UtilHelper.canUseStyleImmersiveSticky() && screenDimensions[1] > screenDimensions[0]) {
                WindowManager.LayoutParams attributes = window.getAttributes();
                attributes.height = screenDimensions[1] - BdUtilHelper.getStatusBarHeight(getPageContext().getPageActivity());
                attributes.gravity = 80;
                getWindowManager().updateViewLayout(decorView, attributes);
            }
            this.mScreenWidth = screenDimensions[0];
            window.setBackgroundDrawableResource(17170445);
            window.getDecorView().getViewTreeObserver().addOnGlobalLayoutListener(this.aHH);
            if (this.mRootView.getLayoutParams() instanceof FrameLayout.LayoutParams) {
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.mRootView.getLayoutParams();
                if (screenDimensions[1] > screenDimensions[0]) {
                    layoutParams.width = screenDimensions[0];
                    layoutParams.height = (int) (screenDimensions[1] * 0.618d);
                    layoutParams.gravity = 80;
                } else {
                    layoutParams.width = (int) getResources().getDimension(a.e.sdk_ds720);
                    layoutParams.height = screenDimensions[1];
                    layoutParams.gravity = 85;
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

    private void bpf() {
        if (this instanceof Activity) {
            overridePendingTransition(a.C0182a.sdk_activity_open_translate_from_right, a.C0182a.sdk_activity_close_translate_to_right);
        } else {
            overridePendingTransition(Util.getHostResourcesId(getActivity(), TbConfig.PACKAGE_NAME, "slide_in_from_bottom", ResUtils.ANIM), Util.getHostResourcesId(getActivity(), TbConfig.PACKAGE_NAME, "slide_out_to_bottom", ResUtils.ANIM));
        }
    }

    @Override // com.baidu.live.tbadk.core.BaseFragmentActivity
    public void enterExitAnimation() {
        bpf();
    }

    @Override // com.baidu.live.tbadk.core.BaseFragmentActivity
    public void closeAnimation() {
        bpf();
    }

    @Override // com.baidu.live.tbadk.core.BaseFragmentActivity
    protected void onChangeSkinType(int i) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.live.tbadk.core.BaseFragmentActivity, com.baidu.live.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.mHandler.removeCallbacksAndMessages(null);
        getWindow().getDecorView().getViewTreeObserver().removeGlobalOnLayoutListener(this.aHH);
        this.aHH = null;
    }
}
