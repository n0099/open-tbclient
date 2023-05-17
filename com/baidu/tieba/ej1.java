package com.baidu.tieba;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.bdtask.model.response.TaskResponseData;
import com.baidu.prologue.business.data.BaseVM;
import com.baidu.searchbox.launch.utils.SpeedStatsUtils;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class ej1 {
    public static /* synthetic */ Interceptable $ic;
    public static a a;
    public static float b;
    public static float c;
    public static int d;
    public static int e;
    public static float f;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes5.dex */
    public static class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public long a;
        public ArrayList<C0272a> b;

        /* renamed from: com.baidu.tieba.ej1$a$a  reason: collision with other inner class name */
        /* loaded from: classes5.dex */
        public static class C0272a {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public long a;
            public long b;

            public C0272a(long j, long j2) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {Long.valueOf(j), Long.valueOf(j2)};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = j;
                this.b = j2;
            }

            public boolean a(long j) {
                InterceptResult invokeJ;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeJ = interceptable.invokeJ(1048576, this, j)) == null) {
                    if (j >= this.a && j <= this.b) {
                        return true;
                    }
                    return false;
                }
                return invokeJ.booleanValue;
            }
        }

        public a(JSONObject jSONObject) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {jSONObject};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = new ArrayList<>();
            this.a = jSONObject.optLong("expires", 0L);
            JSONArray optJSONArray = jSONObject.optJSONArray("schedule");
            if (optJSONArray != null && optJSONArray.length() > 0) {
                for (int i3 = 0; i3 < optJSONArray.length(); i3++) {
                    JSONObject optJSONObject = optJSONArray.optJSONObject(i3);
                    if (optJSONObject != null) {
                        this.b.add(new C0272a(optJSONObject.optLong("start", 0L), optJSONObject.optLong("end", 0L)));
                    }
                }
            }
        }

        @Nullable
        public static a c(@Nullable JSONObject jSONObject) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, jSONObject)) == null) {
                if (jSONObject == null) {
                    return null;
                }
                try {
                    return new a(jSONObject);
                } catch (Exception unused) {
                    return null;
                }
            }
            return (a) invokeL.objValue;
        }

        public final boolean g(long j) {
            InterceptResult invokeJ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeJ = interceptable.invokeJ(1048579, this, j)) == null) {
                if (this.a > j) {
                    return true;
                }
                return false;
            }
            return invokeJ.booleanValue;
        }

        public final boolean d() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return e(System.currentTimeMillis() / 1000);
            }
            return invokeV.booleanValue;
        }

        public final boolean f() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                return g(System.currentTimeMillis() / 1000);
            }
            return invokeV.booleanValue;
        }

        public final boolean e(long j) {
            InterceptResult invokeJ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeJ = interceptable.invokeJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, j)) == null) {
                if (o11.l(this.b) == 0) {
                    return false;
                }
                Iterator<C0272a> it = this.b.iterator();
                while (it.hasNext()) {
                    C0272a next = it.next();
                    if (next != null && next.a(j)) {
                        return true;
                    }
                }
                return false;
            }
            return invokeJ.booleanValue;
        }
    }

    public static void A(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(65536, null, i) == null) {
            b21.a().b("splash_sp_name").g("hot_splash_max_count", i);
        }
    }

    public static void B(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(65537, null, i) == null) {
            b21.a().b("splash_sp_name").g("hot_switch", i);
        }
    }

    public static void C(float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(65538, null, f2) == null) {
            b21.a().b("splash_sp_name").f("hot_background_time", f2);
        }
    }

    public static void D(float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(65539, null, f2) == null) {
            b21.a().b("splash_sp_name").f("hot_update_split_time", f2);
        }
    }

    public static void E(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, str) == null) && !TextUtils.isEmpty(str)) {
            b21.a().b("splash_sp_name").j("inner_monitor_host", str, false);
        }
    }

    public static void F(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(65541, null, i) == null) {
            b21.a().b("splash_sp_name").g("md5_check_switch", i);
        }
    }

    public static void G(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(65542, null, i) == null) {
            b21.a().b("splash_sp_name").g("monitor_log_switch", i);
        }
    }

    public static void H(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(65543, null, i) == null) {
            b21.a().b("splash_sp_name").g("query_host_opt", i);
        }
    }

    public static void I(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(65544, null, i) == null) {
            b21.a().b("splash_sp_name").g("query_time_out_advance", i);
        }
    }

    public static void J(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(65545, null, i) == null) {
            b21.a().b("splash_sp_name").g("request_count", i);
        }
    }

    public static void K(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65546, null, str) == null) {
            String str2 = "";
            if (!TextUtils.isEmpty(str)) {
                try {
                    str2 = new JSONObject(str).optString("server_block_reason", "");
                } catch (JSONException unused) {
                }
            }
            b21.a().b("splash_sp_name").i("server_block_reason", str2);
        }
    }

    public static void v(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(65571, null, i) == null) {
            b21.a().b("splash_sp_name").g("open_bes_switch", i);
        }
    }

    public static void w(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65572, null, str) == null) && !TextUtils.isEmpty(str)) {
            a = a.c(p11.c(str));
            b21.a().b("splash_sp_name").j("cpt_config", str, false);
        }
    }

    public static void x(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(65573, null, i) == null) {
            b21.a().b("splash_sp_name").g("crash_opt", i);
        }
    }

    public static void y(JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65574, null, jSONObject) == null) {
            C((float) jSONObject.optDouble("hot_background_time", 5.0d));
            A(jSONObject.optInt("hot_splash_max_count", 3));
            B(jSONObject.optInt("hot_switch", 1));
        }
    }

    public static void L(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(65547, null, str) != null) || TextUtils.isEmpty(str)) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            JSONObject optJSONObject = jSONObject.optJSONObject("freq");
            if (optJSONObject != null) {
                y(optJSONObject);
            }
            I(jSONObject.optInt("query_time_out_advance", 100));
            D((float) jSONObject.optDouble("hot_update_split_time", 5.0d));
            v(jSONObject.optInt("open_bes_switch", 0));
            F(jSONObject.optInt("md5_check_switch", 0));
            J(jSONObject.optInt("request_count", 10));
            G(jSONObject.optInt("monitor_log_switch", 1));
            E(jSONObject.optString("inner_monitor_host", "https://sp0.baidu.com"));
            x(jSONObject.optInt("crash_opt", 1));
            w(jSONObject.optString("cpt_config", ""));
            H(jSONObject.optInt("query_host_opt", 0));
            z(jSONObject);
        } catch (JSONException unused) {
        }
    }

    public static void z(JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(65575, null, jSONObject) != null) || jSONObject == null) {
            return;
        }
        if (jSONObject.has("gesture_lottie_sensitivity")) {
            b = (float) jSONObject.optDouble("gesture_lottie_sensitivity", 0.0d);
        }
        if (jSONObject.has("hot_shake_sensitivity")) {
            c = (float) jSONObject.optDouble("hot_shake_sensitivity", 0.0d);
        }
        if (jSONObject.has("shake_update_interval")) {
            d = jSONObject.optInt("shake_update_interval", 67);
        }
        if (jSONObject.has("shake_direction_count")) {
            e = jSONObject.optInt("shake_direction_count", 2);
        }
        if (jSONObject.has("shake_action_delay_time")) {
            f = (float) jSONObject.optDouble("shake_action_delay_time", -1.0d);
        }
    }

    public static boolean M() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65548, null)) == null) {
            JSONObject d2 = ri1.a().d();
            if (d2 == null) {
                return false;
            }
            return d2.optBoolean("is_block_shake_gesture", false);
        }
        return invokeV.booleanValue;
    }

    public static boolean N() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65549, null)) == null) {
            if (b21.a().b("splash_sp_name").getInt("query_host_opt", 0) != 1) {
                return false;
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    public static boolean b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65551, null)) == null) {
            return c(false);
        }
        return invokeV.booleanValue;
    }

    public static int d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65553, null)) == null) {
            JSONObject d2 = ri1.a().d();
            if (d2 != null && d2.has("cpc_show_times")) {
                return d2.optInt("cpc_show_times");
            }
            return Integer.MAX_VALUE;
        }
        return invokeV.intValue;
    }

    @Nullable
    public static a e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65554, null)) == null) {
            if (a == null) {
                a = f();
            }
            return a;
        }
        return (a) invokeV.objValue;
    }

    public static int g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65556, null)) == null) {
            return b21.a().b("splash_sp_name").getInt("hot_splash_max_count", 3);
        }
        return invokeV.intValue;
    }

    public static float h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65557, null)) == null) {
            return b21.a().b("splash_sp_name").getFloat("hot_background_time", 5.0f);
        }
        return invokeV.floatValue;
    }

    public static float i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65558, null)) == null) {
            return b21.a().b("splash_sp_name").getFloat("hot_update_split_time", 5.0f);
        }
        return invokeV.floatValue;
    }

    public static String j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65559, null)) == null) {
            return b21.a().b("splash_sp_name").getString("inner_monitor_host", "https://sp0.baidu.com");
        }
        return (String) invokeV.objValue;
    }

    public static boolean k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65560, null)) == null) {
            if (b21.a().b("splash_sp_name").getInt("monitor_log_switch", 1) == 1) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    @NonNull
    public static String l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65561, null)) == null) {
            if (t()) {
                return n();
            }
            return ri1.a().e();
        }
        return (String) invokeV.objValue;
    }

    public static int m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65562, null)) == null) {
            return b21.a().b("splash_sp_name").getInt("query_time_out_advance", 100);
        }
        return invokeV.intValue;
    }

    @NonNull
    public static String n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65563, null)) == null) {
            JSONObject d2 = ri1.a().d();
            if (d2 == null || !d2.has("query_unite_pid")) {
                return "";
            }
            return d2.optString("query_unite_pid", "");
        }
        return (String) invokeV.objValue;
    }

    public static int o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65564, null)) == null) {
            return b21.a().b("splash_sp_name").getInt("request_count", 10);
        }
        return invokeV.intValue;
    }

    public static String p() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65565, null)) == null) {
            return b21.a().b("splash_sp_name").getString("server_block_reason", "");
        }
        return (String) invokeV.objValue;
    }

    public static boolean q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65566, null)) == null) {
            if (vm0.b().a().a("nad_hot_background_time_opt", 0) != 1) {
                return false;
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    public static boolean r() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65567, null)) == null) {
            if (!TextUtils.equals(SpeedStatsUtils.UBC_VALUE_SPLASH, "sdk") && vm0.b().a().a("cmd_uniform_enable", 0) == 0) {
                return false;
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    public static boolean s() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65568, null)) == null) {
            JSONObject d2 = ri1.a().d();
            if (d2 == null || d2.optInt("nad_splash_query_download_opt", 0) != 1) {
                return false;
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    public static boolean t() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65569, null)) == null) {
            if (vm0.b().a().a("query_uniform_enable", 0) != 1 || TextUtils.isEmpty(n())) {
                return false;
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    public static boolean u() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65570, null)) == null) {
            if (vm0.b().a().a("query_url_cache_opt", 0) != 1) {
                return false;
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    public static boolean a(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65550, null, i)) == null) {
            JSONObject d2 = ri1.a().d();
            if (d2 == null || !d2.has("cpc_show_scene")) {
                return true;
            }
            int optInt = d2.optInt("cpc_show_scene", 0);
            if (optInt != 1) {
                if (optInt != 2 || i == 1) {
                    return true;
                }
                return false;
            } else if (i == 0) {
                return true;
            } else {
                return false;
            }
        }
        return invokeI.booleanValue;
    }

    public static boolean c(boolean z) {
        InterceptResult invokeZ;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(65552, null, z)) == null) {
            a e2 = e();
            if (e2 == null) {
                i = 13001;
            } else if (!e2.f()) {
                i = TaskResponseData.ERROR_NO_TASK_OFFLINE_02;
            } else if (e2.d()) {
                i = 13003;
            } else {
                i = 0;
            }
            if (i != 0 && z) {
                BaseVM.k(i);
            }
            if (i != 0) {
                return false;
            }
            return true;
        }
        return invokeZ.booleanValue;
    }

    @Nullable
    public static a f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65555, null)) == null) {
            String string = b21.a().b("splash_sp_name").getString("cpt_config", "");
            if (!TextUtils.isEmpty(string)) {
                return a.c(p11.c(string));
            }
            return null;
        }
        return (a) invokeV.objValue;
    }
}
