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
import com.baidu.live.utils.i;
import com.baidu.live.utils.q;
import com.baidu.tieba.ala.liveroom.challenge.adapter.AlaChallengeShowAllJinzhuPagerAdapter;
import java.util.Iterator;
/* loaded from: classes4.dex */
public class AlaChallengeShowAllJinzhuActivity extends BaseActivity implements View.OnTouchListener {
    private long bmB;
    private long fSB;
    private AlaLiveRoomPanelTabHost gTi;
    private AlaChallengeShowAllJinzhuPagerAdapter gTj;
    private long gTk;
    private boolean mIsHost;
    private View mRootView;
    private int mScreenWidth;
    private int mType;
    private Handler mHandler = new Handler();
    private boolean aTK = false;
    private boolean aXJ = false;
    private boolean aXK = false;
    private final CustomMessageListener aUa = new CustomMessageListener(2913054) { // from class: com.baidu.tieba.ala.liveroom.challenge.AlaChallengeShowAllJinzhuActivity.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            AlaChallengeShowAllJinzhuActivity.this.closeActivity();
        }
    };
    private final CustomMessageListener bzC = new CustomMessageListener(AlaCmdConfigCustom.CMD_ALA_IMAGE_FRAME_PLAYER_CONTROLLER) { // from class: com.baidu.tieba.ala.liveroom.challenge.AlaChallengeShowAllJinzhuActivity.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            AlaChallengeShowAllJinzhuActivity.this.closeActivity();
        }
    };
    private ViewTreeObserver.OnGlobalLayoutListener aXF = new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.tieba.ala.liveroom.challenge.AlaChallengeShowAllJinzhuActivity.5
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
                                i.aa(AlaChallengeShowAllJinzhuActivity.this.mRootView);
                                q.e(AlaChallengeShowAllJinzhuActivity.this.getActivity(), false);
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
        if (!isFinishing()) {
            initData(bundle);
            registerListener(this.bzC);
            registerListener(this.aUa);
            initView();
            ActivityPendingTransitionFactory.enterExitAnimation(getPageContext(), 0);
            this.aXJ = false;
            this.mRootView.setVisibility(4);
            if (this.mType == 2 && this.gTj.getCount() > 1) {
                this.gTi.setCurrentIndex(1);
            } else {
                this.gTi.setCurrentIndex(0);
            }
        }
    }

    private void initData(Bundle bundle) {
        if (bundle != null) {
            this.gTk = bundle.getLong("challengeid");
            this.bmB = bundle.getLong(AlaSDKShareEmptyActivityConfig.SHARE_ALA_SDK_LIVE_ID);
            this.fSB = bundle.getLong("anchorid");
            this.mType = bundle.getInt("type", 1);
            this.mIsHost = bundle.getBoolean(AlaPersonCenterExpActivityConfig.IS_HOST);
            return;
        }
        this.gTk = getIntent().getLongExtra("challengeid", 0L);
        this.bmB = getIntent().getLongExtra(AlaSDKShareEmptyActivityConfig.SHARE_ALA_SDK_LIVE_ID, 0L);
        this.fSB = getIntent().getLongExtra("anchorid", 0L);
        this.mType = getIntent().getIntExtra("type", 1);
        this.mIsHost = getIntent().getBooleanExtra(AlaPersonCenterExpActivityConfig.IS_HOST, false);
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
        this.aXJ = true;
        Animation loadAnimation = AnimationUtils.loadAnimation(getActivity(), a.C0195a.sdk_in_from_bottom);
        loadAnimation.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.ala.liveroom.challenge.AlaChallengeShowAllJinzhuActivity.1
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                AlaChallengeShowAllJinzhuActivity.this.aXJ = false;
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        });
        this.mRootView.startAnimation(loadAnimation);
    }

    private void Hw() {
        if (!this.aXK && !this.aXJ) {
            Animation loadAnimation = AnimationUtils.loadAnimation(getActivity(), a.C0195a.sdk_out_to_bottom);
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
            this.aXK = true;
            this.mRootView.startAnimation(loadAnimation);
        }
    }

    @Override // com.baidu.live.tbadk.BaseActivity, android.app.Activity
    public void finish() {
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
            RJ();
        }
    }

    private void initView() {
        this.mRootView = LayoutInflater.from(getPageContext().getPageActivity()).inflate(a.h.ala_jinzhu_tab_layout, (ViewGroup) null);
        setContentView(this.mRootView);
        initTabSpec();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.support.v4.app.FragmentActivity, android.support.v4.app.SupportActivity, android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putLong("challengeid", this.gTk);
        bundle.putLong(AlaSDKShareEmptyActivityConfig.SHARE_ALA_SDK_LIVE_ID, this.bmB);
        bundle.putLong("anchorid", this.fSB);
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
                attributes.height = screenDimensions[1] - BdUtilHelper.getStatusBarHeight(getPageContext().getPageActivity());
                attributes.gravity = 80;
                getWindowManager().updateViewLayout(decorView, attributes);
            }
            this.mScreenWidth = screenDimensions[0];
            window.setBackgroundDrawableResource(17170445);
            window.getDecorView().getViewTreeObserver().addOnGlobalLayoutListener(this.aXF);
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
        this.gTj = new AlaChallengeShowAllJinzhuPagerAdapter(getPageContext(), this.gTk, this.bmB, this.fSB, this.mIsHost);
        this.gTi = (AlaLiveRoomPanelTabHost) this.mRootView.findViewById(a.g.ala_jinzhu_tab_host);
        this.gTi.setIndicatorWidthAuto(true);
        this.gTi.setData(this.gTj.getDataList());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.live.tbadk.BaseActivity, com.baidu.live.adp.base.BdBaseActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        Iterator<com.baidu.live.liveroom.d.d> it = this.gTj.getDataList().iterator();
        while (it.hasNext()) {
            it.next().onDestroy();
        }
        this.mHandler.removeCallbacksAndMessages(null);
        getWindow().getDecorView().getViewTreeObserver().removeGlobalOnLayoutListener(this.aXF);
        this.aXF = null;
    }
}
