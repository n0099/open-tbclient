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
public final class hv1 extends dv1 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public hv1() {
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

    @Override // com.baidu.tieba.dv1
    public jw1 c(@NonNull p32 p32Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, p32Var)) == null) {
            View q = rn2.i().q(p32Var);
            if (q == null) {
                return new jw1(1001);
            }
            return e(q);
        }
        return (jw1) invokeL.objValue;
    }

    @Override // com.baidu.tieba.dv1
    public jw1 d(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i)) == null) {
            return new jw1(1001);
        }
        return (jw1) invokeI.objValue;
    }

    public final jw1 e(@NonNull View view2) {
        InterceptResult invokeL;
        jw1 jw1Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, view2)) == null) {
            try {
                jw1Var = new jw1(0, b((int) (ai3.P(view2.getLeft()) + 0.5f), (int) (ai3.P(view2.getTop()) + 0.5f), (int) (ai3.P(view2.getRight()) + 0.5f), (int) (ai3.P(view2.getBottom()) + 0.5f)));
            } catch (JSONException e) {
                if (dv1.a) {
                    e.printStackTrace();
                }
                jw1Var = new jw1(1001, "result JSONException");
            }
            j12.k("AbsMenuButtonHandle", "getMenuButtonBoundingClientRect call success, param valid, get param normally, result = " + jw1Var);
            return jw1Var;
        }
        return (jw1) invokeL.objValue;
    }
}
