package com.baidu.tieba.account;

import android.widget.CompoundButton;
import android.widget.EditText;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class o implements CompoundButton.OnCheckedChangeListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ k f907a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(k kVar) {
        this.f907a = kVar;
    }

    @Override // android.widget.CompoundButton.OnCheckedChangeListener
    public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
        EditText editText;
        if (z) {
            editText = this.f907a.c;
            editText.setText(compoundButton.getText());
        }
    }
}
