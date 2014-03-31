package com.baidu.tieba.im.chat;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class aa implements com.baidu.tieba.im.a<Boolean> {
    final /* synthetic */ x a;
    private final /* synthetic */ com.baidu.tieba.im.message.a.b b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aa(x xVar, com.baidu.tieba.im.message.a.b bVar) {
        this.a = xVar;
        this.b = bVar;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // com.baidu.tieba.im.a
    public final /* synthetic */ void a(Boolean bool) {
        this.b.i(System.currentTimeMillis());
        com.baidu.adp.framework.c.a().a(this.b);
        com.baidu.adp.lib.util.f.e("SHANG sendMessage to queue");
    }
}
