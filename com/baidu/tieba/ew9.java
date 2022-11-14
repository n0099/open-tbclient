package com.baidu.tieba;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.util.SparseArray;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.live.frame.IntentData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.yy.open.activity.AssistActivity;
import com.yy.open.activity.BridgeActivity;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public final class ew9 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public SparseArray<c> a;
    public Handler b;
    public Context c;
    public String d;
    public iw9 e;

    public final void h(int i, Intent intent, bw9 bw9Var, long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048581, this, new Object[]{Integer.valueOf(i), intent, bw9Var, Long.valueOf(j)}) == null) {
        }
    }

    /* loaded from: classes4.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ int a;
        public final /* synthetic */ bw9 b;
        public final /* synthetic */ Intent c;
        public final /* synthetic */ long d;
        public final /* synthetic */ ew9 e;

        public a(ew9 ew9Var, int i, bw9 bw9Var, Intent intent, long j) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ew9Var, Integer.valueOf(i), bw9Var, intent, Long.valueOf(j)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.e = ew9Var;
            this.a = i;
            this.b = bw9Var;
            this.c = intent;
            this.d = j;
        }

        @Override // java.lang.Runnable
        public void run() {
            String str;
            int i;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                try {
                    if (this.a == 0) {
                        this.b.onCancel();
                        return;
                    }
                    String stringExtra = this.c.getStringExtra("resjson");
                    this.e.e.a(stringExtra);
                    JSONObject jSONObject = new JSONObject(stringExtra);
                    if (jSONObject.has("resCode") && jSONObject.has("resMsg")) {
                        String optString = jSONObject.optString("resMsg");
                        int optInt = jSONObject.optInt("resCode");
                        if (optInt != 1000006 && optInt != 1290001) {
                            optInt = this.a;
                            this.e.f(this.c, this.b, this.d, optInt, optString);
                            return;
                        }
                        Log.e("chenqiang", "resCode:" + optInt);
                        this.e.f(this.c, this.b, this.d, optInt, optString);
                        return;
                    }
                    Log.e("chenqiang", "please update yy new version！");
                    if (jSONObject.has("openid") && jSONObject.has("access_code")) {
                        i = this.a;
                        str = "success";
                    } else {
                        str = "handleAuthLoginResult--default error!";
                        i = 444222199;
                    }
                    this.e.f(this.c, this.b, this.d, i, str);
                } catch (Exception unused) {
                    this.b.onError(new cw9(444222105, hw9.h(444222105)));
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ bw9 a;
        public final /* synthetic */ cw9 b;

        public b(ew9 ew9Var, bw9 bw9Var, cw9 cw9Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ew9Var, bw9Var, cw9Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = bw9Var;
            this.b = cw9Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.onError(this.b);
            }
        }
    }

    /* loaded from: classes4.dex */
    public final class c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public bw9 a;
        public long b;

        public c(ew9 ew9Var, bw9 bw9Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ew9Var, bw9Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = bw9Var;
            this.b = System.currentTimeMillis();
        }
    }

    public ew9(Context context, String str) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, str};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.e = iw9.b();
        this.c = context;
        this.d = str;
        this.a = new SparseArray<>();
        this.b = new Handler(Looper.getMainLooper());
    }

    public final void c(Activity activity, String str, bw9 bw9Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048576, this, activity, str, bw9Var) == null) {
            if (gw9.d(activity, BridgeActivity.class) && gw9.d(activity, AssistActivity.class)) {
                int a2 = hw9.a(activity);
                if (a2 != 0) {
                    try {
                        this.a.put(62345, new c(this, bw9Var));
                        String c2 = hw9.c(this.c, this.d, str, true);
                        Intent intent = new Intent(activity, AssistActivity.class);
                        intent.putExtra("type", "type_web");
                        intent.putExtra("url", c2);
                        activity.startActivityForResult(intent, 62345);
                        return;
                    } catch (Exception unused) {
                        g(new cw9(a2), bw9Var);
                        return;
                    }
                }
                Intent e = hw9.e(activity);
                this.a.put(62345, new c(this, bw9Var));
                Bundle d = hw9.d(activity, this.d);
                e.putExtra("action", "action_login");
                e.putExtra("bundle", d);
                i(activity, e, 62345);
                return;
            }
            g(new cw9(3), bw9Var);
        }
    }

    public final boolean d(int i, int i2, Intent intent, bw9 bw9Var) {
        InterceptResult invokeCommon;
        long currentTimeMillis;
        bw9 bw9Var2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Integer.valueOf(i), Integer.valueOf(i2), intent, bw9Var})) == null) {
            if (i != 62345 && i != 62347) {
                return false;
            }
            c cVar = this.a.get(i);
            if (cVar != null) {
                currentTimeMillis = cVar.b;
                bw9Var2 = cVar.a;
                this.a.remove(i);
            } else {
                currentTimeMillis = System.currentTimeMillis();
                bw9Var2 = bw9Var;
            }
            if (i == 62345) {
                e(i2, intent, bw9Var2, currentTimeMillis);
                return true;
            } else if (i != 62347) {
                return false;
            } else {
                h(i2, intent, bw9Var2, currentTimeMillis);
                return true;
            }
        }
        return invokeCommon.booleanValue;
    }

    public final void e(int i, Intent intent, bw9 bw9Var, long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Integer.valueOf(i), intent, bw9Var, Long.valueOf(j)}) == null) {
            this.b.postDelayed(new a(this, i, bw9Var, intent, j), 10L);
        }
    }

    public final void f(Intent intent, bw9 bw9Var, long j, int i, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{intent, bw9Var, Long.valueOf(j), Integer.valueOf(i), str}) == null) {
            switch (i) {
                case 1000006:
                    bw9Var.onError(new cw9(1000006, str));
                    return;
                case 1290001:
                    bw9Var.onError(new cw9(1290001, str));
                    return;
                case 444111001:
                    try {
                        String stringExtra = intent.getStringExtra("resjson");
                        this.e.a(stringExtra);
                        JSONObject jSONObject = new JSONObject(stringExtra);
                        jSONObject.optString("openid");
                        jSONObject.optString("uid");
                        jSONObject.optString("access_code");
                        bw9Var.onComplete(jSONObject);
                        return;
                    } catch (Exception unused) {
                        bw9Var.onError(new cw9(444222105, hw9.h(444222105)));
                        return;
                    }
                case 444111002:
                    bw9Var.onCancel();
                    return;
                case 444111003:
                    try {
                        JSONObject jSONObject2 = new JSONObject(intent.getStringExtra("resjson"));
                        if ("1".equals(jSONObject2.optString("appType"))) {
                            jSONObject2.optString("uid");
                        } else {
                            jSONObject2.optString("openid");
                        }
                        bw9Var.onComplete(jSONObject2);
                        return;
                    } catch (Exception unused2) {
                        bw9Var.onError(new cw9(444222105, hw9.h(444222105)));
                        return;
                    }
                case 444222000:
                    bw9Var.onError(new cw9(444222000, str));
                    return;
                case 444222001:
                    bw9Var.onError(new cw9(444222001, str));
                    return;
                case 444222002:
                    bw9Var.onError(new cw9(444222002, str));
                    return;
                case 444222003:
                    bw9Var.onError(new cw9(444222003, str));
                    return;
                case 444222104:
                    bw9Var.onError(new cw9(444222104, str));
                    return;
                case 444222105:
                    bw9Var.onError(new cw9(444222105, str));
                    return;
                case 444222106:
                    try {
                        new JSONObject(intent.getStringExtra("resjson"));
                        bw9Var.onError(new cw9(444222106, str));
                        return;
                    } catch (Exception unused3) {
                        bw9Var.onError(new cw9(444222105, hw9.h(444222105)));
                        return;
                    }
                case 444222108:
                    try {
                        bw9Var.onComplete(new JSONObject(intent.getStringExtra("resjson")));
                        return;
                    } catch (Exception unused4) {
                        bw9Var.onError(new cw9(444222105, hw9.h(444222105)));
                        return;
                    }
                case 444222110:
                    try {
                        new JSONObject(intent.getStringExtra("resjson"));
                        bw9Var.onError(new cw9(444222110, str));
                        return;
                    } catch (Exception unused5) {
                        bw9Var.onError(new cw9(444222105, hw9.h(444222105)));
                        return;
                    }
                default:
                    Log.e("chenqiang", "default  error");
                    bw9Var.onError(new cw9(i, hw9.h(i)));
                    return;
            }
        }
    }

    public final void g(cw9 cw9Var, bw9 bw9Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048580, this, cw9Var, bw9Var) == null) && bw9Var != null) {
            this.b.postDelayed(new b(this, bw9Var, cw9Var), 50L);
        }
    }

    public final void i(Activity activity, Intent intent, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLI(1048582, this, activity, intent, i) == null) {
            intent.putExtra("request_code", i);
            Intent intent2 = new Intent(activity.getApplicationContext(), BridgeActivity.class);
            intent2.putExtra(IntentData.KEY, intent);
            activity.startActivityForResult(intent2, i);
        }
    }
}
