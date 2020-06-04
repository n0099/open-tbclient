package com.baidu.tieba.ala.alasquare.live_tab.model;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.adp.lib.util.l;
import com.baidu.adp.widget.ListView.o;
import com.baidu.ala.AlaCmdConfigHttp;
import com.baidu.live.tbadk.pagestayduration.PageStayDurationHelper;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.ala.alasquare.live_tab.AlaLiveTabFragment;
import com.baidu.tieba.ala.alasquare.live_tab.b.j;
import com.baidu.tieba.ala.alasquare.live_tab.c.c;
import com.baidu.tieba.ala.alasquare.live_tab.message.AlaTabLiveResponsedMessage;
import java.util.List;
/* loaded from: classes3.dex */
public class AlaLiveTabYanzhiModel extends BdBaseModel {
    private String evm;
    private long fdB;
    private c fdF;
    private a fdG;
    private String fde;
    private boolean fdv;
    private boolean hasMore;
    private int mPn;
    private TbPageContext mTbPageContext;
    private HttpMessageListener fdH = new HttpMessageListener(AlaCmdConfigHttp.CMD_ALA_GET_TAB_LIVE_INFO) { // from class: com.baidu.tieba.ala.alasquare.live_tab.model.AlaLiveTabYanzhiModel.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1021141 && (httpResponsedMessage instanceof AlaTabLiveResponsedMessage) && httpResponsedMessage.getOrginalMessage().getTag() == AlaLiveTabYanzhiModel.this.mCurTag) {
                AlaTabLiveResponsedMessage alaTabLiveResponsedMessage = (AlaTabLiveResponsedMessage) httpResponsedMessage;
                if (alaTabLiveResponsedMessage.getError() != 0 || !alaTabLiveResponsedMessage.isSuccess()) {
                    if (AlaLiveTabYanzhiModel.this.fdG != null) {
                        AlaLiveTabYanzhiModel.this.fdG.g(httpResponsedMessage.getError(), httpResponsedMessage.getErrorString(), AlaLiveTabYanzhiModel.this.fdv);
                    }
                } else {
                    j jVar = alaTabLiveResponsedMessage.tabAllLiveInfo;
                    if (AlaLiveTabYanzhiModel.this.fdv) {
                        AlaLiveTabYanzhiModel.this.fdF.a(jVar);
                        AlaLiveTabYanzhiModel.e(AlaLiveTabYanzhiModel.this);
                    } else {
                        AlaLiveTabFragment.fcs++;
                        if (AlaLiveTabYanzhiModel.this.fdF != null) {
                            AlaLiveTabYanzhiModel.this.fdF.clear();
                        }
                        AlaLiveTabYanzhiModel.this.fdF = new c(jVar, AlaLiveTabYanzhiModel.this.evm, AlaLiveTabYanzhiModel.this.fde);
                    }
                    AlaLiveTabYanzhiModel.this.hasMore = AlaLiveTabYanzhiModel.this.fdF.hasMore();
                    if (AlaLiveTabYanzhiModel.this.fdG != null) {
                        AlaLiveTabYanzhiModel.this.fdG.d(AlaLiveTabYanzhiModel.this.hasMore, AlaLiveTabYanzhiModel.this.fdF.getData());
                    }
                }
                AlaLiveTabYanzhiModel.this.fdv = false;
            }
        }
    };
    private BdUniqueId mCurTag = BdUniqueId.gen();

    /* loaded from: classes3.dex */
    public interface a {
        void d(boolean z, List<o> list);

        void g(int i, String str, boolean z);
    }

    static /* synthetic */ int e(AlaLiveTabYanzhiModel alaLiveTabYanzhiModel) {
        int i = alaLiveTabYanzhiModel.mPn;
        alaLiveTabYanzhiModel.mPn = i + 1;
        return i;
    }

    public AlaLiveTabYanzhiModel(TbPageContext tbPageContext, a aVar) {
        this.mTbPageContext = tbPageContext;
        this.fdG = aVar;
    }

    public void init() {
        MessageManager.getInstance().registerListener(this.fdH);
    }

    public void refresh() {
        this.fdB = System.currentTimeMillis();
        this.fdv = false;
        this.mPn = 1;
        I(this.mPn, 0, AlaLiveTabFragment.fcs);
    }

    public void bqx() {
        if (this.hasMore && !this.fdv) {
            long currentTimeMillis = System.currentTimeMillis();
            if (currentTimeMillis - this.fdB >= 1800000) {
                this.fdB = currentTimeMillis;
            }
            this.fdv = true;
            I(this.mPn + 1, 1, AlaLiveTabFragment.fcs - 1);
        }
    }

    private void I(int i, int i2, int i3) {
        HttpMessage httpMessage = new HttpMessage(AlaCmdConfigHttp.CMD_ALA_GET_TAB_LIVE_INFO);
        httpMessage.addParam("tab_id", 2);
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
        httpMessage.addParam("session_id", this.fdB);
        httpMessage.addParam("refresh_type", i2);
        httpMessage.addParam("big_refresh_count", i3);
        httpMessage.addParam("fid", this.evm);
        httpMessage.addParam("fname", this.fde);
        httpMessage.setTag(this.mCurTag);
        MessageManager.getInstance().sendMessage(httpMessage);
    }

    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.fdH);
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
