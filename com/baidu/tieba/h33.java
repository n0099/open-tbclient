package com.baidu.tieba;

import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.ib2;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.tencent.open.miniapp.MiniApp;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public abstract class h33 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public abstract tz1 b(JSONObject jSONObject);

    public abstract c33 f(d33 d33Var);

    public abstract String g();

    public abstract String h();

    public abstract tz1 j(String str, d33 d33Var);

    public abstract boolean k();

    public abstract tz1 m(d33 d33Var, f92<e33> f92Var);

    /* loaded from: classes4.dex */
    public class a implements ib2.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ d33 a;
        public final /* synthetic */ f92 b;
        public final /* synthetic */ h33 c;

        public a(h33 h33Var, d33 d33Var, f92 f92Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {h33Var, d33Var, f92Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = h33Var;
            this.a = d33Var;
            this.b = f92Var;
        }

        @Override // com.baidu.tieba.ib2.b
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                l33.b("payment fun page, your pkg is latest");
            }
        }

        @Override // com.baidu.tieba.ib2.b
        public void onSuccess() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                this.c.d(this.a, true, this.b);
            }
        }

        @Override // com.baidu.tieba.ib2.b
        public void b(mj3 mj3Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, mj3Var) == null) {
                this.c.d(this.a, false, this.b);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b implements oa2 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ d33 a;
        public final /* synthetic */ f92 b;
        public final /* synthetic */ h33 c;

        public b(h33 h33Var, d33 d33Var, f92 f92Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {h33Var, d33Var, f92Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = h33Var;
            this.a = d33Var;
            this.b = f92Var;
        }

        @Override // com.baidu.tieba.oa2
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.c.d(this.a, true, this.b);
            }
        }

        @Override // com.baidu.tieba.oa2
        public void b(int i, mj3 mj3Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, mj3Var) == null) {
                this.c.d(this.a, false, this.b);
            }
        }
    }

    public h33() {
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

    public final void c(d33 d33Var, String str, f92<e33> f92Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, d33Var, str, f92Var) == null) {
            l33.b("local has not main pkg, download fun page main pkg");
            vi4 vi4Var = new vi4(str, s73.K().k());
            vi4Var.q(0L);
            vi4Var.t(d33Var.c);
            vi4Var.d("3");
            df4.c(vi4Var, new ib2(str, new a(this, d33Var, f92Var)));
        }
    }

    public final void e(d33 d33Var, c33 c33Var, f92<e33> f92Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048579, this, d33Var, c33Var, f92Var) == null) {
            l33.b("main pkg is exist, download fun page sub pkg");
            String str = c33Var.a;
            int i = c33Var.d;
            df4.h(new yi4(str, i, r33.e(c33Var.c, c33Var.b), 0), new kb2(str, String.valueOf(i), new b(this, d33Var, f92Var)));
        }
    }

    public final void d(d33 d33Var, boolean z, f92<e33> f92Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{d33Var, Boolean.valueOf(z), f92Var}) == null) {
            if (z) {
                c33 f = f(d33Var);
                if (f != null && f.f) {
                    l33.b("payment fun page, download success, ready to jump");
                    j(f.c, d33Var);
                    return;
                }
                l33.b("payment fun page, download success, but not exist");
                e33 e33Var = new e33(d33Var.f);
                e33Var.a = d33Var.e;
                f92Var.a(e33Var);
                return;
            }
            l33.b("payment fun page, download failed");
            e33 e33Var2 = new e33(d33Var.f);
            e33Var2.a = d33Var.e;
            f92Var.a(e33Var2);
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

    public final tz1 l(d33 d33Var, f92<e33> f92Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048586, this, d33Var, f92Var)) == null) {
            l33.b("open fun page start");
            if (d33Var != null && d33Var.a()) {
                tz1 b2 = b(d33Var.g);
                if (b2 != null) {
                    l33.b("fun page args params invalid");
                    return b2;
                } else if (k()) {
                    l33.b("open payment fun page");
                    c33 f = f(d33Var);
                    if (f == null) {
                        return new tz1(1001, "fun page not exists");
                    }
                    if (!f.f) {
                        l33.b("payment fun page, " + d33Var.d + " mode");
                        if (i(d33Var.d)) {
                            if (f.e) {
                                e(d33Var, f, f92Var);
                            } else {
                                return new tz1(1001, "fun page not exists");
                            }
                        } else if (f.e) {
                            e(d33Var, f, f92Var);
                        } else {
                            c(d33Var, f.a, f92Var);
                        }
                        l33.b("open fun page end");
                        return new tz1(0);
                    }
                    return j(f.c, d33Var);
                } else {
                    l33.b("open user info or choose address fun page");
                    return m(d33Var, f92Var);
                }
            }
            l33.b("params parse fail");
            return new tz1(202, "params parse fail");
        }
        return (tz1) invokeLL.objValue;
    }
}
