package com.baidu.tieba;

import android.text.TextUtils;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
/* loaded from: classes5.dex */
public class ee5 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public List<fe5> a;

    public ee5() {
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
                    da5.p().J("key_index_tab_info_list", "[]");
                    return;
                }
                JSONArray jSONArray2 = new JSONArray(da5.p().w("key_index_tab_info_list", "[]"));
                for (int i = 0; i < jSONArray.length(); i++) {
                    fe5 fe5Var = new fe5();
                    fe5 fe5Var2 = new fe5();
                    fe5Var.i(jSONArray.getJSONObject(i));
                    for (int i2 = 0; i2 < jSONArray2.length(); i2++) {
                        fe5Var2.i(jSONArray2.getJSONObject(i2));
                        if (fe5Var.c != null && fe5Var.c.equals(fe5Var2.c)) {
                            if (!TextUtils.isEmpty(fe5Var2.e) && fe5Var2.e.equals(fe5Var.e)) {
                                z = false;
                                fe5Var.f = z;
                            }
                            z = true;
                            fe5Var.f = z;
                        }
                    }
                    if (!fe5Var.f()) {
                        this.a.add(fe5Var);
                    }
                }
                da5.p().J("key_index_tab_info_list", jSONArray.toString());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
