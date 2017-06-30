package com.baidu.tieba.homepage.personalize;

import android.widget.AbsListView;
import com.baidu.tieba.card.cf;
import com.baidu.tieba.frs.cj;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class y implements AbsListView.OnScrollListener {
    private int cJu = -1;
    private int cJv = 0;
    private boolean cJw = false;
    final /* synthetic */ x this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    public y(x xVar) {
        this.this$0 = xVar;
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScrollStateChanged(AbsListView absListView, int i) {
        com.baidu.tbadk.j.m mVar;
        com.baidu.tbadk.util.t tVar;
        com.baidu.tbadk.j.m mVar2;
        cj cjVar;
        cj cjVar2;
        com.baidu.tieba.play.ac acVar;
        boolean z;
        com.baidu.tieba.play.ac acVar2;
        int i2;
        int i3;
        boolean z2;
        boolean z3;
        com.baidu.tbadk.util.t tVar2;
        com.baidu.tbadk.j.m mVar3;
        com.baidu.tbadk.j.m mVar4;
        mVar = this.this$0.cJc;
        if (mVar == null) {
            this.this$0.cJc = new com.baidu.tbadk.j.m();
            mVar3 = this.this$0.cJc;
            mVar3.fd(1005);
            mVar4 = this.this$0.cJc;
            mVar4.pageType = 1;
        }
        tVar = this.this$0.aKu;
        if (tVar != null) {
            z3 = this.this$0.mIsBackground;
            if (!z3) {
                tVar2 = this.this$0.aKu;
                tVar2.onScrollStateChanged(absListView, i);
            }
        }
        mVar2 = this.this$0.cJc;
        mVar2.FI();
        if (i == 0) {
            cf.VN().cw(true);
            if (this.cJw) {
                this.this$0.amI();
            }
            this.cJw = false;
            acVar = this.this$0.cdS;
            if (acVar != null) {
                z = this.this$0.cJd;
                if (z) {
                    acVar2 = this.this$0.cdS;
                    i2 = this.this$0.cdm;
                    i3 = this.this$0.baJ;
                    z2 = this.this$0.cdL;
                    acVar2.a(i2, i3, z2, 1);
                }
            }
        } else if (i == 1) {
            cjVar = this.this$0.cJa;
            if (cjVar != null) {
                cjVar2 = this.this$0.cJa;
                cjVar2.hideTip();
            }
        }
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
        com.baidu.tbadk.util.t tVar;
        boolean z;
        com.baidu.tbadk.util.t tVar2;
        if (this.cJv > i) {
            this.cJw = true;
        }
        tVar = this.this$0.aKu;
        if (tVar != null) {
            z = this.this$0.mIsBackground;
            if (!z) {
                tVar2 = this.this$0.aKu;
                tVar2.a(absListView, this.cJv, i, i2, i3);
            }
        }
        this.cJv = i;
        int i4 = (i + i2) - 1;
        if (!this.cJw && this.cJu != i4) {
            this.cJu = i4;
            this.this$0.kw(this.cJu);
        }
        if (this.cJw && this.cJu != i) {
            this.cJu = i;
            this.this$0.kw(this.cJu);
        }
        this.this$0.cJs = i;
        this.this$0.cdm = i;
        this.this$0.baJ = (i + i2) - 1;
    }
}
