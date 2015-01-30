package com.baidu.tieba.im.addFriend;

import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d implements View.OnClickListener {
    final /* synthetic */ AddFriendActivity aQU;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(AddFriendActivity addFriendActivity) {
        this.aQU = addFriendActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        InputMethodManager inputMethodManager;
        EditText editText;
        EditText editText2;
        AddFriendActivity addFriendActivity = this.aQU;
        inputMethodManager = this.aQU.aQO;
        editText = this.aQU.aQP;
        addFriendActivity.HidenSoftKeyPad(inputMethodManager, editText);
        editText2 = this.aQU.aQP;
        this.aQU.fW(editText2.getText().toString());
    }
}
