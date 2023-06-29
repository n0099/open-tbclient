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
/* loaded from: classes4.dex */
public final class a32 extends w22 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public a32() {
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

    @Override // com.baidu.tieba.w22
    public c42 c(@NonNull ib2 ib2Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, ib2Var)) == null) {
            View q = kv2.i().q(ib2Var);
            if (q == null) {
                return new c42(1001);
            }
            return e(q);
        }
        return (c42) invokeL.objValue;
    }

    @Override // com.baidu.tieba.w22
    public c42 d(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i)) == null) {
            return new c42(1001);
        }
        return (c42) invokeI.objValue;
    }

    public final c42 e(@NonNull View view2) {
        InterceptResult invokeL;
        c42 c42Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, view2)) == null) {
            try {
                c42Var = new c42(0, b((int) (tp3.P(view2.getLeft()) + 0.5f), (int) (tp3.P(view2.getTop()) + 0.5f), (int) (tp3.P(view2.getRight()) + 0.5f), (int) (tp3.P(view2.getBottom()) + 0.5f)));
            } catch (JSONException e) {
                if (w22.a) {
                    e.printStackTrace();
                }
                c42Var = new c42(1001, "result JSONException");
            }
            c92.k("AbsMenuButtonHandle", "getMenuButtonBoundingClientRect call success, param valid, get param normally, result = " + c42Var);
            return c42Var;
        }
        return (c42) invokeL.objValue;
    }
}
