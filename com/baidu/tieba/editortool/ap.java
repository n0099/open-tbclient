package com.baidu.tieba.editortool;

import android.view.View;
/* loaded from: classes.dex */
final class ap implements View.OnClickListener {
    final /* synthetic */ ao a;
    private final /* synthetic */ com.baidu.tbadk.editortool.x b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ap(ao aoVar, com.baidu.tbadk.editortool.x xVar) {
        this.a = aoVar;
        this.b = xVar;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        if (view instanceof EditorToolButton) {
            this.a.a((EditorToolButton) view, this.b);
        }
    }
}
