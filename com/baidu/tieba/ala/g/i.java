package com.baidu.tieba.ala.g;

import com.baidu.live.adp.base.BdBaseModel;
import com.baidu.live.adp.base.BdPageContext;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.listener.HttpMessageListener;
import com.baidu.live.adp.framework.message.HttpMessage;
import com.baidu.live.adp.framework.message.HttpResponsedMessage;
import com.baidu.live.tbadk.log.LogConfig;
import com.baidu.tieba.ala.message.AlaUpdateWishListResponseMessage;
/* loaded from: classes10.dex */
public class i extends BdBaseModel {
    private a hPA;
    private b hPB;
    private HttpMessageListener hPC;
    private HttpMessageListener hPD;
    private HttpMessageListener hPE;
    private c hPz;

    /* loaded from: classes10.dex */
    public interface a {
        void a(com.baidu.tieba.ala.data.m mVar);

        void aN(int i, String str);
    }

    /* loaded from: classes10.dex */
    public interface b {
        void aP(int i, String str);

        void c(com.baidu.tieba.ala.data.m mVar);
    }

    /* loaded from: classes10.dex */
    public interface c {
        void aO(int i, String str);

        void b(com.baidu.tieba.ala.data.m mVar);
    }

    public i(BdPageContext<?> bdPageContext, c cVar, a aVar, b bVar) {
        super(bdPageContext);
        this.hPC = new HttpMessageListener(1021168) { // from class: com.baidu.tieba.ala.g.i.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1021168 && (httpResponsedMessage instanceof AlaUpdateWishListResponseMessage)) {
                    AlaUpdateWishListResponseMessage alaUpdateWishListResponseMessage = (AlaUpdateWishListResponseMessage) httpResponsedMessage;
                    com.baidu.tieba.ala.data.m ckT = alaUpdateWishListResponseMessage.ckT();
                    if (i.this.hPz != null && ckT != null) {
                        if (alaUpdateWishListResponseMessage.getError() != 0 || !alaUpdateWishListResponseMessage.isSuccess()) {
                            i.this.hPz.aO(alaUpdateWishListResponseMessage.getError(), alaUpdateWishListResponseMessage.getErrorString());
                        } else {
                            i.this.hPz.b(ckT);
                        }
                    }
                }
            }
        };
        this.hPD = new HttpMessageListener(1021169) { // from class: com.baidu.tieba.ala.g.i.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1021169 && (httpResponsedMessage instanceof AlaUpdateWishListResponseMessage)) {
                    AlaUpdateWishListResponseMessage alaUpdateWishListResponseMessage = (AlaUpdateWishListResponseMessage) httpResponsedMessage;
                    com.baidu.tieba.ala.data.m ckT = alaUpdateWishListResponseMessage.ckT();
                    if (i.this.hPA != null && ckT != null) {
                        if (alaUpdateWishListResponseMessage.getError() != 0 || !alaUpdateWishListResponseMessage.isSuccess()) {
                            i.this.hPA.aN(alaUpdateWishListResponseMessage.getError(), alaUpdateWishListResponseMessage.getErrorString());
                        } else {
                            i.this.hPA.a(ckT);
                        }
                    }
                }
            }
        };
        this.hPE = new HttpMessageListener(1021170) { // from class: com.baidu.tieba.ala.g.i.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1021170 && (httpResponsedMessage instanceof AlaUpdateWishListResponseMessage)) {
                    AlaUpdateWishListResponseMessage alaUpdateWishListResponseMessage = (AlaUpdateWishListResponseMessage) httpResponsedMessage;
                    com.baidu.tieba.ala.data.m ckT = alaUpdateWishListResponseMessage.ckT();
                    if (i.this.hPB != null && ckT != null) {
                        if (alaUpdateWishListResponseMessage.getError() != 0 || !alaUpdateWishListResponseMessage.isSuccess()) {
                            i.this.hPB.aP(alaUpdateWishListResponseMessage.getError(), alaUpdateWishListResponseMessage.getErrorString());
                        } else {
                            i.this.hPB.c(ckT);
                        }
                    }
                }
            }
        };
        this.hPz = cVar;
        this.hPA = aVar;
        this.hPB = bVar;
        registerListener(this.hPC);
        registerListener(this.hPD);
        registerListener(this.hPE);
    }

    public void c(String str, String str2, String str3, int i, int i2) {
        HttpMessage httpMessage = new HttpMessage(1021168);
        httpMessage.addParam("wish_id", str);
        httpMessage.addParam(LogConfig.LOG_GIFT_ID, str2);
        httpMessage.addParam("desc", str3);
        httpMessage.addParam("expire_hour", i);
        httpMessage.addParam("finish_num", i2);
        httpMessage.addParam("status", 1);
        sendMessage(httpMessage);
    }

    public void HB(String str) {
        HttpMessage httpMessage = new HttpMessage(1021169);
        httpMessage.addParam("wish_id", str);
        httpMessage.addParam("status", 2);
        sendMessage(httpMessage);
    }

    public void fJ(long j) {
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
        MessageManager.getInstance().unRegisterListener(this.hPC);
    }

    public void cla() {
        MessageManager.getInstance().unRegisterListener(this.hPD);
    }

    public void clb() {
        MessageManager.getInstance().unRegisterListener(this.hPE);
    }
}
