package com.baidu.tieba.ala.alasquare.live_tab.model;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.adp.lib.util.l;
import com.baidu.adp.widget.ListView.q;
import com.baidu.ala.AlaCmdConfigHttp;
import com.baidu.live.tbadk.pagestayduration.PageStayDurationHelper;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.ala.alasquare.live_tab.AlaLiveTabFragment;
import com.baidu.tieba.ala.alasquare.live_tab.b.j;
import com.baidu.tieba.ala.alasquare.live_tab.c.c;
import com.baidu.tieba.ala.alasquare.live_tab.message.AlaTabLiveResponsedMessage;
import java.util.List;
/* loaded from: classes4.dex */
public class AlaLiveTabYanzhiModel extends BdBaseModel {
    private String eKO;
    private boolean ftQ;
    private long ftW;
    private String ftz;
    private c fua;
    private a fub;
    private boolean hasMore;
    private int mPn;
    private TbPageContext mTbPageContext;
    private HttpMessageListener fuc = new HttpMessageListener(AlaCmdConfigHttp.CMD_ALA_GET_TAB_LIVE_INFO) { // from class: com.baidu.tieba.ala.alasquare.live_tab.model.AlaLiveTabYanzhiModel.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1021141 && (httpResponsedMessage instanceof AlaTabLiveResponsedMessage) && httpResponsedMessage.getOrginalMessage().getTag() == AlaLiveTabYanzhiModel.this.mCurTag) {
                AlaTabLiveResponsedMessage alaTabLiveResponsedMessage = (AlaTabLiveResponsedMessage) httpResponsedMessage;
                if (alaTabLiveResponsedMessage.getError() != 0 || !alaTabLiveResponsedMessage.isSuccess()) {
                    if (AlaLiveTabYanzhiModel.this.fub != null) {
                        AlaLiveTabYanzhiModel.this.fub.g(httpResponsedMessage.getError(), httpResponsedMessage.getErrorString(), AlaLiveTabYanzhiModel.this.ftQ);
                    }
                } else {
                    j jVar = alaTabLiveResponsedMessage.tabAllLiveInfo;
                    if (AlaLiveTabYanzhiModel.this.ftQ) {
                        AlaLiveTabYanzhiModel.this.fua.a(jVar);
                        AlaLiveTabYanzhiModel.e(AlaLiveTabYanzhiModel.this);
                    } else {
                        AlaLiveTabFragment.fsL++;
                        if (AlaLiveTabYanzhiModel.this.fua != null) {
                            AlaLiveTabYanzhiModel.this.fua.clear();
                        }
                        AlaLiveTabYanzhiModel.this.fua = new c(jVar, AlaLiveTabYanzhiModel.this.eKO, AlaLiveTabYanzhiModel.this.ftz);
                    }
                    AlaLiveTabYanzhiModel.this.hasMore = AlaLiveTabYanzhiModel.this.fua.hasMore();
                    if (AlaLiveTabYanzhiModel.this.fub != null) {
                        AlaLiveTabYanzhiModel.this.fub.e(AlaLiveTabYanzhiModel.this.hasMore, AlaLiveTabYanzhiModel.this.fua.getData());
                    }
                }
                AlaLiveTabYanzhiModel.this.ftQ = false;
            }
        }
    };
    private BdUniqueId mCurTag = BdUniqueId.gen();

    /* loaded from: classes4.dex */
    public interface a {
        void e(boolean z, List<q> list);

        void g(int i, String str, boolean z);
    }

    static /* synthetic */ int e(AlaLiveTabYanzhiModel alaLiveTabYanzhiModel) {
        int i = alaLiveTabYanzhiModel.mPn;
        alaLiveTabYanzhiModel.mPn = i + 1;
        return i;
    }

    public AlaLiveTabYanzhiModel(TbPageContext tbPageContext, a aVar) {
        this.mTbPageContext = tbPageContext;
        this.fub = aVar;
    }

    public void init() {
        MessageManager.getInstance().registerListener(this.fuc);
    }

    public void refresh() {
        this.ftW = System.currentTimeMillis();
        this.ftQ = false;
        this.mPn = 1;
        E(this.mPn, 0, AlaLiveTabFragment.fsL);
    }

    public void bwE() {
        if (this.hasMore && !this.ftQ) {
            long currentTimeMillis = System.currentTimeMillis();
            if (currentTimeMillis - this.ftW >= 1800000) {
                this.ftW = currentTimeMillis;
            }
            this.ftQ = true;
            E(this.mPn + 1, 1, AlaLiveTabFragment.fsL - 1);
        }
    }

    private void E(int i, int i2, int i3) {
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
        httpMessage.addParam("session_id", this.ftW);
        httpMessage.addParam("refresh_type", i2);
        httpMessage.addParam("big_refresh_count", i3);
        httpMessage.addParam("fid", this.eKO);
        httpMessage.addParam("fname", this.ftz);
        httpMessage.setTag(this.mCurTag);
        MessageManager.getInstance().sendMessage(httpMessage);
    }

    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.fuc);
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
        this.eKO = str;
        this.ftz = str2;
    }
}
