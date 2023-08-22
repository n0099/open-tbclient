package com.baidu.tieba;

import android.text.TextUtils;
import android.webkit.JavascriptInterface;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.launch.utils.SpeedStatsUtils;
import com.baidu.searchbox.v8engine.JSExceptionType;
import com.baidu.searchbox.v8engine.JSRuntime;
import com.baidu.searchbox.v8engine.JsObject;
import com.baidu.searchbox.v8engine.V8JavascriptField;
import com.baidu.searchbox.v8engine.event.EventTargetImpl;
import com.baidu.searchbox.v8engine.event.JSEvent;
import com.baidu.tieba.f44;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Map;
import java.util.TreeMap;
/* loaded from: classes5.dex */
public class d44 extends EventTargetImpl implements g44, f44.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String a;
    @V8JavascriptField
    public String adUnitId;
    public ni2 b;
    public String c;
    public boolean d;
    public oy3 e;
    public tz3 f;
    public boolean g;
    public Map<String, String> h;
    public k44 i;
    public sy3 j;
    @V8JavascriptField
    public f44 style;

    /* loaded from: classes5.dex */
    public class a implements sy3 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ d44 a;

        public a(d44 d44Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {d44Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = d44Var;
        }

        @Override // com.baidu.tieba.sy3
        public void b(boolean z) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) != null) || this.a.i == null) {
                return;
            }
            if (z) {
                this.a.i.c();
            } else {
                this.a.i.b("3010010");
            }
        }

        @Override // com.baidu.tieba.sy3
        public void onError(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048581, this, str) == null) {
                JSEvent jSEvent = new JSEvent("error");
                jSEvent.data = e44.a(str);
                this.a.dispatchEvent(jSEvent);
                m04.k(this.a.h, str);
            }
        }

        @Override // com.baidu.tieba.sy3
        public void a(boolean z, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZL(1048576, this, z, str) == null) {
                String str2 = "gdtbanner";
                if (z) {
                    this.a.dispatchEvent(new JSEvent("load"));
                    if (!this.a.g) {
                        str2 = SpeedStatsUtils.UBC_VALUE_BANNER;
                    }
                    b44.b(str2, "success");
                    return;
                }
                if (!this.a.g) {
                    str2 = SpeedStatsUtils.UBC_VALUE_BANNER;
                }
                b44.c(str2, "fail", str);
            }
        }

        @Override // com.baidu.tieba.sy3
        public void c(int i, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeII(Constants.METHOD_SEND_USER_MSG, this, i, i2) == null) {
                JSEvent jSEvent = new JSEvent("resize");
                jSEvent.data = e44.b(i, i2);
                this.a.dispatchEvent(jSEvent);
            }
        }

        @Override // com.baidu.tieba.sy3
        public void onClick() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048579, this) == null) && this.a.g) {
                b44.b("gdtbanner", "click");
            }
        }

        @Override // com.baidu.tieba.sy3
        public void onClose() {
            String str;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
                this.a.destroy();
                qd4 A = qd4.A();
                String str2 = this.a.adUnitId;
                A.K(str2, "" + System.currentTimeMillis());
                if (this.a.g) {
                    str = "gdtbanner";
                } else {
                    str = SpeedStatsUtils.UBC_VALUE_BANNER;
                }
                b44.b(str, "close");
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ d44 a;

        public b(d44 d44Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {d44Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = d44Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                JSEvent jSEvent = new JSEvent("error");
                jSEvent.data = e44.a(this.a.c);
                this.a.dispatchEvent(jSEvent);
                m04.k(this.a.h, this.a.c);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d44(ni2 ni2Var, JsObject jsObject) {
        super(ni2Var);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {ni2Var, jsObject};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((JSRuntime) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.style = null;
        this.h = new TreeMap();
        this.j = new a(this);
        this.b = ni2Var;
        k32 F = k32.F(jsObject);
        if (F != null) {
            this.adUnitId = F.B("adUnitId");
            this.a = F.B("appSid");
            k32 w = F.w("style");
            if (w != null) {
                this.style = new f44(w);
            }
        }
        boolean e = x04.e();
        this.g = e;
        if (e) {
            this.a = x04.a();
            this.adUnitId = x04.b();
        }
        String str = this.a;
        String str2 = this.adUnitId;
        boolean z = this.g;
        String str3 = SpeedStatsUtils.UBC_VALUE_BANNER;
        Map<String, String> a2 = m04.a(SpeedStatsUtils.UBC_VALUE_BANNER, "game", str, str2, z);
        this.h = a2;
        m04.m("loadApi", a2);
        if (!A()) {
            return;
        }
        if (F != null && !TextUtils.isEmpty(this.adUnitId) && !TextUtils.isEmpty(this.a) && this.style != null) {
            z34 z34Var = new z34();
            this.f = z34Var;
            oy3 oy3Var = new oy3(this.a, this.adUnitId, this.j, z34Var);
            this.e = oy3Var;
            oy3Var.F(this.h);
            f44 f44Var = this.style;
            if (f44Var != null) {
                this.e.E(f44Var.left, f44Var.top, f44Var.width, f44Var.height);
                this.style.b(this);
            }
            b44.b(this.g ? "gdtbanner" : str3, null);
            return;
        }
        ni2Var.throwJSException(JSExceptionType.Error, "请求广告的必须参数为空,中断执行");
    }

    @Override // com.baidu.tieba.f44.a
    public void i(String str) {
        oy3 oy3Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048579, this, str) == null) && !this.d && !TextUtils.isEmpty(str) && !str.equals("height") && this.style != null && (oy3Var = this.e) != null) {
            oy3Var.H(str);
        }
    }

    public final boolean A() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            if (TextUtils.isEmpty(this.c)) {
                qd4 A = qd4.A();
                if (!A.k()) {
                    if (!A.l()) {
                        if (A.t(this.adUnitId)) {
                            this.c = "3010011";
                        }
                    } else {
                        this.c = "3010013";
                    }
                } else {
                    this.c = "3010012";
                }
            }
            if (!TextUtils.isEmpty(this.c)) {
                this.b.postOnJSThread(new b(this));
                b44.c(SpeedStatsUtils.UBC_VALUE_BANNER, "reject", this.c);
                return false;
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    @JavascriptInterface
    public void destroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.d = true;
            removeEventListener("error", null);
            removeEventListener("load", null);
            removeEventListener("resize", null);
            oy3 oy3Var = this.e;
            if (oy3Var != null) {
                oy3Var.y();
                this.e = null;
            }
        }
    }

    @JavascriptInterface
    public void hide() {
        oy3 oy3Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) && (oy3Var = this.e) != null) {
            oy3Var.B();
        }
    }

    @JavascriptInterface
    public void showAd(JsObject jsObject) {
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, jsObject) == null) {
            if (this.g) {
                str = "gdtbanner";
            } else {
                str = SpeedStatsUtils.UBC_VALUE_BANNER;
            }
            b44.d(str);
            m04.m("showApi", this.h);
            if (A() && this.e != null) {
                qd4.A().E();
                this.i = k44.d(k32.F(jsObject));
                this.e.G(jsObject);
            }
        }
    }
}
