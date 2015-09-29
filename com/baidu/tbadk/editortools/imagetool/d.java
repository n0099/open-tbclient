package com.baidu.tbadk.editortools.imagetool;

import android.view.View;
import com.baidu.tbadk.editortools.w;
/* loaded from: classes.dex */
class d implements View.OnClickListener {
    private final /* synthetic */ w are;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(w wVar) {
        this.are = wVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.are != null) {
            this.are.b(new com.baidu.tbadk.editortools.a(14, -1, true));
        }
    }
}
