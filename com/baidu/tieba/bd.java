package com.baidu.tieba;
/* loaded from: classes.dex */
class bd implements com.baidu.bdcvf.c {
    final /* synthetic */ TiebaApplication a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bd(TiebaApplication tiebaApplication) {
        this.a = tiebaApplication;
    }

    @Override // com.baidu.bdcvf.c
    public void a() {
        this.a.V = true;
    }

    @Override // com.baidu.bdcvf.c
    public void a(int i) {
        this.a.V = false;
    }
}
