package com.baidu.tieba;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import android.view.View;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.launch.utils.SpeedStatsUtils;
import com.baidu.searchbox.v8engine.JsObject;
import com.baidu.swan.game.ad.downloader.model.DownloadParams;
import com.baidu.swan.game.ad.entity.AdElementInfo;
import com.baidu.swan.game.ad.jsbridge.CommandType;
import com.baidu.tieba.iz3;
import com.baidu.tieba.w04;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Map;
import java.util.TreeMap;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class gz3 implements h04, iz3.e {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Context a;
    public String b;
    public String c;
    public kz3 d;
    public hz3 e;
    public v04 f;
    public AdElementInfo g;
    public iz3 h;
    public boolean i;
    public String j;
    public boolean k;
    public oz3 l;
    public Map<String, String> m;
    public l04 n;

    /* loaded from: classes6.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ gz3 a;

        public a(gz3 gz3Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gz3Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = gz3Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.a.h != null && this.a.h.f() != null && this.a.n.c(this.a.h.f())) {
                this.a.n.removeView(this.a.h.f());
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b implements j04 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ gz3 a;

        @Override // com.baidu.tieba.j04
        public void d(String str, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, str, str2) == null) {
            }
        }

        public b(gz3 gz3Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gz3Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = gz3Var;
        }

        @Override // com.baidu.tieba.j04
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

    /* loaded from: classes6.dex */
    public class c implements f04 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ gz3 a;

        public c(gz3 gz3Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gz3Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = gz3Var;
        }

        @Override // com.baidu.tieba.f04
        public void b(CommandType commandType, Uri uri) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLL(1048576, this, commandType, uri) == null) && this.a.g != null) {
                String clickUrl = this.a.g.getClickUrl();
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.putOpt("monitorUrl", e14.b("landingPageLoad", this.a.m));
                } catch (JSONException unused) {
                }
                this.a.n.a(clickUrl, jSONObject);
                e14.g(this.a.g, this.a.f);
                e14.n("lpClick", this.a.m, this.a.f);
                e14.n("click", this.a.m, this.a.f);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class d implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ gz3 b;

        public d(gz3 gz3Var, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gz3Var, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = gz3Var;
            this.a = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            boolean z;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                hz3 hz3Var = this.b.e;
                if (hz3Var.c != hz3Var.e) {
                    z = true;
                } else {
                    z = false;
                }
                this.b.x();
                if (this.b.h != null) {
                    this.b.h.e(this.b.e.c);
                    this.b.n.f(this.b.h.f(), new fz3(o14.a(this.b.e.a), o14.a(this.b.e.b), o14.a(this.b.e.e), o14.a(this.b.e.f)));
                }
                if (this.a.equals("width") && z && this.b.d != null) {
                    kz3 kz3Var = this.b.d;
                    hz3 hz3Var2 = this.b.e;
                    kz3Var.c(hz3Var2.e, hz3Var2.f);
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class e implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ gz3 a;

        public e(gz3 gz3Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gz3Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = gz3Var;
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
                    e14.n("showSuccess", this.a.m, this.a.f);
                    if (this.a.i) {
                        return;
                    }
                    this.a.i = true;
                    if (this.a.k) {
                        g14.f(this.a.g, this.a.f);
                        return;
                    }
                    e14.j(this.a.g, this.a.f);
                    String str = this.a.c;
                    gz3 gz3Var = this.a;
                    e14.f(str, gz3Var.b, gz3Var.j, this.a.f);
                    e14.n("show", this.a.m, this.a.f);
                } else if (this.a.d != null) {
                    this.a.d.b(false);
                    this.a.d.onError("3010010");
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class f implements j04 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ gz3 a;

        @Override // com.baidu.tieba.j04
        public void f(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view2) == null) {
            }
        }

        public f(gz3 gz3Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gz3Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = gz3Var;
        }

        @Override // com.baidu.tieba.j04
        public void d(String str, String str2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLL(1048576, this, str, str2) == null) && !TextUtils.isEmpty(str2)) {
                try {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("url", str2);
                    if (this.a.l == null) {
                        this.a.l = new oz3(this.a.a, this.a.g, this.a.f);
                    }
                    this.a.l.k(str);
                    n04.b().d(this.a.a, jSONObject, DownloadParams.SwanAppDownloadType.TYPE_START_DOWNLOAD, this.a.l);
                } catch (JSONException unused) {
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class g implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ gz3 a;

        public g(gz3 gz3Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gz3Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = gz3Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.a.h != null) {
                this.a.h.g();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class h implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ gz3 a;

        public h(gz3 gz3Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gz3Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = gz3Var;
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

    public gz3(String str, String str2, kz3 kz3Var, l04 l04Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, str2, kz3Var, l04Var};
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
        this.d = kz3Var;
        this.n = l04Var;
        this.f = new v04(appContext);
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
            k14.c(new e(this));
        }
    }

    public void H(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, str) == null) {
            k14.c(new d(this, str));
        }
    }

    @Override // com.baidu.tieba.h04
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
            g14.d(adElementInfo, this.f);
            d14 d14Var = new d14();
            d14Var.a = String.valueOf(this.e.c);
            d14Var.b = String.valueOf(this.e.d);
            d14Var.c = String.valueOf(this.e.c);
            d14Var.d = String.valueOf(this.e.d);
            d14Var.e = String.valueOf((int) view2.getX());
            d14Var.f = String.valueOf((int) view2.getY());
            d14Var.g = String.valueOf((int) view2.getX());
            d14Var.h = String.valueOf((int) view2.getY());
            if (this.g.getActionType() == 2) {
                g14.a(d14Var, this.g, this.f, new f(this));
                return;
            }
            AdElementInfo adElementInfo2 = this.g;
            if (adElementInfo2 != null) {
                this.n.a(g14.c(adElementInfo2.getClickUrl(), d14Var), new JSONObject());
            }
        }
    }

    public void B() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            k14.c(new g(this));
        }
    }

    @Override // com.baidu.tieba.iz3.e
    public void b() {
        kz3 kz3Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048585, this) == null) && (kz3Var = this.d) != null) {
            kz3Var.onClose();
        }
    }

    public void y() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            k14.c(new h(this));
        }
    }

    public final void C() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            iz3 iz3Var = new iz3(this.a, this.g, this.b, this.k);
            this.h = iz3Var;
            iz3Var.i(this);
            if (this.k) {
                this.h.k(new b(this));
            } else {
                this.h.j(new c(this));
            }
            this.h.e(this.e.c);
            if (this.n.c(this.h.f())) {
                this.n.removeView(this.h.f());
            }
            if (this.n.d(this.h.f(), new fz3(o14.a(this.e.a), o14.a(this.e.b), o14.a(this.e.e), o14.a(this.e.f)))) {
                kz3 kz3Var = this.d;
                if (kz3Var != null) {
                    kz3Var.a(true, "");
                    return;
                }
                return;
            }
            kz3 kz3Var2 = this.d;
            if (kz3Var2 != null) {
                kz3Var2.onError("3010000");
            }
        }
    }

    public final void D() {
        y04 x04Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            e14.n("loadApi", this.m, this.f);
            String appKey = n04.b().getAppKey();
            w04.b bVar = new w04.b();
            bVar.m(this.c);
            bVar.j(this.b);
            bVar.o(appKey);
            bVar.n("game");
            bVar.k(SpeedStatsUtils.UBC_VALUE_BANNER);
            bVar.l(this.e.c);
            bVar.i(this.e.d);
            w04 h2 = bVar.h();
            if (this.k) {
                x04Var = new z04(this.a, h2, 1, z());
            } else {
                x04Var = new x04(this.a, h2);
                this.j = x04Var.c();
            }
            t04 t04Var = new t04(this.a, false);
            t04Var.k(this);
            t04Var.i(x04Var, this.f);
        }
    }

    public final void w() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            iz3 iz3Var = new iz3(this.a);
            this.h = iz3Var;
            iz3Var.e(this.e.c);
            if (this.h.f() == null) {
                return;
            }
            if (this.n.c(this.h.f())) {
                this.n.removeView(this.h.f());
            }
            this.n.d(this.h.f(), new fz3(o14.a(this.e.a), o14.a(this.e.b), o14.a(this.e.e), o14.a(this.e.f)));
            this.h.f().postDelayed(new a(this), 20000L);
        }
    }

    public final void x() {
        hz3 hz3Var;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048588, this) != null) || (hz3Var = this.e) == null) {
            return;
        }
        if (o14.a(hz3Var.c) < 300) {
            this.e.c = o14.p(300.0f);
        }
        int k = n04.b().k();
        int j = n04.b().j();
        if (o14.a(this.e.c) > k) {
            this.e.c = o14.p(k);
        }
        hz3 hz3Var2 = this.e;
        hz3Var2.d = (int) (hz3Var2.c / jz3.a);
        if (hz3Var2.a < 0) {
            hz3Var2.a = 0;
        }
        int p = o14.p(k);
        hz3 hz3Var3 = this.e;
        int i = p - hz3Var3.c;
        if (hz3Var3.a > i) {
            hz3Var3.a = i;
        }
        hz3 hz3Var4 = this.e;
        if (hz3Var4.b < 0) {
            hz3Var4.b = 0;
        }
        int p2 = o14.p(j);
        hz3 hz3Var5 = this.e;
        int i2 = p2 - hz3Var5.d;
        if (hz3Var5.b > i2) {
            hz3Var5.b = i2;
        }
        hz3 hz3Var6 = this.e;
        hz3Var6.e = hz3Var6.c;
        hz3Var6.f = hz3Var6.d;
    }

    public void E(int i, int i2, int i3, int i4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIII(1048580, this, i, i2, i3, i4) == null) {
            this.e = new hz3(i, i2, i3, i4);
            x();
        }
    }

    @Override // com.baidu.tieba.h04
    public void a(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str) == null) {
            kz3 kz3Var = this.d;
            if (kz3Var != null) {
                kz3Var.onError(str);
            }
            String appId = n04.b().getAppId();
            if (appId.lastIndexOf("_dev") >= 0 && appId.lastIndexOf("_dev") < appId.length() && str.equals("201000")) {
                w();
            }
            kz3 kz3Var2 = this.d;
            if (kz3Var2 != null) {
                kz3Var2.a(false, "");
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
            int p = o14.p(n04.b().j());
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
