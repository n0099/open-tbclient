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
    private String aFp;
    private boolean bkL;
    private String gvg;
    private String gvh;
    private String gvi;
    private String gvj;
    private com.baidu.tieba.ala.charm.view.b gvk;
    private com.baidu.tieba.ala.charm.model.a gvl;
    private ALaCharmCardActivity gvm;
    private int gvn;
    private String mGroupId;
    private boolean mHasMore;
    private String mLiveId;
    private String mOtherParams;
    private String mUserId;
    private String mUserName;
    private int pn = 0;
    CustomMessageListener gvo = new CustomMessageListener(2913095) { // from class: com.baidu.tieba.ala.charm.a.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof String)) {
                String str = (String) customResponsedMessage.getData();
                if (str == null) {
                    str = "";
                }
                if (a.this.gvk != null) {
                    a.this.gvk.setOtherParams(str);
                }
            }
        }
    };
    a.InterfaceC0638a gvp = new a.InterfaceC0638a() { // from class: com.baidu.tieba.ala.charm.a.2
        @Override // com.baidu.tieba.ala.charm.model.a.InterfaceC0638a
        public void a(ALaCharmDataList aLaCharmDataList) {
            if (aLaCharmDataList == null) {
                a.this.gvk.dq(true);
                return;
            }
            a.this.gvk.Wk();
            a.this.gvk.a(aLaCharmDataList.data, a.this.pn == 0, aLaCharmDataList.userTotalPrice);
            a.this.pn = aLaCharmDataList.pn + 1;
            a.this.mHasMore = aLaCharmDataList.hasMore;
            if (a.this.mHasMore) {
                a.this.gvk.Wi();
            } else {
                a.this.gvk.GX(a.this.gvm.getPageContext().getResources().getString(a.h.charm_no_more));
            }
            if (aLaCharmDataList.data == null || aLaCharmDataList.data.size() <= 0) {
                a.this.gvk.dq(true);
            }
        }

        @Override // com.baidu.tieba.ala.charm.model.a.InterfaceC0638a
        public void t(int i, String str) {
            a.this.gvk.dq(false);
            a.this.gvk.m(new View.OnClickListener() { // from class: com.baidu.tieba.ala.charm.a.2.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (BdNetTypeUtil.isNetWorkAvailable()) {
                        if (a.this.gvl != null) {
                            a.this.gvl.L(a.this.gvn, a.this.pn, 100);
                            return;
                        }
                        return;
                    }
                    a.this.gvm.getPageContext().showToast(a.this.gvm.getResources().getString(a.h.sdk_no_network_guide));
                }
            });
        }
    };
    private BdListView.OnScrollToBottomListener gvq = new BdListView.OnScrollToBottomListener() { // from class: com.baidu.tieba.ala.charm.a.3
        @Override // com.baidu.live.adp.widget.listview.BdListView.OnScrollToBottomListener
        public void onScrollToBottom() {
            if (a.this.mHasMore && a.this.gvl != null) {
                a.this.gvl.L(a.this.gvn, a.this.pn, 100);
            }
        }
    };

    public a(ALaCharmCardActivity aLaCharmCardActivity, int i) {
        this.gvn = 1;
        this.gvm = aLaCharmCardActivity;
        this.gvn = i;
    }

    public void createView() {
        this.gvk = new com.baidu.tieba.ala.charm.view.b(this.gvm, this.mGroupId, this.mLiveId, this.bkL, this.aFp, this.gvn, this.mUserId, this.mUserName, this.gvh, this.gvi, this.gvj);
        this.gvk.a(this.gvq);
        this.gvk.setOtherParams(this.mOtherParams);
        loadData();
        MessageManager.getInstance().registerListener(this.gvo);
    }

    private void loadData() {
        if (this.gvl == null) {
            this.gvl = new com.baidu.tieba.ala.charm.model.a(this.gvm.getPageContext(), this.mUserId, this.gvp);
        }
        this.gvl.bF(this.gvn, 100);
    }

    @Override // com.baidu.live.liveroom.d.d
    public View getPanelView() {
        if (this.gvk == null) {
            return null;
        }
        return this.gvk.getRootView();
    }

    public com.baidu.tieba.ala.charm.view.b bRc() {
        return this.gvk;
    }

    public void az(String str, boolean z) {
        if (this.gvk != null) {
            this.gvk.az(str, z);
        }
    }

    public void GI() {
        if (this.gvk != null) {
            this.gvk.GI();
        }
    }

    @Override // com.baidu.live.liveroom.d.d
    public String getTitle() {
        if (this.gvn == 2) {
            return this.gvm.getResources().getString(a.h.ala_charm_week_title);
        }
        if (this.gvn == 1) {
            return this.gvm.getResources().getString(a.h.ala_charm_all_title);
        }
        if (this.gvn == 3) {
            return this.gvm.getResources().getString(a.h.ala_charm_day_title);
        }
        if (this.gvn != 4) {
            return null;
        }
        return this.gvm.getResources().getString(a.h.audience_list_title);
    }

    public int bRd() {
        return this.gvn;
    }

    @Override // com.baidu.live.liveroom.d.d
    public String Lr() {
        return null;
    }

    @Override // com.baidu.live.liveroom.d.d
    public short Ls() {
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
        if (this.gvl != null) {
            this.gvl.onDestroy();
        }
        MessageManager.getInstance().unRegisterListener(this.gvo);
    }

    public a GD(String str) {
        this.mUserId = str;
        return this;
    }

    public a GE(String str) {
        this.mUserName = str;
        return this;
    }

    public a GF(String str) {
        this.mGroupId = str;
        return this;
    }

    public a GG(String str) {
        this.mLiveId = str;
        return this;
    }

    public a lW(boolean z) {
        this.bkL = z;
        return this;
    }

    public a GH(String str) {
        this.aFp = str;
        return this;
    }

    public a GI(String str) {
        this.gvg = str;
        return this;
    }

    public a GJ(String str) {
        this.gvh = str;
        return this;
    }

    public a GK(String str) {
        this.gvi = str;
        return this;
    }

    public a GL(String str) {
        this.gvj = str;
        return this;
    }

    public a GM(String str) {
        this.mOtherParams = str;
        return this;
    }

    @Override // com.baidu.live.liveroom.d.d
    public void onChangeSkinType(int i) {
    }
}
