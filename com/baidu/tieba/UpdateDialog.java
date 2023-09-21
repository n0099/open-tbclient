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
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.log.DefaultLog;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.nps.utils.Constant;
import com.baidu.searchbox.performance.speed.task.LaunchTaskConstants;
import com.baidu.tbadk.ActivityPendingTransitionFactory;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.LogoActivityConfig;
import com.baidu.tbadk.core.atomData.MainTabActivityConfig;
import com.baidu.tbadk.core.atomData.UpdateDialogConfig;
import com.baidu.tbadk.core.dialog.yun.YunDialogManager;
import com.baidu.tbadk.core.mainentrance.MainEntrance;
import com.baidu.tbadk.core.util.FileHelper;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.permission.PermissionJudgePolicy;
import com.baidu.tbadk.coreExtra.data.CombineDownload;
import com.baidu.tbadk.coreExtra.data.VersionData;
import com.baidu.tieba.g56;
import com.baidu.tieba.log.TbLog;
import com.baidu.tieba.service.TiebaUpdateService;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
/* loaded from: classes5.dex */
public class UpdateDialog extends BaseActivity<UpdateDialog> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean a;
    public boolean b;
    public boolean c;
    public boolean d;
    public boolean e;
    public boolean f;
    public VersionData g;
    public CombineDownload h;
    public String i;
    public g56 j;
    public f k;
    public PermissionJudgePolicy l;

    /* loaded from: classes5.dex */
    public class b implements DialogInterface.OnDismissListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ UpdateDialog a;

        /* loaded from: classes5.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ b a;

            public a(b bVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {bVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = bVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.a.a.g.forceUpdate()) {
                    MainEntrance.goToMainTab(this.a.a.getPageContext().getPageActivity(), 200);
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
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = updateDialog;
        }

        @Override // android.content.DialogInterface.OnDismissListener
        public void onDismiss(DialogInterface dialogInterface) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, dialogInterface) == null) {
                this.a.j.dismiss();
                this.a.mHandler.postDelayed(new a(this), 100L);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class a implements DialogInterface.OnCancelListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ UpdateDialog a;

        public a(UpdateDialog updateDialog) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {updateDialog};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = updateDialog;
        }

        @Override // android.content.DialogInterface.OnCancelListener
        public void onCancel(DialogInterface dialogInterface) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, dialogInterface) == null) {
                this.a.j.dismiss();
                this.a.finish();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class c implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ UpdateDialog a;

        public c(UpdateDialog updateDialog) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {updateDialog};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = updateDialog;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                if (this.a.a) {
                    this.a.j1();
                }
                this.a.j.dismiss();
                this.a.finish();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class d implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ UpdateDialog a;

        public d(UpdateDialog updateDialog) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {updateDialog};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = updateDialog;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                this.a.j.r();
                UpdateDialog updateDialog = this.a;
                updateDialog.i1(updateDialog.c, this.a.d, this.a.e);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class e implements g56.f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ UpdateDialog a;

        public e(UpdateDialog updateDialog) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {updateDialog};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = updateDialog;
        }

        public /* synthetic */ e(UpdateDialog updateDialog, a aVar) {
            this(updateDialog);
        }

        @Override // com.baidu.tieba.g56.f
        public void a(boolean z) {
            boolean z2;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
                TiebaStatic.log(new StatisticItem("c14382").addParam("obj_locate", 1));
                this.a.a = true;
                UpdateDialog updateDialog = this.a;
                if (z && j56.c(updateDialog.getPageContext().getPageActivity(), this.a.h)) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                if (!updateDialog.i1(true, false, z2)) {
                    return;
                }
                this.a.j.t(false);
                this.a.showToast(R.string.download_begin_tip);
                if (!this.a.f) {
                    this.a.j.dismiss();
                    this.a.finish();
                }
            }
        }

        @Override // com.baidu.tieba.g56.f
        public void b(boolean z) {
            boolean z2;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) {
                if (this.a.f1()) {
                    this.a.j.dismiss();
                    this.a.finish();
                    return;
                }
                UpdateDialog updateDialog = this.a;
                if (z && j56.c(updateDialog.getPageContext().getPageActivity(), this.a.h)) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                updateDialog.i1(false, true, z2);
                if (!this.a.f) {
                    this.a.j.dismiss();
                    this.a.finish();
                }
            }
        }

        @Override // com.baidu.tieba.g56.f
        public void c() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                TiebaStatic.log(new StatisticItem("c14382").addParam("obj_locate", 2));
                this.a.finish();
            }
        }

        @Override // com.baidu.tieba.g56.f
        public void d() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
                TiebaStatic.log(new StatisticItem("c14382").addParam("obj_locate", 2));
                this.a.j.dismiss();
                this.a.finish();
            }
        }

        @Override // com.baidu.tieba.g56.f
        public void stopService() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
                this.a.j1();
            }
        }
    }

    /* loaded from: classes5.dex */
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
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = updateDialog;
        }

        public /* synthetic */ f(UpdateDialog updateDialog, a aVar) {
            this(updateDialog);
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, context, intent) == null) {
                this.this$0.b = intent.getBooleanExtra("action_background_downloading", false);
                if (this.this$0.b) {
                    this.this$0.showToast(R.string.background_updating);
                    this.this$0.j.dismiss();
                    this.this$0.finish();
                } else if (intent.getBooleanExtra("action_update_complete", false)) {
                    this.this$0.j.dismiss();
                    this.this$0.finish();
                } else if (intent.getBooleanExtra("action_update_progress_interrupted", false)) {
                    this.this$0.j.dismiss();
                    UpdateDialog updateDialog = this.this$0;
                    updateDialog.showToast(updateDialog.getPageContext().getString(R.string.update_app_error));
                    this.this$0.finish();
                    this.this$0.j1();
                } else {
                    int intExtra = intent.getIntExtra("action_update_download_progress", 0);
                    if (this.this$0.j != null) {
                        this.this$0.j.v(intExtra);
                    }
                }
            }
        }
    }

    public UpdateDialog() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
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

    public final void h1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            this.k = new f(this, null);
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction(TbConfig.APP_UPDATE_ACTION);
            registerReceiver(this.k, intentFilter);
        }
    }

    public final void j1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            Intent intent = new Intent(getPageContext().getPageActivity(), TiebaUpdateService.class);
            intent.setAction("action_stop");
            getPageContext().getPageActivity().startService(intent);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            super.onDestroy();
            YunDialogManager.unMarkShowingDialogName("updateDialog");
            g56 g56Var = this.j;
            if (g56Var != null) {
                g56Var.dismiss();
            }
            f fVar = this.k;
            if (fVar != null) {
                unregisterReceiver(fVar);
            }
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048583, this, i) == null) {
            super.onChangeSkinType(i);
            g56 g56Var = this.j;
            if (g56Var != null) {
                g56Var.m(getPageContext(), i);
            }
        }
    }

    @Override // android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, bundle) == null) {
            super.onSaveInstanceState(bundle);
            VersionData versionData = this.g;
            if (versionData != null) {
                bundle.putSerializable(UpdateDialogConfig.KEY_TIEBA_APK_DATA, versionData);
            }
            CombineDownload combineDownload = this.h;
            if (combineDownload != null) {
                bundle.putSerializable(UpdateDialogConfig.KEY_OTHER_APK_DATA, combineDownload);
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:29:0x0092  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final boolean f1() {
        InterceptResult invokeV;
        boolean z;
        File GetFile;
        PackageInfo packageArchiveInfo;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            VersionData versionData = this.g;
            if (versionData != null && !StringUtils.isNull(versionData.getUrl()) && URLUtil.isNetworkUrl(this.g.getUrl())) {
                String str = getPageContext().getString(R.string.obfuscated_res_0x7f0f029e) + TbadkCoreApplication.getInst().getVersionName() + Constant.FILE.SUFFIX.BUNDLE_SUFFIX;
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

    public final void g1(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, bundle) == null) {
            if (bundle != null) {
                try {
                    try {
                        this.g = (VersionData) bundle.getSerializable(UpdateDialogConfig.KEY_TIEBA_APK_DATA);
                        this.h = (CombineDownload) bundle.getSerializable(UpdateDialogConfig.KEY_OTHER_APK_DATA);
                    } catch (Throwable unused) {
                        this.g = (VersionData) bundle.getSerializable(UpdateDialogConfig.KEY_TIEBA_APK_DATA);
                        this.h = (CombineDownload) bundle.getSerializable(UpdateDialogConfig.KEY_OTHER_APK_DATA);
                    }
                } catch (Throwable unused2) {
                    this.h = null;
                }
                VersionData versionData = this.g;
                if (versionData != null) {
                    this.i = versionData.getAsDownloadUrl();
                }
            } else {
                Intent intent = getIntent();
                if (intent != null) {
                    try {
                        try {
                            this.g = (VersionData) intent.getSerializableExtra(UpdateDialogConfig.KEY_TIEBA_APK_DATA);
                            this.h = (CombineDownload) intent.getSerializableExtra(UpdateDialogConfig.KEY_OTHER_APK_DATA);
                        } catch (Throwable unused3) {
                            this.g = (VersionData) intent.getSerializableExtra(UpdateDialogConfig.KEY_TIEBA_APK_DATA);
                            this.h = (CombineDownload) intent.getSerializableExtra(UpdateDialogConfig.KEY_OTHER_APK_DATA);
                        }
                    } catch (Throwable unused4) {
                        this.h = null;
                    }
                    VersionData versionData2 = this.g;
                    if (versionData2 != null) {
                        this.i = versionData2.getAsDownloadUrl();
                    }
                }
            }
            VersionData versionData3 = this.g;
            if (versionData3 != null) {
                this.f = versionData3.forceUpdate();
            }
            g56 g56Var = new g56(getPageContext().getPageActivity(), R.style.obfuscated_res_0x7f1003ca);
            this.j = g56Var;
            g56Var.setCancelable(false);
            this.j.q(this.g, this.h, new e(this, null));
            this.j.setOnCancelListener(new a(this));
            this.j.setOnDismissListener(new b(this));
            this.j.p(new c(this));
            this.j.u(new d(this));
            if (!isFinishing()) {
                jg.j(this.j, getPageContext());
            }
        }
    }

    public final boolean i1(boolean z, boolean z2, boolean z3) {
        InterceptResult invokeCommon;
        CombineDownload combineDownload;
        VersionData versionData;
        VersionData versionData2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048581, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2), Boolean.valueOf(z3)})) == null) {
            if (!FileHelper.checkSD()) {
                showToast(FileHelper.getSdErrorString());
                return false;
            }
            Activity pageActivity = getPageContext().getPageActivity();
            if (this.l == null) {
                this.l = new PermissionJudgePolicy();
            }
            this.l.clearRequestPermissionList();
            this.l.appendRequestPermission(pageActivity, "android.permission.WRITE_EXTERNAL_STORAGE");
            if (this.l.startRequestPermission(pageActivity)) {
                return false;
            }
            this.c = z;
            this.d = z2;
            this.e = z3;
            Intent intent = new Intent(getPageContext().getPageActivity(), TiebaUpdateService.class);
            intent.addFlags(LaunchTaskConstants.OTHER_PROCESS);
            if (z && (versionData2 = this.g) != null && URLUtil.isNetworkUrl(versionData2.getUrl()) && !TextUtils.isEmpty(this.g.getApkMD5RSA())) {
                intent.putExtra("key_tieba_apk_url", this.g.getUrl());
                intent.putExtra(UpdateDialogConfig.KEY_TIEBA_APK_DATA, this.g);
                intent.putExtra("MD5_RSA_tieba_apk", this.g.getApkMD5RSA());
            }
            if (z2 && URLUtil.isNetworkUrl(this.i) && (versionData = this.g) != null && !TextUtils.isEmpty(versionData.getAsApkMD5RSA())) {
                intent.putExtra(UpdateDialogConfig.KEY_TIEBA_APK_DATA, this.g);
                intent.putExtra("as_apk_url", this.i);
                intent.putExtra("MD5_RSA_as_apk", this.g.getAsApkMD5RSA());
            }
            if (z3 && (combineDownload = this.h) != null && URLUtil.isNetworkUrl(combineDownload.getAppUrl()) && !TextUtils.isEmpty(this.h.getApkMD5RSA())) {
                intent.putExtra("other_apk_url", this.h.getAppUrl());
                intent.putExtra("MD5_RSA_other_apk", this.h.getApkMD5RSA());
            }
            getPageContext().getPageActivity().startService(intent);
            return true;
        }
        return invokeCommon.booleanValue;
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, bundle) == null) {
            super.onCreate(bundle);
            YunDialogManager.markShowingDialogName("updateDialog");
            setSwipeBackEnabled(false);
            WindowManager.LayoutParams attributes = getWindow().getAttributes();
            attributes.alpha = 0.0f;
            getWindow().setAttributes(attributes);
            g1(bundle);
            h1();
            TiebaStatic.log(new StatisticItem("c14383").addParam("obj_locate", 1));
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            super.onResume();
            if (TbSingleton.getInstance().isSplashShowing()) {
                TbLog defaultLog = DefaultLog.getInstance();
                defaultLog.e("BaseActivity", "resume UpdateDialog failed，because of splash showing. IS_MAIN_TAB_SPLASH_SHOW=" + MainTabActivityConfig.IS_MAIN_TAB_SPLASH_SHOW + ", IS_HOT_SPLASH_SHOW=" + LogoActivityConfig.IS_HOT_SPLASH_SHOW);
                finish();
            }
        }
    }
}
