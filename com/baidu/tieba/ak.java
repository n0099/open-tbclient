package com.baidu.tieba;

import android.view.View;
import android.widget.TextView;
/* loaded from: classes.dex */
class ak implements View.OnClickListener {
    final /* synthetic */ ai alZ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ak(ai aiVar) {
        this.alZ = aiVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        TextView textView;
        an anVar;
        boolean z;
        textView = this.alZ.alQ;
        textView.setEnabled(false);
        anVar = this.alZ.alW;
        z = this.alZ.alF;
        anVar.be(z);
    }
}
