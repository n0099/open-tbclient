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
/* loaded from: classes2.dex */
public class g extends BdBaseModel {
    private c fmV;
    private a fmW;
    private b fmX;
    private HttpMessageListener fmY;
    private HttpMessageListener fmZ;
    private HttpMessageListener fna;

    /* loaded from: classes2.dex */
    public interface a {
        void Y(int i, String str);

        void a(com.baidu.tieba.ala.data.j jVar);
    }

    /* loaded from: classes2.dex */
    public interface b {
        void aa(int i, String str);

        void c(com.baidu.tieba.ala.data.j jVar);
    }

    /* loaded from: classes2.dex */
    public interface c {
        void Z(int i, String str);

        void b(com.baidu.tieba.ala.data.j jVar);
    }

    public g(BdPageContext<?> bdPageContext, c cVar, a aVar, b bVar) {
        super(bdPageContext);
        this.fmY = new HttpMessageListener(1021168) { // from class: com.baidu.tieba.ala.e.g.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1021168 && (httpResponsedMessage instanceof AlaUpdateWishListResponseMessage)) {
                    AlaUpdateWishListResponseMessage alaUpdateWishListResponseMessage = (AlaUpdateWishListResponseMessage) httpResponsedMessage;
                    com.baidu.tieba.ala.data.j bpX = alaUpdateWishListResponseMessage.bpX();
                    if (g.this.fmV != null && bpX != null) {
                        if (alaUpdateWishListResponseMessage.getError() != 0 || !alaUpdateWishListResponseMessage.isSuccess()) {
                            g.this.fmV.Z(alaUpdateWishListResponseMessage.getError(), alaUpdateWishListResponseMessage.getErrorString());
                        } else {
                            g.this.fmV.b(bpX);
                        }
                    }
                }
            }
        };
        this.fmZ = new HttpMessageListener(1021169) { // from class: com.baidu.tieba.ala.e.g.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1021169 && (httpResponsedMessage instanceof AlaUpdateWishListResponseMessage)) {
                    AlaUpdateWishListResponseMessage alaUpdateWishListResponseMessage = (AlaUpdateWishListResponseMessage) httpResponsedMessage;
                    com.baidu.tieba.ala.data.j bpX = alaUpdateWishListResponseMessage.bpX();
                    if (g.this.fmW != null && bpX != null) {
                        if (alaUpdateWishListResponseMessage.getError() != 0 || !alaUpdateWishListResponseMessage.isSuccess()) {
                            g.this.fmW.Y(alaUpdateWishListResponseMessage.getError(), alaUpdateWishListResponseMessage.getErrorString());
                        } else {
                            g.this.fmW.a(bpX);
                        }
                    }
                }
            }
        };
        this.fna = new HttpMessageListener(1021170) { // from class: com.baidu.tieba.ala.e.g.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1021170 && (httpResponsedMessage instanceof AlaUpdateWishListResponseMessage)) {
                    AlaUpdateWishListResponseMessage alaUpdateWishListResponseMessage = (AlaUpdateWishListResponseMessage) httpResponsedMessage;
                    com.baidu.tieba.ala.data.j bpX = alaUpdateWishListResponseMessage.bpX();
                    if (g.this.fmX != null && bpX != null) {
                        if (alaUpdateWishListResponseMessage.getError() != 0 || !alaUpdateWishListResponseMessage.isSuccess()) {
                            g.this.fmX.aa(alaUpdateWishListResponseMessage.getError(), alaUpdateWishListResponseMessage.getErrorString());
                        } else {
                            g.this.fmX.c(bpX);
                        }
                    }
                }
            }
        };
        this.fmV = cVar;
        this.fmW = aVar;
        this.fmX = bVar;
        bpZ();
        bqa();
        bqb();
        registerListener(this.fmY);
        registerListener(this.fmZ);
        registerListener(this.fna);
    }

    private void bpZ() {
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

    private void bqa() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1021169, TbConfig.SERVER_HOST + "liveserver/wishlist/updatewishlist");
        tbHttpMessageTask.setIsNeedLogin(true);
        tbHttpMessageTask.setIsNeedTbs(true);
        tbHttpMessageTask.setIsUseCurrentBDUSS(true);
        tbHttpMessageTask.setMethod(HttpMessageTask.HTTP_METHOD.GET);
        tbHttpMessageTask.setResponsedClass(AlaUpdateWishListResponseMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    public void zh(String str) {
        HttpMessage httpMessage = new HttpMessage(1021169);
        httpMessage.addParam("wish_id", str);
        httpMessage.addParam("status", 2);
        sendMessage(httpMessage);
    }

    private void bqb() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1021170, TbConfig.SERVER_HOST + "liveserver/wishlist/updatewishlist");
        tbHttpMessageTask.setIsNeedLogin(true);
        tbHttpMessageTask.setIsNeedTbs(true);
        tbHttpMessageTask.setIsUseCurrentBDUSS(true);
        tbHttpMessageTask.setMethod(HttpMessageTask.HTTP_METHOD.GET);
        tbHttpMessageTask.setResponsedClass(AlaUpdateWishListResponseMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    public void da(long j) {
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
        MessageManager.getInstance().unRegisterListener(this.fmY);
        MessageManager.getInstance().unRegisterTask(1021168);
    }

    public void bqc() {
        MessageManager.getInstance().unRegisterListener(this.fmZ);
        MessageManager.getInstance().unRegisterTask(1021169);
    }

    public void bqd() {
        MessageManager.getInstance().unRegisterListener(this.fna);
        MessageManager.getInstance().unRegisterTask(1021170);
    }
}
