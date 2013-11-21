package com.baidu.tieba.frs;

import android.view.View;
/* loaded from: classes.dex */
class aa implements com.baidu.tbadk.imageManager.c {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ FrsActivity f1309a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aa(FrsActivity frsActivity) {
        this.f1309a = frsActivity;
    }

    @Override // com.baidu.tbadk.imageManager.c
    public void a(com.baidu.adp.widget.ImageView.e eVar, String str, boolean z) {
        bn bnVar;
        if (eVar != null) {
            bnVar = this.f1309a.n;
            View d = bnVar.d(str);
            if (d != null) {
                d.invalidate();
            }
        }
    }
}
