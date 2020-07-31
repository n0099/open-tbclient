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
    private List<IAdapterData> fDY;
    private InterfaceC0549a fEe;
    private HttpMessageListener fEf;

    /* renamed from: com.baidu.tieba.ala.category.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public interface InterfaceC0549a {
        void aBj();

        void ao(int i, String str);
    }

    public a(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.fDY = new ArrayList();
        this.fEf = new HttpMessageListener(1021187, true) { // from class: com.baidu.tieba.ala.category.c.a.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage instanceof AlaCategoryResponseMessage) {
                    AlaCategoryResponseMessage alaCategoryResponseMessage = (AlaCategoryResponseMessage) httpResponsedMessage;
                    com.baidu.tieba.ala.category.b.b byY = alaCategoryResponseMessage.byY();
                    if (!alaCategoryResponseMessage.isSuccess() || byY == null || ListUtils.isEmpty(byY.byU())) {
                        if (a.this.fEe != null) {
                            a.this.fEe.ao(alaCategoryResponseMessage.getError(), alaCategoryResponseMessage.getErrorString());
                            return;
                        }
                        return;
                    }
                    a.this.fDY = byY.byU();
                    if (a.this.fEe != null) {
                        a.this.fEe.aBj();
                    }
                }
            }
        };
        registerTask();
        registerListener(this.fEf);
    }

    private void registerTask() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1021187, TbConfig.SERVER_ADDRESS + "/ala/tag/categorylist");
        tbHttpMessageTask.setIsNeedLogin(true);
        tbHttpMessageTask.setIsNeedTbs(true);
        tbHttpMessageTask.setIsUseCurrentBDUSS(true);
        tbHttpMessageTask.setResponsedClass(AlaCategoryResponseMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    public void byZ() {
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

    public void a(InterfaceC0549a interfaceC0549a) {
        this.fEe = interfaceC0549a;
    }

    public List<IAdapterData> byU() {
        return this.fDY;
    }
}
