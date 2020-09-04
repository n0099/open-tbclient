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
/* loaded from: classes7.dex */
public class a implements com.baidu.live.liveroom.d.d {
    private String aAG;
    private boolean bbJ;
    private String fPL;
    private String fPM;
    private String fPN;
    private String fPO;
    private com.baidu.tieba.ala.charm.view.b fPP;
    private com.baidu.tieba.ala.charm.model.a fPQ;
    private ALaCharmCardActivity fPR;
    private int fPS;
    private String mGroupId;
    private boolean mHasMore;
    private String mLiveId;
    private String mOtherParams;
    private String mUserId;
    private String mUserName;
    private int pn = 0;
    CustomMessageListener fPT = new CustomMessageListener(2913095) { // from class: com.baidu.tieba.ala.charm.a.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof String)) {
                String str = (String) customResponsedMessage.getData();
                if (str == null) {
                    str = "";
                }
                if (a.this.fPP != null) {
                    a.this.fPP.setOtherParams(str);
                }
            }
        }
    };
    a.InterfaceC0597a fPU = new a.InterfaceC0597a() { // from class: com.baidu.tieba.ala.charm.a.2
        @Override // com.baidu.tieba.ala.charm.model.a.InterfaceC0597a
        public void a(ALaCharmDataList aLaCharmDataList) {
            if (aLaCharmDataList == null) {
                a.this.fPP.kW(true);
                return;
            }
            a.this.fPP.bFX();
            a.this.fPP.a(aLaCharmDataList.data, a.this.pn == 0, aLaCharmDataList.userTotalPrice);
            a.this.pn = aLaCharmDataList.pn + 1;
            a.this.mHasMore = aLaCharmDataList.hasMore;
            if (a.this.mHasMore) {
                a.this.fPP.bGS();
            } else {
                a.this.fPP.Fc(a.this.fPR.getPageContext().getResources().getString(a.i.charm_no_more));
            }
            if (aLaCharmDataList.data == null || aLaCharmDataList.data.size() <= 0) {
                a.this.fPP.kW(true);
            }
        }

        @Override // com.baidu.tieba.ala.charm.model.a.InterfaceC0597a
        public void ay(int i, String str) {
            a.this.fPP.kW(false);
            a.this.fPP.l(new View.OnClickListener() { // from class: com.baidu.tieba.ala.charm.a.2.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (BdNetTypeUtil.isNetWorkAvailable()) {
                        if (a.this.fPQ != null) {
                            a.this.fPQ.J(a.this.fPS, a.this.pn, 100);
                            return;
                        }
                        return;
                    }
                    a.this.fPR.getPageContext().showToast(a.this.fPR.getResources().getString(a.i.sdk_no_network_guide));
                }
            });
        }
    };
    private BdListView.OnScrollToBottomListener fPV = new BdListView.OnScrollToBottomListener() { // from class: com.baidu.tieba.ala.charm.a.3
        @Override // com.baidu.live.adp.widget.listview.BdListView.OnScrollToBottomListener
        public void onScrollToBottom() {
            if (a.this.mHasMore && a.this.fPQ != null) {
                a.this.fPQ.J(a.this.fPS, a.this.pn, 100);
            }
        }
    };

    public a(ALaCharmCardActivity aLaCharmCardActivity, int i) {
        this.fPS = 1;
        this.fPR = aLaCharmCardActivity;
        this.fPS = i;
    }

    public void createView() {
        this.fPP = new com.baidu.tieba.ala.charm.view.b(this.fPR, this.mGroupId, this.mLiveId, this.bbJ, this.aAG, this.fPS, this.mUserId, this.mUserName, this.fPM, this.fPN, this.fPO);
        this.fPP.a(this.fPV);
        this.fPP.setOtherParams(this.mOtherParams);
        loadData();
        MessageManager.getInstance().registerListener(this.fPT);
    }

    private void loadData() {
        if (this.fPQ == null) {
            this.fPQ = new com.baidu.tieba.ala.charm.model.a(this.fPR.getPageContext(), this.mUserId, this.fPU);
        }
        this.fPQ.bE(this.fPS, 100);
    }

    @Override // com.baidu.live.liveroom.d.d
    public View getPanelView() {
        if (this.fPP == null) {
            return null;
        }
        return this.fPP.getRootView();
    }

    public com.baidu.tieba.ala.charm.view.b bIi() {
        return this.fPP;
    }

    public void at(String str, boolean z) {
        if (this.fPP != null) {
            this.fPP.at(str, z);
        }
    }

    public void EF() {
        if (this.fPP != null) {
            this.fPP.EF();
        }
    }

    @Override // com.baidu.live.liveroom.d.d
    public String getTitle() {
        if (this.fPS == 2) {
            return this.fPR.getResources().getString(a.i.ala_charm_week_title);
        }
        if (this.fPS == 1) {
            return this.fPR.getResources().getString(a.i.ala_charm_all_title);
        }
        if (this.fPS == 3) {
            return this.fPR.getResources().getString(a.i.ala_charm_day_title);
        }
        if (this.fPS != 4) {
            return null;
        }
        return this.fPR.getResources().getString(a.i.audience_list_title);
    }

    public int bIj() {
        return this.fPS;
    }

    @Override // com.baidu.live.liveroom.d.d
    public String IM() {
        return null;
    }

    @Override // com.baidu.live.liveroom.d.d
    public short IN() {
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
        if (this.fPQ != null) {
            this.fPQ.onDestroy();
        }
        MessageManager.getInstance().unRegisterListener(this.fPT);
    }

    public a EI(String str) {
        this.mUserId = str;
        return this;
    }

    public a EJ(String str) {
        this.mUserName = str;
        return this;
    }

    public a EK(String str) {
        this.mGroupId = str;
        return this;
    }

    public a EL(String str) {
        this.mLiveId = str;
        return this;
    }

    public a kV(boolean z) {
        this.bbJ = z;
        return this;
    }

    public a EM(String str) {
        this.aAG = str;
        return this;
    }

    public a EN(String str) {
        this.fPL = str;
        return this;
    }

    public a EO(String str) {
        this.fPM = str;
        return this;
    }

    public a EP(String str) {
        this.fPN = str;
        return this;
    }

    public a EQ(String str) {
        this.fPO = str;
        return this;
    }

    public a ER(String str) {
        this.mOtherParams = str;
        return this;
    }

    @Override // com.baidu.live.liveroom.d.d
    public void onChangeSkinType(int i) {
    }
}
