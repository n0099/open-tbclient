package com.baidu.tieba.card;

import android.view.View;
/* loaded from: classes.dex */
class v implements View.OnClickListener {
    final /* synthetic */ u aTO;

    /* JADX INFO: Access modifiers changed from: package-private */
    public v(u uVar) {
        this.aTO = uVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.aTO.KN() != null) {
            this.aTO.KN().a(view, null);
        }
    }
}
