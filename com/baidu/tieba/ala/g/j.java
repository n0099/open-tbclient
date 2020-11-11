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
    private a fYY;
    private HttpMessageListener hyY;

    /* loaded from: classes4.dex */
    public interface a {
        void a(ArrayList<com.baidu.tieba.ala.data.d> arrayList, String str, long j);

        void aP(int i, String str);
    }

    public j(BdPageContext<?> bdPageContext, a aVar) {
        super(bdPageContext);
        this.hyY = new HttpMessageListener(1021165) { // from class: com.baidu.tieba.ala.g.j.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1021165 && (httpResponsedMessage instanceof AlaGetWishListResponseMessage)) {
                    AlaGetWishListResponseMessage alaGetWishListResponseMessage = (AlaGetWishListResponseMessage) httpResponsedMessage;
                    if (j.this.fYY != null) {
                        if (alaGetWishListResponseMessage.getError() != 0 || !alaGetWishListResponseMessage.isSuccess()) {
                            j.this.fYY.aP(alaGetWishListResponseMessage.getError(), alaGetWishListResponseMessage.getErrorString());
                        } else {
                            j.this.fYY.a(alaGetWishListResponseMessage.getData(), alaGetWishListResponseMessage.getTips(), alaGetWishListResponseMessage.getSysTime());
                        }
                    }
                }
            }
        };
        this.fYY = aVar;
        registerListener(this.hyY);
    }

    public void IA(String str) {
        HttpMessage httpMessage = new HttpMessage(1021165);
        httpMessage.addParam("anchor_id", str);
        sendMessage(httpMessage);
    }

    public void ciO() {
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
        MessageManager.getInstance().unRegisterListener(this.hyY);
    }
}
