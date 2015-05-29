package com.baidu.tbadk.coreExtra.relationship;

import android.text.TextUtils;
import java.util.Arrays;
/* loaded from: classes.dex */
public final class c {
    public static final String[] aeh = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z", "#"};

    public static boolean ec(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return Arrays.asList(aeh).contains(str);
    }
}
