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
/* loaded from: classes6.dex */
public class AlaLiveTabGameModel extends BdBaseModel {
    private String fFV;
    private b gsE;
    private a gsF;
    private String gsd;
    private boolean gsy;
    private boolean hasMore;
    private int mPn;
    private TbPageContext mTbPageContext;
    private HttpMessageListener gsG = new HttpMessageListener(AlaCmdConfigHttp.CMD_ALA_GAME_LIVE_LIST) { // from class: com.baidu.tieba.ala.alasquare.live_tab.model.AlaLiveTabGameModel.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1021150 && (httpResponsedMessage instanceof SdkLiveInfoListResponsedMessage) && httpResponsedMessage.getOrginalMessage().getTag() == AlaLiveTabGameModel.this.mCurTag) {
                SdkLiveInfoListResponsedMessage sdkLiveInfoListResponsedMessage = (SdkLiveInfoListResponsedMessage) httpResponsedMessage;
                if (sdkLiveInfoListResponsedMessage.getError() != 0 || !sdkLiveInfoListResponsedMessage.isSuccess()) {
                    if (AlaLiveTabGameModel.this.gsF != null) {
                        AlaLiveTabGameModel.this.gsF.h(httpResponsedMessage.getError(), httpResponsedMessage.getErrorString(), AlaLiveTabGameModel.this.gsy);
                    }
                } else {
                    if (AlaLiveTabGameModel.this.gsy) {
                        AlaLiveTabGameModel.this.gsE.l(sdkLiveInfoListResponsedMessage.getLiveList(), sdkLiveInfoListResponsedMessage.hasMore());
                    } else {
                        if (AlaLiveTabGameModel.this.gsE != null) {
                            AlaLiveTabGameModel.this.gsE.clear();
                        }
                        AlaLiveTabGameModel.this.gsE = new b(sdkLiveInfoListResponsedMessage.getLiveList(), sdkLiveInfoListResponsedMessage.hasMore(), AlaLiveTabGameModel.this.fFV, AlaLiveTabGameModel.this.gsd);
                    }
                    AlaLiveTabGameModel.this.hasMore = AlaLiveTabGameModel.this.gsE.hasMore();
                    AlaLiveTabGameModel.g(AlaLiveTabGameModel.this);
                    if (AlaLiveTabGameModel.this.gsF != null) {
                        AlaLiveTabGameModel.this.gsF.e(AlaLiveTabGameModel.this.hasMore, AlaLiveTabGameModel.this.gsE.getData());
                    }
                }
                AlaLiveTabGameModel.this.gsy = false;
            }
        }
    };
    private BdUniqueId mCurTag = BdUniqueId.gen();

    /* loaded from: classes6.dex */
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
        this.gsF = aVar;
    }

    public void init() {
        MessageManager.getInstance().registerListener(this.gsG);
    }

    public void refresh() {
        this.gsy = false;
        this.mPn = 1;
        uX(this.mPn);
    }

    public void bRN() {
        if (this.hasMore && !this.gsy) {
            this.gsy = true;
            uX(this.mPn);
        }
    }

    private void uX(int i) {
        HttpMessage httpMessage = new HttpMessage(AlaCmdConfigHttp.CMD_ALA_GAME_LIVE_LIST);
        httpMessage.addParam("ps", 20);
        httpMessage.addParam(Config.PACKAGE_NAME, this.mPn);
        httpMessage.addParam("fid", this.fFV);
        httpMessage.addParam("fname", this.gsd);
        httpMessage.setTag(this.mCurTag);
        MessageManager.getInstance().sendMessage(httpMessage);
    }

    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.gsG);
    }

    @Override // com.baidu.adp.base.BdBaseModel
    protected boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        return false;
    }

    public void ek(String str, String str2) {
        this.fFV = str;
        this.gsd = str2;
    }
}
