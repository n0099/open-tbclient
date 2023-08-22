package com.baidu.tieba;

import com.baidu.tieba.q7c;
import com.baidu.tieba.r7c;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public final class eac<T> extends r7c<T> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final T b;

    /* loaded from: classes5.dex */
    public class a implements r7c.c<T> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Object a;

        public a(Object obj) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {obj};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = obj;
        }

        public void call(s7c<? super T> s7cVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, s7cVar) == null) {
                s7cVar.c((Object) this.a);
            }
        }

        @Override // com.baidu.tieba.r7c.c, com.baidu.tieba.b8c
        public /* bridge */ /* synthetic */ void call(Object obj) {
            call((s7c) ((s7c) obj));
        }
    }

    /* loaded from: classes5.dex */
    public static final class b<T> implements r7c.c<T> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final p9c a;
        public final T b;

        public b(p9c p9cVar, T t) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {p9cVar, t};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = p9cVar;
            this.b = t;
        }

        public void call(s7c<? super T> s7cVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, s7cVar) == null) {
                s7cVar.a(this.a.a(new d(s7cVar, this.b)));
            }
        }

        @Override // com.baidu.tieba.r7c.c, com.baidu.tieba.b8c
        public /* bridge */ /* synthetic */ void call(Object obj) {
            call((s7c) ((s7c) obj));
        }
    }

    /* loaded from: classes5.dex */
    public static final class c<T> implements r7c.c<T> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final q7c a;
        public final T b;

        public c(q7c q7cVar, T t) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {q7cVar, t};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = q7cVar;
            this.b = t;
        }

        public void call(s7c<? super T> s7cVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, s7cVar) == null) {
                q7c.a createWorker = this.a.createWorker();
                s7cVar.a(createWorker);
                createWorker.b(new d(s7cVar, this.b));
            }
        }

        @Override // com.baidu.tieba.r7c.c, com.baidu.tieba.b8c
        public /* bridge */ /* synthetic */ void call(Object obj) {
            call((s7c) ((s7c) obj));
        }
    }

    /* loaded from: classes5.dex */
    public static final class d<T> implements a8c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final s7c<? super T> a;
        public final T b;

        public d(s7c<? super T> s7cVar, T t) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {s7cVar, t};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = s7cVar;
            this.b = t;
        }

        /* JADX DEBUG: Type inference failed for r1v1. Raw type applied. Possible types: T, ? super T */
        @Override // com.baidu.tieba.a8c
        public void call() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                try {
                    this.a.c((T) this.b);
                } catch (Throwable th) {
                    this.a.b(th);
                }
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public eac(T t) {
        super(new a(t));
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {t};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((r7c.c) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.b = t;
    }

    public static <T> eac<T> m(T t) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, t)) == null) {
            return new eac<>(t);
        }
        return (eac) invokeL.objValue;
    }

    public r7c<T> n(q7c q7cVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, q7cVar)) == null) {
            if (q7cVar instanceof p9c) {
                return r7c.b(new b((p9c) q7cVar, this.b));
            }
            return r7c.b(new c(q7cVar, this.b));
        }
        return (r7c) invokeL.objValue;
    }
}
