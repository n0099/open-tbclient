package com.baidu.tieba.im.b;

import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class g implements com.baidu.tieba.im.net.c {
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
    public void a() {
        List list;
        this.a.r = 0;
        this.a.s = com.baidu.tieba.im.net.b.a().d();
        list = this.a.s;
        if (list == null) {
            this.a.p = false;
        } else {
            this.a.a(this.b, this.c);
        }
    }
}
