package com.baidu.tieba.im.searchGroup;

import android.view.KeyEvent;
import android.widget.EditText;
import android.widget.TextView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class i implements TextView.OnEditorActionListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ d f1784a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(d dVar) {
        this.f1784a = dVar;
    }

    @Override // android.widget.TextView.OnEditorActionListener
    public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
        SearchGroupActivity searchGroupActivity;
        EditText editText;
        if (i == 2) {
            searchGroupActivity = this.f1784a.b;
            editText = this.f1784a.e;
            searchGroupActivity.a(editText.getText().toString());
            return true;
        }
        return false;
    }
}
