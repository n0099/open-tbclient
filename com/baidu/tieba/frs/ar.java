package com.baidu.tieba.frs;

import com.baidu.tieba.frs.r;
/* loaded from: classes.dex */
class ar implements Runnable {
    final /* synthetic */ r.a bVg;
    private final /* synthetic */ String bVh;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ar(r.a aVar, String str) {
        this.bVg = aVar;
        this.bVh = str;
    }

    @Override // java.lang.Runnable
    public void run() {
        com.baidu.tbadk.core.util.z zVar = new com.baidu.tbadk.core.util.z(this.bVh);
        zVar.uF().vA().mIsNeedAddCommenParam = false;
        zVar.uF().vA().mIsUseCurrentBDUSS = false;
        zVar.uh();
    }
}
