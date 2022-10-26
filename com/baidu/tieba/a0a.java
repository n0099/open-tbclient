package com.baidu.tieba;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.ay9;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes3.dex */
public final class a0a extends ay9 {
    public static /* synthetic */ Interceptable $ic;
    public static final a0a a;
    public transient /* synthetic */ FieldHolder $fh;

    public static int a(int i, int i2) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeII = interceptable.invokeII(65538, null, i, i2)) == null) {
            if (i < i2) {
                return -1;
            }
            return i == i2 ? 0 : 1;
        }
        return invokeII.intValue;
    }

    /* loaded from: classes3.dex */
    public final class a extends ay9.a implements ey9 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final AtomicInteger a;
        public final PriorityBlockingQueue b;
        public final q2a c;
        public final AtomicInteger d;

        /* renamed from: com.baidu.tieba.a0a$a$a  reason: collision with other inner class name */
        /* loaded from: classes3.dex */
        public class C0196a implements ky9 {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ b a;
            public final /* synthetic */ a b;

            public C0196a(a aVar, b bVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {aVar, bVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.b = aVar;
                this.a = bVar;
            }

            @Override // com.baidu.tieba.ky9
            public void call() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    this.b.b.remove(this.a);
                }
            }
        }

        public a() {
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
            this.a = new AtomicInteger();
            this.b = new PriorityBlockingQueue();
            this.c = new q2a();
            this.d = new AtomicInteger();
        }

        @Override // com.baidu.tieba.ay9.a
        public ey9 b(ky9 ky9Var) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, ky9Var)) == null) {
                return d(ky9Var, a());
            }
            return (ey9) invokeL.objValue;
        }

        @Override // com.baidu.tieba.ay9.a
        public ey9 c(ky9 ky9Var, long j, TimeUnit timeUnit) {
            InterceptResult invokeCommon;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{ky9Var, Long.valueOf(j), timeUnit})) == null) {
                long a = a() + timeUnit.toMillis(j);
                return d(new zz9(ky9Var, this, a), a);
            }
            return (ey9) invokeCommon.objValue;
        }

        public final ey9 d(ky9 ky9Var, long j) {
            InterceptResult invokeLJ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLJ = interceptable.invokeLJ(Constants.METHOD_SEND_USER_MSG, this, ky9Var, j)) == null) {
                if (this.c.isUnsubscribed()) {
                    return u2a.c();
                }
                b bVar = new b(ky9Var, Long.valueOf(j), this.a.incrementAndGet());
                this.b.add(bVar);
                if (this.d.getAndIncrement() == 0) {
                    do {
                        b bVar2 = (b) this.b.poll();
                        if (bVar2 != null) {
                            bVar2.a.call();
                        }
                    } while (this.d.decrementAndGet() > 0);
                    return u2a.c();
                }
                return u2a.a(new C0196a(this, bVar));
            }
            return (ey9) invokeLJ.objValue;
        }

        @Override // com.baidu.tieba.ey9
        public boolean isUnsubscribed() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
                return this.c.isUnsubscribed();
            }
            return invokeV.booleanValue;
        }

        @Override // com.baidu.tieba.ey9
        public void unsubscribe() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
                this.c.unsubscribe();
            }
        }
    }

    /* loaded from: classes3.dex */
    public final class b implements Comparable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final ky9 a;
        public final Long b;
        public final int c;

        public b(ky9 ky9Var, Long l, int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ky9Var, l, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ky9Var;
            this.b = l;
            this.c = i;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.lang.Comparable
        /* renamed from: a */
        public int compareTo(b bVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, bVar)) == null) {
                int compareTo = this.b.compareTo(bVar.b);
                if (compareTo == 0) {
                    return a0a.a(this.c, bVar.c);
                }
                return compareTo;
            }
            return invokeL.intValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947562743, "Lcom/baidu/tieba/a0a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947562743, "Lcom/baidu/tieba/a0a;");
                return;
            }
        }
        a = new a0a();
    }

    public a0a() {
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

    @Override // com.baidu.tieba.ay9
    public ay9.a createWorker() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return new a();
        }
        return (ay9.a) invokeV.objValue;
    }
}
