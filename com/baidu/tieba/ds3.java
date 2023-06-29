package com.baidu.tieba;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.process.ipc.agent.activity.MainProcessDelegateActivity;
import com.baidu.searchbox.process.ipc.agent.activity.PluginDelegateActivity;
import com.baidu.searchbox.process.ipc.delegate.DelegateListener;
import com.baidu.searchbox.process.ipc.delegate.DelegateResult;
import com.baidu.searchbox.process.ipc.delegate.DelegateUtils;
import com.baidu.searchbox.process.ipc.util.ProcessUtils;
import com.baidu.swan.bdprivate.extensions.loginauthmobile.SwanAppPhoneLoginDialog;
import com.baidu.tieba.gb3;
import com.baidu.tieba.gt3;
import com.baidu.tieba.kt3;
import com.baidu.tieba.os3;
import com.baidu.tieba.vu3;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public final class ds3 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean a;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes5.dex */
    public static class a implements DelegateListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ os1 a;

        public a(os1 os1Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {os1Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = os1Var;
        }

        @Override // com.baidu.searchbox.process.ipc.delegate.DelegateListener
        public void onDelegateCallBack(@NonNull DelegateResult delegateResult) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, delegateResult) != null) || this.a == null) {
                return;
            }
            if (!delegateResult.isOk()) {
                this.a.onResult(-1);
                return;
            }
            this.a.onResult(delegateResult.mResult.getInt("result_code", -1));
        }
    }

    /* loaded from: classes5.dex */
    public static class b extends i83 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ kt3.c c;

        @Override // com.baidu.tieba.i83, com.baidu.tieba.h83
        public long a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return 30000L;
            }
            return invokeV.longValue;
        }

        public b(kt3.c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = cVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.i83, com.baidu.tieba.j83, com.baidu.tieba.h83
        public void onEvent(@NonNull f83 f83Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, f83Var) == null) {
                if (ds3.a) {
                    Log.d("AccountUtils", "get openBduss messenger delegate observer receive event");
                }
                String str = null;
                if (f83Var.a() != null) {
                    str = f83Var.a().getString("result");
                } else if (ds3.a) {
                    Log.d("AccountUtils", "get openBduss : result null");
                }
                this.c.a(str);
            }
        }
    }

    /* loaded from: classes5.dex */
    public static class c extends i83 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ vq3 c;

        @Override // com.baidu.tieba.i83, com.baidu.tieba.h83
        public long a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return 30000L;
            }
            return invokeV.longValue;
        }

        public c(vq3 vq3Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {vq3Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = vq3Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.i83, com.baidu.tieba.j83, com.baidu.tieba.h83
        public void onEvent(@NonNull f83 f83Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, f83Var) == null) {
                if (ds3.a) {
                    Log.d("AccountUtils", "get stoken messenger delegate observer receive event");
                }
                Bundle bundle = null;
                if (f83Var.a() != null) {
                    if (ds3.a) {
                        Log.d("AccountUtils", "get stoken : result " + f83Var.a());
                    }
                    bundle = f83Var.a().getBundle("key_result_stokent");
                } else if (ds3.a) {
                    Log.d("AccountUtils", "get stoken : result null");
                }
                this.c.a(bundle);
            }
        }
    }

    /* loaded from: classes5.dex */
    public static class d implements os3.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ vq3 a;

        @Override // com.baidu.tieba.os3.a
        public void onFinish() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            }
        }

        @Override // com.baidu.tieba.os3.a
        public void onStart() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            }
        }

        public d(vq3 vq3Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {vq3Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = vq3Var;
        }

        @Override // com.baidu.tieba.os3.a
        public void a(os3 os3Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, os3Var) == null) {
                this.a.a(null);
            }
        }

        @Override // com.baidu.tieba.os3.a
        public void b(os3 os3Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, os3Var) == null) {
                if (os3Var.a != 0 || os3Var.b == null) {
                    this.a.a(null);
                }
                Bundle bundle = new Bundle();
                for (Map.Entry<String, String> entry : os3Var.b.entrySet()) {
                    String key = entry.getKey();
                    if (!TextUtils.isEmpty(key)) {
                        bundle.putString(key, entry.getValue());
                    }
                }
                this.a.a(bundle);
            }
        }
    }

    /* loaded from: classes5.dex */
    public static class e implements DelegateListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ss1 a;

        public e(ss1 ss1Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ss1Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ss1Var;
        }

        @Override // com.baidu.searchbox.process.ipc.delegate.DelegateListener
        public void onDelegateCallBack(@NonNull DelegateResult delegateResult) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, delegateResult) == null) {
                String string = delegateResult.mResult.getString("address_info");
                if (TextUtils.isEmpty(string)) {
                    if (ms1.a) {
                        Log.e("AccountUtils", delegateResult.mResult.getString("errorMsg"));
                    }
                    this.a.a(0);
                    return;
                }
                if (ms1.a) {
                    Log.i("AccountUtils", string);
                }
                this.a.b(cp3.d(string));
            }
        }
    }

    /* loaded from: classes5.dex */
    public static class f implements et3 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Bundle a;
        public final /* synthetic */ vq3 b;

        public f(Bundle bundle, vq3 vq3Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bundle, vq3Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = bundle;
            this.b = vq3Var;
        }

        @Override // com.baidu.tieba.et3
        public void a(ct3 ct3Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, ct3Var) == null) {
                if (ds3.a) {
                    Log.d("AccountUtils", "callbackkey=" + ct3Var.a);
                }
                this.a.putString("callbackKey", ct3Var.a);
                vq3 vq3Var = this.b;
                if (vq3Var != null) {
                    vq3Var.a(this.a);
                }
            }
        }

        @Override // com.baidu.tieba.et3
        public void onFailure(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
                if (ds3.a) {
                    Log.d("AccountUtils", "onFailure=" + str);
                }
                this.a.putString("failMsg", str);
                vq3 vq3Var = this.b;
                if (vq3Var != null) {
                    vq3Var.a(this.a);
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public static class g implements DelegateListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ vq3 a;

        public g(vq3 vq3Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {vq3Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = vq3Var;
        }

        @Override // com.baidu.searchbox.process.ipc.delegate.DelegateListener
        public void onDelegateCallBack(@NonNull DelegateResult delegateResult) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, delegateResult) == null) {
                Bundle bundle = delegateResult.mResult;
                vq3 vq3Var = this.a;
                if (vq3Var != null) {
                    vq3Var.a(bp3.d(bundle, "result"));
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public static class h implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Activity a;
        public final /* synthetic */ String b;
        public final /* synthetic */ String c;

        public h(Activity activity, String str, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {activity, str, str2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = activity;
            this.b = str;
            this.c = str2;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeV(1048576, this) != null) {
                return;
            }
            ds3.O(this.a, this.b, this.c);
        }
    }

    /* loaded from: classes5.dex */
    public static class i implements DialogInterface.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Activity a;

        public i(Activity activity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {activity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = activity;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048576, this, dialogInterface, i) == null) {
                ds3.M(this.a, true, null, null);
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947715077, "Lcom/baidu/tieba/ds3;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947715077, "Lcom/baidu/tieba/ds3;");
                return;
            }
        }
        a = ms1.a;
    }

    public static dt3 A(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, context)) == null) {
            if (!ProcessUtils.isMainProcess()) {
                return null;
            }
            return ys3.a().d(context);
        }
        return (dt3) invokeL.objValue;
    }

    public static et3 C(vq3<Bundle> vq3Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, vq3Var)) == null) {
            return new f(new Bundle(), vq3Var);
        }
        return (et3) invokeL.objValue;
    }

    public static boolean E(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, null, context)) == null) {
            if (!ProcessUtils.isMainProcess()) {
                return false;
            }
            return ys3.a().g(context);
        }
        return invokeL.booleanValue;
    }

    public static boolean F(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65542, null, context)) == null) {
            if (ProcessUtils.isMainProcess()) {
                return E(context);
            }
            return G(context);
        }
        return invokeL.booleanValue;
    }

    public static boolean G(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65543, null, context)) == null) {
            DelegateResult callOnMainWithContentProvider = DelegateUtils.callOnMainWithContentProvider(context, ms3.class, null);
            if (!callOnMainWithContentProvider.isOk() || !callOnMainWithContentProvider.mResult.getBoolean("result", false)) {
                return false;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public static void c(qs1 qs1Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(65555, null, qs1Var) != null) || qs1Var == null) {
            return;
        }
        ys3.a().h(qs1Var);
    }

    public static dt3 g(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65559, null, context)) == null) {
            if (ProcessUtils.isMainProcess()) {
                return A(context);
            }
            return B(context);
        }
        return (dt3) invokeL.objValue;
    }

    public static String h(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65560, null, context)) == null) {
            if (!ProcessUtils.isMainProcess()) {
                return "";
            }
            String bduss = ys3.a().getBduss(context);
            if (TextUtils.isEmpty(bduss)) {
                return "";
            }
            return bduss;
        }
        return (String) invokeL.objValue;
    }

    public static String i(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65561, null, context)) == null) {
            if (ProcessUtils.isMainProcess()) {
                return h(context);
            }
            return j(context);
        }
        return (String) invokeL.objValue;
    }

    public static String j(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65562, null, context)) == null) {
            DelegateResult callOnMainWithContentProvider = DelegateUtils.callOnMainWithContentProvider(context, fs3.class, null);
            if (!callOnMainWithContentProvider.isOk()) {
                return "";
            }
            return callOnMainWithContentProvider.mResult.getString("result", "");
        }
        return (String) invokeL.objValue;
    }

    public static String k(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65563, null, context)) == null) {
            if (!ProcessUtils.isMainProcess()) {
                return "";
            }
            return ys3.a().k(context);
        }
        return (String) invokeL.objValue;
    }

    public static String l(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65564, null, context)) == null) {
            if (ProcessUtils.isMainProcess()) {
                return k(context);
            }
            return m(context);
        }
        return (String) invokeL.objValue;
    }

    public static String m(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65565, null, context)) == null) {
            DelegateResult callOnMainWithContentProvider = DelegateUtils.callOnMainWithContentProvider(context, gs3.class, null);
            if (!callOnMainWithContentProvider.isOk()) {
                return "";
            }
            return callOnMainWithContentProvider.mResult.getString("result", "");
        }
        return (String) invokeL.objValue;
    }

    public static String q(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65569, null, context)) == null) {
            if (!ProcessUtils.isMainProcess()) {
                return "";
            }
            return ys3.a().a(context);
        }
        return (String) invokeL.objValue;
    }

    public static String r(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65570, null, context)) == null) {
            if (ProcessUtils.isMainProcess()) {
                return q(context);
            }
            return s(context);
        }
        return (String) invokeL.objValue;
    }

    public static String s(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65571, null, context)) == null) {
            DelegateResult callOnMainWithContentProvider = DelegateUtils.callOnMainWithContentProvider(context, is3.class, null);
            if (!callOnMainWithContentProvider.isOk()) {
                return "";
            }
            return callOnMainWithContentProvider.mResult.getString("result", "");
        }
        return (String) invokeL.objValue;
    }

    public static String x(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65576, null, context)) == null) {
            if (!ProcessUtils.isMainProcess()) {
                return "";
            }
            return ys3.a().b(context);
        }
        return (String) invokeL.objValue;
    }

    public static String y(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65577, null, context)) == null) {
            if (ProcessUtils.isMainProcess()) {
                return x(context);
            }
            return z(context);
        }
        return (String) invokeL.objValue;
    }

    public static String z(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65578, null, context)) == null) {
            DelegateResult callOnMainWithContentProvider = DelegateUtils.callOnMainWithContentProvider(context, ks3.class, null);
            if (!callOnMainWithContentProvider.isOk()) {
                return "";
            }
            return callOnMainWithContentProvider.mResult.getString("result", "");
        }
        return (String) invokeL.objValue;
    }

    public static dt3 B(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, context)) == null) {
            DelegateResult callOnMainWithContentProvider = DelegateUtils.callOnMainWithContentProvider(context, ls3.class, null);
            if (!callOnMainWithContentProvider.isOk()) {
                return null;
            }
            dt3 dt3Var = new dt3();
            dt3Var.a = callOnMainWithContentProvider.mResult.getString("NICK_NAME", "");
            dt3Var.b = callOnMainWithContentProvider.mResult.getString("AVATAR_URL", "");
            return dt3Var;
        }
        return (dt3) invokeL.objValue;
    }

    public static void D(Activity activity, JSONObject jSONObject) {
        JSONObject c2;
        String str;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, activity, jSONObject) == null) && (c2 = ah3.c(jSONObject)) != null && activity != null) {
            int optInt = c2.optInt("errno", 10001);
            String optString = c2.optString("tipmsg");
            if (optInt == 401 || optInt == 400701) {
                JSONObject optJSONObject = c2.optJSONObject("tipoption");
                if (optJSONObject != null) {
                    str = optJSONObject.optString("title");
                } else {
                    str = null;
                }
                if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(optString)) {
                    wp3.e0(new h(activity, str, optString));
                }
            }
        }
    }

    public static void H(Activity activity, String str, vq3<Bundle> vq3Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65544, null, activity, str, vq3Var) == null) {
            ys3.a().l(activity, "baidu_mini_programs_" + str, i(activity), C(vq3Var));
        }
    }

    public static void K(Activity activity, String str, vq3<Bundle> vq3Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65547, null, activity, str, vq3Var) == null) {
            ys3.a().e(activity, "baidu_mini_programs_" + str, i(activity), C(vq3Var));
        }
    }

    public static void L(Context context, Bundle bundle, os1 os1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65548, null, context, bundle, os1Var) == null) {
            if (!ProcessUtils.isMainProcess()) {
                os1Var.onResult(-1);
            } else {
                ys3.a().c(context, bundle, os1Var);
            }
        }
    }

    public static void P(Context context, SwanAppPhoneLoginDialog.g gVar, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65552, null, context, gVar, str) == null) {
            ys3.a().j(context, gVar, str);
        }
    }

    public static void n(String str, ArrayList<String> arrayList, kt3.c cVar) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLLL(65566, null, str, arrayList, cVar) != null) || !ProcessUtils.isMainProcess()) {
            return;
        }
        ys3.a().n(str, arrayList, cVar);
    }

    public static void t(Context context, vq3<Bundle> vq3Var, @Nullable String... strArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65572, null, context, vq3Var, strArr) == null) {
            if (ProcessUtils.isMainProcess()) {
                u(context, vq3Var, strArr);
            } else {
                w(vq3Var, strArr);
            }
        }
    }

    public static void v(os3.a aVar, String str, List<String> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65574, null, aVar, str, list) == null) {
            ys3.a().o(aVar, str, list);
        }
    }

    public static void I(Activity activity, boolean z, String str, vq3<Bundle> vq3Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65545, null, new Object[]{activity, Boolean.valueOf(z), str, vq3Var}) == null) {
            Bundle bundle = new Bundle();
            bundle.putBoolean("isRealName", z);
            bundle.putString("swanAppId", str);
            DelegateUtils.callOnMainWithActivity(activity, PluginDelegateActivity.class, es3.class, bundle, new g(vq3Var));
        }
    }

    public static void M(Activity activity, boolean z, Bundle bundle, os1 os1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65549, null, new Object[]{activity, Boolean.valueOf(z), bundle, os1Var}) == null) {
            if (ProcessUtils.isMainProcess()) {
                L(activity, bundle, os1Var);
            } else {
                N(activity, z, bundle, os1Var);
            }
        }
    }

    public static void N(Activity activity, boolean z, Bundle bundle, os1 os1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65550, null, new Object[]{activity, Boolean.valueOf(z), bundle, os1Var}) == null) {
            Bundle bundle2 = new Bundle();
            bundle2.putBoolean("key_login_force", z);
            bundle2.putBundle("key_login_params", bundle);
            DelegateUtils.callOnMainWithActivity(activity, MainProcessDelegateActivity.class, ns3.class, bundle2, new a(os1Var));
        }
    }

    public static void p(Context context, String str, ArrayList<String> arrayList, kt3.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(65568, null, context, str, arrayList, cVar) == null) {
            cc3 M = cc3.M();
            if (M == null) {
                cVar.a(null);
                return;
            }
            x83 y = M.y();
            if (y == null) {
                cVar.a(null);
                return;
            }
            Bundle bundle = new Bundle();
            bundle.putString("key_result_client_id", str);
            bundle.putStringArrayList("key_param_tpl_list", arrayList);
            y.X(bundle, hs3.class, new b(cVar));
        }
    }

    public static void J(Activity activity, String str, String str2, vq3<Bundle> vq3Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(65546, null, activity, str, str2, vq3Var) == null) {
            boolean equals = TextUtils.equals(str, "1");
            if (ProcessUtils.isMainProcess()) {
                if (equals) {
                    H(activity, str2, vq3Var);
                    return;
                } else {
                    K(activity, str2, vq3Var);
                    return;
                }
            }
            I(activity, equals, str2, vq3Var);
        }
    }

    public static void o(Context context, String str, ArrayList<String> arrayList, kt3.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(65567, null, context, str, arrayList, cVar) == null) {
            if (ProcessUtils.isMainProcess()) {
                n(str, arrayList, cVar);
            } else {
                p(context, str, arrayList, cVar);
            }
        }
    }

    public static void O(Activity activity, String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65551, null, activity, str, str2) == null) {
            gb3.a aVar = new gb3.a(activity);
            aVar.V(str);
            aVar.x(str2);
            aVar.n(new kr3());
            aVar.m(true);
            aVar.P(activity.getString(R.string.obfuscated_res_0x7f0f1494), new i(activity));
            aVar.C(activity.getString(R.string.obfuscated_res_0x7f0f1495), null);
            aVar.X();
        }
    }

    public static void u(Context context, vq3<Bundle> vq3Var, @Nullable String... strArr) {
        List asList;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65573, null, context, vq3Var, strArr) == null) {
            if (ProcessUtils.isMainProcess()) {
                String h2 = h(context);
                if (TextUtils.isEmpty(h2)) {
                    vq3Var.a(null);
                    return;
                }
                d dVar = new d(vq3Var);
                if (strArr == null) {
                    asList = Collections.emptyList();
                } else {
                    asList = Arrays.asList(strArr);
                }
                v(dVar, h2, asList);
                return;
            }
            throw new IllegalStateException("must call in MainProcess");
        }
    }

    public static void d(Context context, gt3.d dVar) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(65556, null, context, dVar) != null) || !ProcessUtils.isMainProcess()) {
            return;
        }
        ys3.a().i(context, dVar);
    }

    public static void e(Activity activity, ss1 ss1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65557, null, activity, ss1Var) == null) {
            DelegateUtils.callOnMainWithActivity(activity, MainProcessDelegateActivity.class, gt3.class, new e(ss1Var));
        }
    }

    public static void f(Context context, vu3.d dVar) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(65558, null, context, dVar) != null) || !ProcessUtils.isMainProcess()) {
            return;
        }
        ys3.a().f(context, dVar);
    }

    public static void w(vq3<Bundle> vq3Var, String... strArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65575, null, vq3Var, strArr) == null) {
            if (strArr != null && strArr.length >= 1) {
                cc3 M = cc3.M();
                if (M == null) {
                    vq3Var.a(null);
                    return;
                }
                x83 y = M.y();
                if (y == null) {
                    vq3Var.a(null);
                    return;
                }
                Bundle bundle = new Bundle();
                bundle.putStringArray("key_param_tpl_list", strArr);
                y.X(bundle, js3.class, new c(vq3Var));
                return;
            }
            vq3Var.a(null);
        }
    }
}
