package com.baidu.tieba.editortool;

import android.text.Editable;
import android.text.TextWatcher;
/* loaded from: classes.dex */
class ah implements TextWatcher {
    final /* synthetic */ PbEditorToolView arE;
    private final /* synthetic */ com.baidu.tbadk.editortool.w arw;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ah(PbEditorToolView pbEditorToolView, com.baidu.tbadk.editortool.w wVar) {
        this.arE = pbEditorToolView;
        this.arw = wVar;
    }

    @Override // android.text.TextWatcher
    public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    @Override // android.text.TextWatcher
    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    @Override // android.text.TextWatcher
    public void afterTextChanged(Editable editable) {
        this.arw.handleAction(18, null);
    }
}
