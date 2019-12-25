package com.baidu.tieba.advert.sdk.data;

import android.content.Context;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.adp.framework.task.HttpMessageTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.message.http.JsonHttpResponsedMessage;
import com.baidu.tbadk.task.TbHttpMessageTask;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class SplashStaticHttpRequest extends HttpMessage {
    public SplashStaticHttpRequest() {
        super(1003193);
    }

    public static void statisticClick(String str) {
        SplashStaticHttpRequest splashStaticHttpRequest = new SplashStaticHttpRequest();
        splashStaticHttpRequest.addParam("placeId", str);
        splashStaticHttpRequest.addParam("text", "click");
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1003193, "http://5v.baidu.com/statistics/tj.gif");
        tbHttpMessageTask.setMethod(HttpMessageTask.HTTP_METHOD.GET);
        tbHttpMessageTask.setResponsedClass(SplashStaticHttpResponse.class);
        MessageManager.getInstance().sendMessage(splashStaticHttpRequest, tbHttpMessageTask);
    }

    public static void statisticExpose(Context context, AdInfo adInfo) {
        SplashStaticHttpRequest splashStaticHttpRequest = new SplashStaticHttpRequest();
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("stamp", String.valueOf(System.currentTimeMillis()));
            jSONObject.put("params", com.baidu.tieba.advert.sdk.b.c.a(context, adInfo));
        } catch (JSONException e) {
            BdLog.e(e.getMessage());
        }
        splashStaticHttpRequest.addParam("parammap", jSONObject.toString());
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1003193, com.baidu.tieba.advert.sdk.b.b.aWB());
        tbHttpMessageTask.setMethod(HttpMessageTask.HTTP_METHOD.GET);
        tbHttpMessageTask.setResponsedClass(SplashStaticHttpResponse.class);
        MessageManager.getInstance().sendMessage(splashStaticHttpRequest, tbHttpMessageTask);
    }

    public static void statisticApkDownLoadSuccess(Context context, AdInfo adInfo) {
        SplashStaticHttpRequest splashStaticHttpRequest = new SplashStaticHttpRequest();
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("stamp", String.valueOf(System.currentTimeMillis()));
            jSONObject.put("params", com.baidu.tieba.advert.sdk.b.c.a(context, adInfo));
        } catch (JSONException e) {
            BdLog.e(e.getMessage());
        }
        splashStaticHttpRequest.addParam("parammap", jSONObject.toString());
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1003193, com.baidu.tieba.advert.sdk.b.b.apkDownloadUrl());
        tbHttpMessageTask.setMethod(HttpMessageTask.HTTP_METHOD.GET);
        tbHttpMessageTask.setResponsedClass(SplashStaticHttpResponse.class);
        MessageManager.getInstance().sendMessage(splashStaticHttpRequest, tbHttpMessageTask);
    }

    /* loaded from: classes7.dex */
    public static class SplashStaticHttpResponse extends JsonHttpResponsedMessage {
        public SplashStaticHttpResponse(int i) {
            super(i);
        }
    }
}
