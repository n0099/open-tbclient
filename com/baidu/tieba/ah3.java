package com.baidu.tieba;

import android.app.Activity;
import android.text.TextUtils;
import android.util.Log;
import android.util.Pair;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.cyberplayer.sdk.CyberPlayerManager;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.tieba.pb3;
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
/* loaded from: classes5.dex */
public class ah3 extends ou1 {
    public static /* synthetic */ Interceptable $ic;
    public static final dl3<kh3<jh3>> f;
    public static final dl3<kh3<List<jh3>>> g;
    public transient /* synthetic */ FieldHolder $fh;

    @Override // com.baidu.tieba.ou1
    public String h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? "Wifi" : (String) invokeV.objValue;
    }

    @Override // com.baidu.tieba.ou1
    public String k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? "WifiApi" : (String) invokeV.objValue;
    }

    /* loaded from: classes5.dex */
    public class a implements n13 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Activity a;
        public final /* synthetic */ ih3 b;
        public final /* synthetic */ String c;
        public final /* synthetic */ ah3 d;

        /* renamed from: com.baidu.tieba.ah3$a$a  reason: collision with other inner class name */
        /* loaded from: classes5.dex */
        public class C0229a implements dl3<kh3<jh3>> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ a a;

            public C0229a(a aVar) {
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
            @Override // com.baidu.tieba.dl3
            /* renamed from: b */
            public void a(kh3<jh3> kh3Var) {
                ly1 ly1Var;
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, kh3Var) == null) {
                    if (kh3Var.a != 0) {
                        k32.i("WifiApi", "connectWifi: " + kh3Var.a + ZeusCrashHandler.NAME_SEPERATOR + kh3Var.b);
                    }
                    JSONObject jSONObject = null;
                    if (kh3Var.c != null) {
                        jSONObject = new JSONObject();
                        try {
                            jSONObject.put("wifi", kh3Var.c.n());
                        } catch (JSONException e) {
                            k32.i("WifiApi", "getConnectedWifi: " + kh3Var.a + ZeusCrashHandler.NAME_SEPERATOR + kh3Var.b + ZeusCrashHandler.NAME_SEPERATOR + kh3Var.c + "\n" + Log.getStackTraceString(e));
                        }
                    }
                    a aVar = this.a;
                    ah3 ah3Var = aVar.d;
                    String str = aVar.c;
                    if (jSONObject == null) {
                        ly1Var = new ly1(kh3Var.a, kh3Var.b);
                    } else {
                        ly1Var = new ly1(kh3Var.a, kh3Var.b, jSONObject);
                    }
                    ah3Var.d(str, ly1Var);
                }
            }
        }

        public a(ah3 ah3Var, Activity activity, ih3 ih3Var, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ah3Var, activity, ih3Var, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.d = ah3Var;
            this.a = activity;
            this.b = ih3Var;
            this.c = str;
        }

        @Override // com.baidu.tieba.n13
        public void a(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                hh3.s(this.a).a(this.b, new C0229a(this));
            }
        }

        @Override // com.baidu.tieba.n13
        public void b(int i, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, str) == null) {
                k32.i("WifiApi", "connectWifi: 12012 : no location permission");
                this.d.d(this.c, new ly1((int) CyberPlayerManager.MEDIA_INFO_MEDIA_FILE_PATH, "no location permission"));
            }
        }
    }

    /* loaded from: classes5.dex */
    public class g implements n13 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Activity a;
        public final /* synthetic */ String b;
        public final /* synthetic */ ah3 c;

        /* loaded from: classes5.dex */
        public class a implements dl3<kh3<Void>> {
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
            @Override // com.baidu.tieba.dl3
            /* renamed from: b */
            public void a(kh3<Void> kh3Var) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, kh3Var) == null) {
                    if (kh3Var.a != 0) {
                        k32.i("WifiApi", "getWifiList: " + kh3Var.a + ZeusCrashHandler.NAME_SEPERATOR + kh3Var.b);
                    }
                    g gVar = this.a;
                    gVar.c.d(gVar.b, new ly1(kh3Var.a, kh3Var.b));
                }
            }
        }

        public g(ah3 ah3Var, Activity activity, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ah3Var, activity, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = ah3Var;
            this.a = activity;
            this.b = str;
        }

        @Override // com.baidu.tieba.n13
        public void a(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                hh3.s(this.a).c(new a(this));
            }
        }

        @Override // com.baidu.tieba.n13
        public void b(int i, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, str) == null) {
                k32.i("WifiApi", "getWifiList: 12012 : no location permission");
                this.c.d(this.b, new ly1((int) CyberPlayerManager.MEDIA_INFO_MEDIA_FILE_PATH, "no location permission"));
            }
        }
    }

    /* loaded from: classes5.dex */
    public class i implements n13 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Activity a;
        public final /* synthetic */ String b;
        public final /* synthetic */ ah3 c;

        /* loaded from: classes5.dex */
        public class a implements dl3<kh3<jh3>> {
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
            @Override // com.baidu.tieba.dl3
            /* renamed from: b */
            public void a(kh3<jh3> kh3Var) {
                ly1 ly1Var;
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, kh3Var) == null) {
                    if (kh3Var.a != 0) {
                        k32.i("WifiApi", "getConnectedWifi: " + kh3Var.a + ZeusCrashHandler.NAME_SEPERATOR + kh3Var.b);
                    }
                    JSONObject jSONObject = null;
                    if (kh3Var.c != null) {
                        jSONObject = new JSONObject();
                        try {
                            jSONObject.put("wifi", kh3Var.c.n());
                        } catch (JSONException e) {
                            k32.i("WifiApi", "getConnectedWifi: " + kh3Var.a + ZeusCrashHandler.NAME_SEPERATOR + kh3Var.b + ZeusCrashHandler.NAME_SEPERATOR + kh3Var.c + "\n" + Log.getStackTraceString(e));
                        }
                    }
                    i iVar = this.a;
                    ah3 ah3Var = iVar.c;
                    String str = iVar.b;
                    if (jSONObject == null) {
                        ly1Var = new ly1(kh3Var.a, kh3Var.b);
                    } else {
                        ly1Var = new ly1(kh3Var.a, kh3Var.b, jSONObject);
                    }
                    ah3Var.d(str, ly1Var);
                }
            }
        }

        public i(ah3 ah3Var, Activity activity, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ah3Var, activity, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = ah3Var;
            this.a = activity;
            this.b = str;
        }

        @Override // com.baidu.tieba.n13
        public void a(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                hh3.s(this.a).j(new a(this));
            }
        }

        @Override // com.baidu.tieba.n13
        public void b(int i, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, str) == null) {
                k32.i("WifiApi", "getConnectedWifi: 12012 : no location permission");
                this.c.d(this.b, new ly1((int) CyberPlayerManager.MEDIA_INFO_MEDIA_FILE_PATH, "no location permission"));
            }
        }
    }

    /* loaded from: classes5.dex */
    public static class b implements dl3<kh3<jh3>> {
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
        @Override // com.baidu.tieba.dl3
        /* renamed from: b */
        public void a(kh3<jh3> kh3Var) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, kh3Var) == null) && kh3Var != null && kh3Var.a == 0 && kh3Var.c != null) {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("wifiInfo", kh3Var.c);
                } catch (JSONException e) {
                    k32.c("WifiApi", "dispatch event onWifiConnected: " + Log.getStackTraceString(e));
                }
                HashMap hashMap = new HashMap();
                hashMap.put("data", jSONObject.toString());
                xr2.V().v(new lg2("wifiConnected", hashMap));
            }
        }
    }

    /* loaded from: classes5.dex */
    public static class c implements dl3<kh3<List<jh3>>> {
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
        @Override // com.baidu.tieba.dl3
        /* renamed from: b */
        public void a(kh3<List<jh3>> kh3Var) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, kh3Var) == null) && kh3Var != null && kh3Var.a == 0 && kh3Var.c != null) {
                JSONObject jSONObject = new JSONObject();
                JSONArray jSONArray = new JSONArray();
                for (jh3 jh3Var : kh3Var.c) {
                    jSONArray.put(jh3Var);
                }
                try {
                    jSONObject.put("wifiList", jSONArray);
                } catch (JSONException e) {
                    k32.c("WifiApi", "dispatch event onGetWifiList: " + Log.getStackTraceString(e));
                }
                HashMap hashMap = new HashMap();
                hashMap.put("data", jSONObject.toString());
                xr2.V().v(new lg2("getWifiList", hashMap));
            }
        }
    }

    /* loaded from: classes5.dex */
    public class d implements dl3<kh3<Void>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ ah3 b;

        public d(ah3 ah3Var, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ah3Var, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = ah3Var;
            this.a = str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.dl3
        /* renamed from: b */
        public void a(kh3<Void> kh3Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, kh3Var) == null) {
                if (kh3Var.a != 0) {
                    k32.i("WifiApi", "startWifi: " + kh3Var.a + ZeusCrashHandler.NAME_SEPERATOR + kh3Var.b);
                }
                this.b.d(this.a, new ly1(kh3Var.a, kh3Var.b));
            }
        }
    }

    /* loaded from: classes5.dex */
    public class e implements dl3<kh3<Void>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ ah3 b;

        public e(ah3 ah3Var, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ah3Var, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = ah3Var;
            this.a = str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.dl3
        /* renamed from: b */
        public void a(kh3<Void> kh3Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, kh3Var) == null) {
                if (kh3Var.a != 0) {
                    k32.i("WifiApi", "stopWifi: " + kh3Var.a + ZeusCrashHandler.NAME_SEPERATOR + kh3Var.b);
                }
                this.b.d(this.a, new ly1(kh3Var.a, kh3Var.b));
            }
        }
    }

    /* loaded from: classes5.dex */
    public class f implements dl3<nb3<pb3.e>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ ah3 b;

        public f(ah3 ah3Var, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ah3Var, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = ah3Var;
            this.a = str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.dl3
        /* renamed from: b */
        public void a(nb3<pb3.e> nb3Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, nb3Var) == null) {
                if (!ib3.h(nb3Var)) {
                    int b = nb3Var.b();
                    k32.i("WifiApi", "getWifiList: " + b + ZeusCrashHandler.NAME_SEPERATOR + ib3.f(b));
                    this.b.d(this.a, new ly1(b, ib3.f(b)));
                    return;
                }
                this.b.G(this.a);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class h implements dl3<nb3<pb3.e>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ ah3 b;

        public h(ah3 ah3Var, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ah3Var, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = ah3Var;
            this.a = str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.dl3
        /* renamed from: b */
        public void a(nb3<pb3.e> nb3Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, nb3Var) == null) {
                if (!ib3.h(nb3Var)) {
                    int b = nb3Var.b();
                    k32.i("WifiApi", "getConnectedWifi: " + b + ZeusCrashHandler.NAME_SEPERATOR + ib3.f(b));
                    this.b.d(this.a, new ly1(b, ib3.f(b)));
                    return;
                }
                this.b.F(this.a);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class j implements dl3<nb3<pb3.e>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ ih3 b;
        public final /* synthetic */ ah3 c;

        public j(ah3 ah3Var, String str, ih3 ih3Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ah3Var, str, ih3Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = ah3Var;
            this.a = str;
            this.b = ih3Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.dl3
        /* renamed from: b */
        public void a(nb3<pb3.e> nb3Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, nb3Var) == null) {
                if (ib3.h(nb3Var)) {
                    this.c.E(this.a, this.b);
                    return;
                }
                int b = nb3Var.b();
                k32.i("WifiApi", "connectWifi: " + b + ZeusCrashHandler.NAME_SEPERATOR + ib3.f(b));
                this.c.d(this.a, new ly1(b, ib3.f(b)));
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947615133, "Lcom/baidu/tieba/ah3;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947615133, "Lcom/baidu/tieba/ah3;");
                return;
            }
        }
        f = new b();
        g = new c();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ah3(@NonNull mu1 mu1Var) {
        super(mu1Var);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {mu1Var};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((mu1) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    public final void E(String str, ih3 ih3Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048579, this, str, ih3Var) == null) {
            SwanAppActivity w = j63.K().w();
            m13.f(w, new String[]{com.kuaishou.weapon.p0.g.g, com.kuaishou.weapon.p0.g.h}, 0, new a(this, w, ih3Var, str));
        }
    }

    public ly1 B(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
            r("#connectWifi", false);
            k63 c0 = k63.c0();
            if (c0 == null) {
                k32.c("WifiApi", "connectWifi: 1001 : swan app is null");
                return new ly1(1001, "swan app is null");
            } else if (c0.w() == null) {
                k32.c("WifiApi", "connectWifi: 1001 : swan activity is null");
                return new ly1(1001, "swan activity is null");
            } else {
                Pair<ly1, JSONObject> t = t(str);
                ly1 ly1Var = (ly1) t.first;
                if (!ly1Var.isSuccess()) {
                    return ly1Var;
                }
                JSONObject jSONObject = (JSONObject) t.second;
                String optString = jSONObject.optString("cb");
                if (TextUtils.isEmpty(optString)) {
                    k32.c("WifiApi", "connectWifi: 201 : callback is null");
                    return new ly1(201, "callback is null");
                }
                ih3 a2 = ih3.a(jSONObject);
                if (TextUtils.isEmpty(a2.a)) {
                    k32.i("WifiApi", "connectWifi: 12008 : invalid ssid");
                    return new ly1(12008, "invalid ssid");
                } else if (c0.o0()) {
                    k32.i("WifiApi", "connectWifi: 12011 : app is invisible");
                    return new ly1((int) CyberPlayerManager.MEDIA_INFO_HTTP_REDIECT, "app is invisible");
                } else {
                    c0.f0().g(i(), "mapp_location", new j(this, optString, a2));
                    return ly1.f();
                }
            }
        }
        return (ly1) invokeL.objValue;
    }

    public ly1 H(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, str)) == null) {
            r("#startWifi", false);
            k63 c0 = k63.c0();
            if (c0 == null) {
                k32.c("WifiApi", "startWifi: 1001 : swan app is null");
                return new ly1(1001, "swan app is null");
            }
            SwanAppActivity w = c0.w();
            if (w == null) {
                k32.c("WifiApi", "startWifi: 1001 : swan activity is null");
                return new ly1(1001, "swan activity is null");
            }
            Pair<ly1, JSONObject> t = t(str);
            ly1 ly1Var = (ly1) t.first;
            if (!ly1Var.isSuccess()) {
                return ly1Var;
            }
            String optString = ((JSONObject) t.second).optString("cb");
            if (TextUtils.isEmpty(optString)) {
                k32.c("WifiApi", "startWifi: 201 : callback is null");
                return new ly1(201, "callback is null");
            }
            hh3 s = hh3.s(w);
            if (s.n(f) && s.d(g)) {
                s.p(new d(this, optString));
                return ly1.f();
            }
            k32.i("WifiApi", "startWifi: 12010 : unknown failed");
            return new ly1(12010, "unknown failed");
        }
        return (ly1) invokeL.objValue;
    }

    public ly1 I(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, str)) == null) {
            r("#stopWifi", false);
            k63 c0 = k63.c0();
            if (c0 == null) {
                k32.c("WifiApi", "stopWifi: 1001 : swan app is null");
                return new ly1(1001, "swan app is null");
            }
            SwanAppActivity w = c0.w();
            if (w == null) {
                k32.c("WifiApi", "stopWifi: 1001 : swan activity is null");
                return new ly1(1001, "swan activity is null");
            }
            Pair<ly1, JSONObject> t = t(str);
            ly1 ly1Var = (ly1) t.first;
            if (!ly1Var.isSuccess()) {
                return ly1Var;
            }
            String optString = ((JSONObject) t.second).optString("cb");
            if (TextUtils.isEmpty(optString)) {
                k32.c("WifiApi", "stopWifi: 201 : callback is null");
                return new ly1(201, "callback is null");
            }
            hh3 s = hh3.s(w);
            if (s.r(f) && s.b(g)) {
                s.q(new e(this, optString));
                return ly1.f();
            }
            k32.i("WifiApi", "stopWifi: 12010 : unknown failed");
            return new ly1(12010, "unknown failed");
        }
        return (ly1) invokeL.objValue;
    }

    public ly1 C(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
            r("#getConnectedWifi", false);
            k63 c0 = k63.c0();
            if (c0 == null) {
                k32.c("WifiApi", "getConnectedWifi: 1001 : swan app is null");
                return new ly1(1001, "swan app is null");
            } else if (c0.w() == null) {
                k32.c("WifiApi", "getConnectedWifi: 1001 : swan activity is null");
                return new ly1(1001, "swan activity is null");
            } else {
                Pair<ly1, JSONObject> t = t(str);
                ly1 ly1Var = (ly1) t.first;
                if (!ly1Var.isSuccess()) {
                    return ly1Var;
                }
                String optString = ((JSONObject) t.second).optString("cb");
                if (TextUtils.isEmpty(optString)) {
                    k32.c("WifiApi", "getConnectedWifi: 201 : callback is null");
                    return new ly1(201, "callback is null");
                } else if (c0.o0()) {
                    k32.i("WifiApi", "getConnectedWifi: 12011 : app is invisible");
                    return new ly1((int) CyberPlayerManager.MEDIA_INFO_HTTP_REDIECT, "app is invisible");
                } else {
                    c0.f0().g(i(), "mapp_location", new h(this, optString));
                    return ly1.f();
                }
            }
        }
        return (ly1) invokeL.objValue;
    }

    public ly1 D(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
            r("#getWifiList", false);
            k63 c0 = k63.c0();
            if (c0 == null) {
                k32.c("WifiApi", "getWifiList: 1001 : swan app is null");
                return new ly1(1001, "swan app is null");
            } else if (c0.w() == null) {
                k32.c("WifiApi", "getWifiList: 1001 : swan activity is null");
                return new ly1(1001, "swan activity is null");
            } else {
                Pair<ly1, JSONObject> t = t(str);
                ly1 ly1Var = (ly1) t.first;
                if (!ly1Var.isSuccess()) {
                    return ly1Var;
                }
                String optString = ((JSONObject) t.second).optString("cb");
                if (TextUtils.isEmpty(optString)) {
                    k32.c("WifiApi", "getWifiList: 201 : callback is null");
                    return new ly1(201, "callback is null");
                } else if (c0.o0()) {
                    k32.i("WifiApi", "getWifiList: 12011 : app is invisible");
                    return new ly1((int) CyberPlayerManager.MEDIA_INFO_HTTP_REDIECT, "app is invisible");
                } else {
                    c0.f0().g(i(), "mapp_location", new f(this, optString));
                    return ly1.f();
                }
            }
        }
        return (ly1) invokeL.objValue;
    }

    public final void F(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, str) == null) {
            SwanAppActivity w = j63.K().w();
            m13.f(w, new String[]{com.kuaishou.weapon.p0.g.g, com.kuaishou.weapon.p0.g.h}, 0, new i(this, w, str));
        }
    }

    public final void G(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, str) == null) {
            SwanAppActivity w = j63.K().w();
            m13.f(w, new String[]{com.kuaishou.weapon.p0.g.g, com.kuaishou.weapon.p0.g.h}, 0, new g(this, w, str));
        }
    }
}
