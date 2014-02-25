package com.baidu.tieba.guide;

import com.baidu.tieba.model.by;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class w implements by {
    final /* synthetic */ u a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public w(u uVar) {
        this.a = uVar;
    }

    @Override // com.baidu.tieba.model.by
    public void a(String str, long j) {
        a aVar;
        int a = com.baidu.adp.lib.f.b.a(String.valueOf(j), 0);
        aVar = this.a.c;
        aVar.b(a);
        this.a.a(a, false);
    }

    @Override // com.baidu.tieba.model.by
    public void b(String str, long j) {
    }
}
