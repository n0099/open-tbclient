package com.baidu.tieba.home;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class l implements m {
    final /* synthetic */ k a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(k kVar) {
        this.a = kVar;
    }

    @Override // com.baidu.tieba.home.m
    public void a(com.baidu.tieba.data.aa aaVar) {
        r rVar;
        r rVar2;
        rVar = this.a.e;
        if (rVar != null) {
            rVar2 = this.a.e;
            rVar2.a(aaVar);
        }
        this.a.notifyDataSetChanged();
    }
}
