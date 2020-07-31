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
/* loaded from: classes4.dex */
public class a implements com.baidu.live.liveroom.d.d {
    private boolean aWs;
    private String avC;
    private String fEq;
    private String fEr;
    private String fEs;
    private String fEt;
    private com.baidu.tieba.ala.charm.view.b fEu;
    private com.baidu.tieba.ala.charm.model.a fEv;
    private ALaCharmCardActivity fEw;
    private int fEx;
    private String mGroupId;
    private boolean mHasMore;
    private String mLiveId;
    private String mOtherParams;
    private String mUserId;
    private String mUserName;
    private int pn = 0;
    CustomMessageListener fEy = new CustomMessageListener(2913095) { // from class: com.baidu.tieba.ala.charm.a.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof String)) {
                String str = (String) customResponsedMessage.getData();
                if (str == null) {
                    str = "";
                }
                if (a.this.fEu != null) {
                    a.this.fEu.setOtherParams(str);
                }
            }
        }
    };
    a.InterfaceC0551a fEz = new a.InterfaceC0551a() { // from class: com.baidu.tieba.ala.charm.a.2
        @Override // com.baidu.tieba.ala.charm.model.a.InterfaceC0551a
        public void a(ALaCharmDataList aLaCharmDataList) {
            if (aLaCharmDataList == null) {
                a.this.fEu.kw(true);
                return;
            }
            a.this.fEu.bwX();
            a.this.fEu.a(aLaCharmDataList.data, a.this.pn == 0, aLaCharmDataList.userTotalPrice);
            a.this.pn = aLaCharmDataList.pn + 1;
            a.this.mHasMore = aLaCharmDataList.hasMore;
            if (a.this.mHasMore) {
                a.this.fEu.bxS();
            } else {
                a.this.fEu.CG(a.this.fEw.getPageContext().getResources().getString(a.i.charm_no_more));
            }
            if (aLaCharmDataList.data == null || aLaCharmDataList.data.size() <= 0) {
                a.this.fEu.kw(true);
            }
        }

        @Override // com.baidu.tieba.ala.charm.model.a.InterfaceC0551a
        public void aB(int i, String str) {
            a.this.fEu.kw(false);
            a.this.fEu.l(new View.OnClickListener() { // from class: com.baidu.tieba.ala.charm.a.2.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (BdNetTypeUtil.isNetWorkAvailable()) {
                        if (a.this.fEv != null) {
                            a.this.fEv.J(a.this.fEx, a.this.pn, 100);
                            return;
                        }
                        return;
                    }
                    a.this.fEw.getPageContext().showToast(a.this.fEw.getResources().getString(a.i.sdk_no_network_guide));
                }
            });
        }
    };
    private BdListView.OnScrollToBottomListener fEA = new BdListView.OnScrollToBottomListener() { // from class: com.baidu.tieba.ala.charm.a.3
        @Override // com.baidu.live.adp.widget.listview.BdListView.OnScrollToBottomListener
        public void onScrollToBottom() {
            if (a.this.mHasMore && a.this.fEv != null) {
                a.this.fEv.J(a.this.fEx, a.this.pn, 100);
            }
        }
    };

    public a(ALaCharmCardActivity aLaCharmCardActivity, int i) {
        this.fEx = 1;
        this.fEw = aLaCharmCardActivity;
        this.fEx = i;
    }

    public void createView() {
        this.fEu = new com.baidu.tieba.ala.charm.view.b(this.fEw, this.mGroupId, this.mLiveId, this.aWs, this.avC, this.fEx, this.mUserId, this.mUserName, this.fEr, this.fEs, this.fEt);
        this.fEu.a(this.fEA);
        this.fEu.setOtherParams(this.mOtherParams);
        loadData();
        MessageManager.getInstance().registerListener(this.fEy);
    }

    private void loadData() {
        if (this.fEv == null) {
            this.fEv = new com.baidu.tieba.ala.charm.model.a(this.fEw.getPageContext(), this.mUserId, this.fEz);
        }
        this.fEv.bv(this.fEx, 100);
    }

    @Override // com.baidu.live.liveroom.d.d
    public View getPanelView() {
        if (this.fEu == null) {
            return null;
        }
        return this.fEu.getRootView();
    }

    public com.baidu.tieba.ala.charm.view.b bze() {
        return this.fEu;
    }

    public void ap(String str, boolean z) {
        if (this.fEu != null) {
            this.fEu.ap(str, z);
        }
    }

    public void zc() {
        if (this.fEu != null) {
            this.fEu.zc();
        }
    }

    @Override // com.baidu.live.liveroom.d.d
    public String getTitle() {
        if (this.fEx == 2) {
            return this.fEw.getResources().getString(a.i.ala_charm_week_title);
        }
        if (this.fEx == 1) {
            return this.fEw.getResources().getString(a.i.ala_charm_all_title);
        }
        if (this.fEx == 3) {
            return this.fEw.getResources().getString(a.i.ala_charm_day_title);
        }
        if (this.fEx != 4) {
            return null;
        }
        return this.fEw.getResources().getString(a.i.audience_list_title);
    }

    public int bzf() {
        return this.fEx;
    }

    @Override // com.baidu.live.liveroom.d.d
    public String Dj() {
        return null;
    }

    @Override // com.baidu.live.liveroom.d.d
    public short Dk() {
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
        if (this.fEv != null) {
            this.fEv.onDestroy();
        }
        MessageManager.getInstance().unRegisterListener(this.fEy);
    }

    public a Cm(String str) {
        this.mUserId = str;
        return this;
    }

    public a Cn(String str) {
        this.mUserName = str;
        return this;
    }

    public a Co(String str) {
        this.mGroupId = str;
        return this;
    }

    public a Cp(String str) {
        this.mLiveId = str;
        return this;
    }

    public a kv(boolean z) {
        this.aWs = z;
        return this;
    }

    public a Cq(String str) {
        this.avC = str;
        return this;
    }

    public a Cr(String str) {
        this.fEq = str;
        return this;
    }

    public a Cs(String str) {
        this.fEr = str;
        return this;
    }

    public a Ct(String str) {
        this.fEs = str;
        return this;
    }

    public a Cu(String str) {
        this.fEt = str;
        return this;
    }

    public a Cv(String str) {
        this.mOtherParams = str;
        return this;
    }

    @Override // com.baidu.live.liveroom.d.d
    public void onChangeSkinType(int i) {
    }
}
