package com.baidu.tieba.ala.charm;

import android.view.View;
import com.baidu.live.adp.lib.util.BdNetTypeUtil;
import com.baidu.live.data.AlaLiveUserInfoData;
import com.baidu.live.data.k;
import com.baidu.live.u.a;
import com.baidu.tieba.ala.charm.model.b;
/* loaded from: classes3.dex */
public class e implements com.baidu.live.liveroom.d.d {
    private boolean aSw;
    private String aSx;
    private ALaCharmCardActivity fnR;
    private String fol;
    private d foq;

    /* renamed from: for  reason: not valid java name */
    private com.baidu.tieba.ala.charm.model.b f3for;
    private String fos;
    private long fot;
    b.a fou = new b.a() { // from class: com.baidu.tieba.ala.charm.e.1
        @Override // com.baidu.tieba.ala.charm.model.b.a
        public void a(long j, k kVar, AlaLiveUserInfoData alaLiveUserInfoData, long j2) {
            if (e.this.foq != null) {
                e.this.foq.dm(j);
                if (kVar == null) {
                    e.this.foq.jF(true);
                    return;
                }
                e.this.foq.bqO();
                e.this.foq.a(kVar.getList(), alaLiveUserInfoData, j2);
                int size = kVar.getList().size();
                if (size <= 0) {
                    e.this.foq.jF(true);
                } else if (size < 100) {
                    e.this.foq.aq(e.this.fnR.getPageContext().getResources().getString(a.i.online_no_more), true);
                } else {
                    e.this.foq.aq(e.this.fnR.getPageContext().getResources().getString(a.i.online_show_100), false);
                }
            }
        }

        @Override // com.baidu.tieba.ala.charm.model.b.a
        public void ax(int i, String str) {
            if (e.this.foq != null) {
                e.this.foq.jF(false);
                e.this.foq.k(new View.OnClickListener() { // from class: com.baidu.tieba.ala.charm.e.1.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (BdNetTypeUtil.isNetWorkAvailable()) {
                            if (e.this.f3for != null) {
                                e.this.f3for.v(e.this.mLiveId, 0, 0);
                                return;
                            }
                            return;
                        }
                        e.this.fnR.getPageContext().showToast(e.this.fnR.getResources().getString(a.i.sdk_no_network_guide));
                    }
                });
            }
        }
    };
    private String mGroupId;
    private String mLiveId;

    public e(ALaCharmCardActivity aLaCharmCardActivity) {
        this.fnR = aLaCharmCardActivity;
    }

    public void createView() {
        this.foq = new d(this.fnR, this.mGroupId, this.mLiveId, this.aSw, this.aSx, this.fos, this.fol);
        loadData();
    }

    private void loadData() {
        if (this.f3for == null) {
            this.f3for = new com.baidu.tieba.ala.charm.model.b(this.fnR.getPageContext(), this.fou);
        }
        this.f3for.u(this.mLiveId, 0, 100);
    }

    public void dm(long j) {
        this.fot = j;
        if (this.foq != null) {
            this.foq.dm(j);
        }
    }

    public e Bn(String str) {
        this.mGroupId = str;
        return this;
    }

    public e Bo(String str) {
        this.mLiveId = str;
        return this;
    }

    public e jG(boolean z) {
        this.aSw = z;
        return this;
    }

    public e Bp(String str) {
        this.aSx = str;
        return this;
    }

    public e Bq(String str) {
        this.fos = str;
        return this;
    }

    public e Br(String str) {
        this.fol = str;
        return this;
    }

    @Override // com.baidu.live.liveroom.d.d
    public View getPanelView() {
        if (this.foq == null) {
            return null;
        }
        return this.foq.getRootView();
    }

    @Override // com.baidu.live.liveroom.d.d
    public String getTitle() {
        return this.fnR.getResources().getString(a.i.audience_list_title);
    }

    @Override // com.baidu.live.liveroom.d.d
    public String Ci() {
        return null;
    }

    @Override // com.baidu.live.liveroom.d.d
    public short Cj() {
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
        if (this.f3for != null) {
            this.f3for.onDestroy();
        }
    }

    @Override // com.baidu.live.liveroom.d.d
    public void onChangeSkinType(int i) {
    }
}
