package com.baidu.tieba;

import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobstat.Config;
import com.baidu.tbadk.core.util.ApiReplaceUtil;
import com.baidu.tbadk.core.util.httpNet.HttpRequest;
import com.baidu.tieba.q40;
import com.baidu.tieba.t40;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class i50 extends t40 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public q40.a d;
    public a e;

    /* loaded from: classes4.dex */
    public class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public long a;
        public boolean b;
        public n40 c;
        public String d;
        public String e;
        public final /* synthetic */ i50 f;

        public a(i50 i50Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {i50Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f = i50Var;
            this.b = true;
            this.c = new n40();
        }

        public String a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return this.e;
            }
            return (String) invokeV.objValue;
        }

        public String b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                return this.d;
            }
            return (String) invokeV.objValue;
        }

        public boolean c() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                if (this.b) {
                    try {
                        JSONObject jSONObject = new JSONObject();
                        jSONObject.put("form_id", this.d);
                        jSONObject.put("lst_fe_ts", this.a);
                        jSONObject.put("c_form_ver", 1);
                        jSONObject.put("flags", this.c.d());
                        jSONObject.put(Config.SSAID, this.e);
                        this.f.d.i("cache.dat", jSONObject.toString(), true);
                        this.b = false;
                        return true;
                    } catch (Exception unused) {
                    }
                }
                return false;
            }
            return invokeV.booleanValue;
        }

        public boolean d() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
                String g = this.f.d.g("cache.dat", true);
                if (!TextUtils.isEmpty(g)) {
                    try {
                        JSONObject jSONObject = new JSONObject(g);
                        this.d = jSONObject.optString("form_id");
                        this.a = jSONObject.getLong("lst_fe_ts");
                        jSONObject.getInt("c_form_ver");
                        this.e = jSONObject.getString(Config.SSAID);
                        this.c.b(jSONObject.getLong("flags"));
                        return true;
                    } catch (Exception unused) {
                        return false;
                    }
                }
                return false;
            }
            return invokeV.booleanValue;
        }

        public void e(String str) {
            String str2;
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048580, this, str) != null) || (str2 = this.e) == str) {
                return;
            }
            if (str == null || !str.equals(str2)) {
                this.e = str;
                this.b = true;
            }
        }

        public void f(String str) {
            String str2;
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048581, this, str) != null) || (str2 = this.d) == str) {
                return;
            }
            if (str == null || !str.equals(str2)) {
                this.d = str;
                this.b = true;
            }
        }

        public void g(long j) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeJ(1048582, this, j) == null) && this.a != j) {
                this.a = j;
                this.b = true;
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947804357, "Lcom/baidu/tieba/i50;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947804357, "Lcom/baidu/tieba/i50;");
                return;
            }
        }
        boolean z = j50.a;
    }

    @Override // com.baidu.tieba.t40
    public String c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.e.b();
        }
        return (String) invokeV.objValue;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public i50() {
        super(Config.SSAID);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((String) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.e = new a(this);
    }

    @Override // com.baidu.tieba.t40
    public void f(t40.c cVar) {
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, cVar) == null) {
            this.d = this.a.f(e());
            try {
                str = ApiReplaceUtil.Overload.getString(this.b.a.getContentResolver(), HttpRequest.ANDROID_ID);
            } catch (Throwable unused) {
                str = null;
            }
            if (str == null) {
                str = "0";
            }
            this.e.d();
            if (TextUtils.isEmpty(this.e.b()) || !TextUtils.equals(str, this.e.a())) {
                this.e.e(str);
                try {
                    this.e.f(t40.b("A30", new k40("ABCDEFGHIJKLMNOPQRSTUVWXYZ234567=", false, false).c(str.getBytes("UTF-8"))));
                } catch (Exception unused2) {
                }
                this.e.g(System.currentTimeMillis());
            }
            this.e.c();
        }
    }
}
