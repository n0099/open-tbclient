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
    private boolean aMq;
    private String aMr;
    private String fad;
    private String fae;
    private String faf;
    private String fag;
    private com.baidu.tieba.ala.charm.view.b fah;
    private com.baidu.tieba.ala.charm.model.a fai;
    private ALaCharmCardActivity faj;
    private int fak;
    private String mGroupId;
    private boolean mHasMore;
    private String mLiveId;
    private String mOtherParams;
    private String mUserId;
    private String mUserName;
    private int pn = 0;
    CustomMessageListener fal = new CustomMessageListener(2913095) { // from class: com.baidu.tieba.ala.charm.a.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof String)) {
                String str = (String) customResponsedMessage.getData();
                if (str == null) {
                    str = "";
                }
                if (a.this.fah != null) {
                    a.this.fah.setOtherParams(str);
                }
            }
        }
    };
    a.InterfaceC0463a fam = new a.InterfaceC0463a() { // from class: com.baidu.tieba.ala.charm.a.2
        @Override // com.baidu.tieba.ala.charm.model.a.InterfaceC0463a
        public void a(ALaCharmDataList aLaCharmDataList) {
            if (aLaCharmDataList == null) {
                a.this.fah.jm(true);
                return;
            }
            a.this.fah.blt();
            a.this.fah.a(aLaCharmDataList.data, a.this.pn == 0, aLaCharmDataList.userTotalPrice);
            a.this.pn = aLaCharmDataList.pn + 1;
            a.this.mHasMore = aLaCharmDataList.hasMore;
            if (a.this.mHasMore) {
                a.this.fah.bmo();
            } else {
                a.this.fah.zN(a.this.faj.getPageContext().getResources().getString(a.i.charm_no_more));
            }
            if (aLaCharmDataList.data == null || aLaCharmDataList.data.size() <= 0) {
                a.this.fah.jm(true);
            }
        }

        @Override // com.baidu.tieba.ala.charm.model.a.InterfaceC0463a
        public void as(int i, String str) {
            a.this.fah.jm(false);
            a.this.fah.l(new View.OnClickListener() { // from class: com.baidu.tieba.ala.charm.a.2.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (BdNetTypeUtil.isNetWorkAvailable()) {
                        if (a.this.fai != null) {
                            a.this.fai.L(a.this.fak, a.this.pn, 100);
                            return;
                        }
                        return;
                    }
                    a.this.faj.getPageContext().showToast(a.this.faj.getResources().getString(a.i.sdk_no_network_guide));
                }
            });
        }
    };
    private BdListView.OnScrollToBottomListener fan = new BdListView.OnScrollToBottomListener() { // from class: com.baidu.tieba.ala.charm.a.3
        @Override // com.baidu.live.adp.widget.listview.BdListView.OnScrollToBottomListener
        public void onScrollToBottom() {
            if (a.this.mHasMore && a.this.fai != null) {
                a.this.fai.L(a.this.fak, a.this.pn, 100);
            }
        }
    };

    public a(ALaCharmCardActivity aLaCharmCardActivity, int i) {
        this.fak = 1;
        this.faj = aLaCharmCardActivity;
        this.fak = i;
    }

    public void createView() {
        this.fah = new com.baidu.tieba.ala.charm.view.b(this.faj, this.mGroupId, this.mLiveId, this.aMq, this.aMr, this.fak, this.mUserId, this.mUserName, this.fae, this.faf, this.fag);
        this.fah.a(this.fan);
        this.fah.setOtherParams(this.mOtherParams);
        loadData();
        MessageManager.getInstance().registerListener(this.fal);
    }

    private void loadData() {
        if (this.fai == null) {
            this.fai = new com.baidu.tieba.ala.charm.model.a(this.faj.getPageContext(), this.mUserId, this.fam);
        }
        this.fai.bl(this.fak, 100);
    }

    @Override // com.baidu.live.liveroom.d.d
    public View getPanelView() {
        if (this.fah == null) {
            return null;
        }
        return this.fah.getRootView();
    }

    public com.baidu.tieba.ala.charm.view.b bnh() {
        return this.fah;
    }

    public void ac(String str, boolean z) {
        if (this.fah != null) {
            this.fah.ac(str, z);
        }
    }

    public void wK() {
        if (this.fah != null) {
            this.fah.wK();
        }
    }

    @Override // com.baidu.live.liveroom.d.d
    public String getTitle() {
        if (this.fak == 2) {
            return this.faj.getResources().getString(a.i.ala_charm_week_title);
        }
        if (this.fak == 1) {
            return this.faj.getResources().getString(a.i.ala_charm_all_title);
        }
        if (this.fak == 3) {
            return this.faj.getResources().getString(a.i.ala_charm_day_title);
        }
        if (this.fak != 4) {
            return null;
        }
        return this.faj.getResources().getString(a.i.audience_list_title);
    }

    public int bni() {
        return this.fak;
    }

    @Override // com.baidu.live.liveroom.d.d
    public String AT() {
        return null;
    }

    @Override // com.baidu.live.liveroom.d.d
    public short AU() {
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
        if (this.fai != null) {
            this.fai.onDestroy();
        }
        MessageManager.getInstance().unRegisterListener(this.fal);
    }

    public a zt(String str) {
        this.mUserId = str;
        return this;
    }

    public a zu(String str) {
        this.mUserName = str;
        return this;
    }

    public a zv(String str) {
        this.mGroupId = str;
        return this;
    }

    public a zw(String str) {
        this.mLiveId = str;
        return this;
    }

    public a jl(boolean z) {
        this.aMq = z;
        return this;
    }

    public a zx(String str) {
        this.aMr = str;
        return this;
    }

    public a zy(String str) {
        this.fad = str;
        return this;
    }

    public a zz(String str) {
        this.fae = str;
        return this;
    }

    public a zA(String str) {
        this.faf = str;
        return this;
    }

    public a zB(String str) {
        this.fag = str;
        return this;
    }

    public a zC(String str) {
        this.mOtherParams = str;
        return this;
    }

    @Override // com.baidu.live.liveroom.d.d
    public void onChangeSkinType(int i) {
    }
}
