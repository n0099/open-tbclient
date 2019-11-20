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
import com.baidu.tieba.ala.alasquare.live_tab.b.h;
import com.baidu.tieba.ala.alasquare.live_tab.message.AlaTabLiveResponsedMessage;
import java.util.List;
/* loaded from: classes6.dex */
public class AlaLiveTabModel extends BdBaseModel {
    private boolean dwD;
    private com.baidu.tieba.ala.alasquare.live_tab.c.a dwE;
    private a dwF;
    private boolean hasMore;
    private int mPn;
    private TbPageContext mTbPageContext;
    private HttpMessageListener dwG = new HttpMessageListener(AlaCmdConfigHttp.CMD_ALA_GET_TAB_LIVE_INFO) { // from class: com.baidu.tieba.ala.alasquare.live_tab.model.AlaLiveTabModel.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1021141 && (httpResponsedMessage instanceof AlaTabLiveResponsedMessage) && httpResponsedMessage.getOrginalMessage().getTag() == AlaLiveTabModel.this.mCurTag) {
                AlaTabLiveResponsedMessage alaTabLiveResponsedMessage = (AlaTabLiveResponsedMessage) httpResponsedMessage;
                if (alaTabLiveResponsedMessage.getError() != 0 || !alaTabLiveResponsedMessage.isSuccess()) {
                    if (AlaLiveTabModel.this.dwF != null) {
                        AlaLiveTabModel.this.dwF.d(httpResponsedMessage.getError(), httpResponsedMessage.getErrorString(), AlaLiveTabModel.this.dwD);
                    }
                } else {
                    h hVar = alaTabLiveResponsedMessage.tabAllLiveInfo;
                    if (AlaLiveTabModel.this.dwD) {
                        AlaLiveTabModel.this.dwE.a(hVar);
                        AlaLiveTabModel.e(AlaLiveTabModel.this);
                    } else {
                        if (AlaLiveTabModel.this.dwE != null) {
                            AlaLiveTabModel.this.dwE.clear();
                        }
                        AlaLiveTabModel.this.dwE = new com.baidu.tieba.ala.alasquare.live_tab.c.a(alaTabLiveResponsedMessage);
                    }
                    AlaLiveTabModel.this.hasMore = AlaLiveTabModel.this.dwE.hasMore();
                    if (AlaLiveTabModel.this.dwF != null) {
                        AlaLiveTabModel.this.dwF.a(AlaLiveTabModel.this.hasMore, AlaLiveTabModel.this.dwE.aJD(), AlaLiveTabModel.this.dwE.getData());
                    }
                }
                AlaLiveTabModel.this.dwD = false;
            }
        }
    };
    private BdUniqueId mCurTag = BdUniqueId.gen();

    /* loaded from: classes6.dex */
    public interface a {
        void a(boolean z, boolean z2, List<m> list);

        void d(int i, String str, boolean z);
    }

    static /* synthetic */ int e(AlaLiveTabModel alaLiveTabModel) {
        int i = alaLiveTabModel.mPn;
        alaLiveTabModel.mPn = i + 1;
        return i;
    }

    public AlaLiveTabModel(TbPageContext tbPageContext, a aVar) {
        this.mTbPageContext = tbPageContext;
        this.dwF = aVar;
    }

    public void init() {
        MessageManager.getInstance().registerListener(this.dwG);
    }

    public void refresh() {
        this.dwD = false;
        this.mPn = 1;
        me(this.mPn);
    }

    public void aIU() {
        if (this.hasMore && !this.dwD) {
            this.dwD = true;
            me(this.mPn + 1);
        }
    }

    private void me(int i) {
        HttpMessage httpMessage = new HttpMessage(AlaCmdConfigHttp.CMD_ALA_GET_TAB_LIVE_INFO);
        httpMessage.addParam(Config.PACKAGE_NAME, i);
        httpMessage.setTag(this.mCurTag);
        MessageManager.getInstance().sendMessage(httpMessage);
    }

    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.dwG);
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
