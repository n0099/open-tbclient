package com.baidu.tbadk.editortools;

import android.view.View;
import com.baidu.tbadk.editortools.view.CommonTabContentView;
/* loaded from: classes.dex */
class w implements CommonTabContentView.c {
    final /* synthetic */ u auO;

    /* JADX INFO: Access modifiers changed from: package-private */
    public w(u uVar) {
        this.auO = uVar;
    }

    @Override // com.baidu.tbadk.editortools.view.CommonTabContentView.c
    public void a(View view, int i, long j) {
        l lVar;
        l lVar2;
        if (view instanceof e) {
            lVar = this.auO.EJ;
            if (lVar != null) {
                lVar2 = this.auO.EJ;
                lVar2.I(view);
            }
        }
    }
}
