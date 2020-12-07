package com.baidu.tieba.ala.charm;

import android.view.View;
import com.baidu.live.adp.lib.util.BdNetTypeUtil;
import com.baidu.live.adp.lib.util.BdUtilHelper;
import com.baidu.live.data.AlaLiveUserInfoData;
import com.baidu.live.data.q;
import com.baidu.live.sdk.a;
import com.baidu.tieba.ala.charm.model.b;
/* loaded from: classes4.dex */
public class e implements com.baidu.live.liveroom.d.d {
    private String aGk;
    private String bdg;
    private boolean bns;
    private ALaCharmCardActivity gDC;
    private d gEa;
    private com.baidu.tieba.ala.charm.model.b gEb;
    private String gEc;
    private long gEd;
    b.a gEe = new b.a() { // from class: com.baidu.tieba.ala.charm.e.1
        @Override // com.baidu.tieba.ala.charm.model.b.a
        public void a(long j, q qVar, AlaLiveUserInfoData alaLiveUserInfoData, long j2) {
            if (e.this.gEa != null) {
                e.this.gEa.eZ(j);
                if (qVar == null) {
                    e.this.gEa.dG(true);
                    return;
                }
                e.this.gEa.Yb();
                e.this.gEa.a(qVar.getList(), alaLiveUserInfoData, j2);
                int size = qVar.getList().size();
                if (size <= 0) {
                    e.this.gEa.dG(true);
                } else if (size < 100) {
                    e.this.gEa.aB(e.this.gDC.getPageContext().getResources().getString(a.h.online_no_more), true);
                } else {
                    e.this.gEa.aB(e.this.gDC.getPageContext().getResources().getString(a.h.online_show_100), false);
                }
            }
        }

        @Override // com.baidu.tieba.ala.charm.model.b.a
        public void t(int i, String str) {
            if (e.this.gEa != null) {
                e.this.gEa.dG(false);
                e.this.gEa.m(new View.OnClickListener() { // from class: com.baidu.tieba.ala.charm.e.1.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (BdNetTypeUtil.isNetWorkAvailable()) {
                            if (e.this.gEb != null) {
                                e.this.gEb.w(e.this.mLiveId, 0, 0);
                                return;
                            }
                            return;
                        }
                        e.this.gDC.getPageContext().showToast(e.this.gDC.getResources().getString(a.h.sdk_no_network_guide));
                    }
                });
            }
        }
    };
    b.InterfaceC0651b gEf = new b.InterfaceC0651b() { // from class: com.baidu.tieba.ala.charm.e.2
        @Override // com.baidu.tieba.ala.charm.model.b.InterfaceC0651b
        public void s(long j, int i) {
            e.this.gEa.r(j, i);
        }

        @Override // com.baidu.tieba.ala.charm.model.b.InterfaceC0651b
        public void t(int i, String str) {
            BdUtilHelper.showToast(e.this.gDC, e.this.gDC.getString(a.h.sdk_poke_poke_once_fail));
        }
    };
    private String mGroupId;
    private String mLiveId;

    public e(ALaCharmCardActivity aLaCharmCardActivity) {
        this.gDC = aLaCharmCardActivity;
    }

    public void createView() {
        this.gEa = new d(this.gDC, this.mGroupId, this.mLiveId, this.bns, this.aGk, this.gEc, this.bdg);
        loadData();
    }

    private void loadData() {
        if (this.gEb == null) {
            this.gEb = new com.baidu.tieba.ala.charm.model.b(this.gDC.getPageContext(), this.gEe, this.gEf);
        }
        this.gEb.v(this.mLiveId, 0, 100);
    }

    public void eZ(long j) {
        this.gEd = j;
        if (this.gEa != null) {
            this.gEa.eZ(j);
        }
    }

    public e Hc(String str) {
        this.mGroupId = str;
        return this;
    }

    public e Hd(String str) {
        this.mLiveId = str;
        return this;
    }

    public e mt(boolean z) {
        this.bns = z;
        return this;
    }

    public e He(String str) {
        this.aGk = str;
        return this;
    }

    public e Hf(String str) {
        this.gEc = str;
        return this;
    }

    public e Hg(String str) {
        this.bdg = str;
        return this;
    }

    @Override // com.baidu.live.liveroom.d.d
    public View getPanelView() {
        if (this.gEa == null) {
            return null;
        }
        return this.gEa.getRootView();
    }

    @Override // com.baidu.live.liveroom.d.d
    public String getTitle() {
        return this.gDC.getResources().getString(a.h.audience_list_title);
    }

    @Override // com.baidu.live.liveroom.d.d
    public String MK() {
        return null;
    }

    @Override // com.baidu.live.liveroom.d.d
    public short ML() {
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
        if (this.gEb != null) {
            this.gEb.onDestroy();
        }
    }

    @Override // com.baidu.live.liveroom.d.d
    public void onChangeSkinType(int i) {
    }
}
