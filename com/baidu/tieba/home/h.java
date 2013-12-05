package com.baidu.tieba.home;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class h implements com.baidu.adp.widget.ListView.b {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ EnterForumActivity f1493a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(EnterForumActivity enterForumActivity) {
        this.f1493a = enterForumActivity;
    }

    @Override // com.baidu.adp.widget.ListView.b
    public void a(boolean z) {
        com.baidu.tieba.model.t tVar;
        Boolean bool;
        tVar = this.f1493a.c;
        bool = this.f1493a.f;
        if (tVar.a(bool.booleanValue())) {
        }
    }
}
