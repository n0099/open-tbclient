package com.baidu.tieba.ala.charm;

import android.text.TextUtils;
import android.view.View;
import com.baidu.live.adp.lib.util.BdNetTypeUtil;
import com.baidu.live.adp.lib.util.BdUtilHelper;
import com.baidu.live.data.AlaLiveUserInfoData;
import com.baidu.live.data.v;
import com.baidu.live.sdk.a;
import com.baidu.tieba.ala.charm.model.b;
/* loaded from: classes11.dex */
public class e implements com.baidu.live.liveroom.d.d {
    private String aDB;
    private String bdi;
    private boolean bnF;
    private ALaCharmCardActivity gNE;
    private d gOc;
    private com.baidu.tieba.ala.charm.model.b gOd;
    private String gOe;
    private long gOf;
    b.a gOg = new b.a() { // from class: com.baidu.tieba.ala.charm.e.1
        @Override // com.baidu.tieba.ala.charm.model.b.a
        public void a(long j, v vVar, AlaLiveUserInfoData alaLiveUserInfoData, long j2) {
            if (e.this.gOc != null) {
                e.this.gOc.ff(j);
                if (vVar == null) {
                    e.this.gOc.dQ(true);
                    return;
                }
                e.this.gOc.WZ();
                e.this.gOc.a(vVar.getList(), alaLiveUserInfoData, j2);
                int size = vVar.getList().size();
                if (size <= 0) {
                    e.this.gOc.dQ(true);
                } else if (size < 100) {
                    e.this.gOc.aB(e.this.gNE.getPageContext().getResources().getString(a.h.online_no_more), true);
                } else {
                    e.this.gOc.aB(e.this.gNE.getPageContext().getResources().getString(a.h.online_show_100), false);
                }
            }
        }

        @Override // com.baidu.tieba.ala.charm.model.b.a
        public void A(int i, String str) {
            if (e.this.gOc != null) {
                e.this.gOc.dQ(false);
                e.this.gOc.n(new View.OnClickListener() { // from class: com.baidu.tieba.ala.charm.e.1.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (BdNetTypeUtil.isNetWorkAvailable()) {
                            if (e.this.gOd != null) {
                                e.this.gOd.w(e.this.mLiveId, 0, 0);
                                return;
                            }
                            return;
                        }
                        e.this.gNE.getPageContext().showToast(e.this.gNE.getResources().getString(a.h.sdk_no_network_guide));
                    }
                });
            }
        }
    };
    b.InterfaceC0625b gOh = new b.InterfaceC0625b() { // from class: com.baidu.tieba.ala.charm.e.2
        @Override // com.baidu.tieba.ala.charm.model.b.InterfaceC0625b
        public void u(long j, int i) {
            e.this.gOc.t(j, i);
        }

        @Override // com.baidu.tieba.ala.charm.model.b.InterfaceC0625b
        public void A(int i, String str) {
            if (TextUtils.isEmpty(str)) {
                BdUtilHelper.showToast(e.this.gNE, e.this.gNE.getString(a.h.sdk_poke_poke_once_fail));
            } else {
                BdUtilHelper.showToast(e.this.gNE, str);
            }
        }
    };
    private String mGroupId;
    private String mLiveId;

    public e(ALaCharmCardActivity aLaCharmCardActivity) {
        this.gNE = aLaCharmCardActivity;
    }

    public void createView() {
        this.gOc = new d(this.gNE, this.mGroupId, this.mLiveId, this.bnF, this.aDB, this.gOe, this.bdi);
        loadData();
    }

    private void loadData() {
        if (this.gOd == null) {
            this.gOd = new com.baidu.tieba.ala.charm.model.b(this.gNE.getPageContext(), this.gOg, this.gOh);
        }
        this.gOd.v(this.mLiveId, 0, 100);
    }

    public void ff(long j) {
        this.gOf = j;
        if (this.gOc != null) {
            this.gOc.ff(j);
        }
    }

    public e Gp(String str) {
        this.mGroupId = str;
        return this;
    }

    public e Gq(String str) {
        this.mLiveId = str;
        return this;
    }

    public e mT(boolean z) {
        this.bnF = z;
        return this;
    }

    public e Gr(String str) {
        this.aDB = str;
        return this;
    }

    public e Gs(String str) {
        this.gOe = str;
        return this;
    }

    public e Gt(String str) {
        this.bdi = str;
        return this;
    }

    @Override // com.baidu.live.liveroom.d.d
    public View getPanelView() {
        if (this.gOc == null) {
            return null;
        }
        return this.gOc.getRootView();
    }

    @Override // com.baidu.live.liveroom.d.d
    public String getTitle() {
        return this.gNE.getResources().getString(a.h.audience_list_title);
    }

    @Override // com.baidu.live.liveroom.d.d
    public String JK() {
        return null;
    }

    @Override // com.baidu.live.liveroom.d.d
    public short JL() {
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
        if (this.gOd != null) {
            this.gOd.onDestroy();
        }
    }

    @Override // com.baidu.live.liveroom.d.d
    public void onChangeSkinType(int i) {
    }
}
