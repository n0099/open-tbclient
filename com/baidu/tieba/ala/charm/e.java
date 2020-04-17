package com.baidu.tieba.ala.charm;

import android.view.View;
import com.baidu.live.adp.lib.util.BdNetTypeUtil;
import com.baidu.live.data.AlaLiveUserInfoData;
import com.baidu.live.data.h;
import com.baidu.live.u.a;
import com.baidu.tieba.ala.charm.model.b;
/* loaded from: classes3.dex */
public class e implements com.baidu.live.liveroom.d.d {
    private boolean aMq;
    private String aMr;
    private String faE;
    private d faJ;
    private com.baidu.tieba.ala.charm.model.b faK;
    private String faL;
    private long faM;
    b.a faN = new b.a() { // from class: com.baidu.tieba.ala.charm.e.1
        @Override // com.baidu.tieba.ala.charm.model.b.a
        public void a(long j, h hVar, AlaLiveUserInfoData alaLiveUserInfoData, long j2) {
            if (e.this.faJ != null) {
                e.this.faJ.dk(j);
                if (hVar == null) {
                    e.this.faJ.jm(true);
                    return;
                }
                e.this.faJ.blt();
                e.this.faJ.a(hVar.getList(), alaLiveUserInfoData, j2);
                int size = hVar.getList().size();
                if (size <= 0) {
                    e.this.faJ.jm(true);
                } else if (size < 100) {
                    e.this.faJ.ad(e.this.faj.getPageContext().getResources().getString(a.i.online_no_more), true);
                } else {
                    e.this.faJ.ad(e.this.faj.getPageContext().getResources().getString(a.i.online_show_100), false);
                }
            }
        }

        @Override // com.baidu.tieba.ala.charm.model.b.a
        public void as(int i, String str) {
            if (e.this.faJ != null) {
                e.this.faJ.jm(false);
                e.this.faJ.l(new View.OnClickListener() { // from class: com.baidu.tieba.ala.charm.e.1.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (BdNetTypeUtil.isNetWorkAvailable()) {
                            if (e.this.faK != null) {
                                e.this.faK.t(e.this.mLiveId, 0, 0);
                                return;
                            }
                            return;
                        }
                        e.this.faj.getPageContext().showToast(e.this.faj.getResources().getString(a.i.sdk_no_network_guide));
                    }
                });
            }
        }
    };
    private ALaCharmCardActivity faj;
    private String mGroupId;
    private String mLiveId;

    public e(ALaCharmCardActivity aLaCharmCardActivity) {
        this.faj = aLaCharmCardActivity;
    }

    public void createView() {
        this.faJ = new d(this.faj, this.mGroupId, this.mLiveId, this.aMq, this.aMr, this.faL, this.faE);
        loadData();
    }

    private void loadData() {
        if (this.faK == null) {
            this.faK = new com.baidu.tieba.ala.charm.model.b(this.faj.getPageContext(), this.faN);
        }
        this.faK.s(this.mLiveId, 0, 100);
    }

    public void dk(long j) {
        this.faM = j;
        if (this.faJ != null) {
            this.faJ.dk(j);
        }
    }

    public e zD(String str) {
        this.mGroupId = str;
        return this;
    }

    public e zE(String str) {
        this.mLiveId = str;
        return this;
    }

    public e jn(boolean z) {
        this.aMq = z;
        return this;
    }

    public e zF(String str) {
        this.aMr = str;
        return this;
    }

    public e zG(String str) {
        this.faL = str;
        return this;
    }

    public e zH(String str) {
        this.faE = str;
        return this;
    }

    @Override // com.baidu.live.liveroom.d.d
    public View getPanelView() {
        if (this.faJ == null) {
            return null;
        }
        return this.faJ.getRootView();
    }

    @Override // com.baidu.live.liveroom.d.d
    public String getTitle() {
        return this.faj.getResources().getString(a.i.audience_list_title);
    }

    @Override // com.baidu.live.liveroom.d.d
    public String AT() {
        return null;
    }

    @Override // com.baidu.live.liveroom.d.d
    public short AU() {
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
        if (this.faK != null) {
            this.faK.onDestroy();
        }
    }

    @Override // com.baidu.live.liveroom.d.d
    public void onChangeSkinType(int i) {
    }
}
