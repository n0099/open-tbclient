package com.baidu.tieba.im.selectfriend;

import android.view.inputmethod.InputMethodManager;
/* loaded from: classes.dex */
class e implements com.baidu.tbadk.core.dialog.d {
    private final /* synthetic */ com.baidu.tieba.im.mygroup.a bfT;
    final /* synthetic */ SelectFriendActivity biu;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(SelectFriendActivity selectFriendActivity, com.baidu.tieba.im.mygroup.a aVar) {
        this.biu = selectFriendActivity;
        this.bfT = aVar;
    }

    @Override // com.baidu.tbadk.core.dialog.d
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        aVar.dismiss();
        ((InputMethodManager) this.biu.getSystemService("input_method")).hideSoftInputFromWindow(this.bfT.getWindowToken(), 2);
    }
}
