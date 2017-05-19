package com.baidu.tieba.frs.e;

import com.baidu.tbadk.core.view.NoPressedRelativeLayout;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class p implements Runnable {
    final /* synthetic */ i cbx;

    /* JADX INFO: Access modifiers changed from: package-private */
    public p(i iVar) {
        this.cbx = iVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        NoPressedRelativeLayout noPressedRelativeLayout;
        noPressedRelativeLayout = this.cbx.caH;
        noPressedRelativeLayout.removeView(this.cbx.cbr);
    }
}
