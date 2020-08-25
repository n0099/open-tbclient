package com.baidu.tieba.ala.liveroom.challenge;

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
import com.baidu.ala.atomdata.AlaPersonCenterExpActivityConfig;
import com.baidu.ala.atomdata.AlaSDKShareEmptyActivityConfig;
import com.baidu.live.adp.framework.listener.CustomMessageListener;
import com.baidu.live.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.adp.lib.util.BdUtilHelper;
import com.baidu.live.bottompanel.AlaLiveRoomPanelTabHost;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.ActivityPendingTransitionFactory;
import com.baidu.live.tbadk.BaseActivity;
import com.baidu.live.tbadk.core.util.UtilHelper;
import com.baidu.live.utils.h;
import com.baidu.live.utils.q;
import com.baidu.tieba.ala.liveroom.challenge.adapter.AlaChallengeShowAllJinzhuPagerAdapter;
import java.util.Iterator;
/* loaded from: classes7.dex */
public class AlaChallengeShowAllJinzhuActivity extends BaseActivity implements View.OnTouchListener {
    private long bew;
    private long fuJ;
    private AlaLiveRoomPanelTabHost gpG;
    private AlaChallengeShowAllJinzhuPagerAdapter gpH;
    private long gpI;
    private boolean mIsHost;
    private View mRootView;
    private int mScreenWidth;
    private int mType;
    private Handler mHandler = new Handler();
    private boolean aND = false;
    private boolean aQY = false;
    private boolean aQZ = false;
    private final CustomMessageListener aNT = new CustomMessageListener(2913054) { // from class: com.baidu.tieba.ala.liveroom.challenge.AlaChallengeShowAllJinzhuActivity.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            AlaChallengeShowAllJinzhuActivity.this.closeActivity();
        }
    };
    private final CustomMessageListener fuM = new CustomMessageListener(AlaCmdConfigCustom.CMD_ALA_IMAGE_FRAME_PLAYER_CONTROLLER) { // from class: com.baidu.tieba.ala.liveroom.challenge.AlaChallengeShowAllJinzhuActivity.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            AlaChallengeShowAllJinzhuActivity.this.closeActivity();
        }
    };
    private ViewTreeObserver.OnGlobalLayoutListener aQU = new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.tieba.ala.liveroom.challenge.AlaChallengeShowAllJinzhuActivity.5
        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            int[] screenDimensions = BdUtilHelper.getScreenDimensions(AlaChallengeShowAllJinzhuActivity.this.getPageContext().getPageActivity());
            if (screenDimensions[0] > screenDimensions[1] && screenDimensions[0] != AlaChallengeShowAllJinzhuActivity.this.mScreenWidth) {
                AlaChallengeShowAllJinzhuActivity.this.mScreenWidth = screenDimensions[0];
                if (UtilHelper.canUseStyleImmersiveSticky()) {
                    AlaChallengeShowAllJinzhuActivity.this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.challenge.AlaChallengeShowAllJinzhuActivity.5.1
                        @Override // java.lang.Runnable
                        public void run() {
                            if (AlaChallengeShowAllJinzhuActivity.this.mRootView != null) {
                                h.Y(AlaChallengeShowAllJinzhuActivity.this.mRootView);
                                q.e(AlaChallengeShowAllJinzhuActivity.this.getActivity(), false);
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
        if (!isFinishing()) {
            initData(bundle);
            registerListener(this.fuM);
            registerListener(this.aNT);
            initView();
            ActivityPendingTransitionFactory.enterExitAnimation(getPageContext(), 0);
            this.aQY = false;
            this.mRootView.setVisibility(4);
            if (this.mType == 2 && this.gpH.getCount() > 1) {
                this.gpG.setCurrentIndex(1);
            } else {
                this.gpG.setCurrentIndex(0);
            }
        }
    }

    private void initData(Bundle bundle) {
        if (bundle != null) {
            this.gpI = bundle.getLong("challengeid");
            this.bew = bundle.getLong(AlaSDKShareEmptyActivityConfig.SHARE_ALA_SDK_LIVE_ID);
            this.fuJ = bundle.getLong("anchorid");
            this.mType = bundle.getInt("type", 1);
            this.mIsHost = bundle.getBoolean(AlaPersonCenterExpActivityConfig.IS_HOST);
            return;
        }
        this.gpI = getIntent().getLongExtra("challengeid", 0L);
        this.bew = getIntent().getLongExtra(AlaSDKShareEmptyActivityConfig.SHARE_ALA_SDK_LIVE_ID, 0L);
        this.fuJ = getIntent().getLongExtra("anchorid", 0L);
        this.mType = getIntent().getIntExtra("type", 1);
        this.mIsHost = getIntent().getBooleanExtra(AlaPersonCenterExpActivityConfig.IS_HOST, false);
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

    private void FD() {
        this.aQY = true;
        Animation loadAnimation = AnimationUtils.loadAnimation(getActivity(), a.C0185a.sdk_in_from_bottom);
        loadAnimation.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.ala.liveroom.challenge.AlaChallengeShowAllJinzhuActivity.1
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                AlaChallengeShowAllJinzhuActivity.this.aQY = false;
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        });
        this.mRootView.startAnimation(loadAnimation);
    }

    private void FE() {
        if (!this.aQZ && !this.aQY) {
            Animation loadAnimation = AnimationUtils.loadAnimation(getActivity(), a.C0185a.sdk_out_to_bottom);
            loadAnimation.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.ala.liveroom.challenge.AlaChallengeShowAllJinzhuActivity.2
                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationStart(Animation animation) {
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationEnd(Animation animation) {
                    AlaChallengeShowAllJinzhuActivity.super.finish();
                    ActivityPendingTransitionFactory.enterExitAnimation(AlaChallengeShowAllJinzhuActivity.this.getPageContext(), 0);
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
            bDu();
        }
    }

    private void initView() {
        this.mRootView = LayoutInflater.from(getPageContext().getPageActivity()).inflate(a.h.ala_jinzhu_tab_layout, (ViewGroup) null);
        setContentView(this.mRootView);
        initTabSpec();
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putLong("challengeid", this.gpI);
        bundle.putLong(AlaSDKShareEmptyActivityConfig.SHARE_ALA_SDK_LIVE_ID, this.bew);
        bundle.putLong("anchorid", this.fuJ);
        bundle.putInt("type", this.mType);
        bundle.putBoolean(AlaPersonCenterExpActivityConfig.IS_HOST, this.mIsHost);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.live.tbadk.BaseActivity
    public void closeActivity() {
        finish();
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
                attributes.height = screenDimensions[1] - BdUtilHelper.getStatusBarHeight(getPageContext().getPageActivity());
                attributes.gravity = 80;
                getWindowManager().updateViewLayout(decorView, attributes);
            }
            this.mScreenWidth = screenDimensions[0];
            window.setBackgroundDrawableResource(17170445);
            window.getDecorView().getViewTreeObserver().addOnGlobalLayoutListener(this.aQU);
            if (this.mRootView.getLayoutParams() instanceof FrameLayout.LayoutParams) {
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.mRootView.getLayoutParams();
                layoutParams.width = screenDimensions[0];
                layoutParams.height = (int) (screenDimensions[1] * 0.618d);
                layoutParams.gravity = 80;
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
        this.gpH = new AlaChallengeShowAllJinzhuPagerAdapter(getPageContext(), this.gpI, this.bew, this.fuJ, this.mIsHost);
        this.gpG = (AlaLiveRoomPanelTabHost) this.mRootView.findViewById(a.g.ala_jinzhu_tab_host);
        this.gpG.setIndicatorWidthAuto(true);
        this.gpG.setData(this.gpH.getDataList());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.live.tbadk.BaseActivity, com.baidu.live.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        Iterator<com.baidu.live.liveroom.d.d> it = this.gpH.getDataList().iterator();
        while (it.hasNext()) {
            it.next().onDestroy();
        }
        this.mHandler.removeCallbacksAndMessages(null);
        getWindow().getDecorView().getViewTreeObserver().removeGlobalOnLayoutListener(this.aQU);
        this.aQU = null;
    }
}
