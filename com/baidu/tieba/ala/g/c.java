package com.baidu.tieba.ala.g;

import android.location.Address;
import com.baidu.live.adp.base.BdBaseModel;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.listener.HttpMessageListener;
import com.baidu.live.adp.framework.message.HttpResponsedMessage;
import com.baidu.live.adp.lib.lbs.BdLocationMananger;
import com.baidu.live.data.x;
import com.baidu.live.gift.ac;
import com.baidu.live.message.AlaSdkGetGiftListHttpResponseMessage;
import com.baidu.live.tbadk.TbConfig;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.tbadk.task.TbHttpMessageTask;
import com.baidu.live.utils.q;
/* loaded from: classes10.dex */
public class c extends BdBaseModel {
    private a hPj;
    private HttpMessageListener hPk = new HttpMessageListener(1021120) { // from class: com.baidu.tieba.ala.g.c.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && (httpResponsedMessage instanceof AlaSdkGetGiftListHttpResponseMessage) && httpResponsedMessage.getOrginalMessage().getTag() == c.this.getUniqueId() && c.this.hPj != null) {
                AlaSdkGetGiftListHttpResponseMessage alaSdkGetGiftListHttpResponseMessage = (AlaSdkGetGiftListHttpResponseMessage) httpResponsedMessage;
                if (alaSdkGetGiftListHttpResponseMessage.getError() != 0 || !alaSdkGetGiftListHttpResponseMessage.isSuccess()) {
                    c.this.hPj.onFail(alaSdkGetGiftListHttpResponseMessage.getError(), alaSdkGetGiftListHttpResponseMessage.getErrorString());
                } else {
                    c.this.hPj.c(alaSdkGetGiftListHttpResponseMessage);
                }
            }
        }
    };
    private TbPageContext mPageContext;

    /* loaded from: classes10.dex */
    public interface a {
        void c(AlaSdkGetGiftListHttpResponseMessage alaSdkGetGiftListHttpResponseMessage);

        void onFail(int i, String str);
    }

    private void Cq() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1021120, TbConfig.SERVER_ADDRESS + "ala/sdk/v1/open/getGiftListBySceneFrom");
        tbHttpMessageTask.setIsNeedTbs(true);
        tbHttpMessageTask.setIsUseCurrentBDUSS(true);
        tbHttpMessageTask.setResponsedClass(AlaSdkGetGiftListHttpResponseMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    public c(TbPageContext tbPageContext, a aVar) {
        this.mPageContext = tbPageContext;
        this.hPj = aVar;
        Cq();
        registerListener(this.hPk);
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0041  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0050  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void request() {
        String str;
        Address address;
        String str2 = "";
        String str3 = "";
        x Eb = ac.Eb();
        if (Eb != null) {
            if (Eb.mLiveInfo != null) {
                str2 = String.valueOf(Eb.mLiveInfo.live_id);
            }
            if (Eb.aFH != null) {
                str3 = String.valueOf(Eb.aFH.userId);
                str = str2;
                com.baidu.live.message.f fVar = new com.baidu.live.message.f(q.TN(), str, str3, "choose", "choose");
                address = BdLocationMananger.getInstance().getAddress(false);
                if (address == null) {
                    fVar.b(address.getLongitude(), address.getLatitude());
                } else {
                    fVar.b(0.0d, 0.0d);
                }
                sendMessage(fVar);
            }
        }
        str = str2;
        com.baidu.live.message.f fVar2 = new com.baidu.live.message.f(q.TN(), str, str3, "choose", "choose");
        address = BdLocationMananger.getInstance().getAddress(false);
        if (address == null) {
        }
        sendMessage(fVar2);
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
        cancelMessage();
        MessageManager.getInstance().unRegisterListener(this.hPk);
        MessageManager.getInstance().unRegisterTask(1021120);
    }
}
