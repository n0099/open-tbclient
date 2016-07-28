package com.baidu.tieba.homepage.personalize;

import android.widget.AbsListView;
import com.baidu.tbadk.core.view.at;
import com.baidu.tieba.card.bw;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c implements AbsListView.OnScrollListener {
    private int ctw = -1;
    private int ctx = 0;
    private boolean cty = false;
    final /* synthetic */ b ctz;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(b bVar) {
        this.ctz = bVar;
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScrollStateChanged(AbsListView absListView, int i) {
        com.baidu.tieba.play.f fVar;
        boolean z;
        com.baidu.tieba.play.f fVar2;
        int i2;
        int i3;
        boolean z2;
        if (this.ctz.ctc == null) {
            this.ctz.ctc = new com.baidu.tbadk.performanceLog.m();
            this.ctz.ctc.eQ(1005);
            this.ctz.ctc.pageType = 1;
        }
        if (this.ctz.csC != null) {
            this.ctz.csC.onScrollStateChanged(absListView, i);
        }
        this.ctz.ctc.EC();
        at.vG().aL(i == 0);
        if (i == 0) {
            bw.Lf().cl(true);
            if (this.cty) {
                this.ctz.ahF();
            }
            this.cty = false;
            fVar = this.ctz.aJx;
            if (fVar != null) {
                z = this.ctz.cth;
                if (z) {
                    fVar2 = this.ctz.aJx;
                    i2 = this.ctz.aLr;
                    i3 = this.ctz.aLq;
                    z2 = this.ctz.aLm;
                    fVar2.a(i2, i3, z2, 1);
                }
            }
        }
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
        if (this.ctx > i) {
            this.cty = true;
        }
        if (this.ctz.csC != null) {
            this.ctz.csC.a(absListView, this.ctx, i, i2, i3);
        }
        this.ctx = i;
        int i4 = (i + i2) - 1;
        if (!this.cty && this.ctw != i4) {
            this.ctw = i4;
            this.ctz.jx(this.ctw);
        }
        if (this.cty && this.ctw != i) {
            this.ctw = i;
            this.ctz.jx(this.ctw);
        }
        this.ctz.ctu = i;
        this.ctz.aLr = i;
        this.ctz.aLq = (i + i2) - 1;
    }
}
