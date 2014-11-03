package com.baidu.tieba.im.addFriend;

import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d implements View.OnClickListener {
    final /* synthetic */ AddFriendActivity aNB;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(AddFriendActivity addFriendActivity) {
        this.aNB = addFriendActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        InputMethodManager inputMethodManager;
        EditText editText;
        EditText editText2;
        AddFriendActivity addFriendActivity = this.aNB;
        inputMethodManager = this.aNB.aNv;
        editText = this.aNB.aNw;
        addFriendActivity.HidenSoftKeyPad(inputMethodManager, editText);
        editText2 = this.aNB.aNw;
        this.aNB.fz(editText2.getText().toString());
    }
}
