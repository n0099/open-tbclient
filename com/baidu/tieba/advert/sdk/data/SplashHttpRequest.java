package com.baidu.tieba.advert.sdk.data;

import android.content.Context;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.adp.framework.task.HttpMessageTask;
import com.baidu.mobads.container.adrequest.IAdRequestParam;
import com.baidu.mobstat.Config;
import com.baidu.tbadk.browser.SearchJsBridge;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.task.TbHttpMessageTask;
import com.baidu.tbadk.util.AdExtParam;
import com.heytap.mcssdk.mode.CommandMessage;
import d.a.o0.t.a.f.d;
import d.a.o0.t.a.i.c;
/* loaded from: classes4.dex */
public class SplashHttpRequest extends HttpMessage {
    public static final TbHttpMessageTask mTask;
    public static final String url = "http://afd.baidu.com/afd/entry";

    static {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_GET_SPLASH_INFO, url);
        mTask = tbHttpMessageTask;
        tbHttpMessageTask.setResponsedClass(SplashHttpResponse.class);
        mTask.setMethod(HttpMessageTask.HTTP_METHOD.POST);
    }

    public SplashHttpRequest(Context context, AdInfo adInfo) {
        super(CmdConfigHttp.CMD_GET_SPLASH_INFO);
        if (adInfo == null || context == null) {
            return;
        }
        addParam("pid", adInfo.placeId);
        addParam("ver", c.b(context));
        addParam("cuid", TbadkCoreApplication.getInst().getCuid());
        addParam(SearchJsBridge.COOKIE_MOD, d.c());
        addParam("ot", 2);
        addParam(SearchJsBridge.COOKIE_OV, d.d());
        addParam(CommandMessage.SDK_VERSION, "1.1.4");
        addParam("nt", d.b(context).intValue());
        addParam(Config.EXCEPTION_CRASH_TYPE, 2);
        addParam("sw", d.f(context).intValue());
        addParam(IAdRequestParam.SCREEN_HEIGHT, d.e(context).intValue());
        addParam("imei", d.a(context));
        addParam("fmt", "json");
        addParam("adw", adInfo.adWidth);
        addParam("adh", adInfo.adHeight);
        addParam("ac", 1);
        addParam("ad_ext_params", AdExtParam.a.b().a());
    }

    public static void sendRequest(SplashHttpRequest splashHttpRequest) {
        MessageManager.getInstance().sendMessage(splashHttpRequest, mTask);
    }
}
