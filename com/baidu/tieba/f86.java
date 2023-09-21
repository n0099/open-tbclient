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
public final class f86 {
    public static /* synthetic */ Interceptable $ic;
    public static final f86 a;
    public static final HashMap<String, hl0> b;
    public static boolean c;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes5.dex */
    public static final class a implements zl0 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ hl0 a;

        public a(hl0 hl0Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hl0Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = hl0Var;
        }

        @Override // com.baidu.tieba.zl0
        public void a(AdDownloadAction action, hl0 data) {
            hl0 hl0Var;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, action, data) == null) {
                Intrinsics.checkNotNullParameter(action, "action");
                Intrinsics.checkNotNullParameter(data, "data");
                if (action == AdDownloadAction.INSTALL_FINISH && !g31.h(f86.b)) {
                    String str = data.d;
                    if (!TextUtils.isEmpty(str) && (hl0Var = (hl0) i31.b(f86.b, str)) != null && hl0Var.e() != null) {
                        km0.l().t(this.a, true);
                        ql0.f().a(hl0Var.e().hashCode());
                        ql0.f().h(ClogBuilder.LogType.INSTALL_COMPLETE.type, ClogBuilder.Area.AD_NOTIFICATION_NOTIFY.type, hl0Var.p.a, hl0Var.q.m);
                        i31.g(f86.b, str);
                    }
                }
            }
        }

        @Override // com.baidu.tieba.zl0
        public hl0 getData() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                return this.a;
            }
            return (hl0) invokeV.objValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947718053, "Lcom/baidu/tieba/f86;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947718053, "Lcom/baidu/tieba/f86;");
                return;
            }
        }
        a = new f86();
        b = new HashMap<>();
    }

    public f86() {
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

    public final void b(hl0 hl0Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048576, this, hl0Var) != null) || hl0Var == null) {
            return;
        }
        a aVar = new a(hl0Var);
        AdAppStateManager.instance().register(hl0Var);
        uk0.c().k(hl0Var.e(), aVar);
    }

    public final void c(hl0 adDownloadBean) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, adDownloadBean) == null) {
            Intrinsics.checkNotNullParameter(adDownloadBean, "adDownloadBean");
            b(adDownloadBean);
            HashMap<String, hl0> hashMap = b;
            String str = adDownloadBean.d;
            Intrinsics.checkNotNullExpressionValue(str, "adDownloadBean.packageName");
            hashMap.put(str, adDownloadBean);
            ql0.f().h(ClogBuilder.LogType.FREE_SHOW.type, ClogBuilder.Area.AD_NOTIFICATION_SHOW.type, adDownloadBean.p.a, adDownloadBean.q.m);
            if (!c) {
                ql0.f().h(ClogBuilder.LogType.FREE_SHOW.type, ClogBuilder.Area.AD_NOTIFICATION_NOTIFY.type, "", String.valueOf(g86.b.a() + 1));
                c = true;
            }
            km0.l().t(adDownloadBean, false);
        }
    }
}
