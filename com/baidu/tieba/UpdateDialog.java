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
import com.baidu.android.imsdk.internal.Constants;
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
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.sdk.core.imageloader.utils.StorageUtils;
import d.a.d.e.m.g;
import d.a.q0.l;
import d.a.q0.n;
import java.io.File;
/* loaded from: classes3.dex */
public class UpdateDialog extends BaseActivity<UpdateDialog> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
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
    public l mSupportDialog;
    public f mUpadateBroadcast;

    /* loaded from: classes3.dex */
    public class a implements DialogInterface.OnCancelListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ UpdateDialog f13720e;

        public a(UpdateDialog updateDialog) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {updateDialog};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f13720e = updateDialog;
        }

        @Override // android.content.DialogInterface.OnCancelListener
        public void onCancel(DialogInterface dialogInterface) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, dialogInterface) == null) {
                this.f13720e.mSupportDialog.dismiss();
                this.f13720e.finish();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b implements DialogInterface.OnDismissListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ UpdateDialog f13721e;

        /* loaded from: classes3.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ b f13722e;

            public a(b bVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {bVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f13722e = bVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.f13722e.f13721e.mData.forceUpdate()) {
                    d.a.p0.s.a0.b.e(this.f13722e.f13721e.getPageContext().getPageActivity(), 200);
                }
            }
        }

        public b(UpdateDialog updateDialog) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {updateDialog};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f13721e = updateDialog;
        }

        @Override // android.content.DialogInterface.OnDismissListener
        public void onDismiss(DialogInterface dialogInterface) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, dialogInterface) == null) {
                this.f13721e.mSupportDialog.dismiss();
                this.f13721e.mHandler.postDelayed(new a(this), 100L);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class c implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ UpdateDialog f13723e;

        public c(UpdateDialog updateDialog) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {updateDialog};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f13723e = updateDialog;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                if (this.f13723e.mIsDownloading) {
                    this.f13723e.stopUpdataService();
                }
                this.f13723e.mSupportDialog.dismiss();
                this.f13723e.finish();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class d implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ UpdateDialog f13724e;

        public d(UpdateDialog updateDialog) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {updateDialog};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f13724e = updateDialog;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f13724e.mSupportDialog.r();
                UpdateDialog updateDialog = this.f13724e;
                updateDialog.startUpdate(updateDialog.mDownloadTieba, this.f13724e.mDownloadAs, this.f13724e.mDownloadOther);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class e implements l.f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ UpdateDialog f13725a;

        public e(UpdateDialog updateDialog) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {updateDialog};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f13725a = updateDialog;
        }

        @Override // d.a.q0.l.f
        public void a(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
                this.f13725a.mIsDownloading = true;
                UpdateDialog updateDialog = this.f13725a;
                if (updateDialog.startUpdate(true, false, z && n.d(updateDialog.getPageContext().getPageActivity(), this.f13725a.mCombineDownload))) {
                    this.f13725a.mSupportDialog.t(false);
                    this.f13725a.showToast(R.string.download_begin_tip);
                    if (this.f13725a.mIsForceUpdate) {
                        return;
                    }
                    this.f13725a.mSupportDialog.dismiss();
                    this.f13725a.finish();
                }
            }
        }

        @Override // d.a.q0.l.f
        public void b(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) {
                if (this.f13725a.checkMainApkExist()) {
                    this.f13725a.mSupportDialog.dismiss();
                    this.f13725a.finish();
                    return;
                }
                boolean z2 = true;
                if (n.c(this.f13725a.getPageContext().getPageActivity().getPackageManager())) {
                    n.b(this.f13725a.getPageContext().getPageActivity(), this.f13725a.mData);
                    UpdateDialog updateDialog = this.f13725a;
                    updateDialog.startUpdate(false, false, (z && n.d(updateDialog.getPageContext().getPageActivity(), this.f13725a.mCombineDownload)) ? false : false);
                } else {
                    UpdateDialog updateDialog2 = this.f13725a;
                    updateDialog2.startUpdate(false, true, z && n.d(updateDialog2.getPageContext().getPageActivity(), this.f13725a.mCombineDownload));
                }
                if (this.f13725a.mIsForceUpdate) {
                    return;
                }
                this.f13725a.mSupportDialog.dismiss();
                this.f13725a.finish();
            }
        }

        @Override // d.a.q0.l.f
        public void c() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                this.f13725a.stopUpdataService();
            }
        }

        @Override // d.a.q0.l.f
        public void d() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
                this.f13725a.finish();
            }
        }

        @Override // d.a.q0.l.f
        public void e() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
                this.f13725a.mSupportDialog.dismiss();
                this.f13725a.finish();
            }
        }

        public /* synthetic */ e(UpdateDialog updateDialog, a aVar) {
            this(updateDialog);
        }
    }

    /* loaded from: classes3.dex */
    public class f extends BroadcastReceiver {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ UpdateDialog this$0;

        public f(UpdateDialog updateDialog) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {updateDialog};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = updateDialog;
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, context, intent) == null) {
                this.this$0.mIsBackgroundDownloading = intent.getBooleanExtra("action_background_downloading", false);
                if (this.this$0.mIsBackgroundDownloading) {
                    this.this$0.showToast(R.string.background_updating);
                    this.this$0.mSupportDialog.dismiss();
                    this.this$0.finish();
                } else if (intent.getBooleanExtra("action_update_complete", false)) {
                    this.this$0.mSupportDialog.dismiss();
                    this.this$0.finish();
                } else if (intent.getBooleanExtra("action_update_progress_interrupted", false)) {
                    this.this$0.mSupportDialog.dismiss();
                    UpdateDialog updateDialog = this.this$0;
                    updateDialog.showToast(updateDialog.getPageContext().getString(R.string.update_app_error));
                    this.this$0.finish();
                    this.this$0.stopUpdataService();
                } else {
                    int intExtra = intent.getIntExtra("action_update_download_progress", 0);
                    if (this.this$0.mSupportDialog != null) {
                        this.this$0.mSupportDialog.v(intExtra);
                    }
                }
            }
        }

        public /* synthetic */ f(UpdateDialog updateDialog, a aVar) {
            this(updateDialog);
        }
    }

    public UpdateDialog() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0091  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean checkMainApkExist() {
        InterceptResult invokeV;
        boolean z;
        File GetFile;
        PackageInfo packageArchiveInfo;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65551, this)) == null) {
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
        return invokeV.booleanValue;
    }

    private void initData(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65552, this, bundle) == null) {
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
            l lVar = new l(getPageContext().getPageActivity(), R.style.common_alert_dialog);
            this.mSupportDialog = lVar;
            lVar.setCancelable(false);
            this.mSupportDialog.q(this.mData, this.mCombineDownload, new e(this, null));
            this.mSupportDialog.setOnCancelListener(new a(this));
            this.mSupportDialog.setOnDismissListener(new b(this));
            this.mSupportDialog.p(new c(this));
            this.mSupportDialog.u(new d(this));
            if (isFinishing()) {
                return;
            }
            g.j(this.mSupportDialog, getPageContext());
        }
    }

    private void regBroadcast() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65553, this) == null) {
            this.mUpadateBroadcast = new f(this, null);
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction(TbConfig.APP_UPDATE_ACTION);
            registerReceiver(this.mUpadateBroadcast, intentFilter);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean startUpdate(boolean z, boolean z2, boolean z3) {
        InterceptResult invokeCommon;
        CombineDownload combineDownload;
        VersionData versionData;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65554, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2), Boolean.valueOf(z3)})) == null) {
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
        return invokeCommon.booleanValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void stopUpdataService() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65555, this) == null) {
            Intent intent = new Intent(getPageContext().getPageActivity(), TiebaUpdateService.class);
            intent.setAction("action_stop");
            getPageContext().getPageActivity().startService(intent);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void closeAnimation() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            ActivityPendingTransitionFactory.closeAnimation(getPageContext(), 0);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void enterExitAnimation() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            ActivityPendingTransitionFactory.enterExitAnimation(getPageContext(), 0);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2) == null) {
            super.onChangeSkinType(i2);
            l lVar = this.mSupportDialog;
            if (lVar != null) {
                lVar.m(getPageContext(), i2);
            }
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, bundle) == null) {
            super.onCreate(bundle);
            setSwipeBackEnabled(false);
            WindowManager.LayoutParams attributes = getWindow().getAttributes();
            attributes.alpha = 0.0f;
            getWindow().setAttributes(attributes);
            initData(bundle);
            regBroadcast();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            super.onDestroy();
            l lVar = this.mSupportDialog;
            if (lVar != null) {
                lVar.dismiss();
            }
            f fVar = this.mUpadateBroadcast;
            if (fVar != null) {
                unregisterReceiver(fVar);
            }
        }
    }

    @Override // android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, bundle) == null) {
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
}
