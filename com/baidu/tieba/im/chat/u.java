package com.baidu.tieba.im.chat;

import android.text.Editable;
import android.text.TextWatcher;
import android.widget.Button;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class u implements TextWatcher {
    final /* synthetic */ AbsMsglistView aNP;

    /* JADX INFO: Access modifiers changed from: package-private */
    public u(AbsMsglistView absMsglistView) {
        this.aNP = absMsglistView;
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
            button = this.aNP.mBtnMsgsendSend;
            button.setEnabled(false);
            return;
        }
        checkTextNum = this.aNP.checkTextNum();
        if (checkTextNum) {
            button3 = this.aNP.mBtnMsgsendSend;
            button3.setEnabled(true);
            return;
        }
        button2 = this.aNP.mBtnMsgsendSend;
        button2.setEnabled(false);
    }
}
