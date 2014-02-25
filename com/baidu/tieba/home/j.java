package com.baidu.tieba.home;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class j implements com.baidu.adp.widget.ListView.b {
    final /* synthetic */ f a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(f fVar) {
        this.a = fVar;
    }

    @Override // com.baidu.adp.widget.ListView.b
    public void a(boolean z) {
        com.baidu.tieba.model.k kVar;
        Boolean bool;
        kVar = this.a.d;
        bool = this.a.g;
        kVar.a(bool.booleanValue());
    }
}
