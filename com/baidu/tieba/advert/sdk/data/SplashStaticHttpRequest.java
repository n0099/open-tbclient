package com.baidu.tieba.advert.sdk.data;

import android.content.Context;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.adp.framework.task.HttpMessageTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.message.http.JsonHttpResponsedMessage;
import com.baidu.tbadk.task.TbHttpMessageTask;
import com.baidu.tieba.u56;
import com.baidu.tieba.v56;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class SplashStaticHttpRequest extends HttpMessage {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes5.dex */
    public static class SplashStaticHttpResponse extends JsonHttpResponsedMessage {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public SplashStaticHttpResponse(int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SplashStaticHttpRequest() {
        super(CmdConfigHttp.CMD_STATIC_SPLASH);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super(((Integer) newInitContext.callArgs[0]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    public static void statisticApkDownLoadSuccess(Context context, AdInfo adInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65537, null, context, adInfo) == null) {
            SplashStaticHttpRequest splashStaticHttpRequest = new SplashStaticHttpRequest();
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("stamp", String.valueOf(System.currentTimeMillis()));
                jSONObject.put("params", v56.a(context, adInfo));
            } catch (JSONException e) {
                BdLog.e(e.getMessage());
            }
            splashStaticHttpRequest.addParam("parammap", jSONObject.toString());
            TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_STATIC_SPLASH, u56.b());
            tbHttpMessageTask.setMethod(HttpMessageTask.HTTP_METHOD.GET);
            tbHttpMessageTask.setResponsedClass(SplashStaticHttpResponse.class);
            MessageManager.getInstance().sendMessage(splashStaticHttpRequest, tbHttpMessageTask);
        }
    }

    public static void statisticExpose(Context context, AdInfo adInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65539, null, context, adInfo) == null) {
            SplashStaticHttpRequest splashStaticHttpRequest = new SplashStaticHttpRequest();
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("stamp", String.valueOf(System.currentTimeMillis()));
                jSONObject.put("params", v56.a(context, adInfo));
            } catch (JSONException e) {
                BdLog.e(e.getMessage());
            }
            splashStaticHttpRequest.addParam("parammap", jSONObject.toString());
            TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_STATIC_SPLASH, u56.c());
            tbHttpMessageTask.setMethod(HttpMessageTask.HTTP_METHOD.GET);
            tbHttpMessageTask.setResponsedClass(SplashStaticHttpResponse.class);
            MessageManager.getInstance().sendMessage(splashStaticHttpRequest, tbHttpMessageTask);
        }
    }

    public static void statisticClick(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65538, null, str) == null) {
            SplashStaticHttpRequest splashStaticHttpRequest = new SplashStaticHttpRequest();
            splashStaticHttpRequest.addParam("placeId", str);
            splashStaticHttpRequest.addParam("text", "click");
            TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_STATIC_SPLASH, "http://5v.baidu.com/statistics/tj.gif");
            tbHttpMessageTask.setMethod(HttpMessageTask.HTTP_METHOD.GET);
            tbHttpMessageTask.setResponsedClass(SplashStaticHttpResponse.class);
            MessageManager.getInstance().sendMessage(splashStaticHttpRequest, tbHttpMessageTask);
        }
    }
}
