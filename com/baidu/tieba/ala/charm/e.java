package com.baidu.tieba.ala.charm;

import android.view.View;
import com.baidu.live.adp.lib.util.BdNetTypeUtil;
import com.baidu.live.data.AlaLiveUserInfoData;
import com.baidu.live.data.k;
import com.baidu.live.sdk.a;
import com.baidu.tieba.ala.charm.model.b;
/* loaded from: classes7.dex */
public class e implements com.baidu.live.liveroom.d.d {
    private String aAE;
    private boolean bbH;
    private ALaCharmCardActivity fPN;
    private String fQh;
    private d fQm;
    private com.baidu.tieba.ala.charm.model.b fQn;
    private String fQo;
    private long fQp;
    b.a fQq = new b.a() { // from class: com.baidu.tieba.ala.charm.e.1
        @Override // com.baidu.tieba.ala.charm.model.b.a
        public void a(long j, k kVar, AlaLiveUserInfoData alaLiveUserInfoData, long j2) {
            if (e.this.fQm != null) {
                e.this.fQm.dO(j);
                if (kVar == null) {
                    e.this.fQm.kU(true);
                    return;
                }
                e.this.fQm.bFW();
                e.this.fQm.a(kVar.getList(), alaLiveUserInfoData, j2);
                int size = kVar.getList().size();
                if (size <= 0) {
                    e.this.fQm.kU(true);
                } else if (size < 100) {
                    e.this.fQm.au(e.this.fPN.getPageContext().getResources().getString(a.i.online_no_more), true);
                } else {
                    e.this.fQm.au(e.this.fPN.getPageContext().getResources().getString(a.i.online_show_100), false);
                }
            }
        }

        @Override // com.baidu.tieba.ala.charm.model.b.a
        public void az(int i, String str) {
            if (e.this.fQm != null) {
                e.this.fQm.kU(false);
                e.this.fQm.l(new View.OnClickListener() { // from class: com.baidu.tieba.ala.charm.e.1.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (BdNetTypeUtil.isNetWorkAvailable()) {
                            if (e.this.fQn != null) {
                                e.this.fQn.u(e.this.mLiveId, 0, 0);
                                return;
                            }
                            return;
                        }
                        e.this.fPN.getPageContext().showToast(e.this.fPN.getResources().getString(a.i.sdk_no_network_guide));
                    }
                });
            }
        }
    };
    private String mGroupId;
    private String mLiveId;

    public e(ALaCharmCardActivity aLaCharmCardActivity) {
        this.fPN = aLaCharmCardActivity;
    }

    public void createView() {
        this.fQm = new d(this.fPN, this.mGroupId, this.mLiveId, this.bbH, this.aAE, this.fQo, this.fQh);
        loadData();
    }

    private void loadData() {
        if (this.fQn == null) {
            this.fQn = new com.baidu.tieba.ala.charm.model.b(this.fPN.getPageContext(), this.fQq);
        }
        this.fQn.t(this.mLiveId, 0, 100);
    }

    public void dO(long j) {
        this.fQp = j;
        if (this.fQm != null) {
            this.fQm.dO(j);
        }
    }

    public e ER(String str) {
        this.mGroupId = str;
        return this;
    }

    public e ES(String str) {
        this.mLiveId = str;
        return this;
    }

    public e kV(boolean z) {
        this.bbH = z;
        return this;
    }

    public e ET(String str) {
        this.aAE = str;
        return this;
    }

    public e EU(String str) {
        this.fQo = str;
        return this;
    }

    public e EV(String str) {
        this.fQh = str;
        return this;
    }

    @Override // com.baidu.live.liveroom.d.d
    public View getPanelView() {
        if (this.fQm == null) {
            return null;
        }
        return this.fQm.getRootView();
    }

    @Override // com.baidu.live.liveroom.d.d
    public String getTitle() {
        return this.fPN.getResources().getString(a.i.audience_list_title);
    }

    @Override // com.baidu.live.liveroom.d.d
    public String IM() {
        return null;
    }

    @Override // com.baidu.live.liveroom.d.d
    public short IN() {
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
        if (this.fQn != null) {
            this.fQn.onDestroy();
        }
    }

    @Override // com.baidu.live.liveroom.d.d
    public void onChangeSkinType(int i) {
    }
}
