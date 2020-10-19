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
    private String aEr;
    private boolean bhU;
    private String gfp;
    private String gfq;
    private String gfr;
    private String gfs;
    private com.baidu.tieba.ala.charm.view.b gft;
    private com.baidu.tieba.ala.charm.model.a gfu;
    private ALaCharmCardActivity gfv;
    private int gfw;
    private String mGroupId;
    private boolean mHasMore;
    private String mLiveId;
    private String mOtherParams;
    private String mUserId;
    private String mUserName;
    private int pn = 0;
    CustomMessageListener gfx = new CustomMessageListener(2913095) { // from class: com.baidu.tieba.ala.charm.a.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof String)) {
                String str = (String) customResponsedMessage.getData();
                if (str == null) {
                    str = "";
                }
                if (a.this.gft != null) {
                    a.this.gft.setOtherParams(str);
                }
            }
        }
    };
    a.InterfaceC0610a gfy = new a.InterfaceC0610a() { // from class: com.baidu.tieba.ala.charm.a.2
        @Override // com.baidu.tieba.ala.charm.model.a.InterfaceC0610a
        public void a(ALaCharmDataList aLaCharmDataList) {
            if (aLaCharmDataList == null) {
                a.this.gft.lw(true);
                return;
            }
            a.this.gft.SK();
            a.this.gft.a(aLaCharmDataList.data, a.this.pn == 0, aLaCharmDataList.userTotalPrice);
            a.this.pn = aLaCharmDataList.pn + 1;
            a.this.mHasMore = aLaCharmDataList.hasMore;
            if (a.this.mHasMore) {
                a.this.gft.SI();
            } else {
                a.this.gft.Gl(a.this.gfv.getPageContext().getResources().getString(a.i.charm_no_more));
            }
            if (aLaCharmDataList.data == null || aLaCharmDataList.data.size() <= 0) {
                a.this.gft.lw(true);
            }
        }

        @Override // com.baidu.tieba.ala.charm.model.a.InterfaceC0610a
        public void aK(int i, String str) {
            a.this.gft.lw(false);
            a.this.gft.l(new View.OnClickListener() { // from class: com.baidu.tieba.ala.charm.a.2.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (BdNetTypeUtil.isNetWorkAvailable()) {
                        if (a.this.gfu != null) {
                            a.this.gfu.J(a.this.gfw, a.this.pn, 100);
                            return;
                        }
                        return;
                    }
                    a.this.gfv.getPageContext().showToast(a.this.gfv.getResources().getString(a.i.sdk_no_network_guide));
                }
            });
        }
    };
    private BdListView.OnScrollToBottomListener gfz = new BdListView.OnScrollToBottomListener() { // from class: com.baidu.tieba.ala.charm.a.3
        @Override // com.baidu.live.adp.widget.listview.BdListView.OnScrollToBottomListener
        public void onScrollToBottom() {
            if (a.this.mHasMore && a.this.gfu != null) {
                a.this.gfu.J(a.this.gfw, a.this.pn, 100);
            }
        }
    };

    public a(ALaCharmCardActivity aLaCharmCardActivity, int i) {
        this.gfw = 1;
        this.gfv = aLaCharmCardActivity;
        this.gfw = i;
    }

    public void createView() {
        this.gft = new com.baidu.tieba.ala.charm.view.b(this.gfv, this.mGroupId, this.mLiveId, this.bhU, this.aEr, this.gfw, this.mUserId, this.mUserName, this.gfq, this.gfr, this.gfs);
        this.gft.a(this.gfz);
        this.gft.setOtherParams(this.mOtherParams);
        loadData();
        MessageManager.getInstance().registerListener(this.gfx);
    }

    private void loadData() {
        if (this.gfu == null) {
            this.gfu = new com.baidu.tieba.ala.charm.model.a(this.gfv.getPageContext(), this.mUserId, this.gfy);
        }
        this.gfu.bD(this.gfw, 100);
    }

    @Override // com.baidu.live.liveroom.d.d
    public View getPanelView() {
        if (this.gft == null) {
            return null;
        }
        return this.gft.getRootView();
    }

    public com.baidu.tieba.ala.charm.view.b bMa() {
        return this.gft;
    }

    public void ax(String str, boolean z) {
        if (this.gft != null) {
            this.gft.ax(str, z);
        }
    }

    public void FS() {
        if (this.gft != null) {
            this.gft.FS();
        }
    }

    @Override // com.baidu.live.liveroom.d.d
    public String getTitle() {
        if (this.gfw == 2) {
            return this.gfv.getResources().getString(a.i.ala_charm_week_title);
        }
        if (this.gfw == 1) {
            return this.gfv.getResources().getString(a.i.ala_charm_all_title);
        }
        if (this.gfw == 3) {
            return this.gfv.getResources().getString(a.i.ala_charm_day_title);
        }
        if (this.gfw != 4) {
            return null;
        }
        return this.gfv.getResources().getString(a.i.audience_list_title);
    }

    public int bMb() {
        return this.gfw;
    }

    @Override // com.baidu.live.liveroom.d.d
    public String Kx() {
        return null;
    }

    @Override // com.baidu.live.liveroom.d.d
    public short Ky() {
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
        if (this.gfu != null) {
            this.gfu.onDestroy();
        }
        MessageManager.getInstance().unRegisterListener(this.gfx);
    }

    public a FQ(String str) {
        this.mUserId = str;
        return this;
    }

    public a FR(String str) {
        this.mUserName = str;
        return this;
    }

    public a FS(String str) {
        this.mGroupId = str;
        return this;
    }

    public a FT(String str) {
        this.mLiveId = str;
        return this;
    }

    public a lv(boolean z) {
        this.bhU = z;
        return this;
    }

    public a FU(String str) {
        this.aEr = str;
        return this;
    }

    public a FV(String str) {
        this.gfp = str;
        return this;
    }

    public a FW(String str) {
        this.gfq = str;
        return this;
    }

    public a FX(String str) {
        this.gfr = str;
        return this;
    }

    public a FY(String str) {
        this.gfs = str;
        return this;
    }

    public a FZ(String str) {
        this.mOtherParams = str;
        return this;
    }

    @Override // com.baidu.live.liveroom.d.d
    public void onChangeSkinType(int i) {
    }
}
