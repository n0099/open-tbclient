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
public final class gx1 extends cx1 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public gx1() {
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

    @Override // com.baidu.tieba.cx1
    public iy1 c(@NonNull n52 n52Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, n52Var)) == null) {
            View q = pp2.i().q(n52Var);
            if (q == null) {
                return new iy1(1001);
            }
            return e(q);
        }
        return (iy1) invokeL.objValue;
    }

    @Override // com.baidu.tieba.cx1
    public iy1 d(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i)) == null) {
            return new iy1(1001);
        }
        return (iy1) invokeI.objValue;
    }

    public final iy1 e(@NonNull View view2) {
        InterceptResult invokeL;
        iy1 iy1Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, view2)) == null) {
            try {
                iy1Var = new iy1(0, b((int) (yj3.P(view2.getLeft()) + 0.5f), (int) (yj3.P(view2.getTop()) + 0.5f), (int) (yj3.P(view2.getRight()) + 0.5f), (int) (yj3.P(view2.getBottom()) + 0.5f)));
            } catch (JSONException e) {
                if (cx1.a) {
                    e.printStackTrace();
                }
                iy1Var = new iy1(1001, "result JSONException");
            }
            h32.k("AbsMenuButtonHandle", "getMenuButtonBoundingClientRect call success, param valid, get param normally, result = " + iy1Var);
            return iy1Var;
        }
        return (iy1) invokeL.objValue;
    }
}
