package com.baidu.tieba.advert.sdk.data;

import android.content.Context;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.adp.framework.task.HttpMessageTask;
import com.baidu.mobstat.Config;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.browser.SearchJsBridge;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.task.TbHttpMessageTask;
import com.baidu.tbadk.util.AdExtParam;
import com.baidu.tieba.fu5;
import com.baidu.tieba.qt5;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.heytap.mcssdk.mode.CommandMessage;
/* loaded from: classes3.dex */
public class SplashHttpRequest extends HttpMessage {
    public static /* synthetic */ Interceptable $ic = null;
    public static final TbHttpMessageTask mTask;
    public static final String url = "http://afd.baidu.com/afd/entry";
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-39270754, "Lcom/baidu/tieba/advert/sdk/data/SplashHttpRequest;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-39270754, "Lcom/baidu/tieba/advert/sdk/data/SplashHttpRequest;");
                return;
            }
        }
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_GET_SPLASH_INFO, url);
        mTask = tbHttpMessageTask;
        tbHttpMessageTask.setResponsedClass(SplashHttpResponse.class);
        mTask.setMethod(HttpMessageTask.HTTP_METHOD.POST);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SplashHttpRequest(Context context, AdInfo adInfo) {
        super(CmdConfigHttp.CMD_GET_SPLASH_INFO);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, adInfo};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super(((Integer) newInitContext.callArgs[0]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        if (adInfo != null && context != null) {
            addParam("pid", adInfo.placeId);
            addParam("ver", fu5.b(context));
            addParam("cuid", TbadkCoreApplication.getInst().getCuid());
            addParam(SearchJsBridge.COOKIE_MOD, qt5.c());
            addParam("ot", 2);
            addParam("ov", qt5.d());
            addParam(CommandMessage.SDK_VERSION, "1.1.4");
            addParam("nt", qt5.b(context).intValue());
            addParam(Config.EXCEPTION_CRASH_TYPE, 2);
            addParam(TbConfig.SW_APID, qt5.f(context).intValue());
            addParam("sh", qt5.e(context).intValue());
            addParam("imei", qt5.a(context));
            addParam("fmt", "json");
            addParam("adw", adInfo.adWidth);
            addParam("adh", adInfo.adHeight);
            addParam("ac", 1);
            addParam("ad_ext_params", AdExtParam.a.b().a());
        }
    }

    public static void sendRequest(SplashHttpRequest splashHttpRequest) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65538, null, splashHttpRequest) == null) {
            MessageManager.getInstance().sendMessage(splashHttpRequest, mTask);
        }
    }
}
