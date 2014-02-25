package com.baidu.tieba;
/* loaded from: classes.dex */
class af implements o {
    final /* synthetic */ MainTabActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public af(MainTabActivity mainTabActivity) {
        this.a = mainTabActivity;
    }

    @Override // com.baidu.tieba.o
    public void a(int i, int i2) {
        q qVar;
        if (i == 4) {
            this.a.r = true;
            this.a.s = true;
            qVar = this.a.m;
            qVar.c.setVisibility(8);
        }
    }
}
