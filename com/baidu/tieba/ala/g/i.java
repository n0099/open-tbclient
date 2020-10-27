package com.baidu.tieba.ala.g;

import com.baidu.live.adp.base.BdBaseModel;
import com.baidu.live.adp.base.BdPageContext;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.listener.HttpMessageListener;
import com.baidu.live.adp.framework.message.HttpMessage;
import com.baidu.live.adp.framework.message.HttpResponsedMessage;
import com.baidu.live.tbadk.log.LogConfig;
import com.baidu.tieba.ala.message.AlaUpdateWishListResponseMessage;
/* loaded from: classes4.dex */
public class i extends BdBaseModel {
    private c hsU;
    private a hsV;
    private b hsW;
    private HttpMessageListener hsX;
    private HttpMessageListener hsY;
    private HttpMessageListener hsZ;

    /* loaded from: classes4.dex */
    public interface a {
        void a(com.baidu.tieba.ala.data.m mVar);

        void aI(int i, String str);
    }

    /* loaded from: classes4.dex */
    public interface b {
        void aK(int i, String str);

        void c(com.baidu.tieba.ala.data.m mVar);
    }

    /* loaded from: classes4.dex */
    public interface c {
        void aJ(int i, String str);

        void b(com.baidu.tieba.ala.data.m mVar);
    }

    public i(BdPageContext<?> bdPageContext, c cVar, a aVar, b bVar) {
        super(bdPageContext);
        this.hsX = new HttpMessageListener(1021168) { // from class: com.baidu.tieba.ala.g.i.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1021168 && (httpResponsedMessage instanceof AlaUpdateWishListResponseMessage)) {
                    AlaUpdateWishListResponseMessage alaUpdateWishListResponseMessage = (AlaUpdateWishListResponseMessage) httpResponsedMessage;
                    com.baidu.tieba.ala.data.m cgc = alaUpdateWishListResponseMessage.cgc();
                    if (i.this.hsU != null && cgc != null) {
                        if (alaUpdateWishListResponseMessage.getError() != 0 || !alaUpdateWishListResponseMessage.isSuccess()) {
                            i.this.hsU.aJ(alaUpdateWishListResponseMessage.getError(), alaUpdateWishListResponseMessage.getErrorString());
                        } else {
                            i.this.hsU.b(cgc);
                        }
                    }
                }
            }
        };
        this.hsY = new HttpMessageListener(1021169) { // from class: com.baidu.tieba.ala.g.i.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1021169 && (httpResponsedMessage instanceof AlaUpdateWishListResponseMessage)) {
                    AlaUpdateWishListResponseMessage alaUpdateWishListResponseMessage = (AlaUpdateWishListResponseMessage) httpResponsedMessage;
                    com.baidu.tieba.ala.data.m cgc = alaUpdateWishListResponseMessage.cgc();
                    if (i.this.hsV != null && cgc != null) {
                        if (alaUpdateWishListResponseMessage.getError() != 0 || !alaUpdateWishListResponseMessage.isSuccess()) {
                            i.this.hsV.aI(alaUpdateWishListResponseMessage.getError(), alaUpdateWishListResponseMessage.getErrorString());
                        } else {
                            i.this.hsV.a(cgc);
                        }
                    }
                }
            }
        };
        this.hsZ = new HttpMessageListener(1021170) { // from class: com.baidu.tieba.ala.g.i.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1021170 && (httpResponsedMessage instanceof AlaUpdateWishListResponseMessage)) {
                    AlaUpdateWishListResponseMessage alaUpdateWishListResponseMessage = (AlaUpdateWishListResponseMessage) httpResponsedMessage;
                    com.baidu.tieba.ala.data.m cgc = alaUpdateWishListResponseMessage.cgc();
                    if (i.this.hsW != null && cgc != null) {
                        if (alaUpdateWishListResponseMessage.getError() != 0 || !alaUpdateWishListResponseMessage.isSuccess()) {
                            i.this.hsW.aK(alaUpdateWishListResponseMessage.getError(), alaUpdateWishListResponseMessage.getErrorString());
                        } else {
                            i.this.hsW.c(cgc);
                        }
                    }
                }
            }
        };
        this.hsU = cVar;
        this.hsV = aVar;
        this.hsW = bVar;
        registerListener(this.hsX);
        registerListener(this.hsY);
        registerListener(this.hsZ);
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

    public void Ik(String str) {
        HttpMessage httpMessage = new HttpMessage(1021169);
        httpMessage.addParam("wish_id", str);
        httpMessage.addParam("status", 2);
        sendMessage(httpMessage);
    }

    public void eJ(long j) {
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
        MessageManager.getInstance().unRegisterListener(this.hsX);
    }

    public void cgk() {
        MessageManager.getInstance().unRegisterListener(this.hsY);
    }

    public void cgl() {
        MessageManager.getInstance().unRegisterListener(this.hsZ);
    }
}
