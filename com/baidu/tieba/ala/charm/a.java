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
    private String gNk;
    private String gNl;
    private String gNm;
    private String gNn;
    private com.baidu.tieba.ala.charm.view.b gNo;
    private com.baidu.tieba.ala.charm.model.a gNp;
    private ALaCharmCardActivity gNq;
    private int gNr;
    private String mGroupId;
    private boolean mHasMore;
    private String mLiveId;
    private String mOtherParams;
    private String mUserId;
    private String mUserName;
    private int pn = 0;
    CustomMessageListener gNs = new CustomMessageListener(2913095) { // from class: com.baidu.tieba.ala.charm.a.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof String)) {
                String str = (String) customResponsedMessage.getData();
                if (str == null) {
                    str = "";
                }
                if (a.this.gNo != null) {
                    a.this.gNo.setOtherParams(str);
                }
            }
        }
    };
    a.InterfaceC0623a gNt = new a.InterfaceC0623a() { // from class: com.baidu.tieba.ala.charm.a.2
        @Override // com.baidu.tieba.ala.charm.model.a.InterfaceC0623a
        public void a(ALaCharmDataList aLaCharmDataList) {
            if (aLaCharmDataList == null) {
                a.this.gNo.dQ(true);
                return;
            }
            a.this.gNo.WZ();
            a.this.gNo.a(aLaCharmDataList.data, a.this.pn == 0, aLaCharmDataList.userTotalPrice);
            a.this.pn = aLaCharmDataList.pn + 1;
            a.this.mHasMore = aLaCharmDataList.hasMore;
            if (a.this.mHasMore) {
                a.this.gNo.WX();
            } else {
                a.this.gNo.Gz(a.this.gNq.getPageContext().getResources().getString(a.h.charm_no_more));
            }
            if (aLaCharmDataList.data == null || aLaCharmDataList.data.size() <= 0) {
                a.this.gNo.dQ(true);
            }
        }

        @Override // com.baidu.tieba.ala.charm.model.a.InterfaceC0623a
        public void A(int i, String str) {
            a.this.gNo.dQ(false);
            a.this.gNo.n(new View.OnClickListener() { // from class: com.baidu.tieba.ala.charm.a.2.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (BdNetTypeUtil.isNetWorkAvailable()) {
                        if (a.this.gNp != null) {
                            a.this.gNp.O(a.this.gNr, a.this.pn, 100);
                            return;
                        }
                        return;
                    }
                    a.this.gNq.getPageContext().showToast(a.this.gNq.getResources().getString(a.h.sdk_no_network_guide));
                }
            });
        }
    };
    private BdListView.OnScrollToBottomListener gNu = new BdListView.OnScrollToBottomListener() { // from class: com.baidu.tieba.ala.charm.a.3
        @Override // com.baidu.live.adp.widget.listview.BdListView.OnScrollToBottomListener
        public void onScrollToBottom() {
            if (a.this.mHasMore && a.this.gNp != null) {
                a.this.gNp.O(a.this.gNr, a.this.pn, 100);
            }
        }
    };

    public a(ALaCharmCardActivity aLaCharmCardActivity, int i) {
        this.gNr = 1;
        this.gNq = aLaCharmCardActivity;
        this.gNr = i;
    }

    public void createView() {
        this.gNo = new com.baidu.tieba.ala.charm.view.b(this.gNq, this.mGroupId, this.mLiveId, this.bnF, this.aDB, this.gNr, this.mUserId, this.mUserName, this.gNl, this.gNm, this.gNn);
        this.gNo.a(this.gNu);
        this.gNo.setOtherParams(this.mOtherParams);
        loadData();
        MessageManager.getInstance().registerListener(this.gNs);
    }

    private void loadData() {
        if (this.gNp == null) {
            this.gNp = new com.baidu.tieba.ala.charm.model.a(this.gNq.getPageContext(), this.mUserId, this.gNt);
        }
        this.gNp.bD(this.gNr, 100);
    }

    @Override // com.baidu.live.liveroom.d.d
    public View getPanelView() {
        if (this.gNo == null) {
            return null;
        }
        return this.gNo.getRootView();
    }

    public com.baidu.tieba.ala.charm.view.b bTx() {
        return this.gNo;
    }

    public void aA(String str, boolean z) {
        if (this.gNo != null) {
            this.gNo.aA(str, z);
        }
    }

    public void EK() {
        if (this.gNo != null) {
            this.gNo.EK();
        }
    }

    @Override // com.baidu.live.liveroom.d.d
    public String getTitle() {
        if (this.gNr == 2) {
            return this.gNq.getResources().getString(a.h.ala_charm_week_title);
        }
        if (this.gNr == 1) {
            return this.gNq.getResources().getString(a.h.ala_charm_all_title);
        }
        if (this.gNr == 3) {
            return this.gNq.getResources().getString(a.h.ala_charm_day_title);
        }
        if (this.gNr != 4) {
            return null;
        }
        return this.gNq.getResources().getString(a.h.audience_list_title);
    }

    public int bTy() {
        return this.gNr;
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
        if (this.gNp != null) {
            this.gNp.onDestroy();
        }
        MessageManager.getInstance().unRegisterListener(this.gNs);
    }

    public a Ge(String str) {
        this.mUserId = str;
        return this;
    }

    public a Gf(String str) {
        this.mUserName = str;
        return this;
    }

    public a Gg(String str) {
        this.mGroupId = str;
        return this;
    }

    public a Gh(String str) {
        this.mLiveId = str;
        return this;
    }

    public a mS(boolean z) {
        this.bnF = z;
        return this;
    }

    public a Gi(String str) {
        this.aDB = str;
        return this;
    }

    public a Gj(String str) {
        this.gNk = str;
        return this;
    }

    public a Gk(String str) {
        this.gNl = str;
        return this;
    }

    public a Gl(String str) {
        this.gNm = str;
        return this;
    }

    public a Gm(String str) {
        this.gNn = str;
        return this;
    }

    public a Gn(String str) {
        this.mOtherParams = str;
        return this;
    }

    @Override // com.baidu.live.liveroom.d.d
    public void onChangeSkinType(int i) {
    }
}
