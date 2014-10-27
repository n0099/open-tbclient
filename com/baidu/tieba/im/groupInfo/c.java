package com.baidu.tieba.im.groupInfo;

import android.text.Editable;
import android.text.TextWatcher;
/* loaded from: classes.dex */
class c implements TextWatcher {
    final /* synthetic */ ApplyJoinGroupActivity bad;
    private CharSequence bae;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(ApplyJoinGroupActivity applyJoinGroupActivity) {
        this.bad = applyJoinGroupActivity;
    }

    @Override // android.text.TextWatcher
    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    @Override // android.text.TextWatcher
    public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        this.bae = charSequence;
    }

    @Override // android.text.TextWatcher
    public void afterTextChanged(Editable editable) {
        if (editable != null) {
            int selectionStart = this.bad.aZR.getSelectionStart();
            int selectionEnd = this.bad.aZR.getSelectionEnd();
            int length = this.bae.length();
            if (30 < length) {
                this.bad.aZV.setEnabled(false);
                editable.delete(selectionStart - 1, selectionEnd);
                this.bad.aZR.setText(editable);
                this.bad.aZR.setSelection(selectionStart);
                length = 30;
            } else {
                this.bad.aZS.setTextColor(this.bad.getResources().getColor(com.baidu.tieba.s.edit_normal));
                if (editable.length() > 0) {
                    this.bad.aZV.setEnabled(true);
                } else {
                    this.bad.aZV.setEnabled(false);
                }
            }
            if (30 == length) {
                this.bad.aZS.setTextColor(this.bad.getResources().getColor(com.baidu.tieba.s.edit_exceed));
            }
            this.bad.aZS.setText(String.valueOf(length) + "/30");
        }
    }
}
