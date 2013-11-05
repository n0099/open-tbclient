package com.baidu.tieba.im.groupInfo;

import android.text.Editable;
import android.text.TextWatcher;
import com.slidingmenu.lib.R;
/* loaded from: classes.dex */
class a implements TextWatcher {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ ApplyJoinGroupActivity f1593a;
    private CharSequence b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(ApplyJoinGroupActivity applyJoinGroupActivity) {
        this.f1593a = applyJoinGroupActivity;
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
            int selectionStart = this.f1593a.b.getSelectionStart();
            int selectionEnd = this.f1593a.b.getSelectionEnd();
            int length = this.b.length();
            if (30 < length) {
                this.f1593a.f.setEnabled(false);
                editable.delete(selectionStart - 1, selectionEnd);
                com.baidu.adp.lib.h.d.d("start:" + selectionStart + " end:" + selectionEnd);
                this.f1593a.b.setText(editable);
                this.f1593a.b.setSelection(selectionStart);
                length = 30;
            } else {
                this.f1593a.c.setTextColor(this.f1593a.getResources().getColor(R.color.edit_normal));
                if (editable.length() > 0) {
                    this.f1593a.f.setEnabled(true);
                } else {
                    this.f1593a.f.setEnabled(false);
                }
            }
            if (30 == length) {
                this.f1593a.c.setTextColor(this.f1593a.getResources().getColor(R.color.edit_exceed));
            }
            this.f1593a.c.setText(length + "/30");
        }
    }
}
