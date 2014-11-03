package com.baidu.tieba.im.mygroup;

import android.view.inputmethod.InputMethodManager;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c implements com.baidu.tbadk.core.dialog.d {
    final /* synthetic */ PersonGroupActivity bfQ;
    private final /* synthetic */ a bfT;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(PersonGroupActivity personGroupActivity, a aVar) {
        this.bfQ = personGroupActivity;
        this.bfT = aVar;
    }

    @Override // com.baidu.tbadk.core.dialog.d
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        aVar.dismiss();
        ((InputMethodManager) this.bfQ.getSystemService("input_method")).hideSoftInputFromWindow(this.bfT.getWindowToken(), 2);
    }
}
