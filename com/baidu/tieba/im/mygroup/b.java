package com.baidu.tieba.im.mygroup;

import android.view.inputmethod.InputMethodManager;
/* loaded from: classes.dex */
class b implements com.baidu.tbadk.core.dialog.d {
    private final /* synthetic */ com.baidu.tieba.im.widget.b bkC;
    final /* synthetic */ PersonGroupActivity bkz;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(PersonGroupActivity personGroupActivity, com.baidu.tieba.im.widget.b bVar) {
        this.bkz = personGroupActivity;
        this.bkC = bVar;
    }

    @Override // com.baidu.tbadk.core.dialog.d
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        aVar.dismiss();
        ((InputMethodManager) this.bkz.getSystemService("input_method")).hideSoftInputFromWindow(this.bkC.getWindowToken(), 2);
    }
}
