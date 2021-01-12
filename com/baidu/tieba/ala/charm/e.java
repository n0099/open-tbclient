package com.baidu.tieba.ala.charm;

import android.text.TextUtils;
import android.view.View;
import com.baidu.live.adp.lib.util.BdNetTypeUtil;
import com.baidu.live.adp.lib.util.BdUtilHelper;
import com.baidu.live.data.AlaLiveUserInfoData;
import com.baidu.live.data.r;
import com.baidu.live.sdk.a;
import com.baidu.tieba.ala.charm.model.b;
/* loaded from: classes10.dex */
public class e implements com.baidu.live.liveroom.d.d {
    private String aBO;
    private String bab;
    private boolean bkm;
    private ALaCharmCardActivity gKK;
    private d gLi;
    private com.baidu.tieba.ala.charm.model.b gLj;
    private String gLk;
    private long gLl;
    b.a gLm = new b.a() { // from class: com.baidu.tieba.ala.charm.e.1
        @Override // com.baidu.tieba.ala.charm.model.b.a
        public void a(long j, r rVar, AlaLiveUserInfoData alaLiveUserInfoData, long j2) {
            if (e.this.gLi != null) {
                e.this.gLi.eZ(j);
                if (rVar == null) {
                    e.this.gLi.dI(true);
                    return;
                }
                e.this.gLi.Vq();
                e.this.gLi.a(rVar.getList(), alaLiveUserInfoData, j2);
                int size = rVar.getList().size();
                if (size <= 0) {
                    e.this.gLi.dI(true);
                } else if (size < 100) {
                    e.this.gLi.aC(e.this.gKK.getPageContext().getResources().getString(a.h.online_no_more), true);
                } else {
                    e.this.gLi.aC(e.this.gKK.getPageContext().getResources().getString(a.h.online_show_100), false);
                }
            }
        }

        @Override // com.baidu.tieba.ala.charm.model.b.a
        public void w(int i, String str) {
            if (e.this.gLi != null) {
                e.this.gLi.dI(false);
                e.this.gLi.n(new View.OnClickListener() { // from class: com.baidu.tieba.ala.charm.e.1.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (BdNetTypeUtil.isNetWorkAvailable()) {
                            if (e.this.gLj != null) {
                                e.this.gLj.w(e.this.mLiveId, 0, 0);
                                return;
                            }
                            return;
                        }
                        e.this.gKK.getPageContext().showToast(e.this.gKK.getResources().getString(a.h.sdk_no_network_guide));
                    }
                });
            }
        }
    };
    b.InterfaceC0625b gLn = new b.InterfaceC0625b() { // from class: com.baidu.tieba.ala.charm.e.2
        @Override // com.baidu.tieba.ala.charm.model.b.InterfaceC0625b
        public void u(long j, int i) {
            e.this.gLi.t(j, i);
        }

        @Override // com.baidu.tieba.ala.charm.model.b.InterfaceC0625b
        public void w(int i, String str) {
            if (TextUtils.isEmpty(str)) {
                BdUtilHelper.showToast(e.this.gKK, e.this.gKK.getString(a.h.sdk_poke_poke_once_fail));
            } else {
                BdUtilHelper.showToast(e.this.gKK, str);
            }
        }
    };
    private String mGroupId;
    private String mLiveId;

    public e(ALaCharmCardActivity aLaCharmCardActivity) {
        this.gKK = aLaCharmCardActivity;
    }

    public void createView() {
        this.gLi = new d(this.gKK, this.mGroupId, this.mLiveId, this.bkm, this.aBO, this.gLk, this.bab);
        loadData();
    }

    private void loadData() {
        if (this.gLj == null) {
            this.gLj = new com.baidu.tieba.ala.charm.model.b(this.gKK.getPageContext(), this.gLm, this.gLn);
        }
        this.gLj.v(this.mLiveId, 0, 100);
    }

    public void eZ(long j) {
        this.gLl = j;
        if (this.gLi != null) {
            this.gLi.eZ(j);
        }
    }

    public e FP(String str) {
        this.mGroupId = str;
        return this;
    }

    public e FQ(String str) {
        this.mLiveId = str;
        return this;
    }

    public e mP(boolean z) {
        this.bkm = z;
        return this;
    }

    public e FR(String str) {
        this.aBO = str;
        return this;
    }

    public e FS(String str) {
        this.gLk = str;
        return this;
    }

    public e FT(String str) {
        this.bab = str;
        return this;
    }

    @Override // com.baidu.live.liveroom.d.d
    public View getPanelView() {
        if (this.gLi == null) {
            return null;
        }
        return this.gLi.getRootView();
    }

    @Override // com.baidu.live.liveroom.d.d
    public String getTitle() {
        return this.gKK.getResources().getString(a.h.audience_list_title);
    }

    @Override // com.baidu.live.liveroom.d.d
    public String Im() {
        return null;
    }

    @Override // com.baidu.live.liveroom.d.d
    public short In() {
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
        if (this.gLj != null) {
            this.gLj.onDestroy();
        }
    }

    @Override // com.baidu.live.liveroom.d.d
    public void onChangeSkinType(int i) {
    }
}
