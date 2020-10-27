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
    private long bmB;
    private long fSB;
    private long gTk;
    private c gZd;
    private com.baidu.tieba.ala.liveroom.challenge.b.a gZe;
    private List<com.baidu.tieba.ala.liveroom.challenge.a.a> gZf = new ArrayList();
    private final c.a gZg = new c.a() { // from class: com.baidu.tieba.ala.liveroom.challenge.view.b.1
        @Override // com.baidu.tieba.ala.liveroom.challenge.view.c.a
        public void onScrollToBottom() {
            if (b.this.gZe != null) {
                b.this.gZe.bMi();
            }
        }

        @Override // com.baidu.tieba.ala.liveroom.challenge.view.c.a
        public void bYs() {
            if (b.this.gZe != null) {
                b.this.gZe.refresh();
            }
        }
    };
    private final a.InterfaceC0655a gZh = new a.InterfaceC0655a() { // from class: com.baidu.tieba.ala.liveroom.challenge.view.b.2
        @Override // com.baidu.tieba.ala.liveroom.challenge.b.a.InterfaceC0655a
        public void e(boolean z, List<com.baidu.tieba.ala.liveroom.challenge.a.a> list) {
            b.this.gZf = list;
            if (b.this.gZd != null) {
                b.this.gZd.completePullRefresh();
                b.this.gZd.Oj();
                if (ListUtils.isEmpty(list)) {
                    b.this.gZd.cl(false);
                    b.this.gZd.bMI();
                    return;
                }
                if (z) {
                    b.this.gZd.bMx();
                } else {
                    b.this.gZd.bMw();
                }
                b.this.gZd.setData(list);
            }
        }

        @Override // com.baidu.tieba.ala.liveroom.challenge.b.a.InterfaceC0655a
        public void h(int i, String str, boolean z) {
            if (b.this.gZd != null) {
                b.this.gZd.completePullRefresh();
                b.this.gZd.Oj();
                b.this.gZd.bMI();
                if (!ListUtils.isEmpty(b.this.gZf)) {
                    BdUtilHelper.showToast(b.this.mTbPageContext.getPageActivity(), str);
                } else if (BdNetTypeUtil.isNetWorkAvailable()) {
                    b.this.gZd.cl(false);
                } else {
                    b.this.gZd.cl(true);
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
        this.gZd = new c(this.mTbPageContext, this.mType, this.mIsHost);
        this.gZd.a(this.gZg);
        this.gZe = new com.baidu.tieba.ala.liveroom.challenge.b.a(this.mTbPageContext, this.mType, this.mIsHost);
        this.gZe.a(this.gZh);
    }

    public void e(long j, long j2, long j3) {
        this.gTk = j;
        this.bmB = j2;
        this.fSB = j3;
        this.gZd.c(this.gTk, this.bmB, this.fSB);
        this.gZe.c(this.gTk, this.bmB, this.fSB);
        this.gZe.refresh();
    }

    @Override // com.baidu.live.liveroom.d.d
    public View getPanelView() {
        return this.gZd.getView();
    }

    @Override // com.baidu.live.liveroom.d.d
    public String getTitle() {
        return this.mType == 2 ? this.mTbPageContext.getResources().getString(a.i.ala_challenge_jinzhu_reval) : this.mTbPageContext.getResources().getString(a.i.ala_challenge_jinzhu_anchor);
    }

    @Override // com.baidu.live.liveroom.d.d
    public String KR() {
        return null;
    }

    @Override // com.baidu.live.liveroom.d.d
    public short KS() {
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
        if (this.gZe != null) {
            this.gZe.onDestroy();
        }
        if (this.gZd != null) {
            this.gZd.onDestroy();
        }
    }

    @Override // com.baidu.live.liveroom.d.d
    public void onChangeSkinType(int i) {
    }
}
