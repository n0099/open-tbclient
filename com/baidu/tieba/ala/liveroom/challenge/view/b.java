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
/* loaded from: classes4.dex */
public class b implements com.baidu.live.liveroom.d.d {
    private long brr;
    private long ggl;
    private long hiH;
    private List<com.baidu.tieba.ala.liveroom.challenge.a.a> hoA = new ArrayList();
    private final c.a hoB = new c.a() { // from class: com.baidu.tieba.ala.liveroom.challenge.view.b.1
        @Override // com.baidu.tieba.ala.liveroom.challenge.view.c.a
        public void onScrollToBottom() {
            if (b.this.hoz != null) {
                b.this.hoz.bRN();
            }
        }

        @Override // com.baidu.tieba.ala.liveroom.challenge.view.c.a
        public void cej() {
            if (b.this.hoz != null) {
                b.this.hoz.refresh();
            }
        }
    };
    private final a.InterfaceC0682a hoC = new a.InterfaceC0682a() { // from class: com.baidu.tieba.ala.liveroom.challenge.view.b.2
        @Override // com.baidu.tieba.ala.liveroom.challenge.b.a.InterfaceC0682a
        public void e(boolean z, List<com.baidu.tieba.ala.liveroom.challenge.a.a> list) {
            b.this.hoA = list;
            if (b.this.hoy != null) {
                b.this.hoy.completePullRefresh();
                b.this.hoy.Qt();
                if (ListUtils.isEmpty(list)) {
                    b.this.hoy.cC(false);
                    b.this.hoy.bSn();
                    return;
                }
                if (z) {
                    b.this.hoy.bSc();
                } else {
                    b.this.hoy.bSb();
                }
                b.this.hoy.setData(list);
            }
        }

        @Override // com.baidu.tieba.ala.liveroom.challenge.b.a.InterfaceC0682a
        public void h(int i, String str, boolean z) {
            if (b.this.hoy != null) {
                b.this.hoy.completePullRefresh();
                b.this.hoy.Qt();
                b.this.hoy.bSn();
                if (!ListUtils.isEmpty(b.this.hoA)) {
                    BdUtilHelper.showToast(b.this.mTbPageContext.getPageActivity(), str);
                } else if (BdNetTypeUtil.isNetWorkAvailable()) {
                    b.this.hoy.cC(false);
                } else {
                    b.this.hoy.cC(true);
                }
            }
        }
    };
    private c hoy;
    private com.baidu.tieba.ala.liveroom.challenge.b.a hoz;
    private boolean mIsHost;
    private TbPageContext mTbPageContext;
    private int mType;

    public b(TbPageContext tbPageContext, int i, boolean z) {
        this.mTbPageContext = tbPageContext;
        this.mType = i;
        this.mIsHost = z;
        this.hoy = new c(this.mTbPageContext, this.mType, this.mIsHost);
        this.hoy.a(this.hoB);
        this.hoz = new com.baidu.tieba.ala.liveroom.challenge.b.a(this.mTbPageContext, this.mType, this.mIsHost);
        this.hoz.a(this.hoC);
    }

    public void e(long j, long j2, long j3) {
        this.hiH = j;
        this.brr = j2;
        this.ggl = j3;
        this.hoy.c(this.hiH, this.brr, this.ggl);
        this.hoz.c(this.hiH, this.brr, this.ggl);
        this.hoz.refresh();
    }

    @Override // com.baidu.live.liveroom.d.d
    public View getPanelView() {
        return this.hoy.getView();
    }

    @Override // com.baidu.live.liveroom.d.d
    public String getTitle() {
        return this.mType == 2 ? this.mTbPageContext.getResources().getString(a.h.ala_challenge_jinzhu_reval) : this.mTbPageContext.getResources().getString(a.h.ala_challenge_jinzhu_anchor);
    }

    @Override // com.baidu.live.liveroom.d.d
    public String MK() {
        return null;
    }

    @Override // com.baidu.live.liveroom.d.d
    public short ML() {
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
        if (this.hoz != null) {
            this.hoz.onDestroy();
        }
        if (this.hoy != null) {
            this.hoy.onDestroy();
        }
    }

    @Override // com.baidu.live.liveroom.d.d
    public void onChangeSkinType(int i) {
    }
}
