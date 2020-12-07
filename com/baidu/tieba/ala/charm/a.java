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
    private String aGk;
    private boolean bns;
    private com.baidu.tieba.ala.charm.view.b gDA;
    private com.baidu.tieba.ala.charm.model.a gDB;
    private ALaCharmCardActivity gDC;
    private int gDD;
    private String gDw;
    private String gDx;
    private String gDy;
    private String gDz;
    private String mGroupId;
    private boolean mHasMore;
    private String mLiveId;
    private String mOtherParams;
    private String mUserId;
    private String mUserName;
    private int pn = 0;
    CustomMessageListener gDE = new CustomMessageListener(2913095) { // from class: com.baidu.tieba.ala.charm.a.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof String)) {
                String str = (String) customResponsedMessage.getData();
                if (str == null) {
                    str = "";
                }
                if (a.this.gDA != null) {
                    a.this.gDA.setOtherParams(str);
                }
            }
        }
    };
    a.InterfaceC0650a gDF = new a.InterfaceC0650a() { // from class: com.baidu.tieba.ala.charm.a.2
        @Override // com.baidu.tieba.ala.charm.model.a.InterfaceC0650a
        public void a(ALaCharmDataList aLaCharmDataList) {
            if (aLaCharmDataList == null) {
                a.this.gDA.dG(true);
                return;
            }
            a.this.gDA.Yb();
            a.this.gDA.a(aLaCharmDataList.data, a.this.pn == 0, aLaCharmDataList.userTotalPrice);
            a.this.pn = aLaCharmDataList.pn + 1;
            a.this.mHasMore = aLaCharmDataList.hasMore;
            if (a.this.mHasMore) {
                a.this.gDA.XZ();
            } else {
                a.this.gDA.Hm(a.this.gDC.getPageContext().getResources().getString(a.h.charm_no_more));
            }
            if (aLaCharmDataList.data == null || aLaCharmDataList.data.size() <= 0) {
                a.this.gDA.dG(true);
            }
        }

        @Override // com.baidu.tieba.ala.charm.model.a.InterfaceC0650a
        public void t(int i, String str) {
            a.this.gDA.dG(false);
            a.this.gDA.m(new View.OnClickListener() { // from class: com.baidu.tieba.ala.charm.a.2.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (BdNetTypeUtil.isNetWorkAvailable()) {
                        if (a.this.gDB != null) {
                            a.this.gDB.M(a.this.gDD, a.this.pn, 100);
                            return;
                        }
                        return;
                    }
                    a.this.gDC.getPageContext().showToast(a.this.gDC.getResources().getString(a.h.sdk_no_network_guide));
                }
            });
        }
    };
    private BdListView.OnScrollToBottomListener gDG = new BdListView.OnScrollToBottomListener() { // from class: com.baidu.tieba.ala.charm.a.3
        @Override // com.baidu.live.adp.widget.listview.BdListView.OnScrollToBottomListener
        public void onScrollToBottom() {
            if (a.this.mHasMore && a.this.gDB != null) {
                a.this.gDB.M(a.this.gDD, a.this.pn, 100);
            }
        }
    };

    public a(ALaCharmCardActivity aLaCharmCardActivity, int i) {
        this.gDD = 1;
        this.gDC = aLaCharmCardActivity;
        this.gDD = i;
    }

    public void createView() {
        this.gDA = new com.baidu.tieba.ala.charm.view.b(this.gDC, this.mGroupId, this.mLiveId, this.bns, this.aGk, this.gDD, this.mUserId, this.mUserName, this.gDx, this.gDy, this.gDz);
        this.gDA.a(this.gDG);
        this.gDA.setOtherParams(this.mOtherParams);
        loadData();
        MessageManager.getInstance().registerListener(this.gDE);
    }

    private void loadData() {
        if (this.gDB == null) {
            this.gDB = new com.baidu.tieba.ala.charm.model.a(this.gDC.getPageContext(), this.mUserId, this.gDF);
        }
        this.gDB.bH(this.gDD, 100);
    }

    @Override // com.baidu.live.liveroom.d.d
    public View getPanelView() {
        if (this.gDA == null) {
            return null;
        }
        return this.gDA.getRootView();
    }

    public com.baidu.tieba.ala.charm.view.b bUf() {
        return this.gDA;
    }

    public void aA(String str, boolean z) {
        if (this.gDA != null) {
            this.gDA.aA(str, z);
        }
    }

    public void HO() {
        if (this.gDA != null) {
            this.gDA.HO();
        }
    }

    @Override // com.baidu.live.liveroom.d.d
    public String getTitle() {
        if (this.gDD == 2) {
            return this.gDC.getResources().getString(a.h.ala_charm_week_title);
        }
        if (this.gDD == 1) {
            return this.gDC.getResources().getString(a.h.ala_charm_all_title);
        }
        if (this.gDD == 3) {
            return this.gDC.getResources().getString(a.h.ala_charm_day_title);
        }
        if (this.gDD != 4) {
            return null;
        }
        return this.gDC.getResources().getString(a.h.audience_list_title);
    }

    public int bUg() {
        return this.gDD;
    }

    @Override // com.baidu.live.liveroom.d.d
    public String MK() {
        return null;
    }

    @Override // com.baidu.live.liveroom.d.d
    public short ML() {
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
        if (this.gDB != null) {
            this.gDB.onDestroy();
        }
        MessageManager.getInstance().unRegisterListener(this.gDE);
    }

    public a GS(String str) {
        this.mUserId = str;
        return this;
    }

    public a GT(String str) {
        this.mUserName = str;
        return this;
    }

    public a GU(String str) {
        this.mGroupId = str;
        return this;
    }

    public a GV(String str) {
        this.mLiveId = str;
        return this;
    }

    public a ms(boolean z) {
        this.bns = z;
        return this;
    }

    public a GW(String str) {
        this.aGk = str;
        return this;
    }

    public a GX(String str) {
        this.gDw = str;
        return this;
    }

    public a GY(String str) {
        this.gDx = str;
        return this;
    }

    public a GZ(String str) {
        this.gDy = str;
        return this;
    }

    public a Ha(String str) {
        this.gDz = str;
        return this;
    }

    public a Hb(String str) {
        this.mOtherParams = str;
        return this;
    }

    @Override // com.baidu.live.liveroom.d.d
    public void onChangeSkinType(int i) {
    }
}
