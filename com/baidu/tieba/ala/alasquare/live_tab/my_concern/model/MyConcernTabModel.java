package com.baidu.tieba.ala.alasquare.live_tab.my_concern.model;

import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.adp.widget.ListView.o;
import com.baidu.ala.AlaCmdConfigHttp;
import com.baidu.ala.AlaConfig;
import com.baidu.mobstat.Config;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.task.TbHttpMessageTask;
import com.baidu.tieba.ala.alasquare.live_tab.my_concern.b.b;
import com.baidu.tieba.ala.alasquare.live_tab.my_concern.data.AlaLiveTabMyConcernResponse;
import java.util.List;
/* loaded from: classes3.dex */
public class MyConcernTabModel extends BdBaseModel {
    private a fem;
    private b fen;
    private TbPageContext mTbPageContext;
    private int pn = 1;
    private HttpMessageListener feo = new HttpMessageListener(AlaCmdConfigHttp.CMD_ALA_TAB_SUB_MY_CONCERN_LIST) { // from class: com.baidu.tieba.ala.alasquare.live_tab.my_concern.model.MyConcernTabModel.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1021140 && (httpResponsedMessage instanceof AlaLiveTabMyConcernResponse)) {
                AlaLiveTabMyConcernResponse alaLiveTabMyConcernResponse = (AlaLiveTabMyConcernResponse) httpResponsedMessage;
                boolean z = v.isEmpty(alaLiveTabMyConcernResponse.followList) && v.isEmpty(alaLiveTabMyConcernResponse.recommendList) && v.isEmpty(alaLiveTabMyConcernResponse.followCloseList) && alaLiveTabMyConcernResponse.followStatus == 0;
                if (alaLiveTabMyConcernResponse.getError() != 0 || !alaLiveTabMyConcernResponse.isSuccess() || z) {
                    if (MyConcernTabModel.this.fem != null) {
                        MyConcernTabModel.this.fem.jq(MyConcernTabModel.this.pn == 1);
                        return;
                    }
                    return;
                }
                MyConcernTabModel.this.fen.c(alaLiveTabMyConcernResponse, MyConcernTabModel.this.pn == 1);
                if (MyConcernTabModel.this.fem != null) {
                    MyConcernTabModel.this.fem.c(MyConcernTabModel.this.fen.brc(), alaLiveTabMyConcernResponse.hasMore, MyConcernTabModel.this.pn == 1);
                }
                MyConcernTabModel.this.pn = alaLiveTabMyConcernResponse.pn + 1;
            }
        }
    };

    /* loaded from: classes3.dex */
    public interface a {
        void c(List<o> list, boolean z, boolean z2);

        void jq(boolean z);
    }

    public MyConcernTabModel(TbPageContext tbPageContext) {
        this.mTbPageContext = tbPageContext;
        this.fen = new b(this.mTbPageContext);
        bqq();
        MessageManager.getInstance().registerListener(this.feo);
    }

    private void bqq() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(AlaCmdConfigHttp.CMD_ALA_TAB_SUB_MY_CONCERN_LIST, TbConfig.SERVER_ADDRESS + AlaConfig.ALA_TAB_SUB_MY_CONCERN_LIST);
        tbHttpMessageTask.setIsNeedLogin(true);
        tbHttpMessageTask.setIsNeedTbs(true);
        tbHttpMessageTask.setIsUseCurrentBDUSS(true);
        tbHttpMessageTask.setResponsedClass(AlaLiveTabMyConcernResponse.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    public void Ho() {
        this.pn = 1;
        this.fen.clearData();
        pD(1);
    }

    public void bqZ() {
        pD(this.pn);
    }

    private void pD(int i) {
        HttpMessage httpMessage = new HttpMessage(AlaCmdConfigHttp.CMD_ALA_TAB_SUB_MY_CONCERN_LIST);
        httpMessage.addParam(Config.PACKAGE_NAME, i);
        MessageManager.getInstance().sendMessage(httpMessage);
    }

    public void onDestroy() {
        this.fen.clearData();
        if (this.feo != null) {
            MessageManager.getInstance().unRegisterListener(this.feo);
        }
    }

    public void a(a aVar) {
        this.fem = aVar;
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
        this.fen.x(cls);
    }
}
