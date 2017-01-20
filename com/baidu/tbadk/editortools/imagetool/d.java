package com.baidu.tbadk.editortools.imagetool;

import android.view.View;
import com.baidu.tbadk.editortools.y;
/* loaded from: classes.dex */
class d implements View.OnClickListener {
    private final /* synthetic */ y aul;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(y yVar) {
        this.aul = yVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.aul != null) {
            this.aul.b(new com.baidu.tbadk.editortools.a(14, -1, true));
        }
    }
}
