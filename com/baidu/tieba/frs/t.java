package com.baidu.tieba.frs;

import android.view.View;
/* loaded from: classes.dex */
class t implements com.baidu.tbadk.a.d {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ s f1094a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public t(s sVar) {
        this.f1094a = sVar;
    }

    @Override // com.baidu.tbadk.a.d
    public void a(com.baidu.adp.widget.a.b bVar, String str, boolean z) {
        FrsActivity frsActivity;
        az azVar;
        if (bVar != null) {
            frsActivity = this.f1094a.f1093a;
            azVar = frsActivity.l;
            View d = azVar.d(str);
            if (d != null) {
                d.invalidate();
            }
        }
    }
}
