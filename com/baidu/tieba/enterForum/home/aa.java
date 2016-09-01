package com.baidu.tieba.enterForum.home;

import android.view.View;
/* loaded from: classes.dex */
class aa implements View.OnClickListener {
    final /* synthetic */ z bHg;
    private final /* synthetic */ View bHh;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aa(z zVar, View view) {
        this.bHg = zVar;
        this.bHh = view;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.bHh != null) {
            this.bHh.setVisibility(8);
        }
    }
}
