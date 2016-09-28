package com.baidu.tbadk.editortools;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class m implements View.OnClickListener {
    final /* synthetic */ l aup;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(l lVar) {
        this.aup = lVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.aup.I(view);
    }
}
