package com.baidu.tieba.im.mygroup;

import android.view.inputmethod.InputMethodManager;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c implements com.baidu.tbadk.core.dialog.d {
    final /* synthetic */ PersonGroupActivity bfC;
    private final /* synthetic */ a bfF;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(PersonGroupActivity personGroupActivity, a aVar) {
        this.bfC = personGroupActivity;
        this.bfF = aVar;
    }

    @Override // com.baidu.tbadk.core.dialog.d
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        aVar.dismiss();
        ((InputMethodManager) this.bfC.getSystemService("input_method")).hideSoftInputFromWindow(this.bfF.getWindowToken(), 2);
    }
}
