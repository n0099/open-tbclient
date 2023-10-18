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
import com.baidu.tieba.ua3;
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
public class fg3 extends tt1 {
    public static /* synthetic */ Interceptable $ic;
    public static final ik3<pg3<og3>> f;
    public static final ik3<pg3<List<og3>>> g;
    public transient /* synthetic */ FieldHolder $fh;

    @Override // com.baidu.tieba.tt1
    public String h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? "Wifi" : (String) invokeV.objValue;
    }

    @Override // com.baidu.tieba.tt1
    public String k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? "WifiApi" : (String) invokeV.objValue;
    }

    /* loaded from: classes5.dex */
    public class a implements s03 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Activity a;
        public final /* synthetic */ ng3 b;
        public final /* synthetic */ String c;
        public final /* synthetic */ fg3 d;

        /* renamed from: com.baidu.tieba.fg3$a$a  reason: collision with other inner class name */
        /* loaded from: classes5.dex */
        public class C0280a implements ik3<pg3<og3>> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ a a;

            public C0280a(a aVar) {
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
            @Override // com.baidu.tieba.ik3
            /* renamed from: b */
            public void a(pg3<og3> pg3Var) {
                qx1 qx1Var;
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, pg3Var) == null) {
                    if (pg3Var.a != 0) {
                        p22.i("WifiApi", "connectWifi: " + pg3Var.a + ZeusCrashHandler.NAME_SEPERATOR + pg3Var.b);
                    }
                    JSONObject jSONObject = null;
                    if (pg3Var.c != null) {
                        jSONObject = new JSONObject();
                        try {
                            jSONObject.put("wifi", pg3Var.c.n());
                        } catch (JSONException e) {
                            p22.i("WifiApi", "getConnectedWifi: " + pg3Var.a + ZeusCrashHandler.NAME_SEPERATOR + pg3Var.b + ZeusCrashHandler.NAME_SEPERATOR + pg3Var.c + "\n" + Log.getStackTraceString(e));
                        }
                    }
                    a aVar = this.a;
                    fg3 fg3Var = aVar.d;
                    String str = aVar.c;
                    if (jSONObject == null) {
                        qx1Var = new qx1(pg3Var.a, pg3Var.b);
                    } else {
                        qx1Var = new qx1(pg3Var.a, pg3Var.b, jSONObject);
                    }
                    fg3Var.d(str, qx1Var);
                }
            }
        }

        public a(fg3 fg3Var, Activity activity, ng3 ng3Var, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fg3Var, activity, ng3Var, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.d = fg3Var;
            this.a = activity;
            this.b = ng3Var;
            this.c = str;
        }

        @Override // com.baidu.tieba.s03
        public void a(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                mg3.s(this.a).a(this.b, new C0280a(this));
            }
        }

        @Override // com.baidu.tieba.s03
        public void b(int i, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, str) == null) {
                p22.i("WifiApi", "connectWifi: 12012 : no location permission");
                this.d.d(this.c, new qx1((int) CyberPlayerManager.MEDIA_INFO_MEDIA_FILE_PATH, "no location permission"));
            }
        }
    }

    /* loaded from: classes5.dex */
    public class g implements s03 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Activity a;
        public final /* synthetic */ String b;
        public final /* synthetic */ fg3 c;

        /* loaded from: classes5.dex */
        public class a implements ik3<pg3<Void>> {
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
            @Override // com.baidu.tieba.ik3
            /* renamed from: b */
            public void a(pg3<Void> pg3Var) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, pg3Var) == null) {
                    if (pg3Var.a != 0) {
                        p22.i("WifiApi", "getWifiList: " + pg3Var.a + ZeusCrashHandler.NAME_SEPERATOR + pg3Var.b);
                    }
                    g gVar = this.a;
                    gVar.c.d(gVar.b, new qx1(pg3Var.a, pg3Var.b));
                }
            }
        }

        public g(fg3 fg3Var, Activity activity, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fg3Var, activity, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = fg3Var;
            this.a = activity;
            this.b = str;
        }

        @Override // com.baidu.tieba.s03
        public void a(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                mg3.s(this.a).c(new a(this));
            }
        }

        @Override // com.baidu.tieba.s03
        public void b(int i, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, str) == null) {
                p22.i("WifiApi", "getWifiList: 12012 : no location permission");
                this.c.d(this.b, new qx1((int) CyberPlayerManager.MEDIA_INFO_MEDIA_FILE_PATH, "no location permission"));
            }
        }
    }

    /* loaded from: classes5.dex */
    public class i implements s03 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Activity a;
        public final /* synthetic */ String b;
        public final /* synthetic */ fg3 c;

        /* loaded from: classes5.dex */
        public class a implements ik3<pg3<og3>> {
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
            @Override // com.baidu.tieba.ik3
            /* renamed from: b */
            public void a(pg3<og3> pg3Var) {
                qx1 qx1Var;
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, pg3Var) == null) {
                    if (pg3Var.a != 0) {
                        p22.i("WifiApi", "getConnectedWifi: " + pg3Var.a + ZeusCrashHandler.NAME_SEPERATOR + pg3Var.b);
                    }
                    JSONObject jSONObject = null;
                    if (pg3Var.c != null) {
                        jSONObject = new JSONObject();
                        try {
                            jSONObject.put("wifi", pg3Var.c.n());
                        } catch (JSONException e) {
                            p22.i("WifiApi", "getConnectedWifi: " + pg3Var.a + ZeusCrashHandler.NAME_SEPERATOR + pg3Var.b + ZeusCrashHandler.NAME_SEPERATOR + pg3Var.c + "\n" + Log.getStackTraceString(e));
                        }
                    }
                    i iVar = this.a;
                    fg3 fg3Var = iVar.c;
                    String str = iVar.b;
                    if (jSONObject == null) {
                        qx1Var = new qx1(pg3Var.a, pg3Var.b);
                    } else {
                        qx1Var = new qx1(pg3Var.a, pg3Var.b, jSONObject);
                    }
                    fg3Var.d(str, qx1Var);
                }
            }
        }

        public i(fg3 fg3Var, Activity activity, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fg3Var, activity, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = fg3Var;
            this.a = activity;
            this.b = str;
        }

        @Override // com.baidu.tieba.s03
        public void a(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                mg3.s(this.a).j(new a(this));
            }
        }

        @Override // com.baidu.tieba.s03
        public void b(int i, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, str) == null) {
                p22.i("WifiApi", "getConnectedWifi: 12012 : no location permission");
                this.c.d(this.b, new qx1((int) CyberPlayerManager.MEDIA_INFO_MEDIA_FILE_PATH, "no location permission"));
            }
        }
    }

    /* loaded from: classes5.dex */
    public static class b implements ik3<pg3<og3>> {
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
        @Override // com.baidu.tieba.ik3
        /* renamed from: b */
        public void a(pg3<og3> pg3Var) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, pg3Var) == null) && pg3Var != null && pg3Var.a == 0 && pg3Var.c != null) {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("wifiInfo", pg3Var.c);
                } catch (JSONException e) {
                    p22.c("WifiApi", "dispatch event onWifiConnected: " + Log.getStackTraceString(e));
                }
                HashMap hashMap = new HashMap();
                hashMap.put("data", jSONObject.toString());
                cr2.V().v(new qf2("wifiConnected", hashMap));
            }
        }
    }

    /* loaded from: classes5.dex */
    public static class c implements ik3<pg3<List<og3>>> {
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
        @Override // com.baidu.tieba.ik3
        /* renamed from: b */
        public void a(pg3<List<og3>> pg3Var) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, pg3Var) == null) && pg3Var != null && pg3Var.a == 0 && pg3Var.c != null) {
                JSONObject jSONObject = new JSONObject();
                JSONArray jSONArray = new JSONArray();
                for (og3 og3Var : pg3Var.c) {
                    jSONArray.put(og3Var);
                }
                try {
                    jSONObject.put("wifiList", jSONArray);
                } catch (JSONException e) {
                    p22.c("WifiApi", "dispatch event onGetWifiList: " + Log.getStackTraceString(e));
                }
                HashMap hashMap = new HashMap();
                hashMap.put("data", jSONObject.toString());
                cr2.V().v(new qf2("getWifiList", hashMap));
            }
        }
    }

    /* loaded from: classes5.dex */
    public class d implements ik3<pg3<Void>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ fg3 b;

        public d(fg3 fg3Var, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fg3Var, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = fg3Var;
            this.a = str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.ik3
        /* renamed from: b */
        public void a(pg3<Void> pg3Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, pg3Var) == null) {
                if (pg3Var.a != 0) {
                    p22.i("WifiApi", "startWifi: " + pg3Var.a + ZeusCrashHandler.NAME_SEPERATOR + pg3Var.b);
                }
                this.b.d(this.a, new qx1(pg3Var.a, pg3Var.b));
            }
        }
    }

    /* loaded from: classes5.dex */
    public class e implements ik3<pg3<Void>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ fg3 b;

        public e(fg3 fg3Var, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fg3Var, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = fg3Var;
            this.a = str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.ik3
        /* renamed from: b */
        public void a(pg3<Void> pg3Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, pg3Var) == null) {
                if (pg3Var.a != 0) {
                    p22.i("WifiApi", "stopWifi: " + pg3Var.a + ZeusCrashHandler.NAME_SEPERATOR + pg3Var.b);
                }
                this.b.d(this.a, new qx1(pg3Var.a, pg3Var.b));
            }
        }
    }

    /* loaded from: classes5.dex */
    public class f implements ik3<sa3<ua3.e>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ fg3 b;

        public f(fg3 fg3Var, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fg3Var, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = fg3Var;
            this.a = str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.ik3
        /* renamed from: b */
        public void a(sa3<ua3.e> sa3Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, sa3Var) == null) {
                if (!na3.h(sa3Var)) {
                    int b = sa3Var.b();
                    p22.i("WifiApi", "getWifiList: " + b + ZeusCrashHandler.NAME_SEPERATOR + na3.f(b));
                    this.b.d(this.a, new qx1(b, na3.f(b)));
                    return;
                }
                this.b.G(this.a);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class h implements ik3<sa3<ua3.e>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ fg3 b;

        public h(fg3 fg3Var, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fg3Var, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = fg3Var;
            this.a = str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.ik3
        /* renamed from: b */
        public void a(sa3<ua3.e> sa3Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, sa3Var) == null) {
                if (!na3.h(sa3Var)) {
                    int b = sa3Var.b();
                    p22.i("WifiApi", "getConnectedWifi: " + b + ZeusCrashHandler.NAME_SEPERATOR + na3.f(b));
                    this.b.d(this.a, new qx1(b, na3.f(b)));
                    return;
                }
                this.b.F(this.a);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class j implements ik3<sa3<ua3.e>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ ng3 b;
        public final /* synthetic */ fg3 c;

        public j(fg3 fg3Var, String str, ng3 ng3Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fg3Var, str, ng3Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = fg3Var;
            this.a = str;
            this.b = ng3Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.ik3
        /* renamed from: b */
        public void a(sa3<ua3.e> sa3Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, sa3Var) == null) {
                if (na3.h(sa3Var)) {
                    this.c.E(this.a, this.b);
                    return;
                }
                int b = sa3Var.b();
                p22.i("WifiApi", "connectWifi: " + b + ZeusCrashHandler.NAME_SEPERATOR + na3.f(b));
                this.c.d(this.a, new qx1(b, na3.f(b)));
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947763127, "Lcom/baidu/tieba/fg3;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947763127, "Lcom/baidu/tieba/fg3;");
                return;
            }
        }
        f = new b();
        g = new c();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public fg3(@NonNull rt1 rt1Var) {
        super(rt1Var);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {rt1Var};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((rt1) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    public final void E(String str, ng3 ng3Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048579, this, str, ng3Var) == null) {
            SwanAppActivity w = o53.K().w();
            r03.f(w, new String[]{com.kuaishou.weapon.p0.h.g, com.kuaishou.weapon.p0.h.h}, 0, new a(this, w, ng3Var, str));
        }
    }

    public qx1 B(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
            r("#connectWifi", false);
            p53 c0 = p53.c0();
            if (c0 == null) {
                p22.c("WifiApi", "connectWifi: 1001 : swan app is null");
                return new qx1(1001, "swan app is null");
            } else if (c0.w() == null) {
                p22.c("WifiApi", "connectWifi: 1001 : swan activity is null");
                return new qx1(1001, "swan activity is null");
            } else {
                Pair<qx1, JSONObject> t = t(str);
                qx1 qx1Var = (qx1) t.first;
                if (!qx1Var.isSuccess()) {
                    return qx1Var;
                }
                JSONObject jSONObject = (JSONObject) t.second;
                String optString = jSONObject.optString("cb");
                if (TextUtils.isEmpty(optString)) {
                    p22.c("WifiApi", "connectWifi: 201 : callback is null");
                    return new qx1(201, "callback is null");
                }
                ng3 a2 = ng3.a(jSONObject);
                if (TextUtils.isEmpty(a2.a)) {
                    p22.i("WifiApi", "connectWifi: 12008 : invalid ssid");
                    return new qx1(12008, "invalid ssid");
                } else if (c0.o0()) {
                    p22.i("WifiApi", "connectWifi: 12011 : app is invisible");
                    return new qx1((int) CyberPlayerManager.MEDIA_INFO_HTTP_REDIECT, "app is invisible");
                } else {
                    c0.f0().g(i(), "mapp_location", new j(this, optString, a2));
                    return qx1.f();
                }
            }
        }
        return (qx1) invokeL.objValue;
    }

    public qx1 H(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, str)) == null) {
            r("#startWifi", false);
            p53 c0 = p53.c0();
            if (c0 == null) {
                p22.c("WifiApi", "startWifi: 1001 : swan app is null");
                return new qx1(1001, "swan app is null");
            }
            SwanAppActivity w = c0.w();
            if (w == null) {
                p22.c("WifiApi", "startWifi: 1001 : swan activity is null");
                return new qx1(1001, "swan activity is null");
            }
            Pair<qx1, JSONObject> t = t(str);
            qx1 qx1Var = (qx1) t.first;
            if (!qx1Var.isSuccess()) {
                return qx1Var;
            }
            String optString = ((JSONObject) t.second).optString("cb");
            if (TextUtils.isEmpty(optString)) {
                p22.c("WifiApi", "startWifi: 201 : callback is null");
                return new qx1(201, "callback is null");
            }
            mg3 s = mg3.s(w);
            if (s.n(f) && s.d(g)) {
                s.p(new d(this, optString));
                return qx1.f();
            }
            p22.i("WifiApi", "startWifi: 12010 : unknown failed");
            return new qx1(12010, "unknown failed");
        }
        return (qx1) invokeL.objValue;
    }

    public qx1 I(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, str)) == null) {
            r("#stopWifi", false);
            p53 c0 = p53.c0();
            if (c0 == null) {
                p22.c("WifiApi", "stopWifi: 1001 : swan app is null");
                return new qx1(1001, "swan app is null");
            }
            SwanAppActivity w = c0.w();
            if (w == null) {
                p22.c("WifiApi", "stopWifi: 1001 : swan activity is null");
                return new qx1(1001, "swan activity is null");
            }
            Pair<qx1, JSONObject> t = t(str);
            qx1 qx1Var = (qx1) t.first;
            if (!qx1Var.isSuccess()) {
                return qx1Var;
            }
            String optString = ((JSONObject) t.second).optString("cb");
            if (TextUtils.isEmpty(optString)) {
                p22.c("WifiApi", "stopWifi: 201 : callback is null");
                return new qx1(201, "callback is null");
            }
            mg3 s = mg3.s(w);
            if (s.r(f) && s.b(g)) {
                s.q(new e(this, optString));
                return qx1.f();
            }
            p22.i("WifiApi", "stopWifi: 12010 : unknown failed");
            return new qx1(12010, "unknown failed");
        }
        return (qx1) invokeL.objValue;
    }

    public qx1 C(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
            r("#getConnectedWifi", false);
            p53 c0 = p53.c0();
            if (c0 == null) {
                p22.c("WifiApi", "getConnectedWifi: 1001 : swan app is null");
                return new qx1(1001, "swan app is null");
            } else if (c0.w() == null) {
                p22.c("WifiApi", "getConnectedWifi: 1001 : swan activity is null");
                return new qx1(1001, "swan activity is null");
            } else {
                Pair<qx1, JSONObject> t = t(str);
                qx1 qx1Var = (qx1) t.first;
                if (!qx1Var.isSuccess()) {
                    return qx1Var;
                }
                String optString = ((JSONObject) t.second).optString("cb");
                if (TextUtils.isEmpty(optString)) {
                    p22.c("WifiApi", "getConnectedWifi: 201 : callback is null");
                    return new qx1(201, "callback is null");
                } else if (c0.o0()) {
                    p22.i("WifiApi", "getConnectedWifi: 12011 : app is invisible");
                    return new qx1((int) CyberPlayerManager.MEDIA_INFO_HTTP_REDIECT, "app is invisible");
                } else {
                    c0.f0().g(i(), "mapp_location", new h(this, optString));
                    return qx1.f();
                }
            }
        }
        return (qx1) invokeL.objValue;
    }

    public qx1 D(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
            r("#getWifiList", false);
            p53 c0 = p53.c0();
            if (c0 == null) {
                p22.c("WifiApi", "getWifiList: 1001 : swan app is null");
                return new qx1(1001, "swan app is null");
            } else if (c0.w() == null) {
                p22.c("WifiApi", "getWifiList: 1001 : swan activity is null");
                return new qx1(1001, "swan activity is null");
            } else {
                Pair<qx1, JSONObject> t = t(str);
                qx1 qx1Var = (qx1) t.first;
                if (!qx1Var.isSuccess()) {
                    return qx1Var;
                }
                String optString = ((JSONObject) t.second).optString("cb");
                if (TextUtils.isEmpty(optString)) {
                    p22.c("WifiApi", "getWifiList: 201 : callback is null");
                    return new qx1(201, "callback is null");
                } else if (c0.o0()) {
                    p22.i("WifiApi", "getWifiList: 12011 : app is invisible");
                    return new qx1((int) CyberPlayerManager.MEDIA_INFO_HTTP_REDIECT, "app is invisible");
                } else {
                    c0.f0().g(i(), "mapp_location", new f(this, optString));
                    return qx1.f();
                }
            }
        }
        return (qx1) invokeL.objValue;
    }

    public final void F(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, str) == null) {
            SwanAppActivity w = o53.K().w();
            r03.f(w, new String[]{com.kuaishou.weapon.p0.h.g, com.kuaishou.weapon.p0.h.h}, 0, new i(this, w, str));
        }
    }

    public final void G(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, str) == null) {
            SwanAppActivity w = o53.K().w();
            r03.f(w, new String[]{com.kuaishou.weapon.p0.h.g, com.kuaishou.weapon.p0.h.h}, 0, new g(this, w, str));
        }
    }
}
