package com.baidu.tieba.ala.charm;

import android.view.View;
import com.baidu.live.adp.lib.util.BdNetTypeUtil;
import com.baidu.live.data.e;
import com.baidu.live.k.a;
import com.baidu.tieba.ala.charm.model.b;
/* loaded from: classes6.dex */
public class c implements com.baidu.live.liveroom.c.d {
    private boolean ahd;
    private String ahe;
    private b dFD;
    private com.baidu.tieba.ala.charm.model.b dFE;
    private long dFF;
    b.a dFG = new b.a() { // from class: com.baidu.tieba.ala.charm.c.1
        @Override // com.baidu.tieba.ala.charm.model.b.a
        public void a(e eVar) {
            if (c.this.dFD != null) {
                if (eVar == null) {
                    c.this.dFD.gN(true);
                    return;
                }
                c.this.dFD.aJo();
                c.this.dFD.bq(eVar.getList());
                int size = eVar.getList().size();
                if (size <= 0) {
                    c.this.dFD.gN(true);
                } else if (size < 100 || (size == 100 && c.this.dFF <= 100)) {
                    c.this.dFD.sO(c.this.dFo.getPageContext().getResources().getString(a.i.online_no_more));
                } else if (size >= 100 && c.this.dFF > 100) {
                    c.this.dFD.sO(c.this.dFo.getPageContext().getResources().getString(a.i.online_show_100));
                }
            }
        }

        @Override // com.baidu.tieba.ala.charm.model.b.a
        public void S(int i, String str) {
            if (c.this.dFD != null) {
                c.this.dFD.gN(false);
                c.this.dFD.l(new View.OnClickListener() { // from class: com.baidu.tieba.ala.charm.c.1.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (BdNetTypeUtil.isNetWorkAvailable()) {
                            if (c.this.dFE != null) {
                                c.this.dFE.r(c.this.mLiveId, 0, 0);
                                return;
                            }
                            return;
                        }
                        c.this.dFo.getPageContext().showToast(c.this.dFo.getResources().getString(a.i.sdk_no_network_guide));
                    }
                });
            }
        }
    };
    private ALaCharmCardActivity dFo;
    private String mGroupId;
    private String mLiveId;

    public c(ALaCharmCardActivity aLaCharmCardActivity) {
        this.dFo = aLaCharmCardActivity;
    }

    public void nw() {
        this.dFD = new b(this.dFo, this.mGroupId, this.mLiveId, this.ahd, this.ahe);
        loadData();
    }

    private void loadData() {
        if (this.dFE == null) {
            this.dFE = new com.baidu.tieba.ala.charm.model.b(this.dFo.getPageContext(), this.dFG);
        }
        this.dFE.q(this.mLiveId, 0, 100);
    }

    public void bV(long j) {
        this.dFF = j;
        if (this.dFD != null) {
            this.dFD.bV(j);
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
        this.ahd = z;
        return this;
    }

    public c sR(String str) {
        this.ahe = str;
        return this;
    }

    @Override // com.baidu.live.liveroom.c.d
    public View sr() {
        if (this.dFD == null) {
            return null;
        }
        return this.dFD.getRootView();
    }

    @Override // com.baidu.live.liveroom.c.d
    public String getTitle() {
        return this.dFo.getResources().getString(a.i.audience_list_title);
    }

    @Override // com.baidu.live.liveroom.c.d
    public String ss() {
        return null;
    }

    @Override // com.baidu.live.liveroom.c.d
    public short st() {
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
        if (this.dFE != null) {
            this.dFE.onDestroy();
        }
    }

    @Override // com.baidu.live.liveroom.c.d
    public void onChangeSkinType(int i) {
    }
}
