package com.baidu.tieba.ala.charm;

import android.view.View;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.listener.CustomMessageListener;
import com.baidu.live.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.adp.lib.util.BdNetTypeUtil;
import com.baidu.live.adp.widget.listview.BdListView;
import com.baidu.live.sdk.a;
import com.baidu.tieba.ala.charm.data.ALaCharmDataList;
import com.baidu.tieba.ala.charm.model.a;
/* loaded from: classes10.dex */
public class a implements com.baidu.live.liveroom.d.d {
    private String aFb;
    private boolean bpf;
    private String gPh;
    private String gPi;
    private String gPj;
    private String gPk;
    private com.baidu.tieba.ala.charm.view.b gPl;
    private com.baidu.tieba.ala.charm.model.a gPm;
    private ALaCharmCardActivity gPn;
    private int gPo;
    private String mGroupId;
    private boolean mHasMore;
    private String mLiveId;
    private String mOtherParams;
    private String mUserId;
    private String mUserName;
    private int pn = 0;
    CustomMessageListener gPp = new CustomMessageListener(2913095) { // from class: com.baidu.tieba.ala.charm.a.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof String)) {
                String str = (String) customResponsedMessage.getData();
                if (str == null) {
                    str = "";
                }
                if (a.this.gPl != null) {
                    a.this.gPl.setOtherParams(str);
                }
            }
        }
    };
    a.InterfaceC0630a gPq = new a.InterfaceC0630a() { // from class: com.baidu.tieba.ala.charm.a.2
        @Override // com.baidu.tieba.ala.charm.model.a.InterfaceC0630a
        public void a(ALaCharmDataList aLaCharmDataList) {
            if (aLaCharmDataList == null) {
                a.this.gPl.dQ(true);
                return;
            }
            a.this.gPl.Xc();
            a.this.gPl.a(aLaCharmDataList.data, a.this.pn == 0, aLaCharmDataList.userTotalPrice);
            a.this.pn = aLaCharmDataList.pn + 1;
            a.this.mHasMore = aLaCharmDataList.hasMore;
            if (a.this.mHasMore) {
                a.this.gPl.Xa();
            } else {
                a.this.gPl.GJ(a.this.gPn.getPageContext().getResources().getString(a.h.charm_no_more));
            }
            if (aLaCharmDataList.data == null || aLaCharmDataList.data.size() <= 0) {
                a.this.gPl.dQ(true);
            }
        }

        @Override // com.baidu.tieba.ala.charm.model.a.InterfaceC0630a
        public void A(int i, String str) {
            a.this.gPl.dQ(false);
            a.this.gPl.n(new View.OnClickListener() { // from class: com.baidu.tieba.ala.charm.a.2.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (BdNetTypeUtil.isNetWorkAvailable()) {
                        if (a.this.gPm != null) {
                            a.this.gPm.O(a.this.gPo, a.this.pn, 100);
                            return;
                        }
                        return;
                    }
                    a.this.gPn.getPageContext().showToast(a.this.gPn.getResources().getString(a.h.sdk_no_network_guide));
                }
            });
        }
    };
    private BdListView.OnScrollToBottomListener gPr = new BdListView.OnScrollToBottomListener() { // from class: com.baidu.tieba.ala.charm.a.3
        @Override // com.baidu.live.adp.widget.listview.BdListView.OnScrollToBottomListener
        public void onScrollToBottom() {
            if (a.this.mHasMore && a.this.gPm != null) {
                a.this.gPm.O(a.this.gPo, a.this.pn, 100);
            }
        }
    };

    public a(ALaCharmCardActivity aLaCharmCardActivity, int i) {
        this.gPo = 1;
        this.gPn = aLaCharmCardActivity;
        this.gPo = i;
    }

    public void createView() {
        this.gPl = new com.baidu.tieba.ala.charm.view.b(this.gPn, this.mGroupId, this.mLiveId, this.bpf, this.aFb, this.gPo, this.mUserId, this.mUserName, this.gPi, this.gPj, this.gPk);
        this.gPl.a(this.gPr);
        this.gPl.setOtherParams(this.mOtherParams);
        loadData();
        MessageManager.getInstance().registerListener(this.gPp);
    }

    private void loadData() {
        if (this.gPm == null) {
            this.gPm = new com.baidu.tieba.ala.charm.model.a(this.gPn.getPageContext(), this.mUserId, this.gPq);
        }
        this.gPm.bE(this.gPo, 100);
    }

    @Override // com.baidu.live.liveroom.d.d
    public View getPanelView() {
        if (this.gPl == null) {
            return null;
        }
        return this.gPl.getRootView();
    }

    public com.baidu.tieba.ala.charm.view.b bTK() {
        return this.gPl;
    }

    public void aA(String str, boolean z) {
        if (this.gPl != null) {
            this.gPl.aA(str, z);
        }
    }

    public void EN() {
        if (this.gPl != null) {
            this.gPl.EN();
        }
    }

    @Override // com.baidu.live.liveroom.d.d
    public String getTitle() {
        if (this.gPo == 2) {
            return this.gPn.getResources().getString(a.h.ala_charm_week_title);
        }
        if (this.gPo == 1) {
            return this.gPn.getResources().getString(a.h.ala_charm_all_title);
        }
        if (this.gPo == 3) {
            return this.gPn.getResources().getString(a.h.ala_charm_day_title);
        }
        if (this.gPo != 4) {
            return null;
        }
        return this.gPn.getResources().getString(a.h.audience_list_title);
    }

    public int bTL() {
        return this.gPo;
    }

    @Override // com.baidu.live.liveroom.d.d
    public String JN() {
        return null;
    }

    @Override // com.baidu.live.liveroom.d.d
    public short JO() {
        return (short) 0;
    }

    @Override // com.baidu.live.liveroom.d.d
    public void enterBackground() {
    }

    @Override // com.baidu.live.liveroom.d.d
    public void enterForeground() {
    }

    @Override // com.baidu.live.liveroom.d.d
    public void onDestroy() {
        if (this.gPm != null) {
            this.gPm.onDestroy();
        }
        MessageManager.getInstance().unRegisterListener(this.gPp);
    }

    public a Go(String str) {
        this.mUserId = str;
        return this;
    }

    public a Gp(String str) {
        this.mUserName = str;
        return this;
    }

    public a Gq(String str) {
        this.mGroupId = str;
        return this;
    }

    public a Gr(String str) {
        this.mLiveId = str;
        return this;
    }

    public a mS(boolean z) {
        this.bpf = z;
        return this;
    }

    public a Gs(String str) {
        this.aFb = str;
        return this;
    }

    public a Gt(String str) {
        this.gPh = str;
        return this;
    }

    public a Gu(String str) {
        this.gPi = str;
        return this;
    }

    public a Gv(String str) {
        this.gPj = str;
        return this;
    }

    public a Gw(String str) {
        this.gPk = str;
        return this;
    }

    public a Gx(String str) {
        this.mOtherParams = str;
        return this;
    }

    @Override // com.baidu.live.liveroom.d.d
    public void onChangeSkinType(int i) {
    }
}
