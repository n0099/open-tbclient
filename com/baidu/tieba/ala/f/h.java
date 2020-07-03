package com.baidu.tieba.ala.f;

import com.baidu.live.adp.base.BdBaseModel;
import com.baidu.live.adp.base.BdPageContext;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.listener.HttpMessageListener;
import com.baidu.live.adp.framework.message.HttpMessage;
import com.baidu.live.adp.framework.message.HttpResponsedMessage;
import com.baidu.tieba.ala.message.AlaGetWishListResponseMessage;
import java.util.ArrayList;
/* loaded from: classes3.dex */
public class h extends BdBaseModel {
    private a feU;
    private HttpMessageListener gwK;

    /* loaded from: classes3.dex */
    public interface a {
        void a(ArrayList<com.baidu.tieba.ala.data.c> arrayList, String str, long j);

        void ay(int i, String str);
    }

    public h(BdPageContext<?> bdPageContext, a aVar) {
        super(bdPageContext);
        this.gwK = new HttpMessageListener(1021165) { // from class: com.baidu.tieba.ala.f.h.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1021165 && (httpResponsedMessage instanceof AlaGetWishListResponseMessage)) {
                    AlaGetWishListResponseMessage alaGetWishListResponseMessage = (AlaGetWishListResponseMessage) httpResponsedMessage;
                    if (h.this.feU != null) {
                        if (alaGetWishListResponseMessage.getError() != 0 || !alaGetWishListResponseMessage.isSuccess()) {
                            h.this.feU.ay(alaGetWishListResponseMessage.getError(), alaGetWishListResponseMessage.getErrorString());
                        } else {
                            h.this.feU.a(alaGetWishListResponseMessage.getData(), alaGetWishListResponseMessage.getTips(), alaGetWishListResponseMessage.getSysTime());
                        }
                    }
                }
            }
        };
        this.feU = aVar;
        registerListener(this.gwK);
    }

    public void Dr(String str) {
        HttpMessage httpMessage = new HttpMessage(1021165);
        httpMessage.addParam("anchor_id", str);
        sendMessage(httpMessage);
    }

    public void bKO() {
        sendMessage(new HttpMessage(1021165));
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
        MessageManager.getInstance().unRegisterListener(this.gwK);
    }
}
