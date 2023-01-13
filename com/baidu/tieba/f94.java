package com.baidu.tieba;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mapapi.model.LatLng;
import com.baidu.tieba.s94;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class f94 extends v84<yq2> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes4.dex */
    public class a implements s94.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ yq2 a;
        public final /* synthetic */ sq2 b;

        public a(f94 f94Var, yq2 yq2Var, sq2 sq2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {f94Var, yq2Var, sq2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = yq2Var;
            this.b = sq2Var;
        }

        @Override // com.baidu.tieba.s94.b
        public void onAnimationEnd() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (!TextUtils.isEmpty(this.a.y)) {
                    this.b.c(this.a.y, null);
                }
                j12.i("map", "TranslateMarkerAction animation end");
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947718952, "Lcom/baidu/tieba/f94;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947718952, "Lcom/baidu/tieba/f94;");
                return;
            }
        }
        boolean z = tk1.a;
    }

    public f94() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public static f94 e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            return new f94();
        }
        return (f94) invokeV.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.v84
    /* renamed from: d */
    public boolean b(Context context, yq2 yq2Var, sq2 sq2Var, j43 j43Var, JSONObject jSONObject) {
        InterceptResult invokeLLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLLL = interceptable.invokeLLLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, yq2Var, sq2Var, j43Var, jSONObject)) == null) {
            return f(context, yq2Var, sq2Var, j43Var);
        }
        return invokeLLLLL.booleanValue;
    }

    public final boolean f(Context context, yq2 yq2Var, sq2 sq2Var, j43 j43Var) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(Constants.METHOD_SEND_USER_MSG, this, context, yq2Var, sq2Var, j43Var)) == null) {
            j12.i("map", "TranslateMarkerAction start");
            rq1 A = wp2.U().A(yq2Var.c);
            if (!(A instanceof pq1)) {
                j12.c("map", "WebViewManager is null");
                return false;
            }
            t94 d = s84.b().c((pq1) A).d(yq2Var.b);
            if (d == null) {
                j12.c("map", "can not find map by id " + yq2Var.b);
                return false;
            }
            return g(yq2Var, d, sq2Var);
        }
        return invokeLLLL.booleanValue;
    }

    public final boolean g(yq2 yq2Var, t94 t94Var, sq2 sq2Var) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048579, this, yq2Var, t94Var, sq2Var)) == null) {
            if (!yq2Var.isValid()) {
                return false;
            }
            cr2 cr2Var = yq2Var.A;
            LatLng latLng = new LatLng(cr2Var.a, cr2Var.b);
            List<s94> I = t94Var.I(yq2Var.z);
            j12.i("map", "TranslateMarkerAction animation start");
            if (I != null) {
                for (s94 s94Var : I) {
                    s94Var.c(t94Var, latLng, yq2Var, new a(this, yq2Var, sq2Var));
                }
            }
            j12.i("map", "TranslateMarkerAction end");
            return true;
        }
        return invokeLLL.booleanValue;
    }
}
