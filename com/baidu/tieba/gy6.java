package com.baidu.tieba;

import android.database.Cursor;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.nadcore.sweetsqlite.LongColumn;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public final class gy6 {
    public static /* synthetic */ Interceptable $ic;
    public static final gy6 a;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes6.dex */
    public interface a extends z41 {
        Cursor b(String str, String... strArr);

        /* synthetic */ long insert(g51 g51Var);

        /* synthetic */ boolean query(g51 g51Var, x41... x41VarArr);

        @Override // com.baidu.tieba.z41
        /* synthetic */ int update(g51 g51Var, x41... x41VarArr);
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947810309, "Lcom/baidu/tieba/gy6;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947810309, "Lcom/baidu/tieba/gy6;");
                return;
            }
        }
        a = new gy6();
    }

    public gy6() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public final x41 a(int i, int i2) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeII = interceptable.invokeII(1048576, this, i, i2)) == null) {
            return new x41(i, "", "", i2, 0);
        }
        return (x41) invokeII.objValue;
    }

    public final LongColumn b(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i)) == null) {
            return new LongColumn(a(3, i));
        }
        return (LongColumn) invokeI.objValue;
    }
}
