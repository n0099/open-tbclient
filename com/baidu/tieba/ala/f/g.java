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
    private c gjF;
    private a gjG;
    private b gjH;
    private HttpMessageListener gjI;
    private HttpMessageListener gjJ;
    private HttpMessageListener gjK;

    /* loaded from: classes3.dex */
    public interface a {
        void a(com.baidu.tieba.ala.data.j jVar);

        void at(int i, String str);
    }

    /* loaded from: classes3.dex */
    public interface b {
        void av(int i, String str);

        void c(com.baidu.tieba.ala.data.j jVar);
    }

    /* loaded from: classes3.dex */
    public interface c {
        void au(int i, String str);

        void b(com.baidu.tieba.ala.data.j jVar);
    }

    public g(BdPageContext<?> bdPageContext, c cVar, a aVar, b bVar) {
        super(bdPageContext);
        this.gjI = new HttpMessageListener(1021168) { // from class: com.baidu.tieba.ala.f.g.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1021168 && (httpResponsedMessage instanceof AlaUpdateWishListResponseMessage)) {
                    AlaUpdateWishListResponseMessage alaUpdateWishListResponseMessage = (AlaUpdateWishListResponseMessage) httpResponsedMessage;
                    com.baidu.tieba.ala.data.j bHE = alaUpdateWishListResponseMessage.bHE();
                    if (g.this.gjF != null && bHE != null) {
                        if (alaUpdateWishListResponseMessage.getError() != 0 || !alaUpdateWishListResponseMessage.isSuccess()) {
                            g.this.gjF.au(alaUpdateWishListResponseMessage.getError(), alaUpdateWishListResponseMessage.getErrorString());
                        } else {
                            g.this.gjF.b(bHE);
                        }
                    }
                }
            }
        };
        this.gjJ = new HttpMessageListener(1021169) { // from class: com.baidu.tieba.ala.f.g.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1021169 && (httpResponsedMessage instanceof AlaUpdateWishListResponseMessage)) {
                    AlaUpdateWishListResponseMessage alaUpdateWishListResponseMessage = (AlaUpdateWishListResponseMessage) httpResponsedMessage;
                    com.baidu.tieba.ala.data.j bHE = alaUpdateWishListResponseMessage.bHE();
                    if (g.this.gjG != null && bHE != null) {
                        if (alaUpdateWishListResponseMessage.getError() != 0 || !alaUpdateWishListResponseMessage.isSuccess()) {
                            g.this.gjG.at(alaUpdateWishListResponseMessage.getError(), alaUpdateWishListResponseMessage.getErrorString());
                        } else {
                            g.this.gjG.a(bHE);
                        }
                    }
                }
            }
        };
        this.gjK = new HttpMessageListener(1021170) { // from class: com.baidu.tieba.ala.f.g.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1021170 && (httpResponsedMessage instanceof AlaUpdateWishListResponseMessage)) {
                    AlaUpdateWishListResponseMessage alaUpdateWishListResponseMessage = (AlaUpdateWishListResponseMessage) httpResponsedMessage;
                    com.baidu.tieba.ala.data.j bHE = alaUpdateWishListResponseMessage.bHE();
                    if (g.this.gjH != null && bHE != null) {
                        if (alaUpdateWishListResponseMessage.getError() != 0 || !alaUpdateWishListResponseMessage.isSuccess()) {
                            g.this.gjH.av(alaUpdateWishListResponseMessage.getError(), alaUpdateWishListResponseMessage.getErrorString());
                        } else {
                            g.this.gjH.c(bHE);
                        }
                    }
                }
            }
        };
        this.gjF = cVar;
        this.gjG = aVar;
        this.gjH = bVar;
        registerListener(this.gjI);
        registerListener(this.gjJ);
        registerListener(this.gjK);
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

    public void CR(String str) {
        HttpMessage httpMessage = new HttpMessage(1021169);
        httpMessage.addParam("wish_id", str);
        httpMessage.addParam("status", 2);
        sendMessage(httpMessage);
    }

    public void dL(long j) {
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
        MessageManager.getInstance().unRegisterListener(this.gjI);
    }

    public void bHG() {
        MessageManager.getInstance().unRegisterListener(this.gjJ);
    }

    public void bHH() {
        MessageManager.getInstance().unRegisterListener(this.gjK);
    }
}
