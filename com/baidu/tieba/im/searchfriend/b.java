package com.baidu.tieba.im.searchfriend;

import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b implements View.OnClickListener {
    final /* synthetic */ SearchFriendActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(SearchFriendActivity searchFriendActivity) {
        this.a = searchFriendActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        InputMethodManager inputMethodManager;
        EditText editText;
        SearchFriendActivity searchFriendActivity = this.a;
        inputMethodManager = this.a.a;
        editText = this.a.d;
        searchFriendActivity.HidenSoftKeyPad(inputMethodManager, editText);
    }
}
