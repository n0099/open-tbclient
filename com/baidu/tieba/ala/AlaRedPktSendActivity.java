package com.baidu.tieba.ala;

import android.content.res.Configuration;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.os.Bundle;
import android.view.ViewTreeObserver;
import android.view.Window;
import com.baidu.live.adp.lib.util.BdUtilHelper;
import com.baidu.live.tbadk.core.BaseFragmentActivity;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.util.ViewCommonUtil;
import com.baidu.live.u.a;
/* loaded from: classes3.dex */
public class AlaRedPktSendActivity extends BaseFragmentActivity {
    private int availableHeight;
    private com.baidu.tieba.ala.c.a eVi;
    private int mLastScreenHeight;
    private int mLastScreenWidth;
    private boolean mIsKeyboardOpen = false;
    private boolean eVj = true;
    ViewTreeObserver.OnGlobalLayoutListener globalListener = new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.tieba.ala.AlaRedPktSendActivity.1
        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            Rect rect = new Rect();
            AlaRedPktSendActivity.this.getPageContext().getPageActivity().getWindow().getDecorView().getWindowVisibleDisplayFrame(rect);
            int statusBarHeight = BdUtilHelper.getStatusBarHeight(AlaRedPktSendActivity.this.getPageContext().getPageActivity());
            int[] screenFullSize = ViewCommonUtil.getScreenFullSize(AlaRedPktSendActivity.this.getPageContext().getPageActivity());
            boolean z = AlaRedPktSendActivity.this.availableHeight != rect.bottom;
            AlaRedPktSendActivity.this.availableHeight = rect.bottom;
            if (AlaRedPktSendActivity.this.mLastScreenHeight != screenFullSize[1]) {
                AlaRedPktSendActivity.this.mLastScreenHeight = screenFullSize[1];
            } else if (AlaRedPktSendActivity.this.mLastScreenWidth != screenFullSize[0]) {
                AlaRedPktSendActivity.this.mLastScreenWidth = screenFullSize[0];
            }
            if (screenFullSize[1] - rect.bottom > screenFullSize[1] / 4 && ((!AlaRedPktSendActivity.this.mIsKeyboardOpen || z) && AlaRedPktSendActivity.this.eVj)) {
                AlaRedPktSendActivity.this.mIsKeyboardOpen = true;
                TbadkCoreApplication.getInst().setKeyboardHeight(screenFullSize[1] - rect.bottom);
                AlaRedPktSendActivity.this.onKeyboardVisibilityChanged(true);
            } else if (screenFullSize[1] - rect.height() <= statusBarHeight && AlaRedPktSendActivity.this.mIsKeyboardOpen) {
                AlaRedPktSendActivity.this.mIsKeyboardOpen = false;
                AlaRedPktSendActivity.this.onKeyboardVisibilityChanged(false);
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.live.tbadk.core.BaseFragmentActivity, com.baidu.live.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.support.v4.app.SupportActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        setIsAddSwipeBackLayout(false);
        setUseStyleImmersiveSticky(true);
        String str = Build.DISPLAY;
        if (str != null && str.contains("Flyme")) {
            getWindow().setBackgroundDrawable(new ColorDrawable(getResources().getColor(a.d.sdk_transparent)));
        }
        super.onCreate(bundle);
        if (!isFinishing()) {
            this.eVi = new com.baidu.tieba.ala.c.a(getPageContext().getPageActivity());
            setContentView(this.eVi.getView());
            Window window = getWindow();
            if (window != null) {
                window.getDecorView().getViewTreeObserver().addOnGlobalLayoutListener(this.globalListener);
            }
        }
    }

    @Override // android.support.v4.app.FragmentActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        if (this.eVi != null) {
            this.eVi.yL();
        }
    }

    @Override // com.baidu.live.tbadk.core.BaseFragmentActivity
    public void onKeyboardVisibilityChanged(boolean z) {
        if (this.eVi != null) {
            this.eVi.onKeyboardVisibilityChanged(z);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.live.tbadk.core.BaseFragmentActivity, com.baidu.live.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        this.eVj = true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.live.tbadk.core.BaseFragmentActivity, com.baidu.live.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        this.eVj = false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.live.tbadk.core.BaseFragmentActivity, com.baidu.live.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.eVi != null) {
            this.eVi.destroy();
        }
    }

    @Override // com.baidu.live.tbadk.core.BaseFragmentActivity
    public void enterExitAnimation() {
        overridePendingTransition(0, 0);
    }

    @Override // com.baidu.live.tbadk.core.BaseFragmentActivity
    public void closeAnimation() {
        overridePendingTransition(0, 0);
    }

    @Override // com.baidu.live.tbadk.core.BaseFragmentActivity
    protected void onChangeSkinType(int i) {
    }
}
