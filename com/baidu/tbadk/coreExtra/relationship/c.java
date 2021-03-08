package com.baidu.tbadk.coreExtra.relationship;

import android.text.TextUtils;
import androidx.exifinterface.media.ExifInterface;
import java.util.Arrays;
/* loaded from: classes.dex */
public final class c {
    public static final String[] fvY = {ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "B", "C", "D", ExifInterface.LONGITUDE_EAST, "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", ExifInterface.LATITUDE_SOUTH, ExifInterface.GPS_DIRECTION_TRUE, "U", ExifInterface.GPS_MEASUREMENT_INTERRUPTED, ExifInterface.LONGITUDE_WEST, "X", "Y", "Z", "#"};

    public static boolean Cr(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return Arrays.asList(fvY).contains(str);
    }
}
