package com.baidu.tieba.homepage.personalize;

import android.widget.AbsListView;
import com.baidu.tieba.card.cc;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class o implements AbsListView.OnScrollListener {
    private int czV = -1;
    private int czW = 0;
    private boolean czX = false;
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
        if (this.this$0.czE == null) {
            this.this$0.czE = new com.baidu.tbadk.j.m();
            this.this$0.czE.fe(1005);
            this.this$0.czE.pageType = 1;
        }
        if (this.this$0.cyo != null) {
            z3 = this.this$0.mIsBackground;
            if (!z3) {
                this.this$0.cyo.onScrollStateChanged(absListView, i);
            }
        }
        this.this$0.czE.Gn();
        if (i == 0) {
            cc.TV().cY(true);
            if (this.czX) {
                this.this$0.akv();
            }
            this.czX = false;
            acVar = this.this$0.aRh;
            if (acVar != null) {
                z = this.this$0.czI;
                if (z) {
                    acVar2 = this.this$0.aRh;
                    i2 = this.this$0.aRl;
                    i3 = this.this$0.aRk;
                    z2 = this.this$0.aRj;
                    acVar2.a(i2, i3, z2, 1);
                }
            }
        }
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
        boolean z;
        if (this.czW > i) {
            this.czX = true;
        }
        if (this.this$0.cyo != null) {
            z = this.this$0.mIsBackground;
            if (!z) {
                this.this$0.cyo.a(absListView, this.czW, i, i2, i3);
            }
        }
        this.czW = i;
        int i4 = (i + i2) - 1;
        if (!this.czX && this.czV != i4) {
            this.czV = i4;
            this.this$0.jW(this.czV);
        }
        if (this.czX && this.czV != i) {
            this.czV = i;
            this.this$0.jW(this.czV);
        }
        this.this$0.czT = i;
        this.this$0.aRl = i;
        this.this$0.aRk = (i + i2) - 1;
    }
}
