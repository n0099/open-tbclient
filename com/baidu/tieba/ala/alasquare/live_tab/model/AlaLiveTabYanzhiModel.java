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
/* loaded from: classes4.dex */
public class AlaLiveTabYanzhiModel extends BdBaseModel {
    private String fyR;
    private boolean gkG;
    private long gkI;
    private d gkT;
    private a gkU;
    private String gkl;
    private boolean hasMore;
    private int mPn;
    private TbPageContext mTbPageContext;
    private HttpMessageListener gkV = new HttpMessageListener(AlaCmdConfigHttp.CMD_ALA_GET_TAB_LIVE_INFO) { // from class: com.baidu.tieba.ala.alasquare.live_tab.model.AlaLiveTabYanzhiModel.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1021141 && (httpResponsedMessage instanceof AlaTabLiveResponsedMessage) && httpResponsedMessage.getOrginalMessage().getTag() == AlaLiveTabYanzhiModel.this.mCurTag) {
                AlaTabLiveResponsedMessage alaTabLiveResponsedMessage = (AlaTabLiveResponsedMessage) httpResponsedMessage;
                if (alaTabLiveResponsedMessage.getError() != 0 || !alaTabLiveResponsedMessage.isSuccess()) {
                    if (AlaLiveTabYanzhiModel.this.gkU != null) {
                        AlaLiveTabYanzhiModel.this.gkU.h(httpResponsedMessage.getError(), httpResponsedMessage.getErrorString(), AlaLiveTabYanzhiModel.this.gkG);
                    }
                } else {
                    j jVar = alaTabLiveResponsedMessage.tabAllLiveInfo;
                    if (AlaLiveTabYanzhiModel.this.gkG) {
                        AlaLiveTabYanzhiModel.this.gkT.a(jVar);
                        AlaLiveTabYanzhiModel.e(AlaLiveTabYanzhiModel.this);
                    } else {
                        AlaLiveTabFragment.gjx++;
                        if (AlaLiveTabYanzhiModel.this.gkT != null) {
                            AlaLiveTabYanzhiModel.this.gkT.clear();
                        }
                        AlaLiveTabYanzhiModel.this.gkT = new d(jVar, AlaLiveTabYanzhiModel.this.fyR, AlaLiveTabYanzhiModel.this.gkl);
                    }
                    AlaLiveTabYanzhiModel.this.hasMore = AlaLiveTabYanzhiModel.this.gkT.hasMore();
                    if (AlaLiveTabYanzhiModel.this.gkU != null) {
                        AlaLiveTabYanzhiModel.this.gkU.e(AlaLiveTabYanzhiModel.this.hasMore, AlaLiveTabYanzhiModel.this.gkT.getData());
                    }
                }
                AlaLiveTabYanzhiModel.this.gkG = false;
            }
        }
    };
    private BdUniqueId mCurTag = BdUniqueId.gen();

    /* loaded from: classes4.dex */
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
        this.gkU = aVar;
    }

    public void init() {
        MessageManager.getInstance().registerListener(this.gkV);
    }

    public void refresh() {
        this.gkI = System.currentTimeMillis();
        this.gkG = false;
        this.mPn = 1;
        J(this.mPn, 0, AlaLiveTabFragment.gjx);
    }

    public void bOI() {
        if (this.hasMore && !this.gkG) {
            long currentTimeMillis = System.currentTimeMillis();
            if (currentTimeMillis - this.gkI >= 1800000) {
                this.gkI = currentTimeMillis;
            }
            this.gkG = true;
            J(this.mPn + 1, 1, AlaLiveTabFragment.gjx - 1);
        }
    }

    private void J(int i, int i2, int i3) {
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
        httpMessage.addParam("session_id", this.gkI);
        httpMessage.addParam("refresh_type", i2);
        httpMessage.addParam("big_refresh_count", i3);
        httpMessage.addParam("fid", this.fyR);
        httpMessage.addParam("fname", this.gkl);
        httpMessage.setTag(this.mCurTag);
        MessageManager.getInstance().sendMessage(httpMessage);
    }

    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.gkV);
    }

    @Override // com.baidu.adp.base.BdBaseModel
    protected boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        return false;
    }

    public void ei(String str, String str2) {
        this.fyR = str;
        this.gkl = str2;
    }
}
