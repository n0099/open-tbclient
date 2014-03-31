package com.baidu.tieba.im.group;
/* loaded from: classes.dex */
final class i implements com.baidu.adp.widget.ListView.d {
    final /* synthetic */ b a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(b bVar) {
        this.a = bVar;
    }

    @Override // com.baidu.adp.widget.ListView.d
    public final void a(boolean z) {
        com.baidu.tieba.im.mygroup.j jVar;
        q qVar;
        com.baidu.tieba.im.mygroup.j jVar2;
        com.baidu.tieba.im.a.a aVar;
        com.baidu.tieba.im.a.a aVar2;
        if (com.baidu.tieba.im.a.a.a) {
            aVar = this.a.c;
            if (aVar != null) {
                aVar2 = this.a.c;
                aVar2.b();
            }
        }
        jVar = this.a.d;
        if (jVar == null) {
            qVar = this.a.b;
            qVar.c();
            return;
        }
        jVar2 = this.a.d;
        jVar2.a();
    }
}
