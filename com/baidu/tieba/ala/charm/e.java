package com.baidu.tieba.ala.charm;

import android.view.View;
import com.baidu.live.adp.lib.util.BdNetTypeUtil;
import com.baidu.live.data.AlaLiveUserInfoData;
import com.baidu.live.data.q;
import com.baidu.live.sdk.a;
import com.baidu.tieba.ala.charm.model.b;
/* loaded from: classes4.dex */
public class e implements com.baidu.live.liveroom.d.d {
    private String aEz;
    private String aZZ;
    private boolean bjr;
    private d gpW;
    private com.baidu.tieba.ala.charm.model.b gpX;
    private String gpY;
    private long gpZ;
    private ALaCharmCardActivity gpy;
    b.a gqa = new b.a() { // from class: com.baidu.tieba.ala.charm.e.1
        @Override // com.baidu.tieba.ala.charm.model.b.a
        public void a(long j, q qVar, AlaLiveUserInfoData alaLiveUserInfoData, long j2) {
            if (e.this.gpW != null) {
                e.this.gpW.ea(j);
                if (qVar == null) {
                    e.this.gpW.dj(true);
                    return;
                }
                e.this.gpW.TK();
                e.this.gpW.a(qVar.getList(), alaLiveUserInfoData, j2);
                int size = qVar.getList().size();
                if (size <= 0) {
                    e.this.gpW.dj(true);
                } else if (size < 100) {
                    e.this.gpW.aA(e.this.gpy.getPageContext().getResources().getString(a.i.online_no_more), true);
                } else {
                    e.this.gpW.aA(e.this.gpy.getPageContext().getResources().getString(a.i.online_show_100), false);
                }
            }
        }

        @Override // com.baidu.tieba.ala.charm.model.b.a
        public void t(int i, String str) {
            if (e.this.gpW != null) {
                e.this.gpW.dj(false);
                e.this.gpW.l(new View.OnClickListener() { // from class: com.baidu.tieba.ala.charm.e.1.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (BdNetTypeUtil.isNetWorkAvailable()) {
                            if (e.this.gpX != null) {
                                e.this.gpX.v(e.this.mLiveId, 0, 0);
                                return;
                            }
                            return;
                        }
                        e.this.gpy.getPageContext().showToast(e.this.gpy.getResources().getString(a.i.sdk_no_network_guide));
                    }
                });
            }
        }
    };
    private String mGroupId;
    private String mLiveId;

    public e(ALaCharmCardActivity aLaCharmCardActivity) {
        this.gpy = aLaCharmCardActivity;
    }

    public void createView() {
        this.gpW = new d(this.gpy, this.mGroupId, this.mLiveId, this.bjr, this.aEz, this.gpY, this.aZZ);
        loadData();
    }

    private void loadData() {
        if (this.gpX == null) {
            this.gpX = new com.baidu.tieba.ala.charm.model.b(this.gpy.getPageContext(), this.gqa);
        }
        this.gpX.u(this.mLiveId, 0, 100);
    }

    public void ea(long j) {
        this.gpZ = j;
        if (this.gpW != null) {
            this.gpW.ea(j);
        }
    }

    public e Gz(String str) {
        this.mGroupId = str;
        return this;
    }

    public e GA(String str) {
        this.mLiveId = str;
        return this;
    }

    public e lO(boolean z) {
        this.bjr = z;
        return this;
    }

    public e GB(String str) {
        this.aEz = str;
        return this;
    }

    public e GC(String str) {
        this.gpY = str;
        return this;
    }

    public e GD(String str) {
        this.aZZ = str;
        return this;
    }

    @Override // com.baidu.live.liveroom.d.d
    public View getPanelView() {
        if (this.gpW == null) {
            return null;
        }
        return this.gpW.getRootView();
    }

    @Override // com.baidu.live.liveroom.d.d
    public String getTitle() {
        return this.gpy.getResources().getString(a.i.audience_list_title);
    }

    @Override // com.baidu.live.liveroom.d.d
    public String KR() {
        return null;
    }

    @Override // com.baidu.live.liveroom.d.d
    public short KS() {
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
        if (this.gpX != null) {
            this.gpX.onDestroy();
        }
    }

    @Override // com.baidu.live.liveroom.d.d
    public void onChangeSkinType(int i) {
    }
}
