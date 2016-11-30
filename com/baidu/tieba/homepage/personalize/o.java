package com.baidu.tieba.homepage.personalize;

import android.widget.AbsListView;
import com.baidu.tieba.card.bx;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class o implements AbsListView.OnScrollListener {
    private int cLm = -1;
    private int cLn = 0;
    private boolean cLo = false;
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
        if (this.this$0.cKT == null) {
            this.this$0.cKT = new com.baidu.tbadk.performanceLog.m();
            this.this$0.cKT.fg(1005);
            this.this$0.cKT.pageType = 1;
        }
        if (this.this$0.cJB != null) {
            z3 = this.this$0.cKX;
            if (!z3) {
                this.this$0.cJB.onScrollStateChanged(absListView, i);
            }
        }
        this.this$0.cKT.Gb();
        if (i == 0) {
            bx.Pl().cw(true);
            if (this.cLo) {
                this.this$0.aoH();
            }
            this.cLo = false;
            aaVar = this.this$0.aMM;
            if (aaVar != null) {
                z = this.this$0.cKY;
                if (z) {
                    aaVar2 = this.this$0.aMM;
                    i2 = this.this$0.aMQ;
                    i3 = this.this$0.aMP;
                    z2 = this.this$0.aMO;
                    aaVar2.a(i2, i3, z2, 1);
                }
            }
        }
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
        boolean z;
        if (this.cLn > i) {
            this.cLo = true;
        }
        if (this.this$0.cJB != null) {
            z = this.this$0.cKX;
            if (!z) {
                this.this$0.cJB.a(absListView, this.cLn, i, i2, i3);
            }
        }
        this.cLn = i;
        int i4 = (i + i2) - 1;
        if (!this.cLo && this.cLm != i4) {
            this.cLm = i4;
            this.this$0.kn(this.cLm);
        }
        if (this.cLo && this.cLm != i) {
            this.cLm = i;
            this.this$0.kn(this.cLm);
        }
        this.this$0.cLj = i;
        this.this$0.aMQ = i;
        this.this$0.aMP = (i + i2) - 1;
    }
}
