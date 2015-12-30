package com.baidu.tbadk.editortools.imagetool;

import android.view.View;
import com.baidu.tbadk.editortools.z;
/* loaded from: classes.dex */
class d implements View.OnClickListener {
    private final /* synthetic */ z atj;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(z zVar) {
        this.atj = zVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.atj != null) {
            this.atj.b(new com.baidu.tbadk.editortools.a(14, -1, true));
        }
    }
}
