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
    private ALaCharmCardActivity evI;
    private b evX;
    private com.baidu.tieba.ala.charm.model.b evY;
    private long evZ;
    b.a ewa = new b.a() { // from class: com.baidu.tieba.ala.charm.c.1
        @Override // com.baidu.tieba.ala.charm.model.b.a
        public void c(h hVar) {
            if (c.this.evX != null) {
                if (hVar == null) {
                    c.this.evX.ij(true);
                    return;
                }
                c.this.evX.bcv();
                c.this.evX.bp(hVar.getList());
                int size = hVar.getList().size();
                if (size <= 0) {
                    c.this.evX.ij(true);
                } else if (size < 100 || (size == 100 && c.this.evZ <= 100)) {
                    c.this.evX.xV(c.this.evI.getPageContext().getResources().getString(a.i.online_no_more));
                } else if (size >= 100 && c.this.evZ > 100) {
                    c.this.evX.xV(c.this.evI.getPageContext().getResources().getString(a.i.online_show_100));
                }
            }
        }

        @Override // com.baidu.tieba.ala.charm.model.b.a
        public void ad(int i, String str) {
            if (c.this.evX != null) {
                c.this.evX.ij(false);
                c.this.evX.l(new View.OnClickListener() { // from class: com.baidu.tieba.ala.charm.c.1.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (BdNetTypeUtil.isNetWorkAvailable()) {
                            if (c.this.evY != null) {
                                c.this.evY.t(c.this.mLiveId, 0, 0);
                                return;
                            }
                            return;
                        }
                        c.this.evI.getPageContext().showToast(c.this.evI.getResources().getString(a.i.sdk_no_network_guide));
                    }
                });
            }
        }
    };
    private String mGroupId;
    private String mLiveId;

    public c(ALaCharmCardActivity aLaCharmCardActivity) {
        this.evI = aLaCharmCardActivity;
    }

    public void createView() {
        this.evX = new b(this.evI, this.mGroupId, this.mLiveId, this.asR, this.asS);
        loadData();
    }

    private void loadData() {
        if (this.evY == null) {
            this.evY = new com.baidu.tieba.ala.charm.model.b(this.evI.getPageContext(), this.ewa);
        }
        this.evY.s(this.mLiveId, 0, 100);
    }

    public void cD(long j) {
        this.evZ = j;
        if (this.evX != null) {
            this.evX.cD(j);
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
        if (this.evX == null) {
            return null;
        }
        return this.evX.getRootView();
    }

    @Override // com.baidu.live.liveroom.d.d
    public String getTitle() {
        return this.evI.getResources().getString(a.i.audience_list_title);
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
        if (this.evY != null) {
            this.evY.onDestroy();
        }
    }

    @Override // com.baidu.live.liveroom.d.d
    public void onChangeSkinType(int i) {
    }
}
