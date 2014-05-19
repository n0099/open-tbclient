package com.baidu.tieba.im.group;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class i implements com.baidu.adp.widget.ListView.d {
    final /* synthetic */ b a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(b bVar) {
        this.a = bVar;
    }

    @Override // com.baidu.adp.widget.ListView.d
    public void a(boolean z) {
        com.baidu.tieba.im.mygroup.j jVar;
        q qVar;
        com.baidu.tieba.im.mygroup.j jVar2;
        com.baidu.tieba.im.a.a aVar;
        com.baidu.tieba.im.a.a aVar2;
        if (com.baidu.tieba.im.a.a.a) {
            aVar = this.a.d;
            if (aVar != null) {
                aVar2 = this.a.d;
                aVar2.b();
            }
        }
        jVar = this.a.e;
        if (jVar == null) {
            qVar = this.a.c;
            qVar.c();
            return;
        }
        jVar2 = this.a.e;
        jVar2.a();
    }
}
