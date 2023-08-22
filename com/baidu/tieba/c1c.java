package com.baidu.tieba;

import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.yy.transvod.player.log.TLog;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes5.dex */
public class c1c {
    public static /* synthetic */ Interceptable $ic;
    public static AtomicBoolean a;
    public static final LinkedList<i2c> b;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947623348, "Lcom/baidu/tieba/c1c;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947623348, "Lcom/baidu/tieba/c1c;");
                return;
            }
        }
        a = new AtomicBoolean(false);
        b = new LinkedList<>();
    }

    public c1c() {
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

    public static void a(i2c i2cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65538, null, i2cVar) == null) {
            synchronized (c1c.class) {
                if (b.size() == 0) {
                    c(i2cVar);
                }
                if (!b.contains(i2cVar)) {
                    b.add(i2cVar);
                }
            }
        }
    }

    public static void c(i2c i2cVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, i2cVar) == null) && i2cVar != null) {
            i2cVar.S0(a.get());
        }
    }

    public static void b(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(65539, null, z) == null) {
            TLog.h("PlayerGlobalOptions", " setAudioFocusEnable:" + z);
            a.set(z);
            t1c.h(z);
            synchronized (c1c.class) {
                if (b.size() > 0) {
                    Iterator<i2c> it = b.iterator();
                    while (it.hasNext()) {
                        i2c next = it.next();
                        if (next != null) {
                            next.S0(z);
                        }
                    }
                }
            }
        }
    }
}
