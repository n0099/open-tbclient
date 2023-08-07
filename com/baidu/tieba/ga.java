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
import java.util.Map;
import java.util.Random;
/* loaded from: classes6.dex */
public class ga {
    public static /* synthetic */ Interceptable $ic;
    public static ga b;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1448305171, "Lcom/baidu/tieba/ga;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1448305171, "Lcom/baidu/tieba/ga;");
        }
    }

    public ga() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.a = 0;
    }

    public static ga a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            if (b == null) {
                synchronized (ga.class) {
                    if (b == null) {
                        b = new ga();
                    }
                }
            }
            return b;
        }
        return (ga) invokeV.objValue;
    }

    public synchronized int b() {
        InterceptResult invokeV;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            synchronized (this) {
                if (this.a == 0) {
                    this.a++;
                }
                i = this.a;
                this.a = i + 1;
            }
            return i;
        }
        return invokeV.intValue;
    }

    public synchronized void c(Map<String, String> map) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, map) == null) {
            synchronized (this) {
                if (map != null) {
                    try {
                        this.a = Integer.valueOf(map.get("Seq-Id")).intValue();
                    } catch (Exception e) {
                        BdLog.e(e.getMessage());
                        ja.a("SequenceManager", 0, 0, "setSequenceId", ia.x, "parser Seq-Id error");
                        if (this.a == 0) {
                            this.a = new Random().nextInt();
                        }
                    }
                }
            }
        }
    }
}
