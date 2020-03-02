package com.baidu.tieba.ala.guardthrone;

import android.app.Activity;
import android.content.res.Configuration;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.os.Bundle;
import android.view.animation.Animation;
import com.baidu.ala.AlaCmdConfigCustom;
import com.baidu.fsg.base.utils.ResUtils;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.listener.CustomMessageListener;
import com.baidu.live.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.tbadk.TbConfig;
import com.baidu.live.tbadk.core.BaseFragmentActivity;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.atomdata.AlaGuardThroneActivityConfig;
import com.baidu.live.tbadk.core.util.UtilHelper;
import com.baidu.live.u.a;
import com.baidu.live.utils.h;
import com.baidu.megapp.ma.Util;
import com.baidu.tieba.ala.guardthrone.f.a;
/* loaded from: classes3.dex */
public class GuardThroneActivity extends BaseFragmentActivity {
    private String aaT;
    private String awo;
    private a eIK;
    private a eIL;
    private boolean eIM;
    private boolean mIsHost;
    private String mLiveId;
    private int mTabId;
    private boolean isFinish = false;
    CustomMessageListener agU = new CustomMessageListener(AlaCmdConfigCustom.CMD_ALA_IMAGE_FRAME_PLAYER_CONTROLLER) { // from class: com.baidu.tieba.ala.guardthrone.GuardThroneActivity.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            GuardThroneActivity.this.closeActivity();
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.live.tbadk.core.BaseFragmentActivity, com.baidu.live.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.support.v4.app.SupportActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        setIsAddSwipeBackLayout(false);
        super.onCreate(bundle);
        String str = Build.DISPLAY;
        if (str != null && str.contains("Flyme")) {
            getWindow().setBackgroundDrawable(new ColorDrawable(getResources().getColor(a.d.sdk_transparent)));
        }
        bfZ();
        initView();
        if (UtilHelper.getRealScreenOrientation(getPageContext().getPageActivity()) == 2) {
            setContentView(this.eIL.getRootView());
        } else {
            setContentView(this.eIK.getRootView());
        }
        initListener();
        if (UtilHelper.getRealScreenOrientation(getActivity()) == 2) {
            h.S(this.eIL.getRootView());
        } else {
            h.T(this.eIK.getRootView());
        }
    }

    @Override // android.support.v4.app.FragmentActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        if (!this.isFinish) {
            if (UtilHelper.getRealScreenOrientation(getPageContext().getPageActivity()) == 2) {
                this.eIK.getRootView().setVisibility(8);
                this.eIL.getRootView().setVisibility(0);
                setContentView(this.eIL.getRootView());
                h.S(this.eIL.getRootView());
            } else {
                this.eIL.getRootView().setVisibility(8);
                this.eIK.getRootView().setVisibility(0);
                setContentView(this.eIK.getRootView());
                h.T(this.eIK.getRootView());
            }
            this.eIK.azc();
            this.eIL.azc();
        }
    }

    private void bfZ() {
        this.mLiveId = getIntent().getStringExtra(AlaGuardThroneActivityConfig.GUARD_THRONE_LIVE_ID);
        this.awo = getIntent().getStringExtra(AlaGuardThroneActivityConfig.GUARD_THRONE_ANCHOR_ID);
        this.aaT = getIntent().getStringExtra(AlaGuardThroneActivityConfig.GUARD_THRONE_GIFT_ID);
        this.mTabId = getIntent().getIntExtra(AlaGuardThroneActivityConfig.GUARD_THRONE_TAB_ID, 1);
        this.mIsHost = getIntent().getBooleanExtra(AlaGuardThroneActivityConfig.GUARD_THRONE_IS_HOST, false);
    }

    private void initView() {
        this.eIK = new com.baidu.tieba.ala.guardthrone.f.a(this, false, this.mIsHost);
        this.eIK.e(this.mLiveId, this.awo, this.aaT, this.mTabId);
        this.eIL = new com.baidu.tieba.ala.guardthrone.f.a(this, true, this.mIsHost);
        this.eIL.e(this.mLiveId, this.awo, this.aaT, this.mTabId);
        if (UtilHelper.getRealScreenOrientation(getPageContext().getPageActivity()) == 2) {
            this.eIK.getRootView().setVisibility(8);
            this.eIL.getRootView().setVisibility(0);
            return;
        }
        this.eIL.getRootView().setVisibility(8);
        this.eIK.getRootView().setVisibility(0);
    }

    private void initListener() {
        registerListener(this.agU);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.live.tbadk.core.BaseFragmentActivity, com.baidu.live.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        this.eIM = true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.live.tbadk.core.BaseFragmentActivity, com.baidu.live.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (!this.eIM) {
            this.eIK.onResume();
            this.eIL.onResume();
        }
        this.eIM = false;
    }

    @Override // com.baidu.live.tbadk.core.BaseFragmentActivity
    public void enterExitAnimation() {
        if (this instanceof Activity) {
            overridePendingTransition(a.C0102a.alpha_in, 0);
        } else if (TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isTieba()) {
            overridePendingTransition(Util.getHostResourcesId(getActivity(), TbConfig.PACKAGE_NAME, "slide_in_from_bottom", ResUtils.ANIM), Util.getHostResourcesId(getActivity(), TbConfig.PACKAGE_NAME, "slide_out_to_bottom", ResUtils.ANIM));
        } else {
            overridePendingTransition(Util.getHostResourcesId(getActivity(), TbConfig.PACKAGE_NAME, "sdk_fade_in", ResUtils.ANIM), 0);
        }
    }

    @Override // com.baidu.live.tbadk.core.BaseFragmentActivity
    public void closeAnimation() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.live.tbadk.core.BaseFragmentActivity, com.baidu.live.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        MessageManager.getInstance().unRegisterListener(this.agU);
        if (this.eIK != null) {
            this.eIK.onDestroy();
        }
        if (this.eIL != null) {
            this.eIL.onDestroy();
        }
    }

    @Override // com.baidu.live.tbadk.core.BaseFragmentActivity, android.app.Activity
    public void finish() {
        Animation bgn;
        if (!this.isFinish) {
            this.isFinish = true;
            if (UtilHelper.getRealScreenOrientation(getPageContext().getPageActivity()) == 2) {
                bgn = this.eIL.bgn();
            } else {
                bgn = this.eIK.bgn();
            }
            bgn.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.ala.guardthrone.GuardThroneActivity.2
                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationStart(Animation animation) {
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationEnd(Animation animation) {
                    GuardThroneActivity.super.finish();
                    if (GuardThroneActivity.this instanceof Activity) {
                        GuardThroneActivity.this.overridePendingTransition(a.C0102a.alpha_in, a.C0102a.alpha_out);
                    } else {
                        GuardThroneActivity.this.overridePendingTransition(0, Util.getHostResourcesId(GuardThroneActivity.this.getActivity(), TbConfig.PACKAGE_NAME, "sdk_fade_out", ResUtils.ANIM));
                    }
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationRepeat(Animation animation) {
                }
            });
        }
    }

    public void bga() {
        super.finish();
    }

    public void closeActivity() {
        super.finish();
    }

    @Override // com.baidu.live.tbadk.core.BaseFragmentActivity
    protected void onChangeSkinType(int i) {
    }
}
