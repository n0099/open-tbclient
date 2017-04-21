package com.baidu.tieba.frs.g;

import com.baidu.tbadk.core.view.NoPressedRelativeLayout;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class p implements Runnable {
    final /* synthetic */ i cdM;

    /* JADX INFO: Access modifiers changed from: package-private */
    public p(i iVar) {
        this.cdM = iVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        NoPressedRelativeLayout noPressedRelativeLayout;
        noPressedRelativeLayout = this.cdM.ccU;
        noPressedRelativeLayout.removeView(this.cdM.cdG);
    }
}
