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
/* loaded from: classes11.dex */
public class a implements com.baidu.live.liveroom.d.d {
    private String aGB;
    private boolean boZ;
    private String gPk;
    private String gPl;
    private String gPm;
    private String gPn;
    private com.baidu.tieba.ala.charm.view.b gPo;
    private com.baidu.tieba.ala.charm.model.a gPp;
    private ALaCharmCardActivity gPq;
    private int gPr;
    private String mGroupId;
    private boolean mHasMore;
    private String mLiveId;
    private String mOtherParams;
    private String mUserId;
    private String mUserName;
    private int pn = 0;
    CustomMessageListener gPs = new CustomMessageListener(2913095) { // from class: com.baidu.tieba.ala.charm.a.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof String)) {
                String str = (String) customResponsedMessage.getData();
                if (str == null) {
                    str = "";
                }
                if (a.this.gPo != null) {
                    a.this.gPo.setOtherParams(str);
                }
            }
        }
    };
    a.InterfaceC0641a gPt = new a.InterfaceC0641a() { // from class: com.baidu.tieba.ala.charm.a.2
        @Override // com.baidu.tieba.ala.charm.model.a.InterfaceC0641a
        public void a(ALaCharmDataList aLaCharmDataList) {
            if (aLaCharmDataList == null) {
                a.this.gPo.dM(true);
                return;
            }
            a.this.gPo.Zi();
            a.this.gPo.a(aLaCharmDataList.data, a.this.pn == 0, aLaCharmDataList.userTotalPrice);
            a.this.pn = aLaCharmDataList.pn + 1;
            a.this.mHasMore = aLaCharmDataList.hasMore;
            if (a.this.mHasMore) {
                a.this.gPo.Zg();
            } else {
                a.this.gPo.Hm(a.this.gPq.getPageContext().getResources().getString(a.h.charm_no_more));
            }
            if (aLaCharmDataList.data == null || aLaCharmDataList.data.size() <= 0) {
                a.this.gPo.dM(true);
            }
        }

        @Override // com.baidu.tieba.ala.charm.model.a.InterfaceC0641a
        public void v(int i, String str) {
            a.this.gPo.dM(false);
            a.this.gPo.n(new View.OnClickListener() { // from class: com.baidu.tieba.ala.charm.a.2.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (BdNetTypeUtil.isNetWorkAvailable()) {
                        if (a.this.gPp != null) {
                            a.this.gPp.O(a.this.gPr, a.this.pn, 100);
                            return;
                        }
                        return;
                    }
                    a.this.gPq.getPageContext().showToast(a.this.gPq.getResources().getString(a.h.sdk_no_network_guide));
                }
            });
        }
    };
    private BdListView.OnScrollToBottomListener gPu = new BdListView.OnScrollToBottomListener() { // from class: com.baidu.tieba.ala.charm.a.3
        @Override // com.baidu.live.adp.widget.listview.BdListView.OnScrollToBottomListener
        public void onScrollToBottom() {
            if (a.this.mHasMore && a.this.gPp != null) {
                a.this.gPp.O(a.this.gPr, a.this.pn, 100);
            }
        }
    };

    public a(ALaCharmCardActivity aLaCharmCardActivity, int i) {
        this.gPr = 1;
        this.gPq = aLaCharmCardActivity;
        this.gPr = i;
    }

    public void createView() {
        this.gPo = new com.baidu.tieba.ala.charm.view.b(this.gPq, this.mGroupId, this.mLiveId, this.boZ, this.aGB, this.gPr, this.mUserId, this.mUserName, this.gPl, this.gPm, this.gPn);
        this.gPo.a(this.gPu);
        this.gPo.setOtherParams(this.mOtherParams);
        loadData();
        MessageManager.getInstance().registerListener(this.gPs);
    }

    private void loadData() {
        if (this.gPp == null) {
            this.gPp = new com.baidu.tieba.ala.charm.model.a(this.gPq.getPageContext(), this.mUserId, this.gPt);
        }
        this.gPp.bG(this.gPr, 100);
    }

    @Override // com.baidu.live.liveroom.d.d
    public View getPanelView() {
        if (this.gPo == null) {
            return null;
        }
        return this.gPo.getRootView();
    }

    public com.baidu.tieba.ala.charm.view.b bWL() {
        return this.gPo;
    }

    public void aB(String str, boolean z) {
        if (this.gPo != null) {
            this.gPo.aB(str, z);
        }
    }

    public void Hp() {
        if (this.gPo != null) {
            this.gPo.Hp();
        }
    }

    @Override // com.baidu.live.liveroom.d.d
    public String getTitle() {
        if (this.gPr == 2) {
            return this.gPq.getResources().getString(a.h.ala_charm_week_title);
        }
        if (this.gPr == 1) {
            return this.gPq.getResources().getString(a.h.ala_charm_all_title);
        }
        if (this.gPr == 3) {
            return this.gPq.getResources().getString(a.h.ala_charm_day_title);
        }
        if (this.gPr != 4) {
            return null;
        }
        return this.gPq.getResources().getString(a.h.audience_list_title);
    }

    public int bWM() {
        return this.gPr;
    }

    @Override // com.baidu.live.liveroom.d.d
    public String Mh() {
        return null;
    }

    @Override // com.baidu.live.liveroom.d.d
    public short Mi() {
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
        if (this.gPp != null) {
            this.gPp.onDestroy();
        }
        MessageManager.getInstance().unRegisterListener(this.gPs);
    }

    public a GR(String str) {
        this.mUserId = str;
        return this;
    }

    public a GS(String str) {
        this.mUserName = str;
        return this;
    }

    public a GT(String str) {
        this.mGroupId = str;
        return this;
    }

    public a GU(String str) {
        this.mLiveId = str;
        return this;
    }

    public a mS(boolean z) {
        this.boZ = z;
        return this;
    }

    public a GV(String str) {
        this.aGB = str;
        return this;
    }

    public a GW(String str) {
        this.gPk = str;
        return this;
    }

    public a GX(String str) {
        this.gPl = str;
        return this;
    }

    public a GY(String str) {
        this.gPm = str;
        return this;
    }

    public a GZ(String str) {
        this.gPn = str;
        return this;
    }

    public a Ha(String str) {
        this.mOtherParams = str;
        return this;
    }

    @Override // com.baidu.live.liveroom.d.d
    public void onChangeSkinType(int i) {
    }
}
