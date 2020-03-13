package com.baidu.tieba.ala.charm;

import android.view.View;
import com.baidu.live.adp.lib.util.BdNetTypeUtil;
import com.baidu.live.data.h;
import com.baidu.live.u.a;
import com.baidu.tieba.ala.charm.model.b;
/* loaded from: classes3.dex */
public class c implements com.baidu.live.liveroom.d.d {
    private boolean asS;
    private String asT;
    private ALaCharmCardActivity evW;
    private b ewl;
    private com.baidu.tieba.ala.charm.model.b ewm;
    private long ewn;
    b.a ewo = new b.a() { // from class: com.baidu.tieba.ala.charm.c.1
        @Override // com.baidu.tieba.ala.charm.model.b.a
        public void c(h hVar) {
            if (c.this.ewl != null) {
                if (hVar == null) {
                    c.this.ewl.ij(true);
                    return;
                }
                c.this.ewl.bcy();
                c.this.ewl.bp(hVar.getList());
                int size = hVar.getList().size();
                if (size <= 0) {
                    c.this.ewl.ij(true);
                } else if (size < 100 || (size == 100 && c.this.ewn <= 100)) {
                    c.this.ewl.xW(c.this.evW.getPageContext().getResources().getString(a.i.online_no_more));
                } else if (size >= 100 && c.this.ewn > 100) {
                    c.this.ewl.xW(c.this.evW.getPageContext().getResources().getString(a.i.online_show_100));
                }
            }
        }

        @Override // com.baidu.tieba.ala.charm.model.b.a
        public void ad(int i, String str) {
            if (c.this.ewl != null) {
                c.this.ewl.ij(false);
                c.this.ewl.l(new View.OnClickListener() { // from class: com.baidu.tieba.ala.charm.c.1.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (BdNetTypeUtil.isNetWorkAvailable()) {
                            if (c.this.ewm != null) {
                                c.this.ewm.t(c.this.mLiveId, 0, 0);
                                return;
                            }
                            return;
                        }
                        c.this.evW.getPageContext().showToast(c.this.evW.getResources().getString(a.i.sdk_no_network_guide));
                    }
                });
            }
        }
    };
    private String mGroupId;
    private String mLiveId;

    public c(ALaCharmCardActivity aLaCharmCardActivity) {
        this.evW = aLaCharmCardActivity;
    }

    public void createView() {
        this.ewl = new b(this.evW, this.mGroupId, this.mLiveId, this.asS, this.asT);
        loadData();
    }

    private void loadData() {
        if (this.ewm == null) {
            this.ewm = new com.baidu.tieba.ala.charm.model.b(this.evW.getPageContext(), this.ewo);
        }
        this.ewm.s(this.mLiveId, 0, 100);
    }

    public void cD(long j) {
        this.ewn = j;
        if (this.ewl != null) {
            this.ewl.cD(j);
        }
    }

    public c xX(String str) {
        this.mGroupId = str;
        return this;
    }

    public c xY(String str) {
        this.mLiveId = str;
        return this;
    }

    public c ik(boolean z) {
        this.asS = z;
        return this;
    }

    public c xZ(String str) {
        this.asT = str;
        return this;
    }

    @Override // com.baidu.live.liveroom.d.d
    public View we() {
        if (this.ewl == null) {
            return null;
        }
        return this.ewl.getRootView();
    }

    @Override // com.baidu.live.liveroom.d.d
    public String getTitle() {
        return this.evW.getResources().getString(a.i.audience_list_title);
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
        if (this.ewm != null) {
            this.ewm.onDestroy();
        }
    }

    @Override // com.baidu.live.liveroom.d.d
    public void onChangeSkinType(int i) {
    }
}
