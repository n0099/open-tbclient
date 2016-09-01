package com.baidu.tieba.homepage.personalize;

import android.widget.AbsListView;
import com.baidu.tbadk.core.view.au;
import com.baidu.tieba.card.cd;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c implements AbsListView.OnScrollListener {
    private int cFc = -1;
    private int cFd = 0;
    private boolean cFe = false;
    final /* synthetic */ b this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(b bVar) {
        this.this$0 = bVar;
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScrollStateChanged(AbsListView absListView, int i) {
        com.baidu.tieba.play.i iVar;
        boolean z;
        com.baidu.tieba.play.i iVar2;
        int i2;
        int i3;
        boolean z2;
        if (this.this$0.cEI == null) {
            this.this$0.cEI = new com.baidu.tbadk.performanceLog.m();
            this.this$0.cEI.fe(1005);
            this.this$0.cEI.pageType = 1;
        }
        if (this.this$0.cDK != null) {
            this.this$0.cDK.onScrollStateChanged(absListView, i);
        }
        this.this$0.cEI.FW();
        au.wK().aM(i == 0);
        if (i == 0) {
            cd.NI().cr(true);
            if (this.cFe) {
                this.this$0.amu();
            }
            this.cFe = false;
            iVar = this.this$0.aNV;
            if (iVar != null) {
                z = this.this$0.cEN;
                if (z) {
                    iVar2 = this.this$0.aNV;
                    i2 = this.this$0.aQc;
                    i3 = this.this$0.aQb;
                    z2 = this.this$0.aPX;
                    iVar2.a(i2, i3, z2, 1);
                }
            }
        }
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
        if (this.cFd > i) {
            this.cFe = true;
        }
        if (this.this$0.cDK != null) {
            this.this$0.cDK.a(absListView, this.cFd, i, i2, i3);
        }
        this.cFd = i;
        int i4 = (i + i2) - 1;
        if (!this.cFe && this.cFc != i4) {
            this.cFc = i4;
            this.this$0.ka(this.cFc);
        }
        if (this.cFe && this.cFc != i) {
            this.cFc = i;
            this.this$0.ka(this.cFc);
        }
        this.this$0.cFa = i;
        this.this$0.aQc = i;
        this.this$0.aQb = (i + i2) - 1;
    }
}
