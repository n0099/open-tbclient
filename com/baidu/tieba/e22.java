package com.baidu.tieba;

import android.app.Application;
import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONException;
/* loaded from: classes5.dex */
public final class e22 extends b22 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public e22() {
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

    @Override // com.baidu.tieba.b22
    public h32 c(@NonNull na2 na2Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, na2Var)) == null) {
            return e();
        }
        return (h32) invokeL.objValue;
    }

    @Override // com.baidu.tieba.b22
    public h32 d(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i)) == null) {
            return e();
        }
        return (h32) invokeI.objValue;
    }

    public h32 e() {
        InterceptResult invokeV;
        h32 h32Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            Application c = ou2.c();
            int i = (int) 28.4d;
            int P = (int) yo3.P(yo3.o(c) - c.getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f0700f8));
            int i2 = P - ((int) 75.53d);
            int P2 = ((int) (yo3.P(yo3.t()) + 0.5f)) + ((38 - i) / 2);
            try {
                h32Var = new h32(0, b(i2, P2, P, i + P2));
            } catch (JSONException e) {
                if (b22.a) {
                    e.printStackTrace();
                }
                h32Var = new h32(1001, "result JSONException");
            }
            h82.k("AbsMenuButtonHandle", "getMenuButtonBoundingClientRect call success, param valid, get param abnormally, result = " + h32Var);
            return h32Var;
        }
        return (h32) invokeV.objValue;
    }
}
