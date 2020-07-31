package com.baidu.tieba.ala.charm;

import android.view.View;
import com.baidu.live.adp.lib.util.BdNetTypeUtil;
import com.baidu.live.data.AlaLiveUserInfoData;
import com.baidu.live.data.k;
import com.baidu.live.sdk.a;
import com.baidu.tieba.ala.charm.model.b;
/* loaded from: classes4.dex */
public class e implements com.baidu.live.liveroom.d.d {
    private boolean aWs;
    private String avC;
    private String fEQ;
    private d fEV;
    private com.baidu.tieba.ala.charm.model.b fEW;
    private String fEX;
    private long fEY;
    b.a fEZ = new b.a() { // from class: com.baidu.tieba.ala.charm.e.1
        @Override // com.baidu.tieba.ala.charm.model.b.a
        public void a(long j, k kVar, AlaLiveUserInfoData alaLiveUserInfoData, long j2) {
            if (e.this.fEV != null) {
                e.this.fEV.dD(j);
                if (kVar == null) {
                    e.this.fEV.kw(true);
                    return;
                }
                e.this.fEV.bwX();
                e.this.fEV.a(kVar.getList(), alaLiveUserInfoData, j2);
                int size = kVar.getList().size();
                if (size <= 0) {
                    e.this.fEV.kw(true);
                } else if (size < 100) {
                    e.this.fEV.aq(e.this.fEw.getPageContext().getResources().getString(a.i.online_no_more), true);
                } else {
                    e.this.fEV.aq(e.this.fEw.getPageContext().getResources().getString(a.i.online_show_100), false);
                }
            }
        }

        @Override // com.baidu.tieba.ala.charm.model.b.a
        public void aB(int i, String str) {
            if (e.this.fEV != null) {
                e.this.fEV.kw(false);
                e.this.fEV.l(new View.OnClickListener() { // from class: com.baidu.tieba.ala.charm.e.1.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (BdNetTypeUtil.isNetWorkAvailable()) {
                            if (e.this.fEW != null) {
                                e.this.fEW.v(e.this.mLiveId, 0, 0);
                                return;
                            }
                            return;
                        }
                        e.this.fEw.getPageContext().showToast(e.this.fEw.getResources().getString(a.i.sdk_no_network_guide));
                    }
                });
            }
        }
    };
    private ALaCharmCardActivity fEw;
    private String mGroupId;
    private String mLiveId;

    public e(ALaCharmCardActivity aLaCharmCardActivity) {
        this.fEw = aLaCharmCardActivity;
    }

    public void createView() {
        this.fEV = new d(this.fEw, this.mGroupId, this.mLiveId, this.aWs, this.avC, this.fEX, this.fEQ);
        loadData();
    }

    private void loadData() {
        if (this.fEW == null) {
            this.fEW = new com.baidu.tieba.ala.charm.model.b(this.fEw.getPageContext(), this.fEZ);
        }
        this.fEW.u(this.mLiveId, 0, 100);
    }

    public void dD(long j) {
        this.fEY = j;
        if (this.fEV != null) {
            this.fEV.dD(j);
        }
    }

    public e Cw(String str) {
        this.mGroupId = str;
        return this;
    }

    public e Cx(String str) {
        this.mLiveId = str;
        return this;
    }

    public e kx(boolean z) {
        this.aWs = z;
        return this;
    }

    public e Cy(String str) {
        this.avC = str;
        return this;
    }

    public e Cz(String str) {
        this.fEX = str;
        return this;
    }

    public e CA(String str) {
        this.fEQ = str;
        return this;
    }

    @Override // com.baidu.live.liveroom.d.d
    public View getPanelView() {
        if (this.fEV == null) {
            return null;
        }
        return this.fEV.getRootView();
    }

    @Override // com.baidu.live.liveroom.d.d
    public String getTitle() {
        return this.fEw.getResources().getString(a.i.audience_list_title);
    }

    @Override // com.baidu.live.liveroom.d.d
    public String Dj() {
        return null;
    }

    @Override // com.baidu.live.liveroom.d.d
    public short Dk() {
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
        if (this.fEW != null) {
            this.fEW.onDestroy();
        }
    }

    @Override // com.baidu.live.liveroom.d.d
    public void onChangeSkinType(int i) {
    }
}
