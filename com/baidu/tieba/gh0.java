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
/* loaded from: classes6.dex */
public class gh0 extends cj0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @Override // com.baidu.tieba.cj0
    public String a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? NotificationCompat.CATEGORY_CALL : (String) invokeV.objValue;
    }

    /* loaded from: classes6.dex */
    public class a extends jt0<Map<String, String>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ac1 a;
        public final /* synthetic */ String b;
        public final /* synthetic */ Context c;
        public final /* synthetic */ String d;
        public final /* synthetic */ kj0 e;
        public final /* synthetic */ gj0 f;
        public final /* synthetic */ HashMap g;
        public final /* synthetic */ String h;
        public final /* synthetic */ gh0 i;

        public a(gh0 gh0Var, ac1 ac1Var, String str, Context context, String str2, kj0 kj0Var, gj0 gj0Var, HashMap hashMap, String str3) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gh0Var, ac1Var, str, context, str2, kj0Var, gj0Var, hashMap, str3};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.i = gh0Var;
            this.a = ac1Var;
            this.b = str;
            this.c = context;
            this.d = str2;
            this.e = kj0Var;
            this.f = gj0Var;
            this.g = hashMap;
            this.h = str3;
        }

        @Override // com.baidu.tieba.ht0
        public void a(Exception exc, int i) {
            int i2;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048576, this, exc, i) == null) {
                this.a.dismiss();
                this.i.n("4", this.b);
                boolean l = this.i.l(this.c, this.d, this.b);
                gh0 gh0Var = this.i;
                kj0 kj0Var = this.e;
                gj0 gj0Var = this.f;
                if (l) {
                    i2 = 0;
                } else {
                    i2 = 1001;
                }
                gh0Var.c(kj0Var, gj0Var, i2, l);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.it0
        @Nullable
        /* renamed from: f */
        public Map<String, String> d(Headers headers, String str, int i) {
            InterceptResult invokeLLI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLLI = interceptable.invokeLLI(1048580, this, headers, str, i)) == null) {
                return gh0.m(str);
            }
            return (Map) invokeLLI.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.it0
        /* renamed from: e */
        public void b(Headers headers, @Nullable Map<String, String> map, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLI(1048579, this, headers, map, i) == null) {
                this.a.dismiss();
                int i2 = 0;
                if (map == null) {
                    this.i.n("8", this.b);
                    boolean l = this.i.l(this.c, this.d, this.b);
                    gh0 gh0Var = this.i;
                    kj0 kj0Var = this.e;
                    gj0 gj0Var = this.f;
                    if (!l) {
                        i2 = 1001;
                    }
                    gh0Var.c(kj0Var, gj0Var, i2, l);
                    return;
                }
                String str = (String) f31.b(map, "virtualPhone");
                if (TextUtils.isEmpty(str)) {
                    this.i.n("5", this.b);
                    boolean l2 = this.i.l(this.c, this.d, this.b);
                    gh0 gh0Var2 = this.i;
                    kj0 kj0Var2 = this.e;
                    gj0 gj0Var2 = this.f;
                    if (!l2) {
                        i2 = 1001;
                    }
                    gh0Var2.c(kj0Var2, gj0Var2, i2, l2);
                    return;
                }
                String str2 = (String) f31.b(map, "solutionId");
                if (TextUtils.isEmpty(str2)) {
                    this.i.n("6", this.b);
                    boolean l3 = this.i.l(this.c, this.d, this.b);
                    gh0 gh0Var3 = this.i;
                    kj0 kj0Var3 = this.e;
                    gj0 gj0Var3 = this.f;
                    if (!l3) {
                        i2 = 1001;
                    }
                    gh0Var3.c(kj0Var3, gj0Var3, i2, l3);
                    return;
                }
                String str3 = (String) f31.b(this.g, "log_url");
                if (str3 == null) {
                    str3 = "";
                }
                if (TextUtils.isEmpty(str3)) {
                    this.i.n("3", this.b);
                } else {
                    this.i.n("7", this.b);
                    String replaceAll = str3.replaceAll("\\__TIMESTAMP__", this.h).replaceAll("\\__VIRTUALPHONE__", str).replaceAll("\\__SOLUTIONID__", str2);
                    qt0 qt0Var = new qt0();
                    qt0Var.l(replaceAll);
                    qt0Var.g(3000);
                    qt0Var.c();
                    xs0.b().a().a(qt0Var, null);
                }
                boolean l4 = this.i.l(this.c, str, this.b);
                gh0 gh0Var4 = this.i;
                kj0 kj0Var4 = this.e;
                gj0 gj0Var4 = this.f;
                if (!l4) {
                    i2 = 1001;
                }
                gh0Var4.c(kj0Var4, gj0Var4, i2, l4);
            }
        }
    }

    public gh0() {
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
            JSONArray optJSONArray = e31.c(str).optJSONArray("data");
            if (optJSONArray == null || optJSONArray.length() <= 0 || (optJSONObject = optJSONArray.optJSONObject(0)) == null) {
                return null;
            }
            hashMap.put("virtualPhone", optJSONObject.optString("virtualPhone"));
            hashMap.put("solutionId", optJSONObject.optString("solutionId"));
            return hashMap;
        }
        return (Map) invokeL.objValue;
    }

    @Override // com.baidu.tieba.cj0
    public boolean b(@NonNull Context context, @NonNull gj0 gj0Var, @Nullable Map<String, Object> map, @Nullable kj0 kj0Var) {
        InterceptResult invokeLLLL;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, gj0Var, map, kj0Var)) == null) {
            super.b(context, gj0Var, map, kj0Var);
            HashMap<String, String> d = gj0Var.d();
            String valueOf = String.valueOf(System.currentTimeMillis());
            String str2 = (String) f31.b(d, MigrateStatisticUtils.EXT_INFO);
            String str3 = (String) f31.b(d, "phone");
            int i = 0;
            if (TextUtils.isEmpty(str3)) {
                n("1", str2);
                c(kj0Var, gj0Var, 202, false);
                return true;
            }
            if (d.containsKey("type")) {
                str = (String) f31.b(d, "type");
            } else {
                str = "0";
            }
            if (TextUtils.equals(str, "1")) {
                String str4 = (String) f31.b(d, "number_url");
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
                    c(kj0Var, gj0Var, i, l);
                    return true;
                }
                ac1 ac1Var = new ac1(context);
                ac1Var.e(context.getString(R.string.nad_ocpc_phone_call_toast_text));
                ac1Var.c(false);
                ac1Var.d(false);
                e61.b(ac1Var);
                a aVar = new a(this, ac1Var, str2, context, str3, kj0Var, gj0Var, d, valueOf);
                String replaceAll = str5.replaceAll("\\__TIMESTAMP__", valueOf);
                qt0 qt0Var = new qt0();
                qt0Var.l(replaceAll);
                qt0Var.g(3000);
                qt0Var.c();
                xs0.b().a().a(qt0Var, aVar);
            } else {
                boolean l2 = l(context, str3, str2);
                if (!l2) {
                    i = 1001;
                }
                c(kj0Var, gj0Var, i, l2);
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
            if (e61.d(context, new Intent("android.intent.action.DIAL", Uri.parse("tel:" + str)))) {
                n("11", str2);
                new wd1().p(context, str2, "makePhoneCall");
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
        t31.e(new ClogBuilder().u(ClogBuilder.Page.AD_CALL).i(ClogBuilder.Area.AD_CALL).y(ClogBuilder.LogType.AD_CALL).k(str).p(str2));
    }
}
