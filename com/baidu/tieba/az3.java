package com.baidu.tieba;

import android.content.Intent;
import android.widget.Toast;
import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class az3 extends zz3 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public az3() {
        super("openSpaceCleanActivity");
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((String) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    @Override // com.baidu.tieba.zz3
    public tz1 a(@NonNull JSONObject jSONObject, @NonNull xk2 xk2Var) {
        InterceptResult invokeLL;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, jSONObject, xk2Var)) == null) {
            if (cl3.m()) {
                z = b("com.huawei.systemmanager", "com.huawei.systemmanager.appfeature.spacecleaner.SpaceCleanActivity");
            } else if (cl3.n()) {
                z = b("com.miui.cleanmaster", "com.miui.optimizecenter.MainActivity");
            } else if (cl3.o()) {
                z = b("com.coloros.phonemanager", "com.coloros.phonemanager.clear.ClearActivity");
            } else if (cl3.r()) {
                z = b("com.iqoo.secure", "com.iqoo.secure.clean.PhoneCleanActivity2");
            } else {
                z = false;
            }
            if (!z) {
                Toast.makeText(ar2.c(), (int) R.string.obfuscated_res_0x7f0f0192, 0).show();
            }
            xk2Var.a(null);
            return null;
        }
        return (tz1) invokeLL.objValue;
    }

    public final boolean b(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, str2)) == null) {
            Intent intent = new Intent();
            intent.setClassName(str, str2);
            return ck3.i(ar2.c(), intent, true, false);
        }
        return invokeLL.booleanValue;
    }
}
