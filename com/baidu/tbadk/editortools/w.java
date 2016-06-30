package com.baidu.tbadk.editortools;

import android.view.View;
import com.baidu.tbadk.editortools.view.CommonTabContentView;
/* loaded from: classes.dex */
class w implements CommonTabContentView.c {
    final /* synthetic */ u aqS;

    /* JADX INFO: Access modifiers changed from: package-private */
    public w(u uVar) {
        this.aqS = uVar;
    }

    @Override // com.baidu.tbadk.editortools.view.CommonTabContentView.c
    public void a(View view, int i, long j) {
        l lVar;
        l lVar2;
        if (view instanceof e) {
            lVar = this.aqS.BW;
            if (lVar != null) {
                lVar2 = this.aqS.BW;
                lVar2.H(view);
            }
        }
    }
}
