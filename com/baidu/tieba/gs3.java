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
/* loaded from: classes4.dex */
public class gs3 extends ft3 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public gs3() {
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

    @Override // com.baidu.tieba.ft3
    public at1 a(@NonNull JSONObject jSONObject, @NonNull ee2 ee2Var) {
        InterceptResult invokeLL;
        boolean b;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, jSONObject, ee2Var)) == null) {
            if (je3.m()) {
                b = b("com.huawei.systemmanager", "com.huawei.systemmanager.appfeature.spacecleaner.SpaceCleanActivity");
            } else if (je3.n()) {
                b = b("com.miui.cleanmaster", "com.miui.optimizecenter.MainActivity");
            } else if (je3.o()) {
                b = b("com.coloros.phonemanager", "com.coloros.phonemanager.clear.ClearActivity");
            } else {
                b = je3.r() ? b("com.iqoo.secure", "com.iqoo.secure.clean.PhoneCleanActivity2") : false;
            }
            if (!b) {
                Toast.makeText(hk2.c(), (int) R.string.obfuscated_res_0x7f0f018e, 0).show();
            }
            ee2Var.a(null);
            return null;
        }
        return (at1) invokeLL.objValue;
    }

    public final boolean b(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, str2)) == null) {
            Intent intent = new Intent();
            intent.setClassName(str, str2);
            return jd3.i(hk2.c(), intent, true, false);
        }
        return invokeLL.booleanValue;
    }
}
