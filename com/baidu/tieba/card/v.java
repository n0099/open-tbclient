package com.baidu.tieba.card;

import android.view.View;
/* loaded from: classes.dex */
class v implements View.OnClickListener {
    final /* synthetic */ u aSS;

    /* JADX INFO: Access modifiers changed from: package-private */
    public v(u uVar) {
        this.aSS = uVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.aSS.KO() != null) {
            this.aSS.KO().a(view, null);
        }
    }
}
