package com.baidu.tieba.ala.charm;

import android.view.View;
import com.baidu.live.adp.lib.util.BdNetTypeUtil;
import com.baidu.live.data.h;
import com.baidu.live.u.a;
import com.baidu.tieba.ala.charm.model.b;
/* loaded from: classes3.dex */
public class c implements com.baidu.live.liveroom.d.d {
    private boolean asR;
    private String asS;
    private ALaCharmCardActivity evJ;
    private b evY;
    private com.baidu.tieba.ala.charm.model.b evZ;
    private long ewa;
    b.a ewb = new b.a() { // from class: com.baidu.tieba.ala.charm.c.1
        @Override // com.baidu.tieba.ala.charm.model.b.a
        public void c(h hVar) {
            if (c.this.evY != null) {
                if (hVar == null) {
                    c.this.evY.ij(true);
                    return;
                }
                c.this.evY.bcx();
                c.this.evY.bp(hVar.getList());
                int size = hVar.getList().size();
                if (size <= 0) {
                    c.this.evY.ij(true);
                } else if (size < 100 || (size == 100 && c.this.ewa <= 100)) {
                    c.this.evY.xV(c.this.evJ.getPageContext().getResources().getString(a.i.online_no_more));
                } else if (size >= 100 && c.this.ewa > 100) {
                    c.this.evY.xV(c.this.evJ.getPageContext().getResources().getString(a.i.online_show_100));
                }
            }
        }

        @Override // com.baidu.tieba.ala.charm.model.b.a
        public void ad(int i, String str) {
            if (c.this.evY != null) {
                c.this.evY.ij(false);
                c.this.evY.l(new View.OnClickListener() { // from class: com.baidu.tieba.ala.charm.c.1.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (BdNetTypeUtil.isNetWorkAvailable()) {
                            if (c.this.evZ != null) {
                                c.this.evZ.t(c.this.mLiveId, 0, 0);
                                return;
                            }
                            return;
                        }
                        c.this.evJ.getPageContext().showToast(c.this.evJ.getResources().getString(a.i.sdk_no_network_guide));
                    }
                });
            }
        }
    };
    private String mGroupId;
    private String mLiveId;

    public c(ALaCharmCardActivity aLaCharmCardActivity) {
        this.evJ = aLaCharmCardActivity;
    }

    public void createView() {
        this.evY = new b(this.evJ, this.mGroupId, this.mLiveId, this.asR, this.asS);
        loadData();
    }

    private void loadData() {
        if (this.evZ == null) {
            this.evZ = new com.baidu.tieba.ala.charm.model.b(this.evJ.getPageContext(), this.ewb);
        }
        this.evZ.s(this.mLiveId, 0, 100);
    }

    public void cD(long j) {
        this.ewa = j;
        if (this.evY != null) {
            this.evY.cD(j);
        }
    }

    public c xW(String str) {
        this.mGroupId = str;
        return this;
    }

    public c xX(String str) {
        this.mLiveId = str;
        return this;
    }

    public c ik(boolean z) {
        this.asR = z;
        return this;
    }

    public c xY(String str) {
        this.asS = str;
        return this;
    }

    @Override // com.baidu.live.liveroom.d.d
    public View we() {
        if (this.evY == null) {
            return null;
        }
        return this.evY.getRootView();
    }

    @Override // com.baidu.live.liveroom.d.d
    public String getTitle() {
        return this.evJ.getResources().getString(a.i.audience_list_title);
    }

    @Override // com.baidu.live.liveroom.d.d
    public String wf() {
        return null;
    }

    @Override // com.baidu.live.liveroom.d.d
    public short wg() {
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
        if (this.evZ != null) {
            this.evZ.onDestroy();
        }
    }

    @Override // com.baidu.live.liveroom.d.d
    public void onChangeSkinType(int i) {
    }
}
