package com.baidu.tieba.home;

import android.app.Activity;
import android.view.MotionEvent;
import android.view.View;
import android.widget.EditText;
import com.baidu.adp.lib.util.n;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c implements View.OnTouchListener {
    final /* synthetic */ CreateBarActivity aYM;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(CreateBarActivity createBarActivity) {
        this.aYM = createBarActivity;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        EditText editText;
        EditText editText2;
        EditText editText3;
        EditText editText4;
        if (motionEvent.getAction() == 0) {
            editText = this.aYM.aYA;
            if (editText.hasFocus()) {
                Activity pageActivity = this.aYM.getPageContext().getPageActivity();
                editText4 = this.aYM.aYA;
                n.c(pageActivity, editText4);
            }
            editText2 = this.aYM.axx;
            if (editText2.hasFocus()) {
                Activity pageActivity2 = this.aYM.getPageContext().getPageActivity();
                editText3 = this.aYM.axx;
                n.c(pageActivity2, editText3);
                return false;
            }
            return false;
        }
        return false;
    }
}
