package com.baidu.tieba.home;
/* loaded from: classes.dex */
class h implements com.baidu.adp.widget.ListView.b {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ EnterForumActivity f1217a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(EnterForumActivity enterForumActivity) {
        this.f1217a = enterForumActivity;
    }

    @Override // com.baidu.adp.widget.ListView.b
    public void a(boolean z) {
        com.baidu.tieba.model.l lVar;
        Boolean bool;
        lVar = this.f1217a.c;
        bool = this.f1217a.f;
        lVar.a(bool.booleanValue());
    }
}
