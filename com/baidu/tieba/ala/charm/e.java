package com.baidu.tieba.ala.charm;

import android.view.View;
import com.baidu.live.adp.lib.util.BdNetTypeUtil;
import com.baidu.live.data.AlaLiveUserInfoData;
import com.baidu.live.data.q;
import com.baidu.live.sdk.a;
import com.baidu.tieba.ala.charm.model.b;
/* loaded from: classes4.dex */
public class e implements com.baidu.live.liveroom.d.d {
    private String aFp;
    private String bbs;
    private boolean bkL;
    private d gvK;
    private com.baidu.tieba.ala.charm.model.b gvL;
    private String gvM;
    private long gvN;
    b.a gvO = new b.a() { // from class: com.baidu.tieba.ala.charm.e.1
        @Override // com.baidu.tieba.ala.charm.model.b.a
        public void a(long j, q qVar, AlaLiveUserInfoData alaLiveUserInfoData, long j2) {
            if (e.this.gvK != null) {
                e.this.gvK.ew(j);
                if (qVar == null) {
                    e.this.gvK.dq(true);
                    return;
                }
                e.this.gvK.Wk();
                e.this.gvK.a(qVar.getList(), alaLiveUserInfoData, j2);
                int size = qVar.getList().size();
                if (size <= 0) {
                    e.this.gvK.dq(true);
                } else if (size < 100) {
                    e.this.gvK.aA(e.this.gvm.getPageContext().getResources().getString(a.h.online_no_more), true);
                } else {
                    e.this.gvK.aA(e.this.gvm.getPageContext().getResources().getString(a.h.online_show_100), false);
                }
            }
        }

        @Override // com.baidu.tieba.ala.charm.model.b.a
        public void t(int i, String str) {
            if (e.this.gvK != null) {
                e.this.gvK.dq(false);
                e.this.gvK.m(new View.OnClickListener() { // from class: com.baidu.tieba.ala.charm.e.1.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (BdNetTypeUtil.isNetWorkAvailable()) {
                            if (e.this.gvL != null) {
                                e.this.gvL.v(e.this.mLiveId, 0, 0);
                                return;
                            }
                            return;
                        }
                        e.this.gvm.getPageContext().showToast(e.this.gvm.getResources().getString(a.h.sdk_no_network_guide));
                    }
                });
            }
        }
    };
    private ALaCharmCardActivity gvm;
    private String mGroupId;
    private String mLiveId;

    public e(ALaCharmCardActivity aLaCharmCardActivity) {
        this.gvm = aLaCharmCardActivity;
    }

    public void createView() {
        this.gvK = new d(this.gvm, this.mGroupId, this.mLiveId, this.bkL, this.aFp, this.gvM, this.bbs);
        loadData();
    }

    private void loadData() {
        if (this.gvL == null) {
            this.gvL = new com.baidu.tieba.ala.charm.model.b(this.gvm.getPageContext(), this.gvO);
        }
        this.gvL.u(this.mLiveId, 0, 100);
    }

    public void ew(long j) {
        this.gvN = j;
        if (this.gvK != null) {
            this.gvK.ew(j);
        }
    }

    public e GN(String str) {
        this.mGroupId = str;
        return this;
    }

    public e GO(String str) {
        this.mLiveId = str;
        return this;
    }

    public e lX(boolean z) {
        this.bkL = z;
        return this;
    }

    public e GP(String str) {
        this.aFp = str;
        return this;
    }

    public e GQ(String str) {
        this.gvM = str;
        return this;
    }

    public e GR(String str) {
        this.bbs = str;
        return this;
    }

    @Override // com.baidu.live.liveroom.d.d
    public View getPanelView() {
        if (this.gvK == null) {
            return null;
        }
        return this.gvK.getRootView();
    }

    @Override // com.baidu.live.liveroom.d.d
    public String getTitle() {
        return this.gvm.getResources().getString(a.h.audience_list_title);
    }

    @Override // com.baidu.live.liveroom.d.d
    public String Lr() {
        return null;
    }

    @Override // com.baidu.live.liveroom.d.d
    public short Ls() {
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
        if (this.gvL != null) {
            this.gvL.onDestroy();
        }
    }

    @Override // com.baidu.live.liveroom.d.d
    public void onChangeSkinType(int i) {
    }
}
