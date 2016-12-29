package com.baidu.tieba.frs;

import java.util.ArrayList;
/* loaded from: classes.dex */
class j implements com.baidu.tieba.frs.d.t {
    final /* synthetic */ FrsActivity bzl;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(FrsActivity frsActivity) {
        this.bzl = frsActivity;
    }

    @Override // com.baidu.tieba.frs.d.t
    public void a(int i, boolean z, int i2, boolean z2, ArrayList<com.baidu.adp.widget.ListView.v> arrayList) {
        com.baidu.tieba.frs.f.d dVar;
        com.baidu.tieba.frs.f.d dVar2;
        dVar = this.bzl.byz;
        if (dVar != null && this.bzl.byr != null && this.bzl.byr.aaZ() && z && this.bzl.Wv() && !z2) {
            dVar2 = this.bzl.byz;
            dVar2.hH(i2);
        }
    }
}
