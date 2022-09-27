package com.baidu.tieba;

import android.app.Activity;
import android.text.TextUtils;
import android.util.Log;
import android.util.Pair;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.tieba.q83;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.webkit.sdk.dumper.ZeusCrashHandler;
import java.util.HashMap;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class be3 extends or1 {
    public static /* synthetic */ Interceptable $ic;
    public static final ei3<le3<ke3>> f;
    public static final ei3<le3<List<ke3>>> g;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes3.dex */
    public class a implements oy2 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Activity a;
        public final /* synthetic */ je3 b;
        public final /* synthetic */ String c;
        public final /* synthetic */ be3 d;

        /* renamed from: com.baidu.tieba.be3$a$a  reason: collision with other inner class name */
        /* loaded from: classes3.dex */
        public class C0211a implements ei3<le3<ke3>> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ a a;

            public C0211a(a aVar) {
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

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.ei3
            /* renamed from: b */
            public void a(le3<ke3> le3Var) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, le3Var) == null) {
                    if (le3Var.a != 0) {
                        l02.i("WifiApi", "connectWifi: " + le3Var.a + ZeusCrashHandler.NAME_SEPERATOR + le3Var.b);
                    }
                    JSONObject jSONObject = null;
                    if (le3Var.c != null) {
                        jSONObject = new JSONObject();
                        try {
                            jSONObject.put("wifi", le3Var.c.n());
                        } catch (JSONException e) {
                            l02.i("WifiApi", "getConnectedWifi: " + le3Var.a + ZeusCrashHandler.NAME_SEPERATOR + le3Var.b + ZeusCrashHandler.NAME_SEPERATOR + le3Var.c + "\n" + Log.getStackTraceString(e));
                        }
                    }
                    a aVar = this.a;
                    aVar.d.d(aVar.c, jSONObject == null ? new lv1(le3Var.a, le3Var.b) : new lv1(le3Var.a, le3Var.b, jSONObject));
                }
            }
        }

        public a(be3 be3Var, Activity activity, je3 je3Var, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {be3Var, activity, je3Var, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.d = be3Var;
            this.a = activity;
            this.b = je3Var;
            this.c = str;
        }

        @Override // com.baidu.tieba.oy2
        public void a(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                ie3.s(this.a).a(this.b, new C0211a(this));
            }
        }

        @Override // com.baidu.tieba.oy2
        public void b(int i, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, str) == null) {
                l02.i("WifiApi", "connectWifi: 12012 : no location permission");
                this.d.d(this.c, new lv1(12012, "no location permission"));
            }
        }
    }

    /* loaded from: classes3.dex */
    public static class b implements ei3<le3<ke3>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public b() {
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
        @Override // com.baidu.tieba.ei3
        /* renamed from: b */
        public void a(le3<ke3> le3Var) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, le3Var) == null) || le3Var == null || le3Var.a != 0 || le3Var.c == null) {
                return;
            }
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("wifiInfo", le3Var.c);
            } catch (JSONException e) {
                l02.c("WifiApi", "dispatch event onWifiConnected: " + Log.getStackTraceString(e));
            }
            HashMap hashMap = new HashMap();
            hashMap.put("data", jSONObject.toString());
            yo2.U().u(new md2("wifiConnected", hashMap));
        }
    }

    /* loaded from: classes3.dex */
    public static class c implements ei3<le3<List<ke3>>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public c() {
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
        @Override // com.baidu.tieba.ei3
        /* renamed from: b */
        public void a(le3<List<ke3>> le3Var) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, le3Var) == null) || le3Var == null || le3Var.a != 0 || le3Var.c == null) {
                return;
            }
            JSONObject jSONObject = new JSONObject();
            JSONArray jSONArray = new JSONArray();
            for (ke3 ke3Var : le3Var.c) {
                jSONArray.put(ke3Var);
            }
            try {
                jSONObject.put("wifiList", jSONArray);
            } catch (JSONException e) {
                l02.c("WifiApi", "dispatch event onGetWifiList: " + Log.getStackTraceString(e));
            }
            HashMap hashMap = new HashMap();
            hashMap.put("data", jSONObject.toString());
            yo2.U().u(new md2("getWifiList", hashMap));
        }
    }

    /* loaded from: classes3.dex */
    public class d implements ei3<le3<Void>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ be3 b;

        public d(be3 be3Var, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {be3Var, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = be3Var;
            this.a = str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.ei3
        /* renamed from: b */
        public void a(le3<Void> le3Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, le3Var) == null) {
                if (le3Var.a != 0) {
                    l02.i("WifiApi", "startWifi: " + le3Var.a + ZeusCrashHandler.NAME_SEPERATOR + le3Var.b);
                }
                this.b.d(this.a, new lv1(le3Var.a, le3Var.b));
            }
        }
    }

    /* loaded from: classes3.dex */
    public class e implements ei3<le3<Void>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ be3 b;

        public e(be3 be3Var, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {be3Var, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = be3Var;
            this.a = str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.ei3
        /* renamed from: b */
        public void a(le3<Void> le3Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, le3Var) == null) {
                if (le3Var.a != 0) {
                    l02.i("WifiApi", "stopWifi: " + le3Var.a + ZeusCrashHandler.NAME_SEPERATOR + le3Var.b);
                }
                this.b.d(this.a, new lv1(le3Var.a, le3Var.b));
            }
        }
    }

    /* loaded from: classes3.dex */
    public class f implements ei3<o83<q83.e>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ be3 b;

        public f(be3 be3Var, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {be3Var, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = be3Var;
            this.a = str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.ei3
        /* renamed from: b */
        public void a(o83<q83.e> o83Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, o83Var) == null) {
                if (j83.h(o83Var)) {
                    this.b.F(this.a);
                    return;
                }
                int b = o83Var.b();
                l02.i("WifiApi", "getWifiList: " + b + ZeusCrashHandler.NAME_SEPERATOR + j83.f(b));
                this.b.d(this.a, new lv1(b, j83.f(b)));
            }
        }
    }

    /* loaded from: classes3.dex */
    public class g implements oy2 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Activity a;
        public final /* synthetic */ String b;
        public final /* synthetic */ be3 c;

        /* loaded from: classes3.dex */
        public class a implements ei3<le3<Void>> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ g a;

            public a(g gVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {gVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = gVar;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.ei3
            /* renamed from: b */
            public void a(le3<Void> le3Var) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, le3Var) == null) {
                    if (le3Var.a != 0) {
                        l02.i("WifiApi", "getWifiList: " + le3Var.a + ZeusCrashHandler.NAME_SEPERATOR + le3Var.b);
                    }
                    g gVar = this.a;
                    gVar.c.d(gVar.b, new lv1(le3Var.a, le3Var.b));
                }
            }
        }

        public g(be3 be3Var, Activity activity, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {be3Var, activity, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = be3Var;
            this.a = activity;
            this.b = str;
        }

        @Override // com.baidu.tieba.oy2
        public void a(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                ie3.s(this.a).c(new a(this));
            }
        }

        @Override // com.baidu.tieba.oy2
        public void b(int i, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, str) == null) {
                l02.i("WifiApi", "getWifiList: 12012 : no location permission");
                this.c.d(this.b, new lv1(12012, "no location permission"));
            }
        }
    }

    /* loaded from: classes3.dex */
    public class h implements ei3<o83<q83.e>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ be3 b;

        public h(be3 be3Var, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {be3Var, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = be3Var;
            this.a = str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.ei3
        /* renamed from: b */
        public void a(o83<q83.e> o83Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, o83Var) == null) {
                if (j83.h(o83Var)) {
                    this.b.E(this.a);
                    return;
                }
                int b = o83Var.b();
                l02.i("WifiApi", "getConnectedWifi: " + b + ZeusCrashHandler.NAME_SEPERATOR + j83.f(b));
                this.b.d(this.a, new lv1(b, j83.f(b)));
            }
        }
    }

    /* loaded from: classes3.dex */
    public class i implements oy2 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Activity a;
        public final /* synthetic */ String b;
        public final /* synthetic */ be3 c;

        /* loaded from: classes3.dex */
        public class a implements ei3<le3<ke3>> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ i a;

            public a(i iVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {iVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = iVar;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.ei3
            /* renamed from: b */
            public void a(le3<ke3> le3Var) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, le3Var) == null) {
                    if (le3Var.a != 0) {
                        l02.i("WifiApi", "getConnectedWifi: " + le3Var.a + ZeusCrashHandler.NAME_SEPERATOR + le3Var.b);
                    }
                    JSONObject jSONObject = null;
                    if (le3Var.c != null) {
                        jSONObject = new JSONObject();
                        try {
                            jSONObject.put("wifi", le3Var.c.n());
                        } catch (JSONException e) {
                            l02.i("WifiApi", "getConnectedWifi: " + le3Var.a + ZeusCrashHandler.NAME_SEPERATOR + le3Var.b + ZeusCrashHandler.NAME_SEPERATOR + le3Var.c + "\n" + Log.getStackTraceString(e));
                        }
                    }
                    i iVar = this.a;
                    iVar.c.d(iVar.b, jSONObject == null ? new lv1(le3Var.a, le3Var.b) : new lv1(le3Var.a, le3Var.b, jSONObject));
                }
            }
        }

        public i(be3 be3Var, Activity activity, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {be3Var, activity, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = be3Var;
            this.a = activity;
            this.b = str;
        }

        @Override // com.baidu.tieba.oy2
        public void a(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                ie3.s(this.a).j(new a(this));
            }
        }

        @Override // com.baidu.tieba.oy2
        public void b(int i, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, str) == null) {
                l02.i("WifiApi", "getConnectedWifi: 12012 : no location permission");
                this.c.d(this.b, new lv1(12012, "no location permission"));
            }
        }
    }

    /* loaded from: classes3.dex */
    public class j implements ei3<o83<q83.e>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ je3 b;
        public final /* synthetic */ be3 c;

        public j(be3 be3Var, String str, je3 je3Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {be3Var, str, je3Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = be3Var;
            this.a = str;
            this.b = je3Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.ei3
        /* renamed from: b */
        public void a(o83<q83.e> o83Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, o83Var) == null) {
                if (j83.h(o83Var)) {
                    this.c.D(this.a, this.b);
                    return;
                }
                int b = o83Var.b();
                l02.i("WifiApi", "connectWifi: " + b + ZeusCrashHandler.NAME_SEPERATOR + j83.f(b));
                this.c.d(this.a, new lv1(b, j83.f(b)));
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947642041, "Lcom/baidu/tieba/be3;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947642041, "Lcom/baidu/tieba/be3;");
                return;
            }
        }
        f = new b();
        g = new c();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public be3(@NonNull mr1 mr1Var) {
        super(mr1Var);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {mr1Var};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((mr1) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    public lv1 A(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
            q("#connectWifi", false);
            l33 b0 = l33.b0();
            if (b0 == null) {
                l02.c("WifiApi", "connectWifi: 1001 : swan app is null");
                return new lv1(1001, "swan app is null");
            } else if (b0.w() == null) {
                l02.c("WifiApi", "connectWifi: 1001 : swan activity is null");
                return new lv1(1001, "swan activity is null");
            } else {
                Pair<lv1, JSONObject> s = s(str);
                lv1 lv1Var = (lv1) s.first;
                if (lv1Var.isSuccess()) {
                    JSONObject jSONObject = (JSONObject) s.second;
                    String optString = jSONObject.optString("cb");
                    if (TextUtils.isEmpty(optString)) {
                        l02.c("WifiApi", "connectWifi: 201 : callback is null");
                        return new lv1(201, "callback is null");
                    }
                    je3 a2 = je3.a(jSONObject);
                    if (TextUtils.isEmpty(a2.a)) {
                        l02.i("WifiApi", "connectWifi: 12008 : invalid ssid");
                        return new lv1(12008, "invalid ssid");
                    } else if (b0.n0()) {
                        l02.i("WifiApi", "connectWifi: 12011 : app is invisible");
                        return new lv1(12011, "app is invisible");
                    } else {
                        b0.e0().g(getContext(), "mapp_location", new j(this, optString, a2));
                        return lv1.f();
                    }
                }
                return lv1Var;
            }
        }
        return (lv1) invokeL.objValue;
    }

    public lv1 B(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
            q("#getConnectedWifi", false);
            l33 b0 = l33.b0();
            if (b0 == null) {
                l02.c("WifiApi", "getConnectedWifi: 1001 : swan app is null");
                return new lv1(1001, "swan app is null");
            } else if (b0.w() == null) {
                l02.c("WifiApi", "getConnectedWifi: 1001 : swan activity is null");
                return new lv1(1001, "swan activity is null");
            } else {
                Pair<lv1, JSONObject> s = s(str);
                lv1 lv1Var = (lv1) s.first;
                if (lv1Var.isSuccess()) {
                    String optString = ((JSONObject) s.second).optString("cb");
                    if (TextUtils.isEmpty(optString)) {
                        l02.c("WifiApi", "getConnectedWifi: 201 : callback is null");
                        return new lv1(201, "callback is null");
                    } else if (b0.n0()) {
                        l02.i("WifiApi", "getConnectedWifi: 12011 : app is invisible");
                        return new lv1(12011, "app is invisible");
                    } else {
                        b0.e0().g(getContext(), "mapp_location", new h(this, optString));
                        return lv1.f();
                    }
                }
                return lv1Var;
            }
        }
        return (lv1) invokeL.objValue;
    }

    public lv1 C(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
            q("#getWifiList", false);
            l33 b0 = l33.b0();
            if (b0 == null) {
                l02.c("WifiApi", "getWifiList: 1001 : swan app is null");
                return new lv1(1001, "swan app is null");
            } else if (b0.w() == null) {
                l02.c("WifiApi", "getWifiList: 1001 : swan activity is null");
                return new lv1(1001, "swan activity is null");
            } else {
                Pair<lv1, JSONObject> s = s(str);
                lv1 lv1Var = (lv1) s.first;
                if (lv1Var.isSuccess()) {
                    String optString = ((JSONObject) s.second).optString("cb");
                    if (TextUtils.isEmpty(optString)) {
                        l02.c("WifiApi", "getWifiList: 201 : callback is null");
                        return new lv1(201, "callback is null");
                    } else if (b0.n0()) {
                        l02.i("WifiApi", "getWifiList: 12011 : app is invisible");
                        return new lv1(12011, "app is invisible");
                    } else {
                        b0.e0().g(getContext(), "mapp_location", new f(this, optString));
                        return lv1.f();
                    }
                }
                return lv1Var;
            }
        }
        return (lv1) invokeL.objValue;
    }

    public final void D(String str, je3 je3Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048579, this, str, je3Var) == null) {
            SwanAppActivity w = k33.K().w();
            ny2.g(w, new String[]{com.kuaishou.weapon.p0.h.g, com.kuaishou.weapon.p0.h.h}, 0, new a(this, w, je3Var, str));
        }
    }

    public final void E(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, str) == null) {
            SwanAppActivity w = k33.K().w();
            ny2.g(w, new String[]{com.kuaishou.weapon.p0.h.g, com.kuaishou.weapon.p0.h.h}, 0, new i(this, w, str));
        }
    }

    public final void F(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, str) == null) {
            SwanAppActivity w = k33.K().w();
            ny2.g(w, new String[]{com.kuaishou.weapon.p0.h.g, com.kuaishou.weapon.p0.h.h}, 0, new g(this, w, str));
        }
    }

    public lv1 G(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, str)) == null) {
            q("#startWifi", false);
            l33 b0 = l33.b0();
            if (b0 == null) {
                l02.c("WifiApi", "startWifi: 1001 : swan app is null");
                return new lv1(1001, "swan app is null");
            }
            SwanAppActivity w = b0.w();
            if (w == null) {
                l02.c("WifiApi", "startWifi: 1001 : swan activity is null");
                return new lv1(1001, "swan activity is null");
            }
            Pair<lv1, JSONObject> s = s(str);
            lv1 lv1Var = (lv1) s.first;
            if (lv1Var.isSuccess()) {
                String optString = ((JSONObject) s.second).optString("cb");
                if (TextUtils.isEmpty(optString)) {
                    l02.c("WifiApi", "startWifi: 201 : callback is null");
                    return new lv1(201, "callback is null");
                }
                ie3 s2 = ie3.s(w);
                if (s2.n(f) && s2.d(g)) {
                    s2.p(new d(this, optString));
                    return lv1.f();
                }
                l02.i("WifiApi", "startWifi: 12010 : unknown failed");
                return new lv1(12010, "unknown failed");
            }
            return lv1Var;
        }
        return (lv1) invokeL.objValue;
    }

    public lv1 H(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, str)) == null) {
            q("#stopWifi", false);
            l33 b0 = l33.b0();
            if (b0 == null) {
                l02.c("WifiApi", "stopWifi: 1001 : swan app is null");
                return new lv1(1001, "swan app is null");
            }
            SwanAppActivity w = b0.w();
            if (w == null) {
                l02.c("WifiApi", "stopWifi: 1001 : swan activity is null");
                return new lv1(1001, "swan activity is null");
            }
            Pair<lv1, JSONObject> s = s(str);
            lv1 lv1Var = (lv1) s.first;
            if (lv1Var.isSuccess()) {
                String optString = ((JSONObject) s.second).optString("cb");
                if (TextUtils.isEmpty(optString)) {
                    l02.c("WifiApi", "stopWifi: 201 : callback is null");
                    return new lv1(201, "callback is null");
                }
                ie3 s2 = ie3.s(w);
                if (s2.r(f) && s2.b(g)) {
                    s2.q(new e(this, optString));
                    return lv1.f();
                }
                l02.i("WifiApi", "stopWifi: 12010 : unknown failed");
                return new lv1(12010, "unknown failed");
            }
            return lv1Var;
        }
        return (lv1) invokeL.objValue;
    }

    @Override // com.baidu.tieba.or1
    public String h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? "Wifi" : (String) invokeV.objValue;
    }

    @Override // com.baidu.tieba.or1
    public String j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? "WifiApi" : (String) invokeV.objValue;
    }
}
