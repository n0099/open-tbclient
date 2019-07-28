package com.baidu.tieba.advert.sdk.b;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tieba.advert.sdk.data.AdInfo;
import com.baidu.tieba.advert.sdk.data.SplashHttpRequest;
import com.baidu.tieba.advert.sdk.data.SplashHttpResponse;
/* loaded from: classes5.dex */
public class b {
    private static b dak = new b();
    private a dal;
    private final HttpMessageListener dam = new HttpMessageListener(CmdConfigHttp.CMD_GET_SPLASH_INFO) { // from class: com.baidu.tieba.advert.sdk.b.b.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage instanceof SplashHttpResponse) {
                SplashHttpResponse splashHttpResponse = (SplashHttpResponse) httpResponsedMessage;
                if (!splashHttpResponse.hasError() && splashHttpResponse.getErrno() == 0) {
                    if (b.this.dal != null) {
                        b.this.dal.sP(splashHttpResponse.getResultMsg());
                        return;
                    }
                    return;
                }
                BdLog.e("Response of splash has error");
                if (b.this.dal != null) {
                    b.this.dal.sQ(splashHttpResponse.getResultMsg());
                    return;
                }
                return;
            }
            BdLog.e("Not response of splash request");
        }
    };

    /* loaded from: classes5.dex */
    public interface a {
        void sP(String str);

        void sQ(String str);
    }

    private b() {
    }

    public static b aDU() {
        return dak;
    }

    public void a(TbPageContext<?> tbPageContext, a aVar, AdInfo adInfo) {
        this.dal = aVar;
        this.dam.setTag(tbPageContext.getUniqueId());
        MessageManager.getInstance().registerListener(this.dam);
        SplashHttpRequest.sendRequest(new SplashHttpRequest(tbPageContext.getPageActivity(), adInfo));
    }

    public static String aDV() {
        return "http://baichuan.baidu.com/rs/adpmobile/successdisplaystatistics";
    }

    public static String apkDownloadUrl() {
        return "http://baichuan.baidu.com/rs/adpmobile/downloadstatistics";
    }
}
