package com.baidu.tieba.account;

import android.widget.CompoundButton;
import android.widget.EditText;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class p implements CompoundButton.OnCheckedChangeListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ l f1087a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public p(l lVar) {
        this.f1087a = lVar;
    }

    @Override // android.widget.CompoundButton.OnCheckedChangeListener
    public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
        EditText editText;
        if (z) {
            editText = this.f1087a.c;
            editText.setText(compoundButton.getText());
        }
    }
}
