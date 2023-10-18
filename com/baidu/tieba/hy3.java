package com.baidu.tieba;

import android.content.ComponentName;
import android.content.Intent;
import android.os.Build;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Locale;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class hy3 extends vx3 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean c;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947840007, "Lcom/baidu/tieba/hy3;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947840007, "Lcom/baidu/tieba/hy3;");
                return;
            }
        }
        c = am1.a;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public hy3() {
        super("startPermissionsPage");
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((String) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    @Override // com.baidu.tieba.vx3
    public qx1 a(JSONObject jSONObject, ti2 ti2Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, jSONObject, ti2Var)) == null) {
            p53 c0 = p53.c0();
            if (c0 != null && c0.w() != null) {
                String str = Build.MANUFACTURER;
                if (!TextUtils.isEmpty(str)) {
                    str = str.toLowerCase(Locale.US);
                }
                if (TextUtils.equals(str, "oppo")) {
                    try {
                        Intent intent = new Intent(c0.w().getPackageName());
                        intent.setComponent(new ComponentName("com.oppo.launcher", "com.oppo.launcher.shortcut.ShortcutSettingsActivity"));
                        c0.w().startActivity(intent);
                    } catch (Exception e) {
                        if (c) {
                            e.printStackTrace();
                        }
                        ti3.f(c0.w());
                    }
                } else {
                    ti3.g(c0.w());
                }
                ti2Var.onSuccess(null);
            } else if (c) {
                Log.d("StartPermissionsPage", "swan or activity is null");
            }
            return null;
        }
        return (qx1) invokeLL.objValue;
    }
}
