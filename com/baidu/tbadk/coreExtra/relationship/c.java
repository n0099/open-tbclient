package com.baidu.tbadk.coreExtra.relationship;

import android.text.TextUtils;
import com.baidu.android.common.util.DeviceId;
import java.util.Arrays;
/* loaded from: classes.dex */
public final class c {
    public static final String[] cxx = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", DeviceId.CUIDInfo.I_FIXED, "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z", "#"};

    public static boolean oX(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return Arrays.asList(cxx).contains(str);
    }
}
