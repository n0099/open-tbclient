package com.baidu.tieba.ala.live.personcenter.guardian;

import com.baidu.live.adp.base.BdBaseModel;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.listener.HttpMessageListener;
import com.baidu.live.adp.framework.message.HttpMessage;
import com.baidu.live.adp.framework.message.HttpResponsedMessage;
import com.baidu.live.adp.lib.util.StringUtils;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.TbConfig;
import com.baidu.live.tbadk.task.TbHttpMessageTask;
/* loaded from: classes3.dex */
public class e extends BdBaseModel<AlaGuardianListActivity> {
    private a fQX;
    private AlaGuardianListActivity fQZ;
    public HttpMessageListener fQs;
    private String mUserId;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public interface a {
        void CA(String str);

        c b(c cVar);
    }

    public e(AlaGuardianListActivity alaGuardianListActivity, a aVar) {
        super(alaGuardianListActivity.getPageContext());
        this.fQs = new HttpMessageListener(1021024) { // from class: com.baidu.tieba.ala.live.personcenter.guardian.e.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                String errorString;
                if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1021024 && (httpResponsedMessage instanceof AlaGuardianListHttpResponseMessage)) {
                    int statusCode = httpResponsedMessage.getStatusCode();
                    int error = httpResponsedMessage.getError();
                    if (statusCode != 200 || error != 0) {
                        if (e.this.fQX != null) {
                            if (StringUtils.isNull(httpResponsedMessage.getErrorString())) {
                                errorString = e.this.fQZ.getResources().getString(a.i.sdk_neterror);
                            } else {
                                errorString = httpResponsedMessage.getErrorString();
                            }
                            e.this.fQX.CA(errorString);
                            return;
                        }
                        return;
                    }
                    AlaGuardianListHttpResponseMessage alaGuardianListHttpResponseMessage = (AlaGuardianListHttpResponseMessage) httpResponsedMessage;
                    if (e.this.fQX != null) {
                        e.this.fQX.b(alaGuardianListHttpResponseMessage.bzd());
                    }
                }
            }
        };
        this.fQZ = alaGuardianListActivity;
        this.fQX = aVar;
        aVg();
        registerListener(this.fQs);
    }

    public void CC(String str) {
        this.mUserId = str;
    }

    private void aVg() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1021024, TbConfig.SERVER_ADDRESS + "ala/relation/getGuardianShipList");
        tbHttpMessageTask.setIsNeedLogin(true);
        tbHttpMessageTask.setIsNeedTbs(true);
        tbHttpMessageTask.setIsUseCurrentBDUSS(true);
        tbHttpMessageTask.setResponsedClass(AlaGuardianListHttpResponseMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    @Override // com.baidu.live.adp.base.BdBaseModel
    public boolean loadData() {
        bze();
        return false;
    }

    private void bze() {
        HttpMessage httpMessage = new HttpMessage(1021024);
        httpMessage.setTag(this.fQZ.getUniqueId());
        httpMessage.addParam("benefit_userid", this.mUserId);
        sendMessage(httpMessage);
    }

    @Override // com.baidu.live.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        MessageManager.getInstance().unRegisterListener(this.fQs);
        return false;
    }

    public void onDestroy() {
        cancelLoadData();
        MessageManager.getInstance().unRegisterTask(1021024);
    }
}
