package com.baidu.tbadk.editortools.imagetool;

import android.view.View;
import com.baidu.tbadk.editortools.ab;
/* loaded from: classes.dex */
class d implements View.OnClickListener {
    private final /* synthetic */ ab avJ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(ab abVar) {
        this.avJ = abVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.avJ != null) {
            this.avJ.b(new com.baidu.tbadk.editortools.a(14, -1, true));
        }
    }
}
