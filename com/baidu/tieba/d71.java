package com.baidu.tieba;

import android.content.Context;
import android.content.Intent;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.nadcore.webview.activity.NadWebViewActivity;
import com.baidu.nadcore.webview.activity.NadWebViewActivityStandard;
import com.baidu.pyramid.annotation.Service;
import com.baidu.tieba.i81;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
@Service
/* loaded from: classes4.dex */
public final class d71 extends th0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final String a;

    @Override // com.baidu.tieba.th0
    public String a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? "easybrowse" : (String) invokeV.objValue;
    }

    @Override // com.baidu.tieba.th0
    public String b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? "interceptorEasybrowse" : (String) invokeV.objValue;
    }

    /* loaded from: classes4.dex */
    public static final class a implements i81.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ d71 a;
        public final /* synthetic */ Context b;
        public final /* synthetic */ HashMap c;
        public final /* synthetic */ zh0 d;
        public final /* synthetic */ vh0 e;

        public a(d71 d71Var, Context context, HashMap hashMap, zh0 zh0Var, vh0 vh0Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {d71Var, context, hashMap, zh0Var, vh0Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = d71Var;
            this.b = context;
            this.c = hashMap;
            this.d = zh0Var;
            this.e = vh0Var;
        }

        @Override // com.baidu.tieba.i81.b
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                int i = 0;
                boolean i2 = this.a.i(this.b, this.c, false);
                String str = this.a.a;
                n81.a(str, "调起SDK落地页, 结果 " + i2);
                d71 d71Var = this.a;
                zh0 zh0Var = this.d;
                vh0 vh0Var = this.e;
                if (!i2) {
                    i = 1001;
                }
                d71Var.c(zh0Var, vh0Var, i, i2);
            }
        }

        @Override // com.baidu.tieba.i81.b
        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                n81.c(this.b, "初始化失败，降级为原生打开");
            }
        }
    }

    public d71() {
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
        this.a = "EasyBrowseInterceptor";
    }

    public final boolean j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            if (bm0.b().a().a("use_nairobi", 0) != 1) {
                return false;
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.th0
    public boolean d(Context context, vh0 schemeModel, Map<String, Object> map, zh0 zh0Var) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(Constants.METHOD_SEND_USER_MSG, this, context, schemeModel, map, zh0Var)) == null) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(schemeModel, "schemeModel");
            int i = 0;
            if (!j()) {
                n81.c(context, "未命中新架构");
                return false;
            }
            HashMap<String, String> d = schemeModel.d();
            Intrinsics.checkNotNullExpressionValue(d, "schemeModel.params");
            l11.b((String) w01.b(d, "charge_url"));
            int b = e71.b(context.getApplicationContext(), new a(this, context, d, zh0Var, schemeModel));
            if (b == 0) {
                c(zh0Var, schemeModel, 1001, false);
                n81.d(new IllegalStateException("web app init failed, state=" + b));
                return false;
            } else if (2 != b && 1 != b) {
                if (4 == b) {
                    n81.c(context, "初始化失败，降级为原生打开");
                    h(context, schemeModel, zh0Var);
                    return true;
                } else if (5 == b) {
                    n81.c(context, "低版本不支持t7，降级为原生打开");
                    h(context, schemeModel, zh0Var);
                    return true;
                } else {
                    boolean i2 = i(context, d, false);
                    String str = this.a;
                    n81.a(str, "调起SDK落地页, 结果 " + i2);
                    if (!i2) {
                        i = 1001;
                    }
                    c(zh0Var, schemeModel, i, i2);
                    return true;
                }
            } else {
                n81.c(context, "正在初始化，降级为原生打开");
                h(context, schemeModel, zh0Var);
                return true;
            }
        }
        return invokeLLLL.booleanValue;
    }

    public final void h(Context context, vh0 vh0Var, zh0 zh0Var) {
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048579, this, context, vh0Var, zh0Var) == null) {
            HashMap<String, String> d = vh0Var.d();
            Intrinsics.checkNotNullExpressionValue(d, "schemeModel.params");
            d.put("downgrade_to_native", "1");
            boolean i2 = i(context, vh0Var.d(), true);
            if (i2) {
                i = 0;
            } else {
                i = 1001;
            }
            c(zh0Var, vh0Var, i, i2);
        }
    }

    public final boolean i(Context context, HashMap<String, String> hashMap, boolean z) {
        InterceptResult invokeLLZ;
        String str;
        Class cls;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLZ = interceptable.invokeLLZ(1048580, this, context, hashMap, z)) == null) {
            if (!z && !a71.a().a(hashMap, a71.b())) {
                n81.a(this.a, "调起SDK落地页, Activity 调起失败, 内核未成功初始化");
                return false;
            }
            if (hashMap != null) {
                str = hashMap.remove("newbrowser");
            } else {
                str = null;
            }
            if (Intrinsics.areEqual("1", str)) {
                cls = NadWebViewActivityStandard.class;
            } else {
                cls = NadWebViewActivity.class;
            }
            Intent intent = new Intent(context, cls);
            intent.putExtra("map", hashMap);
            return r31.d(context, intent);
        }
        return invokeLLZ.booleanValue;
    }
}
