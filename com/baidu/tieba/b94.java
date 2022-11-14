package com.baidu.tieba;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mapapi.model.LatLng;
import com.baidu.tieba.o94;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class b94 extends r84<uq2> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes3.dex */
    public class a implements o94.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ uq2 a;
        public final /* synthetic */ oq2 b;

        public a(b94 b94Var, uq2 uq2Var, oq2 oq2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {b94Var, uq2Var, oq2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = uq2Var;
            this.b = oq2Var;
        }

        @Override // com.baidu.tieba.o94.b
        public void onAnimationEnd() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (!TextUtils.isEmpty(this.a.y)) {
                    this.b.c(this.a.y, null);
                }
                f12.i("map", "TranslateMarkerAction animation end");
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947599788, "Lcom/baidu/tieba/b94;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947599788, "Lcom/baidu/tieba/b94;");
                return;
            }
        }
        boolean z = pk1.a;
    }

    public b94() {
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

    public static b94 e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            return new b94();
        }
        return (b94) invokeV.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.r84
    /* renamed from: d */
    public boolean b(Context context, uq2 uq2Var, oq2 oq2Var, f43 f43Var, JSONObject jSONObject) {
        InterceptResult invokeLLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLLL = interceptable.invokeLLLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, uq2Var, oq2Var, f43Var, jSONObject)) == null) {
            return f(context, uq2Var, oq2Var, f43Var);
        }
        return invokeLLLLL.booleanValue;
    }

    public final boolean f(Context context, uq2 uq2Var, oq2 oq2Var, f43 f43Var) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(Constants.METHOD_SEND_USER_MSG, this, context, uq2Var, oq2Var, f43Var)) == null) {
            f12.i("map", "TranslateMarkerAction start");
            nq1 A = sp2.U().A(uq2Var.c);
            if (!(A instanceof lq1)) {
                f12.c("map", "WebViewManager is null");
                return false;
            }
            p94 d = o84.b().c((lq1) A).d(uq2Var.b);
            if (d == null) {
                f12.c("map", "can not find map by id " + uq2Var.b);
                return false;
            }
            return g(uq2Var, d, oq2Var);
        }
        return invokeLLLL.booleanValue;
    }

    public final boolean g(uq2 uq2Var, p94 p94Var, oq2 oq2Var) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048579, this, uq2Var, p94Var, oq2Var)) == null) {
            if (!uq2Var.isValid()) {
                return false;
            }
            yq2 yq2Var = uq2Var.A;
            LatLng latLng = new LatLng(yq2Var.a, yq2Var.b);
            List<o94> I = p94Var.I(uq2Var.z);
            f12.i("map", "TranslateMarkerAction animation start");
            if (I != null) {
                for (o94 o94Var : I) {
                    o94Var.c(p94Var, latLng, uq2Var, new a(this, uq2Var, oq2Var));
                }
            }
            f12.i("map", "TranslateMarkerAction end");
            return true;
        }
        return invokeLLL.booleanValue;
    }
}
