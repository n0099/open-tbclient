package com.baidu.tieba.ala.alasquare.live_tab.model;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.adp.widget.ListView.o;
import com.baidu.ala.AlaCmdConfigHttp;
import com.baidu.mobstat.Config;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.ala.alasquare.subtablist.message.SdkLiveInfoListResponsedMessage;
import java.util.List;
/* loaded from: classes3.dex */
public class AlaLiveTabGameModel extends BdBaseModel {
    private String evm;
    private String fde;
    private boolean fdv;
    private com.baidu.tieba.ala.alasquare.live_tab.c.a fdw;
    private a fdx;
    private boolean hasMore;
    private int mPn;
    private TbPageContext mTbPageContext;
    private HttpMessageListener fdy = new HttpMessageListener(AlaCmdConfigHttp.CMD_ALA_GAME_LIVE_LIST) { // from class: com.baidu.tieba.ala.alasquare.live_tab.model.AlaLiveTabGameModel.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1021150 && (httpResponsedMessage instanceof SdkLiveInfoListResponsedMessage) && httpResponsedMessage.getOrginalMessage().getTag() == AlaLiveTabGameModel.this.mCurTag) {
                SdkLiveInfoListResponsedMessage sdkLiveInfoListResponsedMessage = (SdkLiveInfoListResponsedMessage) httpResponsedMessage;
                if (sdkLiveInfoListResponsedMessage.getError() != 0 || !sdkLiveInfoListResponsedMessage.isSuccess()) {
                    if (AlaLiveTabGameModel.this.fdx != null) {
                        AlaLiveTabGameModel.this.fdx.g(httpResponsedMessage.getError(), httpResponsedMessage.getErrorString(), AlaLiveTabGameModel.this.fdv);
                    }
                } else {
                    if (AlaLiveTabGameModel.this.fdv) {
                        AlaLiveTabGameModel.this.fdw.k(sdkLiveInfoListResponsedMessage.getLiveList(), sdkLiveInfoListResponsedMessage.hasMore());
                    } else {
                        if (AlaLiveTabGameModel.this.fdw != null) {
                            AlaLiveTabGameModel.this.fdw.clear();
                        }
                        AlaLiveTabGameModel.this.fdw = new com.baidu.tieba.ala.alasquare.live_tab.c.a(sdkLiveInfoListResponsedMessage.getLiveList(), sdkLiveInfoListResponsedMessage.hasMore(), AlaLiveTabGameModel.this.evm, AlaLiveTabGameModel.this.fde);
                    }
                    AlaLiveTabGameModel.this.hasMore = AlaLiveTabGameModel.this.fdw.hasMore();
                    AlaLiveTabGameModel.g(AlaLiveTabGameModel.this);
                    if (AlaLiveTabGameModel.this.fdx != null) {
                        AlaLiveTabGameModel.this.fdx.d(AlaLiveTabGameModel.this.hasMore, AlaLiveTabGameModel.this.fdw.getData());
                    }
                }
                AlaLiveTabGameModel.this.fdv = false;
            }
        }
    };
    private BdUniqueId mCurTag = BdUniqueId.gen();

    /* loaded from: classes3.dex */
    public interface a {
        void d(boolean z, List<o> list);

        void g(int i, String str, boolean z);
    }

    static /* synthetic */ int g(AlaLiveTabGameModel alaLiveTabGameModel) {
        int i = alaLiveTabGameModel.mPn;
        alaLiveTabGameModel.mPn = i + 1;
        return i;
    }

    public AlaLiveTabGameModel(TbPageContext tbPageContext, a aVar) {
        this.mTbPageContext = tbPageContext;
        this.fdx = aVar;
    }

    public void init() {
        MessageManager.getInstance().registerListener(this.fdy);
    }

    public void refresh() {
        this.fdv = false;
        this.mPn = 1;
        pC(this.mPn);
    }

    public void bqx() {
        if (this.hasMore && !this.fdv) {
            this.fdv = true;
            pC(this.mPn);
        }
    }

    private void pC(int i) {
        HttpMessage httpMessage = new HttpMessage(AlaCmdConfigHttp.CMD_ALA_GAME_LIVE_LIST);
        httpMessage.addParam("ps", 20);
        httpMessage.addParam(Config.PACKAGE_NAME, this.mPn);
        httpMessage.addParam("fid", this.evm);
        httpMessage.addParam("fname", this.fde);
        httpMessage.setTag(this.mCurTag);
        MessageManager.getInstance().sendMessage(httpMessage);
    }

    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.fdy);
    }

    @Override // com.baidu.adp.base.BdBaseModel
    protected boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        return false;
    }

    public void dy(String str, String str2) {
        this.evm = str;
        this.fde = str2;
    }
}
