package com.baidu.tieba;

import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.bd2;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.tencent.open.miniapp.MiniApp;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public abstract class a53 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public abstract m12 b(JSONObject jSONObject);

    public abstract v43 f(w43 w43Var);

    public abstract String g();

    public abstract String h();

    public abstract m12 j(String str, w43 w43Var);

    public abstract boolean k();

    public abstract m12 m(w43 w43Var, ya2<x43> ya2Var);

    /* loaded from: classes3.dex */
    public class a implements bd2.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ w43 a;
        public final /* synthetic */ ya2 b;
        public final /* synthetic */ a53 c;

        public a(a53 a53Var, w43 w43Var, ya2 ya2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {a53Var, w43Var, ya2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = a53Var;
            this.a = w43Var;
            this.b = ya2Var;
        }

        @Override // com.baidu.tieba.bd2.b
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                e53.b("payment fun page, your pkg is latest");
            }
        }

        @Override // com.baidu.tieba.bd2.b
        public void onSuccess() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                this.c.d(this.a, true, this.b);
            }
        }

        @Override // com.baidu.tieba.bd2.b
        public void b(fl3 fl3Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, fl3Var) == null) {
                this.c.d(this.a, false, this.b);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b implements hc2 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ w43 a;
        public final /* synthetic */ ya2 b;
        public final /* synthetic */ a53 c;

        public b(a53 a53Var, w43 w43Var, ya2 ya2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {a53Var, w43Var, ya2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = a53Var;
            this.a = w43Var;
            this.b = ya2Var;
        }

        @Override // com.baidu.tieba.hc2
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.c.d(this.a, true, this.b);
            }
        }

        @Override // com.baidu.tieba.hc2
        public void b(int i, fl3 fl3Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, fl3Var) == null) {
                this.c.d(this.a, false, this.b);
            }
        }
    }

    public a53() {
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

    public final void c(w43 w43Var, String str, ya2<x43> ya2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, w43Var, str, ya2Var) == null) {
            e53.b("local has not main pkg, download fun page main pkg");
            ok4 ok4Var = new ok4(str, l93.K().k());
            ok4Var.q(0L);
            ok4Var.t(w43Var.c);
            ok4Var.d("3");
            wg4.c(ok4Var, new bd2(str, new a(this, w43Var, ya2Var)));
        }
    }

    public final void e(w43 w43Var, v43 v43Var, ya2<x43> ya2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048579, this, w43Var, v43Var, ya2Var) == null) {
            e53.b("main pkg is exist, download fun page sub pkg");
            String str = v43Var.a;
            int i = v43Var.d;
            wg4.h(new rk4(str, i, k53.e(v43Var.c, v43Var.b), 0), new dd2(str, String.valueOf(i), new b(this, w43Var, ya2Var)));
        }
    }

    public final void d(w43 w43Var, boolean z, ya2<x43> ya2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{w43Var, Boolean.valueOf(z), ya2Var}) == null) {
            if (z) {
                v43 f = f(w43Var);
                if (f != null && f.f) {
                    e53.b("payment fun page, download success, ready to jump");
                    j(f.c, w43Var);
                    return;
                }
                e53.b("payment fun page, download success, but not exist");
                x43 x43Var = new x43(w43Var.f);
                x43Var.a = w43Var.e;
                ya2Var.a(x43Var);
                return;
            }
            e53.b("payment fun page, download failed");
            x43 x43Var2 = new x43(w43Var.f);
            x43Var2.a = w43Var.e;
            ya2Var.a(x43Var2);
        }
    }

    public final boolean i(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, str)) == null) {
            return TextUtils.equals(str, MiniApp.MINIAPP_VERSION_DEVELOP);
        }
        return invokeL.booleanValue;
    }

    public final m12 l(w43 w43Var, ya2<x43> ya2Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048586, this, w43Var, ya2Var)) == null) {
            e53.b("open fun page start");
            if (w43Var != null && w43Var.a()) {
                m12 b2 = b(w43Var.g);
                if (b2 != null) {
                    e53.b("fun page args params invalid");
                    return b2;
                } else if (k()) {
                    e53.b("open payment fun page");
                    v43 f = f(w43Var);
                    if (f == null) {
                        return new m12(1001, "fun page not exists");
                    }
                    if (!f.f) {
                        e53.b("payment fun page, " + w43Var.d + " mode");
                        if (i(w43Var.d)) {
                            if (f.e) {
                                e(w43Var, f, ya2Var);
                            } else {
                                return new m12(1001, "fun page not exists");
                            }
                        } else if (f.e) {
                            e(w43Var, f, ya2Var);
                        } else {
                            c(w43Var, f.a, ya2Var);
                        }
                        e53.b("open fun page end");
                        return new m12(0);
                    }
                    return j(f.c, w43Var);
                } else {
                    e53.b("open user info or choose address fun page");
                    return m(w43Var, ya2Var);
                }
            }
            e53.b("params parse fail");
            return new m12(202, "params parse fail");
        }
        return (m12) invokeLL.objValue;
    }
}
