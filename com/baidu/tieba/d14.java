package com.baidu.tieba;

import android.content.Context;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.v8engine.JsObject;
import com.baidu.swan.apps.binding.model.JSTypeMismatchException;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes3.dex */
public class d14 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public va2 a;
    public p64 b;
    public Context c;
    public sv1 d;
    public sv1 e;
    public sv1 f;
    public f14 g;
    public i14 h;
    public h14 i;
    public h14 j;
    public e14 k;
    public f l;

    /* loaded from: classes3.dex */
    public class a implements f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ d14 a;

        public a(d14 d14Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {d14Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = d14Var;
        }

        @Override // com.baidu.tieba.d14.f
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.j();
            }
        }

        @Override // com.baidu.tieba.d14.f
        public void b(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i) == null) {
                i14 i14Var = new i14();
                i14Var.errMsg = "showKeyboard:ok";
                i14Var.height = i;
                x54.call(this.a.d, true, i14Var);
            }
        }

        @Override // com.baidu.tieba.d14.f
        public void c(String str) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) || this.a.k == null) {
                return;
            }
            this.a.k.c(str);
        }

        @Override // com.baidu.tieba.d14.f
        public void d(String str) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048579, this, str) == null) || this.a.k == null) {
                return;
            }
            this.a.k.b(str);
        }

        @Override // com.baidu.tieba.d14.f
        public void e(String str) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048580, this, str) == null) || this.a.k == null) {
                return;
            }
            this.a.k.d(str);
        }
    }

    /* loaded from: classes3.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ d14 a;

        public b(d14 d14Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {d14Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = d14Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (!q64.p().n(this.a.b)) {
                    this.a.h.errMsg = "showKeyboard:fail";
                    x54.call(this.a.d, false, this.a.h);
                    return;
                }
                this.a.b.j(this.a.g);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ d14 a;

        public c(d14 d14Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {d14Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = d14Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (q64.p().s(this.a.b)) {
                    this.a.i.errMsg = "hideKeyboard:ok";
                    x54.call(this.a.e, true, this.a.i);
                    return;
                }
                this.a.i.errMsg = "hideKeyboard:fail";
                x54.call(this.a.e, false, this.a.i);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class d implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ d14 a;

        public d(d14 d14Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {d14Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = d14Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                q64.p().s(this.a.b);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class e implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ d14 b;

        public e(d14 d14Var, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {d14Var, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = d14Var;
            this.a = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (this.b.b.m(this.a)) {
                    this.b.j.errMsg = "updateKeyboard:ok";
                    x54.call(this.b.f, true, this.b.j);
                    return;
                }
                this.b.j.errMsg = "updateKeyboard:fail";
                x54.call(this.b.f, false, this.b.j);
            }
        }
    }

    /* loaded from: classes3.dex */
    public interface f {
        void a();

        void b(int i);

        void c(String str);

        void d(String str);

        void e(String str);
    }

    public d14(va2 va2Var, e14 e14Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {va2Var, e14Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.k = null;
        this.l = new a(this);
        this.a = va2Var;
        Context appContext = AppRuntime.getAppContext();
        this.c = appContext;
        p64 p64Var = new p64(appContext);
        this.b = p64Var;
        p64Var.i(this.l);
        this.k = e14Var;
    }

    public void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            fh3.e0(new d(this));
        }
    }

    public void k(JsObject jsObject) {
        p64 p64Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, jsObject) == null) {
            this.i = new h14();
            sv1 F = sv1.F(jsObject);
            this.e = F;
            if (F == null) {
                this.e = new sv1();
            }
            if (this.a != null && (p64Var = this.b) != null && p64Var.g()) {
                fh3.e0(new c(this));
                return;
            }
            h14 h14Var = this.i;
            h14Var.errMsg = "hideKeyboard:fail";
            x54.call(this.e, false, h14Var);
        }
    }

    public void l(JsObject jsObject) {
        p64 p64Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, jsObject) == null) {
            this.h = new i14();
            sv1 F = sv1.F(jsObject);
            this.d = F;
            if (F == null) {
                this.d = new sv1();
            }
            if (this.a != null && (p64Var = this.b) != null && !p64Var.g()) {
                f14 f14Var = new f14();
                this.g = f14Var;
                try {
                    if (f14Var.a(this.d)) {
                        fh3.f0(new b(this), 500L);
                    } else {
                        this.h.errMsg = "showKeyboard:fail";
                        x54.call(this.d, false, this.h);
                    }
                    return;
                } catch (JSTypeMismatchException unused) {
                    i14 i14Var = this.h;
                    i14Var.errMsg = "showKeyboard:fail";
                    x54.call(this.d, false, i14Var);
                    return;
                }
            }
            i14 i14Var2 = this.h;
            i14Var2.errMsg = "showKeyboard:fail";
            x54.call(this.d, false, i14Var2);
        }
    }

    public void m(JsObject jsObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, jsObject) == null) {
            this.j = new h14();
            sv1 F = sv1.F(jsObject);
            this.f = F;
            if (F == null) {
                this.f = new sv1();
            }
            if (this.a != null && this.b != null) {
                fh3.e0(new e(this, this.f.B("value")));
                return;
            }
            h14 h14Var = this.j;
            h14Var.errMsg = "updateKeyboard:fail";
            x54.call(this.f, false, h14Var);
        }
    }
}
