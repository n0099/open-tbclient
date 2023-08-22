package com.baidu.tieba.common.jscore;

import androidx.annotation.Keep;
import com.baidu.tbadk.coreExtra.view.BaseWebView;
import com.baidu.tieba.ny4;
import com.baidu.tieba.oy4;
import com.baidu.tieba.py4;
import com.baidu.tieba.yl6;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
@Keep
/* loaded from: classes5.dex */
public final class JsInterfaces_tbadkcore {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public JsInterfaces_tbadkcore() {
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

    public static void register() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65537, null) == null) {
            yl6.a().c("_TieBa_Native_Invoke", py4.class);
            yl6.a().c("local_obj", ny4.class);
            yl6.a().c(BaseWebView.TB_NA_CHANNEL, oy4.class);
        }
    }
}
