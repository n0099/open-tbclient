package com.baidu.tieba.advert.sdk.data;

import android.content.Context;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.adp.framework.task.HttpMessageTask;
import com.baidu.mobads.interfaces.IXAdRequestInfo;
import com.baidu.mobstat.Config;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.task.TbHttpMessageTask;
import com.heytap.mcssdk.mode.CommandMessage;
/* loaded from: classes10.dex */
public class SplashHttpRequest extends HttpMessage {
    private static final String url = "http://afd.baidu.com/afd/entry";
    private static final TbHttpMessageTask mTask = new TbHttpMessageTask(1003192, url);

    static {
        mTask.setResponsedClass(SplashHttpResponse.class);
        mTask.setMethod(HttpMessageTask.HTTP_METHOD.POST);
    }

    public SplashHttpRequest(Context context, AdInfo adInfo) {
        super(1003192);
        if (adInfo != null && context != null) {
            addParam("pid", adInfo.placeId);
            addParam("ver", com.baidu.tieba.advert.sdk.b.c.getAppVersion(context));
            addParam("cuid", TbadkCoreApplication.getInst().getCuid());
            addParam("mod", d.getPhoneModel());
            addParam("ot", 2);
            addParam("ov", d.bqf());
            addParam(CommandMessage.SDK_VERSION, "1.1.4");
            addParam("nt", d.en(context).intValue());
            addParam(Config.EXCEPTION_CRASH_TYPE, 2);
            addParam("sw", d.em(context).intValue());
            addParam(IXAdRequestInfo.SCREEN_HEIGHT, d.el(context).intValue());
            addParam("imei", d.getImei(context));
            addParam("fmt", "json");
            addParam("adw", adInfo.adWidth);
            addParam("adh", adInfo.adHeight);
            addParam("ac", 1);
        }
    }

    public static void sendRequest(SplashHttpRequest splashHttpRequest) {
        MessageManager.getInstance().sendMessage(splashHttpRequest, mTask);
    }
}
