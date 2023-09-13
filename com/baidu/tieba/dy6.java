package com.baidu.tieba;

import android.database.Cursor;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.nadcore.sweetsqlite.IntegerColumn;
import com.baidu.nadcore.sweetsqlite.LongColumn;
import com.baidu.nadcore.sweetsqlite.StringColumn;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public final class dy6 {
    public static /* synthetic */ Interceptable $ic;
    public static final dy6 a;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes5.dex */
    public interface a extends j41 {
        Cursor b(String str, String... strArr);

        /* synthetic */ long insert(q41 q41Var);

        /* synthetic */ boolean query(q41 q41Var, h41... h41VarArr);

        @Override // com.baidu.tieba.j41
        /* synthetic */ int update(q41 q41Var, h41... h41VarArr);
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947720936, "Lcom/baidu/tieba/dy6;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947720936, "Lcom/baidu/tieba/dy6;");
                return;
            }
        }
        a = new dy6();
    }

    public dy6() {
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

    public final h41 a(int i, int i2) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeII = interceptable.invokeII(1048576, this, i, i2)) == null) {
            return new h41(i, "", "", i2, 0);
        }
        return (h41) invokeII.objValue;
    }

    public final IntegerColumn b(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i)) == null) {
            return new IntegerColumn(a(2, i));
        }
        return (IntegerColumn) invokeI.objValue;
    }

    public final LongColumn c(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i)) == null) {
            return new LongColumn(a(3, i));
        }
        return (LongColumn) invokeI.objValue;
    }

    public final StringColumn d(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048579, this, i)) == null) {
            return new StringColumn(a(4, i));
        }
        return (StringColumn) invokeI.objValue;
    }
}
