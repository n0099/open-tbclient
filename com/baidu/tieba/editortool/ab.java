package com.baidu.tieba.editortool;

import android.view.View;
/* loaded from: classes.dex */
class ab implements View.OnClickListener {
    final /* synthetic */ aa a;
    private final /* synthetic */ z b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ab(aa aaVar, z zVar) {
        this.a = aaVar;
        this.b = zVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view instanceof EditorToolButton) {
            this.a.a((EditorToolButton) view, this.b);
        }
    }
}
