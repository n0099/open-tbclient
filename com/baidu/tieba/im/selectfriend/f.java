package com.baidu.tieba.im.selectfriend;

import android.view.inputmethod.InputMethodManager;
/* loaded from: classes.dex */
class f implements com.baidu.tbadk.core.dialog.d {
    private final /* synthetic */ com.baidu.tieba.im.widget.b bkB;
    final /* synthetic */ SelectFriendActivity bor;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(SelectFriendActivity selectFriendActivity, com.baidu.tieba.im.widget.b bVar) {
        this.bor = selectFriendActivity;
        this.bkB = bVar;
    }

    @Override // com.baidu.tbadk.core.dialog.d
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        aVar.dismiss();
        ((InputMethodManager) this.bor.getSystemService("input_method")).hideSoftInputFromWindow(this.bkB.getWindowToken(), 2);
    }
}
