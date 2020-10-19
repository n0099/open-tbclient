package com.baidu.tieba.ala.charm;

import android.view.View;
import com.baidu.live.adp.lib.util.BdNetTypeUtil;
import com.baidu.live.data.AlaLiveUserInfoData;
import com.baidu.live.data.n;
import com.baidu.live.sdk.a;
import com.baidu.tieba.ala.charm.model.b;
/* loaded from: classes4.dex */
public class e implements com.baidu.live.liveroom.d.d {
    private String aEr;
    private String aYC;
    private boolean bhU;
    private d gfT;
    private com.baidu.tieba.ala.charm.model.b gfU;
    private String gfV;
    private long gfW;
    b.a gfX = new b.a() { // from class: com.baidu.tieba.ala.charm.e.1
        @Override // com.baidu.tieba.ala.charm.model.b.a
        public void a(long j, n nVar, AlaLiveUserInfoData alaLiveUserInfoData, long j2) {
            if (e.this.gfT != null) {
                e.this.gfT.dY(j);
                if (nVar == null) {
                    e.this.gfT.lw(true);
                    return;
                }
                e.this.gfT.SK();
                e.this.gfT.a(nVar.getList(), alaLiveUserInfoData, j2);
                int size = nVar.getList().size();
                if (size <= 0) {
                    e.this.gfT.lw(true);
                } else if (size < 100) {
                    e.this.gfT.ay(e.this.gfv.getPageContext().getResources().getString(a.i.online_no_more), true);
                } else {
                    e.this.gfT.ay(e.this.gfv.getPageContext().getResources().getString(a.i.online_show_100), false);
                }
            }
        }

        @Override // com.baidu.tieba.ala.charm.model.b.a
        public void aK(int i, String str) {
            if (e.this.gfT != null) {
                e.this.gfT.lw(false);
                e.this.gfT.l(new View.OnClickListener() { // from class: com.baidu.tieba.ala.charm.e.1.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (BdNetTypeUtil.isNetWorkAvailable()) {
                            if (e.this.gfU != null) {
                                e.this.gfU.u(e.this.mLiveId, 0, 0);
                                return;
                            }
                            return;
                        }
                        e.this.gfv.getPageContext().showToast(e.this.gfv.getResources().getString(a.i.sdk_no_network_guide));
                    }
                });
            }
        }
    };
    private ALaCharmCardActivity gfv;
    private String mGroupId;
    private String mLiveId;

    public e(ALaCharmCardActivity aLaCharmCardActivity) {
        this.gfv = aLaCharmCardActivity;
    }

    public void createView() {
        this.gfT = new d(this.gfv, this.mGroupId, this.mLiveId, this.bhU, this.aEr, this.gfV, this.aYC);
        loadData();
    }

    private void loadData() {
        if (this.gfU == null) {
            this.gfU = new com.baidu.tieba.ala.charm.model.b(this.gfv.getPageContext(), this.gfX);
        }
        this.gfU.t(this.mLiveId, 0, 100);
    }

    public void dY(long j) {
        this.gfW = j;
        if (this.gfT != null) {
            this.gfT.dY(j);
        }
    }

    public e Ga(String str) {
        this.mGroupId = str;
        return this;
    }

    public e Gb(String str) {
        this.mLiveId = str;
        return this;
    }

    public e lx(boolean z) {
        this.bhU = z;
        return this;
    }

    public e Gc(String str) {
        this.aEr = str;
        return this;
    }

    public e Gd(String str) {
        this.gfV = str;
        return this;
    }

    public e Ge(String str) {
        this.aYC = str;
        return this;
    }

    @Override // com.baidu.live.liveroom.d.d
    public View getPanelView() {
        if (this.gfT == null) {
            return null;
        }
        return this.gfT.getRootView();
    }

    @Override // com.baidu.live.liveroom.d.d
    public String getTitle() {
        return this.gfv.getResources().getString(a.i.audience_list_title);
    }

    @Override // com.baidu.live.liveroom.d.d
    public String Kx() {
        return null;
    }

    @Override // com.baidu.live.liveroom.d.d
    public short Ky() {
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
        if (this.gfU != null) {
            this.gfU.onDestroy();
        }
    }

    @Override // com.baidu.live.liveroom.d.d
    public void onChangeSkinType(int i) {
    }
}
