package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.searchbox.bddownload.core.breakpoint.sqlite.BreakpointSQLiteKey;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class il0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String a;
    public String b;
    public String c;
    public String d;
    public long e;
    public boolean f;
    public int g;
    public int h;
    public int i;
    public String j;
    public int k;
    public int l;
    public String m;
    public String n;
    public String o;
    public long p;
    public long q;
    public boolean r;
    public boolean s;
    public int t;
    public boolean u;
    public boolean v;

    public il0() {
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
        this.d = "";
        this.e = 0L;
        this.f = false;
        this.g = 0;
        this.h = 0;
        this.i = 0;
        this.p = -1L;
        this.q = -1L;
        this.s = false;
        this.t = 0;
        this.u = true;
        this.v = false;
    }

    @NonNull
    public static il0 a(String str) {
        InterceptResult invokeL;
        boolean z;
        boolean z2;
        boolean z3;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, str)) == null) {
            il0 il0Var = new il0();
            JSONObject c = e31.c(str);
            il0Var.a = c.optString("page");
            il0Var.b = c.optString("business");
            il0Var.c = c.optString("source");
            il0Var.d = c.optString("content_type");
            il0Var.e = c.optLong(BreakpointSQLiteKey.CONTENT_LENGTH);
            boolean z4 = false;
            if (c.optInt("is_dirty", 0) == 1) {
                z = true;
            } else {
                z = false;
            }
            il0Var.f = z;
            il0Var.g = c.optInt("close_v_download", 0);
            il0Var.h = c.optInt("no_click_opt");
            il0Var.i = c.optInt("open_after_install");
            il0Var.j = c.optString("action_area");
            il0Var.k = c.optInt("notification_show_count");
            il0Var.l = c.optInt("tips_show_count");
            il0Var.p = c.optLong("als_app_save_day");
            il0Var.q = c.optLong("finished_install_time", -1L);
            if (c.optInt("lazy_launch_switch", 0) == 1) {
                z2 = true;
            } else {
                z2 = false;
            }
            il0Var.s = z2;
            il0Var.t = c.optInt("lazy_launch_internal", 0);
            if (c.optInt("is_start_download", 0) == 1) {
                z3 = true;
            } else {
                z3 = false;
            }
            il0Var.v = z3;
            int optInt = c.optInt("package_launch_switch", Integer.MIN_VALUE);
            if (optInt == Integer.MIN_VALUE) {
                if (tn0.b().a().a("package_launch_switch", 1) == 1) {
                    z4 = true;
                }
                il0Var.u = z4;
            } else {
                if (optInt == 1) {
                    z4 = true;
                }
                il0Var.u = z4;
            }
            return il0Var;
        }
        return (il0) invokeL.objValue;
    }

    public static String b(@NonNull il0 il0Var) {
        InterceptResult invokeL;
        int i;
        int i2;
        int i3;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, il0Var)) == null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("page", il0Var.a);
                jSONObject.put("business", il0Var.b);
                jSONObject.put("source", il0Var.c);
                jSONObject.put("content_type", il0Var.d);
                jSONObject.put(BreakpointSQLiteKey.CONTENT_LENGTH, il0Var.e);
                int i4 = 1;
                if (il0Var.f) {
                    i = 1;
                } else {
                    i = 0;
                }
                jSONObject.put("is_dirty", i);
                jSONObject.put("close_v_download", il0Var.g);
                jSONObject.put("no_click_opt", il0Var.h);
                jSONObject.put("open_after_install", il0Var.i);
                jSONObject.put("action_area", il0Var.j);
                jSONObject.put("notification_show_count", il0Var.k);
                jSONObject.put("tips_show_count", il0Var.l);
                jSONObject.put("als_app_save_day", il0Var.p);
                jSONObject.put("finished_install_time", il0Var.q);
                if (il0Var.s) {
                    i2 = 1;
                } else {
                    i2 = 0;
                }
                jSONObject.put("lazy_launch_switch", i2);
                jSONObject.put("lazy_launch_internal", il0Var.t);
                if (il0Var.u) {
                    i3 = 1;
                } else {
                    i3 = 0;
                }
                jSONObject.put("package_launch_switch", i3);
                if (!il0Var.v) {
                    i4 = 0;
                }
                jSONObject.put("is_start_download", i4);
            } catch (JSONException unused) {
            }
            return jSONObject.toString();
        }
        return (String) invokeL.objValue;
    }
}
