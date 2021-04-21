package com.baidu.tieba;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageInfo;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.WindowManager;
import android.webkit.URLUtil;
import com.alibaba.fastjson.asm.Label;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.ActivityPendingTransitionFactory;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.UpdateDialogConfig;
import com.baidu.tbadk.core.util.FileHelper;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.permission.PermissionJudgePolicy;
import com.baidu.tbadk.coreExtra.data.CombineDownload;
import com.baidu.tbadk.coreExtra.data.VersionData;
import com.baidu.tieba.service.TiebaUpdateService;
import com.kwad.sdk.core.imageloader.utils.StorageUtils;
import d.b.c.e.m.g;
import d.b.j0.j;
import d.b.j0.l;
import java.io.File;
/* loaded from: classes4.dex */
public class UpdateDialog extends BaseActivity<UpdateDialog> {
    public String mAsUrl;
    public CombineDownload mCombineDownload;
    public VersionData mData;
    public boolean mDownloadAs;
    public boolean mDownloadOther;
    public boolean mDownloadTieba;
    public boolean mIsBackgroundDownloading;
    public boolean mIsDownloading;
    public boolean mIsForceUpdate;
    public PermissionJudgePolicy mPermissionJudgement;
    public j mSupportDialog;
    public f mUpadateBroadcast;

    /* loaded from: classes4.dex */
    public class a implements DialogInterface.OnCancelListener {
        public a() {
        }

        @Override // android.content.DialogInterface.OnCancelListener
        public void onCancel(DialogInterface dialogInterface) {
            UpdateDialog.this.mSupportDialog.dismiss();
            UpdateDialog.this.finish();
        }
    }

    /* loaded from: classes4.dex */
    public class b implements DialogInterface.OnDismissListener {

        /* loaded from: classes4.dex */
        public class a implements Runnable {
            public a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                if (UpdateDialog.this.mData.forceUpdate()) {
                    d.b.i0.r.a0.b.e(UpdateDialog.this.getPageContext().getPageActivity(), 200);
                }
            }
        }

        public b() {
        }

