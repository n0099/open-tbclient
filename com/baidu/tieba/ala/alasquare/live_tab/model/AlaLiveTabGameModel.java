package com.baidu.tieba.ala.alasquare.live_tab.model;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.adp.widget.ListView.q;
import com.baidu.ala.AlaCmdConfigHttp;
import com.baidu.mobstat.Config;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.ala.alasquare.subtablist.message.SdkLiveInfoListResponsedMessage;
import java.util.List;
/* loaded from: classes3.dex */
public class AlaLiveTabGameModel extends BdBaseModel {
    private String eEs;
    private boolean foF;
    private com.baidu.tieba.ala.alasquare.live_tab.c.a foG;
    private a foH;
    private String foo;
    private boolean hasMore;
    private int mPn;
    private TbPageContext mTbPageContext;
    private HttpMessageListener foI = new HttpMessageListener(AlaCmdConfigHttp.CMD_ALA_GAME_LIVE_LIST) { // from class: com.baidu.tieba.ala.alasquare.live_tab.model.AlaLiveTabGameModel.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1021150 && (httpResponsedMessage instanceof SdkLiveInfoListResponsedMessage) && httpResponsedMessage.getOrginalMessage().getTag() == AlaLiveTabGameModel.this.mCurTag) {
                SdkLiveInfoListResponsedMessage sdkLiveInfoListResponsedMessage = (SdkLiveInfoListResponsedMessage) httpResponsedMessage;
                if (sdkLiveInfoListResponsedMessage.getError() != 0 || !sdkLiveInfoListResponsedMessage.isSuccess()) {
                    if (AlaLiveTabGameModel.this.foH != null) {
                        AlaLiveTabGameModel.this.foH.g(httpResponsedMessage.getError(), httpResponsedMessage.getErrorString(), AlaLiveTabGameModel.this.foF);
                    }
                } else {
                    if (AlaLiveTabGameModel.this.foF) {
                        AlaLiveTabGameModel.this.foG.k(sdkLiveInfoListResponsedMessage.getLiveList(), sdkLiveInfoListResponsedMessage.hasMore());
                    } else {
                        if (AlaLiveTabGameModel.this.foG != null) {
                            AlaLiveTabGameModel.this.foG.clear();
                        }
                        AlaLiveTabGameModel.this.foG = new com.baidu.tieba.ala.alasquare.live_tab.c.a(sdkLiveInfoListResponsedMessage.getLiveList(), sdkLiveInfoListResponsedMessage.hasMore(), AlaLiveTabGameModel.this.eEs, AlaLiveTabGameModel.this.foo);
                    }
                    AlaLiveTabGameModel.this.hasMore = AlaLiveTabGameModel.this.foG.hasMore();
                    AlaLiveTabGameModel.g(AlaLiveTabGameModel.this);
                    if (AlaLiveTabGameModel.this.foH != null) {
                        AlaLiveTabGameModel.this.foH.e(AlaLiveTabGameModel.this.hasMore, AlaLiveTabGameModel.this.foG.getData());
                    }
                }
                AlaLiveTabGameModel.this.foF = false;
            }
        }
    };
    private BdUniqueId mCurTag = BdUniqueId.gen();

    /* loaded from: classes3.dex */
    public interface a {
        void e(boolean z, List<q> list);

        void g(int i, String str, boolean z);
    }

    static /* synthetic */ int g(AlaLiveTabGameModel alaLiveTabGameModel) {
        int i = alaLiveTabGameModel.mPn;
        alaLiveTabGameModel.mPn = i + 1;
        return i;
    }

    public AlaLiveTabGameModel(TbPageContext tbPageContext, a aVar) {
        this.mTbPageContext = tbPageContext;
        this.foH = aVar;
    }

    public void init() {
        MessageManager.getInstance().registerListener(this.foI);
    }

    public void refresh() {
        this.foF = false;
        this.mPn = 1;
        qb(this.mPn);
    }

    public void btv() {
        if (this.hasMore && !this.foF) {
            this.foF = true;
            qb(this.mPn);
        }
    }

    private void qb(int i) {
        HttpMessage httpMessage = new HttpMessage(AlaCmdConfigHttp.CMD_ALA_GAME_LIVE_LIST);
        httpMessage.addParam("ps", 20);
        httpMessage.addParam(Config.PACKAGE_NAME, this.mPn);
        httpMessage.addParam("fid", this.eEs);
        httpMessage.addParam("fname", this.foo);
        httpMessage.setTag(this.mCurTag);
        MessageManager.getInstance().sendMessage(httpMessage);
    }

    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.foI);
    }

    @Override // com.baidu.adp.base.BdBaseModel
    protected boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        return false;
    }

    public void dC(String str, String str2) {
        this.eEs = str;
        this.foo = str2;
    }
}
