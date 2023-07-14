package com.baidu.tieba;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import androidx.core.view.InputDeviceCompat;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.TimeHelper;
import com.baidu.tbadk.core.view.breathetip.BreatheTipWidget;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class gl9 {
    public static /* synthetic */ Interceptable $ic;
    public static final String a;
    public static final String b;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes6.dex */
    public static class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Context a;
        public final /* synthetic */ View b;

        public a(Context context, View view2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {context, view2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = context;
            this.b = view2;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeV(1048576, this) != null) || BreatheTipWidget.f() || this.a == null) {
                return;
            }
            ab5 ab5Var = new ab5();
            ab5Var.b = R.raw.lottie_bubble_breath_tip;
            ab5Var.a = BreatheTipWidget.PointType.LOTTIE;
            ab5Var.c = yi.g(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds130);
            bb5 bb5Var = new bb5();
            bb5Var.a = hj9.t(R.string.obfuscated_res_0x7f0f05a9, new Object[0]);
            bb5Var.b = hj9.t(R.string.agree_tip_content, new Object[0]);
            bb5Var.e = R.drawable.pic_guidecard;
            bb5Var.f = yi.g(this.a, R.dimen.tbds156);
            bb5Var.g = yi.g(this.a, R.dimen.tbds489);
            bb5Var.h = yi.g(this.a, R.dimen.tbds286);
            if (this.b == null) {
                return;
            }
            BreatheTipWidget breatheTipWidget = new BreatheTipWidget(this.a);
            breatheTipWidget.j(this.b);
            breatheTipWidget.h(bb5Var, ab5Var);
            if (breatheTipWidget.k((Activity) this.a, 4000L)) {
                da5 p = da5.p();
                p.A("key_pb_double_click_agree_" + TbadkCoreApplication.getCurrentAccount(), true);
                yg5.c("c14828");
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947797909, "Lcom/baidu/tieba/gl9;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947797909, "Lcom/baidu/tieba/gl9;");
                return;
            }
        }
        a = da5.t("key_show_god_agree_tips_count");
        b = da5.t("key_show_god_agree_tips_timestamp");
    }

    public static void a() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(65537, null) == null) && !b()) {
            da5.p().H(b, System.currentTimeMillis());
            da5.p().F(a, 0);
        }
    }

    public static boolean b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            long currentTimeMillis = System.currentTimeMillis();
            long r = da5.p().r(b, 0L);
            if (r >= 0) {
                return TimeHelper.isSameDay(currentTimeMillis, r);
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public static boolean c(ze9 ze9Var) {
        InterceptResult invokeL;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, ze9Var)) == null) {
            if (ze9Var == null || ze9Var.N() == null || !TbadkCoreApplication.isLogin() || !ze9Var.N().isExcellentThread() || ze9Var.N().getHasAgree() == 1) {
                return false;
            }
            if (b()) {
                i = da5.p().q(a, 0);
            } else {
                i = 0;
            }
            if (i >= 2) {
                return false;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public static void d(Context context, View view2, ze9 ze9Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLLL(InputDeviceCompat.SOURCE_TRACKBALL, null, context, view2, ze9Var) != null) || zd9.c() || c(ze9Var)) {
            return;
        }
        da5 p = da5.p();
        if (!p.l("key_pb_double_click_agree_" + TbadkCoreApplication.getCurrentAccount(), false)) {
            zg.a().postDelayed(new a(context, view2), 500L);
        }
    }
}
