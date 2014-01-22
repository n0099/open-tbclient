package com.baidu.tieba;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ap implements u {
    final /* synthetic */ MainTabActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ap(MainTabActivity mainTabActivity) {
        this.a = mainTabActivity;
    }

    @Override // com.baidu.tieba.u
    public void a(int i, int i2) {
        w wVar;
        if (i == 4) {
            this.a.r = true;
            this.a.s = true;
            wVar = this.a.l;
            wVar.c.setVisibility(8);
        }
    }
}
