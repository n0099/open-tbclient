package com.baidu.tieba.editortool;

import android.view.View;
/* loaded from: classes.dex */
class k implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ h f1281a;
    final /* synthetic */ j b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(j jVar, h hVar) {
        this.b = jVar;
        this.f1281a = hVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view instanceof EditorToolButton) {
            this.b.a((EditorToolButton) view, this.f1281a);
        }
    }
}
