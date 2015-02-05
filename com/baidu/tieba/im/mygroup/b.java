package com.baidu.tieba.im.mygroup;

import android.view.inputmethod.InputMethodManager;
/* loaded from: classes.dex */
class b implements com.baidu.tbadk.core.dialog.d {
    private final /* synthetic */ com.baidu.tieba.im.widget.b bkB;
    final /* synthetic */ PersonGroupActivity bky;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(PersonGroupActivity personGroupActivity, com.baidu.tieba.im.widget.b bVar) {
        this.bky = personGroupActivity;
        this.bkB = bVar;
    }

    @Override // com.baidu.tbadk.core.dialog.d
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        aVar.dismiss();
        ((InputMethodManager) this.bky.getSystemService("input_method")).hideSoftInputFromWindow(this.bkB.getWindowToken(), 2);
    }
}
