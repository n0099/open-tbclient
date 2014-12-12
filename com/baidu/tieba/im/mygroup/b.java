package com.baidu.tieba.im.mygroup;

import android.view.inputmethod.InputMethodManager;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b implements com.baidu.tbadk.core.dialog.d {
    final /* synthetic */ PersonGroupActivity bjc;
    private final /* synthetic */ com.baidu.tieba.im.widget.b bjf;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(PersonGroupActivity personGroupActivity, com.baidu.tieba.im.widget.b bVar) {
        this.bjc = personGroupActivity;
        this.bjf = bVar;
    }

    @Override // com.baidu.tbadk.core.dialog.d
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        aVar.dismiss();
        ((InputMethodManager) this.bjc.getSystemService("input_method")).hideSoftInputFromWindow(this.bjf.getWindowToken(), 2);
    }
}
