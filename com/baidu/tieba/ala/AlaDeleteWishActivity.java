package com.baidu.tieba.ala;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.FrameLayout;
import com.baidu.ala.AlaCmdConfigCustom;
import com.baidu.live.adp.framework.listener.CustomMessageListener;
import com.baidu.live.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.adp.lib.util.BdUtilHelper;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.ActivityPendingTransitionFactory;
import com.baidu.live.tbadk.core.BaseFragmentActivity;
import com.baidu.live.tbadk.core.util.UtilHelper;
import com.baidu.live.utils.r;
import com.baidu.tieba.ala.data.m;
import com.baidu.tieba.ala.g.i;
/* loaded from: classes10.dex */
public class AlaDeleteWishActivity extends BaseFragmentActivity implements i.a {
    private Button gqA;
    private Button gqB;
    private com.baidu.tieba.ala.g.i gqC;
    private String gqD;
    private long gqE;
    private Context mContext;
    private View mRootView;
    private int mScreenWidth;
    private Handler mHandler = new Handler();
    private boolean aXT = false;
    private boolean bch = false;
    private boolean bci = false;
    private CustomMessageListener aYj = new CustomMessageListener(2913054) { // from class: com.baidu.tieba.ala.AlaDeleteWishActivity.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            AlaDeleteWishActivity.this.closeActivity();
        }
    };
    CustomMessageListener aYk = new CustomMessageListener(AlaCmdConfigCustom.CMD_ALA_IMAGE_FRAME_PLAYER_CONTROLLER) { // from class: com.baidu.tieba.ala.AlaDeleteWishActivity.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            AlaDeleteWishActivity.this.closeActivity();
        }
    };
    private ViewTreeObserver.OnGlobalLayoutListener bcd = new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.tieba.ala.AlaDeleteWishActivity.7
        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            int[] screenDimensions = BdUtilHelper.getScreenDimensions(AlaDeleteWishActivity.this.getPageContext().getPageActivity());
            if (screenDimensions[0] > screenDimensions[1] && screenDimensions[0] != AlaDeleteWishActivity.this.mScreenWidth) {
                AlaDeleteWishActivity.this.mScreenWidth = screenDimensions[0];
                if (UtilHelper.canUseStyleImmersiveSticky()) {
                    AlaDeleteWishActivity.this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.AlaDeleteWishActivity.7.1
                        @Override // java.lang.Runnable
                        public void run() {
                            if (AlaDeleteWishActivity.this.mRootView != null) {
                                com.baidu.live.utils.i.ae(AlaDeleteWishActivity.this.mRootView);
                                r.e(AlaDeleteWishActivity.this.getActivity(), false);
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
            this.mContext = this;
            registerListener(this.aYk);
            registerListener(this.aYj);
            initView();
            ActivityPendingTransitionFactory.enterExitAnimation(getPageContext(), 0);
            this.bch = false;
            this.mRootView.setVisibility(4);
            this.gqC = new com.baidu.tieba.ala.g.i(getPageContext(), null, this, null);
            this.gqD = getIntent().getStringExtra("wish_id");
            this.gqE = getIntent().getLongExtra("index_id", 0L);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        if (!this.aXT) {
            this.mRootView.setVisibility(0);
            Ge();
            this.aXT = true;
        }
    }

    private void Ge() {
        Animation loadAnimation;
        this.bch = true;
        if (UtilHelper.getRealScreenOrientation(getActivity()) == 2) {
            loadAnimation = AnimationUtils.loadAnimation(getActivity(), a.C0201a.sdk_in_from_right);
        } else {
            loadAnimation = AnimationUtils.loadAnimation(getActivity(), a.C0201a.sdk_in_from_bottom);
        }
        loadAnimation.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.ala.AlaDeleteWishActivity.1
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                AlaDeleteWishActivity.this.bch = false;
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        });
        this.mRootView.startAnimation(loadAnimation);
    }

    private void Gf() {
        Animation loadAnimation;
        if (!this.bci && !this.bch) {
            if (UtilHelper.getRealScreenOrientation(getActivity()) == 2) {
                loadAnimation = AnimationUtils.loadAnimation(getActivity(), a.C0201a.sdk_out_to_right);
            } else {
                loadAnimation = AnimationUtils.loadAnimation(getActivity(), a.C0201a.sdk_out_to_bottom);
            }
            loadAnimation.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.ala.AlaDeleteWishActivity.2
                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationStart(Animation animation) {
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationEnd(Animation animation) {
                    AlaDeleteWishActivity.super.finish();
                    ActivityPendingTransitionFactory.enterExitAnimation(AlaDeleteWishActivity.this.getPageContext(), 0);
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationRepeat(Animation animation) {
                }
            });
            this.bci = true;
            this.mRootView.startAnimation(loadAnimation);
        }
    }

    @Override // com.baidu.live.tbadk.core.BaseFragmentActivity, android.app.Activity
    public void finish() {
        Gf();
    }

    private void initView() {
        this.mRootView = LayoutInflater.from(getPageContext().getPageActivity()).inflate(a.g.ala_wish_list_delete_item_layout, (ViewGroup) null);
        setContentView(this.mRootView);
        this.gqA = (Button) this.mRootView.findViewById(a.f.ala_wish_list_delete_item_ok);
        this.gqB = (Button) this.mRootView.findViewById(a.f.ala_wish_list_delete_item_cancle);
        this.gqA.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.AlaDeleteWishActivity.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                AlaDeleteWishActivity.this.gqC.Ip(AlaDeleteWishActivity.this.gqD);
            }
        });
        this.gqB.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.AlaDeleteWishActivity.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                AlaDeleteWishActivity.this.finish();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void closeActivity() {
        finish();
    }

    @Override // com.baidu.live.tbadk.core.BaseFragmentActivity, android.app.Activity, android.view.Window.Callback
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        Vc();
    }

    private void Vc() {
        Window window = getWindow();
        if (window != null) {
            int[] screenDimensions = BdUtilHelper.getScreenDimensions(getPageContext().getPageActivity());
            View decorView = window.getDecorView();
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
            window.getDecorView().getViewTreeObserver().addOnGlobalLayoutListener(this.bcd);
            if (this.mRootView.getLayoutParams() instanceof FrameLayout.LayoutParams) {
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.mRootView.getLayoutParams();
                if (screenDimensions[1] > screenDimensions[0]) {
                    layoutParams.width = screenDimensions[0];
                    layoutParams.height = (int) (screenDimensions[1] * 0.18d);
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

    @Override // com.baidu.live.tbadk.core.BaseFragmentActivity
    protected void onChangeSkinType(int i) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.live.tbadk.core.BaseFragmentActivity, com.baidu.live.adp.base.BdBaseFragmentActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        if (this.gqC != null) {
            this.gqC.cml();
        }
        super.onDestroy();
        this.mHandler.removeCallbacksAndMessages(null);
        getWindow().getDecorView().getViewTreeObserver().removeGlobalOnLayoutListener(this.bcd);
        this.bcd = null;
    }

    @Override // com.baidu.tieba.ala.g.i.a
    public void a(m mVar) {
        Intent intent = new Intent();
        intent.putExtra("index_id", this.gqE);
        setResult(-1, intent);
        finish();
    }

    @Override // com.baidu.tieba.ala.g.i.a
    public void aS(int i, String str) {
        if (TextUtils.isEmpty(str)) {
            str = "删除心愿失败";
        }
        getPageContext().showToast(str);
    }
}
