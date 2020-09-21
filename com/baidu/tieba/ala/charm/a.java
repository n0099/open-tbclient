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
    private String aBm;
    private boolean bej;
    private String fSW;
    private String fSX;
    private String fSY;
    private String fSZ;
    private com.baidu.tieba.ala.charm.view.b fTa;
    private com.baidu.tieba.ala.charm.model.a fTb;
    private ALaCharmCardActivity fTc;
    private int fTd;
    private String mGroupId;
    private boolean mHasMore;
    private String mLiveId;
    private String mOtherParams;
    private String mUserId;
    private String mUserName;
    private int pn = 0;
    CustomMessageListener fTe = new CustomMessageListener(2913095) { // from class: com.baidu.tieba.ala.charm.a.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof String)) {
                String str = (String) customResponsedMessage.getData();
                if (str == null) {
                    str = "";
                }
                if (a.this.fTa != null) {
                    a.this.fTa.setOtherParams(str);
                }
            }
        }
    };
    a.InterfaceC0593a fTf = new a.InterfaceC0593a() { // from class: com.baidu.tieba.ala.charm.a.2
        @Override // com.baidu.tieba.ala.charm.model.a.InterfaceC0593a
        public void a(ALaCharmDataList aLaCharmDataList) {
            if (aLaCharmDataList == null) {
                a.this.fTa.kY(true);
                return;
            }
            a.this.fTa.bHn();
            a.this.fTa.a(aLaCharmDataList.data, a.this.pn == 0, aLaCharmDataList.userTotalPrice);
            a.this.pn = aLaCharmDataList.pn + 1;
            a.this.mHasMore = aLaCharmDataList.hasMore;
            if (a.this.mHasMore) {
                a.this.fTa.bIi();
            } else {
                a.this.fTa.FA(a.this.fTc.getPageContext().getResources().getString(a.i.charm_no_more));
            }
            if (aLaCharmDataList.data == null || aLaCharmDataList.data.size() <= 0) {
                a.this.fTa.kY(true);
            }
        }

        @Override // com.baidu.tieba.ala.charm.model.a.InterfaceC0593a
        public void az(int i, String str) {
            a.this.fTa.kY(false);
            a.this.fTa.l(new View.OnClickListener() { // from class: com.baidu.tieba.ala.charm.a.2.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (BdNetTypeUtil.isNetWorkAvailable()) {
                        if (a.this.fTb != null) {
                            a.this.fTb.J(a.this.fTd, a.this.pn, 100);
                            return;
                        }
                        return;
                    }
                    a.this.fTc.getPageContext().showToast(a.this.fTc.getResources().getString(a.i.sdk_no_network_guide));
                }
            });
        }
    };
    private BdListView.OnScrollToBottomListener fTg = new BdListView.OnScrollToBottomListener() { // from class: com.baidu.tieba.ala.charm.a.3
        @Override // com.baidu.live.adp.widget.listview.BdListView.OnScrollToBottomListener
        public void onScrollToBottom() {
            if (a.this.mHasMore && a.this.fTb != null) {
                a.this.fTb.J(a.this.fTd, a.this.pn, 100);
            }
        }
    };

    public a(ALaCharmCardActivity aLaCharmCardActivity, int i) {
        this.fTd = 1;
        this.fTc = aLaCharmCardActivity;
        this.fTd = i;
    }

    public void createView() {
        this.fTa = new com.baidu.tieba.ala.charm.view.b(this.fTc, this.mGroupId, this.mLiveId, this.bej, this.aBm, this.fTd, this.mUserId, this.mUserName, this.fSX, this.fSY, this.fSZ);
        this.fTa.a(this.fTg);
        this.fTa.setOtherParams(this.mOtherParams);
        loadData();
        MessageManager.getInstance().registerListener(this.fTe);
    }

    private void loadData() {
        if (this.fTb == null) {
            this.fTb = new com.baidu.tieba.ala.charm.model.a(this.fTc.getPageContext(), this.mUserId, this.fTf);
        }
        this.fTb.bE(this.fTd, 100);
    }

    @Override // com.baidu.live.liveroom.d.d
    public View getPanelView() {
        if (this.fTa == null) {
            return null;
        }
        return this.fTa.getRootView();
    }

    public com.baidu.tieba.ala.charm.view.b bJq() {
        return this.fTa;
    }

    public void at(String str, boolean z) {
        if (this.fTa != null) {
            this.fTa.at(str, z);
        }
    }

    public void EW() {
        if (this.fTa != null) {
            this.fTa.EW();
        }
    }

    @Override // com.baidu.live.liveroom.d.d
    public String getTitle() {
        if (this.fTd == 2) {
            return this.fTc.getResources().getString(a.i.ala_charm_week_title);
        }
        if (this.fTd == 1) {
            return this.fTc.getResources().getString(a.i.ala_charm_all_title);
        }
        if (this.fTd == 3) {
            return this.fTc.getResources().getString(a.i.ala_charm_day_title);
        }
        if (this.fTd != 4) {
            return null;
        }
        return this.fTc.getResources().getString(a.i.audience_list_title);
    }

    public int bJr() {
        return this.fTd;
    }

    @Override // com.baidu.live.liveroom.d.d
    public String Jq() {
        return null;
    }

    @Override // com.baidu.live.liveroom.d.d
    public short Jr() {
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
        if (this.fTb != null) {
            this.fTb.onDestroy();
        }
        MessageManager.getInstance().unRegisterListener(this.fTe);
    }

    public a Ff(String str) {
        this.mUserId = str;
        return this;
    }

    public a Fg(String str) {
        this.mUserName = str;
        return this;
    }

    public a Fh(String str) {
        this.mGroupId = str;
        return this;
    }

    public a Fi(String str) {
        this.mLiveId = str;
        return this;
    }

    public a kX(boolean z) {
        this.bej = z;
        return this;
    }

    public a Fj(String str) {
        this.aBm = str;
        return this;
    }

    public a Fk(String str) {
        this.fSW = str;
        return this;
    }

    public a Fl(String str) {
        this.fSX = str;
        return this;
    }

    public a Fm(String str) {
        this.fSY = str;
        return this;
    }

    public a Fn(String str) {
        this.fSZ = str;
        return this;
    }

    public a Fo(String str) {
        this.mOtherParams = str;
        return this;
    }

    @Override // com.baidu.live.liveroom.d.d
    public void onChangeSkinType(int i) {
    }
}
