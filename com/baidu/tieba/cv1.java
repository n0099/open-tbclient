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
/* loaded from: classes3.dex */
public final class cv1 extends zu1 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public cv1() {
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

    @Override // com.baidu.tieba.zu1
    public fw1 c(@NonNull l32 l32Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, l32Var)) == null) {
            return e();
        }
        return (fw1) invokeL.objValue;
    }

    @Override // com.baidu.tieba.zu1
    public fw1 d(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i)) == null) {
            return e();
        }
        return (fw1) invokeI.objValue;
    }

    public fw1 e() {
        InterceptResult invokeV;
        fw1 fw1Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            Application c = mn2.c();
            int i = (int) 28.4d;
            int P = (int) wh3.P(wh3.o(c) - c.getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f0700ef));
            int i2 = P - ((int) 75.53d);
            int P2 = ((int) (wh3.P(wh3.t()) + 0.5f)) + ((38 - i) / 2);
            try {
                fw1Var = new fw1(0, b(i2, P2, P, i + P2));
            } catch (JSONException e) {
                if (zu1.a) {
                    e.printStackTrace();
                }
                fw1Var = new fw1(1001, "result JSONException");
            }
            f12.k("AbsMenuButtonHandle", "getMenuButtonBoundingClientRect call success, param valid, get param abnormally, result = " + fw1Var);
            return fw1Var;
        }
        return (fw1) invokeV.objValue;
    }
}
