package com.baidu.tieba;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.os.Handler;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.FrameLayout;
import android.widget.ProgressBar;
import com.baidu.adp.lib.util.BdUtilHelper;
import com.baidu.mobstat.StatService;
import com.baidu.tieba.compatible.CompatibleUtile;
import com.baidu.tieba.util.UtilHelper;
import com.baidu.tieba.util.cc;
import com.compatible.smartbarutil.SmartBarUtils;
import com.slidingmenu.lib.R;
/* loaded from: classes.dex */
public class f extends com.baidu.adp.a.a {
    private com.baidu.tieba.util.u customToast;
    protected boolean hasSmartBar;
    private c mLayoutInflateFactory;
    private e mLayoutMode;
    private ProgressBar mProgressBar;
    protected ProgressDialog mWaitingDialog = null;
    private DialogInterface.OnCancelListener mDialogListener = null;
    private AlertDialog mListMenu = null;
    protected int mSkinType = -1;
    private com.baidu.tieba.view.bb mGuidPage = null;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.a.a, android.app.Activity
    public void onCreate(Bundle bundle) {
        this.hasSmartBar = TiebaApplication.g().bu();
        if (this.hasSmartBar) {
            SmartBarUtils.initActionBar(this);
            SmartBarUtils.setActionBarTabsShowAtBottom(this, true);
            SmartBarUtils.setActionBarViewCollapsable(this, true);
        }
        this.customToast = com.baidu.tieba.util.u.a();
        super.onCreate(bundle);
        this.mLayoutMode = new e();
        this.mLayoutInflateFactory = new c();
        this.mLayoutInflateFactory.a(this.mLayoutMode);
        getLayoutInflater().setFactory(this.mLayoutInflateFactory);
        if (getGpuSwitch()) {
            CompatibleUtile.getInstance().openGpu(this);
        }
        com.baidu.tieba.account.m.a().b();
        TiebaApplication.v(true);
        cc.a(getClass().getName());
        if (TiebaApplication.g().s()) {
            try {
                StatService.setAppChannel(com.baidu.tieba.data.i.l());
            } catch (Exception e) {
                com.baidu.adp.lib.util.f.b(getClass().getName(), "onCreate", e.getMessage());
            }
        }
    }

    public boolean getGpuSwitch() {
        return false;
    }

