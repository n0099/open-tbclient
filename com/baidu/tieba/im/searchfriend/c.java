package com.baidu.tieba.im.searchfriend;

import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c implements View.OnFocusChangeListener {
    final /* synthetic */ SearchFriendActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(SearchFriendActivity searchFriendActivity) {
        this.a = searchFriendActivity;
    }

    @Override // android.view.View.OnFocusChangeListener
    public void onFocusChange(View view, boolean z) {
        InputMethodManager inputMethodManager;
        EditText editText;
        InputMethodManager inputMethodManager2;
        EditText editText2;
        if (z) {
            SearchFriendActivity searchFriendActivity = this.a;
            inputMethodManager2 = this.a.a;
            editText2 = this.a.d;
            searchFriendActivity.ShowSoftKeyPad(inputMethodManager2, editText2);
            return;
        }
        SearchFriendActivity searchFriendActivity2 = this.a;
        inputMethodManager = this.a.a;
        editText = this.a.d;
        searchFriendActivity2.HidenSoftKeyPad(inputMethodManager, editText);
    }
}
