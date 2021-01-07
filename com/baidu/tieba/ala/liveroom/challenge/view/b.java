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
    private long bvY;
    private long gqJ;
    private c hAt;
    private com.baidu.tieba.ala.liveroom.challenge.b.a hAu;
    private List<com.baidu.tieba.ala.liveroom.challenge.a.a> hAv = new ArrayList();
    private final c.a hAw = new c.a() { // from class: com.baidu.tieba.ala.liveroom.challenge.view.b.1
        @Override // com.baidu.tieba.ala.liveroom.challenge.view.c.a
        public void onScrollToBottom() {
            if (b.this.hAu != null) {
                b.this.hAu.bUq();
            }
        }

        @Override // com.baidu.tieba.ala.liveroom.challenge.view.c.a
        public void cha() {
            if (b.this.hAu != null) {
                b.this.hAu.refresh();
            }
        }
    };
    private final a.InterfaceC0674a hAx = new a.InterfaceC0674a() { // from class: com.baidu.tieba.ala.liveroom.challenge.view.b.2
        @Override // com.baidu.tieba.ala.liveroom.challenge.b.a.InterfaceC0674a
        public void f(boolean z, List<com.baidu.tieba.ala.liveroom.challenge.a.a> list) {
            b.this.hAv = list;
            if (b.this.hAt != null) {
                b.this.hAt.completePullRefresh();
                b.this.hAt.Rx();
                if (ListUtils.isEmpty(list)) {
                    b.this.hAt.cF(false);
                    b.this.hAt.bUQ();
                    return;
                }
                if (z) {
                    b.this.hAt.bUF();
                } else {
                    b.this.hAt.bUE();
                }
                b.this.hAt.setData(list);
            }
        }

        @Override // com.baidu.tieba.ala.liveroom.challenge.b.a.InterfaceC0674a
        public void h(int i, String str, boolean z) {
            if (b.this.hAt != null) {
                b.this.hAt.completePullRefresh();
                b.this.hAt.Rx();
                b.this.hAt.bUQ();
                if (!ListUtils.isEmpty(b.this.hAv)) {
                    BdUtilHelper.showToast(b.this.mTbPageContext.getPageActivity(), str);
                } else if (BdNetTypeUtil.isNetWorkAvailable()) {
                    b.this.hAt.cF(false);
                } else {
                    b.this.hAt.cF(true);
                }
            }
        }
    };
    private long huC;
    private boolean mIsHost;
    private TbPageContext mTbPageContext;
    private int mType;

    public b(TbPageContext tbPageContext, int i, boolean z) {
        this.mTbPageContext = tbPageContext;
        this.mType = i;
        this.mIsHost = z;
        this.hAt = new c(this.mTbPageContext, this.mType, this.mIsHost);
        this.hAt.a(this.hAw);
        this.hAu = new com.baidu.tieba.ala.liveroom.challenge.b.a(this.mTbPageContext, this.mType, this.mIsHost);
        this.hAu.a(this.hAx);
    }

    public void e(long j, long j2, long j3) {
        this.huC = j;
        this.bvY = j2;
        this.gqJ = j3;
        this.hAt.c(this.huC, this.bvY, this.gqJ);
        this.hAu.c(this.huC, this.bvY, this.gqJ);
        this.hAu.refresh();
    }

    @Override // com.baidu.live.liveroom.d.d
    public View getPanelView() {
        return this.hAt.getView();
    }

    @Override // com.baidu.live.liveroom.d.d
    public String getTitle() {
        return this.mType == 2 ? this.mTbPageContext.getResources().getString(a.h.ala_challenge_jinzhu_reval) : this.mTbPageContext.getResources().getString(a.h.ala_challenge_jinzhu_anchor);
    }

    @Override // com.baidu.live.liveroom.d.d
    public String Mh() {
        return null;
    }

    @Override // com.baidu.live.liveroom.d.d
    public short Mi() {
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
        if (this.hAu != null) {
            this.hAu.onDestroy();
        }
        if (this.hAt != null) {
            this.hAt.onDestroy();
        }
    }

    @Override // com.baidu.live.liveroom.d.d
    public void onChangeSkinType(int i) {
    }
}
