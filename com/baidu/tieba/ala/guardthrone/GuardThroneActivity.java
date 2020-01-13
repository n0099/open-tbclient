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
import com.baidu.live.r.a;
import com.baidu.live.tbadk.TbConfig;
import com.baidu.live.tbadk.core.BaseFragmentActivity;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.atomdata.AlaGuardThroneActivityConfig;
import com.baidu.live.tbadk.core.util.UtilHelper;
import com.baidu.live.utils.h;
import com.baidu.megapp.ma.Util;
import com.baidu.tieba.ala.guardthrone.f.a;
/* loaded from: classes2.dex */
public class GuardThroneActivity extends BaseFragmentActivity {
    private String Zb;
    private String asd;
    private a eEP;
    private a eEQ;
    private boolean eER;
    private boolean mIsHost;
    private String mLiveId;
    private int mTabId;
    private boolean isFinish = false;
    CustomMessageListener aeN = new CustomMessageListener(AlaCmdConfigCustom.CMD_ALA_IMAGE_FRAME_PLAYER_CONTROLLER) { // from class: com.baidu.tieba.ala.guardthrone.GuardThroneActivity.1
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
        bdN();
        initView();
        if (UtilHelper.getRealScreenOrientation(getPageContext().getPageActivity()) == 2) {
            setContentView(this.eEQ.getRootView());
        } else {
            setContentView(this.eEP.getRootView());
        }
        initListener();
        if (UtilHelper.getRealScreenOrientation(getActivity()) == 2) {
            h.S(this.eEQ.getRootView());
        } else {
            h.T(this.eEP.getRootView());
        }
    }

    @Override // android.support.v4.app.FragmentActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        if (!this.isFinish) {
            if (UtilHelper.getRealScreenOrientation(getPageContext().getPageActivity()) == 2) {
                this.eEP.getRootView().setVisibility(8);
                this.eEQ.getRootView().setVisibility(0);
                setContentView(this.eEQ.getRootView());
                h.S(this.eEQ.getRootView());
            } else {
                this.eEQ.getRootView().setVisibility(8);
                this.eEP.getRootView().setVisibility(0);
                setContentView(this.eEP.getRootView());
                h.T(this.eEP.getRootView());
            }
            this.eEP.awN();
            this.eEQ.awN();
        }
    }

    private void bdN() {
        this.mLiveId = getIntent().getStringExtra(AlaGuardThroneActivityConfig.GUARD_THRONE_LIVE_ID);
        this.asd = getIntent().getStringExtra(AlaGuardThroneActivityConfig.GUARD_THRONE_ANCHOR_ID);
        this.Zb = getIntent().getStringExtra(AlaGuardThroneActivityConfig.GUARD_THRONE_GIFT_ID);
        this.mTabId = getIntent().getIntExtra(AlaGuardThroneActivityConfig.GUARD_THRONE_TAB_ID, 1);
        this.mIsHost = getIntent().getBooleanExtra(AlaGuardThroneActivityConfig.GUARD_THRONE_IS_HOST, false);
    }

    private void initView() {
        this.eEP = new com.baidu.tieba.ala.guardthrone.f.a(this, false, this.mIsHost);
        this.eEP.e(this.mLiveId, this.asd, this.Zb, this.mTabId);
        this.eEQ = new com.baidu.tieba.ala.guardthrone.f.a(this, true, this.mIsHost);
        this.eEQ.e(this.mLiveId, this.asd, this.Zb, this.mTabId);
        if (UtilHelper.getRealScreenOrientation(getPageContext().getPageActivity()) == 2) {
            this.eEP.getRootView().setVisibility(8);
            this.eEQ.getRootView().setVisibility(0);
            return;
        }
        this.eEQ.getRootView().setVisibility(8);
        this.eEP.getRootView().setVisibility(0);
    }

    private void initListener() {
        registerListener(this.aeN);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.live.tbadk.core.BaseFragmentActivity, com.baidu.live.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        this.eER = true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.live.tbadk.core.BaseFragmentActivity, com.baidu.live.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (!this.eER) {
            this.eEP.onResume();
            this.eEQ.onResume();
        }
        this.eER = false;
    }

    @Override // com.baidu.live.tbadk.core.BaseFragmentActivity
    public void enterExitAnimation() {
        if (this instanceof Activity) {
            overridePendingTransition(a.C0086a.alpha_in, 0);
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
        MessageManager.getInstance().unRegisterListener(this.aeN);
        if (this.eEP != null) {
            this.eEP.onDestroy();
        }
        if (this.eEQ != null) {
            this.eEQ.onDestroy();
        }
    }

    @Override // com.baidu.live.tbadk.core.BaseFragmentActivity, android.app.Activity
    public void finish() {
        Animation beb;
        if (!this.isFinish) {
            this.isFinish = true;
            if (UtilHelper.getRealScreenOrientation(getPageContext().getPageActivity()) == 2) {
                beb = this.eEQ.beb();
            } else {
                beb = this.eEP.beb();
            }
            beb.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.ala.guardthrone.GuardThroneActivity.2
                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationStart(Animation animation) {
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationEnd(Animation animation) {
                    GuardThroneActivity.super.finish();
                    if (GuardThroneActivity.this instanceof Activity) {
                        GuardThroneActivity.this.overridePendingTransition(a.C0086a.alpha_in, a.C0086a.alpha_out);
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

    public void bdO() {
        super.finish();
    }

    public void closeActivity() {
        super.finish();
    }

    @Override // com.baidu.live.tbadk.core.BaseFragmentActivity
    protected void onChangeSkinType(int i) {
    }
}
