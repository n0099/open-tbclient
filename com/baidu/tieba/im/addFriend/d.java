package com.baidu.tieba.im.addFriend;

import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d implements View.OnClickListener {
    final /* synthetic */ AddFriendActivity aPP;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(AddFriendActivity addFriendActivity) {
        this.aPP = addFriendActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        InputMethodManager inputMethodManager;
        EditText editText;
        EditText editText2;
        AddFriendActivity addFriendActivity = this.aPP;
        inputMethodManager = this.aPP.aPJ;
        editText = this.aPP.aPK;
        addFriendActivity.HidenSoftKeyPad(inputMethodManager, editText);
        editText2 = this.aPP.aPK;
        this.aPP.fR(editText2.getText().toString());
    }
}
