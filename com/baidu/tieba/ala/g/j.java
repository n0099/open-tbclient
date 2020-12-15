package com.baidu.tieba.ala.g;

import com.baidu.live.adp.base.BdBaseModel;
import com.baidu.live.adp.base.BdPageContext;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.listener.HttpMessageListener;
import com.baidu.live.adp.framework.message.HttpMessage;
import com.baidu.live.adp.framework.message.HttpResponsedMessage;
import com.baidu.tieba.ala.message.AlaGetWishListResponseMessage;
import java.util.ArrayList;
/* loaded from: classes4.dex */
public class j extends BdBaseModel {
    private a ggS;
    private HttpMessageListener hIm;

    /* loaded from: classes4.dex */
    public interface a {
        void a(ArrayList<com.baidu.tieba.ala.data.d> arrayList, String str, long j);

        void aN(int i, String str);
    }

    public j(BdPageContext<?> bdPageContext, a aVar) {
        super(bdPageContext);
        this.hIm = new HttpMessageListener(1021165) { // from class: com.baidu.tieba.ala.g.j.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1021165 && (httpResponsedMessage instanceof AlaGetWishListResponseMessage)) {
                    AlaGetWishListResponseMessage alaGetWishListResponseMessage = (AlaGetWishListResponseMessage) httpResponsedMessage;
                    if (j.this.ggS != null) {
                        if (alaGetWishListResponseMessage.getError() != 0 || !alaGetWishListResponseMessage.isSuccess()) {
                            j.this.ggS.aN(alaGetWishListResponseMessage.getError(), alaGetWishListResponseMessage.getErrorString());
                        } else {
                            j.this.ggS.a(alaGetWishListResponseMessage.getData(), alaGetWishListResponseMessage.getTips(), alaGetWishListResponseMessage.getSysTime());
                        }
                    }
                }
            }
        };
        this.ggS = aVar;
        registerListener(this.hIm);
    }

    public void IQ(String str) {
        HttpMessage httpMessage = new HttpMessage(1021165);
        httpMessage.addParam("anchor_id", str);
        sendMessage(httpMessage);
    }

    public void cmc() {
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
        MessageManager.getInstance().unRegisterListener(this.hIm);
    }
}
