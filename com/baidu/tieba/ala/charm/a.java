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
    private boolean ahd;
    private String ahe;
    private String dFi;
    private String dFj;
    private String dFk;
    private String dFl;
    private com.baidu.tieba.ala.charm.view.b dFm;
    private com.baidu.tieba.ala.charm.model.a dFn;
    private ALaCharmCardActivity dFo;
    private int dFp;
    private String mGroupId;
    private boolean mHasMore;
    private String mLiveId;
    private String mOtherParams;
    private String mUserId;
    private String mUserName;
    private int pn = 0;
    CustomMessageListener dFq = new CustomMessageListener(2913095) { // from class: com.baidu.tieba.ala.charm.a.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof String)) {
                String str = (String) customResponsedMessage.getData();
                if (str == null) {
                    str = "";
                }
                if (a.this.dFm != null) {
                    a.this.dFm.setOtherParams(str);
                }
            }
        }
    };
    a.InterfaceC0341a dFr = new a.InterfaceC0341a() { // from class: com.baidu.tieba.ala.charm.a.2
        @Override // com.baidu.tieba.ala.charm.model.a.InterfaceC0341a
        public void a(ALaCharmDataList aLaCharmDataList) {
            if (aLaCharmDataList == null) {
                a.this.dFm.gN(true);
                return;
            }
            a.this.dFm.aJo();
            a.this.dFm.a(aLaCharmDataList.data, a.this.pn == 0, aLaCharmDataList.userTotalPrice);
            a.this.pn = aLaCharmDataList.pn + 1;
            a.this.mHasMore = aLaCharmDataList.hasMore;
            if (a.this.mHasMore) {
                a.this.dFm.aKi();
            } else {
                a.this.dFm.sO(a.this.dFo.getPageContext().getResources().getString(a.i.charm_no_more));
            }
            if (aLaCharmDataList.data == null || aLaCharmDataList.data.size() <= 0) {
                a.this.dFm.gN(true);
            }
        }

        @Override // com.baidu.tieba.ala.charm.model.a.InterfaceC0341a
        public void S(int i, String str) {
            a.this.dFm.gN(false);
            a.this.dFm.l(new View.OnClickListener() { // from class: com.baidu.tieba.ala.charm.a.2.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (BdNetTypeUtil.isNetWorkAvailable()) {
                        if (a.this.dFn != null) {
                            a.this.dFn.D(a.this.dFp, a.this.pn, 100);
                            return;
                        }
                        return;
                    }
                    a.this.dFo.getPageContext().showToast(a.this.dFo.getResources().getString(a.i.sdk_no_network_guide));
                }
            });
        }
    };
    private BdListView.OnScrollToBottomListener dFs = new BdListView.OnScrollToBottomListener() { // from class: com.baidu.tieba.ala.charm.a.3
        @Override // com.baidu.live.adp.widget.listview.BdListView.OnScrollToBottomListener
        public void onScrollToBottom() {
            if (a.this.mHasMore && a.this.dFn != null) {
                a.this.dFn.D(a.this.dFp, a.this.pn, 100);
            }
        }
    };

    public a(ALaCharmCardActivity aLaCharmCardActivity, int i) {
        this.dFp = 1;
        this.dFo = aLaCharmCardActivity;
        this.dFp = i;
    }

    public void nw() {
        this.dFm = new com.baidu.tieba.ala.charm.view.b(this.dFo, this.mGroupId, this.mLiveId, this.ahd, this.ahe, this.dFp, this.mUserId, this.mUserName, this.dFj, this.dFk, this.dFl);
        this.dFm.a(this.dFs);
        this.dFm.setOtherParams(this.mOtherParams);
        loadData();
        MessageManager.getInstance().registerListener(this.dFq);
    }

    private void loadData() {
        if (this.dFn == null) {
            this.dFn = new com.baidu.tieba.ala.charm.model.a(this.dFo.getPageContext(), this.mUserId, this.dFr);
        }
        this.dFn.aN(this.dFp, 100);
    }

    @Override // com.baidu.live.liveroom.c.d
    public View sr() {
        if (this.dFm == null) {
            return null;
        }
        return this.dFm.getRootView();
    }

    public com.baidu.tieba.ala.charm.view.b aKv() {
        return this.dFm;
    }

    public void T(String str, boolean z) {
        if (this.dFm != null) {
            this.dFm.T(str, z);
        }
    }

    public void pC() {
        if (this.dFm != null) {
            this.dFm.pC();
        }
    }

    @Override // com.baidu.live.liveroom.c.d
    public String getTitle() {
        if (this.dFp == 2) {
            return this.dFo.getResources().getString(a.i.ala_charm_week_title);
        }
        if (this.dFp == 1) {
            return this.dFo.getResources().getString(a.i.ala_charm_all_title);
        }
        if (this.dFp == 3) {
            return this.dFo.getResources().getString(a.i.ala_charm_day_title);
        }
        if (this.dFp != 4) {
            return null;
        }
        return this.dFo.getResources().getString(a.i.audience_list_title);
    }

    public int aKw() {
        return this.dFp;
    }

    @Override // com.baidu.live.liveroom.c.d
    public String ss() {
        return null;
    }

    @Override // com.baidu.live.liveroom.c.d
    public short st() {
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
        if (this.dFn != null) {
            this.dFn.onDestroy();
        }
        MessageManager.getInstance().unRegisterListener(this.dFq);
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
        this.ahd = z;
        return this;
    }

    public a sI(String str) {
        this.ahe = str;
        return this;
    }

    public a sJ(String str) {
        this.dFi = str;
        return this;
    }

    public a sK(String str) {
        this.dFj = str;
        return this;
    }

    public a sL(String str) {
        this.dFk = str;
        return this;
    }

    public a sM(String str) {
        this.dFl = str;
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
