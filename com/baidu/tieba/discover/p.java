package com.baidu.tieba.discover;

import com.baidu.tbadk.core.view.r;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class p implements r.a {
    final /* synthetic */ a aRT;

    /* JADX INFO: Access modifiers changed from: package-private */
    public p(a aVar) {
        this.aRT = aVar;
    }

    @Override // com.baidu.tbadk.core.view.r.a
    public void onListPullRefresh(boolean z) {
        boolean z2;
        t tVar;
        t tVar2;
        z2 = this.aRT.aRJ;
        if (z2) {
            tVar2 = this.aRT.aRB;
            tVar2.Hm();
            return;
        }
        tVar = this.aRT.aRB;
        tVar.Ji();
    }
}
