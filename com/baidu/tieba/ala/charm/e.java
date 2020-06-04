package com.baidu.tieba.ala.charm;

import android.view.View;
import com.baidu.live.adp.lib.util.BdNetTypeUtil;
import com.baidu.live.data.AlaLiveUserInfoData;
import com.baidu.live.data.k;
import com.baidu.live.u.a;
import com.baidu.tieba.ala.charm.model.b;
/* loaded from: classes3.dex */
public class e implements com.baidu.live.liveroom.d.d {
    private boolean aSw;
    private String aSx;
    private d foB;
    private com.baidu.tieba.ala.charm.model.b foC;
    private String foD;
    private long foE;
    b.a foF = new b.a() { // from class: com.baidu.tieba.ala.charm.e.1
        @Override // com.baidu.tieba.ala.charm.model.b.a
        public void a(long j, k kVar, AlaLiveUserInfoData alaLiveUserInfoData, long j2) {
            if (e.this.foB != null) {
                e.this.foB.dm(j);
                if (kVar == null) {
                    e.this.foB.jF(true);
                    return;
                }
                e.this.foB.bqQ();
                e.this.foB.a(kVar.getList(), alaLiveUserInfoData, j2);
                int size = kVar.getList().size();
                if (size <= 0) {
                    e.this.foB.jF(true);
                } else if (size < 100) {
                    e.this.foB.aq(e.this.foc.getPageContext().getResources().getString(a.i.online_no_more), true);
                } else {
                    e.this.foB.aq(e.this.foc.getPageContext().getResources().getString(a.i.online_show_100), false);
                }
            }
        }

        @Override // com.baidu.tieba.ala.charm.model.b.a
        public void ax(int i, String str) {
            if (e.this.foB != null) {
                e.this.foB.jF(false);
                e.this.foB.k(new View.OnClickListener() { // from class: com.baidu.tieba.ala.charm.e.1.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (BdNetTypeUtil.isNetWorkAvailable()) {
                            if (e.this.foC != null) {
                                e.this.foC.v(e.this.mLiveId, 0, 0);
                                return;
                            }
                            return;
                        }
                        e.this.foc.getPageContext().showToast(e.this.foc.getResources().getString(a.i.sdk_no_network_guide));
                    }
                });
            }
        }
    };
    private ALaCharmCardActivity foc;
    private String fow;
    private String mGroupId;
    private String mLiveId;

    public e(ALaCharmCardActivity aLaCharmCardActivity) {
        this.foc = aLaCharmCardActivity;
    }

    public void createView() {
        this.foB = new d(this.foc, this.mGroupId, this.mLiveId, this.aSw, this.aSx, this.foD, this.fow);
        loadData();
    }

    private void loadData() {
        if (this.foC == null) {
            this.foC = new com.baidu.tieba.ala.charm.model.b(this.foc.getPageContext(), this.foF);
        }
        this.foC.u(this.mLiveId, 0, 100);
    }

    public void dm(long j) {
        this.foE = j;
        if (this.foB != null) {
            this.foB.dm(j);
        }
    }

    public e Bn(String str) {
        this.mGroupId = str;
        return this;
    }

    public e Bo(String str) {
        this.mLiveId = str;
        return this;
    }

    public e jG(boolean z) {
        this.aSw = z;
        return this;
    }

    public e Bp(String str) {
        this.aSx = str;
        return this;
    }

    public e Bq(String str) {
        this.foD = str;
        return this;
    }

    public e Br(String str) {
        this.fow = str;
        return this;
    }

    @Override // com.baidu.live.liveroom.d.d
    public View getPanelView() {
        if (this.foB == null) {
            return null;
        }
        return this.foB.getRootView();
    }

    @Override // com.baidu.live.liveroom.d.d
    public String getTitle() {
        return this.foc.getResources().getString(a.i.audience_list_title);
    }

    @Override // com.baidu.live.liveroom.d.d
    public String Ci() {
        return null;
    }

    @Override // com.baidu.live.liveroom.d.d
    public short Cj() {
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
        if (this.foC != null) {
            this.foC.onDestroy();
        }
    }

    @Override // com.baidu.live.liveroom.d.d
    public void onChangeSkinType(int i) {
    }
}
