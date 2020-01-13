package com.baidu.tieba.ala.alasquare.live_tab.model;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.adp.widget.ListView.m;
import com.baidu.ala.AlaCmdConfigHttp;
import com.baidu.mobstat.Config;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.ala.alasquare.subtablist.message.SdkLiveInfoListResponsedMessage;
import java.util.List;
/* loaded from: classes2.dex */
public class AlaLiveTabGameModel extends BdBaseModel {
    private boolean eil;
    private com.baidu.tieba.ala.alasquare.live_tab.c.a eim;
    private a ein;
    private boolean hasMore;
    private int mPn;
    private TbPageContext mTbPageContext;
    private HttpMessageListener eio = new HttpMessageListener(AlaCmdConfigHttp.CMD_ALA_GAME_LIVE_LIST) { // from class: com.baidu.tieba.ala.alasquare.live_tab.model.AlaLiveTabGameModel.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1021150 && (httpResponsedMessage instanceof SdkLiveInfoListResponsedMessage) && httpResponsedMessage.getOrginalMessage().getTag() == AlaLiveTabGameModel.this.mCurTag) {
                SdkLiveInfoListResponsedMessage sdkLiveInfoListResponsedMessage = (SdkLiveInfoListResponsedMessage) httpResponsedMessage;
                if (sdkLiveInfoListResponsedMessage.getError() != 0 || !sdkLiveInfoListResponsedMessage.isSuccess()) {
                    if (AlaLiveTabGameModel.this.ein != null) {
                        AlaLiveTabGameModel.this.ein.e(httpResponsedMessage.getError(), httpResponsedMessage.getErrorString(), AlaLiveTabGameModel.this.eil);
                    }
                } else {
                    if (AlaLiveTabGameModel.this.eil) {
                        AlaLiveTabGameModel.this.eim.j(sdkLiveInfoListResponsedMessage.getLiveList(), sdkLiveInfoListResponsedMessage.hasMore());
                    } else {
                        if (AlaLiveTabGameModel.this.eim != null) {
                            AlaLiveTabGameModel.this.eim.clear();
                        }
                        AlaLiveTabGameModel.this.eim = new com.baidu.tieba.ala.alasquare.live_tab.c.a(sdkLiveInfoListResponsedMessage.getLiveList(), sdkLiveInfoListResponsedMessage.hasMore());
                    }
                    AlaLiveTabGameModel.this.hasMore = AlaLiveTabGameModel.this.eim.hasMore();
                    AlaLiveTabGameModel.e(AlaLiveTabGameModel.this);
                    if (AlaLiveTabGameModel.this.ein != null) {
                        AlaLiveTabGameModel.this.ein.d(AlaLiveTabGameModel.this.hasMore, AlaLiveTabGameModel.this.eim.getData());
                    }
                }
                AlaLiveTabGameModel.this.eil = false;
            }
        }
    };
    private BdUniqueId mCurTag = BdUniqueId.gen();

    /* loaded from: classes2.dex */
    public interface a {
        void d(boolean z, List<m> list);

        void e(int i, String str, boolean z);
    }

    static /* synthetic */ int e(AlaLiveTabGameModel alaLiveTabGameModel) {
        int i = alaLiveTabGameModel.mPn;
        alaLiveTabGameModel.mPn = i + 1;
        return i;
    }

    public AlaLiveTabGameModel(TbPageContext tbPageContext, a aVar) {
        this.mTbPageContext = tbPageContext;
        this.ein = aVar;
    }

    public void init() {
        MessageManager.getInstance().registerListener(this.eio);
    }

    public void refresh() {
        this.eil = false;
        this.mPn = 1;
        on(this.mPn);
    }

    public void aZN() {
        if (this.hasMore && !this.eil) {
            this.eil = true;
            on(this.mPn);
        }
    }

    private void on(int i) {
        HttpMessage httpMessage = new HttpMessage(AlaCmdConfigHttp.CMD_ALA_GAME_LIVE_LIST);
        httpMessage.addParam("ps", 10);
        httpMessage.addParam(Config.PACKAGE_NAME, this.mPn);
        httpMessage.setTag(this.mCurTag);
        MessageManager.getInstance().sendMessage(httpMessage);
    }

    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.eio);
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
