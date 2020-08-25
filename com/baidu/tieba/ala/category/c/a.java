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
/* loaded from: classes7.dex */
public class a extends BdBaseModel {
    private List<IAdapterData> fPp;
    private InterfaceC0595a fPv;
    private HttpMessageListener fPw;

    /* renamed from: com.baidu.tieba.ala.category.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public interface InterfaceC0595a {
        void aJZ();

        void am(int i, String str);
    }

    public a(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.fPp = new ArrayList();
        this.fPw = new HttpMessageListener(1021187, true) { // from class: com.baidu.tieba.ala.category.c.a.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage instanceof AlaCategoryResponseMessage) {
                    AlaCategoryResponseMessage alaCategoryResponseMessage = (AlaCategoryResponseMessage) httpResponsedMessage;
                    com.baidu.tieba.ala.category.b.b bIb = alaCategoryResponseMessage.bIb();
                    if (!alaCategoryResponseMessage.isSuccess() || bIb == null || ListUtils.isEmpty(bIb.bHX())) {
                        if (a.this.fPv != null) {
                            a.this.fPv.am(alaCategoryResponseMessage.getError(), alaCategoryResponseMessage.getErrorString());
                            return;
                        }
                        return;
                    }
                    a.this.fPp = bIb.bHX();
                    if (a.this.fPv != null) {
                        a.this.fPv.aJZ();
                    }
                }
            }
        };
        registerTask();
        registerListener(this.fPw);
    }

    private void registerTask() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1021187, TbConfig.SERVER_ADDRESS + "/ala/tag/categorylist");
        tbHttpMessageTask.setIsNeedLogin(true);
        tbHttpMessageTask.setIsNeedTbs(true);
        tbHttpMessageTask.setIsUseCurrentBDUSS(true);
        tbHttpMessageTask.setResponsedClass(AlaCategoryResponseMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    public void bIc() {
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

    public void a(InterfaceC0595a interfaceC0595a) {
        this.fPv = interfaceC0595a;
    }

    public List<IAdapterData> bHX() {
        return this.fPp;
    }
}
