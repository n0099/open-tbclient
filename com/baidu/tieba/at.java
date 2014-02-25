package com.baidu.tieba;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class at implements com.baidu.tbplugin.h {
    final /* synthetic */ TiebaApplication a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public at(TiebaApplication tiebaApplication) {
        this.a = tiebaApplication;
    }

    @Override // com.baidu.tbplugin.h
    public void a(int i, String str) {
        if (i != 0) {
            com.baidu.adp.lib.util.f.b("Installation Error: " + str);
        } else {
            com.baidu.adp.lib.util.f.d("Installation Success");
        }
    }

    @Override // com.baidu.tbplugin.h
    public void a(int i) {
    }
}
