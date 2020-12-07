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
/* loaded from: classes6.dex */
public class AlaLiveTabFriendModel extends BdBaseModel {
    private boolean gsw;
    private com.baidu.tieba.ala.alasquare.live_tab.c.a gsx;
    private long gsy;
    private a gsz;
    private boolean hasMore;
    private int mPn;
    private TbPageContext mTbPageContext;
    private HttpMessageListener gsA = new HttpMessageListener(AlaCmdConfigHttp.CMD_ALA_GET_TAB_LIVE_INFO) { // from class: com.baidu.tieba.ala.alasquare.live_tab.model.AlaLiveTabFriendModel.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1021141 && (httpResponsedMessage instanceof AlaTabLiveResponsedMessage) && httpResponsedMessage.getOrginalMessage().getTag() == AlaLiveTabFriendModel.this.mCurTag) {
                AlaTabLiveResponsedMessage alaTabLiveResponsedMessage = (AlaTabLiveResponsedMessage) httpResponsedMessage;
                if (alaTabLiveResponsedMessage.getError() != 0 || !alaTabLiveResponsedMessage.isSuccess()) {
                    if (AlaLiveTabFriendModel.this.gsz != null) {
                        AlaLiveTabFriendModel.this.gsz.h(httpResponsedMessage.getError(), httpResponsedMessage.getErrorString(), AlaLiveTabFriendModel.this.gsw);
                    }
                } else {
                    j jVar = alaTabLiveResponsedMessage.tabAllLiveInfo;
                    if (AlaLiveTabFriendModel.this.gsw) {
                        AlaLiveTabFriendModel.this.gsx.a(jVar);
                        AlaLiveTabFriendModel.e(AlaLiveTabFriendModel.this);
                    } else {
                        AlaLiveTabFragment.gro++;
                        if (AlaLiveTabFriendModel.this.gsx != null) {
                            AlaLiveTabFriendModel.this.gsx.clear();
                        }
                        AlaLiveTabFriendModel.this.gsx = new com.baidu.tieba.ala.alasquare.live_tab.c.a(alaTabLiveResponsedMessage);
                    }
                    AlaLiveTabFriendModel.this.hasMore = AlaLiveTabFriendModel.this.gsx.hasMore();
                    if (AlaLiveTabFriendModel.this.gsz != null) {
                        AlaLiveTabFriendModel.this.gsz.e(AlaLiveTabFriendModel.this.hasMore, AlaLiveTabFriendModel.this.gsx.getData());
                    }
                }
                AlaLiveTabFriendModel.this.gsw = false;
            }
        }
    };
    private BdUniqueId mCurTag = BdUniqueId.gen();

    /* loaded from: classes6.dex */
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
        this.gsz = aVar;
    }

    public void init() {
        MessageManager.getInstance().registerListener(this.gsA);
    }

    public void refresh() {
        this.gsy = System.currentTimeMillis();
        this.gsw = false;
        this.mPn = 1;
        K(this.mPn, 0, AlaLiveTabFragment.gro);
    }

    public void bRM() {
        if (this.hasMore && !this.gsw) {
            long currentTimeMillis = System.currentTimeMillis();
            if (currentTimeMillis - this.gsy >= 1800000) {
                this.gsy = currentTimeMillis;
            }
            this.gsw = true;
            K(this.mPn + 1, 1, AlaLiveTabFragment.gro - 1);
        }
    }

    private void K(int i, int i2, int i3) {
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
        httpMessage.addParam("session_id", this.gsy);
        httpMessage.addParam("refresh_type", i2);
        httpMessage.addParam("big_refresh_count", i3);
        httpMessage.setTag(this.mCurTag);
        MessageManager.getInstance().sendMessage(httpMessage);
    }

    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.gsA);
    }

    public boolean hasData() {
        return (this.gsx == null || y.isEmpty(this.gsx.getData())) ? false : true;
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
