package com.baidu.tieba;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.b3a;
import com.baidu.tieba.e3a;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Queue;
import java.util.concurrent.atomic.AtomicLong;
import rx.exceptions.MissingBackpressureException;
import rx.internal.operators.NotificationLite;
/* loaded from: classes4.dex */
public final class h4a<T> implements b3a.b<T, T> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final e3a a;
    public final boolean b;
    public final int c;

    /* loaded from: classes4.dex */
    public static final class a<T> extends h3a<T> implements o3a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final h3a<? super T> e;
        public final e3a.a f;
        public final boolean g;
        public final Queue<Object> h;
        public final int i;
        public volatile boolean j;
        public final AtomicLong k;
        public final AtomicLong l;
        public Throwable m;
        public long n;

        /* renamed from: com.baidu.tieba.h4a$a$a  reason: collision with other inner class name */
        /* loaded from: classes4.dex */
        public class C0295a implements d3a {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ a a;

            public C0295a(a aVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {aVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = aVar;
            }

            @Override // com.baidu.tieba.d3a
            public void request(long j) {
                Interceptable interceptable = $ic;
                if ((interceptable == null || interceptable.invokeJ(1048576, this, j) == null) && j > 0) {
                    w3a.b(this.a.k, j);
                    this.a.i();
                }
            }
        }

        public a(e3a e3aVar, h3a<? super T> h3aVar, boolean z, int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {e3aVar, h3aVar, Boolean.valueOf(z), Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.k = new AtomicLong();
            this.l = new AtomicLong();
            this.e = h3aVar;
            this.f = e3aVar.createWorker();
            this.g = z;
            i = i <= 0 ? k5a.c : i;
            this.i = i - (i >> 2);
            if (y6a.b()) {
                this.h = new k6a(i);
            } else {
                this.h = new p5a(i);
            }
            e(i);
        }

        public boolean g(boolean z, boolean z2, h3a<? super T> h3aVar, Queue<Object> queue) {
            InterceptResult invokeCommon;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2), h3aVar, queue})) == null) {
                if (h3aVar.isUnsubscribed()) {
                    queue.clear();
                    return true;
                } else if (z) {
                    if (this.g) {
                        if (z2) {
                            Throwable th = this.m;
                            try {
                                if (th != null) {
                                    h3aVar.onError(th);
                                } else {
                                    h3aVar.onCompleted();
                                }
                                return false;
                            } finally {
                            }
                        }
                        return false;
                    }
                    Throwable th2 = this.m;
                    if (th2 != null) {
                        queue.clear();
                        try {
                            h3aVar.onError(th2);
                            return true;
                        } finally {
                        }
                    } else if (z2) {
                        try {
                            h3aVar.onCompleted();
                            return true;
                        } finally {
                        }
                    } else {
                        return false;
                    }
                } else {
                    return false;
                }
            }
            return invokeCommon.booleanValue;
        }

        @Override // com.baidu.tieba.o3a
        public void call() {
            int i;
            boolean z;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                long j = this.n;
                Queue<Object> queue = this.h;
                h3a<? super T> h3aVar = this.e;
                long j2 = 1;
                do {
                    long j3 = this.k.get();
                    while (true) {
                        i = (j3 > j ? 1 : (j3 == j ? 0 : -1));
                        if (i == 0) {
                            break;
                        }
                        boolean z2 = this.j;
                        Object poll = queue.poll();
                        if (poll == null) {
                            z = true;
                        } else {
                            z = false;
                        }
                        if (g(z2, z, h3aVar, queue)) {
                            return;
                        }
                        if (z) {
                            break;
                        }
                        h3aVar.onNext((Object) NotificationLite.e(poll));
                        j++;
                        if (j == this.i) {
                            j3 = w3a.g(this.k, j);
                            e(j);
                            j = 0;
                        }
                    }
                    if (i == 0 && g(this.j, queue.isEmpty(), h3aVar, queue)) {
                        return;
                    }
                    this.n = j;
                    j2 = this.l.addAndGet(-j2);
                } while (j2 != 0);
            }
        }

        public void h() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                h3a<? super T> h3aVar = this.e;
                h3aVar.f(new C0295a(this));
                h3aVar.b(this.f);
                h3aVar.b(this);
            }
        }

        public void i() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048579, this) == null) && this.l.getAndIncrement() == 0) {
                this.f.b(this);
            }
        }

        @Override // com.baidu.tieba.c3a
        public void onCompleted() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048580, this) == null) && !isUnsubscribed() && !this.j) {
                this.j = true;
                i();
            }
        }

        @Override // com.baidu.tieba.c3a
        public void onError(Throwable th) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048581, this, th) == null) {
                if (!isUnsubscribed() && !this.j) {
                    this.m = th;
                    this.j = true;
                    i();
                    return;
                }
                i7a.j(th);
            }
        }

        @Override // com.baidu.tieba.c3a
        public void onNext(T t) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048582, this, t) == null) && !isUnsubscribed() && !this.j) {
                if (!this.h.offer(NotificationLite.h(t))) {
                    onError(new MissingBackpressureException());
                } else {
                    i();
                }
            }
        }
    }

    public h4a(e3a e3aVar, boolean z, int i) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {e3aVar, Boolean.valueOf(z), Integer.valueOf(i)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = e3aVar;
        this.b = z;
        this.c = i <= 0 ? k5a.c : i;
    }

    public h3a<? super T> call(h3a<? super T> h3aVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, h3aVar)) == null) {
            e3a e3aVar = this.a;
            if (e3aVar instanceof z4a) {
                return h3aVar;
            }
            if (e3aVar instanceof e5a) {
                return h3aVar;
            }
            a aVar = new a(e3aVar, h3aVar, this.b, this.c);
            aVar.h();
            return aVar;
        }
        return (h3a) invokeL.objValue;
    }

    @Override // com.baidu.tieba.b3a.b, com.baidu.tieba.t3a
    public /* bridge */ /* synthetic */ Object call(Object obj) {
        return call((h3a) ((h3a) obj));
    }
}
