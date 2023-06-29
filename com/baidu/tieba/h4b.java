package com.baidu.tieba;

import android.text.TextUtils;
import android.util.Log;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.config.AppConfig;
import com.baidu.searchbox.ui.animview.praise.resource.ComboPraiseProvider;
import com.baidu.tbadk.TbConfig;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class h4b {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean d;
    public static final String e;
    public transient /* synthetic */ FieldHolder $fh;
    public i4b a;
    public JSONObject b;
    public JSONObject c;

    /* loaded from: classes6.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes6.dex */
    public static class b {
        public static /* synthetic */ Interceptable $ic;
        public static final h4b a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-793836107, "Lcom/baidu/tieba/h4b$b;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-793836107, "Lcom/baidu/tieba/h4b$b;");
                    return;
                }
            }
            a = new h4b(null);
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947775155, "Lcom/baidu/tieba/h4b;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947775155, "Lcom/baidu/tieba/h4b;");
                return;
            }
        }
        d = AppConfig.isDebug();
        e = AppRuntime.getAppContext().getApplicationInfo().dataDir + File.separator + "yalog/";
    }

    public h4b() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        i();
    }

    public static h4b c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            return b.a;
        }
        return (h4b) invokeV.objValue;
    }

    public Map<String, j4b> a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.a.e();
        }
        return (Map) invokeV.objValue;
    }

    public float b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.a.f();
        }
        return invokeV.floatValue;
    }

    public float d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.a.g();
        }
        return invokeV.floatValue;
    }

    public List<k4b> e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.a.h();
        }
        return (List) invokeV.objValue;
    }

    public float f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.a.i();
        }
        return invokeV.floatValue;
    }

    public float g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return this.a.j();
        }
        return invokeV.floatValue;
    }

    public float h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return this.a.k();
        }
        return invokeV.floatValue;
    }

    public final void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            if (this.a == null) {
                this.a = new i4b();
            }
            j();
            k();
        }
    }

    public boolean l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            return this.a.l();
        }
        return invokeV.booleanValue;
    }

    public boolean m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            return this.a.m();
        }
        return invokeV.booleanValue;
    }

    public /* synthetic */ h4b(a aVar) {
        this();
    }

    public final void j() {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            if (!new File(e).exists()) {
                if (d) {
                    Log.d("YaLogConfigManager", "dir not exists.");
                    return;
                }
                return;
            }
            File file = new File(e, "yalog_cloud.txt");
            if (!file.exists()) {
                if (d) {
                    Log.d("YaLogConfigManager", "yalog_cloud.txt not exists, use default value.");
                }
                this.a.p();
                return;
            }
            String a2 = q4b.a(file);
            if (d) {
                Log.d("YaLogConfigManager", "read from local: " + a2);
            }
            if (TextUtils.isEmpty(a2)) {
                this.a.p();
                return;
            }
            try {
                JSONObject jSONObject = new JSONObject(a2);
                this.b = jSONObject;
                this.a.t(jSONObject.optString(TbConfig.SW_APID));
                this.a.q(this.b.optString("cl"));
                this.a.A((float) this.b.optDouble("tosize"));
                this.a.w((float) this.b.optDouble("sisize"));
                this.a.y((float) this.b.optDouble("spsize"));
                this.a.z((float) this.b.optDouble("sptime"));
                this.a.v((float) this.b.optDouble("idsize"));
                if (this.b.has("spdelist")) {
                    List<String> asList = Arrays.asList(this.b.optString("spdelist"));
                    if (asList.size() > 0) {
                        this.a.s(asList);
                    }
                }
                if (this.b.has("splist")) {
                    JSONObject optJSONObject = this.b.optJSONObject("splist");
                    ArrayList arrayList = new ArrayList();
                    if (optJSONObject != null && optJSONObject.length() > 0) {
                        Iterator<String> keys = optJSONObject.keys();
                        while (keys.hasNext()) {
                            String next = keys.next();
                            JSONObject optJSONObject2 = optJSONObject.optJSONObject(next);
                            if (optJSONObject2 != null) {
                                if (!TextUtils.equals("0", optJSONObject2.optString(TbConfig.SW_APID))) {
                                    z = true;
                                } else {
                                    z = false;
                                }
                                arrayList.add(new k4b(next, z, (float) optJSONObject2.optDouble("size"), (float) optJSONObject2.optDouble("time")));
                            }
                        }
                    }
                    if (arrayList.size() > 0) {
                        this.a.x(arrayList);
                    }
                }
            } catch (JSONException e2) {
                if (d) {
                    e2.printStackTrace();
                }
            }
        }
    }

    public final void k() {
        boolean z;
        JSONObject optJSONObject;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            if (!new File(e).exists()) {
                if (d) {
                    Log.d("YaLogConfigManager", "dir not exists.");
                    return;
                }
                return;
            }
            File file = new File(e, "yalog_id_cloud.txt");
            if (!file.exists()) {
                if (d) {
                    Log.d("YaLogConfigManager", "yalog_id_cloud.txt not exists.");
                    return;
                }
                return;
            }
            String a2 = q4b.a(file);
            if (d) {
                Log.d("YaLogConfigManager", "read from local: " + a2);
            }
            if (!TextUtils.isEmpty(a2)) {
                try {
                    JSONObject jSONObject = new JSONObject(a2);
                    this.c = jSONObject;
                    if (jSONObject.has("iddemap") && (optJSONObject = this.c.optJSONObject("iddemap")) != null && optJSONObject.length() > 0) {
                        HashMap hashMap = new HashMap();
                        Iterator<String> keys = optJSONObject.keys();
                        while (keys.hasNext()) {
                            String next = keys.next();
                            hashMap.put(next, optJSONObject.optString(next));
                        }
                        if (hashMap.size() > 0) {
                            this.a.r(hashMap);
                        }
                    }
                    if (this.c.has("idlist")) {
                        JSONObject optJSONObject2 = this.c.optJSONObject("idlist");
                        HashMap hashMap2 = new HashMap();
                        if (optJSONObject2 != null && optJSONObject2.length() > 0) {
                            Iterator<String> keys2 = optJSONObject2.keys();
                            while (keys2.hasNext()) {
                                String next2 = keys2.next();
                                JSONObject optJSONObject3 = optJSONObject2.optJSONObject(next2);
                                if (optJSONObject3 != null) {
                                    String optString = optJSONObject3.optString(TbConfig.SW_APID);
                                    long optLong = optJSONObject3.optLong("v");
                                    if (!TextUtils.equals("0", optString)) {
                                        z = true;
                                    } else {
                                        z = false;
                                    }
                                    hashMap2.put(next2, new j4b(next2, optLong, z, (float) optJSONObject3.optDouble("size")));
                                }
                            }
                        }
                        if (hashMap2.size() > 0) {
                            this.a.u(hashMap2);
                        }
                    }
                } catch (JSONException e2) {
                    if (d) {
                        e2.printStackTrace();
                    }
                }
            }
        }
    }

    public final void n(String str, String str2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048588, this, str, str2) == null) && !TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            try {
                File file = new File(e);
                if (!file.exists()) {
                    file.mkdirs();
                }
                File file2 = new File(e, str);
                String str3 = e;
                File file3 = new File(str3, ComboPraiseProvider.PREFIX_PRESSED_CLICKED + str);
                file3.createNewFile();
                q4b.b(str2, file3);
                if (file2.exists()) {
                    file2.delete();
                }
                file3.renameTo(file2);
                if (d) {
                    Log.d("YaLogConfigManager", "save to local: " + str2);
                }
            } catch (IOException e2) {
                if (d) {
                    e2.printStackTrace();
                }
            }
        }
    }

    public void o(JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048589, this, jSONObject) == null) && jSONObject != null && jSONObject.length() != 0) {
            if (d) {
                Log.d("YaLogConfigManager", "update Config: " + jSONObject.toString());
            }
            if (this.a == null) {
                this.a = new i4b();
            }
            this.a.n(jSONObject);
            p(this.a);
        }
    }

    public final void p(i4b i4bVar) {
        String str;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048590, this, i4bVar) != null) || i4bVar == null) {
            return;
        }
        if (this.b == null) {
            this.b = new JSONObject();
        }
        try {
            this.b.put(TbConfig.SW_APID, i4bVar.d());
            this.b.put("cl", i4bVar.a());
            this.b.put("tosize", String.valueOf(i4bVar.k()));
            this.b.put("sisize", String.valueOf(i4bVar.g()));
            this.b.put("spsize", String.valueOf(i4bVar.i()));
            this.b.put("sptime", String.valueOf(i4bVar.j()));
            this.b.put("idsize", String.valueOf(i4bVar.f()));
            List<String> c = i4bVar.c();
            if (c != null && c.size() > 0) {
                this.b.put("spdelist", TextUtils.join(StringUtil.ARRAY_ELEMENT_SEPARATOR, c));
            }
            List<k4b> h = i4bVar.h();
            if (h != null && h.size() > 0) {
                JSONObject jSONObject = new JSONObject();
                for (k4b k4bVar : h) {
                    String b2 = k4bVar.b();
                    if (!TextUtils.isEmpty(b2)) {
                        JSONObject jSONObject2 = new JSONObject();
                        if (k4bVar.c()) {
                            str = "1";
                        } else {
                            str = "0";
                        }
                        jSONObject2.put(TbConfig.SW_APID, str);
                        jSONObject2.put("size", k4bVar.a());
                        jSONObject2.put("time", k4bVar.d());
                        jSONObject.put(b2, jSONObject2);
                    }
                }
                if (jSONObject.length() > 0) {
                    this.b.put("splist", jSONObject);
                }
            }
            n("yalog_cloud.txt", this.b.toString());
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
    }

    public final void r(i4b i4bVar) {
        String str;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048592, this, i4bVar) != null) || i4bVar == null) {
            return;
        }
        if (this.c == null) {
            this.c = new JSONObject();
        }
        try {
            Map<String, String> b2 = i4bVar.b();
            if (b2 != null && b2.size() > 0) {
                JSONObject jSONObject = new JSONObject();
                for (String str2 : b2.keySet()) {
                    jSONObject.put(str2, b2.get(str2));
                }
                this.c.put("iddemap", jSONObject);
            }
            Map<String, j4b> e2 = i4bVar.e();
            if (e2 != null && e2.size() > 0) {
                JSONObject jSONObject2 = new JSONObject();
                for (String str3 : e2.keySet()) {
                    j4b j4bVar = e2.get(str3);
                    if (j4bVar != null) {
                        JSONObject jSONObject3 = new JSONObject();
                        if (j4bVar.b()) {
                            str = "1";
                        } else {
                            str = "0";
                        }
                        jSONObject3.put(TbConfig.SW_APID, str);
                        jSONObject3.put("size", j4bVar.a());
                        jSONObject3.put("v", j4bVar.c());
                        jSONObject2.put(str3, jSONObject3);
                    }
                }
                if (jSONObject2.length() > 0) {
                    this.c.put("idlist", jSONObject2);
                }
            }
            n("yalog_id_cloud.txt", this.c.toString());
        } catch (JSONException e3) {
            e3.printStackTrace();
        }
    }

    public void q(JSONObject jSONObject, boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLZ(1048591, this, jSONObject, z) == null) && jSONObject != null && jSONObject.length() != 0) {
            if (d) {
                Log.d("YaLogConfigManager", "update Config: " + jSONObject.toString());
            }
            if (this.a == null) {
                this.a = new i4b();
            }
            this.a.o(jSONObject, z);
            r(this.a);
        }
    }
}
