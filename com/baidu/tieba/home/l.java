package com.baidu.tieba.home;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class l implements com.baidu.adp.widget.ListView.b {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ EnterForumActivity f1456a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(EnterForumActivity enterForumActivity) {
        this.f1456a = enterForumActivity;
    }

    @Override // com.baidu.adp.widget.ListView.b
    public void a(boolean z) {
        com.baidu.tieba.model.t tVar;
        Boolean bool;
        tVar = this.f1456a.e;
        bool = this.f1456a.h;
        if (tVar.a(bool.booleanValue())) {
        }
    }
}
