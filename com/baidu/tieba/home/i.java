package com.baidu.tieba.home;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class i implements com.baidu.adp.widget.ListView.d {
    final /* synthetic */ e a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(e eVar) {
        this.a = eVar;
    }

    @Override // com.baidu.adp.widget.ListView.d
    public void a(boolean z) {
        com.baidu.tieba.model.n nVar;
        Boolean bool;
        nVar = this.a.d;
        bool = this.a.g;
        nVar.a(bool.booleanValue());
    }
}
