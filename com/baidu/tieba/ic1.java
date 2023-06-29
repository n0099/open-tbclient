package com.baidu.tieba;

import android.webkit.WebView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public final class ic1 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final a a;
    public long b;
    public final jc1 c;
    public boolean d;
    public final fc1 e;

    /* loaded from: classes6.dex */
    public static final class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public String a;
        public String b;
        public String c;
        public String d;
        public String e;
        public String f;
        public String g;
        public String h;

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
            this.a = "";
            this.b = "";
            this.c = "";
            this.d = "";
            this.e = "";
            this.f = "";
            this.g = "";
            this.h = "";
        }

        public final String a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return this.d;
            }
            return (String) invokeV.objValue;
        }

        public final String b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                return this.c;
            }
            return (String) invokeV.objValue;
        }

        public final String c() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                return this.f;
            }
            return (String) invokeV.objValue;
        }

        public final String d() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
                return this.e;
            }
            return (String) invokeV.objValue;
        }

        public final String e() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
                return this.h;
            }
            return (String) invokeV.objValue;
        }

        public final String f() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
                return this.b;
            }
            return (String) invokeV.objValue;
        }

        public final String g() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
                return this.a;
            }
            return (String) invokeV.objValue;
        }

        public final String h() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
                return this.g;
            }
            return (String) invokeV.objValue;
        }

        public final void i(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str) == null) {
                Intrinsics.checkNotNullParameter(str, "<set-?>");
                this.d = str;
            }
        }

        public final void j(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048585, this, str) == null) {
                Intrinsics.checkNotNullParameter(str, "<set-?>");
                this.c = str;
            }
        }

        public final void k(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048586, this, str) == null) {
                Intrinsics.checkNotNullParameter(str, "<set-?>");
                this.f = str;
            }
        }

        public final void l(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048587, this, str) == null) {
                Intrinsics.checkNotNullParameter(str, "<set-?>");
                this.e = str;
            }
        }

        public final void m(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048588, this, str) == null) {
                Intrinsics.checkNotNullParameter(str, "<set-?>");
                this.h = str;
            }
        }

        public final void n(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048589, this, str) == null) {
                Intrinsics.checkNotNullParameter(str, "<set-?>");
                this.b = str;
            }
        }

        public final void o(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048590, this, str) == null) {
                Intrinsics.checkNotNullParameter(str, "<set-?>");
                this.a = str;
            }
        }

        public final void p(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048591, this, str) == null) {
                Intrinsics.checkNotNullParameter(str, "<set-?>");
                this.g = str;
            }
        }
    }

    public ic1(fc1 fc1Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {fc1Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.e = fc1Var;
        this.a = new a();
        this.b = -1L;
        this.c = new jc1();
    }

    public final void a() {
        String str;
        String str2;
        String jSONObject;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            a aVar = this.a;
            fc1 fc1Var = this.e;
            if (fc1Var == null || (str = fc1Var.h) == null) {
                fc1 fc1Var2 = this.e;
                if (fc1Var2 != null) {
                    str = fc1Var2.a;
                } else {
                    str = null;
                }
            }
            if (str == null) {
                str = "";
            }
            aVar.o(str);
            this.a.i(String.valueOf(this.b));
            this.a.k(String.valueOf((((float) ((System.currentTimeMillis() - this.c.c()) + this.c.b())) * 1.0f) / ((float) 1000)));
            a aVar2 = this.a;
            if (!zt0.a()) {
                str2 = "0";
            } else {
                str2 = "1";
            }
            aVar2.p(str2);
            a aVar3 = this.a;
            try {
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("Nairobi", "0");
                Unit unit = Unit.INSTANCE;
                jSONObject = jSONObject2.toString();
                Intrinsics.checkNotNullExpressionValue(jSONObject, "JSONObject().apply {\n   …\n            }.toString()");
            } catch (JSONException unused) {
                jSONObject = new JSONObject().toString();
                Intrinsics.checkNotNullExpressionValue(jSONObject, "JSONObject().toString()");
            }
            aVar3.m(jSONObject);
        }
    }

    public final void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            a();
            y31 g = new y31().g("1029");
            Intrinsics.checkNotNullExpressionValue(g, "PlogBuilder().setCID(Plo…lder.C_ID_LP_PERFORMANCE)");
            g.b("f2", this.a.g());
            g.b("f14", this.a.f());
            g.b("ef2", this.a.b());
            g.b("ef3", this.a.a());
            g.b("ef4", this.a.d());
            g.b("ef5", this.a.c());
            g.b("ef12", this.a.h());
            g.b("ef15", this.a.e());
            r31.b(g);
        }
    }

    public final void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            a aVar = this.a;
            fc1 fc1Var = this.e;
            aVar.n((fc1Var == null || (r1 = fc1Var.f) == null) ? "" : "");
        }
    }

    public final void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.a.j(String.valueOf(System.currentTimeMillis()));
            this.c.f(System.currentTimeMillis());
            b();
        }
    }

    public final void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            i();
            this.c.e();
        }
    }

    public final void e(WebView webView) {
        String obj;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, webView) == null) {
            Intrinsics.checkNotNullParameter(webView, "webView");
            this.b = System.currentTimeMillis();
            Object tag = webView.getTag(R.id.nad_webcontent_error_code);
            a aVar = this.a;
            if (tag == null) {
                obj = "0";
            } else {
                obj = tag.toString();
            }
            aVar.l(obj);
        }
    }

    public final void g(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048582, this, i) == null) {
            this.a.l(String.valueOf(i));
        }
    }

    public final void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            this.c.h(System.currentTimeMillis());
            long c = this.c.c() - this.c.d();
            if (c < 0) {
                c = 0;
            }
            jc1 jc1Var = this.c;
            jc1Var.g(jc1Var.b() + c);
        }
    }

    public final void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            this.c.i(System.currentTimeMillis());
            if (!this.d) {
                long d = this.c.d() - this.c.a();
                if (d < 0) {
                    d = 0;
                }
                this.c.g(d);
                this.d = true;
            }
        }
    }
}
