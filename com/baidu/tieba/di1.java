package com.baidu.tieba;

import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.net.URLDecoder;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public final class di1 {
    public static /* synthetic */ Interceptable $ic;
    public static long c;
    public static di1 d;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean a;
    public boolean b;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1947705405, "Lcom/baidu/tieba/di1;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1947705405, "Lcom/baidu/tieba/di1;");
        }
    }

    /* loaded from: classes5.dex */
    public class a extends ch1<JSONObject> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ gj1 a;
        public final /* synthetic */ String b;
        public final /* synthetic */ di1 c;

        public a(di1 di1Var, gj1 gj1Var, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {di1Var, gj1Var, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = di1Var;
            this.a = gj1Var;
            this.b = str;
        }

        @Override // com.baidu.tieba.ch1
        public void b(Throwable th, String str) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeLL(1048576, this, th, str) != null) || this.c.b) {
                return;
            }
            long currentTimeMillis = System.currentTimeMillis();
            if (gh1.b(yi1.a()) && currentTimeMillis - di1.c <= 3000) {
                if (this.c.a) {
                    this.a.onResult(1, "");
                }
                this.c.i(this.b, this.a);
            } else {
                this.a.onResult(3, "支付失败，请重试");
            }
            this.c.a = false;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.ch1
        /* renamed from: d */
        public void c(JSONObject jSONObject) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, jSONObject) != null) || this.c.b) {
                return;
            }
            int optInt = jSONObject.optInt("status", -1);
            int optInt2 = jSONObject.optInt("payStatus", -1);
            if (optInt == 1 && optInt2 == 0) {
                this.a.onResult(3, "支付失败，请重试");
                return;
            }
            if (optInt != 2 && (optInt != 1 || optInt2 != 2)) {
                if (optInt == 1 && optInt2 == 3) {
                    this.a.onResult(3, "支付失败，请重试");
                } else if (System.currentTimeMillis() - di1.c <= 3000) {
                    if (this.c.a) {
                        this.a.onResult(1, "");
                    }
                    this.c.i(this.b, this.a);
                } else {
                    this.a.onResult(6, "支付结果查询失败，请重试");
                }
            } else {
                this.a.onResult(0, "小额免密支付成功");
            }
            this.c.a = false;
        }
    }

    public di1() {
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
        this.a = true;
        this.b = false;
    }

    public static di1 h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65543, null)) == null) {
            if (d == null) {
                synchronized (di1.class) {
                    if (d == null) {
                        d = new di1();
                    }
                }
            }
            return d;
        }
        return (di1) invokeV.objValue;
    }

    public void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.b = true;
        }
    }

    public void g(String str, gj1 gj1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, gj1Var) == null) {
            this.b = false;
            this.a = true;
            c = System.currentTimeMillis();
            i(str, gj1Var);
        }
    }

    public final void i(String str, gj1 gj1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, str, gj1Var) == null) {
            String[] split = str.split("&");
            dh1 dh1Var = new dh1();
            for (String str2 : split) {
                String[] split2 = str2.split("=");
                if (split2.length == 2) {
                    if (TextUtils.equals(split2[0], "timestamp")) {
                        dh1Var.d(split2[0], URLDecoder.decode(split2[1]));
                    } else {
                        dh1Var.d(split2[0], split2[1]);
                    }
                }
            }
            dh1Var.d("terminalData", "{\"queryOrderType\":\"AGREEMENT\",\"payChannel\":\"BAIDU-ALIPAY-WISE\"}");
            kh1.j().g(mh1.e(), dh1Var, new a(this, gj1Var, str));
        }
    }
}
