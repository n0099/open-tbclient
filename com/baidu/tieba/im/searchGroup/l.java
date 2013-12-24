package com.baidu.tieba.im.searchGroup;

import android.view.KeyEvent;
import android.widget.EditText;
import android.widget.TextView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class l implements TextView.OnEditorActionListener {
    final /* synthetic */ g a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(g gVar) {
        this.a = gVar;
    }

    @Override // android.widget.TextView.OnEditorActionListener
    public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
        SearchGroupActivity searchGroupActivity;
        EditText editText;
        if (i == 2) {
            searchGroupActivity = this.a.b;
            editText = this.a.e;
            searchGroupActivity.a(editText.getText().toString());
            return true;
        }
        return false;
    }
}
