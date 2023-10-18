package com.baidu.tieba;

import android.app.Activity;
import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.nadcore.stats.request.ClogBuilder;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public final class ad0 extends jj0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean a;
    public long b;
    public long c;

    public ad0() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = true;
        this.b = 0L;
        this.c = 0L;
    }

    public final void f() {
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            ClogBuilder k = new ClogBuilder().y(ClogBuilder.LogType.CHECK).u(ClogBuilder.Page.NA_SPLASH).k("4");
            if (this.a) {
                str = "4003";
            } else {
                str = "4002";
            }
            jy0.e(k.l(str).m(String.valueOf(this.c)));
        }
    }

    @Override // com.baidu.tieba.jj0, com.baidu.tieba.mj0
    public void onBackgroundToForeground(@NonNull Activity activity) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, activity) == null) {
            if (!this.a) {
                this.c = System.currentTimeMillis() - this.b;
            }
            if (pe0.a().o()) {
                f();
            }
        }
    }

    @Override // com.baidu.tieba.jj0, com.baidu.tieba.mj0
    public void onForegroundToBackground(@NonNull Activity activity) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, activity) == null) {
            this.a = false;
            this.b = System.currentTimeMillis();
        }
    }
}
