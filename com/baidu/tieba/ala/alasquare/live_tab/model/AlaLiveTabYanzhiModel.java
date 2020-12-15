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
import com.baidu.tieba.ala.alasquare.live_tab.c.d;
import com.baidu.tieba.ala.alasquare.live_tab.message.AlaTabLiveResponsedMessage;
import java.util.List;
/* loaded from: classes6.dex */
public class AlaLiveTabYanzhiModel extends BdBaseModel {
    private String fFV;
    private long gsA;
    private d gsL;
    private a gsM;
    private String gsd;
    private boolean gsy;
    private boolean hasMore;
    private int mPn;
    private TbPageContext mTbPageContext;
    private HttpMessageListener gsN = new HttpMessageListener(AlaCmdConfigHttp.CMD_ALA_GET_TAB_LIVE_INFO) { // from class: com.baidu.tieba.ala.alasquare.live_tab.model.AlaLiveTabYanzhiModel.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1021141 && (httpResponsedMessage instanceof AlaTabLiveResponsedMessage) && httpResponsedMessage.getOrginalMessage().getTag() == AlaLiveTabYanzhiModel.this.mCurTag) {
                AlaTabLiveResponsedMessage alaTabLiveResponsedMessage = (AlaTabLiveResponsedMessage) httpResponsedMessage;
                if (alaTabLiveResponsedMessage.getError() != 0 || !alaTabLiveResponsedMessage.isSuccess()) {
                    if (AlaLiveTabYanzhiModel.this.gsM != null) {
                        AlaLiveTabYanzhiModel.this.gsM.h(httpResponsedMessage.getError(), httpResponsedMessage.getErrorString(), AlaLiveTabYanzhiModel.this.gsy);
                    }
                } else {
                    j jVar = alaTabLiveResponsedMessage.tabAllLiveInfo;
                    if (AlaLiveTabYanzhiModel.this.gsy) {
                        AlaLiveTabYanzhiModel.this.gsL.a(jVar);
                        AlaLiveTabYanzhiModel.e(AlaLiveTabYanzhiModel.this);
                    } else {
                        AlaLiveTabFragment.grp++;
                        if (AlaLiveTabYanzhiModel.this.gsL != null) {
                            AlaLiveTabYanzhiModel.this.gsL.clear();
                        }
                        AlaLiveTabYanzhiModel.this.gsL = new d(jVar, AlaLiveTabYanzhiModel.this.fFV, AlaLiveTabYanzhiModel.this.gsd);
                    }
                    AlaLiveTabYanzhiModel.this.hasMore = AlaLiveTabYanzhiModel.this.gsL.hasMore();
                    if (AlaLiveTabYanzhiModel.this.gsM != null) {
                        AlaLiveTabYanzhiModel.this.gsM.e(AlaLiveTabYanzhiModel.this.hasMore, AlaLiveTabYanzhiModel.this.gsL.getData());
                    }
                }
                AlaLiveTabYanzhiModel.this.gsy = false;
            }
        }
    };
    private BdUniqueId mCurTag = BdUniqueId.gen();

    /* loaded from: classes6.dex */
    public interface a {
        void e(boolean z, List<q> list);

        void h(int i, String str, boolean z);
    }

    static /* synthetic */ int e(AlaLiveTabYanzhiModel alaLiveTabYanzhiModel) {
        int i = alaLiveTabYanzhiModel.mPn;
        alaLiveTabYanzhiModel.mPn = i + 1;
        return i;
    }

    public AlaLiveTabYanzhiModel(TbPageContext tbPageContext, a aVar) {
        this.mTbPageContext = tbPageContext;
        this.gsM = aVar;
    }

    public void init() {
        MessageManager.getInstance().registerListener(this.gsN);
    }

    public void refresh() {
        this.gsA = System.currentTimeMillis();
        this.gsy = false;
        this.mPn = 1;
        K(this.mPn, 0, AlaLiveTabFragment.grp);
    }

    public void bRN() {
        if (this.hasMore && !this.gsy) {
            long currentTimeMillis = System.currentTimeMillis();
            if (currentTimeMillis - this.gsA >= 1800000) {
                this.gsA = currentTimeMillis;
            }
            this.gsy = true;
            K(this.mPn + 1, 1, AlaLiveTabFragment.grp - 1);
        }
    }

    private void K(int i, int i2, int i3) {
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
        httpMessage.addParam("session_id", this.gsA);
        httpMessage.addParam("refresh_type", i2);
        httpMessage.addParam("big_refresh_count", i3);
        httpMessage.addParam("fid", this.fFV);
        httpMessage.addParam("fname", this.gsd);
        httpMessage.setTag(this.mCurTag);
        MessageManager.getInstance().sendMessage(httpMessage);
    }

    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.gsN);
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
