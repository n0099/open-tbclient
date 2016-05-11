package com.baidu.tieba.enterForum.home;

import android.view.View;
/* loaded from: classes.dex */
class aa implements View.OnClickListener {
    final /* synthetic */ z aXJ;
    private final /* synthetic */ View aXK;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aa(z zVar, View view) {
        this.aXJ = zVar;
        this.aXK = view;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.aXK != null) {
            this.aXK.setVisibility(8);
        }
    }
}
