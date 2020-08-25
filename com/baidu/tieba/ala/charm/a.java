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
    private String aAE;
    private boolean bbH;
    private String fPH;
    private String fPI;
    private String fPJ;
    private String fPK;
    private com.baidu.tieba.ala.charm.view.b fPL;
    private com.baidu.tieba.ala.charm.model.a fPM;
    private ALaCharmCardActivity fPN;
    private int fPO;
    private String mGroupId;
    private boolean mHasMore;
    private String mLiveId;
    private String mOtherParams;
    private String mUserId;
    private String mUserName;
    private int pn = 0;
    CustomMessageListener fPP = new CustomMessageListener(2913095) { // from class: com.baidu.tieba.ala.charm.a.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof String)) {
                String str = (String) customResponsedMessage.getData();
                if (str == null) {
                    str = "";
                }
                if (a.this.fPL != null) {
                    a.this.fPL.setOtherParams(str);
                }
            }
        }
    };
    a.InterfaceC0597a fPQ = new a.InterfaceC0597a() { // from class: com.baidu.tieba.ala.charm.a.2
        @Override // com.baidu.tieba.ala.charm.model.a.InterfaceC0597a
        public void a(ALaCharmDataList aLaCharmDataList) {
            if (aLaCharmDataList == null) {
                a.this.fPL.kU(true);
                return;
            }
            a.this.fPL.bFW();
            a.this.fPL.a(aLaCharmDataList.data, a.this.pn == 0, aLaCharmDataList.userTotalPrice);
            a.this.pn = aLaCharmDataList.pn + 1;
            a.this.mHasMore = aLaCharmDataList.hasMore;
            if (a.this.mHasMore) {
                a.this.fPL.bGR();
            } else {
                a.this.fPL.Fb(a.this.fPN.getPageContext().getResources().getString(a.i.charm_no_more));
            }
            if (aLaCharmDataList.data == null || aLaCharmDataList.data.size() <= 0) {
                a.this.fPL.kU(true);
            }
        }

        @Override // com.baidu.tieba.ala.charm.model.a.InterfaceC0597a
        public void az(int i, String str) {
            a.this.fPL.kU(false);
            a.this.fPL.l(new View.OnClickListener() { // from class: com.baidu.tieba.ala.charm.a.2.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (BdNetTypeUtil.isNetWorkAvailable()) {
                        if (a.this.fPM != null) {
                            a.this.fPM.J(a.this.fPO, a.this.pn, 100);
                            return;
                        }
                        return;
                    }
                    a.this.fPN.getPageContext().showToast(a.this.fPN.getResources().getString(a.i.sdk_no_network_guide));
                }
            });
        }
    };
    private BdListView.OnScrollToBottomListener fPR = new BdListView.OnScrollToBottomListener() { // from class: com.baidu.tieba.ala.charm.a.3
        @Override // com.baidu.live.adp.widget.listview.BdListView.OnScrollToBottomListener
        public void onScrollToBottom() {
            if (a.this.mHasMore && a.this.fPM != null) {
                a.this.fPM.J(a.this.fPO, a.this.pn, 100);
            }
        }
    };

    public a(ALaCharmCardActivity aLaCharmCardActivity, int i) {
        this.fPO = 1;
        this.fPN = aLaCharmCardActivity;
        this.fPO = i;
    }

    public void createView() {
        this.fPL = new com.baidu.tieba.ala.charm.view.b(this.fPN, this.mGroupId, this.mLiveId, this.bbH, this.aAE, this.fPO, this.mUserId, this.mUserName, this.fPI, this.fPJ, this.fPK);
        this.fPL.a(this.fPR);
        this.fPL.setOtherParams(this.mOtherParams);
        loadData();
        MessageManager.getInstance().registerListener(this.fPP);
    }

    private void loadData() {
        if (this.fPM == null) {
            this.fPM = new com.baidu.tieba.ala.charm.model.a(this.fPN.getPageContext(), this.mUserId, this.fPQ);
        }
        this.fPM.bE(this.fPO, 100);
    }

    @Override // com.baidu.live.liveroom.d.d
    public View getPanelView() {
        if (this.fPL == null) {
            return null;
        }
        return this.fPL.getRootView();
    }

    public com.baidu.tieba.ala.charm.view.b bIh() {
        return this.fPL;
    }

    public void at(String str, boolean z) {
        if (this.fPL != null) {
            this.fPL.at(str, z);
        }
    }

    public void EF() {
        if (this.fPL != null) {
            this.fPL.EF();
        }
    }

    @Override // com.baidu.live.liveroom.d.d
    public String getTitle() {
        if (this.fPO == 2) {
            return this.fPN.getResources().getString(a.i.ala_charm_week_title);
        }
        if (this.fPO == 1) {
            return this.fPN.getResources().getString(a.i.ala_charm_all_title);
        }
        if (this.fPO == 3) {
            return this.fPN.getResources().getString(a.i.ala_charm_day_title);
        }
        if (this.fPO != 4) {
            return null;
        }
        return this.fPN.getResources().getString(a.i.audience_list_title);
    }

    public int bIi() {
        return this.fPO;
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
        if (this.fPM != null) {
            this.fPM.onDestroy();
        }
        MessageManager.getInstance().unRegisterListener(this.fPP);
    }

    public a EH(String str) {
        this.mUserId = str;
        return this;
    }

    public a EI(String str) {
        this.mUserName = str;
        return this;
    }

    public a EJ(String str) {
        this.mGroupId = str;
        return this;
    }

    public a EK(String str) {
        this.mLiveId = str;
        return this;
    }

    public a kT(boolean z) {
        this.bbH = z;
        return this;
    }

    public a EL(String str) {
        this.aAE = str;
        return this;
    }

    public a EM(String str) {
        this.fPH = str;
        return this;
    }

    public a EN(String str) {
        this.fPI = str;
        return this;
    }

    public a EO(String str) {
        this.fPJ = str;
        return this;
    }

    public a EP(String str) {
        this.fPK = str;
        return this;
    }

    public a EQ(String str) {
        this.mOtherParams = str;
        return this;
    }

    @Override // com.baidu.live.liveroom.d.d
    public void onChangeSkinType(int i) {
    }
}
