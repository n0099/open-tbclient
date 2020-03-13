package com.baidu.tieba.ala.charm;

import android.view.View;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.listener.CustomMessageListener;
import com.baidu.live.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.adp.lib.util.BdNetTypeUtil;
import com.baidu.live.adp.widget.listview.BdListView;
import com.baidu.live.u.a;
import com.baidu.tieba.ala.charm.data.ALaCharmDataList;
import com.baidu.tieba.ala.charm.model.a;
/* loaded from: classes3.dex */
public class a implements com.baidu.live.liveroom.d.d {
    private boolean asS;
    private String asT;
    private String evQ;
    private String evR;
    private String evS;
    private String evT;
    private com.baidu.tieba.ala.charm.view.b evU;
    private com.baidu.tieba.ala.charm.model.a evV;
    private ALaCharmCardActivity evW;
    private int evX;
    private String mGroupId;
    private boolean mHasMore;
    private String mLiveId;
    private String mOtherParams;
    private String mUserId;
    private String mUserName;
    private int pn = 0;
    CustomMessageListener evY = new CustomMessageListener(2913095) { // from class: com.baidu.tieba.ala.charm.a.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof String)) {
                String str = (String) customResponsedMessage.getData();
                if (str == null) {
                    str = "";
                }
                if (a.this.evU != null) {
                    a.this.evU.setOtherParams(str);
                }
            }
        }
    };
    a.InterfaceC0428a evZ = new a.InterfaceC0428a() { // from class: com.baidu.tieba.ala.charm.a.2
        @Override // com.baidu.tieba.ala.charm.model.a.InterfaceC0428a
        public void a(ALaCharmDataList aLaCharmDataList) {
            if (aLaCharmDataList == null) {
                a.this.evU.ij(true);
                return;
            }
            a.this.evU.bcy();
            a.this.evU.a(aLaCharmDataList.data, a.this.pn == 0, aLaCharmDataList.userTotalPrice);
            a.this.pn = aLaCharmDataList.pn + 1;
            a.this.mHasMore = aLaCharmDataList.hasMore;
            if (a.this.mHasMore) {
                a.this.evU.bds();
            } else {
                a.this.evU.xW(a.this.evW.getPageContext().getResources().getString(a.i.charm_no_more));
            }
            if (aLaCharmDataList.data == null || aLaCharmDataList.data.size() <= 0) {
                a.this.evU.ij(true);
            }
        }

        @Override // com.baidu.tieba.ala.charm.model.a.InterfaceC0428a
        public void ad(int i, String str) {
            a.this.evU.ij(false);
            a.this.evU.l(new View.OnClickListener() { // from class: com.baidu.tieba.ala.charm.a.2.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (BdNetTypeUtil.isNetWorkAvailable()) {
                        if (a.this.evV != null) {
                            a.this.evV.I(a.this.evX, a.this.pn, 100);
                            return;
                        }
                        return;
                    }
                    a.this.evW.getPageContext().showToast(a.this.evW.getResources().getString(a.i.sdk_no_network_guide));
                }
            });
        }
    };
    private BdListView.OnScrollToBottomListener ewa = new BdListView.OnScrollToBottomListener() { // from class: com.baidu.tieba.ala.charm.a.3
        @Override // com.baidu.live.adp.widget.listview.BdListView.OnScrollToBottomListener
        public void onScrollToBottom() {
            if (a.this.mHasMore && a.this.evV != null) {
                a.this.evV.I(a.this.evX, a.this.pn, 100);
            }
        }
    };

    public a(ALaCharmCardActivity aLaCharmCardActivity, int i) {
        this.evX = 1;
        this.evW = aLaCharmCardActivity;
        this.evX = i;
    }

    public void createView() {
        this.evU = new com.baidu.tieba.ala.charm.view.b(this.evW, this.mGroupId, this.mLiveId, this.asS, this.asT, this.evX, this.mUserId, this.mUserName, this.evR, this.evS, this.evT);
        this.evU.a(this.ewa);
        this.evU.setOtherParams(this.mOtherParams);
        loadData();
        MessageManager.getInstance().registerListener(this.evY);
    }

    private void loadData() {
        if (this.evV == null) {
            this.evV = new com.baidu.tieba.ala.charm.model.a(this.evW.getPageContext(), this.mUserId, this.evZ);
        }
        this.evV.bf(this.evX, 100);
    }

    @Override // com.baidu.live.liveroom.d.d
    public View we() {
        if (this.evU == null) {
            return null;
        }
        return this.evU.getRootView();
    }

    public com.baidu.tieba.ala.charm.view.b bdR() {
        return this.evU;
    }

    public void X(String str, boolean z) {
        if (this.evU != null) {
            this.evU.X(str, z);
        }
    }

    public void sm() {
        if (this.evU != null) {
            this.evU.sm();
        }
    }

    @Override // com.baidu.live.liveroom.d.d
    public String getTitle() {
        if (this.evX == 2) {
            return this.evW.getResources().getString(a.i.ala_charm_week_title);
        }
        if (this.evX == 1) {
            return this.evW.getResources().getString(a.i.ala_charm_all_title);
        }
        if (this.evX == 3) {
            return this.evW.getResources().getString(a.i.ala_charm_day_title);
        }
        if (this.evX != 4) {
            return null;
        }
        return this.evW.getResources().getString(a.i.audience_list_title);
    }

    public int bdS() {
        return this.evX;
    }

    @Override // com.baidu.live.liveroom.d.d
    public String wf() {
        return null;
    }

    @Override // com.baidu.live.liveroom.d.d
    public short wg() {
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
        if (this.evV != null) {
            this.evV.onDestroy();
        }
        MessageManager.getInstance().unRegisterListener(this.evY);
    }

    public a xM(String str) {
        this.mUserId = str;
        return this;
    }

    public a xN(String str) {
        this.mUserName = str;
        return this;
    }

    public a xO(String str) {
        this.mGroupId = str;
        return this;
    }

    public a xP(String str) {
        this.mLiveId = str;
        return this;
    }

    public a ii(boolean z) {
        this.asS = z;
        return this;
    }

    public a xQ(String str) {
        this.asT = str;
        return this;
    }

    public a xR(String str) {
        this.evQ = str;
        return this;
    }

    public a xS(String str) {
        this.evR = str;
        return this;
    }

    public a xT(String str) {
        this.evS = str;
        return this;
    }

    public a xU(String str) {
        this.evT = str;
        return this;
    }

    public a xV(String str) {
        this.mOtherParams = str;
        return this;
    }

    @Override // com.baidu.live.liveroom.d.d
    public void onChangeSkinType(int i) {
    }
}
