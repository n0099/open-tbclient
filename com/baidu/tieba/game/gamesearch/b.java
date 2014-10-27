package com.baidu.tieba.game.gamesearch;

import android.view.View;
/* loaded from: classes.dex */
class b implements View.OnClickListener {
    final /* synthetic */ GameSearchActivity aJH;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(GameSearchActivity gameSearchActivity) {
        this.aJH = gameSearchActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.aJH.Ic();
    }
}
