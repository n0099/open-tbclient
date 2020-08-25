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
/* loaded from: classes4.dex */
public class AlaLiveTabGameModel extends BdBaseModel {
    private String eVt;
    private String fES;
    private boolean fFj;
    private com.baidu.tieba.ala.alasquare.live_tab.c.a fFk;
    private a fFl;
    private boolean hasMore;
    private int mPn;
    private TbPageContext mTbPageContext;
    private HttpMessageListener fFm = new HttpMessageListener(AlaCmdConfigHttp.CMD_ALA_GAME_LIVE_LIST) { // from class: com.baidu.tieba.ala.alasquare.live_tab.model.AlaLiveTabGameModel.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1021150 && (httpResponsedMessage instanceof SdkLiveInfoListResponsedMessage) && httpResponsedMessage.getOrginalMessage().getTag() == AlaLiveTabGameModel.this.mCurTag) {
                SdkLiveInfoListResponsedMessage sdkLiveInfoListResponsedMessage = (SdkLiveInfoListResponsedMessage) httpResponsedMessage;
                if (sdkLiveInfoListResponsedMessage.getError() != 0 || !sdkLiveInfoListResponsedMessage.isSuccess()) {
                    if (AlaLiveTabGameModel.this.fFl != null) {
                        AlaLiveTabGameModel.this.fFl.f(httpResponsedMessage.getError(), httpResponsedMessage.getErrorString(), AlaLiveTabGameModel.this.fFj);
                    }
                } else {
                    if (AlaLiveTabGameModel.this.fFj) {
                        AlaLiveTabGameModel.this.fFk.i(sdkLiveInfoListResponsedMessage.getLiveList(), sdkLiveInfoListResponsedMessage.hasMore());
                    } else {
                        if (AlaLiveTabGameModel.this.fFk != null) {
                            AlaLiveTabGameModel.this.fFk.clear();
                        }
                        AlaLiveTabGameModel.this.fFk = new com.baidu.tieba.ala.alasquare.live_tab.c.a(sdkLiveInfoListResponsedMessage.getLiveList(), sdkLiveInfoListResponsedMessage.hasMore(), AlaLiveTabGameModel.this.eVt, AlaLiveTabGameModel.this.fES);
                    }
                    AlaLiveTabGameModel.this.hasMore = AlaLiveTabGameModel.this.fFk.hasMore();
                    AlaLiveTabGameModel.g(AlaLiveTabGameModel.this);
                    if (AlaLiveTabGameModel.this.fFl != null) {
                        AlaLiveTabGameModel.this.fFl.f(AlaLiveTabGameModel.this.hasMore, AlaLiveTabGameModel.this.fFk.getData());
                    }
                }
                AlaLiveTabGameModel.this.fFj = false;
            }
        }
    };
    private BdUniqueId mCurTag = BdUniqueId.gen();

    /* loaded from: classes4.dex */
    public interface a {
        void f(int i, String str, boolean z);

        void f(boolean z, List<q> list);
    }

    static /* synthetic */ int g(AlaLiveTabGameModel alaLiveTabGameModel) {
        int i = alaLiveTabGameModel.mPn;
        alaLiveTabGameModel.mPn = i + 1;
        return i;
    }

    public AlaLiveTabGameModel(TbPageContext tbPageContext, a aVar) {
        this.mTbPageContext = tbPageContext;
        this.fFl = aVar;
    }

    public void init() {
        MessageManager.getInstance().registerListener(this.fFm);
    }

    public void refresh() {
        this.fFj = false;
        this.mPn = 1;
        sC(this.mPn);
    }

    public void bFD() {
        if (this.hasMore && !this.fFj) {
            this.fFj = true;
            sC(this.mPn);
        }
    }

    private void sC(int i) {
        HttpMessage httpMessage = new HttpMessage(AlaCmdConfigHttp.CMD_ALA_GAME_LIVE_LIST);
        httpMessage.addParam("ps", 20);
        httpMessage.addParam(Config.PACKAGE_NAME, this.mPn);
        httpMessage.addParam("fid", this.eVt);
        httpMessage.addParam("fname", this.fES);
        httpMessage.setTag(this.mCurTag);
        MessageManager.getInstance().sendMessage(httpMessage);
    }

    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.fFm);
    }

    @Override // com.baidu.adp.base.BdBaseModel
    protected boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        return false;
    }

    public void dS(String str, String str2) {
        this.eVt = str;
        this.fES = str2;
    }
}
