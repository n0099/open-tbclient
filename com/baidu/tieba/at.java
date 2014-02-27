package com.baidu.tieba;
/* loaded from: classes.dex */
final class at implements com.baidu.tbplugin.h {
    final /* synthetic */ TiebaApplication a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public at(TiebaApplication tiebaApplication) {
        this.a = tiebaApplication;
    }

    @Override // com.baidu.tbplugin.h
    public final void a(int i, String str) {
        if (i != 0) {
            com.baidu.adp.lib.util.e.b("Installation Error: " + str);
        } else {
            com.baidu.adp.lib.util.e.d("Installation Success");
        }
    }
}
