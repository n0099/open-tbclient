package com.baidu.tieba;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import com.baidu.tieba.data.VersionData;
import com.baidu.tieba.service.TiebaUpdateService;
import com.baidu.tieba.util.FileHelper;
/* loaded from: classes.dex */
public class UpdateDialog extends BaseActivity {
    public static final String TAG_DATA = "data";
    private VersionData mData = null;
    private AlertDialog mDialog = null;
    private DialogInterface.OnClickListener mUpdataListener = null;
    private DialogInterface.OnClickListener mMustUpdataListener = null;

    public static void startActivity(Context context, VersionData data) {
        if (data != null) {
            Intent intent = new Intent(context, UpdateDialog.class);
            intent.setFlags(268435456);
            intent.putExtra("data", data);
            context.startActivity(intent);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.BaseActivity, android.app.Activity
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        InitData(savedInstanceState);
    }

    private void InitData(Bundle savedInstanceState) {
        String content;
        if (savedInstanceState != null) {
            this.mData = (VersionData) savedInstanceState.getSerializable("data");
        } else {
            Intent intent = getIntent();
            if (intent != null) {
                this.mData = (VersionData) intent.getSerializableExtra("data");
            }
        }
        if (this.mData == null || this.mData.getHas_new_ver() == 0) {
            finish();
        }
        AlertDialog.Builder dialog_builder = new AlertDialog.Builder(this);
        dialog_builder.setTitle(R.string.notify);
        if (this.mData.getNew_version_desc() != null && this.mData.getNew_version_desc().length() > 0) {
            content = this.mData.getNew_version_desc();
        } else {
            content = String.format(getString(R.string.update_client), this.mData.getNew_version());
        }
        if (this.mData.getHas_new_ver() == 1) {
            if (this.mData.getForce_update() == 1) {
                this.mMustUpdataListener = new DialogInterface.OnClickListener() { // from class: com.baidu.tieba.UpdateDialog.1
                    @Override // android.content.DialogInterface.OnClickListener
                    public void onClick(DialogInterface dialog, int which) {
                        if (which == -1) {
                            UpdateDialog.this.mDialog.dismiss();
                            UpdateDialog.this.startUpdata();
                        } else if (which == -2) {
                            UpdateDialog.this.mDialog.dismiss();
                            UpdateDialog.this.stopUpdataService();
                        }
                        MainTabActivity.startActivity(UpdateDialog.this, MainTabActivity.GOTO_CLOSE);
                    }
                };
                dialog_builder.setMessage(content);
                dialog_builder.setPositiveButton(R.string.update_new_ver, this.mMustUpdataListener);
                dialog_builder.setNegativeButton(R.string.close, this.mMustUpdataListener);
            } else {
                this.mUpdataListener = new DialogInterface.OnClickListener() { // from class: com.baidu.tieba.UpdateDialog.2
                    @Override // android.content.DialogInterface.OnClickListener
                    public void onClick(DialogInterface dialog, int which) {
                        if (which == -1) {
                            UpdateDialog.this.mDialog.dismiss();
                            UpdateDialog.this.startUpdata();
                        } else if (which == -2) {
                            UpdateDialog.this.mDialog.dismiss();
                            UpdateDialog.this.stopUpdataService();
                        }
                    }
                };
                dialog_builder.setMessage(content);
                dialog_builder.setPositiveButton(R.string.update_new_ver, this.mUpdataListener);
                dialog_builder.setNegativeButton(R.string.remind_later, this.mUpdataListener);
            }
        }
        this.mDialog = dialog_builder.create();
        this.mDialog.setCancelable(false);
        this.mDialog.setOnCancelListener(new DialogInterface.OnCancelListener() { // from class: com.baidu.tieba.UpdateDialog.3
            @Override // android.content.DialogInterface.OnCancelListener
            public void onCancel(DialogInterface dialog) {
                UpdateDialog.this.finish();
            }
        });
        this.mDialog.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.baidu.tieba.UpdateDialog.4
            @Override // android.content.DialogInterface.OnDismissListener
            public void onDismiss(DialogInterface arg0) {
                UpdateDialog.this.finish();
            }
        });
        this.mDialog.show();
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        if (this.mData != null) {
            outState.putSerializable("data", this.mData);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.BaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.mDialog != null) {
            this.mDialog.dismiss();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void startUpdata() {
        if (!FileHelper.checkSD()) {
            showToast(FileHelper.getSdErrorString());
            return;
        }
        Intent service = new Intent(this, TiebaUpdateService.class);
        service.putExtra(TiebaUpdateService.TAG_UPDATE, true);
        service.putExtra(TiebaUpdateService.TAG_VERSION, this.mData);
        startService(service);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void stopUpdataService() {
        Intent service = new Intent(this, TiebaUpdateService.class);
        stopService(service);
    }
}
