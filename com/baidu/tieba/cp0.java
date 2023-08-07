package com.baidu.tieba;

import android.content.Context;
import android.view.ViewGroup;
import com.baidu.nadcore.lp.reward.view.NadRewardFullTailView;
import com.baidu.nadcore.lp.reward.view.NadRewardHalfTailHolder;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes5.dex */
public interface cp0 {
    public static final a k0 = a.a;

    ViewGroup getView();

    void setData(mr0 mr0Var);

    void setOnReplayClickListener(Function0<Unit> function0);

    void setVisibility(boolean z);

    /* loaded from: classes5.dex */
    public static final class a {
        public static /* synthetic */ Interceptable $ic;
        public static final /* synthetic */ a a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-883060183, "Lcom/baidu/tieba/cp0$a;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-883060183, "Lcom/baidu/tieba/cp0$a;");
                    return;
                }
            }
            a = new a();
        }

        public a() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65537, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                }
            }
        }

        public final cp0 a(mr0 adModel, Context context) {
            InterceptResult invokeLL;
            String str;
            rr0 rr0Var;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, adModel, context)) == null) {
                Intrinsics.checkNotNullParameter(adModel, "adModel");
                Intrinsics.checkNotNullParameter(context, "context");
                pr0 pr0Var = adModel.j;
                if (pr0Var != null && (rr0Var = pr0Var.i) != null) {
                    str = rr0Var.a;
                } else {
                    str = null;
                }
                if (str != null && str.hashCode() == 49 && str.equals("1")) {
                    return new NadRewardHalfTailHolder(context, null, 0, 6, null);
                }
                return new NadRewardFullTailView(context, null, 0, 6, null);
            }
            return (cp0) invokeLL.objValue;
        }
    }
}