        @Override // android.content.DialogInterface.OnDismissListener
        public void onDismiss(DialogInterface dialogInterface) {
            UpdateDialog.this.mSupportDialog.dismiss();
            UpdateDialog.this.mHandler.postDelayed(new a(), 100L);
        }
    }

    /* loaded from: classes4.dex */
    public class c implements View.OnClickListener {
        public c() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (UpdateDialog.this.mIsDownloading) {
                UpdateDialog.this.stopUpdataService();
            }
            UpdateDialog.this.mSupportDialog.dismiss();
            UpdateDialog.this.finish();
        }
    }

    /* loaded from: classes4.dex */
    public class d implements View.OnClickListener {
        public d() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            UpdateDialog.this.mSupportDialog.r();
            UpdateDialog updateDialog = UpdateDialog.this;
            updateDialog.startUpdate(updateDialog.mDownloadTieba, UpdateDialog.this.mDownloadAs, UpdateDialog.this.mDownloadOther);
        }
    }

    /* loaded from: classes4.dex */
    public class e implements j.f {
        public e() {
        }

        @Override // d.b.j0.j.f
        public void a(boolean z) {
            UpdateDialog.this.mIsDownloading = true;
            UpdateDialog updateDialog = UpdateDialog.this;
            if (updateDialog.startUpdate(true, false, z && l.d(updateDialog.getPageContext().getPageActivity(), UpdateDialog.this.mCombineDownload))) {
                UpdateDialog.this.mSupportDialog.t(false);
                UpdateDialog.this.showToast(R.string.download_begin_tip);
                if (UpdateDialog.this.mIsForceUpdate) {
                    return;
                }
                UpdateDialog.this.mSupportDialog.dismiss();
                UpdateDialog.this.finish();
            }
        }

        @Override // d.b.j0.j.f
        public void b(boolean z) {
            if (UpdateDialog.this.checkMainApkExist()) {
                UpdateDialog.this.mSupportDialog.dismiss();
                UpdateDialog.this.finish();
                return;
            }
            boolean z2 = true;
            if (l.c(UpdateDialog.this.getPageContext().getPageActivity().getPackageManager())) {
                l.b(UpdateDialog.this.getPageContext().getPageActivity(), UpdateDialog.this.mData);
                UpdateDialog updateDialog = UpdateDialog.this;
                updateDialog.startUpdate(false, false, (z && l.d(updateDialog.getPageContext().getPageActivity(), UpdateDialog.this.mCombineDownload)) ? false : false);
            } else {
                UpdateDialog updateDialog2 = UpdateDialog.this;
                updateDialog2.startUpdate(false, true, z && l.d(updateDialog2.getPageContext().getPageActivity(), UpdateDialog.this.mCombineDownload));
            }
            if (UpdateDialog.this.mIsForceUpdate) {
                return;
            }
            UpdateDialog.this.mSupportDialog.dismiss();
            UpdateDialog.this.finish();
        }

        @Override // d.b.j0.j.f
        public void c() {
            UpdateDialog.this.stopUpdataService();
        }

        @Override // d.b.j0.j.f
        public void d() {
            UpdateDialog.this.finish();
        }

        @Override // d.b.j0.j.f
        public void e() {
            UpdateDialog.this.mSupportDialog.dismiss();
            UpdateDialog.this.finish();
        }

        public /* synthetic */ e(UpdateDialog updateDialog, a aVar) {
            this();
        }
    }

    /* loaded from: classes4.dex */
    public class f extends BroadcastReceiver {
        public f() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            UpdateDialog.this.mIsBackgroundDownloading = intent.getBooleanExtra("action_background_downloading", false);
            if (UpdateDialog.this.mIsBackgroundDownloading) {
                UpdateDialog.this.showToast(R.string.background_updating);
                UpdateDialog.this.mSupportDialog.dismiss();
                UpdateDialog.this.finish();
            } else if (intent.getBooleanExtra("action_update_complete", false)) {
                UpdateDialog.this.mSupportDialog.dismiss();
                UpdateDialog.this.finish();
            } else if (intent.getBooleanExtra("action_update_progress_interrupted", false)) {
                UpdateDialog.this.mSupportDialog.dismiss();
                UpdateDialog updateDialog = UpdateDialog.this;
                updateDialog.showToast(updateDialog.getPageContext().getString(R.string.update_app_error));
                UpdateDialog.this.finish();
                UpdateDialog.this.stopUpdataService();
            } else {
                int intExtra = intent.getIntExtra("action_update_download_progress", 0);
                if (UpdateDialog.this.mSupportDialog != null) {
                    UpdateDialog.this.mSupportDialog.v(intExtra);
                }
            }
        }

        public /* synthetic */ f(UpdateDialog updateDialog, a aVar) {
            this();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:27:0x008d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean checkMainApkExist() {
        boolean z;
        File GetFile;
        PackageInfo packageArchiveInfo;
        VersionData versionData = this.mData;
        if (versionData != null && !StringUtils.isNull(versionData.getUrl()) && URLUtil.isNetworkUrl(this.mData.getUrl())) {
            String str = getPageContext().getString(R.string.app_name) + TbadkCoreApplication.getInst().getVersionName() + ".apk";
            String fileDireciory = FileHelper.getFileDireciory(str);
            if (fileDireciory != null && (packageArchiveInfo = getPageContext().getPageActivity().getPackageManager().getPackageArchiveInfo(fileDireciory, 1)) != null) {
                String str2 = packageArchiveInfo.versionName;
                if (!TextUtils.isEmpty(str2) && str2.compareTo(TbConfig.getVersion()) >= 0) {
                    z = true;
                    GetFile = FileHelper.GetFile(str);
                    if (GetFile == null && GetFile.exists() && z) {
                        UtilHelper.install_apk(TbadkCoreApplication.getInst().getApp(), str);
                        return true;
                    } else if (GetFile != null) {
                        GetFile.delete();
                    }
                }
            }
            z = false;
            GetFile = FileHelper.GetFile(str);
            if (GetFile == null) {
            }
            if (GetFile != null) {
            }
        }
        return false;
    }

    private void initData(Bundle bundle) {
        if (bundle != null) {
            try {
                try {
                    this.mData = (VersionData) bundle.getSerializable(UpdateDialogConfig.KEY_TIEBA_APK_DATA);
                    this.mCombineDownload = (CombineDownload) bundle.getSerializable(UpdateDialogConfig.KEY_OTHER_APK_DATA);
                } catch (Throwable unused) {
                    this.mData = (VersionData) bundle.getSerializable(UpdateDialogConfig.KEY_TIEBA_APK_DATA);
                    this.mCombineDownload = (CombineDownload) bundle.getSerializable(UpdateDialogConfig.KEY_OTHER_APK_DATA);
                }
            } catch (Throwable unused2) {
                this.mCombineDownload = null;
            }
            VersionData versionData = this.mData;
            if (versionData != null) {
                this.mAsUrl = versionData.getAsDownloadUrl();
            }
        } else {
            Intent intent = getIntent();
            if (intent != null) {
                try {
                    try {
                        this.mData = (VersionData) intent.getSerializableExtra(UpdateDialogConfig.KEY_TIEBA_APK_DATA);
                        this.mCombineDownload = (CombineDownload) intent.getSerializableExtra(UpdateDialogConfig.KEY_OTHER_APK_DATA);
                    } catch (Throwable unused3) {
                        this.mData = (VersionData) intent.getSerializableExtra(UpdateDialogConfig.KEY_TIEBA_APK_DATA);
                        this.mCombineDownload = (CombineDownload) intent.getSerializableExtra(UpdateDialogConfig.KEY_OTHER_APK_DATA);
                    }
                } catch (Throwable unused4) {
                    this.mCombineDownload = null;
                }
                VersionData versionData2 = this.mData;
                if (versionData2 != null) {
                    this.mAsUrl = versionData2.getAsDownloadUrl();
                }
            }
        }
        VersionData versionData3 = this.mData;
        if (versionData3 != null) {
            this.mIsForceUpdate = versionData3.forceUpdate();
        }
        j jVar = new j(getPageContext().getPageActivity(), R.style.common_alert_dialog);
        this.mSupportDialog = jVar;
        jVar.setCancelable(false);
        this.mSupportDialog.q(this.mData, this.mCombineDownload, new e(this, null));
        this.mSupportDialog.setOnCancelListener(new a());
        this.mSupportDialog.setOnDismissListener(new b());
        this.mSupportDialog.p(new c());
        this.mSupportDialog.u(new d());
        if (isFinishing()) {
            return;
        }
        g.j(this.mSupportDialog, getPageContext());
    }

    private void regBroadcast() {
        this.mUpadateBroadcast = new f(this, null);
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(TbConfig.APP_UPDATE_ACTION);
        registerReceiver(this.mUpadateBroadcast, intentFilter);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean startUpdate(boolean z, boolean z2, boolean z3) {
        CombineDownload combineDownload;
        VersionData versionData;
        if (!FileHelper.checkSD()) {
            showToast(FileHelper.getSdErrorString());
            return false;
        }
        Activity pageActivity = getPageContext().getPageActivity();
        if (this.mPermissionJudgement == null) {
            this.mPermissionJudgement = new PermissionJudgePolicy();
        }
        this.mPermissionJudgement.clearRequestPermissionList();
        this.mPermissionJudgement.appendRequestPermission(pageActivity, StorageUtils.EXTERNAL_STORAGE_PERMISSION);
        if (this.mPermissionJudgement.startRequestPermission(pageActivity)) {
            return false;
        }
        this.mDownloadTieba = z;
        this.mDownloadAs = z2;
        this.mDownloadOther = z3;
        Intent intent = new Intent(getPageContext().getPageActivity(), TiebaUpdateService.class);
        intent.addFlags(Label.FORWARD_REFERENCE_TYPE_SHORT);
        if (z && (versionData = this.mData) != null && URLUtil.isNetworkUrl(versionData.getUrl()) && !TextUtils.isEmpty(this.mData.getApkMD5RSA())) {
            intent.putExtra(UpdateDialogConfig.KEY_TIEBA_APK_URL, this.mData.getUrl());
            intent.putExtra(UpdateDialogConfig.KEY_TIEBA_APK_DATA, this.mData);
            intent.putExtra("MD5_RSA_tieba_apk", this.mData.getApkMD5RSA());
        }
        if (z2 && URLUtil.isNetworkUrl(this.mAsUrl) && !TextUtils.isEmpty(this.mData.getAsApkMD5RSA())) {
            intent.putExtra(UpdateDialogConfig.KEY_TIEBA_APK_DATA, this.mData);
            intent.putExtra(UpdateDialogConfig.KEY_AS_APK_URL, this.mAsUrl);
            intent.putExtra("MD5_RSA_as_apk", this.mData.getAsApkMD5RSA());
        }
        if (z3 && (combineDownload = this.mCombineDownload) != null && URLUtil.isNetworkUrl(combineDownload.getAppUrl()) && !TextUtils.isEmpty(this.mCombineDownload.getApkMD5RSA())) {
            intent.putExtra(UpdateDialogConfig.KEY_OTHER_APK_URL, this.mCombineDownload.getAppUrl());
            intent.putExtra("MD5_RSA_other_apk", this.mCombineDownload.getApkMD5RSA());
        }
        getPageContext().getPageActivity().startService(intent);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void stopUpdataService() {
        Intent intent = new Intent(getPageContext().getPageActivity(), TiebaUpdateService.class);
        intent.setAction("action_stop");
        getPageContext().getPageActivity().startService(intent);
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void closeAnimation() {
        ActivityPendingTransitionFactory.closeAnimation(getPageContext(), 0);
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void enterExitAnimation() {
        ActivityPendingTransitionFactory.enterExitAnimation(getPageContext(), 0);
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        j jVar = this.mSupportDialog;
        if (jVar != null) {
            jVar.m(getPageContext(), i);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setSwipeBackEnabled(false);
        WindowManager.LayoutParams attributes = getWindow().getAttributes();
        attributes.alpha = 0.0f;
        getWindow().setAttributes(attributes);
        initData(bundle);
        regBroadcast();
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        j jVar = this.mSupportDialog;
        if (jVar != null) {
            jVar.dismiss();
        }
        f fVar = this.mUpadateBroadcast;
        if (fVar != null) {
            unregisterReceiver(fVar);
        }
    }

    @Override // android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        VersionData versionData = this.mData;
        if (versionData != null) {
            bundle.putSerializable(UpdateDialogConfig.KEY_TIEBA_APK_DATA, versionData);
        }
        CombineDownload combineDownload = this.mCombineDownload;
        if (combineDownload != null) {
            bundle.putSerializable(UpdateDialogConfig.KEY_OTHER_APK_DATA, combineDownload);
        }
    }
}
