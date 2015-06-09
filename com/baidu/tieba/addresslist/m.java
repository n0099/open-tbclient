package com.baidu.tieba.addresslist;

import android.app.Activity;
import android.view.MotionEvent;
import android.view.View;
import android.widget.EditText;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class m implements View.OnTouchListener {
    final /* synthetic */ QuickSearchActivity azv;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(QuickSearchActivity quickSearchActivity) {
        this.azv = quickSearchActivity;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        EditText editText;
        if (motionEvent.getAction() == 0) {
            Activity pageActivity = this.azv.getPageContext().getPageActivity();
            editText = this.azv.azq;
            com.baidu.adp.lib.util.n.c(pageActivity, editText);
            return false;
        }
        return false;
    }
}
