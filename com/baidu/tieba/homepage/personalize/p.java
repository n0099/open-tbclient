package com.baidu.tieba.homepage.personalize;

import android.widget.AbsListView;
import com.baidu.tieba.card.cf;
import com.baidu.tieba.frs.ci;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class p implements AbsListView.OnScrollListener {
    private int cBx = -1;
    private int cBy = 0;
    private boolean cBz = false;
    final /* synthetic */ o this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    public p(o oVar) {
        this.this$0 = oVar;
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScrollStateChanged(AbsListView absListView, int i) {
        com.baidu.tbadk.j.m mVar;
        com.baidu.tbadk.util.s sVar;
        com.baidu.tbadk.j.m mVar2;
        ci ciVar;
        ci ciVar2;
        com.baidu.tieba.play.ac acVar;
        boolean z;
        com.baidu.tieba.play.ac acVar2;
        int i2;
        int i3;
        boolean z2;
        boolean z3;
        com.baidu.tbadk.util.s sVar2;
        com.baidu.tbadk.j.m mVar3;
        com.baidu.tbadk.j.m mVar4;
        mVar = this.this$0.cBg;
        if (mVar == null) {
            this.this$0.cBg = new com.baidu.tbadk.j.m();
            mVar3 = this.this$0.cBg;
            mVar3.fb(1005);
            mVar4 = this.this$0.cBg;
            mVar4.pageType = 1;
        }
        sVar = this.this$0.aJf;
        if (sVar != null) {
            z3 = this.this$0.mIsBackground;
            if (!z3) {
                sVar2 = this.this$0.aJf;
                sVar2.onScrollStateChanged(absListView, i);
            }
        }
        mVar2 = this.this$0.cBg;
        mVar2.Fl();
        if (i == 0) {
            cf.Uw().ds(true);
            if (this.cBz) {
                this.this$0.aiW();
            }
            this.cBz = false;
            acVar = this.this$0.bVJ;
            if (acVar != null) {
                z = this.this$0.cBh;
                if (z) {
                    acVar2 = this.this$0.bVJ;
                    i2 = this.this$0.bVc;
                    i3 = this.this$0.bVd;
                    z2 = this.this$0.bVC;
                    acVar2.a(i2, i3, z2, 1);
                }
            }
        } else if (i == 1) {
            ciVar = this.this$0.cBe;
            if (ciVar != null) {
                ciVar2 = this.this$0.cBe;
                ciVar2.hideTip();
            }
        }
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
        com.baidu.tbadk.util.s sVar;
        boolean z;
        com.baidu.tbadk.util.s sVar2;
        if (this.cBy > i) {
            this.cBz = true;
        }
        sVar = this.this$0.aJf;
        if (sVar != null) {
            z = this.this$0.mIsBackground;
            if (!z) {
                sVar2 = this.this$0.aJf;
                sVar2.a(absListView, this.cBy, i, i2, i3);
            }
        }
        this.cBy = i;
        int i4 = (i + i2) - 1;
        if (!this.cBz && this.cBx != i4) {
            this.cBx = i4;
            this.this$0.kl(this.cBx);
        }
        if (this.cBz && this.cBx != i) {
            this.cBx = i;
            this.this$0.kl(this.cBx);
        }
        this.this$0.cBv = i;
        this.this$0.bVc = i;
        this.this$0.bVd = (i + i2) - 1;
    }
}
