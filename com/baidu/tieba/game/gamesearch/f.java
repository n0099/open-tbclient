package com.baidu.tieba.game.gamesearch;

import android.view.View;
import android.widget.EditText;
import com.baidu.adp.lib.util.m;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class f implements View.OnClickListener {
    final /* synthetic */ GameSearchActivity aJH;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(GameSearchActivity gameSearchActivity) {
        this.aJH = gameSearchActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EditText editText;
        EditText editText2;
        editText = this.aJH.aJx;
        if (editText.hasFocus()) {
            GameSearchActivity gameSearchActivity = this.aJH;
            editText2 = this.aJH.aJx;
            m.b(gameSearchActivity, editText2);
        }
        this.aJH.closeActivity();
    }
}
