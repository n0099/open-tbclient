package com.baidu.tieba.im.addFriend;

import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class e implements View.OnFocusChangeListener {
    final /* synthetic */ AddFriendActivity aPP;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(AddFriendActivity addFriendActivity) {
        this.aPP = addFriendActivity;
    }

    @Override // android.view.View.OnFocusChangeListener
    public void onFocusChange(View view, boolean z) {
        InputMethodManager inputMethodManager;
        EditText editText;
        InputMethodManager inputMethodManager2;
        EditText editText2;
        if (z) {
            AddFriendActivity addFriendActivity = this.aPP;
            inputMethodManager2 = this.aPP.aPJ;
            editText2 = this.aPP.aPK;
            addFriendActivity.ShowSoftKeyPad(inputMethodManager2, editText2);
            return;
        }
        AddFriendActivity addFriendActivity2 = this.aPP;
        inputMethodManager = this.aPP.aPJ;
        editText = this.aPP.aPK;
        addFriendActivity2.HidenSoftKeyPad(inputMethodManager, editText);
    }
}
