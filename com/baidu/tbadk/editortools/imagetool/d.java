package com.baidu.tbadk.editortools.imagetool;

import android.view.View;
import com.baidu.tbadk.editortools.x;
/* loaded from: classes.dex */
class d implements View.OnClickListener {
    private final /* synthetic */ x apI;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(x xVar) {
        this.apI = xVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.apI != null) {
            this.apI.b(new com.baidu.tbadk.editortools.a(14, -1, true));
        }
    }
}
