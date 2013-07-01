package com.baidu.tieba.home;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class l implements m {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ k f933a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(k kVar) {
        this.f933a = kVar;
    }

    @Override // com.baidu.tieba.home.m
    public void a(com.baidu.tieba.data.aa aaVar) {
        r rVar;
        r rVar2;
        rVar = this.f933a.e;
        if (rVar != null) {
            rVar2 = this.f933a.e;
            rVar2.a(aaVar);
        }
        this.f933a.notifyDataSetChanged();
    }
}
