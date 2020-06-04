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
/* loaded from: classes3.dex */
public class a extends BdBaseModel<ALaCharmCardActivity> {
    private BdUniqueId fpn;
    private InterfaceC0532a fpo;
    private HttpMessageListener fpp;
    private String mUid;

    /* renamed from: com.baidu.tieba.ala.charm.model.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public interface InterfaceC0532a {
        void a(ALaCharmDataList aLaCharmDataList);

        void ax(int i, String str);
    }

    public a(TbPageContext tbPageContext, String str, InterfaceC0532a interfaceC0532a) {
        super(tbPageContext);
        this.fpn = BdUniqueId.gen();
        this.fpp = new HttpMessageListener(1021002) { // from class: com.baidu.tieba.ala.charm.model.a.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1021002 && (httpResponsedMessage instanceof AlaCharmDetailHttpResponsedMessage)) {
                    if (httpResponsedMessage.getOrginalMessage() == null || httpResponsedMessage.getOrginalMessage().getTag() == a.this.fpn) {
                        int statusCode = httpResponsedMessage.getStatusCode();
                        int error = httpResponsedMessage.getError();
                        AlaCharmDetailHttpResponsedMessage alaCharmDetailHttpResponsedMessage = (AlaCharmDetailHttpResponsedMessage) httpResponsedMessage;
                        if (statusCode != 200 || error != 0) {
                            if (a.this.fpo != null) {
                                a.this.fpo.ax(httpResponsedMessage.getError(), httpResponsedMessage.getErrorString());
                            }
                        } else if (a.this.fpo != null) {
                            a.this.fpo.a(alaCharmDetailHttpResponsedMessage.fpr);
                        }
                    }
                }
            }
        };
        this.mUid = str;
        this.fpo = interfaceC0532a;
        this.fpp.setTag(this.fpn);
        MessageManager.getInstance().registerListener(this.fpp);
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1021002, TbConfig.SERVER_ADDRESS + "ala/relation/getGuardianShipList");
        tbHttpMessageTask.setIsNeedLogin(true);
        tbHttpMessageTask.setIsNeedAddCommenParam(true);
        tbHttpMessageTask.setIsNeedTbs(true);
        tbHttpMessageTask.setResponsedClass(AlaCharmDetailHttpResponsedMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    public void bo(int i, int i2) {
        J(i, i2, 0);
    }

    public void J(int i, int i2, int i3) {
        if (this.mUid != null) {
            HttpMessage httpMessage = new HttpMessage(1021002);
            httpMessage.setTag(this.fpn);
            httpMessage.addParam("benefit_userid", this.mUid);
            httpMessage.addParam("time_type", i);
            httpMessage.addParam(Config.PACKAGE_NAME, 0);
            httpMessage.addParam("ps", i2);
            httpMessage.addParam("is_card", i3);
            MessageManager.getInstance().sendMessage(httpMessage);
        }
    }

    public void K(int i, int i2, int i3) {
        if (this.mUid != null) {
            HttpMessage httpMessage = new HttpMessage(1021002);
            httpMessage.setTag(this.fpn);
            httpMessage.addParam("benefit_userid", this.mUid);
            httpMessage.addParam("time_type", i);
            httpMessage.addParam(Config.PACKAGE_NAME, i2);
            httpMessage.addParam("ps", i3);
            MessageManager.getInstance().sendMessage(httpMessage);
        }
    }

    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.fpp);
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
