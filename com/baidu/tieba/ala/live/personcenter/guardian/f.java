package com.baidu.tieba.ala.live.personcenter.guardian;

import com.baidu.live.adp.base.BdBaseModel;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.listener.HttpMessageListener;
import com.baidu.live.adp.framework.message.HttpMessage;
import com.baidu.live.adp.framework.message.HttpResponsedMessage;
import com.baidu.live.adp.lib.util.StringUtils;
import com.baidu.live.k.a;
import com.baidu.live.tbadk.TbConfig;
import com.baidu.live.tbadk.task.TbHttpMessageTask;
/* loaded from: classes6.dex */
public class f extends BdBaseModel<AlaGuardianListActivity> {
    private a dSI;
    private AlaGuardianListActivity dSK;
    public HttpMessageListener dSd;
    private String mUserId;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes6.dex */
    public interface a {
        d b(d dVar);

        void tr(String str);
    }

    public f(AlaGuardianListActivity alaGuardianListActivity, a aVar) {
        super(alaGuardianListActivity.getPageContext());
        this.dSd = new HttpMessageListener(1021024) { // from class: com.baidu.tieba.ala.live.personcenter.guardian.f.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                String errorString;
                if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1021024 && (httpResponsedMessage instanceof AlaGuardianListHttpResponseMessage)) {
                    int statusCode = httpResponsedMessage.getStatusCode();
                    int error = httpResponsedMessage.getError();
                    if (statusCode != 200 || error != 0) {
                        if (f.this.dSI != null) {
                            if (StringUtils.isNull(httpResponsedMessage.getErrorString())) {
                                errorString = f.this.dSK.getResources().getString(a.i.sdk_neterror);
                            } else {
                                errorString = httpResponsedMessage.getErrorString();
                            }
                            f.this.dSI.tr(errorString);
                            return;
                        }
                        return;
                    }
                    AlaGuardianListHttpResponseMessage alaGuardianListHttpResponseMessage = (AlaGuardianListHttpResponseMessage) httpResponsedMessage;
                    if (f.this.dSI != null) {
                        f.this.dSI.b(alaGuardianListHttpResponseMessage.aMI());
                    }
                }
            }
        };
        this.dSK = alaGuardianListActivity;
        this.dSI = aVar;
        aMJ();
        registerListener(this.dSd);
    }

    public void tt(String str) {
        this.mUserId = str;
    }

    private void aMJ() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1021024, TbConfig.SERVER_ADDRESS + "ala/relation/getGuardianShipList");
        tbHttpMessageTask.setIsNeedLogin(true);
        tbHttpMessageTask.setIsNeedTbs(true);
        tbHttpMessageTask.setIsUseCurrentBDUSS(true);
        tbHttpMessageTask.setResponsedClass(AlaGuardianListHttpResponseMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    @Override // com.baidu.live.adp.base.BdBaseModel
    public boolean loadData() {
        aMK();
        return false;
    }

    private void aMK() {
        HttpMessage httpMessage = new HttpMessage(1021024);
        httpMessage.setTag(this.dSK.getUniqueId());
        httpMessage.addParam("benefit_userid", this.mUserId);
        sendMessage(httpMessage);
    }

    @Override // com.baidu.live.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        MessageManager.getInstance().unRegisterListener(this.dSd);
        return false;
    }

    public void onDestroy() {
        cancelLoadData();
        MessageManager.getInstance().unRegisterTask(1021024);
    }
}
