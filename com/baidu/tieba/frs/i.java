package com.baidu.tieba.frs;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class i implements com.baidu.tbadk.a.d {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ FrsActivity f1150a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(FrsActivity frsActivity) {
        this.f1150a = frsActivity;
    }

    @Override // com.baidu.tbadk.a.d
    public void a(com.baidu.adp.widget.a.c cVar, String str, boolean z) {
        ba baVar;
        if (cVar != null) {
            baVar = this.f1150a.o;
            View d = baVar.d(str);
            if (d != null) {
                d.invalidate();
            }
        }
    }
}
