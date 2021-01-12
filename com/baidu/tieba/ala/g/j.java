package com.baidu.tieba.ala.g;

import com.baidu.live.adp.base.BdBaseModel;
import com.baidu.live.adp.base.BdPageContext;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.listener.HttpMessageListener;
import com.baidu.live.adp.framework.message.HttpMessage;
import com.baidu.live.adp.framework.message.HttpResponsedMessage;
import com.baidu.tieba.ala.message.AlaGetWishListResponseMessage;
import java.util.ArrayList;
/* loaded from: classes10.dex */
public class j extends BdBaseModel {
    private a gmJ;
    private HttpMessageListener hPG;

    /* loaded from: classes10.dex */
    public interface a {
        void a(ArrayList<com.baidu.tieba.ala.data.d> arrayList, String str, long j);

        void aQ(int i, String str);
    }

    public j(BdPageContext<?> bdPageContext, a aVar) {
        super(bdPageContext);
        this.hPG = new HttpMessageListener(1021165) { // from class: com.baidu.tieba.ala.g.j.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1021165 && (httpResponsedMessage instanceof AlaGetWishListResponseMessage)) {
                    AlaGetWishListResponseMessage alaGetWishListResponseMessage = (AlaGetWishListResponseMessage) httpResponsedMessage;
                    if (j.this.gmJ != null) {
                        if (alaGetWishListResponseMessage.getError() != 0 || !alaGetWishListResponseMessage.isSuccess()) {
                            j.this.gmJ.aQ(alaGetWishListResponseMessage.getError(), alaGetWishListResponseMessage.getErrorString());
                        } else {
                            j.this.gmJ.a(alaGetWishListResponseMessage.getData(), alaGetWishListResponseMessage.getTips(), alaGetWishListResponseMessage.getSysTime());
                        }
                    }
                }
            }
        };
        this.gmJ = aVar;
        registerListener(this.hPG);
    }

    public void HA(String str) {
        HttpMessage httpMessage = new HttpMessage(1021165);
        httpMessage.addParam("anchor_id", str);
        sendMessage(httpMessage);
    }

    public void clc() {
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
        MessageManager.getInstance().unRegisterListener(this.hPG);
    }
}
