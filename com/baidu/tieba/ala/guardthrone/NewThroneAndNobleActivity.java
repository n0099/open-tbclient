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
import com.baidu.live.utils.i;
import com.baidu.live.utils.q;
import com.baidu.tieba.ala.guardthrone.adapter.AlaThroneAndNobleControllerAdapter;
import com.baidu.tieba.ala.guardthrone.view.AlaThroneAndNobleTabHost;
/* loaded from: classes4.dex */
public class NewThroneAndNobleActivity extends BaseActivity implements View.OnTouchListener {
    private String aOt;
    private String brl;
    private AlaThroneAndNobleControllerAdapter gSA;
    private AlaThroneAndNobleTabHost gSy;
    private boolean mIsHost;
    private String mLiveId;
    private View mRootView;
    private int mScreenWidth;
    private int mTabId;
    private String gSz = "guard_throne";
    private Handler mHandler = new Handler();
    private boolean aWv = false;
    private boolean baH = false;
    private boolean baI = false;
    private final CustomMessageListener aWL = new CustomMessageListener(2913054) { // from class: com.baidu.tieba.ala.guardthrone.NewThroneAndNobleActivity.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            NewThroneAndNobleActivity.this.closeActivity();
        }
    };
    private final CustomMessageListener bJk = new CustomMessageListener(AlaCmdConfigCustom.CMD_ALA_IMAGE_FRAME_PLAYER_CONTROLLER) { // from class: com.baidu.tieba.ala.guardthrone.NewThroneAndNobleActivity.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            NewThroneAndNobleActivity.this.closeActivity();
        }
    };
    private ViewTreeObserver.OnGlobalLayoutListener baD = new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.tieba.ala.guardthrone.NewThroneAndNobleActivity.6
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
                                i.ae(NewThroneAndNobleActivity.this.mRootView);
                                q.e(NewThroneAndNobleActivity.this.getActivity(), false);
                            }
                        }
                    }, 300L);
                }
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.live.tbadk.BaseActivity, com.baidu.live.adp.base.BdBaseActivity, android.support.v4.app.FragmentActivity, android.support.v4.app.SupportActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        setIsAddSwipeBackLayout(false);
        setUseStyleImmersiveSticky(true);
        super.onCreate(bundle);
        if (bundle != null) {
            this.mLiveId = bundle.getString(AlaGuardThroneActivityConfig.GUARD_THRONE_LIVE_ID);
            this.brl = bundle.getString(AlaGuardThroneActivityConfig.GUARD_THRONE_ANCHOR_ID);
            this.aOt = bundle.getString(AlaGuardThroneActivityConfig.GUARD_THRONE_GIFT_ID);
            this.mTabId = bundle.getInt(AlaGuardThroneActivityConfig.GUARD_THRONE_TAB_ID, 1);
            this.mIsHost = bundle.getBoolean(AlaGuardThroneActivityConfig.GUARD_THRONE_IS_HOST, false);
            this.gSz = bundle.getString(AlaGuardThroneActivityConfig.DEFAULT_TAB_TYPE);
        } else {
            this.mLiveId = getIntent().getStringExtra(AlaGuardThroneActivityConfig.GUARD_THRONE_LIVE_ID);
            this.brl = getIntent().getStringExtra(AlaGuardThroneActivityConfig.GUARD_THRONE_ANCHOR_ID);
            this.aOt = getIntent().getStringExtra(AlaGuardThroneActivityConfig.GUARD_THRONE_GIFT_ID);
            this.mTabId = getIntent().getIntExtra(AlaGuardThroneActivityConfig.GUARD_THRONE_TAB_ID, 1);
            this.mIsHost = getIntent().getBooleanExtra(AlaGuardThroneActivityConfig.GUARD_THRONE_IS_HOST, false);
            this.gSz = getIntent().getStringExtra(AlaGuardThroneActivityConfig.DEFAULT_TAB_TYPE);
        }
        registerListener(this.bJk);
        registerListener(this.aWL);
        initView();
        ActivityPendingTransitionFactory.enterExitAnimation(getPageContext(), 0);
        this.baH = false;
        this.mRootView.setVisibility(4);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.live.tbadk.BaseActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        if (!this.aWv) {
            this.mRootView.setVisibility(0);
            Je();
            this.aWv = true;
        }
    }

    private void initTabSpec() {
        this.gSA = new AlaThroneAndNobleControllerAdapter(getPageContext(), this.mLiveId, this.brl, this.aOt, this.mTabId, this.mIsHost);
        this.gSy = (AlaThroneAndNobleTabHost) this.mRootView.findViewById(a.f.ala_throne_and_noble_list_tabhost);
        this.gSy.setAdapter(this.gSA);
        this.gSy.setPageSelectedListener(new AlaThroneAndNobleTabHost.b() { // from class: com.baidu.tieba.ala.guardthrone.NewThroneAndNobleActivity.1
            @Override // com.baidu.tieba.ala.guardthrone.view.AlaThroneAndNobleTabHost.b
            public void onPageSelected(int i) {
                NewThroneAndNobleActivity.this.gSA.uC(i);
            }
        });
    }

    private void Je() {
        Animation loadAnimation;
        this.baH = true;
        if (UtilHelper.getRealScreenOrientation(getActivity()) == 2) {
            loadAnimation = AnimationUtils.loadAnimation(getActivity(), a.C0205a.sdk_in_from_right);
        } else {
            loadAnimation = AnimationUtils.loadAnimation(getActivity(), a.C0205a.sdk_in_from_bottom);
        }
        loadAnimation.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.ala.guardthrone.NewThroneAndNobleActivity.2
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                NewThroneAndNobleActivity.this.baH = false;
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        });
        this.mRootView.startAnimation(loadAnimation);
    }

    private void Jf() {
        Animation loadAnimation;
        if (!this.baI && !this.baH) {
            if (UtilHelper.getRealScreenOrientation(getActivity()) == 2) {
                loadAnimation = AnimationUtils.loadAnimation(getActivity(), a.C0205a.sdk_out_to_right);
            } else {
                loadAnimation = AnimationUtils.loadAnimation(getActivity(), a.C0205a.sdk_out_to_bottom);
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
            this.baI = true;
            this.mRootView.startAnimation(loadAnimation);
        }
    }

    @Override // com.baidu.live.tbadk.BaseActivity, android.app.Activity
    public void finish() {
        Jf();
    }

    @Override // android.support.v4.app.FragmentActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        if (this.mRootView != null) {
            if (UtilHelper.getRealScreenOrientation(getActivity()) == 2) {
                i.ae(this.mRootView);
                q.e(getActivity(), false);
            } else {
                i.af(this.mRootView);
                q.e(getActivity(), true);
            }
            if (this.gSA != null) {
                this.gSA.onConfigurationChanged(configuration);
            }
            Wh();
            Wi();
        }
    }

    private void initView() {
        this.mRootView = LayoutInflater.from(getPageContext().getPageActivity()).inflate(a.g.ala_activity_throne_and_noble_layout, (ViewGroup) null);
        Wh();
        setContentView(this.mRootView);
        initTabSpec();
        if (UtilHelper.getRealScreenOrientation(getActivity()) == 2) {
            i.ae(this.mRootView);
            q.e(getActivity(), false);
        }
    }

    private void Wh() {
        if (UtilHelper.getRealScreenOrientation(getPageContext().getPageActivity()) == 2) {
            this.mRootView.setBackgroundResource(a.e.ala_new_throne_and_noble_land_bg);
        } else {
            this.mRootView.setBackgroundResource(a.e.ala_new_throne_and_noble_bg);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.support.v4.app.FragmentActivity, android.support.v4.app.SupportActivity, android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putString(AlaGuardThroneActivityConfig.GUARD_THRONE_LIVE_ID, this.mLiveId);
        bundle.putString(AlaGuardThroneActivityConfig.GUARD_THRONE_ANCHOR_ID, this.brl);
        bundle.putString(AlaGuardThroneActivityConfig.GUARD_THRONE_GIFT_ID, this.aOt);
        bundle.putInt(AlaGuardThroneActivityConfig.GUARD_THRONE_TAB_ID, this.mTabId);
        bundle.putBoolean(AlaGuardThroneActivityConfig.GUARD_THRONE_IS_HOST, this.mIsHost);
        bundle.putString(AlaGuardThroneActivityConfig.DEFAULT_TAB_TYPE, this.gSz);
    }

    @Override // com.baidu.live.tbadk.BaseActivity, android.app.Activity, android.view.Window.Callback
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        Wi();
    }

    private void Wi() {
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
            window.getDecorView().getViewTreeObserver().addOnGlobalLayoutListener(this.baD);
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
    @Override // com.baidu.live.tbadk.BaseActivity, com.baidu.live.adp.base.BdBaseActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.gSA != null) {
            this.gSA.onDestroy();
        }
        this.mHandler.removeCallbacksAndMessages(null);
        getWindow().getDecorView().getViewTreeObserver().removeGlobalOnLayoutListener(this.baD);
        this.baD = null;
    }
}
