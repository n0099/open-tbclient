package com.baidu.tieba.frs;

import com.baidu.tieba.model.cj;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bh implements cj {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ FrsImageActivity f1334a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bh(FrsImageActivity frsImageActivity) {
        this.f1334a = frsImageActivity;
    }

    @Override // com.baidu.tieba.model.cj
    public void a(String str, long j) {
        com.baidu.tieba.model.ar arVar;
        bl blVar;
        arVar = this.f1334a.r;
        arVar.a().setLike(0);
        blVar = this.f1334a.l;
        blVar.f().c(false);
    }

    @Override // com.baidu.tieba.model.cj
    public void b(String str, long j) {
    }
}
