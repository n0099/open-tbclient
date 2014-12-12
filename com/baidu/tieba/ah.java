package com.baidu.tieba;

import android.view.View;
import android.widget.TextView;
/* loaded from: classes.dex */
class ah implements View.OnClickListener {
    final /* synthetic */ af alf;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ah(af afVar) {
        this.alf = afVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        TextView textView;
        ak akVar;
        boolean z;
        textView = this.alf.akW;
        textView.setEnabled(false);
        akVar = this.alf.alc;
        z = this.alf.akL;
        akVar.bc(z);
    }
}
