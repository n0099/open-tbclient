package com.baidu.tieba.ala.live.personcenter.guardian;

import com.baidu.live.adp.base.BdBaseModel;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.listener.HttpMessageListener;
import com.baidu.live.adp.framework.message.HttpMessage;
import com.baidu.live.adp.framework.message.HttpResponsedMessage;
import com.baidu.live.adp.lib.util.StringUtils;
import com.baidu.live.tbadk.TbConfig;
import com.baidu.live.tbadk.task.TbHttpMessageTask;
import com.baidu.live.u.a;
/* loaded from: classes3.dex */
public class e extends BdBaseModel<AlaGuardianListActivity> {
    public HttpMessageListener fEY;
    private a fFD;
    private AlaGuardianListActivity fFF;
    private String mUserId;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public interface a {
        void Cc(String str);

        c b(c cVar);
    }

    public e(AlaGuardianListActivity alaGuardianListActivity, a aVar) {
        super(alaGuardianListActivity.getPageContext());
        this.fEY = new HttpMessageListener(1021024) { // from class: com.baidu.tieba.ala.live.personcenter.guardian.e.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                String errorString;
                if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1021024 && (httpResponsedMessage instanceof AlaGuardianListHttpResponseMessage)) {
                    int statusCode = httpResponsedMessage.getStatusCode();
                    int error = httpResponsedMessage.getError();
                    if (statusCode != 200 || error != 0) {
                        if (e.this.fFD != null) {
                            if (StringUtils.isNull(httpResponsedMessage.getErrorString())) {
                                errorString = e.this.fFF.getResources().getString(a.i.sdk_neterror);
                            } else {
                                errorString = httpResponsedMessage.getErrorString();
                            }
                            e.this.fFD.Cc(errorString);
                            return;
                        }
                        return;
                    }
                    AlaGuardianListHttpResponseMessage alaGuardianListHttpResponseMessage = (AlaGuardianListHttpResponseMessage) httpResponsedMessage;
                    if (e.this.fFD != null) {
                        e.this.fFD.b(alaGuardianListHttpResponseMessage.bwf());
                    }
                }
            }
        };
        this.fFF = alaGuardianListActivity;
        this.fFD = aVar;
        aTm();
        registerListener(this.fEY);
    }

    public void Ce(String str) {
        this.mUserId = str;
    }

    private void aTm() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1021024, TbConfig.SERVER_ADDRESS + "ala/relation/getGuardianShipList");
        tbHttpMessageTask.setIsNeedLogin(true);
        tbHttpMessageTask.setIsNeedTbs(true);
        tbHttpMessageTask.setIsUseCurrentBDUSS(true);
        tbHttpMessageTask.setResponsedClass(AlaGuardianListHttpResponseMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    @Override // com.baidu.live.adp.base.BdBaseModel
    public boolean loadData() {
        bwg();
        return false;
    }

    private void bwg() {
        HttpMessage httpMessage = new HttpMessage(1021024);
        httpMessage.setTag(this.fFF.getUniqueId());
        httpMessage.addParam("benefit_userid", this.mUserId);
        sendMessage(httpMessage);
    }

    @Override // com.baidu.live.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        MessageManager.getInstance().unRegisterListener(this.fEY);
        return false;
    }

    public void onDestroy() {
        cancelLoadData();
        MessageManager.getInstance().unRegisterTask(1021024);
    }
}
