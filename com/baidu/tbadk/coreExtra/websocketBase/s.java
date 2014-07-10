package com.baidu.tbadk.coreExtra.websocketBase;

import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class s implements b {
    final /* synthetic */ q a;
    private final /* synthetic */ String b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public s(q qVar, String str) {
        this.a = qVar;
        this.b = str;
    }

    @Override // com.baidu.tbadk.coreExtra.websocketBase.b
    public void a() {
        List list;
        this.a.c = 0;
        this.a.f = a.a().d();
        list = this.a.f;
        if (list == null) {
            this.a.g = false;
        } else {
            this.a.b(this.b);
        }
    }
}
