package com.baidu.tieba.ala.g;

import android.location.Address;
import com.baidu.live.adp.base.BdBaseModel;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.listener.HttpMessageListener;
import com.baidu.live.adp.framework.message.HttpResponsedMessage;
import com.baidu.live.adp.lib.lbs.BdLocationMananger;
import com.baidu.live.data.w;
import com.baidu.live.gift.ac;
import com.baidu.live.message.AlaSdkGetGiftListHttpResponseMessage;
import com.baidu.live.tbadk.TbConfig;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.tbadk.task.TbHttpMessageTask;
/* loaded from: classes4.dex */
public class c extends BdBaseModel {
    private a hHN;
    private HttpMessageListener hHO = new HttpMessageListener(1021120) { // from class: com.baidu.tieba.ala.g.c.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && (httpResponsedMessage instanceof AlaSdkGetGiftListHttpResponseMessage) && httpResponsedMessage.getOrginalMessage().getTag() == c.this.getUniqueId() && c.this.hHN != null) {
                AlaSdkGetGiftListHttpResponseMessage alaSdkGetGiftListHttpResponseMessage = (AlaSdkGetGiftListHttpResponseMessage) httpResponsedMessage;
                if (alaSdkGetGiftListHttpResponseMessage.getError() != 0 || !alaSdkGetGiftListHttpResponseMessage.isSuccess()) {
                    c.this.hHN.onFail(alaSdkGetGiftListHttpResponseMessage.getError(), alaSdkGetGiftListHttpResponseMessage.getErrorString());
                } else {
                    c.this.hHN.c(alaSdkGetGiftListHttpResponseMessage);
                }
            }
        }
    };
    private TbPageContext mPageContext;

    /* loaded from: classes4.dex */
    public interface a {
        void c(AlaSdkGetGiftListHttpResponseMessage alaSdkGetGiftListHttpResponseMessage);

        void onFail(int i, String str);
    }

    private void GL() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1021120, TbConfig.SERVER_ADDRESS + "ala/sdk/v1/open/getGiftListBySceneFrom");
        tbHttpMessageTask.setIsNeedTbs(true);
        tbHttpMessageTask.setIsUseCurrentBDUSS(true);
        tbHttpMessageTask.setResponsedClass(AlaSdkGetGiftListHttpResponseMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    public c(TbPageContext tbPageContext, a aVar) {
        this.mPageContext = tbPageContext;
        this.hHN = aVar;
        GL();
        registerListener(this.hHO);
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
        w Iv = ac.Iv();
        if (Iv != null) {
            if (Iv.mLiveInfo != null) {
                str2 = String.valueOf(Iv.mLiveInfo.live_id);
            }
            if (Iv.aJV != null) {
                str3 = String.valueOf(Iv.aJV.userId);
                str = str2;
                com.baidu.live.message.f fVar = new com.baidu.live.message.f(com.baidu.live.utils.p.WB(), str, str3, "choose", "choose");
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
        com.baidu.live.message.f fVar2 = new com.baidu.live.message.f(com.baidu.live.utils.p.WB(), str, str3, "choose", "choose");
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
        MessageManager.getInstance().unRegisterListener(this.hHO);
        MessageManager.getInstance().unRegisterTask(1021120);
    }
}
