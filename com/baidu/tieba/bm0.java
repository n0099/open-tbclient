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
/* loaded from: classes5.dex */
public class bm0 {
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

    public bm0() {
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
    }

    @NonNull
    public static bm0 a(String str) {
        InterceptResult invokeL;
        boolean z;
        boolean z2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, str)) == null) {
            bm0 bm0Var = new bm0();
            JSONObject c = z21.c(str);
            bm0Var.a = c.optString("page");
            bm0Var.b = c.optString("business");
            bm0Var.d = c.optString("content_type");
            bm0Var.e = c.optLong(BreakpointSQLiteKey.CONTENT_LENGTH);
            boolean z3 = false;
            if (c.optInt("is_dirty", 0) == 1) {
                z = true;
            } else {
                z = false;
            }
            bm0Var.f = z;
            bm0Var.g = c.optInt("close_v_download", 0);
            bm0Var.h = c.optInt("no_click_opt");
            bm0Var.i = c.optInt("open_after_install");
            bm0Var.j = c.optString("action_area");
            bm0Var.k = c.optInt("notification_show_count");
            bm0Var.l = c.optInt("tips_show_count");
            bm0Var.p = c.optLong("als_app_save_day");
            bm0Var.q = c.optLong("finished_install_time", -1L);
            if (c.optInt("lazy_launch_switch", 0) == 1) {
                z2 = true;
            } else {
                z2 = false;
            }
            bm0Var.s = z2;
            bm0Var.t = c.optInt("lazy_launch_internal", 0);
            int optInt = c.optInt("package_launch_switch", Integer.MIN_VALUE);
            if (optInt == Integer.MIN_VALUE) {
                if (fo0.b().a().a("package_launch_switch", 1) == 1) {
                    z3 = true;
                }
                bm0Var.u = z3;
            } else {
                if (optInt == 1) {
                    z3 = true;
                }
                bm0Var.u = z3;
            }
            return bm0Var;
        }
        return (bm0) invokeL.objValue;
    }

    public static String b(@NonNull bm0 bm0Var) {
        InterceptResult invokeL;
        int i;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, bm0Var)) == null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("page", bm0Var.a);
                jSONObject.put("business", bm0Var.b);
                jSONObject.put("content_type", bm0Var.d);
                jSONObject.put(BreakpointSQLiteKey.CONTENT_LENGTH, bm0Var.e);
                int i3 = 1;
                if (bm0Var.f) {
                    i = 1;
                } else {
                    i = 0;
                }
                jSONObject.put("is_dirty", i);
                jSONObject.put("close_v_download", bm0Var.g);
                jSONObject.put("no_click_opt", bm0Var.h);
                jSONObject.put("open_after_install", bm0Var.i);
                jSONObject.put("action_area", bm0Var.j);
                jSONObject.put("notification_show_count", bm0Var.k);
                jSONObject.put("tips_show_count", bm0Var.l);
                jSONObject.put("als_app_save_day", bm0Var.p);
                jSONObject.put("finished_install_time", bm0Var.q);
                if (bm0Var.s) {
                    i2 = 1;
                } else {
                    i2 = 0;
                }
                jSONObject.put("lazy_launch_switch", i2);
                jSONObject.put("lazy_launch_internal", bm0Var.t);
                if (!bm0Var.u) {
                    i3 = 0;
                }
                jSONObject.put("package_launch_switch", i3);
            } catch (JSONException unused) {
            }
            return jSONObject.toString();
        }
        return (String) invokeL.objValue;
    }
}
