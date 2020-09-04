package com.baidu.tieba.ala.f;

import com.baidu.live.adp.base.BdBaseModel;
import com.baidu.live.adp.base.BdPageContext;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.listener.HttpMessageListener;
import com.baidu.live.adp.framework.message.HttpMessage;
import com.baidu.live.adp.framework.message.HttpResponsedMessage;
import com.baidu.live.tbadk.log.LogConfig;
import com.baidu.tieba.ala.message.AlaUpdateWishListResponseMessage;
/* loaded from: classes7.dex */
public class h extends BdBaseModel {
    private c gOF;
    private a gOG;
    private b gOH;
    private HttpMessageListener gOI;
    private HttpMessageListener gOJ;
    private HttpMessageListener gOK;

    /* loaded from: classes7.dex */
    public interface a {
        void a(com.baidu.tieba.ala.data.k kVar);

        void au(int i, String str);
    }

    /* loaded from: classes7.dex */
    public interface b {
        void aw(int i, String str);

        void c(com.baidu.tieba.ala.data.k kVar);
    }

    /* loaded from: classes7.dex */
    public interface c {
        void av(int i, String str);

        void b(com.baidu.tieba.ala.data.k kVar);
    }

    public h(BdPageContext<?> bdPageContext, c cVar, a aVar, b bVar) {
        super(bdPageContext);
        this.gOI = new HttpMessageListener(1021168) { // from class: com.baidu.tieba.ala.f.h.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1021168 && (httpResponsedMessage instanceof AlaUpdateWishListResponseMessage)) {
                    AlaUpdateWishListResponseMessage alaUpdateWishListResponseMessage = (AlaUpdateWishListResponseMessage) httpResponsedMessage;
                    com.baidu.tieba.ala.data.k bXS = alaUpdateWishListResponseMessage.bXS();
                    if (h.this.gOF != null && bXS != null) {
                        if (alaUpdateWishListResponseMessage.getError() != 0 || !alaUpdateWishListResponseMessage.isSuccess()) {
                            h.this.gOF.av(alaUpdateWishListResponseMessage.getError(), alaUpdateWishListResponseMessage.getErrorString());
                        } else {
                            h.this.gOF.b(bXS);
                        }
                    }
                }
            }
        };
        this.gOJ = new HttpMessageListener(1021169) { // from class: com.baidu.tieba.ala.f.h.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1021169 && (httpResponsedMessage instanceof AlaUpdateWishListResponseMessage)) {
                    AlaUpdateWishListResponseMessage alaUpdateWishListResponseMessage = (AlaUpdateWishListResponseMessage) httpResponsedMessage;
                    com.baidu.tieba.ala.data.k bXS = alaUpdateWishListResponseMessage.bXS();
                    if (h.this.gOG != null && bXS != null) {
                        if (alaUpdateWishListResponseMessage.getError() != 0 || !alaUpdateWishListResponseMessage.isSuccess()) {
                            h.this.gOG.au(alaUpdateWishListResponseMessage.getError(), alaUpdateWishListResponseMessage.getErrorString());
                        } else {
                            h.this.gOG.a(bXS);
                        }
                    }
                }
            }
        };
        this.gOK = new HttpMessageListener(1021170) { // from class: com.baidu.tieba.ala.f.h.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1021170 && (httpResponsedMessage instanceof AlaUpdateWishListResponseMessage)) {
                    AlaUpdateWishListResponseMessage alaUpdateWishListResponseMessage = (AlaUpdateWishListResponseMessage) httpResponsedMessage;
                    com.baidu.tieba.ala.data.k bXS = alaUpdateWishListResponseMessage.bXS();
                    if (h.this.gOH != null && bXS != null) {
                        if (alaUpdateWishListResponseMessage.getError() != 0 || !alaUpdateWishListResponseMessage.isSuccess()) {
                            h.this.gOH.aw(alaUpdateWishListResponseMessage.getError(), alaUpdateWishListResponseMessage.getErrorString());
                        } else {
                            h.this.gOH.c(bXS);
                        }
                    }
                }
            }
        };
        this.gOF = cVar;
        this.gOG = aVar;
        this.gOH = bVar;
        registerListener(this.gOI);
        registerListener(this.gOJ);
        registerListener(this.gOK);
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

    public void GE(String str) {
        HttpMessage httpMessage = new HttpMessage(1021169);
        httpMessage.addParam("wish_id", str);
        httpMessage.addParam("status", 2);
        sendMessage(httpMessage);
    }

    public void em(long j) {
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
        MessageManager.getInstance().unRegisterListener(this.gOI);
    }

    public void bXX() {
        MessageManager.getInstance().unRegisterListener(this.gOJ);
    }

    public void bXY() {
        MessageManager.getInstance().unRegisterListener(this.gOK);
    }
}
