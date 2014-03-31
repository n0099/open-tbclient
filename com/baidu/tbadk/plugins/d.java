package com.baidu.tbadk.plugins;

import com.baidu.tbplugin.i;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class d implements i {
    final /* synthetic */ a a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(a aVar) {
        this.a = aVar;
    }

    @Override // com.baidu.tbplugin.i
    public final void a(int i, String str) {
        if (i != 0) {
            com.baidu.adp.lib.util.f.b("Installation Error: " + str);
        } else {
            com.baidu.adp.lib.util.f.d("Installation Success");
        }
    }
}
