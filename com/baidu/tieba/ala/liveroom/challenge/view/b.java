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
    private long bnV;
    private long fYr;
    private long gZp;
    private c hfh;
    private com.baidu.tieba.ala.liveroom.challenge.b.a hfi;
    private List<com.baidu.tieba.ala.liveroom.challenge.a.a> hfj = new ArrayList();
    private final c.a hfk = new c.a() { // from class: com.baidu.tieba.ala.liveroom.challenge.view.b.1
        @Override // com.baidu.tieba.ala.liveroom.challenge.view.c.a
        public void onScrollToBottom() {
            if (b.this.hfi != null) {
                b.this.hfi.bOI();
            }
        }

        @Override // com.baidu.tieba.ala.liveroom.challenge.view.c.a
        public void caU() {
            if (b.this.hfi != null) {
                b.this.hfi.refresh();
            }
        }
    };
    private final a.InterfaceC0669a hfl = new a.InterfaceC0669a() { // from class: com.baidu.tieba.ala.liveroom.challenge.view.b.2
        @Override // com.baidu.tieba.ala.liveroom.challenge.b.a.InterfaceC0669a
        public void e(boolean z, List<com.baidu.tieba.ala.liveroom.challenge.a.a> list) {
            b.this.hfj = list;
            if (b.this.hfh != null) {
                b.this.hfh.completePullRefresh();
                b.this.hfh.OJ();
                if (ListUtils.isEmpty(list)) {
                    b.this.hfh.cm(false);
                    b.this.hfh.bPi();
                    return;
                }
                if (z) {
                    b.this.hfh.bOX();
                } else {
                    b.this.hfh.bOW();
                }
                b.this.hfh.setData(list);
            }
        }

        @Override // com.baidu.tieba.ala.liveroom.challenge.b.a.InterfaceC0669a
        public void h(int i, String str, boolean z) {
            if (b.this.hfh != null) {
                b.this.hfh.completePullRefresh();
                b.this.hfh.OJ();
                b.this.hfh.bPi();
                if (!ListUtils.isEmpty(b.this.hfj)) {
                    BdUtilHelper.showToast(b.this.mTbPageContext.getPageActivity(), str);
                } else if (BdNetTypeUtil.isNetWorkAvailable()) {
                    b.this.hfh.cm(false);
                } else {
                    b.this.hfh.cm(true);
                }
            }
        }
    };
    private boolean mIsHost;
    private TbPageContext mTbPageContext;
    private int mType;

    public b(TbPageContext tbPageContext, int i, boolean z) {
        this.mTbPageContext = tbPageContext;
        this.mType = i;
        this.mIsHost = z;
        this.hfh = new c(this.mTbPageContext, this.mType, this.mIsHost);
        this.hfh.a(this.hfk);
        this.hfi = new com.baidu.tieba.ala.liveroom.challenge.b.a(this.mTbPageContext, this.mType, this.mIsHost);
        this.hfi.a(this.hfl);
    }

    public void e(long j, long j2, long j3) {
        this.gZp = j;
        this.bnV = j2;
        this.fYr = j3;
        this.hfh.c(this.gZp, this.bnV, this.fYr);
        this.hfi.c(this.gZp, this.bnV, this.fYr);
        this.hfi.refresh();
    }

    @Override // com.baidu.live.liveroom.d.d
    public View getPanelView() {
        return this.hfh.getView();
    }

    @Override // com.baidu.live.liveroom.d.d
    public String getTitle() {
        return this.mType == 2 ? this.mTbPageContext.getResources().getString(a.h.ala_challenge_jinzhu_reval) : this.mTbPageContext.getResources().getString(a.h.ala_challenge_jinzhu_anchor);
    }

    @Override // com.baidu.live.liveroom.d.d
    public String Lr() {
        return null;
    }

    @Override // com.baidu.live.liveroom.d.d
    public short Ls() {
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
        if (this.hfi != null) {
            this.hfi.onDestroy();
        }
        if (this.hfh != null) {
            this.hfh.onDestroy();
        }
    }

    @Override // com.baidu.live.liveroom.d.d
    public void onChangeSkinType(int i) {
    }
}
