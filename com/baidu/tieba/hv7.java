package com.baidu.tieba;

import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.atomData.MangaBrowserActivityConfig;
import com.baidu.tbadk.core.atomData.VideoPlayActivityConfig;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class hv7 implements rd5 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String a;
    public String b;
    public String c;
    public long d;
    public String e;
    public boolean f;
    public boolean g;
    public int h;
    public boolean i;
    public long j;
    public int k;
    public boolean l;
    public String m;
    public String n;
    public String o;
    public boolean p;

    public hv7() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = "";
        this.b = "";
        this.c = "";
        this.d = System.currentTimeMillis();
        this.e = "";
        this.f = false;
        this.g = false;
        this.h = 0;
        this.i = false;
        this.m = "";
        this.n = "";
        this.o = "";
        this.p = true;
    }

    public void A(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
            this.l = z;
        }
    }

    public void C(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) {
            this.p = z;
        }
    }

    public void D(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) {
            this.m = str;
        }
    }

    public void G(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048579, this, z) == null) {
            this.i = z;
        }
    }

    public void H(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, str) == null) {
            this.e = str;
        }
    }

    public void I(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048581, this, z) == null) {
            this.g = z;
        }
    }

    public void J(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, str) == null) {
            this.a = str;
        }
    }

    public void K(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, str) == null) {
            this.b = str;
        }
    }

    public void L(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i) == null) {
            this.h = i;
        }
    }

    public void M(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, str) == null) {
            this.n = str;
        }
    }

    public void u(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048608, this, j) == null) {
            this.j = j;
        }
    }

    public void v(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048609, this, i) == null) {
            this.k = i;
        }
    }

    @Override // com.baidu.tieba.rd5
    public boolean w(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048610, this, str)) == null) {
            if (str != null) {
                try {
                    return s(new JSONObject(str));
                } catch (JSONException e) {
                    e.printStackTrace();
                    return false;
                }
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public void x(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048611, this, str) == null) {
            this.o = str;
        }
    }

    public void y(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048612, this, str) == null) {
            this.c = str;
        }
    }

    public void z(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048613, this, z) == null) {
            this.f = z;
        }
    }

    public JSONObject N() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("forum_name", this.c);
                jSONObject.put("thread_id", this.a);
                jSONObject.put("thread_time", this.d);
                jSONObject.put("thread_name", this.b);
                jSONObject.put("post_id", this.e);
                jSONObject.put("host_only", this.f);
                jSONObject.put("squence", this.g);
                jSONObject.put("thread_type", this.h);
                jSONObject.put("is_manga", this.i);
                jSONObject.put(MangaBrowserActivityConfig.CARTOON_ID, this.j);
                jSONObject.put(MangaBrowserActivityConfig.CHAPTER_ID, this.k);
                jSONObject.put(VideoPlayActivityConfig.IS_SHARE_THREAD, this.l);
                jSONObject.put("live_id", this.m);
                jSONObject.put("user_name", this.n);
                jSONObject.put("live_description", this.o);
            } catch (JSONException unused) {
            }
            return jSONObject;
        }
        return (JSONObject) invokeV.objValue;
    }

    public long a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            return this.j;
        }
        return invokeV.longValue;
    }

    public int b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            return this.k;
        }
        return invokeV.intValue;
    }

    public String c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            return this.o;
        }
        return (String) invokeV.objValue;
    }

    public String d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            return this.c;
        }
        return (String) invokeV.objValue;
    }

    public String e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            return this.m;
        }
        return (String) invokeV.objValue;
    }

    public String f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) {
            return this.e;
        }
        return (String) invokeV.objValue;
    }

    public String g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) {
            return this.a;
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.tieba.pd5
    public String getCacheKey() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) {
            if (this.h == 49) {
                return this.m + "_ala";
            }
            return this.a;
        }
        return (String) invokeV.objValue;
    }

    public String i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) {
            return this.b;
        }
        return (String) invokeV.objValue;
    }

    public int j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) {
            return this.h;
        }
        return invokeV.intValue;
    }

    public long k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) {
            return this.d;
        }
        return invokeV.longValue;
    }

    @Override // com.baidu.tieba.rd5
    public String l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) {
            return N().toString();
        }
        return (String) invokeV.objValue;
    }

    public String m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048601, this)) == null) {
            return this.n;
        }
        return (String) invokeV.objValue;
    }

    public boolean n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048602, this)) == null) {
            return this.f;
        }
        return invokeV.booleanValue;
    }

    public boolean o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048603, this)) == null) {
            return this.p;
        }
        return invokeV.booleanValue;
    }

    public boolean p() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048604, this)) == null) {
            return this.i;
        }
        return invokeV.booleanValue;
    }

    public boolean q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048605, this)) == null) {
            return this.l;
        }
        return invokeV.booleanValue;
    }

    public boolean r() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048606, this)) == null) {
            return this.g;
        }
        return invokeV.booleanValue;
    }

    public boolean equals(Object obj) {
        InterceptResult invokeL;
        String str;
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048592, this, obj)) == null) {
            if (obj != null && (obj instanceof hv7)) {
                hv7 hv7Var = (hv7) obj;
                if (this.h == 49) {
                    String str3 = this.m;
                    if (str3 != null && (str2 = hv7Var.m) != null && str3.equals(str2)) {
                        return true;
                    }
                } else {
                    String str4 = this.a;
                    if (str4 != null && (str = hv7Var.a) != null && str4.equals(str)) {
                        return true;
                    }
                }
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public int hashCode() {
        InterceptResult invokeV;
        int hashCode;
        int hashCode2;
        int hashCode3;
        int hashCode4;
        int hashCode5;
        int hashCode6;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) {
            if (TextUtils.isEmpty(this.a)) {
                hashCode = 120;
            } else {
                hashCode = 119 + this.a.hashCode();
            }
            if (TextUtils.isEmpty(this.b)) {
                hashCode2 = (hashCode * 7) + 1;
            } else {
                hashCode2 = (hashCode * 7) + this.b.hashCode();
            }
            if (TextUtils.isEmpty(this.c)) {
                hashCode3 = (hashCode2 * 7) + 1;
            } else {
                hashCode3 = (hashCode2 * 7) + this.c.hashCode();
            }
            int i = (hashCode3 * 7) + ((int) this.d);
            if (TextUtils.isEmpty(this.e)) {
                hashCode4 = (i * 7) + 1;
            } else {
                hashCode4 = (i * 7) + this.e.hashCode();
            }
            if (TextUtils.isEmpty(this.m)) {
                hashCode5 = (hashCode4 * 7) + 1;
            } else {
                hashCode5 = (hashCode4 * 7) + this.m.hashCode();
            }
            if (TextUtils.isEmpty(this.o)) {
                hashCode6 = (hashCode5 * 7) + 1;
            } else {
                hashCode6 = (hashCode5 * 7) + this.o.hashCode();
            }
            return (((hashCode6 * 7) + (this.f ? 1 : 0)) * 7) + (this.g ? 1 : 0);
        }
        return invokeV.intValue;
    }

    public boolean s(JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048607, this, jSONObject)) == null) {
            String optString = jSONObject.optString("forum_name");
            String optString2 = jSONObject.optString("thread_id");
            String optString3 = jSONObject.optString("thread_name");
            long optLong = jSONObject.optLong("thread_time");
            this.e = jSONObject.optString("post_id");
            this.f = jSONObject.optBoolean("host_only");
            this.g = jSONObject.optBoolean("squence");
            this.i = jSONObject.optBoolean("is_manga");
            this.j = jSONObject.optLong(MangaBrowserActivityConfig.CARTOON_ID);
            this.k = jSONObject.optInt(MangaBrowserActivityConfig.CHAPTER_ID);
            this.l = jSONObject.optBoolean(VideoPlayActivityConfig.IS_SHARE_THREAD, false);
            if (!TextUtils.isEmpty(optString)) {
                this.c = optString;
            }
            if (!TextUtils.isEmpty(optString2)) {
                this.a = optString2;
            }
            if (!TextUtils.isEmpty(optString3)) {
                this.b = optString3;
            }
            if (optLong > 2000) {
                this.d = optLong;
            }
            this.h = jSONObject.optInt("thread_type");
            this.m = jSONObject.optString("live_id", "");
            this.n = jSONObject.optString("user_name", "");
            this.o = jSONObject.optString("live_description", "");
            return true;
        }
        return invokeL.booleanValue;
    }
}
