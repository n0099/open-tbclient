package com.baidu.tieba;

import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.concurrent.CountDownLatch;
/* loaded from: classes3.dex */
public abstract class aj3<OuT> implements Runnable {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final dj3<OuT> a;
    public OuT b;

    public abstract void c();

    /* loaded from: classes3.dex */
    public static class a extends aj3<OuT> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ CountDownLatch c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(dj3 dj3Var, CountDownLatch countDownLatch) {
            super(dj3Var, null);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dj3Var, countDownLatch};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super((dj3) objArr2[0], (a) objArr2[1]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = countDownLatch;
        }

        @Override // com.baidu.tieba.aj3
        public void c() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.c.countDown();
            }
        }
    }

    public aj3(dj3<OuT> dj3Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {dj3Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.b = null;
        this.a = dj3Var;
    }

    public static <OuT> OuT b(dj3<OuT> dj3Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, dj3Var)) == null) {
            return (OuT) a(Looper.getMainLooper(), dj3Var);
        }
        return (OuT) invokeL.objValue;
    }

    public /* synthetic */ aj3(dj3 dj3Var, a aVar) {
        this(dj3Var);
    }

    public static <OuT> OuT a(Looper looper, dj3<OuT> dj3Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, looper, dj3Var)) == null) {
            if (dj3Var == null) {
                return null;
            }
            if (looper != null && Thread.currentThread() != looper.getThread()) {
                CountDownLatch countDownLatch = new CountDownLatch(1);
                a aVar = new a(dj3Var, countDownLatch);
                new Handler(looper).post(aVar);
                try {
                    countDownLatch.await();
                } catch (InterruptedException e) {
                    j12.o("Awaiting", "callOnLooper: Thread=" + Thread.currentThread().getName() + " ret by InterruptedException " + e);
                    e.printStackTrace();
                }
                return aVar.b;
            }
            return dj3Var.create();
        }
        return (OuT) invokeLL.objValue;
    }

    @Override // java.lang.Runnable
    public void run() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            try {
                try {
                    this.b = this.a.create();
                } catch (Exception e) {
                    j12.o("Awaiting", "catch: " + e + "\n" + Log.getStackTraceString(e));
                }
            } finally {
                c();
            }
        }
    }
}
