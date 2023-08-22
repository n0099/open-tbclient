package com.baidu.tieba;

import android.text.TextUtils;
import android.util.Pair;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.yy.gameassist.GameAssistConstKt;
import com.baidu.tieba.dv2;
import com.baidu.tieba.i02;
import com.baidu.tieba.ig3;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class h02 extends gz1 implements i02.c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @Override // com.baidu.tieba.gz1
    public String h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? "LocationService" : (String) invokeV.objValue;
    }

    @Override // com.baidu.tieba.gz1
    public String j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? "GetLocationApi" : (String) invokeV.objValue;
    }

    /* loaded from: classes6.dex */
    public class b implements wp3<gg3<ig3.e>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ h02 b;

        /* loaded from: classes6.dex */
        public class a implements dv2.a {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            public a(b bVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {bVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                    }
                }
            }

            @Override // com.baidu.tieba.dv2.a
            public void a(ce3 ce3Var) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, ce3Var) == null) {
                    HashMap hashMap = new HashMap();
                    hashMap.put("data", ce3Var.a().toString());
                    qw2.T().u(new el2("locationChange", hashMap));
                }
            }

            @Override // com.baidu.tieba.dv2.a
            public void onFailed(int i) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i) == null) {
                    ji3.b("startLocationUpdate", 4000, "sdk's errCode is " + i, -1, "");
                }
            }
        }

        public b(h02 h02Var, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {h02Var, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = h02Var;
            this.a = str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.wp3
        /* renamed from: b */
        public void a(gg3<ig3.e> gg3Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, gg3Var) == null) {
                if (!bg3.h(gg3Var)) {
                    int b = gg3Var.b();
                    ji3.b("startLocationUpdate", 5000, bg3.f(b), b, bg3.f(b));
                    this.b.d(this.a, new d32(b, bg3.f(b)));
                } else if (!xo3.M()) {
                    ji3.b("startLocationUpdate", 5004, "user no permission", 10005, bg3.f(10005));
                    this.b.d(this.a, new d32(10005, bg3.f(10005)));
                } else {
                    this.b.d(this.a, new d32(0));
                    ku2.I().f(new a(this));
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class a implements wp3<gg3<ig3.e>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ c a;
        public final /* synthetic */ h02 b;

        public a(h02 h02Var, c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {h02Var, cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = h02Var;
            this.a = cVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.wp3
        /* renamed from: b */
        public void a(gg3<ig3.e> gg3Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, gg3Var) == null) {
                this.b.z(gg3Var, this.a, false);
            }
        }
    }

    /* loaded from: classes6.dex */
    public static class c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public String a;
        public boolean b;
        public String c;

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

        public static c b(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, str)) == null) {
                if (TextUtils.isEmpty(str)) {
                    return null;
                }
                c cVar = new c();
                try {
                    JSONObject jSONObject = new JSONObject(str);
                    String optString = jSONObject.optString("type");
                    cVar.a = optString;
                    if (TextUtils.isEmpty(optString)) {
                        cVar.a = "wgs84";
                    }
                    cVar.b = jSONObject.optBoolean("altitude");
                    String optString2 = jSONObject.optString("cb");
                    cVar.c = optString2;
                    if (TextUtils.isEmpty(optString2)) {
                        return null;
                    }
                    return cVar;
                } catch (JSONException e) {
                    d82.d("GetLocationApi", "# parseFromJSON error", e);
                    return null;
                }
            }
            return (c) invokeL.objValue;
        }

        public boolean a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                if ((TextUtils.equals(this.a, "wgs84") || TextUtils.equals(this.a, "gcj02") || TextUtils.equals(this.a, "bd09ll")) && !TextUtils.isEmpty(this.c)) {
                    return true;
                }
                return false;
            }
            return invokeV.booleanValue;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public h02(@NonNull ez1 ez1Var) {
        super(ez1Var);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {ez1Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((ez1) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    public d32 A(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
            q("#startLocationUpdate", false);
            db3 b0 = db3.b0();
            if (b0 == null) {
                ji3.b("startLocationUpdate", 2001, "SwanApp is null", 1001, "SwanApp is null");
                return new d32(1001, "SwanApp is null");
            }
            Pair<d32, JSONObject> s = s(str);
            d32 d32Var = (d32) s.first;
            if (!d32Var.isSuccess()) {
                return d32Var;
            }
            String optString = ((JSONObject) s.second).optString("cb");
            if (TextUtils.isEmpty(optString)) {
                ji3.b("startLocationUpdate", 1001, "empty cb", 201, "empty cb");
                d82.c("GetLocationApi", "empty cb");
                return new d32(201, "empty cb");
            }
            b0.e0().g(getContext(), "mapp_location", new b(this, optString));
            return d32.f();
        }
        return (d32) invokeL.objValue;
    }

    public d32 y(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, str)) == null) {
            q("#getLocation", false);
            db3 b0 = db3.b0();
            if (b0 == null) {
                ji3.b(GameAssistConstKt.METHOD_GET_LOCATION, 2001, "SwanApp is null", 1001, "SwanApp is null");
                return new d32(1001, "SwanApp is null");
            }
            Pair<d32, JSONObject> s = s(str);
            d32 d32Var = (d32) s.first;
            if (!d32Var.isSuccess()) {
                return d32Var;
            }
            c b2 = c.b(((JSONObject) s.second).toString());
            if (b2 != null && b2.a()) {
                if (TextUtils.isEmpty(b2.c)) {
                    ji3.b(GameAssistConstKt.METHOD_GET_LOCATION, 1001, "empty cb", 201, "empty cb");
                    d82.c("GetLocationApi", "empty cb");
                    return new d32(201, "empty cb");
                }
                b0.e0().g(getContext(), "mapp_location", new a(this, b2));
                return d32.f();
            }
            ji3.b(GameAssistConstKt.METHOD_GET_LOCATION, 1001, "params is invalid", 201, "params is invalid");
            p("params is invalid", null, true);
            return new d32(201, "params is invalid");
        }
        return (d32) invokeL.objValue;
    }

    public d32 B() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            ku2.I().e();
            return d32.f();
        }
        return (d32) invokeV.objValue;
    }

    @Override // com.baidu.tieba.i02.c
    public void b(c cVar, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, cVar, i) == null) {
            d82.c("GetLocationApi", "request location error code : " + i);
            d(cVar.c, new d32(1001, String.valueOf(i)));
        }
    }

    @Override // com.baidu.tieba.i02.c
    public void f(c cVar, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048579, this, cVar, str) == null) {
            d(cVar.c, new d32(10005, "system deny"));
        }
    }

    @Override // com.baidu.tieba.i02.c
    public void g(c cVar, ce3 ce3Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048580, this, cVar, ce3Var) == null) {
            d(cVar.c, new d32(0, "success", ce3Var.a()));
        }
    }

    public final void z(gg3<ig3.e> gg3Var, c cVar, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLZ(InputDeviceCompat.SOURCE_TOUCHPAD, this, gg3Var, cVar, z) == null) {
            d82.i("GetLocationApi", "authorized result is " + gg3Var);
            if (bg3.h(gg3Var)) {
                i02.d().e(cVar, this, z);
                return;
            }
            int b2 = gg3Var.b();
            ji3.b(GameAssistConstKt.METHOD_GET_LOCATION, 5000, bg3.f(b2), b2, bg3.f(b2));
            d(cVar.c, new d32(b2, bg3.f(b2)));
        }
    }
}
