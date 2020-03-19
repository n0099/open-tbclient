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
    private boolean atc;
    private String atd;
    private String ewm;
    private String ewn;
    private String ewo;
    private String ewp;
    private com.baidu.tieba.ala.charm.view.b ewq;
    private com.baidu.tieba.ala.charm.model.a ewr;
    private ALaCharmCardActivity ews;
    private int ewt;
    private String mGroupId;
    private boolean mHasMore;
    private String mLiveId;
    private String mOtherParams;
    private String mUserId;
    private String mUserName;
    private int pn = 0;
    CustomMessageListener ewu = new CustomMessageListener(2913095) { // from class: com.baidu.tieba.ala.charm.a.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof String)) {
                String str = (String) customResponsedMessage.getData();
                if (str == null) {
                    str = "";
                }
                if (a.this.ewq != null) {
                    a.this.ewq.setOtherParams(str);
                }
            }
        }
    };
    a.InterfaceC0428a ewv = new a.InterfaceC0428a() { // from class: com.baidu.tieba.ala.charm.a.2
        @Override // com.baidu.tieba.ala.charm.model.a.InterfaceC0428a
        public void a(ALaCharmDataList aLaCharmDataList) {
            if (aLaCharmDataList == null) {
                a.this.ewq.il(true);
                return;
            }
            a.this.ewq.bcC();
            a.this.ewq.a(aLaCharmDataList.data, a.this.pn == 0, aLaCharmDataList.userTotalPrice);
            a.this.pn = aLaCharmDataList.pn + 1;
            a.this.mHasMore = aLaCharmDataList.hasMore;
            if (a.this.mHasMore) {
                a.this.ewq.bdx();
            } else {
                a.this.ewq.xX(a.this.ews.getPageContext().getResources().getString(a.i.charm_no_more));
            }
            if (aLaCharmDataList.data == null || aLaCharmDataList.data.size() <= 0) {
                a.this.ewq.il(true);
            }
        }

        @Override // com.baidu.tieba.ala.charm.model.a.InterfaceC0428a
        public void ad(int i, String str) {
            a.this.ewq.il(false);
            a.this.ewq.l(new View.OnClickListener() { // from class: com.baidu.tieba.ala.charm.a.2.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (BdNetTypeUtil.isNetWorkAvailable()) {
                        if (a.this.ewr != null) {
                            a.this.ewr.I(a.this.ewt, a.this.pn, 100);
                            return;
                        }
                        return;
                    }
                    a.this.ews.getPageContext().showToast(a.this.ews.getResources().getString(a.i.sdk_no_network_guide));
                }
            });
        }
    };
    private BdListView.OnScrollToBottomListener eww = new BdListView.OnScrollToBottomListener() { // from class: com.baidu.tieba.ala.charm.a.3
        @Override // com.baidu.live.adp.widget.listview.BdListView.OnScrollToBottomListener
        public void onScrollToBottom() {
            if (a.this.mHasMore && a.this.ewr != null) {
                a.this.ewr.I(a.this.ewt, a.this.pn, 100);
            }
        }
    };

    public a(ALaCharmCardActivity aLaCharmCardActivity, int i) {
        this.ewt = 1;
        this.ews = aLaCharmCardActivity;
        this.ewt = i;
    }

    public void createView() {
        this.ewq = new com.baidu.tieba.ala.charm.view.b(this.ews, this.mGroupId, this.mLiveId, this.atc, this.atd, this.ewt, this.mUserId, this.mUserName, this.ewn, this.ewo, this.ewp);
        this.ewq.a(this.eww);
        this.ewq.setOtherParams(this.mOtherParams);
        loadData();
        MessageManager.getInstance().registerListener(this.ewu);
    }

    private void loadData() {
        if (this.ewr == null) {
            this.ewr = new com.baidu.tieba.ala.charm.model.a(this.ews.getPageContext(), this.mUserId, this.ewv);
        }
        this.ewr.bg(this.ewt, 100);
    }

    @Override // com.baidu.live.liveroom.d.d
    public View wj() {
        if (this.ewq == null) {
            return null;
        }
        return this.ewq.getRootView();
    }

    public com.baidu.tieba.ala.charm.view.b bdW() {
        return this.ewq;
    }

    public void X(String str, boolean z) {
        if (this.ewq != null) {
            this.ewq.X(str, z);
        }
    }

    public void sr() {
        if (this.ewq != null) {
            this.ewq.sr();
        }
    }

    @Override // com.baidu.live.liveroom.d.d
    public String getTitle() {
        if (this.ewt == 2) {
            return this.ews.getResources().getString(a.i.ala_charm_week_title);
        }
        if (this.ewt == 1) {
            return this.ews.getResources().getString(a.i.ala_charm_all_title);
        }
        if (this.ewt == 3) {
            return this.ews.getResources().getString(a.i.ala_charm_day_title);
        }
        if (this.ewt != 4) {
            return null;
        }
        return this.ews.getResources().getString(a.i.audience_list_title);
    }

    public int bdX() {
        return this.ewt;
    }

    @Override // com.baidu.live.liveroom.d.d
    public String wk() {
        return null;
    }

    @Override // com.baidu.live.liveroom.d.d
    public short wl() {
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
        if (this.ewr != null) {
            this.ewr.onDestroy();
        }
        MessageManager.getInstance().unRegisterListener(this.ewu);
    }

    public a xN(String str) {
        this.mUserId = str;
        return this;
    }

    public a xO(String str) {
        this.mUserName = str;
        return this;
    }

    public a xP(String str) {
        this.mGroupId = str;
        return this;
    }

    public a xQ(String str) {
        this.mLiveId = str;
        return this;
    }

    public a ik(boolean z) {
        this.atc = z;
        return this;
    }

    public a xR(String str) {
        this.atd = str;
        return this;
    }

    public a xS(String str) {
        this.ewm = str;
        return this;
    }

    public a xT(String str) {
        this.ewn = str;
        return this;
    }

    public a xU(String str) {
        this.ewo = str;
        return this;
    }

    public a xV(String str) {
        this.ewp = str;
        return this;
    }

    public a xW(String str) {
        this.mOtherParams = str;
        return this;
    }

    @Override // com.baidu.live.liveroom.d.d
    public void onChangeSkinType(int i) {
    }
}
