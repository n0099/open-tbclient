package com.baidu.tieba.ala.alasquare.live_tab.my_concern.model;

import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.adp.widget.ListView.q;
import com.baidu.ala.AlaCmdConfigHttp;
import com.baidu.ala.AlaConfig;
import com.baidu.mobstat.Config;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.x;
import com.baidu.tbadk.task.TbHttpMessageTask;
import com.baidu.tieba.ala.alasquare.live_tab.my_concern.b.b;
import com.baidu.tieba.ala.alasquare.live_tab.my_concern.data.AlaLiveTabMyConcernResponse;
import java.util.List;
/* loaded from: classes4.dex */
public class MyConcernTabModel extends BdBaseModel {
    private a fuH;
    private b fuI;
    private TbPageContext mTbPageContext;
    private int pn = 1;
    private HttpMessageListener fuJ = new HttpMessageListener(AlaCmdConfigHttp.CMD_ALA_TAB_SUB_MY_CONCERN_LIST) { // from class: com.baidu.tieba.ala.alasquare.live_tab.my_concern.model.MyConcernTabModel.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1021140 && (httpResponsedMessage instanceof AlaLiveTabMyConcernResponse)) {
                AlaLiveTabMyConcernResponse alaLiveTabMyConcernResponse = (AlaLiveTabMyConcernResponse) httpResponsedMessage;
                boolean z = x.isEmpty(alaLiveTabMyConcernResponse.followList) && x.isEmpty(alaLiveTabMyConcernResponse.recommendList) && x.isEmpty(alaLiveTabMyConcernResponse.followCloseList) && alaLiveTabMyConcernResponse.followStatus == 0;
                if (alaLiveTabMyConcernResponse.getError() != 0 || !alaLiveTabMyConcernResponse.isSuccess() || z) {
                    if (MyConcernTabModel.this.fuH != null) {
                        MyConcernTabModel.this.fuH.kh(MyConcernTabModel.this.pn == 1);
                        return;
                    }
                    return;
                }
                MyConcernTabModel.this.fuI.c(alaLiveTabMyConcernResponse, MyConcernTabModel.this.pn == 1);
                if (MyConcernTabModel.this.fuH != null) {
                    MyConcernTabModel.this.fuH.b(MyConcernTabModel.this.fuI.bxj(), alaLiveTabMyConcernResponse.hasMore, MyConcernTabModel.this.pn == 1);
                }
                MyConcernTabModel.this.pn = alaLiveTabMyConcernResponse.pn + 1;
            }
        }
    };

    /* loaded from: classes4.dex */
    public interface a {
        void b(List<q> list, boolean z, boolean z2);

        void kh(boolean z);
    }

    public MyConcernTabModel(TbPageContext tbPageContext) {
        this.mTbPageContext = tbPageContext;
        this.fuI = new b(this.mTbPageContext);
        bwx();
        MessageManager.getInstance().registerListener(this.fuJ);
    }

    private void bwx() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(AlaCmdConfigHttp.CMD_ALA_TAB_SUB_MY_CONCERN_LIST, TbConfig.SERVER_ADDRESS + AlaConfig.ALA_TAB_SUB_MY_CONCERN_LIST);
        tbHttpMessageTask.setIsNeedLogin(true);
        tbHttpMessageTask.setIsNeedTbs(true);
        tbHttpMessageTask.setIsUseCurrentBDUSS(true);
        tbHttpMessageTask.setResponsedClass(AlaLiveTabMyConcernResponse.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    public void IH() {
        this.pn = 1;
        this.fuI.clearData();
        qr(1);
    }

    public void bxg() {
        qr(this.pn);
    }

    private void qr(int i) {
        HttpMessage httpMessage = new HttpMessage(AlaCmdConfigHttp.CMD_ALA_TAB_SUB_MY_CONCERN_LIST);
        httpMessage.addParam(Config.PACKAGE_NAME, i);
        MessageManager.getInstance().sendMessage(httpMessage);
    }

    public void onDestroy() {
        this.fuI.clearData();
        if (this.fuJ != null) {
            MessageManager.getInstance().unRegisterListener(this.fuJ);
        }
    }

    public void a(a aVar) {
        this.fuH = aVar;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    protected boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        return false;
    }

    public void x(Class<? extends com.baidu.tieba.card.data.b> cls) {
        this.fuI.x(cls);
    }
}
