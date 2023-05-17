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
/* loaded from: classes5.dex */
public final class e02 extends a02 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public e02() {
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

    @Override // com.baidu.tieba.a02
    public g12 c(@NonNull m82 m82Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, m82Var)) == null) {
            View q = os2.i().q(m82Var);
            if (q == null) {
                return new g12(1001);
            }
            return e(q);
        }
        return (g12) invokeL.objValue;
    }

    @Override // com.baidu.tieba.a02
    public g12 d(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i)) == null) {
            return new g12(1001);
        }
        return (g12) invokeI.objValue;
    }

    public final g12 e(@NonNull View view2) {
        InterceptResult invokeL;
        g12 g12Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, view2)) == null) {
            try {
                g12Var = new g12(0, b((int) (xm3.P(view2.getLeft()) + 0.5f), (int) (xm3.P(view2.getTop()) + 0.5f), (int) (xm3.P(view2.getRight()) + 0.5f), (int) (xm3.P(view2.getBottom()) + 0.5f)));
            } catch (JSONException e) {
                if (a02.a) {
                    e.printStackTrace();
                }
                g12Var = new g12(1001, "result JSONException");
            }
            g62.k("AbsMenuButtonHandle", "getMenuButtonBoundingClientRect call success, param valid, get param normally, result = " + g12Var);
            return g12Var;
        }
        return (g12) invokeL.objValue;
    }
}
