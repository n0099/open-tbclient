package com.baidu.tieba.frs;

import com.baidu.tieba.model.ck;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bh implements ck {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ FrsImageActivity f1390a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bh(FrsImageActivity frsImageActivity) {
        this.f1390a = frsImageActivity;
    }

    @Override // com.baidu.tieba.model.ck
    public void a(String str, long j) {
        com.baidu.tieba.model.ar arVar;
        arVar = this.f1390a.r;
        arVar.a().setLike(0);
    }

    @Override // com.baidu.tieba.model.ck
    public void b(String str, long j) {
    }
}
