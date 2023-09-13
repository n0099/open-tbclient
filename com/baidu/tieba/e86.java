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
/* loaded from: classes5.dex */
public final class e86 {
    public static /* synthetic */ Interceptable $ic;
    public static final e86 a;
    public static final HashMap<String, il0> b;
    public static boolean c;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes5.dex */
    public static final class a implements am0 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ il0 a;

        public a(il0 il0Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {il0Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = il0Var;
        }

        @Override // com.baidu.tieba.am0
        public void a(AdDownloadAction action, il0 data) {
            il0 il0Var;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, action, data) == null) {
                Intrinsics.checkNotNullParameter(action, "action");
                Intrinsics.checkNotNullParameter(data, "data");
                if (action == AdDownloadAction.INSTALL_FINISH && !h31.h(e86.b)) {
                    String str = data.d;
                    if (!TextUtils.isEmpty(str) && (il0Var = (il0) j31.b(e86.b, str)) != null && il0Var.e() != null) {
                        lm0.l().t(this.a, true);
                        rl0.f().a(il0Var.e().hashCode());
                        rl0.f().h(ClogBuilder.LogType.INSTALL_COMPLETE.type, ClogBuilder.Area.AD_NOTIFICATION_NOTIFY.type, il0Var.p.a, il0Var.q.m);
                        j31.g(e86.b, str);
                    }
                }
            }
        }

        @Override // com.baidu.tieba.am0
        public il0 getData() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                return this.a;
            }
            return (il0) invokeV.objValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947688262, "Lcom/baidu/tieba/e86;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947688262, "Lcom/baidu/tieba/e86;");
                return;
            }
        }
        a = new e86();
        b = new HashMap<>();
    }

    public e86() {
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

    public final void b(il0 il0Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048576, this, il0Var) != null) || il0Var == null) {
            return;
        }
        a aVar = new a(il0Var);
        AdAppStateManager.instance().register(il0Var);
        vk0.c().k(il0Var.e(), aVar);
    }

    public final void c(il0 adDownloadBean) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, adDownloadBean) == null) {
            Intrinsics.checkNotNullParameter(adDownloadBean, "adDownloadBean");
            b(adDownloadBean);
            HashMap<String, il0> hashMap = b;
            String str = adDownloadBean.d;
            Intrinsics.checkNotNullExpressionValue(str, "adDownloadBean.packageName");
            hashMap.put(str, adDownloadBean);
            rl0.f().h(ClogBuilder.LogType.FREE_SHOW.type, ClogBuilder.Area.AD_NOTIFICATION_SHOW.type, adDownloadBean.p.a, adDownloadBean.q.m);
            if (!c) {
                rl0.f().h(ClogBuilder.LogType.FREE_SHOW.type, ClogBuilder.Area.AD_NOTIFICATION_NOTIFY.type, "", String.valueOf(f86.b.a() + 1));
                c = true;
            }
            lm0.l().t(adDownloadBean, false);
        }
    }
}
