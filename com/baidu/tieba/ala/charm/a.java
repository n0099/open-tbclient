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
    private boolean aSw;
    private String aSx;
    private String fnL;
    private String fnM;
    private String fnN;
    private String fnO;
    private com.baidu.tieba.ala.charm.view.b fnP;
    private com.baidu.tieba.ala.charm.model.a fnQ;
    private ALaCharmCardActivity fnR;
    private int fnS;
    private String mGroupId;
    private boolean mHasMore;
    private String mLiveId;
    private String mOtherParams;
    private String mUserId;
    private String mUserName;
    private int pn = 0;
    CustomMessageListener fnT = new CustomMessageListener(2913095) { // from class: com.baidu.tieba.ala.charm.a.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof String)) {
                String str = (String) customResponsedMessage.getData();
                if (str == null) {
                    str = "";
                }
                if (a.this.fnP != null) {
                    a.this.fnP.setOtherParams(str);
                }
            }
        }
    };
    a.InterfaceC0532a fnU = new a.InterfaceC0532a() { // from class: com.baidu.tieba.ala.charm.a.2
        @Override // com.baidu.tieba.ala.charm.model.a.InterfaceC0532a
        public void a(ALaCharmDataList aLaCharmDataList) {
            if (aLaCharmDataList == null) {
                a.this.fnP.jF(true);
                return;
            }
            a.this.fnP.bqO();
            a.this.fnP.a(aLaCharmDataList.data, a.this.pn == 0, aLaCharmDataList.userTotalPrice);
            a.this.pn = aLaCharmDataList.pn + 1;
            a.this.mHasMore = aLaCharmDataList.hasMore;
            if (a.this.mHasMore) {
                a.this.fnP.brK();
            } else {
                a.this.fnP.Bx(a.this.fnR.getPageContext().getResources().getString(a.i.charm_no_more));
            }
            if (aLaCharmDataList.data == null || aLaCharmDataList.data.size() <= 0) {
                a.this.fnP.jF(true);
            }
        }

        @Override // com.baidu.tieba.ala.charm.model.a.InterfaceC0532a
        public void ax(int i, String str) {
            a.this.fnP.jF(false);
            a.this.fnP.k(new View.OnClickListener() { // from class: com.baidu.tieba.ala.charm.a.2.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (BdNetTypeUtil.isNetWorkAvailable()) {
                        if (a.this.fnQ != null) {
                            a.this.fnQ.K(a.this.fnS, a.this.pn, 100);
                            return;
                        }
                        return;
                    }
                    a.this.fnR.getPageContext().showToast(a.this.fnR.getResources().getString(a.i.sdk_no_network_guide));
                }
            });
        }
    };
    private BdListView.OnScrollToBottomListener fnV = new BdListView.OnScrollToBottomListener() { // from class: com.baidu.tieba.ala.charm.a.3
        @Override // com.baidu.live.adp.widget.listview.BdListView.OnScrollToBottomListener
        public void onScrollToBottom() {
            if (a.this.mHasMore && a.this.fnQ != null) {
                a.this.fnQ.K(a.this.fnS, a.this.pn, 100);
            }
        }
    };

    public a(ALaCharmCardActivity aLaCharmCardActivity, int i) {
        this.fnS = 1;
        this.fnR = aLaCharmCardActivity;
        this.fnS = i;
    }

    public void createView() {
        this.fnP = new com.baidu.tieba.ala.charm.view.b(this.fnR, this.mGroupId, this.mLiveId, this.aSw, this.aSx, this.fnS, this.mUserId, this.mUserName, this.fnM, this.fnN, this.fnO);
        this.fnP.a(this.fnV);
        this.fnP.setOtherParams(this.mOtherParams);
        loadData();
        MessageManager.getInstance().registerListener(this.fnT);
    }

    private void loadData() {
        if (this.fnQ == null) {
            this.fnQ = new com.baidu.tieba.ala.charm.model.a(this.fnR.getPageContext(), this.mUserId, this.fnU);
        }
        this.fnQ.bo(this.fnS, 100);
    }

    @Override // com.baidu.live.liveroom.d.d
    public View getPanelView() {
        if (this.fnP == null) {
            return null;
        }
        return this.fnP.getRootView();
    }

    public com.baidu.tieba.ala.charm.view.b bsX() {
        return this.fnP;
    }

    public void ap(String str, boolean z) {
        if (this.fnP != null) {
            this.fnP.ap(str, z);
        }
    }

    public void ya() {
        if (this.fnP != null) {
            this.fnP.ya();
        }
    }

    @Override // com.baidu.live.liveroom.d.d
    public String getTitle() {
        if (this.fnS == 2) {
            return this.fnR.getResources().getString(a.i.ala_charm_week_title);
        }
        if (this.fnS == 1) {
            return this.fnR.getResources().getString(a.i.ala_charm_all_title);
        }
        if (this.fnS == 3) {
            return this.fnR.getResources().getString(a.i.ala_charm_day_title);
        }
        if (this.fnS != 4) {
            return null;
        }
        return this.fnR.getResources().getString(a.i.audience_list_title);
    }

    public int bsY() {
        return this.fnS;
    }

    @Override // com.baidu.live.liveroom.d.d
    public String Ci() {
        return null;
    }

    @Override // com.baidu.live.liveroom.d.d
    public short Cj() {
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
        if (this.fnQ != null) {
            this.fnQ.onDestroy();
        }
        MessageManager.getInstance().unRegisterListener(this.fnT);
    }

    public a Bd(String str) {
        this.mUserId = str;
        return this;
    }

    public a Be(String str) {
        this.mUserName = str;
        return this;
    }

    public a Bf(String str) {
        this.mGroupId = str;
        return this;
    }

    public a Bg(String str) {
        this.mLiveId = str;
        return this;
    }

    public a jE(boolean z) {
        this.aSw = z;
        return this;
    }

    public a Bh(String str) {
        this.aSx = str;
        return this;
    }

    public a Bi(String str) {
        this.fnL = str;
        return this;
    }

    public a Bj(String str) {
        this.fnM = str;
        return this;
    }

    public a Bk(String str) {
        this.fnN = str;
        return this;
    }

    public a Bl(String str) {
        this.fnO = str;
        return this;
    }

    public a Bm(String str) {
        this.mOtherParams = str;
        return this;
    }

    @Override // com.baidu.live.liveroom.d.d
    public void onChangeSkinType(int i) {
    }
}
