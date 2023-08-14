package com.baidu.tieba.gameassist.permission;

import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.Settings;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import androidx.annotation.NonNull;
import com.baidu.adp.lib.util.BdUtilHelper;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.yy.gameassist.interfaces.PermissionService;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.util.permission.PermissionJudgePolicy;
import com.baidu.tieba.R;
import com.baidu.tieba.bw7;
import com.baidu.tieba.j71;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.webkit.sdk.WebChromeClient;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes6.dex */
public class PermissionFragmentActivity extends BaseFragmentActivity {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public PermissionService.IGrantCallback a;
    public final List<String> b;
    public String[] c;
    public boolean d;

    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    public void onChangeSkinType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i) == null) {
        }
    }

    /* loaded from: classes6.dex */
    public class a implements PermissionJudgePolicy.OnPermissionsGrantedListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PermissionFragmentActivity a;

        public a(PermissionFragmentActivity permissionFragmentActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {permissionFragmentActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = permissionFragmentActivity;
        }

        @Override // com.baidu.tbadk.core.util.permission.PermissionJudgePolicy.OnPermissionsGrantedListener
        public void onPermissionsGranted() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.a.onResult(true);
                this.a.finish();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b implements PermissionJudgePolicy.PermissionDialogClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PermissionFragmentActivity a;

        public b(PermissionFragmentActivity permissionFragmentActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {permissionFragmentActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = permissionFragmentActivity;
        }

        @Override // com.baidu.tbadk.core.util.permission.PermissionJudgePolicy.PermissionDialogClickListener
        public void onDialogCaneled(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                this.a.finish();
            }
        }

        @Override // com.baidu.tbadk.core.util.permission.PermissionJudgePolicy.PermissionDialogClickListener
        public void onDialogComfirmed(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
                this.a.finish();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class c implements PermissionJudgePolicy.IExtraDialogCloseCallback {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PermissionFragmentActivity a;

        public c(PermissionFragmentActivity permissionFragmentActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {permissionFragmentActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = permissionFragmentActivity;
        }

        @Override // com.baidu.tbadk.core.util.permission.PermissionJudgePolicy.IExtraDialogCloseCallback
        public void onClose() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.a.onResult(false);
                this.a.finish();
            }
        }
    }

    public PermissionFragmentActivity() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.b = new ArrayList();
        this.d = false;
    }

    @Override // android.view.Window.Callback
    public void onPointerCaptureChanged(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048579, this, z) == null) {
            super.onPointerCaptureChanged(z);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIL(1048576, this, i, i2, intent) == null) {
            super.onActivityResult(i, i2, intent);
            PermissionService.IGrantCallback iGrantCallback = this.a;
            if (iGrantCallback == null) {
                finish();
            } else if (i == 12016) {
                if (Build.VERSION.SDK_INT >= 23) {
                    iGrantCallback.onResult(Settings.canDrawOverlays(this));
                    finish();
                }
                this.a = null;
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, bundle) == null) {
            getWindow().getDecorView().setSystemUiVisibility(260);
            getWindow().setStatusBarColor(0);
            requestWindowFeature(1);
            overridePendingTransition(0, 0);
            super.onCreate(bundle);
            setSwipeBackEnabled(false);
            setActivityBgTransparent();
            setContentView(new View(this));
            Window window = getWindow();
            window.setGravity(51);
            WindowManager.LayoutParams attributes = window.getAttributes();
            attributes.x = 0;
            attributes.y = 0;
            attributes.height = 1;
            attributes.width = 1;
            window.setAttributes(attributes);
            Intent intent = getIntent();
            String stringExtra = intent.getStringExtra("request");
            this.c = intent.getStringArrayExtra("permissions");
            int intExtra = intent.getIntExtra(WebChromeClient.KEY_ARG_CALLBACK, 0);
            this.a = (PermissionService.IGrantCallback) bw7.a.get(Integer.valueOf(intExtra));
            bw7.a.remove(Integer.valueOf(intExtra));
            if (stringExtra != null) {
                if (stringExtra.equals("requestFloatPermission")) {
                    t1();
                } else if (stringExtra.equals("requestPermissions")) {
                    u1();
                }
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, androidx.fragment.app.FragmentActivity, android.app.Activity, androidx.core.app.ActivityCompat.OnRequestPermissionsResultCallback
    public void onRequestPermissionsResult(int i, @NonNull String[] strArr, @NonNull int[] iArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeILL(1048580, this, i, strArr, iArr) == null) {
            super.onRequestPermissionsResult(i, strArr, iArr);
            if (this.a == null) {
                return;
            }
            if (25040 == i) {
                if (Build.VERSION.SDK_INT >= 23) {
                    for (int i2 = 0; i2 < iArr.length; i2++) {
                        if (iArr[i2] == -1) {
                            this.a.onResult(false);
                            this.a = null;
                            PermissionJudgePolicy permissionJudgePolicy = this.mCurrentPermissionJudgePolicy;
                            if (permissionJudgePolicy != null) {
                                this.d = permissionJudgePolicy.checkPermissionForbidden(this, strArr[i2]);
                            }
                            if (this.d) {
                                finish();
                                return;
                            }
                            return;
                        }
                    }
                    this.a.onResult(true);
                }
                this.a = null;
            }
            finish();
        }
    }

    public void t1() {
        PermissionService.IGrantCallback iGrantCallback;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048581, this) != null) || (iGrantCallback = this.a) == null) {
            return;
        }
        if (Build.VERSION.SDK_INT >= 23) {
            if (Settings.canDrawOverlays(this)) {
                PermissionService.IGrantCallback iGrantCallback2 = this.a;
                if (iGrantCallback2 != null) {
                    iGrantCallback2.onResult(true);
                    finish();
                    return;
                }
                return;
            }
            try {
                Intent intent = new Intent("android.settings.action.MANAGE_OVERLAY_PERMISSION");
                intent.setData(Uri.parse("package:" + getPackageName()));
                startActivityForResult(intent, 12016);
                return;
            } catch (Exception unused) {
                BdUtilHelper.showToast(this, (int) R.string.request_window_permission_default_text_by_yourself);
                PermissionService.IGrantCallback iGrantCallback3 = this.a;
                if (iGrantCallback3 != null) {
                    iGrantCallback3.onResult(false);
                    finish();
                    return;
                }
                return;
            }
        }
        iGrantCallback.onResult(true);
        finish();
    }

    public void u1() {
        String[] strArr;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048582, this) == null) && this.a != null && this.c != null) {
            this.b.clear();
            if (Build.VERSION.SDK_INT >= 23) {
                for (String str : this.c) {
                    if (j71.a(this, str) != 0) {
                        this.b.add(str);
                    }
                }
                if (this.b.size() > 0) {
                    PermissionJudgePolicy permissionJudgePolicy = new PermissionJudgePolicy();
                    permissionJudgePolicy.clearRequestPermissionList();
                    for (int i = 0; i < this.b.size(); i++) {
                        permissionJudgePolicy.appendRequestPermission(getActivity(), this.b.get(i));
                    }
                    permissionJudgePolicy.setOnPermissionsGrantedListener(new a(this));
                    permissionJudgePolicy.setDialogClickListener(new b(this));
                    permissionJudgePolicy.startRequestPermission(getActivity(), 25040, PermissionJudgePolicy.EXTRA_DIALOG_REFUSE_POLICY.Reject_all, new c(this));
                    return;
                }
                this.a.onResult(true);
                finish();
            }
        }
    }
}
