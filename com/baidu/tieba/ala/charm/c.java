package com.baidu.tieba.ala.charm;

import android.view.View;
import com.baidu.live.adp.lib.util.BdNetTypeUtil;
import com.baidu.live.data.g;
import com.baidu.live.r.a;
import com.baidu.tieba.ala.charm.model.b;
/* loaded from: classes2.dex */
public class c implements com.baidu.live.liveroom.c.d {
    private String apA;
    private boolean apz;
    private b erN;
    private com.baidu.tieba.ala.charm.model.b erO;
    private long erP;
    b.a erQ = new b.a() { // from class: com.baidu.tieba.ala.charm.c.1
        @Override // com.baidu.tieba.ala.charm.model.b.a
        public void b(g gVar) {
            if (c.this.erN != null) {
                if (gVar == null) {
                    c.this.erN.ic(true);
                    return;
                }
                c.this.erN.baf();
                c.this.erN.bp(gVar.getList());
                int size = gVar.getList().size();
                if (size <= 0) {
                    c.this.erN.ic(true);
                } else if (size < 100 || (size == 100 && c.this.erP <= 100)) {
                    c.this.erN.xB(c.this.ery.getPageContext().getResources().getString(a.i.online_no_more));
                } else if (size >= 100 && c.this.erP > 100) {
                    c.this.erN.xB(c.this.ery.getPageContext().getResources().getString(a.i.online_show_100));
                }
            }
        }

        @Override // com.baidu.tieba.ala.charm.model.b.a
        public void ac(int i, String str) {
            if (c.this.erN != null) {
                c.this.erN.ic(false);
                c.this.erN.l(new View.OnClickListener() { // from class: com.baidu.tieba.ala.charm.c.1.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (BdNetTypeUtil.isNetWorkAvailable()) {
                            if (c.this.erO != null) {
                                c.this.erO.t(c.this.mLiveId, 0, 0);
                                return;
                            }
                            return;
                        }
                        c.this.ery.getPageContext().showToast(c.this.ery.getResources().getString(a.i.sdk_no_network_guide));
                    }
                });
            }
        }
    };
    private ALaCharmCardActivity ery;
    private String mGroupId;
    private String mLiveId;

    public c(ALaCharmCardActivity aLaCharmCardActivity) {
        this.ery = aLaCharmCardActivity;
    }

    public void createView() {
        this.erN = new b(this.ery, this.mGroupId, this.mLiveId, this.apz, this.apA);
        loadData();
    }

    private void loadData() {
        if (this.erO == null) {
            this.erO = new com.baidu.tieba.ala.charm.model.b(this.ery.getPageContext(), this.erQ);
        }
        this.erO.s(this.mLiveId, 0, 100);
    }

    public void cA(long j) {
        this.erP = j;
        if (this.erN != null) {
            this.erN.cA(j);
        }
    }

    public c xC(String str) {
        this.mGroupId = str;
        return this;
    }

    public c xD(String str) {
        this.mLiveId = str;
        return this;
    }

    public c id(boolean z) {
        this.apz = z;
        return this;
    }

    public c xE(String str) {
        this.apA = str;
        return this;
    }

    @Override // com.baidu.live.liveroom.c.d
    public View uA() {
        if (this.erN == null) {
            return null;
        }
        return this.erN.getRootView();
    }

    @Override // com.baidu.live.liveroom.c.d
    public String getTitle() {
        return this.ery.getResources().getString(a.i.audience_list_title);
    }

    @Override // com.baidu.live.liveroom.c.d
    public String uB() {
        return null;
    }

    @Override // com.baidu.live.liveroom.c.d
    public short uC() {
        return (short) 0;
    }

    @Override // com.baidu.live.liveroom.c.d
    public void enterBackground() {
    }

    @Override // com.baidu.live.liveroom.c.d
    public void enterForeground() {
    }

    @Override // com.baidu.live.liveroom.c.d
    public void onDestroy() {
        if (this.erO != null) {
            this.erO.onDestroy();
        }
    }

    @Override // com.baidu.live.liveroom.c.d
    public void onChangeSkinType(int i) {
    }
}
