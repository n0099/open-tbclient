package com.baidu.tbadk.coreExtra.relationship;

import android.text.TextUtils;
import java.util.Arrays;
/* loaded from: classes.dex */
public final class c {
    public static final String[] aup = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z", "#"};

    public static boolean fc(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return Arrays.asList(aup).contains(str);
    }
}
