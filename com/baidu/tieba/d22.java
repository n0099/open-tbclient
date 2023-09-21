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
public final class d22 extends a22 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public d22() {
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

    @Override // com.baidu.tieba.a22
    public g32 c(@NonNull ma2 ma2Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, ma2Var)) == null) {
            return e();
        }
        return (g32) invokeL.objValue;
    }

    @Override // com.baidu.tieba.a22
    public g32 d(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i)) == null) {
            return e();
        }
        return (g32) invokeI.objValue;
    }

    public g32 e() {
        InterceptResult invokeV;
        g32 g32Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            Application c = nu2.c();
            int i = (int) 28.4d;
            int P = (int) xo3.P(xo3.o(c) - c.getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f0700f8));
            int i2 = P - ((int) 75.53d);
            int P2 = ((int) (xo3.P(xo3.t()) + 0.5f)) + ((38 - i) / 2);
            try {
                g32Var = new g32(0, b(i2, P2, P, i + P2));
            } catch (JSONException e) {
                if (a22.a) {
                    e.printStackTrace();
                }
                g32Var = new g32(1001, "result JSONException");
            }
            g82.k("AbsMenuButtonHandle", "getMenuButtonBoundingClientRect call success, param valid, get param abnormally, result = " + g32Var);
            return g32Var;
        }
        return (g32) invokeV.objValue;
    }
}
