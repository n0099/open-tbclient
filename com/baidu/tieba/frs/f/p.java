package com.baidu.tieba.frs.f;

import com.baidu.tbadk.core.view.NoPressedRelativeLayout;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class p implements Runnable {
    final /* synthetic */ i ccU;

    /* JADX INFO: Access modifiers changed from: package-private */
    public p(i iVar) {
        this.ccU = iVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        NoPressedRelativeLayout noPressedRelativeLayout;
        noPressedRelativeLayout = this.ccU.ccc;
        noPressedRelativeLayout.removeView(this.ccU.ccO);
    }
}
