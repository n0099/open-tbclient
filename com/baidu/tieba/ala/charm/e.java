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
    private ALaCharmCardActivity gDE;
    private d gEc;
    private com.baidu.tieba.ala.charm.model.b gEd;
    private String gEe;
    private long gEf;
    b.a gEg = new b.a() { // from class: com.baidu.tieba.ala.charm.e.1
        @Override // com.baidu.tieba.ala.charm.model.b.a
        public void a(long j, q qVar, AlaLiveUserInfoData alaLiveUserInfoData, long j2) {
            if (e.this.gEc != null) {
                e.this.gEc.eZ(j);
                if (qVar == null) {
                    e.this.gEc.dG(true);
                    return;
                }
                e.this.gEc.Yb();
                e.this.gEc.a(qVar.getList(), alaLiveUserInfoData, j2);
                int size = qVar.getList().size();
                if (size <= 0) {
                    e.this.gEc.dG(true);
                } else if (size < 100) {
                    e.this.gEc.aB(e.this.gDE.getPageContext().getResources().getString(a.h.online_no_more), true);
                } else {
                    e.this.gEc.aB(e.this.gDE.getPageContext().getResources().getString(a.h.online_show_100), false);
                }
            }
        }

        @Override // com.baidu.tieba.ala.charm.model.b.a
        public void t(int i, String str) {
            if (e.this.gEc != null) {
                e.this.gEc.dG(false);
                e.this.gEc.m(new View.OnClickListener() { // from class: com.baidu.tieba.ala.charm.e.1.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (BdNetTypeUtil.isNetWorkAvailable()) {
                            if (e.this.gEd != null) {
                                e.this.gEd.w(e.this.mLiveId, 0, 0);
                                return;
                            }
                            return;
                        }
                        e.this.gDE.getPageContext().showToast(e.this.gDE.getResources().getString(a.h.sdk_no_network_guide));
                    }
                });
            }
        }
    };
    b.InterfaceC0651b gEh = new b.InterfaceC0651b() { // from class: com.baidu.tieba.ala.charm.e.2
        @Override // com.baidu.tieba.ala.charm.model.b.InterfaceC0651b
        public void s(long j, int i) {
            e.this.gEc.r(j, i);
        }

        @Override // com.baidu.tieba.ala.charm.model.b.InterfaceC0651b
        public void t(int i, String str) {
            BdUtilHelper.showToast(e.this.gDE, e.this.gDE.getString(a.h.sdk_poke_poke_once_fail));
        }
    };
    private String mGroupId;
    private String mLiveId;

    public e(ALaCharmCardActivity aLaCharmCardActivity) {
        this.gDE = aLaCharmCardActivity;
    }

    public void createView() {
        this.gEc = new d(this.gDE, this.mGroupId, this.mLiveId, this.bns, this.aGk, this.gEe, this.bdg);
        loadData();
    }

    private void loadData() {
        if (this.gEd == null) {
            this.gEd = new com.baidu.tieba.ala.charm.model.b(this.gDE.getPageContext(), this.gEg, this.gEh);
        }
        this.gEd.v(this.mLiveId, 0, 100);
    }

    public void eZ(long j) {
        this.gEf = j;
        if (this.gEc != null) {
            this.gEc.eZ(j);
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
        this.gEe = str;
        return this;
    }

    public e Hg(String str) {
        this.bdg = str;
        return this;
    }

    @Override // com.baidu.live.liveroom.d.d
    public View getPanelView() {
        if (this.gEc == null) {
            return null;
        }
        return this.gEc.getRootView();
    }

    @Override // com.baidu.live.liveroom.d.d
    public String getTitle() {
        return this.gDE.getResources().getString(a.h.audience_list_title);
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
        if (this.gEd != null) {
            this.gEd.onDestroy();
        }
    }

    @Override // com.baidu.live.liveroom.d.d
    public void onChangeSkinType(int i) {
    }
}
