package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
/* loaded from: classes5.dex */
public class el2 implements lw2 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Queue<fl2> c;

    /* loaded from: classes5.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes5.dex */
    public static class b {
        public static /* synthetic */ Interceptable $ic;
        public static final el2 a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-829436352, "Lcom/baidu/tieba/el2$b;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-829436352, "Lcom/baidu/tieba/el2$b;");
                    return;
                }
            }
            a = new el2(null);
        }
    }

    public el2() {
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
        this.c = new ConcurrentLinkedQueue();
    }

    public static el2 b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            return b.a;
        }
        return (el2) invokeV.objValue;
    }

    public synchronized void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            synchronized (this) {
                this.c.clear();
            }
        }
    }

    public /* synthetic */ el2(a aVar) {
        this();
    }

    public synchronized void c(@NonNull fl2 fl2Var, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, fl2Var, str) == null) {
            synchronized (this) {
                while (this.c.size() > 0) {
                    fl2 peek = this.c.peek();
                    if (peek == null) {
                        this.c.remove();
                    } else if (peek.a()) {
                        break;
                    } else {
                        this.c.remove();
                    }
                }
                int size = this.c.size();
                if (size == 0) {
                    this.c.offer(fl2Var);
                    bp3.g0(fl2Var);
                } else {
                    fl2 peek2 = this.c.peek();
                    this.c.offer(fl2Var);
                    if (size == 1 && peek2 != null && peek2.b(str)) {
                        bp3.g0(fl2Var);
                    } else {
                        bp3.q().post(fl2Var);
                    }
                }
            }
        }
    }
}
