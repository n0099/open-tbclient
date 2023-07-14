package com.baidu.tieba;

import android.content.Context;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.unitedscheme.SchemeCollecter;
import com.baidu.tbadk.core.util.httpNet.HttpRequest;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.turbonet.net.ICronetEngineBuilder;
import com.baidu.turbonet.net.impl.VersionSafeCallbacks;
import com.baidu.webkit.internal.ETAG;
import java.io.File;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public abstract class a1b extends ICronetEngineBuilder {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final Context a;
    public String b;
    public String c;
    public boolean d;
    public boolean e;
    public boolean f;
    public boolean g;
    public long h;
    public boolean i;
    public int j;
    public String k;
    public JSONObject l;
    public String m;

    public VersionSafeCallbacks.c v() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048602, this)) == null) {
            return null;
        }
        return (VersionSafeCallbacks.c) invokeV.objValue;
    }

    public a1b(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.j = 20;
        this.a = context.getApplicationContext();
        this.l = new JSONObject();
        m(true);
        k(true);
        j(false);
        l(false, "");
    }

    public final void A(String str, String str2, Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048576, this, str, str2, obj) == null) {
            try {
                JSONObject optJSONObject = this.l.optJSONObject(str);
                if (optJSONObject == null) {
                    optJSONObject = new JSONObject();
                }
                optJSONObject.put(str2, obj);
                this.l.put(str, optJSONObject);
            } catch (JSONException e) {
                throw new IllegalStateException("JSON expcetion:", e);
            }
        }
    }

    public a1b B(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
            if (new File(str).isDirectory()) {
                this.c = str;
                return this;
            }
            throw new IllegalArgumentException("Storage path must be set to existing directory");
        }
        return (a1b) invokeL.objValue;
    }

    public a1b C(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
            A(SchemeCollecter.CLASSIFY_BASE, HttpRequest.USER_AGENT, str);
            this.b = str;
            return this;
        }
        return (a1b) invokeL.objValue;
    }

    public int E(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048580, this, i)) == null) {
            int i2 = this.j;
            if (i2 != 20) {
                return i2;
            }
            return i;
        }
        return invokeI.intValue;
    }

    @Override // com.baidu.turbonet.net.ICronetEngineBuilder
    public /* bridge */ /* synthetic */ ICronetEngineBuilder a(String str) {
        g(str);
        return this;
    }

    @Override // com.baidu.turbonet.net.ICronetEngineBuilder
    public /* bridge */ /* synthetic */ ICronetEngineBuilder d(String str) {
        y(str);
        return this;
    }

    @Override // com.baidu.turbonet.net.ICronetEngineBuilder
    public /* bridge */ /* synthetic */ ICronetEngineBuilder e(String str) {
        z(str);
        return this;
    }

    @Override // com.baidu.turbonet.net.ICronetEngineBuilder
    public /* bridge */ /* synthetic */ ICronetEngineBuilder f(String str) {
        B(str);
        return this;
    }

    public a1b g(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048586, this, str)) == null) {
            this.m = str;
            return this;
        }
        return (a1b) invokeL.objValue;
    }

    public a1b j(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048590, this, z)) == null) {
            this.f = z;
            return this;
        }
        return (a1b) invokeZ.objValue;
    }

    public a1b k(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048591, this, z)) == null) {
            A(SchemeCollecter.CLASSIFY_BASE, "http2_enabled", Boolean.valueOf(z));
            this.e = z;
            return this;
        }
        return (a1b) invokeZ.objValue;
    }

    public a1b m(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048593, this, z)) == null) {
            A(SchemeCollecter.CLASSIFY_BASE, ETAG.KEY_QUIC_ENABLED, Boolean.valueOf(z));
            this.d = z;
            return this;
        }
        return (a1b) invokeZ.objValue;
    }

    public a1b y(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048605, this, str)) == null) {
            A("app", "cuid", str);
            return this;
        }
        return (a1b) invokeL.objValue;
    }

    public a1b z(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048606, this, str)) == null) {
            A("app", "app_name", str);
            return this;
        }
        return (a1b) invokeL.objValue;
    }

    public String D() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.c;
        }
        return (String) invokeV.objValue;
    }

    public Context getContext() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            return this.a;
        }
        return (Context) invokeV.objValue;
    }

    public boolean h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            return this.f;
        }
        return invokeV.booleanValue;
    }

    public boolean i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            return this.g;
        }
        return invokeV.booleanValue;
    }

    public String n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) {
            return this.k;
        }
        return (String) invokeV.objValue;
    }

    public String o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) {
            return this.m;
        }
        return (String) invokeV.objValue;
    }

    public String p() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) {
            return this.l.toString();
        }
        return (String) invokeV.objValue;
    }

    public String q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) {
            return z1b.b(this.a);
        }
        return (String) invokeV.objValue;
    }

    public String r() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) {
            return this.b;
        }
        return (String) invokeV.objValue;
    }

    public boolean s() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) {
            return this.e;
        }
        return invokeV.booleanValue;
    }

    public long t() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) {
            return this.h;
        }
        return invokeV.longValue;
    }

    public int u() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048601, this)) == null) {
            JSONObject optJSONObject = this.l.optJSONObject(SchemeCollecter.CLASSIFY_BASE);
            if (optJSONObject == null) {
                return 0;
            }
            return optJSONObject.optInt("http_cache_mode", 0);
        }
        return invokeV.intValue;
    }

    public boolean w() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048603, this)) == null) {
            return this.i;
        }
        return invokeV.booleanValue;
    }

    public boolean x() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048604, this)) == null) {
            return this.d;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.turbonet.net.ICronetEngineBuilder
    public /* bridge */ /* synthetic */ ICronetEngineBuilder c(boolean z, String str) {
        l(z, str);
        return this;
    }

    public a1b l(boolean z, String str) {
        InterceptResult invokeZL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZL = interceptable.invokeZL(1048592, this, z, str)) == null) {
            A("nq", "network_quality_enabled", Boolean.valueOf(z));
            A("nq", "watched_groups", str);
            this.i = z;
            return this;
        }
        return (a1b) invokeZL.objValue;
    }
}
