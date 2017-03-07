package com.baidu.tieba.homepage.personalize;

import android.widget.AbsListView;
import com.baidu.tieba.card.cc;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class o implements AbsListView.OnScrollListener {
    private int cze = -1;
    private int czf = 0;
    private boolean czg = false;
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
        if (this.this$0.cyN == null) {
            this.this$0.cyN = new com.baidu.tbadk.performanceLog.m();
            this.this$0.cyN.fb(1005);
            this.this$0.cyN.pageType = 1;
        }
        if (this.this$0.cxx != null) {
            z3 = this.this$0.mIsBackground;
            if (!z3) {
                this.this$0.cxx.onScrollStateChanged(absListView, i);
            }
        }
        this.this$0.cyN.FP();
        if (i == 0) {
            cc.Sv().cM(true);
            if (this.czg) {
                this.this$0.ajA();
            }
            this.czg = false;
            acVar = this.this$0.aQP;
            if (acVar != null) {
                z = this.this$0.cyR;
                if (z) {
                    acVar2 = this.this$0.aQP;
                    i2 = this.this$0.aQT;
                    i3 = this.this$0.aQS;
                    z2 = this.this$0.aQR;
                    acVar2.a(i2, i3, z2, 1);
                }
            }
        }
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
        boolean z;
        if (this.czf > i) {
            this.czg = true;
        }
        if (this.this$0.cxx != null) {
            z = this.this$0.mIsBackground;
            if (!z) {
                this.this$0.cxx.a(absListView, this.czf, i, i2, i3);
            }
        }
        this.czf = i;
        int i4 = (i + i2) - 1;
        if (!this.czg && this.cze != i4) {
            this.cze = i4;
            this.this$0.jP(this.cze);
        }
        if (this.czg && this.cze != i) {
            this.cze = i;
            this.this$0.jP(this.cze);
        }
        this.this$0.czc = i;
        this.this$0.aQT = i;
        this.this$0.aQS = (i + i2) - 1;
    }
}
