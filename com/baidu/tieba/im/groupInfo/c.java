package com.baidu.tieba.im.groupInfo;

import android.text.Editable;
import android.text.TextWatcher;
import com.baidu.adp.lib.util.BdLog;
/* loaded from: classes.dex */
class c implements TextWatcher {
    final /* synthetic */ ApplyJoinGroupActivity a;
    private CharSequence b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(ApplyJoinGroupActivity applyJoinGroupActivity) {
        this.a = applyJoinGroupActivity;
    }

    @Override // android.text.TextWatcher
    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    @Override // android.text.TextWatcher
    public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        this.b = charSequence;
    }

    @Override // android.text.TextWatcher
    public void afterTextChanged(Editable editable) {
        if (editable != null) {
            int selectionStart = this.a.b.getSelectionStart();
            int selectionEnd = this.a.b.getSelectionEnd();
            int length = this.b.length();
            if (30 < length) {
                this.a.f.setEnabled(false);
                editable.delete(selectionStart - 1, selectionEnd);
                BdLog.d("start:" + selectionStart + " end:" + selectionEnd);
                this.a.b.setText(editable);
                this.a.b.setSelection(selectionStart);
                length = 30;
            } else {
                this.a.c.setTextColor(this.a.getResources().getColor(com.baidu.tieba.o.edit_normal));
                if (editable.length() > 0) {
                    this.a.f.setEnabled(true);
                } else {
                    this.a.f.setEnabled(false);
                }
            }
            if (30 == length) {
                this.a.c.setTextColor(this.a.getResources().getColor(com.baidu.tieba.o.edit_exceed));
            }
            this.a.c.setText(String.valueOf(length) + "/30");
        }
    }
}
