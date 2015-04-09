package com.baidu.tieba.im.mygroup;

import android.view.inputmethod.InputMethodManager;
/* loaded from: classes.dex */
class b implements com.baidu.tbadk.core.dialog.d {
    final /* synthetic */ PersonGroupActivity blD;
    private final /* synthetic */ com.baidu.tieba.im.widget.b blG;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(PersonGroupActivity personGroupActivity, com.baidu.tieba.im.widget.b bVar) {
        this.blD = personGroupActivity;
        this.blG = bVar;
    }

    @Override // com.baidu.tbadk.core.dialog.d
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        aVar.dismiss();
        ((InputMethodManager) this.blD.getSystemService("input_method")).hideSoftInputFromWindow(this.blG.getWindowToken(), 2);
    }
}
