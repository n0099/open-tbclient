package com.baidu.tieba.aiapps.apps.launch;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mytransformapp.util.LogUtil;
import com.baidu.tbadk.core.util.PermissionUtil;
import com.baidu.tieba.aiapps.apps.abtest.SwanAppAbTestStatic;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.td3;
import com.repackage.w8;
import com.repackage.wl5;
import com.repackage.wm3;
/* loaded from: classes3.dex */
public class SwanEntryActivity extends Activity {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String LAUNCHER_URI = "SWAN_URI";
    public static final String SWAN_ACTION = "com.baidu.swan.launcher";
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes3.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ SwanEntryActivity a;

        public a(SwanEntryActivity swanEntryActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {swanEntryActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = swanEntryActivity;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.finish();
            }
        }
    }

    public SwanEntryActivity() {
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

    private void doLaunch() {
        Intent intent;
        String uri;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65537, this) == null) || (intent = getIntent()) == null) {
            return;
        }
        if (TextUtils.equals(intent.getAction(), SWAN_ACTION)) {
            uri = intent.getStringExtra(LAUNCHER_URI);
        } else {
            Uri data = intent.getData();
            uri = data == null ? null : data.toString();
        }
        if (TextUtils.isEmpty(uri)) {
            return;
        }
        if (!PermissionUtil.isAgreePrivacyPolicy()) {
            SwanAppAbTestStatic.a = uri;
            return;
        }
        wl5.a();
        wm3.a(uri);
    }

    @Override // android.app.Activity
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, bundle) == null) {
            w8.b(this);
            super.onCreate(bundle);
            if (td3.a(this)) {
                LogUtil.logActivity(this, "onCreate");
                return;
            }
            doLaunch();
            LogUtil.logActivity(this, "onCreate");
        }
    }

    @Override // android.app.Activity
    public void onNewIntent(Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, intent) == null) {
            super.onNewIntent(intent);
            doLaunch();
        }
    }

    @Override // android.app.Activity
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            super.onResume();
            runOnUiThread(new a(this));
        }
    }

    @Override // android.app.Activity
    public void setRequestedOrientation(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048579, this, i) == null) {
            if (w8.d(this) && w8.a(i)) {
                return;
            }
            super.setRequestedOrientation(i);
        }
    }
}
