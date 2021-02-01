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
    private d gNO;
    private com.baidu.tieba.ala.charm.model.b gNP;
    private String gNQ;
    private long gNR;
    b.a gNS = new b.a() { // from class: com.baidu.tieba.ala.charm.e.1
        @Override // com.baidu.tieba.ala.charm.model.b.a
        public void a(long j, v vVar, AlaLiveUserInfoData alaLiveUserInfoData, long j2) {
            if (e.this.gNO != null) {
                e.this.gNO.ff(j);
                if (vVar == null) {
                    e.this.gNO.dQ(true);
                    return;
                }
                e.this.gNO.WZ();
                e.this.gNO.a(vVar.getList(), alaLiveUserInfoData, j2);
                int size = vVar.getList().size();
                if (size <= 0) {
                    e.this.gNO.dQ(true);
                } else if (size < 100) {
                    e.this.gNO.aB(e.this.gNq.getPageContext().getResources().getString(a.h.online_no_more), true);
                } else {
                    e.this.gNO.aB(e.this.gNq.getPageContext().getResources().getString(a.h.online_show_100), false);
                }
            }
        }

        @Override // com.baidu.tieba.ala.charm.model.b.a
        public void A(int i, String str) {
            if (e.this.gNO != null) {
                e.this.gNO.dQ(false);
                e.this.gNO.n(new View.OnClickListener() { // from class: com.baidu.tieba.ala.charm.e.1.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (BdNetTypeUtil.isNetWorkAvailable()) {
                            if (e.this.gNP != null) {
                                e.this.gNP.w(e.this.mLiveId, 0, 0);
                                return;
                            }
                            return;
                        }
                        e.this.gNq.getPageContext().showToast(e.this.gNq.getResources().getString(a.h.sdk_no_network_guide));
                    }
                });
            }
        }
    };
    b.InterfaceC0624b gNT = new b.InterfaceC0624b() { // from class: com.baidu.tieba.ala.charm.e.2
        @Override // com.baidu.tieba.ala.charm.model.b.InterfaceC0624b
        public void u(long j, int i) {
            e.this.gNO.t(j, i);
        }

        @Override // com.baidu.tieba.ala.charm.model.b.InterfaceC0624b
        public void A(int i, String str) {
            if (TextUtils.isEmpty(str)) {
                BdUtilHelper.showToast(e.this.gNq, e.this.gNq.getString(a.h.sdk_poke_poke_once_fail));
            } else {
                BdUtilHelper.showToast(e.this.gNq, str);
            }
        }
    };
    private ALaCharmCardActivity gNq;
    private String mGroupId;
    private String mLiveId;

    public e(ALaCharmCardActivity aLaCharmCardActivity) {
        this.gNq = aLaCharmCardActivity;
    }

    public void createView() {
        this.gNO = new d(this.gNq, this.mGroupId, this.mLiveId, this.bnF, this.aDB, this.gNQ, this.bdi);
        loadData();
    }

    private void loadData() {
        if (this.gNP == null) {
            this.gNP = new com.baidu.tieba.ala.charm.model.b(this.gNq.getPageContext(), this.gNS, this.gNT);
        }
        this.gNP.v(this.mLiveId, 0, 100);
    }

    public void ff(long j) {
        this.gNR = j;
        if (this.gNO != null) {
            this.gNO.ff(j);
        }
    }

    public e Go(String str) {
        this.mGroupId = str;
        return this;
    }

    public e Gp(String str) {
        this.mLiveId = str;
        return this;
    }

    public e mT(boolean z) {
        this.bnF = z;
        return this;
    }

    public e Gq(String str) {
        this.aDB = str;
        return this;
    }

    public e Gr(String str) {
        this.gNQ = str;
        return this;
    }

    public e Gs(String str) {
        this.bdi = str;
        return this;
    }

    @Override // com.baidu.live.liveroom.d.d
    public View getPanelView() {
        if (this.gNO == null) {
            return null;
        }
        return this.gNO.getRootView();
    }

    @Override // com.baidu.live.liveroom.d.d
    public String getTitle() {
        return this.gNq.getResources().getString(a.h.audience_list_title);
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
        if (this.gNP != null) {
            this.gNP.onDestroy();
        }
    }

    @Override // com.baidu.live.liveroom.d.d
    public void onChangeSkinType(int i) {
    }
}
