package com.baidu.tieba.ala.charm;

import android.view.View;
import com.baidu.live.adp.lib.util.BdNetTypeUtil;
import com.baidu.live.data.g;
import com.baidu.live.q.a;
import com.baidu.tieba.ala.charm.model.b;
/* loaded from: classes2.dex */
public class c implements com.baidu.live.liveroom.c.d {
    private boolean aoM;
    private String aoN;
    private b eqA;
    private com.baidu.tieba.ala.charm.model.b eqB;
    private long eqC;
    b.a eqD = new b.a() { // from class: com.baidu.tieba.ala.charm.c.1
        @Override // com.baidu.tieba.ala.charm.model.b.a
        public void b(g gVar) {
            if (c.this.eqA != null) {
                if (gVar == null) {
                    c.this.eqA.hS(true);
                    return;
                }
                c.this.eqA.aZK();
                c.this.eqA.bp(gVar.getList());
                int size = gVar.getList().size();
                if (size <= 0) {
                    c.this.eqA.hS(true);
                } else if (size < 100 || (size == 100 && c.this.eqC <= 100)) {
                    c.this.eqA.xw(c.this.eql.getPageContext().getResources().getString(a.i.online_no_more));
                } else if (size >= 100 && c.this.eqC > 100) {
                    c.this.eqA.xw(c.this.eql.getPageContext().getResources().getString(a.i.online_show_100));
                }
            }
        }

        @Override // com.baidu.tieba.ala.charm.model.b.a
        public void aa(int i, String str) {
            if (c.this.eqA != null) {
                c.this.eqA.hS(false);
                c.this.eqA.m(new View.OnClickListener() { // from class: com.baidu.tieba.ala.charm.c.1.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (BdNetTypeUtil.isNetWorkAvailable()) {
                            if (c.this.eqB != null) {
                                c.this.eqB.t(c.this.mLiveId, 0, 0);
                                return;
                            }
                            return;
                        }
                        c.this.eql.getPageContext().showToast(c.this.eql.getResources().getString(a.i.sdk_no_network_guide));
                    }
                });
            }
        }
    };
    private ALaCharmCardActivity eql;
    private String mGroupId;
    private String mLiveId;

    public c(ALaCharmCardActivity aLaCharmCardActivity) {
        this.eql = aLaCharmCardActivity;
    }

    public void createView() {
        this.eqA = new b(this.eql, this.mGroupId, this.mLiveId, this.aoM, this.aoN);
        loadData();
    }

    private void loadData() {
        if (this.eqB == null) {
            this.eqB = new com.baidu.tieba.ala.charm.model.b(this.eql.getPageContext(), this.eqD);
        }
        this.eqB.s(this.mLiveId, 0, 100);
    }

    public void cv(long j) {
        this.eqC = j;
        if (this.eqA != null) {
            this.eqA.cv(j);
        }
    }

    public c xx(String str) {
        this.mGroupId = str;
        return this;
    }

    public c xy(String str) {
        this.mLiveId = str;
        return this;
    }

    public c hT(boolean z) {
        this.aoM = z;
        return this;
    }

    public c xz(String str) {
        this.aoN = str;
        return this;
    }

    @Override // com.baidu.live.liveroom.c.d
    public View uj() {
        if (this.eqA == null) {
            return null;
        }
        return this.eqA.getRootView();
    }

    @Override // com.baidu.live.liveroom.c.d
    public String getTitle() {
        return this.eql.getResources().getString(a.i.audience_list_title);
    }

    @Override // com.baidu.live.liveroom.c.d
    public String uk() {
        return null;
    }

    @Override // com.baidu.live.liveroom.c.d
    public short ul() {
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
        if (this.eqB != null) {
            this.eqB.onDestroy();
        }
    }

    @Override // com.baidu.live.liveroom.c.d
    public void onChangeSkinType(int i) {
    }
}
