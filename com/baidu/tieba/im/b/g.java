package com.baidu.tieba.im.b;

import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class g implements com.baidu.tieba.im.net.c {
    final /* synthetic */ a a;
    private final /* synthetic */ String b;
    private final /* synthetic */ int c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(a aVar, String str, int i) {
        this.a = aVar;
        this.b = str;
        this.c = i;
    }

    @Override // com.baidu.tieba.im.net.c
    public final void a() {
        List list;
        this.a.s = 0;
        this.a.t = com.baidu.tieba.im.net.b.a().c();
        list = this.a.t;
        if (list == null) {
            this.a.p = false;
        } else {
            this.a.a(this.b, this.c);
        }
    }
}
