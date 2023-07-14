package com.baidu.tieba.aiapps.apps.launch;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.atomData.LogoActivityConfig;
import com.baidu.tbadk.core.util.PermissionUtil;
import com.baidu.tieba.aiapps.apps.abtest.SwanAppAbTestStatic;
import com.baidu.tieba.ca6;
import com.baidu.tieba.g9;
import com.baidu.tieba.h9;
import com.baidu.tieba.uo3;
import com.baidu.tieba.yx3;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class SwanEntryActivity extends Activity {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes5.dex */
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

    @Override // android.app.Activity
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            super.onResume();
            runOnUiThread(new a(this));
        }
    }

    public final void a() {
        Intent intent;
        String uri;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048576, this) != null) || (intent = getIntent()) == null) {
            return;
        }
        if (TextUtils.equals(intent.getAction(), "com.baidu.swan.launcher")) {
            uri = intent.getStringExtra("SWAN_URI");
        } else {
            Uri data = intent.getData();
            if (data == null) {
                uri = null;
            } else {
                uri = data.toString();
            }
        }
        if (TextUtils.isEmpty(uri)) {
            return;
        }
        if (!PermissionUtil.isAgreePrivacyPolicy()) {
            SwanAppAbTestStatic.a = uri;
        } else if (!h9.f().h("MainTabActivity")) {
            LogoActivityConfig logoActivityConfig = new LogoActivityConfig(this, intent);
            intent.setData(Uri.parse(uri));
            logoActivityConfig.getIntent().putExtra(LogoActivityConfig.IS_DEAL_INTENT, true);
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, logoActivityConfig));
        } else {
            ca6.a();
            yx3.a(uri);
        }
    }

    @Override // android.app.Activity
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bundle) == null) {
            g9.b(this);
            super.onCreate(bundle);
            if (uo3.a(this)) {
                return;
            }
            a();
        }
    }

    @Override // android.app.Activity
    public void onNewIntent(Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, intent) == null) {
            super.onNewIntent(intent);
            a();
        }
    }

    @Override // android.app.Activity
    public void setRequestedOrientation(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048580, this, i) == null) {
            if (g9.d(this) && g9.a(i)) {
                return;
            }
            super.setRequestedOrientation(i);
        }
    }
}
