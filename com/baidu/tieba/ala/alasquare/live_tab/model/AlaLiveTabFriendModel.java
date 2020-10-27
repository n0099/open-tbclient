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
import com.baidu.tbadk.core.util.y;
import com.baidu.tieba.ala.alasquare.live_tab.AlaLiveTabFragment;
import com.baidu.tieba.ala.alasquare.live_tab.b.j;
import com.baidu.tieba.ala.alasquare.live_tab.message.AlaTabLiveResponsedMessage;
import java.util.List;
/* loaded from: classes4.dex */
public class AlaLiveTabFriendModel extends BdBaseModel {
    private boolean geR;
    private com.baidu.tieba.ala.alasquare.live_tab.c.a geS;
    private long geT;
    private a geU;
    private boolean hasMore;
    private int mPn;
    private TbPageContext mTbPageContext;
    private HttpMessageListener geV = new HttpMessageListener(AlaCmdConfigHttp.CMD_ALA_GET_TAB_LIVE_INFO) { // from class: com.baidu.tieba.ala.alasquare.live_tab.model.AlaLiveTabFriendModel.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1021141 && (httpResponsedMessage instanceof AlaTabLiveResponsedMessage) && httpResponsedMessage.getOrginalMessage().getTag() == AlaLiveTabFriendModel.this.mCurTag) {
                AlaTabLiveResponsedMessage alaTabLiveResponsedMessage = (AlaTabLiveResponsedMessage) httpResponsedMessage;
                if (alaTabLiveResponsedMessage.getError() != 0 || !alaTabLiveResponsedMessage.isSuccess()) {
                    if (AlaLiveTabFriendModel.this.geU != null) {
                        AlaLiveTabFriendModel.this.geU.h(httpResponsedMessage.getError(), httpResponsedMessage.getErrorString(), AlaLiveTabFriendModel.this.geR);
                    }
                } else {
                    j jVar = alaTabLiveResponsedMessage.tabAllLiveInfo;
                    if (AlaLiveTabFriendModel.this.geR) {
                        AlaLiveTabFriendModel.this.geS.a(jVar);
                        AlaLiveTabFriendModel.e(AlaLiveTabFriendModel.this);
                    } else {
                        AlaLiveTabFragment.gdI++;
                        if (AlaLiveTabFriendModel.this.geS != null) {
                            AlaLiveTabFriendModel.this.geS.clear();
                        }
                        AlaLiveTabFriendModel.this.geS = new com.baidu.tieba.ala.alasquare.live_tab.c.a(alaTabLiveResponsedMessage);
                    }
                    AlaLiveTabFriendModel.this.hasMore = AlaLiveTabFriendModel.this.geS.hasMore();
                    if (AlaLiveTabFriendModel.this.geU != null) {
                        AlaLiveTabFriendModel.this.geU.e(AlaLiveTabFriendModel.this.hasMore, AlaLiveTabFriendModel.this.geS.getData());
                    }
                }
                AlaLiveTabFriendModel.this.geR = false;
            }
        }
    };
    private BdUniqueId mCurTag = BdUniqueId.gen();

    /* loaded from: classes4.dex */
    public interface a {
        void e(boolean z, List<q> list);

        void h(int i, String str, boolean z);
    }

    static /* synthetic */ int e(AlaLiveTabFriendModel alaLiveTabFriendModel) {
        int i = alaLiveTabFriendModel.mPn;
        alaLiveTabFriendModel.mPn = i + 1;
        return i;
    }

    public AlaLiveTabFriendModel(TbPageContext tbPageContext, a aVar) {
        this.mTbPageContext = tbPageContext;
        this.geU = aVar;
    }

    public void init() {
        MessageManager.getInstance().registerListener(this.geV);
    }

    public void refresh() {
        this.geT = System.currentTimeMillis();
        this.geR = false;
        this.mPn = 1;
        J(this.mPn, 0, AlaLiveTabFragment.gdI);
    }

    public void bMi() {
        if (this.hasMore && !this.geR) {
            long currentTimeMillis = System.currentTimeMillis();
            if (currentTimeMillis - this.geT >= 1800000) {
                this.geT = currentTimeMillis;
            }
            this.geR = true;
            J(this.mPn + 1, 1, AlaLiveTabFragment.gdI - 1);
        }
    }

    private void J(int i, int i2, int i3) {
        HttpMessage httpMessage = new HttpMessage(AlaCmdConfigHttp.CMD_ALA_GET_TAB_LIVE_INFO);
        httpMessage.addParam("tab_id", 3);
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
        httpMessage.addParam("session_id", this.geT);
        httpMessage.addParam("refresh_type", i2);
        httpMessage.addParam("big_refresh_count", i3);
        httpMessage.setTag(this.mCurTag);
        MessageManager.getInstance().sendMessage(httpMessage);
    }

    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.geV);
    }

    public boolean hasData() {
        return (this.geS == null || y.isEmpty(this.geS.getData())) ? false : true;
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
