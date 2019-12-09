package com.baidu.tieba.ala.charm;

import android.view.View;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.listener.CustomMessageListener;
import com.baidu.live.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.adp.lib.util.BdNetTypeUtil;
import com.baidu.live.adp.widget.listview.BdListView;
import com.baidu.live.k.a;
import com.baidu.tieba.ala.charm.data.ALaCharmDataList;
import com.baidu.tieba.ala.charm.model.a;
/* loaded from: classes6.dex */
public class a implements com.baidu.live.liveroom.c.d {
    private boolean agL;
    private String agM;
    private String dEr;
    private String dEs;
    private String dEt;
    private String dEu;
    private com.baidu.tieba.ala.charm.view.b dEv;
    private com.baidu.tieba.ala.charm.model.a dEw;
    private ALaCharmCardActivity dEx;
    private int dEy;
    private String mGroupId;
    private boolean mHasMore;
    private String mLiveId;
    private String mOtherParams;
    private String mUserId;
    private String mUserName;
    private int pn = 0;
    CustomMessageListener dEz = new CustomMessageListener(2913095) { // from class: com.baidu.tieba.ala.charm.a.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof String)) {
                String str = (String) customResponsedMessage.getData();
                if (str == null) {
                    str = "";
                }
                if (a.this.dEv != null) {
                    a.this.dEv.setOtherParams(str);
                }
            }
        }
    };
    a.InterfaceC0336a dEA = new a.InterfaceC0336a() { // from class: com.baidu.tieba.ala.charm.a.2
        @Override // com.baidu.tieba.ala.charm.model.a.InterfaceC0336a
        public void a(ALaCharmDataList aLaCharmDataList) {
            if (aLaCharmDataList == null) {
                a.this.dEv.gN(true);
                return;
            }
            a.this.dEv.aJm();
            a.this.dEv.a(aLaCharmDataList.data, a.this.pn == 0, aLaCharmDataList.userTotalPrice);
            a.this.pn = aLaCharmDataList.pn + 1;
            a.this.mHasMore = aLaCharmDataList.hasMore;
            if (a.this.mHasMore) {
                a.this.dEv.aKg();
            } else {
                a.this.dEv.sO(a.this.dEx.getPageContext().getResources().getString(a.i.charm_no_more));
            }
            if (aLaCharmDataList.data == null || aLaCharmDataList.data.size() <= 0) {
                a.this.dEv.gN(true);
            }
        }

        @Override // com.baidu.tieba.ala.charm.model.a.InterfaceC0336a
        public void R(int i, String str) {
            a.this.dEv.gN(false);
            a.this.dEv.l(new View.OnClickListener() { // from class: com.baidu.tieba.ala.charm.a.2.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (BdNetTypeUtil.isNetWorkAvailable()) {
                        if (a.this.dEw != null) {
                            a.this.dEw.D(a.this.dEy, a.this.pn, 100);
                            return;
                        }
                        return;
                    }
                    a.this.dEx.getPageContext().showToast(a.this.dEx.getResources().getString(a.i.sdk_no_network_guide));
                }
            });
        }
    };
    private BdListView.OnScrollToBottomListener dEB = new BdListView.OnScrollToBottomListener() { // from class: com.baidu.tieba.ala.charm.a.3
        @Override // com.baidu.live.adp.widget.listview.BdListView.OnScrollToBottomListener
        public void onScrollToBottom() {
            if (a.this.mHasMore && a.this.dEw != null) {
                a.this.dEw.D(a.this.dEy, a.this.pn, 100);
            }
        }
    };

    public a(ALaCharmCardActivity aLaCharmCardActivity, int i) {
        this.dEy = 1;
        this.dEx = aLaCharmCardActivity;
        this.dEy = i;
    }

    public void nw() {
        this.dEv = new com.baidu.tieba.ala.charm.view.b(this.dEx, this.mGroupId, this.mLiveId, this.agL, this.agM, this.dEy, this.mUserId, this.mUserName, this.dEs, this.dEt, this.dEu);
        this.dEv.a(this.dEB);
        this.dEv.setOtherParams(this.mOtherParams);
        loadData();
        MessageManager.getInstance().registerListener(this.dEz);
    }

    private void loadData() {
        if (this.dEw == null) {
            this.dEw = new com.baidu.tieba.ala.charm.model.a(this.dEx.getPageContext(), this.mUserId, this.dEA);
        }
        this.dEw.aL(this.dEy, 100);
    }

    @Override // com.baidu.live.liveroom.c.d
    public View ss() {
        if (this.dEv == null) {
            return null;
        }
        return this.dEv.getRootView();
    }

    public com.baidu.tieba.ala.charm.view.b aKt() {
        return this.dEv;
    }

    public void T(String str, boolean z) {
        if (this.dEv != null) {
            this.dEv.T(str, z);
        }
    }

    public void pC() {
        if (this.dEv != null) {
            this.dEv.pC();
        }
    }

    @Override // com.baidu.live.liveroom.c.d
    public String getTitle() {
        if (this.dEy == 2) {
            return this.dEx.getResources().getString(a.i.ala_charm_week_title);
        }
        if (this.dEy == 1) {
            return this.dEx.getResources().getString(a.i.ala_charm_all_title);
        }
        if (this.dEy == 3) {
            return this.dEx.getResources().getString(a.i.ala_charm_day_title);
        }
        if (this.dEy != 4) {
            return null;
        }
        return this.dEx.getResources().getString(a.i.audience_list_title);
    }

    public int aKu() {
        return this.dEy;
    }

    @Override // com.baidu.live.liveroom.c.d
    public String st() {
        return null;
    }

    @Override // com.baidu.live.liveroom.c.d
    public short su() {
        return (short) 0;
    }

    @Override // com.baidu.live.liveroom.c.d
    public void enterBackground() {
    }

    @Override // com.baidu.live.liveroom.c.d
    public void enterForeground() {
    }

    @Override // com.baidu.live.liveroom.c.d
    public void onDestroy() {
        if (this.dEw != null) {
            this.dEw.onDestroy();
        }
        MessageManager.getInstance().unRegisterListener(this.dEz);
    }

    public a sE(String str) {
        this.mUserId = str;
        return this;
    }

    public a sF(String str) {
        this.mUserName = str;
        return this;
    }

    public a sG(String str) {
        this.mGroupId = str;
        return this;
    }

    public a sH(String str) {
        this.mLiveId = str;
        return this;
    }

    public a gM(boolean z) {
        this.agL = z;
        return this;
    }

    public a sI(String str) {
        this.agM = str;
        return this;
    }

    public a sJ(String str) {
        this.dEr = str;
        return this;
    }

    public a sK(String str) {
        this.dEs = str;
        return this;
    }

    public a sL(String str) {
        this.dEt = str;
        return this;
    }

    public a sM(String str) {
        this.dEu = str;
        return this;
    }

    public a sN(String str) {
        this.mOtherParams = str;
        return this;
    }

    @Override // com.baidu.live.liveroom.c.d
    public void onChangeSkinType(int i) {
    }
}
