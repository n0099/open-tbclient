package com.baidu.tieba.home;

import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b implements TextWatcher {
    final /* synthetic */ CreateBarActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(CreateBarActivity createBarActivity) {
        this.a = createBarActivity;
    }

    @Override // android.text.TextWatcher
    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    @Override // android.text.TextWatcher
    public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0068  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0040  */
    @Override // android.text.TextWatcher
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void afterTextChanged(Editable editable) {
        EditText editText;
        RelativeLayout relativeLayout;
        TextView textView;
        TextView textView2;
        TextView textView3;
        TextView textView4;
        EditText editText2;
        RelativeLayout relativeLayout2;
        editText = this.a.h;
        int length = editText.getText().toString().trim().length();
        if (length > 0 && length < 32) {
            editText2 = this.a.i;
            if (editText2.getText().toString().trim().length() > 0) {
                relativeLayout2 = this.a.j;
                relativeLayout2.setEnabled(true);
                if (length < 32) {
                    textView3 = this.a.t;
                    textView3.setText(this.a.getString(com.baidu.tieba.u.bar_name_long));
                    textView4 = this.a.t;
                    textView4.setTextColor(-65536);
                    return;
                }
                textView = this.a.t;
                textView.setText(this.a.getString(com.baidu.tieba.u.bar_name_rule));
                textView2 = this.a.t;
                textView2.setTextColor(-6250336);
                return;
            }
        }
        relativeLayout = this.a.j;
        relativeLayout.setEnabled(false);
        if (length < 32) {
        }
    }
}
