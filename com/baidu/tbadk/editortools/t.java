package com.baidu.tbadk.editortools;

import android.view.View;
import com.baidu.tbadk.editortools.view.CommonTabContentView;
/* loaded from: classes.dex */
class t implements CommonTabContentView.c {
    final /* synthetic */ r auI;

    /* JADX INFO: Access modifiers changed from: package-private */
    public t(r rVar) {
        this.auI = rVar;
    }

    @Override // com.baidu.tbadk.editortools.view.CommonTabContentView.c
    public void a(View view, int i, long j) {
        j jVar;
        j jVar2;
        if (view instanceof e) {
            jVar = this.auI.EM;
            if (jVar != null) {
                jVar2 = this.auI.EM;
                jVar2.J(view);
            }
        }
    }
}
