package com.baidu.tieba;

import android.util.SparseArray;
import com.baidu.adp.BdUniqueId;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class ct7 extends SparseArray<nt7> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public BdUniqueId a;

    public ct7() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = null;
    }

    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            for (int i = 0; i < size(); i++) {
                nt7 valueAt = valueAt(i);
                if (valueAt != null) {
                    valueAt.N(null);
                    valueAt.n();
                }
            }
        }
    }

    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            for (int i = 0; i < size(); i++) {
                nt7 valueAt = valueAt(i);
                if (valueAt != null) {
                    valueAt.init();
                }
            }
        }
    }

    public void a(int i, nt7 nt7Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048576, this, i, nt7Var) == null) {
            if (i > 100) {
                i = 100;
            }
            put(i, nt7Var);
        }
    }

    public nt7 c(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i)) == null) {
            if (i > 100) {
                i = 100;
            }
            return get(i);
        }
        return (nt7) invokeI.objValue;
    }

    public void e(rt7 rt7Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, rt7Var) == null) {
            for (int i = 0; i < size(); i++) {
                nt7 valueAt = valueAt(i);
                if (valueAt != null) {
                    valueAt.N(rt7Var);
                }
            }
        }
    }
}
