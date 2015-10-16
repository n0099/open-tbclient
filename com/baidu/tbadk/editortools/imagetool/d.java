package com.baidu.tbadk.editortools.imagetool;

import android.view.View;
import com.baidu.tbadk.editortools.w;
/* loaded from: classes.dex */
class d implements View.OnClickListener {
    private final /* synthetic */ w arf;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(w wVar) {
        this.arf = wVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.arf != null) {
            this.arf.b(new com.baidu.tbadk.editortools.a(14, -1, true));
        }
    }
}
