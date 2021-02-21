package com.baidu.tieba.ala.alasquare.live_tab.model;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.adp.lib.util.l;
import com.baidu.adp.widget.ListView.n;
import com.baidu.ala.AlaCmdConfigHttp;
import com.baidu.live.tbadk.pagestayduration.PageStayDurationHelper;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.ala.alasquare.live_tab.AlaLiveTabFragment;
import com.baidu.tieba.ala.alasquare.live_tab.b.j;
import com.baidu.tieba.ala.alasquare.live_tab.c.d;
import com.baidu.tieba.ala.alasquare.live_tab.message.AlaTabLiveResponsedMessage;
import java.util.List;
/* loaded from: classes10.dex */
public class AlaLiveTabYanzhiModel extends BdBaseModel {
    private String fNd;
    private boolean gBO;
    private long gBQ;
    private String gBt;
    private d gCb;
    private a gCc;
    private boolean hasMore;
    private int mPn;
    private TbPageContext mTbPageContext;
    private HttpMessageListener gCd = new HttpMessageListener(AlaCmdConfigHttp.CMD_ALA_GET_TAB_LIVE_INFO) { // from class: com.baidu.tieba.ala.alasquare.live_tab.model.AlaLiveTabYanzhiModel.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1021141 && (httpResponsedMessage instanceof AlaTabLiveResponsedMessage) && httpResponsedMessage.getOrginalMessage().getTag() == AlaLiveTabYanzhiModel.this.mCurTag) {
                AlaTabLiveResponsedMessage alaTabLiveResponsedMessage = (AlaTabLiveResponsedMessage) httpResponsedMessage;
                if (alaTabLiveResponsedMessage.getError() != 0 || !alaTabLiveResponsedMessage.isSuccess()) {
                    if (AlaLiveTabYanzhiModel.this.gCc != null) {
                        AlaLiveTabYanzhiModel.this.gCc.g(httpResponsedMessage.getError(), httpResponsedMessage.getErrorString(), AlaLiveTabYanzhiModel.this.gBO);
                    }
                } else {
                    j jVar = alaTabLiveResponsedMessage.tabAllLiveInfo;
                    if (AlaLiveTabYanzhiModel.this.gBO) {
                        AlaLiveTabYanzhiModel.this.gCb.a(jVar);
                        AlaLiveTabYanzhiModel.e(AlaLiveTabYanzhiModel.this);
                    } else {
                        AlaLiveTabFragment.gAF++;
                        if (AlaLiveTabYanzhiModel.this.gCb != null) {
                            AlaLiveTabYanzhiModel.this.gCb.clear();
                        }
                        AlaLiveTabYanzhiModel.this.gCb = new d(jVar, AlaLiveTabYanzhiModel.this.fNd, AlaLiveTabYanzhiModel.this.gBt);
                    }
                    AlaLiveTabYanzhiModel.this.hasMore = AlaLiveTabYanzhiModel.this.gCb.hasMore();
                    if (AlaLiveTabYanzhiModel.this.gCc != null) {
                        AlaLiveTabYanzhiModel.this.gCc.f(AlaLiveTabYanzhiModel.this.hasMore, AlaLiveTabYanzhiModel.this.gCb.getData());
                    }
                }
                AlaLiveTabYanzhiModel.this.gBO = false;
            }
        }
    };
    private BdUniqueId mCurTag = BdUniqueId.gen();

    /* loaded from: classes10.dex */
    public interface a {
        void f(boolean z, List<n> list);

        void g(int i, String str, boolean z);
    }

    static /* synthetic */ int e(AlaLiveTabYanzhiModel alaLiveTabYanzhiModel) {
        int i = alaLiveTabYanzhiModel.mPn;
        alaLiveTabYanzhiModel.mPn = i + 1;
        return i;
    }

    public AlaLiveTabYanzhiModel(TbPageContext tbPageContext, a aVar) {
        this.mTbPageContext = tbPageContext;
        this.gCc = aVar;
    }

    public void init() {
        MessageManager.getInstance().registerListener(this.gCd);
    }

    public void refresh() {
        this.gBQ = System.currentTimeMillis();
        this.gBO = false;
        this.mPn = 1;
        M(this.mPn, 0, AlaLiveTabFragment.gAF);
    }

    public void bRj() {
        if (this.hasMore && !this.gBO) {
            long currentTimeMillis = System.currentTimeMillis();
            if (currentTimeMillis - this.gBQ >= 1800000) {
                this.gBQ = currentTimeMillis;
            }
            this.gBO = true;
            M(this.mPn + 1, 1, AlaLiveTabFragment.gAF - 1);
        }
    }

    private void M(int i, int i2, int i3) {
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
        httpMessage.addParam("session_id", this.gBQ);
        httpMessage.addParam("refresh_type", i2);
        httpMessage.addParam("big_refresh_count", i3);
        httpMessage.addParam("fid", this.fNd);
        httpMessage.addParam("fname", this.gBt);
        httpMessage.setTag(this.mCurTag);
        MessageManager.getInstance().sendMessage(httpMessage);
    }

    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.gCd);
    }

    @Override // com.baidu.adp.base.BdBaseModel
    protected boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        return false;
    }

    public void eg(String str, String str2) {
        this.fNd = str;
        this.gBt = str2;
    }
}
