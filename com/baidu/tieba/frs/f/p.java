package com.baidu.tieba.frs.f;

import com.baidu.tbadk.core.view.NoPressedRelativeLayout;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class p implements Runnable {
    final /* synthetic */ i bVC;

    /* JADX INFO: Access modifiers changed from: package-private */
    public p(i iVar) {
        this.bVC = iVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        NoPressedRelativeLayout noPressedRelativeLayout;
        noPressedRelativeLayout = this.bVC.bUK;
        noPressedRelativeLayout.removeView(this.bVC.bVw);
    }
}
