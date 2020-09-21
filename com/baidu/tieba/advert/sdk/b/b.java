package com.baidu.tieba.advert.sdk.b;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.advert.sdk.data.AdInfo;
import com.baidu.tieba.advert.sdk.data.SplashHttpRequest;
import com.baidu.tieba.advert.sdk.data.SplashHttpResponse;
/* loaded from: classes22.dex */
public class b {
    private static b fvj = new b();
    private a fvk;
    private final HttpMessageListener fvl = new HttpMessageListener(1003192) { // from class: com.baidu.tieba.advert.sdk.b.b.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage instanceof SplashHttpResponse) {
                SplashHttpResponse splashHttpResponse = (SplashHttpResponse) httpResponsedMessage;
                if (!splashHttpResponse.hasError() && splashHttpResponse.getErrno() == 0) {
                    if (b.this.fvk != null) {
                        b.this.fvk.Eu(splashHttpResponse.getResultMsg());
                        return;
                    }
                    return;
                }
                BdLog.e("Response of splash has error");
                if (b.this.fvk != null) {
                    b.this.fvk.Ev(splashHttpResponse.getResultMsg());
                    return;
                }
                return;
            }
            BdLog.e("Not response of splash request");
        }
    };

    /* loaded from: classes22.dex */
    public interface a {
        void Eu(String str);

        void Ev(String str);
    }

    private b() {
    }

    public static b bDq() {
        return fvj;
    }

    public void a(TbPageContext<?> tbPageContext, a aVar, AdInfo adInfo) {
        this.fvk = aVar;
        this.fvl.setTag(tbPageContext.getUniqueId());
        MessageManager.getInstance().registerListener(this.fvl);
        SplashHttpRequest.sendRequest(new SplashHttpRequest(tbPageContext.getPageActivity(), adInfo));
    }

    public static String bDr() {
        return "http://baichuan.baidu.com/rs/adpmobile/successdisplaystatistics";
    }

    public static String apkDownloadUrl() {
        return "http://baichuan.baidu.com/rs/adpmobile/downloadstatistics";
    }
}
