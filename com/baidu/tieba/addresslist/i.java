package com.baidu.tieba.addresslist;

import android.view.MotionEvent;
import android.view.View;
import android.widget.EditText;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class i implements View.OnTouchListener {
    final /* synthetic */ QuickSearchActivity agP;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(QuickSearchActivity quickSearchActivity) {
        this.agP = quickSearchActivity;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        EditText editText;
        if (motionEvent.getAction() == 0) {
            QuickSearchActivity quickSearchActivity = this.agP;
            editText = this.agP.agK;
            com.baidu.adp.lib.util.m.b(quickSearchActivity, editText);
            return false;
        }
        return false;
    }
}
