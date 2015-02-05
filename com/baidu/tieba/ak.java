package com.baidu.tieba;

import android.view.View;
import android.widget.TextView;
/* loaded from: classes.dex */
class ak implements View.OnClickListener {
    final /* synthetic */ ai alW;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ak(ai aiVar) {
        this.alW = aiVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        TextView textView;
        an anVar;
        boolean z;
        textView = this.alW.alN;
        textView.setEnabled(false);
        anVar = this.alW.alT;
        z = this.alW.alC;
        anVar.be(z);
    }
}
