package com.baidu.tbadk.coreExtra.d;

import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class t implements b {
    final /* synthetic */ q a;
    private final /* synthetic */ String b;
    private final /* synthetic */ int c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public t(q qVar, String str, int i) {
        this.a = qVar;
        this.b = str;
        this.c = i;
    }

    @Override // com.baidu.tbadk.coreExtra.d.b
    public final void a() {
        a aVar;
        List list;
        this.a.d = 0;
        q qVar = this.a;
        aVar = d.a;
        qVar.g = aVar.a();
        list = this.a.g;
        if (list == null) {
            this.a.h = false;
        } else {
            this.a.a(this.b, this.c);
        }
    }
}
