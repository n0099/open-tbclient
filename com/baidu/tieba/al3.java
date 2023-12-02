package com.baidu.tieba;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayDeque;
import java.util.Queue;
/* loaded from: classes5.dex */
public class al3 implements zk3 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final Queue<yk3> a;
    public yk3 b;

    public al3() {
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
        this.a = new ArrayDeque();
    }

    public final void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            synchronized (this.a) {
                if (this.b != null) {
                    return;
                }
                e();
            }
        }
    }

    public synchronized void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            synchronized (this) {
                if (this.b != null) {
                    this.b.a();
                    this.b = null;
                }
                this.a.clear();
            }
        }
    }

    @Override // com.baidu.tieba.zk3
    public void a(yk3 yk3Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, yk3Var) == null) {
            synchronized (this.a) {
                if (yk3Var == this.b) {
                    e();
                }
            }
        }
    }

    public void d(yk3 yk3Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, yk3Var) == null) {
            if (yk3Var != null) {
                synchronized (this.a) {
                    Queue<yk3> queue = this.a;
                    yk3Var.b(this);
                    queue.offer(yk3Var);
                }
            }
            b();
        }
    }

    public final void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            synchronized (this.a) {
                this.b = null;
                if (this.a.isEmpty()) {
                    return;
                }
                yk3 poll = this.a.poll();
                this.b = poll;
                if (poll == null) {
                    e();
                } else {
                    ek3.a0(poll);
                }
            }
        }
    }
}
