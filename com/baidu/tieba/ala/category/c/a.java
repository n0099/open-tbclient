package com.baidu.tieba.ala.category.c;

import com.baidu.live.adp.base.BdBaseModel;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.listener.HttpMessageListener;
import com.baidu.live.adp.framework.message.HttpMessage;
import com.baidu.live.adp.framework.message.HttpResponsedMessage;
import com.baidu.live.adp.widget.listview.IAdapterData;
import com.baidu.live.tbadk.TbConfig;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.tbadk.core.util.ListUtils;
import com.baidu.live.tbadk.task.TbHttpMessageTask;
import com.baidu.tieba.ala.category.message.AlaCategoryResponseMessage;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class a extends BdBaseModel {
    private List<IAdapterData> guN;
    private InterfaceC0636a guT;
    private HttpMessageListener guU;

    /* renamed from: com.baidu.tieba.ala.category.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public interface InterfaceC0636a {
        void aE(int i, String str);

        void aRN();
    }

    public a(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.guN = new ArrayList();
        this.guU = new HttpMessageListener(1021187, true) { // from class: com.baidu.tieba.ala.category.c.a.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage instanceof AlaCategoryResponseMessage) {
                    AlaCategoryResponseMessage alaCategoryResponseMessage = (AlaCategoryResponseMessage) httpResponsedMessage;
                    com.baidu.tieba.ala.category.b.b bQW = alaCategoryResponseMessage.bQW();
                    if (!alaCategoryResponseMessage.isSuccess() || bQW == null || ListUtils.isEmpty(bQW.bQS())) {
                        if (a.this.guT != null) {
                            a.this.guT.aE(alaCategoryResponseMessage.getError(), alaCategoryResponseMessage.getErrorString());
                            return;
                        }
                        return;
                    }
                    a.this.guN = bQW.bQS();
                    if (a.this.guT != null) {
                        a.this.guT.aRN();
                    }
                }
            }
        };
        registerTask();
        registerListener(this.guU);
    }

    private void registerTask() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1021187, TbConfig.SERVER_ADDRESS + "ala/tag/categorylist");
        tbHttpMessageTask.setIsNeedLogin(true);
        tbHttpMessageTask.setIsNeedTbs(true);
        tbHttpMessageTask.setIsUseCurrentBDUSS(true);
        tbHttpMessageTask.setResponsedClass(AlaCategoryResponseMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    public void bQX() {
        loadData();
    }

    @Override // com.baidu.live.adp.base.BdBaseModel
    protected boolean loadData() {
        sendMessage(new HttpMessage(1021187));
        return true;
    }

    @Override // com.baidu.live.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        cancelMessage();
        return true;
    }

    public void a(InterfaceC0636a interfaceC0636a) {
        this.guT = interfaceC0636a;
    }

    public List<IAdapterData> bQS() {
        return this.guN;
    }
}
