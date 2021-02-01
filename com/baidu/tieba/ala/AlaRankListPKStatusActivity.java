package com.baidu.tieba.ala;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
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
import androidx.fragment.app.Fragment;
import com.baidu.ala.AlaCmdConfigCustom;
import com.baidu.fsg.base.utils.ResUtils;
import com.baidu.live.adp.framework.listener.CustomMessageListener;
import com.baidu.live.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.adp.lib.util.BdUtilHelper;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.TbConfig;
import com.baidu.live.tbadk.core.BaseFragmentActivity;
import com.baidu.live.tbadk.core.tabhost.FragmentTabHost;
import com.baidu.live.tbadk.core.tabhost.FragmentTabWidget;
import com.baidu.live.tbadk.core.util.TbEnum;
import com.baidu.live.tbadk.core.util.UtilHelper;
import com.baidu.live.tbadk.maintab.FragmentTabIndicator;
import com.baidu.live.tbadk.ubc.UbcStatConstant;
import com.baidu.megapp.ma.Util;
import com.baidu.tieba.ala.adapter.AlaRankListPKStatusFragmentAdapter;
/* loaded from: classes11.dex */
public class AlaRankListPKStatusActivity extends BaseFragmentActivity implements View.OnTouchListener {
    private int aKa;
    private String gpD;
    private boolean gpE;
    private FragmentTabHost gpL;
    private AlaRankListPKStatusFragmentAdapter gpM;
    private String mPortrait;
    private View mRootView;
    private int mScreenWidth;
    private long mUserId;
    private Handler mHandler = new Handler();
    CustomMessageListener aWK = new CustomMessageListener(AlaCmdConfigCustom.CMD_ALA_IMAGE_FRAME_PLAYER_CONTROLLER) { // from class: com.baidu.tieba.ala.AlaRankListPKStatusActivity.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            AlaRankListPKStatusActivity.this.closeActivity();
        }
    };
    private ViewTreeObserver.OnGlobalLayoutListener baD = new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.tieba.ala.AlaRankListPKStatusActivity.3
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
                                com.baidu.live.utils.i.ae(AlaRankListPKStatusActivity.this.mRootView);
                            }
                        }
                    }, 300L);
                }
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.live.tbadk.core.BaseFragmentActivity, com.baidu.live.adp.base.BdBaseFragmentActivity, androidx.fragment.app.FragmentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        setIsAddSwipeBackLayout(false);
        setUseStyleImmersiveSticky(true);
        super.onCreate(bundle);
        if (!isFinishing()) {
            if (bundle != null) {
                this.aKa = bundle.getInt(UbcStatConstant.KEY_LIVE_TYPE, 1);
                this.mUserId = bundle.getLong(TbEnum.SystemMessage.KEY_USER_ID, 0L);
                this.gpD = bundle.getString("rank_list_type", "");
                this.gpE = bundle.getBoolean("rank_list_from");
                this.mPortrait = bundle.getString("portrait");
            } else {
                this.aKa = getIntent().getIntExtra(UbcStatConstant.KEY_LIVE_TYPE, 1);
                this.mUserId = getIntent().getLongExtra(TbEnum.SystemMessage.KEY_USER_ID, 0L);
                this.gpD = getIntent().getStringExtra("rank_list_type");
                this.gpE = getIntent().getBooleanExtra("rank_list_from", false);
                this.mPortrait = getIntent().getStringExtra("portrait");
            }
            registerListener(this.aWK);
            initView();
        }
    }

    private void initView() {
        this.mRootView = LayoutInflater.from(getPageContext().getPageActivity()).inflate(a.g.ala_pk_status_layout, (ViewGroup) null);
        setContentView(this.mRootView);
        ImageView imageView = (ImageView) this.mRootView.findViewById(a.f.ala_rank_list_back);
        imageView.setVisibility(0);
        imageView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.AlaRankListPKStatusActivity.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                AlaRankListPKStatusActivity.this.finish();
            }
        });
        ((TextView) this.mRootView.findViewById(a.f.ala_rank_list_title)).setText(a.h.ala_rank_list_pk_status_panel_title);
        bOs();
        initTabSpec();
        if (UtilHelper.canUseStyleImmersiveSticky() && UtilHelper.getRealScreenOrientation(getActivity()) == 2) {
            com.baidu.live.utils.i.ae(this.mRootView);
        }
    }

    private void bOs() {
        this.gpL = (FragmentTabHost) findViewById(a.f.ala_rank_list_tabhost);
        this.gpL.setup(getSupportFragmentManager());
        this.gpL.setTabWidgetViewHeight((int) getResources().getDimension(a.d.sdk_ds80));
        this.gpL.getFragmentTabWidget().setAbsoluteWeight(true);
        this.gpL.getFragmentTabWidget().setDiverColor(getResources().getColor(a.c.sdk_cp_cont_b));
        this.gpL.getFragmentTabWidget().setDviderRectWidth(-2);
        this.gpL.getFragmentTabWidget().setDviderRectHeight(BdUtilHelper.getDimens(getPageContext().getPageActivity(), a.d.sdk_ds4));
    }

    private void initTabSpec() {
        this.gpM = new AlaRankListPKStatusFragmentAdapter(this, this.aKa, this.mUserId, this.gpE, this.mPortrait);
        int Fr = this.gpM.Fr(this.gpD);
        int count = this.gpM.getCount();
        for (int i = 0; i < count; i++) {
            Fragment item = this.gpM.getItem(i);
            if (item != null) {
                a(item, this.gpM.tp(i));
            }
        }
        FragmentTabWidget fragmentTabWidget = this.gpL.getFragmentTabWidget();
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) fragmentTabWidget.getLayoutParams();
        layoutParams.gravity = 1;
        layoutParams.width = -1;
        layoutParams.leftMargin = (int) getResources().getDimension(a.d.sdk_ds34);
        layoutParams.rightMargin = (int) getResources().getDimension(a.d.sdk_ds34);
        fragmentTabWidget.setLayoutParams(layoutParams);
        this.gpL.initViewPagerWithNoType();
        this.gpL.setCurrentTab(Fr);
    }

    private void a(Fragment fragment, String str) {
        if (fragment != null) {
            FragmentTabHost.TabSpec tabSpec = new FragmentTabHost.TabSpec();
            FragmentTabIndicator fragmentTabIndicator = new FragmentTabIndicator(getPageContext().getContext());
            tabSpec.mContentFragment = fragment;
            fragmentTabIndicator.setText(str);
            fragmentTabIndicator.setTextColorResId(a.c.ala_rank_list_tab_text_color);
            fragmentTabIndicator.setTextSize(0, getResources().getDimension(a.d.sdk_fontsize32));
            tabSpec.mIndicatorView = fragmentTabIndicator;
            this.gpL.addTabSpec(tabSpec);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.fragment.app.FragmentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putLong(TbEnum.SystemMessage.KEY_USER_ID, this.mUserId);
        bundle.putInt(UbcStatConstant.KEY_LIVE_TYPE, this.aKa);
        bundle.putString("rank_list_type", this.gpD);
        bundle.putBoolean("rank_list_from", this.gpE);
        bundle.putString("portrait", this.mPortrait);
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
            window.getDecorView().getViewTreeObserver().addOnGlobalLayoutListener(this.baD);
            if (this.mRootView.getLayoutParams() instanceof FrameLayout.LayoutParams) {
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.mRootView.getLayoutParams();
                if (screenDimensions[1] > screenDimensions[0]) {
                    layoutParams.width = screenDimensions[0];
                    layoutParams.height = (int) (screenDimensions[1] * 0.618d);
                    layoutParams.gravity = 80;
                } else {
                    layoutParams.width = (int) getResources().getDimension(a.d.sdk_ds720);
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

    private void bOt() {
        if (this instanceof Activity) {
            overridePendingTransition(a.C0195a.sdk_activity_open_translate_from_right, a.C0195a.sdk_activity_close_translate_to_right);
        } else {
            overridePendingTransition(Util.getHostResourcesId(getActivity(), TbConfig.PACKAGE_NAME, "slide_in_from_bottom", ResUtils.ANIM), Util.getHostResourcesId(getActivity(), TbConfig.PACKAGE_NAME, "slide_out_to_bottom", ResUtils.ANIM));
        }
    }

    @Override // com.baidu.live.tbadk.core.BaseFragmentActivity
    public void enterExitAnimation() {
        bOt();
    }

    @Override // com.baidu.live.tbadk.core.BaseFragmentActivity
    public void closeAnimation() {
        bOt();
    }

    @Override // com.baidu.live.tbadk.core.BaseFragmentActivity
    protected void onChangeSkinType(int i) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.live.tbadk.core.BaseFragmentActivity, com.baidu.live.adp.base.BdBaseFragmentActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.mHandler.removeCallbacksAndMessages(null);
        getWindow().getDecorView().getViewTreeObserver().removeGlobalOnLayoutListener(this.baD);
        this.baD = null;
    }
}
