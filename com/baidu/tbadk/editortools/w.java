package com.baidu.tbadk.editortools;

import android.view.View;
import com.baidu.tbadk.editortools.view.CommonTabContentView;
/* loaded from: classes.dex */
class w implements CommonTabContentView.c {
    final /* synthetic */ u avl;

    /* JADX INFO: Access modifiers changed from: package-private */
    public w(u uVar) {
        this.avl = uVar;
    }

    @Override // com.baidu.tbadk.editortools.view.CommonTabContentView.c
    public void a(View view, int i, long j) {
        l lVar;
        l lVar2;
        if (view instanceof e) {
            lVar = this.avl.EL;
            if (lVar != null) {
                lVar2 = this.avl.EL;
                lVar2.J(view);
            }
        }
    }
}
