package com.baidu.tieba.addresslist;

import android.app.Activity;
import android.view.MotionEvent;
import android.view.View;
import android.widget.EditText;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class n implements View.OnTouchListener {
    final /* synthetic */ QuickSearchActivity azu;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(QuickSearchActivity quickSearchActivity) {
        this.azu = quickSearchActivity;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        EditText editText;
        if (motionEvent.getAction() == 0) {
            Activity pageActivity = this.azu.getPageContext().getPageActivity();
            editText = this.azu.azp;
            com.baidu.adp.lib.util.n.c(pageActivity, editText);
            return false;
        }
        return false;
    }
}
