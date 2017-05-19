package com.baidu.tbadk.editortools.imagetool;

import android.view.View;
import com.baidu.tbadk.editortools.y;
/* loaded from: classes.dex */
class d implements View.OnClickListener {
    private final /* synthetic */ y azW;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(y yVar) {
        this.azW = yVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.azW != null) {
            this.azW.b(new com.baidu.tbadk.editortools.a(14, -1, true));
        }
    }
}
