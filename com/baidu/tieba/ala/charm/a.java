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
    private String aEz;
    private boolean bjr;
    private String gps;
    private String gpt;
    private String gpu;
    private String gpv;
    private com.baidu.tieba.ala.charm.view.b gpw;
    private com.baidu.tieba.ala.charm.model.a gpx;
    private ALaCharmCardActivity gpy;
    private int gpz;
    private String mGroupId;
    private boolean mHasMore;
    private String mLiveId;
    private String mOtherParams;
    private String mUserId;
    private String mUserName;
    private int pn = 0;
    CustomMessageListener gpA = new CustomMessageListener(2913095) { // from class: com.baidu.tieba.ala.charm.a.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof String)) {
                String str = (String) customResponsedMessage.getData();
                if (str == null) {
                    str = "";
                }
                if (a.this.gpw != null) {
                    a.this.gpw.setOtherParams(str);
                }
            }
        }
    };
    a.InterfaceC0626a gpB = new a.InterfaceC0626a() { // from class: com.baidu.tieba.ala.charm.a.2
        @Override // com.baidu.tieba.ala.charm.model.a.InterfaceC0626a
        public void a(ALaCharmDataList aLaCharmDataList) {
            if (aLaCharmDataList == null) {
                a.this.gpw.dj(true);
                return;
            }
            a.this.gpw.TK();
            a.this.gpw.a(aLaCharmDataList.data, a.this.pn == 0, aLaCharmDataList.userTotalPrice);
            a.this.pn = aLaCharmDataList.pn + 1;
            a.this.mHasMore = aLaCharmDataList.hasMore;
            if (a.this.mHasMore) {
                a.this.gpw.TI();
            } else {
                a.this.gpw.GK(a.this.gpy.getPageContext().getResources().getString(a.i.charm_no_more));
            }
            if (aLaCharmDataList.data == null || aLaCharmDataList.data.size() <= 0) {
                a.this.gpw.dj(true);
            }
        }

        @Override // com.baidu.tieba.ala.charm.model.a.InterfaceC0626a
        public void t(int i, String str) {
            a.this.gpw.dj(false);
            a.this.gpw.l(new View.OnClickListener() { // from class: com.baidu.tieba.ala.charm.a.2.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (BdNetTypeUtil.isNetWorkAvailable()) {
                        if (a.this.gpx != null) {
                            a.this.gpx.L(a.this.gpz, a.this.pn, 100);
                            return;
                        }
                        return;
                    }
                    a.this.gpy.getPageContext().showToast(a.this.gpy.getResources().getString(a.i.sdk_no_network_guide));
                }
            });
        }
    };
    private BdListView.OnScrollToBottomListener gpC = new BdListView.OnScrollToBottomListener() { // from class: com.baidu.tieba.ala.charm.a.3
        @Override // com.baidu.live.adp.widget.listview.BdListView.OnScrollToBottomListener
        public void onScrollToBottom() {
            if (a.this.mHasMore && a.this.gpx != null) {
                a.this.gpx.L(a.this.gpz, a.this.pn, 100);
            }
        }
    };

    public a(ALaCharmCardActivity aLaCharmCardActivity, int i) {
        this.gpz = 1;
        this.gpy = aLaCharmCardActivity;
        this.gpz = i;
    }

    public void createView() {
        this.gpw = new com.baidu.tieba.ala.charm.view.b(this.gpy, this.mGroupId, this.mLiveId, this.bjr, this.aEz, this.gpz, this.mUserId, this.mUserName, this.gpt, this.gpu, this.gpv);
        this.gpw.a(this.gpC);
        this.gpw.setOtherParams(this.mOtherParams);
        loadData();
        MessageManager.getInstance().registerListener(this.gpA);
    }

    private void loadData() {
        if (this.gpx == null) {
            this.gpx = new com.baidu.tieba.ala.charm.model.a(this.gpy.getPageContext(), this.mUserId, this.gpB);
        }
        this.gpx.bF(this.gpz, 100);
    }

    @Override // com.baidu.live.liveroom.d.d
    public View getPanelView() {
        if (this.gpw == null) {
            return null;
        }
        return this.gpw.getRootView();
    }

    public com.baidu.tieba.ala.charm.view.b bOC() {
        return this.gpw;
    }

    public void az(String str, boolean z) {
        if (this.gpw != null) {
            this.gpw.az(str, z);
        }
    }

    public void Gh() {
        if (this.gpw != null) {
            this.gpw.Gh();
        }
    }

    @Override // com.baidu.live.liveroom.d.d
    public String getTitle() {
        if (this.gpz == 2) {
            return this.gpy.getResources().getString(a.i.ala_charm_week_title);
        }
        if (this.gpz == 1) {
            return this.gpy.getResources().getString(a.i.ala_charm_all_title);
        }
        if (this.gpz == 3) {
            return this.gpy.getResources().getString(a.i.ala_charm_day_title);
        }
        if (this.gpz != 4) {
            return null;
        }
        return this.gpy.getResources().getString(a.i.audience_list_title);
    }

    public int bOD() {
        return this.gpz;
    }

    @Override // com.baidu.live.liveroom.d.d
    public String KR() {
        return null;
    }

    @Override // com.baidu.live.liveroom.d.d
    public short KS() {
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
        if (this.gpx != null) {
            this.gpx.onDestroy();
        }
        MessageManager.getInstance().unRegisterListener(this.gpA);
    }

    public a Gp(String str) {
        this.mUserId = str;
        return this;
    }

    public a Gq(String str) {
        this.mUserName = str;
        return this;
    }

    public a Gr(String str) {
        this.mGroupId = str;
        return this;
    }

    public a Gs(String str) {
        this.mLiveId = str;
        return this;
    }

    public a lN(boolean z) {
        this.bjr = z;
        return this;
    }

    public a Gt(String str) {
        this.aEz = str;
        return this;
    }

    public a Gu(String str) {
        this.gps = str;
        return this;
    }

    public a Gv(String str) {
        this.gpt = str;
        return this;
    }

    public a Gw(String str) {
        this.gpu = str;
        return this;
    }

    public a Gx(String str) {
        this.gpv = str;
        return this;
    }

    public a Gy(String str) {
        this.mOtherParams = str;
        return this;
    }

    @Override // com.baidu.live.liveroom.d.d
    public void onChangeSkinType(int i) {
    }
}
