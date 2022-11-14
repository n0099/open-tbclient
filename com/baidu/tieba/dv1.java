package com.baidu.tieba;

import android.view.View;
import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONException;
/* loaded from: classes3.dex */
public final class dv1 extends zu1 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public dv1() {
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
            View q = nn2.i().q(l32Var);
            if (q == null) {
                return new fw1(1001);
            }
            return e(q);
        }
        return (fw1) invokeL.objValue;
    }

    @Override // com.baidu.tieba.zu1
    public fw1 d(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i)) == null) {
            return new fw1(1001);
        }
        return (fw1) invokeI.objValue;
    }

    public final fw1 e(@NonNull View view2) {
        InterceptResult invokeL;
        fw1 fw1Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, view2)) == null) {
            try {
                fw1Var = new fw1(0, b((int) (wh3.P(view2.getLeft()) + 0.5f), (int) (wh3.P(view2.getTop()) + 0.5f), (int) (wh3.P(view2.getRight()) + 0.5f), (int) (wh3.P(view2.getBottom()) + 0.5f)));
            } catch (JSONException e) {
                if (zu1.a) {
                    e.printStackTrace();
                }
                fw1Var = new fw1(1001, "result JSONException");
            }
            f12.k("AbsMenuButtonHandle", "getMenuButtonBoundingClientRect call success, param valid, get param normally, result = " + fw1Var);
            return fw1Var;
        }
        return (fw1) invokeL.objValue;
    }
}
