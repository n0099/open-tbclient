package com.baidu.tieba.home;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class l implements m {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ k f1155a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(k kVar) {
        this.f1155a = kVar;
    }

    @Override // com.baidu.tieba.home.m
    public void a(com.baidu.tieba.data.ai aiVar) {
        r rVar;
        r rVar2;
        rVar = this.f1155a.e;
        if (rVar != null) {
            rVar2 = this.f1155a.e;
            rVar2.a(aiVar);
        }
        this.f1155a.notifyDataSetChanged();
    }
}
