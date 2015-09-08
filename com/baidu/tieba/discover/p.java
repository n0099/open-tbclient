package com.baidu.tieba.discover;

import com.baidu.tbadk.core.view.x;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class p implements x.a {
    final /* synthetic */ a aLD;

    /* JADX INFO: Access modifiers changed from: package-private */
    public p(a aVar) {
        this.aLD = aVar;
    }

    @Override // com.baidu.tbadk.core.view.x.a
    public void onListPullRefresh(boolean z) {
        boolean z2;
        u uVar;
        u uVar2;
        z2 = this.aLD.aLt;
        if (z2) {
            uVar2 = this.aLD.aLl;
            uVar2.GD();
            return;
        }
        uVar = this.aLD.aLl;
        uVar.HL();
    }
}
