package com.baidu.tieba.game.gamesearch;

import android.widget.EditText;
import com.baidu.adp.lib.util.m;
/* loaded from: classes.dex */
class c implements Runnable {
    final /* synthetic */ GameSearchActivity aJU;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(GameSearchActivity gameSearchActivity) {
        this.aJU = gameSearchActivity;
    }

    @Override // java.lang.Runnable
    public void run() {
        EditText editText;
        EditText editText2;
        editText = this.aJU.aJK;
        editText.requestFocus();
        GameSearchActivity gameSearchActivity = this.aJU;
        editText2 = this.aJU.aJK;
        m.c(gameSearchActivity, editText2);
    }
}
