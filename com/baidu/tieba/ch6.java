package com.baidu.tieba;

import android.annotation.SuppressLint;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.os.MessageQueue;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.ch6;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.lang.reflect.Field;
/* loaded from: classes5.dex */
public class ch6 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile a a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1947674808, "Lcom/baidu/tieba/ch6;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1947674808, "Lcom/baidu/tieba/ch6;");
        }
    }

    /* loaded from: classes5.dex */
    public static class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final Handler a;
        public final Looper b;
        public MessageQueue c;

        public a(Looper looper) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {looper};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = looper;
            this.a = new Handler(looper);
        }

        public static /* synthetic */ boolean b(Runnable runnable) {
            runnable.run();
            return false;
        }

        public boolean c(Runnable runnable) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, runnable)) == null) {
                if (a() == null) {
                    return false;
                }
                return this.a.post(runnable);
            }
            return invokeL.booleanValue;
        }

        public void e(Runnable runnable) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048579, this, runnable) == null) && a() != null) {
                this.a.removeCallbacks(runnable);
            }
        }

        public void f(final Runnable runnable) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048580, this, runnable) != null) || a() == null) {
                return;
            }
            this.c.addIdleHandler(new MessageQueue.IdleHandler() { // from class: com.baidu.tieba.yg6
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // android.os.MessageQueue.IdleHandler
                public final boolean queueIdle() {
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    return (interceptable2 == null || (invokeV = interceptable2.invokeV(1048576, this)) == null) ? ch6.a.b(runnable) : invokeV.booleanValue;
                }
            });
        }

        @SuppressLint({"DiscouragedPrivateApi"})
        public final synchronized MessageQueue a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                synchronized (this) {
                    if (this.c != null) {
                        return this.c;
                    }
                    if (Build.VERSION.SDK_INT >= 23) {
                        MessageQueue queue = this.b.getQueue();
                        this.c = queue;
                        return queue;
                    }
                    try {
                        Field declaredField = Looper.class.getDeclaredField("mQueue");
                        declaredField.setAccessible(true);
                        Object obj = declaredField.get(this.b);
                        if (obj instanceof MessageQueue) {
                            this.c = (MessageQueue) obj;
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    return this.c;
                }
            }
            return (MessageQueue) invokeV.objValue;
        }

        public boolean d(Runnable runnable, long j) {
            InterceptResult invokeLJ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLJ = interceptable.invokeLJ(Constants.METHOD_SEND_USER_MSG, this, runnable, j)) == null) {
                if (a() == null) {
                    return false;
                }
                return this.a.postDelayed(runnable, j);
            }
            return invokeLJ.booleanValue;
        }
    }

    public ch6() {
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

    public static a a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            if (a == null) {
                synchronized (ch6.class) {
                    if (a == null) {
                        a = new a(Looper.getMainLooper());
                    }
                }
            }
            return a;
        }
        return (a) invokeV.objValue;
    }
}
