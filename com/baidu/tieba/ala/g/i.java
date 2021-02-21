package com.baidu.tieba.ala.g;

import com.baidu.live.adp.base.BdBaseModel;
import com.baidu.live.adp.base.BdPageContext;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.listener.HttpMessageListener;
import com.baidu.live.adp.framework.message.HttpMessage;
import com.baidu.live.adp.framework.message.HttpResponsedMessage;
import com.baidu.live.tbadk.log.LogConfig;
import com.baidu.tieba.ala.message.AlaUpdateWishListResponseMessage;
/* loaded from: classes11.dex */
public class i extends BdBaseModel {
    private c hUj;
    private a hUk;
    private b hUl;
    private HttpMessageListener hUm;
    private HttpMessageListener hUn;
    private HttpMessageListener hUo;

    /* loaded from: classes11.dex */
    public interface a {
        void a(com.baidu.tieba.ala.data.m mVar);

        void aS(int i, String str);
    }

    /* loaded from: classes11.dex */
    public interface b {
        void aU(int i, String str);

        void c(com.baidu.tieba.ala.data.m mVar);
    }

    /* loaded from: classes11.dex */
    public interface c {
        void aT(int i, String str);

        void b(com.baidu.tieba.ala.data.m mVar);
    }

    public i(BdPageContext<?> bdPageContext, c cVar, a aVar, b bVar) {
        super(bdPageContext);
        this.hUm = new HttpMessageListener(1021168) { // from class: com.baidu.tieba.ala.g.i.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1021168 && (httpResponsedMessage instanceof AlaUpdateWishListResponseMessage)) {
                    AlaUpdateWishListResponseMessage alaUpdateWishListResponseMessage = (AlaUpdateWishListResponseMessage) httpResponsedMessage;
                    com.baidu.tieba.ala.data.m clY = alaUpdateWishListResponseMessage.clY();
                    if (i.this.hUj != null && clY != null) {
                        if (alaUpdateWishListResponseMessage.getError() != 0 || !alaUpdateWishListResponseMessage.isSuccess()) {
                            i.this.hUj.aT(alaUpdateWishListResponseMessage.getError(), alaUpdateWishListResponseMessage.getErrorString());
                        } else {
                            i.this.hUj.b(clY);
                        }
                    }
                }
            }
        };
        this.hUn = new HttpMessageListener(1021169) { // from class: com.baidu.tieba.ala.g.i.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1021169 && (httpResponsedMessage instanceof AlaUpdateWishListResponseMessage)) {
                    AlaUpdateWishListResponseMessage alaUpdateWishListResponseMessage = (AlaUpdateWishListResponseMessage) httpResponsedMessage;
                    com.baidu.tieba.ala.data.m clY = alaUpdateWishListResponseMessage.clY();
                    if (i.this.hUk != null && clY != null) {
                        if (alaUpdateWishListResponseMessage.getError() != 0 || !alaUpdateWishListResponseMessage.isSuccess()) {
                            i.this.hUk.aS(alaUpdateWishListResponseMessage.getError(), alaUpdateWishListResponseMessage.getErrorString());
                        } else {
                            i.this.hUk.a(clY);
                        }
                    }
                }
            }
        };
        this.hUo = new HttpMessageListener(1021170) { // from class: com.baidu.tieba.ala.g.i.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1021170 && (httpResponsedMessage instanceof AlaUpdateWishListResponseMessage)) {
                    AlaUpdateWishListResponseMessage alaUpdateWishListResponseMessage = (AlaUpdateWishListResponseMessage) httpResponsedMessage;
                    com.baidu.tieba.ala.data.m clY = alaUpdateWishListResponseMessage.clY();
                    if (i.this.hUl != null && clY != null) {
                        if (alaUpdateWishListResponseMessage.getError() != 0 || !alaUpdateWishListResponseMessage.isSuccess()) {
                            i.this.hUl.aU(alaUpdateWishListResponseMessage.getError(), alaUpdateWishListResponseMessage.getErrorString());
                        } else {
                            i.this.hUl.c(clY);
                        }
                    }
                }
            }
        };
        this.hUj = cVar;
        this.hUk = aVar;
        this.hUl = bVar;
        registerListener(this.hUm);
        registerListener(this.hUn);
        registerListener(this.hUo);
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

    public void Ig(String str) {
        HttpMessage httpMessage = new HttpMessage(1021169);
        httpMessage.addParam("wish_id", str);
        httpMessage.addParam("status", 2);
        sendMessage(httpMessage);
    }

    public void fO(long j) {
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
        MessageManager.getInstance().unRegisterListener(this.hUm);
    }

    public void cmf() {
        MessageManager.getInstance().unRegisterListener(this.hUn);
    }

    public void cmg() {
        MessageManager.getInstance().unRegisterListener(this.hUo);
    }
}
