package com.baidu.tieba;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.ix9;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import rx.internal.operators.CompletableOnSubscribeConcatIterable;
/* loaded from: classes3.dex */
public class dx9 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final f a;

    /* loaded from: classes3.dex */
    public static class a implements f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

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
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.dx9.f, com.baidu.tieba.tx9
        public void call(ex9 ex9Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, ex9Var) == null) {
                ex9Var.onSubscribe(c2a.c());
                ex9Var.onCompleted();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b implements f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ix9 a;
        public final /* synthetic */ dx9 b;

        /* loaded from: classes3.dex */
        public class a implements ex9 {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ ix9.a a;
            public final /* synthetic */ ex9 b;
            public final /* synthetic */ qz9 c;

            /* renamed from: com.baidu.tieba.dx9$b$a$a  reason: collision with other inner class name */
            /* loaded from: classes3.dex */
            public class C0227a implements sx9 {
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ a a;

                public C0227a(a aVar) {
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

                @Override // com.baidu.tieba.sx9
                public void call() {
                    Interceptable interceptable = $ic;
                    if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                        try {
                            this.a.b.onCompleted();
                        } finally {
                            this.a.c.unsubscribe();
                        }
                    }
                }
            }

            /* renamed from: com.baidu.tieba.dx9$b$a$b  reason: collision with other inner class name */
            /* loaded from: classes3.dex */
            public class C0228b implements sx9 {
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ Throwable a;
                public final /* synthetic */ a b;

                public C0228b(a aVar, Throwable th) {
                    Interceptable interceptable = $ic;
                    if (interceptable != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {aVar, th};
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
                    this.a = th;
                }

                @Override // com.baidu.tieba.sx9
                public void call() {
                    Interceptable interceptable = $ic;
                    if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                        try {
                            this.b.b.onError(this.a);
                        } finally {
                            this.b.c.unsubscribe();
                        }
                    }
                }
            }

            public a(b bVar, ix9.a aVar, ex9 ex9Var, qz9 qz9Var) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {bVar, aVar, ex9Var, qz9Var};
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
                this.b = ex9Var;
                this.c = qz9Var;
            }

            @Override // com.baidu.tieba.ex9
            public void onCompleted() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    this.a.b(new C0227a(this));
                }
            }

            @Override // com.baidu.tieba.ex9
            public void onError(Throwable th) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, th) == null) {
                    this.a.b(new C0228b(this, th));
                }
            }

            @Override // com.baidu.tieba.ex9
            public void onSubscribe(mx9 mx9Var) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, mx9Var) == null) {
                    this.c.a(mx9Var);
                }
            }
        }

        public b(dx9 dx9Var, ix9 ix9Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dx9Var, ix9Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = dx9Var;
            this.a = ix9Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.dx9.f, com.baidu.tieba.tx9
        public void call(ex9 ex9Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, ex9Var) == null) {
                qz9 qz9Var = new qz9();
                ix9.a createWorker = this.a.createWorker();
                qz9Var.a(createWorker);
                ex9Var.onSubscribe(qz9Var);
                this.b.j(new a(this, createWorker, ex9Var, qz9Var));
            }
        }
    }

    /* loaded from: classes3.dex */
    public class c implements ex9 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ a2a a;

        public c(dx9 dx9Var, a2a a2aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dx9Var, a2aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = a2aVar;
        }

        @Override // com.baidu.tieba.ex9
        public void onCompleted() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.unsubscribe();
            }
        }

        @Override // com.baidu.tieba.ex9
        public void onError(Throwable th) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, th) == null) {
                m1a.j(th);
                this.a.unsubscribe();
                dx9.c(th);
            }
        }

        @Override // com.baidu.tieba.ex9
        public void onSubscribe(mx9 mx9Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, mx9Var) == null) {
                this.a.a(mx9Var);
            }
        }
    }

    /* loaded from: classes3.dex */
    public static class d implements f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public d() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.dx9.f, com.baidu.tieba.tx9
        public void call(ex9 ex9Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, ex9Var) == null) {
                ex9Var.onSubscribe(c2a.c());
            }
        }
    }

    /* loaded from: classes3.dex */
    public class e implements f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ix9 a;
        public final /* synthetic */ dx9 b;

        /* loaded from: classes3.dex */
        public class a implements sx9 {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ ex9 a;
            public final /* synthetic */ ix9.a b;
            public final /* synthetic */ e c;

            public a(e eVar, ex9 ex9Var, ix9.a aVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {eVar, ex9Var, aVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.c = eVar;
                this.a = ex9Var;
                this.b = aVar;
            }

            @Override // com.baidu.tieba.sx9
            public void call() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    try {
                        this.c.b.j(this.a);
                    } finally {
                        this.b.unsubscribe();
                    }
                }
            }
        }

        public e(dx9 dx9Var, ix9 ix9Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dx9Var, ix9Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = dx9Var;
            this.a = ix9Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.dx9.f, com.baidu.tieba.tx9
        public void call(ex9 ex9Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, ex9Var) == null) {
                ix9.a createWorker = this.a.createWorker();
                createWorker.b(new a(this, ex9Var, createWorker));
            }
        }
    }

    /* loaded from: classes3.dex */
    public interface f extends tx9<ex9> {
        @Override // com.baidu.tieba.tx9
        /* synthetic */ void call(T t);
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947720068, "Lcom/baidu/tieba/dx9;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947720068, "Lcom/baidu/tieba/dx9;");
                return;
            }
        }
        new dx9(new a(), false);
        new dx9(new d(), false);
    }

    public dx9(f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {fVar};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.a = m1a.g(fVar);
    }

    public static dx9 a(Iterable<? extends dx9> iterable) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, iterable)) == null) {
            e(iterable);
            return b(new CompletableOnSubscribeConcatIterable(iterable));
        }
        return (dx9) invokeL.objValue;
    }

    public static dx9 b(f fVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, fVar)) == null) {
            e(fVar);
            try {
                return new dx9(fVar);
            } catch (NullPointerException e2) {
                throw e2;
            } catch (Throwable th) {
                m1a.j(th);
                throw i(th);
            }
        }
        return (dx9) invokeL.objValue;
    }

    public static void c(Throwable th) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65541, null, th) == null) {
            Thread currentThread = Thread.currentThread();
            currentThread.getUncaughtExceptionHandler().uncaughtException(currentThread, th);
        }
    }

    public static <T> T e(T t) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65542, null, t)) == null) {
            if (t != null) {
                return t;
            }
            throw null;
        }
        return (T) invokeL.objValue;
    }

    public static NullPointerException i(Throwable th) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65543, null, th)) == null) {
            NullPointerException nullPointerException = new NullPointerException("Actually not, but can't pass out an exception otherwise...");
            nullPointerException.initCause(th);
            return nullPointerException;
        }
        return (NullPointerException) invokeL.objValue;
    }

    public final dx9 d(ix9 ix9Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, ix9Var)) == null) {
            e(ix9Var);
            return b(new b(this, ix9Var));
        }
        return (dx9) invokeL.objValue;
    }

    public final mx9 f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            a2a a2aVar = new a2a();
            j(new c(this, a2aVar));
            return a2aVar;
        }
        return (mx9) invokeV.objValue;
    }

    public final void g(ex9 ex9Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, ex9Var) == null) {
            if (!(ex9Var instanceof f1a)) {
                ex9Var = new f1a(ex9Var);
            }
            j(ex9Var);
        }
    }

    public final dx9 h(ix9 ix9Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, ix9Var)) == null) {
            e(ix9Var);
            return b(new e(this, ix9Var));
        }
        return (dx9) invokeL.objValue;
    }

    public final void j(ex9 ex9Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, ex9Var) == null) {
            e(ex9Var);
            try {
                m1a.e(this, this.a).call(ex9Var);
            } catch (NullPointerException e2) {
                throw e2;
            } catch (Throwable th) {
                rx9.e(th);
                Throwable d2 = m1a.d(th);
                m1a.j(d2);
                throw i(d2);
            }
        }
    }

    public dx9(f fVar, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {fVar, Boolean.valueOf(z)};
            interceptable.invokeUnInit(65538, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.a = z ? m1a.g(fVar) : fVar;
    }
}
