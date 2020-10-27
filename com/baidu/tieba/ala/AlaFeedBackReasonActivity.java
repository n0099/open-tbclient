package com.baidu.tieba.ala;

import android.content.res.Configuration;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout;
import com.baidu.ala.AlaCmdConfigCustom;
import com.baidu.ala.atomdata.AlaAdminListActivityConfig;
import com.baidu.live.adp.framework.listener.CustomMessageListener;
import com.baidu.live.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.adp.lib.util.BdUtilHelper;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.ActivityPendingTransitionFactory;
import com.baidu.live.tbadk.BaseActivity;
import com.baidu.live.tbadk.core.util.UtilHelper;
import com.baidu.live.utils.i;
import com.baidu.live.utils.q;
/* loaded from: classes4.dex */
public class AlaFeedBackReasonActivity extends BaseActivity implements View.OnTouchListener {
    private long bmB;
    private boolean bzY;
    private long fSB;
    private com.baidu.tieba.ala.d.b fSE;
    private boolean mIsHost;
    private View mRootView;
    private int mScreenWidth;
    private long mUserId;
    private boolean aTK = false;
    private boolean aXJ = false;
    private boolean aXK = false;
    private final CustomMessageListener aUa = new CustomMessageListener(2913054) { // from class: com.baidu.tieba.ala.AlaFeedBackReasonActivity.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            AlaFeedBackReasonActivity.this.closeActivity();
        }
    };
    private final CustomMessageListener bzC = new CustomMessageListener(AlaCmdConfigCustom.CMD_ALA_IMAGE_FRAME_PLAYER_CONTROLLER) { // from class: com.baidu.tieba.ala.AlaFeedBackReasonActivity.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            AlaFeedBackReasonActivity.this.closeActivity();
        }
    };
    private ViewTreeObserver.OnGlobalLayoutListener aXF = new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.tieba.ala.AlaFeedBackReasonActivity.5
        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            int[] screenDimensions = BdUtilHelper.getScreenDimensions(AlaFeedBackReasonActivity.this.getPageContext().getPageActivity());
            if (screenDimensions[0] > screenDimensions[1] && screenDimensions[0] != AlaFeedBackReasonActivity.this.mScreenWidth) {
                AlaFeedBackReasonActivity.this.mScreenWidth = screenDimensions[0];
                if (UtilHelper.canUseStyleImmersiveSticky()) {
                    AlaFeedBackReasonActivity.this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.AlaFeedBackReasonActivity.5.1
                        @Override // java.lang.Runnable
                        public void run() {
                            if (AlaFeedBackReasonActivity.this.mRootView != null) {
                                i.aa(AlaFeedBackReasonActivity.this.mRootView);
                                q.e(AlaFeedBackReasonActivity.this.getActivity(), false);
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
            this.bmB = bundle.getLong(AlaAdminListActivityConfig.ALA_LIVE_CUR_LIVE_ID);
            this.fSB = bundle.getLong("ala_live_cur_anchor_id");
            this.mUserId = bundle.getLong("ala_live_cur_user_id");
            this.mIsHost = bundle.getBoolean("ala_live_cur_is_host", false);
            this.bzY = bundle.getBoolean("ala_live_cur_is_landscape");
        } else {
            this.bmB = getIntent().getLongExtra(AlaAdminListActivityConfig.ALA_LIVE_CUR_LIVE_ID, 0L);
            this.fSB = getIntent().getLongExtra("ala_live_cur_anchor_id", 0L);
            this.mUserId = getIntent().getLongExtra("ala_live_cur_user_id", 0L);
            this.mIsHost = getIntent().getBooleanExtra("ala_live_cur_is_host", false);
            this.bzY = getIntent().getBooleanExtra("ala_live_cur_is_landscape", false);
        }
        registerListener(this.bzC);
        registerListener(this.aUa);
        this.fSE = new com.baidu.tieba.ala.d.b(getPageContext(), this.bmB, this.fSB, this.mUserId, this.mIsHost, this.bzY);
        this.mRootView = this.fSE.getView();
        if (this.mRootView == null) {
            super.finish();
            return;
        }
        RI();
        setContentView(this.mRootView);
        if (UtilHelper.getRealScreenOrientation(getActivity()) == 2) {
            i.aa(this.mRootView);
            q.e(getActivity(), false);
        }
        ActivityPendingTransitionFactory.enterExitAnimation(getPageContext(), 0);
        this.aXJ = false;
        this.mRootView.setVisibility(4);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.live.tbadk.BaseActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        if (!this.aTK) {
            this.mRootView.setVisibility(0);
            Hv();
            this.aTK = true;
        }
    }

    private void Hv() {
        Animation loadAnimation;
        this.aXJ = true;
        if (UtilHelper.getRealScreenOrientation(getActivity()) == 2) {
            loadAnimation = AnimationUtils.loadAnimation(getActivity(), a.C0195a.sdk_in_from_right);
        } else {
            loadAnimation = AnimationUtils.loadAnimation(getActivity(), a.C0195a.sdk_in_from_bottom);
        }
        loadAnimation.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.ala.AlaFeedBackReasonActivity.1
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                AlaFeedBackReasonActivity.this.aXJ = false;
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        });
        this.mRootView.startAnimation(loadAnimation);
    }

    private void Hw() {
        Animation loadAnimation;
        if (!this.aXK && !this.aXJ) {
            if (UtilHelper.getRealScreenOrientation(getActivity()) == 2) {
                loadAnimation = AnimationUtils.loadAnimation(getActivity(), a.C0195a.sdk_out_to_right);
            } else {
                loadAnimation = AnimationUtils.loadAnimation(getActivity(), a.C0195a.sdk_out_to_bottom);
            }
            loadAnimation.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.ala.AlaFeedBackReasonActivity.2
                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationStart(Animation animation) {
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationEnd(Animation animation) {
                    AlaFeedBackReasonActivity.super.finish();
                    ActivityPendingTransitionFactory.enterExitAnimation(AlaFeedBackReasonActivity.this.getPageContext(), 0);
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationRepeat(Animation animation) {
                }
            });
            this.aXK = true;
            this.mRootView.startAnimation(loadAnimation);
        }
    }

    @Override // com.baidu.live.tbadk.BaseActivity, android.app.Activity
    public void finish() {
        if (!this.aXK) {
            this.fSE.onDestroy();
        }
        Hw();
    }

    @Override // android.support.v4.app.FragmentActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        if (this.mRootView != null) {
            if (UtilHelper.getRealScreenOrientation(getActivity()) == 2) {
                i.aa(this.mRootView);
                q.e(getActivity(), false);
            } else {
                i.ab(this.mRootView);
                q.e(getActivity(), true);
            }
            this.fSE.onConfigurationChanged(configuration);
            RI();
            RJ();
        }
    }

    private void RI() {
        if (UtilHelper.getRealScreenOrientation(getPageContext().getPageActivity()) == 2) {
            this.mRootView.setBackgroundResource(a.f.ala_choose_feedback_act_bg_land);
        } else {
            this.mRootView.setBackgroundResource(a.f.ala_choose_feedback_act_bg);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.support.v4.app.FragmentActivity, android.support.v4.app.SupportActivity, android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putLong(AlaAdminListActivityConfig.ALA_LIVE_CUR_LIVE_ID, this.bmB);
        bundle.putLong("ala_live_cur_anchor_id", this.fSB);
        bundle.putLong("ala_live_cur_user_id", this.mUserId);
        bundle.putBoolean("ala_live_cur_is_host", this.mIsHost);
        bundle.putBoolean("ala_live_cur_is_landscape", this.bzY);
    }

    @Override // com.baidu.live.tbadk.BaseActivity, android.app.Activity, android.view.Window.Callback
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        RJ();
    }

    private void RJ() {
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
            window.getDecorView().getViewTreeObserver().addOnGlobalLayoutListener(this.aXF);
            if (this.mRootView.getLayoutParams() instanceof FrameLayout.LayoutParams) {
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.mRootView.getLayoutParams();
                if (screenDimensions[1] > screenDimensions[0]) {
                    layoutParams.width = screenDimensions[0];
                    layoutParams.height = BdUtilHelper.dip2px(this, 300.0f);
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
        this.mHandler.removeCallbacksAndMessages(null);
        getWindow().getDecorView().getViewTreeObserver().removeGlobalOnLayoutListener(this.aXF);
        this.aXF = null;
    }
}
