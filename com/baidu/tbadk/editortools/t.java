package com.baidu.tbadk.editortools;

import android.view.View;
import com.baidu.tbadk.editortools.view.CommonTabContentView;
/* loaded from: classes.dex */
class t implements CommonTabContentView.c {
    final /* synthetic */ r aAn;

    /* JADX INFO: Access modifiers changed from: package-private */
    public t(r rVar) {
        this.aAn = rVar;
    }

    @Override // com.baidu.tbadk.editortools.view.CommonTabContentView.c
    public void a(View view, int i, long j) {
        j jVar;
        j jVar2;
        if (view instanceof e) {
            jVar = this.aAn.JT;
            if (jVar != null) {
                jVar2 = this.aAn.JT;
                jVar2.F(view);
            }
        }
    }
}
