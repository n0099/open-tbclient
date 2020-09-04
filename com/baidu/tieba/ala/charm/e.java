package com.baidu.tieba.ala.charm;

import android.view.View;
import com.baidu.live.adp.lib.util.BdNetTypeUtil;
import com.baidu.live.data.AlaLiveUserInfoData;
import com.baidu.live.data.k;
import com.baidu.live.sdk.a;
import com.baidu.tieba.ala.charm.model.b;
/* loaded from: classes7.dex */
public class e implements com.baidu.live.liveroom.d.d {
    private String aAG;
    private boolean bbJ;
    private ALaCharmCardActivity fPR;
    private String fQl;
    private d fQq;
    private com.baidu.tieba.ala.charm.model.b fQr;
    private String fQs;
    private long fQt;
    b.a fQu = new b.a() { // from class: com.baidu.tieba.ala.charm.e.1
        @Override // com.baidu.tieba.ala.charm.model.b.a
        public void a(long j, k kVar, AlaLiveUserInfoData alaLiveUserInfoData, long j2) {
            if (e.this.fQq != null) {
                e.this.fQq.dO(j);
                if (kVar == null) {
                    e.this.fQq.kW(true);
                    return;
                }
                e.this.fQq.bFX();
                e.this.fQq.a(kVar.getList(), alaLiveUserInfoData, j2);
                int size = kVar.getList().size();
                if (size <= 0) {
                    e.this.fQq.kW(true);
                } else if (size < 100) {
                    e.this.fQq.au(e.this.fPR.getPageContext().getResources().getString(a.i.online_no_more), true);
                } else {
                    e.this.fQq.au(e.this.fPR.getPageContext().getResources().getString(a.i.online_show_100), false);
                }
            }
        }

        @Override // com.baidu.tieba.ala.charm.model.b.a
        public void ay(int i, String str) {
            if (e.this.fQq != null) {
                e.this.fQq.kW(false);
                e.this.fQq.l(new View.OnClickListener() { // from class: com.baidu.tieba.ala.charm.e.1.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (BdNetTypeUtil.isNetWorkAvailable()) {
                            if (e.this.fQr != null) {
                                e.this.fQr.u(e.this.mLiveId, 0, 0);
                                return;
                            }
                            return;
                        }
                        e.this.fPR.getPageContext().showToast(e.this.fPR.getResources().getString(a.i.sdk_no_network_guide));
                    }
                });
            }
        }
    };
    private String mGroupId;
    private String mLiveId;

    public e(ALaCharmCardActivity aLaCharmCardActivity) {
        this.fPR = aLaCharmCardActivity;
    }

    public void createView() {
        this.fQq = new d(this.fPR, this.mGroupId, this.mLiveId, this.bbJ, this.aAG, this.fQs, this.fQl);
        loadData();
    }

    private void loadData() {
        if (this.fQr == null) {
            this.fQr = new com.baidu.tieba.ala.charm.model.b(this.fPR.getPageContext(), this.fQu);
        }
        this.fQr.t(this.mLiveId, 0, 100);
    }

    public void dO(long j) {
        this.fQt = j;
        if (this.fQq != null) {
            this.fQq.dO(j);
        }
    }

    public e ES(String str) {
        this.mGroupId = str;
        return this;
    }

    public e ET(String str) {
        this.mLiveId = str;
        return this;
    }

    public e kX(boolean z) {
        this.bbJ = z;
        return this;
    }

    public e EU(String str) {
        this.aAG = str;
        return this;
    }

    public e EV(String str) {
        this.fQs = str;
        return this;
    }

    public e EW(String str) {
        this.fQl = str;
        return this;
    }

    @Override // com.baidu.live.liveroom.d.d
    public View getPanelView() {
        if (this.fQq == null) {
            return null;
        }
        return this.fQq.getRootView();
    }

    @Override // com.baidu.live.liveroom.d.d
    public String getTitle() {
        return this.fPR.getResources().getString(a.i.audience_list_title);
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
        if (this.fQr != null) {
            this.fQr.onDestroy();
        }
    }

    @Override // com.baidu.live.liveroom.d.d
    public void onChangeSkinType(int i) {
    }
}
