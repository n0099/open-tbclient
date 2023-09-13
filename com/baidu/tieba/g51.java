package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class g51 {
    public static /* synthetic */ Interceptable $ic;
    public static g51 b;
    public transient /* synthetic */ FieldHolder $fh;
    @NonNull
    public h51 a;

    public g51() {
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
        this.a = new e51();
        if (!x41.a()) {
            this.a = new f51();
        }
    }

    public static g51 b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            if (b == null) {
                synchronized (g51.class) {
                    if (b == null) {
                        b = new g51();
                    }
                }
            }
            return b;
        }
        return (g51) invokeV.objValue;
    }

    @NonNull
    public h51 a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.a;
        }
        return (h51) invokeV.objValue;
    }
}
