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
    private String gDA;
    private String gDB;
    private com.baidu.tieba.ala.charm.view.b gDC;
    private com.baidu.tieba.ala.charm.model.a gDD;
    private ALaCharmCardActivity gDE;
    private int gDF;
    private String gDy;
    private String gDz;
    private String mGroupId;
    private boolean mHasMore;
    private String mLiveId;
    private String mOtherParams;
    private String mUserId;
    private String mUserName;
    private int pn = 0;
    CustomMessageListener gDG = new CustomMessageListener(2913095) { // from class: com.baidu.tieba.ala.charm.a.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof String)) {
                String str = (String) customResponsedMessage.getData();
                if (str == null) {
                    str = "";
                }
                if (a.this.gDC != null) {
                    a.this.gDC.setOtherParams(str);
                }
            }
        }
    };
    a.InterfaceC0650a gDH = new a.InterfaceC0650a() { // from class: com.baidu.tieba.ala.charm.a.2
        @Override // com.baidu.tieba.ala.charm.model.a.InterfaceC0650a
        public void a(ALaCharmDataList aLaCharmDataList) {
            if (aLaCharmDataList == null) {
                a.this.gDC.dG(true);
                return;
            }
            a.this.gDC.Yb();
            a.this.gDC.a(aLaCharmDataList.data, a.this.pn == 0, aLaCharmDataList.userTotalPrice);
            a.this.pn = aLaCharmDataList.pn + 1;
            a.this.mHasMore = aLaCharmDataList.hasMore;
            if (a.this.mHasMore) {
                a.this.gDC.XZ();
            } else {
                a.this.gDC.Hm(a.this.gDE.getPageContext().getResources().getString(a.h.charm_no_more));
            }
            if (aLaCharmDataList.data == null || aLaCharmDataList.data.size() <= 0) {
                a.this.gDC.dG(true);
            }
        }

        @Override // com.baidu.tieba.ala.charm.model.a.InterfaceC0650a
        public void t(int i, String str) {
            a.this.gDC.dG(false);
            a.this.gDC.m(new View.OnClickListener() { // from class: com.baidu.tieba.ala.charm.a.2.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (BdNetTypeUtil.isNetWorkAvailable()) {
                        if (a.this.gDD != null) {
                            a.this.gDD.M(a.this.gDF, a.this.pn, 100);
                            return;
                        }
                        return;
                    }
                    a.this.gDE.getPageContext().showToast(a.this.gDE.getResources().getString(a.h.sdk_no_network_guide));
                }
            });
        }
    };
    private BdListView.OnScrollToBottomListener gDI = new BdListView.OnScrollToBottomListener() { // from class: com.baidu.tieba.ala.charm.a.3
        @Override // com.baidu.live.adp.widget.listview.BdListView.OnScrollToBottomListener
        public void onScrollToBottom() {
            if (a.this.mHasMore && a.this.gDD != null) {
                a.this.gDD.M(a.this.gDF, a.this.pn, 100);
            }
        }
    };

    public a(ALaCharmCardActivity aLaCharmCardActivity, int i) {
        this.gDF = 1;
        this.gDE = aLaCharmCardActivity;
        this.gDF = i;
    }

    public void createView() {
        this.gDC = new com.baidu.tieba.ala.charm.view.b(this.gDE, this.mGroupId, this.mLiveId, this.bns, this.aGk, this.gDF, this.mUserId, this.mUserName, this.gDz, this.gDA, this.gDB);
        this.gDC.a(this.gDI);
        this.gDC.setOtherParams(this.mOtherParams);
        loadData();
        MessageManager.getInstance().registerListener(this.gDG);
    }

    private void loadData() {
        if (this.gDD == null) {
            this.gDD = new com.baidu.tieba.ala.charm.model.a(this.gDE.getPageContext(), this.mUserId, this.gDH);
        }
        this.gDD.bH(this.gDF, 100);
    }

    @Override // com.baidu.live.liveroom.d.d
    public View getPanelView() {
        if (this.gDC == null) {
            return null;
        }
        return this.gDC.getRootView();
    }

    public com.baidu.tieba.ala.charm.view.b bUg() {
        return this.gDC;
    }

    public void aA(String str, boolean z) {
        if (this.gDC != null) {
            this.gDC.aA(str, z);
        }
    }

    public void HO() {
        if (this.gDC != null) {
            this.gDC.HO();
        }
    }

    @Override // com.baidu.live.liveroom.d.d
    public String getTitle() {
        if (this.gDF == 2) {
            return this.gDE.getResources().getString(a.h.ala_charm_week_title);
        }
        if (this.gDF == 1) {
            return this.gDE.getResources().getString(a.h.ala_charm_all_title);
        }
        if (this.gDF == 3) {
            return this.gDE.getResources().getString(a.h.ala_charm_day_title);
        }
        if (this.gDF != 4) {
            return null;
        }
        return this.gDE.getResources().getString(a.h.audience_list_title);
    }

    public int bUh() {
        return this.gDF;
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
        if (this.gDD != null) {
            this.gDD.onDestroy();
        }
        MessageManager.getInstance().unRegisterListener(this.gDG);
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
        this.gDy = str;
        return this;
    }

    public a GY(String str) {
        this.gDz = str;
        return this;
    }

    public a GZ(String str) {
        this.gDA = str;
        return this;
    }

    public a Ha(String str) {
        this.gDB = str;
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
