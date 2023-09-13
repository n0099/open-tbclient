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
public final class f22 extends b22 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public f22() {
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

    @Override // com.baidu.tieba.b22
    public h32 c(@NonNull na2 na2Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, na2Var)) == null) {
            View q = pu2.i().q(na2Var);
            if (q == null) {
                return new h32(1001);
            }
            return e(q);
        }
        return (h32) invokeL.objValue;
    }

    @Override // com.baidu.tieba.b22
    public h32 d(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i)) == null) {
            return new h32(1001);
        }
        return (h32) invokeI.objValue;
    }

    public final h32 e(@NonNull View view2) {
        InterceptResult invokeL;
        h32 h32Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, view2)) == null) {
            try {
                h32Var = new h32(0, b((int) (yo3.P(view2.getLeft()) + 0.5f), (int) (yo3.P(view2.getTop()) + 0.5f), (int) (yo3.P(view2.getRight()) + 0.5f), (int) (yo3.P(view2.getBottom()) + 0.5f)));
            } catch (JSONException e) {
                if (b22.a) {
                    e.printStackTrace();
                }
                h32Var = new h32(1001, "result JSONException");
            }
            h82.k("AbsMenuButtonHandle", "getMenuButtonBoundingClientRect call success, param valid, get param normally, result = " + h32Var);
            return h32Var;
        }
        return (h32) invokeL.objValue;
    }
}
