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
    private String aDE;
    private boolean bja;
    private String guN;
    private String guO;
    private String guP;
    private String guQ;
    private com.baidu.tieba.ala.charm.view.b guR;
    private com.baidu.tieba.ala.charm.model.a guS;
    private ALaCharmCardActivity guT;
    private int guU;
    private String mGroupId;
    private boolean mHasMore;
    private String mLiveId;
    private String mOtherParams;
    private String mUserId;
    private String mUserName;
    private int pn = 0;
    CustomMessageListener guV = new CustomMessageListener(2913095) { // from class: com.baidu.tieba.ala.charm.a.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof String)) {
                String str = (String) customResponsedMessage.getData();
                if (str == null) {
                    str = "";
                }
                if (a.this.guR != null) {
                    a.this.guR.setOtherParams(str);
                }
            }
        }
    };
    a.InterfaceC0638a guW = new a.InterfaceC0638a() { // from class: com.baidu.tieba.ala.charm.a.2
        @Override // com.baidu.tieba.ala.charm.model.a.InterfaceC0638a
        public void a(ALaCharmDataList aLaCharmDataList) {
            if (aLaCharmDataList == null) {
                a.this.guR.ds(true);
                return;
            }
            a.this.guR.VB();
            a.this.guR.a(aLaCharmDataList.data, a.this.pn == 0, aLaCharmDataList.userTotalPrice);
            a.this.pn = aLaCharmDataList.pn + 1;
            a.this.mHasMore = aLaCharmDataList.hasMore;
            if (a.this.mHasMore) {
                a.this.guR.Vz();
            } else {
                a.this.guR.Gy(a.this.guT.getPageContext().getResources().getString(a.h.charm_no_more));
            }
            if (aLaCharmDataList.data == null || aLaCharmDataList.data.size() <= 0) {
                a.this.guR.ds(true);
            }
        }

        @Override // com.baidu.tieba.ala.charm.model.a.InterfaceC0638a
        public void t(int i, String str) {
            a.this.guR.ds(false);
            a.this.guR.m(new View.OnClickListener() { // from class: com.baidu.tieba.ala.charm.a.2.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (BdNetTypeUtil.isNetWorkAvailable()) {
                        if (a.this.guS != null) {
                            a.this.guS.N(a.this.guU, a.this.pn, 100);
                            return;
                        }
                        return;
                    }
                    a.this.guT.getPageContext().showToast(a.this.guT.getResources().getString(a.h.sdk_no_network_guide));
                }
            });
        }
    };
    private BdListView.OnScrollToBottomListener guX = new BdListView.OnScrollToBottomListener() { // from class: com.baidu.tieba.ala.charm.a.3
        @Override // com.baidu.live.adp.widget.listview.BdListView.OnScrollToBottomListener
        public void onScrollToBottom() {
            if (a.this.mHasMore && a.this.guS != null) {
                a.this.guS.N(a.this.guU, a.this.pn, 100);
            }
        }
    };

    public a(ALaCharmCardActivity aLaCharmCardActivity, int i) {
        this.guU = 1;
        this.guT = aLaCharmCardActivity;
        this.guU = i;
    }

    public void createView() {
        this.guR = new com.baidu.tieba.ala.charm.view.b(this.guT, this.mGroupId, this.mLiveId, this.bja, this.aDE, this.guU, this.mUserId, this.mUserName, this.guO, this.guP, this.guQ);
        this.guR.a(this.guX);
        this.guR.setOtherParams(this.mOtherParams);
        loadData();
        MessageManager.getInstance().registerListener(this.guV);
    }

    private void loadData() {
        if (this.guS == null) {
            this.guS = new com.baidu.tieba.ala.charm.model.a(this.guT.getPageContext(), this.mUserId, this.guW);
        }
        this.guS.bF(this.guU, 100);
    }

    @Override // com.baidu.live.liveroom.d.d
    public View getPanelView() {
        if (this.guR == null) {
            return null;
        }
        return this.guR.getRootView();
    }

    public com.baidu.tieba.ala.charm.view.b bQv() {
        return this.guR;
    }

    public void az(String str, boolean z) {
        if (this.guR != null) {
            this.guR.az(str, z);
        }
    }

    public void FZ() {
        if (this.guR != null) {
            this.guR.FZ();
        }
    }

    @Override // com.baidu.live.liveroom.d.d
    public String getTitle() {
        if (this.guU == 2) {
            return this.guT.getResources().getString(a.h.ala_charm_week_title);
        }
        if (this.guU == 1) {
            return this.guT.getResources().getString(a.h.ala_charm_all_title);
        }
        if (this.guU == 3) {
            return this.guT.getResources().getString(a.h.ala_charm_day_title);
        }
        if (this.guU != 4) {
            return null;
        }
        return this.guT.getResources().getString(a.h.audience_list_title);
    }

    public int bQw() {
        return this.guU;
    }

    @Override // com.baidu.live.liveroom.d.d
    public String KI() {
        return null;
    }

    @Override // com.baidu.live.liveroom.d.d
    public short KJ() {
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
        if (this.guS != null) {
            this.guS.onDestroy();
        }
        MessageManager.getInstance().unRegisterListener(this.guV);
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

    public a lX(boolean z) {
        this.bja = z;
        return this;
    }

    public a Gi(String str) {
        this.aDE = str;
        return this;
    }

    public a Gj(String str) {
        this.guN = str;
        return this;
    }

    public a Gk(String str) {
        this.guO = str;
        return this;
    }

    public a Gl(String str) {
        this.guP = str;
        return this;
    }

    public a Gm(String str) {
        this.guQ = str;
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
