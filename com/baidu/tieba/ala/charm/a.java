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
/* loaded from: classes3.dex */
public class a implements com.baidu.live.liveroom.d.d {
    private boolean aVc;
    private String aVd;
    private String fzj;
    private String fzk;
    private String fzl;
    private String fzm;
    private com.baidu.tieba.ala.charm.view.b fzn;
    private com.baidu.tieba.ala.charm.model.a fzo;
    private ALaCharmCardActivity fzp;
    private int fzq;
    private String mGroupId;
    private boolean mHasMore;
    private String mLiveId;
    private String mOtherParams;
    private String mUserId;
    private String mUserName;
    private int pn = 0;
    CustomMessageListener fzr = new CustomMessageListener(2913095) { // from class: com.baidu.tieba.ala.charm.a.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof String)) {
                String str = (String) customResponsedMessage.getData();
                if (str == null) {
                    str = "";
                }
                if (a.this.fzn != null) {
                    a.this.fzn.setOtherParams(str);
                }
            }
        }
    };
    a.InterfaceC0540a fzs = new a.InterfaceC0540a() { // from class: com.baidu.tieba.ala.charm.a.2
        @Override // com.baidu.tieba.ala.charm.model.a.InterfaceC0540a
        public void a(ALaCharmDataList aLaCharmDataList) {
            if (aLaCharmDataList == null) {
                a.this.fzn.jS(true);
                return;
            }
            a.this.fzn.btO();
            a.this.fzn.a(aLaCharmDataList.data, a.this.pn == 0, aLaCharmDataList.userTotalPrice);
            a.this.pn = aLaCharmDataList.pn + 1;
            a.this.mHasMore = aLaCharmDataList.hasMore;
            if (a.this.mHasMore) {
                a.this.fzn.buJ();
            } else {
                a.this.fzn.BV(a.this.fzp.getPageContext().getResources().getString(a.i.charm_no_more));
            }
            if (aLaCharmDataList.data == null || aLaCharmDataList.data.size() <= 0) {
                a.this.fzn.jS(true);
            }
        }

        @Override // com.baidu.tieba.ala.charm.model.a.InterfaceC0540a
        public void az(int i, String str) {
            a.this.fzn.jS(false);
            a.this.fzn.l(new View.OnClickListener() { // from class: com.baidu.tieba.ala.charm.a.2.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (BdNetTypeUtil.isNetWorkAvailable()) {
                        if (a.this.fzo != null) {
                            a.this.fzo.K(a.this.fzq, a.this.pn, 100);
                            return;
                        }
                        return;
                    }
                    a.this.fzp.getPageContext().showToast(a.this.fzp.getResources().getString(a.i.sdk_no_network_guide));
                }
            });
        }
    };
    private BdListView.OnScrollToBottomListener fzt = new BdListView.OnScrollToBottomListener() { // from class: com.baidu.tieba.ala.charm.a.3
        @Override // com.baidu.live.adp.widget.listview.BdListView.OnScrollToBottomListener
        public void onScrollToBottom() {
            if (a.this.mHasMore && a.this.fzo != null) {
                a.this.fzo.K(a.this.fzq, a.this.pn, 100);
            }
        }
    };

    public a(ALaCharmCardActivity aLaCharmCardActivity, int i) {
        this.fzq = 1;
        this.fzp = aLaCharmCardActivity;
        this.fzq = i;
    }

    public void createView() {
        this.fzn = new com.baidu.tieba.ala.charm.view.b(this.fzp, this.mGroupId, this.mLiveId, this.aVc, this.aVd, this.fzq, this.mUserId, this.mUserName, this.fzk, this.fzl, this.fzm);
        this.fzn.a(this.fzt);
        this.fzn.setOtherParams(this.mOtherParams);
        loadData();
        MessageManager.getInstance().registerListener(this.fzr);
    }

    private void loadData() {
        if (this.fzo == null) {
            this.fzo = new com.baidu.tieba.ala.charm.model.a(this.fzp.getPageContext(), this.mUserId, this.fzs);
        }
        this.fzo.bs(this.fzq, 100);
    }

    @Override // com.baidu.live.liveroom.d.d
    public View getPanelView() {
        if (this.fzn == null) {
            return null;
        }
        return this.fzn.getRootView();
    }

    public com.baidu.tieba.ala.charm.view.b bvV() {
        return this.fzn;
    }

    public void ar(String str, boolean z) {
        if (this.fzn != null) {
            this.fzn.ar(str, z);
        }
    }

    public void yA() {
        if (this.fzn != null) {
            this.fzn.yA();
        }
    }

    @Override // com.baidu.live.liveroom.d.d
    public String getTitle() {
        if (this.fzq == 2) {
            return this.fzp.getResources().getString(a.i.ala_charm_week_title);
        }
        if (this.fzq == 1) {
            return this.fzp.getResources().getString(a.i.ala_charm_all_title);
        }
        if (this.fzq == 3) {
            return this.fzp.getResources().getString(a.i.ala_charm_day_title);
        }
        if (this.fzq != 4) {
            return null;
        }
        return this.fzp.getResources().getString(a.i.audience_list_title);
    }

    public int bvW() {
        return this.fzq;
    }

    @Override // com.baidu.live.liveroom.d.d
    public String CI() {
        return null;
    }

    @Override // com.baidu.live.liveroom.d.d
    public short CJ() {
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
        if (this.fzo != null) {
            this.fzo.onDestroy();
        }
        MessageManager.getInstance().unRegisterListener(this.fzr);
    }

    public a BB(String str) {
        this.mUserId = str;
        return this;
    }

    public a BC(String str) {
        this.mUserName = str;
        return this;
    }

    public a BD(String str) {
        this.mGroupId = str;
        return this;
    }

    public a BE(String str) {
        this.mLiveId = str;
        return this;
    }

    public a jR(boolean z) {
        this.aVc = z;
        return this;
    }

    public a BF(String str) {
        this.aVd = str;
        return this;
    }

    public a BG(String str) {
        this.fzj = str;
        return this;
    }

    public a BH(String str) {
        this.fzk = str;
        return this;
    }

    public a BI(String str) {
        this.fzl = str;
        return this;
    }

    public a BJ(String str) {
        this.fzm = str;
        return this;
    }

    public a BK(String str) {
        this.mOtherParams = str;
        return this;
    }

    @Override // com.baidu.live.liveroom.d.d
    public void onChangeSkinType(int i) {
    }
}
