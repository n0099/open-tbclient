package com.baidu.tbadk.coreExtra.websocketBase;

import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class t implements b {
    final /* synthetic */ r a;
    private final /* synthetic */ String b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public t(r rVar, String str) {
        this.a = rVar;
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
