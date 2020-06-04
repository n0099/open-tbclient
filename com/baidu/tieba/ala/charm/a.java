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
    private String fnW;
    private String fnX;
    private String fnY;
    private String fnZ;
    private com.baidu.tieba.ala.charm.view.b foa;
    private com.baidu.tieba.ala.charm.model.a fob;
    private ALaCharmCardActivity foc;
    private int fod;
    private String mGroupId;
    private boolean mHasMore;
    private String mLiveId;
    private String mOtherParams;
    private String mUserId;
    private String mUserName;
    private int pn = 0;
    CustomMessageListener foe = new CustomMessageListener(2913095) { // from class: com.baidu.tieba.ala.charm.a.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof String)) {
                String str = (String) customResponsedMessage.getData();
                if (str == null) {
                    str = "";
                }
                if (a.this.foa != null) {
                    a.this.foa.setOtherParams(str);
                }
            }
        }
    };
    a.InterfaceC0532a fof = new a.InterfaceC0532a() { // from class: com.baidu.tieba.ala.charm.a.2
        @Override // com.baidu.tieba.ala.charm.model.a.InterfaceC0532a
        public void a(ALaCharmDataList aLaCharmDataList) {
            if (aLaCharmDataList == null) {
                a.this.foa.jF(true);
                return;
            }
            a.this.foa.bqQ();
            a.this.foa.a(aLaCharmDataList.data, a.this.pn == 0, aLaCharmDataList.userTotalPrice);
            a.this.pn = aLaCharmDataList.pn + 1;
            a.this.mHasMore = aLaCharmDataList.hasMore;
            if (a.this.mHasMore) {
                a.this.foa.brM();
            } else {
                a.this.foa.Bx(a.this.foc.getPageContext().getResources().getString(a.i.charm_no_more));
            }
            if (aLaCharmDataList.data == null || aLaCharmDataList.data.size() <= 0) {
                a.this.foa.jF(true);
            }
        }

        @Override // com.baidu.tieba.ala.charm.model.a.InterfaceC0532a
        public void ax(int i, String str) {
            a.this.foa.jF(false);
            a.this.foa.k(new View.OnClickListener() { // from class: com.baidu.tieba.ala.charm.a.2.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (BdNetTypeUtil.isNetWorkAvailable()) {
                        if (a.this.fob != null) {
                            a.this.fob.K(a.this.fod, a.this.pn, 100);
                            return;
                        }
                        return;
                    }
                    a.this.foc.getPageContext().showToast(a.this.foc.getResources().getString(a.i.sdk_no_network_guide));
                }
            });
        }
    };
    private BdListView.OnScrollToBottomListener fog = new BdListView.OnScrollToBottomListener() { // from class: com.baidu.tieba.ala.charm.a.3
        @Override // com.baidu.live.adp.widget.listview.BdListView.OnScrollToBottomListener
        public void onScrollToBottom() {
            if (a.this.mHasMore && a.this.fob != null) {
                a.this.fob.K(a.this.fod, a.this.pn, 100);
            }
        }
    };

    public a(ALaCharmCardActivity aLaCharmCardActivity, int i) {
        this.fod = 1;
        this.foc = aLaCharmCardActivity;
        this.fod = i;
    }

    public void createView() {
        this.foa = new com.baidu.tieba.ala.charm.view.b(this.foc, this.mGroupId, this.mLiveId, this.aSw, this.aSx, this.fod, this.mUserId, this.mUserName, this.fnX, this.fnY, this.fnZ);
        this.foa.a(this.fog);
        this.foa.setOtherParams(this.mOtherParams);
        loadData();
        MessageManager.getInstance().registerListener(this.foe);
    }

    private void loadData() {
        if (this.fob == null) {
            this.fob = new com.baidu.tieba.ala.charm.model.a(this.foc.getPageContext(), this.mUserId, this.fof);
        }
        this.fob.bo(this.fod, 100);
    }

    @Override // com.baidu.live.liveroom.d.d
    public View getPanelView() {
        if (this.foa == null) {
            return null;
        }
        return this.foa.getRootView();
    }

    public com.baidu.tieba.ala.charm.view.b bsZ() {
        return this.foa;
    }

    public void ap(String str, boolean z) {
        if (this.foa != null) {
            this.foa.ap(str, z);
        }
    }

    public void ya() {
        if (this.foa != null) {
            this.foa.ya();
        }
    }

    @Override // com.baidu.live.liveroom.d.d
    public String getTitle() {
        if (this.fod == 2) {
            return this.foc.getResources().getString(a.i.ala_charm_week_title);
        }
        if (this.fod == 1) {
            return this.foc.getResources().getString(a.i.ala_charm_all_title);
        }
        if (this.fod == 3) {
            return this.foc.getResources().getString(a.i.ala_charm_day_title);
        }
        if (this.fod != 4) {
            return null;
        }
        return this.foc.getResources().getString(a.i.audience_list_title);
    }

    public int bta() {
        return this.fod;
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
        if (this.fob != null) {
            this.fob.onDestroy();
        }
        MessageManager.getInstance().unRegisterListener(this.foe);
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
        this.fnW = str;
        return this;
    }

    public a Bj(String str) {
        this.fnX = str;
        return this;
    }

    public a Bk(String str) {
        this.fnY = str;
        return this;
    }

    public a Bl(String str) {
        this.fnZ = str;
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
