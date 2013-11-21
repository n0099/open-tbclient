package com.baidu.tieba.im.b;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class f implements com.baidu.adp.widget.ListView.b {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ d f1470a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(d dVar) {
        this.f1470a = dVar;
    }

    @Override // com.baidu.adp.widget.ListView.b
    public void a(boolean z) {
        if (!this.f1470a.b.b()) {
            this.f1470a.i();
            this.f1470a.f1468a.a();
            return;
        }
        this.f1470a.a();
    }
}
