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
/* loaded from: classes4.dex */
public class hz3 extends u33 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String f;
    public String g;
    public JSONObject h;

    /* loaded from: classes4.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ JSONObject a;
        public final /* synthetic */ hz3 b;

        public a(hz3 hz3Var, JSONObject jSONObject) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hz3Var, jSONObject};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = hz3Var;
            this.a = jSONObject;
        }

        /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
        @Override // java.lang.Runnable
        public void run() {
            char c;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                ty3.n().G(this.b.h);
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
                        this.b.setResult(new oz3(31009, "invalid operation"));
                        return;
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b implements nz3 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ hz3 a;

        public b(hz3 hz3Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hz3Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = hz3Var;
        }

        @Override // com.baidu.tieba.nz3
        public void a(pz3 pz3Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeL(1048576, this, pz3Var) != null) {
                return;
            }
            this.a.setResult(pz3Var);
        }
    }

    public hz3() {
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
            ty3.n().u();
        }
    }

    public final void s() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            ty3.n().w(new b(this));
        }
    }

    public final void u() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            ty3.n().D();
        }
    }

    public final void p(@NonNull JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, jSONObject) == null) {
            ty3.n().m(jSONObject, new b(this));
        }
    }

    public final void r(@NonNull JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, jSONObject) == null) {
            ty3.n().v(jSONObject, new b(this));
        }
    }

    public final void t(@NonNull JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, jSONObject) == null) {
            ty3.n().x(jSONObject, new b(this));
        }
    }

    public final void v(@NonNull JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, jSONObject) == null) {
            ty3.n().E(jSONObject, new b(this));
        }
    }

    public final void w(@NonNull JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, jSONObject) == null) {
            ty3.n().H(jSONObject.optString("url"), jSONObject.optString("packageName"), jSONObject.optString("apkId"), new b(this));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setResult(pz3 pz3Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65548, this, pz3Var) == null) {
            this.d.clear();
            if (pz3Var != null) {
                this.d.putString("functionType", pz3Var.a());
                this.d.putString("resultData", pz3Var.b());
                this.d.putInt("resultStatus", pz3Var.c());
                if (pz3Var.d()) {
                    if (!TextUtils.equals(this.f, "startDownload")) {
                        vz3.a(this.g, this.f, "success", null, new tz3(this.h));
                    }
                } else {
                    vz3.a(this.g, this.f, com.baidu.pass.biometrics.face.liveness.b.a.g0, String.valueOf(pz3Var.c()), new tz3(this.h));
                }
            }
            c();
        }
    }

    @Override // com.baidu.tieba.u33
    public void b(@NonNull Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, bundle) == null) {
            this.f = bundle.getString(AppDownloadNetworkStateReceiver.KEY_OPERATION, "");
            this.h = uk3.d(bundle.getString("ubc_params", ""));
            JSONObject d = uk3.d(bundle.getString("data", ""));
            this.g = d.optString("packageName");
            wy3.d.execute(new a(this, d));
        }
    }
}
