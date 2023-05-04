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
/* loaded from: classes3.dex */
public class bk0 {
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

    public bk0() {
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
    public static bk0 a(String str) {
        InterceptResult invokeL;
        boolean z;
        boolean z2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, str)) == null) {
            bk0 bk0Var = new bk0();
            JSONObject c = z01.c(str);
            bk0Var.a = c.optString("page");
            bk0Var.b = c.optString("business");
            bk0Var.d = c.optString("content_type");
            bk0Var.e = c.optLong(BreakpointSQLiteKey.CONTENT_LENGTH);
            boolean z3 = false;
            if (c.optInt("is_dirty", 0) == 1) {
                z = true;
            } else {
                z = false;
            }
            bk0Var.f = z;
            bk0Var.g = c.optInt("close_v_download", 0);
            bk0Var.h = c.optInt("no_click_opt");
            bk0Var.i = c.optInt("open_after_install");
            bk0Var.j = c.optString("action_area");
            bk0Var.k = c.optInt("notification_show_count");
            bk0Var.l = c.optInt("tips_show_count");
            bk0Var.p = c.optLong("als_app_save_day");
            bk0Var.q = c.optLong("finished_install_time", -1L);
            if (c.optInt("lazy_launch_switch", 0) == 1) {
                z2 = true;
            } else {
                z2 = false;
            }
            bk0Var.s = z2;
            bk0Var.t = c.optInt("lazy_launch_internal", 0);
            int optInt = c.optInt("package_launch_switch", Integer.MIN_VALUE);
            if (optInt == Integer.MIN_VALUE) {
                if (fm0.b().a().a("package_launch_switch", 1) == 1) {
                    z3 = true;
                }
                bk0Var.u = z3;
            } else {
                if (optInt == 1) {
                    z3 = true;
                }
                bk0Var.u = z3;
            }
            return bk0Var;
        }
        return (bk0) invokeL.objValue;
    }

    public static String b(@NonNull bk0 bk0Var) {
        InterceptResult invokeL;
        int i;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, bk0Var)) == null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("page", bk0Var.a);
                jSONObject.put("business", bk0Var.b);
                jSONObject.put("content_type", bk0Var.d);
                jSONObject.put(BreakpointSQLiteKey.CONTENT_LENGTH, bk0Var.e);
                int i3 = 1;
                if (bk0Var.f) {
                    i = 1;
                } else {
                    i = 0;
                }
                jSONObject.put("is_dirty", i);
                jSONObject.put("close_v_download", bk0Var.g);
                jSONObject.put("no_click_opt", bk0Var.h);
                jSONObject.put("open_after_install", bk0Var.i);
                jSONObject.put("action_area", bk0Var.j);
                jSONObject.put("notification_show_count", bk0Var.k);
                jSONObject.put("tips_show_count", bk0Var.l);
                jSONObject.put("als_app_save_day", bk0Var.p);
                jSONObject.put("finished_install_time", bk0Var.q);
                if (bk0Var.s) {
                    i2 = 1;
                } else {
                    i2 = 0;
                }
                jSONObject.put("lazy_launch_switch", i2);
                jSONObject.put("lazy_launch_internal", bk0Var.t);
                if (!bk0Var.u) {
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
