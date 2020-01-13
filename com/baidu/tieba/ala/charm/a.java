package com.baidu.tieba.ala.charm;

import android.view.View;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.listener.CustomMessageListener;
import com.baidu.live.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.adp.lib.util.BdNetTypeUtil;
import com.baidu.live.adp.widget.listview.BdListView;
import com.baidu.live.r.a;
import com.baidu.tieba.ala.charm.data.ALaCharmDataList;
import com.baidu.tieba.ala.charm.model.a;
/* loaded from: classes2.dex */
public class a implements com.baidu.live.liveroom.c.d {
    private String apA;
    private boolean apz;
    private String ers;
    private String ert;
    private String eru;
    private String erv;
    private com.baidu.tieba.ala.charm.view.b erw;
    private com.baidu.tieba.ala.charm.model.a erx;
    private ALaCharmCardActivity ery;
    private int erz;
    private String mGroupId;
    private boolean mHasMore;
    private String mLiveId;
    private String mOtherParams;
    private String mUserId;
    private String mUserName;
    private int pn = 0;
    CustomMessageListener erA = new CustomMessageListener(2913095) { // from class: com.baidu.tieba.ala.charm.a.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof String)) {
                String str = (String) customResponsedMessage.getData();
                if (str == null) {
                    str = "";
                }
                if (a.this.erw != null) {
                    a.this.erw.setOtherParams(str);
                }
            }
        }
    };
    a.InterfaceC0417a erB = new a.InterfaceC0417a() { // from class: com.baidu.tieba.ala.charm.a.2
        @Override // com.baidu.tieba.ala.charm.model.a.InterfaceC0417a
        public void a(ALaCharmDataList aLaCharmDataList) {
            if (aLaCharmDataList == null) {
                a.this.erw.ic(true);
                return;
            }
            a.this.erw.baf();
            a.this.erw.a(aLaCharmDataList.data, a.this.pn == 0, aLaCharmDataList.userTotalPrice);
            a.this.pn = aLaCharmDataList.pn + 1;
            a.this.mHasMore = aLaCharmDataList.hasMore;
            if (a.this.mHasMore) {
                a.this.erw.bba();
            } else {
                a.this.erw.xB(a.this.ery.getPageContext().getResources().getString(a.i.charm_no_more));
            }
            if (aLaCharmDataList.data == null || aLaCharmDataList.data.size() <= 0) {
                a.this.erw.ic(true);
            }
        }

        @Override // com.baidu.tieba.ala.charm.model.a.InterfaceC0417a
        public void ac(int i, String str) {
            a.this.erw.ic(false);
            a.this.erw.l(new View.OnClickListener() { // from class: com.baidu.tieba.ala.charm.a.2.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (BdNetTypeUtil.isNetWorkAvailable()) {
                        if (a.this.erx != null) {
                            a.this.erx.D(a.this.erz, a.this.pn, 100);
                            return;
                        }
                        return;
                    }
                    a.this.ery.getPageContext().showToast(a.this.ery.getResources().getString(a.i.sdk_no_network_guide));
                }
            });
        }
    };
    private BdListView.OnScrollToBottomListener erC = new BdListView.OnScrollToBottomListener() { // from class: com.baidu.tieba.ala.charm.a.3
        @Override // com.baidu.live.adp.widget.listview.BdListView.OnScrollToBottomListener
        public void onScrollToBottom() {
            if (a.this.mHasMore && a.this.erx != null) {
                a.this.erx.D(a.this.erz, a.this.pn, 100);
            }
        }
    };

    public a(ALaCharmCardActivity aLaCharmCardActivity, int i) {
        this.erz = 1;
        this.ery = aLaCharmCardActivity;
        this.erz = i;
    }

    public void createView() {
        this.erw = new com.baidu.tieba.ala.charm.view.b(this.ery, this.mGroupId, this.mLiveId, this.apz, this.apA, this.erz, this.mUserId, this.mUserName, this.ert, this.eru, this.erv);
        this.erw.a(this.erC);
        this.erw.setOtherParams(this.mOtherParams);
        loadData();
        MessageManager.getInstance().registerListener(this.erA);
    }

    private void loadData() {
        if (this.erx == null) {
            this.erx = new com.baidu.tieba.ala.charm.model.a(this.ery.getPageContext(), this.mUserId, this.erB);
        }
        this.erx.bf(this.erz, 100);
    }

    @Override // com.baidu.live.liveroom.c.d
    public View uA() {
        if (this.erw == null) {
            return null;
        }
        return this.erw.getRootView();
    }

    public com.baidu.tieba.ala.charm.view.b bbz() {
        return this.erw;
    }

    public void X(String str, boolean z) {
        if (this.erw != null) {
            this.erw.X(str, z);
        }
    }

    public void rl() {
        if (this.erw != null) {
            this.erw.rl();
        }
    }

    @Override // com.baidu.live.liveroom.c.d
    public String getTitle() {
        if (this.erz == 2) {
            return this.ery.getResources().getString(a.i.ala_charm_week_title);
        }
        if (this.erz == 1) {
            return this.ery.getResources().getString(a.i.ala_charm_all_title);
        }
        if (this.erz == 3) {
            return this.ery.getResources().getString(a.i.ala_charm_day_title);
        }
        if (this.erz != 4) {
            return null;
        }
        return this.ery.getResources().getString(a.i.audience_list_title);
    }

    public int bbA() {
        return this.erz;
    }

    @Override // com.baidu.live.liveroom.c.d
    public String uB() {
        return null;
    }

    @Override // com.baidu.live.liveroom.c.d
    public short uC() {
        return (short) 0;
    }

    @Override // com.baidu.live.liveroom.c.d
    public void enterBackground() {
    }

    @Override // com.baidu.live.liveroom.c.d
    public void enterForeground() {
    }

    @Override // com.baidu.live.liveroom.c.d
    public void onDestroy() {
        if (this.erx != null) {
            this.erx.onDestroy();
        }
        MessageManager.getInstance().unRegisterListener(this.erA);
    }

    public a xr(String str) {
        this.mUserId = str;
        return this;
    }

    public a xs(String str) {
        this.mUserName = str;
        return this;
    }

    public a xt(String str) {
        this.mGroupId = str;
        return this;
    }

    public a xu(String str) {
        this.mLiveId = str;
        return this;
    }

    public a ib(boolean z) {
        this.apz = z;
        return this;
    }

    public a xv(String str) {
        this.apA = str;
        return this;
    }

    public a xw(String str) {
        this.ers = str;
        return this;
    }

    public a xx(String str) {
        this.ert = str;
        return this;
    }

    public a xy(String str) {
        this.eru = str;
        return this;
    }

    public a xz(String str) {
        this.erv = str;
        return this;
    }

    public a xA(String str) {
        this.mOtherParams = str;
        return this;
    }

    @Override // com.baidu.live.liveroom.c.d
    public void onChangeSkinType(int i) {
    }
}
