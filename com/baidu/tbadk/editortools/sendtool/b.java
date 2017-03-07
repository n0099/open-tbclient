package com.baidu.tbadk.editortools.sendtool;

import android.view.View;
/* loaded from: classes.dex */
class b implements View.OnClickListener {
    final /* synthetic */ SendView aBj;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(SendView sendView) {
        this.aBj = sendView;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.aBj.b(new com.baidu.tbadk.editortools.a(8, -1, null));
    }
}
