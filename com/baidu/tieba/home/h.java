package com.baidu.tieba.home;
/* loaded from: classes.dex */
class h implements com.baidu.adp.widget.ListView.b {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ EnterForumActivity f1185a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(EnterForumActivity enterForumActivity) {
        this.f1185a = enterForumActivity;
    }

    @Override // com.baidu.adp.widget.ListView.b
    public void a(boolean z) {
        com.baidu.tieba.model.j jVar;
        Boolean bool;
        jVar = this.f1185a.c;
        bool = this.f1185a.f;
        jVar.a(bool.booleanValue());
    }
}
