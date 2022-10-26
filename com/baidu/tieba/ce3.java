package com.baidu.tieba;

import android.app.Activity;
import android.text.TextUtils;
import android.util.Log;
import android.util.Pair;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.apps.SwanAppActivity;
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
public class ce3 extends pr1 {
    public static /* synthetic */ Interceptable $ic;
    public static final fi3 f;
    public static final fi3 g;
    public transient /* synthetic */ FieldHolder $fh;

    @Override // com.baidu.tieba.pr1
    public String h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? "Wifi" : (String) invokeV.objValue;
    }

    @Override // com.baidu.tieba.pr1
    public String j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? "WifiApi" : (String) invokeV.objValue;
    }

    /* loaded from: classes3.dex */
    public class a implements py2 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Activity a;
        public final /* synthetic */ ke3 b;
        public final /* synthetic */ String c;
        public final /* synthetic */ ce3 d;

        /* renamed from: com.baidu.tieba.ce3$a$a  reason: collision with other inner class name */
        /* loaded from: classes3.dex */
        public class C0209a implements fi3 {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ a a;

            public C0209a(a aVar) {
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
            @Override // com.baidu.tieba.fi3
            /* renamed from: b */
            public void a(me3 me3Var) {
                mv1 mv1Var;
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, me3Var) == null) {
                    if (me3Var.a != 0) {
                        m02.i("WifiApi", "connectWifi: " + me3Var.a + ZeusCrashHandler.NAME_SEPERATOR + me3Var.b);
                    }
                    JSONObject jSONObject = null;
                    if (me3Var.c != null) {
                        jSONObject = new JSONObject();
                        try {
                            jSONObject.put("wifi", ((le3) me3Var.c).n());
                        } catch (JSONException e) {
                            m02.i("WifiApi", "getConnectedWifi: " + me3Var.a + ZeusCrashHandler.NAME_SEPERATOR + me3Var.b + ZeusCrashHandler.NAME_SEPERATOR + me3Var.c + "\n" + Log.getStackTraceString(e));
                        }
                    }
                    a aVar = this.a;
                    ce3 ce3Var = aVar.d;
                    String str = aVar.c;
                    if (jSONObject == null) {
                        mv1Var = new mv1(me3Var.a, me3Var.b);
                    } else {
                        mv1Var = new mv1(me3Var.a, me3Var.b, jSONObject);
                    }
                    ce3Var.d(str, mv1Var);
                }
            }
        }

        public a(ce3 ce3Var, Activity activity, ke3 ke3Var, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ce3Var, activity, ke3Var, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.d = ce3Var;
            this.a = activity;
            this.b = ke3Var;
            this.c = str;
        }

        @Override // com.baidu.tieba.py2
        public void a(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                je3.s(this.a).a(this.b, new C0209a(this));
            }
        }

        @Override // com.baidu.tieba.py2
        public void b(int i, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, str) == null) {
                m02.i("WifiApi", "connectWifi: 12012 : no location permission");
                this.d.d(this.c, new mv1(12012, "no location permission"));
            }
        }
    }

    /* loaded from: classes3.dex */
    public class g implements py2 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Activity a;
        public final /* synthetic */ String b;
        public final /* synthetic */ ce3 c;

        /* loaded from: classes3.dex */
        public class a implements fi3 {
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
            @Override // com.baidu.tieba.fi3
            /* renamed from: b */
            public void a(me3 me3Var) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, me3Var) == null) {
                    if (me3Var.a != 0) {
                        m02.i("WifiApi", "getWifiList: " + me3Var.a + ZeusCrashHandler.NAME_SEPERATOR + me3Var.b);
                    }
                    g gVar = this.a;
                    gVar.c.d(gVar.b, new mv1(me3Var.a, me3Var.b));
                }
            }
        }

        public g(ce3 ce3Var, Activity activity, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ce3Var, activity, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = ce3Var;
            this.a = activity;
            this.b = str;
        }

        @Override // com.baidu.tieba.py2
        public void a(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                je3.s(this.a).c(new a(this));
            }
        }

        @Override // com.baidu.tieba.py2
        public void b(int i, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, str) == null) {
                m02.i("WifiApi", "getWifiList: 12012 : no location permission");
                this.c.d(this.b, new mv1(12012, "no location permission"));
            }
        }
    }

    /* loaded from: classes3.dex */
    public class i implements py2 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Activity a;
        public final /* synthetic */ String b;
        public final /* synthetic */ ce3 c;

        /* loaded from: classes3.dex */
        public class a implements fi3 {
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
            @Override // com.baidu.tieba.fi3
            /* renamed from: b */
            public void a(me3 me3Var) {
                mv1 mv1Var;
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, me3Var) == null) {
                    if (me3Var.a != 0) {
                        m02.i("WifiApi", "getConnectedWifi: " + me3Var.a + ZeusCrashHandler.NAME_SEPERATOR + me3Var.b);
                    }
                    JSONObject jSONObject = null;
                    if (me3Var.c != null) {
                        jSONObject = new JSONObject();
                        try {
                            jSONObject.put("wifi", ((le3) me3Var.c).n());
                        } catch (JSONException e) {
                            m02.i("WifiApi", "getConnectedWifi: " + me3Var.a + ZeusCrashHandler.NAME_SEPERATOR + me3Var.b + ZeusCrashHandler.NAME_SEPERATOR + me3Var.c + "\n" + Log.getStackTraceString(e));
                        }
                    }
                    i iVar = this.a;
                    ce3 ce3Var = iVar.c;
                    String str = iVar.b;
                    if (jSONObject == null) {
                        mv1Var = new mv1(me3Var.a, me3Var.b);
                    } else {
                        mv1Var = new mv1(me3Var.a, me3Var.b, jSONObject);
                    }
                    ce3Var.d(str, mv1Var);
                }
            }
        }

        public i(ce3 ce3Var, Activity activity, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ce3Var, activity, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = ce3Var;
            this.a = activity;
            this.b = str;
        }

        @Override // com.baidu.tieba.py2
        public void a(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                je3.s(this.a).j(new a(this));
            }
        }

        @Override // com.baidu.tieba.py2
        public void b(int i, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, str) == null) {
                m02.i("WifiApi", "getConnectedWifi: 12012 : no location permission");
                this.c.d(this.b, new mv1(12012, "no location permission"));
            }
        }
    }

    /* loaded from: classes3.dex */
    public final class b implements fi3 {
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
        @Override // com.baidu.tieba.fi3
        /* renamed from: b */
        public void a(me3 me3Var) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, me3Var) == null) && me3Var != null && me3Var.a == 0 && me3Var.c != null) {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("wifiInfo", me3Var.c);
                } catch (JSONException e) {
                    m02.c("WifiApi", "dispatch event onWifiConnected: " + Log.getStackTraceString(e));
                }
                HashMap hashMap = new HashMap();
                hashMap.put("data", jSONObject.toString());
                zo2.U().u(new nd2("wifiConnected", hashMap));
            }
        }
    }

    /* loaded from: classes3.dex */
    public final class c implements fi3 {
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
        @Override // com.baidu.tieba.fi3
        /* renamed from: b */
        public void a(me3 me3Var) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, me3Var) == null) && me3Var != null && me3Var.a == 0 && me3Var.c != null) {
                JSONObject jSONObject = new JSONObject();
                JSONArray jSONArray = new JSONArray();
                for (le3 le3Var : (List) me3Var.c) {
                    jSONArray.put(le3Var);
                }
                try {
                    jSONObject.put("wifiList", jSONArray);
                } catch (JSONException e) {
                    m02.c("WifiApi", "dispatch event onGetWifiList: " + Log.getStackTraceString(e));
                }
                HashMap hashMap = new HashMap();
                hashMap.put("data", jSONObject.toString());
                zo2.U().u(new nd2("getWifiList", hashMap));
            }
        }
    }

    /* loaded from: classes3.dex */
    public class d implements fi3 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ ce3 b;

        public d(ce3 ce3Var, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ce3Var, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = ce3Var;
            this.a = str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.fi3
        /* renamed from: b */
        public void a(me3 me3Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, me3Var) == null) {
                if (me3Var.a != 0) {
                    m02.i("WifiApi", "startWifi: " + me3Var.a + ZeusCrashHandler.NAME_SEPERATOR + me3Var.b);
                }
                this.b.d(this.a, new mv1(me3Var.a, me3Var.b));
            }
        }
    }

    /* loaded from: classes3.dex */
    public class e implements fi3 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ ce3 b;

        public e(ce3 ce3Var, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ce3Var, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = ce3Var;
            this.a = str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.fi3
        /* renamed from: b */
        public void a(me3 me3Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, me3Var) == null) {
                if (me3Var.a != 0) {
                    m02.i("WifiApi", "stopWifi: " + me3Var.a + ZeusCrashHandler.NAME_SEPERATOR + me3Var.b);
                }
                this.b.d(this.a, new mv1(me3Var.a, me3Var.b));
            }
        }
    }

    /* loaded from: classes3.dex */
    public class f implements fi3 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ ce3 b;

        public f(ce3 ce3Var, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ce3Var, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = ce3Var;
            this.a = str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.fi3
        /* renamed from: b */
        public void a(p83 p83Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, p83Var) == null) {
                if (k83.h(p83Var)) {
                    this.b.F(this.a);
                    return;
                }
                int b = p83Var.b();
                m02.i("WifiApi", "getWifiList: " + b + ZeusCrashHandler.NAME_SEPERATOR + k83.f(b));
                this.b.d(this.a, new mv1(b, k83.f(b)));
            }
        }
    }

    /* loaded from: classes3.dex */
    public class h implements fi3 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ ce3 b;

        public h(ce3 ce3Var, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ce3Var, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = ce3Var;
            this.a = str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.fi3
        /* renamed from: b */
        public void a(p83 p83Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, p83Var) == null) {
                if (k83.h(p83Var)) {
                    this.b.E(this.a);
                    return;
                }
                int b = p83Var.b();
                m02.i("WifiApi", "getConnectedWifi: " + b + ZeusCrashHandler.NAME_SEPERATOR + k83.f(b));
                this.b.d(this.a, new mv1(b, k83.f(b)));
            }
        }
    }

    /* loaded from: classes3.dex */
    public class j implements fi3 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ ke3 b;
        public final /* synthetic */ ce3 c;

        public j(ce3 ce3Var, String str, ke3 ke3Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ce3Var, str, ke3Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = ce3Var;
            this.a = str;
            this.b = ke3Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.fi3
        /* renamed from: b */
        public void a(p83 p83Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, p83Var) == null) {
                if (!k83.h(p83Var)) {
                    int b = p83Var.b();
                    m02.i("WifiApi", "connectWifi: " + b + ZeusCrashHandler.NAME_SEPERATOR + k83.f(b));
                    this.c.d(this.a, new mv1(b, k83.f(b)));
                    return;
                }
                this.c.D(this.a, this.b);
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947671832, "Lcom/baidu/tieba/ce3;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947671832, "Lcom/baidu/tieba/ce3;");
                return;
            }
        }
        f = new b();
        g = new c();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ce3(nr1 nr1Var) {
        super(nr1Var);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {nr1Var};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((nr1) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    public final void D(String str, ke3 ke3Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048579, this, str, ke3Var) == null) {
            SwanAppActivity w = l33.K().w();
            oy2.g(w, new String[]{com.kuaishou.weapon.p0.h.g, com.kuaishou.weapon.p0.h.h}, 0, new a(this, w, ke3Var, str));
        }
    }

    public mv1 A(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
            q("#connectWifi", false);
            m33 b0 = m33.b0();
            if (b0 == null) {
                m02.c("WifiApi", "connectWifi: 1001 : swan app is null");
                return new mv1(1001, "swan app is null");
            } else if (b0.w() == null) {
                m02.c("WifiApi", "connectWifi: 1001 : swan activity is null");
                return new mv1(1001, "swan activity is null");
            } else {
                Pair s = s(str);
                mv1 mv1Var = (mv1) s.first;
                if (!mv1Var.isSuccess()) {
                    return mv1Var;
                }
                JSONObject jSONObject = (JSONObject) s.second;
                String optString = jSONObject.optString("cb");
                if (TextUtils.isEmpty(optString)) {
                    m02.c("WifiApi", "connectWifi: 201 : callback is null");
                    return new mv1(201, "callback is null");
                }
                ke3 a2 = ke3.a(jSONObject);
                if (TextUtils.isEmpty(a2.a)) {
                    m02.i("WifiApi", "connectWifi: 12008 : invalid ssid");
                    return new mv1(12008, "invalid ssid");
                } else if (b0.n0()) {
                    m02.i("WifiApi", "connectWifi: 12011 : app is invisible");
                    return new mv1(12011, "app is invisible");
                } else {
                    b0.e0().g(getContext(), "mapp_location", new j(this, optString, a2));
                    return mv1.f();
                }
            }
        }
        return (mv1) invokeL.objValue;
    }

    public mv1 G(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, str)) == null) {
            q("#startWifi", false);
            m33 b0 = m33.b0();
            if (b0 == null) {
                m02.c("WifiApi", "startWifi: 1001 : swan app is null");
                return new mv1(1001, "swan app is null");
            }
            SwanAppActivity w = b0.w();
            if (w == null) {
                m02.c("WifiApi", "startWifi: 1001 : swan activity is null");
                return new mv1(1001, "swan activity is null");
            }
            Pair s = s(str);
            mv1 mv1Var = (mv1) s.first;
            if (!mv1Var.isSuccess()) {
                return mv1Var;
            }
            String optString = ((JSONObject) s.second).optString("cb");
            if (TextUtils.isEmpty(optString)) {
                m02.c("WifiApi", "startWifi: 201 : callback is null");
                return new mv1(201, "callback is null");
            }
            je3 s2 = je3.s(w);
            if (s2.n(f) && s2.d(g)) {
                s2.p(new d(this, optString));
                return mv1.f();
            }
            m02.i("WifiApi", "startWifi: 12010 : unknown failed");
            return new mv1(12010, "unknown failed");
        }
        return (mv1) invokeL.objValue;
    }

    public mv1 H(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, str)) == null) {
            q("#stopWifi", false);
            m33 b0 = m33.b0();
            if (b0 == null) {
                m02.c("WifiApi", "stopWifi: 1001 : swan app is null");
                return new mv1(1001, "swan app is null");
            }
            SwanAppActivity w = b0.w();
            if (w == null) {
                m02.c("WifiApi", "stopWifi: 1001 : swan activity is null");
                return new mv1(1001, "swan activity is null");
            }
            Pair s = s(str);
            mv1 mv1Var = (mv1) s.first;
            if (!mv1Var.isSuccess()) {
                return mv1Var;
            }
            String optString = ((JSONObject) s.second).optString("cb");
            if (TextUtils.isEmpty(optString)) {
                m02.c("WifiApi", "stopWifi: 201 : callback is null");
                return new mv1(201, "callback is null");
            }
            je3 s2 = je3.s(w);
            if (s2.r(f) && s2.b(g)) {
                s2.q(new e(this, optString));
                return mv1.f();
            }
            m02.i("WifiApi", "stopWifi: 12010 : unknown failed");
            return new mv1(12010, "unknown failed");
        }
        return (mv1) invokeL.objValue;
    }

    public mv1 B(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
            q("#getConnectedWifi", false);
            m33 b0 = m33.b0();
            if (b0 == null) {
                m02.c("WifiApi", "getConnectedWifi: 1001 : swan app is null");
                return new mv1(1001, "swan app is null");
            } else if (b0.w() == null) {
                m02.c("WifiApi", "getConnectedWifi: 1001 : swan activity is null");
                return new mv1(1001, "swan activity is null");
            } else {
                Pair s = s(str);
                mv1 mv1Var = (mv1) s.first;
                if (!mv1Var.isSuccess()) {
                    return mv1Var;
                }
                String optString = ((JSONObject) s.second).optString("cb");
                if (TextUtils.isEmpty(optString)) {
                    m02.c("WifiApi", "getConnectedWifi: 201 : callback is null");
                    return new mv1(201, "callback is null");
                } else if (b0.n0()) {
                    m02.i("WifiApi", "getConnectedWifi: 12011 : app is invisible");
                    return new mv1(12011, "app is invisible");
                } else {
                    b0.e0().g(getContext(), "mapp_location", new h(this, optString));
                    return mv1.f();
                }
            }
        }
        return (mv1) invokeL.objValue;
    }

    public mv1 C(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
            q("#getWifiList", false);
            m33 b0 = m33.b0();
            if (b0 == null) {
                m02.c("WifiApi", "getWifiList: 1001 : swan app is null");
                return new mv1(1001, "swan app is null");
            } else if (b0.w() == null) {
                m02.c("WifiApi", "getWifiList: 1001 : swan activity is null");
                return new mv1(1001, "swan activity is null");
            } else {
                Pair s = s(str);
                mv1 mv1Var = (mv1) s.first;
                if (!mv1Var.isSuccess()) {
                    return mv1Var;
                }
                String optString = ((JSONObject) s.second).optString("cb");
                if (TextUtils.isEmpty(optString)) {
                    m02.c("WifiApi", "getWifiList: 201 : callback is null");
                    return new mv1(201, "callback is null");
                } else if (b0.n0()) {
                    m02.i("WifiApi", "getWifiList: 12011 : app is invisible");
                    return new mv1(12011, "app is invisible");
                } else {
                    b0.e0().g(getContext(), "mapp_location", new f(this, optString));
                    return mv1.f();
                }
            }
        }
        return (mv1) invokeL.objValue;
    }

    public final void E(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, str) == null) {
            SwanAppActivity w = l33.K().w();
            oy2.g(w, new String[]{com.kuaishou.weapon.p0.h.g, com.kuaishou.weapon.p0.h.h}, 0, new i(this, w, str));
        }
    }

    public final void F(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, str) == null) {
            SwanAppActivity w = l33.K().w();
            oy2.g(w, new String[]{com.kuaishou.weapon.p0.h.g, com.kuaishou.weapon.p0.h.h}, 0, new g(this, w, str));
        }
    }
}
