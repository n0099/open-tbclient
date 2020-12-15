package com.baidu.tieba.ala.charm;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.Handler;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout;
import com.baidu.ala.AlaCmdConfigCustom;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.listener.CustomMessageListener;
import com.baidu.live.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.adp.framework.message.Message;
import com.baidu.live.adp.lib.util.BdUtilHelper;
import com.baidu.live.adp.lib.util.StringUtils;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.ActivityPendingTransitionFactory;
import com.baidu.live.tbadk.BaseActivity;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.core.util.UtilHelper;
import com.baidu.live.tbadk.coreextra.message.UpdateAttentionMessage;
import com.baidu.live.utils.i;
import com.baidu.live.utils.q;
/* loaded from: classes4.dex */
public class ALaCharmCardActivity extends BaseActivity<ALaCharmCardActivity> implements View.OnTouchListener {
    private com.baidu.tieba.ala.charm.view.c gDs;
    private View mRootView;
    private int mScreenWidth;
    private Handler mHandler = new Handler();
    private boolean aWv = false;
    private boolean baH = false;
    private boolean baI = false;
    private CustomMessageListener gDt = new CustomMessageListener(2913062) { // from class: com.baidu.tieba.ala.charm.ALaCharmCardActivity.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (TbadkCoreApplication.getInst().isHaokan()) {
                ALaCharmCardActivity.this.finish();
            }
        }
    };
    private ViewTreeObserver.OnGlobalLayoutListener baD = new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.tieba.ala.charm.ALaCharmCardActivity.4
        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            int[] screenDimensions = BdUtilHelper.getScreenDimensions(ALaCharmCardActivity.this.getPageContext().getPageActivity());
            if (screenDimensions[0] > screenDimensions[1] && screenDimensions[0] != ALaCharmCardActivity.this.mScreenWidth) {
                ALaCharmCardActivity.this.mScreenWidth = screenDimensions[0];
                if (UtilHelper.canUseStyleImmersiveSticky()) {
                    ALaCharmCardActivity.this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.charm.ALaCharmCardActivity.4.1
                        @Override // java.lang.Runnable
                        public void run() {
                            i.ae(ALaCharmCardActivity.this.gDs.getView());
                        }
                    }, 300L);
                }
            }
        }
    };
    CustomMessageListener aWM = new CustomMessageListener(AlaCmdConfigCustom.CMD_ALA_IMAGE_FRAME_PLAYER_CONTROLLER) { // from class: com.baidu.tieba.ala.charm.ALaCharmCardActivity.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            ALaCharmCardActivity.this.closeActivity();
        }
    };
    private CustomMessageListener gDu = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_ATTENTION) { // from class: com.baidu.tieba.ala.charm.ALaCharmCardActivity.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            UpdateAttentionMessage updateAttentionMessage;
            if ((customResponsedMessage instanceof UpdateAttentionMessage) && (updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage) != null && updateAttentionMessage.getData() != null && !StringUtils.isNull(updateAttentionMessage.getData().toUid)) {
                if (updateAttentionMessage.getData().isSucc) {
                    if (ALaCharmCardActivity.this.gDs != null) {
                        ALaCharmCardActivity.this.gDs.aA(updateAttentionMessage.getData().toUid, updateAttentionMessage.getData().isAttention);
                    }
                    Message<?> message = updateAttentionMessage.getmOrginalMessage();
                    if (message != null && message.getTag() != null && message.getTag().equals(ALaCharmCardActivity.this.getUniqueId())) {
                        if (updateAttentionMessage.getData().isAttention) {
                            ALaCharmCardActivity.this.getPageContext().showToast(ALaCharmCardActivity.this.getResources().getString(a.h.sdk_attention_success_toast));
                            return;
                        } else {
                            ALaCharmCardActivity.this.getPageContext().showToast(ALaCharmCardActivity.this.getResources().getString(a.h.sdk_unfollow_success_toast));
                            return;
                        }
                    }
                    return;
                }
                if (ALaCharmCardActivity.this.gDs != null) {
                    ALaCharmCardActivity.this.gDs.aA(updateAttentionMessage.getData().toUid, !updateAttentionMessage.getData().isAttention);
                }
                Message<?> message2 = updateAttentionMessage.getmOrginalMessage();
                if (message2 != null && message2.getTag() != null && message2.getTag().equals(ALaCharmCardActivity.this.getUniqueId())) {
                    ALaCharmCardActivity.this.getPageContext().showToast(updateAttentionMessage.getData().errorString);
                }
            }
        }
    };
    CustomMessageListener gDv = new CustomMessageListener(2913096) { // from class: com.baidu.tieba.ala.charm.ALaCharmCardActivity.7
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof Long)) {
                Long l = (Long) customResponsedMessage.getData();
                if (ALaCharmCardActivity.this.gDs != null) {
                    ALaCharmCardActivity.this.gDs.eZ(l.longValue());
                }
            }
        }
    };
    private CustomMessageListener aWL = new CustomMessageListener(2913054) { // from class: com.baidu.tieba.ala.charm.ALaCharmCardActivity.8
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            ALaCharmCardActivity.this.closeActivity();
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.live.tbadk.BaseActivity, com.baidu.live.adp.base.BdBaseActivity, android.support.v4.app.FragmentActivity, android.support.v4.app.SupportActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        setUseStyleImmersiveSticky(true);
        setIsAddSwipeBackLayout(false);
        super.onCreate(bundle);
        if (!isFinishing()) {
            this.gDs = new com.baidu.tieba.ala.charm.view.c(this);
            this.mRootView = this.gDs.getView();
            setContentView(this.mRootView);
            registerListener(this.aWL);
            registerListener(this.aWM);
            registerListener(this.gDu);
            registerListener(this.gDt);
            ActivityPendingTransitionFactory.enterExitAnimation(getPageContext(), 0);
            this.baH = false;
            this.mRootView.setVisibility(4);
            if (UtilHelper.getRealScreenOrientation(getActivity()) == 2) {
                i.ae(this.gDs.getView());
                q.e(getActivity(), false);
            }
        }
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

    private void Je() {
        Animation loadAnimation;
        this.baH = true;
        if (UtilHelper.getRealScreenOrientation(getActivity()) == 2) {
            loadAnimation = AnimationUtils.loadAnimation(getActivity(), a.C0205a.sdk_in_from_right);
        } else {
            loadAnimation = AnimationUtils.loadAnimation(getActivity(), a.C0205a.sdk_in_from_bottom);
        }
        loadAnimation.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.ala.charm.ALaCharmCardActivity.2
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                ALaCharmCardActivity.this.baH = false;
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
            loadAnimation.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.ala.charm.ALaCharmCardActivity.3
                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationStart(Animation animation) {
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationEnd(Animation animation) {
                    ALaCharmCardActivity.super.finish();
                    ActivityPendingTransitionFactory.enterExitAnimation(ALaCharmCardActivity.this.getPageContext(), 0);
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
        if (this.gDs != null) {
            if (UtilHelper.getRealScreenOrientation(getActivity()) == 2) {
                i.ae(this.gDs.getView());
                q.e(getActivity(), false);
            } else {
                i.af(this.gDs.getView());
                q.e(getActivity(), true);
            }
            this.gDs.HO();
            Wi();
        }
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
            if (!UtilHelper.canUseStyleImmersiveSticky() && screenDimensions[1] > screenDimensions[0]) {
                WindowManager.LayoutParams attributes = window.getAttributes();
                attributes.height = screenDimensions[1] - BdUtilHelper.getStatusBarHeight(getPageContext().getPageActivity());
                attributes.gravity = 80;
                getWindowManager().updateViewLayout(decorView, attributes);
            }
            this.mScreenWidth = screenDimensions[0];
            window.setBackgroundDrawableResource(17170445);
            window.getDecorView().getViewTreeObserver().addOnGlobalLayoutListener(this.baD);
            if (this.gDs.getView().getLayoutParams() instanceof FrameLayout.LayoutParams) {
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.gDs.getView().getLayoutParams();
                if (screenDimensions[1] > screenDimensions[0]) {
                    layoutParams.width = screenDimensions[0];
                    layoutParams.height = (int) (screenDimensions[1] * 0.618d);
                    layoutParams.gravity = 80;
                } else {
                    layoutParams.width = screenDimensions[1];
                    layoutParams.height = screenDimensions[1];
                    layoutParams.gravity = 53;
                }
                this.gDs.getView().setLayoutParams(layoutParams);
            }
        }
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        boolean z = false;
        if (motionEvent.getAction() == 0) {
            z = true;
            if (view.getId() != a.f.ala_charm_detail_id) {
                finish();
            }
        }
        return z;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.live.tbadk.BaseActivity, com.baidu.live.adp.base.BdBaseActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.gDs.onDestory();
        this.mHandler.removeCallbacksAndMessages(null);
        getWindow().getDecorView().getViewTreeObserver().removeGlobalOnLayoutListener(this.baD);
        MessageManager.getInstance().unRegisterListener(this.gDt);
        this.baD = null;
    }

    public void bUf() {
        Intent intent = new Intent();
        intent.putExtra("need_show_gift_panel", true);
        setResult(-1, intent);
        finish();
    }
}
