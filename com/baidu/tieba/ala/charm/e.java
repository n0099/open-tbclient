package com.baidu.tieba.ala.charm;

import android.view.View;
import com.baidu.live.adp.lib.util.BdNetTypeUtil;
import com.baidu.live.data.AlaLiveUserInfoData;
import com.baidu.live.data.q;
import com.baidu.live.sdk.a;
import com.baidu.tieba.ala.charm.model.b;
/* loaded from: classes4.dex */
public class e implements com.baidu.live.liveroom.d.d {
    private String aDE;
    private String aZG;
    private boolean bja;
    private ALaCharmCardActivity guT;
    private d gvr;
    private com.baidu.tieba.ala.charm.model.b gvs;
    private String gvt;
    private long gvu;
    b.a gvv = new b.a() { // from class: com.baidu.tieba.ala.charm.e.1
        @Override // com.baidu.tieba.ala.charm.model.b.a
        public void a(long j, q qVar, AlaLiveUserInfoData alaLiveUserInfoData, long j2) {
            if (e.this.gvr != null) {
                e.this.gvr.ew(j);
                if (qVar == null) {
                    e.this.gvr.ds(true);
                    return;
                }
                e.this.gvr.VB();
                e.this.gvr.a(qVar.getList(), alaLiveUserInfoData, j2);
                int size = qVar.getList().size();
                if (size <= 0) {
                    e.this.gvr.ds(true);
                } else if (size < 100) {
                    e.this.gvr.aA(e.this.guT.getPageContext().getResources().getString(a.h.online_no_more), true);
                } else {
                    e.this.gvr.aA(e.this.guT.getPageContext().getResources().getString(a.h.online_show_100), false);
                }
            }
        }

        @Override // com.baidu.tieba.ala.charm.model.b.a
        public void t(int i, String str) {
            if (e.this.gvr != null) {
                e.this.gvr.ds(false);
                e.this.gvr.m(new View.OnClickListener() { // from class: com.baidu.tieba.ala.charm.e.1.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (BdNetTypeUtil.isNetWorkAvailable()) {
                            if (e.this.gvs != null) {
                                e.this.gvs.v(e.this.mLiveId, 0, 0);
                                return;
                            }
                            return;
                        }
                        e.this.guT.getPageContext().showToast(e.this.guT.getResources().getString(a.h.sdk_no_network_guide));
                    }
                });
            }
        }
    };
    private String mGroupId;
    private String mLiveId;

    public e(ALaCharmCardActivity aLaCharmCardActivity) {
        this.guT = aLaCharmCardActivity;
    }

    public void createView() {
        this.gvr = new d(this.guT, this.mGroupId, this.mLiveId, this.bja, this.aDE, this.gvt, this.aZG);
        loadData();
    }

    private void loadData() {
        if (this.gvs == null) {
            this.gvs = new com.baidu.tieba.ala.charm.model.b(this.guT.getPageContext(), this.gvv);
        }
        this.gvs.u(this.mLiveId, 0, 100);
    }

    public void ew(long j) {
        this.gvu = j;
        if (this.gvr != null) {
            this.gvr.ew(j);
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

    public e lY(boolean z) {
        this.bja = z;
        return this;
    }

    public e Gq(String str) {
        this.aDE = str;
        return this;
    }

    public e Gr(String str) {
        this.gvt = str;
        return this;
    }

    public e Gs(String str) {
        this.aZG = str;
        return this;
    }

    @Override // com.baidu.live.liveroom.d.d
    public View getPanelView() {
        if (this.gvr == null) {
            return null;
        }
        return this.gvr.getRootView();
    }

    @Override // com.baidu.live.liveroom.d.d
    public String getTitle() {
        return this.guT.getResources().getString(a.h.audience_list_title);
    }

    @Override // com.baidu.live.liveroom.d.d
    public String KI() {
        return null;
    }

    @Override // com.baidu.live.liveroom.d.d
    public short KJ() {
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
        if (this.gvs != null) {
            this.gvs.onDestroy();
        }
    }

    @Override // com.baidu.live.liveroom.d.d
    public void onChangeSkinType(int i) {
    }
}
