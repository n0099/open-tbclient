package com.baidu.tieba.card;

import android.view.View;
/* loaded from: classes.dex */
class f implements View.OnClickListener {
    final /* synthetic */ c bzJ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(c cVar) {
        this.bzJ = cVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.bzJ.Ud() != null) {
            this.bzJ.Ud().a(view, this.bzJ.bzH);
        }
    }
}
