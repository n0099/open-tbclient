package com.baidu.tieba;

import android.content.Context;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mapapi.UIMsg;
import com.baidu.sapi2.activity.social.YYInnerSSOLoginActivity;
import com.baidu.sapi2.result.OneKeyLoginOptResult;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.sdk.base.api.CallBack;
import com.sdk.base.module.manager.SDKManager;
import com.sdk.mobile.manager.login.cucc.UiOauthManager;
import com.sdk.mobile.manager.oauth.cucc.OauthManager;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class ci1 extends uh1 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean s;

    /* loaded from: classes3.dex */
    public class a extends di1 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ int b;
        public final /* synthetic */ int c;
        public final /* synthetic */ int d;
        public final /* synthetic */ ci1 e;

        public a(ci1 ci1Var, long j, int i, int i2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ci1Var, Long.valueOf(j), Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i4 = newInitContext.flag;
                if ((i4 & 1) != 0) {
                    int i5 = i4 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.e = ci1Var;
            this.b = i;
            this.c = i2;
            this.d = i3;
        }

        @Override // com.sdk.base.api.CallBack
        public void onFailed(int i, int i2, String str, String str2) {
            int i3;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i), Integer.valueOf(i2), str, str2}) == null) {
                long currentTimeMillis = System.currentTimeMillis() - a();
                if (!this.e.M(i2, this.b) || (i3 = this.c) != 0) {
                    this.e.I(i2, str, this.b);
                } else {
                    this.e.x(this.b, this.d, i3 + 1);
                }
                mi1.c(this.e.a, this.e.c, i2, currentTimeMillis, this.d, str2);
            }
        }

        @Override // com.sdk.base.api.CallBack
        public void onSuccess(int i, String str, int i2, Object obj, String str2) {
            int i3;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Integer.valueOf(i), str, Integer.valueOf(i2), obj, str2}) == null) {
                long currentTimeMillis = System.currentTimeMillis() - a();
                if (i != 0) {
                    if (!this.e.M(i2, this.b) || (i3 = this.c) != 0) {
                        this.e.I(i2, str, this.b);
                    } else {
                        this.e.x(this.b, this.d, i3 + 1);
                    }
                } else {
                    this.e.D(obj, this.b);
                }
                mi1.c(this.e.a, this.e.c, i2, currentTimeMillis, this.d, str2);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b implements CallBack {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ int a;
        public final /* synthetic */ ci1 b;

        public b(ci1 ci1Var, int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ci1Var, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = ci1Var;
            this.a = i;
        }

        @Override // com.sdk.base.api.CallBack
        public void onFailed(int i, int i2, String str, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i), Integer.valueOf(i2), str, str2}) == null) {
                this.b.y(i2, str, this.a);
            }
        }

        @Override // com.sdk.base.api.CallBack
        public void onSuccess(int i, String str, int i2, Object obj, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Integer.valueOf(i), str, Integer.valueOf(i2), obj, str2}) == null) {
                if (i != 0) {
                    this.b.y(i2, str, this.a);
                } else {
                    this.b.L(obj, this.a);
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public class c extends ri1 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Object b;
        public final /* synthetic */ int c;
        public final /* synthetic */ ci1 d;

        public c(ci1 ci1Var, Object obj, int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ci1Var, obj, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.d = ci1Var;
            this.b = obj;
            this.c = i;
        }

        @Override // com.baidu.tieba.ri1
        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                try {
                    JSONObject jSONObject = new JSONObject((String) this.b);
                    this.d.g = jSONObject.optString(OneKeyLoginOptResult.OptResultFields.SECURITY_PHONE);
                    this.d.e = jSONObject.optString(YYInnerSSOLoginActivity.o);
                    this.d.f = jSONObject.optLong("exp");
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.put(OneKeyLoginOptResult.OptResultFields.SECURITY_PHONE, this.d.a(this.d.g));
                    this.d.e(this.c, 0, 0, this.d.c, jSONObject2.toString(), 1);
                } catch (Throwable unused) {
                    ci1 ci1Var = this.d;
                    ci1Var.e(this.c, 3, UIMsg.m_AppUI.MSG_APP_VERSION_COMMEND_NAV_MODULE, ci1Var.c, "cu on handle login unknown error.", 1);
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public class d extends ri1 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ int b;
        public final /* synthetic */ int c;
        public final /* synthetic */ String d;
        public final /* synthetic */ ci1 e;

        public d(ci1 ci1Var, int i, int i2, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ci1Var, Integer.valueOf(i), Integer.valueOf(i2), str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.e = ci1Var;
            this.b = i;
            this.c = i2;
            this.d = str;
        }

        @Override // com.baidu.tieba.ri1
        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                try {
                    if (this.e.c != this.e.d && this.b == 1101) {
                        this.e.e(this.c, 3, 2002, this.e.c, "pre login error, wrong sim operator", 1);
                    } else {
                        ci1 ci1Var = this.e;
                        int i = this.c;
                        int i2 = this.b;
                        int i3 = this.e.c;
                        StringBuilder sb = new StringBuilder();
                        sb.append("cu pre login error.");
                        sb.append(this.d);
                        sb.append(", status ");
                        sb.append(this.b);
                        ci1Var.e(i, 2, i2, i3, sb.toString(), 1);
                    }
                } catch (Throwable unused) {
                    ci1 ci1Var2 = this.e;
                    ci1Var2.e(this.c, 3, UIMsg.m_AppUI.MSG_APP_VERSION_COMMEND_NAV_MODULE, ci1Var2.c, "cu on handle login unknown error.", 1);
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public class e extends ri1 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Object b;
        public final /* synthetic */ int c;
        public final /* synthetic */ ci1 d;

        public e(ci1 ci1Var, Object obj, int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ci1Var, obj, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.d = ci1Var;
            this.b = obj;
            this.c = i;
        }

        @Override // com.baidu.tieba.ri1
        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                try {
                    JSONObject jSONObject = new JSONObject((String) this.b);
                    this.d.h = jSONObject.optString(YYInnerSSOLoginActivity.o);
                    this.d.i = jSONObject.optLong("exp");
                    this.d.e(this.c, 0, 0, this.d.c, "preVerify success", 3);
                } catch (Throwable unused) {
                    ci1 ci1Var = this.d;
                    ci1Var.e(this.c, 3, UIMsg.m_AppUI.MSG_APP_VERSION_COMMEND_NAV_MODULE, ci1Var.c, "cu on handle preVerify unknown error.", 3);
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public class f extends ri1 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ int b;
        public final /* synthetic */ int c;
        public final /* synthetic */ String d;
        public final /* synthetic */ ci1 e;

        public f(ci1 ci1Var, int i, int i2, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ci1Var, Integer.valueOf(i), Integer.valueOf(i2), str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.e = ci1Var;
            this.b = i;
            this.c = i2;
            this.d = str;
        }

        @Override // com.baidu.tieba.ri1
        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                try {
                    if (this.e.c != this.e.d && this.b == 1101) {
                        this.e.e(this.c, 3, 2002, this.e.c, "pre verify error, wrong sim operator", 3);
                    } else {
                        ci1 ci1Var = this.e;
                        int i = this.c;
                        int i2 = this.b;
                        int i3 = this.e.c;
                        StringBuilder sb = new StringBuilder();
                        sb.append("cu pre verify error.");
                        sb.append(this.d);
                        sb.append(", status ");
                        sb.append(this.b);
                        ci1Var.e(i, 2, i2, i3, sb.toString(), 3);
                    }
                } catch (Throwable unused) {
                    ci1 ci1Var2 = this.e;
                    ci1Var2.e(this.c, 3, UIMsg.m_AppUI.MSG_APP_VERSION_COMMEND_NAV_MODULE, ci1Var2.c, "cu on handle verify unknown error.", 3);
                }
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ci1(Context context) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.s = false;
        this.c = 2;
    }

    @Override // com.baidu.tieba.uh1, com.baidu.tieba.th1
    public void p(Context context, int i, long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048582, this, new Object[]{context, Integer.valueOf(i), Long.valueOf(j)}) == null) {
            super.p(context, i, j);
        }
    }

    public final void x(int i, int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIII(1048583, this, i, i2, i3) == null) {
            UiOauthManager.getInstance(this.a).login(8, new a(this, System.currentTimeMillis(), i, i3, i2));
        }
    }

    public final void D(Object obj, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048576, this, obj, i) == null) {
            ti1.c().b(new c(this, obj, i));
        }
    }

    public final void L(Object obj, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, obj, i) == null) {
            ti1.c().b(new e(this, obj, i));
        }
    }

    public final void I(int i, String str, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Integer.valueOf(i), str, Integer.valueOf(i2)}) == null) {
            ti1.c().b(new d(this, i, i2, str));
        }
    }

    public void y(int i, String str, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(InputDeviceCompat.SOURCE_TOUCHPAD, this, new Object[]{Integer.valueOf(i), str, Integer.valueOf(i2)}) == null) {
            ti1.c().b(new f(this, i, i2, str));
        }
    }

    public final boolean M(int i, int i2) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeII = interceptable.invokeII(1048579, this, i, i2)) == null) {
            boolean b2 = kh1.f(this.a).b();
            boolean m = kh1.f(this.a).m("k_retry_code_cu", i);
            boolean h = ph1.c().h(i2);
            if (b2 && m && h) {
                return true;
            }
            return false;
        }
        return invokeII.booleanValue;
    }

    @Override // com.baidu.tieba.th1
    public void h(Context context, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048580, this, context, i) == null) {
            super.h(context, i);
            if (!kh1.f(this.a).c()) {
                e(i, 3, 997, this.c, "pre verify error. sdk stop run", 3);
            } else if (!r()) {
                e(i, 3, 2006, this.c, "pre verify error. cu has not valid config.", 3);
            } else if (kh1.f(this.a).a()) {
                if (!this.s) {
                    SDKManager.init(this.a, th1.o, th1.p);
                    SDKManager.setUseCache(false);
                    this.s = true;
                }
                OauthManager.getInstance(this.a).getAuthoriseCode(8, new b(this, i));
            } else {
                e(i, 3, 995, this.c, "pre verify error. cu sdk stop run.", 3);
            }
        }
    }

    @Override // com.baidu.tieba.th1
    public void i(Context context, int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLII(1048581, this, context, i, i2) == null) {
            super.i(context, i, i2);
            if (!kh1.f(this.a).c()) {
                e(i2, 3, 997, this.c, "pre login error. sdk stop run", 1);
            } else if (!r()) {
                e(i2, 3, 2006, this.c, "pre login error. cu has not valid config.", 1);
            } else if (kh1.f(this.a).a()) {
                if (!this.s) {
                    System.currentTimeMillis();
                    SDKManager.init(this.a, th1.o, th1.p);
                    SDKManager.setUseCache(false);
                    SDKManager.setDebug(oh1.c());
                    this.s = true;
                }
                x(i2, i, 0);
            } else {
                e(i2, 3, 995, this.c, "pre login error. cu sdk stop run.", 1);
            }
        }
    }
}
