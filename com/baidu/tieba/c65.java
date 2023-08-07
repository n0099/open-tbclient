package com.baidu.tieba;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.browser.BrowserHelper;
import com.baidu.tbadk.core.atomData.TbWebViewActivityConfig;
import com.baidu.tbadk.core.atomData.WebViewActivityConfig;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class c65 extends r55 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public c65() {
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

    @Override // com.baidu.tieba.r55
    public void a(@NonNull Context context, @NonNull j55 j55Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, context, j55Var) == null) {
            String a = j55Var.a("yun_dialogName");
            String a2 = j55Var.a("yun_dialogUrl");
            if (!TextUtils.isEmpty(a) && !TextUtils.isEmpty(a2)) {
                b(context, a2, a);
            }
        }
    }

    public final void b(Context context, String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, str, str2) == null) {
            Bundle bundle = new Bundle();
            bundle.putString(WebViewActivityConfig.TAG_PAGE_TRANSLUCENT, TbWebViewActivityConfig.PAGE_TYPE_BLACK_TRANSLUCENT);
            bundle.putString(WebViewActivityConfig.TAG_WEB_DIALOG_NAME, str2);
            bundle.putBoolean(WebViewActivityConfig.TAG_TRANSLUCENT_AUTO_CLOSE, true);
            BrowserHelper.startWebActivity(context, "", str + TbWebViewActivityConfig.JUMP_PARAMS_PAGE_TYPE, false, true, true, bundle);
        }
    }
}
