package com.baidu.tieba.ala.charm;

import android.view.View;
import com.baidu.live.adp.lib.util.BdNetTypeUtil;
import com.baidu.live.data.h;
import com.baidu.live.u.a;
import com.baidu.tieba.ala.charm.model.b;
/* loaded from: classes3.dex */
public class c implements com.baidu.live.liveroom.d.d {
    private boolean atc;
    private String atd;
    private b ewH;
    private com.baidu.tieba.ala.charm.model.b ewI;
    private long ewJ;
    b.a ewK = new b.a() { // from class: com.baidu.tieba.ala.charm.c.1
        @Override // com.baidu.tieba.ala.charm.model.b.a
        public void c(h hVar) {
            if (c.this.ewH != null) {
                if (hVar == null) {
                    c.this.ewH.il(true);
                    return;
                }
                c.this.ewH.bcC();
                c.this.ewH.bp(hVar.getList());
                int size = hVar.getList().size();
                if (size <= 0) {
                    c.this.ewH.il(true);
                } else if (size < 100 || (size == 100 && c.this.ewJ <= 100)) {
                    c.this.ewH.xX(c.this.ews.getPageContext().getResources().getString(a.i.online_no_more));
                } else if (size >= 100 && c.this.ewJ > 100) {
                    c.this.ewH.xX(c.this.ews.getPageContext().getResources().getString(a.i.online_show_100));
                }
            }
        }

        @Override // com.baidu.tieba.ala.charm.model.b.a
        public void ad(int i, String str) {
            if (c.this.ewH != null) {
                c.this.ewH.il(false);
                c.this.ewH.l(new View.OnClickListener() { // from class: com.baidu.tieba.ala.charm.c.1.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (BdNetTypeUtil.isNetWorkAvailable()) {
                            if (c.this.ewI != null) {
                                c.this.ewI.t(c.this.mLiveId, 0, 0);
                                return;
                            }
                            return;
                        }
                        c.this.ews.getPageContext().showToast(c.this.ews.getResources().getString(a.i.sdk_no_network_guide));
                    }
                });
            }
        }
    };
    private ALaCharmCardActivity ews;
    private String mGroupId;
    private String mLiveId;

    public c(ALaCharmCardActivity aLaCharmCardActivity) {
        this.ews = aLaCharmCardActivity;
    }

    public void createView() {
        this.ewH = new b(this.ews, this.mGroupId, this.mLiveId, this.atc, this.atd);
        loadData();
    }

    private void loadData() {
        if (this.ewI == null) {
            this.ewI = new com.baidu.tieba.ala.charm.model.b(this.ews.getPageContext(), this.ewK);
        }
        this.ewI.s(this.mLiveId, 0, 100);
    }

    public void cD(long j) {
        this.ewJ = j;
        if (this.ewH != null) {
            this.ewH.cD(j);
        }
    }

    public c xY(String str) {
        this.mGroupId = str;
        return this;
    }

    public c xZ(String str) {
        this.mLiveId = str;
        return this;
    }

    public c im(boolean z) {
        this.atc = z;
        return this;
    }

    public c ya(String str) {
        this.atd = str;
        return this;
    }

    @Override // com.baidu.live.liveroom.d.d
    public View wj() {
        if (this.ewH == null) {
            return null;
        }
        return this.ewH.getRootView();
    }

    @Override // com.baidu.live.liveroom.d.d
    public String getTitle() {
        return this.ews.getResources().getString(a.i.audience_list_title);
    }

    @Override // com.baidu.live.liveroom.d.d
    public String wk() {
        return null;
    }

    @Override // com.baidu.live.liveroom.d.d
    public short wl() {
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
        if (this.ewI != null) {
            this.ewI.onDestroy();
        }
    }

    @Override // com.baidu.live.liveroom.d.d
    public void onChangeSkinType(int i) {
    }
}
