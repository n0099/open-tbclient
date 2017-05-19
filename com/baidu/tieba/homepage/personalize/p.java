package com.baidu.tieba.homepage.personalize;

import android.widget.AbsListView;
import com.baidu.tieba.card.ca;
import com.baidu.tieba.frs.ch;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class p implements AbsListView.OnScrollListener {
    private int cvf = -1;
    private int cvg = 0;
    private boolean cvh = false;
    final /* synthetic */ o this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    public p(o oVar) {
        this.this$0 = oVar;
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScrollStateChanged(AbsListView absListView, int i) {
        com.baidu.tbadk.util.s sVar;
        ch chVar;
        ch chVar2;
        com.baidu.tieba.play.ac acVar;
        boolean z;
        com.baidu.tieba.play.ac acVar2;
        int i2;
        int i3;
        boolean z2;
        boolean z3;
        com.baidu.tbadk.util.s sVar2;
        if (this.this$0.cuO == null) {
            this.this$0.cuO = new com.baidu.tbadk.j.m();
            this.this$0.cuO.fa(1005);
            this.this$0.cuO.pageType = 1;
        }
        sVar = this.this$0.aJs;
        if (sVar != null) {
            z3 = this.this$0.mIsBackground;
            if (!z3) {
                sVar2 = this.this$0.aJs;
                sVar2.onScrollStateChanged(absListView, i);
            }
        }
        this.this$0.cuO.Fr();
        if (i == 0) {
            ca.To().db(true);
            if (this.cvh) {
                this.this$0.ahH();
            }
            this.cvh = false;
            acVar = this.this$0.aRC;
            if (acVar != null) {
                z = this.this$0.cuP;
                if (z) {
                    acVar2 = this.this$0.aRC;
                    i2 = this.this$0.aRG;
                    i3 = this.this$0.aRF;
                    z2 = this.this$0.aRE;
                    acVar2.a(i2, i3, z2, 1);
                }
            }
        } else if (i == 1) {
            chVar = this.this$0.cuM;
            if (chVar != null) {
                chVar2 = this.this$0.cuM;
                chVar2.hideTip();
            }
        }
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
        com.baidu.tbadk.util.s sVar;
        boolean z;
        com.baidu.tbadk.util.s sVar2;
        if (this.cvg > i) {
            this.cvh = true;
        }
        sVar = this.this$0.aJs;
        if (sVar != null) {
            z = this.this$0.mIsBackground;
            if (!z) {
                sVar2 = this.this$0.aJs;
                sVar2.a(absListView, this.cvg, i, i2, i3);
            }
        }
        this.cvg = i;
        int i4 = (i + i2) - 1;
        if (!this.cvh && this.cvf != i4) {
            this.cvf = i4;
            this.this$0.jN(this.cvf);
        }
        if (this.cvh && this.cvf != i) {
            this.cvf = i;
            this.this$0.jN(this.cvf);
        }
        this.this$0.cvd = i;
        this.this$0.aRG = i;
        this.this$0.aRF = (i + i2) - 1;
    }
}
