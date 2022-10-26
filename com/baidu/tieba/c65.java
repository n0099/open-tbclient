package com.baidu.tieba;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes3.dex */
public class c65 implements j85 {
    public static /* synthetic */ Interceptable $ic;
    public static final HashMap a;
    public static final ArrayList b;
    public static final HashMap c;
    public static final HashMap d;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947626727, "Lcom/baidu/tieba/c65;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947626727, "Lcom/baidu/tieba/c65;");
                return;
            }
        }
        a = new HashMap(200);
        b = new ArrayList(180);
        c = new HashMap(180);
        d = new HashMap(180);
    }

    public c65() {
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

    public static void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65538, null) == null) {
            try {
                Class.forName("com.baidu.tieba.z55");
            } catch (Throwable th) {
                BdLog.e(th);
            }
            try {
                Class.forName("com.baidu.tieba.q86");
            } catch (Throwable th2) {
                BdLog.e(th2);
            }
            try {
                Class.forName("com.baidu.tieba.s86");
            } catch (Throwable th3) {
                BdLog.e(th3);
            }
        }
    }

    @Override // com.baidu.tieba.j85
    public int a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            g();
            return b.size();
        }
        return invokeV.intValue;
    }

    public void g() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048582, this) == null) && d.isEmpty()) {
            i();
        }
    }

    @Override // com.baidu.tieba.j85
    public String b(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i)) == null) {
            g();
            int h = h(i);
            for (Map.Entry entry : c.entrySet()) {
                if (((Integer) entry.getValue()).intValue() == h) {
                    return (String) entry.getKey();
                }
            }
            return null;
        }
        return (String) invokeI.objValue;
    }

    @Override // com.baidu.tieba.j85
    public String d(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048579, this, i)) == null) {
            g();
            for (Map.Entry entry : a.entrySet()) {
                if (((Integer) entry.getValue()).intValue() == i) {
                    return (String) entry.getKey();
                }
            }
            return null;
        }
        return (String) invokeI.objValue;
    }

    @Override // com.baidu.tieba.j85
    public int e(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, str)) == null) {
            g();
            Integer num = (Integer) a.get(str);
            if ("video_icon".equals(str)) {
                return Integer.valueOf((int) R.drawable.ico_link_video).intValue();
            }
            if (num != null) {
                return num.intValue();
            }
            return 0;
        }
        return invokeL.intValue;
    }

    @Override // com.baidu.tieba.j85
    public String c(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
            g();
            return (String) d.get(str);
        }
        return (String) invokeL.objValue;
    }

    @Override // com.baidu.tieba.j85
    public int f(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, str)) == null) {
            g();
            Integer num = (Integer) c.get(str);
            if (num != null) {
                return num.intValue();
            }
            return 0;
        }
        return invokeL.intValue;
    }

    public final int h(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048583, this, i)) == null) {
            g();
            if (i >= 0 && i < b.size()) {
                return ((Integer) b.get(i)).intValue();
            }
            return 0;
        }
        return invokeI.intValue;
    }
}
