package com.baidu.tieba.im.chat;

import android.text.Editable;
import android.text.TextWatcher;
import android.widget.Button;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class j implements TextWatcher {
    final /* synthetic */ AbsMsglistView aQh;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(AbsMsglistView absMsglistView) {
        this.aQh = absMsglistView;
    }

    @Override // android.text.TextWatcher
    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    @Override // android.text.TextWatcher
    public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    @Override // android.text.TextWatcher
    public void afterTextChanged(Editable editable) {
        Button button;
        boolean checkTextNum;
        Button button2;
        Button button3;
        if (editable == null || editable.length() <= 0) {
            button = this.aQh.mBtnMsgsendSend;
            button.setEnabled(false);
            return;
        }
        checkTextNum = this.aQh.checkTextNum();
        if (checkTextNum) {
            button3 = this.aQh.mBtnMsgsendSend;
            button3.setEnabled(true);
            return;
        }
        button2 = this.aQh.mBtnMsgsendSend;
        button2.setEnabled(false);
    }
}
