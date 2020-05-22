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
    private String fcT;
    private boolean fdk;
    private com.baidu.tieba.ala.alasquare.live_tab.c.a fdl;
    private a fdm;
    private boolean hasMore;
    private int mPn;
    private TbPageContext mTbPageContext;
    private HttpMessageListener fdn = new HttpMessageListener(AlaCmdConfigHttp.CMD_ALA_GAME_LIVE_LIST) { // from class: com.baidu.tieba.ala.alasquare.live_tab.model.AlaLiveTabGameModel.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1021150 && (httpResponsedMessage instanceof SdkLiveInfoListResponsedMessage) && httpResponsedMessage.getOrginalMessage().getTag() == AlaLiveTabGameModel.this.mCurTag) {
                SdkLiveInfoListResponsedMessage sdkLiveInfoListResponsedMessage = (SdkLiveInfoListResponsedMessage) httpResponsedMessage;
                if (sdkLiveInfoListResponsedMessage.getError() != 0 || !sdkLiveInfoListResponsedMessage.isSuccess()) {
                    if (AlaLiveTabGameModel.this.fdm != null) {
                        AlaLiveTabGameModel.this.fdm.g(httpResponsedMessage.getError(), httpResponsedMessage.getErrorString(), AlaLiveTabGameModel.this.fdk);
                    }
                } else {
                    if (AlaLiveTabGameModel.this.fdk) {
                        AlaLiveTabGameModel.this.fdl.k(sdkLiveInfoListResponsedMessage.getLiveList(), sdkLiveInfoListResponsedMessage.hasMore());
                    } else {
                        if (AlaLiveTabGameModel.this.fdl != null) {
                            AlaLiveTabGameModel.this.fdl.clear();
                        }
                        AlaLiveTabGameModel.this.fdl = new com.baidu.tieba.ala.alasquare.live_tab.c.a(sdkLiveInfoListResponsedMessage.getLiveList(), sdkLiveInfoListResponsedMessage.hasMore(), AlaLiveTabGameModel.this.evm, AlaLiveTabGameModel.this.fcT);
                    }
                    AlaLiveTabGameModel.this.hasMore = AlaLiveTabGameModel.this.fdl.hasMore();
                    AlaLiveTabGameModel.g(AlaLiveTabGameModel.this);
                    if (AlaLiveTabGameModel.this.fdm != null) {
                        AlaLiveTabGameModel.this.fdm.d(AlaLiveTabGameModel.this.hasMore, AlaLiveTabGameModel.this.fdl.getData());
                    }
                }
                AlaLiveTabGameModel.this.fdk = false;
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
        this.fdm = aVar;
    }

    public void init() {
        MessageManager.getInstance().registerListener(this.fdn);
    }

    public void refresh() {
        this.fdk = false;
        this.mPn = 1;
        pA(this.mPn);
    }

    public void bqv() {
        if (this.hasMore && !this.fdk) {
            this.fdk = true;
            pA(this.mPn);
        }
    }

    private void pA(int i) {
        HttpMessage httpMessage = new HttpMessage(AlaCmdConfigHttp.CMD_ALA_GAME_LIVE_LIST);
        httpMessage.addParam("ps", 20);
        httpMessage.addParam(Config.PACKAGE_NAME, this.mPn);
        httpMessage.addParam("fid", this.evm);
        httpMessage.addParam("fname", this.fcT);
        httpMessage.setTag(this.mCurTag);
        MessageManager.getInstance().sendMessage(httpMessage);
    }

    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.fdn);
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
        this.fcT = str2;
    }
}
