package com.baidu.tieba.ala;

import android.content.res.Configuration;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.os.Bundle;
import android.view.ViewTreeObserver;
import android.view.Window;
import com.baidu.live.adp.lib.util.BdUtilHelper;
import com.baidu.live.r.a;
import com.baidu.live.tbadk.core.BaseFragmentActivity;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.util.ViewCommonUtil;
/* loaded from: classes2.dex */
public class AlaRedPktSendActivity extends BaseFragmentActivity {
    private com.baidu.tieba.ala.b.a eel;
    private int eem;
    private int mLastScreenHeight;
    private int mLastScreenWidth;
    private boolean ahn = false;
    private boolean een = true;
    ViewTreeObserver.OnGlobalLayoutListener eeo = new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.tieba.ala.AlaRedPktSendActivity.1
        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            Rect rect = new Rect();
            AlaRedPktSendActivity.this.getPageContext().getPageActivity().getWindow().getDecorView().getWindowVisibleDisplayFrame(rect);
            int statusBarHeight = BdUtilHelper.getStatusBarHeight(AlaRedPktSendActivity.this.getPageContext().getPageActivity());
            int[] screenFullSize = ViewCommonUtil.getScreenFullSize(AlaRedPktSendActivity.this.getPageContext().getPageActivity());
            boolean z = AlaRedPktSendActivity.this.eem != rect.bottom;
            AlaRedPktSendActivity.this.eem = rect.bottom;
            if (AlaRedPktSendActivity.this.mLastScreenHeight != screenFullSize[1]) {
                AlaRedPktSendActivity.this.mLastScreenHeight = screenFullSize[1];
            } else if (AlaRedPktSendActivity.this.mLastScreenWidth != screenFullSize[0]) {
                AlaRedPktSendActivity.this.mLastScreenWidth = screenFullSize[0];
            }
            if (screenFullSize[1] - rect.bottom > screenFullSize[1] / 4 && ((!AlaRedPktSendActivity.this.ahn || z) && AlaRedPktSendActivity.this.een)) {
                AlaRedPktSendActivity.this.ahn = true;
                TbadkCoreApplication.getInst().setKeyboardHeight(screenFullSize[1] - rect.bottom);
                AlaRedPktSendActivity.this.onKeyboardVisibilityChanged(true);
            } else if (screenFullSize[1] - rect.height() <= statusBarHeight && AlaRedPktSendActivity.this.ahn) {
                AlaRedPktSendActivity.this.ahn = false;
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
        this.eel = new com.baidu.tieba.ala.b.a(getPageContext().getPageActivity());
        setContentView(this.eel.getView());
        Window window = getWindow();
        if (window != null) {
            window.getDecorView().getViewTreeObserver().addOnGlobalLayoutListener(this.eeo);
        }
    }

    @Override // android.support.v4.app.FragmentActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        if (this.eel != null) {
            this.eel.rP();
        }
    }

    @Override // com.baidu.live.tbadk.core.BaseFragmentActivity
    public void onKeyboardVisibilityChanged(boolean z) {
        if (this.eel != null) {
            this.eel.onKeyboardVisibilityChanged(z);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.live.tbadk.core.BaseFragmentActivity, com.baidu.live.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        this.een = true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.live.tbadk.core.BaseFragmentActivity, com.baidu.live.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        this.een = false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.live.tbadk.core.BaseFragmentActivity, com.baidu.live.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.eel != null) {
            this.eel.destroy();
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
