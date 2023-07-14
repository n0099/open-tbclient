package com.baidu.tieba;

import android.text.TextUtils;
import android.util.Log;
import androidx.core.view.InputDeviceCompat;
import androidx.transition.Transition;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.payment.PaymentManager;
import com.baidu.pyramid.annotation.Service;
import com.baidu.pyramid.annotation.Singleton;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.tieba.sw2;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
import org.json.JSONException;
import org.json.JSONObject;
@Singleton
@Service
/* loaded from: classes5.dex */
public class fu3 implements fx1 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean b;
    public transient /* synthetic */ FieldHolder $fh;
    public PaymentManager a;

    /* loaded from: classes5.dex */
    public class a extends fi1 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ long a;

        public a(fu3 fu3Var, long j) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fu3Var, Long.valueOf(j)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = j;
        }

        @Override // com.baidu.tieba.fi1
        public void a(int i, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(1048576, this, i, str) == null) {
                if (fu3.b) {
                    Log.d("RebateInfoManager", "requestBatchRebateInfo onResult: " + i + " " + str);
                }
                zr4.j(fu3.d());
                zr4.N(String.valueOf(this.a), fu3.d());
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b extends fi1 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public b(fu3 fu3Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fu3Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // com.baidu.tieba.fi1
        public void a(int i, String str) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeIL(1048576, this, i, str) == null) && fu3.b) {
                Log.d("RebateInfoManager", "requestSingleRebateInfo onResult: " + i + " " + str);
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947776581, "Lcom/baidu/tieba/fu3;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947776581, "Lcom/baidu/tieba/fu3;");
                return;
            }
        }
        b = fs1.a;
    }

    public fu3() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.a = new PaymentManager();
    }

    public static /* synthetic */ File d() {
        return e();
    }

    public static File e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) {
            return new File(AppRuntime.getAppContext().getFilesDir().getPath(), "rebate_info_timestamp");
        }
        return (File) invokeV.objValue;
    }

    @Override // com.baidu.tieba.fx1
    public boolean a(String str, String str2, String str3) {
        InterceptResult invokeLLL;
        vb3 b0;
        sw2.a W;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048576, this, str, str2, str3)) == null) {
            if (!dg3.l() || (b0 = vb3.b0()) == null || (W = b0.W()) == null) {
                return false;
            }
            f(str, br4.g().u(AppRuntime.getAppContext()), cv2.h0().i(cv2.c()), wr3.i(b0.getApplicationContext()), str2, str3, cv2.n().a(), W.T());
            return true;
        }
        return invokeLLL.booleanValue;
    }

    @Override // com.baidu.tieba.fx1
    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            String E = zr4.E(e());
            long currentTimeMillis = System.currentTimeMillis() / 1000;
            if (!TextUtils.isEmpty(E)) {
                try {
                    if (currentTimeMillis - Long.parseLong(E) < 86400) {
                        if (b) {
                            Log.d("RebateInfoManager", "requestBatchRebateInfo: 相邻请求时间需要大于一天");
                            return;
                        }
                        return;
                    }
                } catch (NumberFormatException e) {
                    if (b) {
                        e.printStackTrace();
                        return;
                    }
                    return;
                }
            }
            this.a.p(new a(this, currentTimeMillis));
        }
    }

    public final void f(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{str, str2, str3, str4, str5, str6, str7, str8}) == null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("masterId", str);
                if (!TextUtils.isEmpty(str2)) {
                    jSONObject.put("userPassId", str2);
                }
                jSONObject.put("cuid", str3);
                jSONObject.put("bduss", str4);
                jSONObject.put(Transition.MATCH_ITEM_ID_STR, str5);
                jSONObject.put("businessId", str6);
                jSONObject.put("naid", str7);
                jSONObject.put("scene", str8);
                this.a.o(jSONObject, new b(this));
            } catch (JSONException e) {
                if (b) {
                    e.printStackTrace();
                }
            }
        }
    }
}
