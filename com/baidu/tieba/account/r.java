package com.baidu.tieba.account;

import android.widget.CompoundButton;
import android.widget.EditText;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class r implements CompoundButton.OnCheckedChangeListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ n f1102a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public r(n nVar) {
        this.f1102a = nVar;
    }

    @Override // android.widget.CompoundButton.OnCheckedChangeListener
    public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
        EditText editText;
        if (z) {
            editText = this.f1102a.c;
            editText.setText(compoundButton.getText());
        }
    }
}
