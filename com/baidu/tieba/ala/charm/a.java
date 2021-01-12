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
    private String aBO;
    private boolean bkm;
    private String gKE;
    private String gKF;
    private String gKG;
    private String gKH;
    private com.baidu.tieba.ala.charm.view.b gKI;
    private com.baidu.tieba.ala.charm.model.a gKJ;
    private ALaCharmCardActivity gKK;
    private int gKL;
    private String mGroupId;
    private boolean mHasMore;
    private String mLiveId;
    private String mOtherParams;
    private String mUserId;
    private String mUserName;
    private int pn = 0;
    CustomMessageListener gKM = new CustomMessageListener(2913095) { // from class: com.baidu.tieba.ala.charm.a.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof String)) {
                String str = (String) customResponsedMessage.getData();
                if (str == null) {
                    str = "";
                }
                if (a.this.gKI != null) {
                    a.this.gKI.setOtherParams(str);
                }
            }
        }
    };
    a.InterfaceC0624a gKN = new a.InterfaceC0624a() { // from class: com.baidu.tieba.ala.charm.a.2
        @Override // com.baidu.tieba.ala.charm.model.a.InterfaceC0624a
        public void a(ALaCharmDataList aLaCharmDataList) {
            if (aLaCharmDataList == null) {
                a.this.gKI.dI(true);
                return;
            }
            a.this.gKI.Vq();
            a.this.gKI.a(aLaCharmDataList.data, a.this.pn == 0, aLaCharmDataList.userTotalPrice);
            a.this.pn = aLaCharmDataList.pn + 1;
            a.this.mHasMore = aLaCharmDataList.hasMore;
            if (a.this.mHasMore) {
                a.this.gKI.Vo();
            } else {
                a.this.gKI.Ga(a.this.gKK.getPageContext().getResources().getString(a.h.charm_no_more));
            }
            if (aLaCharmDataList.data == null || aLaCharmDataList.data.size() <= 0) {
                a.this.gKI.dI(true);
            }
        }

        @Override // com.baidu.tieba.ala.charm.model.a.InterfaceC0624a
        public void w(int i, String str) {
            a.this.gKI.dI(false);
            a.this.gKI.n(new View.OnClickListener() { // from class: com.baidu.tieba.ala.charm.a.2.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (BdNetTypeUtil.isNetWorkAvailable()) {
                        if (a.this.gKJ != null) {
                            a.this.gKJ.O(a.this.gKL, a.this.pn, 100);
                            return;
                        }
                        return;
                    }
                    a.this.gKK.getPageContext().showToast(a.this.gKK.getResources().getString(a.h.sdk_no_network_guide));
                }
            });
        }
    };
    private BdListView.OnScrollToBottomListener gKO = new BdListView.OnScrollToBottomListener() { // from class: com.baidu.tieba.ala.charm.a.3
        @Override // com.baidu.live.adp.widget.listview.BdListView.OnScrollToBottomListener
        public void onScrollToBottom() {
            if (a.this.mHasMore && a.this.gKJ != null) {
                a.this.gKJ.O(a.this.gKL, a.this.pn, 100);
            }
        }
    };

    public a(ALaCharmCardActivity aLaCharmCardActivity, int i) {
        this.gKL = 1;
        this.gKK = aLaCharmCardActivity;
        this.gKL = i;
    }

    public void createView() {
        this.gKI = new com.baidu.tieba.ala.charm.view.b(this.gKK, this.mGroupId, this.mLiveId, this.bkm, this.aBO, this.gKL, this.mUserId, this.mUserName, this.gKF, this.gKG, this.gKH);
        this.gKI.a(this.gKO);
        this.gKI.setOtherParams(this.mOtherParams);
        loadData();
        MessageManager.getInstance().registerListener(this.gKM);
    }

    private void loadData() {
        if (this.gKJ == null) {
            this.gKJ = new com.baidu.tieba.ala.charm.model.a(this.gKK.getPageContext(), this.mUserId, this.gKN);
        }
        this.gKJ.bG(this.gKL, 100);
    }

    @Override // com.baidu.live.liveroom.d.d
    public View getPanelView() {
        if (this.gKI == null) {
            return null;
        }
        return this.gKI.getRootView();
    }

    public com.baidu.tieba.ala.charm.view.b bSU() {
        return this.gKI;
    }

    public void aB(String str, boolean z) {
        if (this.gKI != null) {
            this.gKI.aB(str, z);
        }
    }

    public void Du() {
        if (this.gKI != null) {
            this.gKI.Du();
        }
    }

    @Override // com.baidu.live.liveroom.d.d
    public String getTitle() {
        if (this.gKL == 2) {
            return this.gKK.getResources().getString(a.h.ala_charm_week_title);
        }
        if (this.gKL == 1) {
            return this.gKK.getResources().getString(a.h.ala_charm_all_title);
        }
        if (this.gKL == 3) {
            return this.gKK.getResources().getString(a.h.ala_charm_day_title);
        }
        if (this.gKL != 4) {
            return null;
        }
        return this.gKK.getResources().getString(a.h.audience_list_title);
    }

    public int bSV() {
        return this.gKL;
    }

    @Override // com.baidu.live.liveroom.d.d
    public String Im() {
        return null;
    }

    @Override // com.baidu.live.liveroom.d.d
    public short In() {
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
        if (this.gKJ != null) {
            this.gKJ.onDestroy();
        }
        MessageManager.getInstance().unRegisterListener(this.gKM);
    }

    public a FF(String str) {
        this.mUserId = str;
        return this;
    }

    public a FG(String str) {
        this.mUserName = str;
        return this;
    }

    public a FH(String str) {
        this.mGroupId = str;
        return this;
    }

    public a FI(String str) {
        this.mLiveId = str;
        return this;
    }

    public a mO(boolean z) {
        this.bkm = z;
        return this;
    }

    public a FJ(String str) {
        this.aBO = str;
        return this;
    }

    public a FK(String str) {
        this.gKE = str;
        return this;
    }

    public a FL(String str) {
        this.gKF = str;
        return this;
    }

    public a FM(String str) {
        this.gKG = str;
        return this;
    }

    public a FN(String str) {
        this.gKH = str;
        return this;
    }

    public a FO(String str) {
        this.mOtherParams = str;
        return this;
    }

    @Override // com.baidu.live.liveroom.d.d
    public void onChangeSkinType(int i) {
    }
}
