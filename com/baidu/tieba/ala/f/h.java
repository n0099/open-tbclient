package com.baidu.tieba.ala.f;

import com.baidu.live.adp.base.BdBaseModel;
import com.baidu.live.adp.base.BdPageContext;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.listener.HttpMessageListener;
import com.baidu.live.adp.framework.message.HttpMessage;
import com.baidu.live.adp.framework.message.HttpResponsedMessage;
import com.baidu.live.tbadk.log.LogConfig;
import com.baidu.tieba.ala.message.AlaUpdateWishListResponseMessage;
/* loaded from: classes4.dex */
public class h extends BdBaseModel {
    private c gCe;
    private a gCf;
    private b gCg;
    private HttpMessageListener gCh;
    private HttpMessageListener gCi;
    private HttpMessageListener gCj;

    /* loaded from: classes4.dex */
    public interface a {
        void a(com.baidu.tieba.ala.data.k kVar);

        void ax(int i, String str);
    }

    /* loaded from: classes4.dex */
    public interface b {
        void az(int i, String str);

        void c(com.baidu.tieba.ala.data.k kVar);
    }

    /* loaded from: classes4.dex */
    public interface c {
        void ay(int i, String str);

        void b(com.baidu.tieba.ala.data.k kVar);
    }

    public h(BdPageContext<?> bdPageContext, c cVar, a aVar, b bVar) {
        super(bdPageContext);
        this.gCh = new HttpMessageListener(1021168) { // from class: com.baidu.tieba.ala.f.h.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1021168 && (httpResponsedMessage instanceof AlaUpdateWishListResponseMessage)) {
                    AlaUpdateWishListResponseMessage alaUpdateWishListResponseMessage = (AlaUpdateWishListResponseMessage) httpResponsedMessage;
                    com.baidu.tieba.ala.data.k bNR = alaUpdateWishListResponseMessage.bNR();
                    if (h.this.gCe != null && bNR != null) {
                        if (alaUpdateWishListResponseMessage.getError() != 0 || !alaUpdateWishListResponseMessage.isSuccess()) {
                            h.this.gCe.ay(alaUpdateWishListResponseMessage.getError(), alaUpdateWishListResponseMessage.getErrorString());
                        } else {
                            h.this.gCe.b(bNR);
                        }
                    }
                }
            }
        };
        this.gCi = new HttpMessageListener(1021169) { // from class: com.baidu.tieba.ala.f.h.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1021169 && (httpResponsedMessage instanceof AlaUpdateWishListResponseMessage)) {
                    AlaUpdateWishListResponseMessage alaUpdateWishListResponseMessage = (AlaUpdateWishListResponseMessage) httpResponsedMessage;
                    com.baidu.tieba.ala.data.k bNR = alaUpdateWishListResponseMessage.bNR();
                    if (h.this.gCf != null && bNR != null) {
                        if (alaUpdateWishListResponseMessage.getError() != 0 || !alaUpdateWishListResponseMessage.isSuccess()) {
                            h.this.gCf.ax(alaUpdateWishListResponseMessage.getError(), alaUpdateWishListResponseMessage.getErrorString());
                        } else {
                            h.this.gCf.a(bNR);
                        }
                    }
                }
            }
        };
        this.gCj = new HttpMessageListener(1021170) { // from class: com.baidu.tieba.ala.f.h.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1021170 && (httpResponsedMessage instanceof AlaUpdateWishListResponseMessage)) {
                    AlaUpdateWishListResponseMessage alaUpdateWishListResponseMessage = (AlaUpdateWishListResponseMessage) httpResponsedMessage;
                    com.baidu.tieba.ala.data.k bNR = alaUpdateWishListResponseMessage.bNR();
                    if (h.this.gCg != null && bNR != null) {
                        if (alaUpdateWishListResponseMessage.getError() != 0 || !alaUpdateWishListResponseMessage.isSuccess()) {
                            h.this.gCg.az(alaUpdateWishListResponseMessage.getError(), alaUpdateWishListResponseMessage.getErrorString());
                        } else {
                            h.this.gCg.c(bNR);
                        }
                    }
                }
            }
        };
        this.gCe = cVar;
        this.gCf = aVar;
        this.gCg = bVar;
        registerListener(this.gCh);
        registerListener(this.gCi);
        registerListener(this.gCj);
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

    public void Ee(String str) {
        HttpMessage httpMessage = new HttpMessage(1021169);
        httpMessage.addParam("wish_id", str);
        httpMessage.addParam("status", 2);
        sendMessage(httpMessage);
    }

    public void eb(long j) {
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
        MessageManager.getInstance().unRegisterListener(this.gCh);
    }

    public void bNW() {
        MessageManager.getInstance().unRegisterListener(this.gCi);
    }

    public void bNX() {
        MessageManager.getInstance().unRegisterListener(this.gCj);
    }
}
