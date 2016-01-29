package com.baidu.tbadk.editortools.imagetool;

import android.view.View;
import com.baidu.tbadk.editortools.z;
/* loaded from: classes.dex */
class d implements View.OnClickListener {
    private final /* synthetic */ z aub;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(z zVar) {
        this.aub = zVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.aub != null) {
            this.aub.b(new com.baidu.tbadk.editortools.a(14, -1, true));
        }
    }
}
