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
    private long ggj;
    private long hiF;
    private c how;
    private com.baidu.tieba.ala.liveroom.challenge.b.a hox;
    private boolean mIsHost;
    private TbPageContext mTbPageContext;
    private int mType;
    private List<com.baidu.tieba.ala.liveroom.challenge.a.a> hoy = new ArrayList();
    private final c.a hoz = new c.a() { // from class: com.baidu.tieba.ala.liveroom.challenge.view.b.1
        @Override // com.baidu.tieba.ala.liveroom.challenge.view.c.a
        public void onScrollToBottom() {
            if (b.this.hox != null) {
                b.this.hox.bRM();
            }
        }

        @Override // com.baidu.tieba.ala.liveroom.challenge.view.c.a
        public void cei() {
            if (b.this.hox != null) {
                b.this.hox.refresh();
            }
        }
    };
    private final a.InterfaceC0682a hoA = new a.InterfaceC0682a() { // from class: com.baidu.tieba.ala.liveroom.challenge.view.b.2
        @Override // com.baidu.tieba.ala.liveroom.challenge.b.a.InterfaceC0682a
        public void e(boolean z, List<com.baidu.tieba.ala.liveroom.challenge.a.a> list) {
            b.this.hoy = list;
            if (b.this.how != null) {
                b.this.how.completePullRefresh();
                b.this.how.Qt();
                if (ListUtils.isEmpty(list)) {
                    b.this.how.cC(false);
                    b.this.how.bSm();
                    return;
                }
                if (z) {
                    b.this.how.bSb();
                } else {
                    b.this.how.bSa();
                }
                b.this.how.setData(list);
            }
        }

        @Override // com.baidu.tieba.ala.liveroom.challenge.b.a.InterfaceC0682a
        public void h(int i, String str, boolean z) {
            if (b.this.how != null) {
                b.this.how.completePullRefresh();
                b.this.how.Qt();
                b.this.how.bSm();
                if (!ListUtils.isEmpty(b.this.hoy)) {
                    BdUtilHelper.showToast(b.this.mTbPageContext.getPageActivity(), str);
                } else if (BdNetTypeUtil.isNetWorkAvailable()) {
                    b.this.how.cC(false);
                } else {
                    b.this.how.cC(true);
                }
            }
        }
    };

    public b(TbPageContext tbPageContext, int i, boolean z) {
        this.mTbPageContext = tbPageContext;
        this.mType = i;
        this.mIsHost = z;
        this.how = new c(this.mTbPageContext, this.mType, this.mIsHost);
        this.how.a(this.hoz);
        this.hox = new com.baidu.tieba.ala.liveroom.challenge.b.a(this.mTbPageContext, this.mType, this.mIsHost);
        this.hox.a(this.hoA);
    }

    public void e(long j, long j2, long j3) {
        this.hiF = j;
        this.brr = j2;
        this.ggj = j3;
        this.how.c(this.hiF, this.brr, this.ggj);
        this.hox.c(this.hiF, this.brr, this.ggj);
        this.hox.refresh();
    }

    @Override // com.baidu.live.liveroom.d.d
    public View getPanelView() {
        return this.how.getView();
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
        if (this.hox != null) {
            this.hox.onDestroy();
        }
        if (this.how != null) {
            this.how.onDestroy();
        }
    }

    @Override // com.baidu.live.liveroom.d.d
    public void onChangeSkinType(int i) {
    }
}
