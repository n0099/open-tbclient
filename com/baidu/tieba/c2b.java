package com.baidu.tieba;

import android.text.TextUtils;
import android.util.JsonWriter;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.platform.comapi.map.MapBundleKey;
import com.baidu.searchbox.logsystem.basic.upload.Constant;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class c2b implements n3b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String a;
    public String b;
    public int c;
    public String d;
    public JSONObject e;
    public long f;
    public int g;
    public String h;
    public String i;
    public boolean j;
    public String k;
    public String l;
    public String m;

    public c2b(String str) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.d = "";
        this.j = false;
        this.k = "";
        this.l = "0";
        this.a = str;
        this.b = str;
        this.c = -1;
        this.g = 0;
    }

    public c2b(String str, String str2, int i) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, str2, Integer.valueOf(i)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.d = "";
        this.j = false;
        this.k = "";
        this.l = "0";
        this.a = str;
        this.b = str;
        this.c = -1;
        this.d = str2;
        this.g = i;
        if ((i & 2) == 0) {
            this.f = System.currentTimeMillis();
        }
    }

    public c2b(String str, String str2, int i, String str3, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, str2, Integer.valueOf(i), str3, Integer.valueOf(i2)};
            interceptable.invokeUnInit(65538, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.d = "";
        this.j = false;
        this.k = "";
        this.l = "0";
        this.a = str2;
        this.b = str;
        this.c = i;
        this.d = str3;
        this.g = i2;
        if ((i2 & 2) == 0) {
            this.f = System.currentTimeMillis();
        }
    }

    public c2b(String str, String str2, int i, String str3, long j, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, str2, Integer.valueOf(i), str3, Long.valueOf(j), Integer.valueOf(i2)};
            interceptable.invokeUnInit(65539, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65539, newInitContext);
                return;
            }
        }
        this.d = "";
        this.j = false;
        this.k = "";
        this.l = "0";
        this.a = str2;
        this.b = str;
        this.c = i;
        this.d = str3;
        this.g = i2;
        if ((i2 & 2) == 0) {
            if (j > 0) {
                this.f = j;
            } else {
                this.f = System.currentTimeMillis();
            }
        }
    }

    public c2b(String str, JSONObject jSONObject, int i) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, jSONObject, Integer.valueOf(i)};
            interceptable.invokeUnInit(InputDeviceCompat.SOURCE_TRACKBALL, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(InputDeviceCompat.SOURCE_TRACKBALL, newInitContext);
                return;
            }
        }
        this.d = "";
        this.j = false;
        this.k = "";
        this.l = "0";
        this.a = str;
        this.b = str;
        this.c = -1;
        this.e = jSONObject;
        this.g = i;
        if ((i & 2) == 0) {
            this.f = System.currentTimeMillis();
        }
    }

    public void A(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
            this.l = str;
        }
    }

    public void B(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, j) == null) {
            this.f = j;
        }
    }

    public void r(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048595, this, str) == null) {
            this.m = str;
        }
    }

    public void s(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048596, this, str) == null) {
            this.i = str;
        }
    }

    public void t(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048597, this, str) != null) || TextUtils.isEmpty(str)) {
            return;
        }
        this.d = str;
    }

    public void u(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048598, this, z) == null) {
            this.j = z;
        }
    }

    public void w(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048600, this, str) == null) {
            this.h = str;
        }
    }

    public void x(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048601, this, str) == null) {
            this.k = str;
        }
    }

    public void y(JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048602, this, jSONObject) != null) || jSONObject == null) {
            return;
        }
        this.e = jSONObject;
    }

    public void z(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048603, this, i) == null) {
            this.g = i;
        }
    }

    @Override // com.baidu.tieba.n3b
    public JSONObject a() throws JSONException {
        InterceptResult invokeV;
        JSONObject d;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("id", this.a);
            jSONObject.put("timestamp", Long.toString(this.f));
            String str = "0";
            jSONObject.put("type", "0");
            JSONObject jSONObject2 = this.e;
            if (jSONObject2 != null) {
                jSONObject.put("content", jSONObject2.toString());
            } else if (!TextUtils.isEmpty(this.d)) {
                jSONObject.put("content", this.d);
            }
            if (!TextUtils.isEmpty(this.h)) {
                jSONObject.put("abtest", this.h);
            }
            if (!TextUtils.isEmpty(this.i)) {
                jSONObject.put("c", this.i);
            }
            if (this.j) {
                jSONObject.put(MapBundleKey.MapObjKey.OBJ_OFFSET, "1");
            }
            v1b o = v1b.o();
            jSONObject.put(Constant.ID_TYPE, o.z(this.a));
            if (o.O(this.a)) {
                str = "1";
            }
            jSONObject.put(Constant.IS_REAL, str);
            int n = o.n(this.a);
            if (n != 0) {
                jSONObject.put("gflow", String.valueOf(n));
            }
            if (!TextUtils.isEmpty(this.m) && (d = d()) != null) {
                jSONObject.put("bizInfo", d);
            }
            return jSONObject;
        }
        return (JSONObject) invokeV.objValue;
    }

    @Override // com.baidu.tieba.n3b
    public void b(JsonWriter jsonWriter) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, jsonWriter) == null) {
            jsonWriter.beginObject();
            jsonWriter.name("id").value(this.a);
            jsonWriter.name("timestamp").value(Long.toString(this.f));
            String str = "0";
            jsonWriter.name("type").value("0");
            if (this.e != null) {
                jsonWriter.name("content").value(this.e.toString());
            } else if (!TextUtils.isEmpty(this.d)) {
                jsonWriter.name("content").value(this.d);
            }
            if (!TextUtils.isEmpty(this.h)) {
                jsonWriter.name("abtest").value(this.h);
            }
            if (!TextUtils.isEmpty(this.i)) {
                jsonWriter.name("c").value(this.i);
            }
            if (this.j) {
                jsonWriter.name(MapBundleKey.MapObjKey.OBJ_OFFSET).value("1");
            }
            jsonWriter.name(Constant.ID_TYPE).value(v1b.o().z(this.a));
            JsonWriter name = jsonWriter.name(Constant.IS_REAL);
            if (v1b.o().O(this.a)) {
                str = "1";
            }
            name.value(str);
            int n = v1b.o().n(this.a);
            if (n != 0) {
                jsonWriter.name("gflow").value(String.valueOf(n));
            }
            if (!TextUtils.isEmpty(this.m) && d() != null) {
                jsonWriter.name("bizInfo");
                u3b.a(jsonWriter, d());
            }
            jsonWriter.endObject();
        }
    }

    public String c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.m;
        }
        return (String) invokeV.objValue;
    }

    public JSONObject d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            if (TextUtils.isEmpty(this.m)) {
                return null;
            }
            try {
                return new JSONObject(this.m);
            } catch (JSONException e) {
                if (!q2b.m()) {
                    return null;
                }
                e.printStackTrace();
                return null;
            }
        }
        return (JSONObject) invokeV.objValue;
    }

    public String e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return this.i;
        }
        return (String) invokeV.objValue;
    }

    public String f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return this.d;
        }
        return (String) invokeV.objValue;
    }

    public String h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            return this.h;
        }
        return (String) invokeV.objValue;
    }

    public String i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            return this.k;
        }
        return (String) invokeV.objValue;
    }

    public int j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            return this.c;
        }
        return invokeV.intValue;
    }

    public String k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            return this.b;
        }
        return (String) invokeV.objValue;
    }

    public String l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            return this.a;
        }
        return (String) invokeV.objValue;
    }

    public JSONObject m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            return this.e;
        }
        return (JSONObject) invokeV.objValue;
    }

    public int n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            return this.g;
        }
        return invokeV.intValue;
    }

    public String o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
            return this.l;
        }
        return (String) invokeV.objValue;
    }

    public long p() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) {
            return this.f;
        }
        return invokeV.longValue;
    }

    public boolean q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) {
            return this.j;
        }
        return invokeV.booleanValue;
    }

    public void v() {
        String str;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048599, this) == null) && (str = this.a) != null && str.equals(this.b) && v1b.o().a(this.a)) {
            this.h = q2b.i().h();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x0042  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0052  */
    /* JADX WARN: Removed duplicated region for block: B:30:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public int g() {
        InterceptResult invokeV;
        int length;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            int i = 0;
            if (!TextUtils.isEmpty(this.a)) {
                i = 0 + this.a.getBytes().length;
            }
            JSONObject jSONObject = this.e;
            if (jSONObject != null) {
                try {
                    length = jSONObject.toString().getBytes("UTF-8").length;
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                }
            } else {
                if (!TextUtils.isEmpty(this.d)) {
                    length = this.d.getBytes().length;
                }
                if (!TextUtils.isEmpty(this.h)) {
                    i += this.h.getBytes().length;
                }
                if (TextUtils.isEmpty(this.m)) {
                    return i + this.m.getBytes().length;
                }
                return i;
            }
            i += length;
            if (!TextUtils.isEmpty(this.h)) {
            }
            if (TextUtils.isEmpty(this.m)) {
            }
        } else {
            return invokeV.intValue;
        }
    }
}
