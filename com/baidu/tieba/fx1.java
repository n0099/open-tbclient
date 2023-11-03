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
/* loaded from: classes6.dex */
public final class fx1 extends bx1 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public fx1() {
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

    @Override // com.baidu.tieba.bx1
    public hy1 c(@NonNull m52 m52Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, m52Var)) == null) {
            View q = op2.i().q(m52Var);
            if (q == null) {
                return new hy1(1001);
            }
            return e(q);
        }
        return (hy1) invokeL.objValue;
    }

    @Override // com.baidu.tieba.bx1
    public hy1 d(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i)) == null) {
            return new hy1(1001);
        }
        return (hy1) invokeI.objValue;
    }

    public final hy1 e(@NonNull View view2) {
        InterceptResult invokeL;
        hy1 hy1Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, view2)) == null) {
            try {
                hy1Var = new hy1(0, b((int) (xj3.P(view2.getLeft()) + 0.5f), (int) (xj3.P(view2.getTop()) + 0.5f), (int) (xj3.P(view2.getRight()) + 0.5f), (int) (xj3.P(view2.getBottom()) + 0.5f)));
            } catch (JSONException e) {
                if (bx1.a) {
                    e.printStackTrace();
                }
                hy1Var = new hy1(1001, "result JSONException");
            }
            g32.k("AbsMenuButtonHandle", "getMenuButtonBoundingClientRect call success, param valid, get param normally, result = " + hy1Var);
            return hy1Var;
        }
        return (hy1) invokeL.objValue;
    }
}
