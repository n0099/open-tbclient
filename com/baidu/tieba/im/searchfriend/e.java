package com.baidu.tieba.im.searchfriend;

import android.text.TextUtils;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class e implements View.OnClickListener {
    final /* synthetic */ SearchFriendActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(SearchFriendActivity searchFriendActivity) {
        this.a = searchFriendActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        InputMethodManager inputMethodManager;
        EditText editText;
        EditText editText2;
        SearchFriendActivity searchFriendActivity = this.a;
        inputMethodManager = this.a.a;
        editText = this.a.d;
        searchFriendActivity.HidenSoftKeyPad(inputMethodManager, editText);
        editText2 = this.a.d;
        String editable = editText2.getText().toString();
        if (TextUtils.isEmpty(editable) || editable.trim().length() == 0 || editable.trim().length() > 20) {
            return;
        }
        this.a.a(editable);
    }
}
