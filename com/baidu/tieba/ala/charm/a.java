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
/* loaded from: classes11.dex */
public class a implements com.baidu.live.liveroom.d.d {
    private String aDB;
    private boolean bnF;
    private String gNA;
    private String gNB;
    private com.baidu.tieba.ala.charm.view.b gNC;
    private com.baidu.tieba.ala.charm.model.a gND;
    private ALaCharmCardActivity gNE;
    private int gNF;
    private String gNy;
    private String gNz;
    private String mGroupId;
    private boolean mHasMore;
    private String mLiveId;
    private String mOtherParams;
    private String mUserId;
    private String mUserName;
    private int pn = 0;
    CustomMessageListener gNG = new CustomMessageListener(2913095) { // from class: com.baidu.tieba.ala.charm.a.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof String)) {
                String str = (String) customResponsedMessage.getData();
                if (str == null) {
                    str = "";
                }
                if (a.this.gNC != null) {
                    a.this.gNC.setOtherParams(str);
                }
            }
        }
    };
    a.InterfaceC0624a gNH = new a.InterfaceC0624a() { // from class: com.baidu.tieba.ala.charm.a.2
        @Override // com.baidu.tieba.ala.charm.model.a.InterfaceC0624a
        public void a(ALaCharmDataList aLaCharmDataList) {
            if (aLaCharmDataList == null) {
                a.this.gNC.dQ(true);
                return;
            }
            a.this.gNC.WZ();
            a.this.gNC.a(aLaCharmDataList.data, a.this.pn == 0, aLaCharmDataList.userTotalPrice);
            a.this.pn = aLaCharmDataList.pn + 1;
            a.this.mHasMore = aLaCharmDataList.hasMore;
            if (a.this.mHasMore) {
                a.this.gNC.WX();
            } else {
                a.this.gNC.GA(a.this.gNE.getPageContext().getResources().getString(a.h.charm_no_more));
            }
            if (aLaCharmDataList.data == null || aLaCharmDataList.data.size() <= 0) {
                a.this.gNC.dQ(true);
            }
        }

        @Override // com.baidu.tieba.ala.charm.model.a.InterfaceC0624a
        public void A(int i, String str) {
            a.this.gNC.dQ(false);
            a.this.gNC.n(new View.OnClickListener() { // from class: com.baidu.tieba.ala.charm.a.2.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (BdNetTypeUtil.isNetWorkAvailable()) {
                        if (a.this.gND != null) {
                            a.this.gND.O(a.this.gNF, a.this.pn, 100);
                            return;
                        }
                        return;
                    }
                    a.this.gNE.getPageContext().showToast(a.this.gNE.getResources().getString(a.h.sdk_no_network_guide));
                }
            });
        }
    };
    private BdListView.OnScrollToBottomListener gNI = new BdListView.OnScrollToBottomListener() { // from class: com.baidu.tieba.ala.charm.a.3
        @Override // com.baidu.live.adp.widget.listview.BdListView.OnScrollToBottomListener
        public void onScrollToBottom() {
            if (a.this.mHasMore && a.this.gND != null) {
                a.this.gND.O(a.this.gNF, a.this.pn, 100);
            }
        }
    };

    public a(ALaCharmCardActivity aLaCharmCardActivity, int i) {
        this.gNF = 1;
        this.gNE = aLaCharmCardActivity;
        this.gNF = i;
    }

    public void createView() {
        this.gNC = new com.baidu.tieba.ala.charm.view.b(this.gNE, this.mGroupId, this.mLiveId, this.bnF, this.aDB, this.gNF, this.mUserId, this.mUserName, this.gNz, this.gNA, this.gNB);
        this.gNC.a(this.gNI);
        this.gNC.setOtherParams(this.mOtherParams);
        loadData();
        MessageManager.getInstance().registerListener(this.gNG);
    }

    private void loadData() {
        if (this.gND == null) {
            this.gND = new com.baidu.tieba.ala.charm.model.a(this.gNE.getPageContext(), this.mUserId, this.gNH);
        }
        this.gND.bE(this.gNF, 100);
    }

    @Override // com.baidu.live.liveroom.d.d
    public View getPanelView() {
        if (this.gNC == null) {
            return null;
        }
        return this.gNC.getRootView();
    }

    public com.baidu.tieba.ala.charm.view.b bTE() {
        return this.gNC;
    }

    public void aA(String str, boolean z) {
        if (this.gNC != null) {
            this.gNC.aA(str, z);
        }
    }

    public void EK() {
        if (this.gNC != null) {
            this.gNC.EK();
        }
    }

    @Override // com.baidu.live.liveroom.d.d
    public String getTitle() {
        if (this.gNF == 2) {
            return this.gNE.getResources().getString(a.h.ala_charm_week_title);
        }
        if (this.gNF == 1) {
            return this.gNE.getResources().getString(a.h.ala_charm_all_title);
        }
        if (this.gNF == 3) {
            return this.gNE.getResources().getString(a.h.ala_charm_day_title);
        }
        if (this.gNF != 4) {
            return null;
        }
        return this.gNE.getResources().getString(a.h.audience_list_title);
    }

    public int bTF() {
        return this.gNF;
    }

    @Override // com.baidu.live.liveroom.d.d
    public String JK() {
        return null;
    }

    @Override // com.baidu.live.liveroom.d.d
    public short JL() {
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
        if (this.gND != null) {
            this.gND.onDestroy();
        }
        MessageManager.getInstance().unRegisterListener(this.gNG);
    }

    public a Gf(String str) {
        this.mUserId = str;
        return this;
    }

    public a Gg(String str) {
        this.mUserName = str;
        return this;
    }

    public a Gh(String str) {
        this.mGroupId = str;
        return this;
    }

    public a Gi(String str) {
        this.mLiveId = str;
        return this;
    }

    public a mS(boolean z) {
        this.bnF = z;
        return this;
    }

    public a Gj(String str) {
        this.aDB = str;
        return this;
    }

    public a Gk(String str) {
        this.gNy = str;
        return this;
    }

    public a Gl(String str) {
        this.gNz = str;
        return this;
    }

    public a Gm(String str) {
        this.gNA = str;
        return this;
    }

    public a Gn(String str) {
        this.gNB = str;
        return this;
    }

    public a Go(String str) {
        this.mOtherParams = str;
        return this;
    }

    @Override // com.baidu.live.liveroom.d.d
    public void onChangeSkinType(int i) {
    }
}
