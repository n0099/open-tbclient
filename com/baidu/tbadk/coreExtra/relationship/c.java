package com.baidu.tbadk.coreExtra.relationship;

import android.text.TextUtils;
import com.baidu.android.common.util.DeviceId;
import java.util.Arrays;
/* loaded from: classes.dex */
public final class c {
    public static final String[] clo = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", DeviceId.CUIDInfo.I_FIXED, "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z", "#"};

    public static boolean pN(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return Arrays.asList(clo).contains(str);
    }
}
