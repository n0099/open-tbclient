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
import com.baidu.searchbox.ui.state.StateManager;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.yy.open.activity.AssistActivity;
import com.yy.open.activity.BridgeActivity;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public final class b2c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public SparseArray<c> a;
    public Handler b;
    public Context c;
    public String d;
    public f2c e;

    public final void h(int i, Intent intent, y1c y1cVar, long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048581, this, new Object[]{Integer.valueOf(i), intent, y1cVar, Long.valueOf(j)}) == null) {
        }
    }

    /* loaded from: classes5.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ int a;
        public final /* synthetic */ y1c b;
        public final /* synthetic */ Intent c;
        public final /* synthetic */ long d;
        public final /* synthetic */ b2c e;

        public a(b2c b2cVar, int i, y1c y1cVar, Intent intent, long j) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {b2cVar, Integer.valueOf(i), y1cVar, intent, Long.valueOf(j)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.e = b2cVar;
            this.a = i;
            this.b = y1cVar;
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
                    this.b.onError(new z1c(444222105, e2c.h(444222105)));
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ y1c a;
        public final /* synthetic */ z1c b;

        public b(b2c b2cVar, y1c y1cVar, z1c z1cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {b2cVar, y1cVar, z1cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = y1cVar;
            this.b = z1cVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.onError(this.b);
            }
        }
    }

    /* loaded from: classes5.dex */
    public final class c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public y1c a;
        public long b;

        public c(b2c b2cVar, y1c y1cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {b2cVar, y1cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = y1cVar;
            this.b = System.currentTimeMillis();
        }
    }

    public b2c(Context context, String str) {
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
        this.e = f2c.b();
        this.c = context;
        this.d = str;
        this.a = new SparseArray<>();
        this.b = new Handler(Looper.getMainLooper());
    }

    public final void c(Activity activity, String str, y1c y1cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048576, this, activity, str, y1cVar) == null) {
            if (d2c.d(activity, BridgeActivity.class) && d2c.d(activity, AssistActivity.class)) {
                int a2 = e2c.a(activity);
                if (a2 != 0) {
                    try {
                        this.a.put(62345, new c(this, y1cVar));
                        String c2 = e2c.c(this.c, this.d, str, true);
                        Intent intent = new Intent(activity, AssistActivity.class);
                        intent.putExtra("type", "type_web");
                        intent.putExtra("url", c2);
                        activity.startActivityForResult(intent, 62345);
                        return;
                    } catch (Exception unused) {
                        g(new z1c(a2), y1cVar);
                        return;
                    }
                }
                Intent e = e2c.e(activity);
                this.a.put(62345, new c(this, y1cVar));
                Bundle d = e2c.d(activity, this.d);
                e.putExtra("action", "action_login");
                e.putExtra(StateManager.KEY_STATE, d);
                i(activity, e, 62345);
                return;
            }
            g(new z1c(3), y1cVar);
        }
    }

    public final boolean d(int i, int i2, Intent intent, y1c y1cVar) {
        InterceptResult invokeCommon;
        long currentTimeMillis;
        y1c y1cVar2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Integer.valueOf(i), Integer.valueOf(i2), intent, y1cVar})) == null) {
            if (i != 62345 && i != 62347) {
                return false;
            }
            c cVar = this.a.get(i);
            if (cVar != null) {
                currentTimeMillis = cVar.b;
                y1cVar2 = cVar.a;
                this.a.remove(i);
            } else {
                currentTimeMillis = System.currentTimeMillis();
                y1cVar2 = y1cVar;
            }
            if (i == 62345) {
                e(i2, intent, y1cVar2, currentTimeMillis);
                return true;
            } else if (i != 62347) {
                return false;
            } else {
                h(i2, intent, y1cVar2, currentTimeMillis);
                return true;
            }
        }
        return invokeCommon.booleanValue;
    }

    public final void e(int i, Intent intent, y1c y1cVar, long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Integer.valueOf(i), intent, y1cVar, Long.valueOf(j)}) == null) {
            this.b.postDelayed(new a(this, i, y1cVar, intent, j), 10L);
        }
    }

    public final void f(Intent intent, y1c y1cVar, long j, int i, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{intent, y1cVar, Long.valueOf(j), Integer.valueOf(i), str}) == null) {
            switch (i) {
                case 1000006:
                    y1cVar.onError(new z1c(1000006, str));
                    return;
                case 1290001:
                    y1cVar.onError(new z1c(1290001, str));
                    return;
                case 444111001:
                    try {
                        String stringExtra = intent.getStringExtra("resjson");
                        this.e.a(stringExtra);
                        JSONObject jSONObject = new JSONObject(stringExtra);
                        jSONObject.optString("openid");
                        jSONObject.optString("uid");
                        jSONObject.optString("access_code");
                        y1cVar.onComplete(jSONObject);
                        return;
                    } catch (Exception unused) {
                        y1cVar.onError(new z1c(444222105, e2c.h(444222105)));
                        return;
                    }
                case 444111002:
                    y1cVar.onCancel();
                    return;
                case 444111003:
                    try {
                        JSONObject jSONObject2 = new JSONObject(intent.getStringExtra("resjson"));
                        if ("1".equals(jSONObject2.optString("appType"))) {
                            jSONObject2.optString("uid");
                        } else {
                            jSONObject2.optString("openid");
                        }
                        y1cVar.onComplete(jSONObject2);
                        return;
                    } catch (Exception unused2) {
                        y1cVar.onError(new z1c(444222105, e2c.h(444222105)));
                        return;
                    }
                case 444222000:
                    y1cVar.onError(new z1c(444222000, str));
                    return;
                case 444222001:
                    y1cVar.onError(new z1c(444222001, str));
                    return;
                case 444222002:
                    y1cVar.onError(new z1c(444222002, str));
                    return;
                case 444222003:
                    y1cVar.onError(new z1c(444222003, str));
                    return;
                case 444222104:
                    y1cVar.onError(new z1c(444222104, str));
                    return;
                case 444222105:
                    y1cVar.onError(new z1c(444222105, str));
                    return;
                case 444222106:
                    try {
                        new JSONObject(intent.getStringExtra("resjson"));
                        y1cVar.onError(new z1c(444222106, str));
                        return;
                    } catch (Exception unused3) {
                        y1cVar.onError(new z1c(444222105, e2c.h(444222105)));
                        return;
                    }
                case 444222108:
                    try {
                        y1cVar.onComplete(new JSONObject(intent.getStringExtra("resjson")));
                        return;
                    } catch (Exception unused4) {
                        y1cVar.onError(new z1c(444222105, e2c.h(444222105)));
                        return;
                    }
                case 444222110:
                    try {
                        new JSONObject(intent.getStringExtra("resjson"));
                        y1cVar.onError(new z1c(444222110, str));
                        return;
                    } catch (Exception unused5) {
                        y1cVar.onError(new z1c(444222105, e2c.h(444222105)));
                        return;
                    }
                default:
                    Log.e("chenqiang", "default  error");
                    y1cVar.onError(new z1c(i, e2c.h(i)));
                    return;
            }
        }
    }

    public final void g(z1c z1cVar, y1c y1cVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048580, this, z1cVar, y1cVar) == null) && y1cVar != null) {
            this.b.postDelayed(new b(this, y1cVar, z1cVar), 50L);
        }
    }

    public final void i(Activity activity, Intent intent, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLI(1048582, this, activity, intent, i) == null) {
            intent.putExtra("request_code", i);
            Intent intent2 = new Intent(activity.getApplicationContext(), BridgeActivity.class);
            intent2.putExtra("intent", intent);
            activity.startActivityForResult(intent2, i);
        }
    }
}
