package com.baidu.tieba.card;

import android.view.View;
/* loaded from: classes.dex */
class v implements View.OnClickListener {
    final /* synthetic */ u aPw;

    /* JADX INFO: Access modifiers changed from: package-private */
    public v(u uVar) {
        this.aPw = uVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.aPw.JM() != null) {
            this.aPw.JM().a(view, null);
        }
    }
}
