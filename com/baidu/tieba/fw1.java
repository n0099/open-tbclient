package com.baidu.tieba;

import android.annotation.SuppressLint;
import android.util.Pair;
import android.view.View;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.swan.apps.view.SwanAppActionBar;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class fw1 extends wv1 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public final int C(boolean z, int i) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i)})) == null) {
            if (z) {
                return i;
            }
            return -1;
        }
        return invokeCommon.intValue;
    }

    @Override // com.baidu.tieba.tt1
    public String k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? "RequestFullScreenApi" : (String) invokeV.objValue;
    }

    /* loaded from: classes6.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ int a;
        public final /* synthetic */ String b;
        public final /* synthetic */ fw1 c;

        public a(fw1 fw1Var, int i, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fw1Var, Integer.valueOf(i), str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = fw1Var;
            this.a = i;
            this.b = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                View b = l43.b();
                LinearLayout d = l43.d();
                int i = this.a;
                if (i != -90) {
                    if (i != 0) {
                        if (i != 90) {
                            l43.o();
                            if (b != null) {
                                b.setVisibility(0);
                            }
                            if (d != null) {
                                d.setVisibility(0);
                            }
                            fw1.F();
                        } else {
                            if (b != null) {
                                b.setVisibility(8);
                            }
                            if (d != null) {
                                d.setVisibility(8);
                            }
                            l43.g();
                            l43.m(true);
                            fw1.E(0);
                        }
                    } else {
                        if (d != null) {
                            d.setVisibility(8);
                        }
                        fw1.D();
                    }
                } else {
                    if (b != null) {
                        b.setVisibility(8);
                    }
                    if (d != null) {
                        d.setVisibility(8);
                    }
                    l43.g();
                    l43.m(true);
                    fw1.E(8);
                }
                hw1.e().u(this.a);
                this.c.d(this.b, new qx1(0));
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public fw1(@NonNull rt1 rt1Var) {
        super(rt1Var);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {rt1Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((rt1) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    @SuppressLint({"SourceLockedOrientationActivity"})
    public static void D() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65538, null) == null) {
            SwanAppActivity activity = cr2.V().getActivity();
            if (yh3.d(activity)) {
                activity.setRequestedOrientation(1);
            }
            x42 J = cr2.V().J();
            if (J != null) {
                J.Y3(true);
                J.w2();
            }
        }
    }

    public static void E(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(65539, null, i) == null) {
            if (cr2.V().J() != null) {
                cr2.V().J().Y3(false);
            }
            SwanAppActivity activity = cr2.V().getActivity();
            if (yh3.d(activity)) {
                activity.setRequestedOrientation(i);
            }
            if (activity.getWindow() != null) {
                activity.getWindow().clearFlags(2048);
                activity.getWindow().setFlags(1024, 1024);
            }
        }
    }

    public qx1 G(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
            r("#setFullScreen", false);
            Pair<qx1, JSONObject> t = t(str);
            qx1 qx1Var = (qx1) t.first;
            if (!qx1Var.isSuccess()) {
                return qx1Var;
            }
            JSONObject jSONObject = (JSONObject) t.second;
            B(C(jSONObject.optBoolean("fullScreen"), jSONObject.optInt(HiAnalyticsConstant.HaKey.BI_KEY_DIRECTION)), jSONObject.optString("cb"));
            return qx1.f();
        }
        return (qx1) invokeL.objValue;
    }

    @SuppressLint({"SourceLockedOrientationActivity"})
    public static void F() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null) == null) {
            SwanAppActivity activity = cr2.V().getActivity();
            x42 J = cr2.V().J();
            if (yh3.d(activity)) {
                activity.setRequestedOrientation(1);
            }
            if (!l43.i(l43.e(activity))) {
                l43.m(false);
            }
            if (activity.getWindow() != null) {
                activity.getWindow().clearFlags(1024);
                activity.getWindow().clearFlags(2048);
            }
            if (J != null) {
                J.Y3(false);
                J.w2();
                qk3 O1 = J.O1();
                if (O1 != null) {
                    int i = O1.d().b;
                    View b = l43.b();
                    if (b != null) {
                        b.findViewById(R.id.obfuscated_res_0x7f09018f).setBackgroundColor(i);
                    }
                }
                SwanAppActionBar Q1 = J.Q1();
                Q1.f(Q1.getCenterTitleView().getCurrentTextColor(), false);
            }
        }
    }

    public final void B(int i, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048576, this, i, str) == null) {
            jj3.a0(new a(this, i, str));
        }
    }
}
