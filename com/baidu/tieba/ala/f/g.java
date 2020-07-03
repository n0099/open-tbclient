package com.baidu.tieba.ala.f;

import com.baidu.live.adp.base.BdBaseModel;
import com.baidu.live.adp.base.BdPageContext;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.listener.HttpMessageListener;
import com.baidu.live.adp.framework.message.HttpMessage;
import com.baidu.live.adp.framework.message.HttpResponsedMessage;
import com.baidu.live.tbadk.log.LogConfig;
import com.baidu.tieba.ala.message.AlaUpdateWishListResponseMessage;
/* loaded from: classes3.dex */
public class g extends BdBaseModel {
    private c gwD;
    private a gwE;
    private b gwF;
    private HttpMessageListener gwG;
    private HttpMessageListener gwH;
    private HttpMessageListener gwI;

    /* loaded from: classes3.dex */
    public interface a {
        void a(com.baidu.tieba.ala.data.j jVar);

        void av(int i, String str);
    }

    /* loaded from: classes3.dex */
    public interface b {
        void ax(int i, String str);

        void c(com.baidu.tieba.ala.data.j jVar);
    }

    /* loaded from: classes3.dex */
    public interface c {
        void aw(int i, String str);

        void b(com.baidu.tieba.ala.data.j jVar);
    }

    public g(BdPageContext<?> bdPageContext, c cVar, a aVar, b bVar) {
        super(bdPageContext);
        this.gwG = new HttpMessageListener(1021168) { // from class: com.baidu.tieba.ala.f.g.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1021168 && (httpResponsedMessage instanceof AlaUpdateWishListResponseMessage)) {
                    AlaUpdateWishListResponseMessage alaUpdateWishListResponseMessage = (AlaUpdateWishListResponseMessage) httpResponsedMessage;
                    com.baidu.tieba.ala.data.j bKK = alaUpdateWishListResponseMessage.bKK();
                    if (g.this.gwD != null && bKK != null) {
                        if (alaUpdateWishListResponseMessage.getError() != 0 || !alaUpdateWishListResponseMessage.isSuccess()) {
                            g.this.gwD.aw(alaUpdateWishListResponseMessage.getError(), alaUpdateWishListResponseMessage.getErrorString());
                        } else {
                            g.this.gwD.b(bKK);
                        }
                    }
                }
            }
        };
        this.gwH = new HttpMessageListener(1021169) { // from class: com.baidu.tieba.ala.f.g.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1021169 && (httpResponsedMessage instanceof AlaUpdateWishListResponseMessage)) {
                    AlaUpdateWishListResponseMessage alaUpdateWishListResponseMessage = (AlaUpdateWishListResponseMessage) httpResponsedMessage;
                    com.baidu.tieba.ala.data.j bKK = alaUpdateWishListResponseMessage.bKK();
                    if (g.this.gwE != null && bKK != null) {
                        if (alaUpdateWishListResponseMessage.getError() != 0 || !alaUpdateWishListResponseMessage.isSuccess()) {
                            g.this.gwE.av(alaUpdateWishListResponseMessage.getError(), alaUpdateWishListResponseMessage.getErrorString());
                        } else {
                            g.this.gwE.a(bKK);
                        }
                    }
                }
            }
        };
        this.gwI = new HttpMessageListener(1021170) { // from class: com.baidu.tieba.ala.f.g.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1021170 && (httpResponsedMessage instanceof AlaUpdateWishListResponseMessage)) {
                    AlaUpdateWishListResponseMessage alaUpdateWishListResponseMessage = (AlaUpdateWishListResponseMessage) httpResponsedMessage;
                    com.baidu.tieba.ala.data.j bKK = alaUpdateWishListResponseMessage.bKK();
                    if (g.this.gwF != null && bKK != null) {
                        if (alaUpdateWishListResponseMessage.getError() != 0 || !alaUpdateWishListResponseMessage.isSuccess()) {
                            g.this.gwF.ax(alaUpdateWishListResponseMessage.getError(), alaUpdateWishListResponseMessage.getErrorString());
                        } else {
                            g.this.gwF.c(bKK);
                        }
                    }
                }
            }
        };
        this.gwD = cVar;
        this.gwE = aVar;
        this.gwF = bVar;
        registerListener(this.gwG);
        registerListener(this.gwH);
        registerListener(this.gwI);
    }

    public void b(String str, String str2, String str3, int i, int i2) {
        HttpMessage httpMessage = new HttpMessage(1021168);
        httpMessage.addParam("wish_id", str);
        httpMessage.addParam(LogConfig.LOG_GIFT_ID, str2);
        httpMessage.addParam("desc", str3);
        httpMessage.addParam("expire_hour", i);
        httpMessage.addParam("finish_num", i2);
        httpMessage.addParam("status", 1);
        sendMessage(httpMessage);
    }

    public void Ds(String str) {
        HttpMessage httpMessage = new HttpMessage(1021169);
        httpMessage.addParam("wish_id", str);
        httpMessage.addParam("status", 2);
        sendMessage(httpMessage);
    }

    public void dO(long j) {
        HttpMessage httpMessage = new HttpMessage(1021170);
        httpMessage.addParam("live_id", j);
        httpMessage.addParam("status", 3);
        sendMessage(httpMessage);
    }

    @Override // com.baidu.live.adp.base.BdBaseModel
    protected boolean loadData() {
        return false;
    }

    @Override // com.baidu.live.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        return false;
    }

    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.gwG);
    }

    public void bKM() {
        MessageManager.getInstance().unRegisterListener(this.gwH);
    }

    public void bKN() {
        MessageManager.getInstance().unRegisterListener(this.gwI);
    }
}
