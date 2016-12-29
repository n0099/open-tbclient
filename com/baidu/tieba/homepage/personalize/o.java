package com.baidu.tieba.homepage.personalize;

import android.widget.AbsListView;
import com.baidu.tieba.card.bz;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class o implements AbsListView.OnScrollListener {
    private int cqH = -1;
    private int cqI = 0;
    private boolean cqJ = false;
    final /* synthetic */ n this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(n nVar) {
        this.this$0 = nVar;
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScrollStateChanged(AbsListView absListView, int i) {
        com.baidu.tieba.play.aa aaVar;
        boolean z;
        com.baidu.tieba.play.aa aaVar2;
        int i2;
        int i3;
        boolean z2;
        boolean z3;
        if (this.this$0.cqo == null) {
            this.this$0.cqo = new com.baidu.tbadk.performanceLog.m();
            this.this$0.cqo.fg(1005);
            this.this$0.cqo.pageType = 1;
        }
        if (this.this$0.coW != null) {
            z3 = this.this$0.cqs;
            if (!z3) {
                this.this$0.coW.onScrollStateChanged(absListView, i);
            }
        }
        this.this$0.cqo.FB();
        if (i == 0) {
            bz.OH().cy(true);
            if (this.cqJ) {
                this.this$0.ajh();
            }
            this.cqJ = false;
            aaVar = this.this$0.aMd;
            if (aaVar != null) {
                z = this.this$0.cqt;
                if (z) {
                    aaVar2 = this.this$0.aMd;
                    i2 = this.this$0.aMh;
                    i3 = this.this$0.aMg;
                    z2 = this.this$0.aMf;
                    aaVar2.a(i2, i3, z2, 1);
                }
            }
        }
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
        boolean z;
        if (this.cqI > i) {
            this.cqJ = true;
        }
        if (this.this$0.coW != null) {
            z = this.this$0.cqs;
            if (!z) {
                this.this$0.coW.a(absListView, this.cqI, i, i2, i3);
            }
        }
        this.cqI = i;
        int i4 = (i + i2) - 1;
        if (!this.cqJ && this.cqH != i4) {
            this.cqH = i4;
            this.this$0.jy(this.cqH);
        }
        if (this.cqJ && this.cqH != i) {
            this.cqH = i;
            this.this$0.jy(this.cqH);
        }
        this.this$0.cqE = i;
        this.this$0.aMh = i;
        this.this$0.aMg = (i + i2) - 1;
    }
}
