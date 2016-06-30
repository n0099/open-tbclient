package com.baidu.tieba.homepage.personalize;

import android.widget.AbsListView;
import com.baidu.tbadk.core.view.at;
import com.baidu.tieba.card.bw;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b implements AbsListView.OnScrollListener {
    private int cqO = -1;
    private int cqP = 0;
    private boolean cqQ = false;
    final /* synthetic */ a cqR;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar) {
        this.cqR = aVar;
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScrollStateChanged(AbsListView absListView, int i) {
        com.baidu.tieba.play.f fVar;
        boolean z;
        com.baidu.tieba.play.f fVar2;
        int i2;
        int i3;
        boolean z2;
        if (this.cqR.cqx == null) {
            this.cqR.cqx = new com.baidu.tbadk.performanceLog.m();
            this.cqR.cqx.eQ(1005);
            this.cqR.cqx.pageType = 1;
        }
        if (this.cqR.cpX != null) {
            this.cqR.cpX.onScrollStateChanged(absListView, i);
        }
        this.cqR.cqx.ED();
        at.vG().aI(i == 0);
        if (i == 0) {
            bw.Lg().cj(true);
            if (this.cqQ) {
                this.cqR.agY();
            }
            this.cqQ = false;
            fVar = this.cqR.aIG;
            if (fVar != null) {
                z = this.cqR.cqC;
                if (z) {
                    fVar2 = this.cqR.aIG;
                    i2 = this.cqR.aKy;
                    i3 = this.cqR.aKx;
                    z2 = this.cqR.aKt;
                    fVar2.a(i2, i3, z2, 1);
                }
            }
        }
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
        if (this.cqP > i) {
            this.cqQ = true;
        }
        if (this.cqR.cpX != null) {
            this.cqR.cpX.a(absListView, this.cqP, i, i2, i3);
        }
        this.cqP = i;
        int i4 = (i + i2) - 1;
        if (!this.cqQ && this.cqO != i4) {
            this.cqO = i4;
            this.cqR.js(this.cqO);
        }
        if (this.cqQ && this.cqO != i) {
            this.cqO = i;
            this.cqR.js(this.cqO);
        }
        this.cqR.aKy = i;
        this.cqR.aKx = (i + i2) - 1;
    }
}
