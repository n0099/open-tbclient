package com.baidu.tieba;

import android.os.Bundle;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.gi1;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class hi1 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes6.dex */
    public static class a extends fg1<String> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ gi1 a;

        public a(gi1 gi1Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gi1Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = gi1Var;
        }

        @Override // com.baidu.tieba.fg1
        public void a(Throwable th, int i, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(1048576, this, th, i, str) == null) {
                gi1.a aVar = new gi1.a();
                aVar.a = 2;
                aVar.b = bi1.a().getResources().getString(R.string.obfuscated_res_0x7f0f03be);
                this.a.a(aVar);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.fg1
        /* renamed from: d */
        public void c(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) {
                gi1.a aVar = new gi1.a();
                try {
                    JSONObject jSONObject = new JSONObject(str);
                    if (jSONObject.optInt("errno") == 0) {
                        aVar.a = 0;
                        aVar.b = jSONObject.optString("msg");
                        JSONObject optJSONObject = jSONObject.optJSONObject("data");
                        aVar.c = optJSONObject.optLong("totalAmount");
                        aVar.d = optJSONObject.optLong("userPayAmount");
                        aVar.f = optJSONObject.optString("usedHostMarketingDetail");
                        aVar.h = gi1.a.C0317a.c(optJSONObject.optJSONArray("promotionStatus"));
                    } else {
                        aVar.a = jSONObject.optInt("errorLevel", 2);
                        aVar.b = jSONObject.optString("msg");
                    }
                } catch (Exception unused) {
                    aVar.a = 2;
                    aVar.b = bi1.a().getResources().getString(R.string.obfuscated_res_0x7f0f03be);
                }
                this.a.a(aVar);
            }
        }
    }

    /* loaded from: classes6.dex */
    public static class b extends fg1<String> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ gi1 a;

        public b(gi1 gi1Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gi1Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = gi1Var;
        }

        @Override // com.baidu.tieba.fg1
        public void a(Throwable th, int i, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(1048576, this, th, i, str) == null) {
                gi1.a aVar = new gi1.a();
                aVar.a = 2;
                aVar.b = bi1.a().getResources().getString(R.string.obfuscated_res_0x7f0f03be);
                this.a.a(aVar);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.fg1
        /* renamed from: d */
        public void c(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) {
                gi1.a aVar = new gi1.a();
                try {
                    JSONObject jSONObject = new JSONObject(str);
                    if (jSONObject.optInt("errno") == 0) {
                        aVar.a = 0;
                        aVar.b = jSONObject.optString("msg");
                        JSONObject optJSONObject = jSONObject.optJSONObject("data");
                        aVar.c = optJSONObject.optLong("totalAmount");
                        aVar.d = optJSONObject.optLong("userPayAmount");
                        aVar.e = optJSONObject.optLong("reduceAmount");
                        aVar.g = optJSONObject.optInt("overdueStatus");
                        aVar.f = optJSONObject.optString("usedHostMarketingDetail");
                        aVar.h = gi1.a.C0317a.c(optJSONObject.optJSONArray("promotionStatus"));
                    } else {
                        aVar.a = jSONObject.optInt("errorLevel", 2);
                        aVar.b = jSONObject.optString("msg");
                    }
                } catch (Exception unused) {
                    aVar.a = 2;
                    aVar.b = bi1.a().getResources().getString(R.string.obfuscated_res_0x7f0f03be);
                }
                this.a.a(aVar);
            }
        }
    }

    public static void a(Bundle bundle, gi1 gi1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65536, null, bundle, gi1Var) == null) {
            hg1 hg1Var = new hg1();
            og1.d(hg1Var);
            String string = bundle.getString("bduss");
            bundle.remove("bduss");
            c(string, hg1Var);
            String string2 = bundle.getString("openBduss");
            bundle.remove("openBduss");
            e(string2, hg1Var);
            String string3 = bundle.getString("clientId");
            bundle.remove("clientId");
            d(string3, hg1Var);
            gg1 gg1Var = new gg1();
            gg1Var.d("appKey", bundle.get("appKey").toString());
            gg1Var.d("totalAmount", bundle.get("totalAmount").toString());
            gg1Var.d("hostMarketingDetail", bundle.get("hostMarketingDetail").toString());
            new lg1().a(pg1.b(), hg1Var, gg1Var, new b(gi1Var));
        }
    }

    public static void b(String str, String str2, String str3, List<String> list, gi1 gi1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLLL(65537, null, str, str2, str3, list, gi1Var) == null) {
            hg1 hg1Var = new hg1();
            og1.d(hg1Var);
            if (!TextUtils.isEmpty(str)) {
                hg1Var.d("Cookie", "BDUSS=" + str);
            }
            gg1 gg1Var = new gg1();
            gg1Var.d("appKey", str2);
            gg1Var.d("totalAmount", str3);
            if (list != null && list.size() > 0) {
                JSONArray jSONArray = new JSONArray();
                for (String str4 : list) {
                    if (!TextUtils.isEmpty(str4)) {
                        try {
                            jSONArray.put(new JSONObject(str4));
                        } catch (Exception unused) {
                        }
                    }
                }
                gg1Var.d("hostMarketingDetail", jSONArray.toString());
            }
            new lg1().a(pg1.b(), hg1Var, gg1Var, new a(gi1Var));
        }
    }

    public static void c(String str, hg1 hg1Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(65538, null, str, hg1Var) == null) && str != null && !TextUtils.isEmpty(str)) {
            String a2 = hg1Var.a("Cookie");
            String str2 = "BDUSS=" + str;
            if (a2 == null) {
                hg1Var.d("Cookie", str2);
                return;
            }
            hg1Var.d("Cookie", a2 + "; " + str2);
        }
    }

    public static void d(String str, hg1 hg1Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(65539, null, str, hg1Var) == null) && str != null && !TextUtils.isEmpty(str)) {
            String a2 = hg1Var.a("Cookie");
            String str2 = "CLIENTID=" + str;
            if (a2 == null) {
                hg1Var.d("Cookie", str2);
                return;
            }
            hg1Var.d("Cookie", a2 + "; " + str2);
        }
    }

    public static void e(String str, hg1 hg1Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, str, hg1Var) == null) && str != null && !TextUtils.isEmpty(str)) {
            String a2 = hg1Var.a("Cookie");
            String str2 = "OPENBDUSS=" + str;
            if (a2 == null) {
                hg1Var.d("Cookie", str2);
                return;
            }
            hg1Var.d("Cookie", a2 + "; " + str2);
        }
    }
}
