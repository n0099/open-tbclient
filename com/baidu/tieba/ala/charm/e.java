package com.baidu.tieba.ala.charm;

import android.view.View;
import com.baidu.live.adp.lib.util.BdNetTypeUtil;
import com.baidu.live.data.AlaLiveUserInfoData;
import com.baidu.live.data.n;
import com.baidu.live.sdk.a;
import com.baidu.tieba.ala.charm.model.b;
/* loaded from: classes4.dex */
public class e implements com.baidu.live.liveroom.d.d {
    private String aBm;
    private String aVr;
    private boolean bej;
    private d fTA;
    private com.baidu.tieba.ala.charm.model.b fTB;
    private String fTC;
    private long fTD;
    b.a fTE = new b.a() { // from class: com.baidu.tieba.ala.charm.e.1
        @Override // com.baidu.tieba.ala.charm.model.b.a
        public void a(long j, n nVar, AlaLiveUserInfoData alaLiveUserInfoData, long j2) {
            if (e.this.fTA != null) {
                e.this.fTA.dP(j);
                if (nVar == null) {
                    e.this.fTA.kY(true);
                    return;
                }
                e.this.fTA.bHn();
                e.this.fTA.a(nVar.getList(), alaLiveUserInfoData, j2);
                int size = nVar.getList().size();
                if (size <= 0) {
                    e.this.fTA.kY(true);
                } else if (size < 100) {
                    e.this.fTA.au(e.this.fTc.getPageContext().getResources().getString(a.i.online_no_more), true);
                } else {
                    e.this.fTA.au(e.this.fTc.getPageContext().getResources().getString(a.i.online_show_100), false);
                }
            }
        }

        @Override // com.baidu.tieba.ala.charm.model.b.a
        public void az(int i, String str) {
            if (e.this.fTA != null) {
                e.this.fTA.kY(false);
                e.this.fTA.l(new View.OnClickListener() { // from class: com.baidu.tieba.ala.charm.e.1.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (BdNetTypeUtil.isNetWorkAvailable()) {
                            if (e.this.fTB != null) {
                                e.this.fTB.u(e.this.mLiveId, 0, 0);
                                return;
                            }
                            return;
                        }
                        e.this.fTc.getPageContext().showToast(e.this.fTc.getResources().getString(a.i.sdk_no_network_guide));
                    }
                });
            }
        }
    };
    private ALaCharmCardActivity fTc;
    private String mGroupId;
    private String mLiveId;

    public e(ALaCharmCardActivity aLaCharmCardActivity) {
        this.fTc = aLaCharmCardActivity;
    }

    public void createView() {
        this.fTA = new d(this.fTc, this.mGroupId, this.mLiveId, this.bej, this.aBm, this.fTC, this.aVr);
        loadData();
    }

    private void loadData() {
        if (this.fTB == null) {
            this.fTB = new com.baidu.tieba.ala.charm.model.b(this.fTc.getPageContext(), this.fTE);
        }
        this.fTB.t(this.mLiveId, 0, 100);
    }

    public void dP(long j) {
        this.fTD = j;
        if (this.fTA != null) {
            this.fTA.dP(j);
        }
    }

    public e Fp(String str) {
        this.mGroupId = str;
        return this;
    }

    public e Fq(String str) {
        this.mLiveId = str;
        return this;
    }

    public e kZ(boolean z) {
        this.bej = z;
        return this;
    }

    public e Fr(String str) {
        this.aBm = str;
        return this;
    }

    public e Fs(String str) {
        this.fTC = str;
        return this;
    }

    public e Ft(String str) {
        this.aVr = str;
        return this;
    }

    @Override // com.baidu.live.liveroom.d.d
    public View getPanelView() {
        if (this.fTA == null) {
            return null;
        }
        return this.fTA.getRootView();
    }

    @Override // com.baidu.live.liveroom.d.d
    public String getTitle() {
        return this.fTc.getResources().getString(a.i.audience_list_title);
    }

    @Override // com.baidu.live.liveroom.d.d
    public String Jq() {
        return null;
    }

    @Override // com.baidu.live.liveroom.d.d
    public short Jr() {
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
        if (this.fTB != null) {
            this.fTB.onDestroy();
        }
    }

    @Override // com.baidu.live.liveroom.d.d
    public void onChangeSkinType(int i) {
    }
}
