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
public final class e22 extends a22 {
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

    @Override // com.baidu.tieba.a22
    public g32 c(@NonNull ma2 ma2Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, ma2Var)) == null) {
            View q = ou2.i().q(ma2Var);
            if (q == null) {
                return new g32(1001);
            }
            return e(q);
        }
        return (g32) invokeL.objValue;
    }

    @Override // com.baidu.tieba.a22
    public g32 d(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i)) == null) {
            return new g32(1001);
        }
        return (g32) invokeI.objValue;
    }

    public final g32 e(@NonNull View view2) {
        InterceptResult invokeL;
        g32 g32Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, view2)) == null) {
            try {
                g32Var = new g32(0, b((int) (xo3.P(view2.getLeft()) + 0.5f), (int) (xo3.P(view2.getTop()) + 0.5f), (int) (xo3.P(view2.getRight()) + 0.5f), (int) (xo3.P(view2.getBottom()) + 0.5f)));
            } catch (JSONException e) {
                if (a22.a) {
                    e.printStackTrace();
                }
                g32Var = new g32(1001, "result JSONException");
            }
            g82.k("AbsMenuButtonHandle", "getMenuButtonBoundingClientRect call success, param valid, get param normally, result = " + g32Var);
            return g32Var;
        }
        return (g32) invokeL.objValue;
    }
}
