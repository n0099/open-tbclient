package com.baidu.tieba.game.gamesearch;

import android.view.View;
import com.baidu.adp.lib.util.m;
/* loaded from: classes.dex */
class g implements View.OnFocusChangeListener {
    final /* synthetic */ GameSearchActivity aJU;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(GameSearchActivity gameSearchActivity) {
        this.aJU = gameSearchActivity;
    }

    @Override // android.view.View.OnFocusChangeListener
    public void onFocusChange(View view, boolean z) {
        if (!z) {
            m.b(this.aJU, view);
        } else {
            m.c(this.aJU, view);
        }
    }
}
