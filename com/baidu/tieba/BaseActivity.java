package com.baidu.tieba;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import com.baidu.tieba.util.TiebaLog;
import com.baidu.tieba.util.UtilHelper;
/* loaded from: classes.dex */
public class BaseActivity extends Activity {
    protected ProgressDialog mWaitingDialog = null;
    private DialogInterface.OnCancelListener mDialogListener = null;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.app.Activity
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        TiebaApplication.IS_APP_RUNNING = true;
    }

    protected void InitTitle() {
        getWindow().setFeatureInt(7, R.layout.title);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.app.Activity
    public void onDestroy() {
        closeLoadingDialog();
        super.onDestroy();
    }

    public void showLoadingDialog(String string) {
        if (this.mDialogListener == null) {
            this.mDialogListener = new DialogInterface.OnCancelListener() { // from class: com.baidu.tieba.BaseActivity.1
                @Override // android.content.DialogInterface.OnCancelListener
                public void onCancel(DialogInterface dialog) {
                    BaseActivity.this.mWaitingDialog = null;
                }
            };
        }
        if (string != null) {
            this.mWaitingDialog = ProgressDialog.show(this, "", string, true, false, this.mDialogListener);
        } else {
            this.mWaitingDialog = ProgressDialog.show(this, "", getResources().getString(R.string.Waiting), true, false, this.mDialogListener);
        }
    }

    public void DeinitWaitingDialog() {
        this.mWaitingDialog = null;
    }

    public void showLoadingDialog(String string, DialogInterface.OnCancelListener listener) {
        if (string != null) {
            this.mWaitingDialog = ProgressDialog.show(this, "", string, true, true, listener);
        } else {
            this.mWaitingDialog = ProgressDialog.show(this, "", getResources().getString(R.string.Waiting), true, true, listener);
        }
    }

    public void closeLoadingDialog() {
        if (this.mWaitingDialog != null) {
            try {
                if (this.mWaitingDialog.isShowing()) {
                    this.mWaitingDialog.dismiss();
                }
            } catch (Exception ex) {
                TiebaLog.e(getClass().getName(), "closeLoadingDialog", ex.getMessage());
            }
            this.mWaitingDialog = null;
        }
    }

    public void showToast(String str) {
        UtilHelper.showToast(this, str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void HidenSoftKeyPad(InputMethodManager imm, View view) {
        try {
            imm.hideSoftInputFromWindow(view.getWindowToken(), 2);
        } catch (Exception ex) {
            TiebaLog.e(getClass().getName(), "HidenSoftKeyPad", "error = " + ex.getMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void ShowSoftKeyPad(InputMethodManager imm, View view) {
        if (view != null && imm != null) {
            try {
                imm.showSoftInput(view, 0);
            } catch (Exception e) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void ShowSoftKeyPadDelay(View view, int delayMillis) {
        Handler handler = new Handler();
        DelayRunnable r = new DelayRunnable(view);
        handler.postDelayed(r, delayMillis);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void quitDialog() {
        UtilHelper.quitDialog(this);
    }

    /* loaded from: classes.dex */
    class DelayRunnable implements Runnable {
        private View mView;

        public DelayRunnable(View view) {
            this.mView = null;
            this.mView = view;
        }

        @Override // java.lang.Runnable
        public void run() {
            InputMethodManager imm = (InputMethodManager) BaseActivity.this.getSystemService("input_method");
            BaseActivity.this.ShowSoftKeyPad(imm, this.mView);
        }
    }
}
