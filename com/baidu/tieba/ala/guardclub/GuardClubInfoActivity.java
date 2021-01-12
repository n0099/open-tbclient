package com.baidu.tieba.ala.guardclub;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.RelativeLayout;
import com.baidu.ala.AlaCmdConfigCustom;
import com.baidu.live.adp.framework.listener.CustomMessageListener;
import com.baidu.live.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.ActivityPendingTransitionFactory;
import com.baidu.live.tbadk.BaseActivity;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.atomdata.GuardClubInfoActivityConfig;
import com.baidu.live.tbadk.core.frameworkdata.IntentConfig;
import com.baidu.live.tbadk.core.util.UtilHelper;
import com.baidu.live.view.BackBar;
/* loaded from: classes10.dex */
public class GuardClubInfoActivity extends BaseActivity<GuardClubInfoActivity> {
    private boolean aGY;
    private String aLT;
    private String aLU;
    private String aTK;
    private long anchorId;
    private e gUX;
    private boolean gUY;
    private boolean isFullScreen;
    private long liveId;
    private View mRootView;
    private String otherParams;
    private long roomId;
    private Handler mHandler = new Handler();
    private boolean aTo = false;
    private boolean aXA = false;
    private boolean aXB = false;
    CustomMessageListener aTF = new CustomMessageListener(AlaCmdConfigCustom.CMD_ALA_IMAGE_FRAME_PLAYER_CONTROLLER) { // from class: com.baidu.tieba.ala.guardclub.GuardClubInfoActivity.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            GuardClubInfoActivity.this.closeActivity();
        }
    };
    CustomMessageListener notifyDialogDismissListener = new CustomMessageListener(2913097) { // from class: com.baidu.tieba.ala.guardclub.GuardClubInfoActivity.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof String) && TextUtils.equals((String) customResponsedMessage.getData(), "into_end_view")) {
                GuardClubInfoActivity.this.closeActivity();
            }
        }
    };
    private CustomMessageListener aTE = new CustomMessageListener(2913054) { // from class: com.baidu.tieba.ala.guardclub.GuardClubInfoActivity.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            GuardClubInfoActivity.this.closeActivity();
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.live.tbadk.BaseActivity, com.baidu.live.adp.base.BdBaseActivity, androidx.fragment.app.FragmentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        setIsAddSwipeBackLayout(false);
        getWindow().setSoftInputMode(16);
        boolean booleanExtra = getIntent().getBooleanExtra("is_translucent", false);
        if (booleanExtra) {
            setTheme(a.i.DialogStyleBottom);
        }
        super.onCreate(bundle);
        if (!isFinishing()) {
            this.anchorId = getIntent().getLongExtra("anchor_id", 0L);
            this.liveId = getIntent().getLongExtra("live_id", 0L);
            this.roomId = getIntent().getLongExtra("room_id", 0L);
            this.aTK = getIntent().getStringExtra("feed_id");
            this.aGY = getIntent().getBooleanExtra("is_live_owner", false);
            this.otherParams = getIntent().getStringExtra(IntentConfig.OTHER_PARAMS);
            this.isFullScreen = getIntent().getBooleanExtra(GuardClubInfoActivityConfig.IS_FULLSCREEN, true);
            this.gUY = getIntent().getBooleanExtra(GuardClubInfoActivityConfig.IS_CLUB_MEMBER, true);
            String stringExtra = getIntent().getStringExtra(GuardClubInfoActivityConfig.FROM_LOC_INFO);
            boolean booleanExtra2 = getIntent().getBooleanExtra(GuardClubInfoActivityConfig.IS_HIDE_RANK, false);
            this.aLT = getIntent().getStringExtra(GuardClubInfoActivityConfig.ANCHOR_NAME);
            this.aLU = getIntent().getStringExtra(GuardClubInfoActivityConfig.ANCHOR_PORTRAIT);
            this.gUX = new e(this, this.anchorId, this.liveId, this.roomId, this.aTK, this.aGY, this.otherParams, this.isFullScreen, this.gUY, booleanExtra2, stringExtra, booleanExtra, this.aLT, this.aLU);
            if (this.gUX.getView() != null) {
                if (TbadkCoreApplication.getInst().isMobileBaidu()) {
                    this.mRootView = h(this.gUX.getView(), this.isFullScreen);
                } else {
                    this.mRootView = this.gUX.getView();
                }
                setContentView(this.mRootView);
            }
            if (!this.isFullScreen) {
                registerListener(this.aTF);
                registerListener(this.aTE);
            }
            registerListener(this.notifyDialogDismissListener);
            if (UtilHelper.getRealScreenOrientation(getActivity()) == 2) {
                com.baidu.live.utils.i.ae(this.gUX.getView());
            }
            ActivityPendingTransitionFactory.enterExitAnimation(getPageContext(), 0);
            this.aXA = false;
            this.mRootView.setVisibility(4);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.live.tbadk.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        if (!this.aTo) {
            this.mRootView.setVisibility(0);
            EL();
            this.aTo = true;
        }
    }

    private void EL() {
        Animation loadAnimation;
        this.aXA = true;
        if (UtilHelper.getRealScreenOrientation(getActivity()) == 2) {
            loadAnimation = AnimationUtils.loadAnimation(getActivity(), a.C0194a.sdk_in_from_right);
        } else {
            loadAnimation = AnimationUtils.loadAnimation(getActivity(), a.C0194a.sdk_in_from_bottom);
        }
        loadAnimation.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.ala.guardclub.GuardClubInfoActivity.1
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                GuardClubInfoActivity.this.aXA = false;
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        });
        this.mRootView.startAnimation(loadAnimation);
    }

    private void EM() {
        Animation loadAnimation;
        if (!this.aXB && !this.aXA) {
            if (UtilHelper.getRealScreenOrientation(getActivity()) == 2) {
                loadAnimation = AnimationUtils.loadAnimation(getActivity(), a.C0194a.sdk_out_to_right);
            } else {
                loadAnimation = AnimationUtils.loadAnimation(getActivity(), a.C0194a.sdk_out_to_bottom);
            }
            loadAnimation.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.ala.guardclub.GuardClubInfoActivity.2
                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationStart(Animation animation) {
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationEnd(Animation animation) {
                    GuardClubInfoActivity.super.finish();
                    ActivityPendingTransitionFactory.enterExitAnimation(GuardClubInfoActivity.this.getPageContext(), 0);
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationRepeat(Animation animation) {
                }
            });
            this.aXB = true;
            this.mRootView.startAnimation(loadAnimation);
        }
    }

    @Override // com.baidu.live.tbadk.BaseActivity, android.app.Activity
    public void finish() {
        EM();
    }

    private View h(View view, boolean z) {
        if (z) {
            RelativeLayout relativeLayout = new RelativeLayout(getPageContext().getPageActivity());
            BackBar backBar = new BackBar(getPageContext().getPageActivity());
            backBar.setId(a.f.sdk_live_backbar);
            backBar.setTheme(0);
            backBar.setBackgroundColor(-14674877);
            backBar.setCallback(new BackBar.a() { // from class: com.baidu.tieba.ala.guardclub.GuardClubInfoActivity.3
                @Override // com.baidu.live.view.BackBar.a
                public void onBack() {
                    GuardClubInfoActivity.this.finish();
                }
            });
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, getResources().getDimensionPixelOffset(a.d.sdk_ds96));
            layoutParams.addRule(12);
            backBar.setLayoutParams(layoutParams);
            RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-1, -1);
            layoutParams2.addRule(2, a.f.sdk_live_backbar);
            view.setLayoutParams(layoutParams2);
            relativeLayout.addView(backBar);
            relativeLayout.addView(view);
            return relativeLayout;
        }
        return view;
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        if (this.gUX.getView() != null) {
            this.gUX.Ex();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.live.tbadk.BaseActivity, com.baidu.live.adp.base.BdBaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (this.isFullScreen) {
            UtilHelper.changeStatusBarIconAndTextColor(true, getActivity());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.live.tbadk.BaseActivity, com.baidu.live.adp.base.BdBaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.mHandler.removeCallbacksAndMessages(null);
        if (this.gUX != null) {
            this.gUX.onDestroy();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.live.tbadk.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i2 == -1) {
            if ((i == 25045 || i == 25046) && this.gUX != null) {
                this.gUX.bUO();
            }
            if (i == 25046 && intent != null) {
                if (intent.getBooleanExtra("guard_club_rank_hit", false)) {
                    setResult(-1);
                    finish();
                } else if (intent.getBooleanExtra("guard_club_rank_back_to_room", false)) {
                    finish();
                }
            }
        }
    }
}
