package com.baidu.tieba.editortool;

import android.view.View;
/* loaded from: classes.dex */
final class ac implements View.OnClickListener {
    final /* synthetic */ ab a;
    private final /* synthetic */ aa b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ac(ab abVar, aa aaVar) {
        this.a = abVar;
        this.b = aaVar;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        if (view instanceof EditorToolButton) {
            this.a.a((EditorToolButton) view, this.b);
        }
    }
}
