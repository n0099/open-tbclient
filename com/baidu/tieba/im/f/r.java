package com.baidu.tieba.im.f;

import android.text.Editable;
import android.text.TextUtils;
import android.widget.EditText;
/* loaded from: classes.dex */
public final class r {
    public static int a(EditText editText) {
        Editable text;
        if (editText == null || (text = editText.getText()) == null) {
            return 0;
        }
        return a(text.toString());
    }

    public static boolean a(char c) {
        return (c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z') || ((c >= '0' && c <= '9') || c == ' ');
    }

    public static int a(String str) {
        if (TextUtils.isEmpty(str)) {
            return 0;
        }
        int i = 0;
        for (int i2 = 0; i2 < str.length(); i2++) {
            if (a(str.charAt(i2))) {
                i++;
            } else {
                i += 2;
            }
        }
        return i;
    }

    public static String a(String str, int i, int i2) {
        StringBuilder sb = new StringBuilder();
        if (TextUtils.isEmpty(str)) {
            return sb.toString();
        }
        int i3 = 0;
        for (int i4 = 0; i4 < str.length(); i4++) {
            char charAt = str.charAt(i4);
            if (i3 >= 16) {
                return sb.toString();
            }
            if (i3 >= 0) {
                sb.append(charAt);
            }
            if (a(charAt)) {
                i3++;
            } else {
                i3 += 2;
            }
        }
        return sb.toString();
    }
}
