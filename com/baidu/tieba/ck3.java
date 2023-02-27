package com.baidu.tieba;

import android.app.Activity;
import android.text.TextUtils;
import android.util.Log;
import android.util.Pair;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.tieba.re3;
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
public class ck3 extends px1 {
    public static /* synthetic */ Interceptable $ic;
    public static final fo3<mk3<lk3>> f;
    public static final fo3<mk3<List<lk3>>> g;
    public transient /* synthetic */ FieldHolder $fh;

    @Override // com.baidu.tieba.px1
    public String h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? "Wifi" : (String) invokeV.objValue;
    }

    @Override // com.baidu.tieba.px1
    public String j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? "WifiApi" : (String) invokeV.objValue;
    }

    /* loaded from: classes3.dex */
    public class a implements p43 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Activity a;
        public final /* synthetic */ kk3 b;
        public final /* synthetic */ String c;
        public final /* synthetic */ ck3 d;

        /* renamed from: com.baidu.tieba.ck3$a$a  reason: collision with other inner class name */
        /* loaded from: classes3.dex */
        public class C0219a implements fo3<mk3<lk3>> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ a a;

            public C0219a(a aVar) {
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
            @Override // com.baidu.tieba.fo3
            /* renamed from: b */
            public void a(mk3<lk3> mk3Var) {
                m12 m12Var;
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, mk3Var) == null) {
                    if (mk3Var.a != 0) {
                        m62.i("WifiApi", "connectWifi: " + mk3Var.a + ZeusCrashHandler.NAME_SEPERATOR + mk3Var.b);
                    }
                    JSONObject jSONObject = null;
                    if (mk3Var.c != null) {
                        jSONObject = new JSONObject();
                        try {
                            jSONObject.put("wifi", mk3Var.c.n());
                        } catch (JSONException e) {
                            m62.i("WifiApi", "getConnectedWifi: " + mk3Var.a + ZeusCrashHandler.NAME_SEPERATOR + mk3Var.b + ZeusCrashHandler.NAME_SEPERATOR + mk3Var.c + "\n" + Log.getStackTraceString(e));
                        }
                    }
                    a aVar = this.a;
                    ck3 ck3Var = aVar.d;
                    String str = aVar.c;
                    if (jSONObject == null) {
                        m12Var = new m12(mk3Var.a, mk3Var.b);
                    } else {
                        m12Var = new m12(mk3Var.a, mk3Var.b, jSONObject);
                    }
                    ck3Var.d(str, m12Var);
                }
            }
        }

        public a(ck3 ck3Var, Activity activity, kk3 kk3Var, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ck3Var, activity, kk3Var, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.d = ck3Var;
            this.a = activity;
            this.b = kk3Var;
            this.c = str;
        }

        @Override // com.baidu.tieba.p43
        public void a(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                jk3.s(this.a).a(this.b, new C0219a(this));
            }
        }

        @Override // com.baidu.tieba.p43
        public void b(int i, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, str) == null) {
                m62.i("WifiApi", "connectWifi: 12012 : no location permission");
                this.d.d(this.c, new m12(12012, "no location permission"));
            }
        }
    }

    /* loaded from: classes3.dex */
    public class g implements p43 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Activity a;
        public final /* synthetic */ String b;
        public final /* synthetic */ ck3 c;

        /* loaded from: classes3.dex */
        public class a implements fo3<mk3<Void>> {
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
            @Override // com.baidu.tieba.fo3
            /* renamed from: b */
            public void a(mk3<Void> mk3Var) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, mk3Var) == null) {
                    if (mk3Var.a != 0) {
                        m62.i("WifiApi", "getWifiList: " + mk3Var.a + ZeusCrashHandler.NAME_SEPERATOR + mk3Var.b);
                    }
                    g gVar = this.a;
                    gVar.c.d(gVar.b, new m12(mk3Var.a, mk3Var.b));
                }
            }
        }

        public g(ck3 ck3Var, Activity activity, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ck3Var, activity, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = ck3Var;
            this.a = activity;
            this.b = str;
        }

        @Override // com.baidu.tieba.p43
        public void a(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                jk3.s(this.a).c(new a(this));
            }
        }

        @Override // com.baidu.tieba.p43
        public void b(int i, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, str) == null) {
                m62.i("WifiApi", "getWifiList: 12012 : no location permission");
                this.c.d(this.b, new m12(12012, "no location permission"));
            }
        }
    }

    /* loaded from: classes3.dex */
    public class i implements p43 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Activity a;
        public final /* synthetic */ String b;
        public final /* synthetic */ ck3 c;

        /* loaded from: classes3.dex */
        public class a implements fo3<mk3<lk3>> {
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
            @Override // com.baidu.tieba.fo3
            /* renamed from: b */
            public void a(mk3<lk3> mk3Var) {
                m12 m12Var;
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, mk3Var) == null) {
                    if (mk3Var.a != 0) {
                        m62.i("WifiApi", "getConnectedWifi: " + mk3Var.a + ZeusCrashHandler.NAME_SEPERATOR + mk3Var.b);
                    }
                    JSONObject jSONObject = null;
                    if (mk3Var.c != null) {
                        jSONObject = new JSONObject();
                        try {
                            jSONObject.put("wifi", mk3Var.c.n());
                        } catch (JSONException e) {
                            m62.i("WifiApi", "getConnectedWifi: " + mk3Var.a + ZeusCrashHandler.NAME_SEPERATOR + mk3Var.b + ZeusCrashHandler.NAME_SEPERATOR + mk3Var.c + "\n" + Log.getStackTraceString(e));
                        }
                    }
                    i iVar = this.a;
                    ck3 ck3Var = iVar.c;
                    String str = iVar.b;
                    if (jSONObject == null) {
                        m12Var = new m12(mk3Var.a, mk3Var.b);
                    } else {
                        m12Var = new m12(mk3Var.a, mk3Var.b, jSONObject);
                    }
                    ck3Var.d(str, m12Var);
                }
            }
        }

        public i(ck3 ck3Var, Activity activity, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ck3Var, activity, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = ck3Var;
            this.a = activity;
            this.b = str;
        }

        @Override // com.baidu.tieba.p43
        public void a(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                jk3.s(this.a).j(new a(this));
            }
        }

        @Override // com.baidu.tieba.p43
        public void b(int i, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, str) == null) {
                m62.i("WifiApi", "getConnectedWifi: 12012 : no location permission");
                this.c.d(this.b, new m12(12012, "no location permission"));
            }
        }
    }

    /* loaded from: classes3.dex */
    public static class b implements fo3<mk3<lk3>> {
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
        @Override // com.baidu.tieba.fo3
        /* renamed from: b */
        public void a(mk3<lk3> mk3Var) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, mk3Var) == null) && mk3Var != null && mk3Var.a == 0 && mk3Var.c != null) {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("wifiInfo", mk3Var.c);
                } catch (JSONException e) {
                    m62.c("WifiApi", "dispatch event onWifiConnected: " + Log.getStackTraceString(e));
                }
                HashMap hashMap = new HashMap();
                hashMap.put("data", jSONObject.toString());
                zu2.U().u(new nj2("wifiConnected", hashMap));
            }
        }
    }

    /* loaded from: classes3.dex */
    public static class c implements fo3<mk3<List<lk3>>> {
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
        @Override // com.baidu.tieba.fo3
        /* renamed from: b */
        public void a(mk3<List<lk3>> mk3Var) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, mk3Var) == null) && mk3Var != null && mk3Var.a == 0 && mk3Var.c != null) {
                JSONObject jSONObject = new JSONObject();
                JSONArray jSONArray = new JSONArray();
                for (lk3 lk3Var : mk3Var.c) {
                    jSONArray.put(lk3Var);
                }
                try {
                    jSONObject.put("wifiList", jSONArray);
                } catch (JSONException e) {
                    m62.c("WifiApi", "dispatch event onGetWifiList: " + Log.getStackTraceString(e));
                }
                HashMap hashMap = new HashMap();
                hashMap.put("data", jSONObject.toString());
                zu2.U().u(new nj2("getWifiList", hashMap));
            }
        }
    }

    /* loaded from: classes3.dex */
    public class d implements fo3<mk3<Void>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ ck3 b;

        public d(ck3 ck3Var, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ck3Var, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = ck3Var;
            this.a = str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.fo3
        /* renamed from: b */
        public void a(mk3<Void> mk3Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, mk3Var) == null) {
                if (mk3Var.a != 0) {
                    m62.i("WifiApi", "startWifi: " + mk3Var.a + ZeusCrashHandler.NAME_SEPERATOR + mk3Var.b);
                }
                this.b.d(this.a, new m12(mk3Var.a, mk3Var.b));
            }
        }
    }

    /* loaded from: classes3.dex */
    public class e implements fo3<mk3<Void>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ ck3 b;

        public e(ck3 ck3Var, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ck3Var, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = ck3Var;
            this.a = str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.fo3
        /* renamed from: b */
        public void a(mk3<Void> mk3Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, mk3Var) == null) {
                if (mk3Var.a != 0) {
                    m62.i("WifiApi", "stopWifi: " + mk3Var.a + ZeusCrashHandler.NAME_SEPERATOR + mk3Var.b);
                }
                this.b.d(this.a, new m12(mk3Var.a, mk3Var.b));
            }
        }
    }

    /* loaded from: classes3.dex */
    public class f implements fo3<pe3<re3.e>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ ck3 b;

        public f(ck3 ck3Var, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ck3Var, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = ck3Var;
            this.a = str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.fo3
        /* renamed from: b */
        public void a(pe3<re3.e> pe3Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, pe3Var) == null) {
                if (ke3.h(pe3Var)) {
                    this.b.F(this.a);
                    return;
                }
                int b = pe3Var.b();
                m62.i("WifiApi", "getWifiList: " + b + ZeusCrashHandler.NAME_SEPERATOR + ke3.f(b));
                this.b.d(this.a, new m12(b, ke3.f(b)));
            }
        }
    }

    /* loaded from: classes3.dex */
    public class h implements fo3<pe3<re3.e>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ ck3 b;

        public h(ck3 ck3Var, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ck3Var, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = ck3Var;
            this.a = str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.fo3
        /* renamed from: b */
        public void a(pe3<re3.e> pe3Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, pe3Var) == null) {
                if (ke3.h(pe3Var)) {
                    this.b.E(this.a);
                    return;
                }
                int b = pe3Var.b();
                m62.i("WifiApi", "getConnectedWifi: " + b + ZeusCrashHandler.NAME_SEPERATOR + ke3.f(b));
                this.b.d(this.a, new m12(b, ke3.f(b)));
            }
        }
    }

    /* loaded from: classes3.dex */
    public class j implements fo3<pe3<re3.e>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ kk3 b;
        public final /* synthetic */ ck3 c;

        public j(ck3 ck3Var, String str, kk3 kk3Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ck3Var, str, kk3Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = ck3Var;
            this.a = str;
            this.b = kk3Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.fo3
        /* renamed from: b */
        public void a(pe3<re3.e> pe3Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, pe3Var) == null) {
                if (!ke3.h(pe3Var)) {
                    int b = pe3Var.b();
                    m62.i("WifiApi", "connectWifi: " + b + ZeusCrashHandler.NAME_SEPERATOR + ke3.f(b));
                    this.c.d(this.a, new m12(b, ke3.f(b)));
                    return;
                }
                this.c.D(this.a, this.b);
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947677598, "Lcom/baidu/tieba/ck3;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947677598, "Lcom/baidu/tieba/ck3;");
                return;
            }
        }
        f = new b();
        g = new c();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ck3(@NonNull nx1 nx1Var) {
        super(nx1Var);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {nx1Var};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((nx1) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    public final void D(String str, kk3 kk3Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048579, this, str, kk3Var) == null) {
            SwanAppActivity w = l93.K().w();
            o43.g(w, new String[]{com.kuaishou.weapon.p0.h.g, com.kuaishou.weapon.p0.h.h}, 0, new a(this, w, kk3Var, str));
        }
    }

    public m12 A(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
            q("#connectWifi", false);
            m93 b0 = m93.b0();
            if (b0 == null) {
                m62.c("WifiApi", "connectWifi: 1001 : swan app is null");
                return new m12(1001, "swan app is null");
            } else if (b0.w() == null) {
                m62.c("WifiApi", "connectWifi: 1001 : swan activity is null");
                return new m12(1001, "swan activity is null");
            } else {
                Pair<m12, JSONObject> s = s(str);
                m12 m12Var = (m12) s.first;
                if (!m12Var.isSuccess()) {
                    return m12Var;
                }
                JSONObject jSONObject = (JSONObject) s.second;
                String optString = jSONObject.optString("cb");
                if (TextUtils.isEmpty(optString)) {
                    m62.c("WifiApi", "connectWifi: 201 : callback is null");
                    return new m12(201, "callback is null");
                }
                kk3 a2 = kk3.a(jSONObject);
                if (TextUtils.isEmpty(a2.a)) {
                    m62.i("WifiApi", "connectWifi: 12008 : invalid ssid");
                    return new m12(12008, "invalid ssid");
                } else if (b0.n0()) {
                    m62.i("WifiApi", "connectWifi: 12011 : app is invisible");
                    return new m12(12011, "app is invisible");
                } else {
                    b0.e0().g(getContext(), "mapp_location", new j(this, optString, a2));
                    return m12.f();
                }
            }
        }
        return (m12) invokeL.objValue;
    }

    public m12 B(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
            q("#getConnectedWifi", false);
            m93 b0 = m93.b0();
            if (b0 == null) {
                m62.c("WifiApi", "getConnectedWifi: 1001 : swan app is null");
                return new m12(1001, "swan app is null");
            } else if (b0.w() == null) {
                m62.c("WifiApi", "getConnectedWifi: 1001 : swan activity is null");
                return new m12(1001, "swan activity is null");
            } else {
                Pair<m12, JSONObject> s = s(str);
                m12 m12Var = (m12) s.first;
                if (!m12Var.isSuccess()) {
                    return m12Var;
                }
                String optString = ((JSONObject) s.second).optString("cb");
                if (TextUtils.isEmpty(optString)) {
                    m62.c("WifiApi", "getConnectedWifi: 201 : callback is null");
                    return new m12(201, "callback is null");
                } else if (b0.n0()) {
                    m62.i("WifiApi", "getConnectedWifi: 12011 : app is invisible");
                    return new m12(12011, "app is invisible");
                } else {
                    b0.e0().g(getContext(), "mapp_location", new h(this, optString));
                    return m12.f();
                }
            }
        }
        return (m12) invokeL.objValue;
    }

    public m12 C(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
            q("#getWifiList", false);
            m93 b0 = m93.b0();
            if (b0 == null) {
                m62.c("WifiApi", "getWifiList: 1001 : swan app is null");
                return new m12(1001, "swan app is null");
            } else if (b0.w() == null) {
                m62.c("WifiApi", "getWifiList: 1001 : swan activity is null");
                return new m12(1001, "swan activity is null");
            } else {
                Pair<m12, JSONObject> s = s(str);
                m12 m12Var = (m12) s.first;
                if (!m12Var.isSuccess()) {
                    return m12Var;
                }
                String optString = ((JSONObject) s.second).optString("cb");
                if (TextUtils.isEmpty(optString)) {
                    m62.c("WifiApi", "getWifiList: 201 : callback is null");
                    return new m12(201, "callback is null");
                } else if (b0.n0()) {
                    m62.i("WifiApi", "getWifiList: 12011 : app is invisible");
                    return new m12(12011, "app is invisible");
                } else {
                    b0.e0().g(getContext(), "mapp_location", new f(this, optString));
                    return m12.f();
                }
            }
        }
        return (m12) invokeL.objValue;
    }

    public m12 G(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, str)) == null) {
            q("#startWifi", false);
            m93 b0 = m93.b0();
            if (b0 == null) {
                m62.c("WifiApi", "startWifi: 1001 : swan app is null");
                return new m12(1001, "swan app is null");
            }
            SwanAppActivity w = b0.w();
            if (w == null) {
                m62.c("WifiApi", "startWifi: 1001 : swan activity is null");
                return new m12(1001, "swan activity is null");
            }
            Pair<m12, JSONObject> s = s(str);
            m12 m12Var = (m12) s.first;
            if (!m12Var.isSuccess()) {
                return m12Var;
            }
            String optString = ((JSONObject) s.second).optString("cb");
            if (TextUtils.isEmpty(optString)) {
                m62.c("WifiApi", "startWifi: 201 : callback is null");
                return new m12(201, "callback is null");
            }
            jk3 s2 = jk3.s(w);
            if (s2.n(f) && s2.d(g)) {
                s2.p(new d(this, optString));
                return m12.f();
            }
            m62.i("WifiApi", "startWifi: 12010 : unknown failed");
            return new m12(12010, "unknown failed");
        }
        return (m12) invokeL.objValue;
    }

    public m12 H(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, str)) == null) {
            q("#stopWifi", false);
            m93 b0 = m93.b0();
            if (b0 == null) {
                m62.c("WifiApi", "stopWifi: 1001 : swan app is null");
                return new m12(1001, "swan app is null");
            }
            SwanAppActivity w = b0.w();
            if (w == null) {
                m62.c("WifiApi", "stopWifi: 1001 : swan activity is null");
                return new m12(1001, "swan activity is null");
            }
            Pair<m12, JSONObject> s = s(str);
            m12 m12Var = (m12) s.first;
            if (!m12Var.isSuccess()) {
                return m12Var;
            }
            String optString = ((JSONObject) s.second).optString("cb");
            if (TextUtils.isEmpty(optString)) {
                m62.c("WifiApi", "stopWifi: 201 : callback is null");
                return new m12(201, "callback is null");
            }
            jk3 s2 = jk3.s(w);
            if (s2.r(f) && s2.b(g)) {
                s2.q(new e(this, optString));
                return m12.f();
            }
            m62.i("WifiApi", "stopWifi: 12010 : unknown failed");
            return new m12(12010, "unknown failed");
        }
        return (m12) invokeL.objValue;
    }

    public final void E(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, str) == null) {
            SwanAppActivity w = l93.K().w();
            o43.g(w, new String[]{com.kuaishou.weapon.p0.h.g, com.kuaishou.weapon.p0.h.h}, 0, new i(this, w, str));
        }
    }

    public final void F(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, str) == null) {
            SwanAppActivity w = l93.K().w();
            o43.g(w, new String[]{com.kuaishou.weapon.p0.h.g, com.kuaishou.weapon.p0.h.h}, 0, new g(this, w, str));
        }
    }
}
