package com.baidu.tbadk.editortools;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class k implements View.OnClickListener {
    final /* synthetic */ j auG;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(j jVar) {
        this.auG = jVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.auG.J(view);
    }
}
