package com.baidu.tieba.forumfeed;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c implements com.baidu.adp.widget.ListView.f {
    final /* synthetic */ a ayj;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(a aVar) {
        this.ayj = aVar;
    }

    @Override // com.baidu.adp.widget.ListView.f
    public void H(boolean z) {
        this.ayj.refresh();
    }
}
