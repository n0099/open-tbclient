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
/* loaded from: classes4.dex */
public class e extends BdBaseModel<AlaGuardianListActivity> {
    public HttpMessageListener gQQ;
    private a gRu;
    private AlaGuardianListActivity gRw;
    private String mUserId;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public interface a {
        void HC(String str);

        c b(c cVar);
    }

    public e(AlaGuardianListActivity alaGuardianListActivity, a aVar) {
        super(alaGuardianListActivity.getPageContext());
        this.gQQ = new HttpMessageListener(1021024) { // from class: com.baidu.tieba.ala.live.personcenter.guardian.e.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                String errorString;
                if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1021024 && (httpResponsedMessage instanceof AlaGuardianListHttpResponseMessage)) {
                    int statusCode = httpResponsedMessage.getStatusCode();
                    int error = httpResponsedMessage.getError();
                    if (statusCode != 200 || error != 0) {
                        if (e.this.gRu != null) {
                            if (StringUtils.isNull(httpResponsedMessage.getErrorString())) {
                                errorString = e.this.gRw.getResources().getString(a.h.sdk_neterror);
                            } else {
                                errorString = httpResponsedMessage.getErrorString();
                            }
                            e.this.gRu.HC(errorString);
                            return;
                        }
                        return;
                    }
                    AlaGuardianListHttpResponseMessage alaGuardianListHttpResponseMessage = (AlaGuardianListHttpResponseMessage) httpResponsedMessage;
                    if (e.this.gRu != null) {
                        e.this.gRu.b(alaGuardianListHttpResponseMessage.bVJ());
                    }
                }
            }
        };
        this.gRw = alaGuardianListActivity;
        this.gRu = aVar;
        bpx();
        registerListener(this.gQQ);
    }

    public void HE(String str) {
        this.mUserId = str;
    }

    private void bpx() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1021024, TbConfig.SERVER_ADDRESS + "ala/relation/getGuardianShipList");
        tbHttpMessageTask.setIsNeedLogin(true);
        tbHttpMessageTask.setIsNeedTbs(true);
        tbHttpMessageTask.setIsUseCurrentBDUSS(true);
        tbHttpMessageTask.setResponsedClass(AlaGuardianListHttpResponseMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    @Override // com.baidu.live.adp.base.BdBaseModel
    public boolean loadData() {
        bVK();
        return false;
    }

    private void bVK() {
        HttpMessage httpMessage = new HttpMessage(1021024);
        httpMessage.setTag(this.gRw.getUniqueId());
        httpMessage.addParam("benefit_userid", this.mUserId);
        sendMessage(httpMessage);
    }

    @Override // com.baidu.live.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        MessageManager.getInstance().unRegisterListener(this.gQQ);
        return false;
    }

    public void onDestroy() {
        cancelLoadData();
        MessageManager.getInstance().unRegisterTask(1021024);
    }
}
