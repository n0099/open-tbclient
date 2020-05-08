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
    private boolean aMw;
    private String aMx;
    private String fai;
    private String faj;
    private String fak;
    private String fal;
    private com.baidu.tieba.ala.charm.view.b fam;
    private com.baidu.tieba.ala.charm.model.a fan;
    private ALaCharmCardActivity fao;
    private int fap;
    private String mGroupId;
    private boolean mHasMore;
    private String mLiveId;
    private String mOtherParams;
    private String mUserId;
    private String mUserName;
    private int pn = 0;
    CustomMessageListener faq = new CustomMessageListener(2913095) { // from class: com.baidu.tieba.ala.charm.a.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof String)) {
                String str = (String) customResponsedMessage.getData();
                if (str == null) {
                    str = "";
                }
                if (a.this.fam != null) {
                    a.this.fam.setOtherParams(str);
                }
            }
        }
    };
    a.InterfaceC0484a far = new a.InterfaceC0484a() { // from class: com.baidu.tieba.ala.charm.a.2
        @Override // com.baidu.tieba.ala.charm.model.a.InterfaceC0484a
        public void a(ALaCharmDataList aLaCharmDataList) {
            if (aLaCharmDataList == null) {
                a.this.fam.jm(true);
                return;
            }
            a.this.fam.blr();
            a.this.fam.a(aLaCharmDataList.data, a.this.pn == 0, aLaCharmDataList.userTotalPrice);
            a.this.pn = aLaCharmDataList.pn + 1;
            a.this.mHasMore = aLaCharmDataList.hasMore;
            if (a.this.mHasMore) {
                a.this.fam.bmm();
            } else {
                a.this.fam.zQ(a.this.fao.getPageContext().getResources().getString(a.i.charm_no_more));
            }
            if (aLaCharmDataList.data == null || aLaCharmDataList.data.size() <= 0) {
                a.this.fam.jm(true);
            }
        }

        @Override // com.baidu.tieba.ala.charm.model.a.InterfaceC0484a
        public void as(int i, String str) {
            a.this.fam.jm(false);
            a.this.fam.l(new View.OnClickListener() { // from class: com.baidu.tieba.ala.charm.a.2.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (BdNetTypeUtil.isNetWorkAvailable()) {
                        if (a.this.fan != null) {
                            a.this.fan.L(a.this.fap, a.this.pn, 100);
                            return;
                        }
                        return;
                    }
                    a.this.fao.getPageContext().showToast(a.this.fao.getResources().getString(a.i.sdk_no_network_guide));
                }
            });
        }
    };
    private BdListView.OnScrollToBottomListener fas = new BdListView.OnScrollToBottomListener() { // from class: com.baidu.tieba.ala.charm.a.3
        @Override // com.baidu.live.adp.widget.listview.BdListView.OnScrollToBottomListener
        public void onScrollToBottom() {
            if (a.this.mHasMore && a.this.fan != null) {
                a.this.fan.L(a.this.fap, a.this.pn, 100);
            }
        }
    };

    public a(ALaCharmCardActivity aLaCharmCardActivity, int i) {
        this.fap = 1;
        this.fao = aLaCharmCardActivity;
        this.fap = i;
    }

    public void createView() {
        this.fam = new com.baidu.tieba.ala.charm.view.b(this.fao, this.mGroupId, this.mLiveId, this.aMw, this.aMx, this.fap, this.mUserId, this.mUserName, this.faj, this.fak, this.fal);
        this.fam.a(this.fas);
        this.fam.setOtherParams(this.mOtherParams);
        loadData();
        MessageManager.getInstance().registerListener(this.faq);
    }

    private void loadData() {
        if (this.fan == null) {
            this.fan = new com.baidu.tieba.ala.charm.model.a(this.fao.getPageContext(), this.mUserId, this.far);
        }
        this.fan.bl(this.fap, 100);
    }

    @Override // com.baidu.live.liveroom.d.d
    public View getPanelView() {
        if (this.fam == null) {
            return null;
        }
        return this.fam.getRootView();
    }

    public com.baidu.tieba.ala.charm.view.b bnf() {
        return this.fam;
    }

    public void ac(String str, boolean z) {
        if (this.fam != null) {
            this.fam.ac(str, z);
        }
    }

    public void wJ() {
        if (this.fam != null) {
            this.fam.wJ();
        }
    }

    @Override // com.baidu.live.liveroom.d.d
    public String getTitle() {
        if (this.fap == 2) {
            return this.fao.getResources().getString(a.i.ala_charm_week_title);
        }
        if (this.fap == 1) {
            return this.fao.getResources().getString(a.i.ala_charm_all_title);
        }
        if (this.fap == 3) {
            return this.fao.getResources().getString(a.i.ala_charm_day_title);
        }
        if (this.fap != 4) {
            return null;
        }
        return this.fao.getResources().getString(a.i.audience_list_title);
    }

    public int bng() {
        return this.fap;
    }

    @Override // com.baidu.live.liveroom.d.d
    public String AS() {
        return null;
    }

    @Override // com.baidu.live.liveroom.d.d
    public short AT() {
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
        if (this.fan != null) {
            this.fan.onDestroy();
        }
        MessageManager.getInstance().unRegisterListener(this.faq);
    }

    public a zw(String str) {
        this.mUserId = str;
        return this;
    }

    public a zx(String str) {
        this.mUserName = str;
        return this;
    }

    public a zy(String str) {
        this.mGroupId = str;
        return this;
    }

    public a zz(String str) {
        this.mLiveId = str;
        return this;
    }

    public a jl(boolean z) {
        this.aMw = z;
        return this;
    }

    public a zA(String str) {
        this.aMx = str;
        return this;
    }

    public a zB(String str) {
        this.fai = str;
        return this;
    }

    public a zC(String str) {
        this.faj = str;
        return this;
    }

    public a zD(String str) {
        this.fak = str;
        return this;
    }

    public a zE(String str) {
        this.fal = str;
        return this;
    }

    public a zF(String str) {
        this.mOtherParams = str;
        return this;
    }

    @Override // com.baidu.live.liveroom.d.d
    public void onChangeSkinType(int i) {
    }
}
