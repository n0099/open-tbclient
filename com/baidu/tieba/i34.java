package com.baidu.tieba;

import android.os.Bundle;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.gamecenter.appmanager.download.AppDownloadNetworkStateReceiver;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class i34 extends v73 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String f;
    public String g;
    public JSONObject h;

    /* loaded from: classes6.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ JSONObject a;
        public final /* synthetic */ i34 b;

        public a(i34 i34Var, JSONObject jSONObject) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {i34Var, jSONObject};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = i34Var;
            this.a = jSONObject;
        }

        /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
        @Override // java.lang.Runnable
        public void run() {
            char c;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                u24.n().G(this.b.h);
                String str = this.b.f;
                switch (str.hashCode()) {
                    case -1261560102:
                        if (str.equals("queryStatus")) {
                            c = 1;
                            break;
                        }
                        c = 65535;
                        break;
                    case -625158317:
                        if (str.equals("deleteDownload")) {
                            c = 5;
                            break;
                        }
                        c = 65535;
                        break;
                    case -606050596:
                        if (str.equals("resumeAllDownload")) {
                            c = 6;
                            break;
                        }
                        c = 65535;
                        break;
                    case -534830837:
                        if (str.equals("queryAllStatus")) {
                            c = 2;
                            break;
                        }
                        c = 65535;
                        break;
                    case -451216226:
                        if (str.equals("pauseDownload")) {
                            c = 3;
                            break;
                        }
                        c = 65535;
                        break;
                    case -417021581:
                        if (str.equals("pauseAllDownload")) {
                            c = 7;
                            break;
                        }
                        c = 65535;
                        break;
                    case 184711125:
                        if (str.equals("resumeDownload")) {
                            c = 4;
                            break;
                        }
                        c = 65535;
                        break;
                    case 1554935562:
                        if (str.equals("startDownload")) {
                            c = 0;
                            break;
                        }
                        c = 65535;
                        break;
                    default:
                        c = 65535;
                        break;
                }
                switch (c) {
                    case 0:
                        this.b.w(this.a);
                        return;
                    case 1:
                        this.b.t(this.a);
                        return;
                    case 2:
                        this.b.s();
                        return;
                    case 3:
                        this.b.r(this.a);
                        return;
                    case 4:
                        this.b.v(this.a);
                        return;
                    case 5:
                        this.b.p(this.a);
                        return;
                    case 6:
                        this.b.u();
                        return;
                    case 7:
                        this.b.q();
                        return;
                    default:
                        this.b.setResult(new p34(31009, "invalid operation"));
                        return;
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b implements o34 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ i34 a;

        public b(i34 i34Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {i34Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = i34Var;
        }

        @Override // com.baidu.tieba.o34
        public void a(q34 q34Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeL(1048576, this, q34Var) != null) {
                return;
            }
            this.a.setResult(q34Var);
        }
    }

    public i34() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public final void q() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            u24.n().u();
        }
    }

    public final void s() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            u24.n().w(new b(this));
        }
    }

    public final void u() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            u24.n().D();
        }
    }

    public final void p(@NonNull JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, jSONObject) == null) {
            u24.n().m(jSONObject, new b(this));
        }
    }

    public final void r(@NonNull JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, jSONObject) == null) {
            u24.n().v(jSONObject, new b(this));
        }
    }

    public final void t(@NonNull JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, jSONObject) == null) {
            u24.n().x(jSONObject, new b(this));
        }
    }

    public final void v(@NonNull JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, jSONObject) == null) {
            u24.n().E(jSONObject, new b(this));
        }
    }

    public final void w(@NonNull JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, jSONObject) == null) {
            u24.n().H(jSONObject.optString("url"), jSONObject.optString("packageName"), jSONObject.optString("apkId"), new b(this));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setResult(q34 q34Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65548, this, q34Var) == null) {
            this.d.clear();
            if (q34Var != null) {
                this.d.putString("functionType", q34Var.a());
                this.d.putString("resultData", q34Var.b());
                this.d.putInt("resultStatus", q34Var.c());
                if (q34Var.d()) {
                    if (!TextUtils.equals(this.f, "startDownload")) {
                        w34.a(this.g, this.f, "success", null, new u34(this.h));
                    }
                } else {
                    w34.a(this.g, this.f, "fail", String.valueOf(q34Var.c()), new u34(this.h));
                }
            }
            c();
        }
    }

    @Override // com.baidu.tieba.v73
    public void b(@NonNull Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, bundle) == null) {
            this.f = bundle.getString(AppDownloadNetworkStateReceiver.KEY_OPERATION, "");
            this.h = vo3.d(bundle.getString("ubc_params", ""));
            JSONObject d = vo3.d(bundle.getString("data", ""));
            this.g = d.optString("packageName");
            x24.d.execute(new a(this, d));
        }
    }
}
