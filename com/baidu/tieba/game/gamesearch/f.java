package com.baidu.tieba.game.gamesearch;

import android.view.View;
import android.widget.EditText;
import com.baidu.adp.lib.util.m;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class f implements View.OnClickListener {
    final /* synthetic */ GameSearchActivity aJU;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(GameSearchActivity gameSearchActivity) {
        this.aJU = gameSearchActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EditText editText;
        EditText editText2;
        editText = this.aJU.aJK;
        if (editText.hasFocus()) {
            GameSearchActivity gameSearchActivity = this.aJU;
            editText2 = this.aJU.aJK;
            m.b(gameSearchActivity, editText2);
        }
        this.aJU.closeActivity();
    }
}
