package com.baidu.tieba.ala.charm.model;

import com.baidu.live.adp.BdUniqueId;
import com.baidu.live.adp.base.BdBaseModel;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.listener.HttpMessageListener;
import com.baidu.live.adp.framework.message.HttpMessage;
import com.baidu.live.adp.framework.message.HttpResponsedMessage;
import com.baidu.live.tbadk.TbConfig;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.tbadk.task.TbHttpMessageTask;
import com.baidu.mobstat.Config;
import com.baidu.tieba.ala.charm.ALaCharmCardActivity;
import com.baidu.tieba.ala.charm.data.ALaCharmDataList;
/* loaded from: classes10.dex */
public class a extends BdBaseModel<ALaCharmCardActivity> {
    private BdUniqueId gLW;
    private InterfaceC0624a gLX;
    private HttpMessageListener gLY;
    private String mUid;

    /* renamed from: com.baidu.tieba.ala.charm.model.a$a  reason: collision with other inner class name */
    /* loaded from: classes10.dex */
    public interface InterfaceC0624a {
        void a(ALaCharmDataList aLaCharmDataList);

        void w(int i, String str);
    }

    public a(TbPageContext tbPageContext, String str, InterfaceC0624a interfaceC0624a) {
        super(tbPageContext);
        this.gLW = BdUniqueId.gen();
        this.gLY = new HttpMessageListener(1021002) { // from class: com.baidu.tieba.ala.charm.model.a.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1021002 && (httpResponsedMessage instanceof AlaCharmDetailHttpResponsedMessage)) {
                    if (httpResponsedMessage.getOrginalMessage() == null || httpResponsedMessage.getOrginalMessage().getTag() == a.this.gLW) {
                        int statusCode = httpResponsedMessage.getStatusCode();
                        int error = httpResponsedMessage.getError();
                        AlaCharmDetailHttpResponsedMessage alaCharmDetailHttpResponsedMessage = (AlaCharmDetailHttpResponsedMessage) httpResponsedMessage;
                        if (statusCode != 200 || error != 0) {
                            if (a.this.gLX != null) {
                                a.this.gLX.w(httpResponsedMessage.getError(), httpResponsedMessage.getErrorString());
                            }
                        } else if (a.this.gLX != null) {
                            a.this.gLX.a(alaCharmDetailHttpResponsedMessage.gMa);
                        }
                    }
                }
            }
        };
        this.mUid = str;
        this.gLX = interfaceC0624a;
        this.gLY.setTag(this.gLW);
        MessageManager.getInstance().registerListener(this.gLY);
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1021002, TbConfig.SERVER_ADDRESS + "ala/relation/getGuardianShipList");
        tbHttpMessageTask.setIsNeedLogin(true);
        tbHttpMessageTask.setIsNeedAddCommenParam(true);
        tbHttpMessageTask.setIsNeedTbs(true);
        tbHttpMessageTask.setResponsedClass(AlaCharmDetailHttpResponsedMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    public void bG(int i, int i2) {
        N(i, i2, 0);
    }

    public void N(int i, int i2, int i3) {
        if (this.mUid != null) {
            HttpMessage httpMessage = new HttpMessage(1021002);
            httpMessage.setTag(this.gLW);
            httpMessage.addParam("benefit_userid", this.mUid);
            httpMessage.addParam("time_type", i);
            httpMessage.addParam(Config.PACKAGE_NAME, 0);
            httpMessage.addParam("ps", i2);
            httpMessage.addParam("is_card", i3);
            MessageManager.getInstance().sendMessage(httpMessage);
        }
    }

    public void O(int i, int i2, int i3) {
        if (this.mUid != null) {
            HttpMessage httpMessage = new HttpMessage(1021002);
            httpMessage.setTag(this.gLW);
            httpMessage.addParam("benefit_userid", this.mUid);
            httpMessage.addParam("time_type", i);
            httpMessage.addParam(Config.PACKAGE_NAME, i2);
            httpMessage.addParam("ps", i3);
            MessageManager.getInstance().sendMessage(httpMessage);
        }
    }

    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.gLY);
        MessageManager.getInstance().unRegisterTask(1021002);
        cancelMessage();
    }

    @Override // com.baidu.live.adp.base.BdBaseModel
    protected boolean loadData() {
        return false;
    }

    @Override // com.baidu.live.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        cancelMessage();
        return true;
    }
}
