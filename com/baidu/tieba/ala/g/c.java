package com.baidu.tieba.ala.g;

import com.baidu.live.adp.base.BdBaseModel;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.listener.HttpMessageListener;
import com.baidu.live.adp.framework.message.HttpResponsedMessage;
import com.baidu.live.data.w;
import com.baidu.live.gift.aa;
import com.baidu.live.message.AlaSdkGetGiftListHttpResponseMessage;
import com.baidu.live.tbadk.TbConfig;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.tbadk.task.TbHttpMessageTask;
/* loaded from: classes4.dex */
public class c extends BdBaseModel {
    private a hyB;
    private HttpMessageListener hyC = new HttpMessageListener(1021120) { // from class: com.baidu.tieba.ala.g.c.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && (httpResponsedMessage instanceof AlaSdkGetGiftListHttpResponseMessage) && httpResponsedMessage.getOrginalMessage().getTag() == c.this.getUniqueId() && c.this.hyB != null) {
                AlaSdkGetGiftListHttpResponseMessage alaSdkGetGiftListHttpResponseMessage = (AlaSdkGetGiftListHttpResponseMessage) httpResponsedMessage;
                if (alaSdkGetGiftListHttpResponseMessage.getError() != 0 || !alaSdkGetGiftListHttpResponseMessage.isSuccess()) {
                    c.this.hyB.onFail(alaSdkGetGiftListHttpResponseMessage.getError(), alaSdkGetGiftListHttpResponseMessage.getErrorString());
                } else {
                    c.this.hyB.c(alaSdkGetGiftListHttpResponseMessage);
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

    private void FJ() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1021120, TbConfig.SERVER_ADDRESS + "ala/sdk/v1/open/getGiftListBySceneFrom");
        tbHttpMessageTask.setIsNeedTbs(true);
        tbHttpMessageTask.setIsUseCurrentBDUSS(true);
        tbHttpMessageTask.setResponsedClass(AlaSdkGetGiftListHttpResponseMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    public c(TbPageContext tbPageContext, a aVar) {
        this.mPageContext = tbPageContext;
        this.hyB = aVar;
        FJ();
        registerListener(this.hyC);
    }

    public void request() {
        String str;
        String str2 = "";
        String str3 = "";
        w Hn = aa.Hn();
        if (Hn != null) {
            if (Hn.mLiveInfo != null) {
                str2 = String.valueOf(Hn.mLiveInfo.live_id);
            }
            if (Hn.aIV != null) {
                str3 = String.valueOf(Hn.aIV.userId);
                str = str2;
                sendMessage(new com.baidu.live.message.f(com.baidu.live.utils.p.UK(), str, str3, "choose", "choose"));
            }
        }
        str = str2;
        sendMessage(new com.baidu.live.message.f(com.baidu.live.utils.p.UK(), str, str3, "choose", "choose"));
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
        MessageManager.getInstance().unRegisterListener(this.hyC);
        MessageManager.getInstance().unRegisterTask(1021120);
    }
}
