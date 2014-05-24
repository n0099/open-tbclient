package com.baidu.tieba.im.live.room;

import android.text.Editable;
import android.text.TextWatcher;
/* loaded from: classes.dex */
class bq implements TextWatcher {
    final /* synthetic */ bo a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bq(bo boVar) {
        this.a = boVar;
    }

    @Override // android.text.TextWatcher
    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    @Override // android.text.TextWatcher
    public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    @Override // android.text.TextWatcher
    public void afterTextChanged(Editable editable) {
        if (editable == null || editable.toString().length() <= 0) {
            this.a.c.setEnabled(false);
            this.a.c.setTextColor(this.a.b.getResources().getColor(com.baidu.tieba.s.cp_cont_e));
            return;
        }
        this.a.c.setEnabled(true);
        this.a.c.setTextColor(this.a.b.getResources().getColor(com.baidu.tieba.s.cp_cont_g));
        if (editable.toString().length() >= 30) {
            this.a.b.showToast(com.baidu.tieba.y.input_worlds_max);
        }
    }
}
