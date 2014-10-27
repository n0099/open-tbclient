package com.baidu.tieba.im.selectfriend;

import android.view.inputmethod.InputMethodManager;
/* loaded from: classes.dex */
class e implements com.baidu.tbadk.core.dialog.d {
    private final /* synthetic */ com.baidu.tieba.im.mygroup.a bfF;
    final /* synthetic */ SelectFriendActivity bif;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(SelectFriendActivity selectFriendActivity, com.baidu.tieba.im.mygroup.a aVar) {
        this.bif = selectFriendActivity;
        this.bfF = aVar;
    }

    @Override // com.baidu.tbadk.core.dialog.d
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        aVar.dismiss();
        ((InputMethodManager) this.bif.getSystemService("input_method")).hideSoftInputFromWindow(this.bfF.getWindowToken(), 2);
    }
}
