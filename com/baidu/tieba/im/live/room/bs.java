package com.baidu.tieba.im.live.room;

import android.text.Editable;
import android.text.TextWatcher;
/* loaded from: classes.dex */
class bs implements TextWatcher {
    final /* synthetic */ bq a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bs(bq bqVar) {
        this.a = bqVar;
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
            this.a.c.setTextColor(this.a.b.getResources().getColor(com.baidu.tieba.r.cp_cont_e));
            return;
        }
        this.a.c.setEnabled(true);
        this.a.c.setTextColor(this.a.b.getResources().getColor(com.baidu.tieba.r.cp_cont_g));
        if (editable.toString().length() >= 30) {
            this.a.b.showToast(com.baidu.tieba.x.input_worlds_max);
        }
    }
}
