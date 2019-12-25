package com.baidu.tieba.ala.charm;

import android.view.View;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.listener.CustomMessageListener;
import com.baidu.live.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.adp.lib.util.BdNetTypeUtil;
import com.baidu.live.adp.widget.listview.BdListView;
import com.baidu.live.q.a;
import com.baidu.tieba.ala.charm.data.ALaCharmDataList;
import com.baidu.tieba.ala.charm.model.a;
/* loaded from: classes2.dex */
public class a implements com.baidu.live.liveroom.c.d {
    private boolean aoM;
    private String aoN;
    private String eqf;
    private String eqg;
    private String eqh;
    private String eqi;
    private com.baidu.tieba.ala.charm.view.b eqj;
    private com.baidu.tieba.ala.charm.model.a eqk;
    private ALaCharmCardActivity eql;
    private int eqm;
    private String mGroupId;
    private boolean mHasMore;
    private String mLiveId;
    private String mOtherParams;
    private String mUserId;
    private String mUserName;
    private int pn = 0;
    CustomMessageListener eqn = new CustomMessageListener(2913095) { // from class: com.baidu.tieba.ala.charm.a.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof String)) {
                String str = (String) customResponsedMessage.getData();
                if (str == null) {
                    str = "";
                }
                if (a.this.eqj != null) {
                    a.this.eqj.setOtherParams(str);
                }
            }
        }
    };
    a.InterfaceC0414a eqo = new a.InterfaceC0414a() { // from class: com.baidu.tieba.ala.charm.a.2
        @Override // com.baidu.tieba.ala.charm.model.a.InterfaceC0414a
        public void a(ALaCharmDataList aLaCharmDataList) {
            if (aLaCharmDataList == null) {
                a.this.eqj.hS(true);
                return;
            }
            a.this.eqj.aZK();
            a.this.eqj.a(aLaCharmDataList.data, a.this.pn == 0, aLaCharmDataList.userTotalPrice);
            a.this.pn = aLaCharmDataList.pn + 1;
            a.this.mHasMore = aLaCharmDataList.hasMore;
            if (a.this.mHasMore) {
                a.this.eqj.baF();
            } else {
                a.this.eqj.xw(a.this.eql.getPageContext().getResources().getString(a.i.charm_no_more));
            }
            if (aLaCharmDataList.data == null || aLaCharmDataList.data.size() <= 0) {
                a.this.eqj.hS(true);
            }
        }

        @Override // com.baidu.tieba.ala.charm.model.a.InterfaceC0414a
        public void aa(int i, String str) {
            a.this.eqj.hS(false);
            a.this.eqj.m(new View.OnClickListener() { // from class: com.baidu.tieba.ala.charm.a.2.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (BdNetTypeUtil.isNetWorkAvailable()) {
                        if (a.this.eqk != null) {
                            a.this.eqk.D(a.this.eqm, a.this.pn, 100);
                            return;
                        }
                        return;
                    }
                    a.this.eql.getPageContext().showToast(a.this.eql.getResources().getString(a.i.sdk_no_network_guide));
                }
            });
        }
    };
    private BdListView.OnScrollToBottomListener eqp = new BdListView.OnScrollToBottomListener() { // from class: com.baidu.tieba.ala.charm.a.3
        @Override // com.baidu.live.adp.widget.listview.BdListView.OnScrollToBottomListener
        public void onScrollToBottom() {
            if (a.this.mHasMore && a.this.eqk != null) {
                a.this.eqk.D(a.this.eqm, a.this.pn, 100);
            }
        }
    };

    public a(ALaCharmCardActivity aLaCharmCardActivity, int i) {
        this.eqm = 1;
        this.eql = aLaCharmCardActivity;
        this.eqm = i;
    }

    public void createView() {
        this.eqj = new com.baidu.tieba.ala.charm.view.b(this.eql, this.mGroupId, this.mLiveId, this.aoM, this.aoN, this.eqm, this.mUserId, this.mUserName, this.eqg, this.eqh, this.eqi);
        this.eqj.a(this.eqp);
        this.eqj.setOtherParams(this.mOtherParams);
        loadData();
        MessageManager.getInstance().registerListener(this.eqn);
    }

    private void loadData() {
        if (this.eqk == null) {
            this.eqk = new com.baidu.tieba.ala.charm.model.a(this.eql.getPageContext(), this.mUserId, this.eqo);
        }
        this.eqk.bb(this.eqm, 100);
    }

    @Override // com.baidu.live.liveroom.c.d
    public View uj() {
        if (this.eqj == null) {
            return null;
        }
        return this.eqj.getRootView();
    }

    public com.baidu.tieba.ala.charm.view.b bbe() {
        return this.eqj;
    }

    public void X(String str, boolean z) {
        if (this.eqj != null) {
            this.eqj.X(str, z);
        }
    }

    public void qZ() {
        if (this.eqj != null) {
            this.eqj.qZ();
        }
    }

    @Override // com.baidu.live.liveroom.c.d
    public String getTitle() {
        if (this.eqm == 2) {
            return this.eql.getResources().getString(a.i.ala_charm_week_title);
        }
        if (this.eqm == 1) {
            return this.eql.getResources().getString(a.i.ala_charm_all_title);
        }
        if (this.eqm == 3) {
            return this.eql.getResources().getString(a.i.ala_charm_day_title);
        }
        if (this.eqm != 4) {
            return null;
        }
        return this.eql.getResources().getString(a.i.audience_list_title);
    }

    public int bbf() {
        return this.eqm;
    }

    @Override // com.baidu.live.liveroom.c.d
    public String uk() {
        return null;
    }

    @Override // com.baidu.live.liveroom.c.d
    public short ul() {
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
        if (this.eqk != null) {
            this.eqk.onDestroy();
        }
        MessageManager.getInstance().unRegisterListener(this.eqn);
    }

    public a xm(String str) {
        this.mUserId = str;
        return this;
    }

    public a xn(String str) {
        this.mUserName = str;
        return this;
    }

    public a xo(String str) {
        this.mGroupId = str;
        return this;
    }

    public a xp(String str) {
        this.mLiveId = str;
        return this;
    }

    public a hR(boolean z) {
        this.aoM = z;
        return this;
    }

    public a xq(String str) {
        this.aoN = str;
        return this;
    }

    public a xr(String str) {
        this.eqf = str;
        return this;
    }

    public a xs(String str) {
        this.eqg = str;
        return this;
    }

    public a xt(String str) {
        this.eqh = str;
        return this;
    }

    public a xu(String str) {
        this.eqi = str;
        return this;
    }

    public a xv(String str) {
        this.mOtherParams = str;
        return this;
    }

    @Override // com.baidu.live.liveroom.c.d
    public void onChangeSkinType(int i) {
    }
}
