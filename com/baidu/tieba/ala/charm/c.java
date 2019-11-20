package com.baidu.tieba.ala.charm;

import android.view.View;
import com.baidu.live.adp.lib.util.BdNetTypeUtil;
import com.baidu.live.data.e;
import com.baidu.live.k.a;
import com.baidu.tieba.ala.charm.model.b;
/* loaded from: classes6.dex */
public class c implements com.baidu.live.liveroom.c.d {
    private boolean agL;
    private String agM;
    private b dEM;
    private com.baidu.tieba.ala.charm.model.b dEN;
    private long dEO;
    b.a dEP = new b.a() { // from class: com.baidu.tieba.ala.charm.c.1
        @Override // com.baidu.tieba.ala.charm.model.b.a
        public void a(e eVar) {
            if (c.this.dEM != null) {
                if (eVar == null) {
                    c.this.dEM.gN(true);
                    return;
                }
                c.this.dEM.aJm();
                c.this.dEM.bq(eVar.getList());
                int size = eVar.getList().size();
                if (size <= 0) {
                    c.this.dEM.gN(true);
                } else if (size < 100 || (size == 100 && c.this.dEO <= 100)) {
                    c.this.dEM.sO(c.this.dEx.getPageContext().getResources().getString(a.i.online_no_more));
                } else if (size >= 100 && c.this.dEO > 100) {
                    c.this.dEM.sO(c.this.dEx.getPageContext().getResources().getString(a.i.online_show_100));
                }
            }
        }

        @Override // com.baidu.tieba.ala.charm.model.b.a
        public void R(int i, String str) {
            if (c.this.dEM != null) {
                c.this.dEM.gN(false);
                c.this.dEM.l(new View.OnClickListener() { // from class: com.baidu.tieba.ala.charm.c.1.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (BdNetTypeUtil.isNetWorkAvailable()) {
                            if (c.this.dEN != null) {
                                c.this.dEN.r(c.this.mLiveId, 0, 0);
                                return;
                            }
                            return;
                        }
                        c.this.dEx.getPageContext().showToast(c.this.dEx.getResources().getString(a.i.sdk_no_network_guide));
                    }
                });
            }
        }
    };
    private ALaCharmCardActivity dEx;
    private String mGroupId;
    private String mLiveId;

    public c(ALaCharmCardActivity aLaCharmCardActivity) {
        this.dEx = aLaCharmCardActivity;
    }

    public void nw() {
        this.dEM = new b(this.dEx, this.mGroupId, this.mLiveId, this.agL, this.agM);
        loadData();
    }

    private void loadData() {
        if (this.dEN == null) {
            this.dEN = new com.baidu.tieba.ala.charm.model.b(this.dEx.getPageContext(), this.dEP);
        }
        this.dEN.q(this.mLiveId, 0, 100);
    }

    public void bU(long j) {
        this.dEO = j;
        if (this.dEM != null) {
            this.dEM.bU(j);
        }
    }

    public c sP(String str) {
        this.mGroupId = str;
        return this;
    }

    public c sQ(String str) {
        this.mLiveId = str;
        return this;
    }

    public c gO(boolean z) {
        this.agL = z;
        return this;
    }

    public c sR(String str) {
        this.agM = str;
        return this;
    }

    @Override // com.baidu.live.liveroom.c.d
    public View ss() {
        if (this.dEM == null) {
            return null;
        }
        return this.dEM.getRootView();
    }

    @Override // com.baidu.live.liveroom.c.d
    public String getTitle() {
        return this.dEx.getResources().getString(a.i.audience_list_title);
    }

    @Override // com.baidu.live.liveroom.c.d
    public String st() {
        return null;
    }

    @Override // com.baidu.live.liveroom.c.d
    public short su() {
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
        if (this.dEN != null) {
            this.dEN.onDestroy();
        }
    }

    @Override // com.baidu.live.liveroom.c.d
    public void onChangeSkinType(int i) {
    }
}
