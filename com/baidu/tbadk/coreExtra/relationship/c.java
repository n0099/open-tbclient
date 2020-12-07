package com.baidu.tbadk.coreExtra.relationship;

import android.support.media.ExifInterface;
import android.text.TextUtils;
import com.baidu.searchbox.ui.animview.praise.element.eruption.strategy.IEruptionStrategyGroup;
import java.util.Arrays;
/* loaded from: classes.dex */
public final class c {
    public static final String[] fng = {ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "B", "C", "D", ExifInterface.LONGITUDE_EAST, "F", "G", IEruptionStrategyGroup.STRATEGY_MODIFIER_H, "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", ExifInterface.LATITUDE_SOUTH, ExifInterface.GPS_DIRECTION_TRUE, "U", ExifInterface.GPS_MEASUREMENT_INTERRUPTED, ExifInterface.LONGITUDE_WEST, "X", "Y", "Z", "#"};

    public static boolean Dh(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return Arrays.asList(fng).contains(str);
    }
}
