package com.baidu.tieba;

import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.jb2;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.tencent.open.miniapp.MiniApp;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public abstract class i33 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public abstract uz1 b(JSONObject jSONObject);

    public abstract d33 f(e33 e33Var);

    public abstract String g();

    public abstract String h();

    public abstract uz1 j(String str, e33 e33Var);

    public abstract boolean k();

    public abstract uz1 m(e33 e33Var, g92<f33> g92Var);

    /* loaded from: classes4.dex */
    public class a implements jb2.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ e33 a;
        public final /* synthetic */ g92 b;
        public final /* synthetic */ i33 c;

        public a(i33 i33Var, e33 e33Var, g92 g92Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {i33Var, e33Var, g92Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = i33Var;
            this.a = e33Var;
            this.b = g92Var;
        }

        @Override // com.baidu.tieba.jb2.b
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                m33.b("payment fun page, your pkg is latest");
            }
        }

        @Override // com.baidu.tieba.jb2.b
        public void onSuccess() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                this.c.d(this.a, true, this.b);
            }
        }

        @Override // com.baidu.tieba.jb2.b
        public void b(nj3 nj3Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, nj3Var) == null) {
                this.c.d(this.a, false, this.b);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b implements pa2 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ e33 a;
        public final /* synthetic */ g92 b;
        public final /* synthetic */ i33 c;

        public b(i33 i33Var, e33 e33Var, g92 g92Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {i33Var, e33Var, g92Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = i33Var;
            this.a = e33Var;
            this.b = g92Var;
        }

        @Override // com.baidu.tieba.pa2
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.c.d(this.a, true, this.b);
            }
        }

        @Override // com.baidu.tieba.pa2
        public void b(int i, nj3 nj3Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, nj3Var) == null) {
                this.c.d(this.a, false, this.b);
            }
        }
    }

    public i33() {
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

    public final void c(e33 e33Var, String str, g92<f33> g92Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, e33Var, str, g92Var) == null) {
            m33.b("local has not main pkg, download fun page main pkg");
            wi4 wi4Var = new wi4(str, t73.K().k());
            wi4Var.q(0L);
            wi4Var.t(e33Var.c);
            wi4Var.d("3");
            ef4.c(wi4Var, new jb2(str, new a(this, e33Var, g92Var)));
        }
    }

    public final void e(e33 e33Var, d33 d33Var, g92<f33> g92Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048579, this, e33Var, d33Var, g92Var) == null) {
            m33.b("main pkg is exist, download fun page sub pkg");
            String str = d33Var.a;
            int i = d33Var.d;
            ef4.h(new zi4(str, i, s33.e(d33Var.c, d33Var.b), 0), new lb2(str, String.valueOf(i), new b(this, e33Var, g92Var)));
        }
    }

    public final void d(e33 e33Var, boolean z, g92<f33> g92Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{e33Var, Boolean.valueOf(z), g92Var}) == null) {
            if (z) {
                d33 f = f(e33Var);
                if (f != null && f.f) {
                    m33.b("payment fun page, download success, ready to jump");
                    j(f.c, e33Var);
                    return;
                }
                m33.b("payment fun page, download success, but not exist");
                f33 f33Var = new f33(e33Var.f);
                f33Var.a = e33Var.e;
                g92Var.a(f33Var);
                return;
            }
            m33.b("payment fun page, download failed");
            f33 f33Var2 = new f33(e33Var.f);
            f33Var2.a = e33Var.e;
            g92Var.a(f33Var2);
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

    public final uz1 l(e33 e33Var, g92<f33> g92Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048586, this, e33Var, g92Var)) == null) {
            m33.b("open fun page start");
            if (e33Var != null && e33Var.a()) {
                uz1 b2 = b(e33Var.g);
                if (b2 != null) {
                    m33.b("fun page args params invalid");
                    return b2;
                } else if (k()) {
                    m33.b("open payment fun page");
                    d33 f = f(e33Var);
                    if (f == null) {
                        return new uz1(1001, "fun page not exists");
                    }
                    if (!f.f) {
                        m33.b("payment fun page, " + e33Var.d + " mode");
                        if (i(e33Var.d)) {
                            if (f.e) {
                                e(e33Var, f, g92Var);
                            } else {
                                return new uz1(1001, "fun page not exists");
                            }
                        } else if (f.e) {
                            e(e33Var, f, g92Var);
                        } else {
                            c(e33Var, f.a, g92Var);
                        }
                        m33.b("open fun page end");
                        return new uz1(0);
                    }
                    return j(f.c, e33Var);
                } else {
                    m33.b("open user info or choose address fun page");
                    return m(e33Var, g92Var);
                }
            }
            m33.b("params parse fail");
            return new uz1(202, "params parse fail");
        }
        return (uz1) invokeLL.objValue;
    }
}
