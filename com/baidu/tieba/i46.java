package com.baidu.tieba;

import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.nadcore.download.basic.AdAppStateManager;
import com.baidu.nadcore.download.consts.AdDownloadAction;
import com.baidu.nadcore.stats.request.ClogBuilder;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes6.dex */
public final class i46 {
    public static /* synthetic */ Interceptable $ic;
    public static final i46 a;
    public static final HashMap<String, vg0> b;
    public static boolean c;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes6.dex */
    public static final class a implements nh0 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ vg0 a;

        public a(vg0 vg0Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {vg0Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = vg0Var;
        }

        @Override // com.baidu.tieba.nh0
        public void a(AdDownloadAction action, vg0 data) {
            vg0 vg0Var;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, action, data) == null) {
                Intrinsics.checkNotNullParameter(action, "action");
                Intrinsics.checkNotNullParameter(data, "data");
                if (action == AdDownloadAction.INSTALL_FINISH && !ky0.h(i46.b)) {
                    String str = data.d;
                    if (!TextUtils.isEmpty(str) && (vg0Var = (vg0) my0.b(i46.b, str)) != null && vg0Var.e() != null) {
                        yh0.l().t(this.a, true);
                        eh0.f().a(vg0Var.e().hashCode());
                        eh0.f().h(ClogBuilder.LogType.INSTALL_COMPLETE.type, ClogBuilder.Area.AD_NOTIFICATION_NOTIFY.type, vg0Var.p.a, vg0Var.q.m);
                        my0.g(i46.b, str);
                    }
                }
            }
        }

        @Override // com.baidu.tieba.nh0
        public vg0 getData() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                return this.a;
            }
            return (vg0) invokeV.objValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947803582, "Lcom/baidu/tieba/i46;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947803582, "Lcom/baidu/tieba/i46;");
                return;
            }
        }
        a = new i46();
        b = new HashMap<>();
    }

    public i46() {
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

    public final void b(vg0 vg0Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048576, this, vg0Var) != null) || vg0Var == null) {
            return;
        }
        a aVar = new a(vg0Var);
        AdAppStateManager.instance().register(vg0Var);
        ig0.c().k(vg0Var.e(), aVar);
    }

    public final void c(vg0 adDownloadBean) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, adDownloadBean) == null) {
            Intrinsics.checkNotNullParameter(adDownloadBean, "adDownloadBean");
            b(adDownloadBean);
            HashMap<String, vg0> hashMap = b;
            String str = adDownloadBean.d;
            Intrinsics.checkNotNullExpressionValue(str, "adDownloadBean.packageName");
            hashMap.put(str, adDownloadBean);
            eh0.f().h(ClogBuilder.LogType.FREE_SHOW.type, ClogBuilder.Area.AD_NOTIFICATION_SHOW.type, adDownloadBean.p.a, adDownloadBean.q.m);
            if (!c) {
                eh0.f().h(ClogBuilder.LogType.FREE_SHOW.type, ClogBuilder.Area.AD_NOTIFICATION_NOTIFY.type, "", String.valueOf(j46.b.a() + 1));
                c = true;
            }
            yh0.l().t(adDownloadBean, false);
        }
    }
}
