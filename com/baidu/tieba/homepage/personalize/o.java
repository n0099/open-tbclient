package com.baidu.tieba.homepage.personalize;

import android.widget.AbsListView;
import com.baidu.tieba.card.cc;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class o implements AbsListView.OnScrollListener {
    private int cxI = -1;
    private int cxJ = 0;
    private boolean cxK = false;
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
        if (this.this$0.cxo == null) {
            this.this$0.cxo = new com.baidu.tbadk.performanceLog.m();
            this.this$0.cxo.fh(1005);
            this.this$0.cxo.pageType = 1;
        }
        if (this.this$0.cvY != null) {
            z3 = this.this$0.mIsBackground;
            if (!z3) {
                this.this$0.cvY.onScrollStateChanged(absListView, i);
            }
        }
        this.this$0.cxo.Fv();
        if (i == 0) {
            cc.Rx().cM(true);
            if (this.cxK) {
                this.this$0.ako();
            }
            this.cxK = false;
            acVar = this.this$0.aLe;
            if (acVar != null) {
                z = this.this$0.cxs;
                if (z) {
                    acVar2 = this.this$0.aLe;
                    i2 = this.this$0.aLi;
                    i3 = this.this$0.aLh;
                    z2 = this.this$0.aLg;
                    acVar2.a(i2, i3, z2, 1);
                }
            }
        }
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
        boolean z;
        if (this.cxJ > i) {
            this.cxK = true;
        }
        if (this.this$0.cvY != null) {
            z = this.this$0.mIsBackground;
            if (!z) {
                this.this$0.cvY.a(absListView, this.cxJ, i, i2, i3);
            }
        }
        this.cxJ = i;
        int i4 = (i + i2) - 1;
        if (!this.cxK && this.cxI != i4) {
            this.cxI = i4;
            this.this$0.kl(this.cxI);
        }
        if (this.cxK && this.cxI != i) {
            this.cxI = i;
            this.this$0.kl(this.cxI);
        }
        this.this$0.cxF = i;
        this.this$0.aLi = i;
        this.this$0.aLh = (i + i2) - 1;
    }
}
