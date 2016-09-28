package com.baidu.tieba.homepage.personalize;

import android.widget.AbsListView;
import com.baidu.tieba.card.cb;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class n implements AbsListView.OnScrollListener {
    private int cGb = -1;
    private int cGc = 0;
    private boolean cGd = false;
    final /* synthetic */ m this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(m mVar) {
        this.this$0 = mVar;
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScrollStateChanged(AbsListView absListView, int i) {
        com.baidu.tieba.play.k kVar;
        boolean z;
        com.baidu.tieba.play.k kVar2;
        int i2;
        int i3;
        boolean z2;
        boolean z3;
        if (this.this$0.cFF == null) {
            this.this$0.cFF = new com.baidu.tbadk.performanceLog.m();
            this.this$0.cFF.fd(1005);
            this.this$0.cFF.pageType = 1;
        }
        if (this.this$0.cEo != null) {
            z3 = this.this$0.cFJ;
            if (!z3) {
                this.this$0.cEo.onScrollStateChanged(absListView, i);
            }
        }
        this.this$0.cFF.FV();
        if (i == 0) {
            cb.Oj().cr(true);
            if (this.cGd) {
                this.this$0.amM();
            }
            this.cGd = false;
            kVar = this.this$0.aMo;
            if (kVar != null) {
                z = this.this$0.cFK;
                if (z) {
                    kVar2 = this.this$0.aMo;
                    i2 = this.this$0.aMt;
                    i3 = this.this$0.aMs;
                    z2 = this.this$0.aMq;
                    kVar2.a(i2, i3, z2, 1);
                }
            }
        }
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
        boolean z;
        if (this.cGc > i) {
            this.cGd = true;
        }
        if (this.this$0.cEo != null) {
            z = this.this$0.cFJ;
            if (!z) {
                this.this$0.cEo.a(absListView, this.cGc, i, i2, i3);
            }
        }
        this.cGc = i;
        int i4 = (i + i2) - 1;
        if (!this.cGd && this.cGb != i4) {
            this.cGb = i4;
            this.this$0.kg(this.cGb);
        }
        if (this.cGd && this.cGb != i) {
            this.cGb = i;
            this.this$0.kg(this.cGb);
        }
        this.this$0.cFY = i;
        this.this$0.aMt = i;
        this.this$0.aMs = (i + i2) - 1;
    }
}
