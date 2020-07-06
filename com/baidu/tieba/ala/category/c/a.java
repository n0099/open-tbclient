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
/* loaded from: classes3.dex */
public class a extends BdBaseModel {
    private List<IAdapterData> fyR;
    private InterfaceC0538a fyX;
    private HttpMessageListener fyY;

    /* renamed from: com.baidu.tieba.ala.category.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public interface InterfaceC0538a {
        void an(int i, String str);

        void axT();
    }

    public a(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.fyR = new ArrayList();
        this.fyY = new HttpMessageListener(1021187, true) { // from class: com.baidu.tieba.ala.category.c.a.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage instanceof AlaCategoryResponseMessage) {
                    AlaCategoryResponseMessage alaCategoryResponseMessage = (AlaCategoryResponseMessage) httpResponsedMessage;
                    com.baidu.tieba.ala.category.b.b bvP = alaCategoryResponseMessage.bvP();
                    if (!alaCategoryResponseMessage.isSuccess() || bvP == null || ListUtils.isEmpty(bvP.bvL())) {
                        if (a.this.fyX != null) {
                            a.this.fyX.an(alaCategoryResponseMessage.getError(), alaCategoryResponseMessage.getErrorString());
                            return;
                        }
                        return;
                    }
                    a.this.fyR = bvP.bvL();
                    if (a.this.fyX != null) {
                        a.this.fyX.axT();
                    }
                }
            }
        };
        xp();
        registerListener(this.fyY);
    }

    private void xp() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1021187, TbConfig.SERVER_ADDRESS + "/ala/tag/categorylist");
        tbHttpMessageTask.setIsNeedLogin(true);
        tbHttpMessageTask.setIsNeedTbs(true);
        tbHttpMessageTask.setIsUseCurrentBDUSS(true);
        tbHttpMessageTask.setResponsedClass(AlaCategoryResponseMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    public void bvQ() {
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

    public void a(InterfaceC0538a interfaceC0538a) {
        this.fyX = interfaceC0538a;
    }

    public List<IAdapterData> bvL() {
        return this.fyR;
    }
}
