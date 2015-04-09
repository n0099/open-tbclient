package com.baidu.tieba;

import android.view.View;
import android.widget.TextView;
/* loaded from: classes.dex */
class ad implements View.OnClickListener {
    final /* synthetic */ ab auk;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ad(ab abVar) {
        this.auk = abVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        TextView textView;
        ag agVar;
        boolean z;
        textView = this.auk.aua;
        textView.setEnabled(false);
        agVar = this.auk.auh;
        z = this.auk.atP;
        agVar.bj(z);
    }
}
