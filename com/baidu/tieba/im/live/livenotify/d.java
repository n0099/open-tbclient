package com.baidu.tieba.im.live.livenotify;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d implements com.baidu.tieba.im.a<Boolean> {
    final /* synthetic */ LiveNotifyActivity a;
    private final /* synthetic */ com.baidu.tieba.im.a b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(LiveNotifyActivity liveNotifyActivity, com.baidu.tieba.im.a aVar) {
        this.a = liveNotifyActivity;
        this.b = aVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.im.a
    public void a(Boolean bool) {
        o oVar;
        s sVar;
        o oVar2;
        s sVar2;
        o.b(this.b);
        oVar = this.a.g;
        oVar.b();
        sVar = this.a.b;
        oVar2 = this.a.g;
        sVar.a(oVar2.d());
        sVar2 = this.a.b;
        sVar2.c();
        this.a.a(false);
    }
}
