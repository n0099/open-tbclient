package com.baidu.tieba;

import android.os.Bundle;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.poly.statistics.exception.ServerDataException;
import com.baidu.poly.widget.PayChannelEntity;
import com.baidu.searchbox.retrieve.inter.constants.StatConstants;
import com.baidu.tbadk.core.util.TbEnum;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class ab1 {
    public static /* synthetic */ Interceptable $ic = null;
    public static String b = "payChannel";
    public static String c = "installmentPeriod";
    public static String d = "payType";
    public static volatile ab1 e;
    public transient /* synthetic */ FieldHolder $fh;
    public xa1 a;

    /* loaded from: classes3.dex */
    public class a extends sa1<String> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ sa1 a;
        public final /* synthetic */ ab1 b;

        public a(ab1 ab1Var, sa1 sa1Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ab1Var, sa1Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = ab1Var;
            this.a = sa1Var;
        }

        @Override // com.baidu.tieba.sa1
        public void a(Throwable th, int i, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(1048576, this, th, i, str) == null) {
                this.b.w("7", 119501, "cashier/channelAllInfo", i);
                this.a.b(th, str);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.sa1
        /* renamed from: d */
        public void c(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) {
                try {
                    JSONObject jSONObject = new JSONObject(str);
                    int optInt = jSONObject.optInt(StatConstants.KEY_EXT_ERR_CODE, -1);
                    int optInt2 = jSONObject.optInt("errno", -1);
                    JSONObject optJSONObject = jSONObject.optJSONObject("data");
                    if (optJSONObject == null || optInt != 0 || optInt2 != 0) {
                        this.b.w("7", 119503, "cashier/channelAllInfo", optInt2);
                        String optString = jSONObject.optString("errmsg");
                        sa1 sa1Var = this.a;
                        ServerDataException serverDataException = new ServerDataException("errmsg = " + optString);
                        sa1Var.b(serverDataException, "errno is " + optInt2);
                        return;
                    }
                    this.a.c(optJSONObject);
                } catch (JSONException unused) {
                    this.b.w("7", 119502, "cashier/channelAllInfo", -1);
                    this.a.b(new ServerDataException("服务异常，请稍后重试"), "服务异常，请稍后重试");
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b extends sa1<String> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ sa1 b;
        public final /* synthetic */ ab1 c;

        public b(ab1 ab1Var, String str, sa1 sa1Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ab1Var, str, sa1Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = ab1Var;
            this.a = str;
            this.b = sa1Var;
        }

        @Override // com.baidu.tieba.sa1
        public void a(Throwable th, int i, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(1048576, this, th, i, str) == null) {
                this.c.x("8", 119501, "cashier/launchpayment", i, this.a);
                this.b.b(th, oc1.a().getResources().getString(R.string.obfuscated_res_0x7f0f041a));
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.sa1
        /* renamed from: d */
        public void c(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) {
                try {
                    JSONObject jSONObject = new JSONObject(str);
                    int optInt = jSONObject.optInt("errno", -1);
                    if (optInt != 0) {
                        this.c.x("8", 119503, "cashier/launchpayment", optInt, this.a);
                        String optString = jSONObject.optString("msg");
                        sa1 sa1Var = this.b;
                        sa1Var.b(new ServerDataException("msg = " + optString), optString);
                        return;
                    }
                    this.b.c(this.c.y(jSONObject.optJSONObject("data")));
                } catch (JSONException unused) {
                    this.c.x("8", 119502, "cashier/launchpayment", -1, this.a);
                    this.b.b(new ServerDataException("服务异常，请稍后重试"), "服务异常，请稍后重试");
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public class c extends sa1<String> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ sa1 a;
        public final /* synthetic */ ab1 b;

        public c(ab1 ab1Var, sa1 sa1Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ab1Var, sa1Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = ab1Var;
            this.a = sa1Var;
        }

        @Override // com.baidu.tieba.sa1
        public void a(Throwable th, int i, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(1048576, this, th, i, str) == null) {
                this.b.w("8", 119501, "cashier/pay", i);
                this.a.b(th, str);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.sa1
        /* renamed from: d */
        public void c(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) {
                try {
                    JSONObject jSONObject = new JSONObject(str);
                    int optInt = jSONObject.optInt("errno", -1);
                    if (optInt != 0) {
                        this.b.w("8", 119503, "cashier/pay", optInt);
                        String optString = jSONObject.optString("msg");
                        sa1 sa1Var = this.a;
                        sa1Var.b(new ServerDataException("msg = " + optString), optString);
                        return;
                    }
                    this.a.c(this.b.y(jSONObject.optJSONObject("data")));
                } catch (Throwable unused) {
                    this.b.w("8", 119502, "cashier/pay", -1);
                    this.a.b(new ServerDataException("服务异常，请稍后重试"), "服务异常，请稍后重试");
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public class d extends sa1<String> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ sa1 a;
        public final /* synthetic */ ab1 b;

        public d(ab1 ab1Var, sa1 sa1Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ab1Var, sa1Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = ab1Var;
            this.a = sa1Var;
        }

        @Override // com.baidu.tieba.sa1
        public void a(Throwable th, int i, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(1048576, this, th, i, str) == null) {
                this.b.w(TbEnum.SystemMessage.EVENT_ID_GROUP_JOIN, 119501, "cashier/sdkAdaptH5QueryPay", i);
                this.a.b(th, str);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.sa1
        /* renamed from: d */
        public void c(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) {
                try {
                    JSONObject jSONObject = new JSONObject(str);
                    int optInt = jSONObject.optInt("errno", -1);
                    if (optInt != 0) {
                        this.b.w(TbEnum.SystemMessage.EVENT_ID_GROUP_JOIN, 119503, "cashier/sdkAdaptH5QueryPay", optInt);
                        String optString = jSONObject.optString("msg");
                        sa1 sa1Var = this.a;
                        ServerDataException serverDataException = new ServerDataException("msg = " + optString);
                        sa1Var.b(serverDataException, "errno is " + optInt);
                        return;
                    }
                    this.a.c(jSONObject.optJSONObject("data"));
                } catch (Throwable unused) {
                    this.b.w(TbEnum.SystemMessage.EVENT_ID_GROUP_JOIN, 119502, "cashier/sdkAdaptH5QueryPay", -1);
                    this.a.b(new ServerDataException("服务异常，请稍后重试"), "服务异常，请稍后重试");
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public class e extends sa1<String> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ sa1 a;

        public e(ab1 ab1Var, sa1 sa1Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ab1Var, sa1Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = sa1Var;
        }

        @Override // com.baidu.tieba.sa1
        public void a(Throwable th, int i, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(1048576, this, th, i, str) == null) {
                this.a.b(th, str);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.sa1
        /* renamed from: d */
        public void c(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) {
                try {
                    JSONObject jSONObject = new JSONObject(str);
                    int optInt = jSONObject.optInt("errno", -1);
                    if (optInt == 0) {
                        this.a.c(jSONObject.optJSONObject("data"));
                        return;
                    }
                    String optString = jSONObject.optString("msg");
                    sa1 sa1Var = this.a;
                    ServerDataException serverDataException = new ServerDataException("msg=" + optString);
                    sa1Var.b(serverDataException, "code=" + optInt);
                } catch (Throwable th) {
                    kc1.d(th.getMessage());
                    this.a.b(new ServerDataException("服务异常，请稍后重试"), "服务异常，请稍后重试");
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public class f extends sa1<String> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ sa1 a;

        public f(ab1 ab1Var, sa1 sa1Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ab1Var, sa1Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = sa1Var;
        }

        @Override // com.baidu.tieba.sa1
        public void a(Throwable th, int i, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(1048576, this, th, i, str) == null) {
                this.a.b(th, str);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.sa1
        /* renamed from: d */
        public void c(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) {
                try {
                    JSONObject jSONObject = new JSONObject(str);
                    int optInt = jSONObject.optInt("errno", -1);
                    if (optInt == 0) {
                        this.a.c(jSONObject.optJSONObject("data"));
                        return;
                    }
                    String optString = jSONObject.optString("msg");
                    sa1 sa1Var = this.a;
                    ServerDataException serverDataException = new ServerDataException("msg=" + optString);
                    sa1Var.b(serverDataException, "code=" + optInt);
                } catch (Throwable th) {
                    kc1.d(th.getMessage());
                    this.a.b(new ServerDataException("服务异常，请稍后重试"), "服务异常，请稍后重试");
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public class g extends sa1<String> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ sa1 a;

        public g(ab1 ab1Var, sa1 sa1Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ab1Var, sa1Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = sa1Var;
        }

        @Override // com.baidu.tieba.sa1
        public void a(Throwable th, int i, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(1048576, this, th, i, str) == null) {
                this.a.b(th, str);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.sa1
        /* renamed from: d */
        public void c(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) {
                try {
                    JSONObject jSONObject = new JSONObject(str);
                    int optInt = jSONObject.optInt("errno", -1);
                    if (optInt == 0) {
                        this.a.c(jSONObject.optJSONObject("data"));
                        return;
                    }
                    String optString = jSONObject.optString("msg");
                    sa1 sa1Var = this.a;
                    ServerDataException serverDataException = new ServerDataException("msg=" + optString);
                    sa1Var.b(serverDataException, "code=" + optInt);
                } catch (Throwable th) {
                    kc1.d(th.getMessage());
                    this.a.b(new ServerDataException("服务异常，请稍后重试"), "服务异常，请稍后重试");
                }
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1947609305, "Lcom/baidu/tieba/ab1;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1947609305, "Lcom/baidu/tieba/ab1;");
        }
    }

    public ab1(xa1 xa1Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {xa1Var};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.a = xa1Var;
    }

    public static ab1 j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65541, null)) == null) {
            if (e == null) {
                synchronized (ab1.class) {
                    if (e == null) {
                        e = new ab1(new ya1());
                    }
                }
            }
            return e;
        }
        return (ab1) invokeV.objValue;
    }

    public ta1 d(Bundle bundle, ua1 ua1Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, bundle, ua1Var)) == null) {
            ta1 ta1Var = new ta1();
            t(ta1Var, bundle);
            ta1Var.d(d, "android");
            n(bundle, ta1Var, ua1Var);
            return ta1Var;
        }
        return (ta1) invokeLL.objValue;
    }

    public void e(Bundle bundle, sa1<JSONObject> sa1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bundle, sa1Var) == null) {
            f(bundle, false, sa1Var);
        }
    }

    public void f(Bundle bundle, boolean z, sa1<JSONObject> sa1Var) {
        String c2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{bundle, Boolean.valueOf(z), sa1Var}) == null) {
            ua1 h = h();
            Set<String> keySet = bundle.keySet();
            ta1 ta1Var = new ta1();
            for (String str : keySet) {
                if ((bundle.get(str) instanceof String) && (!z || !"bduss".equals(str))) {
                    ta1Var.d(str, bundle.get(str).toString());
                }
            }
            n(bundle, ta1Var, h);
            r(bundle, ta1Var, h);
            p(bundle, ta1Var, h);
            if (z) {
                c2 = cb1.d();
            } else {
                c2 = cb1.c();
            }
            xb1.a("1.02", System.currentTimeMillis());
            this.a.a(c2, h, ta1Var, new a(this, sa1Var));
        }
    }

    public void g(String str, ta1 ta1Var, sa1<JSONObject> sa1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048579, this, str, ta1Var, sa1Var) == null) {
            this.a.a(str, h(), ta1Var, new g(this, sa1Var));
        }
    }

    public final ua1 h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            ua1 ua1Var = new ua1();
            bb1.d(ua1Var);
            return ua1Var;
        }
        return (ua1) invokeV.objValue;
    }

    public final ua1 i(ua1 ua1Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, ua1Var)) == null) {
            if (ua1Var == null) {
                ua1Var = new ua1();
            }
            bb1.d(ua1Var);
            return ua1Var;
        }
        return (ua1) invokeL.objValue;
    }

    public void k(String str, String str2, String str3, sa1<JSONObject> sa1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048582, this, str, str2, str3, sa1Var) == null) {
            ua1 h = h();
            o(str, h);
            ta1 ta1Var = new ta1();
            ta1Var.d("bduss", str);
            ta1Var.d("payChannel", str2);
            ta1Var.d("appKey", str3);
            this.a.a(cb1.i(), h, ta1Var, new e(this, sa1Var));
        }
    }

    public void l(String str, String str2, String str3, sa1<JSONObject> sa1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048583, this, str, str2, str3, sa1Var) == null) {
            ua1 h = h();
            o(str, h);
            ta1 ta1Var = new ta1();
            ta1Var.d("appKey", str3);
            ta1Var.d("bduss", str);
            ta1Var.d("payChannel", str2);
            ta1Var.d("sign", rb1.c("appKey=" + str3 + "&bduss=" + str + "&payChannel=" + str2 + "&lLoIsWxrSeJmHQD2TVQQ"));
            this.a.a(cb1.k(), h, ta1Var, new f(this, sa1Var));
        }
    }

    public void m(Bundle bundle, sa1<JSONObject> sa1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, bundle, sa1Var) == null) {
            ua1 h = h();
            Set<String> keySet = bundle.keySet();
            ta1 ta1Var = new ta1();
            for (String str : keySet) {
                if (bundle.get(str) instanceof String) {
                    ta1Var.d(str, bundle.get(str).toString());
                }
            }
            this.a.a(cb1.m(), h, ta1Var, new d(this, sa1Var));
        }
    }

    public final void n(Bundle bundle, ta1 ta1Var, ua1 ua1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048585, this, bundle, ta1Var, ua1Var) == null) {
            String string = bundle.getString("bduss");
            if (TextUtils.isEmpty(string)) {
                return;
            }
            o(string, ua1Var);
        }
    }

    public final void o(String str, ua1 ua1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048586, this, str, ua1Var) == null) {
            String a2 = ua1Var.a("Cookie");
            String str2 = "BDUSS=" + str;
            if (a2 == null) {
                ua1Var.d("Cookie", str2);
                return;
            }
            ua1Var.d("Cookie", a2 + "; " + str2);
        }
    }

    public final void p(Bundle bundle, ta1 ta1Var, ua1 ua1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048587, this, bundle, ta1Var, ua1Var) == null) {
            String string = bundle.getString("clientId");
            if (TextUtils.isEmpty(string)) {
                return;
            }
            q(string, ua1Var);
        }
    }

    public final void q(String str, ua1 ua1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048588, this, str, ua1Var) == null) {
            String a2 = ua1Var.a("Cookie");
            String str2 = "CLIENTID=" + str;
            if (a2 == null) {
                ua1Var.d("Cookie", str2);
                return;
            }
            ua1Var.d("Cookie", a2 + "; " + str2);
        }
    }

    public final void r(Bundle bundle, ta1 ta1Var, ua1 ua1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048589, this, bundle, ta1Var, ua1Var) == null) {
            String string = bundle.getString("openBduss");
            if (TextUtils.isEmpty(string)) {
                return;
            }
            s(string, ua1Var);
        }
    }

    public final void s(String str, ua1 ua1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048590, this, str, ua1Var) == null) {
            String a2 = ua1Var.a("Cookie");
            String str2 = "OPENBDUSS=" + str;
            if (a2 == null) {
                ua1Var.d("Cookie", str2);
                return;
            }
            ua1Var.d("Cookie", a2 + "; " + str2);
        }
    }

    public final void t(ta1 ta1Var, Bundle bundle) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048591, this, ta1Var, bundle) == null) || bundle == null || ta1Var == null) {
            return;
        }
        for (String str : bundle.keySet()) {
            ta1Var.d(str, bundle.getString(str));
        }
        Iterator<Map.Entry<String, String>> it = ta1Var.b().entrySet().iterator();
        while (it.hasNext()) {
            if (TextUtils.isEmpty(it.next().getValue())) {
                it.remove();
            }
        }
    }

    public void u(Bundle bundle, sa1<Map<String, String>> sa1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048592, this, bundle, sa1Var) == null) {
            ua1 h = h();
            ta1 d2 = d(bundle, h);
            this.a.a(cb1.l(), h, d2, new c(this, sa1Var));
        }
    }

    public void v(ua1 ua1Var, Bundle bundle, sa1<Map<String, String>> sa1Var, PayChannelEntity payChannelEntity, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLLL(1048593, this, ua1Var, bundle, sa1Var, payChannelEntity, str) == null) {
            ua1 i = i(ua1Var);
            Set<String> keySet = bundle.keySet();
            ta1 ta1Var = new ta1();
            for (String str2 : keySet) {
                if (bundle.get(str2) instanceof String) {
                    ta1Var.d(str2, bundle.get(str2).toString());
                }
            }
            if (payChannelEntity == null) {
                return;
            }
            String payChannel = payChannelEntity.getPayChannel();
            if (!TextUtils.isEmpty(payChannel)) {
                ta1Var.d(b, payChannel);
            }
            String installmentPeriod = payChannelEntity.getInstallmentPeriod();
            if (!TextUtils.isEmpty(installmentPeriod)) {
                ta1Var.d(c, installmentPeriod);
            }
            n(bundle, ta1Var, i);
            this.a.a(cb1.j(), i, ta1Var, new b(this, str, sa1Var));
        }
    }

    public final void w(String str, int i, String str2, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048594, this, new Object[]{str, Integer.valueOf(i), str2, Integer.valueOf(i2)}) == null) {
            HashMap hashMap = new HashMap();
            hashMap.put("exceptionType", "" + i);
            hashMap.put("path", str2);
            hashMap.put(StatConstants.KEY_EXT_ERR_CODE, "" + i2);
            xb1.c(str, hashMap);
        }
    }

    public final void x(String str, int i, String str2, int i2, String str3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048595, this, new Object[]{str, Integer.valueOf(i), str2, Integer.valueOf(i2), str3}) == null) {
            HashMap hashMap = new HashMap();
            hashMap.put("exceptionType", "" + i);
            hashMap.put("path", str2);
            hashMap.put(StatConstants.KEY_EXT_ERR_CODE, "" + i2);
            if (!TextUtils.isEmpty(str3)) {
                hashMap.put("isFoldChannel", str3);
            }
            xb1.c(str, hashMap);
        }
    }

    public final Map<String, String> y(JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048596, this, jSONObject)) == null) {
            Map<String, String> c2 = lc1.c();
            if (jSONObject != null) {
                Iterator<String> keys = jSONObject.keys();
                while (keys.hasNext()) {
                    String next = keys.next();
                    if (!TextUtils.isEmpty(next)) {
                        c2.put(next, jSONObject.optString(next));
                    }
                }
            }
            return c2;
        }
        return (Map) invokeL.objValue;
    }
}
