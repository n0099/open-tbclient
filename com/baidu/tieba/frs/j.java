package com.baidu.tieba.frs;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class j implements com.baidu.tbadk.a.d {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ FrsActivity f1103a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(FrsActivity frsActivity) {
        this.f1103a = frsActivity;
    }

    @Override // com.baidu.tbadk.a.d
    public void a(com.baidu.adp.widget.a.b bVar, String str, boolean z) {
        bb bbVar;
        if (bVar != null) {
            bbVar = this.f1103a.l;
            View d = bbVar.d(str);
            if (d != null) {
                d.invalidate();
            }
        }
    }
}
