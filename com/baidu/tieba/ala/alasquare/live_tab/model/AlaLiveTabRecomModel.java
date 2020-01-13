package com.baidu.tieba.ala.alasquare.live_tab.model;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.adp.widget.ListView.m;
import com.baidu.ala.AlaCmdConfigCustom;
import com.baidu.ala.AlaCmdConfigHttp;
import com.baidu.mobstat.Config;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.ala.alasquare.live_tab.b.j;
import com.baidu.tieba.ala.alasquare.live_tab.c.b;
import com.baidu.tieba.ala.alasquare.live_tab.message.AlaTabLiveResponsedMessage;
import java.util.List;
/* loaded from: classes2.dex */
public class AlaLiveTabRecomModel extends BdBaseModel {
    private boolean eil;
    private b eiq;
    private a eir;
    private boolean hasMore;
    private int mPn;
    private TbPageContext mTbPageContext;
    private HttpMessageListener eis = new HttpMessageListener(AlaCmdConfigHttp.CMD_ALA_GET_TAB_LIVE_INFO) { // from class: com.baidu.tieba.ala.alasquare.live_tab.model.AlaLiveTabRecomModel.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1021141 && (httpResponsedMessage instanceof AlaTabLiveResponsedMessage) && httpResponsedMessage.getOrginalMessage().getTag() == AlaLiveTabRecomModel.this.mCurTag) {
                AlaTabLiveResponsedMessage alaTabLiveResponsedMessage = (AlaTabLiveResponsedMessage) httpResponsedMessage;
                com.baidu.tieba.ala.alasquare.live_tab.b.b bVar = new com.baidu.tieba.ala.alasquare.live_tab.b.b();
                if (alaTabLiveResponsedMessage.getError() != 0 || !alaTabLiveResponsedMessage.isSuccess()) {
                    if (AlaLiveTabRecomModel.this.eir != null) {
                        AlaLiveTabRecomModel.this.eir.e(httpResponsedMessage.getError(), httpResponsedMessage.getErrorString(), AlaLiveTabRecomModel.this.eil);
                    }
                    bVar.isSuccess = false;
                    bVar.errCode = httpResponsedMessage.getError();
                    bVar.errMsg = httpResponsedMessage.getErrorString();
                } else {
                    j jVar = alaTabLiveResponsedMessage.tabAllLiveInfo;
                    if (AlaLiveTabRecomModel.this.eil) {
                        AlaLiveTabRecomModel.this.eiq.a(jVar);
                        AlaLiveTabRecomModel.e(AlaLiveTabRecomModel.this);
                    } else {
                        if (AlaLiveTabRecomModel.this.eiq != null) {
                            AlaLiveTabRecomModel.this.eiq.clear();
                        }
                        AlaLiveTabRecomModel.this.eiq = new b(alaTabLiveResponsedMessage);
                    }
                    AlaLiveTabRecomModel.this.hasMore = AlaLiveTabRecomModel.this.eiq.hasMore();
                    if (AlaLiveTabRecomModel.this.eir != null) {
                        AlaLiveTabRecomModel.this.eir.d(AlaLiveTabRecomModel.this.hasMore, AlaLiveTabRecomModel.this.eiq.getData());
                    }
                    bVar.isSuccess = true;
                }
                bVar.isLoadMore = AlaLiveTabRecomModel.this.eil;
                bVar.superEntranceInfo = alaTabLiveResponsedMessage.superEntranceInfo;
                AlaLiveTabRecomModel.this.a(bVar);
                AlaLiveTabRecomModel.this.eil = false;
            }
        }
    };
    private BdUniqueId mCurTag = BdUniqueId.gen();

    /* loaded from: classes2.dex */
    public interface a {
        void d(boolean z, List<m> list);

        void e(int i, String str, boolean z);
    }

    static /* synthetic */ int e(AlaLiveTabRecomModel alaLiveTabRecomModel) {
        int i = alaLiveTabRecomModel.mPn;
        alaLiveTabRecomModel.mPn = i + 1;
        return i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.tieba.ala.alasquare.live_tab.b.b bVar) {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(AlaCmdConfigCustom.CMD_ALA_LIVE_TAB_RESPONSE, bVar));
    }

    public AlaLiveTabRecomModel(TbPageContext tbPageContext, a aVar) {
        this.mTbPageContext = tbPageContext;
        this.eir = aVar;
    }

    public void init() {
        MessageManager.getInstance().registerListener(this.eis);
    }

    public void refresh() {
        this.eil = false;
        this.mPn = 1;
        on(this.mPn);
    }

    public void aZN() {
        if (this.hasMore && !this.eil) {
            this.eil = true;
            on(this.mPn + 1);
        }
    }

    private void on(int i) {
        HttpMessage httpMessage = new HttpMessage(AlaCmdConfigHttp.CMD_ALA_GET_TAB_LIVE_INFO);
        httpMessage.addParam(Config.PACKAGE_NAME, i);
        httpMessage.setTag(this.mCurTag);
        MessageManager.getInstance().sendMessage(httpMessage);
    }

    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.eis);
    }

    @Override // com.baidu.adp.base.BdBaseModel
    protected boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        return false;
    }
}
