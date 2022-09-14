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
public class fu3 extends ev3 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public fu3() {
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

    @Override // com.baidu.tieba.ev3
    public yu1 a(@NonNull JSONObject jSONObject, @NonNull cg2 cg2Var) {
        InterceptResult invokeLL;
        boolean b;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, jSONObject, cg2Var)) == null) {
            if (hg3.m()) {
                b = b("com.huawei.systemmanager", "com.huawei.systemmanager.appfeature.spacecleaner.SpaceCleanActivity");
            } else if (hg3.n()) {
                b = b("com.miui.cleanmaster", "com.miui.optimizecenter.MainActivity");
            } else if (hg3.o()) {
                b = b("com.coloros.phonemanager", "com.coloros.phonemanager.clear.ClearActivity");
            } else {
                b = hg3.r() ? b("com.iqoo.secure", "com.iqoo.secure.clean.PhoneCleanActivity2") : false;
            }
            if (!b) {
                Toast.makeText(fm2.c(), (int) R.string.obfuscated_res_0x7f0f0190, 0).show();
            }
            cg2Var.a(null);
            return null;
        }
        return (yu1) invokeLL.objValue;
    }

    public final boolean b(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, str2)) == null) {
            Intent intent = new Intent();
            intent.setClassName(str, str2);
            return hf3.i(fm2.c(), intent, true, false);
        }
        return invokeLL.booleanValue;
    }
}
