package com.baidu.tieba.ala.charm;

import android.view.View;
import com.baidu.live.adp.lib.util.BdNetTypeUtil;
import com.baidu.live.data.AlaLiveUserInfoData;
import com.baidu.live.data.h;
import com.baidu.live.u.a;
import com.baidu.tieba.ala.charm.model.b;
/* loaded from: classes3.dex */
public class e implements com.baidu.live.liveroom.d.d {
    private boolean aMw;
    private String aMx;
    private String faJ;
    private d faO;
    private com.baidu.tieba.ala.charm.model.b faP;
    private String faQ;
    private long faR;
    b.a faS = new b.a() { // from class: com.baidu.tieba.ala.charm.e.1
        @Override // com.baidu.tieba.ala.charm.model.b.a
        public void a(long j, h hVar, AlaLiveUserInfoData alaLiveUserInfoData, long j2) {
            if (e.this.faO != null) {
                e.this.faO.dk(j);
                if (hVar == null) {
                    e.this.faO.jm(true);
                    return;
                }
                e.this.faO.blr();
                e.this.faO.a(hVar.getList(), alaLiveUserInfoData, j2);
                int size = hVar.getList().size();
                if (size <= 0) {
                    e.this.faO.jm(true);
                } else if (size < 100) {
                    e.this.faO.ad(e.this.fao.getPageContext().getResources().getString(a.i.online_no_more), true);
                } else {
                    e.this.faO.ad(e.this.fao.getPageContext().getResources().getString(a.i.online_show_100), false);
                }
            }
        }

        @Override // com.baidu.tieba.ala.charm.model.b.a
        public void as(int i, String str) {
            if (e.this.faO != null) {
                e.this.faO.jm(false);
                e.this.faO.l(new View.OnClickListener() { // from class: com.baidu.tieba.ala.charm.e.1.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (BdNetTypeUtil.isNetWorkAvailable()) {
                            if (e.this.faP != null) {
                                e.this.faP.t(e.this.mLiveId, 0, 0);
                                return;
                            }
                            return;
                        }
                        e.this.fao.getPageContext().showToast(e.this.fao.getResources().getString(a.i.sdk_no_network_guide));
                    }
                });
            }
        }
    };
    private ALaCharmCardActivity fao;
    private String mGroupId;
    private String mLiveId;

    public e(ALaCharmCardActivity aLaCharmCardActivity) {
        this.fao = aLaCharmCardActivity;
    }

    public void createView() {
        this.faO = new d(this.fao, this.mGroupId, this.mLiveId, this.aMw, this.aMx, this.faQ, this.faJ);
        loadData();
    }

    private void loadData() {
        if (this.faP == null) {
            this.faP = new com.baidu.tieba.ala.charm.model.b(this.fao.getPageContext(), this.faS);
        }
        this.faP.s(this.mLiveId, 0, 100);
    }

    public void dk(long j) {
        this.faR = j;
        if (this.faO != null) {
            this.faO.dk(j);
        }
    }

    public e zG(String str) {
        this.mGroupId = str;
        return this;
    }

    public e zH(String str) {
        this.mLiveId = str;
        return this;
    }

    public e jn(boolean z) {
        this.aMw = z;
        return this;
    }

    public e zI(String str) {
        this.aMx = str;
        return this;
    }

    public e zJ(String str) {
        this.faQ = str;
        return this;
    }

    public e zK(String str) {
        this.faJ = str;
        return this;
    }

    @Override // com.baidu.live.liveroom.d.d
    public View getPanelView() {
        if (this.faO == null) {
            return null;
        }
        return this.faO.getRootView();
    }

    @Override // com.baidu.live.liveroom.d.d
    public String getTitle() {
        return this.fao.getResources().getString(a.i.audience_list_title);
    }

    @Override // com.baidu.live.liveroom.d.d
    public String AS() {
        return null;
    }

    @Override // com.baidu.live.liveroom.d.d
    public short AT() {
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
        if (this.faP != null) {
            this.faP.onDestroy();
        }
    }

    @Override // com.baidu.live.liveroom.d.d
    public void onChangeSkinType(int i) {
    }
}
