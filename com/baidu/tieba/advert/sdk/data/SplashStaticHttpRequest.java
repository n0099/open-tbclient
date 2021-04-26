package com.baidu.tieba.advert.sdk.data;

import android.content.Context;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.adp.framework.task.HttpMessageTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.mobads.container.components.command.XAdRemoteAPKDownloadExtraInfo;
import com.baidu.swan.apps.core.prefetch.PrefetchEvent;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.message.http.JsonHttpResponsedMessage;
import com.baidu.tbadk.task.TbHttpMessageTask;
import d.a.j0.r.a.i.b;
import d.a.j0.r.a.i.c;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class SplashStaticHttpRequest extends HttpMessage {

    /* loaded from: classes4.dex */
    public static class SplashStaticHttpResponse extends JsonHttpResponsedMessage {
        public SplashStaticHttpResponse(int i2) {
            super(i2);
        }
    }

    public SplashStaticHttpRequest() {
        super(CmdConfigHttp.CMD_STATIC_SPLASH);
    }

    public static void statisticApkDownLoadSuccess(Context context, AdInfo adInfo) {
        SplashStaticHttpRequest splashStaticHttpRequest = new SplashStaticHttpRequest();
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("stamp", String.valueOf(System.currentTimeMillis()));
            jSONObject.put("params", c.a(context, adInfo));
        } catch (JSONException e2) {
            BdLog.e(e2.getMessage());
        }
        splashStaticHttpRequest.addParam("parammap", jSONObject.toString());
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_STATIC_SPLASH, b.b());
        tbHttpMessageTask.setMethod(HttpMessageTask.HTTP_METHOD.GET);
        tbHttpMessageTask.setResponsedClass(SplashStaticHttpResponse.class);
        MessageManager.getInstance().sendMessage(splashStaticHttpRequest, tbHttpMessageTask);
    }

    public static void statisticClick(String str) {
        SplashStaticHttpRequest splashStaticHttpRequest = new SplashStaticHttpRequest();
        splashStaticHttpRequest.addParam(XAdRemoteAPKDownloadExtraInfo.PLACE_ID, str);
        splashStaticHttpRequest.addParam("text", PrefetchEvent.STATE_CLICK);
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_STATIC_SPLASH, "http://5v.baidu.com/statistics/tj.gif");
        tbHttpMessageTask.setMethod(HttpMessageTask.HTTP_METHOD.GET);
        tbHttpMessageTask.setResponsedClass(SplashStaticHttpResponse.class);
        MessageManager.getInstance().sendMessage(splashStaticHttpRequest, tbHttpMessageTask);
    }

    public static void statisticExpose(Context context, AdInfo adInfo) {
        SplashStaticHttpRequest splashStaticHttpRequest = new SplashStaticHttpRequest();
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("stamp", String.valueOf(System.currentTimeMillis()));
            jSONObject.put("params", c.a(context, adInfo));
        } catch (JSONException e2) {
            BdLog.e(e2.getMessage());
        }
        splashStaticHttpRequest.addParam("parammap", jSONObject.toString());
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_STATIC_SPLASH, b.c());
        tbHttpMessageTask.setMethod(HttpMessageTask.HTTP_METHOD.GET);
        tbHttpMessageTask.setResponsedClass(SplashStaticHttpResponse.class);
        MessageManager.getInstance().sendMessage(splashStaticHttpRequest, tbHttpMessageTask);
    }
}
