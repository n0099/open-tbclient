package com.baidu.tieba.frs;

import android.view.View;
/* loaded from: classes.dex */
class v implements com.baidu.tbadk.a.d {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ u f1115a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public v(u uVar) {
        this.f1115a = uVar;
    }

    @Override // com.baidu.tbadk.a.d
    public void a(com.baidu.adp.widget.a.b bVar, String str, boolean z) {
        FrsActivity frsActivity;
        bb bbVar;
        if (bVar != null) {
            frsActivity = this.f1115a.f1114a;
            bbVar = frsActivity.l;
            View d = bbVar.d(str);
            if (d != null) {
                d.invalidate();
            }
        }
    }
}
