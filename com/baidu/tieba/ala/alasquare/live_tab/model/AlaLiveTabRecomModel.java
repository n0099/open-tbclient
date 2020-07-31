package com.baidu.tieba.ala.alasquare.live_tab.model;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.adp.lib.util.l;
import com.baidu.adp.widget.ListView.q;
import com.baidu.ala.AlaCmdConfigCustom;
import com.baidu.ala.AlaCmdConfigHttp;
import com.baidu.live.tbadk.pagestayduration.PageStayDurationHelper;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.ala.alasquare.live_tab.AlaLiveTabFragment;
import com.baidu.tieba.ala.alasquare.live_tab.b.j;
import com.baidu.tieba.ala.alasquare.live_tab.c.b;
import com.baidu.tieba.ala.alasquare.live_tab.message.AlaTabLiveResponsedMessage;
import java.util.List;
/* loaded from: classes4.dex */
public class AlaLiveTabRecomModel extends BdBaseModel {
    private boolean ftQ;
    private b ftV;
    private long ftW;
    private a ftX;
    private boolean hasMore;
    private int mPn;
    private TbPageContext mTbPageContext;
    private HttpMessageListener ftY = new HttpMessageListener(AlaCmdConfigHttp.CMD_ALA_GET_TAB_LIVE_INFO) { // from class: com.baidu.tieba.ala.alasquare.live_tab.model.AlaLiveTabRecomModel.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1021141 && (httpResponsedMessage instanceof AlaTabLiveResponsedMessage) && httpResponsedMessage.getOrginalMessage().getTag() == AlaLiveTabRecomModel.this.mCurTag) {
                AlaTabLiveResponsedMessage alaTabLiveResponsedMessage = (AlaTabLiveResponsedMessage) httpResponsedMessage;
                com.baidu.tieba.ala.alasquare.live_tab.b.b bVar = new com.baidu.tieba.ala.alasquare.live_tab.b.b();
                if (alaTabLiveResponsedMessage.getError() != 0 || !alaTabLiveResponsedMessage.isSuccess()) {
                    if (AlaLiveTabRecomModel.this.ftX != null) {
                        AlaLiveTabRecomModel.this.ftX.g(httpResponsedMessage.getError(), httpResponsedMessage.getErrorString(), AlaLiveTabRecomModel.this.ftQ);
                    }
                    bVar.isSuccess = false;
                    bVar.errCode = httpResponsedMessage.getError();
                    bVar.errMsg = httpResponsedMessage.getErrorString();
                } else {
                    j jVar = alaTabLiveResponsedMessage.tabAllLiveInfo;
                    if (AlaLiveTabRecomModel.this.ftQ) {
                        AlaLiveTabRecomModel.this.ftV.a(jVar);
                        AlaLiveTabRecomModel.e(AlaLiveTabRecomModel.this);
                    } else {
                        AlaLiveTabFragment.fsK++;
                        if (AlaLiveTabRecomModel.this.ftV != null) {
                            AlaLiveTabRecomModel.this.ftV.clear();
                        }
                        AlaLiveTabRecomModel.this.ftV = new b(alaTabLiveResponsedMessage);
                    }
                    AlaLiveTabRecomModel.this.hasMore = AlaLiveTabRecomModel.this.ftV.hasMore();
                    if (AlaLiveTabRecomModel.this.ftX != null) {
                        AlaLiveTabRecomModel.this.ftX.e(AlaLiveTabRecomModel.this.hasMore, AlaLiveTabRecomModel.this.ftV.getData());
                    }
                    bVar.isSuccess = true;
                }
                bVar.isLoadMore = AlaLiveTabRecomModel.this.ftQ;
                bVar.superEntranceInfo = alaTabLiveResponsedMessage.superEntranceInfo;
                AlaLiveTabRecomModel.this.a(bVar);
                AlaLiveTabRecomModel.this.ftQ = false;
            }
        }
    };
    private BdUniqueId mCurTag = BdUniqueId.gen();

    /* loaded from: classes4.dex */
    public interface a {
        void e(boolean z, List<q> list);

        void g(int i, String str, boolean z);
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
        this.ftX = aVar;
    }

    public void init() {
        MessageManager.getInstance().registerListener(this.ftY);
    }

    public void refresh() {
        this.ftW = System.currentTimeMillis();
        this.ftQ = false;
        this.mPn = 1;
        E(this.mPn, 0, AlaLiveTabFragment.fsK);
    }

    public void bwE() {
        if (this.hasMore && !this.ftQ) {
            long currentTimeMillis = System.currentTimeMillis();
            if (currentTimeMillis - this.ftW >= 1800000) {
                this.ftW = currentTimeMillis;
            }
            this.ftQ = true;
            E(this.mPn + 1, 1, AlaLiveTabFragment.fsK - 1);
        }
    }

    private void E(int i, int i2, int i3) {
        HttpMessage httpMessage = new HttpMessage(AlaCmdConfigHttp.CMD_ALA_GET_TAB_LIVE_INFO);
        httpMessage.addParam("tab_id", 1);
        String str = "N";
        if (!com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
            str = "N";
        } else if (com.baidu.adp.lib.util.j.isWifiNet()) {
            str = "1_0";
        } else if (com.baidu.adp.lib.util.j.is4GNet()) {
            str = "0_13";
        } else if (com.baidu.adp.lib.util.j.is3GNet()) {
            str = "0_3";
        } else if (com.baidu.adp.lib.util.j.is2GNet()) {
            str = "0_2";
        }
        httpMessage.addParam("network", str);
        httpMessage.addParam("ua_str", l.getEquipmentWidth(this.mTbPageContext.getPageActivity()) + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + l.getEquipmentHeight(this.mTbPageContext.getPageActivity()) + "_android_" + TbConfig.getVersion());
        httpMessage.addParam("session_id", this.ftW);
        httpMessage.addParam("refresh_type", i2);
        httpMessage.addParam("big_refresh_count", i3);
        httpMessage.setTag(this.mCurTag);
        MessageManager.getInstance().sendMessage(httpMessage);
    }

    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.ftY);
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
