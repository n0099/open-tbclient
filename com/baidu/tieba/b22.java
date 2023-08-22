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
public final class b22 extends x12 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public b22() {
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

    @Override // com.baidu.tieba.x12
    public d32 c(@NonNull ja2 ja2Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, ja2Var)) == null) {
            View q = lu2.i().q(ja2Var);
            if (q == null) {
                return new d32(1001);
            }
            return e(q);
        }
        return (d32) invokeL.objValue;
    }

    @Override // com.baidu.tieba.x12
    public d32 d(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i)) == null) {
            return new d32(1001);
        }
        return (d32) invokeI.objValue;
    }

    public final d32 e(@NonNull View view2) {
        InterceptResult invokeL;
        d32 d32Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, view2)) == null) {
            try {
                d32Var = new d32(0, b((int) (uo3.P(view2.getLeft()) + 0.5f), (int) (uo3.P(view2.getTop()) + 0.5f), (int) (uo3.P(view2.getRight()) + 0.5f), (int) (uo3.P(view2.getBottom()) + 0.5f)));
            } catch (JSONException e) {
                if (x12.a) {
                    e.printStackTrace();
                }
                d32Var = new d32(1001, "result JSONException");
            }
            d82.k("AbsMenuButtonHandle", "getMenuButtonBoundingClientRect call success, param valid, get param normally, result = " + d32Var);
            return d32Var;
        }
        return (d32) invokeL.objValue;
    }
}
