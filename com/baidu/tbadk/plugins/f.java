package com.baidu.tbadk.plugins;

import com.baidu.tbplugin.i;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class f implements i {
    final /* synthetic */ a a;
    private final /* synthetic */ com.baidu.tbplugin.c b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(a aVar, com.baidu.tbplugin.c cVar) {
        this.a = aVar;
        this.b = cVar;
    }

    @Override // com.baidu.tbplugin.i
    public final void a(int i, String str) {
        if (i != 0) {
            com.baidu.adp.lib.util.f.b("Installation Error: " + str);
        }
        if (this.b != null) {
            this.b.a();
        }
    }
}
