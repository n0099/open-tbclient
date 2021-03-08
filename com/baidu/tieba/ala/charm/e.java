package com.baidu.tieba.ala.charm;

import android.text.TextUtils;
import android.view.View;
import com.baidu.live.adp.lib.util.BdNetTypeUtil;
import com.baidu.live.adp.lib.util.BdUtilHelper;
import com.baidu.live.data.AlaLiveUserInfoData;
import com.baidu.live.data.v;
import com.baidu.live.sdk.a;
import com.baidu.tieba.ala.charm.model.b;
/* loaded from: classes10.dex */
public class e implements com.baidu.live.liveroom.d.d {
    private String aFb;
    private String beK;
    private boolean bpf;
    private d gPL;
    private com.baidu.tieba.ala.charm.model.b gPM;
    private String gPN;
    private long gPO;
    b.a gPP = new b.a() { // from class: com.baidu.tieba.ala.charm.e.1
        @Override // com.baidu.tieba.ala.charm.model.b.a
        public void a(long j, v vVar, AlaLiveUserInfoData alaLiveUserInfoData, long j2) {
            if (e.this.gPL != null) {
                e.this.gPL.ff(j);
                if (vVar == null) {
                    e.this.gPL.dQ(true);
                    return;
                }
                e.this.gPL.Xc();
                e.this.gPL.a(vVar.getList(), alaLiveUserInfoData, j2);
                int size = vVar.getList().size();
                if (size <= 0) {
                    e.this.gPL.dQ(true);
                } else if (size < 100) {
                    e.this.gPL.aB(e.this.gPn.getPageContext().getResources().getString(a.h.online_no_more), true);
                } else {
                    e.this.gPL.aB(e.this.gPn.getPageContext().getResources().getString(a.h.online_show_100), false);
                }
            }
        }

        @Override // com.baidu.tieba.ala.charm.model.b.a
        public void A(int i, String str) {
            if (e.this.gPL != null) {
                e.this.gPL.dQ(false);
                e.this.gPL.n(new View.OnClickListener() { // from class: com.baidu.tieba.ala.charm.e.1.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (BdNetTypeUtil.isNetWorkAvailable()) {
                            if (e.this.gPM != null) {
                                e.this.gPM.w(e.this.mLiveId, 0, 0);
                                return;
                            }
                            return;
                        }
                        e.this.gPn.getPageContext().showToast(e.this.gPn.getResources().getString(a.h.sdk_no_network_guide));
                    }
                });
            }
        }
    };
    b.InterfaceC0631b gPQ = new b.InterfaceC0631b() { // from class: com.baidu.tieba.ala.charm.e.2
        @Override // com.baidu.tieba.ala.charm.model.b.InterfaceC0631b
        public void u(long j, int i) {
            e.this.gPL.t(j, i);
        }

        @Override // com.baidu.tieba.ala.charm.model.b.InterfaceC0631b
        public void A(int i, String str) {
            if (TextUtils.isEmpty(str)) {
                BdUtilHelper.showToast(e.this.gPn, e.this.gPn.getString(a.h.sdk_poke_poke_once_fail));
            } else {
                BdUtilHelper.showToast(e.this.gPn, str);
            }
        }
    };
    private ALaCharmCardActivity gPn;
    private String mGroupId;
    private String mLiveId;

    public e(ALaCharmCardActivity aLaCharmCardActivity) {
        this.gPn = aLaCharmCardActivity;
    }

    public void createView() {
        this.gPL = new d(this.gPn, this.mGroupId, this.mLiveId, this.bpf, this.aFb, this.gPN, this.beK);
        loadData();
    }

    private void loadData() {
        if (this.gPM == null) {
            this.gPM = new com.baidu.tieba.ala.charm.model.b(this.gPn.getPageContext(), this.gPP, this.gPQ);
        }
        this.gPM.v(this.mLiveId, 0, 100);
    }

    public void ff(long j) {
        this.gPO = j;
        if (this.gPL != null) {
            this.gPL.ff(j);
        }
    }

    public e Gy(String str) {
        this.mGroupId = str;
        return this;
    }

    public e Gz(String str) {
        this.mLiveId = str;
        return this;
    }

    public e mT(boolean z) {
        this.bpf = z;
        return this;
    }

    public e GA(String str) {
        this.aFb = str;
        return this;
    }

    public e GB(String str) {
        this.gPN = str;
        return this;
    }

    public e GC(String str) {
        this.beK = str;
        return this;
    }

    @Override // com.baidu.live.liveroom.d.d
    public View getPanelView() {
        if (this.gPL == null) {
            return null;
        }
        return this.gPL.getRootView();
    }

    @Override // com.baidu.live.liveroom.d.d
    public String getTitle() {
        return this.gPn.getResources().getString(a.h.audience_list_title);
    }

    @Override // com.baidu.live.liveroom.d.d
    public String JN() {
        return null;
    }

    @Override // com.baidu.live.liveroom.d.d
    public short JO() {
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
        if (this.gPM != null) {
            this.gPM.onDestroy();
        }
    }

    @Override // com.baidu.live.liveroom.d.d
    public void onChangeSkinType(int i) {
    }
}
