package com.baidu.tieba;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Map;
/* loaded from: classes4.dex */
public abstract class gt<T> {
    public static /* synthetic */ Interceptable $ic;
    public static final Object j;
    public transient /* synthetic */ FieldHolder $fh;
    public final Object a;
    public jt<it<T>, gt<T>.c> b;
    public int c;
    public volatile Object d;
    public volatile Object e;
    public int f;
    public boolean g;
    public boolean h;
    public final Runnable i;

    /* loaded from: classes4.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ gt a;

        public a(gt gtVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gtVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = gtVar;
        }

        /* JADX DEBUG: Multi-variable search result rejected for r0v4, resolved type: com.baidu.tieba.gt */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.lang.Runnable
        public void run() {
            Object obj;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                synchronized (this.a.a) {
                    obj = this.a.e;
                    this.a.e = gt.j;
                }
                this.a.p(obj);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b extends gt<T>.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(gt gtVar, it<T> itVar) {
            super(gtVar, itVar);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gtVar, itVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super((gt) objArr2[0], (it) objArr2[1]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
        }

        @Override // com.baidu.tieba.gt.c
        public boolean b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return true;
            }
            return invokeV.booleanValue;
        }
    }

    /* loaded from: classes4.dex */
    public abstract class c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final it<T> a;
        public boolean b;
        public int c;
        public final /* synthetic */ gt d;

        public c(gt gtVar, it<T> itVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gtVar, itVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.d = gtVar;
            this.c = -1;
            this.a = itVar;
        }

        public void a(boolean z) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeZ(1048576, this, z) == null) || z == this.b) {
                return;
            }
            this.b = z;
            boolean z2 = this.d.c == 0;
            this.d.c += this.b ? 1 : -1;
            if (z2 && this.b) {
                this.d.m();
            }
            if (this.d.c == 0 && !this.b) {
                this.d.n();
            }
            if (this.b) {
                this.d.j(this);
            }
        }

        public abstract boolean b();
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1448305760, "Lcom/baidu/tieba/gt;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1448305760, "Lcom/baidu/tieba/gt;");
                return;
            }
        }
        j = new Object();
    }

    public gt() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.a = new Object();
        this.b = new jt<>();
        this.c = 0;
        this.d = j;
        this.e = j;
        this.f = -1;
        this.i = new a(this);
    }

    public static void h(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65545, null, str) == null) || rt.b()) {
            return;
        }
        throw new IllegalStateException("Cannot invoke " + str + " on a background thread");
    }

    /* JADX DEBUG: Multi-variable search result rejected for r5v1, resolved type: com.baidu.tieba.it<T> */
    /* JADX WARN: Multi-variable type inference failed */
    public final void i(gt<T>.c cVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048576, this, cVar) == null) && cVar.b) {
            if (!cVar.b()) {
                cVar.a(false);
                return;
            }
            int i = cVar.c;
            int i2 = this.f;
            if (i >= i2) {
                return;
            }
            cVar.c = i2;
            cVar.a.onChanged(this.d);
        }
    }

    public final void j(gt<T>.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, cVar) == null) {
            if (this.g) {
                this.h = true;
                return;
            }
            this.g = true;
            do {
                this.h = false;
                if (cVar != null) {
                    i(cVar);
                    cVar = null;
                } else {
                    jt<it<T>, gt<T>.c>.d f = this.b.f();
                    while (f.hasNext()) {
                        i((c) ((Map.Entry) f.next()).getValue());
                        if (this.h) {
                            break;
                        }
                    }
                }
            } while (this.h);
            this.g = false;
        }
    }

    public T k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            T t = (T) this.d;
            if (t != j) {
                return t;
            }
            return null;
        }
        return (T) invokeV.objValue;
    }

    public void l(it<T> itVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, itVar) == null) {
            b bVar = new b(this, itVar);
            if (this.b.d(itVar, bVar) != null) {
                return;
            }
            bVar.a(true);
        }
    }

    public void m() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
        }
    }

    public void n() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
        }
    }

    public void o(T t) {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, t) == null) {
            synchronized (this.a) {
                z = this.e == j;
                this.e = t;
            }
            if (z) {
                rt.c(this.i);
            }
        }
    }

    public void p(T t) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, t) == null) {
            h("setValue");
            this.f++;
            this.d = t;
            j(null);
        }
    }
}
