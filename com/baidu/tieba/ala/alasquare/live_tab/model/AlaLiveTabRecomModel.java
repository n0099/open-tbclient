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
import com.baidu.tieba.ala.alasquare.live_tab.b.b;
import com.baidu.tieba.ala.alasquare.live_tab.b.j;
import com.baidu.tieba.ala.alasquare.live_tab.c.c;
import com.baidu.tieba.ala.alasquare.live_tab.message.AlaTabLiveResponsedMessage;
import java.util.List;
/* loaded from: classes4.dex */
public class AlaLiveTabRecomModel extends BdBaseModel {
    private boolean gkG;
    private long gkI;
    private c gkQ;
    private a gkR;
    private boolean hasMore;
    private int mPn;
    private TbPageContext mTbPageContext;
    private HttpMessageListener gkK = new HttpMessageListener(AlaCmdConfigHttp.CMD_ALA_GET_TAB_LIVE_INFO) { // from class: com.baidu.tieba.ala.alasquare.live_tab.model.AlaLiveTabRecomModel.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1021141 && (httpResponsedMessage instanceof AlaTabLiveResponsedMessage) && httpResponsedMessage.getOrginalMessage().getTag() == AlaLiveTabRecomModel.this.mCurTag) {
                AlaTabLiveResponsedMessage alaTabLiveResponsedMessage = (AlaTabLiveResponsedMessage) httpResponsedMessage;
                b bVar = new b();
                if (alaTabLiveResponsedMessage.getError() != 0 || !alaTabLiveResponsedMessage.isSuccess()) {
                    if (AlaLiveTabRecomModel.this.gkR != null) {
                        AlaLiveTabRecomModel.this.gkR.h(httpResponsedMessage.getError(), httpResponsedMessage.getErrorString(), AlaLiveTabRecomModel.this.gkG);
                    }
                    bVar.isSuccess = false;
                    bVar.errCode = httpResponsedMessage.getError();
                    bVar.errMsg = httpResponsedMessage.getErrorString();
                } else {
                    j jVar = alaTabLiveResponsedMessage.tabAllLiveInfo;
                    if (AlaLiveTabRecomModel.this.gkG) {
                        AlaLiveTabRecomModel.this.gkQ.a(jVar);
                        AlaLiveTabRecomModel.e(AlaLiveTabRecomModel.this);
                    } else {
                        AlaLiveTabFragment.gjw++;
                        if (AlaLiveTabRecomModel.this.gkQ != null) {
                            AlaLiveTabRecomModel.this.gkQ.clear();
                        }
                        AlaLiveTabRecomModel.this.gkQ = new c(alaTabLiveResponsedMessage);
                    }
                    AlaLiveTabRecomModel.this.hasMore = AlaLiveTabRecomModel.this.gkQ.hasMore();
                    if (AlaLiveTabRecomModel.this.gkR != null) {
                        AlaLiveTabRecomModel.this.gkR.e(AlaLiveTabRecomModel.this.hasMore, AlaLiveTabRecomModel.this.gkQ.getData());
                    }
                    bVar.isSuccess = true;
                }
                bVar.isLoadMore = AlaLiveTabRecomModel.this.gkG;
                bVar.superEntranceInfo = alaTabLiveResponsedMessage.superEntranceInfo;
                AlaLiveTabRecomModel.this.a(bVar);
                AlaLiveTabRecomModel.this.gkG = false;
            }
        }
    };
    private BdUniqueId mCurTag = BdUniqueId.gen();

    /* loaded from: classes4.dex */
    public interface a {
        void e(boolean z, List<q> list);

        void h(int i, String str, boolean z);
    }

    static /* synthetic */ int e(AlaLiveTabRecomModel alaLiveTabRecomModel) {
        int i = alaLiveTabRecomModel.mPn;
        alaLiveTabRecomModel.mPn = i + 1;
        return i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(b bVar) {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(AlaCmdConfigCustom.CMD_ALA_LIVE_TAB_RESPONSE, bVar));
    }

    public AlaLiveTabRecomModel(TbPageContext tbPageContext, a aVar) {
        this.mTbPageContext = tbPageContext;
        this.gkR = aVar;
    }

    public void init() {
        MessageManager.getInstance().registerListener(this.gkK);
    }

    public void refresh() {
        this.gkI = System.currentTimeMillis();
        this.gkG = false;
        this.mPn = 1;
        J(this.mPn, 0, AlaLiveTabFragment.gjw);
    }

    public void bOI() {
        if (this.hasMore && !this.gkG) {
            long currentTimeMillis = System.currentTimeMillis();
            if (currentTimeMillis - this.gkI >= 1800000) {
                this.gkI = currentTimeMillis;
            }
            this.gkG = true;
            J(this.mPn + 1, 1, AlaLiveTabFragment.gjw - 1);
        }
    }

    private void J(int i, int i2, int i3) {
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
        httpMessage.addParam("session_id", this.gkI);
        httpMessage.addParam("refresh_type", i2);
        httpMessage.addParam("big_refresh_count", i3);
        httpMessage.setTag(this.mCurTag);
        MessageManager.getInstance().sendMessage(httpMessage);
    }

    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.gkK);
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
