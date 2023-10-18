package com.baidu.tieba;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import android.view.View;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.v8engine.JsObject;
import com.baidu.swan.game.ad.downloader.model.DownloadParams;
import com.baidu.swan.game.ad.entity.AdElementInfo;
import com.baidu.swan.game.ad.jsbridge.CommandType;
import com.baidu.tieba.ct3;
import com.baidu.tieba.qu3;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Map;
import java.util.TreeMap;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class at3 implements bu3, ct3.e {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Context a;
    public String b;
    public String c;
    public et3 d;
    public bt3 e;
    public pu3 f;
    public AdElementInfo g;
    public ct3 h;
    public boolean i;
    public String j;
    public boolean k;
    public it3 l;
    public Map<String, String> m;
    public fu3 n;

    /* loaded from: classes5.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ at3 a;

        public a(at3 at3Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {at3Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = at3Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.a.h != null && this.a.h.f() != null && this.a.n.c(this.a.h.f())) {
                this.a.n.removeView(this.a.h.f());
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b implements du3 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ at3 a;

        @Override // com.baidu.tieba.du3
        public void d(String str, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, str, str2) == null) {
            }
        }

        public b(at3 at3Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {at3Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = at3Var;
        }

        @Override // com.baidu.tieba.du3
        public void f(View view2) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view2) != null) || !this.a.k) {
                return;
            }
            this.a.A(view2);
            if (this.a.d != null) {
                this.a.d.onClick();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class c implements zt3 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ at3 a;

        public c(at3 at3Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {at3Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = at3Var;
        }

        @Override // com.baidu.tieba.zt3
        public void b(CommandType commandType, Uri uri) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLL(1048576, this, commandType, uri) == null) && this.a.g != null) {
                String clickUrl = this.a.g.getClickUrl();
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.putOpt("monitorUrl", yu3.b("landingPageLoad", this.a.m));
                } catch (JSONException unused) {
                }
                this.a.n.a(clickUrl, jSONObject);
                yu3.g(this.a.g, this.a.f);
                yu3.n("lpClick", this.a.m, this.a.f);
                yu3.n("click", this.a.m, this.a.f);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class d implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ at3 b;

        public d(at3 at3Var, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {at3Var, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = at3Var;
            this.a = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            boolean z;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                bt3 bt3Var = this.b.e;
                if (bt3Var.c != bt3Var.e) {
                    z = true;
                } else {
                    z = false;
                }
                this.b.x();
                if (this.b.h != null) {
                    this.b.h.e(this.b.e.c);
                    this.b.n.f(this.b.h.f(), new zs3(iv3.a(this.b.e.a), iv3.a(this.b.e.b), iv3.a(this.b.e.e), iv3.a(this.b.e.f)));
                }
                if (this.a.equals("width") && z && this.b.d != null) {
                    et3 et3Var = this.b.d;
                    bt3 bt3Var2 = this.b.e;
                    et3Var.c(bt3Var2.e, bt3Var2.f);
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class e implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ at3 a;

        public e(at3 at3Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {at3Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = at3Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (this.a.h != null && this.a.n.c(this.a.h.f())) {
                    this.a.h.l();
                    if (this.a.d != null) {
                        this.a.d.b(true);
                    }
                    yu3.n("showSuccess", this.a.m, this.a.f);
                    if (this.a.i) {
                        return;
                    }
                    this.a.i = true;
                    if (this.a.k) {
                        av3.f(this.a.g, this.a.f);
                        return;
                    }
                    yu3.j(this.a.g, this.a.f);
                    String str = this.a.c;
                    at3 at3Var = this.a;
                    yu3.f(str, at3Var.b, at3Var.j, this.a.f);
                    yu3.n("show", this.a.m, this.a.f);
                } else if (this.a.d != null) {
                    this.a.d.b(false);
                    this.a.d.onError("3010010");
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class f implements du3 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ at3 a;

        @Override // com.baidu.tieba.du3
        public void f(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view2) == null) {
            }
        }

        public f(at3 at3Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {at3Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = at3Var;
        }

        @Override // com.baidu.tieba.du3
        public void d(String str, String str2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLL(1048576, this, str, str2) == null) && !TextUtils.isEmpty(str2)) {
                try {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("url", str2);
                    if (this.a.l == null) {
                        this.a.l = new it3(this.a.a, this.a.g, this.a.f);
                    }
                    this.a.l.k(str);
                    hu3.b().d(this.a.a, jSONObject, DownloadParams.SwanAppDownloadType.TYPE_START_DOWNLOAD, this.a.l);
                } catch (JSONException unused) {
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class g implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ at3 a;

        public g(at3 at3Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {at3Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = at3Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.a.h != null) {
                this.a.h.g();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class h implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ at3 a;

        public h(at3 at3Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {at3Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = at3Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (this.a.h != null) {
                    this.a.n.removeView(this.a.h.f());
                }
                this.a.h = null;
                this.a.d = null;
                this.a.g = null;
                if (this.a.l != null) {
                    this.a.l.i();
                    this.a.l = null;
                }
            }
        }
    }

    public at3(String str, String str2, et3 et3Var, fu3 fu3Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, str2, et3Var, fu3Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.e = null;
        this.m = new TreeMap();
        Context appContext = AppRuntime.getAppContext();
        this.a = appContext;
        this.c = str;
        this.b = str2;
        this.d = et3Var;
        this.n = fu3Var;
        this.f = new pu3(appContext);
        this.k = false;
        E(10, 10, 350, 50);
        D();
    }

    public void F(Map<String, String> map) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, map) == null) {
            this.m = map;
        }
    }

    public void G(JsObject jsObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, jsObject) == null) {
            ev3.c(new e(this));
        }
    }

    public void H(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, str) == null) {
            ev3.c(new d(this, str));
        }
    }

    @Override // com.baidu.tieba.bu3
    public void c(AdElementInfo adElementInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, adElementInfo) == null) {
            this.g = adElementInfo;
            C();
        }
    }

    public final void A(View view2) {
        AdElementInfo adElementInfo;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048576, this, view2) == null) && this.k && (adElementInfo = this.g) != null && this.e != null && view2 != null) {
            av3.d(adElementInfo, this.f);
            xu3 xu3Var = new xu3();
            xu3Var.a = String.valueOf(this.e.c);
            xu3Var.b = String.valueOf(this.e.d);
            xu3Var.c = String.valueOf(this.e.c);
            xu3Var.d = String.valueOf(this.e.d);
            xu3Var.e = String.valueOf((int) view2.getX());
            xu3Var.f = String.valueOf((int) view2.getY());
            xu3Var.g = String.valueOf((int) view2.getX());
            xu3Var.h = String.valueOf((int) view2.getY());
            if (this.g.getActionType() == 2) {
                av3.a(xu3Var, this.g, this.f, new f(this));
                return;
            }
            AdElementInfo adElementInfo2 = this.g;
            if (adElementInfo2 != null) {
                this.n.a(av3.c(adElementInfo2.getClickUrl(), xu3Var), new JSONObject());
            }
        }
    }

    public void B() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            ev3.c(new g(this));
        }
    }

    @Override // com.baidu.tieba.ct3.e
    public void b() {
        et3 et3Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048585, this) == null) && (et3Var = this.d) != null) {
            et3Var.onClose();
        }
    }

    public void y() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            ev3.c(new h(this));
        }
    }

    public final void C() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            ct3 ct3Var = new ct3(this.a, this.g, this.b, this.k);
            this.h = ct3Var;
            ct3Var.i(this);
            if (this.k) {
                this.h.k(new b(this));
            } else {
                this.h.j(new c(this));
            }
            this.h.e(this.e.c);
            if (this.n.c(this.h.f())) {
                this.n.removeView(this.h.f());
            }
            if (this.n.d(this.h.f(), new zs3(iv3.a(this.e.a), iv3.a(this.e.b), iv3.a(this.e.e), iv3.a(this.e.f)))) {
                et3 et3Var = this.d;
                if (et3Var != null) {
                    et3Var.a(true, "");
                    return;
                }
                return;
            }
            et3 et3Var2 = this.d;
            if (et3Var2 != null) {
                et3Var2.onError("3010000");
            }
        }
    }

    public final void D() {
        su3 ru3Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            yu3.n("loadApi", this.m, this.f);
            String appKey = hu3.b().getAppKey();
            qu3.b bVar = new qu3.b();
            bVar.m(this.c);
            bVar.j(this.b);
            bVar.o(appKey);
            bVar.n("game");
            bVar.k("banner");
            bVar.l(this.e.c);
            bVar.i(this.e.d);
            qu3 h2 = bVar.h();
            if (this.k) {
                ru3Var = new tu3(this.a, h2, 1, z());
            } else {
                ru3Var = new ru3(this.a, h2);
                this.j = ru3Var.c();
            }
            nu3 nu3Var = new nu3(this.a, false);
            nu3Var.k(this);
            nu3Var.i(ru3Var, this.f);
        }
    }

    public final void w() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            ct3 ct3Var = new ct3(this.a);
            this.h = ct3Var;
            ct3Var.e(this.e.c);
            if (this.h.f() == null) {
                return;
            }
            if (this.n.c(this.h.f())) {
                this.n.removeView(this.h.f());
            }
            this.n.d(this.h.f(), new zs3(iv3.a(this.e.a), iv3.a(this.e.b), iv3.a(this.e.e), iv3.a(this.e.f)));
            this.h.f().postDelayed(new a(this), 20000L);
        }
    }

    public final void x() {
        bt3 bt3Var;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048588, this) != null) || (bt3Var = this.e) == null) {
            return;
        }
        if (iv3.a(bt3Var.c) < 300) {
            this.e.c = iv3.p(300.0f);
        }
        int k = hu3.b().k();
        int j = hu3.b().j();
        if (iv3.a(this.e.c) > k) {
            this.e.c = iv3.p(k);
        }
        bt3 bt3Var2 = this.e;
        bt3Var2.d = (int) (bt3Var2.c / dt3.a);
        if (bt3Var2.a < 0) {
            bt3Var2.a = 0;
        }
        int p = iv3.p(k);
        bt3 bt3Var3 = this.e;
        int i = p - bt3Var3.c;
        if (bt3Var3.a > i) {
            bt3Var3.a = i;
        }
        bt3 bt3Var4 = this.e;
        if (bt3Var4.b < 0) {
            bt3Var4.b = 0;
        }
        int p2 = iv3.p(j);
        bt3 bt3Var5 = this.e;
        int i2 = p2 - bt3Var5.d;
        if (bt3Var5.b > i2) {
            bt3Var5.b = i2;
        }
        bt3 bt3Var6 = this.e;
        bt3Var6.e = bt3Var6.c;
        bt3Var6.f = bt3Var6.d;
    }

    public void E(int i, int i2, int i3, int i4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIII(1048580, this, i, i2, i3, i4) == null) {
            this.e = new bt3(i, i2, i3, i4);
            x();
        }
    }

    @Override // com.baidu.tieba.bu3
    public void a(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str) == null) {
            et3 et3Var = this.d;
            if (et3Var != null) {
                et3Var.onError(str);
            }
            String appId = hu3.b().getAppId();
            if (appId.lastIndexOf("_dev") >= 0 && appId.lastIndexOf("_dev") < appId.length() && str.equals("201000")) {
                w();
            }
            et3 et3Var2 = this.d;
            if (et3Var2 != null) {
                et3Var2.a(false, "");
            }
        }
    }

    public final int z() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            if (this.e == null) {
                return 2;
            }
            int p = iv3.p(hu3.b().j());
            int i = this.e.b;
            int i2 = p / 3;
            if (i < i2) {
                return 1;
            }
            if (i >= i2 * 2) {
                return 2;
            }
            return 4;
        }
        return invokeV.intValue;
    }
}
