package com.baidu.tieba.im.selectfriend;

import android.view.inputmethod.InputMethodManager;
/* loaded from: classes.dex */
class f implements com.baidu.tbadk.core.dialog.d {
    private final /* synthetic */ com.baidu.tieba.im.widget.b bjf;
    final /* synthetic */ SelectFriendActivity bmV;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(SelectFriendActivity selectFriendActivity, com.baidu.tieba.im.widget.b bVar) {
        this.bmV = selectFriendActivity;
        this.bjf = bVar;
    }

    @Override // com.baidu.tbadk.core.dialog.d
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        aVar.dismiss();
        ((InputMethodManager) this.bmV.getSystemService("input_method")).hideSoftInputFromWindow(this.bjf.getWindowToken(), 2);
    }
}
