package com.baidu.tieba.ala.charm;

import android.text.TextUtils;
import android.view.View;
import com.baidu.live.adp.lib.util.BdNetTypeUtil;
import com.baidu.live.adp.lib.util.BdUtilHelper;
import com.baidu.live.data.AlaLiveUserInfoData;
import com.baidu.live.data.r;
import com.baidu.live.sdk.a;
import com.baidu.tieba.ala.charm.model.b;
/* loaded from: classes11.dex */
public class e implements com.baidu.live.liveroom.d.d {
    private String aGB;
    private String beR;
    private boolean boZ;
    private d gPO;
    private com.baidu.tieba.ala.charm.model.b gPP;
    private String gPQ;
    private long gPR;
    b.a gPS = new b.a() { // from class: com.baidu.tieba.ala.charm.e.1
        @Override // com.baidu.tieba.ala.charm.model.b.a
        public void a(long j, r rVar, AlaLiveUserInfoData alaLiveUserInfoData, long j2) {
            if (e.this.gPO != null) {
                e.this.gPO.eZ(j);
                if (rVar == null) {
                    e.this.gPO.dM(true);
                    return;
                }
                e.this.gPO.Zi();
                e.this.gPO.a(rVar.getList(), alaLiveUserInfoData, j2);
                int size = rVar.getList().size();
                if (size <= 0) {
                    e.this.gPO.dM(true);
                } else if (size < 100) {
                    e.this.gPO.aC(e.this.gPq.getPageContext().getResources().getString(a.h.online_no_more), true);
                } else {
                    e.this.gPO.aC(e.this.gPq.getPageContext().getResources().getString(a.h.online_show_100), false);
                }
            }
        }

        @Override // com.baidu.tieba.ala.charm.model.b.a
        public void v(int i, String str) {
            if (e.this.gPO != null) {
                e.this.gPO.dM(false);
                e.this.gPO.n(new View.OnClickListener() { // from class: com.baidu.tieba.ala.charm.e.1.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (BdNetTypeUtil.isNetWorkAvailable()) {
                            if (e.this.gPP != null) {
                                e.this.gPP.w(e.this.mLiveId, 0, 0);
                                return;
                            }
                            return;
                        }
                        e.this.gPq.getPageContext().showToast(e.this.gPq.getResources().getString(a.h.sdk_no_network_guide));
                    }
                });
            }
        }
    };
    b.InterfaceC0642b gPT = new b.InterfaceC0642b() { // from class: com.baidu.tieba.ala.charm.e.2
        @Override // com.baidu.tieba.ala.charm.model.b.InterfaceC0642b
        public void u(long j, int i) {
            e.this.gPO.t(j, i);
        }

        @Override // com.baidu.tieba.ala.charm.model.b.InterfaceC0642b
        public void v(int i, String str) {
            if (TextUtils.isEmpty(str)) {
                BdUtilHelper.showToast(e.this.gPq, e.this.gPq.getString(a.h.sdk_poke_poke_once_fail));
            } else {
                BdUtilHelper.showToast(e.this.gPq, str);
            }
        }
    };
    private ALaCharmCardActivity gPq;
    private String mGroupId;
    private String mLiveId;

    public e(ALaCharmCardActivity aLaCharmCardActivity) {
        this.gPq = aLaCharmCardActivity;
    }

    public void createView() {
        this.gPO = new d(this.gPq, this.mGroupId, this.mLiveId, this.boZ, this.aGB, this.gPQ, this.beR);
        loadData();
    }

    private void loadData() {
        if (this.gPP == null) {
            this.gPP = new com.baidu.tieba.ala.charm.model.b(this.gPq.getPageContext(), this.gPS, this.gPT);
        }
        this.gPP.v(this.mLiveId, 0, 100);
    }

    public void eZ(long j) {
        this.gPR = j;
        if (this.gPO != null) {
            this.gPO.eZ(j);
        }
    }

    public e Hb(String str) {
        this.mGroupId = str;
        return this;
    }

    public e Hc(String str) {
        this.mLiveId = str;
        return this;
    }

    public e mT(boolean z) {
        this.boZ = z;
        return this;
    }

    public e Hd(String str) {
        this.aGB = str;
        return this;
    }

    public e He(String str) {
        this.gPQ = str;
        return this;
    }

    public e Hf(String str) {
        this.beR = str;
        return this;
    }

    @Override // com.baidu.live.liveroom.d.d
    public View getPanelView() {
        if (this.gPO == null) {
            return null;
        }
        return this.gPO.getRootView();
    }

    @Override // com.baidu.live.liveroom.d.d
    public String getTitle() {
        return this.gPq.getResources().getString(a.h.audience_list_title);
    }

    @Override // com.baidu.live.liveroom.d.d
    public String Mh() {
        return null;
    }

    @Override // com.baidu.live.liveroom.d.d
    public short Mi() {
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
        if (this.gPP != null) {
            this.gPP.onDestroy();
        }
    }

    @Override // com.baidu.live.liveroom.d.d
    public void onChangeSkinType(int i) {
    }
}
