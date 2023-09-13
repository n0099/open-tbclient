package com.baidu.tieba;

import com.badlogic.gdx.utils.GdxRuntimeException;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
/* loaded from: classes6.dex */
public class i8 implements b7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final ExecutorService a;

    /* loaded from: classes6.dex */
    public class a implements ThreadFactory {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;

        public a(i8 i8Var, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {i8Var, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = str;
        }

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable runnable) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, runnable)) == null) {
                Thread thread = new Thread(runnable, this.a);
                thread.setDaemon(true);
                return thread;
            }
            return (Thread) invokeL.objValue;
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* loaded from: classes6.dex */
    public class b<T> implements Callable<T> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ k8 a;

        public b(i8 i8Var, k8 k8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {i8Var, k8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = k8Var;
        }

        @Override // java.util.concurrent.Callable
        public T call() throws Exception {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return (T) this.a.call();
            }
            return (T) invokeV.objValue;
        }
    }

    public i8(int i, String str) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i), str};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = Executors.newFixedThreadPool(i, new a(this, str));
    }

    public <T> j8<T> a(k8<T> k8Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, k8Var)) == null) {
            if (!this.a.isShutdown()) {
                return new j8<>(this.a.submit(new b(this, k8Var)));
            }
            throw new GdxRuntimeException("Cannot run tasks on an executor that has been shutdown (disposed)");
        }
        return (j8) invokeL.objValue;
    }

    @Override // com.baidu.tieba.b7
    public void dispose() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.a.shutdown();
            try {
                this.a.awaitTermination(Long.MAX_VALUE, TimeUnit.SECONDS);
            } catch (InterruptedException e) {
                throw new GdxRuntimeException("Couldn't shutdown loading thread", e);
            }
        }
    }
}
