package com.baidu.tieba.game.gamesearch;

import android.view.MotionEvent;
import android.view.View;
import android.widget.EditText;
import com.baidu.adp.lib.util.m;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class e implements View.OnTouchListener {
    final /* synthetic */ GameSearchActivity aJU;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(GameSearchActivity gameSearchActivity) {
        this.aJU = gameSearchActivity;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        EditText editText;
        if (motionEvent.getAction() == 0) {
            GameSearchActivity gameSearchActivity = this.aJU;
            editText = this.aJU.aJK;
            m.b(gameSearchActivity, editText);
            return false;
        }
        return false;
    }
}
