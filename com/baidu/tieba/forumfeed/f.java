package com.baidu.tieba.forumfeed;

import com.baidu.tbadk.core.view.q;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class f implements q {
    final /* synthetic */ a a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(a aVar) {
        this.a = aVar;
    }

    @Override // com.baidu.tbadk.core.view.q
    public void a(boolean z) {
        j jVar;
        if (z) {
            jVar = this.a.d;
            jVar.a();
        }
    }
}
