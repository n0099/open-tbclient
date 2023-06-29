package com.baidu.tieba;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.app.NotificationCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.nadcore.net.request.Headers;
import com.baidu.nadcore.stats.request.ClogBuilder;
import com.baidu.pyramid.annotation.Service;
import com.baidu.searchbox.download.util.MigrateStatisticUtils;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;
@Service
/* loaded from: classes5.dex */
public class ei0 extends yj0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @Override // com.baidu.tieba.yj0
    public String a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? NotificationCompat.CATEGORY_CALL : (String) invokeV.objValue;
    }

    /* loaded from: classes5.dex */
    public class a extends pt0<Map<String, String>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ad1 a;
        public final /* synthetic */ String b;
        public final /* synthetic */ Context c;
        public final /* synthetic */ String d;
        public final /* synthetic */ gk0 e;
        public final /* synthetic */ ck0 f;
        public final /* synthetic */ HashMap g;
        public final /* synthetic */ String h;
        public final /* synthetic */ ei0 i;

        public a(ei0 ei0Var, ad1 ad1Var, String str, Context context, String str2, gk0 gk0Var, ck0 ck0Var, HashMap hashMap, String str3) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ei0Var, ad1Var, str, context, str2, gk0Var, ck0Var, hashMap, str3};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.i = ei0Var;
            this.a = ad1Var;
            this.b = str;
            this.c = context;
            this.d = str2;
            this.e = gk0Var;
            this.f = ck0Var;
            this.g = hashMap;
            this.h = str3;
        }

        @Override // com.baidu.tieba.nt0
        public void a(Exception exc, int i) {
            int i2;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048576, this, exc, i) == null) {
                this.a.dismiss();
                this.i.n("4", this.b);
                boolean l = this.i.l(this.c, this.d, this.b);
                ei0 ei0Var = this.i;
                gk0 gk0Var = this.e;
                ck0 ck0Var = this.f;
                if (l) {
                    i2 = 0;
                } else {
                    i2 = 1001;
                }
                ei0Var.c(gk0Var, ck0Var, i2, l);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.ot0
        @Nullable
        /* renamed from: f */
        public Map<String, String> d(Headers headers, String str, int i) {
            InterceptResult invokeLLI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLLI = interceptable.invokeLLI(1048580, this, headers, str, i)) == null) {
                return ei0.m(str);
            }
            return (Map) invokeLLI.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.ot0
        /* renamed from: e */
        public void b(Headers headers, @Nullable Map<String, String> map, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLI(1048579, this, headers, map, i) == null) {
                this.a.dismiss();
                int i2 = 0;
                if (map == null) {
                    this.i.n("8", this.b);
                    boolean l = this.i.l(this.c, this.d, this.b);
                    ei0 ei0Var = this.i;
                    gk0 gk0Var = this.e;
                    ck0 ck0Var = this.f;
                    if (!l) {
                        i2 = 1001;
                    }
                    ei0Var.c(gk0Var, ck0Var, i2, l);
                    return;
                }
                String str = (String) d31.b(map, "virtualPhone");
                if (TextUtils.isEmpty(str)) {
                    this.i.n("5", this.b);
                    boolean l2 = this.i.l(this.c, this.d, this.b);
                    ei0 ei0Var2 = this.i;
                    gk0 gk0Var2 = this.e;
                    ck0 ck0Var2 = this.f;
                    if (!l2) {
                        i2 = 1001;
                    }
                    ei0Var2.c(gk0Var2, ck0Var2, i2, l2);
                    return;
                }
                String str2 = (String) d31.b(map, "solutionId");
                if (TextUtils.isEmpty(str2)) {
                    this.i.n("6", this.b);
                    boolean l3 = this.i.l(this.c, this.d, this.b);
                    ei0 ei0Var3 = this.i;
                    gk0 gk0Var3 = this.e;
                    ck0 ck0Var3 = this.f;
                    if (!l3) {
                        i2 = 1001;
                    }
                    ei0Var3.c(gk0Var3, ck0Var3, i2, l3);
                    return;
                }
                String str3 = (String) d31.b(this.g, "log_url");
                if (str3 == null) {
                    str3 = "";
                }
                if (TextUtils.isEmpty(str3)) {
                    this.i.n("3", this.b);
                } else {
                    this.i.n("7", this.b);
                    String replaceAll = str3.replaceAll("\\__TIMESTAMP__", this.h).replaceAll("\\__VIRTUALPHONE__", str).replaceAll("\\__SOLUTIONID__", str2);
                    wt0 wt0Var = new wt0();
                    wt0Var.l(replaceAll);
                    wt0Var.g(3000);
                    wt0Var.c();
                    dt0.b().a().a(wt0Var, null);
                }
                boolean l4 = this.i.l(this.c, str, this.b);
                ei0 ei0Var4 = this.i;
                gk0 gk0Var4 = this.e;
                ck0 ck0Var4 = this.f;
                if (!l4) {
                    i2 = 1001;
                }
                ei0Var4.c(gk0Var4, ck0Var4, i2, l4);
            }
        }
    }

    public ei0() {
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

    @Nullable
    public static Map<String, String> m(String str) {
        InterceptResult invokeL;
        JSONObject optJSONObject;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65544, null, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            HashMap hashMap = new HashMap();
            JSONArray optJSONArray = c31.c(str).optJSONArray("data");
            if (optJSONArray == null || optJSONArray.length() <= 0 || (optJSONObject = optJSONArray.optJSONObject(0)) == null) {
                return null;
            }
            hashMap.put("virtualPhone", optJSONObject.optString("virtualPhone"));
            hashMap.put("solutionId", optJSONObject.optString("solutionId"));
            return hashMap;
        }
        return (Map) invokeL.objValue;
    }

    @Override // com.baidu.tieba.yj0
    public boolean b(@NonNull Context context, @NonNull ck0 ck0Var, @Nullable Map<String, Object> map, @Nullable gk0 gk0Var) {
        InterceptResult invokeLLLL;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, ck0Var, map, gk0Var)) == null) {
            super.b(context, ck0Var, map, gk0Var);
            HashMap<String, String> d = ck0Var.d();
            String valueOf = String.valueOf(System.currentTimeMillis());
            String str2 = (String) d31.b(d, MigrateStatisticUtils.EXT_INFO);
            String str3 = (String) d31.b(d, "phone");
            int i = 0;
            if (TextUtils.isEmpty(str3)) {
                n("1", str2);
                c(gk0Var, ck0Var, 202, false);
                return true;
            }
            if (d.containsKey("type")) {
                str = (String) d31.b(d, "type");
            } else {
                str = "0";
            }
            if (TextUtils.equals(str, "1")) {
                String str4 = (String) d31.b(d, "number_url");
                if (str4 == null) {
                    str4 = "";
                }
                String str5 = str4;
                if (TextUtils.isEmpty(str5)) {
                    n("2", str2);
                    boolean l = l(context, str3, str2);
                    if (!l) {
                        i = 1001;
                    }
                    c(gk0Var, ck0Var, i, l);
                    return true;
                }
                ad1 ad1Var = new ad1(context);
                ad1Var.e(context.getString(R.string.nad_ocpc_phone_call_toast_text));
                ad1Var.c(false);
                ad1Var.d(false);
                y51.b(ad1Var);
                a aVar = new a(this, ad1Var, str2, context, str3, gk0Var, ck0Var, d, valueOf);
                String replaceAll = str5.replaceAll("\\__TIMESTAMP__", valueOf);
                wt0 wt0Var = new wt0();
                wt0Var.l(replaceAll);
                wt0Var.g(3000);
                wt0Var.c();
                dt0.b().a().a(wt0Var, aVar);
            } else {
                boolean l2 = l(context, str3, str2);
                if (!l2) {
                    i = 1001;
                }
                c(gk0Var, ck0Var, i, l2);
            }
            return true;
        }
        return invokeLLLL.booleanValue;
    }

    public final boolean l(@NonNull Context context, String str, String str2) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(Constants.METHOD_SEND_USER_MSG, this, context, str, str2)) == null) {
            if (TextUtils.isEmpty(str)) {
                return false;
            }
            if (y51.d(context, new Intent("android.intent.action.DIAL", Uri.parse("tel:" + str)))) {
                n("11", str2);
                new ve1().p(context, str2, "makePhoneCall");
                return true;
            }
            n("9", str2);
            return true;
        }
        return invokeLLL.booleanValue;
    }

    public final void n(@NonNull String str, String str2) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(1048579, this, str, str2) != null) || TextUtils.isEmpty(str2)) {
            return;
        }
        r31.b(new ClogBuilder().u(ClogBuilder.Page.AD_CALL).i(ClogBuilder.Area.AD_CALL).y(ClogBuilder.LogType.AD_CALL).k(str).p(str2));
    }
}
