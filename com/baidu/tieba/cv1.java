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
public final class cv1 extends yu1 {
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

    @Override // com.baidu.tieba.yu1
    public ew1 c(@NonNull k32 k32Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, k32Var)) == null) {
            View q = mn2.i().q(k32Var);
            if (q == null) {
                return new ew1(1001);
            }
            return e(q);
        }
        return (ew1) invokeL.objValue;
    }

    @Override // com.baidu.tieba.yu1
    public ew1 d(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i)) == null) {
            return new ew1(1001);
        }
        return (ew1) invokeI.objValue;
    }

    public final ew1 e(@NonNull View view2) {
        InterceptResult invokeL;
        ew1 ew1Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, view2)) == null) {
            try {
                ew1Var = new ew1(0, b((int) (vh3.P(view2.getLeft()) + 0.5f), (int) (vh3.P(view2.getTop()) + 0.5f), (int) (vh3.P(view2.getRight()) + 0.5f), (int) (vh3.P(view2.getBottom()) + 0.5f)));
            } catch (JSONException e) {
                if (yu1.a) {
                    e.printStackTrace();
                }
                ew1Var = new ew1(1001, "result JSONException");
            }
            e12.k("AbsMenuButtonHandle", "getMenuButtonBoundingClientRect call success, param valid, get param normally, result = " + ew1Var);
            return ew1Var;
        }
        return (ew1) invokeL.objValue;
    }
}
