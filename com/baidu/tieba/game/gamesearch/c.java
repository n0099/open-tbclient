package com.baidu.tieba.game.gamesearch;

import android.widget.EditText;
import com.baidu.adp.lib.util.m;
/* loaded from: classes.dex */
class c implements Runnable {
    final /* synthetic */ GameSearchActivity aJH;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(GameSearchActivity gameSearchActivity) {
        this.aJH = gameSearchActivity;
    }

    @Override // java.lang.Runnable
    public void run() {
        EditText editText;
        EditText editText2;
        editText = this.aJH.aJx;
        editText.requestFocus();
        GameSearchActivity gameSearchActivity = this.aJH;
        editText2 = this.aJH.aJx;
        m.c(gameSearchActivity, editText2);
    }
}
