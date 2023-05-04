package com.baidu.tieba;

import android.webkit.JavascriptInterface;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.v8engine.JsObject;
import com.baidu.searchbox.v8engine.event.JSEvent;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public class ga4 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ea4 a;

    /* loaded from: classes4.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ SwanAppActivity a;

        public a(ga4 ga4Var, SwanAppActivity swanAppActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ga4Var, swanAppActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = swanAppActivity;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                fl3.a(this.a);
            }
        }
    }

    public ga4(JsObject jsObject) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {jsObject};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = ea4.d(e02.F(jsObject));
        da4.a().f(this);
    }

    /* JADX WARN: Code restructure failed: missing block: B:20:0x0054, code lost:
        if (r1.equals("checkForUpdate") != false) goto L16;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void a(fa4 fa4Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048576, this, fa4Var) == null) && this.a != null && JSEvent.isValid(fa4Var)) {
            char c = 0;
            x42.i("UpdateManagerApi", String.format("dispatchEvent : eventType = %s; hasUpdate = %s", fa4Var.type, Boolean.valueOf(fa4Var.hasUpdate)));
            String str = fa4Var.type;
            int hashCode = str.hashCode();
            if (hashCode != -1330233754) {
                if (hashCode != -1317168438) {
                    if (hashCode == -585906598 && str.equals("updateReady")) {
                        c = 1;
                    }
                    c = 65535;
                }
            } else {
                if (str.equals("updateFailed")) {
                    c = 2;
                }
                c = 65535;
            }
            if (c != 0) {
                if (c != 1) {
                    if (c == 2) {
                        this.a.b();
                        return;
                    }
                    return;
                }
                this.a.c();
                return;
            }
            this.a.a(fa4Var);
        }
    }

    @JavascriptInterface
    public boolean applyUpdate() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            SwanAppActivity activity = kt2.U().getActivity();
            if (activity == null) {
                x42.c("UpdateManagerApi", "applyUpdate activity is null");
                return false;
            } else if (activity.isDestroyed() || activity.getIntent() == null) {
                return false;
            } else {
                rl3.e0(new a(this, activity));
                return true;
            }
        }
        return invokeV.booleanValue;
    }
}
