package com.baidu.tieba.im.addFriend;

import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d implements View.OnClickListener {
    final /* synthetic */ AddFriendActivity aNn;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(AddFriendActivity addFriendActivity) {
        this.aNn = addFriendActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        InputMethodManager inputMethodManager;
        EditText editText;
        EditText editText2;
        AddFriendActivity addFriendActivity = this.aNn;
        inputMethodManager = this.aNn.aNh;
        editText = this.aNn.aNi;
        addFriendActivity.HidenSoftKeyPad(inputMethodManager, editText);
        editText2 = this.aNn.aNi;
        this.aNn.fz(editText2.getText().toString());
    }
}
