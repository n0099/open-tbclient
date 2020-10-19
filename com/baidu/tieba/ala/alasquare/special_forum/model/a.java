package com.baidu.tieba.ala.alasquare.special_forum.model;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.ala.AlaCmdConfigHttp;
import com.baidu.ala.AlaConfig;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.task.TbHttpMessageTask;
import com.baidu.tieba.ala.alasquare.special_forum.data.SpecialLiveResponseMessage;
import com.baidu.tieba.ala.alasquare.special_forum.data.h;
/* loaded from: classes4.dex */
public class a {
    private InterfaceC0605a gal;
    private boolean isLoading;
    private TbPageContext mPageContext;
    private HttpMessageListener gaj = new HttpMessageListener(AlaCmdConfigHttp.CMD_ALA_SPECIAL_LIVE_DATA) { // from class: com.baidu.tieba.ala.alasquare.special_forum.model.a.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            a.this.isLoading = false;
            if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1021093 && (httpResponsedMessage instanceof SpecialLiveResponseMessage) && httpResponsedMessage.getOrginalMessage().getTag() == a.this.mCurTag) {
                SpecialLiveResponseMessage specialLiveResponseMessage = (SpecialLiveResponseMessage) httpResponsedMessage;
                if (!specialLiveResponseMessage.isSuccess() || specialLiveResponseMessage.getData() == null) {
                    if (a.this.gal != null) {
                        a.this.gal.aK(httpResponsedMessage.getError(), httpResponsedMessage.getErrorString());
                    }
                } else if (a.this.gal != null) {
                    a.this.gal.b(specialLiveResponseMessage.getData());
                }
            }
        }
    };
    private BdUniqueId mCurTag = BdUniqueId.gen();

    /* renamed from: com.baidu.tieba.ala.alasquare.special_forum.model.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public interface InterfaceC0605a {
        void aK(int i, String str);

        void b(h hVar);
    }

    public a(TbPageContext tbPageContext, InterfaceC0605a interfaceC0605a) {
        this.mPageContext = tbPageContext;
        this.gal = interfaceC0605a;
        registerTask();
        registerListener();
    }

    private void registerTask() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(AlaCmdConfigHttp.CMD_ALA_SPECIAL_LIVE_DATA, TbConfig.SERVER_ADDRESS + AlaConfig.ALA_SPECIAL_LIVE_DATA);
        tbHttpMessageTask.setResponsedClass(SpecialLiveResponseMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    private void registerListener() {
        MessageManager.getInstance().registerListener(this.gaj);
    }

    public void loadData() {
        if (!this.isLoading) {
            this.isLoading = true;
            HttpMessage httpMessage = new HttpMessage(AlaCmdConfigHttp.CMD_ALA_SPECIAL_LIVE_DATA);
            httpMessage.setTag(this.mCurTag);
            MessageManager.getInstance().sendMessage(httpMessage);
        }
    }

    public boolean isLoading() {
        return this.isLoading;
    }

    public void onDestroy() {
        MessageManager.getInstance().unRegisterTask(AlaCmdConfigHttp.CMD_ALA_SPECIAL_LIVE_DATA);
        MessageManager.getInstance().unRegisterListener(this.gaj);
    }
}
