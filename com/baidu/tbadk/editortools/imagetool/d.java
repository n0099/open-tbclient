package com.baidu.tbadk.editortools.imagetool;

import android.view.View;
import com.baidu.tbadk.editortools.z;
/* loaded from: classes.dex */
class d implements View.OnClickListener {
    private final /* synthetic */ z arF;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(z zVar) {
        this.arF = zVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.arF != null) {
            this.arF.b(new com.baidu.tbadk.editortools.a(14, -1, true));
        }
    }
}
