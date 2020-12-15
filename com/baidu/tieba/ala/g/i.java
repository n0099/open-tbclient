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
    private c hIf;
    private a hIg;
    private b hIh;
    private HttpMessageListener hIi;
    private HttpMessageListener hIj;
    private HttpMessageListener hIk;

    /* loaded from: classes4.dex */
    public interface a {
        void a(com.baidu.tieba.ala.data.m mVar);

        void aK(int i, String str);
    }

    /* loaded from: classes4.dex */
    public interface b {
        void aM(int i, String str);

        void c(com.baidu.tieba.ala.data.m mVar);
    }

    /* loaded from: classes4.dex */
    public interface c {
        void aL(int i, String str);

        void b(com.baidu.tieba.ala.data.m mVar);
    }

    public i(BdPageContext<?> bdPageContext, c cVar, a aVar, b bVar) {
        super(bdPageContext);
        this.hIi = new HttpMessageListener(1021168) { // from class: com.baidu.tieba.ala.g.i.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1021168 && (httpResponsedMessage instanceof AlaUpdateWishListResponseMessage)) {
                    AlaUpdateWishListResponseMessage alaUpdateWishListResponseMessage = (AlaUpdateWishListResponseMessage) httpResponsedMessage;
                    com.baidu.tieba.ala.data.m clT = alaUpdateWishListResponseMessage.clT();
                    if (i.this.hIf != null && clT != null) {
                        if (alaUpdateWishListResponseMessage.getError() != 0 || !alaUpdateWishListResponseMessage.isSuccess()) {
                            i.this.hIf.aL(alaUpdateWishListResponseMessage.getError(), alaUpdateWishListResponseMessage.getErrorString());
                        } else {
                            i.this.hIf.b(clT);
                        }
                    }
                }
            }
        };
        this.hIj = new HttpMessageListener(1021169) { // from class: com.baidu.tieba.ala.g.i.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1021169 && (httpResponsedMessage instanceof AlaUpdateWishListResponseMessage)) {
                    AlaUpdateWishListResponseMessage alaUpdateWishListResponseMessage = (AlaUpdateWishListResponseMessage) httpResponsedMessage;
                    com.baidu.tieba.ala.data.m clT = alaUpdateWishListResponseMessage.clT();
                    if (i.this.hIg != null && clT != null) {
                        if (alaUpdateWishListResponseMessage.getError() != 0 || !alaUpdateWishListResponseMessage.isSuccess()) {
                            i.this.hIg.aK(alaUpdateWishListResponseMessage.getError(), alaUpdateWishListResponseMessage.getErrorString());
                        } else {
                            i.this.hIg.a(clT);
                        }
                    }
                }
            }
        };
        this.hIk = new HttpMessageListener(1021170) { // from class: com.baidu.tieba.ala.g.i.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1021170 && (httpResponsedMessage instanceof AlaUpdateWishListResponseMessage)) {
                    AlaUpdateWishListResponseMessage alaUpdateWishListResponseMessage = (AlaUpdateWishListResponseMessage) httpResponsedMessage;
                    com.baidu.tieba.ala.data.m clT = alaUpdateWishListResponseMessage.clT();
                    if (i.this.hIh != null && clT != null) {
                        if (alaUpdateWishListResponseMessage.getError() != 0 || !alaUpdateWishListResponseMessage.isSuccess()) {
                            i.this.hIh.aM(alaUpdateWishListResponseMessage.getError(), alaUpdateWishListResponseMessage.getErrorString());
                        } else {
                            i.this.hIh.c(clT);
                        }
                    }
                }
            }
        };
        this.hIf = cVar;
        this.hIg = aVar;
        this.hIh = bVar;
        registerListener(this.hIi);
        registerListener(this.hIj);
        registerListener(this.hIk);
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

    public void IR(String str) {
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
        MessageManager.getInstance().unRegisterListener(this.hIi);
    }

    public void cma() {
        MessageManager.getInstance().unRegisterListener(this.hIj);
    }

    public void cmb() {
        MessageManager.getInstance().unRegisterListener(this.hIk);
    }
}
