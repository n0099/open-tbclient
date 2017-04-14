package com.baidu.tieba.homepage.personalize;

import android.widget.AbsListView;
import com.baidu.tieba.card.cc;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class o implements AbsListView.OnScrollListener {
    private int cxE = -1;
    private int cxF = 0;
    private boolean cxG = false;
    final /* synthetic */ n this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(n nVar) {
        this.this$0 = nVar;
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScrollStateChanged(AbsListView absListView, int i) {
        com.baidu.tieba.play.ac acVar;
        boolean z;
        com.baidu.tieba.play.ac acVar2;
        int i2;
        int i3;
        boolean z2;
        boolean z3;
        if (this.this$0.cxn == null) {
            this.this$0.cxn = new com.baidu.tbadk.j.m();
            this.this$0.cxn.fe(1005);
            this.this$0.cxn.pageType = 1;
        }
        if (this.this$0.cvX != null) {
            z3 = this.this$0.mIsBackground;
            if (!z3) {
                this.this$0.cvX.onScrollStateChanged(absListView, i);
            }
        }
        this.this$0.cxn.Gn();
        if (i == 0) {
            cc.ST().cO(true);
            if (this.cxG) {
                this.this$0.aju();
            }
            this.cxG = false;
            acVar = this.this$0.aRf;
            if (acVar != null) {
                z = this.this$0.cxr;
                if (z) {
                    acVar2 = this.this$0.aRf;
                    i2 = this.this$0.aRj;
                    i3 = this.this$0.aRi;
                    z2 = this.this$0.aRh;
                    acVar2.a(i2, i3, z2, 1);
                }
            }
        }
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
        boolean z;
        if (this.cxF > i) {
            this.cxG = true;
        }
        if (this.this$0.cvX != null) {
            z = this.this$0.mIsBackground;
            if (!z) {
                this.this$0.cvX.a(absListView, this.cxF, i, i2, i3);
            }
        }
        this.cxF = i;
        int i4 = (i + i2) - 1;
        if (!this.cxG && this.cxE != i4) {
            this.cxE = i4;
            this.this$0.jQ(this.cxE);
        }
        if (this.cxG && this.cxE != i) {
            this.cxE = i;
            this.this$0.jQ(this.cxE);
        }
        this.this$0.cxC = i;
        this.this$0.aRj = i;
        this.this$0.aRi = (i + i2) - 1;
    }
}