    @Override // android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 82) {
            try {
                if (keyEvent.isLongPress()) {
                    return true;
                }
            } catch (IllegalStateException e) {
                if (i == 4) {
                    finish();
                    return true;
                }
                return false;
            }
        }
        return super.onKeyDown(i, keyEvent);
    }

    @Override // android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyUp(int i, KeyEvent keyEvent) {
        try {
            return super.onKeyUp(i, keyEvent);
        } catch (IllegalStateException e) {
            if (i == 4) {
                finish();
            }
            return true;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void closeActivity() {
        finish();
    }

    protected void InitTitle() {
        getWindow().setFeatureInt(7, R.layout.title);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.a.a, android.app.Activity
    public void onDestroy() {
        closeLoadingDialog();
        if (this.mGuidPage != null) {
            this.mGuidPage.a();
        }
        if (this.mLayoutMode != null) {
            this.mLayoutMode.b();
        }
        hideListMenu();
        super.onDestroy();
    }

    @Override // com.baidu.adp.a.a
    public void releaseResouce() {
    }

    public void showProgressBar() {
        showProgressBarWithOffset(0, 0);
    }

    public void showProgressBarWithOffset(int i, int i2) {
        if (this.mProgressBar == null) {
            this.mProgressBar = new ProgressBar(this);
            this.mProgressBar.setIndeterminateDrawable(getResources().getDrawable(R.drawable.progressbar));
            ((FrameLayout) findViewById(16908290)).addView(this.mProgressBar, new FrameLayout.LayoutParams(-2, -2, 17));
        }
        this.mProgressBar.setPadding(BdUtilHelper.a(this, i), BdUtilHelper.a(this, i2), 0, 0);
        this.mProgressBar.setVisibility(0);
    }

    public void hideProgressBar() {
        if (this.mProgressBar != null) {
            this.mProgressBar.setVisibility(8);
        }
    }

    public boolean isProgressBarShown() {
        return this.mProgressBar != null && this.mProgressBar.getVisibility() == 0;
    }

    public void showLoadingDialog(String str) {
        if (this.mDialogListener == null) {
            this.mDialogListener = new g(this);
        }
        if (str != null) {
            this.mWaitingDialog = ProgressDialog.show(this, "", str, true, false, this.mDialogListener);
        } else {
            this.mWaitingDialog = ProgressDialog.show(this, "", getResources().getString(R.string.Waiting), true, false, this.mDialogListener);
        }
    }

    public void DeinitWaitingDialog() {
        this.mWaitingDialog = null;
    }

    public void showLoadingDialog(String str, DialogInterface.OnCancelListener onCancelListener) {
        if (str != null) {
            this.mWaitingDialog = ProgressDialog.show(this, "", str, true, true, onCancelListener);
        } else {
            this.mWaitingDialog = ProgressDialog.show(this, "", getResources().getString(R.string.Waiting), true, true, onCancelListener);
        }
    }

    public void closeLoadingDialog() {
        if (this.mWaitingDialog != null) {
            try {
                if (this.mWaitingDialog.isShowing()) {
                    this.mWaitingDialog.dismiss();
                }
            } catch (Exception e) {
                com.baidu.adp.lib.util.f.b(getClass().getName(), "closeLoadingDialog", e.getMessage());
            }
            this.mWaitingDialog = null;
        }
    }

    public ProgressDialog getLoadingDialog() {
        return this.mWaitingDialog;
    }

    @Override // com.baidu.adp.a.a
    public void showToast(String str) {
        String name = getClass().getName();
        String str2 = String.valueOf(getApplicationContext().getPackageName()) + ".chat";
        if (name.startsWith(String.valueOf(getApplicationContext().getPackageName()) + ".im") || name.startsWith(str2)) {
            this.customToast.a(str, 2000);
        } else {
            BdUtilHelper.a((Context) this, str);
        }
    }

    public void showToast(String str, int i) {
        this.customToast.a(str, 2000, i);
    }

    public void showToast(int i, int i2) {
        this.customToast.a(i, 2000, i2);
    }

    public void showToast(int i) {
        String name = getClass().getName();
        String str = String.valueOf(getApplicationContext().getPackageName()) + ".chat";
        if (name.startsWith(String.valueOf(getApplicationContext().getPackageName()) + ".im") || name.startsWith(str)) {
            this.customToast.a(i, 2000);
        } else {
            BdUtilHelper.a((Context) this, i);
        }
    }

    public void showToast(String str, boolean z) {
        if (z) {
            showToast(str);
        } else {
            BdUtilHelper.a((Context) this, str);
        }
    }

    public void showToast(int i, boolean z) {
        if (z) {
            showToast(i);
        } else {
            BdUtilHelper.a((Context) this, i);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void HidenSoftKeyPad(InputMethodManager inputMethodManager, View view) {
        try {
            inputMethodManager.hideSoftInputFromWindow(view.getWindowToken(), 2);
        } catch (Exception e) {
            com.baidu.adp.lib.util.f.b(getClass().getName(), "HidenSoftKeyPad", "error = " + e.getMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void ShowSoftKeyPad(InputMethodManager inputMethodManager, View view) {
        if (view != null && inputMethodManager != null) {
            try {
                inputMethodManager.showSoftInput(view, 0);
            } catch (Exception e) {
            }
        }
    }

    public void ShowSoftKeyPadDelay(View view, int i) {
        new Handler().postDelayed(new h(this, view), i);
    }

    protected AlertDialog newListMenu(String[] strArr, DialogInterface.OnClickListener onClickListener) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(R.string.operation);
        builder.setItems(strArr, onClickListener);
        this.mListMenu = builder.create();
        this.mListMenu.setCanceledOnTouchOutside(true);
        return this.mListMenu;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public AlertDialog createListMenu(String[] strArr, DialogInterface.OnClickListener onClickListener) {
        return this.mListMenu != null ? this.mListMenu : newListMenu(strArr, onClickListener);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public AlertDialog getListMenu() {
        return this.mListMenu;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void showListMenu() {
        if (this.mListMenu != null && !this.mListMenu.isShowing()) {
            this.mListMenu.show();
        }
    }

    protected void hideListMenu() {
        if (this.mListMenu != null && this.mListMenu.isShowing()) {
            this.mListMenu.dismiss();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.app.Activity
    public void onPause() {
        super.onPause();
        this.customToast.b();
        TiebaApplication.g().ay();
        if (TiebaApplication.g().s()) {
            try {
                StatService.onPause(this);
            } catch (Exception e) {
                com.baidu.adp.lib.util.f.b(getClass().getName(), "onPause", e.getMessage());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void setSkinType(int i) {
        this.mSkinType = i;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.app.Activity
    public void onResume() {
        super.onResume();
        this.customToast.c();
        changeSkinType(TiebaApplication.g().al());
        if (TiebaApplication.g().s()) {
            try {
                StatService.onResume(this);
            } catch (Exception e) {
                com.baidu.adp.lib.util.f.b(getClass().getName(), "onResume", e.getMessage());
            }
        }
        TiebaApplication.g().ax();
        cc.a(getClass().getName());
    }

    public void changeSkinType(int i) {
        if (i != this.mSkinType) {
            this.mSkinType = i;
            onChangeSkinType(this.mSkinType);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.app.Activity
    public void onStop() {
        super.onStop();
        onResourceRecycle();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onResourceRecycle() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onChangeSkinType(int i) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void quitDialog() {
        UtilHelper.a((Activity) this);
    }

    public e getLayoutMode() {
        return this.mLayoutMode;
    }

    public void setLayoutMode(e eVar) {
        this.mLayoutMode = eVar;
    }

    public c getLayoutInflate() {
        return this.mLayoutInflateFactory;
    }

    public void setLayoutInflate(c cVar) {
        this.mLayoutInflateFactory = cVar;
    }
}
