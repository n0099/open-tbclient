package com.baidu.tieba.ala.liveroom.challenge.view;

import android.view.View;
import com.baidu.live.adp.lib.util.BdNetTypeUtil;
import com.baidu.live.adp.lib.util.BdUtilHelper;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.tbadk.core.util.ListUtils;
import com.baidu.tieba.ala.liveroom.challenge.b.a;
import com.baidu.tieba.ala.liveroom.challenge.view.c;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes11.dex */
public class b implements com.baidu.live.liveroom.d.d {
    private long buN;
    private long goZ;
    private c hAl;
    private com.baidu.tieba.ala.liveroom.challenge.b.a hAm;
    private List<com.baidu.tieba.ala.liveroom.challenge.a.a> hAn = new ArrayList();
    private final c.a hAo = new c.a() { // from class: com.baidu.tieba.ala.liveroom.challenge.view.b.1
        @Override // com.baidu.tieba.ala.liveroom.challenge.view.c.a
        public void onScrollToBottom() {
            if (b.this.hAm != null) {
                b.this.hAm.bRj();
            }
        }

        @Override // com.baidu.tieba.ala.liveroom.challenge.view.c.a
        public void cek() {
            if (b.this.hAm != null) {
                b.this.hAm.refresh();
            }
        }
    };
    private final a.InterfaceC0660a hAp = new a.InterfaceC0660a() { // from class: com.baidu.tieba.ala.liveroom.challenge.view.b.2
        @Override // com.baidu.tieba.ala.liveroom.challenge.b.a.InterfaceC0660a
        public void f(boolean z, List<com.baidu.tieba.ala.liveroom.challenge.a.a> list) {
            b.this.hAn = list;
            if (b.this.hAl != null) {
                b.this.hAl.completePullRefresh();
                b.this.hAl.Pb();
                if (ListUtils.isEmpty(list)) {
                    b.this.hAl.cK(false);
                    b.this.hAl.bRJ();
                    return;
                }
                if (z) {
                    b.this.hAl.bRy();
                } else {
                    b.this.hAl.bRx();
                }
                b.this.hAl.setData(list);
            }
        }

        @Override // com.baidu.tieba.ala.liveroom.challenge.b.a.InterfaceC0660a
        public void g(int i, String str, boolean z) {
            if (b.this.hAl != null) {
                b.this.hAl.completePullRefresh();
                b.this.hAl.Pb();
                b.this.hAl.bRJ();
                if (!ListUtils.isEmpty(b.this.hAn)) {
                    BdUtilHelper.showToast(b.this.mTbPageContext.getPageActivity(), str);
                } else if (BdNetTypeUtil.isNetWorkAvailable()) {
                    b.this.hAl.cK(false);
                } else {
                    b.this.hAl.cK(true);
                }
            }
        }
    };
    private long huu;
    private boolean mIsHost;
    private TbPageContext mTbPageContext;
    private int mType;

    public b(TbPageContext tbPageContext, int i, boolean z) {
        this.mTbPageContext = tbPageContext;
        this.mType = i;
        this.mIsHost = z;
        this.hAl = new c(this.mTbPageContext, this.mType, this.mIsHost);
        this.hAl.a(this.hAo);
        this.hAm = new com.baidu.tieba.ala.liveroom.challenge.b.a(this.mTbPageContext, this.mType, this.mIsHost);
        this.hAm.a(this.hAp);
    }

    public void e(long j, long j2, long j3) {
        this.huu = j;
        this.buN = j2;
        this.goZ = j3;
        this.hAl.c(this.huu, this.buN, this.goZ);
        this.hAm.c(this.huu, this.buN, this.goZ);
        this.hAm.refresh();
    }

    @Override // com.baidu.live.liveroom.d.d
    public View getPanelView() {
        return this.hAl.getView();
    }

    @Override // com.baidu.live.liveroom.d.d
    public String getTitle() {
        return this.mType == 2 ? this.mTbPageContext.getResources().getString(a.h.ala_challenge_jinzhu_reval) : this.mTbPageContext.getResources().getString(a.h.ala_challenge_jinzhu_anchor);
    }

    @Override // com.baidu.live.liveroom.d.d
    public String JK() {
        return null;
    }

    @Override // com.baidu.live.liveroom.d.d
    public short JL() {
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
        if (this.hAm != null) {
            this.hAm.onDestroy();
        }
        if (this.hAl != null) {
            this.hAl.onDestroy();
        }
    }

    @Override // com.baidu.live.liveroom.d.d
    public void onChangeSkinType(int i) {
    }
}
