package com.baidu.tieba.im.mygroup;

import android.view.inputmethod.InputMethodManager;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class p implements com.baidu.tbadk.core.dialog.d {
    final /* synthetic */ PersonGroupActivity a;
    private final /* synthetic */ a b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public p(PersonGroupActivity personGroupActivity, a aVar) {
        this.a = personGroupActivity;
        this.b = aVar;
    }

    @Override // com.baidu.tbadk.core.dialog.d
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        aVar.d();
        ((InputMethodManager) this.a.getSystemService("input_method")).hideSoftInputFromWindow(this.b.getWindowToken(), 2);
    }
}
