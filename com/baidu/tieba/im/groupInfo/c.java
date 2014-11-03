package com.baidu.tieba.im.groupInfo;

import android.text.Editable;
import android.text.TextWatcher;
/* loaded from: classes.dex */
class c implements TextWatcher {
    final /* synthetic */ ApplyJoinGroupActivity baq;
    private CharSequence bas;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(ApplyJoinGroupActivity applyJoinGroupActivity) {
        this.baq = applyJoinGroupActivity;
    }

    @Override // android.text.TextWatcher
    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    @Override // android.text.TextWatcher
    public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        this.bas = charSequence;
    }

    @Override // android.text.TextWatcher
    public void afterTextChanged(Editable editable) {
        if (editable != null) {
            int selectionStart = this.baq.bae.getSelectionStart();
            int selectionEnd = this.baq.bae.getSelectionEnd();
            int length = this.bas.length();
            if (30 < length) {
                this.baq.bai.setEnabled(false);
                editable.delete(selectionStart - 1, selectionEnd);
                this.baq.bae.setText(editable);
                this.baq.bae.setSelection(selectionStart);
                length = 30;
            } else {
                this.baq.baf.setTextColor(this.baq.getResources().getColor(com.baidu.tieba.s.edit_normal));
                if (editable.length() > 0) {
                    this.baq.bai.setEnabled(true);
                } else {
                    this.baq.bai.setEnabled(false);
                }
            }
            if (30 == length) {
                this.baq.baf.setTextColor(this.baq.getResources().getColor(com.baidu.tieba.s.edit_exceed));
            }
            this.baq.baf.setText(String.valueOf(length) + "/30");
        }
    }
}
