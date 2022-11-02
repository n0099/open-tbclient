package com.baidu.tieba;

import android.text.TextUtils;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
/* loaded from: classes4.dex */
public class f25 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public List<g25> a;

    public f25() {
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

    public void a(JSONArray jSONArray) {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, jSONArray) == null) {
            this.a = new ArrayList();
            try {
                if (jSONArray == null) {
                    ky4.k().y("key_index_tab_info_list", "[]");
                    return;
                }
                JSONArray jSONArray2 = new JSONArray(ky4.k().q("key_index_tab_info_list", "[]"));
                for (int i = 0; i < jSONArray.length(); i++) {
                    g25 g25Var = new g25();
                    g25 g25Var2 = new g25();
                    g25Var.h(jSONArray.getJSONObject(i));
                    for (int i2 = 0; i2 < jSONArray2.length(); i2++) {
                        g25Var2.h(jSONArray2.getJSONObject(i2));
                        if (g25Var.c != null && g25Var.c.equals(g25Var2.c)) {
                            if (!TextUtils.isEmpty(g25Var2.e) && g25Var2.e.equals(g25Var.e)) {
                                z = false;
                                g25Var.f = z;
                            }
                            z = true;
                            g25Var.f = z;
                        }
                    }
                    if (!g25Var.e()) {
                        this.a.add(g25Var);
                    }
                }
                ky4.k().y("key_index_tab_info_list", jSONArray.toString());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
