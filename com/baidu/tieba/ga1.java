package com.baidu.tieba;

import android.content.Context;
import android.content.Intent;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.nadcore.webviewx.AdWebActivity;
import com.baidu.nadcore.webviewx.AdWebActivityStandard;
import com.baidu.pyramid.annotation.Service;
import com.baidu.tieba.sa1;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
import java.util.Map;
@Service
/* loaded from: classes4.dex */
public class ga1 extends xi0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @Override // com.baidu.tieba.xi0
    public String a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? "easybrowse" : (String) invokeV.objValue;
    }

    /* loaded from: classes4.dex */
    public class a implements sa1.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Context a;
        public final /* synthetic */ HashMap b;
        public final /* synthetic */ fj0 c;
        public final /* synthetic */ bj0 d;
        public final /* synthetic */ ga1 e;

        public a(ga1 ga1Var, Context context, HashMap hashMap, fj0 fj0Var, bj0 bj0Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ga1Var, context, hashMap, fj0Var, bj0Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.e = ga1Var;
            this.a = context;
            this.b = hashMap;
            this.c = fj0Var;
            this.d = bj0Var;
        }

        @Override // com.baidu.tieba.sa1.b
        public void a() {
            int i;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                boolean g = ga1.g(this.a, this.b);
                ga1 ga1Var = this.e;
                fj0 fj0Var = this.c;
                bj0 bj0Var = this.d;
                if (g) {
                    i = 0;
                } else {
                    i = 1001;
                }
                ga1Var.c(fj0Var, bj0Var, i, g);
            }
        }
    }

    public ga1() {
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

    public static boolean g(Context context, @NonNull HashMap<String, String> hashMap) {
        InterceptResult invokeLL;
        Class cls;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65539, null, context, hashMap)) == null) {
            if (yg0.a) {
                g41.a().showToast(context, "启动SDK Webview");
            }
            if (!da1.a.a(hashMap, 0)) {
                return false;
            }
            if ("1".equals(hashMap.remove("newbrowser"))) {
                cls = AdWebActivityStandard.class;
            } else {
                cls = AdWebActivity.class;
            }
            Intent intent = new Intent(context, cls);
            intent.putExtra("map", hashMap);
            return u41.d(context, intent);
        }
        return invokeLL.booleanValue;
    }

    @Override // com.baidu.tieba.xi0
    public boolean b(@NonNull Context context, @NonNull bj0 bj0Var, @Nullable Map<String, Object> map, @Nullable fj0 fj0Var) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, bj0Var, map, fj0Var)) == null) {
            super.b(context, bj0Var, map, fj0Var);
            HashMap<String, String> d = bj0Var.d();
            int b = ha1.b(context.getApplicationContext(), new a(this, context, d, fj0Var, bj0Var));
            int i = 0;
            if (4 != b && b != 0) {
                if (2 != b && 1 != b) {
                    boolean g = g(context, d);
                    if (!g) {
                        i = 1001;
                    }
                    c(fj0Var, bj0Var, i, g);
                }
                return true;
            }
            c(fj0Var, bj0Var, 1001, false);
            if (!yg0.a) {
                return true;
            }
            throw new IllegalStateException("web app init failed, state=" + b);
        }
        return invokeLLLL.booleanValue;
    }
}
