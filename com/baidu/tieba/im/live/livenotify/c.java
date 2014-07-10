package com.baidu.tieba.im.live.livenotify;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c implements com.baidu.tieba.im.a<Boolean> {
    final /* synthetic */ LiveNotifyActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(LiveNotifyActivity liveNotifyActivity) {
        this.a = liveNotifyActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.im.a
    public void a(Boolean bool) {
        com.baidu.tieba.im.a aVar;
        o oVar;
        s sVar;
        o oVar2;
        s sVar2;
        aVar = this.a.c;
        o.b(aVar);
        oVar = this.a.i;
        oVar.b();
        sVar = this.a.b;
        oVar2 = this.a.i;
        sVar.a(oVar2.d());
        sVar2 = this.a.b;
        sVar2.c();
        this.a.a(false);
    }
}
