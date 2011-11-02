package com.baidu.tieba;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Toast;
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
        if (str != null && str.length() > 0) {
            Toast toast = Toast.makeText(TiebaApplication.app, str, 3000);
            int y_offset = UtilHelper.dip2px(this, 100.0f);
            toast.setGravity(17, 0, y_offset);
            toast.show();
        }
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
        try {
            imm.showSoftInput(view, 0);
        } catch (Exception e) {
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void quitDialog() {
        new AlertDialog.Builder(this).setTitle(R.string.alerm_title).setIcon((Drawable) null).setCancelable(false).setMessage(R.string.alert_quit_confirm).setPositiveButton(R.string.alert_yes_button, new DialogInterface.OnClickListener() { // from class: com.baidu.tieba.BaseActivity.3
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialog, int which) {
                BaseActivity.this.finish();
            }
        }).setNegativeButton(R.string.alert_no_button, new DialogInterface.OnClickListener() { // from class: com.baidu.tieba.BaseActivity.2
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        }).create().show();
    }
}
