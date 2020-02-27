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
    private boolean asR;
    private String asS;
    private String evC;
    private String evD;
    private String evE;
    private String evF;
    private com.baidu.tieba.ala.charm.view.b evG;
    private com.baidu.tieba.ala.charm.model.a evH;
    private ALaCharmCardActivity evI;
    private int evJ;
    private String mGroupId;
    private boolean mHasMore;
    private String mLiveId;
    private String mOtherParams;
    private String mUserId;
    private String mUserName;
    private int pn = 0;
    CustomMessageListener evK = new CustomMessageListener(2913095) { // from class: com.baidu.tieba.ala.charm.a.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof String)) {
                String str = (String) customResponsedMessage.getData();
                if (str == null) {
                    str = "";
                }
                if (a.this.evG != null) {
                    a.this.evG.setOtherParams(str);
                }
            }
        }
    };
    a.InterfaceC0428a evL = new a.InterfaceC0428a() { // from class: com.baidu.tieba.ala.charm.a.2
        @Override // com.baidu.tieba.ala.charm.model.a.InterfaceC0428a
        public void a(ALaCharmDataList aLaCharmDataList) {
            if (aLaCharmDataList == null) {
                a.this.evG.ij(true);
                return;
            }
            a.this.evG.bcv();
            a.this.evG.a(aLaCharmDataList.data, a.this.pn == 0, aLaCharmDataList.userTotalPrice);
            a.this.pn = aLaCharmDataList.pn + 1;
            a.this.mHasMore = aLaCharmDataList.hasMore;
            if (a.this.mHasMore) {
                a.this.evG.bdp();
            } else {
                a.this.evG.xV(a.this.evI.getPageContext().getResources().getString(a.i.charm_no_more));
            }
            if (aLaCharmDataList.data == null || aLaCharmDataList.data.size() <= 0) {
                a.this.evG.ij(true);
            }
        }

        @Override // com.baidu.tieba.ala.charm.model.a.InterfaceC0428a
        public void ad(int i, String str) {
            a.this.evG.ij(false);
            a.this.evG.l(new View.OnClickListener() { // from class: com.baidu.tieba.ala.charm.a.2.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (BdNetTypeUtil.isNetWorkAvailable()) {
                        if (a.this.evH != null) {
                            a.this.evH.I(a.this.evJ, a.this.pn, 100);
                            return;
                        }
                        return;
                    }
                    a.this.evI.getPageContext().showToast(a.this.evI.getResources().getString(a.i.sdk_no_network_guide));
                }
            });
        }
    };
    private BdListView.OnScrollToBottomListener evM = new BdListView.OnScrollToBottomListener() { // from class: com.baidu.tieba.ala.charm.a.3
        @Override // com.baidu.live.adp.widget.listview.BdListView.OnScrollToBottomListener
        public void onScrollToBottom() {
            if (a.this.mHasMore && a.this.evH != null) {
                a.this.evH.I(a.this.evJ, a.this.pn, 100);
            }
        }
    };

    public a(ALaCharmCardActivity aLaCharmCardActivity, int i) {
        this.evJ = 1;
        this.evI = aLaCharmCardActivity;
        this.evJ = i;
    }

    public void createView() {
        this.evG = new com.baidu.tieba.ala.charm.view.b(this.evI, this.mGroupId, this.mLiveId, this.asR, this.asS, this.evJ, this.mUserId, this.mUserName, this.evD, this.evE, this.evF);
        this.evG.a(this.evM);
        this.evG.setOtherParams(this.mOtherParams);
        loadData();
        MessageManager.getInstance().registerListener(this.evK);
    }

    private void loadData() {
        if (this.evH == null) {
            this.evH = new com.baidu.tieba.ala.charm.model.a(this.evI.getPageContext(), this.mUserId, this.evL);
        }
        this.evH.bf(this.evJ, 100);
    }

    @Override // com.baidu.live.liveroom.d.d
    public View we() {
        if (this.evG == null) {
            return null;
        }
        return this.evG.getRootView();
    }

    public com.baidu.tieba.ala.charm.view.b bdO() {
        return this.evG;
    }

    public void X(String str, boolean z) {
        if (this.evG != null) {
            this.evG.X(str, z);
        }
    }

    public void sm() {
        if (this.evG != null) {
            this.evG.sm();
        }
    }

    @Override // com.baidu.live.liveroom.d.d
    public String getTitle() {
        if (this.evJ == 2) {
            return this.evI.getResources().getString(a.i.ala_charm_week_title);
        }
        if (this.evJ == 1) {
            return this.evI.getResources().getString(a.i.ala_charm_all_title);
        }
        if (this.evJ == 3) {
            return this.evI.getResources().getString(a.i.ala_charm_day_title);
        }
        if (this.evJ != 4) {
            return null;
        }
        return this.evI.getResources().getString(a.i.audience_list_title);
    }

    public int bdP() {
        return this.evJ;
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
        if (this.evH != null) {
            this.evH.onDestroy();
        }
        MessageManager.getInstance().unRegisterListener(this.evK);
    }

    public a xL(String str) {
        this.mUserId = str;
        return this;
    }

    public a xM(String str) {
        this.mUserName = str;
        return this;
    }

    public a xN(String str) {
        this.mGroupId = str;
        return this;
    }

    public a xO(String str) {
        this.mLiveId = str;
        return this;
    }

    public a ii(boolean z) {
        this.asR = z;
        return this;
    }

    public a xP(String str) {
        this.asS = str;
        return this;
    }

    public a xQ(String str) {
        this.evC = str;
        return this;
    }

    public a xR(String str) {
        this.evD = str;
        return this;
    }

    public a xS(String str) {
        this.evE = str;
        return this;
    }

    public a xT(String str) {
        this.evF = str;
        return this;
    }

    public a xU(String str) {
        this.mOtherParams = str;
        return this;
    }

    @Override // com.baidu.live.liveroom.d.d
    public void onChangeSkinType(int i) {
    }
}
