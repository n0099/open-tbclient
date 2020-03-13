package com.baidu.tieba.ala.e;

import com.baidu.live.adp.base.BdBaseModel;
import com.baidu.live.adp.base.BdPageContext;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.listener.HttpMessageListener;
import com.baidu.live.adp.framework.message.HttpMessage;
import com.baidu.live.adp.framework.message.HttpResponsedMessage;
import com.baidu.live.adp.framework.task.HttpMessageTask;
import com.baidu.live.tbadk.TbConfig;
import com.baidu.live.tbadk.log.LogConfig;
import com.baidu.live.tbadk.task.TbHttpMessageTask;
import com.baidu.tieba.ala.message.AlaUpdateWishListResponseMessage;
/* loaded from: classes3.dex */
public class g extends BdBaseModel {
    private c fpN;
    private a fpO;
    private b fpP;
    private HttpMessageListener fpQ;
    private HttpMessageListener fpR;
    private HttpMessageListener fpS;

    /* loaded from: classes3.dex */
    public interface a {
        void Z(int i, String str);

        void a(com.baidu.tieba.ala.data.j jVar);
    }

    /* loaded from: classes3.dex */
    public interface b {
        void ab(int i, String str);

        void c(com.baidu.tieba.ala.data.j jVar);
    }

    /* loaded from: classes3.dex */
    public interface c {
        void aa(int i, String str);

        void b(com.baidu.tieba.ala.data.j jVar);
    }

    public g(BdPageContext<?> bdPageContext, c cVar, a aVar, b bVar) {
        super(bdPageContext);
        this.fpQ = new HttpMessageListener(1021168) { // from class: com.baidu.tieba.ala.e.g.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1021168 && (httpResponsedMessage instanceof AlaUpdateWishListResponseMessage)) {
                    AlaUpdateWishListResponseMessage alaUpdateWishListResponseMessage = (AlaUpdateWishListResponseMessage) httpResponsedMessage;
                    com.baidu.tieba.ala.data.j brE = alaUpdateWishListResponseMessage.brE();
                    if (g.this.fpN != null && brE != null) {
                        if (alaUpdateWishListResponseMessage.getError() != 0 || !alaUpdateWishListResponseMessage.isSuccess()) {
                            g.this.fpN.aa(alaUpdateWishListResponseMessage.getError(), alaUpdateWishListResponseMessage.getErrorString());
                        } else {
                            g.this.fpN.b(brE);
                        }
                    }
                }
            }
        };
        this.fpR = new HttpMessageListener(1021169) { // from class: com.baidu.tieba.ala.e.g.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1021169 && (httpResponsedMessage instanceof AlaUpdateWishListResponseMessage)) {
                    AlaUpdateWishListResponseMessage alaUpdateWishListResponseMessage = (AlaUpdateWishListResponseMessage) httpResponsedMessage;
                    com.baidu.tieba.ala.data.j brE = alaUpdateWishListResponseMessage.brE();
                    if (g.this.fpO != null && brE != null) {
                        if (alaUpdateWishListResponseMessage.getError() != 0 || !alaUpdateWishListResponseMessage.isSuccess()) {
                            g.this.fpO.Z(alaUpdateWishListResponseMessage.getError(), alaUpdateWishListResponseMessage.getErrorString());
                        } else {
                            g.this.fpO.a(brE);
                        }
                    }
                }
            }
        };
        this.fpS = new HttpMessageListener(1021170) { // from class: com.baidu.tieba.ala.e.g.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1021170 && (httpResponsedMessage instanceof AlaUpdateWishListResponseMessage)) {
                    AlaUpdateWishListResponseMessage alaUpdateWishListResponseMessage = (AlaUpdateWishListResponseMessage) httpResponsedMessage;
                    com.baidu.tieba.ala.data.j brE = alaUpdateWishListResponseMessage.brE();
                    if (g.this.fpP != null && brE != null) {
                        if (alaUpdateWishListResponseMessage.getError() != 0 || !alaUpdateWishListResponseMessage.isSuccess()) {
                            g.this.fpP.ab(alaUpdateWishListResponseMessage.getError(), alaUpdateWishListResponseMessage.getErrorString());
                        } else {
                            g.this.fpP.c(brE);
                        }
                    }
                }
            }
        };
        this.fpN = cVar;
        this.fpO = aVar;
        this.fpP = bVar;
        brG();
        brH();
        brI();
        registerListener(this.fpQ);
        registerListener(this.fpR);
        registerListener(this.fpS);
    }

    private void brG() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1021168, TbConfig.SERVER_HOST + "liveserver/wishlist/updatewishlist");
        tbHttpMessageTask.setIsNeedLogin(true);
        tbHttpMessageTask.setIsNeedTbs(true);
        tbHttpMessageTask.setIsUseCurrentBDUSS(true);
        tbHttpMessageTask.setMethod(HttpMessageTask.HTTP_METHOD.GET);
        tbHttpMessageTask.setResponsedClass(AlaUpdateWishListResponseMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
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

    private void brH() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1021169, TbConfig.SERVER_HOST + "liveserver/wishlist/updatewishlist");
        tbHttpMessageTask.setIsNeedLogin(true);
        tbHttpMessageTask.setIsNeedTbs(true);
        tbHttpMessageTask.setIsUseCurrentBDUSS(true);
        tbHttpMessageTask.setMethod(HttpMessageTask.HTTP_METHOD.GET);
        tbHttpMessageTask.setResponsedClass(AlaUpdateWishListResponseMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    public void zA(String str) {
        HttpMessage httpMessage = new HttpMessage(1021169);
        httpMessage.addParam("wish_id", str);
        httpMessage.addParam("status", 2);
        sendMessage(httpMessage);
    }

    private void brI() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1021170, TbConfig.SERVER_HOST + "liveserver/wishlist/updatewishlist");
        tbHttpMessageTask.setIsNeedLogin(true);
        tbHttpMessageTask.setIsNeedTbs(true);
        tbHttpMessageTask.setIsUseCurrentBDUSS(true);
        tbHttpMessageTask.setMethod(HttpMessageTask.HTTP_METHOD.GET);
        tbHttpMessageTask.setResponsedClass(AlaUpdateWishListResponseMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    public void dc(long j) {
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
        MessageManager.getInstance().unRegisterListener(this.fpQ);
        MessageManager.getInstance().unRegisterTask(1021168);
    }

    public void brJ() {
        MessageManager.getInstance().unRegisterListener(this.fpR);
        MessageManager.getInstance().unRegisterTask(1021169);
    }

    public void brK() {
        MessageManager.getInstance().unRegisterListener(this.fpS);
        MessageManager.getInstance().unRegisterTask(1021170);
    }
}
