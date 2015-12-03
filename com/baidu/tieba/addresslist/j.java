package com.baidu.tieba.addresslist;

import android.app.Activity;
import android.view.MotionEvent;
import android.view.View;
import android.widget.EditText;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class j implements View.OnTouchListener {
    final /* synthetic */ QuickSearchActivity aHY;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(QuickSearchActivity quickSearchActivity) {
        this.aHY = quickSearchActivity;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        EditText editText;
        if (motionEvent.getAction() == 0) {
            Activity pageActivity = this.aHY.getPageContext().getPageActivity();
            editText = this.aHY.aHT;
            com.baidu.adp.lib.util.k.c(pageActivity, editText);
            return false;
        }
        return false;
    }
}
