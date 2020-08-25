package com.baidu.tieba.ala.guardthrone;

import android.content.res.Configuration;
import android.os.Bundle;
import android.os.Handler;
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
import com.baidu.ala.AlaCmdConfigCustom;
import com.baidu.live.adp.framework.listener.CustomMessageListener;
import com.baidu.live.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.adp.lib.util.BdUtilHelper;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.ActivityPendingTransitionFactory;
import com.baidu.live.tbadk.BaseActivity;
import com.baidu.live.tbadk.core.atomdata.AlaGuardThroneActivityConfig;
import com.baidu.live.tbadk.core.util.UtilHelper;
import com.baidu.live.utils.h;
import com.baidu.live.utils.q;
import com.baidu.tieba.ala.guardthrone.adapter.AlaThroneAndNobleControllerAdapter;
import com.baidu.tieba.ala.guardthrone.view.AlaThroneAndNobleTabHost;
/* loaded from: classes7.dex */
public class NewThroneAndNobleActivity extends BaseActivity implements View.OnTouchListener {
    private String aHi;
    private String ber;
    private AlaThroneAndNobleTabHost gei;
    private AlaThroneAndNobleControllerAdapter gek;
    private boolean mIsHost;
    private String mLiveId;
    private View mRootView;
    private int mScreenWidth;
    private int mTabId;
    private String gej = "guard_throne";
    private Handler mHandler = new Handler();
    private boolean aND = false;
    private boolean aQY = false;
    private boolean aQZ = false;
    private final CustomMessageListener aNT = new CustomMessageListener(2913054) { // from class: com.baidu.tieba.ala.guardthrone.NewThroneAndNobleActivity.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            NewThroneAndNobleActivity.this.closeActivity();
        }
    };
    private final CustomMessageListener fuM = new CustomMessageListener(AlaCmdConfigCustom.CMD_ALA_IMAGE_FRAME_PLAYER_CONTROLLER) { // from class: com.baidu.tieba.ala.guardthrone.NewThroneAndNobleActivity.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            NewThroneAndNobleActivity.this.closeActivity();
        }
    };
    private ViewTreeObserver.OnGlobalLayoutListener aQU = new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.tieba.ala.guardthrone.NewThroneAndNobleActivity.6
        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            int[] screenDimensions = BdUtilHelper.getScreenDimensions(NewThroneAndNobleActivity.this.getPageContext().getPageActivity());
            if (screenDimensions[0] > screenDimensions[1] && screenDimensions[0] != NewThroneAndNobleActivity.this.mScreenWidth) {
                NewThroneAndNobleActivity.this.mScreenWidth = screenDimensions[0];
                if (UtilHelper.canUseStyleImmersiveSticky()) {
                    NewThroneAndNobleActivity.this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.guardthrone.NewThroneAndNobleActivity.6.1
                        @Override // java.lang.Runnable
                        public void run() {
                            if (NewThroneAndNobleActivity.this.mRootView != null) {
                                h.Y(NewThroneAndNobleActivity.this.mRootView);
                                q.e(NewThroneAndNobleActivity.this.getActivity(), false);
                            }
                        }
                    }, 300L);
                }
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.live.tbadk.BaseActivity, com.baidu.live.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        setIsAddSwipeBackLayout(false);
        setUseStyleImmersiveSticky(true);
        super.onCreate(bundle);
        if (bundle != null) {
            this.mLiveId = bundle.getString(AlaGuardThroneActivityConfig.GUARD_THRONE_LIVE_ID);
            this.ber = bundle.getString(AlaGuardThroneActivityConfig.GUARD_THRONE_ANCHOR_ID);
            this.aHi = bundle.getString(AlaGuardThroneActivityConfig.GUARD_THRONE_GIFT_ID);
            this.mTabId = bundle.getInt(AlaGuardThroneActivityConfig.GUARD_THRONE_TAB_ID, 1);
            this.mIsHost = bundle.getBoolean(AlaGuardThroneActivityConfig.GUARD_THRONE_IS_HOST, false);
            this.gej = bundle.getString(AlaGuardThroneActivityConfig.DEFAULT_TAB_TYPE);
        } else {
            this.mLiveId = getIntent().getStringExtra(AlaGuardThroneActivityConfig.GUARD_THRONE_LIVE_ID);
            this.ber = getIntent().getStringExtra(AlaGuardThroneActivityConfig.GUARD_THRONE_ANCHOR_ID);
            this.aHi = getIntent().getStringExtra(AlaGuardThroneActivityConfig.GUARD_THRONE_GIFT_ID);
            this.mTabId = getIntent().getIntExtra(AlaGuardThroneActivityConfig.GUARD_THRONE_TAB_ID, 1);
            this.mIsHost = getIntent().getBooleanExtra(AlaGuardThroneActivityConfig.GUARD_THRONE_IS_HOST, false);
            this.gej = getIntent().getStringExtra(AlaGuardThroneActivityConfig.DEFAULT_TAB_TYPE);
        }
        registerListener(this.fuM);
        registerListener(this.aNT);
        initView();
        ActivityPendingTransitionFactory.enterExitAnimation(getPageContext(), 0);
        this.aQY = false;
        this.mRootView.setVisibility(4);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.live.tbadk.BaseActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        if (!this.aND) {
            this.mRootView.setVisibility(0);
            FD();
            this.aND = true;
        }
    }

    private void initTabSpec() {
        this.gek = new AlaThroneAndNobleControllerAdapter(getPageContext(), this.mLiveId, this.ber, this.aHi, this.mTabId, this.mIsHost);
        this.gei = (AlaThroneAndNobleTabHost) this.mRootView.findViewById(a.g.ala_throne_and_noble_list_tabhost);
        this.gei.setAdapter(this.gek);
        this.gei.setPageSelectedListener(new AlaThroneAndNobleTabHost.b() { // from class: com.baidu.tieba.ala.guardthrone.NewThroneAndNobleActivity.1
            @Override // com.baidu.tieba.ala.guardthrone.view.AlaThroneAndNobleTabHost.b
            public void onPageSelected(int i) {
                NewThroneAndNobleActivity.this.gek.sq(i);
            }
        });
    }

    private void FD() {
        Animation loadAnimation;
        this.aQY = true;
        if (UtilHelper.getRealScreenOrientation(getActivity()) == 2) {
            loadAnimation = AnimationUtils.loadAnimation(getActivity(), a.C0185a.sdk_in_from_right);
        } else {
            loadAnimation = AnimationUtils.loadAnimation(getActivity(), a.C0185a.sdk_in_from_bottom);
        }
        loadAnimation.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.ala.guardthrone.NewThroneAndNobleActivity.2
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                NewThroneAndNobleActivity.this.aQY = false;
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        });
        this.mRootView.startAnimation(loadAnimation);
    }

    private void FE() {
        Animation loadAnimation;
        if (!this.aQZ && !this.aQY) {
            if (UtilHelper.getRealScreenOrientation(getActivity()) == 2) {
                loadAnimation = AnimationUtils.loadAnimation(getActivity(), a.C0185a.sdk_out_to_right);
            } else {
                loadAnimation = AnimationUtils.loadAnimation(getActivity(), a.C0185a.sdk_out_to_bottom);
            }
            loadAnimation.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.ala.guardthrone.NewThroneAndNobleActivity.3
                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationStart(Animation animation) {
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationEnd(Animation animation) {
                    NewThroneAndNobleActivity.super.finish();
                    ActivityPendingTransitionFactory.enterExitAnimation(NewThroneAndNobleActivity.this.getPageContext(), 0);
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationRepeat(Animation animation) {
                }
            });
            this.aQZ = true;
            this.mRootView.startAnimation(loadAnimation);
        }
    }

    @Override // com.baidu.live.tbadk.BaseActivity, android.app.Activity
    public void finish() {
        FE();
    }

    @Override // android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        if (this.mRootView != null) {
            if (UtilHelper.getRealScreenOrientation(getActivity()) == 2) {
                h.Y(this.mRootView);
                q.e(getActivity(), false);
            } else {
                h.Z(this.mRootView);
                q.e(getActivity(), true);
            }
            if (this.gek != null) {
                this.gek.onConfigurationChanged(configuration);
            }
            bDv();
            bDu();
        }
    }

    private void initView() {
        this.mRootView = LayoutInflater.from(getPageContext().getPageActivity()).inflate(a.h.ala_activity_throne_and_noble_layout, (ViewGroup) null);
        bDv();
        setContentView(this.mRootView);
        initTabSpec();
        if (UtilHelper.getRealScreenOrientation(getActivity()) == 2) {
            h.Y(this.mRootView);
            q.e(getActivity(), false);
        }
    }

    private void bDv() {
        if (UtilHelper.getRealScreenOrientation(getPageContext().getPageActivity()) == 2) {
            this.mRootView.setBackgroundResource(a.f.ala_new_throne_and_noble_land_bg);
        } else {
            this.mRootView.setBackgroundResource(a.f.ala_new_throne_and_noble_bg);
        }
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putString(AlaGuardThroneActivityConfig.GUARD_THRONE_LIVE_ID, this.mLiveId);
        bundle.putString(AlaGuardThroneActivityConfig.GUARD_THRONE_ANCHOR_ID, this.ber);
        bundle.putString(AlaGuardThroneActivityConfig.GUARD_THRONE_GIFT_ID, this.aHi);
        bundle.putInt(AlaGuardThroneActivityConfig.GUARD_THRONE_TAB_ID, this.mTabId);
        bundle.putBoolean(AlaGuardThroneActivityConfig.GUARD_THRONE_IS_HOST, this.mIsHost);
        bundle.putString(AlaGuardThroneActivityConfig.DEFAULT_TAB_TYPE, this.gej);
    }

    @Override // com.baidu.live.tbadk.BaseActivity, android.app.Activity, android.view.Window.Callback
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        bDu();
    }

    private void bDu() {
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
            window.getDecorView().getViewTreeObserver().addOnGlobalLayoutListener(this.aQU);
            if (this.mRootView.getLayoutParams() instanceof FrameLayout.LayoutParams) {
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.mRootView.getLayoutParams();
                if (screenDimensions[1] > screenDimensions[0]) {
                    layoutParams.width = screenDimensions[0];
                    layoutParams.height = BdUtilHelper.dip2px(this, 427.0f);
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

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.live.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.live.tbadk.BaseActivity, com.baidu.live.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.gek != null) {
            this.gek.onDestroy();
        }
        this.mHandler.removeCallbacksAndMessages(null);
        getWindow().getDecorView().getViewTreeObserver().removeGlobalOnLayoutListener(this.aQU);
        this.aQU = null;
    }
}
