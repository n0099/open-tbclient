package com.baidu.tieba.advert.sdk.b;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.advert.sdk.data.AdInfo;
import com.baidu.tieba.advert.sdk.data.SplashHttpRequest;
import com.baidu.tieba.advert.sdk.data.SplashHttpResponse;
/* loaded from: classes8.dex */
public class b {
    private static b dYx = new b();
    private a dYy;
    private final HttpMessageListener dYz = new HttpMessageListener(1003192) { // from class: com.baidu.tieba.advert.sdk.b.b.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage instanceof SplashHttpResponse) {
                SplashHttpResponse splashHttpResponse = (SplashHttpResponse) httpResponsedMessage;
                if (!splashHttpResponse.hasError() && splashHttpResponse.getErrno() == 0) {
                    if (b.this.dYy != null) {
                        b.this.dYy.xh(splashHttpResponse.getResultMsg());
                        return;
                    }
                    return;
                }
                BdLog.e("Response of splash has error");
                if (b.this.dYy != null) {
                    b.this.dYy.xi(splashHttpResponse.getResultMsg());
                    return;
                }
                return;
            }
            BdLog.e("Not response of splash request");
        }
    };

    /* loaded from: classes8.dex */
    public interface a {
        void xh(String str);

        void xi(String str);
    }

    private b() {
    }

    public static b aWU() {
        return dYx;
    }

    public void a(TbPageContext<?> tbPageContext, a aVar, AdInfo adInfo) {
        this.dYy = aVar;
        this.dYz.setTag(tbPageContext.getUniqueId());
        MessageManager.getInstance().registerListener(this.dYz);
        SplashHttpRequest.sendRequest(new SplashHttpRequest(tbPageContext.getPageActivity(), adInfo));
    }

    public static String aWV() {
        return "http://baichuan.baidu.com/rs/adpmobile/successdisplaystatistics";
    }

    public static String apkDownloadUrl() {
        return "http://baichuan.baidu.com/rs/adpmobile/downloadstatistics";
    }
}
