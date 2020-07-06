package com.baidu.tieba.ala.charm;

import android.view.View;
import com.baidu.live.adp.lib.util.BdNetTypeUtil;
import com.baidu.live.data.AlaLiveUserInfoData;
import com.baidu.live.data.k;
import com.baidu.live.sdk.a;
import com.baidu.tieba.ala.charm.model.b;
/* loaded from: classes3.dex */
public class e implements com.baidu.live.liveroom.d.d {
    private boolean aVc;
    private String aVd;
    private String fzJ;
    private d fzO;
    private com.baidu.tieba.ala.charm.model.b fzP;
    private String fzQ;
    private long fzR;
    b.a fzS = new b.a() { // from class: com.baidu.tieba.ala.charm.e.1
        @Override // com.baidu.tieba.ala.charm.model.b.a
        public void a(long j, k kVar, AlaLiveUserInfoData alaLiveUserInfoData, long j2) {
            if (e.this.fzO != null) {
                e.this.fzO.dp(j);
                if (kVar == null) {
                    e.this.fzO.jS(true);
                    return;
                }
                e.this.fzO.btO();
                e.this.fzO.a(kVar.getList(), alaLiveUserInfoData, j2);
                int size = kVar.getList().size();
                if (size <= 0) {
                    e.this.fzO.jS(true);
                } else if (size < 100) {
                    e.this.fzO.as(e.this.fzp.getPageContext().getResources().getString(a.i.online_no_more), true);
                } else {
                    e.this.fzO.as(e.this.fzp.getPageContext().getResources().getString(a.i.online_show_100), false);
                }
            }
        }

        @Override // com.baidu.tieba.ala.charm.model.b.a
        public void az(int i, String str) {
            if (e.this.fzO != null) {
                e.this.fzO.jS(false);
                e.this.fzO.l(new View.OnClickListener() { // from class: com.baidu.tieba.ala.charm.e.1.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (BdNetTypeUtil.isNetWorkAvailable()) {
                            if (e.this.fzP != null) {
                                e.this.fzP.v(e.this.mLiveId, 0, 0);
                                return;
                            }
                            return;
                        }
                        e.this.fzp.getPageContext().showToast(e.this.fzp.getResources().getString(a.i.sdk_no_network_guide));
                    }
                });
            }
        }
    };
    private ALaCharmCardActivity fzp;
    private String mGroupId;
    private String mLiveId;

    public e(ALaCharmCardActivity aLaCharmCardActivity) {
        this.fzp = aLaCharmCardActivity;
    }

    public void createView() {
        this.fzO = new d(this.fzp, this.mGroupId, this.mLiveId, this.aVc, this.aVd, this.fzQ, this.fzJ);
        loadData();
    }

    private void loadData() {
        if (this.fzP == null) {
            this.fzP = new com.baidu.tieba.ala.charm.model.b(this.fzp.getPageContext(), this.fzS);
        }
        this.fzP.u(this.mLiveId, 0, 100);
    }

    public void dp(long j) {
        this.fzR = j;
        if (this.fzO != null) {
            this.fzO.dp(j);
        }
    }

    public e BL(String str) {
        this.mGroupId = str;
        return this;
    }

    public e BM(String str) {
        this.mLiveId = str;
        return this;
    }

    public e jT(boolean z) {
        this.aVc = z;
        return this;
    }

    public e BN(String str) {
        this.aVd = str;
        return this;
    }

    public e BO(String str) {
        this.fzQ = str;
        return this;
    }

    public e BP(String str) {
        this.fzJ = str;
        return this;
    }

    @Override // com.baidu.live.liveroom.d.d
    public View getPanelView() {
        if (this.fzO == null) {
            return null;
        }
        return this.fzO.getRootView();
    }

    @Override // com.baidu.live.liveroom.d.d
    public String getTitle() {
        return this.fzp.getResources().getString(a.i.audience_list_title);
    }

    @Override // com.baidu.live.liveroom.d.d
    public String CI() {
        return null;
    }

    @Override // com.baidu.live.liveroom.d.d
    public short CJ() {
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
        if (this.fzP != null) {
            this.fzP.onDestroy();
        }
    }

    @Override // com.baidu.live.liveroom.d.d
    public void onChangeSkinType(int i) {
    }
}
