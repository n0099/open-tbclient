package com.baidu.tbadk.editortools.imagetool;

import android.view.View;
import com.baidu.tbadk.editortools.ab;
/* loaded from: classes.dex */
class d implements View.OnClickListener {
    private final /* synthetic */ ab arq;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(ab abVar) {
        this.arq = abVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.arq != null) {
            this.arq.b(new com.baidu.tbadk.editortools.a(14, -1, true));
        }
    }
}
