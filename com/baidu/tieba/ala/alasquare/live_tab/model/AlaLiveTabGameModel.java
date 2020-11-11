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
import com.baidu.tieba.ala.alasquare.live_tab.c.b;
import com.baidu.tieba.ala.alasquare.subtablist.message.SdkLiveInfoListResponsedMessage;
import java.util.List;
/* loaded from: classes4.dex */
public class AlaLiveTabGameModel extends BdBaseModel {
    private String fyR;
    private boolean gkG;
    private b gkM;
    private a gkN;
    private String gkl;
    private boolean hasMore;
    private int mPn;
    private TbPageContext mTbPageContext;
    private HttpMessageListener gkO = new HttpMessageListener(AlaCmdConfigHttp.CMD_ALA_GAME_LIVE_LIST) { // from class: com.baidu.tieba.ala.alasquare.live_tab.model.AlaLiveTabGameModel.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1021150 && (httpResponsedMessage instanceof SdkLiveInfoListResponsedMessage) && httpResponsedMessage.getOrginalMessage().getTag() == AlaLiveTabGameModel.this.mCurTag) {
                SdkLiveInfoListResponsedMessage sdkLiveInfoListResponsedMessage = (SdkLiveInfoListResponsedMessage) httpResponsedMessage;
                if (sdkLiveInfoListResponsedMessage.getError() != 0 || !sdkLiveInfoListResponsedMessage.isSuccess()) {
                    if (AlaLiveTabGameModel.this.gkN != null) {
                        AlaLiveTabGameModel.this.gkN.h(httpResponsedMessage.getError(), httpResponsedMessage.getErrorString(), AlaLiveTabGameModel.this.gkG);
                    }
                } else {
                    if (AlaLiveTabGameModel.this.gkG) {
                        AlaLiveTabGameModel.this.gkM.k(sdkLiveInfoListResponsedMessage.getLiveList(), sdkLiveInfoListResponsedMessage.hasMore());
                    } else {
                        if (AlaLiveTabGameModel.this.gkM != null) {
                            AlaLiveTabGameModel.this.gkM.clear();
                        }
                        AlaLiveTabGameModel.this.gkM = new b(sdkLiveInfoListResponsedMessage.getLiveList(), sdkLiveInfoListResponsedMessage.hasMore(), AlaLiveTabGameModel.this.fyR, AlaLiveTabGameModel.this.gkl);
                    }
                    AlaLiveTabGameModel.this.hasMore = AlaLiveTabGameModel.this.gkM.hasMore();
                    AlaLiveTabGameModel.g(AlaLiveTabGameModel.this);
                    if (AlaLiveTabGameModel.this.gkN != null) {
                        AlaLiveTabGameModel.this.gkN.e(AlaLiveTabGameModel.this.hasMore, AlaLiveTabGameModel.this.gkM.getData());
                    }
                }
                AlaLiveTabGameModel.this.gkG = false;
            }
        }
    };
    private BdUniqueId mCurTag = BdUniqueId.gen();

    /* loaded from: classes4.dex */
    public interface a {
        void e(boolean z, List<q> list);

        void h(int i, String str, boolean z);
    }

    static /* synthetic */ int g(AlaLiveTabGameModel alaLiveTabGameModel) {
        int i = alaLiveTabGameModel.mPn;
        alaLiveTabGameModel.mPn = i + 1;
        return i;
    }

    public AlaLiveTabGameModel(TbPageContext tbPageContext, a aVar) {
        this.mTbPageContext = tbPageContext;
        this.gkN = aVar;
    }

    public void init() {
        MessageManager.getInstance().registerListener(this.gkO);
    }

    public void refresh() {
        this.gkG = false;
        this.mPn = 1;
        tV(this.mPn);
    }

    public void bOI() {
        if (this.hasMore && !this.gkG) {
            this.gkG = true;
            tV(this.mPn);
        }
    }

    private void tV(int i) {
        HttpMessage httpMessage = new HttpMessage(AlaCmdConfigHttp.CMD_ALA_GAME_LIVE_LIST);
        httpMessage.addParam("ps", 20);
        httpMessage.addParam(Config.PACKAGE_NAME, this.mPn);
        httpMessage.addParam("fid", this.fyR);
        httpMessage.addParam("fname", this.gkl);
        httpMessage.setTag(this.mCurTag);
        MessageManager.getInstance().sendMessage(httpMessage);
    }

    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.gkO);
    }

    @Override // com.baidu.adp.base.BdBaseModel
    protected boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        return false;
    }

    public void ei(String str, String str2) {
        this.fyR = str;
        this.gkl = str2;
    }
}
