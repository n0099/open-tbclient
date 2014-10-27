package com.baidu.tieba.editortool;

import android.text.Editable;
import android.text.TextWatcher;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ah implements TextWatcher {
    private final /* synthetic */ com.baidu.tbadk.editortool.w arn;
    final /* synthetic */ PbEditorToolView arv;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ah(PbEditorToolView pbEditorToolView, com.baidu.tbadk.editortool.w wVar) {
        this.arv = pbEditorToolView;
        this.arn = wVar;
    }

    @Override // android.text.TextWatcher
    public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    @Override // android.text.TextWatcher
    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    @Override // android.text.TextWatcher
    public void afterTextChanged(Editable editable) {
        this.arn.handleAction(18, null);
    }
}
