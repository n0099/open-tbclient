package com.baidu.tieba.im.e;

import android.text.Editable;
import android.text.TextUtils;
import android.widget.EditText;
/* loaded from: classes.dex */
public class g {
    public static int a(EditText editText) {
        if (editText == null) {
            return 0;
        }
        return a(editText.getText());
    }

    public static int a(Editable editable) {
        if (editable == null) {
            return 0;
        }
        return a(editable.toString());
    }

    public static int a(char c) {
        if (b(c)) {
            return 1;
        }
        return 2;
    }

    public static boolean b(char c) {
        return (c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z') || ((c >= '0' && c <= '9') || c == ' ');
    }

    public static int a(String str) {
        if (TextUtils.isEmpty(str)) {
            return 0;
        }
        int i = 0;
        for (int i2 = 0; i2 < str.length(); i2++) {
            if (b(str.charAt(i2))) {
                i++;
            } else {
                i += 2;
            }
        }
        return i;
    }

    public static boolean b(EditText editText) {
        String obj = editText.getText().toString();
        int length = obj.length();
        String trim = obj.trim();
        if (trim.length() < length) {
            editText.setText(trim);
            return false;
        }
        return true;
    }
}
