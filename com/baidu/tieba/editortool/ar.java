package com.baidu.tieba.editortool;

import android.view.View;
/* loaded from: classes.dex */
class ar implements View.OnClickListener {
    final /* synthetic */ aq a;
    private final /* synthetic */ com.baidu.tbadk.editortool.w b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ar(aq aqVar, com.baidu.tbadk.editortool.w wVar) {
        this.a = aqVar;
        this.b = wVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view instanceof EditorToolButton) {
            this.a.a((EditorToolButton) view, this.b);
        }
    }
}
