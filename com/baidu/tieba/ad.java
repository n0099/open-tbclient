package com.baidu.tieba;

import android.view.View;
import android.widget.TextView;
/* loaded from: classes.dex */
class ad implements View.OnClickListener {
    final /* synthetic */ ab auc;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ad(ab abVar) {
        this.auc = abVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        TextView textView;
        ag agVar;
        boolean z;
        textView = this.auc.atS;
        textView.setEnabled(false);
        agVar = this.auc.atZ;
        z = this.auc.atH;
        agVar.bj(z);
    }
}
