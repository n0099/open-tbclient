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
import com.baidu.tbadk.core.util.y;
import com.baidu.tbadk.task.TbHttpMessageTask;
import com.baidu.tieba.ala.alasquare.live_tab.my_concern.b.b;
import com.baidu.tieba.ala.alasquare.live_tab.my_concern.data.AlaLiveTabMyConcernResponse;
import com.baidu.tieba.card.data.BaseCardInfo;
import java.util.List;
/* loaded from: classes6.dex */
public class MyConcernTabModel extends BdBaseModel {
    private a gts;
    private b gtt;
    private TbPageContext mTbPageContext;
    private int pn = 1;
    private HttpMessageListener gtu = new HttpMessageListener(AlaCmdConfigHttp.CMD_ALA_TAB_SUB_MY_CONCERN_LIST) { // from class: com.baidu.tieba.ala.alasquare.live_tab.my_concern.model.MyConcernTabModel.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1021140 && (httpResponsedMessage instanceof AlaLiveTabMyConcernResponse)) {
                AlaLiveTabMyConcernResponse alaLiveTabMyConcernResponse = (AlaLiveTabMyConcernResponse) httpResponsedMessage;
                boolean z = y.isEmpty(alaLiveTabMyConcernResponse.followList) && y.isEmpty(alaLiveTabMyConcernResponse.recommendList) && y.isEmpty(alaLiveTabMyConcernResponse.followCloseList) && alaLiveTabMyConcernResponse.followStatus == 0;
                if (alaLiveTabMyConcernResponse.getError() != 0 || !alaLiveTabMyConcernResponse.isSuccess() || z) {
                    if (MyConcernTabModel.this.gts != null) {
                        MyConcernTabModel.this.gts.mf(MyConcernTabModel.this.pn == 1);
                        return;
                    }
                    return;
                }
                MyConcernTabModel.this.gtt.c(alaLiveTabMyConcernResponse, MyConcernTabModel.this.pn == 1);
                if (MyConcernTabModel.this.gts != null) {
                    MyConcernTabModel.this.gts.b(MyConcernTabModel.this.gtt.bSs(), alaLiveTabMyConcernResponse.hasMore, MyConcernTabModel.this.pn == 1);
                }
                MyConcernTabModel.this.pn = alaLiveTabMyConcernResponse.pn + 1;
            }
        }
    };

    /* loaded from: classes6.dex */
    public interface a {
        void b(List<q> list, boolean z, boolean z2);

        void mf(boolean z);
    }

    public MyConcernTabModel(TbPageContext tbPageContext) {
        this.mTbPageContext = tbPageContext;
        this.gtt = new b(this.mTbPageContext);
        bRG();
        MessageManager.getInstance().registerListener(this.gtu);
    }

    private void bRG() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(AlaCmdConfigHttp.CMD_ALA_TAB_SUB_MY_CONCERN_LIST, TbConfig.SERVER_ADDRESS + AlaConfig.ALA_TAB_SUB_MY_CONCERN_LIST);
        tbHttpMessageTask.setIsNeedLogin(true);
        tbHttpMessageTask.setIsNeedTbs(true);
        tbHttpMessageTask.setIsUseCurrentBDUSS(true);
        tbHttpMessageTask.setResponsedClass(AlaLiveTabMyConcernResponse.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    public void VC() {
        this.pn = 1;
        this.gtt.clearData();
        uY(1);
    }

    public void bSp() {
        uY(this.pn);
    }

    private void uY(int i) {
        HttpMessage httpMessage = new HttpMessage(AlaCmdConfigHttp.CMD_ALA_TAB_SUB_MY_CONCERN_LIST);
        httpMessage.addParam(Config.PACKAGE_NAME, i);
        MessageManager.getInstance().sendMessage(httpMessage);
    }

    public void onDestroy() {
        this.gtt.clearData();
        if (this.gtu != null) {
            MessageManager.getInstance().unRegisterListener(this.gtu);
        }
    }

    public void a(a aVar) {
        this.gts = aVar;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    protected boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        return false;
    }

    public void x(Class<? extends BaseCardInfo> cls) {
        this.gtt.x(cls);
    }
}
