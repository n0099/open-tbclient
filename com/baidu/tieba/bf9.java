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
/* loaded from: classes5.dex */
public class bf9 {
    public static /* synthetic */ Interceptable $ic;
    public static final String a;
    public static final String b;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes5.dex */
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
            ia5 ia5Var = new ia5();
            ia5Var.b = R.raw.lottie_bubble_breath_tip;
            ia5Var.a = BreatheTipWidget.PointType.LOTTIE;
            ia5Var.c = xi.g(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds130);
            ja5 ja5Var = new ja5();
            ja5Var.a = cd9.t(R.string.obfuscated_res_0x7f0f05a6, new Object[0]);
            ja5Var.b = cd9.t(R.string.agree_tip_content, new Object[0]);
            ja5Var.e = R.drawable.pic_guidecard;
            ja5Var.f = xi.g(this.a, R.dimen.tbds156);
            ja5Var.g = xi.g(this.a, R.dimen.tbds489);
            ja5Var.h = xi.g(this.a, R.dimen.tbds286);
            if (this.b == null) {
                return;
            }
            BreatheTipWidget breatheTipWidget = new BreatheTipWidget(this.a);
            breatheTipWidget.j(this.b);
            breatheTipWidget.h(ja5Var, ia5Var);
            if (breatheTipWidget.k((Activity) this.a, 4000L)) {
                r95 p = r95.p();
                p.A("key_pb_double_click_agree_" + TbadkCoreApplication.getCurrentAccount(), true);
                bg5.c("c14828");
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947643188, "Lcom/baidu/tieba/bf9;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947643188, "Lcom/baidu/tieba/bf9;");
                return;
            }
        }
        a = r95.t("key_show_god_agree_tips_count");
        b = r95.t("key_show_god_agree_tips_timestamp");
    }

    public static void a() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(65537, null) == null) && !b()) {
            r95.p().H(b, System.currentTimeMillis());
            r95.p().F(a, 0);
        }
    }

    public static boolean b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            long currentTimeMillis = System.currentTimeMillis();
            long r = r95.p().r(b, 0L);
            if (r >= 0) {
                return TimeHelper.isSameDay(currentTimeMillis, r);
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public static boolean c(u89 u89Var) {
        InterceptResult invokeL;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, u89Var)) == null) {
            if (u89Var == null || u89Var.N() == null || !TbadkCoreApplication.isLogin() || !u89Var.N().isExcellentThread() || u89Var.N().getHasAgree() == 1) {
                return false;
            }
            if (b()) {
                i = r95.p().q(a, 0);
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

    public static void d(Context context, View view2, u89 u89Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLLL(InputDeviceCompat.SOURCE_TRACKBALL, null, context, view2, u89Var) != null) || u79.c() || c(u89Var)) {
            return;
        }
        r95 p = r95.p();
        if (!p.l("key_pb_double_click_agree_" + TbadkCoreApplication.getCurrentAccount(), false)) {
            yg.a().postDelayed(new a(context, view2), 500L);
        }
    }
}
